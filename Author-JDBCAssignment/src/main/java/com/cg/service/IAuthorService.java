package com.cg.service;

import com.cg.bean.Author;

public interface IAuthorService {
        public String createAuthor(Author a);
        public Author findAuthor(Integer id);
        public String updateAuthor(Author a);
        public String deleteAuthor(Integer id);
}
