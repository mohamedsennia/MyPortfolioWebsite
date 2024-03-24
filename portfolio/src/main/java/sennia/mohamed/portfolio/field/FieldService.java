package sennia.mohamed.portfolio.field;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sennia.mohamed.portfolio.Mapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FieldService {
    private FieldRepository fieldRepository;
    private Mapper mapper;
    @Autowired

    public FieldService(FieldRepository fieldRepository,Mapper mapper) {
        this.fieldRepository = fieldRepository;
        this.mapper=mapper;
    }
    public int addField(FieldDTO fieldDTO){
     return   this.fieldRepository.save(this.mapper.toField(fieldDTO)).getField_id();
    }
    public List<FieldDTO> getFields(){
      return   this.fieldRepository.findAll().stream().map(mapper::toFieldDto).collect(Collectors.toList());
    }
   public FieldDTO getFieldById(int id){
       Optional<Field> field=this.fieldRepository.findById(id);
       return field.map(value -> mapper.toFieldDto(value)).orElse(null);
   }
    public  void deletField(FieldDTO fieldDTO){
        this.fieldRepository.delete(mapper.toField(fieldDTO));
    }
}
