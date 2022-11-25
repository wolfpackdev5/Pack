package wolfpack.pack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wolfpack.pack.model.Exercise;
import wolfpack.pack.repo.ExerciseRepo;

import java.util.List;
@Service
public class ExerciseService {
    private final ExerciseRepo exerciseRepo;
    @Autowired
    public ExerciseService(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public List<Exercise> getAllExercises() {
        return this.exerciseRepo.findAll();
    }

    public List<Exercise> findByMuscle(String[] muscle) {
        return this.exerciseRepo.findAllByMuscles(muscle);
    }

    public Exercise findByName(String name) {
        return this.exerciseRepo.findExerciseByName(name);
    }

    public void newExercise(Exercise exercise) {
        this.exerciseRepo.save(exercise);
    }
}
