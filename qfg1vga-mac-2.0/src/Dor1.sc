;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 98)
(include sci.sh)
(use Main)
(use n814)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	Dor1 1
	Dor2 2
	Dor6 3
	lttleButton 5
	bhindDoor11 8
	theTrap1 13
	theTrap2 14
	theTrap3 15
	theFrontTrap 16
	bhindDoor7 19
	dor7 20
	arow 21
	dor12 24
	theGlobe 25
	ball2 30
	theHandle 31
	theHead 32
	Dor15 33
	Chain1 34
	Chain2 35
	PullChain 36
)

(instance Dor1 of Feature
	(properties
		noun 3
		modNum 98
		nsTop 47
		nsLeft 2
		nsBottom 104
		nsRight 18
	)
)

(instance Dor15 of Feature
	(properties
		noun 3
		modNum 98
		nsTop 45
		nsLeft 300
		nsBottom 105
		nsRight 318
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance Chain1 of Feature
	(properties
		noun 7
		modNum 98
		nsTop 49
		nsLeft 281
		nsBottom 84
		nsRight 294
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance Chain2 of Feature
	(properties
		noun 7
		modNum 98
		nsTop 51
		nsLeft 23
		nsBottom 85
		nsRight 37
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance Dor2 of Feature
	(properties
		noun 4
		modNum 98
		nsTop 1
		nsLeft 49
		nsBottom 51
		nsRight 64
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance Dor6 of Feature
	(properties
		noun 3
		modNum 98
		nsTop 22
		nsLeft 87
		nsBottom 71
		nsRight 102
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lttleButton of Feature
	(properties
		noun 8
		modNum 98
		nsTop 59
		nsLeft 50
		nsBottom 87
		nsRight 66
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theHandle of Feature
	(properties
		x 238
		y 85
		nsTop 77
		nsLeft 212
		nsBottom 98
		nsRight 267
	)

	(method (handleEvent event)
		(if
			(and
				(== (gEgo script:) (ScriptID 96 3)) ; rollOut
				(< 69 (gEgo y:) 99)
				(< ((ScriptID 96 3) state:) 7) ; rollOut
			)
			((ScriptID 96 3) changeState: 7) ; rollOut
		)
		(event claimed: 1)
	)
)

(instance bhindDoor11 of View
	(properties
		x 211
		y 62
		noun 2
		modNum 98
		view 291
		loop 11
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theTrap1 of Prop
	(properties
		x 46
		y 93
		noun 11
		modNum 98
		view 296
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theTrap2 of Prop
	(properties
		x 305
		y 148
		noun 11
		modNum 98
		view 296
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theTrap3 of Prop
	(properties
		x 107
		y 125
		noun 11
		modNum 98
		view 296
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theFrontTrap of Prop
	(properties
		x 305
		y 148
		noun 11
		modNum 98
		view 296
		loop 10
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bhindDoor7 of Prop
	(properties
		x 111
		y 66
		view 96
		loop 2
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		)
		(return
			(switch theVerb
				(4 ; Do
					(if (== (gEgo onControl: 1) 4096)
						(if (IsFlag 264)
							(gEgo setScript: (ScriptID 96 1)) ; finalExit
						)
					else
						(gMessager say: 5 4 0 0 0 98) ; "You're not close enough."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance dor7 of Prop
	(properties
		x 133
		y 68
		noun 5
		modNum 98
		view 96
		loop 1
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		)
		(return
			(switch theVerb
				(4 ; Do
					(if (== (gEgo onControl: 1) 4096)
						(if (IsFlag 264)
							(gEgo setScript: (ScriptID 96 1)) ; finalExit
						else
							(dor7 setScript: (ScriptID 96 2)) ; doorFall
						)
					else
						(gMessager say: 5 4 0 0 0 98) ; "You're not close enough."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance arow of Prop
	(properties
		x 160
		y 62
		noun 1
		modNum 98
		view 96
		loop 3
		cel 12
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance dor12 of Prop
	(properties
		x 260
		y 58
		noun 6
		modNum 98
		view 290
		loop 6
	)

	(method (init)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theGlobe of Prop
	(properties
		x 156
		y 1
		noun 10
		modNum 98
		view 291
		loop 8
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gCurRoom doVerb: theVerb &rest)
			(return 1)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance ball2 of Actor
	(properties
		view 291
		loop 8
	)
)

(instance theHead of Prop
	(properties
		x 157
		y 50
		view 297
		loop 6
		cel 1
	)

	(method (doit &tmp temp0)
		(= temp0
			(GetAngle
				((ScriptID 96 5) x:) ; yorick
				((ScriptID 96 5) y:) ; yorick
				(gEgo x:)
				(gEgo y:)
			)
		)
		(if (and (== (theHead loop:) 6) (!= (theHead cel:) 3))
			(cond
				((< temp0 135)
					(if (!= (theHead cel:) 2)
						(theHead setCel: 2)
					)
				)
				((< temp0 225)
					(if (!= (theHead cel:) 1)
						(theHead setCel: 1)
					)
				)
				((!= (theHead cel:) 0)
					(theHead setCel: 0)
				)
			)
		)
		(super doit:)
	)
)

(instance PullChain of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 298
					loop: 2
					cel: 0
					cycleSpeed: 6
					posn: 57 47
					setCycle: End self
				)
			)
			(2
				(gEgo loop: 3 cel: 0)
				((ScriptID 96 6) setCel: 1) ; chain
				(= ticks 30)
			)
			(3
				(gEgo loop: 2 cel: 2)
				((ScriptID 96 6) setCel: 0) ; chain
				(= ticks 30)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(NormalEgo)
				(gEgo loop: 0)
				(if (not (IsFlag 259))
					(SetFlag 259)
					(theHead dispose:)
					((ScriptID 96 5) setLoop: 5) ; yorick
				)
				(if (not (client cel:))
					(client setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

