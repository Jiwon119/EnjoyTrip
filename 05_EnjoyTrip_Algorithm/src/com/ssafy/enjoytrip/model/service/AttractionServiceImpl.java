package com.ssafy.enjoytrip.model.service;

import java.util.Comparator;
import java.util.List;

import com.ssafy.enjoytrip.model.AttractionInfoDto;
import com.ssafy.enjoytrip.model.dao.AttractionDaoImpl;

public class AttractionServiceImpl implements AttractionService {

	private static AttractionService attractionService = new AttractionServiceImpl();

	public static AttractionService getAttractionServcie() {
		return attractionService;
	}

	@Override
	public List<AttractionInfoDto> attractionList(AttractionInfoDto AttractionInfoDto, String title) {
		List<AttractionInfoDto> attractionList = AttractionDaoImpl.getAttractionDao().attractionList(AttractionInfoDto,
				title);
		return attractionList;
	}

	@Override
	public List<AttractionInfoDto> attractionListSort(AttractionInfoDto AttractionInfoDto, String title, String sort) {
		List<AttractionInfoDto> attractionList = AttractionDaoImpl.getAttractionDao().attractionList(AttractionInfoDto,
				title);
		if ("latitude".equals(sort)) {
			quickSort(attractionList, new Comparator<AttractionInfoDto>() {
				@Override
				public int compare(AttractionInfoDto o1, AttractionInfoDto o2) {
					return Double.compare(o1.getLatitude(), o2.getLatitude());
				}
			});
		} else if ("longitude".equals(sort)) {
			quickSort(attractionList, new Comparator<AttractionInfoDto>() {
				@Override
				public int compare(AttractionInfoDto o1, AttractionInfoDto o2) {
					return Double.compare(o1.getLongitude(), o2.getLongitude());
				}
			});
		} else if ("addr".equals(sort)) {
			quickSort(attractionList, new Comparator<AttractionInfoDto>() {
				@Override
				// 음수결과 : o2원소가 크다. / 0 결과 : 두 원소가 같다. / 양수 결과 : o1 원소가 크다.
				public int compare(AttractionInfoDto o1, AttractionInfoDto o2) {
					int tmp = o1.getAddr1().compareTo(o2.getAddr1());
					if (tmp == 0) {
						tmp = o1.getAddr2().compareTo(o2.getAddr2());
					}
					return tmp;
				}
			});
		} else {
			quickSort(attractionList, new Comparator<AttractionInfoDto>() {
				@Override
				public int compare(AttractionInfoDto o1, AttractionInfoDto o2) {
					return o1.getTitle().compareTo(o2.getTitle());
				}
			});
		}

		return attractionList;
	}

	public static void quickSort(List<AttractionInfoDto> list, Comparator<AttractionInfoDto> comparator) {
		quickSortHelper(list, comparator, 0, list.size() - 1);
	}

	private static void quickSortHelper(List<AttractionInfoDto> list, Comparator<AttractionInfoDto> comparator, int low,
			int high) {
		if (low < high) {
			int pivotIndex = partition(list, comparator, low, high);
			quickSortHelper(list, comparator, low, pivotIndex - 1);
			quickSortHelper(list, comparator, pivotIndex + 1, high);
		}
	}

	private static int partition(List<AttractionInfoDto> list, Comparator<AttractionInfoDto> comparator, int low,
			int high) {
		AttractionInfoDto pivot = list.get(high);
		int i = low - 1;

		for (int j = low; j < high; j++) {
			if (comparator.compare(list.get(j), pivot) < 0) {
				i++;
				swap(list, i, j);
			}
		}

		swap(list, i + 1, high);
		return i + 1;
	}

	private static void swap(List<AttractionInfoDto> list, int i, int j) {
		AttractionInfoDto temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}
