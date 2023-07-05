;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 113)
(include sci.sh)
(use Main)
(use rm15)
(use Motion)
(use User)

(public
	castDazzle 0
	castDet 1
)

(instance castDazzle of KScript
	(properties)

	(method (dispose)
		(proc15_1 1)
		(LookAt gEgo gKobold)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= register (User canControl:))
				(HandsOff)
				(LookAt gEgo gKobold)
				(gEgo
					view: 521
					setLoop: (- 3 global348)
					cel: 0
					cycleSpeed: 2
					setCycle: CT 4 1 self
				)
			)
			(1
				(gKobold setScript: (ScriptID 15 4)) ; kobDazzle
				(gEgo setCycle: End)
				(= cycles 6)
			)
			(2
				(gEgo cycleSpeed: 0)
				(self dispose:)
			)
		)
	)
)

(instance castDet of KScript
	(properties)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register 0)
				(= cycles 1)
				(if
					(or
						(gEgo has: 5) ; key
						[gInvDropped 5] ; key
						(gCast contains: (ScriptID 15 3)) ; kobKey
					)
					(LowPrint 113 0) ; "A strong magical aura radiates from the Kobold's key."
					(= register 1)
					(if (and (not (IsFlag 150)) (not (IsFlag 147)))
						(= cycles 0)
						((ScriptID 15 3) ; kobKey
							show:
							view: 175
							setLoop: 8
							cel: 0
							setPri: (gKobold priority:)
							z: 13
							cycleSpeed: 1
							setCycle: End self
						)
					)
				)
			)
			(1
				(if (not (IsFlag 147))
					(if (not (IsFlag 150))
						((ScriptID 15 3) hide:) ; kobKey
					)
					((ScriptID 15 3) ; kobKey
						view: 178
						setLoop: 6
						setCel: 12
						setPri: (if global348 5 else -1)
						z: 0
					)
				)
				(= cycles 1)
				(cond
					((gCast contains: (ScriptID 15 2)) ; chest
						(LowPrint 113 1) ; "You see the outline of a chest glowing in the south end of the cavern."
						(= register 1)
						(= cycles 0)
						((ScriptID 15 2) ; chest
							cel: 0
							cycleSpeed: 1
							setCycle: End self
						)
					)
					((not (IsFlag 175))
						(LowPrint 113 2) ; "You can detect a faint glimmering of magic from the shattered remains of the chest."
						(= register 1)
					)
				)
			)
			(2
				(if (not register)
					(LowPrint 113 3) ; "There no longer seem to be any magical effects or spells active in this part of the cavern."
				)
				(self dispose:)
			)
		)
	)
)

