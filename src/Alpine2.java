/**
 * Created by djokjula on 22.5.16..
 */
public class Alpine2 extends Model {
    @Override
    public double getFitness(Vektor x) {
        double ret = 0;
        for (int i = 0; i < x.x.length; i++) {
            ret *= Math.sqrt(x.x[i])*Math.sin(x.x[i]);
        }
        return ret;
    }
}
