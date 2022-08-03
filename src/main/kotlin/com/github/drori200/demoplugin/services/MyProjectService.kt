package com.github.drori200.demoplugin.services

import com.intellij.openapi.project.Project
import com.github.drori200.demoplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
