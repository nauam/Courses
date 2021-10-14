# Captura Regex Multiline

Este filtro de registro cria uma variável de dados QW Control e preenche o conteúdo dessa variável por meio de uma expressão regular.

Forneça uma correspondência de regex com um padrão e o filtro corresponderá a cada linha no log que retornar para esse padrão. Cada valor correspondente para esse padrão será adicionado a uma variável no contexto de dados ($data.key) para as passos posteriores do job.

Como o filtro de registro de dados de valor-chave, um grupo de captura é necessário. Opcionalmente, dois grupos de captura podem ser fornecidos. Se dois forem fornecidos, a primeira correspondência será a chave para cada linha, enquanto a segunda será adicionada como um valor. Caso contrário, para um grupo de captura, o usuário deve fornecer uma chave no campo “Dados do nome”.

## Uso

Este filtro de registro tem quatro campos para configurar:

- Padrão
  - obrigatório. O valor é uma expressão regular que deve conter um ou dois grupos de captura, conforme descrito acima.
- Dados do nome
  - opcional. Se apenas um grupo de captura for fornecido no campo Padrão, os Dados do Nome devem ter um valor. Se preenchido, este campo será a chave para quaisquer pares de valores-chave criados.
- Ocultar saída
  - caixa de seleção. Se verdadeiro, a saída de log da passo de job anexada será ocultada.
- Dados de registro
  - caixa de seleção. Se verdadeiro, os dados capturados serão repassados ​​no log do job.

::: tip DICA
Quando vários valores correspondem, $data.key será igual a todos os valores correspondentes, separados por uma nova linha.
:::
