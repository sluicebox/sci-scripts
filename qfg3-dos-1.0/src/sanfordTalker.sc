;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 246)
(include sci.sh)
(use Main)
(use Vendor)
(use GloryTalker)
(use Actor)

(public
	sanfordTalker 0
	sonTalker 1
	sanfordVendor 2
)

(local
	local0
)

(instance sanfordTalker of GloryTalker
	(properties
		x 10
		y 15
		view 243
		loop 1
		talkWidth 260
		back 57
		textX 15
		textY 95
		backColor 10
	)

	(method (init)
		(super init: sanfordBust sanfordEyes sanfordMouth &rest)
	)
)

(instance sanfordBust of View
	(properties
		view 243
		loop 1
	)
)

(instance sanfordMouth of Prop
	(properties
		nsTop 52
		nsLeft 42
		view 243
	)
)

(instance sanfordEyes of Prop
	(properties
		nsTop 38
		nsLeft 43
		view 243
		loop 2
	)
)

(instance sonTalker of GloryTalker
	(properties
		x 10
		y 15
		view 245
		loop 1
		talkWidth 260
		back 57
		textX 15
		textY 95
		backColor 10
	)

	(method (init)
		(super init: sonBust sonEyes sonMouth &rest)
	)
)

(instance sonBust of View
	(properties
		view 245
		loop 1
	)
)

(instance sonMouth of Prop
	(properties
		nsTop 49
		nsLeft 42
		view 245
	)
)

(instance sonEyes of Prop
	(properties
		nsTop 35
		nsLeft 39
		view 245
		loop 2
	)
)

(instance sanfordVendor of Vendor
	(properties
		noun 7
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
				(gEgo solvePuzzle: 225 3 get: 9 param2) ; theTinderbox
				(gMessager say: 7 6 10 0 self) ; "You are always welcome back if you want to buy something."
			)
			(1
				(proc47_3 param1 param2 local0)
				(gEgo solvePuzzle: 226 5 4 get: 33 param2) ; theBird
				(SetFlag 147)
				(gMessager say: 6 6 10 0 self) ; "Thanks for stopping by."
			)
		)
	)

	(method (doBargain param1 param2)
		(if param2
			(switch param1
				(1
					(gMessager say: 6 6 11 0 self) ; "That's it. You got the blackbird."
				)
				(2
					(gMessager say: 6 6 14 0 self)
				)
				(3
					(gMessager say: 6 6 15 0 self)
				)
				(4
					(gMessager say: 6 6 16 0 self) ; "You've got to be kidding. This is the only blackbird in this part of East Fricana. You won't be able to buy it anywhere. At least, not at the prices you are offering."
				)
				(5
					(gMessager say: 6 6 12 0 self)
				)
				(6
					(gMessager say: 6 6 13 0 self) ; "Are you crazy? You are insulting my integrity with this offer."
				)
				(else
					(self cue:)
				)
			)
		else
			(switch param1
				(1
					(gMessager say: 7 6 11 0 self) ; "Okay, it's a deal."
				)
				(2
					(gMessager say: 7 6 14 0 self) ; "You have got to be kidding! For this genuine, guaranteed no money back antique, I can't accept less than 200 commons."
				)
				(3
					(gMessager say: 7 6 15 0 self)
				)
				(4
					(gMessager say: 7 6 16 0 self)
				)
				(5
					(gMessager say: 7 6 12 0 self) ; "I guess we can't make a deal, then."
				)
				(6
					(gMessager say: 7 6 13 0 self) ; "How dare you insult our integrity by implying that tinderbox is worthless? Son, you aren't the only dummy around here."
				)
				(else
					(self cue:)
				)
			)
		)
	)
)

