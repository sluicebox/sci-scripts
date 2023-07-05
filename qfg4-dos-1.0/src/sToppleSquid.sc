;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 806)
(include sci.sh)
(use Main)
(use PolyPath)
(use Motion)
(use System)

(public
	sToppleSquid 0
	sPushOver 1
)

(local
	local0
	local1
)

(instance sToppleSquid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo trySkill: 22) ; triggerSpell
				(gWalkHandler addToFront: (ScriptID 800 5)) ; pSquidStone
				(if (== ((ScriptID 800 1) loop:) 6) ; pSquid
					(= local0 1)
					((ScriptID 800 1) setLoop: 0 setCel: 0) ; pSquid
				else
					(= local0 0)
				)
				(self cue:)
			)
			(1
				(if local0
					((ScriptID 800 1) hide: dispose:) ; pSquid
				)
				(= cycles 1)
			)
			(2
				((ScriptID 800 5) setPri: 64 setCycle: End self) ; pSquidStone
			)
			(3
				(gMessager say: 4 82 0 0 self) ; "The earth shakes slightly as the standing stone rocks on its base, then falls over to form a bridge up to the upper ledge."
			)
			(4
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPushOver of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath 152 162 self)
			)
			(1
				(gEgo
					view: 31
					posn: 151 166
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
			)
			(2
				(if (== (gEgo trySkill: 0 300) 1) ; strength
					(= local1 1)
					(gWalkHandler addToFront: (ScriptID 800 5)) ; pSquidStone
					(if (== ((ScriptID 800 1) loop:) 6) ; pSquid
						(= local0 1)
						((ScriptID 800 1) setLoop: 0 setCel: 0) ; pSquid
					else
						(= local0 0)
					)
					(self cue:)
				else
					(gMessager say: 4 4 7 0 self) ; "The stone moves slightly as you push on it, but you aren't strong enough to push it all the way over."
				)
			)
			(3
				(if local1
					(if local0
						((ScriptID 800 1) hide: dispose:) ; pSquid
					)
					((ScriptID 800 5) setPri: 64 setCel: 0 setCycle: End) ; pSquidStone
				)
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo posn: 152 164 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

