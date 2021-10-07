package com.amitseervi.androidbootload.exceptions

class ServiceUnavailableError : RuntimeException(MESSAGE), BaseException {
    companion object {
        private const val MESSAGE = "Service is temporarily Unavailable"
    }
}