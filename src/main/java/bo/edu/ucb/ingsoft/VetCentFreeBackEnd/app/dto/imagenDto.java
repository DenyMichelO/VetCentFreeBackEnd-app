package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto;

public class imagenDto {
    private Integer imagen_id;
    private String nombre;
    private String src_imagen;
    public imagenDto(){

    }

    public imagenDto(String nombre, String src_imagen, String public_id) {
        this.nombre = nombre;
        this.src_imagen = src_imagen;
        this.public_id = public_id;
    }

    private String public_id;



    public String getPublic_id() {
        return public_id;
    }

    public void setPublic_id(String public_id) {
        this.public_id = public_id;
    }




    public Integer getImagen_id() {
        return imagen_id;
    }

    public void setImagen_id(Integer imagen_id) {
        this.imagen_id = imagen_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSrc_imagen() {
        return src_imagen;
    }

    public void setSrc_imagen(String src_imagen) {
        this.src_imagen = src_imagen;
    }
}
