import './styles.js';
import { Conteiner } from './styles.js';

import { useState } from 'react';

import github from '../../assets/github.png';
import Input from '../../components/Input';
import ItemRepo from '../../components/ItemRepo';
import Button from '../../components/Button';

import api from '../../services/api';

function App() {
  const [repos, setRepos] = useState([]);
  const [repo, setRepo] = useState('');
  

  const handleSearch = async () => {
    api.get(`repos/${repo}`).then((response) => {
      repos.find((repo) => repo.id === response.data.id) ? 
        alert('Repositório já adicionado!') : 
        setRepos([...repos, response.data]);
      setRepo('');
    }).catch((error) => {
      alert('Repositório não encontrado!');
    });
  }
  
  const handleRemove = (id) => {
    setRepos(repos.filter((repo) => repo.id !== id));
  }

  return (
    <Conteiner>
      <img src={github} alt="Logo GitHub" width={72} height={72}/>
      <Input value={repo} onChange={(e) => setRepo(e.target.value)}/>
      <Button onClick={handleSearch}/>
      {repos.map((repo) => (
        <ItemRepo repo={repo} onRemove={(id) => handleRemove(id)}/>
      ))}
    </Conteiner>
  );
}

export default App;
