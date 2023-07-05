;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 608)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use Motion)
(use Game)
(use User)
(use System)

(public
	riverReg 0
)

(local
	local0
)

(instance riverReg of Rgn
	(properties)

	(method (init)
		(LoadMany rsVIEW 54 14)
		(Load rsSOUND 14)
		(self keep: 0)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(& (gEgo onControl: 1) $003c)
				(not (gCurRoom script:))
				(== gNewRoomNum gCurRoomNum)
			)
			(gCurRoom setScript: intoRiver)
		)
	)

	(method (handleEvent event)
		(if (or (event claimed:) (!= (event type:) evSAID))
			(return)
		)
		(cond
			((Said 'dive/')
				(cond
					(
						(and
							(== (gCurRoom script:) intoRiver)
							(>= (intoRiver state:) 5)
						)
						(Print 608 0) ; "It's too late now!"
					)
					((!= (gCurRoom script:) intoRiver)
						(Print 608 1) ; "You must be swimming in order to dive."
					)
					(else
						(Print 608 2) ; "The current is too strong for diving."
					)
				)
			)
			(
				(and
					(or
						(Said 'swim/')
						(Said 'go,enter/water,brook,brook,brook')
					)
					(!= gCurRoomNum 42)
				)
				(if (!= (gCurRoom script:) intoRiver)
					(Print 608 3) ; "You must be in the water in order to swim."
				else
					(Print 608 4) ; "Although you try to swim, the current is too strong."
				)
			)
			((or (Said 'drink/water') (Said 'get,get/drink'))
				(Print 608 5) ; "The steep embankment prevents you from getting a drink."
			)
			((or (Said 'get,get/water') (Said 'fill/bucket'))
				(cond
					((== (gCurRoom script:) intoRiver)
						(Print 608 6) ; "You're too busy drowning!"
					)
					((gEgo has: 8) ; Empty_Water_Bucket
						(Print 608 7) ; "The steep embankment prevents you from doing that."
					)
					(else
						(Print 608 8) ; "You have nothing to carry the water in."
					)
				)
			)
			(else
				(event claimed: 0)
			)
		)
	)
)

(instance intoRiver of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (== state 0)
			(cond
				(
					(or
						(& (gEgo onControl: 1) $0200)
						(> (gEgo x:) 326)
						(< (gEgo x:) -6)
						(> (gEgo y:) 196)
					)
					((ScriptID 0 21) number: 14 loop: 1 play:) ; gameSound
					(self cue:)
				)
				((< (gEgo yStep:) 9)
					(gEgo setStep: -1 (+ (gEgo yStep:) 2))
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 0 21) number: 17 init: loop: 1 play:) ; gameSound
				(= global130 6)
				(gEgo
					view: 54
					illegalBits: 0
					setCycle: 0
					cel: 0
					ignoreActors:
					ignoreHorizon:
					setStep: 6 3
				)
				(switch (gEgo onControl: 1)
					(4
						(gEgo
							setLoop: 1
							setMotion:
								MoveTo
								(- (gEgo x:) 200)
								(+ (gEgo y:) 140)
						)
					)
					(32
						(gEgo
							yStep: 1
							setLoop: 2
							setMotion: MoveTo (gEgo x:) 190
						)
					)
					(16
						(gEgo setLoop: 3 setMotion: MoveTo (gEgo x:) 0)
					)
					(8
						(gEgo
							setLoop: 0
							setMotion:
								MoveTo
								(+ (gEgo x:) 200)
								(+ (gEgo y:) 140)
						)
					)
				)
				(if (gCast contains: gGoat)
					(proc0_15 gGoat gEgo)
					(gGoat setMotion: 0)
				)
				(gEgo
					setPri:
						(switch gCurRoomNum
							(25 3)
							(39
								(if (< (gEgo y:) 107) 2 else -1)
							)
							(41 7)
							(26
								(if (& (gEgo onControl: 1) $0004) 1 else 8)
							)
							(42
								(cond
									(
										(and
											(> (gEgo y:) 150)
											(< (gEgo x:) 50)
										)
										13
									)
									((> (gEgo y:) 83) 4)
									(else 1)
								)
							)
							(32
								(if (== (gEgo loop:) 3) 8 else 5)
							)
							(34 3)
							(47
								(if (< (gEgo x:) 159)
									(if (< (gEgo y:) 170) 7 else 9)
								else
									-1
								)
							)
							(else -1)
						)
				)
			)
			(1
				(User canInput: 1)
				(if (IsFlag 1)
					(Print 608 9) ; "As you fall, the magic ring slips from your finger."
					(gGame changeScore: -3)
				)
				(gEgo setLoop: 4 setMotion: 0 cycleSpeed: 1 setCycle: End)
				(if (== gCurRoomNum 17)
					(self changeState: 6)
				else
					(= seconds 2)
				)
			)
			(2
				(User canControl: 0)
				((ScriptID 0 21) number: 96 play:) ; gameSound
				(= local0 (gEgo loop:))
				(gEgo
					view: 14
					cycleSpeed: 2
					setMotion: 0
					setLoop: 0
					cel: 5
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(gEgo cel: 5 setCycle: End self)
			)
			(4
				(gEgo cel: 5 setCycle: End self)
			)
			(5
				(gEgo hide:)
				(= seconds 4)
			)
			(6
				(EgoDead
					{The raging current pulls you under, never to be found.}
				)
			)
		)
	)
)

