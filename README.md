# Sistema OMS (Order Management System)

Este repositório contém um projeto em andamento para um sistema OMS (Order Management System), desenvolvido utilizando os conceitos de arquitetura limpa e Java com Spring.

## Visão Geral

Um Sistema de Gestão de Pedidos (OMS) é uma aplicação que facilita o processo de gestão e monitoramento de pedidos em um ambiente empresarial. Ele lida com várias etapas do ciclo de vida de um pedido, desde o recebimento inicial até o cumprimento e entrega final. O sistema OMS permite que as empresas controlem e otimizem seus processos de pedidos, gerenciando eficientemente as informações relacionadas aos clientes, produtos, estoques e pedidos em andamento.

## Funcionalidades Previstas

O sistema em desenvolvimento pretende abranger as seguintes funcionalidades:

- **Gestão de Pedidos**: Permitirá a criação, edição, e cancelamento de pedidos.
- **Gestão de Clientes**: Cadastro e manutenção de informações dos clientes.
- **Gestão de Produtos**: Cadastro e manutenção de informações dos produtos disponíveis para compra.
- **Gestão de Estoque**: Monitoramento e atualização dos níveis de estoque.
- **Processamento de Pedidos**: Fluxo de trabalho para processar pedidos recebidos.
- **Relatórios e Estatísticas**: Geração de relatórios e análises sobre pedidos, clientes e produtos.

## Arquitetura Limpa e Tecnologias Utilizadas

O projeto segue os princípios da Arquitetura Limpa, proposta por Robert C. Martin, também conhecido como Uncle Bob. Essa abordagem enfatiza a separação de preocupações e a manutenção da independência das camadas do sistema. A arquitetura limpa promove a escalabilidade, testabilidade e manutenibilidade do código.

As principais tecnologias utilizadas no projeto incluem:

- **Java**: Linguagem de programação principal.
- **Spring Framework**: Utilizado para a implementação da infraestrutura da aplicação, injeção de dependências, e configuração de APIs REST.
- **Hibernate**: Mapeamento objeto-relacional para persistência de dados.
- **Spring Boot**: Facilita a configuração e inicialização do projeto Spring.
- **JUnit e Mockito**: Frameworks de teste para garantir a qualidade e robustez do código.

## Estrutura do Projeto

O projeto é dividido em três módulos distintos, cada um com sua responsabilidade bem definida. A estrutura modular permite uma organização clara e a separação de preocupações, facilitando o desenvolvimento, manutenção e escalabilidade do sistema.

A estrutura de packages de cada módulo segue um padrão organizacional consistente, que promove a clareza e a separação de responsabilidades. Abaixo está uma descrição detalhada de cada diretório presente nos módulos:

### Controllers

O diretório `controllers` contém as classes responsáveis por receber requisições HTTP, interagir com os casos de uso apropriados e retornar as respostas adequadas. Eles atuam como a camada de entrada da aplicação e são responsáveis por direcionar o fluxo da requisição para os componentes internos apropriados.

### Domain

O diretório `domain` encapsula a lógica de negócios da aplicação. Ele é dividido em subdiretórios que representam diferentes aspectos do domínio da aplicação:

- **dtos**: Contém os Data Transfer Objects (DTOs), que são utilizados para transferir dados entre diferentes camadas da aplicação e a interface de usuário.
- **entities (BOs)**: Classes que representam as entidades de negócio do domínio da aplicação. Elas encapsulam o comportamento e as regras de negócio relacionadas a cada entidade.
- **enums**: Enumerações que definem conjuntos fixos de constantes ou valores que representam propriedades específicas.
- **exceptions**: Classes que representam exceções específicas do domínio, que podem ser lançadas em caso de erros ou situações excepcionais.
- **interfaces**: Interfaces que definem contratos para as operações e comportamentos que devem ser implementados pelas classes concretas.
- **mappers**: Classes responsáveis por mapear objetos de transferência de dados (DTOs) para entidades de negócio e vice-versa.
- **repositories (somente um contrato)**: Interfaces que definem contratos para acessar e manipular dados no banco de dados. Eles representam abstrações dos mecanismos de persistência de dados.
- **usecases**: Classes que implementam os casos de uso da aplicação, contendo a lógica de negócios e a coordenação das operações relacionadas a um determinado cenário de uso.

### Infra

O diretório `infra` é responsável pela implementação dos detalhes de infraestrutura da aplicação. Ele inclui subdiretórios que abrigam componentes relacionados à infraestrutura técnica da aplicação:

- **jakarta**: Classes e componentes específicos do Jakarta EE (anteriormente Java EE), como implementações de repositórios, mappers, e modelos de dados.
    - **mappers**: Classes responsáveis por mapear objetos de domínio para modelos de dados específicos da infraestrutura e vice-versa.
    - **model (a entidade, como representada no banco)**: Classes que representam os modelos de dados específicos da infraestrutura, como são armazenados no banco de dados.
    - **repository (a implementação em si)**: Implementações concretas dos repositórios definidos nas interfaces do diretório `domain.repositories`.
- **services**: Classes que encapsulam a lógica de infraestrutura e serviços técnicos, como acesso a banco de dados, comunicação com APIs externas, entre outros.

Essa estrutura organizacional ajuda a manter um código limpo, coeso e modular, facilitando o desenvolvimento, teste e manutenção do sistema. Além disso, promove uma clara separação de responsabilidades entre os diferentes componentes da aplicação.

### Módulo "**core**"

O módulo "core" é o núcleo do sistema e contém as funcionalidades comuns que são compartilhadas pelos outros módulos. Suas principais responsabilidades incluem:

- **DTOs (Data Transfer Objects)**: Responsáveis por transferir dados entre diferentes camadas da aplicação e a interface de usuário.
- **BOs (Business Objects)**: Encapsulam a lógica de negócios central da aplicação.
- **Repositories**: Interfaces que definem contratos para acessar e manipular dados no banco de dados.
- **Controllers**: Responsáveis por receber e responder às requisições HTTP da aplicação.

### Módulo "**inventory**"

O módulo "inventory" concentra-se no gerenciamento do estoque dos SKUs (Stock Keeping Units). Este módulo depende do módulo "core" para acessar as funcionalidades comuns e estende essas funcionalidades para lidar especificamente com o inventário. Suas responsabilidades incluem:

- **Gestão de Estoque**: Implementação das operações para verificar, atualizar e monitorar o estoque dos SKUs.
- **Dependência do Módulo "core"**: Utiliza os recursos fornecidos pelo módulo "core" para lidar com aspectos genéricos da aplicação.

### Módulo "**order**"

O módulo "order" é responsável pelo gerenciamento dos pedidos realizados pelos clientes. Ele depende tanto do módulo "core" quanto do módulo "inventory" para funcionar corretamente. Suas responsabilidades incluem:

- **Gestão de Pedidos**: Implementação das funcionalidades relacionadas à criação, edição e cancelamento de pedidos.
- **Dependência dos Módulos "core" e "inventory"**: Utiliza funcionalidades comuns do módulo "core" e interage com o módulo "inventory" para verificar a disponibilidade de produtos em estoque.

### Diagrama de Dependências

Abaixo está um diagrama simplificado das dependências entre os módulos:

```
   +-------------+       +-------------+
   |    core     |  <--  |  inventory  |
   +-------------+       +-------------+
            |                  |
            |                  |
            +--------+---------+
                     |
                     v
                +------------+
                |   order    |
                +------------+
```

Este diagrama ilustra como o módulo "order" depende dos módulos "core" e "inventory" para funcionar corretamente.

A estrutura modular adotada neste projeto promove a reutilização de código, facilita a manutenção e permite que cada parte do sistema seja desenvolvida e testada independentemente das outras. Isso resulta em um código mais limpo, coeso e escalável.

## Como Contribuir

Contribuições são bem-vindas! Se você deseja contribuir para este projeto, por favor siga estas etapas:

1. Faça um fork do repositório e clone-o em sua máquina local.
2. Crie uma branch para a sua feature (`git checkout -b feature/NomeDaFeature`).
3. Implemente suas alterações e faça commits explicativos (`git commit -am 'Adiciona uma nova feature'`).
4. Faça push para a branch (`git push origin feature/NomeDaFeature`).
5. Abra um pull request explicando suas alterações.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

---

Esse README fornece uma visão geral do projeto, suas funcionalidades previstas, tecnologias utilizadas, estrutura do projeto, orientações para contribuições e informações sobre a licença. Se você tiver dúvidas ou sugestões, sinta-se à vontade para entrar em contato com os mantenedores do projeto.
