;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 160)
(include sci.sh)
(use Main)
(use Talker)
(use Actor)

(public
	meepTalker 0
)

(instance meepTalker of Talker
	(properties
		x 10
		y 10
		view 1060
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: meepBust meepEye meepMouth &rest)
		(meepLeg setCycle: Blink 100)
	)

	(method (show)
		(super show:)
	)

	(method (doit)
		(super doit:)
		(self cycle: meepLeg)
	)

	(method (dispose)
		(super dispose: &rest)
		(meepLeg setCycle: 0 dispose: delete:)
	)
)

(instance meepBust of Prop
	(properties
		view 1060
	)
)

(instance meepMouth of Prop
	(properties
		nsTop 32
		nsLeft 39
		view 1060
		loop 1
	)
)

(instance meepLeg of Prop
	(properties
		nsTop 49
		nsLeft 58
		view 1060
		loop 3
		priority 14
		signal 16
	)
)

(instance meepEye of Prop
	(properties
		nsTop 17
		nsLeft 42
		view 1060
		loop 2
	)
)

