package com.mercandalli.android.studio.on_boarding

interface OnBoardingStorage {

    fun increaseNumberOfLoad()

    fun getNumberOfLoadPersisted(): Int
}
