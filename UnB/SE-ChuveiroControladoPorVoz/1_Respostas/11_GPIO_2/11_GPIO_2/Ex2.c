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

	printf("Frequência (Hz)?\n");
	scanf("%f",&freq);
	lamb = 1000000/freq;

	signal(SIGINT,fechar);

  printf("Realizando o export\n");	//set export
	fd = open("/sys/class/gpio/export",O_WRONLY);
	write(fd,"3",2);
	close(fd);
	sleep(1);

	printf("Iniciando o pin como saída\n"); //set saída
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