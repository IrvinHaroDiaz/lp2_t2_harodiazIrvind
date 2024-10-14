package pe.com.cibertec.lp2_t2_harodiazIrvind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.cibertec.lp2_t2_harodiazIrvind.service.AreaService;

@Controller
public class AreaController {

    @Autowired
    private AreaService areaService;

    @GetMapping("/areas")
    public String listarAreas(Model model) {
        model.addAttribute("areas", areaService.listarAreas());
        return "area-list";
    }
}
