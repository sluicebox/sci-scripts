;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1819)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)
(use System)

(public
	You 30
)

(instance You of LarryTalker
	(properties
		x 10
		y 10
		view 1830
		loop 1
		showTitle 1
		back 74
		textX 90
		textY 10
		winPosn 1
	)

	(method (init)
		(= name
			(switch (gGame printLang:)
				(34 {Tu})
				(49 {Du})
				(33 {Tu})
				(else {You})
			)
		)
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
			((== gCurRoomNum 140)
				(= winPosn 0)
				(= textX 90)
				(= talkWidth 205)
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
		view 1905
	)
)

