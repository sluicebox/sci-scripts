;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 195)
(include sci.sh)
(use Main)
(use n128)
(use n142)
(use Interface)
(use Motion)
(use System)

(public
	DrinkElix 0
	EatAppl 1
	egoKeelsOvr 2
)

(instance DrinkElix of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (not (IsFlag 193)) (not global171))
					(Print 195 0) ; "May I advise caution here? Do not rush to use the elixir until it seems absolutely necessary."
					(SetFlag 193 1)
					(self dispose:)
				else
					(HandsOff)
					(if (IsFlag 177)
						(Print 195 1) ; "Aye, do what you will with it. Though it will cure the poison, it will never cleanse you of the crime of noble Galahad's death."
					)
					(proc142_2 self)
				)
			)
			(1
				(PutItem 5) ; sleeve | elixir
				(if global171
					(if (not (IsFlag 310))
						(Print 195 2) ; "The miraculous elixir burns like fire through your veins as it purges you of the poison. You are entirely cured....as long as you are not bitten again."
					)
				else
					(Print 195 3) ; "That was a bloody waste."
				)
				(= global167 0)
				(= global171 0)
				(if (== (gEgo view:) 57)
					(gEgo view: 0)
				)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 195)
	)
)

(instance EatAppl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc142_0 self)
			)
			(1
				(if (not global171)
					(Print 195 4) ; "The apple works its spell. Your hunger and thirst vanish. The heaviness of your limbs is lightened."
				else
					(Print 195 5) ; "The apple's potent spell has relieved your hunger and thirst and given you a new surge of strength."
					(Print 195 6) ; "But alas, it cannot stop the poison of the rat's bite from killing you, it can only delay the final end."
					(if (< global167 21999)
						(+= global167 10000)
					else
						(= global167 32000)
					)
					(if (== (gEgo view:) 57)
						(gEgo view: 0)
					)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 195)
	)
)

(instance egoKeelsOvr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not global124)
					(self changeState: 1)
				else
					(= global124 0)
					(gEgo
						view: 4
						cel: (if (== (gEgo loop:) 2) 6 else 5)
						setCycle: Beg self
					)
				)
			)
			(1
				(gEgo
					view: 49
					setLoop: 0
					setCel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(gEgo
					setLoop: (if (< (gEgo y:) 150) 2 else 1)
					setCel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(EgoDead 195 7) ; "Alas, the rat's poison has taken its toll and the cold hand of Death has closed upon you forever."
			)
		)
	)
)

