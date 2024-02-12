;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 580)
(include sci.sh)
(use Main)
(use GloryRm)
(use TargFeature)
(use Teller)
(use DeathIcon)
(use forest)
(use GloryTalker)
(use Interface)
(use Str)
(use PolyPath)
(use Polygon)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm580 0
	queenTalker 1
)

(local
	local0
	local1
	local2 = 300
	local3 = 100
	local4 = 100
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
)

(procedure (localproc_0)
	(= global438 0)
	(User canInput: 1 canControl: 0)
	(gTheIconBar disable: 0 4)
	(gTheIconBar enable: 1 2 3 5 6 7 8)
	(gTheIconBar curIcon: global204)
	(gGlory setCursor: (gTheIconBar getCursor:))
	(= global204 0)
	(if (not (gTheIconBar curInvIcon:))
		(gTheIconBar disable: 6)
	)
)

(instance rm580 of GloryRm
	(properties
		picture 410
		horizon 70
		north 440
		east 587
		south 581
		west 573
		topX 181
		rightY 135
	)

	(method (init)
		(= local1 (gEgo moveSpeed:))
		(if (and (== gHeroType 1) gNight (not gCombatMonsterNum)) ; Magic User
			(switch global439
				(1
					(= local2 200)
					(= local3 75)
					(= local4 75)
				)
				(2
					(= local2 300)
					(= local3 100)
					(= local4 100)
				)
				(3
					(= local2 500)
					(= local3 200)
					(= local4 200)
				)
			)
			(cond
				(gDebugging
					(= local0 (GetNumber {Fairy Event? (1 - 3)}))
					(SetFlag 35)
				)
				((not (IsFlag 269))
					(= local0 1)
					(SetFlag 35)
				)
				(
					(and
						(IsFlag 269)
						[gEgoStats 34] ; frostSpell
						[gEgoStats 40] ; glideSpell
						[gEgoStats 38] ; protectionSpell
						[gEgoStats 36] ; invisibilitySpell
						[gEgoStats 37] ; auraSpell
						(not (IsFlag 364))
					)
					(= local0 2)
					(SetFlag 35)
				)
				(
					(and
						(not (IsFlag 365))
						(IsFlag 364)
						(IsFlag 450)
						(!= gPrevRoomNum 440)
						(!= gPrevRoomNum 587)
						[gEgoStats 34] ; frostSpell
						[gEgoStats 35] ; ritualOfReleaseSpell
						[gEgoStats 40] ; glideSpell
						[gEgoStats 38] ; protectionSpell
						[gEgoStats 36] ; invisibilitySpell
						[gEgoStats 37] ; auraSpell
					)
					(SetFlag 365)
					(= local0 3)
					(SetFlag 35)
				)
			)
			(if local0
				(RemapColors 2 253 140) ; ByPercent
				(gLongSong number: 580 setLoop: -1 play:)
			)
			(switch local0
				(1
					(fountain init: approachVerbs: 4) ; Do
					(fountainTeller init: fountain 580 15 4 4)
					((ScriptID 50 1) caller: self) ; enterRoomScr
				)
				(2
					(aStaff
						init:
						cel: 11
						signal: (| (aStaff signal:) $0001)
						approachVerbs: 4 ; Do
					)
				)
				(3
					((ScriptID 50 1) caller: self) ; enterRoomScr
				)
			)
		)
		(self setRegions: 50) ; forest
		(super init: &rest)
		(if (== local0 1)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 150 189 167 177 206 166 206 145 319 145
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 122 255 122 201 93 238 72 238 0 319 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 109 0 109 72 159 80 159 94 99 109 115 131 0 131 0 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 147 107 209 107 209 117 147 117
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 319 189 150 189 167 177 206 166 206 145 319 145
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 319 122 255 122 201 93 238 72 238 0 319 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 109 0 109 72 159 80 159 94 99 109 115 131 0 131 0 0
						yourself:
					)
			)
			(if (== local0 2)
				(aStaff setScaler: gEgo)
			)
		)
		(atp1 init:)
		(atp2 init:)
		(atp4 init: setPri: 127)
		(atp5 init: setPri: 148)
		(if gNight
			(atp3Night init: setPri: 249)
		else
			(atp3 init:)
		)
		(if (or (IsFlag 380) (== local0 3))
			(gGlory save: 1)
		)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: 0 1 0) ; "You are in the forest somewhere southeast of the town. To the north you can see a beautiful garden and a gently-flowing stream."
			)
			(local0
				(cond
					((and (== local0 3) (OneOf theVerb 81 85 91 87 83)) ; detectMagicSpell, calmSpell, jugglingLightsSpell, fetchSpell, dazzleSpell
						(gMessager say: 14 6 13) ; "You find yourself magically trapped. Confusing thoughts swirl through your mind making it impossible to cast your spell."
					)
					((== theVerb 81) ; detectMagicSpell
						(gMessager say: 0 81 0) ; "You are definitely feeling something magical in this glade, but you can't seem to pinpoint the source."
					)
					((OneOf theVerb 4 80 82 94) ; Do, openSpell, triggerSpell, ritualSpell
						((ScriptID 50) doVerb: theVerb) ; forest
					)
					((OneOf theVerb 21 86 88 93 79) ; theRocks, flameDartSpell, forceBoltSpell, lightningBallSpell, frostSpell
						(if (== local0 3)
							(gCurRoom setScript: (ScriptID 32) self theVerb) ; project
						else
							((ScriptID 50) doVerb: theVerb) ; forest
						)
					)
					((== theVerb 37) ; theThrowdagger
						(if (== local0 3)
							(gCurRoom setScript: (ScriptID 32) self 37) ; project
						else
							((ScriptID 50) doVerb: theVerb) ; forest
						)
					)
					((== theVerb 83) ; dazzleSpell
						(gCurRoom setScript: (ScriptID 12) 0 83) ; castAreaScript
					)
					((== theVerb 87) ; fetchSpell
						(gCurRoom setScript: (ScriptID 37)) ; castFetchScript
					)
					((== theVerb 89) ; levitateSpell
						(if (== local0 3)
							(gMessager say: 14 6 31) ; "You can't move. The Faerie's spell has caused the grass to grow right over your feet!"
						else
							((ScriptID 50) doVerb: theVerb) ; forest
							(return 1)
						)
					)
					(else
						((ScriptID 50) doVerb: theVerb) ; forest
						(return 1)
					)
				)
			)
			(else
				((ScriptID 50) doVerb: theVerb) ; forest
				(return 1)
			)
		)
	)

	(method (cue)
		(if local6
			(if (== local0 3)
				(localproc_0)
			else
				(gGlory handsOn:)
			)
		else
			(= local6 1)
			(switch local0
				(1
					(if (not local10)
						(= local10 1)
						(fountain setScript: sStartFountain)
					)
				)
				(3
					(if (not local11)
						(= local11 1)
						(gCurRoom setScript: sEvent3)
					)
				)
				(2
					(if (gCast contains: aStaff)
						(gGlory handsOn:)
					)
				)
				(else
					(gGlory handsOn:)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(ClearFlag 9)
		(if local0
			(ClearFlag 35)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance aSound of Sound
	(properties)
)

(instance qReverseFX of Sound
	(properties)
)

(instance atp1 of ForestView
	(properties
		x 251
		y 7
		view 414
	)

	(method (doVerb theVerb)
		(if (and (== local0 3) (OneOf theVerb 37 21 86 88 93 79)) ; theThrowdagger, theRocks, flameDartSpell, forceBoltSpell, lightningBallSpell, frostSpell
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance atp2 of ForestView
	(properties
		x 155
		y 91
		view 415
		cel 5
	)

	(method (doVerb theVerb)
		(if (and (== local0 3) (OneOf theVerb 37 21 86 88 93 79)) ; theThrowdagger, theRocks, flameDartSpell, forceBoltSpell, lightningBallSpell, frostSpell
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance atp3 of ForestView
	(properties
		x 175
		y 167
		view 415
		cel 3
	)

	(method (doVerb theVerb)
		(if (and (== local0 3) (OneOf theVerb 37 21 86 88 93 79)) ; theThrowdagger, theRocks, flameDartSpell, forceBoltSpell, lightningBallSpell, frostSpell
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance atp4 of ForestView
	(properties
		x 71
		y 6
		view 414
		cel 5
	)

	(method (doVerb theVerb)
		(if (and (== local0 3) (OneOf theVerb 37 21 86 88 93 79)) ; theThrowdagger, theRocks, flameDartSpell, forceBoltSpell, lightningBallSpell, frostSpell
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance atp3Night of ForestView
	(properties
		x 232
		y 189
		view 418
		cel 2
	)

	(method (doVerb theVerb)
		(if (and (== local0 3) (OneOf theVerb 37 21 86 88 93 79)) ; theThrowdagger, theRocks, flameDartSpell, forceBoltSpell, lightningBallSpell, frostSpell
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance atp5 of ForestView
	(properties
		x 210
		y 119
		view 414
		cel 6
	)

	(method (doVerb theVerb)
		(if (and (== local0 3) (OneOf theVerb 37 21 86 88 93 79)) ; theThrowdagger, theRocks, flameDartSpell, forceBoltSpell, lightningBallSpell, frostSpell
			(gCurRoom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fountain of Prop
	(properties
		noun 4
		approachX 167
		approachY 111
		x 179
		y 115
		view 580
		signal 16384
	)

	(method (dispose)
		(fountainFX stop:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 4) ; Do
				(fountainTeller doVerb: theVerb)
			)
			((Message msgSIZE 580 4 theVerb 0 1)
				(super doVerb: theVerb)
			)
			(else
				((ScriptID 50) doVerb: theVerb) ; forest
			)
		)
	)
)

(instance water of Prop
	(properties
		approachX 167
		approachY 111
		x 189
		y 116
		z 31
		view 580
		loop 1
		signal 16384
	)

	(method (doVerb theVerb)
		(fountain doVerb: theVerb)
	)
)

(instance aStaff of TargActor
	(properties
		noun 5
		approachX 115
		approachY 170
		x 135
		y 170
		z 45
		view 585
		signal 16384
	)

	(method (cue)
		(gCurRoom setScript: sEvent2)
	)

	(method (getHurt)
		(self setScript: sStaffHurt)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sTouchStaff)
			)
			(87 ; fetchSpell
				(gCurRoom setScript: sMoveToFetch)
			)
			(-87 ; fetchSpell (part 2)
				(aStaff
					signal: (| (aStaff signal:) $0001)
					setStep: 6 6
					setCel: 11
					setMotion: MoveTo (gEgo x:) (gEgo y:)
				)
				((gCurRoom script:) caller: self)
			)
			(82 ; triggerSpell
				(proc0_12 (aStaff x:) (- (- (aStaff y:) 25) (aStaff z:)))
				(self setScript: (ScriptID 11) 0 self) ; castTriggerScript
			)
			(-82 ; triggerSpell (part 2)
				(gCurRoom setScript: sTriggerStaff)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class FairySpell of Actor
	(properties
		view 21
		signal 16385
		cuedOnce 0
		whichType 0
		curDamage 0
	)

	(method (cue)
		(if (not cuedOnce)
			(= cuedOnce 1)
			(self setScript: (sCheckLoop new:) self)
		else
			(if global454
				(gEgo takeDamage: 2)
			else
				(gEgo takeDamage: curDamage)
			)
			(if (<= [gEgoStats 17] 0) ; health
				(EgoDead 25 580 43 End) ; "Do we have to spell it out for you? Hostile magic can be harmful to your health! Maybe you'd do better if you had a staff of assistants like the Faerie Queen... or even if you used a staff to assist you."
			)
			(self setMotion: 0 dispose:)
		)
	)

	(method (init param1 param2 param3)
		(self
			cuedOnce: 0
			whichType: param1
			curDamage: param2
			x: (param3 x:)
			y: (- (param3 y:) 35)
			setStep: 8 5
			setLoop:
				(switch param1
					(88 0)
					(86 2)
					(93 4)
					(79 13)
				)
				1
			moveSpeed: 0
			setCycle: Fwd
			setMotion: MoveTo (gEgo x:) (- (gEgo y:) 40) self
		)
		(super init: &rest)
	)
)

(instance queenFairy of TargProp
	(properties
		noun 2
		x 169
		y 144
		view 450
		signal 20481
	)

	(method (doVerb theVerb)
		(if (Message msgSIZE 580 2 theVerb 0 1)
			(super doVerb: theVerb)
		else
			(gCurRoom doVerb: theVerb)
		)
	)

	(method (getHurt param1 param2)
		(cond
			((> local2 1000))
			((and (not local5) (OneOf param1 21 37 33))
				(gMessager say: 14 6 22) ; "That doesn't seem to affect the Faeries."
			)
			((== param1 79)
				(if (<= (-= local2 param2) 0)
					(= local2 3000)
					(gGlory handsOff:)
					(queenFairy setScript: 0)
					(gCurRoom setScript: sQueenDies)
				)
			)
			(else
				((FairySpell new:) init: param1 param2 self)
			)
		)
	)
)

(instance rightFairy of TargProp
	(properties
		noun 3
		x 202
		y 159
		view 450
		loop 1
		signal 20481
	)

	(method (cue)
		(self hide:)
	)

	(method (getHurt param1 param2)
		(cond
			((> local4 1000))
			((and (not local5) (OneOf param1 21 37 33))
				(gMessager say: 14 6 22) ; "That doesn't seem to affect the Faeries."
			)
			((and (-= local4 param2) (<= local4 0))
				(= local4 3000)
				(self
					setScript: 0
					view: 450
					setLoop: 1 1
					setCel: 15
					setCycle: Beg self
				)
			)
		)
	)
)

(instance leftFairy of TargProp
	(properties
		noun 3
		x 52
		y 166
		view 450
		loop 2
		signal 20481
	)

	(method (cue)
		(self hide:)
	)

	(method (getHurt param1 param2)
		(cond
			((> local3 1000))
			((and (not local5) (OneOf param1 21 37 33))
				(gMessager say: 14 6 22) ; "That doesn't seem to affect the Faeries."
			)
			((and (-= local3 param2) (<= local3 0))
				(= local3 3000)
				(self
					setScript: 0
					view: 450
					setLoop: 2 1
					setCel: 14
					setCycle: Beg self
				)
			)
		)
	)
)

(instance fountainTeller of Teller
	(properties
		actionVerb 4
	)

	(method (sayMessage)
		(cond
			((== iconValue 3) ; Take a Drink
				(self clean:)
				(gCurRoom setScript: sDrink 0 3)
			)
			((== iconValue 4) ; Taste the Water
				(self clean:)
				(gCurRoom setScript: sDrink 0 4)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance fountainFX of Sound
	(properties
		number 982
	)
)

(instance queenTalker of GloryTalker
	(properties
		x 168
		y 0
		talkWidth 130
		view 456
		textX -159
		textY 10
	)

	(method (init)
		(super init: queenMouth 0 queenEyes queenFrame &rest)
		(ear2 init:)
		(ear1 init:)
		(queenMouth setScript: sTwitchEm)
	)

	(method (dispose param1)
		(if (or (not argc) param1)
			(ear1 dispose:)
			(ear2 dispose:)
		)
		(super dispose: param1)
	)
)

(instance sTwitchEm of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self cue:)
			)
			(1
				(= seconds (Random 1 3))
			)
			(2
				(ear1 setCycle: End)
				(ear2 setCycle: End)
				(= seconds 1)
			)
			(3
				(ear1 setCycle: Beg)
				(ear2 setCycle: Beg)
				(= seconds 1)
			)
			(4
				(if (Random 0 1)
					(self changeState: 0)
				else
					(if (Random 0 1)
						(ear1 setCycle: End)
					else
						(ear2 setCycle: End)
					)
					(= seconds 1)
				)
			)
			(5
				(self changeState: 0)
			)
		)
	)
)

(instance queenFrame of View
	(properties
		x 168
		view 456
	)
)

(instance queenMouth of Prop
	(properties
		x 208
		y 63
		view 456
		loop 1
	)
)

(instance queenEyes of Prop
	(properties
		x 203
		y 42
		view 456
		loop 2
	)
)

(instance ear1 of Prop
	(properties
		x 194
		y 22
		view 456
		loop 3
	)
)

(instance ear2 of Prop
	(properties
		x 265
		y 22
		view 456
		loop 4
	)
)

(instance sStaffHurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= (aStaff cel:) 15)
					(aStaff
						signal: (| (aStaff signal:) $0001)
						setCel: 11
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(1
				(if (!= (aStaff cel:) 11)
					(aStaff
						signal: (| (aStaff signal:) $0001)
						setCycle: CT 11 -1 self
					)
				else
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sTriggerStaff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(aStaff
					signal: (| (aStaff signal:) $0001)
					setCel: 11
					setCycle: End self
				)
			)
			(1
				(aStaff setCycle: CT 11 -1 self)
			)
			(2
				(for ((= register 100)) (< register 1000) ((+= register 10))
					(Palette 2 0 255 register) ; PalIntensity
				)
				(for ((= register 500)) (> register 0) ((-= register 10))
					(Palette 2 0 255 register) ; PalIntensity
				)
				(aStaff setCycle: Beg self)
			)
			(3
				(aStaff dispose:)
				(gEgo learn: 35 100) ; ritualOfReleaseSpell
				(gMessager say: 2 6 11 0 self) ; "You are a very foolish creature. You must never use that spell on a true magical Staff. You could easily have destroyed yourself that way. Fortunately, this one is just a spell."
			)
			(4
				(for ((= register 0)) (< register 100) ((+= register 5))
					(Palette 2 0 255 register) ; PalIntensity
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sMoveToFetch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 364)
				(gEgo
					setMotion:
						PolyPath
						(aStaff approachX:)
						(aStaff approachY:)
						self
				)
			)
			(1
				((User curEvent:) x: (aStaff x:))
				((User curEvent:) y: (- (- (aStaff y:) 15) (aStaff z:)))
				(gCurRoom setScript: (ScriptID 37) aStaff aStaff) ; castFetchScript
			)
		)
	)
)

(instance sTouchStaff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 364)
				(gEgo
					view: 31
					setLoop: 0 1
					cycleSpeed: 6
					setCel: 0
					setCycle: End self
				)
			)
			(1
				(gMessager say: 5 4 0 0 self) ; "You reach for the glowing Staff."
			)
			(2
				(gCurRoom setScript: sEvent2)
			)
		)
	)
)

(instance sEvent2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(aStaff
					signal: (| (aStaff signal:) $0001)
					setCel: 15
					setCycle: Beg self
				)
				(gEgo normalize: 6)
			)
			(1
				(aStaff dispose:)
				(self setScript: sFaeriesAppear self)
			)
			(2
				(= ticks 120)
			)
			(3
				(gMessager say: 2 6 10 0 self) ; "You have been tempted by a mere illusion, but there is a true Staff in Mordavia -- the Staff of Erana."
			)
			(4
				(gEgo learn: 35 100) ; ritualOfReleaseSpell
				(self setScript: sFaeriesGo self)
			)
			(5
				(gEgo
					view: 6
					setLoop: 4 1
					setCel: 0
					cycleSpeed: global433
					setCycle: End self
				)
			)
			(6
				(= ticks 120)
			)
			(7
				(gEgo setLoop: 6 1 setCel: 0 setCycle: End self)
			)
			(8
				(gEgo normalize: 4 setSpeed: local1)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFaeriesGo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(leftFairy
					view: 450
					setLoop: 2 1
					setCel: 14
					setCycle: CT 5 -1 self
				)
			)
			(1
				(aSound number: 934 play:)
				(leftFairy setCycle: Beg)
				(rightFairy
					view: 450
					setLoop: 1 1
					setCel: 15
					setCycle: CT 5 -1 self
				)
			)
			(2
				(aSound number: 934 play:)
				(leftFairy dispose:)
				(rightFairy setCycle: Beg)
				(queenFairy
					view: 450
					setLoop: 0 1
					setCel: 15
					setCycle: Beg self
				)
			)
			(3
				(aSound number: 934 play:)
				(rightFairy dispose:)
				(queenFairy dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sFaeriesAppear of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(leftFairy init: setCycle: CT 10 1 self)
				(aSound number: 934 play:)
			)
			(1
				(gEgo setHeading: 270)
				(leftFairy setCycle: CT 14 1)
				(rightFairy init: setCycle: CT 10 1 self)
				(aSound number: 934 play:)
			)
			(2
				(gEgo setHeading: 90)
				(rightFairy setCycle: End)
				(queenFairy init: setCycle: CT 10 1 self)
				(aSound number: 934 play:)
			)
			(3
				(gEgo setHeading: 45)
				(queenFairy setCycle: End self)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance sStartFountain of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gCast contains: water))
					(water approachVerbs: 4 init:) ; Do
				)
				(water
					setLoop: 1 1
					setCel: 0
					signal: (| (water signal:) $0001)
					setCycle: End self
				)
			)
			(1
				(fountainFX setLoop: -1 play:)
				(water setCel: 0 setLoop: 2 1 setCycle: Fwd)
				(gMessager say: 14 6 2 0 self) ; "A beautiful fountain with sparkling, crystal clear water beckons to you. This area feels cooler than the rest of the forest."
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local1 (gEgo moveSpeed:))
				(gEgo
					view: 4
					setLoop: 2 1
					setCel: 0
					setSpeed: global433
					setCycle: End self
				)
			)
			(1
				(= ticks 120)
			)
			(2
				(gMessager say: 15 4 register 0 self)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(= ticks 60)
			)
			(5
				(gEgo
					view: 6
					x: (- (gEgo x:) 3)
					y: (- (gEgo y:) 2)
					setLoop: 1 1
					setCel: 0
					cycleSpeed: global433
					setCycle: End self
				)
				(water setLoop: 3 1 setCel: 0 setCycle: End self)
			)
			(6
				(water signal: (& (water signal:) $fffe))
				(fountainFX stop:)
			)
			(7
				(for ((= register 100)) (> register 0) ((-- register))
					(Palette 2 0 255 register) ; PalIntensity
				)
				(SetFlag 269)
				(if (>= global474 5)
					(gMessager say: 2 6 7 0 self) ; "This one has great magic. This one at last may well be he who shall gain the Staff. Let us go and prepare ourselves. We shall soon have that for which we have worked for all these many years!"
				else
					(gMessager say: 2 6 8 0 self) ; "There is power here, but it has much to learn. It will probably be killed before it can be of use. Still, there is much magic to learn in Mordavia. Perhaps it may yet serve our purposes."
				)
				(fountain dispose:)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 189 150 189 167 177 206 166 206 145 319 145
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 319 122 255 122 201 93 238 72 238 0 319 0
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 109 0 109 72 159 80 159 94 99 109 115 131 0 131 0 0
							yourself:
						)
				)
				(water dispose:)
			)
			(8
				(for ((= register 0)) (< register 100) ((++ register))
					(Palette 2 0 255 register) ; PalIntensity
				)
				(= ticks 60)
			)
			(9
				(gEgo setLoop: 3 1 setCel: 0 setCycle: End self)
			)
			(10
				(gMessager say: 14 6 9 0 self) ; "You awaken from the strange dream (or WAS it a dream?) feeling very dizzy and disoriented. Fortunately, the sensation passes in a few moments and you are back to normal."
			)
			(11
				(gLongSong number: 557 setLoop: -1 play:)
				(gEgo
					x: (- (gEgo x:) 8)
					y: (+ (gEgo y:) 5)
					setSpeed: local1
					normalize: 5
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEvent3 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 115 170 self)
			)
			(1
				(= cycles (+ (gEgo cycleSpeed:) 1))
			)
			(2
				(gMessager say: 14 6 12 0 self) ; "You have a very bad feeling. The air is full of hostile vibrations."
			)
			(3
				(= local1 (gEgo moveSpeed:))
				(gEgo setSpeed: global433)
				(self setScript: sFaeriesAppear self)
			)
			(4
				(leftFairy view: 451 setLoop: 2 1 setCel: 0 setCycle: End self)
				(aSound number: 940 play:)
			)
			(5
				(leftFairy setLoop: 5 1 setCycle: Fwd)
				(= local1 (gEgo moveSpeed:))
				(gEgo
					view: 581
					setLoop: 0 1
					setCel: 0
					setSpeed: global433
					setCycle: End self
				)
			)
			(6
				(aSound number: 940 play:)
				(rightFairy view: 451 setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(7
				(rightFairy setLoop: 4 1 setCycle: Fwd)
				(gEgo setLoop: 1 1 setCel: 0 setCycle: End self)
			)
			(8
				(aSound number: 940 play:)
				(queenFairy view: 451 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(9
				(queenFairy setLoop: 3 1 setCycle: Fwd)
				(leftFairy setLoop: 2 1 setCel: 9 setCycle: 0)
				(= cycles global433)
			)
			(10
				(leftFairy setCel: 1)
				(= cycles global433)
			)
			(11
				(rightFairy setLoop: 1 1 setCel: 9 setCycle: 0)
				(= cycles global433)
			)
			(12
				(rightFairy setCel: 0)
				(= cycles global433)
			)
			(13
				(queenFairy setLoop: 0 1 setCel: 5 setCycle: 0)
				(= cycles global433)
			)
			(14
				(queenFairy setCel: 0)
				(= ticks 120)
			)
			(15
				(gMessager say: 2 6 14 0 self) ; "The human has returned with the Staff. We shall finally gain what we have sought for so long."
			)
			(16
				(aSound number: 940 play:)
				(queenFairy setCycle: End self)
			)
			(17
				(aStaff
					signal: (| (aStaff signal:) $0001)
					init:
					x: (gEgo x:)
					y: (- (gEgo y:) 15)
					setCycle: End self
				)
				(queenFairy setLoop: 3 1 setCycle: Fwd)
			)
			(18
				(aStaff signal: (& (aStaff signal:) $fffe))
				(= ticks 60)
			)
			(19
				(gMessager say: 2 6 15 0 self) ; "Staff, hear my command! Thou shalt hear and obey my words. I am thy master now!"
			)
			(20
				(aSound number: 940 play:)
				(aStaff
					signal: (| (aStaff signal:) $0001)
					setCycle: CT 11 -1 self
				)
			)
			(21
				(aStaff signal: (& (aStaff signal:) $fffe))
				(= ticks 30)
			)
			(22
				(= [gEgoStats 17] (gEgo maxHealth:)) ; health
				(= [gEgoStats 18] (gEgo maxStamina:)) ; stamina
				(= [gEgoStats 19] (gEgo maxMana:)) ; mana
				(gMessager say: 14 6 18 0 self) ; "You feel an incredible rush of magical energy filling you. It tickles."
			)
			(23
				(aStaff signal: (| (aStaff signal:) $0001) setCycle: End self)
			)
			(24
				(aStaff signal: (& (aStaff signal:) $fffe))
				(queenFairy setLoop: 0 1 setCel: 0 setCycle: 0)
				(gEgo setLoop: 2 1 setCel: 0 setCycle: End self)
			)
			(25
				(gEgo normalize: 6)
				(gMessager say: 5 6 17 1 self) ; "You hear a voice in your head."
			)
			(26
				(= local8 (Str new:))
				(Message msgGET 580 5 6 29 1 (local8 data:)) ; "I am now the Staff of the Hero."
				(= local9 (Str new:))
				(local9 format: {%s} gHeroName)
				(local8 format: (local8 data:) local9)
				(if (& gMsgType $0001)
					(= local12 1)
				else
					(|= gMsgType $0001)
				)
				(if (& gMsgType $0002)
					(^= gMsgType $0002)
					(= local13 1)
				)
				(gNarrator say: local8 self)
			)
			(27
				(if (not local12)
					(^= gMsgType $0001)
				)
				(if local13
					(|= gMsgType $0002)
				)
				(local8 dispose:)
				(local9 dispose:)
				(gEgo learn: 32 200 learn: 39 100) ; summonStaffSpell, resistanceSpell
				(gMessager say: 5 6 30 1 self) ; "He is the hand of destiny, and shall restore the spirit of Erana."
			)
			(28
				(aStaff signal: (| (aStaff signal:) $0001) setCycle: Beg self)
			)
			(29
				(aStaff dispose:)
				(gMessager say: 2 6 16 0 self) ; "So, the human has claimed the Staff of Erana? Then by his death, the Staff shall be mine!"
			)
			(30
				(= ticks 60)
			)
			(31
				(queenFairy setScript: (sCastSpell new:) 0 0)
				(rightFairy setScript: (sCastSpell new:) 0 1)
				(leftFairy setScript: (sCastSpell new:) 0 2)
				(SetFlag 9)
				(gLongSong number: 581 setLoop: -1 play:)
				(localproc_0)
				(self dispose:)
			)
		)
	)
)

(instance sCheckLoop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch (client loop:)
					(0
						(client setLoop: 14 1 setMotion: 0 setCycle: End self)
						(qReverseFX number: 930 play:)
					)
					(2
						(client setLoop: 9 1 setMotion: 0 setCycle: End self)
						(qReverseFX number: 930 play:)
					)
					(4
						(client setLoop: 10 1 setMotion: 0 setCycle: End self)
					)
					(13
						(client setLoop: 14 1 setMotion: 0 setCycle: End self)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sQueenDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo normalize: 6)
				(queenFairy
					setScript: 0
					view: 450
					setLoop: 0 1
					setCel: 15
					setCycle: Beg self
				)
			)
			(1
				(queenFairy hide:)
				(gLongSong fade:)
				(theBall
					x: (queenFairy x:)
					y: (queenFairy y:)
					z: 30
					setCycle: Fwd
					init:
				)
				(if (< local4 1000)
					(= local4 3000)
					(rightFairy
						setScript: 0
						view: 450
						setLoop: 1 1
						setCel: 15
						setCycle: Beg rightFairy
					)
				)
				(if (< local3 1000)
					(= local3 3000)
					(leftFairy
						setScript: 0
						view: 450
						setLoop: 1 1
						setCel: 15
						setCycle: Beg leftFairy
					)
				)
				(= seconds 3)
			)
			(2
				(gMessager say: 5 6 26 0 self) ; "A voice sounds in your mind. "Hand of Destiny, you are now triumphant. She who would use me for her own glory is defeated.""
			)
			(3
				(theBall setMotion: MoveTo (gEgo x:) (- (gEgo y:) 3) self)
			)
			(4
				(gLongSong number: 557 play:)
				(gEgo get: 56 1 solvePuzzle: 500 15 2) ; theHeartRit
				(gMessager say: 6 87 28 0 self) ; "You now have a paper which says, "Ritual of the Dark One - Heart of Darkness." You put it away."
			)
			(5
				(theBall hide:)
				(gGlory handsOn:)
				(= local0 0)
				(ClearFlag 35)
				(self dispose:)
			)
		)
	)
)

(instance theBall of Actor
	(properties
		view 582
		loop 2
		signal 18433
	)
)

(instance sCastSpell of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(client
					view: 451
					setLoop: register 1
					setCel: 0
					setCycle: CT (- (client lastCel:) 1) 1 self
				)
			)
			(1
				(if (and (IsFlag 8) (not local7))
					(= local7 1)
					(gMessager say: 2 6 19 0 self) ; "The human has a spell which reverses spells. Use your area attacks!"
				else
					(self cue:)
				)
			)
			(2
				(if (and (== client queenFairy) (< [gEgoStats 19] 5)) ; mana
					(gCurRoom setScript: sHelpless)
				)
				(client setLoop: (+ register 3) 1 setCycle: Fwd)
				(if (IsFlag 8)
					(if (== client queenFairy)
						(= temp0 56)
					else
						(= temp0 36)
					)
					((FairySpell new:) init: 79 temp0 client)
					(= ticks
						(switch global439
							(1
								(Random 300 360)
							)
							(2
								(Random 240 300)
							)
							(3
								(Random 180 240)
							)
						)
					)
				else
					(if (== client queenFairy)
						(= temp0 50)
					else
						(= temp0 30)
					)
					((FairySpell new:) init: 86 temp0 client)
					(= ticks
						(switch global439
							(1
								(Random 300 360)
							)
							(2
								(Random 240 300)
							)
							(3
								(Random 180 240)
							)
						)
					)
				)
			)
			(3
				(client
					setLoop: register 1
					setCel: (if (== client leftFairy) 1 else 0)
					setCycle: 0
				)
				(= ticks
					(switch global439
						(1
							(Random 300 360)
						)
						(2
							(Random 240 300)
						)
						(3
							(Random 180 240)
						)
					)
				)
			)
			(4
				(self changeState: 0)
			)
		)
	)
)

(instance sHelpless of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(queenFairy setLoop: (+ (queenFairy loop:) 3) 1 setCycle: Fwd)
				(gMessager say: 2 6 24 0 self) ; "Ah, the human has wasted his magic. He is at our mercy now."
			)
			(1
				(= seconds 3)
			)
			(2
				(gEgo hide:)
				(= seconds 2)
			)
			(3
				(EgoDead 25 580 43 End) ; "Do we have to spell it out for you? Hostile magic can be harmful to your health! Maybe you'd do better if you had a staff of assistants like the Faerie Queen... or even if you used a staff to assist you."
			)
		)
	)
)

