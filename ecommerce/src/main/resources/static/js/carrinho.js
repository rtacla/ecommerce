	function addProduto(codigo) {
		var vCodigo = $("#codigo_" + codigo).html();
		var vQtde = $("#qtde_" + codigo).val();
		var vDescr = $("#descr_" + codigo).html();
		var vVlrUnit = $("#vlr_" + codigo).html();
		var vProduto = { codigo : codigo, descricao : vDescr };
		var ItemCompras = {produto : vProduto, quantidade : parseInt(vQtde), valorUnitario : parseFloat(vVlrUnit)};
		var json = JSON.stringify(ItemCompras);
		$.ajax({url: "carrinho",
				type : "POST",
				contentType : "application/json",
				data : json,
				success: function(data) { 
					carregaCarrinho();
					$("#valorProdutos").html(data);
					$("#idDescri").html("Produto Adicionado");
					$("#dialogAlerta").dialog({ autoOpen : true, heigth : 200, width: 400, modal : true,});
				},
				error: function(data) { 
					$("#idDescri").html("Erro na inclusão de Itens");
					$("#dialogAlerta").dialog({ autoOpen : true, heigth : 200, width: 400, modal : true,});
				}, 
		});		
	}
	
	function updProduto(codigo) {
		var vCodigo = $("#codigo_" + codigo).html();
		var vDescr = $("#descrVlr_" + codigo).html();
		var vQtde = $("#qtdeVlr_" + codigo).val();
		var vProduto = { codigo : codigo, descricao : vDescr };
		var ItemCompras = {produto : vProduto, quantidade : parseInt(vQtde), valorUnitario : 0};
		var json = JSON.stringify(ItemCompras);		
		$.ajax({url: "carrinho",
				type : "PUT",
				contentType : "application/json",
				data : json,
				success: function(data) { 
					carregaCarrinho();
					$("#idDescri").html("Produto Atualizado");
					$("#dialogAlerta").dialog({ autoOpen : true, heigth : 200, width: 400, modal : true,});
				},
				error: function(data) { 
					$("#idDescri").html("Erro na Atualização de Itens");
					$("#dialogAlerta").dialog({ autoOpen : true, heigth : 200, width: 400, modal : true,});
				}, 
		});		
	}
	function removeProduto(codigo) {
		var vCodigo = $("#codigo_" + codigo).html();
		var vDescr = $("#descrVlr_" + codigo).html();
		var vProduto = { codigo : codigo, descricao : vDescr };
		var json = JSON.stringify(vProduto);
		$.ajax({url: "carrinho",
				type : "DELETE",
				contentType : "application/json",
				data : json,
				success: function(data) { 
					carregaCarrinho();
					$("#idDescri").html("Produto Removido");
					$("#dialogAlerta").dialog({ autoOpen : true, heigth : 200, width: 400, modal : true,});
				},
				error: function(data) { 
					$("#idDescri").html("Erro na inclusão de Itens");
					$("#dialogAlerta").dialog({ autoOpen : true, heigth : 200, width: 400, modal : true,});
				}, 
		});		
	}
	
	function carregaCarrinho() {
		$.ajax({url: "carrinho/totais",
			type : "GET",
			contentType : "application/json",
			success: function(data) {
				var totais = JSON.parse(data);
				$("#valorProdutos").html(totais[0]);
				$("#qtdeProdutos").html(totais[1]);
			},
			error: function(data) {
				$("#idDescri").html("Erro na recuperação de Total do Carrinho");
				$("#dialogAlerta").dialog({ autoOpen : true, heigth : 200, width: 400, modal : true,});
			}, 
		});
		
		$.ajax({url: "carrinho",
			type : "GET",
			contentType : "application/json",
			success: function(data) { 
				var itens = JSON.parse(data);
				$("#divTabItensCarrinho").html('');
				if(itens.length>0) {
					var tab = '<table class="table table-hover">';
					tab = tab.concat('<thead>');
					tab = tab.concat('	<tr>');
					tab = tab.concat('		<th>Codigo</th>');
					tab = tab.concat('		<th>Nome</th>');
					tab = tab.concat('		<th>Valor</th>');
					tab = tab.concat('		<th>Qtde</th>');
					tab = tab.concat('		<th>&nbsp;</th>');
					tab = tab.concat('	</tr>');
					tab = tab.concat('</thead>');
					tab = tab.concat('<tbody>')
					for(var i=0;i<itens.length;i++) {
						var item = itens[i];
						tab = tab.concat('<tr>');
						tab = tab.concat('		<td><span><label class="codigoItem" id="codigoItem_' + item.produto.codigo + '">' + item.produto.codigo + '</label></span></td>');
						tab = tab.concat('		<td><span id="descrVlr_' + item.produto.codigo + '">' + item.produto.descricao + '</span></td>');
						tab = tab.concat('		<td><span><label class="valor" id="vlrItem_' + item.produto.codigo + '">' + item.valorUnitario + '</label></span></td>');					
						tab = tab.concat('		<td>');
						tab = tab.concat('			<label for="qtde_' + item.produto.codigo + '">Qtde.</label>');
						tab = tab.concat('			<input type="number" min="0" max="99" name="qtdeVlr_' + item.produto.codigo + '" id="qtdeVlr_' + item.produto.codigo + '" size="5" value="' + item.quantidade + '">');									
						tab = tab.concat('		</td>');
						tab = tab.concat('		<td>');
						tab = tab.concat('			<button type="button" class="btn btn-primary btn-sm" aria-label="Left Align" onClick="updProduto(' + item.produto.codigo + ');">');
						tab = tab.concat('				<span class="glyphicon glyphicon-pencil" aria-hidden="false"></span>&nbsp;Atualizar');
						tab = tab.concat('			</button>');
						tab = tab.concat('			<button type="button" class="btn btn-primary btn-sm" aria-label="Left Align" onClick="removeProduto(' + item.produto.codigo + ');">');
						tab = tab.concat('				<span class="glyphicon glyphicon-minus" aria-hidden="false"></span>&nbsp;Excluir');
						tab = tab.concat('			</button>');
						
						tab = tab.concat('		</td>');
						tab = tab.concat('</tr>');
					}
					tab = tab.concat('</tbody>')
					tab = tab.concat('</table>');
					$("#divTabItensCarrinho").append(tab);
				}

			},
			error: function(data) { 
				$("#idDescri").html("Erro na recuperação do Carrinho");
				$("#dialogAlerta").dialog({ autoOpen : true, heigth : 200, width: 400, modal : true,});
			}, 
		});		
		
			
	}
	