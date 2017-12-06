package com.fas.repository;

import com.fas.model.Station;
import com.fas.model.StationReading;
import com.fas.model.StationStatus;
import com.fas.model.enums.Alarm;
import com.fas.model.enums.Trend;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

    @Override
    public List<StationReading> findAll() {
        return null;
    }
    @Override
    public StationReading recordStationReading(StationReading stationReading) {
        Session currentSession = (Session) em.getDelegate();
        Integer id = (Integer)currentSession.save(stationReading);
        stationReading.setId(id);

        StationStatus stationStatus = new StationStatus();

//        Set Alarm level
        Station station = stationRepository.findById(stationReading.getStation().getId());
        stationReading.setStation(station);
        Double dangerLevel = station.getDangerLevel();
        Double warningLevel = station.getWarningLevel();
        Double waterLevel = stationReading.getWaterLevel();

        Alarm alarm = Alarm.UNKNOWN;
        Trend trend = Trend.UNKNOWN;

        if(warningLevel == null){
            alarm = Alarm.UNKNOWN;
        }else{
            if(waterLevel >= dangerLevel){
                alarm = Alarm.DANGER;
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

        Date endDate = stationReading.getReadTime();
        if(endDate == null)
            endDate = new Date();
        stationStatus.setReadTime(stationReading.getReadTime());

        Calendar cal = Calendar.getInstance();
        cal.setTime(endDate);
        cal.add(Calendar.MINUTE, -10);
        Date startDate = cal.getTime();

        List<StationReading> pastStationReadings = crudStationReadingRepository
                .findByStationAndReadTimeBetween(station, startDate, endDate);

        Double sum = 0.0;
        Double levelOld = 0.0;
        Double levelNew = 0.0;
        Double avg = 0.0;
        int noOfReadings = pastStationReadings.size();
        for(int i = 0; i < noOfReadings - 2; i++){
            levelOld = pastStationReadings.get(i).getWaterLevel();
            levelNew = pastStationReadings.get(i+1).getWaterLevel();
            Double diff = levelNew - levelOld;
            sum = sum + diff;
        }
        avg = sum/noOfReadings;
        if(avg > 0)
            trend = Trend.RISING;
        else if(avg < 0)
            trend = Trend.FALLING;
        else if(avg == 0)
            trend = Trend.STEADY;
        else
            trend = Trend.UNKNOWN;

        stationStatus.setTrend(trend);
        stationStatusRepository.save(stationStatus);

        return stationReading;
    }
}


//Limit the number of rows
