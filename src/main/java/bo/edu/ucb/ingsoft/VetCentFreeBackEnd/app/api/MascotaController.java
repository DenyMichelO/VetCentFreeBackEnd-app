package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.api;


import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl.GestionMascotaBl;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.MascotaDto;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MascotaController {
    @Autowired
    GestionMascotaBl gestionMascotaBl;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path= "/mascota")
    public ResponseDto Registrar(@RequestBody MascotaDto mascota) throws SQLException {
        System.out.println("ID DUEÑO : "+mascota.getDueno_id()+" id_color : "+mascota.getColor_id());
        MascotaDto mas = gestionMascotaBl.Registrar(mascota);
        if(mas.getNombre()==null|| mas.getNombre().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(mas.getTamano()==null|| mas.getTamano().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(mas.getEspecie_id() <=0 ){
            return new ResponseDto(false,null,null);
        }
        if(mas.getRaza_id() <=0 ){
            return new ResponseDto(false,null,null);
        }
        if(mas.getDueno_id() <=0 ){
            return new ResponseDto(false,null,null);
        }
        if(mas.getColor_id() <=0 ){
            return new ResponseDto(false,null,null);
        }
        if(mas.getGenero_id() <=0 ){
            return new ResponseDto(false,null,null);
        }

        return new ResponseDto(true,mas,"Registros de mascota exitoso");
    }
}
