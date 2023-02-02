import React, { useState } from 'react';
// icon
import { AiFillRobot } from "react-icons/ai";
// component
import BotList from './BotList';

const Bot = ({botItems, onBotItemClick}) => {
  return(
    <div className='bot left'>
      <div className='bot-img'><AiFillRobot className='icon'></AiFillRobot></div>
      <div className='bot-text'>
        <div className='bot-name'>미미</div>
        <BotList botItems={botItems} onBotItemClick={onBotItemClick}/>
      </div>
    </div>
  );
}

export default Bot;