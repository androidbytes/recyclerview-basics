package `in`.androidbytes.recyclerview

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_list_item.view.*

class MovieAdapter : ListAdapter<Movie, MovieAdapter.ViewHolder>(COMPARATOR) {

    private val picasso = Picasso.get()

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return ViewHolder(v, picasso)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)

    }

    class ViewHolder(itemView: View, val picasso: Picasso) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private var movie: Movie? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            with(itemView) {
                name.text = movie.name
                release_date.text = movie.releaseDate
                picasso.load(movie.poster)
                    .fit()
                    .into(poster)
            }
            this.movie = movie
        }

        override fun onClick(v: View) {
            Toast.makeText(v.context, "${movie?.name} clicked", Toast.LENGTH_SHORT).show()
        }
    }

    //movie comparator
    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(old: Movie, new: Movie) = old.id == new.id

            override fun areContentsTheSame(old: Movie, new: Movie) = old == new
        }
    }
}