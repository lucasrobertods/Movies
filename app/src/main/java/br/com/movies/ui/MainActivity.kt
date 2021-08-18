package br.com.movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.movies.R
import br.com.movies.model.Movie
import br.com.movies.model.SimilarMovie
import br.com.movies.utils.Constants
import br.com.movies.viewmodel.MovieViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val viewModel: MovieViewModel by viewModel()
    private var isLiked = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()

    }

    private fun setupView() {
        setupListeners()
        getMovie()
    }

    private fun setupListeners() {
        imgLike.setOnClickListener {
            isLiked = if (isLiked) {
                imgLike.setImageResource(R.drawable.heart_outline)
                false
            } else {
                imgLike.setImageResource(R.drawable.cards_heart)
                true
            }
        }
    }

    private fun getMovie() {
        viewModel.getMovie(object : Callback<Movie> {
            override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                val movie = response.body()

                Glide
                    .with(this@MainActivity)
                    .load(Constants.BASE_IMAGE_URL + movie?.poster_path)
                    .into(imgBanner)

                tvTitle.text = movie?.title
                tvLikes.text = getString(R.string.voteCounts, movie?.vote_count)
                tvViews.text = getString(R.string.countViews, movie?.popularity)
            }

            override fun onFailure(call: Call<Movie>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Falha Filme!", Toast.LENGTH_SHORT).show()
            }

        })

        viewModel.getSimilarMovie(object : Callback<SimilarMovie> {

            override fun onResponse(
                call: Call<SimilarMovie>,
                response: Response<SimilarMovie>
            ) {
                Toast.makeText(this@MainActivity, "Sucesso Filme!", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<SimilarMovie>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Falha Filme!", Toast.LENGTH_SHORT).show()
            }

        })
    }
}