package com.yfny.activityapi.controller;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yfny.activityapi.service.FlowDiagramService;

/**
 * ClassName: FlowDiagramController.java
 * Company: 北京易才博普奥管理咨询有限公司
 * Description:获取流程图片
 * author wanggongliang
 * 2019年5月24日 下午4:51:22
 */
@RestController
@RequestMapping(value = "/flowDiagram")
public class FlowDiagramController {

    //流程图相关Service
    @Autowired
    private FlowDiagramService flowDiagramService;

    /**
     * 根据流程实例ID获取流程图，高亮当前任务节点及历史节点
     * @param taskId   任务ID
     * @param response
     */
    @GetMapping(value = "/getImage/{processInstanceId}")
    public void getImage(@PathVariable String processInstanceId, HttpServletResponse response) throws Exception {
        //根据当前流程实例ID获取图片输入流
        InputStream is = flowDiagramService.getResourceDiagramInputStream(processInstanceId);
        if (is == null)
            return;
        response.setContentType("image/png");
        BufferedImage image = ImageIO.read(is);
        OutputStream out = response.getOutputStream();
        ImageIO.write(image, "png", out);
        is.close();
        out.close();
    }

    /**
     * 根据流程实例ID生成流程图，只高亮当前任务节点
     * @param taskId   任务ID
     * @param response
     */
    @GetMapping(value = "/getDiagram/{taskId}")
    public void getDiagram(@PathVariable String taskId, HttpServletResponse response) throws Exception {
        //根据当前流程实例ID获取图片输入流
        InputStream is = flowDiagramService.getDiagram(taskId);
        if (is == null)
            return;
        response.setContentType("image/png");
        BufferedImage image = ImageIO.read(is);
        OutputStream out = response.getOutputStream();
        ImageIO.write(image, "png", out);
        is.close();
        out.close();
    }

}
