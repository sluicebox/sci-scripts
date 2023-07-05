;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1249)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	MaBird 0
)

(instance MaBird of Eco2Talker
	(properties
		x 192
		y 107
		view 1248
		loop 3
		talkWidth 150
		back 90
		textX -175
		textY 10
		dftBack 90
		textSpacer 20
	)

	(method (init)
		(= font gUserFont)
		(self setupTalker: 4)
		(super init: maBirdBust maBirdEyes maBirdMouth &rest)
	)
)

(instance maBirdMouth of Prop
	(properties
		nsTop 27
		nsLeft 12
		view 1248
	)
)

(instance maBirdBust of Prop
	(properties
		view 1248
		loop 1
	)
)

(instance maBirdEyes of Prop
	(properties
		nsTop 20
		nsLeft 24
		view 1248
		loop 2
	)
)

