import React from 'react';
// template
import ListGroup from 'react-bootstrap/ListGroup';
import ListGroupItem from 'react-bootstrap/esm/ListGroupItem';
import BotName from './BotName';
import BotQuestionItem from './BotQuestionItem';

const BotQuestion = ({botItems, onQItemClick, isBotList}) => {

  return(
    <div className='q-bot'>
      <BotName />
      <div className='q-list'>
        <ListGroup>
          {
            botItems.map(q => 
            <BotQuestionItem  botItems={q.question} key={q.id} onQItemClick={onQItemClick}/>
            )
          }
        </ListGroup>
      </div>
    </div>
  );
}

export default BotQuestion;