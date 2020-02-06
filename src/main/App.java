import DAO.ModalidadeDAO;
import DAO.PaisDAO;
import DAO.TipoPasseioDAO;
import DAO.ViajanteDAO;
import connection.JDBDCConnection;
import domain.Modalidade;
import domain.Pais;
import domain.TipoPasseio;
import domain.Viajante;

import java.util.Date;

public class App {

    public static void main(String[] args) {
        System.out.println(JDBDCConnection.getConnection());

        /** MODALIDADE **/

        // SALVAR
//        new ModalidadeDAO().salvar(new Modalidade(null,"corrida com fotos"));

        //UPDATE
//        new ModalidadeDAO().atualizar(new Modalidade(8, "Caminhada com fotos"));

        //DELETE
//        new ModalidadeDAO().deletar(new Modalidade(8, null));

        //LISTAR
//        for (Modalidade modalidade : new ModalidadeDAO().listarTodos()) {
//            System.out.println(modalidade.toString());
//        }

        /** Tipo Passeio **/

        // SALVAR
//        new TipoPasseioDAO().salvar(new TipoPasseio(null, "semi - testando", "teste"));

        //UPDATE
//        new TipoPasseioDAO().atualizar(new TipoPasseio(5, "semiprivativo", "Passeio para casal"));

        //DELETAR
//        new TipoPasseioDAO().deletar(new TipoPasseio(5));

        //LISTAR
//        for (TipoPasseio tipoPasseio : new TipoPasseioDAO().listarTodos()) {
//            System.out.println(tipoPasseio.toString());
//        }

        /** PAÍS **/

        // SALVAR
//        new PaisDAO().salvar(new Pais(null, "Grécia"));

        //UPDATE
//        new PaisDAO().atualizar(new Pais(4, "Itália"));

        //DELETAR
//        new PaisDAO().deletar(new Pais(4, null));

        //LISTAR
//        for (Pais pais : new PaisDAO().listarTodos()) {
//            System.out.println(pais.toString());
//        }

        /** VIAJANTE **/

        // SALVAR
//        new ViajanteDAO().salvar(
//                new Viajante(
//                        null,
//                        "paulão",
//                        "936434323",
//                        java.sql.Date.valueOf("2001-01-10")
//                )
//        );

        //UPDATE
//        new ViajanteDAO().atualizar(
//                new Viajante(
//                    3,
//                    "paulinho",
//                    "000000",
//                    java.sql.Date.valueOf("2010-02-08")
//                )
//        );

        //DELETAR
//        new ViajanteDAO().deletar(new Viajante(7));

        //LISTAR
//        for (Viajante viajante : new ViajanteDAO().listarTodos()) {
//            System.out.println(viajante.toString());
//        }

    }
}
