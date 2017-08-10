package todo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity 
public class Todo{
	
	  /* 
     * 
     * A anotação Entity diz ao spring data que a classe deve ser persistíve. O spring criará uma tabela no banco de dados caso ainda não exista,
     * com as colunas necessárias para salvar cada atributo da classe. Também serão criadas constraints como nullable false/true nas tabelas de acordo com essas classes. 
     *
     */
	
	
	  /* 
     * 
     * A anotação Id diz qual é a chave primária da tabela a ser criada para salvar a entidade, além disse é possível definir que esse campo seja alimentado automaticamente.
     *
     */
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String title;

    @NotNull
    private String content;
    
    private boolean completed;
    
    public boolean isCompleted(){
    	return this.completed;
    }

    public void setCompleted(boolean completed){
    	this.completed = completed;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}


}