import React from 'react';
// icon
import { AiFillRobot } from "react-icons/ai";


const BotName = () => {
  return(
    <div className='bot-cont'>
      <div className='bot-img'><AiFillRobot className='icon'></AiFillRobot></div>
      <div className='bot-name'>미미</div>
    </div>
  );
}

export default BotName;