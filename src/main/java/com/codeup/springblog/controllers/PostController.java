package com.codeup.springblog.controllers;

import com.codeup.springblog.models.Post;
import com.codeup.springblog.models.PostRepository;
import com.codeup.springblog.models.UserRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final PostRepository postsDao;
    private final UserRepository usersDao;

    private final EmailService emailSvc;





    public PostController(PostRepository postsDao, UserRepository usersDao, EmailService emailSvc){
        this.postsDao = postsDao;
        this.usersDao = usersDao;
        this.emailSvc = emailSvc;
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

    @GetMapping("/posts/create")
    public String createPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "/posts/create";
    }

    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {
       post.setUser(usersDao.getById(1L));
        emailSvc.prepareAndSend(post.getUser().getEmail(), "title", "body");
        postsDao.save(post);
        return "redirect:/posts";
    }

@GetMapping("/posts/edit/{id}")
    public String updatePostForm(@PathVariable("id") long id, Model model) {
    Post post = postsDao.getById((id));
    model.addAttribute("post", post);
    return "/posts/edit";
}

        @PostMapping("/posts/edit")
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



