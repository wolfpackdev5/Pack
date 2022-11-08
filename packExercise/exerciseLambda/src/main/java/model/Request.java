package model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

public class Request {
    private String httpMethod;
    private String id;
    private Exercise exercise;
    private String muscle;
    private int numOfItems;

    public Request() {}
    public Request(String id) {
        this.id = id;
    }
    public Request(String httpMethod, String id) {
        this.httpMethod = httpMethod;
        this.id = id;
    }
    public Request(String httpMethod, Exercise exericse, int numOfItems) {
        this.httpMethod = httpMethod;
        this.exercise = exercise;
        this.numOfItems = numOfItems;
    }
    public Request(String httpMethod, String id, Exercise exercise) {
        this.httpMethod = httpMethod;
        this.id = id;
        this.exercise = exercise;
    }
    public String getHttpMethod() {
        return this.httpMethod;
    }
    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }
    public String getId() {
        return this.id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Exercise getExercise() {
        return this.exercise;
    }
    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }
    public String getMuscle() {
        return this.muscle;
    }
    public void setMuscle(String muscle) {
        this.muscle = muscle;
    }
    public int getNumOfItems() {
        return this.numOfItems;
    }
    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }
}
