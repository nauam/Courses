import {InputContainer, InputText, IconContainer } from "./styles";
import { IInput } from "./types";

const Input = ({ leftIcon, name, placeholder, ...rest }: IInput) => {
    return (
        <InputContainer>
            {leftIcon ? ( <IconContainer>{leftIcon}</IconContainer> ) : null}
            <InputText placeholder={placeholder} name={name}/>
        </InputContainer>
    );
    }

export default Input;