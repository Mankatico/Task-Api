package com.andersson.taskapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HolaController {

  @GetMapping("/hola")
  public String decirHola() {
    return "¡Hola, mundo que tal, pues aquí estoy!";
  }

}
