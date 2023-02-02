import React from 'react';

const BotCheck = ({botCheckItems, onBotItemClick}) => {
  const checkItem = botCheckItems[0].question;

  // console.log(checkItem.key);
  console.log(checkItem);

  return(
    <div className='bot right'>
      <div className='bot-check'>
        테스트 : {checkItem}
        
      </div>
    </div>
  );
}

export default BotCheck;