package todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;

/*
 * 
 * Controller responsável por mapear as urls para os métodos, é o ponto de entrada. Com a anotação RequestMapping ela diz que método deve ser executada quando uma URL é requisitada 
executa esse método
*
*/

@RestController
public class TodoController {

	// Instancia automaticamente a classe abaixo da anotação
	// TodoRepository exetende o CrudRepository que tem implementações padrão para
	// consultar e salvar entidades
	@Autowired
	private TodoRepository todoRepository;

	/*
	 * 
	 * CrossOrigin é necessário porque o front end roda em outro servidor ou porta
	 * diferente do mesmo servdor. É preciso permitir que outras origens chamem a
	 * API, o que não acontece por padrão . Deve-se limitar a origin em ambientes de
	 * prodção, passando o parâmetro 'origin' para a anotação.
	 * 
	 * A anotação ResponseBody faz com que o tipo de retorno(Iteranle<Todo>), seja
	 * transformado em JSON.
	 * 
	 * A anotação RequestMapping faz com que o método seja executado quando uma
	 * URL(value) é chamda. Ela pode receber o método HTTP como parâmetro.
	 * 
	 * Esse método lista todas as tarefas criadas
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/todo", method = RequestMethod.GET)
	public @ResponseBody Iterable<Todo> list() {
		return todoRepository.findAll();
	}

	/*
	 * 
	 * A anotação RequestMapping faz com que o método seja executado quando uma
	 * URL(value) é chamda. Ela pode receber o método HTTP como parâmetro. Pode-se
	 * ter o mesmo value contanto que o método HTTP seja diferente
	 * 
	 * A anotação RequestBody diz ao spring que deve-se converter o body da chamada recebida para o tipo de parâmetro que segue a anotação, nesse caso,TodoDTO.
	 * DTO são objetos utilizados para a trasferência de dados.
	 * 
	 * Esse método cria tarefas
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/todo", method = RequestMethod.POST)
	public ResponseEntity<Void> createTodo(@RequestBody TodoDTO dto) {

		Todo todo = new Todo();
		todo.setTitle(dto.getContent());
		todo.setContent(dto.getContent());
		todo.setCompleted(dto.isCompleted());

		todoRepository.save(todo);

		return new ResponseEntity<Void>(HttpStatus.CREATED);

	}

	/*
	 * 
	 * A anotação RequestMapping faz com que o método seja executado quando uma
	 * URL(value) é chamda. Ela pode receber o método HTTP como parâmetro. Pode-se
	 * ter o mesmo value contanto que o método HTTP seja diferente. O value pode
	 * conter PathVariables, que são parâmetros passados via URL
	 * 
	 * Esse método exibe tarefas
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
	public @ResponseBody Todo show(@PathVariable("id") Integer id) {
		return todoRepository.findOne(id);
	}

	/*
	 * 
	 * 
	 * Esse método deletas tarefas
	 * 
	 */
	@CrossOrigin
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		Todo todo = todoRepository.findOne(id);
		todoRepository.delete(todo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

	/*
	 * 
	 * Esse método atualiza tarefas
	 * 
	 * 
	 */

	@CrossOrigin
	@RequestMapping(value = "/todo/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable("id") Integer id, @RequestBody TodoDTO dto) {

		Todo todo = todoRepository.findOne(id);
		todo.setTitle(dto.getTitle());
		todo.setContent(dto.getContent());
		todo.setCompleted(dto.isCompleted());

		todoRepository.save(todo);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}

}