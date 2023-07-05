;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1149)
(include sci.sh)
(use Main)
(use Eco2Talker)
(use Actor)

(public
	Peddler 0
)

(instance Peddler of Eco2Talker
	(properties
		x 5
		y 5
		view 1149
		loop 3
		talkWidth 150
		back 90
		textX 115
		textY 12
		dftBack 90
	)

	(method (init)
		(= font gUserFont)
		(super init: peddlerBust peddlerEyes peddlerMouth &rest)
	)
)

(instance peddlerMouth of Prop
	(properties
		nsTop 47
		nsLeft 17
		view 1149
	)
)

(instance peddlerBust of Prop
	(properties
		view 1149
		loop 1
	)
)

(instance peddlerEyes of Prop
	(properties
		nsTop 27
		nsLeft 14
		view 1149
		loop 2
	)
)

