;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use Sound)
(use Motion)
(use Actor)
(use System)

(local
	selfDestruct
	spellView
	spellLoop
	impactLoop
	castSound
	hitSound
	spellMethod
	[deltas 18] = [0 0 0 -8 8 -8 8 0 8 8 0 8 -8 8 -8 0 -8 -8]
	[egoLoops 4] = [2 0 1 3]
	[xOffsets 4] = [17 10 -10 -17]
	[yOffsets 4] = [-40 -28 -28 -40]
	lastTargX
	lastTargY
	savedLooper
)

(procedure (findViewLoop spellNum)
	(switch spellNum
		(1
			(= spellView 9)
			(= spellLoop 4)
			(= impactLoop 4)
			(= castSound 25)
			(= hitSound 27)
			(= spellMethod 404)
		)
		(2
			(= spellView 9)
			(= spellLoop 4)
			(= impactLoop 4)
			(= castSound 25)
			(= hitSound 27)
			(= spellMethod 404)
		)
		(4
			(= spellView 9)
			(= spellLoop 4)
			(= impactLoop 4)
			(= castSound 25)
			(= hitSound 27)
			(= spellMethod 404)
		)
		(3
			(= spellView 9)
			(= spellLoop 4)
			(= impactLoop 4)
			(= castSound 25)
			(= hitSound 14)
			(= spellMethod 404)
		)
		(5
			(= spellView 9)
			(= spellLoop 5)
			(= impactLoop 5)
			(= castSound 25)
			(= hitSound 26)
			(= spellMethod 404)
		)
		(19
			(= spellView 32)
			(= spellLoop 9)
			(= impactLoop 9)
			(= castSound 30)
			(= hitSound 20)
			(= spellMethod 405)
		)
		(21
			(= spellView 32)
			(= spellLoop 9)
			(= impactLoop 9)
			(= castSound 31)
			(= hitSound 20)
			(= spellMethod 406)
		)
		(25
			(= spellView 32)
			(= spellLoop 4)
			(= impactLoop 5)
			(= castSound 13)
			(= hitSound 14)
			(= spellMethod 404)
		)
		(26
			(= spellView 32)
			(= spellLoop 8)
			(= impactLoop 8)
			(= castSound 17)
			(= hitSound 18)
			(= spellMethod 403)
		)
		(27
			(= spellView 32)
			(= spellLoop 6)
			(= impactLoop 7)
			(= castSound 15)
			(= hitSound 16)
			(= spellMethod 404)
		)
		(else
			(= spellView (= spellLoop (= impactLoop (= castSound (= hitSound (= spellMethod -1))))))
		)
	)
)

(class ProjClient of Script
	(properties
		type 0
		xStart 0
		yStart 0
		x 0
		y 0
		targetHit 0
	)

	(method (init)
		(HandsOff)
		(= savedLooper (gEgo looper:))
		(gEgo looper: 0)
		(super init: &rest)
	)

	(method (dispose)
		(gEgo looper: savedLooper)
		(HandsOn)
		(super dispose:)
	)
)

(class ProjScript of ProjClient
	(properties
		hitBonus 0
		damage 0
		theLasso 0
		soundObj 0
	)

	(method (dispose &tmp theLoop)
		(if targetHit
			(targetHit dispose:)
		)
		(if theLasso
			(theLasso dispose:)
		)
		(if soundObj
			(soundObj stop: dispose:)
		)
		(if script
			(script caller: 0)
		)
		(= targetHit (= theLasso (= soundObj 0)))
		(= theLoop (gEgo loop:))
		(EgoGait -1 0)
		(gEgo loop: (+ theLoop 4) setLoop: -1)
		(ClearFlag 87) ; fCastingSpell
		(ClearFlag 92) ; fSpellCritical
		(super dispose:)
	)

	(method (changeState newState &tmp dist aMiss moveScript theLoop angleToTarg testAngle index theRoom)
		(switch (= state newState)
			(0
				(SetFlag 87) ; fCastingSpell
				(self setScript: (AimSpell new:) self type)
			)
			(1
				(= angleToTarg (GetAngle (gEgo x:) (- (gEgo y:) 30) x y))
				(gEgo setHeading: angleToTarg)
				(= index 0)
				(for ((= testAngle 90)) (<= testAngle 360) ((+= testAngle 90))
					(if (< angleToTarg testAngle)
						(= xStart (+ (gEgo x:) [xOffsets index]))
						(= yStart (+ (gEgo y:) [yOffsets index]))
						(= theLoop [egoLoops index])
						(break)
					)
					(++ index)
				)
				(findViewLoop type)
				(gEgo
					view: spellView
					setLoop: theLoop
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(2
				(= dist
					(GetDistance (gEgo x:) (- (gEgo y:) 30) x y gPerspective)
				)
				(= aMiss 0)
				(cond
					((OneOf type 26 19 21))
					((not (OneOf type 1 4 5))
						(if (not (TrySkill 12 0 (- 100 (/ dist 5)))) ; magic use
							(= aMiss 25)
						)
					)
					((not [gEgoStats 10]) ; throw
						(= aMiss 50)
					)
					((not (TrySkill 10 0 (- 100 (/ dist 5)))) ; throw
						(= aMiss 25)
					)
				)
				(if aMiss
					(+= x (- (Random 0 (* 2 aMiss)) aMiss))
					(+= y (- (Random 0 (+ aMiss aMiss)) aMiss))
				)
				((= moveScript (Projectile new:))
					type: type
					damage: damage
					xStart: xStart
					yStart: yStart
					x: x
					y: y
				)
				(findViewLoop type)
				(if castSound
					((= soundObj (Sound new:))
						number: castSound
						loop: 1
						priority: 6
						init:
						play:
					)
				)
				(if (== type 25)
					(gEgo show:)
				)
				(self setScript: moveScript self 0)
			)
			(3
				(if (== type 26)
					(SetFlag 92) ; fSpellCritical
					(findViewLoop type)
					(if targetHit
						(if (not soundObj)
							((= soundObj (Sound new:)) init:)
						)
						(soundObj number: hitSound loop: 1 priority: 7 play:)
						(targetHit
							illegalBits: 0
							ignoreActors:
							ignoreHorizon:
							setStep: 12 8
							setMotion: MoveTo xStart yStart
						)
					)
					((= theLasso (Actor new:))
						view: spellView
						setLoop: spellLoop
						cel: 0
						illegalBits: 0
						ignoreActors:
						ignoreHorizon:
						setStep: 12 8
						init:
						posn: x y
						setCycle: Fwd
						setMotion: MoveTo xStart yStart self
					)
				else
					(if (== type 5)
						(if (== (= theRoom gCurRoomNum) 665)
							(= theRoom (- gDesertRoom))
						)
						(if (!= theRoom gDaggerRoom)
							(= gDaggerRoom theRoom)
							(= gMissedDaggers 0)
						)
						(if targetHit
							(++ gHitDaggers)
						else
							(++ gMissedDaggers)
						)
					)
					(= targetHit (= theLasso 0))
					(self cue:)
				)
			)
			(4
				(if targetHit
					(targetHit dispose:)
				)
				(if theLasso
					(theLasso dispose:)
				)
				(= targetHit (= theLasso 0))
				(ClearFlag 92) ; fSpellCritical
				(gEgo setCycle: End self)
			)
			(5
				(if selfDestruct
					(cond
						((OneOf type 25 27 5 4)
							(HighPrint 63 0) ; "Ouch! Why do you treat yourself so inappropriately?"
						)
						((== type 3)
							(HighPrint 63 1) ; "Good thing the Powder of Burning is only activated by Magical beings. Too bad you threw it away."
						)
						(else
							(HighPrint 63 2) ; "Good thing you can't hurt yourself like that."
						)
					)
				)
				(self dispose:)
			)
		)
	)
)

(class AimSpell of Script
	(properties
		DirKey 0
		x 0
		y 0
		oldNormCursor 0
	)

	(method (init &tmp rmnEvent)
		(HandsOff)
		(= rmnEvent (Event new:))
		(= lastTargX (rmnEvent x:))
		(= lastTargY (rmnEvent y:))
		(rmnEvent dispose:)
		(super init: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gKeyDownHandler delete: self)
		(= gNormalCursor oldNormCursor)
		(gGame setCursor: gNormalCursor 1)
		(HandsOn)
		(super dispose:)
	)

	(method (doit &tmp index rmnEvent)
		(if (!= DirKey 0)
			(= index (+ DirKey DirKey))
			(+= x [deltas index])
			(+= y [deltas (+ index 1)])
			(if (< x 0)
				(= x (= DirKey 0))
			)
			(if (> x 319)
				(= DirKey 0)
				(= x 319)
			)
			(if (< y 0)
				(= y (= DirKey 0))
			)
			(if (> y 189)
				(= DirKey 0)
				(= x 189)
			)
			(gGame setCursor: 1 1 (- x 0) (- y 0))
			(= lastTargX (- x 0))
			(= lastTargY (- y 0))
			(= rmnEvent (Event new:))
			(if
				(or
					(!= lastTargX (- (rmnEvent x:) 0))
					(!= lastTargY (- (- (rmnEvent y:) 0) 10))
				)
				(= DirKey 0)
			)
			(rmnEvent dispose:)
		)
		(super doit:)
	)

	(method (handleEvent event &tmp index)
		(= x (+ (event x:) 0))
		(= y (+ (event y:) 0))
		(switch (event type:)
			($0040 ; direction
				(event claimed: 1)
				(if (== (= index (event message:)) DirKey)
					(= DirKey JOY_NULL)
				else
					(= DirKey index)
				)
			)
			(evMOUSEBUTTON
				(event claimed: 1)
				(self cue:)
			)
			(evKEYBOARD
				(if (== (event message:) KEY_RETURN)
					(event claimed: 1)
					(self cue:)
				)
			)
		)
		(event claimed:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gKeyDownHandler addToFront: self)
				(gDirectionHandler addToFront: self)
				(gMouseDownHandler addToFront: self)
				(= oldNormCursor gNormalCursor)
				(= gNormalCursor 1)
				(gGame setCursor: 1 1)
			)
			(1
				(if (client respondsTo: #x)
					(client x: x)
					(client y: y)
				)
				(self dispose:)
			)
		)
	)
)

(class Projectile of Script
	(properties
		type 0
		damage 0
		xStart 0
		yStart 0
		x 0
		y 0
		projObj 0
		soundObj 0
	)

	(method (dispose)
		(if projObj
			(projObj dispose:)
		)
		(if soundObj
			(soundObj stop: dispose:)
		)
		(= projObj (= soundObj 0))
		(super dispose:)
	)

	(method (changeState newState &tmp theTarget gotIt theLoop)
		(switch (= state newState)
			(0
				(findViewLoop type)
				((= projObj (Actor new:))
					view: spellView
					setLoop: spellLoop
					cel: 0
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					setStep: 12 8
					setPri: 14
					posn: xStart yStart
					init:
					setCycle: Fwd
					setMotion: MoveTo x y self
				)
			)
			(1
				(findViewLoop type)
				(= gotIt 0)
				(= selfDestruct
					(== (= theTarget (gCast firstTrue: #onMe projObj)) gEgo)
				)
				(if (and theTarget (!= theTarget projObj))
					(if (theTarget respondsTo: #hitX)
						(theTarget hitX: x)
						(theTarget hitY: y)
					)
					(if
						(and
							(theTarget respondsTo: spellMethod)
							(Eval theTarget spellMethod damage self)
						)
						(= gotIt theTarget)
						(if (client respondsTo: #targetHit)
							(client targetHit: theTarget)
						)
						(if hitSound
							((= soundObj (Sound new:))
								number: hitSound
								loop: 1
								init:
								priority: 7
								play:
							)
						)
						(if (== impactLoop -1)
							(self cue:)
						else
							(projObj setLoop: impactLoop cel: 0 setCycle: End self)
						)
					)
				)
				(if (not gotIt)
					(if (client respondsTo: #targetHit)
						(client targetHit: 0)
					)
					(self dispose:)
				)
			)
			(2
				(self dispose:)
			)
		)
	)
)

