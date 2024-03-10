package sennia.mohamed.portfolio.technologie;
import sennia.mohamed.portfolio.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TechnologieService {
    private TechnologieRepository technologieRepository;
    private Mapper mapper;
    @Autowired
 public TechnologieService(TechnologieRepository technologieRepository,Mapper mapper){
     this.technologieRepository=technologieRepository;
     this.mapper=mapper;

 }
 public int addTechnologie(TechnologieDTO technologie){
     return this.technologieRepository.save(this.mapper.toTech(technologie)).getId_technologie();
 }
public List<TechnologieDTO> getTechnologies(){
      return   this.technologieRepository.findAll().stream().map(mapper::toTechDto).collect(Collectors.toList());
}
public TechnologieDTO getTechnologieByID(int id){
    Optional<Technologie> technologie=this.technologieRepository.findById(id);
        if (technologie.isPresent()){
            return this.mapper.toTechDto(technologie.get());
        }else {
            return  null;
        }

}
public void deleteTechnologie (TechnologieDTO technologieDTO){
        this.technologieRepository.delete(this.mapper.toTech(technologieDTO));
}
}
