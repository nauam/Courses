# Ferramentas de build :building_construction:

## Java 15 

$	sudo add-apt-repository ppa:linuxuprising/java

$	sudo apt-get install oracle-java15-installer 

$	export JAVA_HOME="/usr/lib/jvm/java-15-oracle/"

$	export PATH=$JAVA_HOME/bin:$PATH

$	java --version



## Gradle

+ https://gradle.org/releases/

$	sudo unzip -d /opt/gradle/ gradle-6.8.3-bin.zip

$	export PATH=$PATH:/opt/gradle/gradle-6.8.3/bin

$	gradle -v

- Wrapper

$	gradle wrapper

$	./gradlew -v



## Maven

- https://maven.apache.org/download.cgi

$	sudo unzip -d /opt/maven/ apache-maven-3.6.3-bin.zip 

$	export PATH=$PATH:/opt/maven/apache-maven-3.6.3/bin/

$	mvn -v

- Wrapper

$	mvn -N io.takari:maven:wrapper

$	./mvnw -v



## IntelliJ IDEA

- https://www.jetbrains.com/pt-br/idea/download/#section=linux

$	sudo tar -xzf ideaIC-2020.3.2.tar.gz

$	cd idea-IC-203.7148.57/bin

$	./idea.sh



## Spring initializr

- https://start.spring.io/

  

## Terminal

inicializar pelo terminal

$	java -jar target/*.jar

