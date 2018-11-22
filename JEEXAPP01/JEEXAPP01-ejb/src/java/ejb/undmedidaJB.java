package ejb;

import datos.undmedidaDT;
import entidad.undmedidaNT;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class undmedidaJB implements undmedidaJBRemote {
    public boolean insertar(undmedidaNT prsnlNT) throws Exception{
        undmedidaDT prsnlDT = new undmedidaDT();
        try{
            return prsnlDT.insertar(prsnlNT);
        } catch(Exception e) {
            throw e;
        }
    }
    
    public boolean actualizar(undmedidaNT prsnlNT) throws Exception{
        undmedidaDT prsnlDT = new undmedidaDT();
        try{
            return prsnlDT.actualizar(prsnlNT);
        } catch(Exception e) {
            throw e;
        }        
    }
    
    public boolean eliminar(undmedidaNT prsnlNT) throws Exception{
        undmedidaDT prsnlDT = new undmedidaDT();
        try{
            return prsnlDT.eliminar(prsnlNT);
        } catch(Exception e) {
            throw e;
        }        
    }
    
    public List<undmedidaNT> listarTodos() throws Exception{
        undmedidaDT prsnlDT = new undmedidaDT();
        try{
            return prsnlDT.listarTodos();
        } catch(Exception e) {
            throw e;
        }        
    }    
}
