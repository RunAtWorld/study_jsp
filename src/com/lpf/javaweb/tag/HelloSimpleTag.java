package com.lpf.javaweb.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloSimpleTag implements SimpleTag {

	private PageContext pageContext;
	private String value;
	private String count;
	public void setValue(String value) {
		this.value = value;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("doTag");
		System.out.println("value:"+value + "   count:"+count);
		
		JspWriter out = pageContext.getOut();
		int c= 0;
		c = Integer.parseInt(count);
		for(int i=0;i<c;i++){
			out.print(value + "<br/>");
		}
		
	}

	@Override
	public JspTag getParent() {
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		System.out.println("setJspBody");
	}

	//JSP引擎调用，把代表JSP页面的PageContext对象传入
	//PageContext可以获得JSP页面的其他8个隐含对象
	//所以凡是JSP页面可以做的，标签处理器都能完成
	@Override
	public void setJspContext(JspContext arg0) {
		System.out.println("setJspContext");
		pageContext=(PageContext) arg0;
	}

	@Override
	public void setParent(JspTag arg0) {
		System.out.println("setParent");
	}

}
