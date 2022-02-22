/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo4.produto;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author saimor
 */
@Entity
@Table ( name = "produto" )
public class Produto implements Serializable {

     @Id
     @GeneratedValue ( strategy = GenerationType.IDENTITY )
     @Column ( name = "cod_produto" )
     private Integer produto;

     @Column ( name = "descricao" )
     private String descricao;

     @Column ( name = "preco" )
     private Double preco;

     public Integer getProduto () {
          return produto;
     }

     public void setProduto ( Integer produto ) {
          this.produto = produto;
     }

     public String getDescricao () {
          return descricao;
     }

     public void setDescricao ( String descricao ) {
          this.descricao = descricao;
     }

     public Double getPreco () {
          return preco;
     }

     public void setPreco ( Double preco ) {
          this.preco = preco;
     }

}
