package com.amitseervi.androidbootload.exceptions

class InternalServerError : RuntimeException(MESSAGE), BaseException {
    companion object {
        private const val MESSAGE = "Internal Server error"
    }
}