	function carregaProdutos() {
		$.get( "/produtos", function( data ) {
			var produtos = JSON.parse(data);
			if(produtos.length>0) {
				$("#divTabProdutos").html('');
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
				for(var i=0;i<produtos.length;i++) {
					var produto = produtos[i];
					tab = tab.concat('<tr>');
					tab = tab.concat('	<form id="form_produto_' + produto.codigo + '">');
					tab = tab.concat('		<td><span><label class="codigo" id="codigo_' + produto.codigo + '">' + produto.codigo + '</label></span></td>');
					tab = tab.concat('		<td><span id="descr_' + produto.codigo + '">' + produto.descricao + '</span></td>');
					tab = tab.concat('		<td><span><label class="valor" id="vlr_' + produto.codigo + '">' + produto.valor + '</label></span></td>');					
					tab = tab.concat('		<td>');
					tab = tab.concat('			<label for="qtde_' + produto.codigo + '">Qtde.</label>');
					tab = tab.concat('			<input type="number" min="0" max="99" id="qtde_' + produto.codigo + '" size="5" value="0">');									
					tab = tab.concat('		</td>');
					tab = tab.concat('		<td>');
					tab = tab.concat('			<button type="button" class="btn btn-primary btn-sm" aria-label="Left Align" onClick="addProduto(' + produto.codigo + ');">');
					tab = tab.concat('				<span class="glyphicon glyphicon-plus" aria-hidden="false"></span>&nbsp;Comprar');
					tab = tab.concat('			</button>');
					tab = tab.concat('		</td>');
					tab = tab.concat('	</form>');		            
					tab = tab.concat('</tr>');
				}
				tab = tab.concat('</tbody>')
				tab = tab.concat('</table>');
				$("#divTabProdutos").append(tab);
			}
		  console.log(data);
		});
	}