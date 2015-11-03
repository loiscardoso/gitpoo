/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Codigos;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Ramon
 */
@Entity
@Table(name = "musica", catalog = "bibliotecamusical", schema = "")
@NamedQueries({
    @NamedQuery(name = "Musica.findAll", query = "SELECT m FROM Musica m"),
    @NamedQuery(name = "Musica.findById", query = "SELECT m FROM Musica m WHERE m.id = :id"),
    @NamedQuery(name = "Musica.findByNome", query = "SELECT m FROM Musica m WHERE m.nome = :nome"),
    @NamedQuery(name = "Musica.findByNota", query = "SELECT m FROM Musica m WHERE m.nota = :nota"),
    @NamedQuery(name = "Musica.findByDuracao", query = "SELECT m FROM Musica m WHERE m.duracao = :duracao"),
    @NamedQuery(name = "Musica.findByAlbumId", query = "SELECT m FROM Musica m WHERE m.albumId = :albumId")})
public class Musica implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Column(name = "nota")
    private Integer nota;
    @Column(name = "duracao")
    private Integer duracao;
    @Basic(optional = false)
    @Column(name = "album_id")
    private int albumId;

    public Musica() {
    }

    public Musica(Integer id) {
        this.id = id;
    }

    public Musica(Integer id, String nome, int albumId) {
        this.id = id;
        this.nome = nome;
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        Integer oldNota = this.nota;
        this.nota = nota;
        changeSupport.firePropertyChange("nota", oldNota, nota);
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        Integer oldDuracao = this.duracao;
        this.duracao = duracao;
        changeSupport.firePropertyChange("duracao", oldDuracao, duracao);
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        int oldAlbumId = this.albumId;
        this.albumId = albumId;
        changeSupport.firePropertyChange("albumId", oldAlbumId, albumId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musica)) {
            return false;
        }
        Musica other = (Musica) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Codigos.Musica[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
