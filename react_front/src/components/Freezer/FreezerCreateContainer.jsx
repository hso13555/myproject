import { useNavigate } from "react-router-dom";
import { instance } from "../api/Api";
import FreezerCreateForm from "./FreezerCreateForm";

const FreezerCreateContainer = (props) => {
  const navigate = useNavigate();

  //등록처리
  const onRegister = async (freezerName) => {
    const data = {
      name: freezerName,
    };
    try {
      await instance.post("/api/freezer/add", JSON.stringify(data));
      props.onChange();
      navigate("/freezer");
    } catch (error) {
      console.log(error);
    }
  };

  return <FreezerCreateForm onRegister={onRegister} />;
};

export default FreezerCreateContainer;
