;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1356)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	drunkTalker 0
)

(instance drunkTalker of Talker
	(properties
		x 210
		y 80
		view 1356
		priority 15
		signal 16400
		talkWidth 150
		textX -180
	)

	(method (init)
		(= font gUserFont)
		(super init: 0 0 drunkMouth &rest)
	)
)

(instance drunkMouth of Prop
	(properties
		nsTop 34
		nsLeft 29
		view 1356
		loop 1
		priority 15
		signal 16400
	)
)

