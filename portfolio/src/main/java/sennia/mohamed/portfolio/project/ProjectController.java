package sennia.mohamed.portfolio.project;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
    @RequestMapping("/api/projects")
public class ProjectController {
    private  ProjectService projectService;
    @Autowired

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping("/addProject")
    public void addProject(@RequestBody ProjectDTO projectDTO){
System.out.println("at controller "+projectDTO);
      this.projectService.addProject(projectDTO);
    }
    @GetMapping("/getProjects")
    public List<ProjectDTO> getProjects(){
   return this.projectService.getProjects();
    }
    @GetMapping("/getProjectsByType/{type}")
    public List<ProjectDTO> getProjectsByType(@PathVariable String type){
        return this.projectService.getProjectsByType(type);
    }
    @GetMapping("/filterProjects")
    public List<ProjectDTO>  filterProjects(@RequestParam Map<String,String> filters){
    return this.projectService.filterProjects(filters);

    }
    @GetMapping("/getProject/{id}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable int id){
        ProjectDTO projectDTO=this.projectService.getProject(id);
    if(projectDTO!=null){
        return new ResponseEntity<>(projectDTO, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @DeleteMapping("/deleteProject")
    public void deleteProject(@RequestBody ProjectDTO projectDTO){
    this.projectService.deleteProject(projectDTO);
    }
}
