package cn.com.springboot.shopping.service.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import cn.com.springboot.shopping.service.ILogService;
@Service
@Aspect
public class LogServiceImpl implements ILogService {
	@Pointcut("execution(* cn.com.springboot.shopping.service.impl.DemoServiceImpl.searchAllUserList())")
    public void demo() {}
	@Override
	@Before("demo()")
	public void log() {
    	System.out.println("Log.............");
    }

}
