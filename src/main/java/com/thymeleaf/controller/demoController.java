package com.thymeleaf.controller;

import com.thymeleaf.model.Person;
import com.thymeleaf.model.PersonConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chengxiaohong
 */
@Controller
public class demoController {

    /**
     * 首页
     * @return
     */
    @RequestMapping("/")
    public String templata(Model model){
        Person personOne = new Person("cxh",25);
        List<Person> persons = new ArrayList<Person>();
        Person p1 = new Person("ccc",10 ,0);
        Person p2 = new Person("cxg",22 ,1);
        Person p3 = new Person("dp",32 ,1);
        Person p4 = new Person("gt",40 ,3);
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        model.addAttribute("singlePerson",PersonConverter.converter(personOne));
        model.addAttribute("people", PersonConverter.converter(persons));
        return "system/index";
    }


    /**
     * 视图（外跳）
     * @return
     */
    @RequestMapping("/redirect")
    public String redirect(RedirectAttributes redirectAttributes){
        String interfaceName = "cxh";
        redirectAttributes.addAttribute("name", "外跳-cxh");
        return "redirect:/dispatcher";
    }


    /**
     *视图 （內跳）
     * @param model
     * @return
     */
    @RequestMapping("/dispatcher")
    public String dispatcher(Model model , String name){
        model.addAttribute("interfaceName", StringUtils.isEmpty(name) ? "cxh" : name);
        return "hello";
    }
}
