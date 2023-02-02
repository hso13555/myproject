import React from 'react';
import { useState } from 'react';
// component
import BotBtn from './BotBtn';
import BotChatting from './BotChatting';

const BotComponent = () => {
  const [chatBot, setChatBot] = useState(false);

  const showChatBot = () => setChatBot(true);
  const hideChatBot = () => setChatBot(false);

  return(
    <div className='bot-component'>
      <div className='bot-content'>
        { chatBot && <BotChatting onHideChatBot={hideChatBot} /> }
      </div>
      <BotBtn onClickChatBot={showChatBot}/>
    </div>
  );
}

export default BotComponent;