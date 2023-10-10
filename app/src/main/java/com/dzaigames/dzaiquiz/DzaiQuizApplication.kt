package com.dzaigames.dzaiquiz

import android.app.Application
import com.dzaigames.dzaiquiz.dagger.ApplicationComponent
import com.dzaigames.dzaiquiz.dagger.DaggerApplicationComponent

class DzaiQuizApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}