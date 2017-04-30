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
class SettingDaoImpl: BaseDao<Setting>(), ISettingDao{
    override fun getSettingByName(name: String): Setting? {
        return null
    }

    override fun updateSetting(setting: Setting): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createSetting(setting: Setting): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}