Eu tenho:
 - Autor
 - Post

Um Autor pode ter vários Posts
mas Um Post só pode pertencer a Um Autor.

Então Um Autor tem um atributo Lista de Posts
E Post tem um atributo Autor.

O lado que representa o Muitos da relação vai receber:
	@ManyToOne
	@JoinColumn(name="")
O lado que representa o UM da relação vai receber:
	@OneToMany(mappedBy="")

Então no meu lado muitos, ou seja o Post vai receber
	@ManyToOne
	@JoinColumn(name="autor_id")
	private Autor autor;

E meu lado do UM, ou seja o Autor vai receber
	@OneToMany(mappedBy="autor")
	private List<Post> posts = new ArrayList<>();