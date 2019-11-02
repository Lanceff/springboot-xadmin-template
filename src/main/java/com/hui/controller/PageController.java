package com.hui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping("/welcome1")
    public String welcome1() {
        return "welcome1";
    }

    @RequestMapping("/member-list")
    public String member_list() {
        return "member-list";
    }

    @RequestMapping("/member-list1")
    public String member_list1() {
        return "member-list1";
    }

    @RequestMapping("/member-del")
    public String member_del() {
        return "member-del";
    }

    @RequestMapping("/order-list")
    public String order_list() {
        return "order-list";
    }

    @RequestMapping("/order-list1")
    public String order_list1() {
        return "order-list1";
    }

    @RequestMapping("/cate")
    public String cate() {
        return "cate";
    }

    @RequestMapping("/city")
    public String city() {
        return "city";
    }

    @RequestMapping("/admin-list")
    public String admin_list() {
        return "admin-list";
    }

    @RequestMapping("/admin-role")
    public String admin_role() {
        return "admin-role";
    }

    @RequestMapping("/admin-cate")
    public String admin_cate() {
        return "admin-cate";
    }

    @RequestMapping("/admin-rule")
    public String admin_rule() {
        return "admin-rule";
    }

    @RequestMapping("/echarts1")
    public String echarts1() {
        return "echarts1";
    }

    @RequestMapping("/echarts2")
    public String echarts2() {
        return "echarts2";
    }

    @RequestMapping("/echarts3")
    public String echarts3() {
        return "echarts3";
    }

    @RequestMapping("/echarts4")
    public String echarts4() {
        return "echarts4";
    }

    @RequestMapping("/echarts5")
    public String echarts5() {
        return "echarts5";
    }

    @RequestMapping("/echarts6")
    public String echarts6() {
        return "echarts6";
    }

    @RequestMapping("/echarts7")
    public String echarts7() {
        return "echarts7";
    }

    @RequestMapping("/echarts8")
    public String echarts8() {
        return "echarts8";
    }

    @RequestMapping("/unicode")
    public String unicode() {
        return "unicode";
    }

    @RequestMapping("/errorPage")
    public String error() {
        return "error";
    }

    @RequestMapping("/demo")
    public String demo() {
        return "demo";
    }

    @RequestMapping("/log")
    public String log() {
        return "log";
    }
}
