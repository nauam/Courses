1. Escreva um c�digo em C para gerar uma onda quadrada de 1 Hz em um pino GPIO do Raspberry Pi.
```
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

int fd;

void fechar(){
	close(fd);
	fd = open("/sys/class/gpio/unexport",O_WRONLY);
	write(fd,"3",2);
	printf("Fechando programa\n");
	close(fd);
	sleep(1);
	exit(0);
}

int main(){

	signal(SIGINT,fechar);

  printf("Realizando o export\n");	//set export
	fd = open("/sys/class/gpio/export",O_WRONLY);
	write(fd,"3",2);
	close(fd);
	sleep(1);

	printf("Iniciando o pin como sa�da\n"); //set sa�da
	fd = open("/sys/class/gpio/gpio3/direction",O_WRONLY);
	write(fd,"out",4);
	close(fd);
	sleep(1);

	fd = open("/sys/class/gpio/gpio3/value",O_WRONLY); //Freq 1Hz
	printf("Iniciando o blink\n");
	while(1){
		write(fd,"1",2);
		usleep(500000);  
		write(fd,"0",2);
		usleep(500000);
	}
	return 0;
}
```
2. Generalize o c�digo acima para qualquer frequ�ncia poss�vel.

```
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <signal.h>

int fd;

void fechar(){
	close(fd);
	fd = open("/sys/class/gpio/unexport",O_WRONLY);
	write(fd,"3",2);
	printf("Fechando programa\n");
	close(fd);
	sleep(1);
	exit(0);
}

int main(){

	float freq;
	float lamb;

	printf("Frequ�ncia (Hz)?\n");
	scanf("%f",&freq);
	lamb = 1000000/freq;

	signal(SIGINT,fechar);

  printf("Realizando o export\n");	//set export
	fd = open("/sys/class/gpio/export",O_WRONLY);
	write(fd,"3",2);
	close(fd);
	sleep(1);

	printf("Iniciando o pin como sa�da\n"); //set sa�da
	fd = open("/sys/class/gpio/gpio3/direction",O_WRONLY);
	write(fd,"out",4);
	close(fd);
	sleep(1);

	fd = open("/sys/class/gpio/gpio3/value",O_WRONLY); //Freq 
	printf("Iniciando o blink\n");
	while(1){
		write(fd,"1",2);
		usleep(lamb/2);  
		write(fd,"0",2);
		usleep(lamb/2);
	}
	return 0;
}
```

3. Crie dois processos, e fa�a com que o processo-filho gere uma onda quadrada, enquanto o processo-pai l� um bot�o no GPIO, aumentando a frequ�ncia da onda sempre que o bot�o for pressionado. A frequ�ncia da onda quadrada deve come�ar em 1 Hz, e dobrar cada vez que o bot�o for pressionado. A frequ�ncia m�xima � de 64 Hz, devendo retornar a 1 Hz se o bot�o for pressionado novamente.

```
#include <unistd.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <signal.h>
#include <time.h>
#include <sys/types.h>

int fd;
int fp[2];

void fechar(){
	close(fd);
	fd = open("/sys/class/gpio/unexport",O_WRONLY);
	write(fd,"20",2);
	write(fd,"21",2);
	close(fd);
	printf("Fechando programa\n");
	sleep(1);
	exit(0);
}


int main(){
	pid_t pid_id;
	pipe(fp);
	pid_id = fork();

	signal(SIGINT,fechar);

	if(pid_id == 0){       //processo filho
		char bf='0';
		int freq = 1;        //Hz

    printf("Realizando o export 20\n"); //set export
		fd = open("/sys/class/gpio/export",O_WRONLY);
		write(fd,"20",2);
		close(fd);
    
		printf("Iniciando o pin 20 como sa�da\n");	//set sa�da
		fd = open("/sys/class/gpio/gpio20/direction",O_WRONLY);
		write(fd,"out",4);
		close(fd);

		fd = open("/sys/class/gpio/gpio20/value",O_WRONLY);
		printf("Iniciando o blink em 20\n");
		while(1){
			printf("STATUS = %d\n",read(fp[0],&bf,sizeof(bf)));
			if(bf == '1'){
				freq = freq*2;
				bf = 0;
			}
			printf("Frequencia = %d BF = %c\n",freq,bf);
			write(fd,"1",2);
			usleep(500000/freq);
			write(fd,"0",2);
			usleep(500000/freq);
		}
	}else{         //processo pai
		char btn;
		
		printf("Realizando o export 21\n"); //set export
		fd = open("/sys/class/gpio/export",O_WRONLY);
		write(fd,"21",2);
		close(fd);

		printf("Iniciando o pin como sa�da 21\n"); //set sa�da
		fd = open("/sys/class/gpio/gpio21/direction",O_WRONLY);
		write(fd,"in",4);
		close(fd);

		fd = open("/sys/class/gpio/gpio21/value",O_RDWR);
		printf("Pronto para capturar gpio21\n");
		while(1){
			lseek(fd,0,SEEK_SET);
			read(fd,&btn,2);
			printf("BTN = %c\n",btn);
			if(btn == '1'){
				write(fp[1],&btn,sizeof(btn));
			}
			usleep(500000);
		}
	}
	return 0;
}
```
