import React from 'react';
import Clock from 'react-live-clock';

const Time = () => {
  return (
    <div className='time-text'>
      <Clock format={'YYYY-MM-DD LTS'} ticking={true}/>
    </div>
  );
}

export default Time;