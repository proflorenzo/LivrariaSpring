const url = "http://localhost:8080/livraria";
function salvar(){
    const livro = {
        titulo: document.getElementById("titulo").value,
        autor: document.getElementById("autor").value,
        preco: parseFloat(document.getElementById("preco").value),
        estoque: parseInt(document.getElementById("estoque").value),
        isbn: document.getElementById("isbn").value
    };

    fetch (url, {method: "POST", headers:{"Content-Type":"application/json"}, body: JSON.stringify(livro)}).then(() => listar());
}

function listar(){
    fetch(url)
    .then(res => res.json())
    .then(dados => {
        const lista = document.getElementById("lista");
        lista.innerHTML = "";

    dados.forEach(livro => {
    const li = document.createElement("li");
    li.innerText = `${livro.titulo} - ${livro.autor} - ${livro.preco}`;
    lista.appendChild(li);
    });
    });
}

listar();