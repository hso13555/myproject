import React from 'react';

const BotAnswerItem = ({qItem, aItem, botItems, itemId}) => {

  return(
    <>
    <h5>{qItem}</h5>
    <p>{aItem}</p>
    </>
  );
}

export default BotAnswerItem;