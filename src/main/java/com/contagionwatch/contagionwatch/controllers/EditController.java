package com.contagionwatch.contagionwatch.controllers;

import com.contagionwatch.contagionwatch.dao.EntryRepository;
import com.contagionwatch.contagionwatch.models.Entry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditController {
    private final EntryRepository entryDao;

    public EditController(EntryRepository entryDao) {
        this.entryDao = entryDao;
    }

    @RequestMapping(path = "/edit", method = RequestMethod.POST)
    public String editEntry(@ModelAttribute Entry entry, @ModelAttribute long id){
        if(entry.getDate() != null && entry.getDisease() != null && entry.getLocation() != null ) {
            entryDao.save(entry);
        }
        return "redirect:/information/" + id;
    }
}
