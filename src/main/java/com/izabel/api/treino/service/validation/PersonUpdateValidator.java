package com.izabel.api.treino.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.izabel.api.treino.controller.exception.FieldMessage;
import com.izabel.api.treino.domain.Person;
import com.izabel.api.treino.dto.PersonDto;
import com.izabel.api.treino.repository.PersonRepository;

public class PersonUpdateValidator implements ConstraintValidator<PersonUpdate, PersonDto> {
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public void initialize(PersonUpdate ann) {
	}

	@Override
	public boolean isValid(PersonDto objDto, ConstraintValidatorContext context) {
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		Person aux = personRepository.findByEmail(objDto.getEmail());
		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
