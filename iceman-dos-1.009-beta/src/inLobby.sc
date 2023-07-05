;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use n316)
(use n361)
(use n824)
(use n828)
(use n954)
(use LoadMany)
(use RFeature)
(use Extra)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	inLobby 0
)

(local
	local0
	local1
)

(instance inLobby of Rm
	(properties
		picture 10
		east 11
		south 9
		picAngle 70
		vanishingX 116
		vanishingY 36
	)

	(method (init)
		(super init:)
		(clerk init:)
		(doorToBar init:)
		(girlInLounge init:)
		(gAddToPics add: signPic picturePic barSignPic eachElementDo: #init doit:)
		(Load rsSOUND 42)
		(Load rsSOUND 36)
		(LoadMany rsVIEW 10 910 110 310)
		(gEgo init:)
		(self
			setRegions: 300 ; tahiti
			setFeatures: flowersFeature plantFeature mailRFeat girlRFeature
		)
		(switch gPrevRoomNum
			(east
				(gEgo posn: 280 113 setMotion: MoveTo 200 113)
			)
			(else
				(HandsOn)
				(gEgo posn: 116 176)
			)
		)
		(proc824_0)
		(proc316_0 gCurRoomNum 5)
	)

	(method (cue)
		(super cue:)
		(self newRoom: 11) ; hotelBar
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at,around][/room,scene]')
				(Print 10 0) ; "This is the Hotel Lobby."
			)
			((Said 'look<up')
				(Print 10 1) ; "You decide not to say anything about the cobwebs on the ceiling."
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo y:) 180)
			(self newRoom: south)
		)
	)
)

(instance signPic of RPicView
	(properties
		y 98
		x 174
		z 20
		view 10
		loop 3
		priority 4
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/sign,wall]>')
				(cond
					((TurnIfSaid self event 'read,look/*'))
					((Said 'read,look[<at]')
						(if (> (gEgo distanceTo: self) 60)
							(Print 10 2) ; "There's a sign on the wall, but you can't read it from here."
						else
							(signCloseUp init:)
						)
					)
				)
			)
		)
	)
)

(instance signCloseUp of View
	(properties
		y 58
		x 164
		view 310
	)

	(method (init)
		(super init:)
		(self setPri: 15)
		(&= signal $feff)
		(gIceKeyDownHandler add: self)
		(SetScore tahiti 413 4 1)
	)

	(method (doit)
		(super doit:)
		(if (> (gEgo distanceTo: signPic) 60)
			(self dispose:)
		)
	)

	(method (handleEvent event)
		(if (or (== (event type:) evMOUSEBUTTON) (== (event type:) evKEYBOARD))
			(self dispose:)
		)
	)

	(method (dispose)
		(gIceKeyDownHandler delete: self)
		(super dispose:)
	)
)

(instance picturePic of RPicView
	(properties
		y 124
		x 43
		z 30
		view 10
		loop 2
		priority 5
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/picture,(wall<left)]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 10 3) ; "There is a picture of a humuhumunukunukuapua'a on the wall."
					)
				)
			)
		)
	)
)

(instance barSignPic of RPicView
	(properties
		y 139
		x 267
		z 28
		view 10
		loop 5
		priority 9
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/sign,(wall<right)]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 10 4) ; "There is a sign for the bar on the wall."
					)
				)
			)
		)
	)
)

(instance doorToBar of Prop
	(properties
		y 120
		x 238
		view 10
		loop 4
	)

	(method (init)
		(super init:)
		(self ignoreActors: 1 setPri: 6 stopUpd:)
	)

	(method (doit)
		(super doit:)
		(if (and (== (gEgo onControl: 1) 512) (not (self script:)))
			(HandsOff)
			(self setScript: barDoorScript)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 10 5) ; "This is the door to the bar."
					)
					((Said 'close')
						(Print 10 6) ; "It is closed."
					)
					((GoToIfSaid self event 229 115 'open' 10 7))
					((Said 'open')
						(return)
					)
				)
			)
		)
	)
)

(instance barDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
				(theSound number: (proc0_5 36) loop: 1 play:)
			)
			(1
				(if (> (gEgo x:) (client x:))
					(= register -1)
				else
					(= register 1)
				)
				(gEgo
					illegalBits: (if (== register 1) 0 else -32768)
					setMotion:
						MoveTo
						(+ (gEgo x:) (* 45 register))
						(gEgo y:)
						self
				)
			)
			(2
				(gEgo illegalBits: -32768)
				(client setCycle: Beg self)
				(theSound number: (proc0_5 42) loop: 1 play:)
			)
			(3
				(if (== register 1)
					(HandsOn)
					(gCurRoom newRoom: 11) ; hotelBar
				else
					(if (not (gCurRoom script:))
						(HandsOn)
					)
					(self dispose:)
				)
			)
		)
	)
)

(instance girlInLounge of Extra
	(properties
		y 164
		x 268
		view 10
		cycleType 2
		hesitation 15
		minPause 70
		maxPause 110
		minCycles 1
		maxCycles 1
	)
)

(instance girlRFeature of RFeature
	(properties
		y 167
		x 267
		nsTop 144
		nsLeft 257
		nsBottom 162
		nsRight 278
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/woman,cunt,boob][/table]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 10 8) ; "There is a beautiful young lady at the table."
					)
					((GoToIfSaid self event self 40 0 10 7))
					((Said 'talk')
						(Print 10 9) ; "She obviously has nothing to say as she completely ignores you."
					)
					((Said 'kiss')
						(Print 10 10) ; "She doesn't seem to be the affectionate type."
					)
					((Said 'fuck,suck')
						(Print 10 11) ; "Have you no shame?"
					)
				)
			)
		)
	)
)

(instance clerk of Act
	(properties
		y 106
		x 118
		z 20
		view 910
	)

	(method (init)
		(super init:)
		(self setPri: 6 stopUpd:)
		(if (and (& (tahiti flags:) $0008) (not (& (tahiti flags:) $0100)))
			(= local1 (Random 50 100))
		)
	)

	(method (doit)
		(super doit:)
		(if (and local1 (not (-- local1)))
			(self cue:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/woman,woman,clerk,you,cunt,boob]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(if (> (gEgo distanceTo: self) 30)
							(Print 10 12) ; "A beautiful native girl is standing behind the counter."
						else
							(proc361_0 110 eyesExtra lipsExtra)
						)
					)
					((GoToIfSaid self event self 20 0 10 7))
					((Said 'fuck,suck')
						(Print 10 13) ; "Go suck a lemon!"
					)
					((Said '/cunt,boob')
						(Print 10 11) ; "Have you no shame?"
					)
					((Said 'talk')
						(switch (Random 0 2)
							(0
								(Print 10 14) ; "What can I do for you sir?" she says."
							)
							(1
								(Print 10 15) ; "Hello!" the clerk says, "Can I help you?"
							)
							(2
								(Print 10 16) ; "Hi there!" she says, "How can I help you?"
							)
						)
						(SetScore tahiti 413 32 1)
					)
					((Said 'thank')
						(Print 10 17) ; "You're welcome."
					)
					((Said 'kiss')
						(Print 10 18) ; "Please" she says, "I hardly know you."
					)
					(
						(or
							(Said 'get,call,dial,(pick<up)/call')
							(Said '(call<use)')
							(Said 'make/call<call')
							(Said '//call<about')
						)
						(Print 10 19) ; "The girl responds, "There is a phone available in your hut, sir.""
					)
				)
			)
			((TurnIfSaid self event '[/headband,key,message]'))
			((Said 'look[<at]/headband')
				(Print 10 20) ; "A wreath made from fresh plumaria blossoms adorns her head."
			)
			((Said '/message>')
				(cond
					((not (& (tahiti flags:) $0008)))
					((Said 'read,look[<at]')
						(if (& (tahiti flags:) $0100)
							(Print 10 21) ; "The message reads: Call immediately! General Braxton."
						else
							(event claimed: 0)
						)
					)
					((TurnIfSaid self event 'look[<at]/*'))
					((GoToIfSaid self event self 20 0 10 7))
					((Said 'get,get')
						(cond
							((& (tahiti flags:) $0100)
								(proc0_35) ; "You already took that."
							)
							(local0
								(Print 10 22) ; "You take the message from the clerk."
								(gGame changeScore: 1)
								(tahiti flags: (| (tahiti flags:) $0100))
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
			((Said '/key>')
				(cond
					((GoToIfSaid self event self 20 0 10 7))
					((Said 'get,get')
						(if (proc316_1 gCurRoomNum 5)
							(self setScript: keyScript 0 0)
							(gEgo get: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
							(SetScore tahiti 413 2 1)
						else
							(proc0_35) ; "You already took that."
						)
					)
					((Said 'place,give,return,drop')
						(if (gEgo has: 5) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
							(gEgo put: 5 gCurRoomNum) ; Tahiti: Key | Sub: Storage_Compartment_Key | Tunisia: Map
							(self setScript: keyScript 0 1)
						else
							(proc0_38) ; "You don't have that."
						)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue: &rest)
		(if (and (not (& (tahiti flags:) $0100)) (& (tahiti flags:) $0008))
			(= local0 1)
			(Print 10 23 #time 10) ; "The clerk says to you, "Oh ,Mr. Westland, I have an urgent message for you!""
			(Print 10 24) ; "Continuing she says, "It's from a General Braxton.""
			(tahiti setScript: (ScriptID 300 2)) ; braxMadScript
		)
	)
)

(instance keyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(Print 10 25) ; "Yes sir!" the clerk says, "I'll have it right here when you need it."
				)
				(clerk loop: 0 setCycle: End self)
			)
			(1
				(= seconds 2)
			)
			(2
				(clerk loop: 1 setCycle: End self)
			)
			(3
				(clerk loop: 0 cel: 0)
				(if (not register)
					(Print 10 26) ; "Yes sir!" she says, "Here you are."
				)
			)
		)
	)
)

(instance eyesExtra of Extra
	(properties
		y 83
		x 152
		view 110
		cycleType 2
		hesitation 10
		minPause 50
		maxPause 50
		minCycles 1
		maxCycles 1
	)
)

(instance lipsExtra of Extra
	(properties
		y 132
		x 155
		view 110
		loop 1
		cycleType 2
		hesitation 10
		minPause 50
		maxPause 50
		minCycles 1
		maxCycles 1
	)
)

(instance flowersFeature of RFeature
	(properties
		y 179
		x 227
		z 20
		nsTop 139
		nsLeft 217
		nsBottom 159
		nsRight 237
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/flower,centerpiece,table]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 10 27) ; "There is a flower centerpiece on the table."
					)
					((GoToIfSaid self event self 50 0 10 7))
					((Said 'smell')
						(Print 10 28) ; "These flowers have no smell."
					)
					((Said 'get')
						(Print 10 29) ; "You don't need the flowers. They are for decoration."
					)
				)
			)
		)
	)
)

(instance plantFeature of RFeature
	(properties
		y 101
		x 204
		nsTop 71
		nsLeft 194
		nsBottom 101
		nsRight 214
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/plant,fern]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 10 30) ; "There is a tropical fern in the corner of the room."
					)
					((GoToIfSaid self event self 40 0 10 7))
					((Said 'move,get')
						(proc0_39) ; "You don't need to do that."
					)
					((Said 'smell')
						(Print 10 31) ; "It smells like a fern."
					)
				)
			)
		)
	)
)

(instance mailRFeat of RFeature
	(properties
		y 65
		x 100
		nsTop 60
		nsLeft 84
		nsBottom 75
		nsRight 111
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/box,(wall<center,medium,rear)]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 10 32) ; "They keep the keys in these boxes."
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

