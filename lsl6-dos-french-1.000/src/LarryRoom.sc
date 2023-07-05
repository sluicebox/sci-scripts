;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 84)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	LarryRoom 0
)

(class LarryRoom of Rm
	(properties
		style 100
		horizon 80
		autoLoad 1
		showControls 0
		noControls 0
	)

	(method (init)
		(super init: &rest)
		(if autoLoad
			(if (== modNum -1)
				(= modNum gCurRoomNum)
			)
			(Load rsMESSAGE modNum)
			(Lock rsMESSAGE modNum 1)
		)
	)

	(method (doVerb theVerb)
		(cond
			((super doVerb: theVerb)
				(return 1)
			)
			(
				(and
					(not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
					(Message msgGET modNum noun 15 case 1)
				)
				(gMessager say: noun 15 case)
				(return 1)
			)
			((Message msgGET modNum noun 0 case 1)
				(gMessager say: noun 0 case)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (drawPic &tmp temp0)
		(if noControls
			(DrawMenuBar 0)
			(SetPort 0 0 190 320 10 0)
		else
			(SetPort 0 0 139 320 10 0)
		)
		(super drawPic: &rest)
		(if
			(or
				showControls
				(and (not (gGame controlsVisible:)) (not noControls))
			)
			(gGame drawControls:)
		)
	)

	(method (newRoom)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(gGame handsOff:)
		(Lock rsMESSAGE modNum 0)
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
)

