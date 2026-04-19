package com.ai.ai_chatbot_backend.service;


import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;;

@Service
public class ChatService {


    public String getResponse(String userMessage){
       Client client=new Client();

       GenerateContentConfig config=GenerateContentConfig
               .builder()
               .temperature(0.9F)
               .maxOutputTokens(1000)
               .build();

       GenerateContentResponse response=client
               .models.generateContent("gemini-3-flash-preview",userMessage,config);

       return  response.text();
    }
}