;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1816)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	Jim_Laffer 52
)

(instance Jim_Laffer of Talker
	(properties
		name {Jim Laffer}
		x 5
		y 5
		view 1813
		loop 3
		disposeWhenDone 2
		talkWidth 150
		textX 133
		textY 12
	)

	(method (init)
		(= back global134)
		(= font gUserFont)
		(super init: jimLafferBust jimLafferEyes jimLafferMouth &rest)
	)
)

(instance jimLafferBust of Prop
	(properties
		view 1813
		loop 1
	)
)

(instance jimLafferEyes of Prop
	(properties
		nsTop 51
		nsLeft 54
		view 1813
		loop 2
	)
)

(instance jimLafferMouth of Prop
	(properties
		nsTop 57
		nsLeft 46
		view 1813
	)
)

