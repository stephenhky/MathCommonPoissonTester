package poissontest;

public class PoissonTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (double lambda=0.5; lambda<100; lambda+=0.5) {
			PoissonParameterBean parameters = new PoissonParameterBean(lambda);
			PoissonTestingWrapper poissonTester = new PoissonTestingWrapper(parameters);
			System.out.println("lambda = "+lambda+" : consistent? "+poissonTester.isSampledDistributionConsistent());
		}
	}

}
