import unittest
from unittest.mock import Mock
from library import library
import json


class TestLibrary(unittest.TestCase):

    def setUp(self):
        self.lib = library.Library()
        with open('tests_data/ebooks.txt', 'r') as f:
            self.books_data = json.loads(f.read())
        with open('tests_data/author_books.txt', 'r') as f:
            self.author_books = json.loads(f.read())
        with open('tests_data/books_info.txt', 'r') as f:
            self.books_info = json.loads(f.read())

    def test_is_ebook_true(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertTrue(self.lib.is_ebook('learning python'))

    def test_is_ebook_false(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertFalse(self.lib.is_ebook('unknown'))

    def test_get_ebooks_count(self):
        self.lib.api.get_ebooks = Mock(return_value=self.books_data)
        self.assertEqual(self.lib.get_ebooks_count("learning python"), 9)

    def test_is_book_by_author_true(self):
        self.lib.api.books_by_author = Mock(return_value=self.author_books)
        self.assertTrue(self.lib.is_book_by_author("Mark Lutz", "Learning Python"))

    def test_is_book_by_author_false(self):
        self.lib.api.books_by_author = Mock(return_value=self.author_books)
        self.assertFalse(self.lib.is_book_by_author("Mark Lutz", "machine learning"))

    def test_get_languages_for_book(self):
        self.lib.api.get_book_info = Mock(return_value=self.books_info)
        self.assertEqual(len(self.lib.get_languages_for_book('learning python')), 3)
