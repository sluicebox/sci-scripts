;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1816)
(include sci.sh)
(use Main)
(use fileScr)
(use LarryTalker)
(use Actor)

(public
	Shamara 14
)

(instance Shamara of LarryTalker
	(properties
		x 15
		y 25
		showTitle 1
		back 63
		view 720
		loop 1
		fullFace 1
	)

	(method (init)
		(switch gCurRoomNum
			(720
				(if (IsFlag 100)
					(super init:)
				else
					(super init: tMouth 0 tEyes)
				)
			)
			(730
				(= view 730)
				(super init: tMouth 0 tEyes)
			)
			(else
				(super init: tMouth tBust tEyes)
			)
		)
	)
)

(instance tBust of View
	(properties
		x -11
		y -18
		view 720
		loop 4
	)
)

(instance tMouth of Prop
	(properties
		view 720
	)

	(method (init)
		(if (== gCurRoomNum 730)
			(self view: 730 x: 108 y: 83)
		else
			(self view: 720 x: 167 y: 29)
		)
		(super init: &rest)
	)
)

(instance tEyes of Prop
	(properties
		view 720
		loop 2
	)

	(method (init)
		(if (== gCurRoomNum 730)
			(self x: 105 y: 49 view: 730)
		else
			(self view: 720 x: 164 y: 23)
		)
		(super init: &rest)
	)
)

