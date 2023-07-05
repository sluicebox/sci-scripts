;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1809)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryTalker)
(use Actor)

(public
	Daryl 8
)

(instance Daryl of LarryTalker
	(properties
		talkWidth 100
		showTitle 1
		back 65
		view 98
		fullFace 1
	)

	(method (init)
		(if (== gCurRoomNum 850)
			(if (IsFlag 95)
				(tMouth view: 850 loop: 3 x: 159 y: 22)
			else
				(tMouth view: 850 loop: 5 x: 165 y: 15)
			)
			(super init: 0 0 tMouth)
			(= textX -158)
			(= talkWidth 120)
		else
			(= textX -158)
			(= talkWidth 150)
			(super init:)
		)
	)
)

(instance tMouth of Prop
	(properties
		view 850
		loop 5
	)
)

