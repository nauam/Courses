import { useState } from 'react';
import { Header } from '../../components/Header';
import background from '../../assets/background.png';
import ItemList from '../../components/ItemList';
import './styles.css';

function App() {
    const [user, setUser] = useState('');
    const [profile, setProfile] = useState({});
    const [repositories, setRepositories] = useState([]);

    const handleSearch = () => {
        Promise.all([
            fetch(`https://api.github.com/users/${user}/repos`),
            fetch(`https://api.github.com/users/${user}`)
        ])
        .then(responses => Promise.all(responses.map(response => response.json())))
        .then(data => {
            setRepositories(data[0]);
            setProfile(data[1]);
        })
        .catch(error => console.error(error));
    }

    return (
        <div className="App">
            <Header />
            <div className="conteudo">
                <img src={background} className="background" alt="background app" />
                <div className="info">
                    <div className='search'>
                        <input type="text" name="usuario" placeholder="@username" 
                            value={user} onChange={ event => setUser(event.target.value) }/>
                        <button type="button" onClick={handleSearch}>Buscar</button>
                    </div>
                    {profile.name ? (
                        <div className='profile'>
                            <img src={profile.avatar_url} className='avatar' alt='avatar' />
                            <div className='description'>
                                <h3>{profile.name}</h3>
                                <span>@{profile.login}</span>
                                <p>{profile.bio}</p>
                            </div>
                        </div>
                    ) : (<p  className='info-alert'>Por favor, digite um usuário válido.</p>)}
                    {repositories.length  ? (
                    <>
                        <h4 className='repositories-title'>Repositórios</h4>
                        <div className='repositories'>
                            {repositories.map(repository => (   
                                <ItemList title={repository.name} description={repository.description || repository.name}/>
                            ))}
                        </div>
                    </>
                    ) : null}
                </div>
            </div>
        </div>
    );
}

export default App;
