package sennia.mohamed.portfolio.experience;



import sennia.mohamed.portfolio.project.Project;
import sennia.mohamed.portfolio.project.ProjectDTO;

import java.util.Date;
import java.util.List;

public class ExperienceDTO {
    private int experience_id;

    private String role;

    private String company;

    private Date startDate;
    private Date endDate;
    private String description;
    private List<ProjectDTO> projects;

    public ExperienceDTO(int experience_id, String role, String company, Date startDate, Date endDate, String description, List<ProjectDTO> projects) {
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

    public List<ProjectDTO> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }
}
