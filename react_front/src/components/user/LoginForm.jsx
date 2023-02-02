import React, { useState, useCallback } from "react";
// template
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import PwSearchModal from "./PwSearchModal";

const LoginForm = ({ onLogin, onError }) => {
  const [account, setAccount] = useState({
    userEmail: "",
    userPw: "",
  });

  const changeAccountHandler = useCallback(
    (e) => {
      setAccount({
        ...account,
        [e.target.name]: e.target.value,
      });
    },
    [account]
  );
  const submitHandler = useCallback(
    (e) => {
      e.preventDefault(); //랜더링시 실행안함

      if (!account.userEmail) {
        return alert("ID를 입력하세요.");
      } else if (!account.userPw) {
        return alert("Password를 입력하세요.");
      } else {
        onLogin(account);
      }
    },
    [account, onLogin]
  );

  return (
    <div className="login">
      <Form onSubmit={submitHandler}>
        <Form.Group className="mb-3 form-group" controlId="userEmail">
          <Form.Control
            type="text"
            name="userEmail"
            placeholder="이메일"
            onChange={changeAccountHandler}
            value={account.userEmail}
          />
        </Form.Group>
        <Form.Group className="mb-3 form-group" controlId="userPw">
          <Form.Control
            type="password"
            name="userPw"
            placeholder="비밀번호"
            onChange={changeAccountHandler}
            value={account.userPw}
          />
        </Form.Group>
        <Form.Group className="message error">{onError}</Form.Group>

        <Button variant="primary" type="submit" className="btn-login">
          로그인
        </Button>
      </Form>
      <div>
        <PwSearchModal />
      </div>
    </div>
  );
};

export default LoginForm;
