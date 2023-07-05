;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 40)
(include sci.sh)
(use Main)
(use TargFeature)
(use GloryTalker)
(use Actor)
(use System)

(public
	haramiATalker 0
	Harami 1
)

(instance Harami of TargActor
	(properties
		noun 1
		view 950
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 24 29 40 28 27) ; theRations, theFruit, theHoney, theMeat, theFish
			(= temp0
				(switch theVerb
					(24 14) ; theRations
					(29 19) ; theFruit
					(40 29) ; theHoney
					(28 18) ; theMeat
					(27 17) ; theFish
				)
			)
			(gEgo drop: temp0 1)
			(SetFlag 113)
			(gEgo addHonor: 10)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance haramiATalker of GloryTalker
	(properties
		x 185
		y 10
		view 951
		loop 1
		talkWidth 260
		back 57
		textX -161
		textY 100
		backColor 26
	)

	(method (init)
		(super init: haramiABust haramiAEyes haramiAMouth &rest)
	)
)

(instance haramiAMouth of Prop
	(properties
		nsTop 45
		nsLeft 26
		view 951
	)
)

(instance haramiAEyes of Prop
	(properties
		nsTop 30
		nsLeft 24
		view 951
		loop 2
	)
)

(instance haramiABust of View
	(properties
		nsTop 20
		nsLeft 23
		view 951
		loop 3
	)
)

