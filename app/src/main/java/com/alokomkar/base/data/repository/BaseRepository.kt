package com.alokomkar.base.data.repository

import com.alokomkar.base.data.ServiceLocator

abstract class BaseRepository {
    val serviceLocator = ServiceLocator.instance
}