import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        // 3.1 - Inserir todos os funcionários
        funcionarios.add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), new BigDecimal("2009.44"), "Operador"));
        funcionarios.add(new Funcionario("João", LocalDate.of(1990, 5, 12), new BigDecimal("2284.38"), "Operador"));
        funcionarios.add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), new BigDecimal("9836.14"), "Coordenador"));
        funcionarios.add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), new BigDecimal("19119.88"), "Diretor"));
        funcionarios.add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), new BigDecimal("2234.68"), "Recepcionista"));
        funcionarios.add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), new BigDecimal("1582.72"), "Operador"));
        funcionarios.add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), new BigDecimal("4071.84"), "Contador"));
        funcionarios.add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), new BigDecimal("3017.45"), "Gerente"));
        funcionarios.add(new Funcionario("Heloisa", LocalDate.of(2003, 5, 24), new BigDecimal("1606.85"), "Eletricista"));
        funcionarios.add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), new BigDecimal("2799.93"), "Gerente"));

        // 3.2 - Remover o funcionário "João"
        funcionarios.remove(new Funcionario("João", null, null, null));

        // 3.3 - Imprimir todos os funcionários com todas as suas informações
        funcionarios.forEach(funcionario -> {
            System.out.println(funcionario);
        });

        // 3.4 - Aumentar 10% no salário dos funcionários
        funcionarios.forEach(Funcionario::aplicarAumento);

        // 3.5 - Agrupar os funcionários por função
        Map<String, List<Funcionario>> agrupadosPorFuncao = funcionarios.stream()
                .collect(Collectors.groupingBy(Funcionario::getFuncao));

        // 3.6 - Imprimir os funcionários agrupados por função
        agrupadosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("Função: " + funcao);
            lista.forEach(System.out::println);
        });

        // 3.8 - Imprimir os funcionários que fazem aniversário nos meses 10 e 12
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .forEach(System.out::println);

        // 3.9 - Imprimir o funcionário com a maior idade
        Funcionario maisVelho = funcionarios.stream()
                .max(Comparator.comparingInt(Funcionario::getIdade))
                .orElse(null);

        if (maisVelho != null) {
            System.out.println("Funcionário com maior idade: " + maisVelho.getNome() + " - Idade: " + maisVelho.getIdade());
        }

        // 3.10 - Imprimir a lista de funcionários por ordem alfabética
        funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .forEach(System.out::println);

        // 3.11 - Imprimir o total dos salários dos funcionários
        BigDecimal totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("Total dos salários: " + totalSalarios);

        // 3.12 - Imprimir quantos salários mínimos ganha cada funcionário
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        funcionarios.forEach(f -> {
            @SuppressWarnings("deprecation")
			BigDecimal salarioMinimos = f.getSalario().divide(salarioMinimo, 2, BigDecimal.ROUND_HALF_UP);
            System.out.println(f.getNome() + " ganha " + salarioMinimos + " salários mínimos");
        });
    }
}
