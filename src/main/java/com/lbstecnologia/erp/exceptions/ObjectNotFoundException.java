package com.lbstecnologia.erp.exceptions;

import java.util.HashMap;
import java.util.Map;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
	private Map<String, Object> map = new HashMap<>();

	public static final String ALUNO_NAO_ENCONTRADO = "Aluno não encontrado";

	public ObjectNotFoundException(String msg) {
		super(msg);
	}

	public ObjectNotFoundException(String msg, Map<String, Object> map) {
		this(msg);
		this.map = map;
	}

	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public Map<String, Object> getMap() {
		return map;
	}
}
