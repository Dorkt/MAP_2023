# Patterns utilizados

## Herança

Utilizamos do padrão de herança, pela facilidade de conseguir e o propósito que tínhamos ao extender uma classe no nosso projeto, analisamos que nesse exemplo em que aplicamos esse padrão, o objeto era um “tipo especial de”, e que ele não precisaria fazer override ou até anular variáveis ou métodos da classe que seria tida como pai.

Outro ponto que levamos em conta é o fato de que novas implementações nas classes que herdam da classe pai, sempre implementarão apenas métodos e variáveis específicas para seu contexto criando assim funcionalidades que só dizem respeito aquele escopo trabalhado.

O exemplo no qual utilizamos de herança foi na classe de nome Controller, onde ele define 4 tipos de métodos a serem utilizados, são eles:


    Controller:
        - insertData(Object obj):Insere um objeto no arquivo JSON correspondente com base no tipo 	do objeto (Loja, Comprador ou Produto). 
        - readData(String type):Lê os dados do arquivo JSON correspondente ao tipo especificado 	(Loja, Comprador ou Produto) e retorna uma lista de objetos. 
        - deleteData(int idToRemove, String type): Remove um objeto do arquivo JSON 	correspondente ao tipo especificado. 
        - updateData(String type, int idToUpdate, String newName):Atualiza o nome de um objeto no 	arquivo JSON correspondente ao tipo especificado. 


Todas as classes que tem o nome `Controller` como prefixo, irão extender dessa classe pai.

## Fachade

Entendemos que utilizar de Fachade ajudaria muito o processo de desenvolvimento do nosso código, em vista que a nossa classe MarkteplaceFachade, teria uma visão completa de todas as classes, e apenas exportaria isso para nossa função main, que em tese seria o acesso para as classes e métodos existentes no nosso sistema.

Com isso simplificamos a interface do sistema, dando ao usuário uma interface única e simplificada que acesso todos os serviços do sistema.

Em tese, com a utilização desse padrão, temos a fachada recebendo requisições e solicitações, nas quais ela própria retorna novas interfaces para o usuário utilizar, e a medida que o usuário vai interagindo com essas interfaces, os controllers são chamados através da mesma fachada, e executando comandos e persistências de dados para que o usuário consiga utilizar do sistema