;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1801)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Lever_Bros 55
)

(instance Lever_Bros of Talker
	(properties
		name {Lever Bros}
		x 5
		y 5
		view 1817
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: leverBrosBust leverBrosEyes leverBrosMouth &rest)
	)
)

(instance leverBrosBust of Prop
	(properties
		view 1817
		loop 1
	)
)

(instance leverBrosEyes of Prop
	(properties
		nsTop 55
		nsLeft 44
		view 1817
		loop 2
	)
)

(instance leverBrosMouth of Prop
	(properties
		nsTop 69
		nsLeft 36
		view 1817
	)
)

