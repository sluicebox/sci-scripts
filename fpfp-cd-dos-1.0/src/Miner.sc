;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1827)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Miner 8
)

(instance Miner of Talker
	(properties
		x 5
		y 5
		view 1827
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: minerBust minerEyes minerMouth &rest)
	)
)

(instance minerBust of Prop
	(properties
		view 1827
		loop 1
	)
)

(instance minerEyes of Prop
	(properties
		nsTop 33
		nsLeft 54
		view 1827
		loop 2
	)
)

(instance minerMouth of Prop
	(properties
		nsTop 41
		nsLeft 29
		view 1827
	)
)

