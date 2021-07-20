package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int add(@PathVariable int x, @PathVariable int y) {

        return x + y;
    }

    @RequestMapping(path = "/subtract/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int subtract(@PathVariable int x, @PathVariable int y) {

        return x - y;
    }

    @RequestMapping(path = "/multiply/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int multiply(@PathVariable int x, @PathVariable int y) {

        return x * y;
    }

    @RequestMapping(path = "/divide/{x}/and/{y}", method = RequestMethod.GET)
    @ResponseBody
    public int divide(@PathVariable int x, @PathVariable int y) {

        return x / y;
    }


}
