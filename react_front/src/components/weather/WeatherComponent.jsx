import React from "react";
import Weather from "./Weather";
import { useState } from "react";
import axios from "axios";
import { useEffect } from "react";

const WeatherComponent = () => {
  const [coords, saveCoords] = useState();
  const [temp, setTemp] = useState();
  const [weather, setWeather] = useState();

  const handleGeoSucc = (position) => {
    const latitude = position.coords.latitude; // 경도
    const longitude = position.coords.longitude; // 위도
    const coordsObj = {
      latitude,
      longitude,
    };
    saveCoords(coordsObj);
    getWeather(latitude, longitude);
  };

  const handleGeoErr = (error) => {
    console.log("geo err! " + error);
  };

  const getWeather = async (lat, lon) => {
    const key = "6cd557f1c9eb8846c03da7621aabc12e";
    try {
      const response = await axios.get(
        `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${key}`
      );

      const temp = Math.round(response.data.main.temp) - 273;
      const weather =
        response.data.weather[response.data.weather.length - 1].main;
      setTemp(temp);
      setWeather(weather);
    } catch (error) {
      console.log(error);
    }
  };

  useEffect(() => {
    const requestCoords = () => {
      navigator.geolocation.getCurrentPosition(handleGeoSucc, handleGeoErr);
    };
    requestCoords();
  }, []);

  return (
    <div className="weather-component">
      <div className="weather-content">
        <div className="weather">
          <h5 className="title">날씨</h5>
          <Weather temp={temp} weather={weather} />
        </div>
      </div>
    </div>
  );
};

export default WeatherComponent;
