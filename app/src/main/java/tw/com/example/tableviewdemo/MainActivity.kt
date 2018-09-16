package tw.com.example.tableviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.evrencoskun.tableview.TableView
import tw.com.example.tableviewdemo.adapter.TableAdapter

class MainActivity : AppCompatActivity()
{
    private val tableView: TableView by lazy { findViewById<TableView>(R.id.content_container) }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tableView.adapter = TableAdapter(this);
    }
}

