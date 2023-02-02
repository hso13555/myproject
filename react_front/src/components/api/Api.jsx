import axios from "axios";

export const instance = axios.create({
  headers: {
    "Content-Type": "application/json",
    Authorization: "Bearer " + localStorage.getItem("accessToken"),
  },
});

instance.interceptors.response.use(
  (response) => {
    console.log("axios성공" + JSON.stringify(response));
    return response;
  },
  async (error) => {
    console.log("axios에러" + JSON.stringify(error.response));
    try {
      const errorResponseStatus = error.response.data.code;
      const prevRequest = error.config;

      if (errorResponseStatus === 1005 || errorResponseStatus === 1004) {
        const preRefreshToken = localStorage.getItem("refreshToken");
        if (preRefreshToken) {
          const regenerateToken = async () => {
            try {
              const response = await axios.post("/refresh", {
                refreshToken: preRefreshToken,
              });

              const accessToken = response.data.accessToken;
              localStorage.setItem("accessToken", accessToken);

              prevRequest.headers.Authorization = `Bearer ${accessToken}`;
              window.location.reload();
              return await axios(prevRequest);
            } catch (error) {
              console.log(error);
              localStorage.removeItem("accessToken");
              localStorage.removeItem("refreshToken");
              return new Error(Error);
            }
          };
          regenerateToken();
        } else {
          throw new Error("There is no refresh token");
        }
      }
    } catch (e) {
      // 오류 내용 출력 후 요청 거절
      return Promise.reject(e);
    }
  }
);
