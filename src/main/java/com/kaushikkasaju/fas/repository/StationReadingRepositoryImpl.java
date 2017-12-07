package com.kaushikkasaju.fas.repository;

import com.kaushikkasaju.fas.messaging.FCMClient;
import com.kaushikkasaju.fas.messaging.MessageGenerator;
import com.kaushikkasaju.fas.model.Station;
import com.kaushikkasaju.fas.model.StationReading;
import com.kaushikkasaju.fas.model.StationStatus;
import com.kaushikkasaju.fas.model.enums.Alarm;
import com.kaushikkasaju.fas.model.enums.Trend;
import org.hibernate.Session;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.plugin2.message.Message;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository("readingRepository")
public class StationReadingRepositoryImpl implements StationReadingRepository {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private CrudStationReadingRepository crudStationReadingRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private StationStatusRepository stationStatusRepository;

    @Autowired
    MessageGenerator messageGenerator;

    @Override
    public List<StationReading> findAll() {
        return null;
    }
    @Override
    public StationReading recordStationReading(StationReading stationReading) {
        StationReading stationReadingLatest = crudStationReadingRepository
                .findFirstByOrderByReadTimeDesc();

//        Check for causality
        if(stationReadingLatest.getReadTime().compareTo(stationReading.getReadTime()) < 0){
//            okay
            Session currentSession = (Session) em.getDelegate();

            Integer id = (Integer)currentSession.save(stationReading);
            stationReading.setId(id);
            int flag = 0;

            StationStatus stationStatus = new StationStatus();

//        Set Alarm level
            Station station = stationRepository.findById(stationReading.getStation().getId());
            stationReading.setStation(station);
            Double dangerLevel = station.getDangerLevel();
            Double warningLevel = station.getWarningLevel();
            Double waterLevel = stationReading.getWaterLevel();

            Alarm alarm = Alarm.UNKNOWN;
            Trend trend = Trend.UNKNOWN;

//        Set alarm and push notification acc. to Water level
            if(warningLevel == null){
                alarm = Alarm.UNKNOWN;
            }else{
                if(waterLevel >= dangerLevel){
                    alarm = Alarm.DANGER;
                    flag = 1;
                }else if(waterLevel >= warningLevel){
                    alarm = Alarm.WARNING;
                }else{
                    alarm = Alarm.SAFE;
                }
            }
            stationStatus.setStationId(station.getId());
            stationStatus.setStation(station);
            stationStatus.setWaterLevel(waterLevel);
            stationStatus.setAlarm(alarm);

//        Find Date range for readings
            Date endDate = stationReading.getReadTime();
            if(endDate == null)
                endDate = new Date();
            stationStatus.setReadTime(stationReading.getReadTime());

            Calendar cal = Calendar.getInstance();
            cal.setTime(endDate);
            cal.add(Calendar.MINUTE, -50);
            Date startDate = cal.getTime();

//        Get the range of readings
            List<StationReading> pastStationReadings = crudStationReadingRepository
                    .findTop10ByStationOrderByIdDesc(station);

//        Decide trend
            Double sum = 0.0;
            int count = 0;
            Double avg = 0.0;
            int noOfReadings = pastStationReadings.size();
            if(noOfReadings >= 2){
                for(int i = 1; i < noOfReadings - 1; i++){
                    if(pastStationReadings.get(i).getWaterLevel() < pastStationReadings.get(i-1).getWaterLevel()){
                        count = count + 1;
                    }else if(pastStationReadings.get(i).getWaterLevel() > pastStationReadings.get(i-1).getWaterLevel()){
                        count = count - 1;
                    }else{
                        count+= 0;
                    }
                }
                float posCompare = noOfReadings/2;
                float negCompare = -noOfReadings/2;
                if(count >=  posCompare){
                    trend = Trend.RISING;
                }else if(count <= negCompare){
                    trend = Trend.FALLING;
                }else{
                    trend = Trend.STEADY;
                }
            }else{
                trend = Trend.UNKNOWN;
            }
            stationStatus.setTrend(trend);
            stationStatusRepository.save(stationStatus);

            if(flag == 1){
                messageGenerator.sendStatusMessage(stationStatus);
            }
            return stationReading;

        }else
            return null;
    }
}
