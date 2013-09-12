package gov.nih.cit.htjoin.poissontest;

public class PoissonParameterBean extends DistributionParametersBean {
	private double lambda;

	public PoissonParameterBean(double lambda) {
		super();
		this.lambda = lambda;
	}

	public double getLambda() {
		return lambda;
	}

	public void setLambda(double lambda) {
		this.lambda = lambda;
	}
	
	public static PoissonParameterBean getDefaultParameters() {
		PoissonParameterBean parameters = new PoissonParameterBean(1.5);
		return parameters;
	}
}
