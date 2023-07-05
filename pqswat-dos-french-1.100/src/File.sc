;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64993)
(include sci.sh)
(use Str)
(use System)

(class File of Obj
	(properties
		handle 0
	)

	(method (dispose)
		(self close:)
		(super dispose:)
	)

	(method (close)
		(if handle
			(FileIO fiCLOSE handle)
			(= handle 0)
		)
	)

	(method (copy oldOrNew newFileName &tmp oldName newName)
		(if (> argc 1)
			(= oldName (KString 9 oldOrNew)) ; StrGetData
			(= newName (KString 9 newFileName)) ; StrGetData
		else
			(= oldName name)
			(= newName (KString 9 oldOrNew)) ; StrGetData
		)
		(FileIO 12 oldName newName) ; Copy
	)

	(method (delete fName)
		(if handle
			(self close:)
		)
		(FileIO
			fiUNLINK
			(if argc
				(KString 9 fName) ; StrGetData
			else
				name
			)
		)
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

	(method (readByte)
		(FileIO 13 handle) ; GetByte
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

	(method (readWord)
		(FileIO 15 handle) ; GetWord
	)

	(method (rename oldOrNew newName &tmp upDate newN oldN tmpStr)
		(if (> argc 1)
			(= upDate 0)
			(= oldN (KString 9 oldOrNew)) ; StrGetData
			(= newN (KString 9 newName)) ; StrGetData
		else
			(= upDate 1)
			(= oldN name)
			(= newN (KString 9 oldOrNew)) ; StrGetData
		)
		(if (FileIO fiRENAME oldN newN)
			(return 0)
		else
			(if upDate
				(= tmpStr (Str with: newN))
				(= name (tmpStr data:))
				(tmpStr data: 0 dispose:)
			)
			(return 1)
		)
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

	(method (writeByte b)
		(FileIO 14 handle b) ; PutByte
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

	(method (writeWord theValue)
		(FileIO 16 handle theValue) ; PutWord
	)
)

