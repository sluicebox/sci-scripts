;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 806)
(include sci.sh)
(use Main)
(use Game)

(public
	Cemetery 0
)

(instance Cemetery of Rgn
	(properties)

	(method (handleEvent event &tmp [temp0 4])
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look,look>')
						(cond
							((Said '[<at,around][/!*,forest,greenery]')
								(HighPrint 806 0) ; "The late frosts of winter give way to to the greenery of spring. There is the crisp smell of cedar in the air. This forest seems to be unusually still and quiet."
							)
							((Said '/ghost')
								(if
									(or
										(!= ((ScriptID 805 5) script:) 0) ; twister
										(!= ((ScriptID 805 6) script:) 0) ; tumbler
										(!= ((ScriptID 805 7) script:) 0) ; swimmer
									)
									(HighPrint 806 1) ; "It IS a ghost...a transparent, decaying, writhing, slimy, undead fragment of undulating ectoplasm!"
									(HighPrint 806 2) ; "You might be near a graveyard!"
								else
									(HighPrint 806 3) ; "There are no ghosts here to look at."
								)
							)
							((Said '[<down][/ground,needle,moss,grass]')
								(HighPrint 806 4) ; "Pine needles, moss and early spring grasses cover the forest floor."
							)
							((Said '[<up][/sky,cloud,star,moon]')
								(if gNight
									(HighPrint 806 5) ; "The evening is clear and the stars are bright. Dark clouds pass over the moon."
								else
									(HighPrint 806 6) ; "The sky is a piercing blue with scudding white clouds."
								)
							)
							((Said '/birch,tree')
								(HighPrint 806 7) ; "You can see pines, cedars, birches and other trees frequently associated with mountain forests."
							)
							((Said '/bush')
								(HighPrint 806 8) ; "The low-lying bushes form tight tangles between the trees."
							)
							((Said '/boulder')
								(HighPrint 806 9) ; "The valley floor is covered by fine, moist soil with few large rocks."
							)
							((Said '/hill,cliff,peak,pass,pass')
								(HighPrint 806 10) ; "Looking through the surrounding woods, you occasionally are able to catch a glimpse of the snow-capped mountain peaks."
							)
							((Said '/cave')
								(HighPrint 806 11) ; "There are no caves here."
							)
						)
					)
					((Said 'japaneseclimbup,climb,climb')
						(HighPrint 806 12) ; "Climbing would serve no purpose right now."
					)
					((Said 'get,get/ghost')
						(if gNight
							(HighPrint 806 13) ; "You don't get ghosts. Ghosts get YOU!"
						else
							(HighPrint 806 14) ; "There aren't any."
						)
					)
					((Said 'drink,drink/grease,(potion,grease<ghost,ghoul)')
						(if (gEgo has: 39) ; grease
							(HighPrint 806 15) ; "That isn't drinkable -- it's an oil."
						else
							(HighPrint 806 16) ; "You can't. You don't have any."
						)
					)
					((Said 'use,rub/grease,(potion,grease<ghost,ghoul)')
						(if (gEgo has: 39) ; grease
							(HighPrint 806 17) ; "You feel a tingling sensation as you rub the unguent all over your body."
							(SetFlag 168)
							(ClearFlag 164)
							(= global220 150)
							(gEgo use: 39) ; grease
							(gEgo get: 26) ; empty bottle
							(if gNight
								(SolvePuzzle 682 2)
							)
						else
							(HighPrint 806 16) ; "You can't. You don't have any."
						)
					)
				)
			)
		)
	)
)

