package sports;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BtaCalc {
    static String sport;
    static String logfile;
    
    public static void main(String[] args) throws IOException {
        // check sport from command line
        Scanner input = new Scanner(System.in);
        String validSports = "cbb|cbk|cfb|chk|mlb|nba|nfl|nhl";
        if (args.length > 0) {
            sport = args[0];
        }
        else {
            System.out.println("Available sports: " + validSports);
            System.out.print("Which sport? ");
            sport = input.next();
            input.close();
        }
        if (!sport.matches(validSports)) {
            System.out.println("sport not found: " + sport);
            System.exit(1);
        }
        
        // setup file names
        logfile = sport + "\\log.txt";
        String teams = sport + "\\teams.txt";
        String scores = sport + "\\scores.txt";
        String results = sport + "\\results.txt";
        
        // open and read teams file
        Map<String, Team> lNames = new HashMap<>();
        Map<String, Team> sNames = new HashMap<>();
        try {
            input = new Scanner(new BufferedReader(new FileReader(teams)));
            while (input.hasNext()) {
                String nextTeam = input.nextLine();
                String[] teamData = nextTeam.split(",");
                String name = teamData[0];
                String nickName = teamData[1];
                String shortName = teamData[2];
                String conference = teamData[3];
                String division;
                if (teamData.length == 5) 
                    division = teamData[4];
                else
                    division = "";
                lNames.put(name, new Team(name, nickName, shortName, conference, division));
                sNames.put(shortName, new Team(name, nickName, shortName, conference, division));
            }
        }
        finally {
            input.close();
        }
        
        // check if scores file is newer than results file
        // if results file is current
        //     read results file
        // else
        //     read scores file
        //     calculate bt# for all teams
        //     write results file
        // end if
        // write standings file with division, conference, or league options
        // write btrank file with division, conference, or league options

    }

}
