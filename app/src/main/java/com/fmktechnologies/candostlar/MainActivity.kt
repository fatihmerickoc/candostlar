package com.fmktechnologies.candostlar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){/*android.widget.SearchView.OnQueryTextListener*/

    var tumdostlar = ArrayList<Dost>()
   lateinit var myAdapter :DostlarRecylerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        veriKaynagiDoldur()

         myAdapter = DostlarRecylerViewAdapter(tumdostlar)
        recylerViewDostlar.adapter = myAdapter

        var mylayoutManager = GridLayoutManager(this,2)
        recylerViewDostlar.layoutManager = mylayoutManager

        searchViewDost.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                myAdapter.filter.filter(newText)
                return false
            }

        })


    }


   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.filtremenu,menu)
        var aramaItem = menu?.findItem(R.id.app_bar_search)

        var searchView = aramaItem?.actionView as android.widget.SearchView

        searchView.setOnQueryTextListener(this)




        return super.onCreateOptionsMenu(menu)
    }*/
 /*   override fun onQueryTextSubmit(query: String?): Boolean {

        return false

    }*/
   /* override fun onQueryTextChange(newText: String?): Boolean {


        var girilenVeri = newText?.toLowerCase()
        var arananlar = ArrayList<Dost>()

        for(dost in tumdostlar){

            var adi = dost.dostAdi.toLowerCase()

            if (adi.contains(girilenVeri.toString())){
                arananlar.add(dost)
            }


        }


        myAdapter.setFilter(arananlar)
        return true

    }*/
   private fun veriKaynagiDoldur() {

       var resimler = arrayOf(R.drawable.ani_cat_one,
           R.drawable.ani_cat_two,
           R.drawable.ani_cat_three,
           R.drawable.ani_cat_four,
           R.drawable.ani_cat_five,
           R.drawable.ani_cat_six,
           R.drawable.ani_cat_seven,

           R.drawable.ani_dog_one,
           R.drawable.ani_dog_two,
           R.drawable.ani_dog_three,
           R.drawable.ani_dog_four,
           R.drawable.ani_dog_five,

           R.drawable.ani_deer_one,
           R.drawable.ani_deer_two,
           R.drawable.ani_deer_three,
           R.drawable.ani_deer_four,

           R.drawable.bird_parrot_one,
           R.drawable.bird_parrot_two,
           R.drawable.bird_parrot_three,
           R.drawable.bird_parrot_four,
           R.drawable.bird_parrot_five,
           R.drawable.bird_parrot_six,
           R.drawable.bird_parrot_seven,
           R.drawable.bird_parrot_eight)

       var isimler = arrayOf("Cat 1", "Cat 2", "Cat 3", "Cat 4", "Cat 5", "Cat 6", "Cat 7",
           "Dog 1", "Dog 2", "Dog 3", "Dog 4", "Dog 5",
           "Deer 1", "Deer 2", "Deer 3", "Deer 4",
           " Parrot 1", " Parrot 2", " Parrot 3", " Parrot 4", " Parrot 5", " Parrot 6", " Parrot 7", " Parrot 8")



       for(i in 0.. resimler.size-1){

           var eklenecekDost = Dost(isimler[i],resimler[i])
           tumdostlar.add(eklenecekDost)


       }


   }


}
