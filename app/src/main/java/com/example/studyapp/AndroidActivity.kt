package com.example.studyapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class AndroidActivity : AppCompatActivity() {

    lateinit var recyclerV: RecyclerView
    var cardTopicsList: ArrayList<Card> = ArrayList()
    val adapterRV: AndroidAdapter by lazy { AndroidAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Anroid Review"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android)

        //RECYCLER VIEW SETTING
        recyclerV = findViewById(R.id.rvAndroid)
        recyclerV.adapter = adapterRV

        //click on cell(holder view) action - Click Listener in the Recycler View Adapter
        adapterRV.setOnItemClickListener(object : AndroidAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                AlertDialog(position)
            }

        })


        //fill card contents
        cardTopicsList.add(Card("Project Setup", "Setup anroid studio project", "Detailed notes here"))
        cardTopicsList.add(Card("Console", "Printing to the console", "Detailed notes here"))
        cardTopicsList.add(Card("UI Elements", "learn about view component", "Detailed notes here"))
        cardTopicsList.add(Card("Snackbar", "use a Snackbar to display alerts in our application", "Detailed notes here"))
        cardTopicsList.add(Card("Shared Preferences", "Save and get the data from Shared Preferences", "Detailed notes here"))
        cardTopicsList.add(Card("Intents ", "launch a new activity in Android Studio using Intents",
            "1.val intent = Intent(this, MyActivity::class.java)\n" + "2.startActivity(intent)"))

        adapterRV.setCardList(cardTopicsList)

    }

    fun AlertDialog(position: Int) {

        val dialogBuilder = androidx.appcompat.app.AlertDialog.Builder(this)
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
