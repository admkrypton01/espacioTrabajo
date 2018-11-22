<%@page import="javax.naming.InitialContext"%>
<%@page import="java.util.*"%>
<%@page import="entidad.productosNT"%>
<%@page import="entidad.undmedidaNT"%>
<%@page import="ejb.productosJBRemote"%>
<%@page import="ejb.undmedidaJBRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mantenimiento de Productos</title>
        <script lang="JavaScript">
            function cargar(codi, desc, cdnd, fcng, esta, stoc, prec){
                document.frmProductos.txtCodi.value=codi;
                document.frmProductos.txtDesc.value=desc;
                document.frmProductos.txtFcng.value=fcng;
                document.frmProductos.txtStoc.value=stoc;
                document.frmProductos.txtPrec.value=prec;
                if (esta==="activo"){
                    document.frmProductos.txtEsta[0].checked = true;
                }
                else {
                    document.frmProductos.txtEsta[1].checked = true;
                }
                
                for ( var i = 0; i < document.frmProductos.txtNdmd.options.length; i++ ) {
                    if (document.frmProductos.txtNdmd.options[i].value == cdnd)
                    {
                        document.frmProductos.txtNdmd.options[i].selected=true;
                    }
                }
            }
        </script>
    </head>
    <%
        productosJBRemote productosJB;
        InitialContext initialContext1 = new InitialContext();
        productosJB = (productosJBRemote)initialContext1.lookup("java:global/JEEXAPP01/JEEXAPP01-ejb/productosJB");
        List<productosNT> prsnl = new ArrayList();
        
        undmedidaJBRemote undmedidaJB;
        InitialContext initialContext2 = new InitialContext();
        undmedidaJB = (undmedidaJBRemote)initialContext2.lookup("java:global/JEEXAPP01/JEEXAPP01-ejb/undmedidaJB");
        List<undmedidaNT> ndmdd = new ArrayList();
    %>
    <body>
        <form name="frmProductos" method="POST" action="productosSV">            
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
            <div>
                <label for="undmedida">Unidad Medida</label>
                <div>
                    <select name="txtNdmd">
                        <%  ndmdd = undmedidaJB.listarTodos();
                            for(undmedidaNT q:ndmdd){ %>
                        <option value="<%=q.getCodigo()%>"><%=q.getDescripcion()%></option>
                        <% } %>
                    </select>
                </div>
            </div>
            <div>
                <label for="fechaingreso">Fecha Ingreso</label>
                <div>
                    <input type="text" name="txtFcng"> (yyyy-mm-dd)
                </div>
            </div>                        
            <div>
                <label for="stock">Stock</label>
                <div>
                    <input type="text" name="txtStoc">
                </div>
            </div>
            <div>
                <label for="precios">Precios</label>
                <div>
                    <input type="text" name="txtPrec">
                </div>
            </div>
            <div>
                <label for="estado">Estado</label>
                <div>
                    <input type="radio" name="txtEsta" value="activo"> Activo<br>
                    <input type="radio" name="txtEsta" value="inactivo"> Inactivo<br>
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
                    out.println("<a href='vistaProductos.jsp'>"+request.getParameter("mens")+"</a><br>");
                }else if(request.getParameter("std").equals("0")){
                out.println("<a href='vistaProductos.jsp'>"+request.getParameter("mens")+"</a><br>");
                }
            }
        %>
        <br>
        <table border="1px">
            <tr> 
                <td>Codigo </td><td>Descripcion </td><td>CodUnd </td><td>UndMedida </td>
                <td>Fecha Ingreso </td><td>Stock </td><td>Precio </td><td>Estado </td><td>Accion </td>
            </tr>
            <%
                prsnl = productosJB.listarTodos();
                for(productosNT p:prsnl){
            %>
            <tr>
                <td align="right"><%=p.getCodigo()%> </td>
                <td><%=p.getDescripcion()%> </td>
                <td><%=p.getCodunidad()%> </td>
                <td><%=p.getDesmedida()%> </td>
                <td><%=p.getFechaingreso()%> </td>
                <td align="right"><%=p.getStock()%> </td>
                <td align="right"><%=p.getPrecio()%> </td>
                <td><%=p.getEstado()%> </td>
                <td><a href="javascript:void(0);" onclick="cargar(<%=p.getCodigo()%>,
                    '<%=p.getDescripcion()%>',<%=p.getCodunidad()%>,'<%=p.getFechaingreso()%>',
                    '<%=p.getEstado()%>',<%=p.getStock()%>,<%=p.getPrecio()%>)">Cargar</a></td>
            </tr>
            <% } %>
        </table>
        <hr>
        <a href='./index.html'>Regresar al Menu Principal</a>
        </center>        
    </body>
</html>
