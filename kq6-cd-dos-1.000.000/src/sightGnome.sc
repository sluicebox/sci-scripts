;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 458)
(include sci.sh)
(use Main)
(use rm450)
(use n913)
(use Motion)
(use System)

(public
	sightGnome 0
)

(instance sightGnome of Gnome
	(properties
		x 179
		noun 12
		view 458
		EOLx 96
		FOLx 145
		startPoint 5
	)

	(method (init)
		(self gnomeScript: sightScript setScript: sightInit stopUpd:)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: noun theVerb 22 1 0 450) ; "A gnome with gigantic eyes is standing before Alexander."
		else
			((ScriptID 450 6) setScript: sightScript 0 theVerb) ; gnomeGroup
		)
	)
)

(instance sightInit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gMessager say: 12 0 14 1 self 450) ; "Old Bill Batter, never fatter, vision can resolve this matter. Look you now, and end this chatter!"
			)
			(2
				(DisposeScript 1037)
				(UnLoad 128 8930)
				(((ScriptID 450 6) script:) cue:) ; gnomeGroup
				(self dispose:)
			)
		)
	)
)

(instance sightScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(switch register
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
						(gMessager say: 12 0 14 2 self 450) ; "Alexander holds the item out for the gnome with the enormous eyes."
					)
				)
			)
			(1
				(self setScript: (ScriptID 450 2) self register) ; giveItemScript
			)
			(2
				(sightGnome setLoop: 1 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(gGlobalSound3 number: 456 setLoop: 1 play:)
				(sightGnome setCycle: CT 5 1 self)
			)
			(4
				(gGlobalSound3 play:)
				(sightGnome setCycle: End self)
			)
			(5
				(gGlobalSound3 play:)
				(if (== register 83)
					(sightGnome setLoop: 4 cel: 0 setCycle: End self)
				else
					(self setScript: failScript 0 register)
				)
			)
			(6
				(sightGnome setLoop: 0 cel: 0)
				(= cycles 2)
			)
			(7
				(gMessager say: 2 83 14 2 self 450) ; "By all that's beauteous, fair, and sightly, four morons do I sleep with nightly! There's NOTHING THERE AT ALL I say! Enough of this, let's now away!"
			)
			(8
				((ScriptID 450 6) setScript: (ScriptID 450 3) 0 sightGnome) ; gnomeGroup, rightInvItem
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
					((== register 31)
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
				(sightGnome setLoop: 2 cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(gGlobalSound3 number: 456 setLoop: 1 play:)
				(sightGnome setCycle: CT 4 1 self)
			)
			(4
				(gGlobalSound3 play:)
				(sightGnome setCycle: CT 9 1 self)
			)
			(5
				(gGlobalSound3 number: 459 setLoop: 1 play:)
				(sightGnome setCycle: End self)
			)
			(6
				(SetFlag 59)
				(if (not register)
					(gMessager say: 16 0 32 1 self 450) ; "Of all the senses, eyes are best! A man, I say, and hang the rest!"
				else
					(gMessager say: 12 0 14 3 self 450) ; "My eyes cannot distracted be! A MAN I see, and so say me!"
				)
			)
			(7
				(ClearFlag 59)
				(sightGnome setLoop: 0 cel: 0)
				(self setScript: (ScriptID 450 4) self register) ; wrongInvItem
			)
			(8
				(gMessager say: 16 0 28 1 self 450) ; "A man, a man, so say our eyes! A man he be, a man he dies!"
			)
			(9
				(sightGnome addToPic: delete: dispose:)
				(= cycles 10)
			)
			(10
				((ScriptID 450 6) setScript: (ScriptID 450 5)) ; gnomeGroup, toTheSea
			)
		)
	)
)

