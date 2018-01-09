package com.yzit.plateform.util.freemaker.tag;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import freemarker.core.Environment;
import freemarker.template.ObjectWrapper;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 
 * @author Administrator
 *
 */
public class PicTagModel  implements TemplateDirectiveModel {

	/**
	 * Environment对象存储模板执行时的运行状态信息
	 */
	 public void execute(Environment env, Map params, TemplateModel[] loopVars,
	            TemplateDirectiveBody body) throws TemplateException, IOException {
		 
		 //获取参数
		 
		 List picList = null;
		 
		 //j
		 env.setVariable("picList", ObjectWrapper.DEFAULT_WRAPPER.wrap(picList));
	     body.render(env.getOut());
	}

}
