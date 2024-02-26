package sennia.mohamed.portfolio.experience;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import sennia.mohamed.portfolio.project.Project;

import java.util.Date;
import java.util.List;

@Entity
public class Experience {
    @Id
    @SequenceGenerator(
            name = "Experience_sequence",
            sequenceName = "Experience_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            generator = "Experience_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int experience_id;
    @NotNull
    private String role;
    @NotNull
    private String company;
    @NotNull
    private Date startDate;
    private Date endDate;
    private String description;
    @OneToMany(mappedBy = "experience")
    private List<Project> projects;

    public Experience() {
    }

    public Experience(int experience_id, String role, String company, Date startDate, Date endDate, String description, List<Project> projects) {
        this.experience_id = experience_id;
        this.role = role;
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.projects = projects;
    }

    public int getExperience_id() {
        return experience_id;
    }

    public void setExperience_id(int experience_id) {
        this.experience_id = experience_id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
