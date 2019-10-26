import unittest
import dt


class  Dt_TestCase(unittest.TestCase):
   
    def test_classify0(self):
        dataset,labels = dt.create_dataset()
        
        ent = dt.calc_shannon_ent(dataset)
        tree = dt.create_tree(dataset,labels)
        print(tree)
        predict = dt.classify0(tree,labels,[1,1])
        print "[1,1] is %s" % predict


    def test_main_lenses(self):
        fr = open('lenses/dataset.txt')
        dataset = [line.strip().split('\t') for line in fr.readlines()]
        labels = ['age','prescript','astigmatic','tearRate']
        tree = dt.create_tree(dataset,labels)
        print tree
        dt.save_tree(tree, 'tree.dat')
        print dt.load_tree('tree.dat')
        
        
if __name__ == '__main__':
    unittest.main()

