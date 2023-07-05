;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2640)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm2640 0
)

(instance rm2640 of ExitRoom ; "Exotic Animal Kennel"
	(properties
		modNum 260
		noun 13
		picture 2641
		south 2602 ; rm2602
	)

	(method (init)
		(super init: &rest)
		(PlayScene 1590)
		(cond
			((IsFlag 652)
				(vCatGone init:)
				(fTags init:)
			)
			((IsFlag 653)
				(fCat init:)
				(fTags init:)
			)
			(else
				(vCatGone init:)
				(vStraw init:)
			)
		)
		(gGame handsOn:)
	)

	(method (dispose)
		(if (not (gEgo has: 55)) ; invWolfTags
			(PlayScene 2590)
		)
		(super dispose: &rest)
	)
)

(instance fCat of GKFeature
	(properties
		modNum 260
	)

	(method (init)
		(super init: &rest)
		(pBlink init:)
		(self
			createPoly:
				306
				163
				297
				132
				304
				105
				301
				80
				319
				90
				356
				89
				389
				77
				386
				124
				379
				160
				363
				178
				314
				178
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(62 ; Do
				(if (IsFlag 653)
					(gMessager say: 9 62 0 1 0 260) ; "That cat is just WAITING for me to stick my arm in there again."
				else
					(gMessager say: 8 62 0 1 0 260) ; "(TRY TO GET IN CAGE)It's a nice cage, but I'm not sure I wanna stick my hand in it."
				)
			)
			(87 ; invWurst
				(PlayScene 592)
				(SetFlag 652)
				(gEgo put: 49) ; invWurst
				(vCatGone init:)
				(self dispose:)
				(pBlink dispose:)
			)
			(else
				(gMessager say: 10 0 0 1 0 260) ; "(TRY TO GIVE CAT SOMETHING OTHER THAN WURST)I don't think "Morris" would be interested in that."
			)
		)
	)
)

(instance fTags of GKFeature
	(properties
		modNum 260
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 337 298 341 274 392 275 392 302)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 652)
				(gEgo get: 55) ; invWolfTags
				(PlayScene 593 0 2602) ; rm2602
			else
				(gMessager say: 11 62 0 1 0 260) ; "(LOOK AT TAGS -- CAN'T GET PAST CAT)There's something in there, but I can't tell what it is."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vCatGone of View
	(properties
		x 238
		y 199
		view 30590
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(if (IsFlag 652)
				(gMessager say: 4 62 0 1 0 260) ; "(CLICK ON LARGE CAT IN CAGE)I think I'll leave the cat alone."
			else
				(gMessager say: 5 62 1 1 0 260) ; "(LOOK AT DORN'S ANIMALS)These animals are filthy. hungry too. I'd like to put Dorn in one of these cages - and leave him there."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vStraw of View
	(properties
		modNum 260
		x 317
		y 416
		view 30590
		cel 1
	)

	(method (init)
		(super init: &rest)
		(self createPoly: 337 298 341 274 392 275 392 302)
	)

	(method (doVerb theVerb)
		(if (== theVerb 62) ; Do
			(SetFlag 653)
			(PlayScene 3590)
			(self dispose:)
			(fTags init:)
			(vCatGone dispose:)
			(fCat init:)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pBlink of Prop
	(properties
		x 275
		y 74
		view 30590
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self setScript: sBlink)
	)

	(method (doVerb theVerb)
		(fCat doVerb: theVerb)
	)
)

(instance sBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(pBlink cel: 0 setCycle: End self)
			)
			(1
				(= seconds (Random 1 5))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

