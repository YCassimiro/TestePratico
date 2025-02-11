# TestePratico
Projeto Prático Gupy

#Explicação do Código:
Classe Pessoa:

Contém o nome e a data de nascimento. Além disso, há um método getIdade() que calcula a idade com base na data de nascimento.
Classe Funcionario:

Herda de Pessoa e adiciona atributos específicos como salario e funcao.

O método aplicarAumento() aumenta o salário em 10%.

O método toString() é sobrescrito para garantir que o salário seja exibido com vírgula como separador decimal e ponto como separador de milhar.

Classe Principal:

3.1: Inserimos os funcionários conforme os dados fornecidos.

3.2: Removemos o funcionário João da lista.

3.3: Imprimimos todos os funcionários com as informações, incluindo o formato de data e salário.

3.4: Aplicamos um aumento de 10% no salário de todos os funcionários.

3.5: Agrupamos os funcionários por função utilizando Collectors.groupingBy().

3.6: Imprimimos os funcionários agrupados por função.

3.8: Imprimimos os funcionários que fazem aniversário nos meses 10 e 12.

3.9: Encontramos o funcionário com a maior idade e mostramos o nome e a idade.

3.10: Imprimimos os funcionários em ordem alfabética.

3.11: Calculamos e imprimimos o total dos salários dos funcionários.

3.12: Calculamos quantos salários mínimos cada funcionário ganha, considerando o salário mínimo de R$1212,00.

