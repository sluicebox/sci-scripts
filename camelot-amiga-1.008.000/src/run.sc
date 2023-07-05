;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 114)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use System)

(public
	run 0
)

(local
	[local0 7] = [145 325 170 325 -5 250 -5]
	[local7 7] = [235 126 235 73 75 -5 60]
)

(instance run of Script
	(properties)

	(method (dispose)
		((ScriptID 130 0) dispose:) ; Jabir
		(super dispose:)
		(DisposeScript 114)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (IsFlag 126)
					(ClearFlag 126)
					(Print 114 0) ; "Jabir likes not the flash of your steel."
				else
					(Print 114 1) ; "Jabir likes not the sound of your steel being drawn."
				)
				(switch gCurRoomNum
					(36
						(= temp0 2)
						(= temp1 0)
					)
					(37
						(= temp0 0)
						(= temp1 1)
					)
					(38
						(= temp0 2)
						(= temp1 2)
					)
					(42
						(= temp0 0)
						(= temp1 3)
					)
					(44
						(if (> (gEgo x:) 155)
							(= temp0 1)
							(= temp1 4)
						else
							(= temp0 3)
							(= temp1 5)
						)
					)
					(45
						(= temp0 1)
						(= temp1 6)
					)
				)
				(HandsOff)
				((ScriptID 130 1) hide:) ; jabirHead
				((ScriptID 130 0) ; Jabir
					view: 399
					ignoreActors: 1
					ignoreHorizon: 1
					illegalBits: 0
					cycleSpeed: 0
					setCycle: Walk
					setStep: 9 6
					setLoop: temp0
					setMotion: MoveTo [local0 temp1] [local7 temp1] self
				)
			)
			(1
				(Print 114 2) ; "You have set Jabir to his heels. Let us hope that will be the last of him. You have no strength to spare for chasing him."
				(HandsOn)
				(= global125 2)
				(self dispose:)
			)
		)
	)
)

