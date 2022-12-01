package wolfpack.pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class User {
    @Id
    private String email;
    @Column
    private String firstName;
    @Column
    private List<Exercise> workout;

    //Constructors
    public User() {}
    public User(String email, String firstName) {
        this.email = email;
        this.firstName = firstName;
    }

    //Getters and Setters
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public List<Exercise> getWorkout() {
        return workout;
    }
    public void setWorkout(List<Exercise> workout) {
        this.workout = workout;
    }
}
