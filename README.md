# Gerador de Senhas

Este projeto é um gerador de senhas desenvolvido em Java. Ele foi criado com o objetivo de aprimorar conhecimentos em manipulação de arquivos JSON usando a biblioteca Gson, lógica de programação e integração de diferentes métodos ao longo do código.

## Objetivos do Projeto
- Aprender a trabalhar com manipulação de dados por arquivos JSON usando a biblioteca Gson.
- Aprimorar a lógica de programação.
- Integrar diferentes métodos de forma eficiente ao longo do código.

## Tecnologias Utilizadas
- **Java**: Linguagem principal do projeto.
- **Gson**: Biblioteca para manipulação de arquivos JSON.
- **VS Code**: Ambiente de desenvolvimento utilizado.

## Como Usar
1. Clone o repositório:
   ```sh
   git clone https://github.com/Guxtavo28/passWordGenerator
   ```
2. Compile o código:
   ```sh
   javac -cp gson.jar Gerador.java
   ```
3. Execute o programa:
   ```sh
   java -cp gson.jar:. Main
   ```

## Funcionalidades
- Geração de senhas aleatórias e seguras.
- Armazenamento das senhas geradas em um arquivo JSON.
- Personalização das senhas de acordo com as preferências do usuário:
  - Escolha do tamanho da senha.
  - Inclusão ou exclusão de caracteres especiais.
  - Presença ou ausência de números.
  - Uso de letras maiúsculas e minúsculas.
  - Seleção de até 20 alfabetos diferentes para maior segurança.

## Melhorias Futuras
- Interface gráfica para facilitar o uso.
- Opção de definir critérios personalizados para as senhas.
- Criptografia das senhas armazenadas para maior segurança.