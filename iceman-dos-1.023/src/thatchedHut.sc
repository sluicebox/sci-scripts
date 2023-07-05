;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use SoundSyncWave)
(use n828)
(use n954)
(use LoadMany)
(use RFeature)
(use Sight)
(use Avoid)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	thatchedHut 0
)

(local
	local0
	local1
)

(procedure (localproc_0 param1 param2)
	(gEgo
		loop: 5
		setCel:
			(switch (/ (+ 18 param2) 36)
				(3 4)
				(4 3)
				(5 2)
				(6 1)
				(7 0)
				(8 0)
				(else 2)
			)
		heading: param2
	)
)

(procedure (localproc_1)
	(return (== (gEgo view:) 2))
)

(instance thatchedHut of Rm
	(properties
		picture 2
		horizon 99
		north 9
		east 12
		south 16
		west 3
		picAngle 70
	)

	(method (init)
		(super init:)
		(if (== (tahiti script:) (ScriptID 300 1)) ; tookTooLongScript
			(if (< 124 (gEgo y:) 140)
				(gEgo y: 124)
			)
			(if (< 139 (gEgo y:) 159)
				(gEgo y: 158)
			)
			(dinghyRamp init:)
			(gAddToPics add: noSinkyDinghy dinghyPost)
			(self setFeatures: dinghyMan noSinkyDinghy)
		)
		(gAddToPics add: chairPic eachElementDo: #init doit:)
		(self setFeatures: lobbyDoor chairPic setRegions: 301 300) ; Water, tahiti
		(LoadMany rsVIEW 2 200 206 602 502 402)
		(gEgo init:)
		(= local0 (ScriptID 301 2)) ; bikini3Lady
		(= local1 (ScriptID 301 3)) ; bikini4Lady
		(switch gPrevRoomNum
			(north
				(gEgo posn: 133 105)
			)
			(east
				(gEgo x: 315)
			)
			(west
				(gEgo x: 5)
				(if (and (== (gEgo view:) 206) (> (gEgo y:) 115))
					(gEgo y: 115)
				)
				(if (< (gEgo y:) 100)
					(gEgo y: 100)
				)
			)
			(south
				(gEgo y: 187)
				(if (== (gEgo onControl: 1) 1)
					(gEgo view: 200)
				)
			)
			(else
				(gEgo
					view: 2
					loop: 3
					cel: 0
					heading: 180
					posn: 227 152
					init:
					setScript: relaxScript
				)
				(User canControl: 0 canInput: 1)
			)
		)
		(shirt init:)
		(hutDoor posn: 155 80 setLoop: 0 setPri: 3 init: stopUpd:)
		(wave init: gIceGlobalSound setPri: 5)
		((ScriptID 301) ; Water
			notify: 0 wave 65 180 1 113 189 2 36 164 3 67 151 3 188 189 4
		)
		(bikini1Lady init:)
		(paperView init:)
		(User canInput: 1)
		(MenuBar draw:)
		(SL enable:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<around,at][/room,beach,building,building,hotel]')
				(Print 2 0 #time 10) ; "You are on the beach and can see the hotel entrance to the north."
			)
			((Said '[/woman,man]>')
				(cond
					((Said 'talk')
						(Print 2 1) ; "Nobody can hear you."
					)
					((Said 'fuck')
						(Print 2 2) ; "From this far away?"
					)
				)
			)
		)
	)
)

(instance bikini1Lady of Act
	(properties
		view 602
	)

	(method (init)
		(super init:)
		(self
			ignoreActors:
			ignoreControl: -32768
			ignoreHorizon:
			setCycle: Walk
			posn: 325 85
			setScript: bikini1Script
			setStep: 2 1
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((IsOffScreen self))
			((Said '[/brunette,woman[<brunette]]>')
				(cond
					((== (gEgo view:) 2)
						(cond
							((Said 'look[<at]')
								(Print 2 3) ; "There is a brunette behind you walking into the hotel."
							)
							((Said 'talk')
								(Print 2 4) ; "She can't hear you."
							)
							((Said 'fuck')
								(Print 2 5) ; "You'll have to get a lot closer than this."
							)
						)
					)
					((TurnIfSaid self event 'look[<at]'))
					((Said 'look[<at]')
						(Print 2 6) ; "There is a brunette in the distance walking into the hotel."
					)
					((Said 'talk')
						(Print 2 4) ; "She can't hear you."
					)
					((Said 'fuck')
						(Print 2 5) ; "You'll have to get a lot closer than this."
					)
				)
			)
		)
	)
)

(instance bikini1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client posn: 330 84 xStep: 2 setLoop: -1 setPri: 4)
				(= seconds (Random 30 50))
			)
			(1
				(client setMotion: MoveTo 226 84 self)
			)
			(2
				(client setMotion: MoveTo 145 78 self)
			)
			(3
				(client setLoop: 3)
				(hutDoor startUpd: setCycle: End self)
			)
			(4
				(client xStep: 1 setMotion: MoveTo 152 76 self)
			)
			(5
				(client posn: 330 84 setPri: 2)
				(hutDoor setCycle: Beg self)
			)
			(6
				(hutDoor stopUpd:)
				(= seconds (Random 10 30))
			)
			(7
				(self init: client)
			)
		)
	)
)

(instance hutDoor of Prop
	(properties
		view 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 2 7) ; "You see the door to the hotel lobby."
					)
					((Said 'open,close,knock')
						(proc0_34) ; "You're not close enough."
					)
				)
			)
		)
	)
)

(instance lobbyDoor of RFeature
	(properties
		y 65
		x 136
		nsTop 52
		nsLeft 130
		nsBottom 79
		nsRight 142
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door]>')
				(cond
					((TurnIfSaid self event 'look/*'))
					((Said 'look[<at]')
						(Print 2 7) ; "You see the door to the hotel lobby."
					)
					((Said 'open,close,knock')
						(proc0_34) ; "You're not close enough."
					)
				)
			)
		)
	)
)

(instance chairPic of RPicView
	(properties
		y 150
		x 233
		view 2
		loop 1
	)

	(method (handleEvent event)
		(cond
			((Said '(get<up),(stand[<up])')
				(if (localproc_1)
					(if (!= (gEgo script:) standScript)
						(gEgo setScript: standScript)
					)
				else
					(Print 2 8) ; "You're already standing."
				)
			)
			((Said '[/chair]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]>')
						(cond
							((== (gEgo view:) 2)
								(if (Said '/*')
									(Print 2 9) ; "You're sitting in it."
								)
							)
							((== (gEgo view:) 206)
								(Print 2 10) ; "You see a beach chair facing the water."
								(event claimed: 1)
							)
							(else
								(Print 2 11) ; "Draped across the back of the chair is your shirt."
								(event claimed: 1)
							)
						)
					)
					((Said 'sit>')
						(cond
							((localproc_1)
								(Print 2 12) ; "You're already sitting."
							)
							((GoToIfSaid self event (- x 6) (+ y 2) 'sit' 2 13))
							(else
								(gEgo setScript: sitScript)
							)
						)
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance paperView of View
	(properties
		y 153
		x 246
		z 12
		view 2
		loop 1
		cel 5
		priority 11
		signal 16401
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/table,magazine,news,newspaper]>')
				(cond
					((Said 'read,get,(pick<up)/magazine,news,newspaper')
						(gEgo setScript: readPaperS)
					)
					((TurnIfSaid self event 'look[<at,on]/*'))
					((Said 'look[<at,on]')
						(Print 2 14) ; "On the table you see a news magazine."
					)
				)
			)
		)
	)
)

(instance wave of SoundSyncWave
	(properties
		y 174
		x 35
		view 502
		cycleSpeed 2
	)

	(method (handleEvent)
		(if (Said 'look[<at][/wave]')
			(Print 2 15) ; "These are gentle waves."
		)
	)
)

(instance noSinkyDinghy of RPicView
	(properties
		y 139
		x 4
		view 402
		priority 9
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/boat,dinghy]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 2 16) ; "This is your transportation off the Island."
					)
					((Said 'board,(get<on)')
						(Print 2 17) ; "Just walk aboard."
					)
				)
			)
		)
	)
)

(instance dinghyPost of PV
	(properties
		y 142
		x 25
		view 402
		cel 2
		priority 11
		signal 16384
	)
)

(instance dinghyRamp of View
	(properties
		y 153
		x 80
		view 402
		cel 1
	)

	(method (init)
		(super init:)
		(self ignoreActors: setPri: 9)
		(&= signal $feff)
	)

	(method (doit)
		(super doit:)
		(if (== (gEgo onControl: 1) 256)
			(HandsOff)
			(gEgo
				view:
					(if (OneOf (gEgo view:) 214 215)
						200
					else
						(gEgo view:)
					)
				viewer: 0
				setScript: finallyOffThisStupidIsland
			)
			(|= signal $0100)
		)
	)
)

(instance dinghyMan of RFeature
	(properties
		y 114
		x 41
		nsTop 94
		nsLeft 34
		nsBottom 135
		nsRight 48
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/man,captain]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 2 18) ; "The captain of your boat."
					)
					((Said 'talk')
						(Print 2 19) ; "We really oughta shove off, bub."
					)
				)
			)
		)
	)
)

(instance finallyOffThisStupidIsland of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tahiti setScript: 0)
				(Print 2 20) ; "Next stop: Tahiti airport."
				(gEgo
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 62 142 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 2 142 self)
			)
			(2
				(gCurRoom newRoom: 1) ; openingScene
			)
		)
	)
)

(instance shirt of View
	(properties
		view 2
		loop 1
		cel 3
	)

	(method (init)
		(self ignoreActors: 1 posn: 217 150 10 setPri: 11)
		(super init:)
		(if (and (!= (gEgo view:) 206) (== gCurRoomNum 2)) ; thatchedHut
			(self show:)
		else
			(self signal: (& signal $feff) hide:)
		)
	)

	(method (show)
		(if (== gCurRoomNum 2) ; thatchedHut
			(super show:)
		)
	)

	(method (handleEvent event)
		(if (Said '[/shirt][/!*]>')
			(cond
				((== (gEgo view:) 206)
					(cond
						((Said 'look[<at]')
							(Print 2 21) ; "It's a nice floral aloha shirt."
						)
						((Said '(get<!*),(wear[<!*]),(adjust<on)')
							(Print 2 22) ; "You're already wearing your shirt."
						)
						((TurnIfSaid self event 'look[<at]/*'))
						(
							(GoToIfSaid
								self
								event
								(- x 5)
								(- y 5)
								'(detach[<!*]),(get<off)'
								2
								13
							))
						((Said '(detach[<!*]),(get<off)')
							(gEgo setScript: removeShirtScript)
						)
					)
				)
				((Said '(detach[<!*]),(get<off)')
					(Print 2 23) ; "You're not wearing it."
				)
				((TurnIfSaid self event 'look[<at]/*'))
				((Said 'look[<at]')
					(Print 2 21) ; "It's a nice floral aloha shirt."
				)
				((GoToIfSaid self event (- x 5) (- y 5) '/*' 2 13))
				((Said '(get[<!*]),(wear[<!*]),(adjust<on)')
					(gEgo setScript: wearShirtScript)
				)
			)
		)
	)
)

(instance relaxScript of Script
	(properties)

	(method (cue param1)
		(cond
			((& register $0001)
				(|= register $0002)
			)
			((& register $0004)
				(if (and argc param1)
					(&= register $fffb)
					(super cue:)
				)
			)
			(else
				(super cue:)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if
			(and
				(= temp0
					(cond
						((not (IsOffScreen local0)) local0)
						((not (IsOffScreen local1)) local1)
					)
				)
				(<
					90
					(= temp1
						(GetAngle (client x:) (client y:) (temp0 x:) (temp0 y:))
					)
					285
				)
			)
			(|= register $0001)
			(if (not script)
				(localproc_0 temp0 temp1)
			)
		else
			(if (& register $0002)
				(&= register $0000)
				(self cue:)
			)
			(&= register $fffc)
			(super doit:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 5 10))
				(client cycleSpeed: 2)
			)
			(1
				(client loop: 3 cel: 0 setCycle: End self)
			)
			(2
				(= seconds (Random 5 8))
			)
			(3
				(client setCycle: Beg self)
			)
			(4
				(= seconds (Random 3 8))
			)
			(5
				(self init: client)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'get,wear,(adjust<on)/shirt')
				(gEgo setScript: wearShirtScript)
			)
		)
	)
)

(instance sitScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (gEgo view:) 206)
					(self setScript: removeShirtScript self)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOff)
				(gEgo
					setAvoider: Avoid
					setMotion:
						MoveTo
						(- (chairPic x:) 6)
						(+ (chairPic y:) 2)
						self
				)
			)
			(2
				(gEgo
					setAvoider: 0
					view: 2
					setLoop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(HandsOn)
				(User canControl: 0)
				(gEgo posn: 227 152 heading: 180 setLoop: 3)
				(if (!= client readPaperS)
					(gEgo setScript: relaxScript)
				)
				(self dispose:)
			)
		)
	)
)

(instance standScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setCycle: Beg self)
			)
			(1
				(gEgo
					view: 2
					setLoop: 2
					posn: 227 152
					setCel: 16
					cycleSpeed: 1
					setCycle: Beg self
				)
			)
			(2
				(gEgo view: 200 setLoop: -1 setCycle: Walk cycleSpeed: 0)
				(if (not caller)
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(instance removeShirtScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid setMotion: MoveTo 212 145 self)
			)
			(1
				(gEgo
					view: 208
					setLoop: 0
					cel: (gEgo lastCel:)
					setCycle: Beg self
				)
			)
			(2
				(shirt posn: 217 150 10 show:)
				(gEgo view: 200 setCycle: Walk setAvoider: 0 setLoop: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance wearShirtScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (localproc_1)
					(self setScript: standScript self)
				else
					(HandsOff)
					(= cycles 1)
				)
			)
			(1
				(gEgo view: 208 setLoop: 0 setCel: 0 setCycle: End self)
				(shirt hide:)
			)
			(2
				(HandsOn)
				(gEgo view: 206 setCycle: Walk setLoop: -1)
				(self dispose:)
			)
		)
	)
)

(instance readPaperS of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (localproc_1))
					(self setScript: sitScript self)
				else
					(= cycles 1)
				)
			)
			(1
				(HandsOff)
				(gEgo loop: 3 setCycle: CT 2 1 self)
			)
			(2
				(gEgo setCycle: End self)
				(paperView hide:)
			)
			(3
				(gEgo loop: 4 setCycle: End self)
			)
			(4
				(Print 2 24) ; "You read an article featuring the North African country of Tunisia. Because of the global oil shortage, this small third world country finds itself in a powerful political position."
				(Print 2 25) ; "Because of Tunisia's neutral stance, and her overabundance of high grade crude, the United States and Russia find themselves in a tug of war as they negotiate for the oil."
				(Print 2 26) ; "After reading the article you begin to think, "Hmm, what a dangerous, explosive situation this could be.""
				(SetScore tahiti 413 1 1)
				(= seconds 2)
			)
			(5
				(gEgo loop: 4 setCycle: CT 2 -1 self)
			)
			(6
				(gEgo setCycle: Beg self)
				(paperView show:)
			)
			(7
				(gEgo loop: 3 setScript: relaxScript)
				(HandsOn)
				(User canControl: 0)
				(self dispose:)
			)
		)
	)
)

