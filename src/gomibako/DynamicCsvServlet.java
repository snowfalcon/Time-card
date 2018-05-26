package gomibako;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hal.java.form.TimeObj;

public class DynamicCsvServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// POSTメソッドでアクセスが来てもGETメソッドで全部処理します。
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		TimeObj obj = new TimeObj();
		int day = obj.getDay();
		String sday = String.valueOf(day);
		String date = obj.getDate();
		String start = obj.getStart();
		String end = obj.getEnd();
		String work = obj.getWork();
		String[][] rows = { { sday, date, start, end, work } };
		TimeObj[] s = null;
		System.out.println(s);

		// 文字コード設定
		resp.setContentType("text/html; charset=UTF-8");
		// ファイル名設定（ファイル名を設定しないと、htmlとして画面に表示されてしまいます
		resp.setHeader("Content-Disposition", "attachment; filename=\"dynamic.csv\"");
		// CSVデータ作成
		StringBuffer sb = new StringBuffer();
		for (String[] row : rows) {
			for (int i = 0; i < row.length; i++) {
				if (i == 0) {
					sb.append("\"");
				} else {
					sb.append("\",\"");
				}
				sb.append(row[i]);
				if (i == row.length - 1) {
					sb.append("\"\n");
				}
			}
		}
		// レスポンスにCSV出力
		PrintWriter w = resp.getWriter();
		w.print(sb.toString());
		w.flush();

	}
}