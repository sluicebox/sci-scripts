;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4561)
(include sci.sh)
(use Main)
(use rm450)
(use Motion)
(use System)

(public
	tasteGnome 0
)

(instance tasteGnome of Gnome
	(properties
		x 190
		noun 17
		view 4561
		EOLx 95
		FOLx 149
		startPoint 3
	)

	(method (init)
		(self gnomeScript: tasteScript setScript: tasteInit stopUpd:)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: noun theVerb 22 1 0 450) ; "A squatty little gnome stands before Alexander. He has a huge mouth and a very long, curled up tongue."
		else
			((ScriptID 450 6) setScript: tasteScript 0 theVerb) ; gnomeGroup
		)
	)
)

(instance tasteInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 17 0 39 1 self 450) ; "Taste, Grump-Frump, that we might know, whether friend or whether foe."
			)
			(2
				(((ScriptID 450 6) script:) cue:) ; gnomeGroup
				(self dispose:)
			)
		)
	)
)

(instance tasteScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(switch register
					(63
						(gMessager say: 17 63 39 1 self 450) ; "Alexander holds the mint out for the gnome with the gigantic mouth."
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
						(gMessager say: 17 0 39 2 self 450) ; "Alexander holds the item out for the gnome with the oversized mouth."
					)
				)
			)
			(1
				(self setScript: (ScriptID 450 2) self register) ; giveItemScript
			)
			(2
				(gGlobalSound3 number: 454 setLoop: 1 play:)
				(tasteGnome setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(if (== register 63)
					(tasteGnome setLoop: 4 cel: 0 setCycle: End self)
				else
					(self setScript: failScript 0 register)
				)
			)
			(4
				(tasteGnome setLoop: 0 cel: 0)
				(gEgo setCycle: End self)
			)
			(5
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
			(6
				(gMessager say: 17 63 39 2 self 450) ; "Grump-Frump knows a tasty treat. It matters not what others bleat! No danger is this one so sweet!"
			)
			(7
				(gEgo put: 23 450) ; mint
				(gTheIconBar curIcon: (gTheIconBar at: 0))
				((ScriptID 450 6) setScript: (ScriptID 450 3) 0 tasteGnome) ; gnomeGroup, rightInvItem
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
				(= cycles 2)
			)
			(2
				(if (not register)
					(tasteGnome setCycle: Beg self)
					(gGlobalSound3 number: 454 setLoop: 1 play:)
				else
					(= cycles 1)
				)
			)
			(3
				(tasteGnome setLoop: 2 setCycle: End self)
			)
			(4
				(tasteGnome setCycle: Beg self)
			)
			(5
				(if (not register)
					(gMessager say: 16 0 35 1 self 450) ; "My tongue betrays this one so sly! A man it is! I tell no lie!"
				else
					(gMessager say: 17 0 39 3 self 450) ; "My tongue dislikes this sour thing, and the taste of man all o're it clings!"
				)
			)
			(6
				(self setScript: (ScriptID 450 4) self register) ; wrongInvItem
			)
			(7
				(gMessager say: 16 0 31 1 self 450) ; "A man, a man, so say our tongue! To the Realm of the Dead we send this one!"
			)
			(8
				(tasteGnome addToPic: delete: dispose:)
				(= cycles 10)
			)
			(9
				((ScriptID 450 6) setScript: (ScriptID 450 5)) ; gnomeGroup, toTheSea
			)
		)
	)
)

