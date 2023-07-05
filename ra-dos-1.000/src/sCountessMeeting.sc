;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 441)
(include sci.sh)
(use Main)
(use PolyPath)
(use Timer)
(use Motion)
(use System)

(public
	sCountessMeeting 0
	sCountessNoMeet 1
	sCountessLeaves 2
	sTalkWithCountess 3
	countTimer 4
)

(instance sCountessMeeting of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= cycles 1)
			)
			(2
				(self setScript: sCountessEnters self)
			)
			(3
				((ScriptID 90 1) setMotion: PolyPath 141 171 self) ; aCountess
			)
			(4
				((ScriptID 90 1) view: 444 loop: 0 cel: 0) ; aCountess
				(gGame handsOn:)
				(if (== (gEgo view:) 443)
					(gTheIconBar disable: 1 2 5 6)
				)
				(gTheIconBar enable: 7)
				(= cycles 1)
			)
			(5
				(= seconds 10)
			)
			(6
				(if (== (gEgo view:) 443)
					(gTheIconBar disable: 1 2 5 6)
				)
				(gGame handsOff:)
				(= cycles 3)
			)
			(7
				(if (== (gEgo view:) 443)
					((ScriptID 90 1) setCycle: End self) ; aCountess
				else
					(gGame handsOn: 1)
					(self dispose:)
				)
			)
			(8
				(= seconds 2)
			)
			(9
				((ScriptID 90 1) setCycle: Beg self) ; aCountess
			)
			(10
				(= seconds 3)
			)
			(11
				(gGame handsOn: 1)
				(client setScript: sCountessLeaves)
			)
		)
	)
)

(instance sCountessNoMeet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 3)
			)
			(1
				(= cycles 1)
			)
			(2
				(self setScript: sCountessEnters self)
			)
			(3
				(= seconds 2)
			)
			(4
				(client setScript: sCountessLeaves)
			)
		)
	)
)

(instance sCountessEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 90 1) ; aCountess
					moveTo: 440
					loop: 1
					x: 240
					y: 134
					actions: askQuestions
				)
				(if ((ScriptID 90 1) scaler:) ; aCountess
					(((ScriptID 90 1) scaler:) doit:) ; aCountess
				)
				(= cycles 1)
			)
			(1
				((ScriptID 90 1) view: 825) ; aCountess
				(if (== ((ScriptID 440 2) state:) 0) ; rm440Door
					((ScriptID 440 2) caller: self open:) ; rm440Door
				else
					(= cycles 1)
				)
			)
			(2
				((ScriptID 90 1) setMotion: PolyPath 122 154 self) ; aCountess
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sCountessLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 443)
					(gTheIconBar disable: 1 2 5 6)
				else
					(gWalkHandler delete: gCurRoom)
					(gDirectionHandler delete: gCurRoom)
				)
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 90 1) ; aCountess
					view: 825
					setCycle: Walk
					setMotion: PolyPath 122 154 self
				)
			)
			(2
				((ScriptID 90 1) setMotion: PolyPath 233 134 self) ; aCountess
			)
			(3
				((ScriptID 90 1) setMotion: PolyPath 239 134 self) ; aCountess
			)
			(4
				(if (== (gEgo view:) 443)
					(gGame handsOn: 1)
					(gUser canControl: 1)
				else
					(gGame handsOn:)
				)
				((ScriptID 90 1) actions: 0 moveTo: 430 wandering: 1) ; aCountess
				(countTimer dispose:)
				(gGameMusic2 fade:)
				(WrapMusic pause: 0)
				(self dispose:)
				(DisposeScript 441)
			)
		)
	)
)

(instance sTalkWithCountess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 100 172 self)
			)
			(1
				(gMessager say: 1 0 1 0 self 1440) ; "Well, well. Good evening, Countess."
			)
			(2
				(SetFlag 120)
				(countTimer setReal: countTimer 15)
				(gGame handsOn: 1)
				(gTheIconBar enable: 1 2 5 6)
				(self dispose:)
			)
		)
	)
)

(instance askQuestions of Actions
	(properties)

	(method (doVerb theVerb)
		(return
			(switch theVerb
				(6 ; Ask
					(if (== (gEgo view:) 443)
						(gCurRoom setScript: (ScriptID 440 1)) ; sOutTapestry
					else
						(switch (gCurRoom setInset: (ScriptID 20 0)) ; inNotebook
							(1030
								(gMessager say: 1 6 2 0 0 1440) ; "I saw an interesting diary in Carrington's wall safe. It belonged to Sterling Waldorf-Carlton, your former husband."
								(countTimer
									seconds: (+ (countTimer seconds:) 10)
								)
							)
							(else
								(gMessager say: 1 6 4 0 0 1440) ; "I don't feel like talking about that now!"
								(countTimer seconds: 1)
							)
						)
					)
					1
				)
				(2 ; Talk
					(if (== (gEgo view:) 443)
						(gCurRoom setScript: (ScriptID 440 1)) ; sOutTapestry
					else
						(gMessager say: 1 2 0 0 0 1440) ; "You're not looking well, Countess."
					)
				)
				(17 ; pocketWatch
					(gMessager say: 1 17 0 0 0 1440) ; "Does this look familiar?"
					(countTimer seconds: (+ (countTimer seconds:) 10))
				)
				(else 0)
			)
		)
	)
)

(instance countTimer of Timer
	(properties)

	(method (cue)
		(cond
			((not ((ScriptID 90 1) mover:)) ; aCountess
				((ScriptID 90 1) setScript: sCountessLeaves) ; aCountess
			)
			(((ScriptID 90 1) script:) ; aCountess
				(((ScriptID 90 1) script:) next: sCountessLeaves) ; aCountess
			)
		)
	)
)

