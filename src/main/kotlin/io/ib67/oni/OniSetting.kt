package io.ib67.oni

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.gradle.api.artifacts.Dependency

@Serializable
open class OniSetting {
    var verbose=false
    var oniVersion: String?=null
    @Transient
    var autoAddBootstrap=true
    @Transient
    var autoAddOni=true
    @Transient
    var bootstrapVersion="3.1"
    var additionalRepositories= mutableListOf<String>()
    var dependencies = mutableListOf<OniDependency>()
}