;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 899)
(include sci.sh)
(use Interface)
(use Feature)

(public
	dbg 0
)

(local
	local0
)

(procedure (localproc_0 param1 param2 &tmp [temp0 40]) ; UNUSED
	(= temp0 0)
	(if (> argc 1)
		(Format @temp0 899 0 param2) ; "%d"
	)
	(return
		(if (GetInput @temp0 10 param1)
			(ReadNumber @temp0)
		else
			-1
		)
	)
)

(instance dbg of Feature
	(properties)

	(method (handleEvent)
		(return 0)
	)
)

