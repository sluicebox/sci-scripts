;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1814)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Willy 57
)

(instance Willy of Talker
	(properties
		x 5
		y 5
		view 1814
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: willyBust willyEyes willyMouth &rest)
	)
)

(instance willyBust of Prop
	(properties
		view 1814
		loop 1
	)
)

(instance willyEyes of Prop
	(properties
		nsTop 38
		nsLeft 44
		view 1814
		loop 2
	)
)

(instance willyMouth of Prop
	(properties
		nsTop 46
		nsLeft 18
		view 1814
	)
)

