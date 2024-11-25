package com.example.kidlock.persentation.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

fun <T1, T2, R> compose(l1: LiveData<T1>, l2: LiveData<T2>, combiner: (T1?, T2?) -> R?): LiveData<R> {
    val mediator = MediatorLiveData<R>()
    mediator.addSource(l1) {
        mediator.value = combiner(it, l2.value)
    }

    mediator.addSource(l2) {
        mediator.value = combiner(l1.value, it)
    }
    return mediator
}

fun <T1, T2, T3, R> compose(l1: LiveData<T1>, l2: LiveData<T2>, l3: LiveData<T3>, combiner: (T1?, T2?, T3?) -> R?): LiveData<R> {
    val mediator = MediatorLiveData<R>()
    mediator.addSource(l1) {
        mediator.value = combiner(it, l2.value, l3.value)
    }

    mediator.addSource(l2) {
        mediator.value = combiner(l1.value, it, l3.value)
    }

    mediator.addSource(l3) {
        mediator.value = combiner(l1.value, l2.value, it)
    }
    return mediator
}

fun <T, R> compose(combiner: (List<T?>) -> R?, l1: LiveData<T>, l2: LiveData<T>, vararg others: LiveData<T>): LiveData<R> {
    val sources = listOf(l1, l2) + others
    val mediator = MediatorLiveData<R>()
    sources.forEachIndexed { addIndex, liveData ->
        mediator.addSource(liveData) {
            val data = sources.mapIndexed { index, liveData ->
                if (index != addIndex) {
                    return@mapIndexed liveData.value
                }
                return@mapIndexed it
            }
            mediator.value = combiner(data)
        }
    }

    return mediator
}
