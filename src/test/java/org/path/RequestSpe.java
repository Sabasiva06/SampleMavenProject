package org.path;

import org.path.Fields;
import org.path.Input;
import org.path.IssueType;
import org.path.Project;
import org.updatepojo.PutInputData;

public class RequestSpe {

	public static Input creatPost(String summary, String description) {

		IssueType type = new IssueType();
		type.setName("Bug");

		Project project = new Project();
		project.setKey("AM");

		Fields fields = new Fields();
		fields.setProject(project);
		fields.setSummary(summary);
		fields.setDescription(description);
		fields.setIssuetype(type);

		Input input = new Input();
		input.setFields(fields);

		return input;
	}
	public static PutInputData UpdatePost(String summary, String description) {

		

		org.updatepojo.Fields fields = new org.updatepojo.Fields();
		
		fields.setSummary(summary);
		fields.setDescription(description);
		

		PutInputData input = new PutInputData();
		input.setFields(fields);

		return input;
	}

}
