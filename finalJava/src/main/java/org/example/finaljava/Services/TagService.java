package org.example.finaljava.Services;

import org.example.finaljava.Models.Tag;
import org.example.finaljava.Models.Task;
import org.example.finaljava.Repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public class TagService {
    private final TagRepository tagRepository;
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }
    public List<Tag> findAll() {
        return (List<Tag>) tagRepository.findAll();
    }
    public void addTag(Tag tag, Task task){
        tag.addTask(task);
    }
    public Tag findTag(Long id){
        return tagRepository.findById(id).orElse(null);
    }
    public Boolean existsByName(String name){
        return tagRepository.existsByName(name);
    }
    public Tag findByName(String name){
        return tagRepository.findByName(name);
    }
}
