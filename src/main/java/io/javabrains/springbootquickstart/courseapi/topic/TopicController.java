package io.javabrains.springbootquickstart.courseapi.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    // GET -> /topics (gets all topics)
    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        //Spring will automatically convert to JSON this object
        return topicService.getAllTopics();
    }

    // GET -> /topic/id (Get the topic)
    @RequestMapping("/topic/{id}")
    public Topic getTopic(@PathVariable("id") String id) {
        return topicService.getTopic(id);
    }

   /*
   * Note: to test a POST I have to guaranty that in the header I have :
   * Content-Type : application/json
   * IT'S MANDATORY TO KNOW IN WHICH FORMAT THE DATA IS SENT
   * */
    // POST -> /topics (Create new topic)
/*    @PostMapping("/topics")
    public void addTopic(@RequestBody Topic newTopic){
        topicService.addTopic(newTopic);
    }*/

    @PostMapping("/topics")
    public ResponseEntity addTopic(@RequestBody Topic newTopic) {
        topicService.addTopic(newTopic);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/topic/" + newTopic.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }


    // PUT -> /topics/id (Update the topic)
/*    @PutMapping("/topics/{id}") //Path variable
    public void updateTopic(@PathVariable("id") String id, @RequestBody Topic updatedTopic){
        topicService.updateTopic(id, updatedTopic);
    }*/

    @PutMapping("/topics/{id}")
    public ResponseEntity updateTopic(@PathVariable("id") String id, @RequestBody Topic updatedTopic){
        topicService.updateTopic(id, updatedTopic);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    // DELETE -> /topics/id (Deletes the topic)
    @DeleteMapping("/topics/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //Another way to return a ResponseEntity
    public void deleteTopic(@PathVariable("id")  String id){
        topicService.deleteTopic(id);
    }
}
