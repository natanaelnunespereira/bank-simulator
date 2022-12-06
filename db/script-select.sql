select id, nome, endereco, tipo, cpf from pessoa as p inner join pessoa_fisica
as pf on p.id=pf.id_pessoa;

select id, nome, endereco, tipo, cnpj from pessoa as p inner join pessoa_juridica as pj on p.id=pj.id_pessoa;

select p.id, p.nome, p.endereco, tipo, pf.cpf, c.id, c.numero, c.saldo, c.status, c.senha from pessoa as p inner join pessoa_fisica as pf on p.id=pf.id_pessoa inner join conta as c on p.id=c.id_pessoa;

select p.id, p.nome, p.endereco, tipo, pj.cnpj, c.id, c.numero, c.saldo, c.status, c.senha from pessoa as p inner join pessoa_juridica as pj on p.id=pj.id_pessoa inner join conta as c on p.id=c.id_pessoa;
