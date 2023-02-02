import React from 'react';
import Time from './Time';

const TimeComponent = () => {
  return (
    <div className='time-component'>
      <div className='time-content'>
        <div className='time'>
          <h5 className='title'>시간</h5>
          <Time />
        </div>
      </div>
    </div>
  );
}

export default TimeComponent;