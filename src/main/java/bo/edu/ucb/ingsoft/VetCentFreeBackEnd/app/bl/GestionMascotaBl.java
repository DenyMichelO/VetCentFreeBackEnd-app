package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dao.MascotaDao;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.MascotaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionMascotaBl {
    @Autowired
    MascotaDao mascotaDao;

    public MascotaDto Registrar(MascotaDto mascota) {
        return mascotaDao.registrar(mascota);
    }

}
