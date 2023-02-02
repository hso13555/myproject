import React, { useEffect, useState } from "react";
import { instance } from "../api/Api";
// component
import FreezerContainer from "./FreezerContainer";
import FreezerCreateContainer from "./FreezerCreateContainer";

// template

const FreezerMainComponent = () => {
  const [freezer, SetFreezer] = useState([]);
  const [change, SetChange] = useState(false);

  const changeHandler = () => {
    if (change === false) {
      SetChange(true);
    } else {
      SetChange(false);
    }
  };

  useEffect(() => {
    //조회처리
    const onListUp = async () => {
      try {
        const response = await instance.get("/api/freezer");
        const data = response.data.body.freezers;
        SetFreezer(data);
      } catch (error) {
        console.log("에러" + error);
      }
    };
    onListUp();
  }, [change]);

  return (
    <>
      <div className="character-component">
        <div className="character-content">
          <div className="row">
            <div className="col">
              {freezer[0] ? (
                <FreezerContainer
                  onFreezer={freezer[0]}
                  index="0"
                  onChange={changeHandler}
                />
              ) : (
                <FreezerCreateContainer onChange={changeHandler} />
              )}
            </div>

            <div className="col">
              {freezer[1] ? (
                <FreezerContainer
                  onFreezer={freezer[1]}
                  index="1"
                  onChange={changeHandler}
                />
              ) : (
                <FreezerCreateContainer onChange={changeHandler} />
              )}
            </div>

            <div className="col">
              {freezer[2] ? (
                <FreezerContainer
                  onFreezer={freezer[2]}
                  index="2"
                  onChange={changeHandler}
                />
              ) : (
                <FreezerCreateContainer onChange={changeHandler} />
              )}
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default FreezerMainComponent;
