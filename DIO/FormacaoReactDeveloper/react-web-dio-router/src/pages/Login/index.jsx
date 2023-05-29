import { useNavigate } from 'react-router-dom';
import { FaEnvelope, FaLock } from 'react-icons/fa';
import Button from '../../components/Button';
import Header from '../../components/Header';
import Input from '../../components/Input';

import { Column, Container, Create, Forgot, Row, SubtitleLogin, Title, TitleLogin, Wrapper } from "./styles";

const Login = () => {
    const navigate = useNavigate();

    const handleLogin = () => {
        navigate('/feed');
    }


    return (<>
            <Header />
            <Container>
                <Column>
                    <Title>
                        A plataforma para você aprender a programar com experts, dominar as principais tecnologias
                        e entrar mais rápido no mercado de trabalho.
                    </Title>
                </Column>
                <Column>
                    <Wrapper>
                        <TitleLogin>Faça seu cadastro</TitleLogin>
                        <SubtitleLogin>É gratuito e sempre será.</SubtitleLogin>
                        <form>
                            <Input type="text" placeholder="E-mail" leftIcon={<FaEnvelope />} name="E-mail"/>
                            <Input type="password" placeholder="Senha" leftIcon={<FaLock />} name="senha"/>
                            <Button title="Entrar" variant="secondary" onClick={handleLogin}/>
                        </form>
                        <Row>
                            <Forgot href="#">Esqueceu a senha?</Forgot>
                            <Create href="#">Criar conta</Create>
                        </Row>
                    </Wrapper>
                </Column>
            </Container>
        </>
    );
    }

export default Login;