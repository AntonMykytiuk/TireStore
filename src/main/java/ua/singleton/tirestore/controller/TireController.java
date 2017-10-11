package ua.singleton.tirestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.singleton.tirestore.model.Tire;
import ua.singleton.tirestore.service.TireService;

import java.util.List;

@Controller
@RequestMapping("/")
public class TireController {

    private static final String TIRE_ATTRIBUTE_NAME = "tire";
    private static final String TIRE_LIST_ATTRIBUTE_NAME = "tireList";
    private static final String PAGE_TASK_ATTRIBUTE_NAME = "pageTask";

    private TireService tireService;

    @Autowired
    public TireController(TireService tireService) {
        this.tireService = tireService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getTires(Model model) {
        List<Tire> tireList = tireService.loadAllTires();
        model.addAttribute(TIRE_LIST_ATTRIBUTE_NAME, tireList);
        return "showTiresView";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createTire(Model model) {
        model.addAttribute(PAGE_TASK_ATTRIBUTE_NAME, "Create");
        Tire tire = new Tire();
        model.addAttribute(TIRE_ATTRIBUTE_NAME, tire);
        return "createOrModifyTireView";

    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String confirmCreate(@Validated @ModelAttribute("tire") Tire tire) {
        tireService.saveTire(tire);
        return "redirect:/";
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public String modifyTire(@PathVariable int id, Model model) {
        model.addAttribute(PAGE_TASK_ATTRIBUTE_NAME, "Modify");
        Tire tire = tireService.loadTireById(id);
        model.addAttribute(TIRE_ATTRIBUTE_NAME, tire);
        return "createOrModifyTireView";
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
    public String confirmModify(@Validated @ModelAttribute("tire") Tire tire) {
        tireService.saveTire(tire);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteTire(@PathVariable int id) {
        tireService.deleteTire(id);
        return "redirect:/";
    }
}
