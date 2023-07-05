;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 993)
(include sci.sh)
(use System)

(class File of Obj
	(properties
		handle 0
	)

	(method (open mode)
		(= handle
			(switch argc
				(0
					(FileIO fiOPEN name 0)
				)
				(1
					(FileIO fiOPEN name mode)
				)
				(else 0)
			)
		)
		(if (== handle -1)
			(= handle 0)
		)
		(return (if handle self else 0))
	)

	(method (write str len &tmp i)
		(if (not handle)
			(self open:)
		)
		(return
			(if handle
				(FileIO fiWRITE handle str len)
			else
				0
			)
		)
	)

	(method (writeString str &tmp i)
		(if (not handle)
			(self open:)
		)
		(if handle
			(for ((= i 0)) (< i argc) ((++ i))
				(if (not (FileIO fiWRITE_STRING handle [str i]))
					(return 0)
				)
			)
		)
		(return 1)
	)

	(method (read str len)
		(if (!= argc 2)
			(return 0)
		)
		(if (not handle)
			(self open: 1)
		)
		(return
			(if handle
				(FileIO fiREAD handle str len)
			else
				0
			)
		)
	)

	(method (readString str len)
		(if (!= argc 2)
			(return 0)
		)
		(if (not handle)
			(self open: 1)
		)
		(return
			(if handle
				(FileIO fiREAD_STRING str len handle)
			else
				0
			)
		)
	)

	(method (rename newName &tmp rc)
		(if (not (= rc (FileIO fiRENAME name newName)))
			(= name newName)
		)
		(return rc)
	)

	(method (seek offset mode &tmp theMode)
		(= theMode (if (>= argc 2) mode else 0))
		(if (not handle)
			(self open: 1)
		)
		(return
			(if handle
				(FileIO fiSEEK handle offset theMode)
			else
				0
			)
		)
	)

	(method (close)
		(if handle
			(FileIO fiCLOSE handle)
			(= handle 0)
		)
	)

	(method (delete)
		(if handle
			(self close:)
		)
		(FileIO fiUNLINK name)
	)

	(method (dispose)
		(self close:)
		(super dispose:)
	)

	(method (showStr where)
		(Format where {File: %s} name)
	)
)

