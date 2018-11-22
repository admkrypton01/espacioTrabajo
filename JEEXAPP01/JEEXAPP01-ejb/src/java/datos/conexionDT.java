package datos;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexionDT {
    String strUrlbd,strUsrbd,strPasbd;
    Connection conConecta = null;

    public conexionDT() throws Exception{
        strUsrbd="root";
        strPasbd="passw0rd";
        strUrlbd="jdbc:mysql://localhost:3306/bdcloud";;
        //strUsrbd="bdcloud";
        //strPasbd="5B9V5j5W5o07dary";
        //strUrlbd="jdbc:mysql://node24547-env-4095905.jelastic.cloudhosted.es/bdcloud";
        try
        {   //Carga el driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
            //Obtiene la conexion;
            conConecta=DriverManager.getConnection(strUrlbd,strUsrbd,strPasbd);
            if (conConecta != null){
                System.out.println("Conectado...");
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public Connection obtenerConexion()
    { return conConecta; }

    public Connection cerrarConexion() throws Exception
    {
      try {
        System.out.println("Cerrado...");
        conConecta.close();
        conConecta = null;
        return conConecta;
      } catch (Exception e){
          throw e;
      }
    }    
}
