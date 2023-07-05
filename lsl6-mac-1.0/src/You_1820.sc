;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1820)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)
(use System)

(public
	You 31
)

(instance You of LarryTalker
	(properties
		x 10
		y 10
		view 1830
		loop 1
		showTitle 1
		back 74
		textX 125
		textY 11
	)

	(method (init)
		(if (IsFlag 74)
			(tBust cel: 1)
		else
			(tBust cel: 0)
		)
		(cond
			(
				(or
					(OneOf gCurRoomNum 210 390)
					(and (== gCurRoomNum 440) (gCurRoom inset:))
				)
				(= winPosn 0)
				(= textX 180)
				(= talkWidth 120)
			)
			((OneOf gCurRoomNum 320 310)
				(= winPosn 0)
				(= textX 170)
				(= talkWidth 130)
			)
			((== gCurRoomNum 280)
				(= textY 60)
			)
		)
		(super init: tBust)
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1906
	)
)

