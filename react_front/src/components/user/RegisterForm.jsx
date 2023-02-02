import React, { useState, useCallback } from "react";
// template
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import InputGroup from "react-bootstrap/InputGroup";
import { instance } from "../api/Api";

const RegisterForm = ({ onRegister }) => {
  //오류 메시지
  // const [userIdMessage, setUserIdMessage] = useState('');
  const [userPwMessage, setUserPwMessage] = useState("");
  const [userPwCkMessage, setUserPwCkMessage] = useState("");
  const [userEmailMessage, setUserEmailMessage] = useState("");
  const [userNameMessage, setUserNameMessage] = useState("");
  // const [userPhoneMessage, setUserPhoneMessage] = useState('');

  //입력 상태
  // const [userId, setUserId] = useState("");
  const [userPw, setUserPw] = useState("");
  const [userPwCk, setUserPwCk] = useState("");
  const [userEmail, setUserEmail] = useState("");
  const [userName, setUserName] = useState("");
  // const [userPhone, setUserPhone] = useState("");

  //유효성검사
  // const [isUserId, setIsUserId]= useState(false);
  const [isUserPw, setIsUserPw] = useState(false);
  const [isUserPwCk, setIsUserPwCk] = useState(false);
  const [isUserEmail, setIsUserEmail] = useState(false);
  const [isUserName, setIsUserName] = useState(false);

  const [isCheckEmail, setIsCheckEmail] = useState(false);

  const changeUserPwHandler = useCallback((e) => {
    const passwordRegex =
      /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/;
    const passwordCurrent = e.target.value;
    setUserPw(passwordCurrent);

    if (!passwordRegex.test(passwordCurrent)) {
      setUserPwMessage(
        "숫자+영문자+특수문자 조합으로 8자리 이상 입력해주세요!"
      );
      setIsUserPw(false);
    } else {
      setUserPwMessage("안전한 비밀번호에요.)");
      setIsUserPw(true);
    }
  }, []);

  const changeUserPwCkHandler = useCallback(
    (e) => {
      const passwordConfirmCurrent = e.target.value;
      setUserPwCk(passwordConfirmCurrent);

      if (userPw === passwordConfirmCurrent) {
        setUserPwCkMessage("비밀번호를 똑같이 입력했어요 : )");
        setIsUserPwCk(true);
      } else {
        setUserPwCkMessage("비밀번호가 틀려요. 다시 확인해주세요 ㅜ ㅜ");
        setIsUserPwCk(false);
      }
    },
    [userPw]
  );

  const changeUserEmailHandler = useCallback((e) => {
    const emailRegex =
      /([\w-.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
    const emailCurrent = e.target.value;
    setUserEmail(emailCurrent);

    if (!emailRegex.test(emailCurrent)) {
      setUserEmailMessage("이메일 형식이 틀렸어요! 다시 확인해주세요");
      setIsUserEmail(false);
    } else {
      setUserEmailMessage("올바른 이메일 형식이에요!");
      setIsUserEmail(true);
    }
  }, []);

  const changeUserNameHandler = useCallback((e) => {
    setUserName(e.target.value);
    if (e.target.value.length < 2 || e.target.value.length > 5) {
      setUserNameMessage("2글자 이상 5글자 미만으로 입력해주세요.");
      setIsUserName(false);
    } else {
      setUserNameMessage("올바른 이름 형식입니다.)");
      setIsUserName(true);
    }
  }, []);

  const submitHandler = useCallback(
    (e) => {
      e.preventDefault();

      onRegister(userEmail, userPw, userName);
    },
    [userEmail, userPw, userName, onRegister]
  );

  const onCheckEmail = async () => {
    try {
      const response = await instance.get(
        `/auth/checkEmail/${userEmail}`,
        userEmail
      );
      const data = response.data;
      if (data === false) {
        alert("사용가능한 아이디 입니다.");
        setIsCheckEmail(true);
      } else {
        alert("이미 사용중인 아이디 입니다.");
        setIsCheckEmail(false);
      }
    } catch (e) {
      console.log(e.response.data);
    }
  };

  const emailCheckHandler = (e) => {
    e.preventDefault();
    onCheckEmail();
  };

  return (
    <div className="register">
      <Form onSubmit={submitHandler}>
        <Form.Group className="mb-3 form-group" controlId="userName">
          <Form.Control
            type="text"
            placeholder="이름"
            onChange={changeUserNameHandler}
            required
          />
          {userName.length > 0 && (
            <span className={`message ${isUserName ? "success" : "error"}`}>
              {userNameMessage}
            </span>
          )}
        </Form.Group>
        <Form.Group className="mb-3 form-group" controlId="userEmail">
          <InputGroup>
            <Form.Control
              type="email"
              placeholder="이메일"
              onChange={changeUserEmailHandler}
              required
            />
            <Button
              onClick={emailCheckHandler}
              className="btn-email-check"
              variant="outline-secondary"
            >
              이메일 중복확인
            </Button>
          </InputGroup>

          {userEmail.length > 0 && (
            <span className={`message ${isUserEmail ? "success" : "error"}`}>
              {userEmailMessage}
            </span>
          )}
        </Form.Group>
        <Form.Group className="mb-3 form-group" controlId="userPw">
          <Form.Control
            type="password"
            placeholder="비밀번호"
            onChange={changeUserPwHandler}
            required
          />
          {userPw.length > 0 && (
            <span className={`message ${isUserPw ? "success" : "error"}`}>
              {userPwMessage}
            </span>
          )}
        </Form.Group>
        <Form.Group className="mb-3 form-group" controlId="userPwCk">
          <Form.Control
            type="password"
            placeholder="비밀번호 확인"
            onChange={changeUserPwCkHandler}
            required
          />
          {userPwCk.length > 0 && (
            <span className={`message ${isUserPwCk ? "success" : "error"}`}>
              {userPwCkMessage}
            </span>
          )}
        </Form.Group>
        {/* <Form.Group className="mb-3 form-group" controlId="userPhone">
          <Form.Control type="tel" placeholder="연락처" onChange={changeUserPhoneHandler} required/>
          {userPhone.length > 0 && <span className={`message ${isUserPhone ? 'success' : 'error'}`}>{userPhoneMessage}</span>}
        </Form.Group> */}

        <Button
          variant="primary"
          type="submit"
          className="btn-register"
          disabled={
            !(
              isUserEmail &&
              isUserName &&
              isUserPw &&
              isUserPwCk &&
              isCheckEmail
            )
          }
        >
          회원가입
        </Button>
      </Form>
    </div>
  );
};

export default RegisterForm;
