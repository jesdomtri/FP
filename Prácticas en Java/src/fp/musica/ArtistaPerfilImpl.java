package fp.musica;

import java.util.List;

public class ArtistaPerfilImpl extends ArtistaImpl implements ArtistaPerfil {

	private String nickname;
	private RedSocial redSocial;

	public ArtistaPerfilImpl(String id, String nombre, List<String> genero, Integer popularidad, List<String> urlImagen,
			String nickname, RedSocial redSocial) {
		super(id, nombre, genero, popularidad, urlImagen);
		this.nickname = nickname;
		this.redSocial = redSocial;
	}

	public String getNickname() {
		return nickname;
	}

	public RedSocial getRedSocial() {
		return redSocial;
	}

	public String toString() {
		return super.toString() + " - perfil en " + getRedSocial() + ": " + getNickname();
	}

}
