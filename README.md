# Redes-de-Computadores

Para rodar os programas é simples, basta rodar os programas na ordem:

  1.	Servidor → Package Servidor → Inicio_Servidor.

    	1.1.	Cliente Administrativo → Package Geral → Inicio_Cliente.
    	
      1.2.	Cliente Ponto → Package Geral → Inicio_Cliente.
      
Nota1: Pode rodar em qualquer ordem os pontos 1.1 e 1.2, mas para manipular os pontos, é necessário ter funcionários cadastrados para os ID’s serem válidos.
Nota2: O servidor cria um arquivo .txt na pasta do projeto, chamado Funcionarios, que é onde guarda os dados do sistema. Para trocar a pasta, basta ir em:

  1.	Servidor → Package Servidor → Inicio_Servidor.
 
    	1.1.	Na classe Inicio_Servidor, existe uma public static String endereco, com uma string vazia, que direciona o arquivo diretamente para a pasta do projeto. Para mudar a pasta, basta mudar a string, como por exemplo: endereco = "C:\\Users\\USUÁRIOAQUI\\Desktop\\";. Este endereço salva ou cria (se necessário) o arquivo .txt na área de trabalho do USUÁRIOAQUI.
