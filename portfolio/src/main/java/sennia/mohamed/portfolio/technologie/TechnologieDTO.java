package sennia.mohamed.portfolio.technologie;

import jakarta.persistence.*;
import sennia.mohamed.portfolio.project.Project;

import java.util.HashSet;
import java.util.Set;

public class TechnologieDTO {

    private int id_technologie;
    private String name;
    private String icon;


    public TechnologieDTO() {
    }

    public TechnologieDTO(int id_technologie, String name, String icon) {
        this.id_technologie = id_technologie;
        this.name = name;
        this.icon = icon;

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


}
