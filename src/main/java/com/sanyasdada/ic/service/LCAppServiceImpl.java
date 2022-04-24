package com.sanyasdada.ic.service;

import org.springframework.stereotype.Service;

@Service
public class LCAppServiceImpl implements LCAppService {
	public final String LC_APP_FORMULA = "FLAME";

	@Override
	public String calculateLove(String userName, String crushName) {

		int userAndCrushNameCount = (userName + crushName).toCharArray().length;
		int formulaCount = LC_APP_FORMULA.length();
		int rem = userAndCrushNameCount % formulaCount;
		char resultChar = LC_APP_FORMULA.charAt(rem);

		String result = whatBetweenUs(resultChar);

		return result;
	}

	@Override
	public String whatBetweenUs(char calculationResult) {
		String result = null;
		if (calculationResult == 'F') {
			result = LoveCalculatorConstants.F_CHAR_MEANING;
		}

		if (calculationResult == 'L') {
			result = LoveCalculatorConstants.L_CHAR_MEANING;
		}

		if (calculationResult == 'A') {
			result = LoveCalculatorConstants.A_CHAR_MEANING;
		}

		if (calculationResult == 'M') {
			result = LoveCalculatorConstants.M_CHAR_MEANING;
		}

		if (calculationResult == 'E') {
			result = LoveCalculatorConstants.E_CHAR_MEANING;
		}

		return result;
	}

}
