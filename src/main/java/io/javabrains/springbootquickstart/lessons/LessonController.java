package io.javabrains.springbootquickstart.lessons;

import io.javabrains.springbootquickstart.course.Course;
import io.javabrains.springbootquickstart.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;


   @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public List<Lesson> getAllLessons(@PathVariable("topicId") String topicId, @PathVariable("courseId") String courseId) {
        return lessonService.getAllLessons(courseId);
    }
/*
    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Lesson getCourse(@PathVariable("id") String id) {

        return lessonService.getCourse(id);
    }
*/
    @PostMapping("/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody Lesson newLesson, @PathVariable("courseId") String courseId) {
        newLesson.setCourse(new Course(courseId, "", "", ""));
        lessonService.addLesson(newLesson);
    }
/*
    @PutMapping("/topics/{topicId}/courses/{id}")
    public ResponseEntity updateCourse(@PathVariable("id") String id, @RequestBody Lesson updatedLesson, @PathVariable("topicId") String topicId){
        updatedLesson.setTopic(new Topic(topicId, "", ""));
        lessonService.updateCourse(updatedLesson);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/topics/{topicId}/courses/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //Another way to return a ResponseEntity
    public void deleteCourse(@PathVariable("id")  String id){
        lessonService.deleteCourse(id);
    }*/
}
