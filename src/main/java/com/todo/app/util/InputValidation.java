package com.todo.app.util;

import org.apache.commons.lang3.StringUtils;

import com.todo.app.constant.MessageConstant;
import com.todo.app.dto.TodoDTO;
import com.todo.app.exception.CustomException;

public class InputValidation {

	private InputValidation() {

	}

	/**
	 * Validate on creation.
	 *
	 * @param todoDTO the todo DTO
	 * @throws CustomException the custom exception
	 */
	public static void validateOnCreation(TodoDTO todoDTO) throws CustomException {
		if (StringUtils.isBlank(todoDTO.getName())) {
			throw new CustomException(MessageConstant.VALIDATE_NAME.mesg());
		}
		if (todoDTO.getDescription().length() > 500) {
			throw new CustomException(MessageConstant.VALIDATE_DESCRIPTION.mesg());
		}
		if (!MessageConstant.PENDING.mesg().equalsIgnoreCase(todoDTO.getStatus())) {
			throw new CustomException(MessageConstant.VALIDATE_STATUS_ON_CREATION.mesg());
		}
	}

	/**
	 * Validate on update.
	 *
	 * @param todoDTO the todo DTO
	 * @throws CustomException the custom exception
	 */
	public static void validateOnUpdate(TodoDTO todoDTO) throws CustomException {
		if (StringUtils.isBlank(todoDTO.getName())) {
			throw new CustomException(MessageConstant.VALIDATE_NAME.mesg());
		}
		if (todoDTO.getDescription().length() > 500) {
			throw new CustomException(MessageConstant.VALIDATE_DESCRIPTION.mesg());
		}
		if (MessageConstant.PENDING.mesg().equalsIgnoreCase(todoDTO.getStatus())
				|| MessageConstant.DONE.mesg().equalsIgnoreCase(todoDTO.getStatus())) {
			return;
		} else {
			throw new CustomException(MessageConstant.VALIDATE_STATUS.mesg());
		}
	}
}
