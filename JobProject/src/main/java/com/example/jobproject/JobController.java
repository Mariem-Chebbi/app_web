package com.example.jobproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    private String title = "Hello, i'm the candidate Micro-Service";

    @Autowired
    private JobService jobService;

    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println(title);
        return title;
    }

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs() {
        return new ResponseEntity<>(jobService.getAll(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Job> addJob (@RequestBody Job job) {
        return new ResponseEntity<>(jobService.add(job), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Job> updateJob (@PathVariable Long id,@RequestBody Job job) {
        return new ResponseEntity<>(jobService.updateJob(id,job), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob (@PathVariable Long id){
        return new ResponseEntity<>(jobService.deleteJob(id), HttpStatus.OK);
    }

    @PutMapping("/etat/{id}")
    public ResponseEntity<Job> updateEtat (@PathVariable Long id,@RequestParam Boolean state) {
        return new ResponseEntity<>(jobService.updateJobEtat(id,state), HttpStatus.OK);
    }

}
