package br.com.alura.meetups.firebase

import android.util.Log
import br.com.alura.meetups.model.Dispositivo
import br.com.alura.meetups.preferences.FirebaseTokenPreferences
import br.com.alura.meetups.repository.DispositivoRepository
import com.google.firebase.messaging.FirebaseMessagingService
import org.koin.android.ext.android.inject

const val TAG = "Testando FCM"

class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val dispositivoRepository: DispositivoRepository by inject()
    private val preferences: FirebaseTokenPreferences by inject()

    override fun onNewToken(token: String) {
        Log.d(TAG, "Refreshed token: $token")

        preferences.tokenNovo()

        dispositivoRepository.salva(Dispositivo(token = token))
    }

}