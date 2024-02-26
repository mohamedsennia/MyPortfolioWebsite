package sennia.mohamed.portfolio;

import org.springframework.stereotype.Component;
import sennia.mohamed.portfolio.experience.Experience;
import sennia.mohamed.portfolio.experience.ExperienceDTO;
import sennia.mohamed.portfolio.field.Field;
import sennia.mohamed.portfolio.field.FieldDTO;
import sennia.mohamed.portfolio.project.Project;
import sennia.mohamed.portfolio.project.ProjectDTO;
import sennia.mohamed.portfolio.technologie.Technologie;
import sennia.mohamed.portfolio.technologie.TechnologieDTO;

import java.util.HashSet;
import java.util.stream.Collectors;

@Component
public class Mapper {
    public TechnologieDTO toTechDto(Technologie technologie){
        if(technologie==null){return null;}
        return  new TechnologieDTO(technologie.getId_technologie(),technologie.getName(),technologie.getIcon());
    }
    public Technologie toTech(TechnologieDTO technologieDTO){
        if(technologieDTO==null){return null;}
        return  new Technologie(technologieDTO.getId_technologie(),technologieDTO.getName(),technologieDTO.getIcon(),new HashSet<Project>());
    }
    /**/
    public Field toField(FieldDTO fieldDTO){
        if(fieldDTO==null){return null;}
        return new Field(fieldDTO.getField_id(),fieldDTO.getFieldName(),new HashSet<>());
    }
    public FieldDTO toFieldDto(Field field){
        if(field==null){return null;}

        return new FieldDTO(field.getField_id(), field.getFieldName());
    }
    public Project toProject(ProjectDTO projectDTO){
        if(projectDTO==null){return null;}
    return new Project(projectDTO.getId_project(), projectDTO.getName(), projectDTO.getDescription(), projectDTO.getImages(), projectDTO.getCodeURL(), projectDTO.getDemoURL(), projectDTO.getType(),projectDTO.getTechnologies().stream().map(this::toTech).collect(Collectors.toSet()),projectDTO.getFields().stream().map(this::toField).collect(Collectors.toSet()), null);
    }
    public  ProjectDTO toProjectDto(Project project){
        if(project==null){return null;}
        int idExp= 0;
        if( project.getExperience()!=null){
            idExp = project.getExperience().getExperience_id();
        }

    return new ProjectDTO(project.getId_project(), project.getName(), project.getDescription(), project.getImages(), project.getCodeURL(), project.getDemoURL(), project.getType(),project.getFields().stream().map(this::toFieldDto).collect(Collectors.toSet()), project.getTechnologies().stream().map(this::toTechDto).collect(Collectors.toSet()),idExp );
    }
    public ExperienceDTO toExpDto(Experience experience){
        if(experience==null){return null;}
        return  new ExperienceDTO(experience.getExperience_id(),experience.getRole(),experience.getCompany(),experience.getStartDate(),experience.getEndDate(),experience.getDescription(),experience.getProjects().stream().map(this::toProjectDto).collect(Collectors.toList()));
    }
    public Experience toExp(ExperienceDTO experienceDTO){
       if(experienceDTO==null){return null;}
        return new Experience(experienceDTO.getExperience_id(), experienceDTO.getRole(), experienceDTO.getCompany(), experienceDTO.getStartDate(),experienceDTO.getEndDate(),experienceDTO.getDescription(),experienceDTO.getProjects().stream().map(this::toProject).collect(Collectors.toList()));
    }
}
