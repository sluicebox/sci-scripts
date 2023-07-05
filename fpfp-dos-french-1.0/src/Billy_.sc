;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1846)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Billy_ 1
)

(instance Billy_ of Talker
	(properties
		name {Billy }
		x 5
		y 5
		view 1846
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: billyBust billyEyes billyMouth &rest)
	)
)

(instance billyBust of Prop
	(properties
		view 1846
		loop 1
	)
)

(instance billyEyes of Prop
	(properties
		nsTop 36
		nsLeft 34
		view 1846
		loop 2
	)
)

(instance billyMouth of Prop
	(properties
		nsTop 44
		nsLeft 29
		view 1846
	)
)

