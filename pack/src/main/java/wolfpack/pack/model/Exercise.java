package wolfpack.pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Exercise {
    public Exercise() {}

    public Exercise(String name, String[] muscles, String tutorial) {
        this.name = name;
        this.muscles = muscles;
        this.tutorial = tutorial;
    }
    @Id
    @Column
    private String name;
    @Column
    private String[] muscles;
    @Column
    private String tutorial;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getMuscles() {
        return muscles;
    }

    public void setMuscles(String[] muscles) {
        this.muscles = muscles;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }



}
