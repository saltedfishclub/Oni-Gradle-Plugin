package io.ib67.oni

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import java.io.File
import java.net.URI

class Linker : Plugin<Project> {
    val DEFAULT_ONI_VERSION="1-1.0"
    lateinit var oniSettings: OniSetting
    lateinit var conf: Configuration
    lateinit var project: Project
    override fun apply(project: Project) {
        oniSettings=project.extensions.create("oni",OniSetting::class.java)
        conf=project.configurations.create("dynamicLoads")
        this.project=project
        project.task("generateOniSetting").doLast{
            generateOniSettings()
        }
        project.getTasksByName("processResources",false).stream().findFirst().get().doLast {
            generateOniSettings()
        }

    }
    private fun generateOniSettings(){
        val deps= mutableListOf<OniDependency>()
        conf.dependencies.forEach { deps.add(OniDependency.fromGradleDependency(it)) }
        oniSettings.dependencies.addAll(deps)
        if(oniSettings.oniVersion==null){
            oniSettings.oniVersion=DEFAULT_ONI_VERSION;
        }
        val json=Json.encodeToString(oniSettings)
        val oniSetJson=File(project.buildDir,"resources/main/oni.setting.json")
        oniSetJson.createNewFile()
        oniSetJson.writeText(json)
        println("Oni Bootstrap file was generated! Using Oni ${oniSettings.oniVersion}")
    }
}