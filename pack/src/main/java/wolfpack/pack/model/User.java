package wolfpack.pack.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String email;
    @Column
    private String firstName;
    @Column
    private String[] workout;

    //Constructors
    public User() {}
    public User(String email, String firstName, String[] workout) {
        this.email = email;
        this.firstName = firstName;
        this.workout = workout;
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
    public String[] getWorkout() {
        return workout;
    }
    public void setWorkout(String[] workout) {
        this.workout = workout;
    }
}
