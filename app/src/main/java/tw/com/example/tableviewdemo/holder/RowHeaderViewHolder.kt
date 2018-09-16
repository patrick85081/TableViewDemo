package tw.com.example.tableviewdemo.holder

import android.view.View
import android.widget.TextView
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import kotlinx.android.synthetic.main.cell_item.view.*
import org.jetbrains.anko.find
import tw.com.example.tableviewdemo.R

class RowHeaderViewHolder(view: View) : AbstractViewHolder(view)
{
    private val text: TextView = view.find(R.id.text);
    var title:String
    get() = text.text.toString();
    set(value) = text.setText(value)
}