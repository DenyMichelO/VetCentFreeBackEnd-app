package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao.ImagenDao;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.Imagen;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.imagenDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionImagenBl {
    @Autowired
    ImagenDao imagenDao;


    public int upload(MultipartFile file, imagenDto im){
        return imagenDao.upload(file,im);
    }

    public Imagen CrearImagen(Imagen imagen)throws SQLException {
        return imagenDao.CrearImagen(imagen);
    }
    public List<Imagen> SeleccionarTodasImagenes() throws SQLException {
        return imagenDao.SeleccionarTodasImagenes();
    }
    public Imagen SeleccionarImagen(Integer imagenId) throws SQLException {

        return imagenDao.SeleccionarImagen(imagenId);
    }
    public Imagen EliminarImagen(Integer imagenId) throws SQLException {

        return imagenDao.EliminarImagen(imagenId);
    }

    public Imagen ActualizarImagen(Imagen ob) throws SQLException {

        return imagenDao.ActualizarImagen(ob);
    }
}
