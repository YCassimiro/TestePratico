import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void aplicarAumento() {
        salario = salario.multiply(BigDecimal.valueOf(1.10)); // 10% de aumento
    }

    @Override
    public String toString() {
        return super.toString() + " - Função: " + funcao + " - Salário: " + String.format("%,.2f", salario).replace(",", "_").replace(".", ",").replace("_", ".");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(getNome(), that.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }
}
