
public class Product {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	protected String name;

	public Product(String name, String image, String price, String category) {
		super();
		this.name = name;
		this.image = image;
		this.price = price;
		this.category = category;
	}

	protected String image;
	protected String price;
	protected String category;

}
