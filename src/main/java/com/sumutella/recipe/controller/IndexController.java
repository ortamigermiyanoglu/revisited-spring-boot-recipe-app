package com.sumutella.recipe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sumutella
 * @time 10:08 AM
 * @since 12/23/2019, Mon
 */
@Controller
public class IndexController {
    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(){
        return "index";
    }
}
