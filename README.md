# QW Control Deploy

<p align="center">
    <img src="http://img.shields.io/static/v1?label=STATUS&message=Deploy&color=green&style=for-the-badge"/> <img src="http://img.shields.io/static/v1?label=OS&message=Debian&color=green&style=for-the-badge"/>
</p>

## Getting starting

### Dependencies

* Jenkins
  * Tools
    * NodeJS - Adcionar versão NodeJS 12.22.7
    * Docker build step
    * Docker plugin
    * CloudBees Docker Build and Publish plugin

* Servidor
  * Linux
    * user "qw"
  * Docker e Docker-compose
  * file "deploy.sh"

### Jenkins

* New Jobs
  * Name: Update_Servidor_Homolog(10.1.1.10)
  * Type: Build a freestyle software project
  * Build: Execute shell script on remote host using ssh
    * Baixar todos os arquivos de configuração

    ```sh
    ./deploy.sh
    ```

    * Remover e instalar Dockers

    ```sh
    ./jenkins.sh "$(cat version)"
    ```

    * Docker que será nesessario remover o imagem (colocar apenas os que deseja desistalar)

    ```sh
    qwsoftware
    docs
    nginx
    .
    ```
    