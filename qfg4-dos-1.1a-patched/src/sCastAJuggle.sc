;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 807)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	sCastAJuggle 0
)

(local
	local0
)

(instance sCastAJuggle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 31) ; jugglingLightsSpell
				(sCastAJuggle setScript: (ScriptID 62) self) ; castJuggle
			)
			(1
				(gGlory handsOff:)
				(if (== ((ScriptID 800 5) cel:) 0) ; pSquidStone
					(if (> ((ScriptID 800 1) cel:) 0) ; pSquid
						(= local0 0)
						(self cue:)
					else
						(= local0 1)
						((ScriptID 800 1) ; pSquid
							init:
							approachVerbs: 43 ; theDarksign
							setCycle: End self
						)
					)
				else
					(self cue:)
				)
			)
			(2
				(if (== ((ScriptID 800 5) cel:) 0) ; pSquidStone
					(cond
						((== local0 0)
							(gMessager say: 15 6 33 0 self) ; "Since the runes are already visible, your spell has no effect."
						)
						((< (gEgo y:) 100)
							(gMessager say: 15 6 32 0 self) ; "Out of the corner of your eye, you briefly see something appear on the standing stone. You could probably see it better if you were on the lower ledge."
						)
						(else
							(gMessager say: 15 6 10 0 self) ; "Your Juggling Lights spell momentarily illuminates the scene with magical light."
						)
					)
				else
					(gMessager say: 15 6 34 0 self) ; "Nothing is happening at the moment. Maybe you'll have better luck the next time you return here."
				)
			)
			(3
				(if (== ((ScriptID 800 5) cel:) 0) ; pSquidStone
					(if (== local0 0)
						(self cue:)
					else
						((ScriptID 800 1) setCycle: Beg self) ; pSquid
					)
				else
					(self cue:)
				)
			)
			(4
				(if (and (== ((ScriptID 800 1) cel:) 0) (== local0 1)) ; pSquid
					((ScriptID 800 1) hide: dispose:) ; pSquid
				)
				(= ticks 6)
			)
			(5
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

