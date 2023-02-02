import React, { useState, useEffect } from 'react';
import BotData from '../../db/bot.json';

// component
import BotBtn from './BotBtn';
import BotChatting from './BotChatting';

const BotComponent = () => {
  const botItems = BotData.botQnA; // 데이터
  const [chatBot, setChatBot] = useState(false); // 챗봇
  const [isBotList, setIsBotList] = useState(false);
  const [isQuestionChoice, setIsQuestionChoice] = useState(false); // 질문선택
  const [isAnswer, setIsAnswer] = useState(false); // 답변
  const [isAItem, setIsAItem] = useState(false); // 답변 내용
  const [count, setCount] = useState();
  const [itemValue, setValue] = useState();
  
  // 열기_닫기
  const showChatBot = () => setChatBot(true);
  const hideChatBot = () => setChatBot(false);
  
  // 질문 선택
  const onQItemClick = (key) =>{
    setCount((JSON.stringify(key))); // 질문
    // setValue((JSON.stringify(obj))); // 답변

    if(isQuestionChoice === false){
      setIsQuestionChoice(current => !current); // 질문 선택 시 선택된 항목 보임
    }

    if(isAnswer === false){
      setIsAnswer(current => !current); // 질문 선택 시 답변보임
      setIsAItem(current => !current); // 답변 내용 보임
    }

  }
  
  const onQListClick = () =>{
    setIsBotList(current => !current); // 질문 목록
  }

  return(
    <div className='bot-component'>
      <div className='bot-content'>
        { chatBot && <BotChatting 
                        onHideChatBot={hideChatBot} 
                        botItems={botItems} 
                        onQItemClick={onQItemClick}
                        itemId={count}
                        itemValue={itemValue}
                        isQuestionChoice={isQuestionChoice}
                        isAnswer={isAnswer}
                        isAItem={isAItem}
                        isBotList={isBotList}
                        onQListClick={onQListClick}
                      />
        }
      </div>
      <BotBtn onClickChatBot={showChatBot} />
    </div>
  );
}

export default BotComponent;