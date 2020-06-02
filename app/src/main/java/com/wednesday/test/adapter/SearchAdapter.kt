package com.wednesday.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.wednesday.test.R
import com.wednesday.test.model.Result
import java.util.*

class SearchAdapter(
    internal var mContext: Context,
    internal var tracklist: ArrayList<Result>
) :
    RecyclerView.Adapter<SearchAdapter.MyViewHolder>() {
    override fun getItemCount(): Int {
        return tracklist.size;
    }

    internal var layoutInflater: LayoutInflater? = null


    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, i: Int): MyViewHolder {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.context)
        }
        val view = layoutInflater!!.inflate(R.layout.row_search_items, null, false);
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull myViewHolder: MyViewHolder, i: Int) {

        myViewHolder.trackName?.text = tracklist[i].trackName;
        Glide.with(myViewHolder.imageView!!).load(tracklist[i].artworkUrl100)
            .into(myViewHolder.imageView!!)
    }

    inner class MyViewHolder(@param:NonNull val mView: View) :
        RecyclerView.ViewHolder(mView) {
        var trackName: TextView? = null;
        var imageView: ImageView? = null;

        init {
            imageView = itemView.findViewById(R.id.image)
            trackName = itemView.findViewById(R.id.trackName)
        }


    }
}