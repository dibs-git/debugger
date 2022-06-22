
public class UserBean implements Comparable<UserBean> {
	 String name, author;
	 static String publisher;
	int id, quantity;
		
	public UserBean(int id, String name, String author, String publisher, int quantity) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.id = id;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int compareTo(UserBean o) {
		// TODO Auto-generated method stub
		
		return this.author.compareTo(o.author);
	}

	@Override
	public String toString() {
		return "UserBean [name=" + name + ", author=" + author + ", id=" + id + ", quantity=" + quantity
				+ ", getName()=" + getName() + ", getAuthor()=" + getAuthor() + ", getPublisher()=" + getPublisher()
				+ ", getId()=" + getId() + ", getQuantity()=" + getQuantity() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
