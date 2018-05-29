package com.presagis.art.examples.win10calculator.pages;

import org.sikuli.script.Screen;

import io.github.marcoslimaqa.sikulifactory.FindBy;
import io.github.marcoslimaqa.sikulifactory.SikuliElement;
import io.github.marcoslimaqa.sikulifactory.SikuliFactory;

public class ScientificCalculatorPage {
	
	Screen sikuli;
	
	@FindBy(image = "sin-button.png", similarity =90)
	private SikuliElement sinButton;
	
	@FindBy(image = "cos-button.png", similarity =90)
	private SikuliElement cosButton;

	public ScientificCalculatorPage(Screen sikuli) {
		this.sikuli = sikuli;
		SikuliFactory.initElements(sikuli, this);
	}
	
	public boolean isScientificButtonsPresent() {
		boolean isScientificButtonPresent = true;
		System.out.println( sinButton.exists(5));
		isScientificButtonPresent = sinButton.exists(5)? isScientificButtonPresent : false;
		isScientificButtonPresent = cosButton.exists(5)? isScientificButtonPresent : false;
		
		return isScientificButtonPresent;
	}

}
