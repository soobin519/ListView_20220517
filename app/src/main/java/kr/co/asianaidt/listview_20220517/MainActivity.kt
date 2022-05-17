package kr.co.asianaidt.listview_20220517

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kr.co.asianaidt.listview_20220517.adapters.StudentAdapter
import kr.co.asianaidt.listview_20220517.datas.StudentData

class MainActivity : AppCompatActivity() {

    val mStudentList = ArrayList<StudentData>()

    lateinit var mAdapter : StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mStudentList.add( StudentData("이름", 1999, "서울시 종로구") )
        mStudentList.add( StudentData("조경진", 1988, "서울시 종로구") )
        mStudentList.add( StudentData("채수빈", 1998, "성남시 분당구") )
        mStudentList.add( StudentData("김세희", 1998, "서울시 강동구") )
        mStudentList.add( StudentData("김민제", 1997, "수원시 영통구") )
        mStudentList.add( StudentData("김철수", 1995, "서울시 성동구") )
        mStudentList.add( StudentData("유재석", 1996, "서울시 강남구") )
        mStudentList.add( StudentData("강호동", 1992, "서울시 송파구") )
        mStudentList.add( StudentData("아이유", 1993, "서울시 종로구") )
        mStudentList.add( StudentData("수지", 1994, "용인시 수지구") )
        mStudentList.add( StudentData("강동원", 1999, "서울시 종로구") )

        mAdapter = StudentAdapter(this, R.layout.student_list_item, mStudentList)

        studentListView.adapter = mAdapter

        studentListView.setOnItemClickListener { adapterView, view, position, l ->

            val clickedStudent = mStudentList[position]

            Toast.makeText(this, "${clickedStudent.name} 클릭됨", Toast.LENGTH_SHORT).show()


        }

        studentListView.setOnItemLongClickListener { adapterView, view, position, l ->

            val student = mStudentList[position]


            //학생목록에서 길게 눌린 학생은 제거
            mStudentList.remove(student)

            //어댑터의 변경사항 감지 처리
            mAdapter.notifyDataSetChanged()

            Toast.makeText(this, "${student.name} 학생이 삭제됨 ", Toast.LENGTH_SHORT).show()

            return@setOnItemLongClickListener true

        }


    }
}