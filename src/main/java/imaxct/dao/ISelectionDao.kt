package imaxct.dao

import imaxct.domain.Course
import imaxct.domain.SelectPK
import imaxct.domain.Selection
import imaxct.domain.User

/**
 * Created by imaxct on 17-4-30.
 * student
 */
interface ISelectionDao {
    fun createSelection(selection: Selection): Boolean

    fun deleteSelection(selection: Selection): Boolean

    fun getSelectionByUser(user: User): List<Selection>

    fun getSelectionById(id: SelectPK): Selection?

    fun getSelectionByCourse(course: Course): List<Selection>
}