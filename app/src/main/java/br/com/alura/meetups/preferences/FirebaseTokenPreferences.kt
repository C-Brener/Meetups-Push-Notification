package br.com.alura.meetups.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

private const val NOME_PREFERENCES = "br.com.alura.meetups.preferences.FirebaseTokenPreferences"

class FirebaseTokenPreferences(context: Context) {

    private val preferences: SharedPreferences =
        context.getSharedPreferences(NOME_PREFERENCES, Context.MODE_PRIVATE)
    val enviado get() = preferences.getBoolean("enviaado", false)


    fun tokenNovo() {
        preferences.edit {
            putBoolean("enviado", false)
        }
    }

    fun tokenEnviado() {
        preferences.edit {
            putBoolean("enviado", true)
        }
    }
}