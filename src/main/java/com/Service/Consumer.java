package com.Service;
 import com.google.gson.Gson;
 import com.google.gson.JsonObject;
 import com.google.gson.JsonParser;
 import com.model.MatchResultModel;
 import com.repositry.MatchRepo;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.kafka.annotation.KafkaListener;
 import org.springframework.stereotype.Service;

@Service
public class Consumer {
@Autowired
    MatchRepo matchRepo;
    @KafkaListener(topics="mytopic", groupId="mygroup")
    public String consumeFromTopic(String message) {
        System.out.println(message);
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(message);// response will be the json String
        MatchResultModel emp = gson.fromJson(object, MatchResultModel.class);
        System.out.println(emp.getResult());
        matchRepo.save(emp);
         return "consume successfully";


 }
}