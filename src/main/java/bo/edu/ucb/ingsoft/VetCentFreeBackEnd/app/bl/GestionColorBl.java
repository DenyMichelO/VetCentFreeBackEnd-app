package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao.ColorDao;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.ColorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionColorBl {
    @Autowired
    ColorDao colorDao;

    public List<ColorDto> colores() throws SQLException {
        return colorDao.colores();
    }
}
