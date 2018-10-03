package br.com.projsi.dao;

import java.util.List;

import org.hibernate.Criteria;

public interface IDaoGeneric<T> {

  void cadastrar(T t) throws DaoException;;
  void editar(T t) throws DaoException;;
  void remover(T t) throws DaoException;;
  T buscar(Long id) throws DaoException;;
  List<T> listar() throws DaoException;;
  Criteria getCriteria();   
}
