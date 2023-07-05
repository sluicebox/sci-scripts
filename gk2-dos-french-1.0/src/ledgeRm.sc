;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 570)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Actor)

(public
	ledgeRm 0
)

(local
	local0
)

(instance ledgeRm of ExitRoom ; "Hunting Lodge: Bedroom Ledge"
	(properties
		modNum 570
		noun 1
		picture 5701
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 546) ; vzWRm
			(fVonZellWindow init:)
			(= local0 4)
			(fEastSide init:)
			(PlayScene 674)
			(vEgo
				view: 5701
				cel: 0
				setLoop: 0 1
				posn: 346 153
				setScale: 0
				init:
			)
		else
			(= local0 2)
			(fWestSide init:)
			(PlayScene 673)
			(fPriessWindow init:)
			(vEgo
				view: 5701
				cel: 0
				setLoop: 1 1
				posn: 532 125
				setScale: 0
				init:
			)
		)
	)
)

(instance fEastSide of ExitFeature
	(properties
		sightAngle 360
		sceneNum 1675
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 355 1 616 0 615 335 354 338)
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb)
		(= local0 2)
		(vEgo view: 5701 cel: 0 setLoop: 1 1 posn: 532 125)
		(fPriessWindow init:)
		(fWestSide init:)
		(self dispose:)
	)

	(method (setCursor param1)
		(param1 view: 999)
		(param1 loop: 5)
		(param1 cel: 0)
	)
)

(instance fWestSide of ExitFeature
	(properties
		sightAngle 360
		sceneNum 675
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 0 -3 440 -1 440 332 0 331)
	)

	(method (doVerb theVerb)
		(super doVerb: theVerb)
		(= local0 4)
		(vEgo setLoop: 0 1 posn: 346 153)
		(fPriessWindow dispose:)
		(fVonZellWindow init:)
		(fEastSide init:)
		(self dispose:)
	)

	(method (setCursor param1)
		(param1 view: 999)
		(param1 loop: 4)
		(param1 cel: 0)
	)
)

(instance fPriessWindow of GKFeature
	(properties
		sightAngle 360
		sceneNum 676
		nextRoomNum 543 ; priessRm
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 468 96 562 95 568 174 465 172)
	)
)

(instance fVonZellWindow of GKFeature
	(properties
		sightAngle 360
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 254 87 346 90 347 178 252 178)
	)

	(method (doVerb theVerb)
		(if (== local0 2)
			(switch theVerb
				(62 ; Do
					(gMessager say: 4 62) ; "(LODGE ON LEDGE, CLICK ON VON ZELL'S WINDOW)Von Zell's room, if I'm not mistaken."
				)
				(22 ; invRope
					(gMessager say: 4 62) ; "(LODGE ON LEDGE, CLICK ON VON ZELL'S WINDOW)Von Zell's room, if I'm not mistaken."
				)
				(else
					(super doVerb: theVerb)
				)
			)
		else
			(switch theVerb
				(62 ; Do
					(PlayScene 677 0 56501) ; vzRm
				)
				(22 ; invRope
					(PlayScene 677 0 56501) ; vzRm
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance vEgo of View
	(properties
		x 346
		y 153
		view 5701
	)

	(method (doVerb)
		(gMessager say: 6 22 0 1 0 543) ; "(CLICK ROPE ON LEDGE TO CLIMB OUT)I hate it when I come up with ideas like this."
	)
)

