;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 324)
(include sci.sh)
(use Main)
(use Reserve)

(public
	proc324_0 0
)

(procedure (proc324_0 param1 &tmp temp0 temp1)
	(if (param1 isMemberOf: Reserve)
		(+= global400 1)
		(for
			((= global301 (= temp0 (= temp1 0))))
			(< global301 8)
			((++ global301))
			
			(if ((gTheReserves at: global301) size:)
				(+= temp1 ((gTheReserves at: global301) size:))
			else
				(++ temp0)
			)
			(if (and (== temp1 52) (> (+= global400 temp0) 52))
				(= global400 52)
			)
		)
		(proc0_4)
	)
)

