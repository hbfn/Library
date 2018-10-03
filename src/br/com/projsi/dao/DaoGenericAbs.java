package br.com.projsi.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import br.com.projsi.utils.PersistenceUtil;

public abstract class DaoGenericAbs<T> implements IDaoGeneric<T> {

  EntityManager manager;
  private Class classe;

  public DaoGenericAbs() {
    manager = PersistenceUtil.getEntityManager();
    classe = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
  }

  
  public void cadastrar(T t) throws DaoException {
    try {
      manager.getTransaction().begin();    
      manager.persist(t);
      manager.getTransaction().commit();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("Deu Ruim o cadastro!");
    }
    
  }
  
  public void cadastrarEmprestimo(T t) throws DaoException {
	    try {
	      manager.getTransaction().begin();    
	      manager.persist(t);
	      manager.getTransaction().commit();
	    } catch (Exception e) {
	      manager.getTransaction().rollback();
	      throw new DaoException("Deu Ruim o Empréstimo!");
	    }
	  }

  public void editar(T t) throws DaoException {
    try {
      manager.getTransaction().begin();    
      manager.merge(t);
      manager.getTransaction().commit();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("Deu Ruim!");
    }
    
  }

  public void remover(T t) throws DaoException {
    try {
      manager.getTransaction().begin();    
      manager.remove(t);
      manager.getTransaction().commit();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("Deu Ruim!");
    }
  }

  public T buscar(Long id) throws DaoException {
    try {
      return (T) manager.find(classe, id);
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("Deu Ruim!");
    }
  }
  
  public T buscarPorCpf(String cpf) throws DaoException {
	  try {
		  Criteria criteria = getCriteria();
		  criteria.add(Expression.eq("numeroDocumento", cpf));
		  return (T) criteria.list().get(0);
	  } catch (Exception e) {
		  manager.getTransaction().rollback();
		  throw new DaoException("Deu algo errado!");
	  }
  }

  public List<T> listar() throws DaoException {
    try {
      Criteria criteria = getCriteria();
      criteria.addOrder(Order.asc("id")); //orderBy id;
      return (List<T>) criteria.list();
    } catch (Exception e) {
      manager.getTransaction().rollback();
      throw new DaoException("Deu Ruim!");
    }
  }

  public Criteria getCriteria() {
    Session session = ((Session) manager.getDelegate());
    Criteria criteria = session.createCriteria(classe);
    return criteria;
  }
}
