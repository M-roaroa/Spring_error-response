package error_response.spring_error_response.controller;

import error_response.spring_error_response.common.ApiResponse;
import error_response.spring_error_response.common.ErrorCode;
import error_response.spring_error_response.entity.Student;
import error_response.spring_error_response.exception.CustomException;
import error_response.spring_error_response.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class MyController extends BaseController {

    private final StudentService studentService;

    @Autowired
    public MyController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/add")
    public ApiResponse<Student> add(@RequestParam("name") String name, @RequestParam("grade") int grade) {
        if (grade > 5) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "grade는 6을 넘을 수 없습니다.", 6);
        }

        Student student = studentService.addStudent(name, grade);
        return makeResponse(student);
    }

    @GetMapping("/student/getAll")
    public ApiResponse<Student> getAll() {
        List<Student> students = studentService.getAll();
        return makeResponse(students);
    }

    @GetMapping("/student/get")
    public ApiResponse<Student> get(@RequestParam("grade") int grade) {
        List<Student> students = studentService.get(grade);
        return makeResponse(students);
    }

}
