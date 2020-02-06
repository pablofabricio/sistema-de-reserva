package domain;

public class Modalidade {

    private Integer idModalidade;
    private String nome;

    public Modalidade(Integer idModalidade, String nome) {
        this.idModalidade = idModalidade;
        this.nome = nome;
    }

    public Integer getIdModalidade() {
        return idModalidade;
    }

    public void setIdModalidade(Integer idModalidade) {
        this.idModalidade = idModalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Modalidade{" +
                "idModalidade=" + idModalidade +
                ", nome='" + nome + '\'' +
                '}';
    }
}
