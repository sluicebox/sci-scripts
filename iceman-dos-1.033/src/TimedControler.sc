;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 817)
(include sci.sh)
(use n827)
(use System)

(class TimedControler of Code
	(properties
		theObj 0
		selector 0
		cycles 10
		cyclCnt 0
		incPerTime 0
	)

	(method (init param1 param2)
		(= theObj param1)
		(= selector param2)
	)

	(method (doit &tmp temp0)
		(if (>= (++ cyclCnt) cycles)
			(= cyclCnt 0)
			(self drive:)
		)
	)

	(method (drive)
		(proc827_0 theObj selector (+ (proc827_0 theObj selector) incPerTime))
	)
)

