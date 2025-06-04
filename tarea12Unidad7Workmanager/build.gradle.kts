buildscript {
    extra.apply {
        set("compose_compiler_version", "1.5.3")
        set("lifecycle_version", "2.8.7")
    }
}

plugins {
    id("com.android.application") version "8.8.0" apply false
    id("com.android.library") version "8.8.0" apply false
    id("org.jetbrains.kotlin.android") version "2.1.0" apply false
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.0" apply false
}
