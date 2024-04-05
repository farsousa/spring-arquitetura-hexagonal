# Spring-Arquitetura-Hexagonal
Este projeto visa ser referência de estudo para o assunto de arquitetura hexagonal.

## Arquitetura Hexagonal
A Arquitetura Hexagonal, também conhecida como Arquitetura de Portas e Adaptadores, busca isolar o domínio da aplicação de elementos externos (bibliotecas, frameworks, ...). Tudo isso para que esse _core_ com a regra de negócio seja reaproveitado nos casos de troca de tecnologia, biblioteca, frameworks e para facilitar a manutenção do sistema.

Assim, cria-se um _core_ com a regra que independe de bibliotecas e frameworks e suas funcionalidades são acessadas por meio de portas. E existem adaptadores com capacidades de acionar as portas a fim da execução de alguma funcionalidade do _core_.

A figura a seguir mostra uma ilustração da arquitetura:
![Arquitetura Hexagonal](https://miro.medium.com/v2/resize:fit:1400/format:webp/0*Ujx7saeqJVjXvybC)

Para mais informações, acesse este artigo: https://medium.com/@marcio.kgr/arquitetura-hexagonal-8958fb3e5507

## Organização do Projeto
A estrutura do projeto ficou da seguinte forma:

![image](https://github.com/farsousa/spring-arquitetura-hexagonal/assets/52000592/051e841c-9657-43c5-8612-542d9112c608)

## Swagger
Para verificar os serviços oferecidos, após rodar o projeto localmente, acesse: http://localhost:8080/swagger-ui/index.html


