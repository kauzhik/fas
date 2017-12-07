package com.kaushikkasaju.fas.messaging;

import com.kaushikkasaju.fas.model.StationStatus;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageGenerator {
    private final String TOPIC = "all";

    @Autowired
    FCMClient fcmClient;

    public boolean sendStatusMessage(StationStatus station){
        JSONObject body = new JSONObject();
        body.put("to", "/topics/" + TOPIC);
        body.put("priority", "high");

        JSONObject notification = new JSONObject();
        notification.put("title", "EWS Notification");
        notification.put("body", "Danger Warning!");

        JSONObject data = new JSONObject();
        data.put("stationId", station.getStationId());
        data.put("alarm", station.getAlarm());
        data.put("trend", station.getTrend());
        data.put("waterLevel", station.getWaterLevel());
        data.put("readTime", station.getReadTime());

        body.put("notification", notification);
        body.put("data", data);

        return fcmClient.send(body);
    }
}
