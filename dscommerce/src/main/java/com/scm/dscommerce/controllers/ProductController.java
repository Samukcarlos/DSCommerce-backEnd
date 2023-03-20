package com.scm.dscommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Configura para que esta classe responda na WEB
@RequestMapping(value = "/products") // rota
public class ProductController {

    @GetMapping // respondendo pelo método GET, vizualizando no Postman
   public String teste (){
       return "ola mundo!";
   }
}
