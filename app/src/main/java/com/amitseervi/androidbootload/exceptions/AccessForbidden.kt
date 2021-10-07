package com.amitseervi.androidbootload.exceptions

class AccessForbidden : RuntimeException(MESSAGE), BaseException {
    companion object {
        private const val MESSAGE = "You do not have access to perform this action"
    }
}