package nearest_node;


import nearest_node.flowers.Iris;

/**
 * This is a distance iris used for comparing distance between two iris's.
 * Implements Comparable to compare them.
 *
 * @author Adam
 */
public class DistanceIris implements Comparable<DistanceIris> {

    private Iris iris;
    private double dist;

    public DistanceIris(Iris iris, double dist) {
        this.iris = iris;
        this.dist = dist;
    }


    @Override
    public int compareTo(DistanceIris o) {
        if(o == null){
            throw new RuntimeException("Cannot compare to null");
        }

        if (dist < o.getDist())
            return -1;

        else if (dist > o.getDist())
            return 1;

        return 0; // Must be the same
    }


    public double getDist() {
        return dist;
    }

    public Iris getIris() {
        return iris;
    }
}
