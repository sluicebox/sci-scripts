;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1818)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)
(use System)

(public
	You 29
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
			((or (== gCurRoomNum 210) (and (== gCurRoomNum 440) (gCurRoom inset:)))
				(= winPosn 0)
				(= textX 180)
				(= talkWidth 120)
			)
			((== gCurRoomNum 280)
				(= textY 60)
			)
			((OneOf gCurRoomNum 520 590)
				(= textX 110)
				(= textY 70)
				(= talkWidth 180)
			)
			((OneOf gCurRoomNum 720 730)
				(= textX 140)
				(= textY 47)
				(= talkWidth 150)
			)
			(else
				(= winPosn 1)
			)
		)
		(super init: tBust)
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1904
	)
)

