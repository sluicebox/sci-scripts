;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 48)
(include sci.sh)
(use Main)
(use Interface)
(use Osc)
(use RandCycle)
(use Feature)
(use Motion)
(use Game)
(use Inventory)
(use Actor)
(use System)

(public
	rm48 0
)

(local
	local0
	local1
	local2 = 55
	local3 = 40
	local4 = 45
	[local5 10]
	local15
	local16 = 1
	local17
)

(procedure (localproc_0 param1)
	(= [local5 local15] [param1 0])
	(++ local15)
)

(procedure (localproc_1)
	(if (not (sellRobots register:))
		(= local15 0)
		(bugTalker state: 0 seconds: 0)
	)
)

(instance rm48 of Rm
	(properties
		picture 48
	)

	(method (init)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(super init:)
		(bugMouth init:)
		(antenna init: stopUpd: setScript: wiggleAntenna)
		(rightarm init: setCycle: RandCycle setScript: bugTalker)
		(display init: stopUpd:)
		(readout init: stopUpd:)
		(bug init:)
		(award init:)
		(robotHead init:)
		(robotArm init:)
		(bugButt init:)
		(DBUsign init:)
		(screen init:)
		(diaphram init:)
		(tubes init:)
		(table init:)
		(parts init:)
		(self setScript: sellRobots)
		(gLongSong number: 623 loop: -1 play:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event &rest))
			((not (sellRobots register:))
				(bugTalker seconds: 0 cue:)
				(event claimed: 1)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
					(or (== (event message:) JOY_UP) (& (event type:) $0040)) ; direction
				)
				(gCurRoom newRoom: 47)
				(event claimed: 1)
			)
			(
				(and
					(== (gTheIconBar curIcon:) (gTheIconBar at: 6))
					(== (gTheIconBar curInvIcon:) (Inv at: 10)) ; buckazoid
					(== (event message:) JOY_DOWNRIGHT)
				)
				(Print 48 0) ; "The salesbug would appreciate it if you'd give him the money. It would make his job soooo much easier."
			)
		)
	)

	(method (doit)
		(if (-- local16)
			(switch local17
				(0
					(Palette palANIMATE 64 73 (- (Random 0 30) 15))
				)
				(1
					(Palette palANIMATE 64 73 8)
				)
				(2
					(Palette palANIMATE 64 73 3)
				)
				(3
					(Palette palANIMATE 64 73 -3)
				)
				(4
					(Palette palANIMATE 64 73 -8)
				)
			)
		else
			(= local16 (Random 20 50))
			(= local17 (Random 0 4))
		)
		(super doit: &rest)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance sellRobots of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOn)
				(gTheIconBar disable: 4 5)
				(localproc_0
					{Please observe our robot preview screen. If you have any questions, don't hesitate to ask.}
				)
				(if (IsFlag 45)
					(localproc_0
						{Oh, we're back, are we? Well, perhaps we can manage to take home a droid this time, eh?}
					)
				else
					(localproc_0
						{However, I can see that we would be more... ah... interested in our line of economy-priced, used robots, wouldn't we?}
					)
					(localproc_0
						{We have a wide variety of work-saving, life- enhancing, shiny-new, factory-fresh, technological wonders of modern engineering wizardry!}
					)
					(localproc_0
						{Greetings, sir! Allow me to show you our fine line of robots, otherwise known as "droids".}
					)
				)
				(= cycles 2)
			)
			(1
				(if register
					(= temp0 (display cel:))
					(if (and (OneOf (++ temp0) 10 1 4) (IsFlag 33))
						(++ temp0)
					)
					(display cel: temp0 forceUpd:)
					(readout cel: temp0 forceUpd:)
				)
				(= seconds 3)
			)
			(2
				(= start 1)
				(self init:)
			)
		)
	)
)

(instance bugTalker of Script
	(properties)

	(method (doit)
		(if (and local15 (== state 0))
			(sellRobots register: 0)
			(= seconds 0)
			(self cue:)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local15)
					(HandsOn)
					(gTheIconBar disable: 4 5)
				else
					(HandsOff)
				)
			)
			(1
				(= register
					(proc0_12
						[local5 (-- local15)]
						67
						6
						134
						70
						190
						28
						global136
						33
						60
					)
				)
				(bugMouth setCycle: Fwd)
				(= seconds (+ 1 (/ (StrLen [local5 local15]) 10)))
			)
			(2
				(cond
					((noMoney register:)
						(gCurRoom newRoom: 47)
					)
					((soldDroid register:)
						(gCurRoom newRoom: 46)
					)
					(else
						(proc0_12 register)
						(bugMouth setCycle: 0)
						(if (not local15)
							(sellRobots register: 1)
						)
						(self init:)
					)
				)
			)
		)
	)
)

(instance soldDroid of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(localproc_0 {Thank you, sir.})
				(localproc_0
					{You may pick up your purchase at our convenient Droids-B-Us pickup area, located just out the door and to your right.}
				)
				(= cycles 4)
			)
			(1
				(= register 1)
			)
		)
	)
)

(instance noMoney of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(localproc_1)
				(switch (++ local0)
					(1
						(localproc_0
							{You could fill out one of our credit applications, although I seriously doubt that you would qualify.}
						)
					)
					(2
						(localproc_0
							{I believe that the FloorMart store on Petulence is having a sale on pencil sharpeners that you might just be able to afford!}
						)
					)
					(3
						(localproc_0
							{Why can't I ever get a customer with more money than brains? Well... in your case, you might just qualify at that.}
						)
					)
					(else
						(localproc_0
							{Look, why don't you go break your piggy bank open and come back with a little more cash? Now, if you'll excuse me, you really must be going.}
						)
						(= register 1)
					)
				)
				(localproc_0
					{Pardon me for saying so, sir, but we don't appear to have enough money for our purchase, now, do we?}
				)
				(self dispose:)
			)
		)
	)
)

(instance bug of Feature
	(properties
		y 189
		description {salesbug}
		onMeCheck 16
		lookStr {The salesbug appears to be a Chdnarian, a race renowned for their predatory sales techniques. You decide to count your fingers once you've completed your transaction.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(localproc_1)
				(switch (display cel:)
					(0
						(localproc_0
							{If you were to insist, I could let you have it for a mere 512 buckazoids (407 with a coupon).}
						)
						(localproc_0
							{However, I have only one left, and I put it to work in the warehouse.}
						)
						(localproc_0
							{This is an all-purpose household model. It cooks, sews, does windows and brews a little moonshine on the side.}
						)
					)
					(1
						(localproc_0
							{Don't bother haggling. This one's worth 55 buckazoids for the parts alone. That would be 46 buckazoids with a coupon.}
						)
						(localproc_0
							{That race killed themselves off, however, and spare parts are nearly impossible to find.}
						)
						(localproc_0
							{It was produced exclusively for Droids-B-Us by a small planet who used these mechanical warriors to fight their battles.}
						)
						(localproc_0
							{Ah! This model is one of my personal favorites.}
						)
					)
					(2
						(localproc_0
							{And, if you've got kids, you'll appreciate its low, low price of 698 buckazoids (559 with a coupon).}
						)
						(localproc_0
							{If you can live with the paranoia, though, it makes a great baby-sitter.}
						)
						(localproc_0
							{Whenever it gets excited, it waves its arms around wildly and yells "DANGER! DANGER!"}
						)
						(localproc_0
							{However, the manufacturer had to discontinue it due to a psychological disorder.}
						)
						(localproc_0
							{This model was originally designed as a family companion on those long space vacations.}
						)
					)
					(3
						(localproc_0
							{I'd love to sell you one, but every last one I had was snapped up by a movie director from New Japan IV - sorry.}
						)
						(localproc_0
							{Although a handsome machine, this robot has a habit of killing people without any real reason.}
						)
						(localproc_0
							{Ah, yes, a truly beautiful piece of machinery. This design rates five stars.}
						)
					)
					(4
						(localproc_0
							{Yes, this dandy, compact unit goes for a mere 29 buckazoids (23 with coupon). You can't go wrong when it's SUX!}
						)
						(localproc_0
							{...but of course you wouldn't want to hear about that.}
						)
						(localproc_0
							{I just happen to have one of these in stock. It's been completely re-conditioned since its regrettable accident that took the lives of...}
						)
						(localproc_0
							{The brand name says it all. SUX is a major manufacturer of refrigerators, dishwashers, and, some day, even time machines!}
						)
					)
					(5
						(localproc_0
							{We've got a set of three, and you can have them all for just 999 buckazoids (799 with a coupon).}
						)
						(localproc_0
							{Yessir, they may look like kleenex boxes, but they're built to run a loooong time. And quiet? You bet!}
						)
						(localproc_0
							{These little robots are perfect for gardening chores. And they don't mind at all if they're away on space missions for centuries.}
						)
					)
					(6
						(localproc_0
							{However, we're fresh out of them right now. Nobody seems to survive long enough to trade them in.}
						)
						(localproc_0
							{They're just a wee bit too ambitious is all. And who of us isn't? It's quite an endearing quality, actually.}
						)
						(localproc_0
							{Um... This model has had a bad rep, unearned if you ask me.}
						)
					)
					(7
						(localproc_0
							{I could let you have him for just 875 buckazoids (700 with a coupon).}
						)
						(localproc_0
							{Of course, they're all in hibernation this time of the century.}
						)
						(localproc_0
							{These are really some of the most useful all-purpose robots around, and extremely good with children.}
						)
					)
					(8
						(localproc_0
							{His memory isn't the best, so I'll let you have him for just 512 buckazoids (410 with a coupon).}
						)
						(localproc_0
							{If it had one fault, it was probably a tendency to be over- zealous. It's no longer available except for demolition purposes.}
						)
						(localproc_0
							{This was one of my better bodyguard models, and it also doubled as a radial-arm saw.}
						)
					)
					(9
						(localproc_0
							{Uh, well, maybe you shouldn't consider buying this particular model.}
						)
						(localproc_0
							{These robots have a bad attitude. You've got to keep them in line, or they'll walk all over you.}
						)
					)
					(10
						(localproc_0
							{I got it from some gambling type who was required to pay-up or perish.}
						)
						(localproc_0
							{I ask only 45 buckazoids for it (36 with coupon).}
						)
						(localproc_0
							{It will pilot any modern fighter or cruiser. And, it is one of the most experienced droids we carry.}
						)
						(localproc_0
							{That model is ideal for flight systems operations.}
						)
					)
				)
			)
			(4 ; Inventory
				(switch invItem
					(0 ; Cartridge
						(localproc_0
							{I'm afraid I can't take data cartridges in lieu of currency. Is sir a bit short of cash, hmmmm?}
						)
					)
					(2 ; Gadget
						(localproc_0
							{I'm afraid I can't accept your translator in exchange for a droid. Buckazoids work nicely to grease the wheels of commerce, however.}
						)
					)
					(4 ; Knife
						(localproc_0
							{Please, sir! Violence is never the answer. Money, on the other hand, is almost always the answer.}
						)
					)
					(5 ; Dehydrated_Water
						(Print
							{If he drinks from this, you won't. You decide not to offer him any.}
						)
					)
					(11 ; Jetpack
						(localproc_0
							{My advice, sir, is to come up with the cash or walk.}
						)
						(localproc_0
							{A shodily manufactured jet pack is certainly not worth the price of one of these fine previously-owned droids.}
						)
					)
					(18 ; Droids-B-Us_coupon
						(localproc_1)
						(= local1 1)
						(gEgo put: 18) ; Droids-B-Us_coupon
						(-= local2 9)
						(-= local3 9)
						(-= local4 9)
						(localproc_0
							{Very good, sir. This coupon entitles you to a reduction of twenty percent in the price of any of our fine, previously- owned droids.}
						)
					)
					(10 ; buckazoid
						(localproc_1)
						(switch (display cel:)
							(0
								(bugMouth setScript: noMoney)
							)
							(1
								(if (>= gBuckazoidCount local2)
									(-= gBuckazoidCount local2)
									(SetFlag 32)
									(bugMouth setScript: soldDroid)
								else
									(bugMouth setScript: noMoney)
								)
							)
							(2
								(bugMouth setScript: noMoney)
							)
							(3
								(localproc_0
									{Sorry, sir, but I've sold my last one of those.}
								)
							)
							(4
								(if (>= gBuckazoidCount local3)
									(-= gBuckazoidCount local3)
									(SetFlag 44)
									(bugMouth setScript: soldDroid)
								else
									(bugMouth setScript: noMoney)
								)
							)
							(5
								(bugMouth setScript: noMoney)
							)
							(6
								(localproc_0
									{Sorry, sir, but we have none of those in stock.}
								)
							)
							(7
								(bugMouth setScript: noMoney)
							)
							(8
								(bugMouth setScript: noMoney)
							)
							(9
								(localproc_0
									{I'm sorry, sir, but my conscience just won't let me sell him to you. Besides, your next of kin might sue.}
								)
							)
							(10
								(if (>= gBuckazoidCount local4)
									(-= gBuckazoidCount local4)
									(SetFlag 25)
									(bugMouth setScript: soldDroid)
								else
									(bugMouth setScript: noMoney)
								)
							)
						)
					)
					(else
						(localproc_0
							{Is sir financially embarassed, or might there be cash in one of those pockets?}
						)
						(localproc_0
							{I'm afraid that item can not be exchanged for enough money to purchase one of our quality products.}
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance antenna of Prop
	(properties
		x 198
		y 60
		description {antenna}
		view 148
		cel 2
		priority 12
		signal 16400
		cycleSpeed 30
	)
)

(instance wiggleAntenna of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Osc (Random 1 3) self)
			)
			(1
				(= cycles (Random 10 24))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance bugMouth of Prop
	(properties
		x 195
		y 91
		view 148
		loop 1
		priority 8
		signal 16400
		cycleSpeed 12
	)
)

(instance rightarm of Prop
	(properties
		x 264
		y 97
		view 148
		loop 2
		priority 1
		signal 16400
		cycleSpeed 24
		detailLevel 2
	)
)

(instance display of View
	(properties
		x 87
		y 93
		view 248
		signal 16400
	)
)

(instance readout of View
	(properties
		x 83
		y 112
		view 248
		loop 1
		signal 16400
	)
)

(instance award of Feature
	(properties
		y 189
		description {plaque}
		onMeCheck 2
		lookStr {The plaque says: "Salesbug of the year"! You'd better watch your money around this guy.}
	)
)

(instance robotHead of Feature
	(properties
		y 189
		description {robot head}
		onMeCheck 4
		lookStr {Yikes! It's an Ultron-17, the only robot bad enough to go head-to-head with an Arnoid-1000 Exterminator. You note with relief that he appears to be out of commission, at least temporarily.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Talk
				(Print 48 1) ; "The robot doesn't speak, but you think you can see a bloodthirsty gleam in his metallic eye."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance robotArm of Feature
	(properties
		y 189
		description {robot apendage}
		onMeCheck 8
		lookStr {That's an upgrade option for the Arnoid series. It's capable of crushing a person's skull. Very useful if you're in that line of work.}
	)
)

(instance bugButt of Feature
	(properties
		y 200
		description {exit button}
		onMeCheck 32
		lookStr {Click on this to leave Droids-B-Us.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(gCurRoom newRoom: 47)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance DBUsign of Feature
	(properties
		y 189
		description {sign}
		onMeCheck 64
		lookStr {The plastoid letters on the wall spell out: "Droids-B-Us"}
	)
)

(instance screen of Feature
	(properties
		y 189
		description {view screen}
		onMeCheck 128
		lookStr {The viewscreen shows pictures of droids currently available in your rather limited price range.}
	)
)

(instance diaphram of Feature
	(properties
		y 189
		description {diaphram}
		onMeCheck 256
		lookStr {It looks like some sort of gigantic... diaphragm?}
	)
)

(instance tubes of Feature
	(properties
		y 189
		description {power tubes}
		onMeCheck 512
		lookStr {These tubes on the wall are power conduits.}
	)
)

(instance table of Feature
	(properties
		y 189
		description {work table}
		onMeCheck 1024
		lookStr {There are many robotic parts scattered about the work table.}
	)
)

(instance parts of Feature
	(properties
		y 189
		description {robot parts}
		onMeCheck 2048
		lookStr {Many parts, bits, and pieces of robotic paraphanalia adorn the walls of this small store.}
	)
)

