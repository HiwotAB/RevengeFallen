package byAJ.Securex.repositories;


import byAJ.Securex.models.NewUsers;
import org.springframework.data.repository.CrudRepository;

public interface NewUserRepo extends CrudRepository<NewUsers,Long> {
    NewUsers findByUsername(String username);
    NewUsers findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);
}
