;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 621)
(include sci.sh)
(use Main)
(use fileScr)
(use System)

(public
	roomServiceScr 0
)

(local
	local0
	local1
)

(instance roomServiceScr of Script
	(properties)

	(method (init)
		(= local0 1)
		(= local1 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 97)
					(ClearFlag 97)
					(= register (= cycles (= state 2)))
					(= local0 -1)
				else
					(switch local0
						(1
							(= local0 0)
							(gMessager say: 1 4 66 1 self 610) ; "Welcome to La Costa Lotta's new automated In-Room Ordering System for Room Service. May I help you? Wait. Don't answer that. See, there's no one here but us computers! Ha, ha! Pretty funny, huh? It's a little digital humor!"
						)
						(0
							(gMessager say: 1 4 23 0 self 610) ; "Returning to main menu."
						)
						(else
							(= local0 0)
							(gMessager say: 1 4 22 0 self 610) ; "You have cancelled your order. Returning to main menu."
						)
					)
				)
			)
			(1
				(gMessager say: 1 4 66 2 self 610) ; "You may press your selection at any time or 0 to return to the menu.  Press 1 for breakfast. Press 2 for lunch. Press 3 for dinner. Press 4 for morning snacks. Press 5 for afternoon snacks. Press 6 for late night snacks."
			)
			(2
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(3
				(switch register
					(0
						(self init:)
					)
					(1
						(= state 9)
						(gMessager say: 1 4 24 0 self 610) ; "You selected 1, breakfast.  Press 1 for full meals. Press 2 for lite meals. Press 3 for pig-out meals."
					)
					(2
						(= state 39)
						(gMessager say: 1 4 37 0 self 610) ; "You selected 2, lunch.  Press 1 for burgers. Press 2 for Mexican. Press 3 for fried chicken."
					)
					(3
						(= state 69)
						(gMessager say: 1 4 50 0 self 610) ; "You selected 3, dinners.  Press 1 for healthy meals. Press 2 for tasteful meals. Press 3 for pig-out meals."
					)
					(4
						(gMessager say: 1 4 63 0 self 610) ; "You selected 4, mid-morning snacks. Try a little self-control instead. Try waiting until lunch! Drink a glass of water or something, tubby!"
					)
					(5
						(gMessager say: 1 4 64 0 self 610) ; "You selected 5, afternoon snacks. We don't like serving afternoon snacks. You should have cleaned your plate at lunch! Have some consideration for others around here. Don't just think of yourself!"
					)
					(6
						(gMessager say: 1 4 65 0 self 610) ; "You selected 6, late night snacks. Look at the time. It's too late for that. Why don't you just go to bed and leave us alone! We've got to fix breakfast soon!"
					)
					(-1
						(self dispose:)
					)
					(else
						(self dispose:)
					)
				)
			)
			(4
				(self dispose:)
			)
			(10
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(11
				(switch register
					(1
						(gMessager say: 1 4 25 0 self 610) ; "You selected 1, full breakfasts.  Press 1 for ham and eggs. Press 2 for bacon and waffles. Press 3 for sausage and pancakes."
					)
					(2
						(= state 19)
						(gMessager say: 1 4 29 0 self 610) ; "You selected 2, lite meals.  Press 1 for dry toast. Press 2 for grape platter. Press 3 for tofu surprise."
					)
					(3
						(= state 29)
						(gMessager say: 1 4 33 0 self 610) ; "You selected 3, pig-out breakfasts.   Isn't that just like you? You come to an expensive health spa to try and lose that big gut of yours and what do you do? As soon as you know you're dealing with a machine that won't laugh at you, you order fattening food! Well, the laugh's on you!"
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(12
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(13
				(= state 995)
				(switch register
					(1
						(gMessager say: 1 4 26 0 self 610) ; "You selected 1, ham and eggs.  Press # to confirm, or * to cancel."
					)
					(2
						(gMessager say: 1 4 27 0 self 610) ; "You selected 2, bacon and waffles.  Press # to confirm, or * to cancel."
					)
					(3
						(gMessager say: 1 4 28 0 self 610) ; "You selected 3, sausage and pancakes.  Press # to confirm, or * to cancel."
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(20
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(21
				(switch register
					(1
						(gMessager say: 1 4 30 0 self 610) ; "You selected 1, dry toast.  Press # to confirm, or * to cancel."
					)
					(2
						(gMessager say: 1 4 31 0 self 610) ; "You selected 2, the pair of grapes.  Press # to confirm, or * to cancel."
					)
					(3
						(= local1 1)
						(gMessager say: 1 4 32 1 self 610) ; "You selected 3, tofu.  Press # to confirm, or * to cancel."
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(22
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(23
				(switch register
					(-2
						(if local1
							(= local1 0)
							(gMessager say: 1 4 32 2 self 610) ; "You're kidding, aren't you? We've had this crap on the menu for years and NOBODY ever orders it!"
						else
							(= state 996)
							(self cue:)
						)
					)
					(-1
						(self dispose:)
					)
					(else
						(= local0 -1)
						(self init:)
					)
				)
			)
			(24
				(self dispose:)
			)
			(30
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(31
				(= state 995)
				(switch register
					(1
						(gMessager say: 1 4 34 0 self 610) ; "A wise choice. We'll send up a nice plate of rice cakes!  Press # to confirm, or * to cancel."
					)
					(2
						(gMessager say: 1 4 35 0 self 610) ; "How about if we send up some chocolate to go with that?  Press # to confirm, or * to cancel."
					)
					(3
						(gMessager say: 1 4 36 0 self 610) ; "I doubt they'd even have you. You'd skew the curve!  Press # to confirm, or * to cancel."
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(40
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(41
				(switch register
					(1
						(gMessager say: 1 4 38 0 self 610) ; "You selected 1, burgers.  Press 1 for cheese. Press 2 for bacon. Press 3 for the works."
					)
					(2
						(= state 49)
						(gMessager say: 1 4 42 0 self 610) ; "You selected 2, Mexican.  Press 1 for tostadas. Press 2 for enchiladas. Press 3 for chimichangas."
					)
					(3
						(= state 59)
						(gMessager say: 1 4 46 0 self 610) ; "You selected 1, fried chicken.  Press 1 for mashed potatoes. Press 2 for potatoes with extra gravy. Press 3 for biscuits in gravy."
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(42
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(43
				(= state 995)
				(switch register
					(1
						(gMessager say: 1 4 39 0 self 610) ; "You selected 1, the deluxe cheeseburger, with extra cholesterol.  Press # to confirm, or * to cancel."
					)
					(2
						(gMessager say: 1 4 40 0 self 610) ; "You selected 2, our bacon "artery buster" burger.  Press # to confirm, or * to cancel."
					)
					(3
						(gMessager say: 1 4 41 0 self 610) ; "You selected 3, La Costa "Lotta Layers" Burger, with mayo, sugary ketchup, and cheese, a heart-attack on a plate.  Press # to confirm, or * to cancel."
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(50
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(51
				(= state 995)
				(switch register
					(1
						(gMessager say: 1 4 43 0 self 610) ; "You selected 1, tostadas.  Press # to confirm, or * to cancel."
					)
					(2
						(gMessager say: 1 4 44 0 self 610) ; "You selected 2, enchiladas.  Press # to confirm, or * to cancel."
					)
					(3
						(gMessager say: 1 4 45 0 self 610) ; "You selected 3, chimichangas.  Press # to confirm, or * to cancel."
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(60
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(61
				(switch register
					(1
						(= state 995)
						(gMessager say: 1 4 47 0 self 610) ; "You selected 1, fried chicken with mashed potatoes. Mmm, that sounds good to me, too! Just because I'm hungry, I'll throw on some extra gravy. And maybe some biscuits too.  Press # to confirm, or * to cancel."
					)
					(2
						(= state 995)
						(gMessager say: 1 4 48 0 self 610) ; "You selected 2, fried chicken with mashed potatoes and extra gravy. I can relate to that! You can have the gravy that's left after I finish eating MY serving!  Press # to confirm, or * to cancel."
					)
					(3
						(gMessager say: 1 4 49 0 self 610) ; "You selected 3, fried chicken with biscuits in gravy. Oh, man! I'm tired of pretending to be a computer. I don't care what you press; I'm outta here!"
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(62
				(self dispose:)
			)
			(70
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(71
				(switch register
					(1
						(= state 79)
						(gMessager say: 1 4 51 0 self 610) ; "You selected 1, healthy dinners.  Press 1 for salad. Press 2 for veggie platter. Press 3 for celery soup."
					)
					(2
						(gMessager say: 1 4 55 0 self 610) ; "You selected 2, tasteful meals.  We're all out."
					)
					(3
						(= state 89)
						(gMessager say: 1 4 59 0 self 610) ; "You selected 3, pig-out meals.  Press 1 for extra-large deluxe pizza. Press 2 for beef stroganoff. Press 3 for filet mignon."
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(72
				(= state 995)
				(gMessager say: 1 4 58 0 self 610) ; "Have a nice day.  Press # to confirm, or * to cancel."
			)
			(80
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(81
				(= state 995)
				(switch register
					(1
						(gMessager say: 1 4 52 0 self 610) ; "You selected 1, salad.  Press # to confirm, or * to cancel."
					)
					(2
						(gMessager say: 1 4 53 0 self 610) ; "You selected 2, vegetable platter.  Press # to confirm, or * to cancel."
					)
					(3
						(gMessager say: 1 4 54 0 self 610) ; "You selected 3, celery soup.  Press # to confirm, or * to cancel."
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(90
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(91
				(= state 995)
				(switch register
					(1
						(gMessager say: 1 4 60 0 self 610) ; "You selected 1, the extra-large deluxe pizza with all the trimmings.  Press # to confirm, or * to cancel."
					)
					(2
						(gMessager say: 1 4 61 0 self 610) ; "You selected 2, the beef stroganoff. This is a complete meal, including soup, salad, wine and dessert.  Press # to confirm, or * to cancel."
					)
					(3
						(gMessager say: 1 4 62 0 self 610) ; "You selected 3, a gorgeous 12-ounce filet mignon, smothered in onions, wrapped in bacon, complete with french onion soup, salad, and french fries.  Press # to confirm, or * to cancel."
					)
					(-1
						(self dispose:)
					)
					(else
						(self init:)
					)
				)
			)
			(996
				((ScriptID 610 0) init: self) ; TTDialer
			)
			(997
				(switch register
					(-2
						(gMessager say: 1 4 21 1 self 610) ; "Thank you for ordering. Checking your account for adequate cash reserves to complete transaction. Please hold..."
					)
					(-1
						(self dispose:)
					)
					(else
						(= local0 -1)
						(self init:)
					)
				)
			)
			(998
				(= seconds 8)
			)
			(999
				(gMessager say: 1 4 21 2 self 610) ; "...Sorry. You have no credit standing whatsoever with La Costa Lotta. Order any food you want, you won't get it!"
			)
			(1000
				(self dispose:)
			)
		)
	)
)

