package com.fmktechnologies.candostlar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tek_uye.view.*

class DostlarRecylerViewAdapter(tumdostlar : ArrayList<Dost>) : RecyclerView.Adapter<DostlarRecylerViewAdapter.DostViewHolder>(),Filterable {


    var dostlar = tumdostlar
    var myFilter = FilterHelper(tumdostlar,this)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DostViewHolder {


        var inflater = LayoutInflater.from(parent.context)
        var tek_uye = inflater.inflate(R.layout.tek_uye,parent,false)


        return DostViewHolder(tek_uye)


    }

    override fun getItemCount(): Int {
        return  dostlar.size
    }

    override fun onBindViewHolder(holder: DostViewHolder, position: Int) {

        var oanolusturulanDost = dostlar.get(position)
        holder.setData(position,oanolusturulanDost)


    }

    fun setFilter(arrayList: ArrayList<Dost>) {

        dostlar = arrayList

    }


    override fun getFilter(): Filter {
        return myFilter
    }

    class DostViewHolder(tek_uye: View) : RecyclerView.ViewHolder(tek_uye) {


        var tekDostBilgisi = tek_uye as CardView
        var dostAd = tekDostBilgisi.tvDostAdi
        var dostResim = tekDostBilgisi.imgDost



        fun setData(position: Int, oanolusturulanDost: Dost) {

            dostAd.text = oanolusturulanDost.dostAdi
            dostResim.setImageResource(oanolusturulanDost.dostResim)


            tekDostBilgisi.setOnClickListener {
                Toast.makeText(tekDostBilgisi.context,"Tiklanilan hayvanin adi ${oanolusturulanDost.dostAdi}",Toast.LENGTH_SHORT).show()

            }



        }





    }

    /*fun setFilter(aranilanlar : ArrayList<Dost>){

        dostlar = ArrayList<Dost>()
        dostlar.addAll(aranilanlar)
        notifyDataSetChanged()

    }*/


}