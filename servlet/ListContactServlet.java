package gz.itcast.contactSys_web.servlet;

import gz.itcast.contactSys_web.dao.ContactDao;
import gz.itcast.contactSys_web.dao.impl.ContactDaoImpl;
import gz.itcast.contactSys_web.entity.Contact;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListContactServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ContactDao dao = new ContactDaoImpl();
		List<Contact> list = dao.findAll();
		
		//2.鏄剧ず鍒版祻瑙堝櫒
		response.setContentType("text/html;charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String html = "";
		
		
		html += "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
		html += "<html xmlns='http://www.w3.org/1999/xhtml'>";
		html += "<head>";
		html += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
		html += "<title>鏌ヨ鎵�鏈夎仈绯讳汉</title>";
		html += "<style type='text/css'>";
		html += "	table td{";
		html += "		/*鏂囧瓧灞呬腑*/";
		html += "		text-align:center;";
		html += "	}";
		html += "	";
		html += "	/*鍚堝苟琛ㄦ牸鐨勮竟妗�*/";
		html += "	table{";
		html += "		border-collapse:collapse;";
		html += "	}";
		html += "</style>";
		html += "</head>";
		html += "";
		html += "<body>";
		html += "<center><h3>鏌ヨ鎵�鏈夎仈绯讳汉</h3></center>";
		html += "<table align='center' border='1' width='800px'>";
		html += "	<tr>";
		html += "    	<th>缂栧彿</th>";
		html += "        <th>濮撳悕</th>";
		html += "        <th>鎬у埆</th>";
		html += "        <th>骞撮緞</th>";
		html += "        <th>鐢佃瘽</th>";
		html += "        <th>閭</th>";
		html += "        <th>QQ</th>";
		html += "        <th>鎿嶄綔</th>";
		html += "    </tr>";
		if(list!=null){
			for (Contact contact : list) {
				html += "    <tr>";
				html += "    	<td>"+contact.getId()+"</td>";
				html += "        <td>"+contact.getName()+"</td>";
				html += "        <td>"+contact.getGender()+"</td>";
				html += "        <td>"+contact.getAge()+"</td>";
				html += "        <td>"+contact.getPhone()+"</td>";
				html += "        <td>"+contact.getEmail()+"</td>";
				html += "        <td>"+contact.getQq()+"</td>";
				html += "        <td><a href='"+request.getContextPath()+"/QueryContactServlet?id="+contact.getId()+"'>淇敼</a>&nbsp;<a href='"+request.getContextPath()+"/DeleteContactServlet?id="+contact.getId()+"'>鍒犻櫎</a></td>";
				html += "    </tr>";
			}
		}
		html += "    <tr>";
		html += "    	<td colspan='8' align='center'><a href='"+request.getContextPath()+"/addContact.html'>[娣诲姞鑱旂郴浜篯</a></td>";
		html += "    </tr>";
		html += "</table>";
		html += "</body>";
		html += "</html>";

		
		writer.write(html);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
