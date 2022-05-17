package kr.co.asianaidt.listview_20220517.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import kr.co.asianaidt.listview_20220517.R
import kr.co.asianaidt.listview_20220517.datas.StudentData

class StudentAdapter(
    val mContext: Context,
    val resId: Int,
    val mList: ArrayList<StudentData>) : ArrayAdapter<StudentData>(mContext, resId, mList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if (tempRow == null) {
            tempRow = LayoutInflater.from(mContext).inflate(R.layout.student_list_item, null)
        }
        //tempRow는 null이 둘어있을 가능성이 없다.
        val row = tempRow!! //row가 리스트뷰의 한 줄에 해당하는 그림

        val data = mList[position]
        val txtName = row.findViewById<TextView>(R.id.txtName)
        val txtAge = row.findViewById<TextView>(R.id.txtAge)
        val txtAddress = row.findViewById<TextView>(R.id.txtAddress)

        txtName.text = data.name
        txtAddress.text = data.address

        txtAge.text = "${data.getKoreanAge()}세"

        return row
    }
}