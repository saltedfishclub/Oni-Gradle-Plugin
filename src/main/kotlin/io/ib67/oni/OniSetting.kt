package io.ib67.oni

import kotlinx.serialization.Serializable
import org.gradle.api.artifacts.Dependency
import kotlinx.serialization.Transient

@Serializable
open class OniSetting {
    var verbose = false
    var checkerList = mutableListOf<String>()
    var dependencies = mutableListOf<OniDependency>()
    var additionalRepos = mutableListOf<String>()
    @Transient
    var oniVersion:String? = "1.0-M1-dev-1"
    @Transient
    var bootstrapVersion:String? = "3.1"
    @Transient
    var genSettingTo = "resources/main/oni.setting.json"
}