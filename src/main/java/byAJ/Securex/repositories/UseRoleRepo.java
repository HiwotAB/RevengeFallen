package byAJ.Securex.repositories;

import byAJ.Securex.models.UseRole;
import org.springframework.data.repository.CrudRepository;

public interface UseRoleRepo extends CrudRepository<UseRole,Long> {
    UseRole findByUrole(String role);
}
