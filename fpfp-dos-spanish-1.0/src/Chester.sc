;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1845)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Chester 2
)

(instance Chester of Talker
	(properties
		x 5
		y 5
		view 1845
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: chesterBust chesterEyes chesterMouth &rest)
	)
)

(instance chesterBust of Prop
	(properties
		view 1845
		loop 1
	)
)

(instance chesterEyes of Prop
	(properties
		nsTop 19
		nsLeft 40
		view 1845
		loop 2
	)
)

(instance chesterMouth of Prop
	(properties
		nsTop 35
		nsLeft 35
		view 1845
	)
)

