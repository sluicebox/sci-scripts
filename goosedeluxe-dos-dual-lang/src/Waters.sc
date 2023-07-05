;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 401)
(include sci.sh)
(use Main)
(use System)

(class Waters of Obj
	(properties
		x 0
		y 0
		priority 0
		pos 0
		nLoops 0
		view 0
		loop 16
		cel 0
		cycleSpeed 3
		cycleCnt 0
	)

	(method (init)
		(= nLoops (NumLoops self))
		(= cycleCnt gGameTime)
	)

	(method (doit)
		(if (>= (Abs (- gGameTime cycleCnt)) cycleSpeed)
			(= cycleCnt gGameTime)
			(if (>= (++ loop) nLoops)
				(= pos (= loop 0))
			)
			(self getLoop:)
			(if (>= (++ cel) (NumCels self))
				(= cel 0)
			)
			(self saveLoop:)
		)
	)
)

