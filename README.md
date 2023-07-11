# orgs

O projeto ORGS é um aplicativo Android para gerenciar notas com ou sem imagens. Ele implementa as operações básicas de um CRUD (Create, Read, Update, Delete) para permitir aos usuários criar, visualizar, atualizar e excluir notas, além de adicionar imagens às notas.

<h3>Tecnologias Utilizadas</h3>
O projeto ORGS utiliza as seguintes tecnologias:

- <b>Linguagem de Programação:</b> Kotlin
- <b>Arquitetura:</b> MVVM (Model-View-ViewModel)
- <b>Banco de Dados:</b> SQLite com Room Persistence Library
- <b>Frameworks e Bibliotecas:</b>
  - <b>Android Jetpack Components:</b>
    - <b>LiveData:</b> Para atualização de dados reativos na interface do usuário.
    - <b>ViewModel:</b> Para gerenciamento do estado da interface do usuário e manipulação de dados.
    - <b>Room:</b> Para persistência de dados com SQLite e mapeamento objeto-relacional (ORM).
    - <b>DataStore:</b> Para armazenamento de preferências de usuário.
    - <b>Coroutines:</b> Para execução assíncrona de tarefas.
    - <b>Glide:</b> Para carregamento de imagens.
    - <b>Material Design Components:</b> Para implementação de elementos de design de interface do usuário.
    - <b>RecyclerView:</b> Para exibição de listas de notas e imagens.
    - <b>Kotlin Serialization:</b> Para serialização e desserialização de objetos JSON.
    - <b>Espresso:</b> Para testes de interface do usuário.
    - <b>Mockito e MockK:</b> Para criação de mocks e testes unitários.

<h3>Funcionalidades do Projeto</h3>
O projeto ORGS implementa as seguintes funcionalidades:

- Listagem de Notas: Os usuários podem visualizar uma lista de notas cadastradas, incluindo o título, a descrição e a imagem associada, se houver.
- Detalhes da Nota: Os usuários podem visualizar os detalhes de uma nota específica, incluindo o título, a descrição e a imagem associada.
- Criação de Notas: Os usuários podem criar novas notas, inserindo um título, uma descrição e, opcionalmente, uma imagem.
- Edição de Notas: Os usuários podem editar as informações de uma nota existente, incluindo o título, a descrição e a imagem associada.
- Exclusão de Notas: Os usuários podem excluir uma nota existente.
- Adição de Imagem: Os usuários podem adicionar uma imagem à nota, selecionando uma imagem da galeria do dispositivo ou capturando uma nova foto.
- Armazenamento de Preferências: As preferências do usuário, como o ID do usuário logado, são armazenadas utilizando o DataStore.
- Autenticação de Usuário: O aplicativo possui uma tela de login onde os usuários podem autenticar-se para acessar as funcionalidades do aplicativo.



