;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1808)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Sam_Andreas 3
)

(instance Sam_Andreas of Talker
	(properties
		name {Sam Andreas}
		x 5
		y 5
		view 1815
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: samAndreasBust samAndreasEyes samAndreasMouth &rest)
	)
)

(instance samAndreasBust of Prop
	(properties
		view 1815
		loop 1
	)
)

(instance samAndreasEyes of Prop
	(properties
		nsTop 23
		nsLeft 43
		view 1815
		loop 2
	)
)

(instance samAndreasMouth of Prop
	(properties
		nsTop 36
		nsLeft 45
		view 1815
	)
)

