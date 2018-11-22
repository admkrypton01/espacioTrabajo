package datos;
import entidad.productosNT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class productosDT {
    public boolean insertar(productosNT prsnlNT) throws Exception{
        int intRpt=0;
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();        
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("insert into productos"
                    + "(codigo,descripcion,codunidad,fechaingreso,estado,stock,precio) "
                    + "values(?,?,?,?,?,?,?)");
            ps.setInt(1,ultimoCodigo(cnnConexion)+1);
            ps.setString(2,prsnlNT.getDescripcion());
            ps.setInt(3,prsnlNT.getCodunidad());
            ps.setDate(4,java.sql.Date.valueOf(prsnlNT.getFechaingreso()));
            ps.setString(5,prsnlNT.getEstado());
            ps.setDouble(6,prsnlNT.getStock());
            ps.setDouble(7,prsnlNT.getPrecio());
            intRpt=ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return intRpt>=1?true:false;
    }

    public boolean actualizar(productosNT prsnlNT) throws Exception{
        int intRpt=0;
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("update productos set "
                    + "descripcion=?,codunidad=?,fechaingreso=?,"
                    + "estado=?,stock=?,precio=? where codigo=?");
            ps.setString(1,prsnlNT.getDescripcion());
            ps.setInt(2,prsnlNT.getCodunidad());
            ps.setDate(3,java.sql.Date.valueOf(prsnlNT.getFechaingreso()));
            ps.setString(4,prsnlNT.getEstado());
            ps.setDouble(5,prsnlNT.getStock());
            ps.setDouble(6,prsnlNT.getPrecio());
            ps.setInt(7,prsnlNT.getCodigo());
            intRpt=ps.executeUpdate();
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return intRpt>=1?true:false;
    }
    
    public boolean eliminar(productosNT prsnlNT) throws Exception{
        int intRpt=0;
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("delete from productos "
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

    public List<productosNT> listarTodos() throws Exception{
        Connection cnnConexion=null;
        conexionDT cnnDao=new conexionDT();
        cnnConexion=cnnDao.obtenerConexion();
        List<productosNT> lstTodos = new ArrayList<>();
        try{
            PreparedStatement ps=cnnConexion.prepareStatement("select a.codigo,a.descripcion,a.codunidad,b.descripcion as desmedida, "
                    + "a.fechaingreso,a.estado,a.stock,a.precio from productos a, undmedida b where a.codunidad=b.codigo order by a.codigo");
            ResultSet rslListado = ps.executeQuery();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            while(rslListado.next()){
                lstTodos.add(new productosNT(rslListado.getInt("codigo"),
                rslListado.getString("descripcion"),
                rslListado.getInt("codunidad"),
                rslListado.getString("desmedida"),
                simpleDateFormat.format(rslListado.getDate("fechaingreso")),
                rslListado.getString("estado"),
                rslListado.getDouble("stock"),
                rslListado.getDouble("precio")));
            }
        }catch(Exception e){
            throw e;
        } finally {
            cnnDao.cerrarConexion();
        }
        return lstTodos;
    }     

    public int ultimoCodigo(Connection _cnnConexion) throws Exception{
        int _codigo = 0;
        try{
            PreparedStatement ps=_cnnConexion.prepareStatement("select * from productos "
                    + "order by codigo desc");
            ResultSet rslListado = ps.executeQuery();
            if(rslListado.next()){
                _codigo = rslListado.getInt("codigo");
            }
        }catch(Exception e){
            throw e;
        }
        return _codigo;
    }     
}
