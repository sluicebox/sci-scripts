;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64908)
(include sci.sh)
(use Actor)

(public
	SpeedTest 0
)

(procedure (SpeedTest &tmp temp0 temp1 temp2 temp3)
	(fred view: 64980 loop: 0 cel: 0 init: posn: 200 240)
	(= temp1 0)
	(= temp2 -1)
	(FrameOut)
	(= temp0 (+ (GetTime) 120))
	(while (< (GetTime) temp0)
		(*= temp2 -1)
		(fred x: (+ (fred x:) temp2))
		(UpdateScreenItem fred)
		(FrameOut)
		(++ temp1)
	)
	(fred dispose:)
	(return temp1)
)

(instance fred of Actor
	(properties
		view 64980
	)

	(method (doit)
		(++ x)
	)
)

