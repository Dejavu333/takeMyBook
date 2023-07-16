package com.elte.fsz.takemybook.application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.elte.fsz.takemybook.domain.Bookworm;
import com.elte.fsz.takemybook.domain.Location;
import com.elte.fsz.takemybook.repository.BookwormRepository;
import com.elte.fsz.takemybook.repository.LocationRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
public class MapsController
{
    //properties
    @Autowired
    private BookwormRepository bookwormRepository;
    @Autowired
    private LocationRepository locationRepository;


    //methods //routes
    @RequestMapping(path = "/m", method = RequestMethod.GET) //serveMaps
    @ResponseBody
    public ModelAndView serveMaps()
    {
        return new ModelAndView("maps");
    }


    @RequestMapping(path = "/readEveryBookWorm", method = RequestMethod.GET)
	@ResponseBody
	public String readEveryBookWorm() throws JsonProcessingException
    {
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(bookwormRepository.findAll());
    }


    @RequestMapping(path = "/updateBookWormLocationById", method = RequestMethod.POST)
    @ResponseBody
    public String updateBookWormLocationById(@RequestBody Location l )
    {
        Optional<Bookworm> bookworm = bookwormRepository.findById(l.getId());
        if (bookworm.isPresent())
        {
            Location location = new Location(); location.setLatitude(l.getLatitude()); location.setLongitude(l.getLongitude());
            bookworm.get().setLocation(location);
            locationRepository.save(location);
            bookwormRepository.save(bookworm.get());
            return "OK";
        }
        return "ERROR";
    }
}
