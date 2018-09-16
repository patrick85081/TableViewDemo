package tw.com.example.tableviewdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.evrencoskun.tableview.TableView
import tw.com.example.tableviewdemo.adapter.TableAdapter

class MainActivity : AppCompatActivity()
{
    private val tableView: TableView by lazy { findViewById<TableView>(R.id.tableView) }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val adapter = TableAdapter(this);
        tableView.adapter = adapter;
//        adapter.setTableView(tableView);
        adapter.init();
//        tableView.visibility = View.VISIBLE;
//        tableView.rowHeaderWidth = resources.getDimensionPixelSize(R.dimen.row_header_width);
//        tableView.columnHeader
        tableView.setHasFixedWidth(false);
        tableView.isShowHorizontalSeparators = true;
        tableView.isShowVerticalSeparators = true;
    }
}

