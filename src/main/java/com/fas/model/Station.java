package com.fas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="station")
public class Station {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String longitude;
    private String latitude;
    @OneToOne
    @JoinColumn(name = "river_id")
    @JsonIgnore
    private River river;
    private String code;
    @Column(name = "danger_level")
    private Double dangerLevel;
    @Column(name = "warning_level")
    private Double warningLevel;
    @Column(name = "threshold_deviation")
    private Integer thresholdDeviation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public River getRiver() {
        return river;
    }

    public void setRiver(River river) {
        this.river = river;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(Double dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public Double getWarningLevel() {
        return warningLevel;
    }

    public void setWarningLevel(Double warningLevel) {
        this.warningLevel = warningLevel;
    }

    public Integer getThresholdDeviation() {
        return thresholdDeviation;
    }

    public void setThresholdDeviation(Integer thresholdDeviation) {
        this.thresholdDeviation = thresholdDeviation;
    }
}
