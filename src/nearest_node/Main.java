package nearest_node;


import nearest_node.flowers.Iris;

import java.util.List;

/**
 * Entry point to the program. Running this reads in the files and starts the learning, then classification. This is a
 * controller for other classes.
 */
public class Main {

    private List<Iris> testData;
    private List<Iris> trainingData;

    public final int k;

    public Main(List<Iris> testData, List<Iris> trainingData, int k) {
        this.trainingData = trainingData;
        this.testData = testData;
        this.k = k;


        // Start learning
        Classification classification = new Classification(k);
        classification.learn(trainingData);

        // Run classification
        int totalCorrect = 0;
        for(Iris iris : testData){
            String className = classification.classify(iris);
            System.out.println(className);
            if(className.equals(iris.getIrisType())){
                totalCorrect++;
            }
        }

        double percentCorrect = ((double) totalCorrect) / ((double)testData.size());
        System.out.println("I found " + totalCorrect + ", out of " + testData.size() + ". That is " + percentCorrect +
                "% correct.");
}


    public static void main(String args[]){
        if(args.length != 3){
            System.out.println("Usage: Run with arguments: testFilePath trainingFilePath KValue");
        }
        String trainingFileName = args[0];
        String testFileName = args[1];
        int k = Integer.valueOf(args[2]);

        // Parse the data
        Parser parser = new Parser(trainingFileName, testFileName);
        List<Iris> trainingData = parser.parseTrainingData();
        List<Iris> testData = parser.parseTestData();

        // Start the program
        new Main(testData, trainingData, k);
    }
}
