package com.wipro.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @PostMapping("/post")
    public String createData() {
        return "Post created";
    }

    @GetMapping("/get")
    public String getData() {
        return "Data fetched";
    }

    @PutMapping("/update")
    public String updateData() {
        return "Update done";
    }

    @DeleteMapping("/delete")
    public String deleteData() {
        return "Delete done";
    }
}