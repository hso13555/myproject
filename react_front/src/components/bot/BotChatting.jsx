import React from 'react';
import BotData from '../../db/bot.json';
// icon
import { SlClose } from "react-icons/sl";
// component
import BotBody from './BotBody';

const BotChatting = ({onHideChatBot}) => {
  const BotItems = BotData.botQnA;

  return(
    <div className='bot-chatting'>
      <div className='content-header'>
        <h4 className='title'>봇 채팅</h4>
        <SlClose className="icon" onClick={onHideChatBot}></SlClose>
      </div>
      <BotBody botItems={BotItems}/>
    </div>
  );
}

export default BotChatting;