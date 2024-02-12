;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use TargFeature)
(use DeathIcon)
(use Polygon)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	barrows 0
)

(local
	local0
	local1
	local2
	local3
)

(instance barrows of Rgn
	(properties)

	(method (init)
		(SetFlag 35)
		(if (and (!= (gLongSong number:) 556) (!= (gLongSong number:) 557))
			(gLongSong number: 556 setLoop: 1 play: (ScriptID 50)) ; forest
		)
		(= global366 0)
		(= gCombatMonsterNum 850) ; wraith
		(mound posn: 180 140 init: approachVerbs: 4) ; Do
		(if
			(and
				(or gNight (and (== gCombatMonsterNum 850) (== gPrevRoomNum 810))) ; wraith, combat
				(not (IsFlag 66))
			)
			(if (== gPrevRoomNum 810) ; combat
				(= local0 1)
				(if (< (gEgo x:) (mound x:))
					(gEgo x: (- (- (mound x:) 30) 1) y: 135 setHeading: 270)
				else
					(gEgo x: (+ (mound x:) 30 1) y: 135 setHeading: 90)
				)
				(switch gCombatResult
					(1
						(gCurRoom setScript: (ScriptID 50 2)) ; egoDies
					)
					(2
						(wraith setScript: monsterDies)
					)
					(3
						(if (< (gEgo x:) (mound x:))
							(gEgo x: (- (mound x:) 100))
						else
							(gEgo x: (+ (mound x:) 100))
						)
						(sWrithe start: 4)
						(wraith cel: (wraith lastCel:) init: setScript: sWrithe)
						(gGlory handsOn:)
					)
				)
			else
				(wraith posn: (mound x:) (mound y:) init: hide:)
				(if (== gCurRoomNum 575)
					(= global156 400)
				else
					(= global156 300)
				)
				((ScriptID 50 1) caller: wraith) ; enterRoomScr
			)
		)
		(super init: &rest)
		(if (!= gPrevRoomNum 810) ; combat
			(SetFlag 380)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (!= newRoomNumber 810) (== gCombatMonsterNum 850)) ; combat, wraith
			(= gCombatMonsterNum 0)
		)
		(if (== newRoomNumber 810) ; combat
			(gLongSong client: 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(ClearFlag 66)
		(ClearFlag 65)
		(ClearFlag 35)
		(super dispose: &rest)
	)
)

(instance mound of Prop
	(properties
		noun 2
		approachY 140
		view 854
		signal 24576
	)

	(method (init)
		(self approachX: 145)
		(super init: &rest)
		(SetNowSeen self)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init:
						(- nsLeft 5)
						(- nsBottom 5)
						(+ nsRight 5)
						(- nsBottom 5)
						(+ nsRight 5)
						nsBottom
						(- nsLeft 5)
						nsBottom
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(gGlory handsOff:)
				(if (gCast contains: wraith)
					(= gCombatMonsterNum 850) ; wraith
					(gCurRoom newRoom: 810) ; combat
				else
					(gCurRoom setScript: sSearch)
				)
			)
			((Message msgSIZE 53 noun theVerb 0 1)
				(gMessager say: noun theVerb 0 0 0 53)
			)
			(else
				((ScriptID 50) doVerb: theVerb) ; forest
			)
		)
	)
)

(instance spark of Prop
	(properties
		x 180
		y 140
		view 854
		loop 1
	)

	(method (doVerb theVerb)
		((ScriptID 50) doVerb: theVerb) ; forest
	)
)

(instance wraith of TargProp
	(properties
		noun 3
		view 850
		signal 20481
	)

	(method (init)
		(super init: &rest)
		(= x (mound x:))
		(= y (mound y:))
	)

	(method (cue)
		(gCurRoom setScript: sStartWraith)
	)

	(method (doVerb theVerb)
		(if (Message msgSIZE 53 noun theVerb 0 1)
			(gMessager say: noun theVerb 0 0 0 53)
		else
			((ScriptID 50) doVerb: theVerb) ; forest
		)
	)

	(method (doit)
		(if (> global156 0)
			(if (and (not local0) (< (gEgo distanceTo: self 65) 110))
				(= local0 1)
				(sWrithe start: 0)
				(self setScript: sWrithe)
			)
			(if local0
				(if (> (++ local2) 5)
					(= local2 0)
					(gEgo takeDamage: 1)
				)
				(cond
					((< (gEgo x:) 160)
						(cond
							((== loop 4)
								(wraith setLoop: 5 1)
							)
							((== loop 2)
								(wraith setLoop: 3 1)
							)
						)
					)
					((> (gEgo x:) 160)
						(cond
							((== loop 5)
								(wraith setLoop: 4 1)
							)
							((== loop 3)
								(wraith setLoop: 2 1)
							)
						)
					)
					((< (gEgo y:) 130)
						(cond
							((== loop 3)
								(wraith setLoop: 5 1)
							)
							((== loop 2)
								(wraith setLoop: 4 1)
							)
						)
					)
					((== loop 5)
						(wraith setLoop: 3 1)
					)
					((== loop 4)
						(wraith setLoop: 2 1)
					)
				)
			)
			(if (< (gEgo distanceTo: self 65) 30)
				(= gCombatMonsterNum 850) ; wraith
				(gCurRoom newRoom: 810) ; combat
			)
		)
		(super doit: &rest)
	)

	(method (getHurt param1 param2)
		(if
			(and
				(!= param1 37)
				(!= param1 21)
				(!= param1 79)
				(!= script monsterDies)
				(not local3)
				(<= (-= global156 (/ param2 2)) 0)
			)
			(= local3 1)
			(self setScript: monsterDies)
		)
	)
)

(instance wraithEffect of Actor
	(properties
		fixPriority 1
		view 21
		signal 28673
	)

	(method (init)
		(self
			setPri: (+ (wraith priority:) 1)
			setMotion:
				MoveTo
				(gEgo x:)
				(- (- (gEgo y:) (/ (gEgo scaleY:) 4)) (gEgo z:))
				self
		)
		(wraithFX number: (if (== (sWrithe register:) 1) 974 else 983) play:)
		(super init: &rest)
		(SetNowSeen self)
	)

	(method (doit)
		(super doit: &rest)
		(if (> y (wraith y:))
			(self setPri: y)
		else
			(self setPri: (+ (wraith priority:) 1))
		)
	)

	(method (cue &tmp temp0)
		(if (or (== loop 4) (== loop 13))
			(if (gEgo onMe: x y)
				(= temp0
					(*
						(if (== (sWrithe register:) 1) 12 else 16)
						(switch gCurRoomNum
							(566 1)
							(567 1)
							(576 2)
							(575 4)
							(590 3)
							(else 1)
						)
					)
				)
				(if global453
					(/= temp0 2)
				)
				(if global454
					(= temp0 (/ (* temp0 (- 100 (/ [gEgoStats 39] 7))) 100)) ; resistanceSpell
				)
				(if (and (not (IsFlag 8)) (not (gEgo takeDamage: temp0)))
					(EgoDead 16 53) ; "The Wraith has sucked your life force right out of you. Should you return here (in another life), you will need to be properly protected and strike quickly."
				)
			)
			(self
				setLoop: (if (== loop 4) 10 else 14) 1
				setCel: 0
				setCycle: End self
			)
		else
			(if (not local3)
				(sWrithe changeState: 4)
			)
			(self dispose:)
		)
	)

	(method (doVerb theVerb)
		((ScriptID 50) doVerb: theVerb) ; forest
	)
)

(instance sStartWraith of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 1 6 7 0 self 53) ; "You feel a chill go through you as you enter this part of the forest as if a cold wind suddenly sprang up from nowhere."
			)
			(1
				(if (and (== gHeroType 3) (< [gEgoStats 14] 50)) ; Paladin, honor
					(gMessager say: 1 6 8 0 self 53) ; "Your Paladin "Danger Sense" alerts you. That shadowy figure intends to harm you!"
				else
					(self cue:)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWrithe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gCurRoom script:))
					(gEgo setMotion: 0)
				)
				(spark init: x: 180 y: 140 ignoreActors: setCycle: End self)
			)
			(1
				(spark setLoop: 2 1 setCel: 0 setCycle: End self)
			)
			(2
				(spark dispose:)
				(mound signal: (| (mound signal:) $0001) setCycle: End self)
			)
			(3
				(mound signal: (& (mound signal:) $fffe))
				(wraith
					x: 180
					show:
					setLoop: (if (< (gEgo x:) 160) 1 else 0) 1
					setCel: 0
					setCycle: End self
				)
			)
			(4
				(wraith
					cycleSpeed: 8
					setLoop:
						(cond
							((< (gEgo x:) 160)
								(if (< (gEgo y:) 130) 5 else 3)
							)
							((< (gEgo y:) 130) 4)
							(else 2)
						)
						1
					setCycle: Fwd
				)
				(= cycles (Random 5 15))
			)
			(5
				(if (< (Random 0 100) 75)
					(= register 1)
				else
					(= register 0)
				)
				(wraithEffect
					moveSpeed: 0
					setStep: 8 5
					x:
						(if (mod (wraith loop:) 2)
							(- (wraith x:) 20)
						else
							(+ (wraith x:) 20)
						)
					y: (- (wraith y:) 53)
					illegalBits: 0
					setLoop: (if register 4 else 13) 1
					setCycle: Fwd
					ignoreActors:
					init:
				)
			)
		)
	)
)

(instance monsterDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (not (gCast contains: wraith))
					(wraith init:)
				)
				(wraith
					signal: (| (wraith signal:) $0001)
					view: 850
					setLoop: (if (mod (wraith loop:) 2) 1 else 0) 1
					setCel: 13
					setCycle: Beg self
				)
				(mound signal: (| (mound signal:) $0001) setCycle: Beg self)
			)
			(1
				(wraithFX number: 853 play:)
			)
			(2
				(mound signal: (& (mound signal:) $fffe))
				(wraith signal: (& (wraith signal:) $fffe))
				(switch gCurRoomNum
					(566
						(SetFlag 60)
						(gEgo solvePuzzle: 488 2 1 addHonor: 25)
					)
					(567
						(SetFlag 61)
						(gEgo solvePuzzle: 488 2 1 addHonor: 25)
					)
					(575
						(SetFlag 62)
						(gEgo
							solvePuzzle: 479 15 1
							solvePuzzle: 516 6 4
							solvePuzzle: 528 15 8
							addHonor: 150
						)
					)
					(576
						(SetFlag 63)
						(gEgo solvePuzzle: 488 2 1 addHonor: 25)
					)
					(590
						(SetFlag 64)
						(gEgo solvePuzzle: 488 2 1 addHonor: 25)
					)
				)
				(gMessager say: 3 6 12 0 self 53) ; "The Wraith vanishes into nothingness and the air slowly begins to regain some warmth."
			)
			(3
				(wraith dispose:)
				(= gCombatMonsterNum 0)
				(= global366 0)
				(SetFlag 66)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSearch of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(cond
					((> (gEgo y:) (mound y:))
						(if (> (gEgo x:) (mound x:))
							(= temp0 1)
						else
							(= temp0 0)
						)
					)
					((> (gEgo x:) (mound x:))
						(= temp0 3)
					)
					(else
						(= temp0 2)
					)
				)
				(= temp1 (gEgo loop:))
				(= local1 (gEgo cycleSpeed:))
				(gEgo
					view: 4
					setCel: 0
					setLoop: temp0 1
					cycleSpeed: global433
					setCycle: End self
				)
			)
			(1
				(if
					(switch gCurRoomNum
						(566
							(IsFlag 55)
						)
						(567
							(IsFlag 56)
						)
						(575
							(IsFlag 57)
						)
						(576
							(IsFlag 58)
						)
						(590
							(IsFlag 59)
						)
					)
					(gMessager say: 2 4 10 0 self 53) ; "You find nothing else of interest or value in the barrow."
					(++ state)
				else
					(gMessager say: 2 4 11 0 self 53) ; "The barrow contains treasure that the Wraith collected while it was alive (or perhaps more recently from treasure seekers less fortunate than you):"
				)
			)
			(2
				(switch gCurRoomNum
					(566
						(gMessager say: 1 6 2 0 self 53) ; "You find a dagger, 38 gold Crowns, 75 Kopeks, and a few old bones."
					)
					(567
						(gMessager say: 1 6 1 0 self 53) ; "You find a jewel-studded tiara, 6 gold Crowns, 40 Kopeks, and a few old bones!"
					)
					(575
						(switch gHeroType
							(0 ; Fighter
								(gMessager say: 1 6 13 0 self 53) ; "You find a well-crafted battle axe and 150 gold Crowns! The battle axe feels like a superior weapon in your hands."
							)
							(1 ; Magic User
								(gMessager say: 1 6 15 0 self 53) ; "You find a hoard of 150 gold Crowns. That should improve your cash flow!"
							)
							(2 ; Thief
								(gMessager say: 1 6 14 0 self 53) ; "You find a hoard of 150 gold Crowns and a scroll with mysterious letters that seem to writhe and shift under your gaze. At the top is a stylized heart symbol. A few drops of ink under it remind you of dried blood."
							)
							(3 ; Paladin
								(gMessager say: 1 6 5 0 self 53) ; "You find a well-crafted sword and 150 gold Crowns! As you pick up the sword, you feel a sensation of strength and power. It's magical!"
							)
						)
					)
					(576
						(gMessager say: 1 6 3 0 self 53) ; "You find a diamond-studded brooch, a healing potion, and 15 gold Crowns!"
					)
					(590
						(gMessager say: 1 6 4 0 self 53) ; "You find a suit of platemail armor, a pearl-encrusted goblet, and 25 gold Crowns!"
					)
				)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(SetFlag 65)
				(switch gCurRoomNum
					(566
						(if (not (IsFlag 55))
							(SetFlag 55)
							(gEgo get: 5 1 get: 0 38 get: 29 1) ; theThrowdagger, thePurse, theBones
							(+= global395 75)
						)
					)
					(567
						(if (not (IsFlag 56))
							(SetFlag 56)
							(gEgo get: 45 1 get: 29 1 get: 0 6) ; theJewelry, theBones, thePurse
							(+= global395 40)
						)
					)
					(575
						(if (not (IsFlag 57))
							(SetFlag 57)
							(switch gHeroType
								(0 ; Fighter
									((gInventory at: 19) state: 2) ; theSword
									(if (not (gEgo has: 19)) ; theSword
										(gEgo get: 19 1) ; theSword
									)
									(gEgo get: 0 150 get: 56) ; thePurse, theHeartRit
								)
								(1 ; Magic User
									(gEgo get: 0 150) ; thePurse
								)
								(2 ; Thief
									(gEgo get: 0 150 get: 56) ; thePurse, theHeartRit
								)
								(3 ; Paladin
									((gInventory at: 19) state: 3) ; theSword
									(if (not (gEgo has: 19)) ; theSword
										(gEgo get: 19 1) ; theSword
									)
									(gEgo get: 0 150 get: 56) ; thePurse, theHeartRit
								)
							)
						)
					)
					(576
						(if (not (IsFlag 58))
							(SetFlag 58)
							(gEgo get: 0 15 get: 45 1 get: 3 1) ; thePurse, theJewelry, theHeals
						)
					)
					(590
						(if (not (IsFlag 59))
							(SetFlag 59)
							(gEgo get: 0 25 get: 45 1) ; thePurse, theJewelry
							(or (== gHeroType 3) (== gHeroType 0)) ; Paladin, Fighter
							((gInventory at: 17) state: 1) ; theArmor
							(if (not (gEgo has: 17)) ; theArmor
								(gEgo get: 17 1) ; theArmor
							)
						)
					)
				)
				(gEgo setSpeed: local1 normalize: 4)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance wraithFX of Sound
	(properties)
)

