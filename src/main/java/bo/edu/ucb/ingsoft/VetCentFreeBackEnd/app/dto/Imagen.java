package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto;

public class Imagen {
    private  Integer imagen_id;
    private String src_imagen;
    private String nombre;

    public Integer getImagen_id() {
        return imagen_id;
    }

    public void setImagen_id(Integer imagen_id) {
        this.imagen_id = imagen_id;
    }

    public String getSrc_imagen() {
        return src_imagen;
    }

    public void setSrc_imagen(String src_imagen) {
        this.src_imagen = src_imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
