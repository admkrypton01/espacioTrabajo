<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.*"%>
<%@page import="entidad.undmedidaNT"%>
<%@page import="ejb.undmedidaJBRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento del Unidad Medida</title>
        <script lang="JavaScript">
            function cargar(codi, desc){
                document.frmundmedida.txtCodi.value=codi;
                document.frmundmedida.txtDesc.value=desc;
            }
        </script>
    </head>
    <body>
    <%
        undmedidaJBRemote undmedidaJB;
        InitialContext initialContext = new InitialContext();
        undmedidaJB = (undmedidaJBRemote)initialContext.lookup("java:global/JEEXAPP01/JEEXAPP01-ejb/undmedidaJB");
        //personalDT prsnlDT = new personalDT();
        List<undmedidaNT> prsnl = new ArrayList();
    %>    
    <body>
        <form name="frmundmedida" method="POST" action="undmedidaSV">
            <div>
                <label for="codigo">Codigo</label>
                <div>
                    <input type="text" name="txtCodi" readonly>
                </div>
            </div>
            <div>
                <label for="descripcion">Descripcion</label>
                <div>
                    <input type="text" name="txtDesc">
                </div>
            </div>
            <br>
            <input type="submit" name="btnInsertar" value="Insertar">
            <input type="submit" name="btnActualizar" value="Actualizar">
            <input type="submit" name="btnEliminar" value="Eliminar">
        </form>
        <br>
        <hr><center>
        <br>
        <%
             if(request.getParameter("std")!=null){
                 if(request.getParameter("std").equals("1")){
                    out.println("<a href='vistaUndMedida.jsp'>"+request.getParameter("mens")+"</a><br>");
                }else if(request.getParameter("std").equals("0")){
                out.println("<a href='vistaUndMedida.jsp'>"+request.getParameter("mens")+"</a><br>");
                }
            }
        %>
        <br>
        <table border="1px">
            <tr> 
                <td>Codigo </td><td>Descripcion </td>
            </tr>
            <%
                prsnl = undmedidaJB.listarTodos();
                for(undmedidaNT p:prsnl){
            %>
            <tr>
                <td align="right"><%=p.getCodigo()%> </td>
                <td><%=p.getDescripcion()%> </td>
                <td><a href="javascript:void(0);" onclick="cargar(<%=p.getCodigo()%>,
                    '<%=p.getDescripcion()%>')">Cargar</a></td>
            </tr>
            <% } %>
        </table>
        <hr>
        <a href='./index.html'>Regresar al Menu Principal</a>        
        </center>        
    </body>
</html>
