package tw.com.example.tableviewdemo.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.evrencoskun.tableview.adapter.AbstractTableAdapter
import com.evrencoskun.tableview.adapter.recyclerview.holder.AbstractViewHolder
import io.reactivex.Observable
import tw.com.example.tableviewdemo.*
import tw.com.example.tableviewdemo.holder.CellViewHolder
import tw.com.example.tableviewdemo.holder.ColumnHeaderViewHolder
import tw.com.example.tableviewdemo.holder.RowHeaderViewHolder
import tw.com.example.tableviewdemo.model.Cell
import tw.com.example.tableviewdemo.model.ColumnHeaderCell
import tw.com.example.tableviewdemo.model.RowHeaderCell
import tw.com.example.tableviewdemo.utils.format

class TableAdapter(context: Context) :
        AbstractTableAdapter<ColumnHeaderCell, RowHeaderCell, Cell>(context)
{
    private val RowTypeNormal = 0;
    private val ColumnTypeNormal = 0;
    private val CellTypeNormal = 0;
    private val inflater: LayoutInflater = LayoutInflater.from(context);

    fun init(): TableAdapter
    {
        val columns = Observable.range(0, 20)
                .map { ColumnHeaderCell(it.toString(), it) }
                .toList()
                .blockingGet();

        val rows = Observable.range(0, 20)
                .map { RowHeaderCell(it.toString(), it) }
                .toList()
                .blockingGet()

        val items = Observable.range(0, 20)
                .map {
                    Observable.range(0, 20)
                            .map { item -> Cell(item.toString(), item) }
                            .toList()
                            .blockingGet()
                }
                .toList()
                .blockingGet();

        //        setColumnHeaderItems(columns);
        //        setRowHeaderItems(rows);
        //        setCellItems(items);
        setAllItems(columns, rows, items);
        return this;
    }

    override fun onCreateColumnHeaderViewHolder(parent: ViewGroup?,
                                                viewType: Int): AbstractViewHolder
    {
        val view = inflater.inflate(R.layout.header_column, parent, false);
        return ColumnHeaderViewHolder(view);
    }

    override fun onBindColumnHeaderViewHolder(holder: AbstractViewHolder?,
                                              columnHeaderItemModel: Any?, columnPosition: Int)
    {
        (holder as ColumnHeaderViewHolder).title = "Column${columnPosition.format(2)}";
        holder.itemView.requestLayout();
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
        (holder as RowHeaderViewHolder).title = "Row${rowPosition.format(2)}";
        holder.itemView.requestLayout();
    }

    override fun getRowHeaderItemViewType(position: Int): Int
    {
        return RowTypeNormal;
    }

    override fun onCreateCellViewHolder(parent: ViewGroup?, viewType: Int): AbstractViewHolder
    {
        val view = inflater.inflate(R.layout.cell_item, parent, false);
        view.layoutParams.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        return CellViewHolder(view);
    }

    override fun onBindCellViewHolder(holder: AbstractViewHolder?, cellItemModel: Any?,
                                      columnPosition: Int, rowPosition: Int)
    {
        (holder as CellViewHolder).title =
                "Cell(${columnPosition.format(2)}, ${rowPosition.format( 2)})";
        holder.itemView.requestLayout();
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
