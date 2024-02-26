package sennia.mohamed.portfolio.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Field")
public class FieldController {
    private FieldService fieldService;
    @Autowired

    public FieldController(FieldService fieldService) {
        this.fieldService = fieldService;
    }
        @PostMapping("/addField")
    public void addField(@RequestBody FieldDTO fieldDTO){
    this.fieldService.addField(fieldDTO);
    }
    @GetMapping("/getFields")
    public List<FieldDTO> getFields(){
        return this.fieldService.getFields();
    }
    @GetMapping("getField/{id}")
    public ResponseEntity<FieldDTO> getField(@PathVariable int id){
        FieldDTO fieldDTO=this.fieldService.getFieldById(id);
        if(fieldDTO!=null){
            return new ResponseEntity<>(fieldDTO, HttpStatus.OK);
        }
        else{
            return   new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("deleteField")
    public void deleteField(@RequestBody FieldDTO fieldDTO){
        this.fieldService.deletField(fieldDTO);

    }
}
