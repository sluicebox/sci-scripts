;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1891)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Rameses 27
)

(instance Rameses of Talker
	(properties
		x 5
		y 5
		view 1891
		loop 3
		talkWidth 150
		back 15
		textX 110
		textY 12
	)

	(method (init)
		(= font gUserFont)
		(super init: ramesesBust ramesesEyes ramesesMouth &rest)
	)
)

(instance ramesesBust of Prop
	(properties
		view 1891
		loop 1
	)
)

(instance ramesesEyes of Prop
	(properties
		nsTop 39
		nsLeft 36
		view 1891
		loop 2
	)
)

(instance ramesesMouth of Prop
	(properties
		nsTop 54
		nsLeft 27
		view 1891
	)
)

