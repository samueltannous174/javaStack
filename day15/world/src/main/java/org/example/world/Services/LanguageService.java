package org.example.world.Services;

import org.example.world.Repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageService {

    @Autowired
    private LanguageRepository languageRepository;

    public List<Object[]> getHighPercentLanguages() {
        return languageRepository.getHighPercentLanguages();
    }
}
