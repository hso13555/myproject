import React from 'react';
import ItemContentComponent from '../components/ItemContent/ItemContentComponent';
import InventoryComponent from '../components/inventory/InventoryComponent';

const InventoryPage = (props) => {
  return(
    <div className='page inventory-page'>
      {/* <InventoryComponent /> */}

      <div className='row'>
        <div className='col col-7'>
        <div className='left'>
          <InventoryComponent index={props.index}/>
        </div>
        </div>
        <div className='col col-5'>
          <div className='right'>
            <ItemContentComponent index={props.index}/>
          </div>
        </div>
      </div>
    </div>
  );
}

export default InventoryPage;