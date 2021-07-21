package com.codeup.springblog.controllers;

import com.codeup.springblog.controllers.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    @RequestMapping(path = "/posts", method = RequestMethod.GET)

    public String postsIndex(Model model) {
        List<Post> posts = new ArrayList<>();
        Post post1 = new Post("My First Blog", "Some blog words should go here but i dont know what to type so goodbye");
        Post post2 = new Post("My Second Blog", "Some blog words should go here but i dont know what to type so goodbye");
        posts.add(post1);
        posts.add(post2);
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    //    public String posts() {
//        return "posts index page";
//    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)

    public String postsId( Model model) {
        Post post = new Post("My First Blog", "Some interesting text would fill this area if i could think of anything to write so goodbye!");
        model.addAttribute("post", post);
        return "posts/show";
    }

////      public String postsId() {
//
//        return "View an individuals post!";
//    }

    @RequestMapping(path = "/posts/create", method = RequestMethod.GET)
    @ResponseBody
    public String postsCreate() {

        return "View the form for creating a post!";
    }

    @PostMapping(path = "/posts/create")
    @ResponseBody
    public String createPost(){
        return "Create a new post!";
    }


}
