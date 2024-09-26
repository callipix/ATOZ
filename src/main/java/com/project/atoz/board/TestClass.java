package com.project.atoz.board;

public class TestClass {
	/**
	 * 심심할때 공부하는 정렬메서드 짜보기
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = {64, 25, 12, 22, 11};
		System.out.print("버블정렬 : ");
		for (int i : bubbleSort(arr)) {
			System.out.print(" " + i);
		}
		System.out.print("\n선택정렬 : ");
		for (int i : selectionSort(arr)) {
			System.out.print(" " + i);
		}
	}

	public static int[] bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

	public static int[] selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}
