import {InputContainer, InputText, IconContainer } from "./styles";

const Input = ({ leftIcon, name, placeholder, ...rest }) => {
    return (
        <InputContainer>
            {leftIcon ? ( <IconContainer>{leftIcon}</IconContainer> ) : null}
            <InputText placeholder={placeholder} name={name}/>
        </InputContainer>
    );
    }

export default Input;