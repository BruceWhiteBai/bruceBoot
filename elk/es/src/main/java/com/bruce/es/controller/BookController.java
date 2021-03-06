package com.bruce.es.controller;

import com.bruce.es.dao.BookDao;
import com.bruce.es.entity.Book;
import org.elasticsearch.action.update.UpdateRequestBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    /**
     * 1、查  id
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookDao.findById(id).get();
    }

    /**
     * 2、查  ++:全文检索（根据整个实体的所有属性，可能结果为0个）
     *
     * @param q
     * @return
     */
    @GetMapping("/select/{q}")
    public List<Book> testSearch(@PathVariable String q) {
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(q);
        Iterable<Book> searchResult = bookDao.search(builder);
        Iterator<Book> iterator = searchResult.iterator();
        List<Book> list = new ArrayList<Book>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

    /**
     * 3、查   +++：分页、分数、分域（结果一个也不少）
     *
     * @param page
     * @param size
     * @param q
     * @return
     */
    @GetMapping("/{page}/{size}/{q}")
    public List<Book> searchCity(@PathVariable Integer page, @PathVariable Integer size, @PathVariable String q) {

        // 分页参数
        Pageable pageable = new PageRequest(page, size, Sort.Direction.DESC, "");

        // 分数，并自动按分排序
        /*FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery()
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", q)),
                        ScoreFunctionBuilders.weightFactorFunction(1000))
                .add(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("message", q)),
                        ScoreFunctionBuilders.weightFactorFunction(100));*/

        FunctionScoreQueryBuilder.FilterFunctionBuilder[] builders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[10];

        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(
                QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", q))
        );


        // 分数、分页
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withPageable(pageable)
                .withQuery(functionScoreQueryBuilder).build();

        Page<Book> searchPageResults = bookDao.search(searchQuery);
        return searchPageResults.getContent();

    }

    @GetMapping("/page/{page}/{size}")
    public List<Book> searchBook(@PathVariable Integer page, @PathVariable Integer size) {

        // 分页参数
        //Pageable pageable = new PageRequest(page, size);
        Sort sort = new Sort(Sort.Direction.DESC, "name");
        PageRequest pageRequest = PageRequest.of(page, size, sort);

        Page<Book> searchPageResults = bookDao.findAll(pageRequest);
        return searchPageResults.getContent();

    }

    /**
     * 4、增
     *
     * @return
     */
    @PostMapping("/insert")
    public Book insertBook() {
        Book book = new Book();
        book.setId(System.currentTimeMillis() + "");
        book.setName("book" + System.currentTimeMillis());
        book.setMessage("message" + System.currentTimeMillis());
        book.setType("type" + System.currentTimeMillis());
        bookDao.save(book);
        return book;
    }

    /**
     * 5、删 id
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public Book insertBook(@PathVariable String id) {
        Book book = bookDao.findById(id).get();
        bookDao.deleteById(id);
        return book;
    }

    /**
     * 6、改
     *
     * @param book
     * @return
     */
    @PostMapping("/update")
    public Book updateBook(Book book) {
        bookDao.save(book);
        /**
         * 局部更新
         */
        Book bookObj = bookDao.findById("id").get();
        bookObj.setMessage("123123");
        bookDao.save(bookObj);

        return book;
    }

}
