import { InputContainer } from './styles';

const Input = ({value, onChange, onKeyDown}) => {
  return (
    <InputContainer>
      <input type="text" value={value} onChange={onChange} onKeyDown={onKeyDown}/>
    </InputContainer>
  )
}

export default Input;