package fr.gtm.cinema.dao;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class FilmDaoInterceptor {
	private Logger LOG = Logger.getLogger(FilmDaoInterceptor.class.getName());
	
	
	@PostConstruct
	public void init(InvocationContext ctx) {
		LOG.info(">>> @PostConstruct de "+ctx.getTarget().getClass().getName());
	}
	
	@PreDestroy
	public void destroy(InvocationContext ctx) {
		LOG.info("=====> @PreDestroy de "+ctx.getTarget().getClass().getName());
	}
	@AroundInvoke
	public Object foo(InvocationContext ctx) throws Exception{
		LOG.info("<<< methode invoquée "+ctx.getMethod().getName());
		Object result = ctx.proceed();
	
		return result ;
	}
	
}
