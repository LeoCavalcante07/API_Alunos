const app = require('express')();
const http = require('http').createServer(app);
const config = require('./config')
const bodyParser = require("body-parser");

app.use(bodyParser.urlencoded({
    extended: true
}));

app.use(bodyParser.json());


let alunos = [{    
    "id": 1,
    "nome": "Francisco",
    "data_nascimento": 20000125,
    "matricula" : 208583001,
    "cpf" : "711.301.300-70",
    "notas": [10.0, 8.2, 7.5]        
}, {    
    "id": 2,
    "nome": "Joao",
    "data_nascimento": 20000101,
    "matricula" : 208583002,
    "cpf" : "711.301.300-70",
    "notas": [0, 2, 10]        
}
             

]

ultimaMatricula = 208583002
ultimoId = 2

app.get("/", (req, res)=> {
   const mensagemHelp = `
        <pre>
        *********************************
        *    Bem vindo a API de alunos  *
        *********************************
        </pre>
    ` 
   
   res.send(mensagemHelp)
});


//VER ALUNO ESPECIFICO
app.get("/aluno/:id", (req, res)=>{
    const aluno = alunos.filter(alunos => alunos.id == req.params.id)
    res.send(alunos[0])
});

//VER ALUNOS
app.get("/alunos", (req, res)=>{
    res.send(alunos)
})


//ADC ALUNO
app.post("/aluno/novo", (req, res)=>{
    ultimoId++
    ultimaMatricula++
    
    
    const id = ultimoId
    const nome = req.body.nome
    const data_nascimento  = req.body.data_nascimento
    const matricula = ultimaMatricula
    const cpf = req.body.cpf
    const notas = req.body.notas
    
    
    
    const novoAluno = {id, nome, data_nascimento, matricula, cpf, notas}    
    
    alunos.push(novoAluno)
    
    res.send({"sucesso" : true, "msg" : "Cadastrado com sucesso!"})
    
});


//delete aluno
app.get("/aluno/delete/:id", (req, res) =>{
    alunos = alunos.filter(a => a.id != req.params.id)
    
    res.send({"sucesso":true, "msg": "Deletado com sucesso"})
});



//configurando a porta do servidor
http.listen( config.port, function(){
    console.log(`Servidor rodando na porta ${config.port}`);
    
});