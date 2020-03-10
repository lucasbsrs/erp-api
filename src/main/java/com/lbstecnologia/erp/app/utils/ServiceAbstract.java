package com.lbstecnologia.erp.app.utils;

import com.lbstecnologia.erp.exceptions.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import java.util.List;

public abstract class ServiceAbstract<T> {
	
	protected PageRequest getPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		if (page == null || page < 0) {
			return PageRequest.of(0, Integer.MAX_VALUE, Direction.valueOf(direction), orderBy);
		}
		
		return PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
	}

	protected void verificaObjeto(Object[] objetos, String msg) {
		if (objetos == null || objetos.length == 0) {
			throw new ObjectNotFoundException(msg);
		}
	}

	protected void verificaObjeto(Page<T> objetos, String msg) {
		if (objetos == null || objetos.isEmpty()) {
			throw new ObjectNotFoundException(msg);
		}
	}	
	
	protected void verificaObjeto(List<T> objetos, String msg) {
		if (objetos == null || objetos.isEmpty()) {
			throw new ObjectNotFoundException(msg);
		}
	}

	protected void verificaObjeto(Object objeto, String msg) {
		if (objeto == null) {
			throw new ObjectNotFoundException(msg);
		}
	}
	
	protected Pageable checkPageable(Pageable pageable, Direction direcao, String atributo) {
		if (pageable.getSort().isUnsorted()) {
			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), direcao, atributo);
		}
		return pageable;
	}
}
