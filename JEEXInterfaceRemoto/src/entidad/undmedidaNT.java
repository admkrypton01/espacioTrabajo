package entidad;

import java.io.Serializable;

public class undmedidaNT implements Serializable{
    private int codigo;
    private String descripcion;

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
    
    public undmedidaNT(int _codigo, String _descripcion){
        this.codigo = _codigo;
        this.descripcion = _descripcion;
    }

    public undmedidaNT(){
    }
}
