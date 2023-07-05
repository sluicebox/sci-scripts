;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use eRoom)
(use Interface)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	Rm55 0
)

(local
	local0
)

(instance vision of Prop
	(properties
		y 130
		x 75
		view 319
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (gEgo script:)
			(clr)
			(event claimed: 1)
			((gEgo script:) cue:)
		)
	)
)

(instance Rm55 of eRoom
	(properties
		picture 55
		style 0
	)

	(method (init)
		(Load rsVIEW 319)
		(Load rsPIC 112)
		(super init:)
		(= global112 1)
		(gEgo view: 0 init:)
		(if (IsFlag 94)
			(= local0 1)
		)
		(= global112 1)
		(self setRegions: 123) ; wallRegion
		(self enterRoom: 115 235 115 185)
		(if (IsFlag 20)
			(gMuleObj loop: 3)
			(self muleEnterRoom: 145 220 145 186)
		)
		(if (== gCurRoomNum global206)
			(SetFlag 20)
			(= global206 0)
			(gMuleObj loop: 0 posn: 160 150)
		)
		(proc0_13 65)
		(gAddToPics doit:)
	)

	(method (doit)
		(if (and (not (self goingOut:)) (not (self comingIn:)))
			(cond
				((> (gEgo y:) 185)
					(if (IsFlag 94)
						(SetFlag 95)
					)
					(self leaveRoom: 54 (gEgo x:) 235)
				)
				((and (== (gEgo onControl: 1) 16384) (not local0))
					(= local0 1)
					(gEgo setScript: apparition)
				)
				((and (== (gEgo onControl: 1) 8192) local0)
					(= local0 0)
					(gEgo setScript: squareOne)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(cond
			((and (gCast contains: vision) gModelessDialog)
				(vision handleEvent: event)
			)
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(OnButton event 189 109 279 149)
					(OnButton event 125 131 173 144)
				)
				(Print 55 0) ; "These spiny plants are Aloe Vera."
			)
			((OnButton event 39 91 147 143)
				(Print 55 1) ; "The road leads back into the desert."
			)
			(
				(or
					(event claimed:)
					(and
						(!= (event type:) evSAID)
						(not
							(and
								(== (event type:) evMOUSEBUTTON)
								(& (event modifiers:) emSHIFT)
							)
						)
					)
				)
				(return)
			)
			(
				(or
					(Said 'ask/merlin[/advice]')
					(Said 'ask/advice[<merlin][/!*]')
					(Said 'talk/merlin[/!*]')
				)
				(Print 55 2) ; "My advice is simple and obvious. Enter Jerusalem and search for the Grail!"
			)
			((Said 'kill,attack,annihilate[/merlin]')
				(Print 55 3) ; "There's no one here to attack."
			)
			(
				(or
					(Said 'talk,ask[/merlin]>')
					(Said 'tell[/me]>')
					(Said 'are<where>')
					(Said 'get/clue>')
					(Said 'look>')
					(== (event type:) evMOUSEBUTTON)
				)
				(cond
					(
						(or
							(Said '/path')
							(Said '//path')
							(OnButton event 137 71 161 90)
						)
						(Print 55 4) ; "The road seems to stretch on forever."
					)
					(
						(or
							(Said '/tree')
							(Said '//tree')
							(OnButton event 271 65 310 147)
						)
						(Print 55 5) ; "It is a scrubby and uninteresting tree."
					)
					(
						(or
							(Said 'look[<at,around][/!*][/!*]')
							(Said 'look/room[/!*]')
							(Said
								'/desert,hill,mountain,distance,canyon,country'
							)
							(Said
								'//desert,hill,mountain,distance,canyon,country'
							)
							(OnButton event 9 52 310 146)
						)
						(Print 55 6) ; "In the distance is the searing desert and arid hills through which you have journeyed."
					)
					((or (Said '/gaza,port,ocean') (Said '//gaza,port,ocean'))
						(Print 55 7) ; "It cannot be seen from here."
					)
					(
						(or
							(Said '/wall,slab,city,jerusalem')
							(Said '//wall,slab,city,jerusalem')
						)
						(Print 55 8) ; "The walls of Jerusalem are but a few paces away."
					)
					((or (Said '/door,gate,arch') (Said '//door,gate,arch'))
						(Print 55 9) ; "Behind you, the Jaffa Gate is open and Jerusalem awaits you."
					)
					((or (Said '/*') (Said '//*'))
						(Print 55 10) ; "Concern yourself with your sacred mission. That is all that matters."
					)
				)
			)
		)
	)
)

(instance apparition of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 3 posn: (+ (gEgo x:) 3) (+ (gEgo y:) 5))
				(vision
					loop: 3
					cel: 4
					setCycle: Beg self
					cycleSpeed: 1
					ignoreActors: 1
					init:
				)
			)
			(1
				(vision loop: 2 setCycle: Fwd)
				(= cycles 10)
			)
			(2
				(vision loop: 1 setCycle: End)
				(= cycles 14)
			)
			(3
				(HandsOn)
				(User canControl: 0)
				(vision loop: 2 setCycle: Fwd)
				(Print 55 11 #at 110 110 #dispose) ; "Arthur, halt! At great cost to myself, I send this vision of warning. You must not turn away from your mission now."
			)
			(4
				(Print 55 12 #at 110 110 #dispose) ; "Months of weary labor and travel have brought you here. There is nothing this way but the desert whose hardship you have already suffered."
			)
			(5
				(Print 55 13 #at 110 110 #dispose) ; "Turn back to Jerusalem, King Arthur, and seek your destiny within."
			)
			(6
				(HandsOff)
				(vision loop: 3 cel: 0 setCycle: End self)
			)
			(7
				(HandsOn)
				(SetFlag 94)
				(client setScript: 0)
			)
		)
	)
)

(instance squareOne of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(if (IsFlag 20)
					(ClearFlag 20)
					(= global206 54)
				)
				(gCast eachElementDo: #hide)
				(gCurRoom style: 17 drawPic: 112)
				(if (IsFlag 95)
					(Print 55 14) ; "So, in spite of my best efforts and advice, you insist on heading back into the desert like an utter fool."
				)
				(Print 55 15) ; "And to think that men once hailed you as King and praised your ability."
				(SetScore 295 1 -25)
				(ClearFlag 94)
				(ClearFlag 95)
				(gCurRoom newRoom: 38)
			)
		)
	)
)

