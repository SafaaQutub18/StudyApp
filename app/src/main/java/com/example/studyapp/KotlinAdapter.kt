package com.example.studyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class KotlinAdapter : RecyclerView.Adapter<KotlinAdapter.KotlinCardViewHolder>() {

    var kotlinTopicsList: ArrayList<Card> = ArrayList()

    class KotlinCardViewHolder(itemView: View, listener: onItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var tvTitle: TextView = itemView.findViewById(R.id.titleTV)
        var tvDescription: TextView = itemView.findViewById(R.id.descriptionTV)

        init {
            //Click Listener setting
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
                //
            }
        }

        fun bind(topicCard: Card) {
            tvTitle.text = topicCard.title
            tvDescription.text = topicCard.description
        }
    }

    private lateinit var vhListener: onItemClickListener

    fun setCardList(CardArrayList: ArrayList<Card>) {
        this.kotlinTopicsList = CardArrayList
        notifyDataSetChanged()
    }

    //Click Listener setting
    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        vhListener = listener
    }

    //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KotlinCardViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.kotlin_recyclerview, parent, false)
        return KotlinCardViewHolder(view, vhListener)
    }

    // get text or any thing inside the view holder)
    //holder : used to access the viwes inside the viewholder (ex: textmimage)
    // position: the current position of current index of particular view
    override fun onBindViewHolder(holder: KotlinCardViewHolder, position: Int) {
        // itemview: view that contains all of our single view inside cardrecycleview.xml (in my case: it contain just text)
        holder.itemView.apply {
            holder.bind(kotlinTopicsList[position])
        }
    }

    override fun getItemCount() = kotlinTopicsList.size

    //}
}
