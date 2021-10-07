package com.amitseervi.androidbootload.exceptions

class UnsupportedMediaTypeError : RuntimeException(MESSAGE), BaseException {
    companion object {
        private const val MESSAGE = "Uploaded file type not supported"
    }
}