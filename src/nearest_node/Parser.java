package nearest_node;



import nearest_node.flowers.Iris;
import nearest_node.flowers.IrisFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 20/03/17.
 */
public class Parser {

    private String testFileName;
    private String trainingFileName;

    public Parser(String trainingFileName, String testFileName) {
        this.trainingFileName = trainingFileName;
        this.testFileName = testFileName;
    }

    public List<Iris> parseTestData() {
        System.out.println(System.getProperty("user.dir"));
        return readData(testFileName);
    }

    public List<Iris> parseTrainingData() {
        return readData(trainingFileName);
    }


    private List<Iris> readData(String fileName) {
        List<Iris> flowers = new ArrayList<>();

        try {
            // Set up file reader
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            // Read value
            String val = reader.readLine();

            // Create flower from data line
            while (!val.isEmpty()) {
                String[] vals = val.split(" ");
                double sepalLength = Double.valueOf(vals[0]);
                double sepalWidth = Double.valueOf(vals[2]);
                double petalLength = Double.valueOf(vals[4]);
                double petalWidth = Double.valueOf(vals[6]);
                String flowerType = vals[8];
                Iris flower = IrisFactory.createIris(sepalLength, sepalWidth, petalLength, petalWidth, flowerType);
                flowers.add(flower);
                val = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return flowers;
    }
}
