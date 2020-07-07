buildscript {
    repositories { 
        jcenter()
    }
}

plugins {
    idea
}

allprojects {
    repositories {
        mavenCentral()
    }

    val gitVersion: String? = "git rev-list HEAD --count".runCommand(file("$rootDir"))

    group = "com.nami.backend"
    project.version = "0.1-$gitVersion"
}
fun String.runCommand(workingDir: File): String? {
    return try {
        val parts = this.split("\\s".toRegex())
        val proc = ProcessBuilder(*parts.toTypedArray())
                .directory(workingDir)
                .redirectOutput(ProcessBuilder.Redirect.PIPE)
                .redirectError(ProcessBuilder.Redirect.PIPE)
                .start()

        proc.waitFor(1, TimeUnit.SECONDS)
        proc.inputStream.bufferedReader().readLine().trim()
    } catch(e: java.io.IOException) {
        e.printStackTrace()
        null
    }
}