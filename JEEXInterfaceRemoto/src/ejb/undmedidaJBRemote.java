package ejb;

import entidad.undmedidaNT;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface undmedidaJBRemote {
    boolean insertar(undmedidaNT prsnlNT) throws Exception;
    boolean actualizar(undmedidaNT prsnlNT) throws Exception;
    boolean eliminar(undmedidaNT prsnlNT) throws Exception;
    List<undmedidaNT> listarTodos() throws Exception;    
}
