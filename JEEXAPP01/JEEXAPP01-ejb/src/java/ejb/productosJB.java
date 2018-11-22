package ejb;

import datos.productosDT;
import entidad.productosNT;
import java.util.List;
import javax.ejb.Stateless;

import javax.ejb.Stateless;

@Stateless
public class productosJB implements productosJBRemote {
    public boolean insertar(productosNT prsnlNT) throws Exception{
        productosDT prsnlDT = new productosDT();
        try{
            return prsnlDT.insertar(prsnlNT);
        } catch(Exception e) {
            throw e;
        }
    }
    
    public boolean actualizar(productosNT prsnlNT) throws Exception{
        productosDT prsnlDT = new productosDT();
        try{
            return prsnlDT.actualizar(prsnlNT);
        } catch(Exception e) {
            throw e;
        }        
    }
    
    public boolean eliminar(productosNT prsnlNT) throws Exception{
        productosDT prsnlDT = new productosDT();
        try{
            return prsnlDT.eliminar(prsnlNT);
        } catch(Exception e) {
            throw e;
        }        
    }
    
    public List<productosNT> listarTodos() throws Exception{
        productosDT prsnlDT = new productosDT();
        try{
            return prsnlDT.listarTodos();
        } catch(Exception e) {
            throw e;
        }        
    }    
}
