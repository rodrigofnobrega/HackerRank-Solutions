import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int minimum = 0;
        int maximum = 0;

        int lowestScore = 0;
        int maximumScore = 0;

        for (int game=0; scores.size() > game; game++) {
            int gameScore = scores.get(game);

            if (game == 0) {
                minimum = gameScore;
                maximum = gameScore;
            }

            else if (minimum > gameScore) {
                minimum = gameScore;
                lowestScore++;
            }

            else if (maximum < gameScore) {
                maximum = gameScore;
                maximumScore++;
            }
        }

        ArrayList<Integer> brokeRecords = new ArrayList<>();
        brokeRecords.add(maximumScore);
        brokeRecords.add(lowestScore);

        return brokeRecords;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
