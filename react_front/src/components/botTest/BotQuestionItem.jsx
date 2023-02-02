import React from 'react';
// template
import ListGroupItem from 'react-bootstrap/esm/ListGroupItem';

const BotQuestionItem = ({botItems, onQItemClick}) => {

  return(
    <ListGroupItem onClick={() => onQItemClick(botItems)}>{botItems}</ListGroupItem>
  );
}

export default BotQuestionItem;