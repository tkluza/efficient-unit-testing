package com.tkluza.spring.efficientunittests.common.mapper

interface BaseMapper<IN, OUT> {

    fun map(input: IN): OUT

    fun mapCollection(inputs: Collection<IN>): Collection<OUT> =
        inputs.map { map(it) }
}