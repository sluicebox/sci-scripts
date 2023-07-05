;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 122)
(include sci.sh)
(use Main)
(use n819)
(use Motion)
(use System)

(public
	transition 0
)

(instance transition of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 122)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(gEgo setPri: 7 setMotion: MoveTo 181 111 self)
			)
			(1
				(NormalDelph)
				(gDelph
					posn: 8 -15
					z: 0
					ignoreActors:
					ignoreHorizon:
					setPri: 7
					init:
					setMotion: MoveTo 99 101 self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				((ScriptID 2 0) init: 1 0 0 3 1 self) ; Delphineus, "You met the Oracle, huh?! What'd she say, Adam, what'd she say?!"
			)
			(4
				((ScriptID 2 1) init: 2 0 0 2 1 self) ; Adam, "She says I should find a 'Sign of Trust' from the citizens. What could she mean, Del?"
			)
			(5
				((ScriptID 2 0) init: 1 0 0 4 1 self) ; Delphineus, "Hmmm. A sign of trust, eh? Beats me. Maybe you should talk to the city's Mayor and the Guardian of the Greens. If you can find them, that is. I've seen hardly anyone since I've been back."
			)
			(6
				(= temp0 (if (IsFlag 27) 10 else 3))
				((ScriptID 2 1) init: 2 0 0 temp0 1 self) ; Adam
			)
			(7
				((ScriptID 2 0) init: 1 0 0 5 1 self) ; Delphineus, "Somewhere INDOORS! I'll meet you back at the Fish Apartments later. Come by if you can't find who you're lookin' for."
			)
			(8
				(gDelph setMotion: MoveTo 15 -60 self)
			)
			(9
				(gDelph hide:)
				(NormalEgo 1)
				(gEgo ignoreHorizon: setPri: 7)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

