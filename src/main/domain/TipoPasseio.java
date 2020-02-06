package domain;

public class TipoPasseio {

        private Integer idTipoPasseio;

        private String nomePasseio;

        private String descricaoPasseio;

    public TipoPasseio(Integer idTipoPasseio, String nomePasseio, String descricaoPasseio) {
        this.idTipoPasseio = idTipoPasseio;
        this.nomePasseio = nomePasseio;
        this.descricaoPasseio = descricaoPasseio;
    }

    public TipoPasseio(Integer idTipoPasseio) {
        this.idTipoPasseio = idTipoPasseio;
    }

    public String getNomePasseio() {
        return nomePasseio;
    }

    public void setNomePasseio(String nomePasseio) {
        this.nomePasseio = nomePasseio;
    }

    public String getDescricaoPasseio() {
        return descricaoPasseio;
    }

    public void setDescricaoPasseio(String descricaoPasseio) {
        this.descricaoPasseio = descricaoPasseio;
    }

    public Integer getIdTipoPasseio() {
        return idTipoPasseio;
    }

    public void setIdTipoPasseio(Integer idTipoPasseio) {
        this.idTipoPasseio = idTipoPasseio;
    }

    @Override
    public String toString() {
        return "TipoPasseio{" +
                "idTipoPasseio=" + idTipoPasseio +
                ", nomePasseio='" + nomePasseio + '\'' +
                ", descricaoPasseio='" + descricaoPasseio + '\'' +
                '}';
    }
}
