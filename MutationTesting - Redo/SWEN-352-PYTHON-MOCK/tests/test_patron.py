import unittest
from library import patron


class TestPatron(unittest.TestCase):

    def setUp(self):
        self.pat = patron.Patron('fname', 'lname', '20', '1234')

    def test_valid_name(self):
        pat = patron.Patron('fname', 'lname', '20', '1234')
        self.assertTrue(isinstance(pat, patron.Patron))

    def test_invalid_name(self):
        self.assertRaises(patron.InvalidNameException, patron.Patron, '1fname', '1lname', '20', '1234')
        
    def test_add_borrowed_book_not_present(self):
        self.pat.add_borrowed_book("where the wild things are")
        self.assertEqual(self.pat.borrowed_books[0], "where the wild things are")

    def test_add_borrowed_book_present(self):
        self.pat.add_borrowed_book("where the wild things are")
        self.pat.add_borrowed_book("where the wild things are")
        self.assertEqual(self.pat.borrowed_books, ["where the wild things are"])

    def test_get_borrowed_books(self):
        self.pat.add_borrowed_book("where the wild things are")
        self.assertEqual(self.pat.get_borrowed_books(), ["where the wild things are"])

    def test_return_borrowed_book_present(self):
        self.pat.add_borrowed_book("where the wild things are")
        self.pat.return_borrowed_book("where the wild things are")
        self.assertEqual(self.pat.borrowed_books, [])

    def test_return_borrowed_book_not_present(self):
        self.pat.return_borrowed_book("where the wild things are")
        self.assertEqual(self.pat.borrowed_books, [])

    def test_equals_true(self):
        pat2 = patron.Patron('fname', 'lname', '20', '1234')
        self.assertTrue(self.pat == pat2)

    def test_equals_false(self):
        pat2 = patron.Patron('notfname', 'notlname', '99', '5678')
        self.assertFalse(self.pat == pat2)

    def test_not_equals_true(self):
        pat2 = patron.Patron('notfname', 'notlname', '99', '5678')
        self.assertTrue(self.pat != pat2)

    def test_not_equals_false(self):
        pat2 = patron.Patron('fname', 'lname', '20', '1234')
        self.assertFalse(self.pat != pat2)

    def test_get_fname(self):
        self.assertEqual(self.pat.get_fname(), 'fname')

    def test_get_lname(self):
        self.assertEqual(self.pat.get_lname(), 'lname')

    def test_get_age(self):
        self.assertEqual(self.pat.get_age(), '20')

    def test_get_memberID(self):
        self.assertEqual(self.pat.get_memberID(), '1234')
