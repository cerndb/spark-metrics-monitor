package ch.cern.spark.metrics.defined.equation.functions.bool;

import java.text.ParseException;

import ch.cern.spark.metrics.defined.equation.ValueComputable;
import ch.cern.spark.metrics.defined.equation.functions.Function;
import ch.cern.spark.metrics.value.BooleanValue;
import ch.cern.spark.metrics.value.Value;

public class NotEqualFunc extends Function {
	
	public static String REPRESENTATION = "!=";

	public static Class<? extends Value>[] argumentTypes = types(Value.class, Value.class);

	public NotEqualFunc(ValueComputable... arguments) throws ParseException {
		super(REPRESENTATION, argumentTypes, arguments);

		operationInTheMiddleForToString();
	}

	@Override
	public Class<BooleanValue> returnType() {
		return BooleanValue.class;
	}

	@Override
	protected Value compute(Value... values) {
		return new BooleanValue(!values[0].equals(values[1]));
	}
		
}
