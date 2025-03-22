package com.app.xplore.controller.events;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/event/")
public class EventController {

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String test() {
        return "Hello";
    }
}
