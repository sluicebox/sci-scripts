;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 155)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rgCove 0
)

(instance rgCove of Locale
	(properties)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'talk/friend')
						(if
							(and
								(gCast contains: global112)
								(global112 inRect: 0 0 320 200)
							)
							(if (> global186 800)
								(Print 155 0) ; "Keith stammers, "S-Sonny! Bains... he was SHOOTING at you!""
							else
								(Print 155 1) ; ""I'm with you, Sonny!" Keith responds."
							)
						else
							(Print 155 2) ; "Keith's not here."
						)
					)
					((Said 'talk,tell>')
						(Print 155 3) ; "Who are you talking to?"
						(event claimed: 1)
					)
					((Said 'follow')
						(Print 155 4) ; "Go ahead."
					)
					((Said 'look,frisk/blood,mark,clue')
						(Print 155 5) ; "That's a good idea. Do that."
					)
					((Said 'look>')
						(cond
							((Said '/woman<bag')
								(Print 155 6) ; "She looks awfully mean, and you decide to stay here where it's safe."
							)
							((or (Said '/willow[<cunt]') (Said '/ass<cat'))
								(Print 155 7) ; "These are of a species known as "Gargantium Pussiwilliums""
							)
							((Said '/tree')
								(Print 155 8) ; "The trees provide shade in the summer, and drop a lot of leaves in the fall."
							)
							((Said '/bush')
								(Print 155 9) ; "Although you admire the beauty of the shrubbery, you see nothing out of the ordinary."
							)
							((Said '[<up,at][/air,cloud]')
								(Print 155 10) ; "You gaze into the expanses of the upper atmosphere, and ponder the wonder of it all. More relaxed now, you return your attention to Cotton Cove."
							)
							((Said '[<at,down][/dirt,grass,path,dirt]')
								(if (< (gEgo y:) 163)
									(Print 155 11) ; "The grass is green, and the ants are waiting to be invited to a picnic. Many shoes have left their impressions in the sandy soil."
								else
									(Print 155 12) ; "Broken, black asphalt is all you see beneath your feet."
								)
							)
							((Said '/lake')
								(Print 155 13) ; "The nearest lake is 40 miles away. Clearwater River is nearby, however."
							)
							((Said '/rock')
								(Print 155 14) ; "You see nothing special about the rocks, but it's nice you don't take them for granite."
							)
							((Said '[<at,across][/bank,cliff,(side<other)]')
								(if (== (gEgo loop:) 3)
									(Print 155 15) ; "You see nothing unusual about the bank across the river."
								else
									(Print 155 16) ; "How can you see it? You aren't looking at it."
								)
							)
							((Said '/clearwater,water')
								(if (== (gEgo loop:) 3)
									(if (< (gEgo y:) 95)
										(Print 155 17) ; "Clearwater River deserves its name. Fed by mountain streams, its water is icy cold, and flows very rapidly through the rocks."
									else
										(Print 155 18) ; "To really see why Clearwater River got its name, you must get closer."
									)
								else
									(Print 155 16) ; "How can you see it? You aren't looking at it."
								)
							)
							((Said '/culdesac,ave')
								(if
									(or
										(== (gEgo loop:) 2)
										(> (gEgo y:) 158)
									)
									(Print 155 19) ; "The pavement doesn't hold your interest."
								else
									(Print 155 16) ; "How can you see it? You aren't looking at it."
								)
							)
							((Said '/man,person')
								(Print 155 20) ; "Who are you looking for?"
							)
							((Said '[<around,up][/!*,cove,chamber]')
								(event claimed: 1)
								(if (Random 0 1)
									(Print 155 21) ; "Cotton Cove with its greenery, is a quiet recreational area, with the Clearwater River flowing in the background."
								else
									(Print 155 22) ; "You're in Cotton Cove. You remember the care-free days of your youth when you played cops and robbers here. Now, however, it's very real...and much more serious."
								)
								(if (and (== global100 5) (not global183))
									(Print 155 23) ; "You have an unneasy feeling, as though you are being watched."
								)
							)
						)
					)
					((Said 'climb/tree')
						(Print 155 24) ; "Unless you're a monkey, bear, squirrel, chipmunk, or some other tree dwelling animal, you don't need to do that."
					)
					((Said 'cross,(jump<in)/water,clearwater')
						(Print 155 25) ; "Not a good idea."
					)
					((Said 'get,hoist,move/rock')
						(Print 155 26) ; "You don't need it."
					)
					((Said 'get/grass')
						(Print 155 27) ; "No where in the game will grass help you."
					)
					((Said 'enter,swim,fish[/clearwater,water]')
						(if (< (gEgo y:) 97)
							(Print 155 28) ; "It is tempting, but you're not on vacation."
						else
							(Print 155 29) ; "From way over here?"
						)
					)
					((Said 'frisk[/billfold]')
						(event claimed: 0)
					)
					((Said 'frisk>')
						(event claimed: 1)
						(Print 155 30) ; "Just look around."
					)
				)
			)
		)
	)
)

