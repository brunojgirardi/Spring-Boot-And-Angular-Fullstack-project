package todo;

public class TodoDTO {

    private String content ;
    private String title;
    private boolean completed;
    
    /* 
     * 
     * DTOs são objetos utilizados para transferência de dados entre APIs/Implementações. 
     * Eles não devem ter setters, assim o objeto fica imutável após a criação.
     *
     */
    
    public TodoDTO() {
        this.content = null;
        this.title = null;
    }

    /* 
     * 
     * Ao invés de setters eles devem possuir construtores apropriados a cada caso de uso. 
     * 
     */
    
    public TodoDTO(String content, String title) {
        this.content = content;
        this.title = title;
    }
    
    public TodoDTO(String content, String title, boolean completed) {
        this.content = content;
        this.title = title;
        this.completed = completed;
    } 
    
    public boolean isCompleted(){
    	return this.completed;
    }
    
    public String getContent() {
        return content;
    }
    
    public String getTitle() {
        return title;
    }
}