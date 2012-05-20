package org.springframework.samples.petclinic.web;

import java.beans.PropertyEditorSupport;
import java.util.Collection;

import org.springframework.samples.petclinic.Clinic;
import org.springframework.samples.petclinic.PetType;

/**
 * @author Mark Fisher
 * @author Juergen Hoeller
 */
public class PetTypeEditor extends PropertyEditorSupport {

	private final Clinic clinic;


	public PetTypeEditor(Clinic clinic) {
		this.clinic = clinic;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
        Collection<PetType> petTypes = this.clinic.getPetTypes();
        for (PetType type : petTypes) {
			if (type.getName().equals(text)) {
				setValue(type);
			}
		}
	}

}
