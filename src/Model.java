/**
 * Created by djokjula on 3.5.16..
 */
public class Model {
    // TODO: Add galaxy model
    Vektor lb, ub;
    int N; // Number of dimensions.
    public double getFitness(Vektor x) {
        return 0;
    }

    public Vektor getLb() {
        return lb;
    }

    public void setLb(Vektor lb) {
        this.lb = lb;
    }

    public Vektor getUb() {
        return ub;
    }

    public void setUb(Vektor ub) {
        this.ub = ub;
    }
}
