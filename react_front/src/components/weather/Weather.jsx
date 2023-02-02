import React from 'react';

const Weather = (props) => {
  return (
    <>
    <div className='weather-text'>{props.weather}, {props.temp}˚C</div>
    </>
  );
}

export default Weather;