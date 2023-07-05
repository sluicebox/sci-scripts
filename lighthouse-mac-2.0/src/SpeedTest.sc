;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64908)
(include sci.sh)
(use Actor)

(public
	SpeedTest 0
)

(procedure (SpeedTest &tmp endTime distance speedRating) ; UNUSED
	(fred init: posn: 0 100)
	(= endTime (+ (GetTime) 60))
	(while (< (GetTime) endTime)
		(fred doit:)
		(UpdateScreenItem fred)
		(FrameOut)
	)
	(= distance (fred x:))
	(fred dispose:)
	(if (>= distance 100)
		(= speedRating 0)
	else
		(= speedRating (- 10 (/ distance 10)))
	)
	(DisposeScript 64908 speedRating)
)

(instance fred of Actor
	(properties
		view 64980
	)

	(method (doit)
		(++ x)
	)
)

