package sennia.mohamed.portfolio.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationSerivce {
    private EducationRepository educationRepository;
    @Autowired

    public EducationSerivce(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }
    public int addEducation(Education education) {
      return   (this.educationRepository.save(education)).getEducation_id();
    }
    public List<Education> getEducations(){
      return   this.educationRepository.findAll();
    }
    public Education getEducation(int id){
        return this.educationRepository.findById(id).orElse(null);
    }
    public void deleteEducation(Education education){
        this.educationRepository.delete(education);
    }
}
