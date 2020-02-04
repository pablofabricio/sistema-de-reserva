import DAO.ModalidadeDAO;
import DAO.TipoPasseioDAO;
import connection.JDBDCConnection;
import domain.Modalidade;
import domain.TipoPasseio;

public class App {

    public static void main(String[] args) {
        System.out.println(JDBDCConnection.getConnection());

        // SALVAR
//        Modalidade modalidade = new Modalidade();
//        modalidade.setNome("caminhada tirando fotos");
//
//        new ModalidadeDAO().salvar(modalidade);

        //UPDATE
//        Modalidade modalidade = new Modalidade();
//        modalidade.setNome("Caminhada com fotos");
//        modalidade.setIdModalidade(9);
//
//        new ModalidadeDAO().atualizar(modalidade);

        //DELETE
//        Modalidade modalidade= new Modalidade();
//        modalidade.setIdModalidade(8);
//
//        new ModalidadeDAO().deletar(modalidade);

        //LISTAR TODOS
//        for (Modalidade modalidade : new ModalidadeDAO().listarTodos()) {
//            System.out.println(modalidade.toString());
//        }

        /** TIPO PASSEIO **/

        // SALVAR
//        TipoPasseio tipoPasseio = new TipoPasseio();
//        tipoPasseio.setNomePasseio("Semi - Privativo");
//        tipoPasseio.setDescricaoPasseio("Passeio somente para casal");
//
//        new TipoPasseioDAO().salvar(tipoPasseio);

        //UPDATE
//        TipoPasseio tipoPasseio = new TipoPasseio();
//        tipoPasseio.setIdTipoPasseio(3);
//        tipoPasseio.setNomePasseio("SemiPrivativo");
//        tipoPasseio.setDescricaoPasseio("Passeio somente para casal");
//
//        new TipoPasseioDAO().atualizar(tipoPasseio);
    }
}
