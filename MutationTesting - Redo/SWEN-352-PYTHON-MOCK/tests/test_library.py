import unittest
from unittest.mock import Mock

from library import library
from library import patron
import json


class TestLibrary(unittest.TestCase):

    def setUp(self):
        self.lib = library.Library()
        self.book = 'learning python'
        self.pat_1 = patron.Patron('fname', 'lname', '20', '1234')
        self.lib.db.insert_patron(self.pat_1)
        self.pat_2 = patron.Patron('test', 'testing', '20', '1')

        with open('tests_data/ebooks.txt', 'r') as f:
            self.books_data = json.loads(f.read())
        with open('tests_data/author_books.txt', 'r') as f:
            self.author_books = json.loads(f.read())
        with open('tests_data/books_info.txt', 'r') as f:
            self.books_info = json.loads(f.read())

    ############################################################################
    ################################ API METHODS ###############################
    ############################################################################

    def test_is_ebook_true(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertTrue(self.lib.is_ebook(self.book))

    def test_is_ebook_false(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertFalse(self.lib.is_ebook('unknown'))

    def test_get_ebooks_count(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertEqual(self.lib.get_ebooks_count(self.book), 9)

    def test_is_book_by_author_true(self):
        self.lib.api.books_by_author = Mock(return_value=self.author_books)
        self.assertTrue(self.lib.is_book_by_author("Mark Lutz", self.book))

    def test_is_book_by_author_false(self):
        self.lib.api.books_by_author = Mock(return_value=self.author_books)
        self.assertFalse(self.lib.is_book_by_author("Mark Lutz", "machine learning"))

    def test_get_languages_for_book(self):
        self.lib.api.get_book_info = Mock(return_value=self.books_info)
        self.assertEqual(len(self.lib.get_languages_for_book(self.book)), 3)

    ############################################################################
    ################################# DB METHODS ###############################
    ############################################################################

    def test_register_patron(self):
        self.lib.db.insert_patron = Mock(return_value='2')
        self.assertEqual(self.lib.register_patron('john', 'doe', '20', '2'), '2')

    def test_is_patron_registered_true(self):
        self.assertTrue(self.lib.is_patron_registered(self.pat_1))

    def test_is_patron_registered_false(self):
        self.assertFalse(self.lib.is_patron_registered(self.pat_2))

    def test_borrow_book(self):
        self.lib.borrow_book(self.book, self.pat_1)
        self.assertEqual(self.pat_1.borrowed_books, [self.book])

    def test_return_borrowed_book(self):
        self.lib.borrow_book(self.book, self.pat_1)
        self.lib.return_borrowed_book(self.book, self.pat_1)
        self.assertEqual(self.pat_1.borrowed_books, [])

    def test_is_book_borrowed(self):
        self.lib.borrow_book(self.book, self.pat_1)
        self.assertTrue(self.lib.is_book_borrowed(self.book, self.pat_1))
    
    def test_register_patron_is_not_none(self):
        self.lib.db.insert_patron = Mock(return_value='2')
        self.assertTrue(self.lib.register_patron('john', 'doe', '20', '2') != None)
