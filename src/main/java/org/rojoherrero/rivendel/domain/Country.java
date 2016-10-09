package org.rojoherrero.rivendel.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Country {
	
	RIVENDELL("Rivendell",new String[] {"Rivendell"}), 
	THE_SHIRE("The Shire", new String[] {"Hobbiton","Bywater","Michel Delving","Overhill","Tuckborough"}),
	ROHAN("Rohan",new String[]{"Edoras", "Helm's Deep"}),
	GONDOR("Gondor", new String[]{"Minas Tirith ","Osgiliath","Isengard","Cair Andros"});

	private @Getter String countryName;
	private @Getter String[] countryCities;

}
