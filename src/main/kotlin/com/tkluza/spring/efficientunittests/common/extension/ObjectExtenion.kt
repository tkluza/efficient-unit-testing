package com.tkluza.spring.efficientunittests.common.extension

fun <T> T?.isNull(): Boolean = this == null

fun <T> T?.isNotNull(): Boolean = !isNull()