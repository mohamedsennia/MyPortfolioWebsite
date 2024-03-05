package sennia.mohamed.portfolio.project;



import sennia.mohamed.portfolio.experience.Experience;
import sennia.mohamed.portfolio.field.Field;
import sennia.mohamed.portfolio.field.FieldDTO;
import sennia.mohamed.portfolio.technologie.Technologie;
import sennia.mohamed.portfolio.technologie.TechnologieDTO;

import java.util.List;
import java.util.Set;

public class ProjectDTO {
    private int id_project;
    private  String name;//
    private  String description;

    private List<String> images;

    private  String codeURL;
    private String demoURL;
    private ProjectType type;
    private Set<FieldDTO> fields;
    private Set<TechnologieDTO> technologies;
    private int idExperience;

    public ProjectDTO() {
    }

    public ProjectDTO(int id_project, String name, String description, List<String> images, String codeURL, String demoURL, ProjectType type, Set<FieldDTO> fields, Set<TechnologieDTO> technologies, int idExperience) {
        this.id_project = id_project;
        this.name = name;
        this.description = description;
        this.images = images;
        this.codeURL = codeURL;
        this.demoURL = demoURL;
        this.type = type;
        this.fields = fields;
        this.technologies = technologies;
        this.idExperience = idExperience;
    }

    public int getId_project() {
        return id_project;
    }

    public void setId_project(int id_project) {
        this.id_project = id_project;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getCodeURL() {
        return codeURL;
    }

    public void setCodeURL(String codeURL) {
        this.codeURL = codeURL;
    }

    public String getDemoURL() {
        return demoURL;
    }

    public void setDemoURL(String demoURL) {
        this.demoURL = demoURL;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public Set<FieldDTO> getFields() {
        return fields;
    }

    public void setFields(Set<FieldDTO> fields) {
        this.fields = fields;
    }


    public int getIdExperience() {
        return idExperience;
    }

    public void setIdExperience(int idExperience) {
        this.idExperience = idExperience;
    }

    public Set<TechnologieDTO> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<TechnologieDTO> technologies) {
        this.technologies = technologies;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "id_project=" + id_project +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", codeURL='" + codeURL + '\'' +
                ", demoURL='" + demoURL + '\'' +
                ", type=" + type +
                ", fields=" + fields +
                ", technologies=" + technologies +
                ", idExperience=" + idExperience +
                '}';
    }
}
