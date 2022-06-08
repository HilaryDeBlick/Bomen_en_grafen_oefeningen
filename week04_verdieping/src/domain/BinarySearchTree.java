//package domain;
//
//import java.util.List;
//
//public class BinarySearchTree<E extends Comparable<E>> {
//	private BinaryTree<E> root;
//
//	public List<E> geefKnopenBinnenInterval(E min, E max) {
//		if (this.isEmpty())
//			throw new IllegalStateException("Empty tree");
//		return this.root.geefKnopenBinnenInterval(min, max);
//	}
//	private class BinaryTree<E extends Comparable<E>> {
//		private E data;
//		private BinaryTree<E> leftTree, rightTree;
//
//		public List<E> geefKnopenBinnenInterval(E min, E max) {
//			if (min == null || max == null)
//				throw new IllegalArgumentException("Geen effectief interval");
//			List<E> result = new ArrayList<>();
//			if (min.compareTo(max) > 0)
//				return result;
//		// zoek eerst waarden in linkerboom
//		// je hoeft niet over volledig interval te zoeken
//			// want alle knopen in linkerboom zijn kleiner dan wortel
//			if (this.leftTree != null)
//				result.addAll(this.leftTree.geefKnopenBinnenInterval(min, getMinimum(this.data, max)));
//		// controleer of data in gevraagde interval zit
//			if (this.data.compareTo(min) >= 0 && this.data.compareTo(max) <= 0)
//				result.add(this.data);
//		// behandel rechterboom
//			if (this.rightTree != null)
//				result.addAll(this.rightTree.geefKnopenBinnenInterval(getMaximum(min, this.data), max));
//			return result;
//		}
//		private E getMinimum(E object1, E object2) {
//			if (object1.compareTo(object2) <= 0)
//				return object1;
//			else
//				return object2;
//		}
//		private E getMaximum(E object1, E object2) {
//			if (object1.compareTo(object2) >= 0)
//				return object1;
//			else
//				return object2;
//		}
//	}
//}
//