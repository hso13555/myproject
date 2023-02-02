import React from "react";
// import BotComponent from "../components/bot/BotComponent";
import BotComponent from "../components/botTest/BotComponent";
import FreezerMainComponent from "../components/Freezer/FreezerMainComponent";

const FreezerPage = () => {
  return (
    <div className="page character-page">
      <FreezerMainComponent />
      <BotComponent />
    </div>
  );
};

export default FreezerPage;
