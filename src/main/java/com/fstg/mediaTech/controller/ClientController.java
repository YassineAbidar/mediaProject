package com.fstg.mediaTech.controller;

import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fstg.mediaTech.bean.Client;
import com.fstg.mediaTech.service.IClientService;

@Controller
public class ClientController {
	@Autowired
	private IClientService clientService;

	@RequestMapping(value = "/user/index")
	public String index(Model model, @RequestParam(name = "motcle", defaultValue = "") String motcle) {
		List<Client> clients = clientService.findBymotCle("%" + motcle + "%");
		String moclet = motcle;
		model.addAttribute("listClient", clients);
		model.addAttribute("mc", moclet);
		return "Client/clients";
	}

	@RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
	public String delete(@RequestParam(name = "id") long id) {
		clientService.delete(id);
		return "redirect:/user/index";
	}

	@RequestMapping(value = "/admin/formClient", method = RequestMethod.GET)
	public String formClient(Model model) {
		model.addAttribute("client", new Client());
		return "Client/addClient";
	}

	@RequestMapping(value = "/admin/Formupdate", method = RequestMethod.GET)
	public String updateClient(Model model, @RequestParam(name = "id") long id) {
		Client client = clientService.chercheById(id);
		System.out.println(client.toString());
		model.addAttribute("client", client);
		return "Client/editClient";
	}

	@RequestMapping(value = "/admin/save", method = RequestMethod.POST)
	public String save(Model model, @Valid Client client, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "Client/addClient";
		}
		clientService.save(client);
		return "redirect:/user/index";

	}

	@RequestMapping(value = "/admin/update", method = RequestMethod.POST)
	public String update(Model model, @Valid Client client, BindingResult bindingResult) {
		clientService.updateClient(client.getNom(), client.getTele(), client.getPrenom(), client.getCode_client());
		return "redirect:/user/index";
	}

	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/user/index";

	}

	@RequestMapping(value = "/403")
	public String accessDenied() {
		return "Exeption/403";

	}

}
