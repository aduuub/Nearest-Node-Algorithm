package nearest_node.flowers;

import nearest_node.IrisRange;

/**
 * Created by Adam on 21/03/17.
 */
public abstract class Iris {

    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;

    private String irisType;

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String irisType) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.irisType = irisType;
    }

    public double getSepalLength() {
        return sepalLength;
    }

    public double getSepalWidth() {
        return sepalWidth;
    }

    public double getPetalLength() {
        return petalLength;
    }

    public double getPetalWidth() {
        return petalWidth;
    }

    public String getIrisType() {
        return irisType;
    }

    public double distanceToOtherIris(Iris other, IrisRange range){
        double sepalLengthDistance = Math.pow(sepalLength - other.sepalLength, 2) / Math.pow(range.getSepalLengthRange(), 2);
        double sepalWidthDistance = Math.pow(sepalWidth - other.sepalWidth, 2) / Math.pow(range.getSepalWidthRange(), 2);
        double petalLengthDistance = Math.pow(petalLength - other.petalLength, 2) / Math.pow(range.getPetalLengthRange(), 2);
        double petalWidthDistance = Math.pow(petalWidth - other.petalWidth, 2) / Math.pow(range.getPetalWidthRange(), 2);

        return Math.sqrt(sepalLengthDistance + sepalWidthDistance + petalLengthDistance + petalWidthDistance);
    }
}
