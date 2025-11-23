package org.example.finaljava.Repositories;
import org.example.finaljava.Models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TagRepository  extends CrudRepository<Tag,Long> {

    Boolean existsByName(String name);
    Tag findByName(String name);



}
