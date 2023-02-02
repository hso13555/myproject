import React from 'react';
import dummy from '../../db/nutrient.json';

const Nutrient = ({itemInfo}) => {
  return(
    <tbody>
    <tr>
      <td>{dummy.ingrPerGName}</td>
      <td>{itemInfo.per} {dummy.ingrUnitG}</td>
    </tr>
    <tr>
      <td>{dummy.ingrKcalName}</td>
      <td>{itemInfo.kcal} {dummy.ingrUnitKcal}</td>
    </tr>
    <tr>
      <td>{dummy.ingrFatName}</td>
      <td>{itemInfo.fat} {dummy.ingrUnitMg}</td>
    </tr>
    <tr>
      <td>{dummy.ingrCholName}</td>
      <td>{itemInfo.chol} {dummy.ingrUnitMg}</td>
    </tr>
    <tr>
      <td>{dummy.ingrSodiumName}</td>
      <td>{itemInfo.sodium} {dummy.ingrUnitMg}</td>
    </tr>
    <tr>
      <td>{dummy.ingrPotassiumName}</td>
      <td>{itemInfo.potassium} {dummy.ingrUnitMg}</td>
    </tr>
    <tr>
      <td>{dummy.ingrCarbName}</td>
      <td>{itemInfo.carb} {dummy.ingrUnitG}</td>
    </tr>
    <tr>
      <td>{dummy.ingrProteinName}</td>
      <td>{itemInfo.protein} {dummy.ingrUnitG}</td>
    </tr>
    </tbody>
  );
}

export default Nutrient;