;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 804)
(include sci.sh)
(use Main)
(use LoadMany)
(use Game)

(public
	Forest 0
)

(local
	local0
)

(instance Forest of Locale
	(properties)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(Load rsVIEW 510)
		(LoadMany rsSCRIPT 103 102)
		(if (and (>= (= temp0 (gCurRoom picture:)) 704) (<= temp0 707))
			(= local0 1)
		)
		(= temp1 (if gNight 32 else 25))
		(if (or (== (gContMusic state:) 0) (!= (gContMusic number:) temp1))
			(gContMusic stop: number: temp1 loop: -1 priority: 0 play:)
		)
		(if (and (<= gHowFast 1) (>= temp0 700) (<= temp0 707))
			(= global201 1)
			(EgoGait -1 0)
		)
	)

	(method (dispose)
		(= global201 0)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return)
		)
		(switch (event type:)
			(evSAID
				(cond
					((super handleEvent: event))
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,forest,greenery,clearing]')
								(if local0
									(HighPrint 804 0) ; "You are in a clearing at the edge of the forest. You are faced with impassably steep, rocky escarpments on two sides."
								else
									(HighPrint 804 1) ; "The late frosts of winter give way to to the greenery of spring. There is the crisp smell of cedar in the air. This forest seems to be unusually still and quiet."
								)
							)
							((Said '[<down][/ground,needle,moss,grass]')
								(if local0
									(HighPrint 804 2) ; "The meadow clearing in which you stand is grassy and littered with blown pine needles and small mossy rocks."
								else
									(HighPrint 804 3) ; "Pine needles, moss, and early spring grasses cover the forest floor."
								)
							)
							((Said '[<up][/sky,cloud,star,moon]')
								(if gNight
									(HighPrint 804 4) ; "The evening is clear and the stars are bright. Dark clouds pass over the moon."
								else
									(HighPrint 804 5) ; "The sky is a piercing blue with scudding white clouds."
								)
							)
							((Said '/birch,tree')
								(HighPrint 804 6) ; "You can see pines, cedars, birches and other trees frequently associated with mountain forests."
							)
							((Said '/bush')
								(HighPrint 804 7) ; "The low-lying bushes form tight tangles of shrubbery between the trees."
							)
							((Said '/boulder')
								(if local0
									(HighPrint 804 8) ; "A tumbled pattern of rocks and boulders leads upwards to the steep cliffs and peaks of the mountain range surrounding this small valley."
								else
									(HighPrint 804 9) ; "The valley floor is covered with fine, moist soil with few rocks."
								)
							)
							((Said '/hill,cliff,peak,pass')
								(if local0
									(HighPrint 804 8) ; "A tumbled pattern of rocks and boulders leads upwards to the steep cliffs and peaks of the mountain range surrounding this small valley."
								else
									(HighPrint 804 10) ; "Looking through the surrounding woods, you occasionally are able to catch a glimpse of the snow-capped mountain peaks."
								)
							)
							((Said '/cave')
								(HighPrint 804 11) ; "There are no caves here."
							)
						)
					)
					((Said 'climb')
						(HighPrint 804 12) ; "Climbing would serve no purpose right now."
					)
					(
						(or
							(Said 'get/boulder,brick')
							(Said 'lockpick<up,boulder,brick')
						)
						(gEgo setScript: (ScriptID 103 0)) ; getRock
					)
					((Said 'kiss/tree')
						(HighPrint 804 13) ; "Let's see how much fun you have pulling splinters from your lips."
					)
				)
			)
		)
	)
)

