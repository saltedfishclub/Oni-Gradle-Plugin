package io.ib67.oni

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
open class OniSetting {
    var oniVersion: String?=null
    @Transient
    var autoAddBootstrap=true
    @Transient
    var autoAddOni=true
    @Transient
    var bootstrapVersion="1.0"
    var additionalRepositories= mutableListOf<String>()
    var dependencies = mutableListOf<OniDependency>()
}