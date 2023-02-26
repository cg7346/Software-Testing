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

    def test_make_request_True(self):
        attr = {'json.return_value': dict()}
        requests.get = Mock(return_value = Mock(status_code = 200, **attr))
        self.assertEqual(self.api.make_request(""), dict())

    def test_make_request_connection_error(self):
        ext_api_interface.requests.get = Mock(side_effect=requests.ConnectionError)
        url = "some url"
        self.assertEqual(self.api.make_request(url), None)

    def test_make_request_False(self):
        requests.get = Mock(return_value=Mock(status_code=100))
        self.assertEqual(self.api.make_request(""), None)

    def test_get_ebooks(self):
        self.api.make_request = Mock(return_value=self.json_data)
        self.assertEqual(self.api.get_ebooks(self.book), self.books_data)

    def test_is_book_available_true(self):
        self.api.make_request = Mock(return_value=self.json_data)
        self.assertTrue(self.api.is_book_available('learning python'))

    # def test_is_book_available_false(self):
    #     # self.lib.is_book_borrowed = Mock(return_value=True)
    #     self.api.make_request = Mock(return_value=self.json_data)
    #     self.lib.borrow_book(self.book, self.pat)
    #     self.assertFalse(self.api.is_book_available(self.book))

    def test_books_by_author(self):
        self.api.make_request = Mock(return_value=self.json_data)
        self.assertEqual(len(self.api.books_by_author(self.author)), len(self.json_data["docs"]))

    def test_books_by_author_none(self):
        self.api.make_request = Mock(return_value=[])
        self.assertEqual(len(self.api.books_by_author('yes')), 0)
