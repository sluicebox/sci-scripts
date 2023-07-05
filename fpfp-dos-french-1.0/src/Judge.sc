;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1818)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Judge 51
)

(instance Judge of Talker
	(properties
		x 5
		y 5
		view 1816
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: judgeBust judgeEyes judgeMouth &rest)
	)
)

(instance judgeBust of Prop
	(properties
		view 1816
		loop 1
	)
)

(instance judgeEyes of Prop
	(properties
		nsTop 37
		nsLeft 34
		view 1816
		loop 2
	)
)

(instance judgeMouth of Prop
	(properties
		nsTop 42
		nsLeft 30
		view 1816
	)
)

