package com.company.app.dao;
import com.company.app.services.AddClientService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//check if file exits
//if empty
//then createAccount

public class createAccount {

    final ObjectMapper mapper = new ObjectMapper();
    AddClientService addAccount = new AddClientService();

    MyValue value = mapper.writeValue(new File("./src/main/resources/data.json"), MyValue.class);



}
