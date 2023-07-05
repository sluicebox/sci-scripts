;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1129)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Boatman 0
)

(instance Boatman of Eco2Talker
	(properties
		x 5
		y 5
		view 1129
		loop 3
		talkWidth 150
		back 90
		textX 115
		textY 12
		dftBack 90
	)

	(method (init)
		(= font gUserFont)
		(super init: boatmanBust boatmanEyes boatmanMouth &rest)
	)
)

(instance boatmanMouth of Prop
	(properties
		nsTop 45
		nsLeft 21
		view 1129
	)
)

(instance boatmanBust of Prop
	(properties
		view 1129
		loop 1
	)
)

(instance boatmanEyes of Prop
	(properties
		nsTop 27
		nsLeft 20
		view 1129
		loop 2
	)
)

