package io.javabrains.springbootquickstart.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses(String topicId){
        List<Course> topics = new ArrayList<>();
        courseRepository.findByTopicIdtop(topicId)
        .forEach( topics::add);
        return topics;
    }


    public Course getCourse(String id) {
        return courseRepository.findById(id).get();
    }

    public void addCourse(Course newCourse) {
        courseRepository.save(newCourse);
    }

    public void updateCourse(Course topic) {
        courseRepository.save(topic);
    }

    public void deleteCourse(String id) {
        courseRepository.deleteById(id);
    }
}
