;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Talker)

(public
	LarryTalker 0
)

(class LarryTalker of Talker
	(properties
		talkWidth 175
		winPosn 0
	)

	(method (init)
		(if (not font)
			(= font gUserFont)
		)
		(switch winPosn
			(1
				(= textX 160)
				(= textY 10)
				(= talkWidth 130)
				(= y (= x 10))
			)
			(2
				(= textX -220)
				(= textY 10)
				(= x 230)
				(= y 10)
				(= talkWidth 145)
			)
		)
		(super init: &rest)
	)
)

(class LarryNarrator of Narrator
	(properties)

	(method (init)
		(if (== gCurRoomNum 740)
			(= y 30)
		else
			(= y -1)
		)
		(= font gUserFont)
		(super init: &rest)
	)
)

