package com.hci.main;

import com.hci.main.model.Module;
import com.hci.main.model.Response;
import com.hci.main.service.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootStarter {

    @Autowired
    ModuleRepository moduleRepository;
    @GetMapping("/{userID}")
    public Response getmodule(@PathVariable String userID){
    Response  response  = new Response();
    response.setModules(moduleRepository.findByUserID(userID).toArray(new Module[0]));
    return response;
    }
}
