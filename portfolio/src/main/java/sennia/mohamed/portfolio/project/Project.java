package sennia.mohamed.portfolio.project;

import jakarta.persistence.*;

import sennia.mohamed.portfolio.experience.Experience;
import sennia.mohamed.portfolio.field.Field;
import sennia.mohamed.portfolio.technologie.Technologie;

import java.util.HashSet;

import java.util.List;
import java.util.Set;
@Entity
public class Project {
    @Id
    @SequenceGenerator(
            name = "Project_sequence",
            sequenceName = "Project_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Project_sequence"
    )
    private int id_project;
    private  String name;
    private  String description;
    @ElementCollection
    private List<String> images;

    private  String codeURL;
    private String demoURL;
    private ProjectType type;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="uses-tech",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_technologie")
              )

    private Set<Technologie> technologies;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "has_field",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "field_id")

    )
    private Set<Field> fields;
    @ManyToOne
    @JoinColumn(name = "experience_id")

    private Experience experience;

    public Project() {
    }

    public Project(int id_project, String name, String description, List<String> images, String codeURL, String demoURL, ProjectType type, Set<Technologie> technologies, Set<Field> fields, Experience experience) {
        this.id_project = id_project;
        this.name = name;
        this.description = description;
        this.images = images;
        this.codeURL = codeURL;
        this.demoURL = demoURL;
        this.type = type;
        this.technologies = technologies;
        this.fields = fields;
        this.experience = experience;
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

    public Set<Technologie> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Set<Technologie> technologies) {
        this.technologies = technologies;
    }

    public ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = type;
    }

    public Set<Field> getFields() {
        return fields;
    }

    public void setFields(Set<Field> fields) {
        this.fields = fields;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id_project=" + id_project +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                ", codeURL='" + codeURL + '\'' +
                ", demoURL='" + demoURL + '\'' +
                ", type=" + type +
                ", technologies=" + technologies +
                ", fields=" + fields +
                ", experience=" + experience +
                '}';
    }
}
