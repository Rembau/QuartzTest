package springQuartzTest;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainLaunch {

	public static void main(String[] args) {
		String xmlPath = "conf/applicationContext.xml";
			new FileSystemXmlApplicationContext(xmlPath);
	}
}
