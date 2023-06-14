package com.beyza.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class MainActivity : AppCompatActivity() {
    var constList= ArrayList<Urunler>()
    var adapter:UrunlerAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        constList.add(Urunler("Kahveler", "Açıklama" ,R.drawable._avatar180 ))
        constList.add(Urunler("Yemekler", "Açıklama" ,R.drawable.yemekler))
        constList.add(Urunler( "Tatlılar", "Açıklama" ,R.drawable.tatlılar ))
        constList.add(Urunler("İçecekler", "Açıklama" ,R.drawable.içecekler))

        adapter=UrunlerAdapter(this,constList)


    }
    class UrunlerAdapter: BaseAdapter {
        var constList=ArrayList<Urunler>()
        var context:Context?=null

        constructor(contex: Context,constList:ArrayList<Urunler>):super(){
            this.constList=constList
            this.context=context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var posUrunler = constList[position]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var menuKarti = inflator.inflate(R.layout. null)
            menuKarti.kartAdi.text= posUrunler.constAdi
            menuKarti.kartAciklama.text = posUrunler.constAciklama
            menuKarti.kartResim.setImageResource(posUrunler.constResim!!)

            menuKarti.kartResim.setOnClickListener {
                var intent = Intent(context, Urunler_detay::class.java)
                intent.putExtra("constAdi", posUrunler.constAdi)
                intent.putExtra("constAciklama", posUrunler.constAciklama)
                intent.putExtra("constResim", posUrunler.constResim!!)
                context!!.startActivity(intent)
            }
            return menuKarti
        }
        override fun getItem(position: Int): Any {
            return constList[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        

        override fun getCount(): Int {
            return constList.size
        }
    }
}