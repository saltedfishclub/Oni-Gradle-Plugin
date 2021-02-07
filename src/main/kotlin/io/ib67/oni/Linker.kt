package io.ib67.oni

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.Configuration
import java.io.File
import java.net.URI

class Linker : Plugin<Project> {
    val DEFAULT_ONI_VERSION="1.0-M1-dev-1"
    lateinit var oniSettings: OniSetting
    lateinit var conf: Configuration
    lateinit var project: Project
    override fun apply(project: Project) {
        oniSettings=project.extensions.create("oni",OniSetting::class.java)
        conf=project.configurations.maybeCreate("oniRuntime")
        project.repositories.maven {
            it.url=URI.create("https://repo.sfclub.cc/releases/")
            it.name="S.F Official"
        }
        project.repositories.maven {
            it.url=URI.create("https://repo.sfclub.cc/snapshots/")
            it.name="S.F Official Snapshot"
        }
        this.project=project
        project.afterEvaluate{
            project.configurations.getByName("compileOnly").dependencies.addAll(conf.allDependencies)
            project.configurations.getByName("testCompileOnly").dependencies.addAll(conf.allDependencies)
            if(oniSettings.bootstrapVersion != null){
                project.configurations.getByName("compile").dependencies.add(project.dependencies.create("io.ib67.oni:BootStrap:${oniSettings.bootstrapVersion}"))
            }
            if(oniSettings.oniVersion!=null){
                project.configurations.getByName("compileOnly").dependencies.add(project.dependencies.create("io.ib67.oni:Oni-all:${oniSettings.oniVersion}"))
            }
        }
        project.getTasksByName("processResources",false).stream().findFirst()
            .get().doLast {
            generateOniSettings()
        }

    }
    private fun generateOniSettings(){
        val deps= mutableListOf<OniDependency>()
        if(oniSettings.oniVersion!=null){
            deps.add(OniDependency("io.ib67.oni","Oni-all", oniSettings.oniVersion!!,"all","jar",false))
        }
        conf.dependencies.forEach {
            println("Attempting to add ${it.name}")
            deps.add(OniDependency.fromGradleDependency(it))
        }
        oniSettings.dependencies.addAll(deps)
        oniSettings.checkerList.add("io.ib67.oni.internal.MavenDependencyEnvChecker")
        val json=Json.encodeToString(oniSettings)
        val oniSetJson=File(project.buildDir,oniSettings.genSettingTo)
        oniSetJson.createNewFile()
        oniSetJson.writeText(json)
        println("Oni Bootstrap file was generated!")
    }
}