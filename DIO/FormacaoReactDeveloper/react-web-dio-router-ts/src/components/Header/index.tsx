import { 
    Container,
    Row,
    //Column,
    Wrapper,
    InputContainer,
    Menu,
    MenuRight,
    //Logo,
    //Avatar,
    Input,
    Avatar
} from "./styles";

import Button from "../Button";
import logo from "../../assets/logo-dio.png";
import { IHeader } from "./types";

const Header = ({autenticado}: IHeader ) => {
    return (
        <Wrapper>
            <Container>
                <Row>
                    <img src={logo} alt="Dio"/>
                    {autenticado ? (
                        <>
                        <InputContainer>
                            <Input type="text" placeholder="Pesquisar"/>
                        </InputContainer>
                        <Menu href="#">Live Code</Menu>
                        <Menu href="#">Global</Menu>
                        </>
                    ) : null }
                </Row>
                <Row>
                    {autenticado ? (
                        <>
                            <Avatar src="https://avatars.githubusercontent.com/u/14862464?v=" alt="Nauam Oliveira"/>
                        </>
                    ) : (
                        <>
                            <MenuRight href="#">Home</MenuRight>
                            <Button title="Entrar"/>
                            <Button title="Cadastrar"/>
                        </>
                    ) }
                </Row>
            </Container>
        </Wrapper>
    );
    }

export default Header;