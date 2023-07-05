;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1882)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Pippin 10
)

(instance Pippin of Talker
	(properties
		x 5
		y 5
		view 1882
		loop 3
		talkWidth 150
		back 15
		textX 105
		textY 12
	)

	(method (init)
		(= font gUserFont)
		(super init: pippinBust pippinEyes pippinMouth &rest)
	)
)

(instance pippinBust of Prop
	(properties
		view 1882
		loop 1
	)
)

(instance pippinEyes of Prop
	(properties
		nsTop 36
		nsLeft 27
		view 1882
		loop 2
	)
)

(instance pippinMouth of Prop
	(properties
		nsTop 57
		nsLeft 24
		view 1882
	)
)

