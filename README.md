MiniHaskell
==========
Projeto da disciplina de Programação Orientada a Objetos (1/2016) na Universidade de Brasília.

##### Especificação do projeto:
A partir do projeto inicial disponibilizado pelo professor, executar as seguintes tarefas:
- [ ] Criar novas expressões lógicas (and, or, not), expressões envolvendo inteiros (*, /, -) e operadores relacionais (==, !=, <, >, <=, >=);
- [ ] Criar casos de testes para as expressoes: Let e Aplicação de Função;
  * O que ocorre com a expressao "let x = 10 in let x = 5 in x + x" ?
  * O que ocorre com "fat 5", onde "fat n = if (n == 0) then 1 else n * fat (n - 1)" ?
- [ ] Escrever mais testes para a expressão Aplicação de Função;
- [ ] Corrigir os visitors implementados, mas que estão "quebrados" na versão 03 da implementação do projeto MiniHaskell;
- [ ] Incluir suporte ao tipo Lista, que pode ser uma lista vazia ou uma lista com um elemento seguido de uma outra lista (é um tipo recursivo); 
  * Em Haskell, seria algo como: 
  
    data List a = Nill | a (List a)
- [ ] Escrever funções que manipulam listas (tamanho, elemento em uma posicao especifica, ...);
- [ ] Implementar um parser e um programa para interpretar MiniHaskell.

##### Material de estudo:
