;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1887)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	tkrWD40 24
)

(instance tkrWD40 of Talker
	(properties
		x 10
		y 25
		view 1006
		talkWidth 150
		textX 125
		textY 10
	)

	(method (init)
		(= font gUserFont)
		(super init: wd40Bust wd40Eyes wd40Mouth &rest)
	)
)

(instance wd40Bust of Prop
	(properties
		view 1006
	)
)

(instance wd40Eyes of Prop
	(properties
		nsTop 22
		nsLeft 60
		view 1006
		loop 2
	)
)

(instance wd40Mouth of Prop
	(properties
		nsTop 33
		nsLeft 48
		view 1006
		loop 1
	)
)

