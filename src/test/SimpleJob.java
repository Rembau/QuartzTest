package test;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {
	int x=0;
	public void execute(JobExecutionContext jobCtx)throws JobExecutionException {
		System.out.println(jobCtx.getTrigger().getName()+ 
				" triggered. time is:" + (new Date())+" "+x);
		x++;
	}
}
