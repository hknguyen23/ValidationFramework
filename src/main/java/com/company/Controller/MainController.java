package com.company.Controller;

import com.company.Constant.ValidatorStrategy;
import com.company.FunctionManager.ValidationManager;
import com.company.Object.Person;
import com.company.Object.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

	ValidationManager manager = ValidationManager.createValidatorStrategyByName(
			ValidatorStrategy.NORMAL_VALIDATOR.name());

	@RequestMapping(value = {"/addPerson"}, method = RequestMethod.GET)
	public String showAddPersonPage(Model model) {

		PersonForm personForm = new PersonForm();
		model.addAttribute("personForm", personForm);

		return "addPerson";
	}

	@RequestMapping(value = {"/addPerson"}, method = RequestMethod.POST)
	public String savePerson(Model model, //
	                         @ModelAttribute("personForm") PersonForm personForm) {

		Person newPerson = new Person();
		newPerson.setAge(personForm.getAge());
		newPerson.setDateOfBirth(personForm.getDateOfBirth());
		newPerson.setEmail(personForm.getEmail());
		newPerson.setID(personForm.getID());
		newPerson.setIDSerialNumber(personForm.getIDSerialNumber());
		newPerson.setPassword(personForm.getPassword());
		newPerson.setName(personForm.getName());

		List<String> errorMessageList = manager.validate(newPerson);

		if (!errorMessageList.isEmpty()) {
			model.addAttribute("errorMessages", errorMessageList);
			return "addPerson";
		}

		model.addAttribute("successMessage", "Register successfully");
		return "addPerson";
	}
}
