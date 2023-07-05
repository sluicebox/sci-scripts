;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1807)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Virtue 46
)

(instance Virtue of Talker
	(properties
		x 5
		y 5
		view 1823
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: virtueBust virtueEyes virtueMouth &rest)
	)
)

(instance virtueBust of Prop
	(properties
		view 1823
		loop 1
	)
)

(instance virtueEyes of Prop
	(properties
		nsTop 47
		nsLeft 40
		view 1823
		loop 2
	)
)

(instance virtueMouth of Prop
	(properties
		nsTop 63
		nsLeft 40
		view 1823
	)
)

