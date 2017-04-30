package imaxct.dao

import imaxct.domain.Setting

/**
 * Created by imaxct on 17-4-30.
 * student
 */
interface ISettingDao {
    fun createSetting(setting: Setting): Boolean

    fun getSettingByName(name: String): Setting?

    fun updateSetting(setting: Setting): Boolean
}