package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recoveryroom")
public class RecoveryRoomController {

    @Autowired
    private RecoveryRoomService recoveryRoomService;

    private final String VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE = "recoveryroom/createOrUpdateRecoveryRoomForm";

    @ModelAttribute("types")
	public List<RecoveryRoomType> populateRecoveryRoomTypes() {
		return recoveryRoomService.getAllRecoveryRoomTypes();
	}

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("recoveryRoom", new RecoveryRoom());
        return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE;
    }

    @PostMapping("/create")
    public String postCreateForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, Model model) {
        if (result.hasErrors()) {
			model.addAttribute("recoveryRoom", recoveryRoom);
			return VIEWS_RECOVERY_ROOM_CREATE_OR_UPDATE;
		} else {
            recoveryRoomService.save(recoveryRoom);                    
			return "welcome";
		}
    }
    
}
