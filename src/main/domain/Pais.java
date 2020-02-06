package domain;

public class Pais {
    private Integer idPais;
    private String nomePais;

    public Pais(Integer idPais, String nomePais) {
        this.idPais = idPais;
        this.nomePais = nomePais;
    }

    public Integer getIdPais() {
        return idPais;
    }

    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }

    public String getNomePais() {
        return nomePais;
    }

    public void setNomePais(String nomePais) {
        this.nomePais = nomePais;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "idPais=" + idPais +
                ", nomePais='" + nomePais + '\'' +
                '}';
    }
}
