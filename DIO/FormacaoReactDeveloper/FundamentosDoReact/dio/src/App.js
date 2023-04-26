import Button from "./components/Button";

function App() {
  return (
    <div className="App">
        <h1>Olá React</h1>
        <Button title="Clique aqui" onClick={() => alert("Clicou!")} />
    </div>
  );
}

export default App;
