import React, { useState } from 'react';

const BotQuestionChoice = ({itemId, isQuestionChoice}) => {
  return(
    <>
      {
        isQuestionChoice &&
        <div className="qs-bot">
          <span className="q-selected">{itemId}</span>
        </div>
      }
    </>
  );
}

export default BotQuestionChoice;