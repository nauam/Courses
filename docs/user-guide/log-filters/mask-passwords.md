# Mascarar senhas

Este filtro de log mascara a saída de valores de opção para o job que estão marcados como SEGUROS, como senhas ou outros dados semelhantes. Se um job for configurado com uma opção que usa autenticação remota segura ou segura como o tipo de entrada, este filtro mascarará a saída desse campo de opção nos registros.

## Uso

Este filtro possui duas opções:

- Substituição
  - este valor substitui o valor da opção de entrada. Por padrão, ele é exibido como “[SECURE]”
- Cor
  - menu suspenso dos valores de cor ANSI para a substituição.

Se o job tiver opções Protegidas, é recomendável sempre aplicar esse filtro às passos do job que podem gerar os valores dessas opções.
