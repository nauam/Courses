# Gestão de Tempo - Pomodoro  :tomato:

<p align="center">
  <img src="https://img.shields.io/static/v1?label=java&message=15&color=blue&style=for-the-badge&logo=java"/> 
<img src="http://img.shields.io/static/v1?label=STATUS&message=doing&color=green&style=for-the-badge"/> <img src="http://img.shields.io/static/v1?label=License&message=MIT&color=green&style=for-the-badge"/>
</p>


### Tópicos 

:small_blue_diamond: [Descrição do projeto](#descrição-do-projeto)

:small_blue_diamond: [Funcionalidades](#funcionalidades)

:small_blue_diamond: [Diagrama de classes](#diagrama-de-classes)

## Descrição do projeto 

<p align="justify">
    Uma gestão de tempo ou pomodoro de fácil utilização, focado em metas diárias, semanais ou mensais.
</p>

## Funcionalidades

:heavy_check_mark: Temporizador: Inicie, termine de uma atividade especifica, podendo haver alvos de registros e/ou periodo de tempo.

:heavy_check_mark:Historico: Adicionas, ver, atualizar e apagar registros diarios ou semanais.

:heavy_check_mark:Estatistica: ​Tempo total das atividades por periodo de tempo.

<p align="justify">
    Uma gestão de tempo ou pomodoro de fácil utilização, focado em metas diárias, semanais ou mensais.
</p>


## Diagrama de classes

![Diagrama](img/DiagramaClasses.png)



## Interface Gráfica

### Tela Inicial 

![Diagrama](img/PomodoroView.png)

:building_construction: Icon 1 - Mostra os registros. (EM CONSTRUÇÃO - apenas mostrará os registros no console) 

![Diagrama](img/Registros.png)

:heavy_plus_sign:  Icon 2 - Adiciona registros.  (Abre: Tela Configuração de Registro)

### Tela Configuração Registro

![Diagrama](img/AtividadeEditView.png)

Definir a atividade e a tempo alvo do Pomodoro (HH:MM:SS)

:heavy_check_mark: Icon 1 - Mostra os registros. (Abre: Tela Configuração de Registro)

:heavy_multiplication_x: Icon 2 - Adiciona registros. (Abre: Tela Inicial)

### Tela Registro

![Diagrama](img/AtividadeView2.png)

![Diagrama](img/AtividadeView1.png)

:clock1: Relogio 1: Mostra o tempo decorrido.

:clock1: Relogio 2: Mostra o tempo alvo.

:clock1: Relogio 1: Mostra o tempo restante.

:play_or_pause_button: Play/Pause: Inicia e salva o registro na lista.

<   Return:  (Abre: Tela Inicial).

:  Configuração: (Abre: Tela Configuração de Registro).

:information_source: Quando o alvo for alcançado, será mostrado uma mensagem, o cronometro ainda continuarar contando:

![Diagrama](img/AlertaAlvo.png)

## Licença

The [MIT License]() (MIT)

Copyright &copy; 2021 - UnB Orienteção a Objeto - Nauam Oliveira
