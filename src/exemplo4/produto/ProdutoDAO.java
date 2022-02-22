/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo4.produto;

import exemplo4.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author saimor
 */
public class ProdutoDAO {
     private Session sessao;
     private Transaction transacao;

     public void salvar ( Produto produto ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.save ( produto );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel inserir o produto. Erro: " + e.getMessage () );
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de inserção. Erro: " + e.getMessage () );
               }
          }
     }

     public void atualizar ( Produto produto ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.update ( produto );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel alterar o produto. Erro: " + e.getMessage () );
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de atualização. Erro: " + e.getMessage () );
               }
          }
     }

     public void excluir ( Produto produto ) {
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               this.sessao.delete ( produto );
               this.transacao.commit ();
          } catch ( HibernateException e ) {
               System.out.println ( "Não foi possivel excluir o produto. Erro: " + e.getMessage () );
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de exclusão. Erro: " + e.getMessage () );
               }
          }
     }

     public Produto buscaCategoria ( Integer codigo ) {
          Produto produto = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Produto.class );
               filtro.add ( Restrictions.eq ( "produto" , codigo ) );
               produto = ( Produto ) filtro.uniqueResult ();
               this.transacao.commit ();
          } catch ( Throwable e ) {
               if ( this.transacao.isActive () ) {
                    this.transacao.rollback ();
               }
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de busca. Erro: " + e.getMessage () );
               }
          }
          return produto;
     }

     public List<Produto> listar() {
          List<Produto> produto = null;
          try {
               this.sessao = HibernateUtil.getSessionFactory ().getCurrentSession ();
               this.transacao = this.sessao.beginTransaction ();
               Criteria filtro = this.sessao.createCriteria ( Produto.class );
               produto = filtro.list ();
               this.transacao.commit ();
          } catch ( Throwable e ) {
               if(this.transacao.isActive()){
                    this.transacao.rollback ();
               }
          } finally {
               try {
                    if ( this.sessao.isOpen () ) {
                         this.sessao.close ();
                    }
               } catch ( Throwable e ) {
                    System.out.println ( "Erro ao fechar operação de listagem. Erro: " + e.getMessage () );
               }
          }
          return produto;
     }
     
}
