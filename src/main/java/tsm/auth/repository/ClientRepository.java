package tsm.auth.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tsm.auth.entity.Client;

import java.util.Optional;

public interface ClientRepository  extends JpaRepository<Client, String> {

    Optional<Client> findByClientId(String clientId);

}
