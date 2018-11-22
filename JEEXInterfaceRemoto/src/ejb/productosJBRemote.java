package ejb;

import entidad.productosNT;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface productosJBRemote {
    boolean insertar(productosNT prsnlNT) throws Exception;
    boolean actualizar(productosNT prsnlNT) throws Exception;
    boolean eliminar(productosNT prsnlNT) throws Exception;
    List<productosNT> listarTodos() throws Exception;
}
