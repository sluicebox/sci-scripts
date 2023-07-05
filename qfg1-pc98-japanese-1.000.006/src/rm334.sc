;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 334)
(include sci.sh)
(use Main)
(use RFeature)
(use Extra)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm334 0
)

(local
	local0
	local1
)

(procedure (localproc_0)
	(HighPrint 334 0) ; "This place seems sinister at night. You see a strangely glowing object at the far end of the alley."
)

(instance frontBarrel of PV
	(properties
		y 120
		x 119
		view 333
		loop 2
	)
)

(instance backBarrel of PV
	(properties
		y 97
		x 162
		view 333
		loop 2
	)
)

(instance slink of Act
	(properties
		y 97
		x 162
		view 333
		loop 3
		illegalBits 0
	)
)

(instance sneak of Act
	(properties
		y 120
		x 119
		view 333
		loop 4
		illegalBits 0
	)
)

(instance knife of Act
	(properties
		y 1000
		x 1000
		view 333
		priority 10
		illegalBits 0
	)
)

(instance coin of Extra
	(properties
		y 103
		x 135
		view 333
		cycleType 1
		pauseCel 2
		minPause 12
		minCycles 1
		maxCycles 1
	)
)

(instance rm334 of Rm
	(properties
		picture 333
		style 0
		south 330
	)

	(method (dispose)
		(gMouseHandler delete: self)
		(SetFlag 101)
		(super dispose:)
	)

	(method (init)
		(Load rsVIEW 333)
		(Load rsVIEW 503)
		(super init:)
		(gMouseHandler add: self)
		(SL enable:)
		(self setLocales: 811 801)
		(NormalEgo)
		(switch gPrevRoomNum
			(53
				(gEgo posn: 160 130 init: setMotion: MoveTo 160 150)
			)
			(else
				(gEgo posn: 120 187 init: setMotion: MoveTo 120 180)
			)
		)
		(gAddToPics add: frontBarrel backBarrel eachElementDo: #init doit:)
		(slink ignoreActors: 1 setPri: 7 init: stopUpd:)
		(sneak ignoreActors: 1 setPri: 10 init: stopUpd:)
		(knife ignoreActors: 1 setLoop: 5 setPri: 10 init: stopUpd:)
		(coin ignoreActors: 1 setLoop: 6 setPri: 6 init:)
		(if (not (IsFlag 101))
			(RedrawCast)
			(localproc_0)
		)
	)

	(method (doit)
		(if (and (not local0) (<= (gEgo y:) 132))
			(= local0 1)
			(self setScript: ambushScript)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((Said 'read,look,look/mark')
				(if (<= (gEgo y:) 150)
					(HighPrint 334 1) ; "Some sharp object appears to have been thrown at these walls several times."
				else
					(HighPrint 334 2) ; "You can't make them out from here."
				)
			)
			((Said 'look,look[<at,around][/!*,street,alley]')
				(localproc_0)
			)
			((and (== local0 1) (Said 'look,look/thief,thief,man,man'))
				(HighPrint 334 3) ; "These two men may be smiling at you, but they don't seem very friendly."
			)
			((Said 'look,look/wall')
				(HighPrint 334 4) ; "The walls seem pretty normal, but there are some curious marks at the north ends of the buildings."
			)
			((Said 'look,look/barrel')
				(HighPrint 334 5) ; "The barrels are empty, and smell of sour beer."
			)
			(
				(and
					(== local0 1)
					(or (MouseClaimed onDagger event 3) (Said 'look,look/dagger'))
				)
				(HighPrint 334 6) ; "The dagger looks sharp and very deadly."
			)
			((or (MouseClaimed coin event 3) (Said 'look,look/alm,item'))
				(if (<= (gEgo y:) 150)
					(HighPrint 334 7) ; "It's a glowing golden coin."
				else
					(HighPrint 334 8) ; "You just see a glint from here."
				)
			)
			((and (== local0 1) (MouseClaimed sneak event 3))
				(HighPrint 334 9) ; "He may be short, but the dagger makes him look 7 feet tall."
			)
			((and (== local0 1) (MouseClaimed slink event 3))
				(HighPrint 334 10) ; "The florid face tells you that this thief is a regular at the "Aces and Eights" tavern."
			)
			((MouseClaimed onBricks event 3)
				(HighPrint 334 11) ; "The whole place is in need of repair."
			)
			((MouseClaimed onFirstBarrel event 3)
				(HighPrint 334 12) ; "Looks like this barrel once contained Dragon's Breath. The bottom's eaten out."
			)
			((MouseClaimed onSecondBarrel event 3)
				(HighPrint 334 13) ; "A whiff of Troll's Sweat indicates that this barrel is from the "Aces and Eights" tavern."
			)
			((Said 'get,get,move,move,pick,lockpick<up,grab>')
				(if (Said '/barrel')
					(HighPrint 334 14) ; "The barrels are too heavy to move."
				)
			)
			(
				(and
					(not (and (not local0) (<= (gEgo y:) 132)))
					(Said 'japaneseclimbup,climb,climb')
				)
				(HighPrint 334 15) ; "You're too far away from the back wall."
			)
		)
	)
)

(instance ambushScript of Script
	(properties)

	(method (doit)
		(if (not (-- register))
			(HighPrint 334 16) ; "Aw, now look what ya done. You made poor Slink run out of patience."
			(HandsOff)
			(self changeState: 7)
		)
		(if (and local0 (> (gEgo y:) 143) (not local1) (not (IsFlag 101)))
			(= local0 0)
			(= register 0)
			(TimePrint 4 334 17) ; "Aw, ya forgot to pay. What a shame."
			(HandsOff)
			(self changeState: 6)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(switch (event type:)
			(evSAID
				(cond
					((and (not local1) (Said 'japaneseclimbup,climb,climb'))
						(TimePrint 3 334 18) ; "That's a pretty tall wall."
						(HandsOff)
						(self changeState: 7)
					)
					((Said 'show,make,give/sign,sign[<thief]')
						(cond
							(local1
								(HighPrint 334 19) ; "The thieves seem to be ignoring you."
							)
							((IsFlag 123)
								(= register 0)
								(HighPrint 334 20) ; "Yeah, yeah, we know, you're in the Guild too. How's a poor independent businessman supposed to make a living around here with all this competition?"
								(HighPrint 334 21) ; "Now go before I forget you made the sign and I make you pay anyway."
								(= local1 1)
								(= register 200)
							)
							((not (or [gEgoStats 8] [gEgoStats 9])) ; stealth, pick locks
								(HighPrint 334 22) ; "What's that supposed to be? You trying to pretend you're a thief or something? Har, har."
							)
							(else
								(= register 0)
								(HighPrint 334 23) ; "You mean to say that the first customer we've had in months is a fellow thief? And here I thought we were going to make some money."
								(SolvePuzzle 642 3 2)
								(if (not (gEgo has: 25)) ; thief certificate
									(HighPrint 334 24) ; "You had better check in at the Thieves' Guild before you get in trouble for practicing without a license. Find Crusher in the tavern, and give him the password."
									(HighPrint 334 25) ; "The password is 'blowfish'."
								)
								(SetFlag 123)
								(HighPrint 334 26) ; "Now go before I forget you made the sign and I make you pay anyway."
								(= local1 1)
								(= register 200)
							)
						)
					)
					(
						(or
							(Said 'pay')
							(Said 'give,put,drop,throw[/alm,silver,gold]')
						)
						(= register 0)
						(cond
							(local1
								(HighPrint 334 27) ; "That's all right; we already have all your money. But it was certainly nice of you to offer."
							)
							((not (Purchase 5))
								(HighPrint 334 28) ; "Hey! You don't have enough money to be worth our while. How do you expect us poor independent businessmen to make a living?"
								(HandsOff)
								(self changeState: 7)
							)
							(else
								(= [gInvNum 1] 0) ; silver
								(= [gInvNum 2] 0) ; gold
								(HighPrint 334 29) ; "Slink: "Thanks, it's been a pleasure doing business with you. You can find your way out, I'm sure. But better hurry before my dagger starts to slip.""
								(SolvePuzzle 606 -10 2)
								(= local1 1)
								(= register 200)
							)
						)
					)
					((Said 'talk,talk,ask')
						(HighPrint 334 30) ; "Slink: "My finger is starting to get a bit twitchy, so forget about questions, just pay the man and get out alive.""
					)
					(
						(or
							(Said 'attack,kill,attack,attack,capture,cut,hit')
							(Said 'throw/dagger,boulder')
						)
						(HighPrint 334 31) ; "As you start to draw your weapon, the thieves jump you."
						(HandsOff)
						(self changeState: 7)
					)
					((Said 'cast')
						(HighPrint 334 32) ; "Before you can begin to use any magic, the thieves decide that you're up to no good."
						(HandsOff)
						(self changeState: 7)
					)
				)
			)
		)
		(super handleEvent: event)
	)

	(method (changeState newState)
		(= state newState)
		(switch state
			(0
				(= register 300)
				(HandsOff)
				(slink startUpd: setCycle: End self)
			)
			(1
				(sneak startUpd: setCycle: End self)
			)
			(2
				(knife
					startUpd:
					posn: 150 108
					setCycle: Fwd
					setMotion: MoveTo 175 95 self
				)
			)
			(3
				(knife setCel: 2 addToPic:)
				(slink ignoreActors: 0 stopUpd:)
				(= cycles 3)
			)
			(4
				(sneak setCel: 3 ignoreActors: 0 stopUpd:)
				(= cycles 5)
			)
			(5
				(cond
					((not (IsFlag 126))
						(SetFlag 126)
						(HighPrint 334 33) ; "Slink says, "That coin light spell gets them every time. See that dagger? The next one is centered on your back. Give Sneak there your cash and you walk out of here. It's a simple trade, your life for your money.""
						(HandsOn)
					)
					((not (IsFlag 123))
						(HighPrint 334 34) ; "Slink: "Why, how nice to see you again. I do hope (for your sake) you brought us some nice shiny new silver.""
						(HandsOn)
					)
					((not (gEgo has: 25)) ; thief certificate
						(HighPrint 334 35) ; "Slink: "Hey, Sneak, this guy's hard of hearing or something. I told him to get a license last time he was here, and he didn't listen.""
						(HighPrint 334 36) ; "Let's teach him a little lesson about listening to his betters."
						(self changeState: 7)
					)
					((IsFlag 299)
						(HighPrint 334 37) ; "As Slink reaches for his dagger, you draw your Thieves' Guild license. . ."
						(HighPrint 334 38) ; "You *almost* make it."
						(HighPrint 334 39) ; "Slink: "Hey, Sneak, this guy's hard of hearing or something. I told him to stay out of our alley, and he didn't listen.""
						(HighPrint 334 36) ; "Let's teach him a little lesson about listening to his betters."
						(self changeState: 7)
					)
					(else
						(HighPrint 334 37) ; "As Slink reaches for his dagger, you draw your Thieves' Guild license. . ."
						(HighPrint 334 40) ; "You win by a close margin."
						(HighPrint 334 41) ; "Slink: "All right, so you got your license. How nice. Guess we don't get to kill you right now.""
						(HighPrint 334 42) ; "But stay out of our alley, 'cause we got real short memories, like."
						(SetFlag 299)
						(= local1 1)
						(= register 200)
						(HandsOn)
					)
				)
			)
			(6
				(sneak setLoop: 7 cel: 0)
				(self cue:)
			)
			(7
				(= register 0)
				(sneak cycleSpeed: 2 setCycle: End self)
			)
			(8
				(gEgo
					view: 503
					setLoop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(9
				(clr)
				(EgoDead ; "Perhaps you shouldn't explore dark alleys at night unless you are looking for trouble. Or perhaps you should look in your manual to learn how to deal with thieves."
					334
					43
					80
					{ Erana missed this spot. %j\b4\d7\c5\ca\a4 \ba\ba\a6 \dc\bd\da\c0\dd\c0\de\c8}
					82
					800
					0
					0
				)
			)
		)
	)
)

(instance onFirstBarrel of RFeature
	(properties
		nsTop 120
		nsLeft 111
		nsBottom 142
		nsRight 125
	)
)

(instance onSecondBarrel of RFeature
	(properties
		nsTop 97
		nsLeft 154
		nsBottom 121
		nsRight 171
	)
)

(instance onDagger of RFeature
	(properties
		nsTop 86
		nsLeft 171
		nsBottom 94
		nsRight 179
	)
)

(instance onBricks of RFeature
	(properties
		nsTop 66
		nsLeft 188
		nsBottom 93
		nsRight 201
	)
)

