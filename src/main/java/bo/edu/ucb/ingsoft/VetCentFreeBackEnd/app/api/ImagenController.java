package bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.api;

import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.bl.GestionImagenBl;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.dto.imagenDto;
import bo.edu.ucb.ingsoft.VetCentFreeBackEnd.app.service.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ImagenController {

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    private GestionImagenBl gestionImagenBl;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/upload")
    public ResponseEntity<Integer> uploadFiles(@RequestParam("files")MultipartFile files) {
        System.out.println("ESTOY AQUI");
        int x=0;
        if(files==null){
            return new ResponseEntity(x, HttpStatus.BAD_REQUEST);
        }
        try {
            Map result = cloudinaryService.upload(files);
            imagenDto imagen = new imagenDto((String) result.get("original_filename"),
                    (String) result.get("url"),
                    (String) result.get("public_id"));
            x = gestionImagenBl.upload(files, imagen);
        }catch(Exception ex ){
            x=0;
        }

        return new ResponseEntity(x, HttpStatus.OK);
    }


}
