package controlador;

import ejb.productosJBRemote;
import entidad.productosNT;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class productosSV extends HttpServlet {

    @EJB
    private productosJBRemote productosJB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            productosNT prsnlNT = new productosNT();
            List<productosNT> lstprsnl = new ArrayList<>();
            try{
                if(request.getParameter("btnInsertar")!=null){                    
                    prsnlNT.setCodigo(Integer.parseInt("0"));
                    prsnlNT.setDescripcion(request.getParameter("txtDesc"));
                    prsnlNT.setCodunidad(Integer.parseInt(request.getParameter("txtNdmd")));
                    prsnlNT.setFechaingreso(request.getParameter("txtFcng"));
                    prsnlNT.setEstado(request.getParameter("txtEsta"));
                    prsnlNT.setStock(Double.parseDouble(request.getParameter("txtStoc")));
                    prsnlNT.setPrecio(Double.parseDouble(request.getParameter("txtPrec")));
                    if(productosJB.insertar(prsnlNT))
                     response.sendRedirect("vistaProductos.jsp?mens=Se registro el Personal&&std=1");
                    else
                     response.sendRedirect("vistaProductos.jsp?mens=Error registrar Personal&&std=0");
                }else if(request.getParameter("btnActualizar")!=null){
                    prsnlNT.setCodigo(Integer.parseInt(request.getParameter("txtCodi")));
                    prsnlNT.setDescripcion(request.getParameter("txtDesc"));
                    prsnlNT.setCodunidad(Integer.parseInt(request.getParameter("txtNdmd")));
                    prsnlNT.setFechaingreso(request.getParameter("txtFcng"));
                    prsnlNT.setEstado(request.getParameter("txtEsta"));
                    prsnlNT.setStock(Double.parseDouble(request.getParameter("txtStoc")));
                    prsnlNT.setPrecio(Double.parseDouble(request.getParameter("txtPrec")));
                    if(productosJB.actualizar(prsnlNT))
                     response.sendRedirect("vistaProductos.jsp?mens=Se actualizo el producto&&std=1");
                    else
                     response.sendRedirect("vistaProductos.jsp?mens=Error actualizar el Producto&&std=0");
                }else if(request.getParameter("btnEliminar")!=null){
                    prsnlNT.setCodigo(Integer.parseInt(request.getParameter("txtCodi")));
                    if(productosJB.eliminar(prsnlNT))
                        response.sendRedirect("vistaProductos.jsp?mens=Se elimino el producto&&std=1");
                    else
                        response.sendRedirect("vistaProductos.jsp?mens=Error eliminar el Producto&&std=0");
                }
            } catch (Exception e){
                response.sendRedirect("vistaProductos.jsp?mens="+e.toString()+"&&std=0");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
