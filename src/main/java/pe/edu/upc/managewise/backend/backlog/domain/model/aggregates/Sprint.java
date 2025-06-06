package pe.edu.upc.managewise.backend.backlog.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.managewise.backend.backlog.domain.model.commands.CreateSprintCommand;
import pe.edu.upc.managewise.backend.backlog.domain.model.valueobjects.SprintStatus;
import pe.edu.upc.managewise.backend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;

@Getter
@Entity
public class Sprint extends AuditableAbstractAggregateRoot<Sprint> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String title;
    private String goal;
    private Date startDate;
    private Date endDate;
    private SprintStatus status;

    public Sprint(Long userId, String title, String goal, Date endDate) {
        this.userId = userId;
        this.title = title;
        this.goal = goal;
        this.startDate = new Date();
        this.endDate = endDate;
        this.status = SprintStatus.STARTED;
    }

    public Sprint() {
    }

    public Sprint(CreateSprintCommand command){
        this();
        this.userId = command.userId();
        this.title = command.title();
        this.goal = command.goal();
        this.status = SprintStatus.STARTED;
        this.startDate = new Date();
        this.endDate = command.endDate();
    }

    public Sprint updateInformation(String title, String goal, SprintStatus status) {
        this.title = title;
        this.goal = goal;
        this.status = status;
        return this;
    }

}
