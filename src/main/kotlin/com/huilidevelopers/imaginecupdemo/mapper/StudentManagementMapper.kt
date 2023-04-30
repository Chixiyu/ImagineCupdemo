package com.huilidevelopers.imaginecupdemo.mapper

import com.huilidevelopers.imaginecupdemo.entity.Staff
import com.huilidevelopers.imaginecupdemo.entity.Student
import org.apache.ibatis.annotations.Insert
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.collections.ArrayList

@Mapper
@Repository
interface StudentManagementMapper {
    @Select("select * from student")
    fun getStudents(): ArrayList<Student>

    @Select("select * from student where student_id=#{studentId}")
    fun getStudentById(studentId:Long):Student

    @Insert("insert into events values(#{studentId},#{eventDescription},#{eventTime},#{eventLevel})")
    fun addSafeguardEvent(studentId:Student, eventDescription:String, eventTime: Date, eventLevel:Int)

    @Select("select * from staff")
    fun getAllStaff():ArrayList<Staff>

    @Select("select * from staff where staff_id=#{staffId}")
    fun getStaffById(staffId:Long):Staff

    @Select("insert into staff_notices values(#{staffId},#{noticeInformation})")
    fun addStaffNotices(staffId:Long,noticeInformation:String)

}