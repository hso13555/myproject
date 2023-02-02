import React from 'react';
// icon
import BotName from './BotName';
// template
import ButtonGroup from 'react-bootstrap/ButtonGroup';
import Button from 'react-bootstrap/esm/Button';
import BotAnswerItem from './BotAnswerItem';
import BotQuestion from './BotQuestion';

const BotAnswer = ({ botItems, itemId, itemValue,
  onHideChatBot, onQListClick ,
  isAnswer, isAItem, isBotList}) => {

  return(
    <>
    { isAnswer &&
      <div className='a-bot'>
        <BotName />
        {
          isAItem &&
          <div className='a-list'>
            <BotAnswerItem qItem={itemId} aItem={botItems[0].answer} />
          </div>
          
        }

        <ButtonGroup>
          <Button variant='primary' onClick={onHideChatBot}>나가기</Button>
          <Button variant='primary' onClick={onQListClick}>질문하기</Button>
        </ButtonGroup>
      </div>
    }
    </>
  );
}

export default BotAnswer;