package io.ib67.oni

import kotlinx.serialization.Serializable
import org.gradle.api.artifacts.Dependency

@Serializable
data class OniDependency(val artifactId:String,val groupId:String,val version:String) {
    companion object {
        fun fromGradleDependency(dep: Dependency): OniDependency{
            return OniDependency(dep.name,dep.group!!,dep.version!!)
        }
    }
    var optional = false
    var boundedRepositories: String? = null
    fun asArtifactUrlPart(): String {
        return "$groupId/$artifactId/$version/$artifactId-$version.jar"
    }
}