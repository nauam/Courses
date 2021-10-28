Para todas as quest�es, compile-as com o gcc e execute-as via terminal.

1. Crie um "Ol� mundo!" em C.

```bash
#include <stdio.h>
#include <stdlib.h>

int main (void){
	printf("Ola Mundo!!!\n");
	return 0;
}
```

2. Crie um c�digo em C que pergunta ao usu�rio o seu nome, e imprime no terminal "Ola " e o nome do usu�rio. Por exemplo, considerando que o c�digo criado recebeu o nome de 'ola_usuario_1':

```bash
	$ ./ola_usuario_1
	$ Digite o seu nome: Eu
	$ Ola Eu
	$

#include <stdio.h>
#include <stdlib.h>

int main (void){
	char nome[10];
	printf("Digite o seu nome: ");
	scanf("%s", nome); 
	printf("Ola %s \n", nome);
	return 0;
}
```

3. Apresente os comportamentos do c�digo anterior nos seguintes casos:
	
		(a) Se o usu�rio insere mais de um nome.
```bash
$ ./ola_usuario_1
$ Digite o seu nome: Eu Mesmo

Ola Eu
```
		(b) Se o usu�rio insere mais de um nome entre par�nteses. Por exemplo:
```bash
$ ./ola_usuario_1
$ Digite o seu nome: "Eu Mesmo"

Ola "eu
```
		(c) Se � usado um pipe. Por exemplo:
```bash
$ echo Eu | ./ola_usuario_1

Ola Eu
```
		(d) Se � usado um pipe com mais de um nome. Por exemplo:
```bash
$ echo Eu Mesmo | ./ola_usuario_1

Ola Eu
```
		(e) Se � usado um pipe com mais de um nome entre par�nteses. Por exemplo:
```bash
$ echo "Eu Mesmo" | ./ola_usuario_1

Ola Eu
```
		(f) Se � usado o redirecionamento de arquivo. Por exemplo:
```bash
$ echo Ola mundo cruel! > ola.txt
$ ./ola_usuario_1 < ola.txt

O primeiro comando cria um arquivo .txt com o conte�do da frase  "Ola mundo cruel". O segundo comando executa o programa ola_nome.c com o conte�do do ola.txt exibindo apenas o primeiro nome do arquivo.
```
4. Crie um c�digo em C que recebe o nome do usu�rio como um argumento de entrada (usando as vari�veis argc e *argv[]), e imprime no terminal "Ola " e o nome do usu�rio. Por exemplo, considerando que o c�digo criado recebeu o nome de 'ola_usuario_2':

```bash
$ ./ola_usuario_2 Eu
$ Ola Eu

#include <stdio.h>
#include <stdlib.h>

int main (int argc, char **argv) {
	printf("Ola %s\n", argv[1]);
	return 0;
}

```

5. Apresente os comportamentos do c�digo anterior nos seguintes casos:
		
		(a) Se o usu�rio insere mais de um nome.
```bash
$ ./ola_usuario_2 Eu Mesmo

Ola Eu
```

		(b) Se o usu�rio insere mais de um nome entre par�nteses. Por exemplo:
```bash
$ ./ola_usuario_2 "Eu Mesmo"

Ola eu mesmo	
```

		(c) Se � usado um pipe. Por exemplo:
```bash
$ echo Eu | ./ola_usuario_2

Ola (null)
```

		(d) Se � usado um pipe com mais de um nome. Por exemplo:
```bash
$ echo Eu Mesmo | ./ola_usuario_2

Ola (null)
```

		(e) Se � usado um pipe com mais de um nome entre par�nteses. Por exemplo:
```bash
$ echo Eu Mesmo | ./ola_usuario_2

Ola (null)
```

		(f) Se � usado o redirecionamento de arquivo. Por exemplo:
```bash
$ echo Ola mundo cruel! > ola.txt
$ ./ola_usuario_2 < ola.txt

Ola (null)
```
6. Crie um c�digo em C que faz o mesmo que o c�digo da quest�o 4, e em seguida imprime no terminal quantos valores de entrada foram fornecidos pelo usu�rio. Por exemplo, considerando que o c�digo criado recebeu o nome de 'ola_usuario_3':
```bash
$ ./ola_usuario_3 Eu
$ Ola Eu
$ Numero de entradas = 2

#include <stdio.h>
#include <stdlib.h>

int main (int argc, char **argv){
	printf("Ola %s\n", argv[1]);
	printf("Numero de entradas = %d \n", argc);
	return 0;
}
```

7. Crie um c�digo em C que imprime todos os argumentos de entrada fornecidos pelo usu�rio. Por exemplo, considerando que o c�digo criado recebeu o nome de 'ola_argumentos':

```bash
$ ./ola_argumentos Eu Mesmo e Minha Pessoa
$ Argumentos: Eu Mesmo e Minha Pessoa

#include <stdio.h>

int main(int argc, char **argv){
	int i = 1;
	printf("Argumentos: ");
	while(i!=argc){
		printf("%s ", argv[i]);
		i++;;
	}
	printf("\n");
	return 0;
}
```

8. Crie uma fun��o que retorna a quantidade de caracteres em uma string, usando o seguinte prot�tipo:
`int Num_Caracs(char *string);` Salve-a em um arquivo separado chamado 'num_caracs.c'. Salve o prot�tipo em um arquivo chamado 'num_caracs.h'. Compile 'num_caracs.c' para gerar o objeto 'num_caracs.o'.


9. Re-utilize o objeto criado na quest�o 8 para criar um c�digo que imprime cada argumento de entrada e a quantidade de caracteres de cada um desses argumentos. Por exemplo, considerando que o c�digo criado recebeu o nome de 'ola_num_caracs_1':

```bash
$ ./ola_num_caracs_1 Eu Mesmo
$ Argumento: ./ola_num_caracs_1 / Numero de caracteres: 18
$ Argumento: Eu / Numero de caracteres: 2
$ Argumento: Mesmo / Numero de caracteres: 5

#include <stdio.h>
#include "num_caracs.h"

int main(int argc, char **argv){
	int i = 0;
	while(i!=argc){
		printf("Argumento: %s // Numero de caracteres: %d\n",argv[i],num_caracs(argv[i]));
		i++;
	}
	return 0;
}
```

10. Crie um Makefile para a quest�o anterior.
```bash
#include <stdio.h>
#include "num_caracs.h"

int main(int argc, char **argv){
	int i = 0;
	int total = 0;
	while(i!=argc){
		total += num_caracs(argv[i]);
		i++;
	}
	printf("Total de caracteres de entrada: %d\n", total);
	return 0;
}
```
11. Re-utilize o objeto criado na quest�o 8 para criar um c�digo que imprime o total de caracteres nos argumentos de entrada. Por exemplo, considerando que o c�digo criado recebeu o nome de 'ola_num_caracs_2':
```bash
$ ./ola_num_caracs_2 Eu Mesmo
$ Total de caracteres de entrada: 25

#include <stdio.h>
#include "num_caracs.h"

int main(int argc, char **argv){
	int i = 0;
	int total = 0;
	while(i!=argc){
		total += num_caracs(argv[i]);
		i++;
	}
	printf("Total de caracteres de entrada: %d\n", total);
	return 0;
}
```

12. Crie um Makefile para a quest�o anterior.
