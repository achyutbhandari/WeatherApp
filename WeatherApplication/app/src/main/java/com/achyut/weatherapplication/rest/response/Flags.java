
package com.achyut.weatherapplication.rest.response;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Flags{

    @SerializedName("sources")
    @Expose
    private List<String> sources = null;
    @SerializedName("darksky-stations")
    @Expose
    private List<String> darkskyStations = null;
    @SerializedName("lamp-stations")
    @Expose
    private List<String> lampStations = null;
    @SerializedName("isd-stations")
    @Expose
    private List<String> isdStations = null;
    @SerializedName("madis-stations")
    @Expose
    private List<String> madisStations = null;
    @SerializedName("units")
    @Expose
    private String units;

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public List<String> getDarkskyStations() {
        return darkskyStations;
    }

    public void setDarkskyStations(List<String> darkskyStations) {
        this.darkskyStations = darkskyStations;
    }

    public List<String> getLampStations() {
        return lampStations;
    }

    public void setLampStations(List<String> lampStations) {
        this.lampStations = lampStations;
    }

    public List<String> getIsdStations() {
        return isdStations;
    }

    public void setIsdStations(List<String> isdStations) {
        this.isdStations = isdStations;
    }

    public List<String> getMadisStations() {
        return madisStations;
    }

    public void setMadisStations(List<String> madisStations) {
        this.madisStations = madisStations;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

}
