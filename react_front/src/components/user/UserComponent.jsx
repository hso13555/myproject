import React, {useState} from 'react';
// template
import Button from 'react-bootstrap/Button';
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import { Link, Route } from 'react-router-dom';
import LoginContainer from './LoginContainer';
import RegisterContainer from './RegisterContainer';

const UserComponent = () => {
  const [menu, setMenu] = useState([true, false]);
  const [viewComponent, setViewComponent] = useState(true);

  return(
    <div className='login-component'>
      <div className="login-content">
        <div className="left"></div>
        <div className="right">
          <h1 className="logo">미미</h1>
          <div>
            <ButtonGroup>
              <Button className={menu[0]? "active" : ""} 
                onClick={() => {
                  setViewComponent(true)
                  setMenu([true,false])
              }}>로그인</Button>
              <Button className={menu[1]? "active" : ""}  
                onClick={() => {
                  setViewComponent(false)
                  setMenu([false,true])
                }}>회원가입</Button>
            </ButtonGroup>

            {viewComponent ? <LoginContainer /> : <RegisterContainer />}
          </div>
        </div>
      </div>
    </div>
  );
}

export default UserComponent;