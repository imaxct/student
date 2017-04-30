package imaxct.dao.impl

import imaxct.dao.ISelectionDao
import imaxct.domain.Course
import imaxct.domain.SelectPK
import imaxct.domain.Selection
import imaxct.domain.User

/**
 * Created by imaxct on 17-4-30.
 * student
 */
class SelectionDaoImpl: BaseDao<Selection>(), ISelectionDao {

    override fun getSelectionById(id: SelectPK): Selection? = this.find(Selection::class.java, id)

    override fun createSelection(selection: Selection): Boolean = this.create(selection)

    override fun deleteSelection(selection: Selection): Boolean = this.delete(selection)

    override fun getSelectionByUser(user: User): List<Selection>
            = this.list("from Selection where id.user=?", user)

    override fun getSelectionByCourse(course: Course): List<Selection>
            = this.list("from Selection where id.course=?", course)
}