package com.udhay.reed.di

import org.koin.core.annotation.ComponentScan
import org.koin.core.annotation.Configuration
import org.koin.core.annotation.Module

@Module(includes = [NetworkModule::class])
@ComponentScan("com.udhay.reed")
@Configuration
class AppModule
