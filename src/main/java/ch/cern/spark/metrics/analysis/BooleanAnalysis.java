package ch.cern.spark.metrics.analysis;

import java.time.Instant;

import ch.cern.spark.metrics.Metric;
import ch.cern.spark.metrics.results.AnalysisResult;
import ch.cern.spark.metrics.results.AnalysisResult.Status;

public abstract class BooleanAnalysis extends Analysis {

    private static final long serialVersionUID = -1822474093334300773L;

	@Override
	public AnalysisResult process(Metric metric) {
		if(!metric.getValue().getAsBoolean().isPresent()) {
			AnalysisResult result = AnalysisResult.buildWithStatus(Status.EXCEPTION, "Current analysis requires metrics of boolean type."); 
			result.setAnalyzedMetric(metric);
			
	        return result;
		}
		
		return process(metric.getInstant(), metric.getValue().getAsBoolean().get());
	}

    public abstract AnalysisResult process(Instant timestamp, boolean value);

}
    
