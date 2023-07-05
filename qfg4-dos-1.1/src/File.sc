;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64993)
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
				(FileIO fiWRITE handle (KString 9 str) len) ; StrGetData
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
				(if (not (FileIO fiWRITE_STRING handle (KString 9 [str i]))) ; StrGetData
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
				(FileIO fiREAD handle (KString 9 str) len) ; StrGetData
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
				(FileIO fiREAD_STRING (KString 9 str) len handle) ; StrGetData
			else
				0
			)
		)
	)

	(method (rename param1 &tmp temp0)
		(if (not (= temp0 (FileIO fiRENAME name param1)))
			(= name param1)
		)
		(return temp0)
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
)

