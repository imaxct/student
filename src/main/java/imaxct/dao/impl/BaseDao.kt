package imaxct.dao.impl

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.hibernate.query.Query

import javax.annotation.Resource
import java.io.Serializable

open class BaseDao<T> {

    @Resource(name = "sessionFactory")
    private val sessionFactory: SessionFactory? = null

    protected fun currentSession(): Session = sessionFactory!!.currentSession

    fun create(t: T): Boolean {
        val session = currentSession()
        try {
            session.persist(t)
            return true
        } catch (e: Exception) {
            session.transaction.rollback()
            logger.error("create", e)
            return false
        }

    }

    fun delete(t: T): Boolean {
        val session = currentSession()
        try {
            session.delete(t)
            return true
        } catch (e: Exception) {
            session.transaction.rollback()
            logger.error("delete", e)
            return false
        }

    }

    fun update(t: T): Boolean {
        val session = currentSession()
        try {
            session.update(t)
            return true
        } catch (e: Exception) {
            session.transaction.rollback()
            logger.error("update", e)
            return false
        }

    }

    fun saveOrUpdate(t: T): Boolean {
        val session = currentSession()
        try {
            session.saveOrUpdate(t)
            return true
        } catch (e: Exception) {
            session.transaction.rollback()
            logger.error("saveOrUpdate", e)
            return false
        }

    }

    fun uniqueResult(hql: String, vararg objects: Any): T {
        val session = currentSession()
        val query = session.createQuery(hql)
        if (objects.isNotEmpty()) {
            for (i in objects.indices)
                query.setParameter(i, objects[i])
        }
        return query.uniqueResult() as T
    }

    fun find(clazz: Class<T>, id: Serializable): T {
        return currentSession().get(clazz, id)
    }

    fun list(hql: String, vararg objects: Any): List<T> {
        val session = currentSession()
        val query = session.createQuery(hql)
        if (objects.isNotEmpty()) {
            for (i in objects.indices) {
                query.setParameter(i, objects[i])
            }
        }

        return query.list() as List<T>
    }

    fun execute(hql: String, vararg objects: Any): List<T> {
        val session = currentSession()
        val query = session.createQuery(hql)
        if (objects.isNotEmpty()) {
            for (i in objects.indices) {
                query.setParameter(i, objects[i])
            }
        }
        return query.list() as List<T>
    }


    fun listPage(firstPage: Int, maxResult: Int, hql: String, vararg objects: Any): List<T> {
        val session = currentSession()
        val query = session.createQuery(hql)
        query.setFirstResult(firstPage).maxResults = maxResult
        if (objects.isNotEmpty()) {
            for (i in objects.indices) {
                query.setParameter(i, objects[i])
            }
        }
        return query.list() as List<T>
    }

    fun batchUpdate(vararg objects: Any): Boolean {
        if (objects.isNotEmpty()) {
            val session = currentSession()
            for (obj in objects) {
                session.update(obj)
            }
            return true
        }
        return false
    }

    fun batchInsert(vararg objects: Any): Boolean {
        if (objects.isNotEmpty()) {
            val session = currentSession()
            for (obj in objects) {
                session.persist(obj)
            }
            return true
        }
        return false
    }

    companion object {
        protected var logger: Logger = LogManager.getLogger(BaseDao::class.java)
    }
}
