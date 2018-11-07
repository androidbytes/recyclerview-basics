package `in`.androidbytes.recyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeRecyclerView()
    }

    private fun initializeRecyclerView() {
        //create and set the adapter
        val adapter = MovieAdapter()
        recycler_view.adapter = adapter

        //submit movie list to the adapter
        adapter.submitList(movies)

        //create and set layout manager
        val lm = LinearLayoutManager(this)
        recycler_view.layoutManager = lm

        //add item divider
        recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }

    companion object {
        val movies = listOf(
            Movie(1, "The Dark Knight", "July 18, 2008", "http://www.gstatic.com/tv/thumb/v22vodart/173378/p173378_v_v8_at.jpg"),
            Movie(2, "Inception", "July 16, 2010", "http://www.gstatic.com/tv/thumb/v22vodart/7825626/p7825626_v_v8_ad.jpg"),
            Movie(3, "Titanic", "December 19, 1997", "http://www.gstatic.com/tv/thumb/v22vodart/20056/p20056_v_v8_ba.jpg"),
            Movie(4, "The Matrix", "March 31, 1999", "http://www.gstatic.com/tv/thumb/v22vodart/22804/p22804_v_v8_as.jpg"),
            Movie(5, "Terminator 2: Judgement Day", "July 3, 1991", "http://www.gstatic.com/tv/thumb/v22vodart/13308/p13308_v_v8_ab.jpg"),
            Movie(6, "Jurassic Park", "June 11, 1993", "http://www.gstatic.com/tv/thumb/v22vodart/14812/p14812_v_v8_ai.jpg"),
            Movie(7, "Spider-Man", "May 3, 2002", "https://images-na.ssl-images-amazon.com/images/I/418zjk8EnnL.jpg")
        )
    }
}
