package com.kaushikkasaju.fas.messaging;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class FCMClient {
    private static final String FIREBASE_SERVER_KEY = "AAAAQJSJkVY:APA91bEiYen5zjcwwwF1InGOtrrlOFW7XR3KbcL9eGo3m6ofzeHZmN1FGbgvr68NBeuA59xuYDNsI2nBVSUkS1icwg0DbU7z_7hiHBx5gVha06ABYhDFEOSqq9tVNJghF9Q-JAZz3Adc";
    private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";

    @Async
    public boolean send(JSONObject jsonObject) {

        HttpEntity<String> request = new HttpEntity<>(jsonObject.toString());

        RestTemplate restTemplate = new RestTemplate();

        /**
         https://fcm.googleapis.com/fcm/send
         Content-Type:application/json
         Authorization:key=FIREBASE_SERVER_KEY*/

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
        restTemplate.setInterceptors(interceptors);

        String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, request, String.class);


        CompletableFuture<String> pushNotification =  CompletableFuture.completedFuture(firebaseResponse);
        CompletableFuture.allOf(pushNotification).join();

        try {
            String response = pushNotification.get();
            return true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }
}
