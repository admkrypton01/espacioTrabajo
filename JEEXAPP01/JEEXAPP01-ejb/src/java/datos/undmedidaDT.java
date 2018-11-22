package datos;

import entidad.undmedidaNT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class undmedidaDT {
    public boolean insertar(undmedidaNT prsnlNT) throws Exception{
        int intRpt=0;
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();        
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("insert into undmedida"
                    + "(codigo,descripcion) "
                    + "values(((select nvl(max(codigo),0) as codigo from undmedida)+1),"
                    + "?)");
            ps.setString(1,prsnlNT.getDescripcion());
            intRpt=ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return intRpt>=1?true:false;
    }

    public boolean actualizar(undmedidaNT prsnlNT) throws Exception{
        int intRpt=0;
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("update undmedida set "
                    + "descripcion=? where codigo=?");
            ps.setString(1,prsnlNT.getDescripcion());
            ps.setInt(2,prsnlNT.getCodigo());
            intRpt=ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return intRpt>=1?true:false;
    }
    
    public boolean eliminar(undmedidaNT prsnlNT) throws Exception{
        int intRpt=0;
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("delete from undmedida "
                    + "where codigo=?");
            ps.setInt(1,prsnlNT.getCodigo());
            intRpt=ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return intRpt>=1?true:false;
    }

    public List<undmedidaNT> listarTodos() throws Exception{
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();
        List<undmedidaNT> lstTodos = new ArrayList<>();
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("select * from undmedida "
                    + "order by codigo");
            ResultSet rslListado = ps.executeQuery();
            while(rslListado.next()){
                lstTodos.add(new undmedidaNT(rslListado.getInt("codigo"),
                rslListado.getString("descripcion")));
            }
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return lstTodos;
    }         
}
