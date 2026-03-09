ALTER TABLE topicos DROP COLUMN autor;
ALTER TABLE topicos DROP COLUMN curso;

ALTER TABLE topicos ADD COLUMN autor_id BIGINT NOT NULL;
ALTER TABLE topicos ADD COLUMN curso_id BIGINT NOT NULL;

ALTER TABLE topicos ADD CONSTRAINT fk_topicos_autor_id FOREIGN KEY (autor_id) REFERENCES usuarios(id);
ALTER TABLE topicos ADD CONSTRAINT fk_topicos_curso_id FOREIGN KEY (curso_id) REFERENCES cursos(id);
