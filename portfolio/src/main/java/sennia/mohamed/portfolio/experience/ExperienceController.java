package sennia.mohamed.portfolio.experience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    @RequestMapping("/api/Experience")
public class ExperienceController {
    private ExperienceService experienceService;
    @Autowired

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }
    @PostMapping("/addExperience")
    public void addExperience(@RequestBody ExperienceDTO experienceDTO){
    this.experienceService.addExperience(experienceDTO);
    }
    @GetMapping("/getExperiences")
    public List<ExperienceDTO> getExperiences() {
    return this.experienceService.getExperiences();
    }
    @GetMapping("/getExperience/{id}")
    public ResponseEntity<ExperienceDTO> getExperience(@PathVariable int id){
        ExperienceDTO experienceDTO=this.experienceService.getExperience(id);
    if(experienceDTO!=null){
    return new ResponseEntity<>(experienceDTO, HttpStatus.OK);
    }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    }
    @DeleteMapping("/deleteExperience")
    public void deleteExperience(ExperienceDTO experienceDTO){
    this.experienceService.deleteExperience(experienceDTO);
    }
}
