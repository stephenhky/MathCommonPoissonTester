package poissontest;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.distribution.PoissonDistribution;

public class PoissonTestingWrapper extends DistributionTestingWrapper {
	protected PoissonDistribution poisson;
	private PoissonParameterBean poiParameters;
	
	public PoissonTestingWrapper(DistributionParametersBean parameters) {
		super(parameters);
		if (!(parameters instanceof PoissonParameterBean)) {
			throw new WrongBeanTypeException();
		}
		poiParameters = (PoissonParameterBean)parameters;
		poisson = new PoissonDistribution(poiParameters.getLambda());
	}

	@Override
	public List<Double> getSamples(Integer num) {
		List<Double> samples = new ArrayList<Double>();
		for (int i=0; i<num; i++) {
			samples.add((double)poisson.sample());
		}
		return samples;
	}
	
	private Integer getMaxNumberToTest() {
		Double maxNum = poisson.getMean() + 3*Math.sqrt(poisson.getMean());
		return maxNum.intValue();
	}

	@Override
	public double[] getExpectedBins() {
		int maxNumToTest = getMaxNumberToTest();
		double[] expectedBins = new double[maxNumToTest];
		for (int i=0; i<maxNumToTest; i++) {
			expectedBins[i] = num * poisson.probability(i);
		}
		return expectedBins;
	}

	@Override
	public long[] getObservedBins() {
		int maxNumToTest = getMaxNumberToTest();
		long[] observedBins = new long[maxNumToTest];
		for (int i=0; i<maxNumToTest; i++) {
			observedBins[i] = 0L;
		}
		List<Double> samples = getSamples(num);
		for (Double sample: samples) {
			if (sample.intValue() < maxNumToTest) {
				observedBins[sample.intValue()] += 1;
			}
		}
		return observedBins;
	}

}
