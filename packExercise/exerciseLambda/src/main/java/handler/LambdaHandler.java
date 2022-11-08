package handler;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.amazonaws.services.dynamodbv2.document.ScanFilter;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.amazonaws.services.lambda.runtime.Context;
import model.Exercise;
import model.Request;
import model.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@DynamoDBDocument
public class LambdaHandler {
    static final Logger log = LoggerFactory.getLogger(LambdaHandler.class);
    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.defaultClient();
    DynamoDBMapper mapper = new DynamoDBMapper(client);
    DynamoDBScanExpression scan = new DynamoDBScanExpression();
    Exercise exercise = null;
    List<Exercise> exerciseList;
    public Object exerciseMethod(Request request, Context context) {
        switch(request.getHttpMethod()) {
            case "GET":
                exerciseList = mapper.scan(Exercise.class, scan);
                if(exerciseList.size() == 0) {
                    return "List is empty";
                //load method works for getting a specific exercise
               /*exercise = mapper.load(Exercise.class, request.getId());
               if(exercise == null) {
                   throw new ResourceNotFoundException("Resource not found: " + request.getId());
               }
                return this.exercise;*/
                }
                return exerciseList.subList(request.getNumOfItems() - 8, request.getNumOfItems());
            case "POST":
               this.exercise = request.getExercise();
               mapper.save(this.exercise);
               return this.exercise;
            default:
                break;
        }
       return null;
    }

    public Object exerciseByMuscle(Request request, Context context) {
        Condition condition = new Condition().withComparisonOperator(ComparisonOperator.CONTAINS)
                .withAttributeValueList(new AttributeValue(request.getId()));
        this.scan.addFilterCondition("muscles", condition);
        exerciseList = mapper.scan(Exercise.class, scan);
        if(exerciseList.size() == 0) {
            return request.getId() + "returned an empty list";
      }
      return exerciseList;
    }

    public Exercise getPullExercise() {
        Condition condition = new Condition().withComparisonOperator(ComparisonOperator.CONTAINS)
                .withAttributeValueList(new AttributeValue("back"));
        this.scan.addFilterCondition("muscles", condition);
        exerciseList = mapper.scan(Exercise.class, scan);
        Exercise ex = exerciseList.get((int) Math.random() * exerciseList.size());
        return ex;
    }

    public Exercise getCoreExercise() {
        Condition condition = new Condition().withComparisonOperator(ComparisonOperator.CONTAINS)
                .withAttributeValueList(new AttributeValue("core"));
        this.scan.addFilterCondition("muscles", condition);
        exerciseList = mapper.scan(Exercise.class, scan);
        Exercise ex = exerciseList.get((int) Math.random() * exerciseList.size());
        return ex;
    }

    public Exercise getPushExercise() {
        Condition condition = new Condition().withComparisonOperator(ComparisonOperator.CONTAINS)
                .withAttributeValueList(new AttributeValue("chest"));
        this.scan.addFilterCondition("muscles", condition);
        exerciseList = mapper.scan(Exercise.class, scan);
        Exercise ex = exerciseList.get((int) Math.random() * exerciseList.size());
        return ex;
    }

    public Exercise getShoulderExercise() {
        Condition condition = new Condition().withComparisonOperator(ComparisonOperator.CONTAINS)
                .withAttributeValueList(new AttributeValue("shoulders"));
        this.scan.addFilterCondition("muscles", condition);
        exerciseList = mapper.scan(Exercise.class, scan);
        Exercise ex = exerciseList.get((int) Math.random() * exerciseList.size());
        return ex;
    }

    public Exercise getButtExercise() {
        Condition condition = new Condition().withComparisonOperator(ComparisonOperator.CONTAINS)
                .withAttributeValueList(new AttributeValue("butt"));
        this.scan.addFilterCondition("muscles", condition);
        exerciseList = mapper.scan(Exercise.class, scan);
        Exercise ex = exerciseList.get((int) Math.random() * exerciseList.size());
        return ex;
    }

    public Exercise getLegExercise() {
        Condition condition = new Condition().withComparisonOperator(ComparisonOperator.CONTAINS)
                .withAttributeValueList(new AttributeValue("legs"));
        this.scan.addFilterCondition("muscles", condition);
        exerciseList = mapper.scan(Exercise.class, scan);
        Exercise ex = exerciseList.get((int) Math.random() * exerciseList.size());
        return ex;
    }

    public Object makeAWorkout() {
        this.exerciseList.add(getLegExercise());
        this.exerciseList.add(getButtExercise());
        this.exerciseList.add(getCoreExercise());
        this.exerciseList.add(getPullExercise());
        this.exerciseList.add(getPushExercise());
        this.exerciseList.add(getShoulderExercise());

        ArrayList<Exercise> workout = new ArrayList<>();
        Users user = new Users();
        for(int x = 0; x > this.exerciseList.size() - 1; x++) {
            if(!workout.contains(this.exerciseList.get(x))) {
                workout.add(this.exerciseList.get(x));
                //user.
            }
        }
        //mapper.save(user);
        if(workout.size() == 0) {
            return "an error occured and the list is empty";
        }
        return workout;
    }
}
