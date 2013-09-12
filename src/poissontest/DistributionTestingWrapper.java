package poissontest;

import java.util.List;

import org.apache.commons.math3.stat.inference.ChiSquareTest;

public abstract class DistributionTestingWrapper {
	protected DistributionParametersBean parameters;
	protected double alpha = 0.05;
	protected int num = 1000;
	protected ChiSquareTest chiSquareTest;
	
	public DistributionTestingWrapper(DistributionParametersBean parameters) {
		super();
		this.parameters = parameters;
		chiSquareTest = new ChiSquareTest();
	}

	abstract public List<Double> getSamples(Integer num);
	abstract public double[] getExpectedBins();
	abstract public long[] getObservedBins();

	public Double getAlpha() {
		return alpha;
	}

	public void setAlpha(double alpha) {
		this.alpha = alpha;
	}
	
	public Boolean isChiSquareTestPassed() {
		return chiSquareTest.chiSquareTest(getExpectedBins(), getObservedBins(), alpha);
	}
	
	public Boolean isSampledDistributionConsistent() {
		return !isChiSquareTestPassed();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
