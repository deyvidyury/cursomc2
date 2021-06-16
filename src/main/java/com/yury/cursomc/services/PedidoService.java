package com.yury.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yury.cursomc.domain.Pedido;
import com.yury.cursomc.repositories.PedidoRepository;
import com.yury.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objecto nao encontrado! ID: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}