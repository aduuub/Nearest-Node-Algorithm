package nearest_node;

/**
 * This stores the ranges for a collection of Iris. It has a range for each of its fields which was calculated using
 * max - min.
 *
 * @author Adam
 */
public class IrisRange {

    private double sepalLengthRange;
    private double sepalWidthRange ;
    private double petalLengthRange;
    private double petalWidthRange;

    public IrisRange(double sepalLengthRange, double sepalWidthRange, double petalLengthRange, double petalWidthRange) {
        this.sepalLengthRange = sepalLengthRange;
        this.sepalWidthRange = sepalWidthRange;
        this.petalLengthRange = petalLengthRange;
        this.petalWidthRange = petalWidthRange;
    }

    public double getSepalLengthRange() {
        return sepalLengthRange;
    }

    public double getSepalWidthRange() {
        return sepalWidthRange;
    }

    public double getPetalLengthRange() {
        return petalLengthRange;
    }

    public double getPetalWidthRange() {
        return petalWidthRange;
    }
}
