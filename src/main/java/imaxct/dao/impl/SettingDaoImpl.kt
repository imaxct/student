package imaxct.dao.impl

import imaxct.dao.ISettingDao
import imaxct.domain.Setting
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 * Created by imaxct on 17-4-30.
 * student
 */
@Repository
@Transactional
open class SettingDaoImpl: BaseDao<Setting>(), ISettingDao{
    override fun createOrUpdate(setting: Setting): Boolean = this.saveOrUpdate(setting)

    override fun listSetting(): List<Setting> = this.list("from Setting")

    override fun getSettingByName(name: String): Setting? = this.uniqueResult("from Setting where key=?", name)

    override fun updateSetting(setting: Setting): Boolean = this.update(setting)

    override fun createSetting(setting: Setting): Boolean = this.create(setting)
}