package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class OfferController {
    //Controller -> Service -> Dao
    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public String showOffers(Model model) {
        // ServiceLayer를 호출하여 결과를 offers에 저장
        List<Offer> offers = offerService.getAllOffers();
        // 저장한 값을 model에 저장 후
        model.addAttribute("id_offers", offers);
        // view로 넘김
        return "offers";

        // -> 받은 view는 model에 있는 결과물(offers)를 끄집어내서 html 생성
    }

}
