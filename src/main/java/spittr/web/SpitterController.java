package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Path;
import javax.validation.Valid;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {
    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method= RequestMethod.GET)
    public String showRegistrationForm(Model model){
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @RequestPart("profilePicture") MultipartFile profilePicture,
            @Valid Spitter spitter,
            Errors errors) throws IOException {
        byte[] bytes = profilePicture.getBytes();

        if(errors.hasErrors()){
            return "registerForm";
        }
        spitterRepository.save(spitter);
//        BufferedOutputStream stream = new BufferedOutputStream(
//                new FileOutputStream(new File("tmp/spittr/upload/" + profilePicture.getOriginalFilename()))
//        );
//        stream.write(bytes);
//        stream.close();
        return "redirect:/spitter/" +
                spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model){
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
