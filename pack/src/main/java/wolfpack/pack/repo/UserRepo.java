package wolfpack.pack.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import wolfpack.pack.model.User;

public interface UserRepo extends JpaRepository<User, String> {
}
