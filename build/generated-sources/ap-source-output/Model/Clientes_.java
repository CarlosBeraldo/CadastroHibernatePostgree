package Model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Clientes.class)
public abstract class Clientes_ {

	public static volatile SingularAttribute<Clientes, String> nomeFantasia;
	public static volatile SingularAttribute<Clientes, Integer> id;
	public static volatile SingularAttribute<Clientes, String> razaoSocial;
	public static volatile ListAttribute<Clientes, ContatoCliente> contato;

}

