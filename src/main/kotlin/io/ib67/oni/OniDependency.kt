package io.ib67.oni

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import org.gradle.api.artifacts.Dependency

@Serializable
data class OniDependency(
    val groupId: String,
    val artifactId: String,
    val version: String,
    val classifier: String?=null,
    val packagingType: String?=null,
    val optional: Boolean=false
    ) {
    companion object {
        fun fromGradleDependency(dep: Dependency): OniDependency{
            return OniDependency(dep.group!!,dep.name,dep.version!!)
        }
    }

}