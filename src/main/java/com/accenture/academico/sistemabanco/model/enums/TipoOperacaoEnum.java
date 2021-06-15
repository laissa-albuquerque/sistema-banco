package com.accenture.academico.sistemabanco.model.enums;

public enum TipoOperacaoEnum {

	TRANSFERENCIA(001, "Transferência"), SAQUE(002, "Saque"), DEPOSITO(003, "Depósito");

	private int codigo;
	private String descricao;

	private TipoOperacaoEnum(int codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public final int getCodigo() {
		return codigo;
	}

	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public final String getDescricao() {
		return descricao;
	}

	public final void setDescricao(String descricao) {
		this.descricao = descricao;
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
