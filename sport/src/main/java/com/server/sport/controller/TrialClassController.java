package com.server.sport.controller;

import com.server.sport.model.Event;
import com.server.sport.model.TrialClass;
import com.server.sport.service.TrialClassService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trialClasses")
public class TrialClassController {

  @Autowired
  private TrialClassService trialClassService;

  @PostMapping("/add")
  public String add(@RequestBody TrialClass trialClass) {
    trialClassService.saveTrialClass(trialClass);
    return "Добавлено новое событие";
  }

  @PostMapping("/getAll")
  public List<TrialClass> getAllTrialClasses() {
    return trialClassService.getAllTrialClasses();
  }
}
