package ir.freeland.springboot.xml;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import generated.Student;
import generated.Teacher;

@SpringBootApplication
@EntityScan("ir.freeland.springboot.persistence.model")
public class StudentApplication {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		
		SpringApplication.run(StudentApplication.class, args);
		// Read-XML
		File xmlfile = new ClassPathResource("Student.xml").getFile();
		XmlMapper xmlMapper = new XmlMapper();
		Student Student = xmlMapper.readValue(xmlfile, Student.class);
		System.out.println(Student);

		File xmlfile1 = new ClassPathResource("Teacher.xml").getFile();
		Teacher Teacher = xmlMapper.readValue(xmlfile1, Teacher.class);
		System.out.println(Teacher);

		// Write-XML#serialization
		Student s1 = new Student();
		s1.setFirstName("Mas");
		s1.setLastName("Rad");
		s1.setAge("27!");
		s1.setCourse("java!!");
		xmlMapper.writeValue(new File("generated-from-java-Student.xml"), s1);
		// Write-Json
		ObjectMapper jmapper = new ObjectMapper();
		jmapper.writeValue(new File("generated-from-java-Student.json"), s1);
		
		// Read-Json#deserialize
		File jsonfile = new ClassPathResource("Student.json").getFile();
		var s11 = jmapper.readValue(jsonfile, Student.class);
		System.out.println(s11);
	
	}


	

	 

}
