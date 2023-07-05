;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)

(public
	Eat 0
)

(procedure (Eat event &tmp haveEaten)
	(= haveEaten 0)
	(cond
		((Said '/mushroom,toadstool')
			(cond
				((and (not (gEgo has: 30)) (!= gCurRoomNum 70)) ; magic mushroom
					(HighPrint 6 0) ; "You don't have any."
				)
				((IsFlag 174)
					(gEgo use: 30 3) ; magic mushroom
					(if (IsFlag 279)
						(HighPrint 6 1) ; "The mushrooms from the Fairy Ring are pretty good, so you hear. However, when they're mixed with Kobold toadstools...that's a horse of a different color."
					)
					(HighPrint 6 2) ; "You eat some of the Kobold's fungus. Within seconds your insides feel like they're on fire. Guess you're not a Kobold, huh?"
					(if (<= [gEgoStats 14] 20) ; health
						(EgoDead
							{Didn't anyone warn you about eating other people's food?  Death by Toadstools doesn't leave mushroom for improvement.}
							82
							800
							1
							1
						)
					else
						(TakeDamage 20)
						(HighPrint 6 3) ; "You think that you'd better take it easy for a while until you recover."
					)
					(if (not (gEgo has: 30)) ; magic mushroom
						(ClearFlag 174)
					)
				)
				(else
					(gEgo use: 30 3) ; magic mushroom
					(if (IsFlag 125)
						(ClearFlag 125)
					else
						(ClearFlag 124)
					)
					(HighPrint 6 4) ; "You ingest a few of the mushrooms from the Faery Ring. They taste delicious."
					(HighPrint 6 5) ; "Wow! Look at all the nice paisley horses!"
					(HighPrint 6 6) ; "Not to mention the beautiful neon sky."
					(if (IsFlag 327)
						(EgoDead ; "That's funny. I could have sworn I warned you about eating too many Magic Mushrooms. Your mind permanently warped, you die a garishly polka-dotted death."
							6
							7
							80
							{Where did all the pretty horses go?}
							82
							800
							1
							1
						)
					else
						(HighPrint 6 8) ; "Hmm, that was interesting. But it would probably not be a good idea to repeat the experience."
					)
					(SetFlag 327)
				)
			)
		)
		((Said '/acorn,nut')
			(if (not (gEgo has: 41)) ; acorn
				(HighPrint 6 0) ; "You don't have any."
			else
				(gEgo use: 41 1) ; acorn
				(HighPrint 6 9) ; "You eat the Magic Acorn. It tastes terrible. Better stick to real food next time."
			)
		)
		(gFreeMeals
			(event claimed: 1)
			(HighPrint 6 10) ; "There's no need. You're not hungry."
		)
		((Said '/apple')
			(if (gEgo has: 11) ; apple
				(gEgo use: 11 3) ; apple
				(HighPrint 6 11) ; "You eat some of the apples. They actually taste quite good."
				(= haveEaten 1)
			else
				(HighPrint 6 12) ; "You don't have any fruit."
			)
		)
		((Said '/carrot')
			(if (gEgo has: 12) ; carrot
				(gEgo use: 12 2) ; carrot
				(HighPrint 6 13) ; "You eat some vegetables. You think they would have been better saved for cows or horses. Real Heros eat preserved dry rations."
				(= haveEaten 1)
			else
				(HighPrint 6 14) ; "You don't have any vegetables."
			)
		)
		((or (Said '/ration,food') (Said 'eat[/!*]'))
			(if (gEgo has: 3) ; food
				(gEgo use: 3 1) ; food
				(HighPrint 6 15) ; "The rations are tasteless but filling."
				(= haveEaten 1)
			else
				(HighPrint 6 16) ; "You aren't carrying any rations."
			)
		)
		(else
			(event claimed: 1)
			(HighPrint 6 17) ; "Ugh. You don't want to eat *that*."
		)
	)
	(if haveEaten
		(if (IsFlag 124)
			(ClearFlag 124)
			(ClearFlag 125)
		else
			(= gFreeMeals 1)
		)
	)
	(DisposeScript 6)
)

