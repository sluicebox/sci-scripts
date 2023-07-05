;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 455)
(include sci.sh)
(use Main)
(use rm450)
(use n913)
(use Motion)
(use System)

(public
	smellGnome 0
)

(instance smellGnome of Gnome
	(properties
		x 197
		noun 14
		view 455
		EOLx 105
		FOLx 157
		startPoint 4
	)

	(method (init)
		(self gnomeScript: smellScript setScript: smellInit stopUpd:)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: noun theVerb 22 1 0 450) ; "A gnome with a huge nose stands before Alexander."
		else
			((ScriptID 450 6) setScript: smellScript 0 theVerb) ; gnomeGroup
		)
	)
)

(instance smellInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 14 0 24 1 self 450) ; "Old Tom Trow, smell your smell. Do that which you do so well."
			)
			(2
				(((ScriptID 450 6) script:) cue:) ; gnomeGroup
				(self dispose:)
			)
		)
	)
)

(instance smellScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 6)
			)
			(1
				(switch register
					(47
						(gMessager say: 14 47 24 1 self 450) ; "Alexander holds the flower of stench out to the gnome with the jumbo nose."
					)
					(83
						(self cue:)
					)
					(31
						(self cue:)
					)
					(37
						(gMessager say: 2 37 42 1 self 450) ; "Alexander winds the mechanical nightingale and plays it for the gnome."
					)
					(else
						(gMessager say: 14 0 24 2 self 450) ; "Alexander holds the item out for the gnome with the stupendous nose."
					)
				)
			)
			(2
				(self setScript: (ScriptID 450 2) self register) ; giveItemScript
			)
			(3
				(gGlobalSound3 number: 453 setLoop: 1 play:)
				(smellGnome setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(if (== register 47)
					(smellGnome
						setLoop: 4
						cel: 0
						cycleSpeed: 12
						setCycle: End self
					)
				else
					(self setScript: failScript 0 register)
				)
			)
			(5
				(smellGnome setLoop: 3 cycleSpeed: 6)
				(smellGnome cel: (smellGnome lastCel:) setCycle: Beg self)
			)
			(6
				(smellGnome cycleSpeed: 6 setLoop: 0 cel: 0)
				(gEgo setCycle: End self)
			)
			(7
				(if ((ScriptID 40 0) alexX:) ; rWonder
					(gEgo
						posn: ((ScriptID 40 0) alexX:) ((ScriptID 40 0) alexY:) ; rWonder, rWonder
					)
				)
				(if (!= (gEgo view:) 900)
					(gEgo reset: 1)
				)
				(= cycles 6)
			)
			(8
				(gMessager say: 14 47 24 2 self 450) ; "Tom Trow I am, that's all I'll be. My nose knows all on land and sea. A flower of stench has washed ashore. A flower, 'tis all, and nothing more!"
			)
			(9
				((ScriptID 450 6) setScript: (ScriptID 450 3) 0 smellGnome) ; gnomeGroup, rightInvItem
			)
		)
	)
)

(instance failScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(cond
					((or ((ScriptID 40 0) alexInvisible:) (== register 31)) ; rWonder
						(self state: (+ state 1) cue:)
					)
					(register
						(gEgo setCycle: End self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(1
				(if ((ScriptID 40 0) alexX:) ; rWonder
					(gEgo
						posn: ((ScriptID 40 0) alexX:) ((ScriptID 40 0) alexY:) ; rWonder, rWonder
					)
				)
				(if (!= (gEgo view:) 900)
					(gEgo reset: 1)
				)
				(if (not register)
					(smellGnome setLoop: 1 cel: 0 setCycle: End self)
					(gGlobalSound3 number: 453 setLoop: 1 play:)
				else
					(= cycles 1)
				)
			)
			(2
				(smellGnome setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(SetFlag 59)
				(if (not register)
					(gMessager say: 16 0 33 1 self 450) ; "Alert, my brothers, as we feared! A man, a man, has landed here!"
				else
					(gMessager say: 14 0 24 3 self 450) ; "My nose can not be tricked that way! The smell of man still rules the day!"
				)
			)
			(4
				(smellGnome setLoop: 3 cycleSpeed: 6)
				(smellGnome cel: (smellGnome lastCel:) setCycle: Beg self)
				(ClearFlag 59)
			)
			(5
				(self setScript: (ScriptID 450 4) self register) ; wrongInvItem
			)
			(6
				(gMessager say: 16 0 29 1 self 450) ; "A man, a man, so say our nose! Into the waiting sea he goes!"
			)
			(7
				(smellGnome addToPic: delete: dispose:)
				(= cycles 10)
			)
			(8
				((ScriptID 450 6) setScript: (ScriptID 450 5)) ; gnomeGroup, toTheSea
			)
		)
	)
)

