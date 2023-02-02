import axios from "axios";
import React from "react";
import { useState } from "react";
import { useCallback } from "react";

import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";

const PwSearchForm = () => {
  const [account, setAccount] = useState([]);
  //이메일 보내서 있는지 확인하기
  const onPwSearch = async () => {
    const userInfo = {
      userEmail: account.userEmail,
      userName: account.userName,
    };
    try {
      console.log("어카운트" + account);
      const response = await axios.post(
        `/auth/checkEmail/findPw`,
        JSON.stringify(userInfo),
        {
          headers: { "Content-Type": "application/json" },
        }
      );
      if (response.data.check === true) {
        onSendEmail();
      }
    } catch (error) {
      console.log(error);
    }
  };

  const onSendEmail = async () => {
    const userInfo = {
      userEmail: account.userEmail,
      userName: account.userName,
    };
    console.log(userInfo);
    try {
      const response = await axios.post(
        `/auth/check/findPw/sendEmail`,
        JSON.stringify(userInfo),
        {
          headers: { "Content-Type": "application/json" },
        }
      );
    } catch (error) {
      console.log(error);
    }
  };

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
        return alert("이메일을 입력하세요.");
      } else if (!account.userName) {
        return alert("이름을 입력하세요.");
      } else {
        onPwSearch();
      }
    },
    [onPwSearch]
  );

  return (
    <div className="pwSearch">
      <Form onSubmit={submitHandler}>
        <Form.Group className="mb-3 form-group" controlId="userEmail">
          <Form.Control
            type="text"
            name="userEmail"
            placeholder="이메일"
            onChange={changeAccountHandler}
            value={account.userEmail || ""}
          />
        </Form.Group>
        <Form.Group className="mb-3 form-group" controlId="userEmail">
          <Form.Control
            type="text"
            name="userName"
            placeholder="이름"
            onChange={changeAccountHandler}
            value={account.userName || ""}
          />
        </Form.Group>

        {/* <Form.Group>{onError}</Form.Group> */}

        <Button variant="primary" type="submit" className="btn-login">
          임시비밀번호 발급
        </Button>
      </Form>
    </div>
  );
};

export default PwSearchForm;
