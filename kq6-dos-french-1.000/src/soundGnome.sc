;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 456)
(include sci.sh)
(use Main)
(use rm450)
(use n913)
(use Motion)
(use System)

(public
	soundGnome 0
)

(instance soundGnome of Gnome
	(properties
		x 191
		noun 15
		view 456
		EOLx 99
		FOLx 146
		startPoint 2
	)

	(method (init)
		(self gnomeScript: soundScript setScript: soundInit stopUpd:)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: noun theVerb 22 1 0 450) ; "An odd-looking gnome stands before Alexander. He has incredibly huge ears!"
		else
			((ScriptID 450 6) setScript: soundScript 0 theVerb) ; gnomeGroup
		)
	)
)

(instance soundInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 15 0 12 1 self 450) ; "Listen! Hark you, Grovernor! Do your duty as you swore. With your ears, please tell us more."
			)
			(2
				(((ScriptID 450 6) script:) cue:) ; gnomeGroup
				(self dispose:)
			)
		)
	)
)

(instance soundScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(switch register
					(37
						(gMessager say: 15 37 12 1 self 450) ; "Alexander winds the tin nightingale and plays it for the gnome with the monumental ears."
					)
					(83
						(self cue:)
					)
					(31
						(SetFlag 59)
						(gMessager say: 15 31 12 1 self 450) ; "Alexander plays the flute for the gnome with the huge ears."
					)
					(else
						(gMessager say: 15 0 12 2 self 450) ; "Alexander holds the item out for the gnome with the immense ears."
					)
				)
			)
			(1
				(self setScript: (ScriptID 450 2) self register) ; giveItemScript
			)
			(2
				(if (== register 37)
					(soundGnome setLoop: 4 cel: 0 setCycle: End self)
				else
					(self setScript: failScript 0 register)
				)
			)
			(3
				(soundGnome setLoop: 3 cycleSpeed: 6)
				(soundGnome cel: (soundGnome lastCel:) setCycle: Beg self)
			)
			(4
				(soundGnome setLoop: 0 cel: 0)
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
				(gMessager say: 15 37 12 2 self 450) ; "A nose is not a way to spy! My ears cannot be told a lie. A nightingale is all there be. No man is near, and so say me!"
			)
			(7
				((ScriptID 450 6) setScript: (ScriptID 450 3) 0 soundGnome) ; gnomeGroup, rightInvItem
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
				(soundGnome setLoop: 2 cel: 0 setCycle: End self)
			)
			(3
				(soundGnome setCycle: Beg self)
			)
			(4
				(SetFlag 59)
				(cond
					((not register)
						(gMessager say: 16 0 34 1 self 450) ; "My ears can't miss that strong heartbeat! A man it is, a man we greet!"
					)
					((== register 31)
						(gMessager say: 15 31 12 2 self 450) ; "A flute, it's true, is a harmless thing, but the man who blows it--there's the sting!"
					)
					(else
						(gMessager say: 15 0 12 3 self 450) ; "My ears can hear nothing so clear, as the sound of a man standing here!"
					)
				)
			)
			(5
				(soundGnome setLoop: 3 cycleSpeed: 6)
				(soundGnome cel: (soundGnome lastCel:) setCycle: Beg self)
				(ClearFlag 59)
			)
			(6
				(self setScript: (ScriptID 450 4) self register) ; wrongInvItem
			)
			(7
				(gMessager say: 16 0 30 1 self 450) ; "A man, a man, so say our ears! We shall send him to his bier!"
			)
			(8
				(soundGnome addToPic: delete: dispose:)
				(= cycles 10)
			)
			(9
				((ScriptID 450 6) setScript: (ScriptID 450 5)) ; gnomeGroup, toTheSea
			)
		)
	)
)

