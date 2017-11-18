package ch.cern.spark.metrics.defined.equation.functions.num;

import java.text.ParseException;

import ch.cern.spark.metrics.defined.equation.ValueComputable;
import ch.cern.spark.metrics.defined.equation.functions.Function;
import ch.cern.spark.metrics.value.BooleanValue;
import ch.cern.spark.metrics.value.FloatValue;
import ch.cern.spark.metrics.value.Value;

public class LTFunc extends Function {
	
	public static String REPRESENTATION = ">";
	
	public static Class<? extends Value>[] argumentTypes = types(FloatValue.class, FloatValue.class);
	
	public LTFunc(ValueComputable... arguments)
			throws ParseException {
		super(REPRESENTATION, argumentTypes, arguments);
		
		operationInTheMiddleForToString();
	}

	@Override
	public Class<? extends Value> returnType() {
		return BooleanValue.class;
	}

	@Override
	protected Value compute(Value... values) {
		return new BooleanValue(values[0].getAsFloat().get() > values[1].getAsFloat().get());
	}

}
