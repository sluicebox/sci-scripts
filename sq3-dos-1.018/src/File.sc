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
					(FOpen name 0)
				)
				(1
					(FOpen name mode)
				)
				(else 0)
			)
		)
		(if (== handle -1)
			(= handle 0)
		)
		(return (if handle self else 0))
	)

	(method (write str &tmp i)
		(if (not handle)
			(self open:)
		)
		(if handle
			(for ((= i 0)) (< i argc) ((++ i))
				(FPuts handle [str i])
			)
		)
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
				(FGets str len handle)
			else
				0
			)
		)
	)

	(method (close)
		(if handle
			(FClose handle)
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

