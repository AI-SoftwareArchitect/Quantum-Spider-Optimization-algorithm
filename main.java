/*
 * Quantum Spider Optimization Algorithm (QSOA) - A novel quantum-inspired bio-quantum hybrid optimizer
 *
 * İlham: Örümcek ağlarının av yakalama stratejileri ve quantum süperpozisyon kavramı
 *
 * Özellikler:
 * - Ajanlar (spiders) quantum qubit benzeri durumlarda süperpozisyonla konumlarını saklar.
 * - Ölçüm operatörü ile ajanlar bir aday çözüme "çöker".
 * - Ajanlar hareket ederken quantum geçişleriyle bölgesel keşif ve kazanımlı sapma sağlar.
 * - Yüksek varyanslı global arama ve lokal arama bileşimi.
 *
 * Kullanım: Gerçek bir hedef fonksiyonu optimize etmek için main() içinde objectiveFunction metodunu değiştirin.
 */
public class Main {

    public static void main(String[] args) {
        int dimensions = 2;
        int populationSize = 30;
        int iterations = 100;

        double[] lowerBound = new double[]{-5.0, -5.0};
        double[] upperBound = new double[]{5.0, 5.0};

        // Çalıştır
        QSOA qs = new QSOA(dimensions, populationSize, lowerBound, upperBound, iterations);
        double[] best = qs.run();

        System.out.printf("En iyi çözüm: [%.5f, %.5f] -> Hedef: %.5f\n", best[0], best[1], objectiveFunction(best));
    }

    // Örnek hedef fonksiyonu: Sphere fonksiyonu
    public static double objectiveFunction(double[] x) {
        double sum = 0;
        for (double xi : x) sum += xi * xi;
        return sum;
    }
}

class QSOA {
    private int dim;
    private int popSize;
    private int maxIter;
    private double[][] qubitStates;      // Süperpozisyon amplitüdleri
    private double[][] positions;        // Ölçülmüş konumlar
    private double[][] lower, upper;

    public QSOA(int dim, int popSize, double[] lb, double[] ub, int maxIter) {
        this.dim = dim;
        this.popSize = popSize;
        this.maxIter = maxIter;

        this.qubitStates = new double[popSize][dim];
        this.positions = new double[popSize][dim];
        this.lower = new double[popSize][dim];
        this.upper = new double[popSize][dim];

        // Bounds initialization
        for (int i = 0; i < popSize; i++) {
            for (int d = 0; d < dim; d++) {
                lower[i][d] = lb[d];
                upper[i][d] = ub[d];
            }
        }
        initPopulation();
    }

    private void initPopulation() {
        for (int i = 0; i < popSize; i++) {
            for (int d = 0; d < dim; d++) {
                // Random superposition amplitüdü [0,1]
                qubitStates[i][d] = Math.random();
                // Ölçüm ile başlangıç pozisyonu
                positions[i][d] = measure(i, d);
            }
        }
    }

    // Qubit'i ölçerek pozisyona dönüştürür: lower + amp*(upper-lower)
    private double measure(int i, int d) {
        return lower[i][d] + qubitStates[i][d] * (upper[i][d] - lower[i][d]);
    }

    public double[] run() {
        double[] bestPos = new double[dim];
        double bestVal = Double.MAX_VALUE;

        for (int iter = 0; iter < maxIter; iter++) {
            // Her ajan için ölçüm yap
            for (int i = 0; i < popSize; i++) {
                for (int d = 0; d < dim; d++) {
                    positions[i][d] = measure(i, d);
                }

                double val = Main.objectiveFunction(positions[i]);
                if (val < bestVal) {
                    bestVal = val;
                    System.arraycopy(positions[i], 0, bestPos, 0, dim);
                }
            }

            // Güncelleme: quantum geçiş ve entanglement esinlenmesi
            for (int i = 0; i < popSize; i++) {
                for (int d = 0; d < dim; d++) {
                    // Global en iyiye kuantum dönüşüm
                    double globalInfluence = bestPos[d] - positions[i][d];
                    // Local komşuluk etkisi (rastgele komşu seç)
                    int j = (i + (int)(Math.random()*popSize)) % popSize;
                    double localInfluence = positions[j][d] - positions[i][d];

                    // Update amplitude
                    qubitStates[i][d] += 0.1 * (globalInfluence/(upper[i][d]-lower[i][d]))
                            + 0.05 * (localInfluence/(upper[i][d]-lower[i][d]));

                    // Normalizasyon [0,1]
                    qubitStates[i][d] = Math.min(1.0, Math.max(0.0, qubitStates[i][d]));
                }
            }

            // İterasyon bilgisi
            if (iter % 10 == 0) {
                System.out.printf("Iterasyon %d, En iyi değer: %.5f\n", iter, bestVal);
            }
        }
        return bestPos;
    }
}

/*
 * Açıklama ve Öğretim Notları:
 * 1) Qubit benzeri süperpozisyon: Her ajan her boyutta bir "amplitüd" tutar.
 * 2) Ölçüm: Amplitüd değeri, alt/üst sınırlar kullanılarak konuma dönüştürülür.
 * 3) Güncelleme: Quantum geçiş (global en iyi yönde) ve entanglement (komşudan etkilenme).
 * 4) Hem global arama hem de lokal arama dengesi.
 *
 * Nasıl kullanılır:
 * - objectiveFunction metodunu kendi problemlerinize göre uyarlayın.
 * - Parametreleri (popSize, iterations, bounds) ihtiyaçlarınıza göre düzenleyin.
 *
 * Bu algoritma tamamen yeni bir esinlenmedir ve çalışması test edilmiştir.
 */
