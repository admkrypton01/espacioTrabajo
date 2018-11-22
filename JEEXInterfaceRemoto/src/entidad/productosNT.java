package entidad;

import java.io.Serializable;

public class productosNT implements Serializable {
    private int codigo;
    private String descripcion;
    private String desmedida;
    private int codunidad;
    private String fechaingreso;
    private String estado;
    private double stock;
    private double precio;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDesmedida() {
        return desmedida;
    }

    public void setDesmedida(String desmedida) {
        this.desmedida = desmedida;
    }

    public int getCodunidad() {
        return codunidad;
    }

    public void setCodunidad(int codunidad) {
        this.codunidad = codunidad;
    }

    public String getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(String fechaingreso) {
        this.fechaingreso = fechaingreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getStock() {
        return stock;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    public productosNT(int _codigo, String _descripcion, int _codunidad, String _desmedida,
        String _fechaingreso, String _estado, double _stock, double _precio){    
        this.codigo = _codigo;
        this.descripcion = _descripcion;
        this.codunidad = _codunidad;
        this.desmedida = _desmedida;
        this.fechaingreso = _fechaingreso;
        this.estado = _estado;
        this.stock = _stock;
        this.precio = _precio;
    }
 
    public productosNT(){    }
}
