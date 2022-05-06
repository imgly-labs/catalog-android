package ly.img.catalog.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ly.img.catalog.R
import ly.img.catalog.data.items
import ly.img.catalog.examples.Example

class MainActivity : AppCompatActivity() {

    private var currentExample: Example? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        recyclerView.adapter = CatalogAdapter(items) {
            currentExample = it.example.getConstructor(AppCompatActivity::class.java)
                .newInstance(this)
                .also { example ->
                    example.invoke()
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        currentExample?.onActivityResult(requestCode, resultCode, data)
    }
}
