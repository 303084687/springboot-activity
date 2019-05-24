package com.yfny.activityapi.utils;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@SuppressWarnings("all")
public class ActivitiUtils {

    @Autowired
    private RepositoryService repositoryService;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityService;

    ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();

    /**
     * 启动流程引擎
     * @param userId 流程发起人ID
     * @param key    流程ID
     * @return
     */
    public String getProcessInstance(String userId, String key) {
        //读取配置文件流
        //InputStream in = this.getClass().getClassLoader().getSystemResourceAsStream("processes/" + key + ".zip");
        //ZipInputStream zipInputStream = new ZipInputStream(in);
        //部署流程实例
        //Deployment deployment = repositoryService.createDeployment().addZipInputStream(zipInputStream).key(key).deploy();
        identityService.setAuthenticatedUserId(userId);
        //获取流程定义
        //ProcessDefinition processDefinition = repositoryService.createProcessDefinitionQuery().deploymentId(key).singleResult();
        //根据流程定义启动流程
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById(key);
        return processInstance.getId().toString();
    }

}
