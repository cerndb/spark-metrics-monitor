package ch.cern.spark.metrics.defined.equation.functions.num;

import java.text.ParseException;

import ch.cern.spark.metrics.defined.equation.ValueComputable;
import ch.cern.spark.metrics.defined.equation.functions.FunctionCaller;
import ch.cern.spark.metrics.value.Value;

public class SinFunc extends NumericFunction {
	
	public static String REPRESENTATION = "sin";

	public SinFunc(ValueComputable... v) throws ParseException {
		super(REPRESENTATION, v);
	}

	@Override
	public float compute(float value) {
		return (float) Math.sin(Math.toRadians(value));
	}
	
	public static class Caller implements FunctionCaller{
		
		@Override
		public String getFunctionRepresentation() {
			return REPRESENTATION;
		}

		@Override
		public Class<? extends Value>[] getArgumentTypes() {
			return argumentTypes;
		}

		@Override
		public ValueComputable call(ValueComputable... arguments) throws ParseException {
			return new SinFunc(arguments);
		}
		
	}

}
