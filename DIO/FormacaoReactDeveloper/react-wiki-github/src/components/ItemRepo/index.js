import { ItemRepoConteiner } from './styles.js';

function ItemRepo({repo, onRemove}) {
  return (
    <ItemRepoConteiner>
      <div className='row'>
        <div className='col'>
          <h3>{repo.name}</h3>
          <p>{repo.full_name}</p>
        </div>
        <div className='row'>
          <a target="_blank" rel="noreferrer" href={repo.html_url} className="btn btn-success">Ver</a>
          <button className="btn btn-danger ml-50" onClick={() => onRemove(repo.id)}>Remover</button>	
        </div>
      </div>
      <hr />
    </ItemRepoConteiner>
  );
}

export default ItemRepo;
