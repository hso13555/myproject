import React from 'react';
// component
import Bot from './Bot';
import BotAnswer from './BotAnswer';
import BotCheck from './BotCheck';

const BotBody = ({botItems}) => {

  const onBotItemClick = (key) => {
    JSON.stringify(key);
    console.log("질문 선택 : " + JSON.stringify(key));
  }

  return(
    <div className='content-body'>
      <div className='bot-list'>
        <Bot botItems={botItems} onBotItemClick={onBotItemClick}/>
 
        <BotCheck botCheckItems={botItems} onBotItemClick={onBotItemClick} />

        <BotAnswer botAnswerItems={botItems}/>
      </div>
    </div>
  );
}

export default BotBody;