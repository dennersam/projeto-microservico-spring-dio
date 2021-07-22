# Projeto de microserviço - [Digital Innovation One](https://digitalinnovation.one/)

### Estudo realizado na aula :
"Construindo um projeto com arquitetura baseada em microserviços usando Spring Cloud"


## Por que uma arquitetura de microserviços?

Um projeto em microserviço traz diversos pontos positivos em um ambiente de produção. 

Basicamente é fazer uma separação das atividades, configurações e responsabilidades de cada serviço.

Imagine um e-commerce, onde temos os serviços de produtos, o carrinho, entre outros. <br>
Com spring cloud, é possivel separar esses serviços e criar load balance, <br>
aumentando a disponibilidade caso houver falhas ou atualizações no sistema.


## O projeto

Esse projeto demonstra basicamente isso, há um serviço de catalago de produto, onde as informações<br>
estão sendo armazenado no elasticsearch, outro serviço de carrinho de compras, que basicamente<br>
pode ser estruturado em diferente banco de dados que nesse exemplo, esta configurado com Radis. <br>
Em cima disto tem um servidor de configuração(config-server) onde estão armazenadas em arquivos yml <br>
as portas de conexão com esses serviços, nome do host e outras informações, todas essas certralizadas.

Com um servidor de configurações fica melhor gerenciado toda a estrutura de microserviços<br>
onde é possível configurar todos os microserviços de um local só, apenas apontando todos os <br>
microserviços para o servidor.

Outra peça importante do projeto é o Service Discovery. É outro serviço que tem a responsabilidade de<br>
fazer a comunicação entre os microserviços, por exemplo entre o catalogo de produto, e o carrinho. Caso<br>
o serviço de carrinho precisar pesquisar informações no catalogo, este pergunta ao service discovery<br>
onde e em que porta está o catalogo de produtos.

Para comunicação externa e/ou autenticação, temos outra serviço importante que é o Gateway.<br>
Através dele podemos gerenciar melhor as infomação que são trocadas entre o front-end e back-end<br>
como por exemplo as requisições Rest.

