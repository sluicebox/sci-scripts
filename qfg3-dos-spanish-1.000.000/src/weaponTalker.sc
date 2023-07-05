;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 245)
(include sci.sh)
(use Main)
(use Vendor)
(use GloryTalker)
(use Actor)

(public
	weaponTalker 0
	weaponVendor 1
)

(local
	local0
)

(instance weaponTalker of GloryTalker
	(properties
		x 200
		y 10
		view 326
		loop 1
		talkWidth 260
		back 57
		textX -175
		textY 165
		backColor 50
	)

	(method (init)
		(super init: weaponBust weaponEyes weaponMouth &rest)
	)
)

(instance weaponBust of View
	(properties
		nsTop 22
		nsLeft 30
		view 326
		loop 3
	)
)

(instance weaponMouth of Prop
	(properties
		nsTop 47
		nsLeft 38
		view 326
	)
)

(instance weaponEyes of Prop
	(properties
		nsTop 34
		nsLeft 37
		view 326
		loop 2
	)
)

(instance weaponVendor of Vendor
	(properties
		noun 1
	)

	(method (dispose)
		(= goods 0)
		(super dispose:)
	)

	(method (transact param1 param2)
		(= local0 self)
		(switch param1
			(0
				(proc47_3 param1 param2 local0)
				(gEgo solvePuzzle: 227 2 get: 2 param2) ; theFineDagger
				(SetFlag 166)
				(gMessager say: 1 6 10 0 self)
			)
			(1
				(proc47_3 param1 param2 local0)
				(gEgo get: 10 param2) ; theDaggers
				(gMessager say: 1 6 10 0 self)
			)
			(2
				(proc47_3 param1 param2 local0)
				(gEgo solvePuzzle: 222 2 get: 3 param2) ; theFineSpear
				(SetFlag 167)
				(gMessager say: 1 6 10 0 self)
			)
			(3
				(proc47_3 param1 param2 local0)
				(gEgo get: 1 param2) ; theSword
				(gMessager say: 1 6 10 0 self)
			)
		)
	)

	(method (doBargain param1)
		(switch param1
			(1
				(gMessager say: 1 6 11 0 self)
			)
			(2
				(gMessager say: 1 6 14 0 self)
			)
			(3
				(gMessager say: 1 6 15 0 self)
			)
			(4
				(gMessager say: 1 6 16 0 self)
			)
			(5
				(gMessager say: 1 6 12 0 self)
			)
			(6
				(gMessager say: 1 6 13 0 self)
			)
			(else
				(self cue:)
			)
		)
	)
)

