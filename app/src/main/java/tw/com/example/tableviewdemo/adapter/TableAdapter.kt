package tw.com.example.tableviewdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evrencoskun.tableview.adapter.AbstractTableAdapter
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import tw.com.example.tableviewdemo.*
import tw.com.example.tableviewdemo.holder.CellViewHolder
import tw.com.example.tableviewdemo.holder.ColumnHeaderViewHolder
import tw.com.example.tableviewdemo.holder.RowHeaderViewHolder
import tw.com.example.tableviewdemo.model.Cell
import tw.com.example.tableviewdemo.model.ColumnHeaderCell
import tw.com.example.tableviewdemo.model.RowHeaderCell

class TableAdapter(context: Context) :
        AbstractTableAdapter<ColumnHeaderCell, RowHeaderCell, Cell>(context)
{
    private val RowTypeNormal = 1;
    private val ColumnTypeNormal = 1;
    private val CellTypeNormal = 1;
    private val inflater: LayoutInflater = LayoutInflater.from(context);

    override fun onCreateColumnHeaderViewHolder(parent: ViewGroup?,
                                                viewType: Int): AbstractViewHolder
    {
        val view = inflater.inflate(R.layout.header_column, parent, false);
        return ColumnHeaderViewHolder(view);
    }

    override fun onBindColumnHeaderViewHolder(holder: AbstractViewHolder?,
                                              columnHeaderItemModel: Any?, columnPosition: Int)
    {
    }

    override fun getColumnHeaderItemViewType(position: Int): Int
    {
        return ColumnTypeNormal;
    }

    override fun onCreateRowHeaderViewHolder(parent: ViewGroup?,
                                             viewType: Int): AbstractViewHolder
    {
        val view = inflater.inflate(R.layout.header_row, parent, false);
        return RowHeaderViewHolder(view);
    }

    override fun onBindRowHeaderViewHolder(holder: AbstractViewHolder?,
                                           rowHeaderItemModel: Any?, rowPosition: Int)
    {
    }

    override fun getRowHeaderItemViewType(position: Int): Int
    {
        return RowTypeNormal;
    }

    override fun onCreateCellViewHolder(parent: ViewGroup?, viewType: Int): AbstractViewHolder
    {
        val view = inflater.inflate(R.layout.cell_item, parent, false);
        return CellViewHolder(view);
    }

    override fun onBindCellViewHolder(holder: AbstractViewHolder?, cellItemModel: Any?,
                                      columnPosition: Int, rowPosition: Int)
    {
    }

    override fun getCellItemViewType(position: Int): Int
    {
        return CellTypeNormal;
    }

    override fun onCreateCornerView(): View
    {
        return inflater.inflate(R.layout.view_corner, null, false);
    }

}