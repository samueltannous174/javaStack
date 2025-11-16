package org.example.auth.Repositories;
import org.example.auth.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends CrudRepository<User,Long> {

    public Optional<User> findByEmail(String email);


}
