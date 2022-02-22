/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo4.categoria;

import exemplo4.produto.Produto;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author saimor
 */
@Entity
@Table ( name = "categoria" )
public class Categoria {

     @Id
     @GeneratedValue ( strategy = GenerationType.IDENTITY )
     @Column ( name = "cod_categoria" )
     protected Integer categoria;

     @Column ( name = "descricao" )
     protected String descricao;

     @ManyToMany
     @JoinTable ( name = "categoria_produto" ,
                 joinColumns = { 
                      @JoinColumn ( name = "cod_categoria" ) } , inverseJoinColumns = { 
                      @JoinColumn ( name = "cod_produto" ) } )
     private Set<Produto> produtos = new HashSet<Produto> ();

     public Integer getCategoria () {
          return categoria;
     }

     public void setCategoria ( Integer categoria ) {
          this.categoria = categoria;
     }

     public String getDescricao () {
          return descricao;
     }

     public void setDescricao ( String descricao ) {
          this.descricao = descricao;
     }

     public Set<Produto> getProdutos () {
          return produtos;
     }

     public void setProdutos ( Set<Produto> produtos ) {
          this.produtos = produtos;
     }


}
