package org.bdwallet.app

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class EntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val isWalletInitialized = getSharedPreferences("init", Context.MODE_PRIVATE)
            .getBoolean("walletInitialized", false)
        val intent = Intent(
            this,
            Class.forName(getNextActivityName(isWalletInitialized))
        )
        startActivity(intent)
    }

    private fun getNextActivityName(walletInitialized: Boolean): String {
        if (walletInitialized) {
            return LoginActivity::class.qualifiedName!!
        }
        return InitActivity::class.qualifiedName!!
    }
}