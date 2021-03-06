package AplicationService;

import Dominio.Entidades.Contato;
import Dominio.Enum.ETipoContato;
import Dominio.Interfaces.IContatoRepositorio;
import Infraestrutura.Postgre.DAO.ContatoDAO;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ContatoApl extends GenericApl<Contato> {

    //CONSTRUTORES
    public ContatoApl() {
        this.setDataDAO(new ContatoDAO());
    }

    //METODOS
    public List<Contato> getByType(ETipoContato type, int limit, int offset) {

        List<Contato> resultSearch = null;
        try {
            IContatoRepositorio currentDao = (IContatoRepositorio) this.getDataDAo();
            resultSearch = currentDao.obterTodosPorTipo(type, limit, offset);
        }
        catch (Exception erro) {
            resultSearch = null;
        }
        finally {
            return resultSearch;
        }
    }

    public List<Contato> getByUser(int idUser, int limit, int offset) {

        List<Contato> resultSearch = null;
        try {
            IContatoRepositorio currentDao = (IContatoRepositorio) this.getDataDAo();
            resultSearch = currentDao.obterTodosPorUsuario(idUser, limit, offset);
        }
        catch (Exception erro) {
            resultSearch = null;
        }
        finally {
            return resultSearch;
        }
    }

    public List<Contato> getByUserNType(int idUser, ETipoContato type, int limit, int offset) {

        List<Contato> resultSearch = null;
        try {
            IContatoRepositorio currentDao = (IContatoRepositorio) this.getDataDAo();
            resultSearch = currentDao.obterTodosPorTipoEUsuario(type, idUser, limit, offset);
        }
        catch (Exception erro) {
            resultSearch = null;
        }
        finally {
            return resultSearch;
        }
    }

    @Override
    public JSONObject parseDataToJSON(Contato data) {

        JSONObject jsonOutput = new JSONObject();
        jsonOutput.put("ID", data.getId());
        jsonOutput.put("FkUsuario", data.getFkUsuario());
        jsonOutput.put("TipoContato", data.getTipo().getNome());
        jsonOutput.put("Descricao", data.getDescricao());
        return jsonOutput;
    }

    @Override
    public List<JSONObject> parseListToJSONList(List<Contato> dataList) {

        List<JSONObject> listJSONOutput = new ArrayList<>();
        for(Contato contato : dataList) {
            listJSONOutput.add(this.parseDataToJSON(contato));
        }
        return listJSONOutput;
    }

}
