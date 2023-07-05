;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 117)
(include sci.sh)
(use Main)
(use Talker)
(use Full)
(use Motion)
(use System)

(public
	abdulla 0
	abdullaTalk 1
)

(local
	abdullaTimer
	[abdullaGenList 38] = [0 2 3 4 6 8 10 12 5 14 15 16 17 18 19 20 21 1 22 24 23 25 26 27 28 29 30 1 31 32 33 34 35 1 1 1 1 1]
	[abdullaSpecList 36] = [36 '//shema,dance' 37 '//shameen' 38 '//arus[<aldin,about]' 39 '//loot' 40 '//news' 41 '//spielburg' 42 '//bandit' 43 '//carpet' 44 '//month' 45 '//year' 46 '//omen' 47 '//explore,exploration' 48 '//food,breakfast,drink,tea,eat,eat' 49 '//problem,news' 50 '//land,enchantment' 51 '//flame,fire' 52 '//bazaar,courtyard' 0 0]
)

(instance abdullaTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(abdulla tLoop: 0 setCycle: Fwd)
				(Say abdulla self 117 0) ; "Is it not amazing how quickly we have set up this Inn?  The Katta's Tail is already the center of Shapeir's entertainment. Where else can you watch Shema dance?"
			)
			(1
				(abdulla tLoop: 1 setCycle: End)
				(Say abdulla self 117 1) ; "You know you will always have a place to stay and fine food to eat in Shapeir. Shameen, Shema, and I cannot thank you enough for helping us recover our stolen treasure."
			)
			(2
				(abdulla tLoop: 0 setCycle: Fwd)
				(Say abdulla self 117 2) ; "It is good to be back home, even though I have had troubling news. My old friend Arus Al-Din, the Emir of Raseir, is missing. He was a good man, but not as wise as I."
			)
			(3
				(abdulla tLoop: 1 setCycle: End)
				(Say abdulla self 117 3) ; "Ah, but you have not even seen our beautiful Shapeir, and already I speak of problems. You need to go out, explore and discover why this is indeed a land of enchantment."
			)
			(4
				(= cycles 4)
			)
			(5
				(= abdullaTimer 200)
				(self dispose:)
			)
		)
	)
)

(instance abdullaEats of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(abdulla loop: 2 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(= cycles 3)
			)
			(2
				(abdulla setCycle: Full 1 self)
			)
			(3
				(abdulla loop: 0 setCycle: 0 cycleSpeed: 0)
				(= abdullaTimer 200)
				(self dispose:)
			)
		)
	)
)

(instance abdulla of Talker
	(properties
		x 63
		y 155
		description {Abdulla Doo}
		lookStr {It is your good friend, Abdulla Doo.}
		view 105
		priority 13
		signal 16400
		illegalBits 0
		tLoop 1
		talkSpeed 1
		myName '//abdulla,man,merchant'
		title {Abdulla:}
		color 2
		back 0
		msgFile 105
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((or (Said 'hello,greet') (Said '/hello,greet'))
				(Say self 117 4) ; "Good Day, my fine friend. I trust you are finding your stay in Shapeir interesting? There is always so much to see and do here."
			)
		)
	)

	(method (showText what)
		(cond
			((and (OneOf gElementalState 1 3 5 7) (<= 6 what 12))
				(self showMany: what (+ what 1))
			)
			((== what 51)
				(cond
					((< gElementalState 1)
						(Say self 117 5) ; "The subject is too hot for me."
					)
					((>= gElementalState 2)
						(Say self 117 6) ; "Only a true Hero could have defeated the dreadful Fire Elemental."
					)
					(else
						(super showText: what &rest)
					)
				)
			)
			(else
				(super showText: what &rest)
			)
		)
	)

	(method (doit)
		(if (and abdullaTimer (not (-- abdullaTimer)))
			(self setScript: abdullaEats)
		)
		(super doit:)
	)

	(method (atSpec which)
		(return [abdullaSpecList which])
	)

	(method (atGen which)
		(return [abdullaGenList which])
	)

	(method (endTalk)
		(super endTalk:)
		(= abdullaTimer 200)
	)
)

