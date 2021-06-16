package com.accenture.academico.sistemabanco.model.enums;

public enum TipoOperacaoEnum {

	TRANSFERENCIA(1, "Transferência"), SAQUE(2, "Saque"), DEPOSITO(3, "Depósito");

	private int codigo;
	private String descricao;

	private TipoOperacaoEnum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public final int getCodigo() {
		return codigo;
	}

	public final String getDescricao() {
		return descricao;
	}

	public static TipoOperacaoEnum toEnum(Integer codigo) {
		if (codigo.equals(null)) {
			return null;
		}

		for (TipoOperacaoEnum x : TipoOperacaoEnum.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}

		throw new IllegalArgumentException("Código inválido: " + codigo);
	}

}
