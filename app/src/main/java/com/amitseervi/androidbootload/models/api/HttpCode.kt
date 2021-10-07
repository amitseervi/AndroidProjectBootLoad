package com.amitseervi.androidbootload.models.api

enum class HttpCode(val code: Int) {
    OK(200),
    CREATED(201),
    ACCEPTED(202),
    NO_CONTENT(204),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    UNSUPPORTED_MEDIA_TYPE(415),
    INTERNAL_SERVER_ERROR(500),
    SERVICE_UNAVAILABLE(503),
    UNDEFINED(1000);

    companion object {
        fun fromCode(code: Int): HttpCode {
            return values().find { it.code == code } ?: UNDEFINED
        }
    }
}