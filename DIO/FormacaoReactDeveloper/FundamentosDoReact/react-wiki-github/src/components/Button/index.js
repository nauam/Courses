import { ButtonConteiner } from './styles.js';

function Button({onClick}) {
  return (
    <ButtonConteiner onClick={onClick}>
      Buscar
    </ButtonConteiner>
  );
}

export default Button;
