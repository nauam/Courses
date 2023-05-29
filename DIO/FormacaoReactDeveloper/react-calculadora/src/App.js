import Input from './components/Input';
import Button from './components/Button';
import { Conteiner, Content, Row, Column } from './styles';
import { useState } from 'react';

function App() {
  const [currentValue, setCurrentValue] = useState('0');
  const [firstValue, setFirstValue] = useState('0');
  const [operation, setOperation] = useState(''); 

  const handleAddValue = (value) => {
    if (currentValue.length >= 16) return;
    if (value === '.' && currentValue.includes('.')) return;
    if (value === '.' && currentValue === '') value = '0.';
    setCurrentValue(prev => `${parseFloat(prev) ||  prev === '0.' ? prev : ''}${value}`);
  }

  const handleClearValue = () => {
    setCurrentValue('');
    setFirstValue('');
    setOperation('');
  }

  const handleValue = (type) => {
    if (currentValue !== '') {
      setFirstValue(getResult());
      setCurrentValue('');
    }
    setOperation(type);
  }

  const handleEquals = () => {
    setCurrentValue(getResult());
    setFirstValue('');
    setOperation('');
  }

  const getResult = () => {
    if (operation === 'div' && parseFloat(currentValue) === 0) return 'Erro';
    var result = {
      sum: parseFloat(firstValue) + parseFloat(currentValue),
      sub: parseFloat(firstValue) - parseFloat(currentValue),
      div: parseFloat(firstValue) / parseFloat(currentValue),
      mult: parseFloat(firstValue) * parseFloat(currentValue),
      perCent: parseFloat(firstValue) / 100, 
    }[operation];

    return String (result == null ? currentValue : result);
  }

  const getSimbol = () => {
    return {
      sum: ' + ',
      sub: ' - ',
      div: ' ÷ ',
      mult: ' x ',
      perCent: ' % ',
    }[operation] || '';
  }

  const handleKeyDown = (event) => {
    const { key } = event;
    const keys = ['1','2','3','4','5','6','7','8','9','0','+','-','*','/','%','(',')','.','Enter','Backspace','Escape'];
    if(keys.includes(key)) {
      event.preventDefault();
      return (({
        'Enter': handleEquals,
        'Backspace': handleClearValue,
        'Escape': handleClearValue,
        '+': () => handleValue('sum'),
        '-': () => handleValue('sub'),
        '*': () => handleValue('mult'),
        '/': () => handleValue('div'),
        '%': () => handleValue('perCent')	
      }[key] || ((key) => handleAddValue(key))))(key);
    }
  }

  return (
    <Conteiner >
      <Content>
        <Input value={operation ? (firstValue + getSimbol() + currentValue ) : currentValue} onKeyDown={handleKeyDown} />
        <Row>
            <Column>
              <Button label="%" onClick={() => handleValue('perCent')}/>
            </Column>
            <Column>
              <Button label="C" onClick={handleClearValue}/>
            </Column>
        </Row>
        <Row>
            <Column>
              <Button label="7" onClick={() => handleAddValue('7')}/>
            </Column>
            <Column>
              <Button label="8" onClick={() => handleAddValue('8')}/>
            </Column>
            <Column>
              <Button label="9" onClick={() => handleAddValue('9')}/>
            </Column>
            <Column>
              <Button label="÷" onClick={() => handleValue('div')}/>
            </Column>
        </Row>
        <Row>
            <Column>
              <Button label="4" onClick={() => handleAddValue('4')}/>
            </Column>
            <Column>
              <Button label="5" onClick={() => handleAddValue('5')}/>
            </Column>
            <Column>
              <Button label="6" onClick={() => handleAddValue('6')}/>
            </Column>
            <Column>
              <Button label="x" onClick={() => handleValue('mult')}/>
            </Column>
        </Row>
        <Row>
            <Column>
              <Button label="1" onClick={() => handleAddValue('1')}/>
            </Column>
            <Column>
              <Button label="2" onClick={() => handleAddValue('2')}/>
            </Column>
            <Column>
              <Button label="3" onClick={() => handleAddValue('3')}/>
            </Column>
            <Column>
              <Button label="-" onClick={() => handleValue('sub')}/>
            </Column>
        </Row>
        <Row>
            <Column>
              <Button label="0" onClick={() => handleAddValue('0')}/>
            </Column>
            <Column>
              <Button label="." onClick={() => handleAddValue('.')}/>
            </Column>
            <Column>
              <Button label="=" onClick={handleEquals}/>
            </Column>
            <Column>
              <Button label="+" onClick={() => handleValue('sum')}/>
            </Column>
        </Row>
      </Content>
    </Conteiner>
  );
}

export default App;
