package wolfpack.pack.repoTests;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import wolfpack.pack.model.Exercise;
import wolfpack.pack.repo.ExerciseRepo;

import java.util.List;
//NEED TO ADD JUNIT DEPENDENCY
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ExerciseRepoTests {
    private ExerciseRepo eRepo;
    @Test
    public void searchRepoByMuscleMethodTest() {
        List<Exercise> list = eRepo.findByMuscles("chest");
        assertNotNull(list);
    }
}
