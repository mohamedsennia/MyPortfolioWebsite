package sennia.mohamed.portfolio.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import sennia.mohamed.portfolio.experience.Experience;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project,Integer> {

    public List<Project> findByType(ProjectType type);
    @Query("Select DISTINCT p from Project p JOIN p.technologies T JOIN p.fields F WHERE T.name in :technologies and F.fieldName in :fields")
    public List<Project>filterProjects(@Param("technologies")List<String> technologies, @Param("fields")List<String> fields);
    @Query("Select DISTINCT p from Project p JOIN p.technologies T JOIN p.fields F WHERE T.name in :technologies and F.fieldName in :fields and p.type= :type")
    public List<Project>filterProjectsWithType(@Param("technologies")List<String> technologies, @Param("fields")List<String> fields,@Param("type") ProjectType type);
}
