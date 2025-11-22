package org.example.world.Controllers;

import org.example.world.Models.CitiesEntity;
import org.example.world.Models.CountriesEntity;
import org.example.world.Services.CityService;
import org.example.world.Services.CountryService;
import org.example.world.Services.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class WorldController {

    @Autowired
    private CountryService countryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private LanguageService languageService;


    @GetMapping("/world-data")
    public String showWorldData(Model model) {

        List<Object[]> countriesSpeakingEnglish = countryService.getCountriesSpeaking("Slovene");
        System.out.println(countriesSpeakingEnglish);
        model.addAttribute("countriesSpeakingEnglish", countriesSpeakingEnglish);
        List<Object[]> cityCounts = countryService.getCityCounts();
        model.addAttribute("cityCounts", cityCounts);

        

        List<CountriesEntity> smallPopCountries = countryService.getSmallButPopulatedCountries();
        model.addAttribute("smallPopCountries", smallPopCountries);

        List<CountriesEntity> monarchies = countryService.getConstitutionalMonarchies();
        model.addAttribute("monarchies", monarchies);

        List<CitiesEntity> mexicanBigCities = cityService.getMexicanBigCities();
        model.addAttribute("mexicanBigCities", mexicanBigCities);

        List<Object[]> argentinaBigCities = cityService.getArgentinaBigCities();
        model.addAttribute("argentinaBigCities", argentinaBigCities);

        List<Object[]> allLanguagesEachCountry = languageService.getHighPercentLanguages();
        model.addAttribute("allLanguagesEachCountry", allLanguagesEachCountry);

        List<Object[]> countriesRegion = countryService.getCountCountriesByRegion();
        model.addAttribute("countriesRegion", countriesRegion);


        return "world-data";
    }
}
