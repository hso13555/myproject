// template
import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";
import InputGroup from "react-bootstrap/InputGroup";
import { useState } from "react";
import { useEffect } from "react";

const ItemSearchForm = (props) => {
  const itemList = props.itemList;
  const [search, setSearch] = useState("");
  const [filterItem, setFilterItem] = useState();
  const [isSearch, setIsSearch] = useState(false);

  console.log(itemList);
  console.log(search);

  useEffect(() => {
    if (search === "") {
      setIsSearch(false);
      setFilterItem([]);
    } else {
      setIsSearch(true);
      const name = itemList.filter((item) => {
        return item.name.includes(search);
      });
      setFilterItem(name);
    }
  }, [search]);
  console.log(filterItem);
  return (
    <div className="ingr-search search">
      <Form>
        <InputGroup className="mb-4">
          <Form.Control
            placeholder="재료를 입력하세요."
            type="text"
            onChange={(e) => {
              setSearch(e.target.value);
              setIsSearch(true);
            }}
          />
        </InputGroup>
      </Form>
      <div className="search-result-component">
      {isSearch &&
        filterItem.map((it) => {
          return (
            <div className="search-result-content">
              <div class="search-result"
                onClick={() => {
                  props.itemNameHandler(it.name);
                }}
              >
                {it.name}
              </div>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default ItemSearchForm;
