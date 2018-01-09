package com.yzit.common.util;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		String genCfg = "/generator.xml";
		File configFile = new File(GenMain.class.getResource(genCfg).getFile());
		System.out.println(configFile.exists());
	}
}
