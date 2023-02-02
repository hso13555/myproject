// style
import "bootstrap/dist/css/bootstrap.min.css";
import "../src/assets/scss/app.scss";

// react
import { Route, Routes } from "react-router-dom";

// page
import FreezerLayout from "./components/Freezer/FreezerLayout";
import LoginPage from "./page/LoginPage";
import InventoryLayout from "./components/inventory/InventoryLayout";
import RecipePage from "./page/RecipePage";
import Recipe from "./components/recipe/List/Recipe";

function App() {
  return (
    <div className="app">
      <Routes>
        <Route path="/freezer" element={<FreezerLayout />}></Route>
        <Route path="/inventory/:index" element={<InventoryLayout />}></Route>
        <Route path="/recipe" element={<RecipePage />}></Route>
        <Route path="/recipe/:recipeId" element={<Recipe />}></Route>
        <Route path="/" element={<LoginPage />}></Route>
      </Routes>
    </div>
  );
}

export default App;
