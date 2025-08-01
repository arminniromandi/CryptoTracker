package com.plcoding.cryptotracker.core.domain.utils

enum class NetworkError: Error{
    REQUEST_TIMEOUT,
    TOO_MANY_REQUEST,
    SERVER_ERROR,
    NO_INTERNET,
    SERIALIZATION,
    UNKNOWN

}
