package ly.img.catalog.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ly.img.catalog.R
import ly.img.catalog.data.ExampleItem

class CatalogAdapter(private val data: List<ExampleItem>, private val listener: (item: ExampleItem) -> Unit) :
    RecyclerView.Adapter<CatalogAdapter.ExampleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_example, parent, false)
        return ExampleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ExampleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        init {
            view.setOnClickListener {
                listener(data[adapterPosition])
            }
        }

        private val titleView = view.findViewById<TextView>(R.id.title)
        private val subtitleView = view.findViewById<TextView>(R.id.subtitle)

        fun bind(item: ExampleItem) {
            titleView.text = item.title
            subtitleView.text = item.subtitle
        }
    }
}