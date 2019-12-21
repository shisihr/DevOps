package ua.yermolenko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ua.yermolenko.model.Operation;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("history")
public class OperationController {

    @Autowired
    Operation operation;

    /**
     * Ajax request using jQuery
     * @param firstNumber first digit for calculation
     * @param secondNumber second digit for calculation
     * @param operator "+-/*"
     * @param model for setting data to session
     * @return String with calculated result
     */
    @RequestMapping(value = "/jquer", method = RequestMethod.GET, produces = {"text/html; charset=UTF-8"})
    public @ResponseBody
    String jquer(@RequestParam("firstNumber") Integer firstNumber,
                 @RequestParam("secondNumber") Integer secondNumber,
                 @RequestParam("operator") String operator,
                 ModelMap model) {
        Double result = operation.calculate(firstNumber, secondNumber, operator);
        String hist = ("" + firstNumber + " " + operator + " " + secondNumber + " = " + result);
        List<String> list;
        if(model.get("history") == null){
            list = new ArrayList<>();
            list.add(hist);

        }else {
            list = (ArrayList<String>) model.get("history");
            list.add(hist);
        }
            model.put("history", list);
            return result.toString();
        }
 }
