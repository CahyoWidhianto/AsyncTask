package com.example.praktikumasynctask

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.w3c.dom.Text

class QouteAdapter(private val listQoute: JSONArray)
    : RecyclerView.Adapter<QouteAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val tvContent = view.findViewById<TextView>(R.id.tv_content)
        val tvAuthor = view.findViewById<TextView>(R.id.tv_author)
        fun bind(content: String, author: String) {
            tvContent.text =content
            tvAuthor.text= author
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_qoute, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val qoute = listQoute.getJSONObject(position)
        val content = qoute.getString("content")
        val author = qoute.getString("author")
        holder.bind(content, author)
    }
    override fun getItemCount(): Int {
        return listQoute.length()
    }
}