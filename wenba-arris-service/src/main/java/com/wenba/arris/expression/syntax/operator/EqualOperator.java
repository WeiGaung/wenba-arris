package com.wenba.arris.expression.syntax.operator;

import com.wenba.arris.expression.syntax.ArgumentsMismatchException;
import com.wenba.arris.expression.tokens.DataType;
import com.wenba.arris.expression.tokens.Valuable;

public class EqualOperator extends BinaryOperator {

	public EqualOperator() {
		super("EQUAL");
	}

	@Override
	public Object operate(Valuable[] arguments)
			throws ArgumentsMismatchException {
		Object result = null;
		Valuable a1 = arguments[0];
		Valuable a2 = arguments[1];
		if (a1.getDataType() == DataType.NUMBER
				&& a2.getDataType() == DataType.NUMBER) {
			result = a1.getNumberValue().compareTo(a2.getNumberValue()) == 0;
		} else if (a1.getDataType() == DataType.STRING
				&& a2.getDataType() == DataType.STRING) {
			result = a1.getStringValue().equals(a2.getStringValue());
		} else if (a1.getDataType() == DataType.CHARACTER
				&& a2.getDataType() == DataType.CHARACTER) {
			result = a1.getCharValue().equals(a2.getCharValue());
		} else if (a1.getDataType() == DataType.DATE
				&& a2.getDataType() == DataType.DATE) {
			result = a1.getDateValue().equals(a2.getDateValue());

			/**
			 * 	GB
			 * 	原来条件参数判断必须赋值或者"",否则抛异常
			 * 	修改成,跳出
			 * 	跳出后dataType和value都为null
			 * 	所以增加null判断
			 */

		} else if((null == a1.getDataType() || null == a2.getDataType()) && (null == a1.getValue() || null == a2.getValue())) {
			result = false;
		} else {
			throw new ArgumentsMismatchException(arguments, "==");
		}
		return result;
	}
}
