package java_swing_erp.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java_swing_erp.dto.Student;

public class JsonWriteThread extends Thread {
	private List<Student> list;
	private String fileName;
	private Gson gson = new Gson();
	
	public void setList(List<Student> list) {
		this.list = list;
	}



	public void setFileName(String fileName) {
		this.fileName = fileName;
	}



	@Override
	public void run() {
		String result = gson.toJson(list, new TypeToken<List<Student>>() {}.getType());
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))){
			bw.write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
