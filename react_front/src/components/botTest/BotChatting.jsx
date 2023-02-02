import React, { useState } from 'react';
// icon
import { SlClose } from "react-icons/sl";
import { IoMdSend } from "react-icons/io";
// component
import BotQuestion from './BotQuestion';
import BotQuestionChoice from './BotQuestionChoice';
import BotAnswer from './BotAnswer';
// template
import Button from 'react-bootstrap/esm/Button';
import Form from 'react-bootstrap/Form';
import InputGroup from 'react-bootstrap/InputGroup';

const BotChatting = ({ botItems, itemId, itemValue,
  onQItemClick, onHideChatBot, onQListClick,
  isQuestionChoice, isAnswer, isAItem, isBotList }) => {

  return(
    <div className='bot-chatting'>
      <div className='content-header'>
        <h5 className='title'>챗봇</h5>
        <SlClose className="icon" onClick={onHideChatBot}></SlClose>
      </div>
      <div className='content-body'>
        <div className='bot'>
          <BotQuestion 
            botItems={botItems} 
            isBotList={isBotList} 
            onQItemClick={onQItemClick}
          />

          <BotQuestionChoice 
            botItems={botItems} itemId={itemId} 
            isQuestionChoice={isQuestionChoice}
          />

          <BotAnswer 
            botItems={botItems} itemId={itemId} itemValue={itemValue}
            isAnswer={isAnswer} isAItem={isAItem} isBotList={isBotList}
            onHideChatBot={onHideChatBot} onQListClick={onQListClick}
           />
        </div>
      </div>
      <div className='content-footer'>
        <InputGroup className='disabled'>
          <Form.Control placeholder='입력할 수 없는 채팅입니다.' disabled />
          <Button variant="primary" className='btn-send'><IoMdSend className="icon" /></Button>
        </InputGroup>
      </div>
    </div>
  );
}

export default BotChatting;