;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1805)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Purity 45
)

(instance Purity of Talker
	(properties
		x 5
		y 5
		view 1821
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: purityBust purityEyes purityMouth &rest)
	)
)

(instance purityBust of Prop
	(properties
		view 1821
		loop 1
	)
)

(instance purityEyes of Prop
	(properties
		nsTop 48
		nsLeft 38
		view 1821
		loop 2
	)
)

(instance purityMouth of Prop
	(properties
		nsTop 55
		nsLeft 38
		view 1821
	)
)

