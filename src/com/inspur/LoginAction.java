package com.inspur;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

 
public class LoginAction implements Action
{
	private String username;
	private String password;

	//username���Ե�setter��getter����
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getUsername()
	{
		return this.username;
	}

	//password���Ե�setter��getter����
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPassword()
	{
		return this.password;
	}
	
	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		//ͨ��ActionContext����application��Χ������ֵ
		Integer counter = (Integer)ctx.getApplication()
			.get("counter");
		if (counter == null)
		{
			counter = 1;
		}
		else
		{
			counter = counter + 1;
		}
		//ͨ��ActionContext����application��Χ������
		ctx.getApplication().put("counter" , counter);
		//ͨ��ActionContext����session��Χ������
		ctx.getSession().put("user" , getUsername());
		if (getUsername().equals("admin")
			&& getPassword().equals("123") )
		{
			//ͨ��ActionContext����request��Χ������
			ctx.put("tip" , "��������ʾ�����Ѿ��ɹ��ĵ�¼");
			return SUCCESS;
		}
		else
		{
			//ͨ��ActionContext����request��Χ������
			ctx.put("tip" , "��������ʾ����¼ʧ��");
			return ERROR;
		}
	}
	
	public String execute1() throws Exception
	{
		ServletContext sc=ServletActionContext.getServletContext();
		ActionContext ctx=ActionContext.getContext();
		//ͨ��ActionContext����application��Χ������ֵ
		Integer counter = (Integer)sc.getAttribute("counter");
		if (counter == null)
		{
			counter = 1;
		}
		else
		{
			counter = counter + 1;
		}
		//ͨ��ActionContext����application��Χ������
		sc.setAttribute("counter",counter);
		//ͨ��ActionContext����session��Χ������
		HttpSession session=ServletActionContext.getRequest().getSession();;
		session.setAttribute("user" , getUsername());
		if (getUsername().equals("admin")
			&& getPassword().equals("123") )
		{
			//ͨ��ActionContext����request��Χ������
			ctx.put("tip" , "��������ʾ�����Ѿ��ɹ��ĵ�¼");
			return SUCCESS;
		}
		else
		{
			//ͨ��ActionContext����request��Χ������
			ctx.put("tip" , "��������ʾ����¼ʧ��");
			return ERROR;
		}
	}
}