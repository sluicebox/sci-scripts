;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 38)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use combat)
(use Motion)
(use Actor)
(use System)

(class SView of View
	(properties)

	(method (init param1)
		(&= signal $fff7)
		((param1 extraCast:) add: self)
		(= plane (param1 plane:))
		(AddScreenItem self)
		(|= -info- $0010)
		(SetNowSeen self)
	)

	(method (doVerb))
)

(class SActor of Actor
	(properties
		typeView 0
		width 0
		height 0
		attackCode 0
		explodeX 0
	)

	(method (dedectPts))

	(method (getHurt))

	(method (doVerb)
		(switch ((gPuzzleBar combatEvent:) modifiers:)
			(8
				(if (== (gCombatEgoActor typeView:) 44)
					(gPuzzleBar move: 14)
				else
					(gPuzzleBar move:)
				)
			)
			(4
				(gPuzzleBar move: 15)
			)
			(else
				(gPuzzleBar move: 4)
			)
		)
	)

	(method (cantBeHere)
		(return 0)
	)

	(method (init param1)
		(&= signal $fff7)
		((param1 puzzleCast:) add: self)
		(= plane (param1 plane:))
		(AddScreenItem self)
		(|= -info- $0010)
		(SetNowSeen self)
		(= width (/ (- nsRight nsLeft) 2))
		(= height (/ (- nsBottom nsTop) 2))
	)

	(method (onMe param1 param2)
		(return (OnMe param1 param2 self (& signal $1000)))
	)

	(method (doit)
		(if (not (& signal $0008))
			(if script
				(script doit:)
			)
			(if mover
				(mover doit:)
			)
			(if cycler
				(cycler doit:)
			)
			(= xLast x)
			(= yLast y)
			(if (& -info- $0008)
				(UpdateScreenItem self)
			)
			(return 1)
		else
			(return 0)
		)
	)
)

(class CombatSpell of SActor
	(properties
		view 26
		cycleSpeed 1
		myTarget 0
		oldTarget 0
		type 0
		active 0
		hit 0
	)

	(method (init)
		(super init: &rest)
		(= xStep global190)
	)

	(method (setMotion)
		(= active 1)
		(proc810_13 3 933)
		(super setMotion: &rest)
	)

	(method (setCycle param1)
		(if (== param1 End)
			(proc810_13 3 944)
		)
		(super setCycle: param1 &rest)
	)

	(method (doit)
		(if (super doit:)
			(if (and myTarget (myTarget onMe: x y))
				(= oldTarget myTarget)
				(if (and (== (oldTarget attackCode:) 23) (not global189))
					(= myTarget 0)
					(self
						active: 0
						setPri: 240
						setMotion: 0
						setLoop: (+ loop (if (> loop 5) 1 else 2)) 1
						cel: 0
						setCycle: End self
					)
				else
					(= myTarget 0)
					(self toDamage:)
				)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (toDamage))

	(method (hide)
		(= active 0)
		(super hide: &rest)
	)
)

(class CombatIcon of TextIcon
	(properties)

	(method (init param1)
		(= nsRight (+ nsLeft (CelWide view loop cel)))
		(= nsBottom (+ nsTop (CelHigh view loop cel)))
		(= owner param1)
		(&= signal $fff7)
		((owner extraCast:) add: self)
		(= plane (owner plane:))
		(AddScreenItem self)
	)
)

(class CombatBar of PuzzleBar
	(properties
		combatEvent 0
		extraCast 0
	)

	(method (move))

	(method (init)
		(cond
			((> global191 200)
				(= global190 12)
			)
			((> global191 160)
				(= global190 10)
			)
			((> global191 100)
				(= global190 9)
			)
			((> global191 70)
				(= global190 9)
			)
			((> global191 40)
				(= global190 8)
			)
			((> global191 30)
				(= global190 4)
			)
			(else
				(= global190 1)
			)
		)
		(= extraCast (Cast new:))
		(super init: &rest)
	)

	(method (setPlane)
		(= usePlane 0)
		(plane
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 0 0 319 199
			drawPic: (gCurRoom picture:) (if (Random 0 1) 0 else 1024)
			addCast: puzzleCast
		)
	)

	(method (addIcons))

	(method (select param1 param2)
		(return
			(if
				(if (param1 isKindOf: TextIcon)
					(param1 select: (and (>= argc 2) param2))
				else
					(param1 doVerb:)
					0
				)
				(if (not (& (param1 signal:) $0002))
					(= curIcon param1)
				)
				1
			)
		)
	)

	(method (doit &tmp temp0)
		(while (and (& state $0020) (= combatEvent ((gUser curEvent:) new:)))
			(= gGameTime (+ gTickOffset (GetTime)))
			(puzzleCast doit:)
			(FrameOut)
			(if noHands
				(combatEvent type: 0)
			)
			(breakif (self dispatchEvent:))
		)
		(= temp0 (GetTime))
		(while (< (- (GetTime) temp0) 60)
			(FrameOut)
			(gSounds eachElementDo: #check)
		)
	)

	(method (dispatchEvent &tmp temp0 temp1)
		(if script
			(script doit:)
		)
		(if gDoMotionCue
			(= gDoMotionCue 0)
			(puzzleCast eachElementDo: #motionCue)
		)
		(if gCuees
			(gCuees eachElementDo: #doit)
			(if (gCuees isEmpty:)
				(gCuees dispose:)
				(= gCuees 0)
			)
		)
		(gSounds eachElementDo: #check)
		(if (& (combatEvent type:) $02ff)
			(if noHands
				(switch (combatEvent type:)
					(1
						(if (IsFlag 374)
							(if (== (combatEvent modifiers:) 3)
								(SetFlag 376)
								(if
									(and
										(= temp1 (gCombatEgoActor script:))
										(not (temp1 script:))
									)
									(gCombatEgoActor cue:)
								)
							else
								((ScriptID 40 13) init: show: dispose:) ; xFuzzyPanel
							)
						)
					)
					(4
						(if (== (combatEvent message:) 32)
							((ScriptID 40 13) init: show: dispose:) ; xFuzzyPanel
						)
					)
				)
			else
				(= temp0
					(self firstTrue: #onMe (combatEvent x:) (combatEvent y:))
				)
				(switch (combatEvent type:)
					(1
						(cond
							((IsFlag 374)
								(if (== (combatEvent modifiers:) 3)
									(SetFlag 376)
									(if
										(and
											(= temp1 (gCombatEgoActor script:))
											(not (temp1 script:))
										)
										(gCombatEgoActor cue:)
									)
								else
									((ScriptID 40 13) init: show: dispose:) ; xFuzzyPanel
								)
							)
							(temp0
								(self select: temp0 1)
							)
							((IsFlag 374)
								(if (== (combatEvent modifiers:) 3)
									(SetFlag 376)
									(if (not (gCombatEgoActor script:))
										(gCombatEgoActor cue:)
										(if (IsFlag 374)
											((ScriptID 40 14) hide:) ; xModeButton
										)
									)
								else
									((ScriptID 40 13) init: show: dispose:) ; xFuzzyPanel
								)
							)
							(
								(or
									(& (combatEvent modifiers:) $0002)
									(& (combatEvent modifiers:) $0001)
								)
								(cond
									(
										(and
											(> (combatEvent y:) 156)
											(== gHeroType 2) ; Thief
										)
										(self move: 13)
									)
									((< (combatEvent y:) 63)
										(if
											(>
												(combatEvent x:)
												(+
													(gCombatEgoActor x:)
													(gCombatEgoActor width:)
												)
											)
											(self move: 3)
										else
											(self move: 16)
										)
									)
									(else
										(self move: 4)
									)
								)
							)
							((< (combatEvent y:) 63)
								(cond
									(
										(>
											(combatEvent x:)
											(+
												(gCombatEgoActor x:)
												(gCombatEgoActor width:)
											)
										)
										(self move: 17)
									)
									(
										(<
											(combatEvent x:)
											(-
												(gCombatEgoActor x:)
												(gCombatEgoActor width:)
											)
										)
										(self move: 18)
									)
									(else
										(self move: 2)
									)
								)
							)
							((< (combatEvent y:) 156)
								(switch (combatEvent modifiers:)
									(8
										(if (== (gCombatEgoActor typeView:) 44)
											(self move: 14)
										else
											(self move:)
										)
									)
									(4
										(self move: 15)
									)
									(else
										(self move:)
									)
								)
							)
						)
					)
					(4
						(if
							(or
								(& (combatEvent modifiers:) $0002)
								(& (combatEvent modifiers:) $0001)
							)
							(switch (combatEvent message:)
								(18432
									(self move: 3)
								)
								(19712
									(self move: 4)
								)
								(19200
									(self move: 19)
								)
								(20480
									(self move: 20)
								)
							)
						else
							(switch (combatEvent message:)
								(27
									(self move: 7)
								)
								(15104
									(SetFlag 376)
									(cond
										((IsFlag 374)
											(if
												(and
													(= temp1
														(gCombatEgoActor script:)
													)
													(not (temp1 script:))
												)
												(gCombatEgoActor cue:)
											)
										)
										((not (gCombatEgoActor script:))
											(gCombatEgoActor cue:)
											((ScriptID 40 14) hide:) ; xModeButton
										)
									)
								)
								(32
									(if (IsFlag 374)
										((ScriptID 40 13) init: show: dispose:) ; xFuzzyPanel
									)
								)
								(19200
									(self move: 1)
								)
								(19712
									(self move: 0)
								)
								(20480
									(self move: 6)
								)
								(18432
									(self move: 2)
								)
								(122
									(self move: 8)
								)
								(120
									(self move: 9)
								)
								(99
									(self move: 10)
								)
								(118
									(self move: 11)
								)
								(98
									(self move: 12)
								)
							)
						)
					)
					(512
						(cond
							((< (combatEvent z:) 0)
								(self move: 6)
							)
							((> (combatEvent z:) 0)
								(self move: 2)
							)
							((< (combatEvent roll:) 0)
								(self move: 0)
							)
							((> (combatEvent roll:) 0)
								(self move: 1)
							)
							((combatEvent yaw:)
								(self move: 4)
							)
						)
					)
				)
			)
		)
		(return 0)
	)

	(method (dispose)
		(if extraCast
			(extraCast dispose:)
		)
		(super dispose:)
	)
)

(class ShotTo of Obj
	(properties
		client 0
		caller 0
		x 0
		y 0
		dx 0
		b-moveCnt 0
		completed 0
	)

	(method (init param1 param2 param3 param4 &tmp temp0)
		(if (>= argc 1)
			(= client param1)
			(if (>= argc 2)
				(= x param2)
				(if (>= argc 3)
					(= y param3)
					(if (>= argc 4)
						(= caller param4)
					)
				)
			)
		)
		(= completed 0)
		(if (> x (client x:))
			(= dx (client xStep:))
		else
			(= dx (- 0 (client xStep:)))
		)
		(= b-moveCnt (+ 1 (client moveSpeed:) gGameTime))
		(if (= temp0 (client cycler:))
			(temp0 cycleCnt: b-moveCnt)
		)
	)

	(method (doit)
		(if (>= (Abs (- gGameTime b-moveCnt)) (client moveSpeed:))
			(cond
				((< dx 0)
					(if (<= (client x:) x)
						(self moveDone:)
					else
						(= b-moveCnt gGameTime)
						(client x: (+ (client x:) dx))
					)
				)
				((>= (client x:) x)
					(self moveDone:)
				)
				(else
					(= b-moveCnt gGameTime)
					(client x: (+ (client x:) dx))
				)
			)
		)
	)

	(method (moveDone)
		(= completed 1)
		(if caller
			(= gDoMotionCue 1)
		else
			(self motionCue:)
		)
	)

	(method (motionCue)
		(client mover: 0)
		(if (and completed caller)
			(caller cue:)
		)
		(self dispose:)
	)
)

(class CombatAttack of CT
	(properties
		myTarget 0
		targetDist 0
		startCel 0
		hitPts 0
	)

	(method (init param1 param2 param3 param4 param5 param6 param7 param8 &tmp temp0)
		(super init: param1)
		(= cycleDir param3)
		(= caller param4)
		(= myTarget param5)
		(= targetDist param6)
		(= startCel param7)
		(= hitPts param8)
		(= temp0 (client lastCel:))
		(= endCel (if (> param2 temp0) temp0 else param2))
	)

	(method (doit &tmp temp0 temp1)
		(= temp1 (client lastCel:))
		(if (> endCel temp1)
			(= endCel temp1)
		)
		(= temp0 (self nextCel:))
		(if
			(and
				myTarget
				(!= (myTarget attackCode:) 23)
				(<= (Abs (- (client x:) (myTarget x:))) targetDist)
				(>= temp0 startCel)
			)
			(myTarget getHurt: 2)
			(= myTarget 0)
			(client dedectPts: hitPts)
		)
		(client
			cel:
				(cond
					((> temp0 temp1) 0)
					((< temp0 0) temp1)
					(else temp0)
				)
		)
		(if (and (== gGameTime cycleCnt) (== endCel (client cel:)))
			(self cycleDone:)
		)
	)
)

