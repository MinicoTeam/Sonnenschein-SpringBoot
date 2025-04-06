package Sonnenschein.controller;

import Sonnenschein.model.WetterData;
import Sonnenschein.service.WetterService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WetterController {

    @Autowired
    private WetterService wetterService;


    @GetMapping("/")
    public String index() {
        return "index"; // name of the html file
    }
    
    @GetMapping("/currentWeather")
    public String getCurrentWeather(@RequestParam String location, Model model) {
        WetterData wetterData = wetterService.fetchCurrentWeather(location);
        model.addAttribute("weatherData", wetterData);
        return "index"; // name of the html file
    }

    @GetMapping("/hourlyForecast")
    public String getHourlyForecast(@RequestParam String location, Model model) {
        List<WetterData> forecastHourly = wetterService.fetchHourlyForecast(location);
        model.addAttribute("forecastHourly", forecastHourly);
        return "index"; // name of the html file
    }
    
    @GetMapping("/dailyForecast")
    public String getDailyForecast(@RequestParam String location, Model model) {
        List<WetterData> forecast = wetterService.fetchDailyForecast(location);
        model.addAttribute("forecast", forecast);
        return "index"; //name of the html file 
    }

    @GetMapping("/threeDayForecast")
    public String getThreeDayForecast(@RequestParam String location, Model model) {
        List<WetterData> forecast = wetterService.fetchThreeDayForecast(location);
        model.addAttribute("forecast", forecast);
        return "index"; // Name der Thymeleaf-Vorlage
    }
}