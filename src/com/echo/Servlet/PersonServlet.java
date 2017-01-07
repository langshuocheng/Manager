package com.echo.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.echo.Dao.PersonDao;
import com.echo.Model.Person;

@WebServlet(urlPatterns={"/personService/*"})
public class PersonServlet extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
			{
		doPost(req, resp);
			}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String jspUrl = null;
		String requestUrl = req.getRequestURI();
		boolean Flag = false;
		if(requestUrl.endsWith("/tosavePerson"))
		{
			jspUrl = "/person/savaPerson.jsp";
		}
		else if (requestUrl.endsWith("/savePerson"))
		{
			String pId = req.getParameter("pId");
			String pName = req.getParameter("pName");
//			System.out.println(pName);
			String pSex = req.getParameter("pSex");
			String pAge = req.getParameter("pAge");
			String pPost = req.getParameter("pPost");
			String pStartTime = req.getParameter("pStartTime");
			String pYear = req.getParameter("pYear");
			Person person = new Person();
			person.setpId(Integer.parseInt(pId));
			person.setpName(pName);
			person.setpSex(pSex);
			person.setpAge(Integer.parseInt(pAge));
			person.setpPost(Integer.parseInt(pPost));
			person.setpStartTime(pStartTime);
			person.setpYear(Integer.parseInt(pYear));
			try 
			{
				Flag = new PersonDao().savePerson(person);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			if (Flag)
			{
				jspUrl = "/common/success.jsp";
			}
			else
			{
				jspUrl = "/common/error.jsp";
			}
		}
		else if (requestUrl.endsWith("/todeletePerson"))
		{
			jspUrl = "/person/deletePerson.jsp";
		}
		else if (requestUrl.endsWith("/deletePerson"))
		{
			int pId = Integer.parseInt(req.getParameter("pId"));
			try 
			{
				Flag = new PersonDao().deletePerson(pId);
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			if (Flag)
			{
				jspUrl = "/common/success.jsp";
			}
			else
			{
				jspUrl = "/common/error.jsp";
			}
		}
		else if (requestUrl.endsWith("/toupdataPerson"))
		{
			jspUrl = "/person/updataPerson.jsp";
		}
		else if (requestUrl.endsWith("/updataPerson"))
		{
			String pId = req.getParameter("pId");
			String pName = req.getParameter("pName");
			String pSex = req.getParameter("pSex");
			String pAge = req.getParameter("pAge");
			String pPost = req.getParameter("pPost");
			String pStartTime = req.getParameter("pStartTime");
			String pYear = req.getParameter("pYear");
			Person person = new Person();
			person.setpId(Integer.parseInt(pId));
			person.setpName(pName);
			person.setpSex(pSex);
			person.setpAge(Integer.parseInt(pAge));
			person.setpPost(Integer.parseInt(pPost));
			person.setpStartTime(pStartTime);
			person.setpYear(Integer.parseInt(pYear));
			try 
			{
				Flag = new PersonDao().updataPerson(person);
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			if (Flag)
			{
				jspUrl = "/common/success.jsp";
			}
			else
			{
				jspUrl = "/common/error.jsp";
			}
		}
		else if (requestUrl.endsWith("/toselectAllPerson"))
		{
			int count;
			try 
			{
				count = new PersonDao().selectPersonWithNum();
			if (count > 0)
			{
				List<Person> list = new PersonDao().selectPerosnWithList(0, 10);
				req.setAttribute("listPerson", list);
				req.setAttribute("countPerson", count);

			} 
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			jspUrl = "/person/index.jsp";
		}
		else if (requestUrl.endsWith("/toselectPersonById"))
		{
			jspUrl = "/person/selectOnePerson.jsp";
		}
		else if (requestUrl.endsWith("/selectPersonById"))
		{
			int pId = Integer.parseInt(req.getParameter("pId"));
			Person person = new PersonDao().selectPersonById(pId);
			req.setAttribute("person", person);

		}

		try 
		{
			//控制转发
			req.getRequestDispatcher(jspUrl).forward(req, resp);
		} 
		catch (ServletException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}

	}

}


