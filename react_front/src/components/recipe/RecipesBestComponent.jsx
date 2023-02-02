import React from 'react';
import RecipesGroup from './RecipesGroup';
// component
import RecipesCarousel from './RecipesCarousel';

const RecipesBestComponent = () => {
  return(
    <div className='items-component'>
      <div className='items-content'>
        <div className='content-header'>
          <h5>메뉴 추천</h5>
        </div>
        <div className='content-body'>
          <RecipesCarousel />
        </div>
      </div>
    </div>
  );
}

export default RecipesBestComponent;