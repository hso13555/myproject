import React from 'react';
import ListGroupItem from 'react-bootstrap/esm/ListGroupItem';

// template
import ListGroup from 'react-bootstrap/ListGroup';

const BotList = ({botItems, onBotItemClick}) => {

  return(
    <ListGroup className='bot-select'>
      { botItems.map((b) => 
        <ListGroupItem key={b.id} onClick={() => onBotItemClick(b.id)}>{b.question}</ListGroupItem>
      )}
    </ListGroup>
  );
}

export default BotList;