# 🧩 Sudoku - Projeto Java com Swing

Projeto desenvolvido em Java para aplicar conceitos de orientação a objetos, interface gráfica (Swing), design patterns e lógica de jogo. O usuário pode jogar Sudoku diretamente pela interface, com validações automáticas, botões de controle e feedback visual.

---

## ✅ Tecnologias utilizadas

-   Java 17+
-   Swing (JFrame, JPanel, JTextField, etc)
-   Padrões de projeto:
    -   Observer (EventListener)
    -   MVC em camadas (`model`, `service`, `ui.custom`)

---

## 🚀 Como rodar o projeto

### 1. Pré-requisitos

-   IntelliJ IDEA (ou outra IDE com suporte a Java)
-   Java instalado (versão 17 ou superior)

### 2. Clonar o repositório

```bash
git clone [https://github.com/seu-usuario/seu-repositorio.git](https://github.com/seu-usuario/seu-repositorio.git)
cd seu-repositorio
3. Configurar argumentos no IntelliJ
Vá até o menu superior: Run > Edit Configurations...

Selecione a classe UiMain.

No campo Program arguments, cole a string abaixo (toda em uma única linha):

Plaintext

0,0;4,false 1,0;7,false 2,0;9,true 3,0;5,false 4,0;8,true 5,0;6,true 6,0;2,true 7,0;3,false
8,0;1,false 0,1;1,false 1,1;3,true 2,1;5,false 3,1;4,false 4,1;7,true 5,1;2,false 6,1;8,false
7,1;9,true 8,1;6,true 0,2;2,false 1,2;6,true 2,2;8,false 3,2;9,false 4,2;1,true 5,2;3,false 6,2;7,false
7,2;4,false 8,2;5,true 0,3;5,true 1,3;1,false 2,3;3,true 3,3;7,false 4,3;6,false 5,3;4,false 6,3;9,false
7,3;8,true 8,3;2,false 0,4;8,false 1,4;9,true 2,4;7,false 3,4;1,true 4,4;2,true 5,4;5,true 6,4;3,false
7,4;6,true 8,4;4,false 0,5;6,false 1,5;4,true 2,5;2,false 3,5;3,false 4,5;9,false 5,5;8,false 6,5;1,true
7,5;5,false 8,5;7,true 0,6;7,true 1,6;5,false 2,6;4,false 3,6;2,false 4,6;3,true 5,6;9,false 6,6;6,false
7,6;1,true 8,6;8,false 0,7;9,true 1,7;8,true 2,7;1,false 3,7;6,false 4,7;4,true 5,7;7,false 6,7;5,false
7,7;2,true 8,7;3,false 0,8;3,false 1,8;2,false 2,8;6,true 3,8;8,true 4,8;5,true 5,8;1,false 6,8;4,true 7,8;7,false 8,8;9,false

Clique em Apply e depois em OK.

Execute normalmente a aplicação!

🧠 Lógica dos parâmetros
Cada valor representa uma célula preenchida do tabuleiro, seguindo o formato:

coluna,linha;valor,fixed
Exemplo:

2,0;9,true
Isso significa: Posição coluna 2, linha 0, com o valor 9, sendo uma célula fixa (não-editável).

🧩 Funcionalidades implementadas
Interface Swing com layout em grid 9x9.

Estilo dark (fundo preto, fontes brancas).

Campos editáveis com validação (aceita apenas números de 1 a 9).

Células fixas são bloqueadas para edição.

Botão "Verificar Jogo" com retorno de status (se há erros no tabuleiro).

Botão "Finalizar Jogo" com verificação de vitória.

Botão "Resetar" que limpa apenas os campos preenchidos pelo usuário.

Sistema de eventos com o padrão Observer para um reset reativo.

Código organizado por pacotes (model, service, ui.custom).
```
## Autor
Desenvolvido por Lucas Ximenes

## 📧 Email: lucasximenes177@gmail.com

## 🔗 GitHub: @lucasximenes30
