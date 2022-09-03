package br.com.alura.meetups.firebase

import android.util.Log
import br.com.alura.meetups.model.Dispositivo
import br.com.alura.meetups.repository.DispositivoRepository
import com.google.firebase.messaging.FirebaseMessagingService
import org.koin.android.ext.android.inject

const val TAG = "Testando FCM"

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val dispositivoRepository: DispositivoRepository by inject()

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        dispositivoRepository.salva(Dispositivo(token = token))
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // FCM registration token to your app server.
    }

}