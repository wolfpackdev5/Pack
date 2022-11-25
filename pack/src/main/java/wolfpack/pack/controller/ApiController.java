package wolfpack.pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wolfpack.pack.model.Exercise;
import wolfpack.pack.service.ExerciseService;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class ApiController {
    @Autowired
    private final ExerciseService exerciseService;

    public ApiController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }
    @GetMapping("exercises")
    public ResponseEntity<List<Exercise>> getAllExercises() {
        List<Exercise> exercises = this.exerciseService.getAllExercises();
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
    @GetMapping("exercisesFor/{muscle}")
    public ResponseEntity<List<Exercise>> getExerciseByMuscle(@PathVariable String[] muscle) {
        System.out.println(muscle.getClass());
        List<Exercise> exercises = this.exerciseService.findByMuscle(muscle);
        return new ResponseEntity<>(exercises, HttpStatus.OK);
    }
    @GetMapping("exercise/{name}")
    public ResponseEntity<Exercise> getExerciseByName(@PathVariable String name) {
        Exercise exercise = this.exerciseService.findByName(name);
        return new ResponseEntity<>(exercise, HttpStatus.OK);
    }
    @PostMapping("newExercise")
    public ResponseEntity<Exercise> addNewExercise(@RequestBody Exercise exercise) {
        this.exerciseService.newExercise(exercise);
        return new ResponseEntity<>(exercise, HttpStatus.CREATED);
    }
}
