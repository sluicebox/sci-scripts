;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1810)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Gambler 50
)

(instance Gambler of Talker
	(properties
		x 5
		y 5
		view 1808
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(if (== gCurRoomNum 675)
			(= textX 20)
			(= textY 130)
			(= talkWidth 260)
			(super init: acesCloseBust acesCloseEyes acesCloseMouth &rest)
		else
			(super init: gamblerBust gamblerEyes gamblerMouth &rest)
		)
	)
)

(instance gamblerBust of Prop
	(properties
		view 1808
		loop 1
	)
)

(instance gamblerEyes of Prop
	(properties
		view 1808
		loop 2
	)
)

(instance gamblerMouth of Prop
	(properties
		nsTop 44
		nsLeft 20
		view 1808
	)
)

(instance acesCloseBust of Prop
	(properties
		view 1843
	)
)

(instance acesCloseEyes of Prop
	(properties
		view 1843
	)
)

(instance acesCloseMouth of Prop
	(properties
		nsTop 37
		nsLeft 131
		view 675
		loop 4
		priority 1
	)
)

