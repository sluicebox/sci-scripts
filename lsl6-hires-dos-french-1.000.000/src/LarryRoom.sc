;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use fileScr)
(use Game)
(use System)

(public
	LarryRoom 0
)

(class LarryRoom of Room
	(properties
		style 0
		horizon 80
		autoLoad 1
		showControls 0
		noControls 0
	)

	(method (doVerb theVerb)
		(cond
			((super doVerb: theVerb)
				(return 1)
			)
			(
				(and
					(not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
					(Message msgGET modNum noun 15 0 1)
				)
				(gMessager say: noun 15 0)
				(return 1)
			)
			((Message msgGET modNum noun 0 0 1)
				(gMessager say: noun 0 0)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (newRoom)
		(gGame handsOff:)
		(super newRoom: &rest)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: ((gUser alterEgo:) edgeHit:)))
				(self newRoom: temp0)
			)
		)
	)

	(method (dispose)
		(if global205
			(proc79_7)
		)
		(super dispose: &rest)
	)
)

