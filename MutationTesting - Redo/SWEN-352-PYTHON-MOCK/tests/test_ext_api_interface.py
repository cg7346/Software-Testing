import unittest

from library import ext_api_interface
from library import library
from library import patron
from unittest.mock import Mock
import requests
import json


class TestExtApiInterface(unittest.TestCase):
    def setUp(self):
        self.api = ext_api_interface.Books_API()
        self.book = "learning python"
        self.author = "Mark Lutz"
        self.lib = library.Library()
        self.pat = patron.Patron('fname', 'lname', '20', '1234')
        with open('tests_data/ebooks.txt', 'r') as f:
            self.books_data = json.loads(f.read())
        with open('tests_data/json_data.txt', 'r') as f:
            self.json_data = json.loads(f.read())
        with open('tests_data/author_books.txt', 'r') as f:
            self.author_books = json.loads(f.read())
        with open('tests_data/author_data.txt', 'r') as f:
            self.author_data = json.loads(f.read())
        with open('tests_data/books_info.txt', 'r') as f:
            self.book_info = json.loads(f.read())

    def test_make_request_True(self):
        attr = {'json.return_value': dict()}
        requests.get = Mock(return_value=Mock(status_code=200, **attr))
        self.assertEqual(self.api.make_request(""), dict())
    
    def test_is_book_available_URL_bad(self):
        try:
            self.api.is_book_available('learning python')
            self.assertTrue(True)
        except:
            self.assertTrue(False)
    
    def test_books_by_author_URL_bad(self):
        try:
            self.api.books_by_author(self.author)
            self.assertTrue(True)
        except:
            self.assertTrue(False)

    def test_get_book_info_URL_bad(self):
        try:
            self.api.get_book_info(self.book)
            self.assertTrue(True)
        except:
            self.assertTrue(False)
    
    def test_get_ebooks_URL_bad(self):
        try:
            self.api.get_ebooks(self.book)
            self.assertTrue(True)
        except:
            self.assertTrue(False)

    def test_make_request_connection_error(self):
        ext_api_interface.requests.get = Mock(side_effect=requests.ConnectionError)
        url = "some url"
        self.assertEqual(self.api.make_request(url), None)

    def test_make_request_False(self):
        requests.get = Mock(return_value=Mock(status_code=100))
        self.assertEqual(self.api.make_request(""), None)

    def test_make_request_None(self):
        requests.get = Mock(return_value=Mock(status_code=100))
        self.assertEqual(self.api.make_request(""), None)

    def test_get_ebooks(self):
        self.api.make_request = Mock(return_value=self.json_data)
        self.assertEqual(self.api.get_ebooks(self.book), self.books_data)

    def test_get_ebooks_none(self):
        self.api.make_request = Mock(return_value=[])
        self.assertEqual(self.api.get_ebooks(self.book), [])

    def test_is_book_available_true(self):
        self.api.make_request = Mock(return_value=self.json_data)
        self.assertTrue(self.api.is_book_available('learning python'))

    def test_is_book_available_false(self):
        self.api.make_request = Mock(return_value=None)
        self.assertFalse(self.api.is_book_available(self.book))

    def test_books_by_author(self):
        self.api.make_request = Mock(return_value=self.author_data)
        self.assertEqual(self.api.books_by_author(self.author), self.author_books)

    def test_books_by_author_none(self):
        self.api.make_request = Mock(return_value=[])
        self.assertEqual(self.api.books_by_author('yes'), [])

    def test_get_book_info(self):
        self.api.make_request = Mock(return_value=self.json_data)
        self.assertEqual(self.api.get_book_info(self.book), self.book_info)

    def test_get_book_info_none(self):
        self.api.make_request = Mock(return_value=[])
        self.assertEqual(self.api.get_book_info(self.book), [])
    
    def test_is_book_available_json_len_1(self):
        self.api.make_request = Mock(return_value={"docs": ["one"]})
        self.assertTrue(self.api.is_book_available("learning python"))
