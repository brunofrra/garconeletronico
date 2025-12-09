package com.ufg.garcomeletronico.converters;

import com.ufg.garcomeletronico.dto.*;
import com.ufg.garcomeletronico.entities.*;

import java.util.List;

public class EntityDTOConverter {

    public static ContaDTO toDTO(Conta c) {
        if (c == null) return null;

        return new ContaDTO(
                c.getId(),
                c.getNome(),
                toMesaDTO(c.getMesa()),
                toPedidosDTO(c.getPedidos()),
                toPagamentoDTO(c.getPagamento())
        );
    }

    public static Conta toEntity(ContaDTO dto) {
        if (dto == null) return null;

        Conta c = new Conta();
        c.setId(dto.getId());
        c.setNome(dto.getNome());
        return c;
    }

    public static Garcom toEntity(GarcomDTO dto) {
        if (dto == null) return null;

        Garcom g = new Garcom();
        g.setId(dto.getId());
        g.setNome(dto.getNome());
        return g;
    }

    public static MesaDTO toMesaDTO(Mesa m) {
        if (m == null) return null;

        return new MesaDTO(
                m.getId(),
                m.getNumero(),
                m.isDisponivel(),
                null
        );
    }

    public static PedidoDTO toPedidoDTO(Pedido p) {
        if (p == null) return null;

        return new PedidoDTO(
                p.getId(),
                p.getNumero(),
                p.getHoraPedido(),
                p.getHoraEntrega(),
                toClienteDTO(p.getCliente()),
                toItensPedidoDTO(p.getItens()),
                null
        );
    }

    public static List<PedidoDTO> toPedidosDTO(List<Pedido> lista) {
        if (lista == null) return null;
        return lista.stream().map(EntityDTOConverter::toPedidoDTO).toList();
    }

    public static ClienteDTO toClienteDTO(Cliente c) {
        if (c == null) return null;

        return new ClienteDTO(
                c.getId(),
                c.getNome(),
                c.getHoraChegada(),
                c.getHoraSaida()
        );
    }

    public static ItemPedidoDTO toItemPedidoDTO(ItemPedido entity) {
        if (entity == null) return null;

        return new ItemPedidoDTO(
                entity.getId(),
                entity.getQuantidade(),
                toItemCardapioDTO(entity.getItemCardapio())
        );
    }

    public static List<ItemPedidoDTO> toItensPedidoDTO(List<ItemPedido> lista) {
        if (lista == null) return null;
        return lista.stream().map(EntityDTOConverter::toItemPedidoDTO).toList();
    }

    public static ItemPedido toEntity(ItemPedidoDTO dto) {
        if (dto == null) return null;

        ItemPedido entity = new ItemPedido();
        entity.setId(dto.getId());
        entity.setQuantidade(dto.getQuantidade());
        entity.setItemCardapio(toItemCardapio(dto.getItemCardapio()));
        return entity;
    }

    public static ItemCardapioDTO toItemCardapioDTO(ItemCardapio entity) {
        if (entity == null) return null;

        return new ItemCardapioDTO(
                entity.getId(),
                entity.getNome(),
                entity.getIngredientes(),
                entity.getPreco(),
                entity.isDisponivelCozinha(),
                toCategoriaDTO(entity.getCategoria())
        );
    }

    public static ItemCardapio toItemCardapio(ItemCardapioDTO dto) {
        if (dto == null) return null;

        ItemCardapio entity = new ItemCardapio();
        entity.setId(dto.getId());
        entity.setNome(dto.getNome());
        entity.setIngredientes(dto.getIngredientes());
        entity.setPreco(dto.getPreco());
        entity.setDisponivelCozinha(dto.isDisponivelCozinha());
        entity.setCategoria(toCategoria(dto.getCategoria()));
        return entity;
    }

    public static CategoriaDTO toCategoriaDTO(Categoria entity) {
        if (entity == null) return null;

        return new CategoriaDTO(
                entity.getId(),
                entity.getNome()
        );
    }

    public static Categoria toCategoria(CategoriaDTO dto) {
        if (dto == null) return null;

        Categoria c = new Categoria();
        c.setId(dto.getId());
        c.setNome(dto.getNome());
        return c;
    }

    public static PagamentoDTO toPagamentoDTO(Pagamento p) {
        if (p == null) return null;

        return new PagamentoDTO(
                p.getId(),
                p.getTipo(),
                p.getNumeroTransacao(),
                p.getNumeroCheque()
        );
    }

    public static Pagamento toEntity(PagamentoDTO dto) {
        if (dto == null) return null;

        Pagamento p = new Pagamento();
        p.setId(dto.getId());
        p.setTipo(dto.getTipo());
        p.setNumeroTransacao(dto.getNumeroTransacao());
        p.setNumeroCheque(dto.getNumeroCheque());
        return p;
    }
}
