# Saída silenciosa

Acalma a saída que corresponde ou não a um determinado padrão, alterando seu nível de log. Este filtro faz isso alterando o nível de log da saída. Ele não remove ou exclui nenhum registro.

## Uso

Existem quatro opções para este filtro de registro:

- Padrão
  - expressão regular testada em relação aos logs dos passos de Job anexada. Se for deixado em branco, todas as linhas serão correspondentes.
- Nível de registro de teste
  - Testes apenas em relação às linhas do nível de registro selecionado. O padrão é “Normal”. Se “Qualquer” for selecionado, todos os níveis de registro serão testados.
- Saída combinada silenciosa
  - se marcado, muda os níveis de log das linhas correspondentes. Caso contrário, linhas silenciosas não coincidentes.
- Nível de registro de resultado
  - As linhas silenciosas serão alteradas para este nível de registro. O padrão é “Detalhado”.

Por padrão, todos os resultados do logs dos passos de Job do QW Control são publicados no nível de log “Normal”. Esse filtro pode ser usado não apenas para desativar a saída do log, mas também para promover um nível superior.

::: tip DICA
Os filtros de log do QW Control esperam ler os logs no nível de log “Normal”. Isso significa que a aplicação deste filtro como um filtro de registro global em um Job do QW Control pode afetar outros filtros que são processados ​​posteriormente.
:::
