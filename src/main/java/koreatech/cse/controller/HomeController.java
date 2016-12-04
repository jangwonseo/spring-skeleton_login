package koreatech.cse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {
    @ModelAttribute("name")
    private String getName() {
        return "IamHomeControllerModelAttribute";
    }

    @RequestMapping
    public String home() {
        return "hello";
    }

    @RequestMapping("/jstlTest")
    public String emptyTest(Model model) {
        String a = null;
        String b = "";
        String c = "hello";
        List<String> d = new ArrayList<String>();
        List<String> e = new ArrayList<String>();
        e.add(a);
        e.add(b);

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("c", c);
        model.addAttribute("d", d);
        model.addAttribute("e", e);

        List<String> stringArray = new ArrayList<String>();
        stringArray.add("one");
        stringArray.add("two");
        stringArray.add("three");
        model.addAttribute("stringArray", stringArray);

        Map<Integer, String> stringMap = new HashMap<Integer, String>();
        stringMap.put(1, "one");
        stringMap.put(2, "two");
        stringMap.put(3, "three");
        model.addAttribute("stringMap", stringMap);

        return "jstlTest";
    }

    @RequestMapping("/test/testing")
    public String test(Model model){
        String str = "우리는 한 팀이다.";
        model.addAttribute("str",str);
        return "testing/test";

    }

    //파라미터가 없어도 페이지로 넘거가긴함 httpSevletRequest의 경우.,
    @RequestMapping("/test/requestHTTP")
    public String tested(HttpServletRequest httpServletRequest, Model model){
        String id = httpServletRequest.getParameter("id");
        String pw = httpServletRequest.getParameter("pw");

        model.addAttribute("id", id);
        model.addAttribute("pw", pw);

        return "/testing/tested";
    }

    //requestParam은 파라미터값이 안오면 404에러남
    @RequestMapping("/test/requestParam")
    public String paramTest(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model){
        model.addAttribute("id", "mklmkl2001");
        model.addAttribute("pw", "link1234");

        return "testing/checkId";
    }

    @RequestMapping("/test/member")

}
