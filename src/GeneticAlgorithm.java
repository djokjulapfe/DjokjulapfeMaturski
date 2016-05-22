import java.util.Random;

/**
 * Created by djokjula on 3.5.16..
 */
public class GeneticAlgorithm extends Optimization{
    Vektor[] dna;
    Vektor fitness;
    int P;
    int Pcut;
    double mutationRate;

    GeneticAlgorithm(Model M, int P) {
        this.M = M;
        this.P = P;
        dna = new Vektor[P];
        Pcut = (int) (P * 0.1);
        mutationRate = 0.01;
    }

    @Override
    public void update() {
        for (int i = 0; i < P; i++) {
            fitness.x[i] = M.getFitness(dna[i]);
        }
        for (int i = 0; i < P - 1; i++) {
            for (int j = i + 1; j < P; j++) {
                if (fitness.x[i] > fitness.x[j]) {
                    double t = fitness.x[i];
                    fitness.x[i] = fitness.x[j];
                    fitness.x[j] = t;
                    Vektor td = dna[i].clone();
                    dna[i] = dna[j].clone();
                    dna[j] = td;
                }
            }
        }
        global = dna[0];
        globalFitness = fitness.x[0];
        Vektor[] tmpdna = new Vektor[Pcut];
        for (int i = 0; i < Pcut; i++) {
            tmpdna[i] = dna[i].clone();
        }
        Random r = new Random();
        for (int i = 0; i < P; i++) {
            Vektor g1 = tmpdna[r.nextInt() % Pcut];
            Vektor g2 = tmpdna[r.nextInt() % Pcut];
            Vektor n = new Vektor(M.N);
            int k = r.nextInt()%M.N;
            for (int j = 0; j < k; j++) {
                n.x[j] = g1.x[j];
            }
            for (int j = k; j < M.N; j++) {
                n.x[j] = g2.x[j];
            }
            for (int j = 0; j < M.N; j++) {
                if(r.nextDouble()<mutationRate) {
                    n.x[j] = r.nextDouble();
                }
            }
        }
    }
}
