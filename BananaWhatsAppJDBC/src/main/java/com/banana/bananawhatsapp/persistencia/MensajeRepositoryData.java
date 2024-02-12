package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Profile({"prod", "default"})

public interface MensajeRepositoryData extends JpaRepository<Mensaje, Integer> {

    public default Mensaje crear(Mensaje mensaje) throws SQLException {
        mensaje.valido();
        return save(mensaje);
    }

    public List<Mensaje> findByRemitenteIdOrDestinatarioId(Integer rid, Integer did);

    public default List<Mensaje> obtener(Usuario usuario) throws SQLException {
        usuario.valido();
        return findByRemitenteIdOrDestinatarioId(usuario.getId(), usuario.getId());
    }


    @Modifying
    @Query(value = "DELETE FROM Mensaje m WHERE (m.remitente.id = ?1 AND m.destinatario.id = ?2) OR (m.remitente.id = ?2 AND m.destinatario.id = ?1)")
    public void deleteBtwnRemitenteAndDestinatario(Integer rid, Integer did);

    @Transactional(propagation = Propagation.MANDATORY)
    public default boolean borrarEntre(Usuario remitente, Usuario destinatario) throws Exception {
        remitente.valido();
        destinatario.valido();

        deleteBtwnRemitenteAndDestinatario(remitente.getId(), destinatario.getId());

        return true;
    }

    @Modifying
    @Query(value = "DELETE FROM Mensaje m WHERE m.remitente.id = ?1 OR m.destinatario.id = ?1")
    public void deleteByRemitenteIdOrDestinatarioId(int uid);

    @Transactional(propagation = Propagation.MANDATORY)
    public default boolean borrarTodos(Usuario usuario) throws SQLException {
        usuario.valido();

        deleteByRemitenteIdOrDestinatarioId(usuario.getId());

        return true;
    }


}
