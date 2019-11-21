1. Quantos pipes serão criados após as linhas de código a seguir? Por quê?

(a)
```C
int pid;
int fd[2];
pipe(fd);
pid = fork();

Será criado 1 pipe, pois o canal foi criado antes de realizar o fork, ou seja, os dois processos tem o mesmo pipe.
```

(b)
```C
int pid;
int fd[2];
pid = fork();
pipe(fd);

Serão criados 2 pipes, pois o pipe é dado a partir dos processos criados, ou seja, um para cada processo.
```

2. Apresente mais cinco sinais importantes do ambiente Unix, além do `SIGSEGV`, `SIGUSR1`, `SIGUSR2`, `SIGALRM` e `SIGINT`. Quais são suas características e utilidades?

```bash
SIGCLD =>
SIGTERM =>
SIGPIPE => 
SIGSYS =>
SIGPWR =>
```

3. Considere o código a seguir:

```C
#include <signal.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>

void tratamento_alarme(int sig)
{
	system("date");
	alarm(1);
}

int main()
{
	signal(SIGALRM, tratamento_alarme);
	alarm(1);
	printf("Aperte CTRL+C para acabar:\n");
	while(1);
	return 0;
}
```

Sabendo que a função `alarm()` tem como entrada a quantidade de segundos para terminar a contagem, quão precisos são os alarmes criados neste código? De onde vem a imprecisão? Este é um método confiável para desenvolver aplicações em tempo real?

```bash
A precisão desta função é relacionada a segundos, portanto, sua precisão é de até 1 segundo. O metódo tem um imprecisão baseada no delay causado pela chamada do processo. Não é um método confiável em relação ao fato de que o tempo de chamada, ao ser acumulado, pode gerar um delay muito grande no final. De acordo a fonte: http://pubs.opengroup.org/onlinepubs/009695399/functions/alarm.html, os problemas com essa função começam a aparecer por volta de meses.
```