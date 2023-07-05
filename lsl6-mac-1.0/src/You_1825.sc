;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1825)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Sound)
(use Actor)
(use System)

(public
	You 35
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
			(
				(or
					(OneOf gCurRoomNum 280 250)
					(and (IsFlag 8) (== gCurRoomNum 230))
				)
				(= textX 100)
				(= textY 68)
				(= talkWidth 175)
			)
			((== gCurRoomNum 370)
				(= talkWidth 120)
				(= textX 168)
			)
			((== gCurRoomNum 410)
				(= textY 65)
				(= textX 120)
			)
			((== gCurRoomNum 140)
				(= winPosn 0)
				(= textX 90)
				(= textY 10)
				(= talkWidth 80)
			)
		)
		(super init: tBust)
	)

	(method (show)
		(super show: &rest)
		(dohSFX play:)
	)
)

(instance tBust of View
	(properties
		nsTop 4
		nsLeft 4
		view 1907
	)
)

(instance dohSFX of Sound
	(properties
		flags 1
		number 1005
	)
)

