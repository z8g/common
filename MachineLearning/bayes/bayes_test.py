import bayes
import numpy
import random
import re
import unittest
import feedparser

class  Bayes_TestCase(unittest.TestCase):

    def test_create_dataset(self):
        print "\ntest_create_dataset"
        dataset, labels = bayes.create_dataset()
        print dataset
        print labels

    def test_create_vocab_list(self):
        print "\ntest_create_vocab_list"
        dataset, labels = bayes.create_dataset()
        vocab_list = bayes.create_vocab_list(dataset)
        print vocab_list

    def test_get_vector(self):
        print "\ntest_get_vector"
        dataset, labels = bayes.create_dataset()
        vocab_list = bayes.create_vocab_list(dataset)
        print bayes.get_vector(vocab_list, dataset[0])
        print bayes.get_vector(vocab_list, dataset[1])

    def test_train0(self):
        print "\ntest_train0"
        dataset, labels = bayes.create_dataset()
        vocab_list = bayes.create_vocab_list(dataset)
        train_matrix = []
        for doc in dataset:
            train_matrix.append(bayes.get_vector(vocab_list, doc))
        print train_matrix
        p0_vector, p1_vector, p  = bayes.train0(train_matrix, labels)
        print p0_vector
        print p1_vector
        print p


    def test_classify0(self):
        print "\ntest_classify0"
        dataset, labels = bayes.create_dataset()
        vocab_list = bayes.create_vocab_list(dataset)
        train_matrix = []
        for doc in dataset:
            train_matrix.append(bayes.get_vector(vocab_list, doc))
        p0_vector, p1_vector, p = bayes.train0(train_matrix, labels)

        test_list = ['love', 'my', 'dalmation']
        docs = numpy.array(bayes.get_vector(vocab_list, test_list))
        result = bayes.classify0(docs, p0_vector, p1_vector, p)
        print test_list, " classified as: ", result

        test_list = ['stupid', 'garbage', 'my']
        docs = numpy.array(bayes.get_vector(vocab_list, test_list))
        result = bayes.classify0(docs, p0_vector, p1_vector, p)
        print test_list, " classified as: ", result


    def test_split_email(self):
        print "\ntest_email"
        email_text = "this book is the best book on Python "\
        "or M.L I have ever laid eyes upon."
        print email_text.split()

        regex = re.compile('\\W*')
        strs = regex.split(email_text)
        print strs

        strs = regex.split(email_text)
        print strs

        strs = [s for s in strs if len(s) > 0]
        print strs

        strs = [s.lower() for s in strs if len(s) > 0]
        print strs

        strs = bayes.split_email('email/ham/6.txt')
        print strs

    def test_main_spam(self):
        print "\ntest_main_spam"
        doc_list = []
        labels = []
        full_text = []
        for i in range(1, 26):
            word_list = bayes.split_email('email/spam/%d.txt' % i)
            doc_list.append(word_list)
            full_text.extend(word_list)
            labels.append(1)

            word_list = bayes.split_email('email/ham/%d.txt' % i)
            doc_list.append(word_list)
            full_text.extend(word_list)
            labels.append(0)
        vocab_list = bayes.create_vocab_list(doc_list)
        print vocab_list

        train_set = range(50)
        test_set = []
        for i in range(10):
            rand_index = int(random.uniform(0, len(train_set)))
            test_set.append(train_set[rand_index])
            del(train_set[rand_index])

        train_matrix = []
        train_labels = []
        for i in train_set:
            train_matrix.append(bayes.get_vector(vocab_list, doc_list[i]))
            train_labels.append(labels[i])

        p0_vector, p1_vector, p = bayes.train0(train_matrix, train_labels)

        err_count = 0
        for i in test_set:
            word_vector = bayes.get_vector(vocab_list, doc_list[i])

            predict = bayes.classify0(word_vector, p0_vector, p1_vector, p)
            print "predict: %s real: %s" % (predict, labels[i])
            if  predict != labels[i]:
                err_count += 1
        print 'error rate: %s' % (float(err_count) / len(test_set))
    
    def test_rss(self):
        ny = feedparser.parse('https://zhaoxuyang.net/rss.xml')
        print ny
        

if __name__ == '__main__':
    unittest.main()

