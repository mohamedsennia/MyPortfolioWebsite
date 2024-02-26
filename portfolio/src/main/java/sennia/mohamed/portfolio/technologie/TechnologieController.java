package sennia.mohamed.portfolio.technologie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/Technologies")
public class TechnologieController {
    private  TechnologieService technologieService;
    @Autowired
    public TechnologieController (TechnologieService technologieService){
        this.technologieService=technologieService;
    }
    @PostMapping("/addTechnologie")
    public void addTechnologie(@RequestBody TechnologieDTO technologieDTO){
        this.technologieService.addTechnologie(technologieDTO);
    }
    @PutMapping("/updateTechnologie")
    public  void updateTechnologie(@RequestBody TechnologieDTO technologieDTO){
        this.technologieService.addTechnologie(technologieDTO);
    }
    @GetMapping("/getTechnologies")
    public List<TechnologieDTO> getTechnologies(){
        return this.technologieService.getTechnologies();
    }
    @GetMapping("/getTechnologie/{id}")
    public ResponseEntity<TechnologieDTO> getTechnologieById(@PathVariable int id){
        TechnologieDTO technologieDTO=this.technologieService.getTechnologieByID(id);
       if(technologieDTO!=null){
           return new ResponseEntity<>(technologieDTO, HttpStatus.OK);

       }else{
            return   new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }
    @DeleteMapping("/deleteTechnologie")
    public void deleteTechnologie(@RequestBody TechnologieDTO technologieDTO){
        this.technologieService.deleteTechnologie(technologieDTO);
    }

}
