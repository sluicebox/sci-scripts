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

	(method (isType param1)
		(= handle
			(switch argc
				(0
					(FileIO fiOPEN name 0)
				)
				(1
					(FileIO fiOPEN name param1)
				)
				(else -1)
			)
		)
		(return (if (== handle -1) 0 else self))
	)

	(method (hesitation param1 &tmp temp0)
		(if (not handle)
			(self isType:)
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(FileIO fiWRITE_STRING handle [param1 temp0])
		)
	)

	(method (pauseCel param1 param2)
		(if (!= argc 2)
			(return 0)
		)
		(if (not handle)
			(self isType: 1)
		)
		(return (FileIO fiREAD_STRING param1 param2 handle))
	)

	(method (minPause)
		(if handle
			(FileIO fiCLOSE handle)
			(= handle 0)
		)
	)

	(method (dispose)
		(self minPause:)
		(super dispose:)
	)

	(method (showStr where)
		(Format where 993 0 name) ; "File: %s"
	)
)

