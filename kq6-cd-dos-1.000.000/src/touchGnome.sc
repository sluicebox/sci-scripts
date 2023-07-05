;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 457)
(include sci.sh)
(use Main)
(use rm450)
(use n913)
(use Motion)
(use System)

(public
	touchGnome 0
)

(instance touchGnome of Gnome
	(properties
		x 187
		noun 18
		view 457
		EOLx 96
		FOLx 140
		startPoint 5
	)

	(method (init)
		(self gnomeScript: touchScript setScript: touchInit stopUpd:)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: noun theVerb 22 1 0 450) ; "A gnome with very large hands stands in front of Alexander."
		else
			((ScriptID 450 6) setScript: touchScript 0 theVerb) ; gnomeGroup
		)
	)
)

(instance touchInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 18 0 41 1 self 450) ; "Trilly Dilly, use your hands. Is it beast, or is it man?"
			)
			(2
				(((ScriptID 450 6) script:) cue:) ; gnomeGroup
				(self dispose:)
			)
		)
	)
)

(instance touchScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(switch register
					(68
						(gMessager say: 18 68 41 1 self 450) ; "Alexander holds the rabbit's foot out for the gnome with the huge hands."
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
						(gMessager say: 18 0 41 2 self 450) ; "Alexander holds the item out for the gnome with the massive hands."
					)
				)
			)
			(1
				(self setScript: (ScriptID 450 2) self register) ; giveItemScript
			)
			(2
				(gGlobalSound3 number: 455 setLoop: 1)
				(touchGnome setLoop: 1 cel: 0 setCycle: CT 6 1 self)
			)
			(3
				(gGlobalSound3 play:)
				(touchGnome setCycle: End self)
			)
			(4
				(gGlobalSound3 play:)
				(= cycles 1)
			)
			(5
				(if (== register 68)
					(touchGnome setLoop: 4 cel: 0 setCycle: End self)
				else
					(self setScript: failScript 0 register)
				)
			)
			(6
				(gEgo setCycle: End self)
				(touchGnome setLoop: 3)
				(touchGnome cel: (- (NumCels touchGnome) 1) setCycle: Beg self)
			)
			(7 0)
			(8
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
			(9
				(gMessager say: 18 68 41 2 self 450) ; "Be all you mad? What aileth thee? A bunny can't trill merrily! A hare does not at all taste sweet! A rabbit here is all we greet."
			)
			(10
				((ScriptID 450 6) setScript: (ScriptID 450 3) 0 touchGnome) ; gnomeGroup, rightInvItem
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
					(gGlobalSound3 number: 455 setLoop: 1)
					(touchGnome setLoop: 1 cel: 0 setCycle: CT 6 1 self)
				else
					(= cycles 1)
				)
			)
			(3
				(if (not register)
					(gGlobalSound3 play:)
					(touchGnome setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(4
				(if (not register)
					(gGlobalSound3 play:)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(5
				(touchGnome setLoop: 2 cel: 0 setCycle: End self)
			)
			(6
				(SetFlag 59)
				(if (not register)
					(gMessager say: 16 0 36 1 self 450) ; "My hands know what the rest do not! A man is standing on this spot!"
				else
					(gMessager say: 18 0 41 3 self 450) ; "My hands cannot be led astray. A man is here, that's plain as day!"
				)
			)
			(7
				(touchGnome cel: 4)
				(touchGnome setCycle: Beg self)
			)
			(8
				(touchGnome setLoop: 3)
				(touchGnome cel: (touchGnome lastCel:) setCycle: Beg self)
				(ClearFlag 59)
			)
			(9
				(self setScript: (ScriptID 450 4) self register) ; wrongInvItem
			)
			(10
				(gMessager say: 16 0 37 1 self 450) ; "A man, a man, so say our hands! We act at the vizier's command!"
			)
			(11
				(touchGnome addToPic: delete: dispose:)
				(= cycles 10)
			)
			(12
				((ScriptID 450 6) setScript: (ScriptID 450 5)) ; gnomeGroup, toTheSea
			)
		)
	)
)

