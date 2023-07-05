;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Main)
(use Actor)

(class Waters2 of View
	(properties
		view 0
		signal 24608
		pos 3
		nLoops 0
		illegalBits 0
		cycleSpeed 3
		cycleCnt 0
	)

	(method (init)
		(super init:)
		(= nLoops (NumLoops self))
		(= cycleCnt gGameTime)
	)

	(method (doit)
		(if (>= (Abs (- gGameTime cycleCnt)) cycleSpeed)
			(= cycleCnt gGameTime)
			(if (>= (++ loop) nLoops)
				(= pos (= loop 0))
				(= cycleCnt cycleSpeed)
			)
			(self getLoop:)
			(if (>= (++ cel) (NumCels self))
				(= cel 0)
			)
			(self saveLoop:)
		)
	)

	(method (dispose)
		(&= signal (~ global510))
		(super dispose:)
	)

	(method (handleEvent)
		(return 0)
	)
)

