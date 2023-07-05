;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 241)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use n065)
(use TryToMoveTo)
(use Elemental)
(use LoadMany)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	airElemental 0
)

(local
	[moveList 68] = [0 0 0 0 5 185 308 253 96 163 217 284 31 140 255 315 126 130 212 337 202 130 114 337 298 140 60 317 233 163 115 282 314 185 25 252 315 249 12 181 224 271 103 150 289 294 65 119 194 304 108 97 118 304 206 97 22 294 260 117 87 271 205 152 6 249 295 182]
	[bellowsMove 10] = [0 0 -19 28 -22 13 22 13 19 28]
	[bellowsLoop 5] = [0 5 3 4 6]
	index
	startPoint
	stuff = {dirt}
	airGrounded
	heardWoozy
	heardStrongest
	heardStrong
	heardWeak
	[string 100]
)

(procedure (FindWhere thePoint)
	(= index (* thePoint 4))
	(if (== gCurRoomNum 335) ; rmSPlazaPalace
		(+= index 2)
	)
	(airElemental newX: [moveList index] newY: [moveList (+ index 1)])
)

(procedure (FindAngle thePoint &tmp theDiff eAngle pAngle nX nY eX eY)
	(FindWhere thePoint)
	(= nX (airElemental newX:))
	(= nY (airElemental newY:))
	(= eX (airElemental x:))
	(= eY (airElemental y:))
	(= eAngle (GetAngle eX eY (gEgo x:) (gEgo y:)))
	(= pAngle (GetAngle eX eY nX nY))
	(if (> (= theDiff (Abs (- eAngle pAngle))) 180)
		(= theDiff (- 360 theDiff))
	)
	(return theDiff)
)

(procedure (GroundAir)
	(airElemental
		following: 1
		wandering: 0
		cycleSpeed: 1
		ignoreActors: 0
		setMotion: 0
	)
	(airEyes init:)
	(= airGrounded 1)
	(groundTimer setReal: groundTimer 15)
)

(instance airElemental of Elemental
	(properties
		x 160
		y 160
		noun '/cyclone,air,(elemental<air)'
		description {the Air Elemental}
		lookStr {You see a writhing funnel of air (what a windbag).}
		view 342
		signal 26624
		wandering 1
		wanderList 16
	)

	(method (init theX)
		(LoadMany rsVIEW 342 343 50)
		(= gLevScript levRopeSaids)
		(= gRopeScript levRopeSaids)
		(= wandering (mod gAirPoints 100))
		(= lastWander (/ gAirPoints 100))
		(if (> lastWander 16)
			(-= lastWander 16)
		)
		(cond
			(
				(and
					(or
						(and (== gPrevRoomNum 240) (> wandering 8)) ; rmPalaceGatesE
						(and (== gPrevRoomNum 335) (< wandering 9)) ; rmSPlazaPalace
					)
					(> gAirPoints 1699)
				)
				(= startPoint wandering)
			)
			(
				(or
					(and (== gPrevRoomNum 240) (> wandering 8)) ; rmPalaceGatesE
					(and (== gPrevRoomNum 335) (< wandering 9)) ; rmSPlazaPalace
				)
				(= startPoint lastWander)
				(= wandering lastWander)
			)
			(
				(and
					(not
						(or
							(and (== gPrevRoomNum 240) (> wandering 8)) ; rmPalaceGatesE
							(and (== gPrevRoomNum 335) (< wandering 9)) ; rmSPlazaPalace
						)
					)
					(> gAirPoints 1699)
				)
				(= startPoint lastWander)
				(= wandering lastWander)
			)
			(else
				(= startPoint wandering)
			)
		)
		(FindWhere startPoint)
		(= x newX)
		(= y newY)
		(super init: &rest)
		(self baseSetter: airBase)
	)

	(method (dispose)
		(if (> y 200)
			(= gAirPoints (+ (* (+ lastWander 16) 100) wandering))
		)
		(gTimers eachElementDo: #dispose eachElementDo: #delete)
		(= gLevScript 0)
		(= gRopeScript 0)
		(super dispose:)
	)

	(method (doit)
		(if
			(and
				(or (IsFlag 90) (IsFlag 88))
				(< (self distanceTo: gEgo) attackDist)
				(< (gEgo z:) 30)
			)
			(self attack:)
		)
		(super doit:)
	)

	(method (attack)
		(cond
			(airGrounded)
			((> (gEgo z:) 30))
			((IsFlag 90)
				(gEgo setScript: (ScriptID 62 1)) ; fallDown
			)
			((IsFlag 88)
				(gEgo setScript: (ScriptID 61 3)) ; ropeFall
			)
			((IsFlag 91))
			((IsFlag 95))
			((gCurRoom script:))
			(else
				(UseStamina 20)
				(gEgo hurtScript: blowEgo)
				(super attack:)
			)
		)
	)

	(method (wander &tmp theDir theAngle bailOut)
		(= bailOut 0)
		(cond
			((or (>= gDay 10) (IsFlag 90) (IsFlag 88))
				(= theAngle 359)
				(while (and (> theAngle 20) (< bailOut 10))
					(super wander:)
					(= theAngle (FindAngle wandering))
					(++ bailOut)
				)
			)
			((== gDay 9)
				(super wander:)
				(FindWhere wandering)
			)
			(else
				(= theAngle 1)
				(while (and (< theAngle 40) (< bailOut 10))
					(super wander:)
					(= theAngle (FindAngle wandering))
					(++ bailOut)
				)
			)
		)
		(self setMotion: TryToMoveTo newX newY 500 self)
		(= gAirPoints (+ (* lastWander 100) wandering))
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'use/bellows')
				(if (gEgo has: 25) ; Bellows
					(gEgo setScript: bellowsScript)
				else
					(DontHave)
				)
			)
			((Said 'throw/dirt,earth,pan')
				(gEgo setScript: dirtScript 0 1)
			)
			((Said 'throw/sand,bag')
				(gEgo setScript: dirtScript 0 0)
			)
		)
	)

	(method (onMe theObj &tmp oX oY)
		(= oX (theObj x:))
		(= oY (theObj y:))
		(return
			(and
				(<= nsLeft oX nsRight)
				(<= (- nsTop 15) oY nsBottom)
				(if control
					(& control (OnControl CONTROL oX oY))
				else
					1
				)
			)
		)
	)

	(method (hurtMe amount whatHurt)
		(cond
			((OneOf (whatHurt type:) 25 27)
				(HighPrint 241 0) ; "The spell does not seem to affect the wind."
			)
			((== (whatHurt type:) 5)
				(HighPrint 241 1) ; "The dagger is easily tossed from the funnel."
			)
			((>= hitY (+ nsTop 15))
				(HighPrint (Format @string 241 2 stuff)) ; "The wind catches the %s and spins it away.  It takes far more skill to throw into something than to throw at something."
			)
			((> y 220))
			(else
				(HighPrint (Format @string 241 3 stuff)) ; "You have managed to throw the %s into the center of the funnel."
				(GroundAir)
			)
		)
		(return 0)
	)

	(method (fetchMe)
		(HighPrint 241 4) ; "Hmm. Nothing to grab on to."
		(return 0)
	)
)

(instance airBase of Code
	(properties)

	(method (doit theActor &tmp theX)
		(= theX (theActor x:))
		(BaseSetter theActor)
		(theActor brLeft: (- theX 9) brRight: (+ theX 9))
	)
)

(instance airEyes of Prop
	(properties
		view 342
		loop 2
		signal 24592
	)

	(method (doit)
		(= y (- (airElemental y:) 38))
		(self setPri: (+ (airElemental priority:) 1))
		(switch (airElemental cel:)
			(0
				(= x (- (airElemental x:) 8))
			)
			(1
				(= x (- (airElemental x:) 6))
			)
			(2
				(= x (- (airElemental x:) 1))
			)
			(3
				(= x (+ (airElemental x:) 6))
			)
			(4
				(= x (+ (airElemental x:) 2))
			)
		)
		(cond
			((== loop 1)
				(super doit:)
			)
			((> (gEgo x:) (+ x 20))
				(self setCel: 0)
			)
			((< (gEgo x:) (- x 20))
				(self setCel: 2)
			)
			(else
				(self setCel: 1)
			)
		)
	)
)

(instance groundTimer of Timer
	(properties)

	(method (cue)
		(if (!= (gEgo script:) bellowsScript)
			(airElemental
				following: 0
				wandering: 1
				cycleSpeed: 0
				ignoreActors: 1
			)
			(airEyes dispose:)
			(= airGrounded 0)
		)
	)
)

(instance blowEgo of HandsOffScript
	(properties)

	(method (init &tmp theScript)
		(if (== (= theScript (gCurRoom script:)) dirtScript)
			(gEgo illegalBits: -32768)
			(theScript dispose:)
		)
		(gEgo hurtScript: 0)
		(super init: &rest)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'drop,throw,use/dirt,earth')
				(DontTalk 1)
				(if gClumpsLeft
					(HighPrint 241 5) ; "You force some earth into the center of the Air Elemental's funnel."
					(if (not (mod (-- gClumpsLeft) 6))
						(gEgo use: 32) ; PotOfDirt
						(gEgo get: 35) ; EmptyPot
					)
					(GroundAir)
				else
					(HighPrint 241 6) ; "Uh oh! You don't have any dirt."
				)
				(= cycles 1)
			)
			((Said 'drop,throw,use/sand')
				(DontTalk 1)
				(if global318
					(HighPrint 241 7) ; "You force some sand into the center of the Air Elemental's funnel."
					(-- global318)
					(GroundAir)
					(if (not (mod global318 9))
						(gEgo use: 51) ; BagOfSand
						(gEgo get: 38) ; ClothBag
					)
				else
					(HighPrint 241 8) ; "You don't have any sand."
				)
				(= cycles 1)
			)
			(else
				(event claimed: 1)
				(HighPrint 241 9) ; "It's too windy to do that."
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((TrySkill 0 125) ; strength
						(if (not heardStrongest)
							(HighPrint 241 10) ; "You manage to withstand the force of the wind."
							(= heardStrongest 1)
						)
						(DontTalk 0)
						(airElemental
							following: 1
							wandering: 0
							setMotion: MoveTo (gEgo x:) (gEgo y:)
						)
						(= state 1)
						(= cycles 30)
					)
					((> [gEgoStats 0] 100) ; strength
						(if (not heardStrong)
							(HighPrint 241 11) ; "You try to force yourself into the wind, but it is stronger than you, and you can't quite get to the center of the funnel."
							(= heardStrong 1)
						)
						(self cue:)
					)
					(else
						(if (not heardWeak)
							(HighPrint 241 12) ; "You are just not strong enough to withstand the wind."
							(= heardWeak 1)
						)
						(self cue:)
					)
				)
			)
			(1
				(gEgo view: 343 setLoop: 0 setCycle: Fwd)
				(= state 3)
				(= cycles 24)
			)
			(2
				(if (> (gEgo x:) 160)
					(gEgo
						setMotion: MoveTo (- (gEgo x:) 30) (gEgo y:) self
					)
				else
					(gEgo
						setMotion: MoveTo (+ (gEgo x:) 30) (gEgo y:) self
					)
				)
			)
			(3
				(Face gEgo airElemental 0 self)
			)
			(4
				(if (not airGrounded)
					(airElemental following: 0 wandering: 1 attackDist: 15)
				)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance dirtScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					(register
						(if (ThrowObj 1 self self 0 0 0)
							(= stuff {dirt})
						else
							(self changeState: 1)
						)
					)
					((ThrowObj 2 self self 0 0 0)
						(= stuff {sand})
					)
					(else
						(self changeState: 1)
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance levRopeSaids of Script
	(properties)

	(method (init)
		(super init: &rest)
		(client cue:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'drop,throw,use/dirt,earth')
				(if (and (< (gEgo distanceTo: airElemental) 20) gClumpsLeft)
					(HighPrint 241 13) ; "You scoop some dirt into the funnel."
					(if (not (mod (-- gClumpsLeft) 6))
						(gEgo use: 32) ; PotOfDirt
						(gEgo get: 35) ; EmptyPot
					)
					(GroundAir)
				else
					(HighPrint 241 14) ; "You don't seem to be close enough for that."
				)
			)
			((Said 'drop,throw,use/sand')
				(if (and (< (gEgo distanceTo: airElemental) 20) global318)
					(HighPrint 241 15) ; "You pitch some sand into the funnel."
					(if (not (mod (-- global318) 9))
						(gEgo use: 51) ; BagOfSand
						(gEgo get: 38) ; ClothBag
					)
					(GroundAir)
				else
					(HighPrint 241 14) ; "You don't seem to be close enough for that."
				)
			)
			((Said 'throw/dirt,earth,pan,sand,bag')
				(HighPrint 241 16) ; "You will need to be on the ground in order to do that."
			)
			(else
				(event claimed: 0)
			)
		)
	)
)

(instance bellowsScript of HandsOffScript
	(properties)

	(method (changeState newState &tmp theX theY theLoop)
		(switch (= state newState)
			(0
				(= theX (airElemental x:))
				(= theY (airElemental y:))
				(cond
					((and (> theX 160) (< theY 150))
						(= register 1)
					)
					((> theX 160)
						(= register 2)
					)
					((> theY 165)
						(= register 3)
					)
					(else
						(= register 4)
					)
				)
				(= cycles 1)
			)
			(1
				(if (not airGrounded)
					(self cue:)
				else
					(= theX (airElemental x:))
					(= theY (airElemental y:))
					(+= theX [bellowsMove (* register 2)])
					(+= theY [bellowsMove (+ (* register 2) 1)])
					(gEgo setMotion: MoveTo theX theY self)
				)
			)
			(2
				(gEgo view: 342 setLoop: [bellowsLoop register])
				(if (not airGrounded)
					(self changeState: 5)
				else
					(= cycles 8)
				)
			)
			(3
				(airEyes setLoop: 1 setCel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(= cycles 8)
			)
			(5
				(gEgo cycleSpeed: 1 setCycle: Fwd)
				(if airGrounded
					(airEyes dispose:)
					(airElemental
						view: 342
						setLoop: (if (< register 3) 9 else 10)
						setCel: 0
						setPri: (gEgo priority:)
						setCycle: End self
					)
				else
					(self changeState: 8)
				)
			)
			(6
				(airElemental
					posn: (airElemental x:) (- (airElemental y:) 17)
					setLoop: (if (< register 3) 7 else 8)
					setCel: 13
					setCycle: Beg self
				)
				(gMiscSound number: 342 loop: 0 priority: 15 play:)
			)
			(7
				(airElemental dispose:)
				(++ gElementalState)
				(gEgo view: 50 setLoop: 0 setCel: 0 setCycle: End)
				(= cycles 16)
			)
			(8
				(if airGrounded
					(SolvePuzzle 626 20)
					(SkillUsed 14 100) ; honor
					(HighPrint 241 17) ; "You capture the Air Elemental in the bellows and proudly put them away."
				else
					(HighPrint 241 18) ; "The swift Air Elemental easily avoids the bellows."
				)
				(= cycles 1)
			)
			(9
				(gEgo view: 0)
				(NormalEgo)
				(= cycles 1)
			)
			(10
				(self dispose:)
			)
		)
	)
)

