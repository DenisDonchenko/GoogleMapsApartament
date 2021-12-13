package org.map.apartament.controller;

import com.google.gson.Gson;
import org.map.apartament.facade.FlatFacade;
import org.map.apartament.facade.impl.FlatFacadeImpl;
import org.map.apartament.model.dto.flat.FlatDto;
import org.map.apartament.model.dto.flat.FlatDtoOutput;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class FlatController {

    private final FlatFacade flatFacade;

    public FlatController(FlatFacadeImpl flatFacade) {
        this.flatFacade = flatFacade;
    }

    @GetMapping
    public String getMainPage(Model model) {
        model.addAttribute("flatDtosJson", convertArrayToObj());

        return "index";
    }

    @PostMapping("/flat/save")
    public String saveUser(@ModelAttribute FlatDto dto) throws IOException {
        flatFacade.saveFlat(dto);

        return "redirect:/";
    }

    private String convertArrayToObj() {
        Gson gson = new Gson();
        List<FlatDtoOutput> dtoOutputs = flatFacade.findAllFlat();

        return gson.toJson(dtoOutputs);
    }
}


