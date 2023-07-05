;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 607)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use DPath)
(use Motion)
(use Game)
(use System)

(public
	stalkRg 0
)

(instance stalkRg of Rgn
	(properties)

	(method (init)
		(Load rsVIEW 19)
		(Load rsPIC 270)
		(self keep: 0)
		(super init: &rest)
		(if (gEgo has: 20) ; Beans
			(gEgo put: 20) ; Beans
		else
			(gCurRoom overlay: 270 100)
		)
		(if (== gPrevRoomNum 70)
			(gCurRoom setScript: climbDownStalk)
		)
		(bigStalk init:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'climb,climb')
				(cond
					((not (& (gEgo onControl: 1) $0400))
						(Print 607 0) ; "You're not in a good place to climb the beanstalk."
					)
					((IsFlag 1)
						(Print 607 1) ; "You can't do that when you are invisible!"
					)
					((and (gCurRoom script:) (== (gCurRoom script:) climbUpStalk))
						(Print 607 2) ; "You are already climbing the beanstalk."
					)
					((gCurRoom script:)
						(Print 607 3) ; "You're too busy"
					)
					(else
						(gCurRoom setScript: climbUpStalk)
					)
				)
			)
		)
	)
)

(instance climbUpStalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 2)
					(gGoat setMotion: 0)
					(DisposeScript 971)
					(gGoat setMotion: MoveTo 165 180 self)
				else
					(self cue:)
				)
			)
			(1
				(HandsOff)
				(gEgo ignoreActors: ignoreHorizon: illegalBits: 0)
				(cond
					((> (gEgo y:) 141)
						(self changeState: 4)
					)
					((< (gEgo x:) 126)
						(self changeState: 3)
					)
					((> (gEgo x:) 220)
						(self changeState: 3)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gEgo setMotion: MoveTo 122 (gEgo y:) self)
			)
			(3
				(gEgo setMotion: MoveTo (gEgo x:) 148 self)
			)
			(4
				(gEgo setMotion: MoveTo 162 147 self)
			)
			(5
				(SetFlag 48)
				(gEgo
					posn: 162 145
					view: 19
					setLoop: 0
					cel: 0
					setPri: 14
					setStep: 4 3
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: SyncWalk
					setMotion: DPath 174 118 175 100 134 53 136 31 145 1 self
				)
			)
			(6
				(gEgo cel: 0)
				(= cycles 6)
			)
			(7
				(HandsOn)
				(gCurRoom newRoom: 70)
			)
		)
	)
)

(instance climbDownStalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 2)
				(ClearFlag 0)
				(gEgo
					illegalBits: 0
					ignoreActors:
					posn: 144 2
					view: 19
					setLoop: 0
					cel: 0
					setPri: 14
					setStep: 4 3
					moveSpeed: 1
					cycleSpeed: 1
					setCycle: SyncWalk
					setMotion: DPath 136 31 134 53 175 100 174 118 162 145 self
				)
			)
			(1
				(ClearFlag 48)
				(proc0_1)
				(gEgo posn: 162 147 loop: 3)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bigStalk of NewFeature
	(properties
		x 159
		y 19
		noun '/beanstalk'
		nsLeft 120
		nsBottom 143
		nsRight 196
		description {stalk}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {This mighty beanstalk stretches up so high, it vanishes into the clouds above.}
	)

	(method (init)
		(super init: &rest)
		(gFeatures delete: self)
		(gFeatures addToFront: self)
	)
)

