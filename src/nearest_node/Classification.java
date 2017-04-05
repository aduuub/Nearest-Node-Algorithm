package nearest_node;

import nearest_node.flowers.Iris;

import java.util.*;

/**
 * This classifies Iris's class based on previous iris learnt.
 *
 * @author Adam
 */
public class Classification {

    private List<Iris> irisLearnt;
    private IrisRange range;
    private int k;

    public Classification(int k) {
        this.k = k;
    }

    /**
     * Learn a list of iris, and set the new max/min range.
     * @param irisToLearn
     */
    public void learn(List<Iris> irisToLearn){
        this.irisLearnt = irisToLearn;
        determineMaxAndMinRanges();
    }


    /**
     * Determines an appropriate class for an iris based on the iris learnt.
     * @param classifyIris
     * @return  - name of the class the AI expects it to be.
     */
    public String classify(Iris classifyIris){
        List<DistanceIris> distanceIrises = new ArrayList<>();

        // Measure distance to iris's and put in a list
        for(Iris iris : irisLearnt){
            double dist = classifyIris.distanceToOtherIris(iris, range);
            distanceIrises.add(new DistanceIris(iris, dist));
        }

        // Sort from smallest dist -> largest dist
        Collections.sort(distanceIrises);

        // Build sub-list of closest iris
        List<Iris> closestIris = new ArrayList<>() ;
        for(int i=0; i < k; i++){
            DistanceIris distIris = distanceIrises.get(i);
            closestIris.add(distIris.getIris());
        }

        // Find most common class
        return findMostCommonClass(closestIris);
    }

    /**
     * Finds the most common class among a list of irises
     * @param irises
     * @return
     */
    private String findMostCommonClass(List<Iris> irises){
        Map<String, Integer> votes = new HashMap<>();

        // Put Class -> Count in map
        for(Iris s : irises){

            if(votes.containsKey(s)){
                int current = votes.get(s);
                votes.put(s.getIrisType(), current+1);
            }else{
                votes.put(s.getIrisType(), 1);
            }
        }

        // Find most common in map
        return Collections.max(votes.entrySet(), (entry1, entry2) -> entry1.getValue() - entry2.getValue()).getKey();
    }

    /**
     * Determines the minimum and maximum ranges for the irises learnt. Sets the range
     */
    private void determineMaxAndMinRanges(){
        // Set min values
        double minSl = 0, minSw = 0, minPl = 0, minPw = 0;
        // Set max values
        double maxSl = 0, maxSw = 0, maxPl = 0, maxPw = 0;

        // Update values for each iris
        for (Iris iris : irisLearnt) {
            // Sepal length
            minSl = Math.min(iris.getSepalLength(), minSl);
            maxSl = Math.max(iris.getSepalLength(), maxSl);
            // Sepal width
            minSw = Math.min(iris.getSepalWidth(), minSw);
            maxSw = Math.max(iris.getSepalWidth(), maxSw);
            // Petal length
            minPl = Math.min(iris.getPetalLength(), minPl);
            maxPl = Math.max(iris.getPetalLength(), maxPl);
            // Petal width
            minPw = Math.min(iris.getPetalWidth(), minPw);
            maxPw = Math.max(iris.getPetalWidth(), maxPw);
        }

        range = new IrisRange(maxSl - minSl, maxSw - minSw, maxPl - minPl, maxPw - minPw);
    }

}
