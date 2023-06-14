package com.beyza.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Urunler_detay : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_urunler_detay)
        
        var bundle:Bundle = intent.extras!!
        var adi=bundle.getString("constAdi")
        //var aciklama=bundle.getString("constAciklama")
        var resim =bundle.getInt("constResim")


        detayAdi.text=adi
        // detayAciklama.text=aciklama
        detayResim.setImageResource(resim)
    }
}