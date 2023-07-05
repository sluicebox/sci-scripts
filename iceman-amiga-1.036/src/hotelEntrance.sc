;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use n954)
(use LoadMany)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	hotelEntrance 0
)

(instance hotelEntrance of Rm
	(properties
		picture 9
		horizon 128
		north 10
		east 12
		south 2
		west 3
	)

	(method (init)
		(super init:)
		(gAddToPics add: newsStand eachElementDo: #init doit:)
		(Load rsSOUND 42)
		(Load rsSOUND 36)
		(LoadMany rsVIEW 9 9 206 200 109 209)
		(self
			setRegions: 300 301 ; tahiti, Water
			setFeatures:
				hut
				newsStand
				flowerFeat
				westwindow
				((Clone westwindow)
					x: 145
					nsTop: 84
					nsBottom: 116
					nsLeft: 140
					nsRight: 151
					heading: 180
					name: {middleLeftWindow}
					yourself:
				)
				((Clone westwindow)
					x: 180
					nsTop: 84
					nsBottom: 119
					nsLeft: 170
					nsRight: 189
					heading: 180
					name: {middleRightWindow}
					yourself:
				)
				((Clone westwindow)
					x: 235
					nsTop: 100
					nsBottom: 129
					nsLeft: 219
					nsRight: 252
					heading: 180
					name: {eastLeftWindow}
					yourself:
				)
				((Clone westwindow)
					x: 282
					nsTop: 97
					nsBottom: 129
					nsLeft: 262
					nsRight: 302
					heading: 180
					name: {eastRightWindow}
					yourself:
				)
		)
		(gEgo init: observeControl: 16384)
		(switch gPrevRoomNum
			(north
				(gEgo posn: 106 135)
			)
			(else
				(gEgo posn: 106 188)
			)
		)
		(egoReflection init:)
		(lobbyDoor init:)
	)

	(method (newRoom)
		(super newRoom: &rest)
		(gEgo ignoreControl: 16384)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room]')
				(Print 9 0) ; "This is the entrance to the hotel lobby. Located near the door you see a newspaper stand."
			)
		)
	)
)

(instance egoReflection of Prop
	(properties
		view 9
	)

	(method (init)
		(self ignoreActors: setPri: 8)
		(super init:)
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(if (> 137 (gEgo y:))
			(self show:)
		else
			(self hide:)
		)
		(= temp0 (gEgo x:))
		(= temp1 (gEgo loop:))
		(self
			setLoop:
				(if (> temp1 3)
					(- temp1 4)
				else
					temp1
				)
			setCel: (gEgo cel:)
			posn:
				(if (< temp0 160)
					(+ temp0 3)
				else
					(- temp0 3)
				)
				(- (gEgo y:) 2)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at]/glass,reflection')
				(Print 9 1 #time 10) ; "You see a reflection of yourself."
			)
		)
	)
)

(instance lobbyDoor of Prop
	(properties
		y 132
		x 133
		heading 180
		view 209
		loop 4
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			((gCurRoom north:)
				(self setCel: (self lastCel:) ignoreActors: setCycle: Beg self)
				(theSound number: (proc0_5 42) loop: 1 play:)
			)
			(else
				(self ignoreActors: stopUpd:)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 9 2) ; "This is the entrance to the hotel lobby."
					)
					((Said 'close/*')
						(Print 9 3) ; "It is closed."
					)
					((Said 'knock/*')
						(Print 9 4) ; "Why bother?"
					)
					(
						(GoToIfSaid
							self
							event
							(- (lobbyDoor x:) 14)
							(+ (lobbyDoor y:) 2)
							0
							9
							5
						))
					((Said 'open/*')
						(if (!= (gEgo view:) 206)
							(Print 9 6) ; "You can't go in the lobby without your shirt."
						else
							(self setScript: openDoorScript self)
						)
					)
				)
			)
		)
	)

	(method (cue)
		(self stopUpd:)
	)
)

(instance openDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo loop: 3 heading: 0)
				(lobbyDoor setCycle: End self)
				(theSound number: (proc0_5 36) loop: 1 play:)
			)
			(1
				(gEgo
					ignoreControl: 16384
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 8)
					setAvoider: 0
				)
				(client setScript: 0)
			)
		)
	)
)

(instance newsStand of RPicView
	(properties
		y 132
		x 151
		heading 180
		view 109
		priority 9
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look/stand<magazine')
				(Print 9 7) ; "It's a newspaper stand."
			)
			((Said '[/stand<newspaper,news,times,newspaper]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at,in]')
						(if (> (gEgo distanceTo: self) 35)
							(Print 9 8) ; "You see a newspaper stand."
						else
							(Print 9 9) ; "Through the plastic window you see the latest edition of the Tahitian Times."
						)
					)
				)
			)
			((Said '[/newspaper,news,times,newspaper]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 9 10) ; "There are newspapers in the newspaper stand."
					)
					((GoToIfSaid self event self 25 0 9 5))
					((Said 'get,get')
						(Print 9 11) ; "You need to deposit fifty cents."
					)
					((Said 'buy')
						(if (gEgo has: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
							(Print 9 12) ; "You deposit fifty cents and remove a copy of the paper."
							(gEgo setScript: readPaperScript)
						else
							(Print 9 13) ; "You don't have the change."
						)
					)
				)
			)
			((Said '[/money,change,cent,coin]>')
				(cond
					((TurnIfSaid self event 'deposit,insert'))
					((GoToIfSaid self event self 25 'deposit,insert' 9 5))
					((Said 'deposit,insert')
						(if (gEgo has: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
							(Print 9 12) ; "You deposit fifty cents and remove a copy of the paper."
							(gEgo setScript: readPaperScript)
						else
							(Print 9 13) ; "You don't have the change."
						)
					)
				)
			)
		)
	)
)

(instance readPaperScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(tahiti flags: (| (tahiti flags:) $0008))
				(gEgo
					put: 4 gCurRoomNum ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
					setLoop: (if (== (gEgo view:) 206) 1 else 2)
					view: 109
					cycleSpeed: 1
					setCel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(1
				(Print 9 14 #at 65 120) ; "Reading the front page, you learn that the cold war between the USSR and the United States is beginning to heat up."
				(Print 9 15 #at 65 120) ; "The Russian-supported radical terrorist group led by Jaharah Khommini Sieb Abdul has taken the United States Ambassador to the Middle East as hostage."
				(gEgo setCycle: End self)
			)
			(2
				(gEgo setCycle: Beg self)
			)
			(3
				(Print 9 16 #at 65 120) ; "You further learn that the terrorist group is demanding ten million dollars ransom in order to purchase arms."
				(Print 9 17 #at 65 120) ; "If the demand is not met within 30 days, the Ambassador will be shot through the head and his body dumped in front of the US Embassy."
				(Print 9 18 #at 65 120) ; "In response to the Soviet naval buildup in the Mediterranian, the United States has ordered its 7th Fleet into the area."
				(Print 9 19 #at 30 120 #width 260) ; "The President has vowed that if the Ambassador is not released unharmed within a reasonable amount of time, the United States will not hesitate to take an aggressive military stance against the cowardly perpetrators."
				(gEgo setCycle: End self)
			)
			(4
				(gEgo
					view: (if (== (gEgo loop:) 1) 206 else 200)
					cycleSpeed: 0
					setLoop: -1
					loop: 3
					setCycle: Walk
				)
				(= cycles 1)
			)
			(5
				(Print 9 20 #at 65 120) ; "After reading the paper and discarding it, you think to yourself, "This is really something. After just a short time on military leave, the whole world goes to pot.""
				(gGame changeScore: 2)
				(gEgo setScript: 0)
				(HandsOn)
			)
		)
	)
)

(instance flowerFeat of RFeature
	(properties
		y 136
		x 26
		z 30
		nsTop 107
		nsBottom 123
		nsRight 68
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/planter,flower,box]>')
				(cond
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look[<at]')
						(Print 9 21) ; "You see a planter box full of flowers."
					)
				)
			)
		)
	)
)

(instance westwindow of RFeature
	(properties
		y 106
		x 26
		z 10
		heading 180
		nsTop 84
		nsBottom 105
		nsRight 68
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look[<at,in]/*'))
					((Said 'look[<at,in]')
						(if (> (gEgo distanceTo: self) 20)
							(Print 9 22) ; "You see the glare of the hotel lobby windows."
						else
							(Print 9 23) ; "You see the hotel lobby inside."
						)
					)
				)
			)
		)
	)
)

(instance hut of RFeature
	(properties
		y 38
		x 159
		heading 180
		nsBottom 77
		nsRight 319
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/building]>')
				(cond
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look[<at]')
						(Print 9 2) ; "This is the entrance to the hotel lobby."
					)
				)
			)
		)
	)
)

(instance theSound of Sound
	(properties
		priority 2
	)
)

