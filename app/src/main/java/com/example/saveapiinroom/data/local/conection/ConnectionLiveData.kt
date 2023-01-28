package com.example.saveapiinroom.data.local.conection

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import androidx.lifecycle.LiveData

class ConnectionLiveData(private val connectivityManager: ConnectivityManager) :
    LiveData<Boolean>() {

    private val networkCallback =
    object : ConnectivityManager.NetworkCallback(){

        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            postValue(true)
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            postValue(false)
        }
    }

    override fun onActive() {
        super.onActive()
        val builder = NetworkRequest.Builder()
        connectivityManager.registerNetworkCallback(builder.build() , networkCallback)
    }

    override fun onInactive() {
        super.onInactive()
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }
}

