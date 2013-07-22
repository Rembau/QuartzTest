package test;

import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class CronTriggerRunner {
	public static void main(String args[])
	{
		Scheduler scheduler =null;
		try
		{
			JobDetail jobDetail = new JobDetail("job1_2", "jGroup1",SimpleJob.class);
			//创建CronTrigger，指定组及名称
			CronTrigger cronTrigger = new CronTrigger("trigger1_2", "tgroup1");
			CronExpression cexp = new CronExpression("0/5 * * * * ?");//定义Cron表达式
			cronTrigger.setCronExpression(cexp);//设置Cron表达式
			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			scheduler = schedulerFactory.getScheduler();
			scheduler.scheduleJob(jobDetail, cronTrigger);
			scheduler.triggerJob("job1_2", "jGroup1");
			scheduler.start();
			
			String tgn[] = scheduler.getTriggerGroupNames();
			for (String g:tgn) {
				String tjb[] = scheduler.getTriggerNames(g);
				for (String string : tjb) {
					System.out.println(string);
					Trigger ct = scheduler.getTrigger(string, g);
					System.out.println("ct-"+ct.getJobGroup());
					System.out.println(ct.getStartTime());
					System.out.println(ct.getEndTime());
					System.out.println(ct.getFinalFireTime());	
					System.out.println(ct.getNextFireTime());
					JobDetail jb = scheduler.getJobDetail("job1_2", "jGroup1");
					for (String string2 : jb.getJobListenerNames()) {
						System.out.println("--"+string2);
					}
					System.out.println(jb.getJobClass());
					if(ct instanceof CronTrigger){
						System.out.println(((CronTrigger)ct).getCronExpression());
					}
					
				}
			}
			
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
