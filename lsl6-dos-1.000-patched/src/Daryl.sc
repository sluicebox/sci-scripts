;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1809)
(include sci.sh)
(use Main)
(use n079)
(use LarryTalker)
(use Actor)

(public
	Daryl 8
)

(instance Daryl of LarryTalker
	(properties
		x 164
		y 18
		view 98
		talkWidth 100
		showTitle 1
		color 7
		back 65
	)

	(method (init)
		(if (== gCurRoomNum 850)
			(if (IsFlag 95)
				(tMouth view: 850 loop: 3 nsLeft: -5 nsTop: 5)
			else
				(tMouth view: 850 loop: 5 nsLeft: 0 nsTop: 0)
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

