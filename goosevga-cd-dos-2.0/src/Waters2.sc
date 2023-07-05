;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Actor)

(class Waters2 of View
	(properties
		signal 24608
		pos 3
		nLoops 0
		illegalBits 0
		cycleSpeed 0
		cycCnt 0
	)

	(method (init)
		(super init:)
		(= nLoops (NumLoops self))
		(Load rsVIEW view)
	)

	(method (doit)
		(if cycCnt
			(-- cycCnt)
		else
			(if (>= (++ loop) nLoops)
				(= pos (= loop 0))
				(= cycCnt cycleSpeed)
			)
			(self getLoop:)
			(if (>= (++ cel) (NumCels self))
				(= cel 0)
			)
			(self saveLoop:)
		)
	)

	(method (dispose)
		(&= signal $ffdf)
		(super dispose:)
	)
)

