package io.javabrains.springbootquickstart.lessons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons(String courseId){
        List<Lesson> lessons = new ArrayList<>();
        lessonRepository.findByCourseId(courseId)
        .forEach( lessons::add);
        return lessons;
    }


    public Lesson getLesson(String id) {
        return lessonRepository.findById(id).get();
    }

    public void addLesson(Lesson newLesson) {
        lessonRepository.save(newLesson);
    }

    public void updateLesson(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    public void deleteLesson(String id) {
        lessonRepository.deleteById(id);
    }
}
