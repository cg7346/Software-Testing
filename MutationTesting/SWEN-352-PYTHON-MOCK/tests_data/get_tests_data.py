import sys
sys.path.append('.')

from library import ext_api_interface
import json


class GetData:
    def __init__(self):
        self.api = ext_api_interface.Books_API()

    def get_ebooks(self, book):
        print("get ebooks: " + book)
        ebooks = self.api.get_ebooks(book)
        print(ebooks)
        with open('tests_data/ebooks.txt', 'w') as f:
            f.write(json.dumps(ebooks))

    def get_books_author(self, author):
        print("get book info: " + author)
        author_books = self.api.books_by_author(author)
        print(author_books)
        with open('tests_data/author_books.txt', 'w') as f:
            f.write(json.dumps(author_books))

    def get_books_info(self, book):
        print("get book language: " + book)
        book_info = self.api.get_book_info(book)
        print(book_info)
        with open('tests_data/books_info.txt', 'w') as f:
            f.write(json.dumps(book_info))

    def get_json(self, book):
        request_url = "%s?q=%s" % (self.api.API_URL, book)
        json_data = self.api.make_request(request_url)
        print(json_data)
        with open('tests_data/json_data.txt', 'w') as f:
            f.write(json.dumps(json_data))

    def get_author(self, author):
        request_url = "%s?author=%s" % (self.api.API_URL, author)
        author_data = self.api.make_request(request_url)
        print(author_data)
        with open('tests_data/author_data.txt', 'w') as f:
            f.write(json.dumps(author_data))


if __name__ == "__main__":
    getdata = GetData()
    getdata.get_ebooks('learning python')
    getdata.get_books_author('Mark Lutz')
    getdata.get_books_info('learning python')
    getdata.get_json('learning python')
    getdata.get_author('Mark Lutz')
