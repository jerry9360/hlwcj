package {$packagename}.entity;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.dom4j.io.SAXReader;
import org.springframework.core.io.ClassPathResource;

import com.centit.jsmsa.core.entity.BaseEntity;

import freemarker.template.TemplateException;

@Entity
@Table(name = "{$table.code}")
public class {$table.upcode} extends BaseEntity implements Staticizable {

	/**
	 * 
	 */
	private static final long serialVersionUID =  1L;


	{$while}
	@Column(name = "{$column.code}")	
    private {$column.datatype} {$column.code};
    {$whileEnd}
    {$while}

	public {$column.datatype} get{$column.upcode}() {
		return {$column.code};
	}

	public void set{$column.upcode}({$column.datatype} {$column.code}) {
		this.{$column.code} = {$column.code};
	}
    {$whileEnd}



}
