package com.example.studyapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView

class KotlinActivity : AppCompatActivity() {

    lateinit var recyclerV: RecyclerView
    var cardTopicsList: ArrayList<Card> = ArrayList()
    val adapterRV: KotlinAdapter by lazy { KotlinAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Kotlin Review"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)

        //RECYCLER VIEW SETTING
        recyclerV = findViewById(R.id.rvKotlin)
        recyclerV.adapter = adapterRV

        //click on cell(holder view) action - Click Listener in the Recycler View Adapter
        adapterRV.setOnItemClickListener(object : KotlinAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                AlertDialog(position)
            }

        })


        //fill card contents
        cardTopicsList.add(Card("If Statments", "the expretions of if-else statments, conditions", "Detailed notes here"))
        cardTopicsList.add(Card("var and val", "Declaring variable", "Detailed notes here"))
        cardTopicsList.add(Card("user Input", "getting user input", "Detailed notes here"))
        cardTopicsList.add(Card("String", "String concatenations, methods, interpolation", "Detailed notes here"))
        cardTopicsList.add(Card("Data types", "Understanding data types", "Detailed notes here"))
        cardTopicsList.add(Card("Basic Oprations", "Performing math operations in kotlin", "Detailed notes here"))
         adapterRV.setCardList(cardTopicsList)

    }

    fun AlertDialog(position: Int) {

        val dialogBuilder = AlertDialog.Builder(this)
        // here we set the message of our alert dialog
        dialogBuilder.setMessage(cardTopicsList[position].detailed)
            // positive button text and action
            .setPositiveButton("ok",
                DialogInterface.OnClickListener { dialog, id -> this.recreate() })

        // create dialog box
        val alert = dialogBuilder.create()
        // set title for alert dialog box
        alert.setTitle(cardTopicsList[position].title)

        // show alert dialog
        alert.show()
    }
}

