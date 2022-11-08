package model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Users")
public class Users {
    String username;
    String exercise1;
    String exercise2;
    String exercise3;
    String exercise4;
    String exercise5;
    String exercise6;
}
