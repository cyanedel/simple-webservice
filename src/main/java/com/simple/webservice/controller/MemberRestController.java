package com.simple.webservice.controller;

import com.google.gson.Gson;
import com.simple.webservice.model.MemberDTO;
import com.simple.webservice.service.member.MemberService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/member")
public class MemberRestController {
    private Gson gson = new Gson();
    private final MemberService memberService;
    public MemberRestController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/")
    public String index() {
        return "Greetings from Member API!";
    }

    @GetMapping("/data/{memberId}")
    public String getMemberData(@PathVariable int memberId) {
        MemberDTO member = memberService.getMemberData(memberId);
        String memberJSONStr = gson.toJson(member);

        return memberJSONStr;
    }

    @GetMapping("/data-json/{memberId}")
    public Map<String, Object> getMemberDataJSON(@PathVariable int memberId) {
        MemberDTO member = memberService.getMemberData(memberId);

        Map<String, Object> data = new HashMap<>();
        data.put("id", member.getId());
        data.put("name", member.getMemberName());
        data.put("age", member.getAge());
        data.put("city", member.getCity());
        data.put("timestamp", System.currentTimeMillis());

        return data;
    }
}
