package com.example.new108.mytest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.PriorityQueue;

/**
 * Created by new108 on 2015-10-06.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationsWeather {
    private Coord coord;
    private Weather[] weather;
    private String base;
    private Main main;
    private String visibility;
    private Wind wind;
    private Clouds clouds;
    private String dt;
    private Sys sys;

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public void setWeather(Weather[] weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public String getDt() {
        return dt;
    }

    public void setDt(String dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    private String id;
    private String name;
    private String cod;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Coord {
        private String lon;
        private String lat;

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Weather {
        private String id;
        private String main;
        private String description;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        private String icon;

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Main {
        private String temp;
        private String pressure;
        private String humidity;
        private String temp_min;
        private String sea_level;

        public String getSea_level() {
            return sea_level;
        }

        public void setSea_level(String sea_level) {
            this.sea_level = sea_level;
        }

        public String getTemp() {
            return temp;
        }

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public String getPressure() {
            return pressure;
        }

        public void setPressure(String pressure) {
            this.pressure = pressure;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(String temp_min) {
            this.temp_min = temp_min;
        }

        public String getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(String temp_max) {
            this.temp_max = temp_max;
        }

        private String temp_max;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Wind {
        private String speed;
        private String deg;

        public String getSpeed() {
            return speed;
        }

        public void setSpeed(String speed) {
            this.speed = speed;
        }

        public String getDeg() {
            return deg;
        }

        public void setDeg(String deg) {
            this.deg = deg;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Clouds {
        private String all;

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Sys {
        private String type;
        private String id;
        private String message;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        private String country;
        private String sunrise;
        private String sunset;
    }
}
