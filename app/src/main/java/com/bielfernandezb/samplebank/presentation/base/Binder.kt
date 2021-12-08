package com.bielfernandezb.samplebank.presentation.base

internal interface Binder<T> {
    fun bind(data: T)
}