package ch.hslu.ninopadrutt.vuzibladeprototype

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomListAdapter(private val context: Context,
                        private val dataSource : ArrayList<ListItemHolder>) : BaseAdapter() {

    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(android.R.layout.simple_list_item_2, parent, false)

        val text1 = rowView?.findViewById<TextView>(android.R.id.text1)
        val text2 = rowView?.findViewById<TextView>(android.R.id.text2)

        text1?.text = dataSource.get(position).Message
        text2?.text = dataSource.get(position).Machine
        return rowView
    }


}