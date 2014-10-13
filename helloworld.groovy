@RestController

public class hello {

	@RequestMapping("")
	public String helloWorld() {
		return "Hello SORT!";
	}
}