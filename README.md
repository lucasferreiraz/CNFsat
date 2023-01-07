<h1 align="center">
    <img src="media/head.png"></img>
    <b>CNFsat</b>
</h1>

## Sobre 📚

O projeto **CNFsat** foi desenvolvido por **Lucas Ferreira dos Santos** e **Walyson Rodrigo da Silva** durante a disciplina **Lógica para Computação** ministrada pelo professor **Thiago Alves** do curso de Ciências da Computação do Instituto Federal de Educação, Ciência e Tecnologia do Ceará (IFCE), Campus Maracanaú.

O seguinte projeto é uma refatoração do [projeto anterior](https://github.com/lucasferreiraz/logisat) utilizando as fórmulas das restrições no formato **CNF** ([Conjuntive Normal Form](https://en.wikipedia.org/wiki/Conjunctive_normal_form)). Mas ao invés de implementar os algoritmos de valoração, validade e satisfatibilidade como foi feito anteriormente, foi utilizado um SAT solver moderno para encontrar as regras que regem o diagnóstico em relação à patogenicidade dos pacientes nos arquivos **csv**.

O solver utilizado foi a biblioteca [Sat4J](https://www.sat4j.org/), que é uma biblioteca Java para resolver problemas booleanos de satisfatibilidade e otimização. Ele pode resolver problemas SAT, MAXSAT, Pseudo-Boolean e MUS (Minimally Unsatisfiable Subset).

## Conceitos Importantes Utilizados 💼

- **CNF (Conjuntive Normal Form)**
- **Fórmulas da Lógica Proposicional**
- **Valorações**
- **Semântica**
- **Representação de Sentenças**
- **Validade**
- **Satisfatibilidade**

## Como Utilizar? 🔧

Da mesma forma como o [projeto anterior](https://github.com/lucasferreiraz/logisat) teremos um binário executável **CNFsat.jar** (que pode ser baixado [aqui](https://github.com/lucasferreiraz/CNFsat/releases)) que já inclui internamente todos os arquivos **.csv** que foram disponibilizados para teste, sendo necessário apenas passar o nome do arquivo completo no primeiro parâmetro na chamada do programa seguido do segunto parâmetro, sendo este último um número inteiro, que é o número de regras suposto inicialmente. <br>
```bash
java -jar logisat.jar [fileName] [numberRules]
```
A lista de arquivos **.csv** suportados no programa são os mesmos que foram disponibilizados e o nome deles podem ser encontrado nesta [pasta](/src/data).


Posto isto, para utilizar, acesse a pasta onde o arquivo binário **.jar** está e abra o terminal na mesma pasta utilizando o seguinte comando, por exemplo, para o arquivo **column_bin_3a_3p.csv**.

```bash
java -jar logisat.jar column_bin_3a_3p.csv 2
```

## Dados Técnicos 📃

Um pequeno "benchmark" foi apurado para cada arquivo **csv** como foi requisitado na entrega, informações tais como o **arquivo**, **número mínimo de regras**, **regras obtidas** e **tempo de execução** podem ser encontrados [aqui](/doc/table.md).

---
<p align="center" style="font-weight:bolder">
    Developed with 💛 by <a href="https://github.com/lucasferreiraz">Lucas Ferreira</a> & <a href="https://github.com/walysonrodrigo">Walyson Rodrigo</a>.
</p>