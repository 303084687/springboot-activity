package com.yfny.activityapi.service;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.task.Task;

public interface ActivityDemoService {
    //根据流程id启动流程
    public void startProcesses(String bizId);

    //根据用户id查询待办任务列表
    public List<Task> findTasksByUserId(String userId);

    /**
     * <p>描述:任务审批（通过/拒接） </p>  
     * @param taskId 任务id
     * @param userId 用户id
     * @param result false OR true
     */
    public void completeTask(String taskId, String userId, String result);

    /**
     * 更改业务流程状态#{ActivityDemoServiceImpl.updateBizStatus(execution,"tj")}
     * @param execution
     * @param status
     */
    public void updateBizStatus(DelegateExecution execution, String status);

    //流程节点权限用户列表${ActivityDemoServiceImpl.findUsers(execution,sign)}
    public List<String> findUsersForSL(DelegateExecution execution);
}
