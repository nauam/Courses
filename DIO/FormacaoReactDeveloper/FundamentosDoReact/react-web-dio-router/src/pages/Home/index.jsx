import { useNavigate } from 'react-router-dom';
import Button from '../../components/Button';
import Header from '../../components/Header';
import Banner from "../../assets/banner.png";

import { Container, TexContainer, Title, TitleHighlight } from "./styles";

const Home = () => {

    const navigate = useNavigate();

    const handleLogin = () => {
        navigate('/login');
    }

    return (<>
            <Header />
            <Container>
                <div>
                    <Title>
                        <TitleHighlight>Implemente</TitleHighlight> <br/>
                        o ser futuro global agora!
                    </Title>
                    <TexContainer>
                        Domine as tecnologias mais desejadas com os melhores especialistas do mercado e <br/>
                        tenha acesso a oportunidades em empresas inovadoras que estão transformando o mundo.
                    </TexContainer>
                    <Button title="Começar agora" variant="secondary" onClick={handleLogin}/>
                </div>
                <div>
                    <img src={Banner} alt="Banner"/>
                </div>
            </Container>
        </>
    );
    }

export default Home;