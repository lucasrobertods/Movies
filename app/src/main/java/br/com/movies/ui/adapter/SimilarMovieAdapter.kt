package br.com.movies.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.movies.R
import br.com.movies.model.Similar
import br.com.movies.utils.Constants
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_similar_movie.view.*

class SimilarMovieAdapter : RecyclerView.Adapter<SimilarMovieAdapter.SimilarVH>() {

    var items: MutableList<Similar> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarVH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_similar_movie, parent, false)
        return SimilarVH(view)
    }

    override fun onBindViewHolder(holder: SimilarVH, position: Int) {
        holder.populate(items[position])
    }

    override fun getItemCount() = items.size

    inner class SimilarVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populate(itemSimilar: Similar) {
            with(itemView) {
                Glide.with(context)
                    .load(Constants.BASE_IMAGE_URL + itemSimilar.backdrop_path)
                    .into(imgItem)
                tvTitle.text = itemSimilar.title
                tvSubtitle.text = itemSimilar.release_date
            }
        }
    }

}
