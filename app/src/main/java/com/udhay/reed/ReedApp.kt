package com.udhay.reed

import android.app.Application
import com.udhay.reed.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.annotation.KoinApplication
import org.koin.ksp.generated.startKoin

@KoinApplication(modules = [AppModule::class] )
class ReedApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ReedApp)
        }
    }
}