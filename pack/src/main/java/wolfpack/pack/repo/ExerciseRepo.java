package wolfpack.pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import wolfpack.pack.model.Exercise;

import java.lang.reflect.Executable;
import java.util.List;

public interface ExerciseRepo extends JpaRepository<Exercise, String> {
    List<Exercise> findAllByMuscles(String[] muscle);
    Exercise findExerciseByName(String name);
}
