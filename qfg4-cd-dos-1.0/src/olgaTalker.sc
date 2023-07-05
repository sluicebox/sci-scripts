;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use GloryTalker)
(use Motion)
(use Actor)

(public
	olgaTalker 0
	knitNeedles 1
)

(instance olgaTalker of GloryTalker
	(properties
		talkWidth 150
		textX 140
		textY 5
	)

	(method (init)
		(super init: olgaMouth 0 olgaEyes olgaFrame &rest)
		(UpdateScreenItem
			(knitNeedles init: cycleSpeed: 8 setCycle: Fwd yourself:)
		)
	)

	(method (dispose param1)
		(if (and (or (not argc) param1 (== gCurRoomNum 635)) (not (IsFlag 147)))
			(knitNeedles dispose:)
		)
		(super dispose: param1)
	)
)

(instance olgaFrame of View
	(properties
		y 13
		view 316
	)
)

(instance olgaMouth of Prop
	(properties
		x 59
		y 70
		view 316
		loop 1
	)
)

(instance olgaEyes of Prop
	(properties
		x 65
		y 59
		view 316
		loop 2
	)
)

(instance knitNeedles of Prop
	(properties
		x 64
		y 163
		view 316
		loop 3
	)
)

