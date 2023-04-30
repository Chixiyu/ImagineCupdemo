package com.huilidevelopers.imaginecupdemo.controller

import com.huilidevelopers.imaginecupdemo.entity.Staff
import com.huilidevelopers.imaginecupdemo.entity.Student
import com.huilidevelopers.imaginecupdemo.mapper.StudentManagementMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Arrays
import java.util.Date
import javax.annotation.Resource

@RestController
class StudentManagementController {
    @Resource
    lateinit var studentManagementMapper: StudentManagementMapper

    //display all student information (names + student id)
    @GetMapping("/students")
    fun getStudents():ArrayList<Student>{
        return studentManagementMapper.getStudents()
    }

    // get one student information by student id
    @GetMapping("/students/id")
    fun getStudentById(id:Long):Student{
        return studentManagementMapper.getStudentById(id)
    }

    @GetMapping("/student/safeguardIssue")
    fun safeGuardIssueDetected(studentId:Student,eventDescription:String,eventTime:Date,eventLevel:Int){
        // record event
        studentManagementMapper.addSafeguardEvent(studentId,eventDescription,eventTime,eventLevel)

        // send alarm to all teachers and school staff members with level higher than 5
        //1. get all teachers
        val staffs=studentManagementMapper.getAllStaff()
        for(item in staffs){
            if(item.staffLevel>=5){
                // 2. send notice to those staff members
                studentManagementMapper.addStaffNotices(item.staffId,eventDescription)
            }
        }
    }
    @GetMapping("/staff/management")
    fun staffManagementHomepage(staffId:Long):Staff{
        return studentManagementMapper.getStaffById(staffId)
    }
}






