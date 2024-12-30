package practice.arrays;

import java.io.*;
import java.util.*;

/*

We are working on a security system for a badged-access room in our company's building.

We want to find employees who badged into our secured room unusually often. We have an unordered list of names and entry times over a single day. Access times are given as numbers up to four digits in length using 24-hour time, such as "800" or "2250".

Write a function that finds anyone who badged into the room three or more times in a one-hour period, and returns each time that they badged in during that period. (If there are multiple one-hour periods where this was true for an employee, just return the first one.)

badge_times = [
  ["Paul",     "1355"],
  ["Jennifer", "1910"],
  ["John",      "835"],
  ["John",      "830"],
  ["Paul",     "1315"],
  ["John",     "1615"],
  ["John",     "1640"],
  ["Paul",     "1405"],
  ["John",      "855"],
  ["John",      "930"],
  ["John",      "915"],
  ["John",      "730"],
  ["John",      "940"],
  ["Jennifer", "1335"],
  ["Jennifer",  "730"],
  ["John",     "1630"],
  ["Jennifer",    "5"]
]

Expected output (in any order)
  John:  830  835  855  915  930
  Paul: 1315 1355 1405
  Steven: 830 835 935 945 955

n: length of the badge records array


*/


public class KaratUserTimings {
  public static void main(String[] argv) {
    String[][] badgeTimes = new String[][] {
      {"Paul",     "1355"}, // 1:55 pm
      {"Jennifer", "1910"},
      {"John",      "835"}, // 8:35 am
      {"John",      "830"},
      {"Paul",     "1315"},
      {"John",     "1615"},
      {"John",     "1640"},
      {"Paul",     "1405"},
      {"John",      "855"},
      {"John",      "930"},
      {"John",      "915"},
      {"John",      "730"},
      {"John",      "940"},
      {"Jennifer", "1335"},
      {"Jennifer",  "730"},
      {"John",     "1630"},
      {"Jennifer",    "5"},
    };

    Map<String, List<Integer>> result = getUsersWithEntries(badgeTimes);
    
    for (String user: result.keySet()) {
      System.out.println(user + ": " + result.get(user));
    }
  }
  
  private static Map<String, List<Integer>> getUsersWithEntries(String[][] badgeTimes) {
    // check for empty or null 
    if (badgeTimes == null || badgeTimes.length == 0) {
      return new HashMap<>();
    }
    
    Map<String, List<Integer>> userTimings = new HashMap<>();
    for (int i = 0; i < badgeTimes.length; i++) {
      List<Integer> timings = userTimings.get(badgeTimes[i][0]);
      if(timings == null) {
        timings = new ArrayList<>();
      }
      timings.add(Integer.parseInt(badgeTimes[i][1]));
      userTimings.put(badgeTimes[i][0], timings);
    }
    // sort the timings for each user
    Map<String, List<Integer>> output = new HashMap<>();
    for (String user: userTimings.keySet()) {
      List<Integer> sortedTimings = userTimings.get(user);
      Collections.sort(sortedTimings);
      // check the entry timings count
      for (int i = 0; i < sortedTimings.size(); i++) {
        List<Integer> timings = new ArrayList<>();
        timings.add(sortedTimings.get(i));
        for (int j = i + 1; j < sortedTimings.size(); j++) {
          if (sortedTimings.get(i) + 100 >= sortedTimings.get(j)) {
            timings.add(sortedTimings.get(j));
          } else {
            break;
          }
        }
        if (timings.size() >= 3) {
          output.put(user, timings);
          break;
        }
      }
    }
    return output;
  }
}
