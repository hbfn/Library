package br.com.projsi.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public final class PersistenceUtil {

  private static final String PERSISTENCE_UNIT_NAME = "dao";
  private static EntityManagerFactory entityManagerFactory = null;
  private static EntityManager entityManager = null;

  private PersistenceUtil() {
  }

  static {
    try {
      entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // SINGLETON
  public static EntityManager getEntityManager() {
    try {
      if (entityManager == null || !entityManager.isOpen()) {
        entityManager = entityManagerFactory.createEntityManager();
      }
      return entityManager;
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public static void closeEntityManager() {
    try {
      if (entityManager != null) {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
          transaction.commit();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      entityManager.close();
    }
  }

  public static void closeEntityManagerFactory() {
    closeEntityManager();
    entityManagerFactory.close();
  }
}
