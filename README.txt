# Universidade Federal do Ceará
# Centro de Tecnologia
# Departamento de Engenharia de Teleinformática
#
# Trabalho de Sistemas Distribuídos 2015.2
# Professor Dr.: Flávio Sousa
# 
#
# Equipe:	Lucas Weyne  
#		Maria Thereza Rodrigues 	
#		
#		
#
# Endereço GitHub:	https://github.com/weynelucas/Trabalho_SD_2015_2.git


Servidor de músicas no formato mp3 que oferece a funcionalidade de buscar uma música pelo seu nome; com replicação, 
consistência e balanceamento de carga.

1. Tipo do projeto: 
	a) Versão simplificada na branch master;
	b) Versão completa na branch Replicacao.

2. Descrição do ambiente, tecnologias e SO: 
	a) Versão do JDK: 1.8.0_60-b27;
	b) Tecnologias: 
		b.a) Java RMI;
	c) Sistema Operacional: Xubuntu 14.04;
	d) IDE: Eclipse Luna;
	e) Conexão com uma Rede de Computadores. 
	
3. Passo a passo:
	a) Executar projeto MusicServerReplicaRMI;
		Resultado esperado: servidor exibe mensagem "Servidor secundário (backup) inicializado!";
	b) Executar projeto MusicServerRMI;
		Resultado esperado: servidor exibe mensagem "Servidor primário inicializado!";
	c) Executar projeto MusicClientRMI;
		Resultado esperado: programa exibe as músicas requisitadas por cada cliente e de qual servidor veio a resposta;
	d) Restrições
		d.a) Se for executar a aplicação novamente para ver o resultado do programa cliente, executar apenas o projeto
		MusicClientRMI
		d.b) Se for rodar novamente os projetos MusicServerReplicaRMI e/ou MusicServerRMI, lembrar de parar os
		processos destas aplicações para liberar as portas usadas no rmiregistry (2000 e 4000, reespectivamente)
	
	
