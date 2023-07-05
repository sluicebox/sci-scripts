;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
(include sci.sh)
(use Main)
(use Vendor)
(use GloryTalker)
(use Actor)

(public
	leatherVendor 0
	tLeatherTalker 1
)

(local
	local0
)

(instance leatherVendor of Vendor
	(properties
		noun 3
	)

	(method (dispose)
		(= goods 0)
		(super dispose: &rest)
	)

	(method (transact param1 param2)
		(= local0 self)
		(switch param1
			(0
				(proc47_3 param1 param2 local0)
				(gEgo get: 15 param2 solvePuzzle: 220 3) ; theWaterskin
				(gMessager say: 3 6 19 0 self)
			)
			(1
				(proc47_3 param1 param2 local0)
				(gEgo get: 21 param2 solvePuzzle: 219 2) ; theSkins
				(gMessager say: 3 6 19 0 self)
			)
		)
	)

	(method (doBargain param1)
		(switch param1
			(1
				(gMessager say: 3 6 35 0 self)
			)
			(2
				(gMessager say: 3 6 39 0 self)
			)
			(3
				(gMessager say: 3 6 40 0 self)
			)
			(4
				(gMessager say: 3 6 41 0 self) ; "Ongeza kidogo, bwana. Give me more."
			)
			(5
				(gMessager say: 3 6 38 0 self)
			)
			(6
				(gMessager say: 3 6 37 0 self)
			)
			(else
				(self cue:)
			)
		)
	)
)

(instance tLeatherTalker of GloryTalker
	(properties
		x 200
		y 2
		view 237
		loop 1
		cel 1
		talkWidth 260
		back 57
		textX -175
		textY 150
		backColor 24
	)

	(method (init)
		(super init: leatherBust leatherEyes leatherMouth &rest)
	)
)

(instance leatherBust of Prop
	(properties
		nsTop 27
		nsLeft 30
		view 237
		loop 3
		cel 1
	)
)

(instance leatherEyes of Prop
	(properties
		nsTop 43
		nsLeft 34
		view 237
		loop 2
	)
)

(instance leatherMouth of Prop
	(properties
		nsTop 55
		nsLeft 32
		view 237
	)
)

