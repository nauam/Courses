# Filtro de Log

Um filtro de log processa a saída de uma etapa do fluxo de trabalho e pode transformar essa saída, aplicar metadados à saída para uso por filtros ou renderizadores posteriores ou processar a saída de alguma forma. Alguns filtros de registro podem ser usados ​​para capturar a saída das variáveis ​​do QW Control para uso em passos posteriores ou para transformar a saída para melhor usabilidade na GUI do QW Control.

O Job do QW control pode definir vários filtros de registro para processar a saída das passos do fluxo de trabalho. O Job pode definir Filtros de registro *global* que se aplicam a todas as passos, bem como filtros de registro de *passos* que se aplicam apenas a passos individuais. Todos os filtros de registro *global* para um Job serão processados ​​antes dos filtros de passos individuais.

Por exemplo, dado um Job que extrai os resultados da API de um serviço da web, os resultados da API podem ser formatados em JSON. O filtro de registro Render Formatted Data pode formatar a saída como uma tabela HTML para usuários que executam o Job.

Por outro lado, como um exemplo diferente, para passos de fluxo de trabalho que precisam alimentar dados para as passos seguintes, o filtro Dados de valor-chave analisará a saída da etapa atribuída com uma expressão regular para criar pares de dados de valor-chave para uso em outras passos do fluxo de trabalho.

Filtros de registro:

- [Dados de valor chave](/user-guide/log-filters/key-value-data.md)
- [Saída silenciosa](/user-guide/log-filters/quiet-output.md)
- [Destaque de saída](/user-guide/log-filters/highlight-output.md)
- [Renderizar dados formatados](/user-guide/log-filters/render-formatted-data.md)
- [Máscara de senhas](/user-guide/log-filters/mask-passwords.md)
- [JSON JQ](/user-guide/log-filters/json-jq.md)
- [Regex multilinha](/user-guide/log-filters/multi-line-regex.md)
