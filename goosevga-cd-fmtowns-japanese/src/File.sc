;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 993)
(include sci.sh)
(use System)

(class gamefile_sh of Obj
	(properties
		name {gamefile.sh}
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
				(else -1)
			)
		)
		(return (if (== handle -1) 0 else self))
	)

	(method (write str &tmp i)
		(if (not handle)
			(self open:)
		)
		(for ((= i 0)) (< i argc) ((++ i))
			(FileIO fiWRITE_STRING handle [str i])
		)
	)

	(method (read str len)
		(if (!= argc 2)
			(return 0)
		)
		(if (not handle)
			(self open: 1)
		)
		(return (FileIO fiREAD_STRING str len handle))
	)

	(method (close)
		(if handle
			(FileIO fiCLOSE handle)
			(= handle 0)
		)
	)

	(method (dispose)
		(self close:)
		(super dispose:)
	)

	(method (showStr where)
		(Format where 993 0 name) ; "File: %s"
	)
)

