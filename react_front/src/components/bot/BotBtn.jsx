import React from 'react';
// icon
import { AiFillRobot } from "react-icons/ai";
// template
import Button from 'react-bootstrap/esm/Button';

const BotBtn = ({onClickChatBot}) => {
  return(
    <Button className='btn-bot' onClick={onClickChatBot}>
      <AiFillRobot className='icon'></AiFillRobot>
    </Button>
  );
}

export default BotBtn;