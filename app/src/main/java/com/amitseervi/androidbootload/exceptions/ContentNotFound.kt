package com.amitseervi.androidbootload.exceptions

class ContentNotFound : RuntimeException(MESSAGE), BaseException {
    companion object {
        private const val MESSAGE = "Content Not Found"
    }
}