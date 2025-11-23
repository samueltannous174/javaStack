package org.example.finaljava.Repositories;

import org.example.finaljava.Models.Task;
import org.example.finaljava.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository  extends CrudRepository<Task,Long> {
    public List<Task> findAllByType(String type);

    public List<Task> findAllByUser(User user);
    public List<Task> findAllByTypeAndUser(String type, User user);

}
