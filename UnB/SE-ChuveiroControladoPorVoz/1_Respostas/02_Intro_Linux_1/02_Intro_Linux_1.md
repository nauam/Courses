1. Por que o Linux recebeu esse nome?
	
	Porque ele é um derivado sistema operacional Unix, além de uma homenagem ao seu criador, Linux Torvalds.

2. O que são daemons?
	
	Daemon é um processo de background responsável por controle administrativo e execução de alguns serviços em sistemas multitarefas.

3. O que é o shell?
	
	É o terminal por onde pode-se executar os comandos para o linux.

4. Por que é importante evitar executar o terminal como super-usuário?
	
	Porque ele possui permissões acima de um usuário comum, o que pode ocasionar em uma exclusão ou alteração indevida de algum arquivo importante ao sistema.

5. Qual botão do teclado completa o que o usuário escreve no terminal, de acordo com o contexto?

	Tab.

6. Quais botões do teclado apresentam instruções escritas anteriormente?
	
	Seta para cima (Up).

7. Apresente os respectivos comandos no terminal para:
	
  (a) Obter mais informações sobre um comando.
	
  	man <comando>

  (b) Apresentar uma lista com os arquivos dentro de uma pasta.
	
  	ls

  (c) Apresentar o caminho completo da pasta.
	
  	pwd
  	
  (d) Trocar de pasta.
	
  	cd <caminho_pasta>
  	
  (e) Criar uma pasta.
	
  	mkdir <nome_pasta>
  	
  (f) Apagar arquivos definitivamente.
	
  	rm <nome_arquivo>
  	
  (g) Apagar pastas definitivamente.
	
  	rm -r <nome_pasta>
  	
  (h) Copiar arquivos.
	
  	cp <fonte_nome_arquivo> <destino_nome_arquivo>
  	
  (i) Copiar pastas.
	
  	cp -r <fonte_nome_pasta> <destino_nome_pasta>
  	
  (j) Mover arquivos.
	
  	mv <fonte_nome_arquivo> <destino_nome_arquivo>
  	
  (k) Mover pastas.
	
  	mv -r <fonte_nome_pasta> <destino_nome_pasta>
  	
  (l) Renomear pastas.
	
  	mv <antigo_nome_pasta> <novo_nome_pasta>
  	
  (m) Apresentar o conteúdo de um arquivo.
	
  	cat <nome_arquivo>
  	
  (n) Apresentar o tipo de um arquivo.
	
  	file <nome_arquivo>

  (o) Limpar a tela do terminal.
	
  	clear

  (p) Encontrar ocorrências de palavras-chave em um arquivo-texto.
	
  	grep -n <nome_arquivo>

  (q) Ordenar informações em um arquivo-texto.
  
  	short <nome_arquivo>

  (r) Substituir ocorrências de palavras-chave em um arquivo-texto.
  
  	sed -i 's/<antiga_palavra>/<nova_palave>' <nome_arquivo>
	
  (s) Conferir se dois arquivos são iguais.
  
  	diff
	
  (t) Escrever algo na tela.
  
  	echo <algo>
