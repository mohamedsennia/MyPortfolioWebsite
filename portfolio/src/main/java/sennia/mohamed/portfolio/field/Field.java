package sennia.mohamed.portfolio.field;

import jakarta.persistence.*;
import sennia.mohamed.portfolio.project.Project;

import java.util.Set;

@Entity

public class Field {
    @Id
    @SequenceGenerator(name = "Field_squence",
    sequenceName = "Field_squence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Field_squence"
    )
    private int field_id;
    private String fieldName;
    @ManyToMany(mappedBy = "fields")
    private Set<Project> projects;

    public Field() {
    }

    public Field(int field_id, String fieldName, Set<Project> projects) {
        this.field_id = field_id;
        this.fieldName = fieldName;
        this.projects = projects;
    }

    public int getField_id() {
        return field_id;
    }

    public void setField_id(int field_id) {
        this.field_id = field_id;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
