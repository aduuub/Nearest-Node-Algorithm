package nearest_node.flowers;

/**
 * Created by Adam on 21/03/17.
 */
public class IrisFactory {

    private IrisFactory(){
        // Cant init
    }

    public static Iris createIris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String type){
        switch(type){
            case "Iris-setosa":
                return new Setosa(sepalLength, sepalWidth, petalLength, petalWidth, type);

            case "Iris-versicolor":
                return new Versicolor(sepalLength, sepalWidth, petalLength, petalWidth, type);

            case "Iris-virginica":
                return new Virginica(sepalLength, sepalWidth, petalLength, petalWidth, type);

            default:
                throw new RuntimeException("Iris type not found");
        }
    }
}
