import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public int getIdade() {
        return LocalDate.now().getYear() - dataNascimento.getYear();
    }

    @Override
    public String toString() {
        return nome + " - " + dataNascimento.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
}
