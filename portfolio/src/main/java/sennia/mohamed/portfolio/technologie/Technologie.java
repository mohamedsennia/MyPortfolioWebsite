package sennia.mohamed.portfolio.technologie;

import jakarta.persistence.*;

import sennia.mohamed.portfolio.project.Project;

import java.util.HashSet;
import java.util.Set;
@Entity
public class Technologie {
    @Id
    @SequenceGenerator(
            name = "Technologie_sequence",
            sequenceName = "Technologie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "Technologie_sequence"
    )
    private int id_technologie;
    private String name;
    private String icon;
    @ManyToMany(mappedBy = "technologies")
    private Set<Project> projects = new HashSet<>();

    public Technologie() {
    }

    public Technologie(int id_technologie, String name, String icon, Set<Project> projects) {
        this.id_technologie = id_technologie;
        this.name = name;
        this.icon = icon;
        this.projects = projects;
    }

    public int getId_technologie() {
        return id_technologie;
    }

    public void setId_technologie(int id_technologie) {
        this.id_technologie = id_technologie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }
}
