package com.amitseervi.androidbootload.models.app

import androidx.annotation.IntDef
import com.amitseervi.androidbootload.exceptions.*
import com.amitseervi.androidbootload.models.api.HttpCode

data class RepositoryResult<T>(
    val data: T? = null,
    val error: BaseException? = null,
    @RepositoryResultStatus
    val status: Int
) {
    companion object {
        fun <T> ok(data: T): RepositoryResult<T> {
            return RepositoryResult(data = data, status = RepositoryResultStatus.LOADED)
        }

        fun <T> loading(): RepositoryResult<T> {
            return RepositoryResult(status = RepositoryResultStatus.IN_PROGRESS)
        }

        fun <T> error(error: BaseException?): RepositoryResult<T> {
            return RepositoryResult(error = error, status = RepositoryResultStatus.LOADED)
        }

        fun notFound(): RepositoryResult<SessionState> {
            return error(ContentNotFound())
        }

        fun <T> errorFromHttpCode(code: Int): RepositoryResult<T> {
            when (HttpCode.fromCode(code)) {
                HttpCode.FORBIDDEN -> {
                    return error(
                        AccessForbidden()
                    )
                }
                HttpCode.INTERNAL_SERVER_ERROR -> {
                    return error(
                        InternalServerError()
                    )
                }
                HttpCode.NOT_FOUND -> {
                    return error(
                        NotFoundError()
                    )
                }
                HttpCode.SERVICE_UNAVAILABLE -> {
                    return error(
                        ServiceUnavailableError()
                    )
                }
                HttpCode.UNSUPPORTED_MEDIA_TYPE -> {
                    return error(
                        UnsupportedMediaTypeError()
                    )
                }
                else -> {
                    return error(
                        SomethingWentWrongError()
                    )
                }
            }
        }
    }
}

@IntDef(value = [RepositoryResultStatus.INIT, RepositoryResultStatus.IN_PROGRESS, RepositoryResultStatus.LOADED])
annotation class RepositoryResultStatus {
    companion object {
        const val INIT = 0
        const val IN_PROGRESS = 1
        const val LOADED = 2
    }
}