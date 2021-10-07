package com.amitseervi.androidbootload.exceptions

class NotFoundError : RuntimeException(MESSAGE), BaseException {
    companion object {
        private const val MESSAGE = "Content not found"
    }
}