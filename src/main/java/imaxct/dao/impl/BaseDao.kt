package imaxct.dao.impl

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.hibernate.Session
import org.hibernate.SessionFactory

import javax.annotation.Resource
import java.io.Serializable

open class BaseDao<T> {

    @Resource(name = "sessionFactory")
    private val sessionFactory: SessionFactory? = null

    private fun currentSession(): Session = sessionFactory!!.currentSession

    fun create(t: T): Boolean {
        val session = currentSession()
        return try {
            session.persist(t)
            true
        } catch (e: Exception) {
            session.transaction.rollback()
            logger.error("create", e)
            false
        }

    }

    fun delete(t: T): Boolean {
        val session = currentSession()
        return try {
            session.delete(t)
            true
        } catch (e: Exception) {
            session.transaction.rollback()
            logger.error("delete", e)
            false
        }

    }

    fun update(t: T): Boolean {
        val session = currentSession()
        return try {
            session.update(t)
            true
        } catch (e: Exception) {
            session.transaction.rollback()
            logger.error("update", e)
            false
        }

    }

    fun saveOrUpdate(t: T): Boolean {
        val session = currentSession()
        return try {
            session.saveOrUpdate(t)
            true
        } catch (e: Exception) {
            session.transaction.rollback()
            logger.error("saveOrUpdate", e)
            false
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

    fun batchUpdate(list: List<T>): Boolean {
        if (list.isNotEmpty()) {
            val session = currentSession()
            for ((cnt, obj) in list.withIndex()) {
                session.update(obj)
                if (cnt % 50 == 0){
                    session.flush()
                    session.clear()
                }
            }
            return true
        }
        return false
    }

    fun batchInsert(list: List<T>): Boolean {
        if (list.isNotEmpty()) {
            val session = currentSession()
            for ((cnt, obj) in list.withIndex()) {
                session.persist(obj)
                if (cnt % 50 == 0) {
                    session.flush()
                    session.clear()
                }
            }
            return true
        }
        return false
    }

    fun query(hql: String, vararg objects: Any): Int{
        val session = currentSession()
        val query = session.createQuery(hql)
        for ((i, x) in objects.withIndex()) query.setParameter(i, x)
        return query.executeUpdate()
    }

    companion object {
        protected var logger: Logger = LogManager.getLogger(BaseDao::class.java)
    }
}
