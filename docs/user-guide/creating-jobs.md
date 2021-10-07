# Criação de _jobs_

## Criando um _job_

Na página _Jobs_, pressione o menu "Novo _job_" para começar a criar um _Job_. O menu contém itens para criar uma definição de _job_ ou fazer upload de uma definição de um arquivo.

![Create _Job_ menu](/assets/img/fig0301.png)

Para o primeiro exemplo de _job_, crie um _job_ que chama o script de informações.

Como no exemplo anterior, comece pressionando o item de menu "Novo _Job_".

No novo formulário de _job_:

Para "Nome do _Job_", digite "info" e para "Grupo", digite "administração/recursos". Se você deseja especificar seu próprio UUID, pode inseri-lo no campo. Caso contrário, um valor exclusivo será definido para você. Fornecer uma descrição será útil para outros usuários compreenderem a intenção e o propósito do _Job_.

Dê uma descrição ao _job_. É recomendada fornecer uma breve descrição na primeira linha. Crie uma linha em branco e todas as linhas subsequentes podem usar o formato de redução. Você pode ver a linha 3, tem um texto que mostra um link de URL em formato de marcação. Quando a QW Control mostra o _job_, essas informações extras podem ser exibidas para o usuário. Rich text é útil para vincular a ferramentas externas ou até mesmo tabelas e gráficos. Qualquer coisa útil para apoiar o usuário do _job_.

Marque a caixa "Enviar para _Nós_". Escolha a opção "Excluir Filtros _Nó_" e digite o nome do seu servidor do QW controle. Isso fará com que o _job_ seja executado apenas nos _nós_ remotos (por exemplo, centos54 e ubuntu).

Digite um script de shell que produza algumas informações (por exemplo, `uname -a`)

Salve a etapa do Fluxo de trabalho.

Pressione o botão "Criar" na parte inferior da página.

![Simple saved _job_ form](/assets/img/fig0303.png)

Depois que o _job_ é criado, o navegador é direcionado para a página do _job_ que você acabou de criar. O _job_ pode ser executado clicando no botão Executar _job_ agora.

<!-- 
After the the _job_ is created, the browser is directed to the page of the _job_ you just created. The _job_ can be run by clicking the Run _Job_ Now button.
 -->
![Simple _job_ form](/assets/img/fig0303-a.png)

Quando você vai para a Jobs página, você verá ícones de pasta refletindo o _job_ de grupo 's. Navegue até a pasta de administração/recursos. Observe que as informações extras são exibidas, o markdown agora é renderizado como HTML.

Observe o botão play antes do nome do _job_.

Pressione o botão play para executar o Job.
<!-- 
When you go to the _Jobs_ page, you will see folder icons reflecting the _Job_'s group.
Navigate through to the administration/resources folder. Notice the extra information is displayed, markdown now rendered as HTML.

Notice the play button before the _job_ name.

Press the play button to run the _Job_.
 -->
![Simple saved _job_](/assets/img/fig0304.png)

Pressione o botão "Executar _Job_ Agora" para iniciar a execução. O _job_ será enfileirado e executado. Você será levado à página de detalhes de execução da tarefa.
<!-- 
Press the "Run _Job_ Now" button to begin execution.
The _job_ will be queued and executed. You will be taken to the _Job_'s
execution details page.
 -->
![Simple saved _job_ output](/assets/img/fig0305.png)

### Múltiplas execuções

Por padrão, um _job_ é executado como uma "Execução Única" - ele só pode ter uma única execução por vez. Isso é útil se as etapas executadas pelo Job puderem ser interferidas se outro processo separado também as estiver executando no (s) mesmo (s) _Nó_ (s).

No entanto, em alguns casos, é útil permitir que uma tarefa seja executada mais de uma vez ao mesmo tempo.

Você pode fazer um _job_ permitir "Execuções múltiplas" alternando o valor para Sim no campo do editor de _jobs_ mostrado abaixo:
<!-- 
By default, a _job_ runs as a "Single Execution" -- it can only have a single execution running at a time. This is useful if the steps the _Job_ performs might be interfered with if another separate process was also performing them on the same _Nó(s)_.

However, in some cases it is useful to allow a _Job_ to be executed more than once simultaneously.

You can make a _job_ allow "Multiple Executions" by toggling the value to Yes in the _Job_ editor field shown below:
 -->
![Multiple executions](/assets/img/fig0324.png)

### Tempo esgotado

Você pode definir um tempo de execução máximo para um _job_. Se o tempo de execução exceder esse valor, o _job_ será interrompido (como se um usuário o tivesse eliminado.) (Observação: o tempo limite só afeta o _job_ se for chamado diretamente, não se for usado como uma referência de _job_ ).
<!-- 
You can set a maximum runtime for a _job_. If the runtime exceeds this value, the _job_ will be halted (as if a user had killed it.) (Note: Timeout only affects the _job_ if is invoked directly, not if it is used as a _Job_ Reference.)
 -->
![_Job_ Timeout field](/assets/img/jobs-timeout-field.png)

O valor do tempo limite pode ser:

- Alguns segundos, como 240
- Uma string indicando números e unidades, como "1d 12h 30m 24s". Cada número deve ter uma letra de unidade ao lado dele. A duração total do tempo limite será a soma dos valores. As unidades disponíveis são "d" (dias) "h" (horas) "m" (minutos) e "s" (segundos, padrão se não especificado).
- Uma referência de propriedade incorporada, como ${option.timeout}. Isso permite que uma opção de _job_ seja usada para alterar o tempo limite do _job_.

<!-- 
The value for the timeout can be:

- A number of seconds, such as `240`
- A string indicating numbers and units, such as "1d 12h 30m 24s". Each number must have a unit letter next to it. The total timeout duration will be the sum of the values. Available units are "d" (days) "h" (hours) "m" (minutes) and "s" (seconds, default if unspecified.)
- An embedded property reference such as `${option.timeout}`. This allows a _Job_ Option to be used to change the timeout for the _job_. 
-->

### Tentar novamente

Você pode definir um número máximo de tentativas para um _job_. Se uma tarefa falhar ou atingir o tempo limite, ela será executada novamente até o número especificado de vezes até ser bem-sucedida. (Observação: a nova tentativa só afeta o _job_ se for invocado diretamente, não se for usado como uma referência de _job_.)
<!-- 
You can set a maximum number of retries for a _job_.
If a _job_ fails or times out,
it will be executed again up to the specified number of times
until it succeeds. (Note: Retry only affects the _job_ if is invoked directly, not if it is used as a _Job_ Reference.) 
-->

![_Job_ Retry field](/assets/img/jobs-retry-field.png)

O valor da nova tentativa pode ser:

- Um número inteiro específico
- Uma referência de propriedade incorporada, como ${option.retryMax}. Isso permite que uma opção de _job_ seja usada para alterar a contagem de novas tentativas do _job_.

Cada execução será iniciada com variáveis ​​de contexto indicando a tentativa de nova tentativa atual e se foi uma nova tentativa. Veja Variáveis ​​de Contexto.

Opcionalmente, um atraso entre as novas tentativas pode ser estabelecido:

- Alguns segundos, como 30
- Uma string indicando números e unidades, como "1d 12h 30m 24s". Cada número deve ter uma letra de unidade ao lado dele. A duração total do tempo limite será a soma dos valores. As unidades disponíveis são "d" (dias) "h" (horas) "m" (minutos) e "s" (segundos, padrão se não especificado).
- Uma referência de propriedade incorporada, como ${option.delay}. Isso permite que uma opção de _job_ seja usada para alterar o intervalo entre as novas tentativas do _job_.

<!-- 
The value for the retry can be:

- A specific integer number
- An embedded property reference such as `${option.retryMax}`. This allows a _Job_ Option to be used to change the retry count for the _job_.

Each execution will be started with context variables
indicating the current retry attempt and whether it was a retry.
See [Context Variables](/manual/_job_-workflows.md#context-variables).

Optionally a delay between retries can be established:

- A number of seconds, such as `30`
- A string indicating numbers and units, such as "1d 12h 30m 24s". Each number must have a unit letter next to it. The total timeout duration will be the sum of the values. Available units are "d" (days) "h" (hours) "m" (minutes) and "s" (seconds, default if unspecified.)
- An embedded property reference such as `${option.delay}`. This allows a _Job_ Option to be used to change the delay between retries for the _job_. -->

![_Job_ Delay between retries field](/assets/img/jobs-retry-delay-field.png)

### Limite de log

Você pode especificar um limite de log, que pode executar uma ação dependendo de quanta saída de log o _job_ produz.

O limite pode ser definido de três maneiras:

- Número máximo total de linhas de registro
- Tamanho máximo total do arquivo de log
- Número máximo de linhas de log para um único _nó_

<!-- 
You can specify a log limit, which can perform an action depending on how much log output
the _Job_ produces.

The limit can be set in one of three ways:

- Maximum total number of log lines
- Maximum total log file size
- Maximum number of log lines for a single _nó_ 
-->

![_Job_ Log limit](/assets/img/jobs-loglimit-field.png)

Insira um valor no campo "Limite de saída de log". A sintaxe do valor que você insere determina o tipo de limite:

### Se você especificar um número, ele será tratado como o "Número total máximo de linhas de registro"

- ###/nodeSe você especificar um número seguido por /node, o número é tratado como o "Número máximo de linhas de log para um único _nó_ "
- ###[GMK]BSe você especificar um número seguido por um sufixo de tamanho de arquivo, isso será tratado como o "tamanho total do arquivo de log". Os sufixos de tamanho de arquivo permitidos são "GB" (gigabyte), "MB" (megabyte), "KB" (kilobyte) e "B" (byte).

E uma das três ações pode ser realizada se o limite for excedido:

- Halt - o _job_ será interrompido com um determinado status
  - Insira uma string de status no campo, como "falhou" ou "abortado", ou qualquer status personalizado
- Truncar e continuar - o _job_ não será interrompido, mas nenhuma outra saída de log será produzida.

<!-- 
Enter a value in the "Log Output Limit" field.
The syntax of the value you enter determines the type of limit:

- `###` If you specify a number, that is treated as the "Maximum total number of log lines"
- `###/node` If you specify a number followed by `/node`, the number is treated as the "Maximum number of log lines for a single _nó_"
- `###[GMK]B` If you specify a number followed by a filesize suffix, that is treated as the "total log file size". The file size suffixes allowed are "GB" (gigabyte), "MB" (megabyte), "KB" (kilobyte) and "B" (byte).

And one of three actions can be performed if the limit is exceeded:

- Halt - the _job_ will halt with a certain status
  - Enter a status string in the field, such as "failed" or "aborted", or any custom status
- Truncate and Continue - the _job_ will not halt, but no more log output will be produced. -->

![_Job_ Log limit action](/assets/img/jobs-loglimit-action.png)

### despachando e filtrando _Nó_

Ao criar um _job_, você pode escolher entre executar o _job_ apenas localmente (no servidor QW Control) ou despachá-lo para vários _nós_ (incluindo o servidor QW Control, se desejar).

Na GUI, a caixa de seleção "Despacho para _nós_" permite que você habilite o despacho de _nó_. Quando você clica nesta caixa, é apresentada a interface do _Nó_ Filtering:
<!-- 
When you create a _job_ you can choose between either running the _job_ only locally (on the QW Control server), or dispatching it to multiple nodes (including the QW Control server if you want).

In the GUI, the "Dispatch to Nodes" checkbox lets you enable _nó_ dispatching. When you click this box you are presented with the _Nó_ Filtering interface: -->

![_Nó_ Filtering interface](/assets/img/fig0305-b.png)

#### Filtros

Você pode clicar nos diferentes campos de filtro "Nome" e "Tags" para inserir valores de filtro para esses campos. Ao atualizar os valores, você verá a seção "_Nós_ correspondentes" atualizada para refletir a lista de _nós_ que corresponderão às entradas. Você pode clicar em "Mais" para ver mais filtros de inclusão disponíveis, e você pode clicar em "Filtros estendidos" para inserir filtros de exclusão para os mesmos campos.
<!-- 
You can click the different filter fields "Name", and "Tags" to enter filter values for those fields. As you update the values you will see the "Matched Nodes" section updated to reflect the list of nodes that will match the inputs. You can click "More" to see more of the available inclusion filters, and you can click "Extended Filters" to enter
exclusion filters for the same fields. -->

::: tip
Por padrão, a seção "_Nós_ correspondentes" mostrará no máximo 100 _nós_ no resultado da pesquisa. Para personalizar este valor máximo, você deve definir a propriedade qwsoftware.gui.matchedNodesMaxCountno arquivo qwcontrol-config.property
<!-- 
By default, the "Matched Nodes" section will show a maximum of 100 nodes in the search result. To customize this maximum value, you should set the property `qwsoftware.gui.matchedNodesMaxCount` on qwcontrol-config.property file -->
:::

#### Threadcount

Você pode definir o número máximo de threads simultâneos a serem usados ​​alterando a caixa "Thread Count". Um valor de 1 significa que todos os despachos de _nó_ acontecem sequencialmente, e qualquer valor maior significa que os despachos de _nó_ acontecerão em paralelo.
<!-- 
You can set the maximum number of simultaneous threads to use by changing the "Thread Count" box. A value of 1 means all _nó_ dispatches happen sequentially, and any greater value means that the _nó_ dispatches will happen in parallel. -->

#### Ordem de classificação

Você pode alterar a ordem em que os _nós_ são executados definindo o "Atributo de classificação" e a "Ordem de classificação". Por padrão, os _nós_ são ordenados por nome (atributo "nodename") em ordem crescente. Você pode alterar o atributo _nó_ para classificar inserindo-o aqui, por exemplo "classificação", e você pode alterar a ordem para decrescente para classificar ao contrário.

Se o atributo que você usar tiver um valor de número inteiro, os _nós_ serão classificados numericamente por esse atributo, em vez de lexicamente. Caso contrário, a classificação é baseada no valor da string em vez do valor inteiro.

Todos os _nós_ sem o atributo especificado serão classificados por seus nomes.
<!-- 
You can change the order in which nodes are executed on by setting the "Rank Attribute" and "Rank Order". By default nodes are ordered by name ("nodename" attribute) in ascending order. You can change the _nó_ attribute to sort on by entering it here, for example "rank", and you can change the order to descending to sort in reverse.

If the attribute you use has an integer number value, then the nodes will be sorted numerically by that attribute, rather than lexically. Otherwise the sort is based on the string value rather than the integer value.

Any nodes without the specified attribute will then be sorted by their names. -->

#### Se um _nó_ falhar

Esta configuração determina como continuar se um dos _nós_ apresentar uma falha.

A opção "Falha na etapa sem executar em nenhum _nó_ remanescente" fará com que nenhum despacho adicional seja executado e a Execução da Tarefa falhará imediatamente.

A opção "Continuar executando em quaisquer _nós_ restantes antes de falhar na etapa" permitirá que os _nós_ restantes continuem a ser executados até que todos tenham sido executados. No final do fluxo de _job_ para todos os _nós_, a execução do _job_ falhará se algum dos _nós_ tiver falhado.
<!-- 
This setting determines how to continue if one of the nodes has a failure.

The option "Fail the step without running on any remaining nodes", will cause no further dispatches to be executed and the _Job_ Execution will fail immediately.

The option "Continue running on any remaining nodes before failing the step" will allow the remaining nodes to continue to be executed until all have been executed.  At the end of the workflow for all nodes, the _Job_ Execution will fail if any of the nodes had failed. -->

#### Filtros de _nós_ dinâmicos

Além de inserir valores estáticos que correspondem aos _nós_, você também pode usar valores mais dinâmicos.

Se você definiu opções para o _job_ (consulte Opções do _job_ ), você pode usar os valores enviados pelo usuário quando o _job_ é executado como parte da filtragem de _nó_.

Basta definir o valor do filtro como ${option.name}, onde "nome" é o nome da opção.

Quando a tarefa for executada, o usuário será solicitado a inserir o valor da opção, e isso será usado no filtro _nó_ para determinar os _nós_ a serem despachados.
<!-- 
In addition to entering static values that match the nodes, you can also use
more dynamic values.

If you have defined Options for the _Job_ (see [_Job_ Options](/manual/_job_-options.md)), you
can use the values submitted by the user when the _job_ is executed as part of the
_nó_ filtering.

Simply set the filter value to `${option.name}`, where "name" is the name of the option.

When the _job_ is executed, the user will be prompted to enter the value of the option, and
that will then be used in the _nó_ filter to determine the nodes to dispatch to. -->

::: tip
Uma vez que o valor da opção dinâmica ainda não foi definido, os "_Nós_ Combinados" mostrados na entrada de filtragem de _nó_ podem indicar que há "Nenhum" correspondido. Além disso, quando o Job é executado, você pode ver uma mensagem dizendo "Aviso: Os filtros _Nó_ especificados para este Job não correspondem a nenhum _nó_, a execução pode falhar." Os _nós_ combinados serão determinados após o usuário inserir os valores da opção.
<!-- 
Since the dynamic option value is not set yet, the "Matched Nodes" shown in the _nó_ filtering input may indicate that there are "None" matched. Also, when the _Job_ is executed, you may see a message saying "Warning: The _Nó_ filters specified for this _Job_ do not match any nodes, execution may fail." The nodes matched will be determined after the user enters the option values. -->
:::

#### Orquestrador

Os orquestradores definem como um _job_ orquestra o envio de execuções para vários _nós_.

O comportamento padrão é despachar com base nestes valores de configuração de _job_ :

Threadcount: quantos _nós_ processar em paralelo
Ordem de classificação: qual atributo _nó_ usar para classificar os _nós_ (o padrão é o nome _nó_.), E se classificar em ordem crescente ou decrescente
Você pode selecionar um plug-in do orquestrador para usar, que pode escolher sua própria lógica para quantos e em que ordem processar os _nós_.

Para saber como desenvolver seu próprio plug- in do orquestrador, consulte o Guia do desenvolvedor do plug- in - Plug-in do orquestrador.
<!-- 
Orchestrators define how a _Job_ orchestrates the dispatching of executions to multiple nodes.

The default behavior is to dispatch based on these _Job_ configuration values:

- Threadcount: how many nodes to process in parallel
- Rank Order: which _nó_ attribute to use to sort the nodes (default is the _nó_ name.), and whether to sort ascending or descending

You can select an Orchestrator plugin to use instead, which can choose its own logic
for how many and what order to process the nodes.

To learn how to develop your own Orchestrator plugin
see [Plugin Developer Guide - Orchestrator Plugin](/developer/09-orchestrator-plugin.md). -->

### Agendando Jobs _Jobs_

Os _jobs_ podem ser configurados para execução periódica. Se você deseja criar um _job_ agendado, selecione Sim em "Agendar para executar repetidamente?"
<!-- 
_Jobs_ can be configured to run on a periodic basis.
If you want to create a Scheduled _Job_, select Yes under "Schedule to
run repeatedly?" -->

![Scheduled _job_ simple form](/assets/img/fig0306.png)

A programação pode ser definida em um seletor gráfico simples ou formato Unix crontab.

Para usar o seletor simples, escolha uma hora e minuto. Você pode então escolher "Todos os dias" (padrão) ou desmarcar essa opção e selecionar dias da semana individuais. Você pode selecionar "Todos os meses" (padrão) ou desmarcar essa opção e escolher meses específicos do ano:

Se o formato de data e hora do crontab for preferido, insira uma expressão cron.
<!-- 
The schedule can be defined in a simple graphical chooser or Unix
crontab format.

To use the simple chooser, choose an hour and minute. You can then
choose "Every Day" (default), or uncheck that option and select
individual days of the week. You can select "Every Month" (default) or
unselect that option and choose specific months of the year:

If the crontab time and date format is preferred, enter a cron
expression. -->

![Scheduled _job_ crontab form](/assets/img/fig0307.png)

Use a sintaxe do crontab referenciada aqui: [Quartz Scheduler crontrigger].

Um bom lugar para gerar, validar e testar crontabs de jobs é aqui (abre uma nova janela).

Depois que o _job_ foi atualizado para incluir uma programação, um ícone de relógio será exibido quando o _job_ for listado:
<!-- 
Use the crontab syntax referenced here: [Quartz Scheduler crontrigger].

A good place to generate, validate and test _job_ crontabs is [here](https://www.freeformatter.com/cron-expression-generator-quartz.html).

After the _Job_ has been updated to include a schedule, a clock icon
will be displayed when the _Job_ is listed: -->

![Scheduled _job_ icon](/assets/img/fig0308.png)

### Notificações de _Job_

Notificações de _job_ são mensagens acionadas por um evento de _job_. Mais detalhes aqui sobre notificações de _job_.
<!-- 
_Job_ notifications are messages triggered by a _job_ event.
[More details here about _Job_ Notifications](_jobs_/_job_-notifications.md). -->

## Excluindo _Jobs_

Na página de visualização do _Job_, clique no botão Ação para um menu de ações e selecione "Excluir este _Job_..." para excluir o _Job_.
<!-- 
In the _Job_ view page, click the Action button for a menu of actions, and select "Delete this _Job_..." to delete the _Job_. -->

![_Job_ delete button](/assets/img/fig0311.png)

Clique em "Excluir" quando disser "Deseja realmente excluir este _job_ ?"

Se você tiver acesso, poderá optar por excluir todas as execuções do _job_ também.
<!-- 
Click "Delete" when it says "Really delete this _Job_?"

If you have access, you can choose to delete all executions for the _job_ as well.
 -->

## Atualizando e copiando _Jobs_

Todos os dados definidos ao criar um _job_ podem ser modificados (exceto UUID). Para editar uma tarefa, você pode clicar no ícone "editar tarefa ":
<!-- 
All of the data you set when creating a _job_ can be modified (except UUID). To edit a
_Job_, you can click the "edit _job_" icon: -->

![edit _job_ button](/assets/img/fig0312.png)

Da mesma forma, para copiar uma definição de _job_ para um novo _job_, pressione o botão "duplicar para um novo _job_".
<!-- 
Similarly, to Copy a _Job_ definition to a new _Job_, press the "duplicate to a new _job_" button. -->

![duplicate _job_ button](/assets/img/fig0313.png)

## Exportando definições do _Job_

As definições de _job_ criadas dentro do console gráfico do QW Control podem ser exportadas para os formatos de arquivo XML ou YAML e ser usadas para importação posterior.

Existem dois métodos para recuperar as definições de Job : por meio da interface gráfica do QW Control e por meio da ferramenta shell [rd- jobs ].

Na guia Definição do _job_, localize o botão de menu "Fazer download da definição". Clicar no ícone permitirá que você escolha o formato XML ou YAML para baixar a definição.
<!-- 
_Job_ definitions created inside the QW Control graphical console can be
exported to XML or YAML file formats and be used for later import.

Two methods exist to retrieve the _Job_ definitions: via QW Control's
graphical interface, and via the [rd-_jobs_] shell tool.

In the _Job_ definition tab, locate the "Download Definition" menu button.
Clicking on the icon will let you
choose either XML or YAML format to download the definition. -->

![_Job_ export button](/assets/img/fig0314.png)

Clique no formato preferido para iniciar o download do arquivo para o seu navegador.

Para exportar _jobs_ para um repositório git, consulte o plug-in Git
<!-- 
Click the preferred format to initiate the file download to your
browser.

To export _jobs_ to a git repository, see the [Git plugin](/administration/projects/scm/git.md#configuring-git-export) -->

## Importando definições de _Job_

Se você tem um arquivo de definição de tarefa (veja acima) e deseja carregá-lo por meio da interface da web da GUI, você pode fazer isso.

Clique no botão de menu "Criar _job_ " na lista de _jobs_.

Clique no item que diz "Definição de upload...":
<!-- 
If you have a _job_ definition file (See above) and want to upload it via
the GUI web interface, you can do so.

Click on the "Create _Job_" menu button in the _Job_ list.

Click the item that says "Upload Definition...": -->

![_Job_ import button](/assets/img/fig0315.png)

Clique no botão Escolher arquivo e escolha o arquivo de definição de _job_ para fazer o upload.
<!-- 
Click the Choose File button and choose your _job_ definition file to upload. -->

![_Job_ import form](/assets/img/fig0316.png)

Escolha uma opção onde diz "Quando já existe um _job_ com o mesmo nome:":

Atualizar - significa que um _job_ definido no xml substituirá qualquer _job_ existente com o mesmo nome.
Ignorar - significa que um _job_ definido no xml será ignorado se houver um _job_ existente com o mesmo nome
Criar - Isso significa que o _job_ definido no xml serão utilizados para criar um novo _job_ se houver um já existente _job_ com o mesmo nome.
Escolha uma opção onde diz " _Jobs_ importados :":

Preservar UUIDs - isso significa que os UUIDs definidos nos _jobs_ importados serão usados ​​ao importá-los. Os UUIDs devem ser únicos, portanto, se você tiver um Job com o mesmo UUID definido em qualquer projeto, sua importação pode falhar.
Remover UUIDs - isto significa que importados Job UUIDs será ignorado, e os importados empregos será ou atualizar um já existente _job_, ou ser criada com um novo UUID.
Clique no botão Upload. Se houver algum erro nas definições de _job_ no arquivo XML, eles serão exibidos na página.

Para importar _jobs_ de um repositório git, consulte o plug-in Git
<!-- 
Choose an option where it says "When a _job_ with the same name already
exists:":

- Update - this means that a _job_ defined in the xml will overwrite any
  existing _job_ with the same name.
- Skip - this means that a _job_ defined in the xml will be skipped over
  if there is an existing _job_ with the same name
- Create - this means that the _job_ defined in the xml will be used to
  create a new _job_ if there is an existing _job_ with the same name.

Choose an option where it says "Imported _Jobs_:":

- Preserve UUIDs - this means that UUIDs defined in the imported _jobs_ will be used when importing them. UUIDs must be unique, so if you have a _Job_ with the same UUID defined in any project, your import may fail.
- Remove UUIDs - this means that imported _Job_ UUIDs will be ignored, and the imported _jobs_ will either _update_ an existing _job_, or be created with a new UUID.

Click the Upload button. If there are any errors with the _Job_
definitions in the XML file, they will show up on the page.

To import _jobs_ from a git repository, see the [Git plugin](/administration/projects/scm/git.md#git-import-configuration) -->
