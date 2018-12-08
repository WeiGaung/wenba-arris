package com.wenba.arris.expression.lexical;

import com.wenba.arris.expression.lexical.dfa.DFAMidState;

/**
 * 词法异常
 * @author shanxuecheng
 *
 */
@SuppressWarnings("serial")
public class LexicalException extends RuntimeException{
	
	public LexicalException() {
		super();
	}

	public LexicalException(String message) {
		super(message);
	}
	
	public LexicalException(String message, int line, int column) {
		this(message + " At line:" + line + ", column:" + column + ".");
	}
	
	public LexicalException(DFAMidState state, int line, int column) {
		this(state.getErrorMessage(), line, column);
	}
}