# Notificações de Job

Notificações de Job são mensagens acionadas por um evento de Job.
Você pode configurar notificações para ocorrerem com base em diferentes eventos de Job ou status e escolher o plug-in de notificação para usar, como enviar e-mail ou chamar webhook.

## Eventos de Notificação

- **Start**: Quando o Job é iniciado, todas as notificações de "início" serão acionadas.
- **On Success**: Quando a execução do Job for concluída, todas as notificações de "sucesso" serão acionadas se o Job for bem-sucedido.
- **On Failure**: Todas as notificações de "falha" serão acionadas se o Job falhar ou for cancelado.
- **On Retryable Failure**: Todas as notificações de "falha" que podem ser repetidas serão acionadas se o Job falhar.
- **Average Duration Exceeded**: Envia uma notificação quando o limite de duração especificado é excedido. Se não for especificado, a duração média do Job será usada. (Veja as informações abaixo para opções de configuração)

![Notification Events List](/assets/img/notifications-events.png)

### Configuring Average Duration Exceeded

Porcentagem da média: 20%
Delta de tempo da média: + 20s, +20
Tempo absoluto: 30s, 5m Use s, m, h, d, w, y etc como unidades de tempo para segundos, minutos, horas, etc. A unidade será segundos se não for especificada.
Observação: Pode incluir referências de valor de opção como ${option.avgDurationThreshold}.

## Tipos de Notificação

Os Tipos de Notificação, são as ações que podem ser realizadas em cada um dos eventos acima.

Para obter uma lista completa de plug-ins de notificação, consulte [Plug-ins de trabalho - notificações](/user-guide/job-plugins.md#notificacoes)

## Configurando Notificações

- Clique na guia Notificações do trabalho.
- Escolha o evento para sua notificação e clique no botão `+ Add Notification`.
- Escolha o **Tipo de Notificação** no menu suspenso e configure-o de acordo com os detalhes específicos do plugin.

![Notification Events Types](/assets/img/notifications-addtype.png)
