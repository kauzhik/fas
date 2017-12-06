package com.kaushikkasaju.fas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kaushikkasaju.fas.model.enums.Alarm;
import com.kaushikkasaju.fas.model.enums.Trend;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "station_status")
public class StationStatus implements Serializable{
    @Id
    @Column(name = "station_id")
    private Integer stationId;
    @OneToOne
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Station station;
    @Column(name = "trend")
    @Enumerated(EnumType.STRING)
    private Trend trend;

    @Column(name = "alarm")
    @Enumerated(EnumType.STRING)
    private Alarm alarm;

    @Column(name = "water_level")
    private Double waterLevel;
    @Column(name = "read_time", columnDefinition = "TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date readTime;

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }


    public Trend getTrend() {
        return trend;
    }

    public void setTrend(Trend trend) {
        this.trend = trend;
    }

    public Alarm getAlarm() {
        return alarm;
    }

    public void setAlarm(Alarm alarm) {
        this.alarm = alarm;
    }

    public Double getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Double waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }
}
