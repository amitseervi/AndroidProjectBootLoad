package com.amitseervi.androidbootload.exceptions

class SomethingWentWrongError : RuntimeException(MESSAGE), BaseException {
    companion object {
        private const val MESSAGE = "Content Not Found"
    }
}