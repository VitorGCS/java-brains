package io.javabrains.springbootquickstart.course;

import io.javabrains.springbootquickstart.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping("/topics/{topicId}/courses")
    public List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable("id") String id) {
        return courseService.getCourse(id);
    }

    @PostMapping("/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course newCourse, @PathVariable("topicId") String topicId) {
        newCourse.setTopic(new Topic(topicId, "", ""));
        courseService.addCourse(newCourse);
    }

    @PutMapping("/topics/{topicId}/courses/{id}")
    public ResponseEntity updateCourse(@PathVariable("id") String id, @RequestBody Course updatedCourse,  @PathVariable("topicId") String topicId){
        updatedCourse.setTopic(new Topic(topicId, "", ""));
        courseService.updateCourse(updatedCourse);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable("id")  String id){

        courseService.deleteCourse(id);
    }
}
