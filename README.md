# QW Control Deploy

<p align="center">
    <img src="http://img.shields.io/static/v1?label=STATUS&message=Deploy&color=green&style=for-the-badge"/> <img src="http://img.shields.io/static/v1?label=OS&message=Debian&color=green&style=for-the-badge"/>
</p>

## Getting starting

### Dependencies

* Jenkins
  * Tools
    * NodeJS - Adicionar versão NodeJS 12.22.7
    * Docker build step
    * Docker plugin
    * CloudBees Docker Build and Publish plugin

* Servidor
  * Linux
    * user "qw"
  * Docker e Docker-compose
  * file "[deploy.sh](/deploy.sh)"

### Jenkins

* New Jobs
  * Name: Update_Servidor_Homolog(10.1.1.50)
  * Type: Build a freestyle software project
  * Build: Execute shell script on remote host using ssh
    * SSH site

        ```sh
        qw@10.1.1.50:22
        ```

    * Command
      * Baixar todos os arquivos de configuração incluindo o [jenkins.sh](/jenkins.sh)

      ```sh
      ./deploy.sh
      ```

      * Remover e instalar Dockers

      ```sh
      ./jenkins.sh "$(cat version)" qwsoftware docs nginx
      ```

      Obs. "$(cat version)" informará a versão do QWControl e para remover um docker é preciso escrever os nomes dos mesmo depois de inserir a versão.
