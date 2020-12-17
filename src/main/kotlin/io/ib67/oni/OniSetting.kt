package io.ib67.oni

import kotlinx.serialization.Serializable

@Serializable
open class OniSetting {
    var oniVersion: String?=null
    var additionalRepositories= mutableListOf<String>()
    var dependencies = mutableListOf<OniDependency>()
}