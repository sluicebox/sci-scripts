;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 119)
(include sci.sh)
(use Main)
(use EgoLooper)
(use Motion)
(use System)

(public
	DoMount 0
	DoDismount 1
)

(local
	local0
)

(instance DoMount of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 ignoreActors: 1)
				(if (== (gHorseObj loop:) 0)
					(gEgo
						setMotion:
							MoveTo
							(gHorseObj x:)
							(- (gHorseObj y:) 3)
							self
					)
				else
					(gEgo
						setMotion:
							MoveTo
							(gHorseObj x:)
							(+ (gHorseObj y:) 1)
							self
					)
				)
			)
			(1
				(= temp1 (gHorseObj x:))
				(= temp2 (gHorseObj y:))
				(gHorseObj dispose:)
				(EgoLooper dispose:)
				(gEgo
					view: (if (== (gHorseObj view:) 401) 13 else 66)
					loop: (gHorseObj loop:)
					cel: 0
					looper: 0
					posn: temp1 temp2
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(2
				(= temp0 (== (gEgo view:) 13))
				(gEgo
					view: (if temp0 9 else 8)
					cel: 0
					setCel: -1
					illegalBits: -32768
					ignoreActors: 0
					looper: gHorseTurnLooper
					setCycle: gHorseStopWalk (if temp0 65 else 64)
					setAvoider: 0
					cycleSpeed: 0
				)
				(= global116 1)
				(HandsOn)
				(client setScript: 0)
				(DisposeScript 119)
			)
		)
	)
)

(instance DoDismount of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local0 (gEgo illegalBits:))
				(gEgo illegalBits: 0)
				(cond
					((< (gEgo x:) 40)
						(gEgo setMotion: MoveTo 40 (gEgo y:) self)
					)
					((> (gEgo x:) 280)
						(gEgo setMotion: MoveTo 280 (gEgo y:) self)
					)
					(
						(&
							(OnControl
								CONTROL
								(gEgo x:)
								(- (gEgo y:) 5)
								(+ (gEgo x:) 5)
								(gEgo y:)
							)
							$8000
						)
						(gEgo
							setMotion:
								MoveTo
								(gEgo x:)
								(+ (gEgo y:) 5)
								self
						)
					)
					(
						(&
							(OnControl
								CONTROL
								(gEgo x:)
								(gEgo y:)
								(+ (gEgo x:) 5)
								(+ (gEgo y:) 5)
							)
							$8000
						)
						(gEgo
							setMotion:
								MoveTo
								(gEgo x:)
								(- (gEgo y:) 5)
								self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(if (== global116 6)
					(if (== (gEgo loop:) 0)
						(= global116 5)
					else
						(= global116 4)
					)
				)
				(cond
					((and (== global116 5) (!= (gEgo loop:) 0))
						(gEgo
							setMotion:
								MoveTo
								(+ (gEgo x:) 4)
								(gEgo y:)
								self
						)
					)
					((and (== global116 4) (!= (gEgo loop:) 1))
						(gEgo
							setMotion:
								MoveTo
								(- (gEgo x:) 4)
								(gEgo y:)
								self
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(gEgo
					view:
						(if (or (== (gEgo view:) 9) (== (gEgo view:) 65))
							13
						else
							66
						)
					baseSetter: 0
					setCel: 255
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(3
				(= temp0 (gEgo x:))
				(= temp1 (gEgo y:))
				(gEgo
					view: (if (== (gEgo view:) 13) 3 else 0)
					setAvoider: 0
					illegalBits: local0
					cel: 0
					posn:
						(gEgo x:)
						(if (== global116 5)
							(- (gEgo y:) 2)
						else
							(+ (gEgo y:) 2)
						)
					cycleSpeed: 0
					setCycle: 0
				)
				(= global115 gCurRoomNum)
				(= global116 2)
				(gEgo setScript: 0)
				(HandsOn)
				(DisposeScript 119)
				(gHorseObj
					posn: temp0 temp1
					loop: (gEgo loop:)
					view: (if (== (gEgo view:) 3) 401 else 408)
					init:
				)
				(gEgo looper: EgoLooper setCycle: Walk)
			)
		)
	)
)

