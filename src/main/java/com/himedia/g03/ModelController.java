package com.himedia.g03;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class ModelController {
    @GetMapping("/")//요청 주소가 http://localhost:8070/ 일때 실행되는 메서드
    public @ResponseBody String root() {
        return "<h1>Model & View</h1>";//화면에 보여질 내용이 String로 리턴
    }
    
    @GetMapping("/test1")
    public String test1(HttpServletRequest request, Model model) {
        
        //Spring Boot의 Controller에는 많은 중요 요소들이 전달인수로 일괄 전달되고있다.
        //이중 필요한 요소를 매게변수로 선택적으로 받아서 사용 가능
        //request도 마찬가지로 매개변수로 추가해서 사용 가능

        //모델2 방식에서는 request에 데이터를 넣고 포워딩 했지만
        //여기서는 request에 데이터를 넣기만하면 자동으로 전달
        request.setAttribute("name1","홍길동");

        model.addAttribute("name2","김하나");

        return "test1";
    }

    @GetMapping("/test2")
    public ModelAndView test2(HttpServletRequest request) {
        //ModelAndView: 전달자료도 저장하고, 이동할 페이지도 지정해서
        //한번에 파일이름 리턴과 자료전달ㅇ르 가능하게 하는 클래스
        //현재 메서드는 그 객체를 리턴형으로 지정중
        ModelAndView mav = new ModelAndView();

        ArrayList<String> list = new ArrayList<String>();
        list.add("item1");
        list.add("item2");
        list.add("item3");

        //request.setAttrubute("list",list)
        //model.addAttribute("list", list)
        mav.addObject("list", list);

        //이동할 jsp지정
        mav.setViewName("myView");

        return mav;
    }
    
}
