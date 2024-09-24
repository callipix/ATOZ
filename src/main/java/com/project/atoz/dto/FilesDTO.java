package com.project.atoz.dto;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FilesDTO {
	@EqualsAndHashCode.Include
	private int file_no;                 // 파일번호 -> DB에서 auto_increment
	private String original_name;        // 파일의 오리지날명
	private String stored_name;          // UUID로 생성한 파일명
	private String file_type;            // 파일의 타입(여기선 이미지 파일 종류)
	private long file_size;              // 파일사이즈
	@EqualsAndHashCode.Include
	private String file_path;            // 파일 경로
	private Date uploaded_at;            // 업로드 날짜
	private String id;                   // 업로드 id
	private String associated_object_id;
	private int category_no;             // 카테고리번호(pk)
	private int post_no;                 // 게시글번호(pk)

	private ErrorBoardDTO errorBoardDTO;

	public FilesDTO() {
	}

	public FilesDTO(int file_no, String stored_name, String file_path, int category_no, int post_no) {
		this.file_no = file_no;
		this.stored_name = stored_name;
		this.file_path = file_path;
		this.category_no = category_no;
		this.post_no = post_no;
	}

	public FilesDTO(int file_no, int category_no, int post_no, String original_name, String stored_name,
		String file_type, long file_size, String file_path, String id) {
		this.file_no = file_no;
		this.category_no = category_no;
		this.post_no = post_no;
		this.original_name = original_name;
		this.stored_name = stored_name;
		this.file_type = file_type;
		this.file_size = file_size;
		this.file_path = file_path;
		this.id = id;
	}

	public ErrorBoardDTO getErrorBoardDTO() {
		return errorBoardDTO;
	}
}
