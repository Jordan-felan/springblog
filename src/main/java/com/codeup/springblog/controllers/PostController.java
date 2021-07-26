package com.codeup.springblog.controllers;

import com.codeup.springblog.controllers.models.Post;
import com.codeup.springblog.controllers.models.PostRepository;
import com.codeup.springblog.controllers.models.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;

    public PostController(PostRepository postsDao, UserRepository userDao){
        this.postsDao = postsDao;
        this.usersDao = userDao;
    }

    @RequestMapping(path = "/posts", method = RequestMethod.GET)
    public String getAllPosts(Model model) {
        List<Post> posts = postsDao.findAll();
        model.addAttribute("posts", posts);
        return "posts/index";
    }
    //    public String posts() {
//        return "posts index page";
//    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)

    public String getOnePost(@PathVariable long id, Model model) {
        Post post = postsDao.getById(id);
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

@GetMapping("/posts/update/{id}")
    public String updatePostForm(@PathVariable("id") long id, Model model) {
    Post post = postsDao.getById((id));
    model.addAttribute("post", post);
    return "/posts/update";
}

        @PostMapping("/posts/update")
                public String saveUpdatedPost(@ModelAttribute Post post){
//            System.out.println(post.getId());
            postsDao.save(post);
            return "redirect:/posts";
    }

    @GetMapping("/posts/delete/{id}")
    public String deletePost(@PathVariable("id") long id, Model model) {
        Post post = postsDao.getById(id);
        postsDao.delete(post);
        return "redirect:/posts";
    }
}



