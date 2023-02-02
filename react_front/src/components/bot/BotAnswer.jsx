import React, { useState } from 'react';
// icon
import { AiFillRobot } from "react-icons/ai";
// template
import Card from 'react-bootstrap/Card';

const BotAnswer = ({botAnswerItems}) => {
  const answerItem = botAnswerItems[0];

  return(
    <div className='bot left'>
      <div className='bot-img'><AiFillRobot className='icon'></AiFillRobot></div>
      <div className='bot-text'>
        <div className='bot-name'>미미</div>
        <Card className="answer">
          <Card.Body>
            <Card.Title>{answerItem.question}</Card.Title>
              <Card.Text>
                {answerItem.answer}
              </Card.Text>
          </Card.Body>
        </Card>
      </div>
    </div>
  );
}

export default BotAnswer;