package com.dsw.shoppingbag.db.util

class RemoteConfigVariables {
    companion object {
        var CACHE_SIZE = 5 * 1024 * 1024
        var MAX_STALE_TIME = 60 * 60 * 24 * 7
        var MAX_AGE = 5
    }
}