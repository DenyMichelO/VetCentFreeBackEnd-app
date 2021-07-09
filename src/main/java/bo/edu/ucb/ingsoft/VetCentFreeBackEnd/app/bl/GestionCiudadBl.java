package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl;


import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao.CiudadDao;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.CiudadDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionCiudadBl {
    @Autowired
    CiudadDao ciudadDao;

    public List<CiudadDto> SelectAllCiudad() throws SQLException {
        return ciudadDao.SelectAllCiudad();
    }
}
