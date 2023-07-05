;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 542)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use FidgetScript)
(use Feature)
(use Cursor)
(use Motion)
(use Actor)
(use System)

(public
	klingRm 0
)

(instance klingRm of ExitRoom ; "Hunting Lodge: Klingmann's Room"
	(properties
		modNum 542
		noun 8
	)

	(method (init)
		(if (not (IsFlag 667))
			(= picture -1)
			(self setScript: sFirstEnter)
		else
			(= picture 54501)
		)
		(gEgo
			posn: 527 84
			setScale: 0
			view: 20631
			BAD_SELECTOR:
			init:
			setScript: (FidgetScript new:)
		)
		(super init: &rest)
		(fDoor init:)
		(fBathroom init:)
		(fShrank init:)
		(fWindow init:)
		(pKlingmann init: setScript: FidgetScript)
		(gGame handsOn:)
	)
)

(instance sFirstEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(SetFlag 667)
				(gCurRoom picture: 54501)
				(PlayScene 631 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance fDoor of GKFeature
	(properties
		approachX 547
		approachY 268
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 515 257 515 47 598 35 598 275)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(PlayScene 1631 0 530) ; hallRm
		else
			(super doVerb: &rest)
		)
	)
)

(instance fBathroom of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 90 249 90 18 174 32 174 239)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62) ; "(LODGE KLINGMANN'S BEDROOM, CLICK ON BATHROOM, CLOSET, ETC.)I can't snoop around too much. Klingmann's here."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fShrank of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 234 226 233 30 265 20 364 35 358 41 358 227 302 216)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 1 62) ; "(LODGE KLINGMANN'S BEDROOM, CLICK ON BATHROOM, CLOSET, ETC.)I can't snoop around too much. Klingmann's here."
		else
			(super doVerb: &rest)
		)
	)
)

(instance fWindow of GKFeature
	(properties)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 0 53 0 53 254 0 226)
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(gMessager say: 2 62) ; "(CLICK ON KLINGMANN'S BEDROOM WINDOW)He's got a window, just like my room."
		else
			(super doVerb: &rest)
		)
	)
)

(instance pKlingmann of Prop
	(properties
		sightAngle 360
		x 36
		y 204
		view 20633
	)

	(method (handleEvent event)
		(if (self onMe: event)
			(= global141 self)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(gMessager say: 4 62) ; "(TRY TO TALK TO KLINGMANN BEFORE SHOWING HIM TAGS, SLY, DARK)I wouldn't mind a chat, but Klingmann needs a little attitude adjustment first."
			)
			(90 ; invWolfTags
				(if (IsFlag 330)
					(gUser BAD_SELECTOR: 62)
					(GKHotCursor update:)
					(SetFlag 657)
					(PlayScene 635 0 530) ; hallRm
				else
					(gMessager say: 5 62) ; "(TRY TO SHOW TAGS TO KLINGMANN BEFORE TALKING TO HENNEMANN)I'd love to show him the tags, but I need to get just a few more facts first."
				)
			)
			(22 ; invRope
				(gMessager say: 7 62) ; "(TRY TO USE ROPE ON KLINGMANN, CH 5)I COULD tie him up, but I'm not sure what that would accomplish."
			)
			(else
				(gMessager say: 6 62) ; "(TRY OTHER INVENTORY ITEMS ON KLINGMANN)I don't think showin' THAT to Klingmann would do any good."
			)
		)
	)
)

(instance sFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo cel: 0 setCycle: End)
				(= seconds (Random 8 16))
			)
			(1
				(self init:)
			)
		)
	)
)

(instance sKlingmannFidget of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(pKlingmann cel: 0 setCycle: End)
				(= seconds (Random 2 10))
			)
			(2
				(self init:)
			)
		)
	)
)

