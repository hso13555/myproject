import axios from "axios";
//최초관리자 or 유저 등록 API 호출 함수
export const adminSetup = async (userEmail, userPw, userName) => {
  const data = {
    userEmail: userEmail,
    userPw: userPw,
    userName: userName,
  };
  try {
    const response = await axios.post("/auth/signup", JSON.stringify(data), {
      headers: {
        "Content-Type": "application/json",
      },
    });
    console.log(response);
  } catch (error) {
    console.log(error);
  }
};

//로그인 API 호출 함수
export const login = async (account) => {
  const loginInfo = {
    userEmail: account.userEmail,
    userPw: account.userPw,
  };

  console.log(loginInfo);
  try {
    const response = await axios.post(
      "/auth/login",
      JSON.stringify(loginInfo),
      { headers: { "Content-Type": "application/json" } }
    );
    console.log(response);

    const data = await response.data;
    const accessToken = data.accessToken;

    axios.defaults.headers.common["Authorization"] = "Bearer " + accessToken;

    localStorage.setItem("accessToken", accessToken);
    alert("로그인 성공!");

    console.log(data);
  } catch (error) {
    alert(error);
  }
};

//냉장고 생성 호출

//냉장고 리스트 조회 호출

export const freezerList = async () => {
  console.log("freezerList 호출 해써염");

  const token = localStorage.getItem("accessToken");
  const headers = {
    "Content-Type": "application/json",
    Authorization: "Bearer " + token,
  };

  try {
    const response = await axios.get("/api/freezer", {
      headers: headers,
    });
    const data = await response.data;

    return data;
  } catch (error) {
    console.log(error);
  }
};
