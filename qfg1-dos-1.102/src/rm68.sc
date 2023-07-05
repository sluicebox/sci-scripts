;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 68)
(include sci.sh)
(use Main)
(use Motion)
(use Game)

(public
	rm68 0
)

(instance rm68 of Rm
	(properties
		picture 68
		style 8
		horizon 30
		west 67
	)

	(method (dispose)
		(SetFlag 58)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(self setLocales: 804)
		(SL enable:)
		(NormalEgo)
		(gEgo
			posn:
				1
				(if (>= global106 150)
					(+= global106 14)
				else
					(+= global106 26)
				)
			init:
			setMotion: MoveTo 320 102
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,forest,greenery]')
								(HighPrint 68 0) ; "You are in a clearing at the edge of the forest. The road you have been following is completely blocked by a very recent avalanche."
							)
							((Said '/ice,road,avalanche')
								(HighPrint 68 1) ; "It appears that a very recent avalanche has sealed off the road leading out of the valley."
							)
							((Said '[<down][/ground,needle,moss,grass]')
								(HighPrint 68 2) ; "The meadow clearing in which you stand is grassy; the road is densely packed and slightly muddy."
							)
							((Said '[<up][/sky,cloud,star]')
								(if gNight
									(HighPrint 68 3) ; "The evening is clear and the stars are bright. Dark clouds pass over the moon."
								else
									(HighPrint 68 4) ; "The sky is a piercing blue with scudding white clouds."
								)
							)
							((Said '/birch,tree')
								(HighPrint 68 5) ; "You can see pines, cedars, birches and other trees frequently associated with mountain forests."
							)
							((Said '/bush')
								(HighPrint 68 6) ; "The low-lying bushes form tight tangles of shrubbery between the trees."
							)
							((Said '/boulder')
								(HighPrint 68 7) ; "A tumbled pattern of rocks can be seen at the forest's edge."
							)
							((Said '/hill,cliff,peak,pass')
								(HighPrint 68 8) ; "The ragged peaks of the snow-covered mountains can be seen clearly. The pass, however, is blocked by very recent avalanches."
							)
							((Said '/cave')
								(HighPrint 68 9) ; "There are no caves here."
							)
						)
					)
					((Said 'climb')
						(HighPrint 68 10) ; "Climbing would serve no purpose right now."
					)
					((Said '/dad')
						(HighPrint 68 11) ; "Hi, Kris!"
					)
					((Said '/clem')
						(HighPrint 68 12) ; "Hi, little kid!"
					)
					((Said '/bobpa')
						(HighPrint 68 13) ; "Hi, Max!"
					)
					((Said '/sid')
						(HighPrint 68 14) ; "Hi, Bridgette!"
					)
				)
			)
		)
		(super handleEvent: event)
	)
)

