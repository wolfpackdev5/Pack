package wolfpack.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wolfpack.pack.model.Exercise;
import wolfpack.pack.model.User;
import wolfpack.pack.repo.ExerciseRepo;
import wolfpack.pack.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;
    private ExerciseRepo exerciseRepo;
    private String[][] muscleGroups = {{"chest", "triceps"}, {"back", "biceps"}, {"legs", "glute"}, {"calves"}, {"core"}};

    @Autowired
    private UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    //create user on cognito register api call
    public void createUser(String email, String firstName) {
        User user = new User(email, firstName);
        this.userRepo.save(user);
    }
    //create a workout and assign it to user
    public List<Exercise> createAWorkout(String email) {
        List workout = new ArrayList<>();
        for(String[] muscles : muscleGroups) {
            List list = this.exerciseRepo.findAllByMuscles(muscles);
            workout.add(list.get((int) Math.random() * list.size()));
        }
        //try catch block for user not found exception
        try {
            Optional<User> user = this.userRepo.findById(email);
            user.get().setWorkout(workout);
        }
        catch(Exception e) {
            System.out.println("User not found");
        }
        return workout;
    }
    //get workout to display it when user wants to see it again
    public List<Exercise> getWorkout(String email) {
        List userWorkout = new ArrayList();
        try {
            Optional<User> user = this.userRepo.findById(email);
            userWorkout = user.get().getWorkout();
        }
        catch(Exception e) {
            System.out.println("User not found");
        }
        return userWorkout;
    }
}
