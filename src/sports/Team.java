package sports;

import java.util.HashMap;
import java.util.Map;

public class Team {
    private String name;
    private String nickName;
    private String shortName;
    private String conference;
    private String division;
    private Map<String, String> divResults;
    private Map<String, String> confResults;
    private Map<String, String> nonConfResults;
    private Map<String, String> fakeResult;
    private double btNumber;
    private int    points;          // only used for hockey

    public Team(String name, String nickName, String shortName, String conference, String division) {
        super();
        this.name = name;                   // first five fields represent data in the 
        this.nickName = nickName;           // teams file. Other fields are derived from
        this.shortName = shortName;         // data in the scores and results data files.
        this.conference = conference;
        this.division = division;
        this.btNumber = 100;                // "average" team
        this.points = 0;
        divResults = new HashMap<String, String>();
        confResults = new HashMap<String, String>();
        nonConfResults = new HashMap<String, String>();
        fakeResult = new HashMap<String, String>();
        fakeResult.put("fx", "T");
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }

    public String getShortName() {
        return shortName;
    }

    public String getConference() {
        return conference;
    }

    public String getDivision() {
        return division;
    }

    public Map<String, String> getResults(int type) {
        Map<String, String> resultsMap = new HashMap<String, String>();
        resultsMap.putAll(divResults);
        if (type > 1) { resultsMap.putAll(confResults); }
        if (type > 2) { resultsMap.putAll(nonConfResults); }
        if (type > 3) { resultsMap.putAll(fakeResult); }
        return resultsMap;
    }

    public double getBtNumber() {
        return btNumber;
    }

    public int getPoints() {
        return points;
    }

    public void setBtNumber(double btNumber) {
        this.btNumber = btNumber;
    }

    public void setPoints(int points) {
        this.points = points;
    }
    
    public void addGame() {
        
    }
}
