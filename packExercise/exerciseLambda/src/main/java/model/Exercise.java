package model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

@DynamoDBTable(tableName = "Exercises")
public class Exercise {
    @DynamoDBHashKey
    private String id;
    @DynamoDBAttribute
    private String muscles;
    @DynamoDBAttribute
    private String tutorial;

    public Exercise() {}

    public Exercise( String id, String muscles, String tutorial) {
        this.id = id;
        this.muscles = muscles;
        this.tutorial = tutorial;
    }

    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getMuscles() {
        return this.muscles;
    }
    public void setMuscles(String muscles) {
        this.muscles = muscles;
    }
    public String getTutorial() {
        return this.tutorial;
    }
    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }
}
