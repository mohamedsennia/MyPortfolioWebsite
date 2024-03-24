package sennia.mohamed.portfolio.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(
        origins = {
                "http://localhost:4200",

        },
        methods = {
                RequestMethod.OPTIONS,
                RequestMethod.GET,
                RequestMethod.PUT,
                RequestMethod.DELETE,
                RequestMethod.POST
        })
@RestController
@RequestMapping("api/Education")

public class EducationController {
    private EducationSerivce educationSerivce;
@Autowired
    public EducationController(EducationSerivce educationSerivce) {
        this.educationSerivce = educationSerivce;
    }
    @PostMapping("/addEducation")
    public  int  addEducation(@RequestBody Education education) {

  return   this.educationSerivce.addEducation(education);
    }
    @GetMapping("/getEducations")
    public List<Education> getEducations(){
    return this.educationSerivce.getEducations();
    }
    @GetMapping("/getEducation/{id}")
    public ResponseEntity<Education> getEducation(@PathVariable int id){
    Education education=this.educationSerivce.getEducation(id);
    if(education!=null){
        return new ResponseEntity<>(education, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/deleteEducation")
    public void deleteEducation(@RequestBody Education education){
    this.educationSerivce.deleteEducation(education);
    }

}
