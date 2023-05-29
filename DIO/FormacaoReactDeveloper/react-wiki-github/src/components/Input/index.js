import { InputConteiner } from './styles.js';

function Input({value, onChange}) {
  return (
    <InputConteiner>
      <input placeholder="user/repository" value={value} onChange={onChange}/>
    </InputConteiner>
  );
}

export default Input;
