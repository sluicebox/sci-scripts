;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 232)
(include sci.sh)
(use Main)
(use Vendor)
(use GloryTalker)
(use Actor)

(public
	fruitVendor 0
	tFruitTalker 1
)

(local
	local0
)

(instance fruitVendor of Vendor
	(properties
		noun 4
	)

	(method (dispose)
		(= goods 0)
		(super dispose:)
	)

	(method (transact param1 param2)
		(switch param1
			(0
				(= local0 self)
				(proc47_3 param1 param2 local0)
				(gEgo get: 19 param2) ; theFruit
				(gMessager say: 4 6 19 0 self)
			)
		)
	)

	(method (doBargain param1)
		(switch param1
			(1
				(gMessager say: 4 6 35 0 self)
			)
			(2
				(gMessager say: 4 6 39 0 self)
			)
			(3
				(gMessager say: 4 6 40 0 self)
			)
			(4
				(gMessager say: 4 6 41 0 self)
			)
			(5
				(gMessager say: 4 6 38 0 self)
			)
			(6
				(gMessager say: 4 6 37 0 self)
			)
			(else
				(self cue:)
			)
		)
	)
)

(instance tFruitTalker of GloryTalker
	(properties
		x 200
		y 2
		view 235
		loop 1
		talkWidth 260
		back 57
		textX -175
		textY 150
		backColor 28
	)

	(method (init)
		(super init: fruitBust fruitEyes fruitMouth &rest)
	)
)

(instance fruitBust of Prop
	(properties
		nsTop 38
		nsLeft 23
		view 235
		loop 3
	)
)

(instance fruitEyes of Prop
	(properties
		nsTop 47
		nsLeft 27
		view 235
		loop 2
	)
)

(instance fruitMouth of Prop
	(properties
		nsTop 62
		nsLeft 23
		view 235
	)
)

