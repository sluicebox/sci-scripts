;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm30 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	[local6 4]
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
	local20
	local21
	local22
	local23
	local24
	local25
	local26
	local27
	local28
	local29
	local30
	local31
	local32
	local33
	local34
	local35
	local36
	local37
	local38
	local39
	local40
	local41
	local42
	local43
	local44
	local45
)

(procedure (localproc_0)
	(Print &rest #at -1 125)
)

(procedure (localproc_1)
	(if (== (Random 1 8) 1)
		(coughScript changeState: 0)
		(= local14 20)
	)
	(if (== (Random 1 8) 2)
		(coughScript changeState: 2)
		(= local15 20)
	)
	(if (== (Random 1 8) 3)
		(coughScript changeState: 4)
		(= local16 20)
	)
	(if (== (Random 1 8) 4)
		(coughScript changeState: 6)
		(= local17 20)
	)
)

(instance mariesTheme of Sound
	(properties
		number 14
		priority 5
	)
)

(instance dinnerMusic of Sound
	(properties
		number 8
		priority 1
	)
)

(instance rm30 of Rm
	(properties
		picture 30
		style 0
	)

	(method (doit)
		(cond
			((> local14 1)
				(-- local14)
			)
			((== local14 1)
				(= local14 0)
				(coughScript changeState: 1)
			)
			((> local15 1)
				(-- local15)
			)
			((== local15 1)
				(= local15 0)
				(coughScript changeState: 3)
			)
			((> local19 0)
				(-- local19)
			)
			((> local20 1)
				(-- local20)
			)
			((== local20 1)
				(waiterScript changeState: 16)
				(= local20 0)
			)
			((> local16 1)
				(-- local16)
			)
			((== local16 1)
				(= local16 0)
				(coughScript changeState: 5)
			)
			((> local17 1)
				(-- local17)
			)
			((== local17 1)
				(= local17 0)
				(coughScript changeState: 7)
			)
			((> local18 1)
				(-- local18)
			)
			((== local18 1)
				(= local18 0)
				(day2Script changeState: 1)
			)
		)
		(if (> local13 1)
			(-- local13)
		)
		(if (== local13 1)
			(= local13 0)
			(if local24
				(waiterScript changeState: 6)
			else
				(= local13 100)
			)
		)
		(cond
			((and (!= (mod (gEgo view:) 2) 0) (<= (gEgo y:) 123))
				(gEgo view: (- (gEgo view:) 1))
			)
			((and (!= (mod (gEgo view:) 2) 1) (> (gEgo y:) 123))
				(gEgo view: (+ (gEgo view:) 1))
			)
		)
		(cond
			((> (gEgo y:) 165)
				(= global126 5)
				(gCurRoom newRoom: 105)
			)
			((and (gEgo inRect: 95 99 215 109) (== (local4 cel:) 5))
				(localproc_1)
				(local4 setCycle: End startUpd:)
				(if (not local32)
					(local5 posn: 157 164)
					(= local32 1)
				)
			)
			((and (not (gEgo inRect: 95 99 215 109)) local32)
				(local5 posn: 0 0)
				(= local32 0)
			)
			((> (local2 x:) 0)
				(if (not local24)
					(= local24 1)
				)
			)
			((and (> (gEgo x:) 0) local24)
				(= local24 0)
			)
		)
		(cond
			(
				(and
					(< (gEgo x:) 120)
					(> (gEgo y:) 130)
					local31
					(not local39)
				)
				(waiterScript changeState: 24)
			)
			((and (< (gEgo x:) 140) (not local24) local33)
				(if (not local34)
					(localproc_0 30 0) ; "What kind of a gentleman are you, leaving without saying goodbye to Marie?"
				)
				(= local33 0)
			)
			((and (gEgo inRect: 170 111 223 120) (not local22))
				(= local22 1)
				(mariesTheme play:)
				(localproc_0 30 1) ; "Hi, Sonny!"
				(localproc_0 30 2) ; "I'm so glad to see you. Please sit down."
			)
		)
		(super doit:)
	)

	(method (dispose)
		(coughScript dispose:)
		(marieScript dispose:)
		(sonnyScript dispose:)
		(waiterScript dispose:)
		(day2Script dispose:)
		(super dispose:)
	)

	(method (init)
		(super init:)
		(Load rsVIEW 1)
		(Load rsVIEW 0)
		(Load rsVIEW 266)
		(Load rsVIEW 28)
		(= global212 3)
		(= local42 16)
		(= local43 8)
		(= local44 5)
		((= local2 (Prop new:)) init:)
		((= local3 (Prop new:)) init:)
		((= local10 (Prop new:)) init:)
		((= local11 (Prop new:)) init:)
		((= local12 (Prop new:)) init:)
		(dinnerMusic play:)
		(= global204 0)
		(gEgo
			view: 1
			setStep: 3 2
			init:
			posn: 107 165
			setMotion: MoveTo 107 143
			setScript: day2Script
		)
		((= local0 (Act new:))
			view: 28
			posn: 137 104
			init:
			setCycle: Walk
			setStep: 3 2
			setScript: waiterScript
		)
		((= local1 (Prop new:))
			view: 266
			posn: 178 111
			loop: 8
			cel: 0
			init:
			stopUpd:
			setScript: marieScript
		)
		((= local5 (View new:))
			view: 266
			posn: 0 0
			loop: 4
			cel: 7
			setPri: 15
			init:
			stopUpd:
		)
		((= local4 (Prop new:))
			view: 266
			loop: 7
			cel: 5
			posn: 98 78
			setPri: 8
			init:
			ignoreActors:
		)
		((View new:)
			view: 266
			posn: 224 133
			loop: 3
			cel: 4
			setPri: 9
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 206 130
			loop: 3
			cel: 3
			setPri: 9
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 123 111
			loop: 3
			cel: 2
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 149 112
			loop: 3
			cel: 1
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 268 105
			loop: 4
			cel: 2
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 59 100
			loop: 4
			cel: 2
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 194 91
			loop: 4
			cel: 2
			setPri: 7
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 134 91
			loop: 4
			cel: 2
			setPri: 7
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 200 109
			loop: 4
			cel: 2
			setPri: 9
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 187 130
			loop: 2
			cel: 0
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 48 111
			loop: 4
			cel: 1
			setPri: 9
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 215 110
			loop: 1
			cel: 0
			ignoreActors:
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 102 98
			loop: 3
			cel: 0
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 56 98
			loop: 4
			cel: 0
			init:
			stopUpd:
			addToPic:
		)
		((View new:)
			view: 266
			posn: 271 86
			loop: 4
			cel: 4
			init:
			stopUpd:
			addToPic:
		)
		((= [local6 0] (Prop new:))
			view: 266
			posn: 0 0
			loop: 3
			cel: 5
			setPri: 10
			init:
			stopUpd:
		)
		((= [local6 1] (Prop new:))
			view: 266
			posn: 0 0
			loop: 3
			cel: 6
			setPri: 10
			init:
			stopUpd:
		)
		((= [local6 2] (Prop new:))
			view: 266
			posn: 0 0
			loop: 3
			cel: 7
			setPri: 10
			init:
			stopUpd:
		)
		((= [local6 3] (Prop new:))
			view: 266
			posn: 0 0
			loop: 3
			cel: 8
			setPri: 10
			init:
			stopUpd:
		)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '[<at,around][/!*,chamber,cafe,arnie]')
								(localproc_0 30 3) ; "Even for Lytton, this is a very classy place to dine. The wallpaper is white velveteen and the napkins are linen."
							)
							((Said '<below/table')
								(localproc_0 30 4) ; "You look, but all you see is a bony knee here and there."
							)
							((Said '/table')
								(localproc_0 30 5) ; "The elegant tables are made of solid oak."
							)
							((Said '/wall')
								(Print 30 6 #at -1 125) ; "There are some limited edition prints on the wall. There is a partition which separates the rear of the restaurant from the front."
							)
							((or (Said '<up') (Said '/ceiling'))
								(localproc_0 30 7) ; "In one corner, you can see the stain left from a leaky roof."
							)
							((or (Said '<down') (Said '/floor'))
								(localproc_0 30 8) ; "The carpeting was chosen in a light blue by Nguyen Interiors, Inc. It does little to hide the food stains."
							)
							((Said '/partition')
								(localproc_0 30 9) ; "Constructed from forest products, it separates the smoking section from the non-smoking section."
							)
							((Said '/counter')
								(localproc_0 30 10) ; "A telephone is located on the counter."
							)
							((Said '/phone')
								(Print 30 11) ; "Manufactured by the Steelton Phone Company."
							)
							((Said '/desk')
								(localproc_0 30 12) ; "The cash register is located on the desk"
							)
							((Said '/chow')
								(if local31
									(localproc_0 30 13) ; "Looks delicious!"
								else
									(localproc_0 30 14) ; "You notice that the other customers don't have any food on their tables."
								)
							)
							((Said '/man')
								(if (<= (local0 distanceTo: gEgo) 20)
									(localproc_0 30 15) ; "His velveteen outfit is very stylish. He seems to know his business."
								else
									(localproc_0 30 16) ; "The couple at the table seem happy and content."
								)
							)
							((Said '/crowd,couple,customer')
								(localproc_0 30 16) ; "The couple at the table seem happy and content."
							)
							((Said '/waiter')
								(if
									(and
										(< (local0 y:) 105)
										(> (local0 x:) 105)
									)
									(localproc_0 30 17) ; "He's not around to look at."
								else
									(localproc_0 30 15) ; "His velveteen outfit is very stylish. He seems to know his business."
								)
							)
							((Said '/woman,cheeks')
								(cond
									(
										(and
											(not local24)
											(not
												(gEgo
													inRect: 170 111 223 120
												)
											)
										)
										(localproc_0 30 18) ; "Marie slips you a sidelong glance. She suspects that you're looking at another woman."
									)
									(
										(and
											(not local24)
											(gEgo inRect: 170 111 223 120)
										)
										(localproc_0 30 19) ; "You want to gaze into Marie's eyes. You'd better sit down."
									)
									(else
										(localproc_0 30 20) ; "You can't get over what a knockout Marie is!"
									)
								)
							)
							((Said '/computer,terminal,register')
								(localproc_0 30 21) ; "The cash register is a modern point-of-sale computer terminal which feeds its information to Arnie's home office."
							)
							((Said '/plant')
								(localproc_0 30 22) ; "It's a fake rubber plant."
							)
							((Said '/painting,print')
								(localproc_0 30 23) ; "The painting adorning the wall is in a new style called "Computer Art.""
							)
							((Said '/grass')
								(localproc_0 30 24) ; "There isn't any marijuana in here."
							)
							((Said '/pane')
								(localproc_0 30 25) ; "You see the parking lot through the window."
							)
						)
					)
					((Said 'look,read/sign')
						(if (or (< (gEgo x:) 160) local24)
							(localproc_0 30 26) ; "It informs patrons that the Smoking Section is behind the partition."
						else
							(localproc_0 30 27) ; "You can't read it from where you're standing."
						)
					)
					((Said 'frisk[<behind]/partition')
						(localproc_0 30 28) ; "Searching the partition is not in the realm of logical thinking."
					)
					((Said 'frisk/customer,cafe,man,woman,couple')
						(localproc_0 30 29) ; "You wouldn't want to upset the patrons."
					)
					(
						(or
							(Said '(use,dial,(pick[<up]))<phone')
							(Said 'make/call')
						)
						(localproc_0 30 30) ; "Who ya gonna call...Crimebusters?"
					)
					((Said 'open/register')
						(localproc_0 30 31) ; "You could be arrested for doing that."
					)
					((Said 'get/plant')
						(localproc_0 30 32) ; "It would look nice in your apartment, but you really shouldn't."
					)
					((Said 'get/register')
						(localproc_0 30 33) ; "That would be stealing."
					)
					((Said 'yes')
						(if local24
							(localproc_0 30 34) ; "Thanks, Sonny!"
						else
							(localproc_0 30 35) ; "Good. A positive outlook."
						)
					)
					((Said 'no')
						(if local24
							(localproc_0 30 36) ; "Marie just looks at you thoughtfully."
						else
							(localproc_0 30 37) ; "Being negative never helps."
						)
					)
					((Said 'beg')
						(cond
							((> (gEgo x:) 105)
								(localproc_0 30 38) ; "It's funny...he doesn't look like a bum."
							)
							(local24
								(localproc_0 30 39) ; "You beg Marie for her affections."
							)
							(else
								(localproc_0 30 40) ; "Not much luck on this side of the room."
							)
						)
					)
					((Said 'talk>')
						(cond
							((Said '/man,crowd,customer,cafe,customer')
								(cond
									((> (gEgo x:) 105)
										(switch (Random 0 5)
											(0
												(Print 30 41 #at -1 125) ; "Thinking you're the waiter, the diner says..."I'll take the #3 medium well, with baked potato and... oh yes, a side order of mushrooms, please.""
											)
											(1
												(localproc_0 30 42) ; "Unless you're the waiter," the man snarls, "I don't need a thing."
											)
											(2
												(localproc_0 30 43) ; "Give me a break!" the customer snaps, "can't you see I'm trying to eat?"
											)
											(3
												(localproc_0 30 44) ; "Try begging at the next table, BUB!"
											)
											(4
												(localproc_0 30 45) ; "Why you poor thing," the lady says, "are you lost?"
											)
											(5
												(localproc_0 30 46) ; "With a smile the man says, "I'll have the special of the day with iced tea, please.""
											)
										)
									)
									((not local24)
										(localproc_0 30 47) ; "All of the people are on the other side of the room."
									)
									(else
										(localproc_0 30 48) ; "Marie says, "Sonny, you're not paying attention to me!""
									)
								)
							)
							((Said '/waiter')
								(if
									(and
										(< (local0 y:) 105)
										(> (local0 x:) 105)
									)
									(localproc_0 30 49) ; "He's not around to talk to."
								else
									(localproc_0 30 50) ; "He's the strong, silent type. He only waits."
								)
							)
							((Said '/woman,cheeks,cheeks')
								(cond
									((not local24)
										(localproc_0 30 51) ; "Why don't you sit down with her first."
									)
									((and local31 (not local37))
										(localproc_0 30 52) ; "Gosh, Sonny. This food looks so good! Let's eat, shall we?"
									)
									(local35
										(localproc_0 30 53) ; ""Why don't you give the man your order?" says Marie."
									)
									(else
										(localproc_0 30 54) ; "All excited, Marie says..."Oh precious, I'm so happy to see you!""
										(localproc_0 30 55) ; "My life is so different now," she says, "and it's all because of you. I owe everything to you, Sonny!"
									)
								)
							)
							(local24
								(localproc_0 30 56) ; "Marie just looks longingly into your eyes."
							)
							(else
								(localproc_0 30 57) ; "You're talking to yourself again."
							)
						)
						(event claimed: 1)
					)
					((Said 'kiss/!*')
						(localproc_0 30 58) ; "Kiss who?"
					)
					(
						(or
							(Said 'kiss/cheeks,woman,cheeks')
							(Said 'give/kiss/woman')
						)
						(cond
							((and (not local26) local24)
								(marieScript changeState: 4)
							)
							((gEgo inRect: 0 0 320 200)
								(localproc_0 30 51) ; "Why don't you sit down with her first."
							)
							(local35
								(localproc_0 30 59) ; ""Not in front of the waiter, Sonny!" Marie says."
							)
							(else
								(localproc_0 30 60) ; "Not now, Sonny!" Marie says. "The waiter'll be here any minute."
							)
						)
					)
					((Said 'eat,blow,fuck/couple,customer,cafe,customer,man')
						(Print 30 61 #at -1 125) ; "Golly gee!" the customer declares. "It must be one of them there preeverts that you read about in the papers. Go on, buddy! Get away! Shoo! Shoo!"
					)
					((Said 'fuck,eat,blow/woman,cheeks,cheeks')
						(if (> (local2 x:) 0)
							(switch (Random 0 3)
								(0
									(localproc_0 30 62) ; "Embarrassed, she says..."Oh Sonny, you shouldn't talk like that.""
								)
								(1
									(localproc_0 30 63) ; ""WOW!" she says."
								)
								(2
									(localproc_0 30 64) ; "Have a drink of water, Sonny. You must be getting warm."
								)
								(3
									(localproc_0 30 65) ; "Without saying anything, Marie blushes, but her eyes remain fixed on yours."
								)
							)
						else
							(localproc_0 30 66) ; "Here??? In the restaurant???"
						)
					)
					(
						(or
							(Said 'ask/cost[<chow,lobster,loaf,rib]')
							(Said 'ask/man,waiter/cost')
							(Said 'much<how')
						)
						(if (and local35 (not local28))
							(localproc_0 30 67) ; "He answers..."Meatloaf is $5.00, prime rib is $8.00, and the lobster is $16.00""
							(= local38 1)
						else
							(localproc_0 30 68) ; "Better ask the waiter, if you can get his attention."
						)
					)
					(
						(or
							(Said 'read,ask/chow,choice,menu')
							(Said 'look,give,show,get/menu[/me]')
							(Said 'ask/waiter/menu,chow,choice')
						)
						(if local35
							(localproc_0 30 67) ; "He answers..."Meatloaf is $5.00, prime rib is $8.00, and the lobster is $16.00""
						else
							(localproc_0 30 69) ; "This restaurant has no menus. You must ask the waiter."
						)
					)
					((Said 'show/badge')
						(cond
							((and local25 local38 (not local28))
								(localproc_0 30 70) ; "He answers..."Meatloaf is $3.00, prime rib is $4.00, and the lobster is $8.00""
								(= local42 8)
								(= local43 4)
								(= local44 3)
							)
							((or (gEgo inRect: 170 111 223 120) local24)
								(localproc_0 30 71) ; "With a tear in her eye, Marie says, "S-S-S-Sonny! Are you BUSTING me????""
							)
							((> (gEgo x:) 105)
								(switch (Random 0 3)
									(0
										(localproc_0 30 72) ; "You whip out the ole badge, and the customer says... "Now what??""
									)
									(1
										(localproc_0 30 73) ; "After you have displayed your badge, the patron says: "So what?""
									)
									(2
										(localproc_0 30 74) ; "You show your badge and the customer lashes out..."Whatsa matter, am I holding my fork wrong or something?""
									)
									(3
										(localproc_0 30 75) ; ""Good day officer," he says, after you have displayed your badge."
									)
								)
							)
							(else
								(localproc_0 30 76) ; "Quit flashing your badge at the wall!"
							)
						)
					)
					((or (Said '[exit]/info[/waiter]') (Said 'info[/waiter]'))
						(if local37
							(if (> global107 5)
								(localproc_0 30 77) ; "Being the big tipper you are, you throw down $5.00."
								(-= global107 5)
							else
								(localproc_0 30 78) ; "Oops! You're down to your last cash...better not leave a tip!"
							)
						else
							(localproc_0 30 79) ; "Most people wait until they've finished eating."
						)
					)
					(
						(or
							(Said 'pay/waiter,bill,chow,chow')
							(Said 'get,get/bill,check')
						)
						(if local37
							(if local24
								(waiterScript changeState: 6)
							else
								(waiterScript changeState: 28)
							)
						else
							(localproc_0 30 80) ; "You might as well eat your food before paying for it."
						)
					)
					((Said '[order]/chow')
						(if (not local28)
							(= local41 3)
							(= local40 (+ local42 local42))
						)
						(waiterScript changeState: 11)
					)
					((Said '[order]/lobster')
						(if (not local28)
							(= local41 3)
							(= local40 (+ local42 local42))
						)
						(waiterScript changeState: 11)
					)
					((Said '[order]/rib[<prime]')
						(if (not local28)
							(= local41 2)
							(= local40 (+ local42 local43))
						)
						(waiterScript changeState: 11)
					)
					((or (Said '[order]/meatloaf') (Said '[order]/loaf<meat'))
						(if (not local28)
							(= local41 1)
							(= local40 (+ local42 local44))
						)
						(waiterScript changeState: 11)
					)
					((or (Said 'get,get/chow') (Said '[call,get]/waiter'))
						(cond
							(
								(and
									local28
									local29
									(not local31)
									(not local37)
									(not local30)
									local24
									(== local19 0)
									(> local20 1)
								)
								(= local20 0)
								(waiterScript changeState: 16)
							)
							((and local28 (> local19 0))
								(localproc_0 30 81) ; "Good food takes a little time."
							)
							((and (not local24) (not local28))
								(localproc_0 30 82) ; "So...go sit down and order some food, first!"
							)
							((and local24 (not local28))
								(localproc_0 30 83) ; "Have some patience! The waiter will take your order."
							)
							((and local31 (not local37))
								(localproc_0 30 84) ; "There's food on your plate...eat it if you're hungry."
							)
							((not local29)
								(localproc_0 30 85) ; "Have some patience with the poor waiter!"
							)
							((and local30 (not local31))
								(localproc_0 30 86) ; "Your food is on the way."
							)
							(local37
								(if local24
									(waiterScript changeState: 6)
								else
									(waiterScript changeState: 28)
								)
							)
							(else
								(localproc_0 30 87) ; "The waiter's in back flirting with the cook."
							)
						)
					)
					((Said '[order]/water,tea,coffee,coca')
						(if local24
							(localproc_0 30 88) ; "Your choice comes with the meal."
						else
							(localproc_0 30 89) ; "Sit down first."
						)
					)
					((Said '[order]/beer,booze,drink')
						(if local37
							(localproc_0 30 90) ; "Maybe a little later."
						else
							(localproc_0 30 91) ; "You feel like eating something before you have a drink."
						)
					)
					((Said 'eat[/chow,chow,meatloaf,loaf,rib,lobster]')
						(cond
							((and local31 local24 (not local36) (not local37))
								(marieScript changeState: 1)
							)
							((and (not local24) (not local37))
								(localproc_0 30 92) ; "Sit at the table in order to eat."
							)
							((not local24)
								(localproc_0 30 89) ; "Sit down first."
							)
							(local37
								(localproc_0 30 93) ; "You've already cleaned your plate."
							)
							(local36
								(localproc_0 30 94) ; "Can't you tell from the taste in your mouth that you're already eating?"
							)
							(else
								(localproc_0 30 95) ; "You don't have any food of your own yet."
							)
						)
					)
					((Said 'give/flower,rose,plant,bouquet,carnation')
						(cond
							((and local24 (not local26) (gEgo has: 11)) ; potted_plant
								(sonnyScript changeState: 2)
							)
							((and local24 local27)
								(localproc_0 30 96) ; "She already has them."
							)
							((not local24)
								(localproc_0 30 97) ; "Why don't you sit down first?"
							)
							((and local26 (gEgo has: 11)) ; potted_plant
								(localproc_0 30 98) ; "Wait until the waiter's taken your order."
							)
							(else
								(localproc_0 30 99) ; "You didn't buy them when you had a chance."
							)
						)
					)
					((Said 'sat[<down]')
						(cond
							((gEgo inRect: 203 105 233 120)
								(sonnyScript changeState: 0)
							)
							((gEgo inRect: 170 111 203 120)
								(localproc_0 30 100) ; "On her lap??! Try your own chair!"
							)
							(local24
								(localproc_0 30 101) ; "You can't sit down any farther!"
							)
							(else
								(localproc_0 30 102) ; "Why don't you sit with your girlfriend?"
							)
						)
					)
					(
						(or
							(Said 'say,tell/bye,cheeks')
							(Said '/bye')
							(Said '/cheeks<bye')
						)
						(= local34 1)
						(localproc_0 30 103) ; "Snif!"
					)
					((Said 'stand,(get<up)')
						(if (not local24)
							(localproc_0 30 104) ; "Get up from where? You're already standing!"
						else
							(sonnyScript changeState: 4)
						)
					)
				)
			)
		)
	)
)

(instance coughScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				([local6 0] posn: 121 54)
			)
			(1
				([local6 0] posn: 0 0)
			)
			(2
				([local6 1] posn: 112 69)
			)
			(3
				([local6 1] posn: 0 0)
			)
			(4
				([local6 2] posn: 92 88)
			)
			(5
				([local6 2] posn: 0 0)
			)
			(6
				([local6 3] posn: 77 60)
			)
			(7
				([local6 3] posn: 0 0)
			)
		)
	)
)

(instance waiterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(local0 setMotion: MoveTo 103 104 self startUpd:)
			)
			(1
				(local0 setMotion: MoveTo 103 115 self)
			)
			(2
				(local0 stopUpd: (Print 30 105 #at 68 150)) ; ""Please find a table, Sir, and we'll be right with you," says the waiter."
				(self cue:)
				(User canControl: 1)
			)
			(3
				(local0 setMotion: MoveTo 103 104 self startUpd:)
			)
			(4
				(local0 setMotion: MoveTo 127 104 self)
			)
			(5
				(local0 stopUpd:)
			)
			(6
				(User canControl: 0 canInput: 0)
				(local0
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setLoop: -1
					setStep: 3 2
					setMotion: MoveTo 103 104 self
					startUpd:
				)
			)
			(7
				(local0 setMotion: MoveTo 103 113 self)
			)
			(8
				(local0 setPri: 8 setMotion: MoveTo 194 113 self)
			)
			(9
				(local0 setMotion: MoveTo 194 112 self)
			)
			(10
				(local0 stopUpd:)
				(User canInput: 1)
				(if local37
					(self changeState: 28)
				else
					(Print 30 106 #at 59 140 #time 6) ; "Good day sir," says the waiter..."Our specials of the day are meatloaf, prime rib, and lobster."
					(Print 30 107 #at 59 150) ; "Continuing he says, "Which would you prefer?""
					(= local35 1)
				)
			)
			(11
				(cond
					((and local24 local35 (not local28))
						(switch local41
							(3
								(localproc_0 30 108) ; "Very good, sir. The lobster is excellent this season. And what will you have, young lady?"
							)
							(1
								(localproc_0 30 109) ; "A wise choice....very frugal. And what will you have, young lady?"
							)
							(2
								(localproc_0 30 110) ; "Our beef comes only from contented steers. And what will you have, young lady?"
							)
						)
						(localproc_0 30 111) ; ""I'll have the lobster!" says Marie."
						(= local28 1)
						(= local19 300)
						(= local20 450)
						(self cue:)
					)
					(local28
						(localproc_0 30 112) ; "You've already ordered food."
					)
					((not local35)
						(localproc_0 30 113) ; "Wait for the waiter."
					)
					(else
						(localproc_0 30 114) ; "You must be seated at a table if you want to order."
					)
				)
				(User canControl: 1)
			)
			(12
				(localproc_0 30 115) ; "Thank you very much sir" the waiter says, "your order will be ready shortly."
				(local0 setMotion: MoveTo 103 113 self startUpd:)
				(= local35 0)
				(= local26 0)
				(User canInput: 0)
			)
			(13
				(local0 setMotion: MoveTo 103 104 self)
			)
			(14
				(local0 setPri: 6 setMotion: MoveTo 125 102 self)
			)
			(15
				(local0 stopUpd:)
				(= local29 1)
				(User canInput: 1)
			)
			(16
				(localproc_0 30 116 25 3) ; "Here comes the chow!"
				(HandsOff)
				(local0
					view: 44
					setLoop: 5
					setMotion: MoveTo 103 104 self
					startUpd:
				)
				(= local30 1)
			)
			(17
				(local0 setLoop: 6 setPri: 8 setMotion: MoveTo 103 113 self)
			)
			(18
				(local0 setLoop: 4 setMotion: MoveTo 190 113 self)
			)
			(19
				(local0 setLoop: 7 setMotion: MoveTo 190 112 self)
			)
			(20
				(local0 stopUpd:)
				(= local31 1)
				(localproc_0 30 117 25 3) ; "Your dinner, sir. Please enjoy."
				(local0
					view: 44
					loop: 1
					cel: 0
					posn: 200 113
					setMotion: MoveTo 100 113 self
					startUpd:
				)
				(= local30 0)
				(HandsOn)
			)
			(21
				(local0 setLoop: 3 setPri: 6 setMotion: MoveTo 100 104 self)
			)
			(22
				(local0 setLoop: 0 setMotion: MoveTo 125 102 self)
			)
			(23
				(local0 stopUpd:)
			)
			(24
				(gEgo stopUpd:)
				(HandsOff)
				(= local39 1)
				(localproc_0 30 118) ; "What kind of turkey are you, leaving without paying?"
				(self cue:)
			)
			(25
				(local0
					view: 28
					ignoreActors: 1
					illegalBits: 0
					setCycle: Walk
					setStep: 3 2
					setLoop: 1
					setMotion: MoveTo 103 104 self
					startUpd:
				)
			)
			(26
				(local0 setLoop: 2 setMotion: MoveTo 103 125 self)
			)
			(27
				(localproc_0 30 119) ; "Here is the bill, sir"
				(self cue:)
			)
			(28
				(User canInput: 1)
				(if (or local31 local37)
					(if (> global107 local40)
						(localproc_0 30 120) ; "Paying your bill, you thank the waiter for the fine food and service."
						(-= global107 local40)
						(= local39 1)
						(SetScore 2)
					else
						(localproc_0 30 121) ; "Uh-oh! It seems you've spent too much of your ready cash. Even worse than that, you're overextended on your credit cards."
						(localproc_0 30 122) ; "Embarrassed, because you're broke, you ask the waiter if he has any dishes to wash."
					)
				else
					(localproc_0 30 79) ; "Most people wait until they've finished eating."
				)
				(= global126 3)
				(gCurRoom newRoom: 105)
			)
		)
	)
)

(instance marieScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local1 stopUpd:)
			)
			(1
				(HandsOff)
				(= local36 1)
				(SetScore 1)
				(local1 loop: 8 cel: 0 setCycle: Fwd cycleSpeed: 3 startUpd:)
				(local2 loop: 9 cel: 0 setCycle: Fwd cycleSpeed: 0 startUpd:)
				(= seconds 3)
			)
			(2
				(localproc_0 30 123 25 3) ; "Hungry, you consume the meal in record time."
				(= seconds 6)
			)
			(3
				(local1 setCel: 0 stopUpd:)
				(local2 setCel: 0 stopUpd:)
				(HandsOn)
				(= local37 1)
				(= local36 0)
				(= local31 0)
			)
			(4
				(HandsOff)
				(local1 loop: 5 cel: 0 setCycle: End cycleSpeed: 0)
				(local2 posn: 209 111 loop: 6 cel: 0 setCycle: End)
				(+= local45 1)
				(local10
					view: 285
					loop: 0
					cel: 0
					posn: 196 78
					setPri: 7
					init:
					setCycle: Fwd
					startUpd:
				)
				(local11
					view: 285
					loop: 1
					cel: 0
					posn: 218 70
					setPri: 7
					init:
					setCycle: Fwd
					startUpd:
				)
				(local12
					view: 285
					loop: 2
					cel: 0
					posn: 175 62
					setPri: 7
					init:
					setCycle: Fwd
					startUpd:
				)
				(= seconds 4)
			)
			(5
				(local1 setCycle: Beg)
				(local2 setCycle: Beg)
				(local10 posn: 0 0 stopUpd:)
				(local11 posn: 0 0 stopUpd:)
				(local12 posn: 0 0 stopUpd:)
				(= seconds 4)
				(cond
					((== local45 2)
						(SetScore 2)
						(localproc_0 30 124) ; "WOW! You're some kisser, Sonny!"
					)
					((== local45 3)
						(localproc_0 30 125) ; "I don't know how much more of this I can take, Sonny!"
					)
					((> local45 3)
						(localproc_0 30 126) ; "Marie says, "Listen, Sonny...we'd better go somewhere more private if you're going to keep this up.""
						(self changeState: 7)
					)
				)
				(= seconds 1)
			)
			(6
				(HandsOn)
				(if (== local45 1)
					(SetScore 2)
					(localproc_0 30 127) ; "Oh, by the way," she says..."How do you like my new lipstick? It's called Pink Rapture."
					(localproc_0 30 128) ; "I really like it" she says, "It's my favorite. It's so PINK!"
				)
			)
			(7
				(if (> global107 local40)
					(= global126 4)
				else
					(= global126 2)
				)
				(gCurRoom newRoom: 105)
			)
		)
	)
)

(instance sonnyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0)
				(gEgo posn: -100 0 stopUpd:)
				(local2
					view: 266
					posn: 209 111
					loop: 6
					cel: 0
					ignoreActors:
					init:
					stopUpd:
				)
				(if (not local25)
					(= local25 1)
					(= local26 1)
					(= local13 100)
				)
				(if (not local23)
					(self cue:)
				)
			)
			(1
				(= local23 1)
				(localproc_0 30 129 83) ; "Marie says, "Oh Sonny. I've been so worried for you.""
				(localproc_0 30 130 83) ; "I know that Jessie Bains is looking for revenge. I know he's out to get even, especially with you."
				(localproc_0 30 131 83) ; "I'm scared Sonny! Promise you'll stop in and see me sometime tomorrow. I need to know that you're all right."
			)
			(4
				(cond
					(local28
						(gEgo loop: 1 cel: 3 posn: 214 112)
						(local2 posn: -100 0 stopUpd:)
						(self cue:)
					)
					(local35
						(localproc_0 30 132) ; "Don't get up. Order your dinner."
					)
					(else
						(localproc_0 30 133) ; "Don't get up yet. You just got here."
					)
				)
			)
			(5
				(localproc_0 30 134 83) ; "Sonny! Where are you going, Sonny? Don't leave me!"
				(= local33 1)
				(User canControl: 1)
			)
			(2
				(= local27 1)
				(SetScore 3)
				(if (gEgo has: 11) ; potted_plant
					(local3
						view: 266
						posn: 187 89
						loop: 4
						setPri: 7
						init:
						stopUpd:
					)
					(switch ((gInventory at: 11) cel:) ; potted_plant
						(0
							(local3 cel: 6)
						)
						(1
							(local3 cel: 3)
						)
						(2
							(local3 cel: 5)
						)
					)
					(gEgo put: 11 30) ; potted_plant
				)
				(self cue:)
			)
			(3
				(Print 30 135 #at 69 140 #time 5 #draw) ; "Oh, Sonny....you're WONDERFUL!!!"
			)
		)
	)
)

(instance day2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local18 1500)
			)
			(1
				(cond
					((and (== local45 0) (not local28) (not local25))
						(= global126 1)
						(gCurRoom newRoom: 105)
					)
					((and (== local45 0) (not local28) local25)
						(localproc_0 30 136 25 10) ; "Boy!" you think to yourself. "A romantic evening like this sure works up the old appetite."
						(day2Script changeState: 0)
					)
					((and (== local45 0) local28)
						(localproc_0 30 137 25 10) ; "You think to yourself..."What a wonderful time to get romantic, Sonny. Marie looks positively delicious!""
						(day2Script changeState: 0)
					)
					((and (> local45 0) (not local28))
						(localproc_0 30 136 25 10) ; "Boy!" you think to yourself. "A romantic evening like this sure works up the old appetite."
						(day2Script changeState: 0)
					)
					((not local39)
						(= global126 2)
						(gCurRoom newRoom: 105)
					)
					(else
						(= global126 3)
						(gCurRoom newRoom: 105)
					)
				)
			)
		)
	)
)

