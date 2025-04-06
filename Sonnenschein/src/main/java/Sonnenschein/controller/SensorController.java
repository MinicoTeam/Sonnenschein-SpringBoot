package Sonnenschein.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import Sonnenschein.model.SensorData;
import Sonnenschein.repository.SensorRepository;

@Controller
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;

    @GetMapping("/sensor-data")
    public String getSensorData(Model model) {
        List<SensorData> sensorDataList = sensorRepository.findAll();
        model.addAttribute("sensorDataList", sensorDataList);
        return "sensorData";
    }
}