;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1885)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Yvette 28
)

(instance Yvette of Talker
	(properties
		x 5
		y 5
		view 1885
		loop 3
		talkWidth 150
		back 15
		textX 110
		textY 12
	)

	(method (init)
		(= font gUserFont)
		(super init: yvetteBust yvetteEyes yvetteMouth &rest)
	)
)

(instance yvetteBust of Prop
	(properties
		view 1885
		loop 1
	)
)

(instance yvetteEyes of Prop
	(properties
		nsTop 29
		nsLeft 21
		view 1885
		loop 2
	)
)

(instance yvetteMouth of Prop
	(properties
		nsTop 47
		nsLeft 25
		view 1885
	)
)

