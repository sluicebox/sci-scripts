;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 993)
(include sci.sh)
(use System)

(class File of Obj
	(properties
		sel_20 0
		sel_90 0
	)

	(method (sel_183 param1)
		(= sel_90
			(switch argc
				(0
					(FileIO fiOPEN sel_20 0)
				)
				(1
					(FileIO fiOPEN sel_20 param1)
				)
				(else 0)
			)
		)
		(if (== sel_90 -1)
			(= sel_90 0)
		)
		(return (if sel_90 self else 0))
	)

	(method (sel_329 param1 param2 &tmp temp0)
		(if (not sel_90)
			(self sel_183:)
		)
		(return
			(if sel_90
				(FileIO fiWRITE sel_90 param1 param2)
			else
				0
			)
		)
	)

	(method (sel_328 param1 &tmp temp0)
		(if (not sel_90)
			(self sel_183:)
		)
		(if sel_90
			(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
				(FileIO fiWRITE_STRING sel_90 [param1 temp0])
			)
		)
	)

	(method (sel_330 param1 param2)
		(if (!= argc 2)
			(return 0)
		)
		(if (not sel_90)
			(self sel_183: 1)
		)
		(return
			(if sel_90
				(FileIO fiREAD sel_90 param1 param2)
			else
				0
			)
		)
	)

	(method (sel_327 param1 param2)
		(if (!= argc 2)
			(return 0)
		)
		(if (not sel_90)
			(self sel_183: 1)
		)
		(return
			(if sel_90
				(FileIO fiREAD_STRING param1 param2 sel_90)
			else
				0
			)
		)
	)

	(method (sel_331 param1 param2 &tmp temp0)
		(= temp0 (if (>= argc 2) param2 else 0))
		(if (not sel_90)
			(self sel_183: 1)
		)
		(return
			(if sel_90
				(FileIO fiSEEK sel_90 param1 temp0)
			else
				0
			)
		)
	)

	(method (sel_332)
		(if sel_90
			(FileIO fiCLOSE sel_90)
			(= sel_90 0)
		)
	)

	(method (sel_81)
		(if sel_90
			(self sel_332:)
		)
		(FileIO fiUNLINK sel_20)
	)

	(method (sel_111)
		(self sel_332:)
		(super sel_111:)
	)

	(method (sel_112 param1)
		(Format param1 993 0 sel_20) ; "File: %s"
	)
)

