package domain;


import java.sql.Date;

public class Viajante {
    private Integer idViajante;
    private String nomeViajante;
    private String documentoViajante;
    private Date data_nascimento;

    public Viajante(Integer idViajante, String nomeViajante, String documentoViajante,  Date data_nascimento) {
        this.idViajante = idViajante;
        this.nomeViajante = nomeViajante;
        this.documentoViajante = documentoViajante;
        this.data_nascimento = data_nascimento;
    }

    public Viajante(Integer idViajante){
        this.idViajante = idViajante;
    }

    public Integer getIdViajante() {
        return idViajante;
    }

    public void setIdViajante(Integer idViajante) {
        this.idViajante = idViajante;
    }

    public String getNomeViajante() {
        return nomeViajante;
    }

    public void setNomeViajante(String nomeViajante) {
        this.nomeViajante = nomeViajante;
    }

    public String getDocumentoViajante() {
        return documentoViajante;
    }

    public void setDocumentoViajante(String documentoViajante) {
        this.documentoViajante = documentoViajante;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    @Override
    public String toString() {
        return "Viajante{" +
                "idViajante=" + idViajante +
                ", nomeViajante='" + nomeViajante + '\'' +
                ", documentoViajante='" + documentoViajante + '\'' +
                ", data_nascimento=" + data_nascimento +
                '}';
    }
}
