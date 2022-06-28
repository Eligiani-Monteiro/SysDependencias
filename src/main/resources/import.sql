

INSERT INTO TB_Curso (nome_curso, turno) VALUES ('TADS', 'Noturno');
INSERT INTO TB_Curso (nome_curso, turno) VALUES ('Sistema de Informação', 'Noturno');
INSERT INTO TB_Curso (nome_curso, turno) VALUES ('Engenharia da Computação', 'Noturno');

INSERT INTO TB_ALUNO (nome_aluno, idade, ra_aluno, matricula, id_curso_fk) VALUES ('Eligiani', '36', '32298', '367612', 1);
INSERT INTO TB_ALUNO (nome_aluno, idade, ra_aluno, matricula, id_curso_fk) VALUES ('Pedro', '20', '54764', '5747443', 2);
INSERT INTO TB_ALUNO (nome_aluno, idade, ra_aluno, matricula, id_curso_fk) VALUES ('Julha', '18', '765856', '5765865', 3);

INSERT INTO TB_PROFESSOR (nome_professor, titulo) VALUES ('Marcos Rogério', 'Mestre');
INSERT INTO TB_PROFESSOR (nome_professor, titulo) VALUES ('Priscila', 'DRA');
INSERT INTO TB_PROFESSOR (nome_professor, titulo) VALUES ('Paula Bazotti', 'Especialista');

INSERT INTO TB_DISCIPLINA (nome_disciplina, carga_horaria, situacao, id_professor_fk) VALUES ('Framework', '80', 1, 1);
INSERT INTO TB_DISCIPLINA (nome_disciplina, carga_horaria, situacao, id_professor_fk) VALUES ('Desenvolvimento Web', '80', 1, 2);
INSERT INTO TB_DISCIPLINA (nome_disciplina, carga_horaria, situacao, id_professor_fk) VALUES ('Administração', '60', 1, 3);


INSERT INTO TB_CURSO_PROFESSOR (id_curso, id_professor) VALUES (1, 1);
INSERT INTO TB_CURSO_PROFESSOR (id_curso, id_professor) VALUES (2, 2);
INSERT INTO TB_CURSO_PROFESSOR (id_curso, id_professor) VALUES (3, 3);

INSERT INTO TB_CURSO_DISCIPLINA (id_curso ,id_disciplina) VALUES (1, 1);
INSERT INTO TB_CURSO_DISCIPLINA (id_curso ,id_disciplina) VALUES (2, 2);
INSERT INTO TB_CURSO_DISCIPLINA (id_curso ,id_disciplina) VALUES (3, 3);

INSERT INTO TB_DISCIPLINA_ALUNO (id_disciplina, id_aluno) VALUES (1, 1);
INSERT INTO TB_DISCIPLINA_ALUNO (id_disciplina, id_aluno) VALUES (2, 2);
INSERT INTO TB_DISCIPLINA_ALUNO (id_disciplina, id_aluno) VALUES (3, 3);













