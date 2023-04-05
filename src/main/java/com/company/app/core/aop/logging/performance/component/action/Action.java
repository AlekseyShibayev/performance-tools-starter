package com.company.app.core.aop.logging.performance.component.action;

import com.company.app.core.aop.logging.performance.PerformanceLogAnnotation;
import com.company.app.core.aop.logging.performance.component.ActionType;
import com.company.app.core.aop.logging.performance.component.GuidExtractor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public interface Action {

	ActionType getActionType();

	String getGuid(ProceedingJoinPoint proceedingJoinPoint, PerformanceLogAnnotation annotation);

	@Autowired
	default void registerMyself(GuidExtractor guidExtractor) {
		guidExtractor.putAction(this);
	}
}