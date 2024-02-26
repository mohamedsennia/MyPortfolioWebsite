package sennia.mohamed.portfolio.education;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
public class Education {
    @Id
    @SequenceGenerator(
            name = "Education_sequence",
            sequenceName = "Education_sequence",
            allocationSize=1
    )
    @GeneratedValue(
            generator = "Education_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private int education_id;
    @NotNull
    private String degree;
    @NotNull
    private String school;
    @NotNull
    private Date startDate;
    private Date endDate;
    private  String description;
}
