package sennia.mohamed.portfolio.experience;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sennia.mohamed.portfolio.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ExperienceService {
    private ExperienceRepository experienceRepository;
    private Mapper mapper;
    @Autowired

    public ExperienceService(ExperienceRepository experienceRepository,Mapper mapper) {
        this.experienceRepository = experienceRepository;
        this.mapper=mapper;
    }
    public  int addExperience(ExperienceDTO experienceDTO){
     return this.experienceRepository.save(this.mapper.toExp(experienceDTO)).getExperience_id();
    }
    public List<ExperienceDTO> getExperiences(){
        return this.experienceRepository.findAll().stream().map(mapper::toExpDto).collect(Collectors.toList());
    }
    public ExperienceDTO getExperience(int id){
        Optional<Experience> experience=this.experienceRepository.findById(id);
        return experience.map((value)->mapper.toExpDto(value)).orElse(null);
    }
    public  void  deleteExperience(ExperienceDTO experienceDTO){
        this.experienceRepository.delete(mapper.toExp(experienceDTO));
    }
}
