;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1804)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Doc 48
)

(instance Doc of Talker
	(properties
		x 5
		y 5
		view 1804
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: docBust docEyes docMouth &rest)
	)
)

(instance docBust of Prop
	(properties
		view 1804
		loop 1
	)
)

(instance docEyes of Prop
	(properties
		nsTop 22
		nsLeft 42
		view 1804
		loop 2
	)
)

(instance docMouth of Prop
	(properties
		nsTop 32
		nsLeft 28
		view 1804
	)
)

