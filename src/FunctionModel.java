/**
 * Created by djokjula on 22.5.16..
 */
public class FunctionModel extends Model {
    @Override
    public double getFitness(Vektor x) {
        return x.x[0]*x.x[0];
    }
}
