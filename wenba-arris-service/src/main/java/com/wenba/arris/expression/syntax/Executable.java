package com.wenba.arris.expression.syntax;

import com.wenba.arris.expression.tokens.Valuable;

/**
 * 可执行动作接口
 * @author shanxuecheng
 *
 */
public interface Executable {
	/**
	 * 参数个数
	 * @return
	 */
	public int getArgumentNum();
	
	/**
	 * 执行运算，返回结果
	 * @param arguments
	 * @return
	 * @throws ArgumentsMismatchException
	 */
	public Valuable execute(Valuable[] arguments) throws ArgumentsMismatchException;
	
}
