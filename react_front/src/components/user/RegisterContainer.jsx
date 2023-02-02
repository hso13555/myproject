import React from "react";
import * as api from "../../lib/api";
import RegisterForm from "./RegisterForm";

const RegisterContainer = () => {
  //등록처리
  const onRegister = async (userEmail, userPw, userName) => {
    try {
      await api.adminSetup(userEmail, userPw, userName);

      alert(" 등록이 완료되었습니다");

      window.location.replace("/");
    } catch (e) {
      alert(e.response.data);
    }
  };

  return <RegisterForm onRegister={onRegister} />;
};

export default RegisterContainer;
