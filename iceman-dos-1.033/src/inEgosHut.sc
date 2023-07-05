;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6)
(include sci.sh)
(use Main)
(use Interface)
(use tahiti)
(use n316)
(use n824)
(use n954)
(use LoadMany)
(use RFeature)
(use Sight)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	inEgosHut 0
)

(local
	[local0 20]
)

(procedure (localproc_0)
	(if (and (closetProp cel:) (not (CantBeSeen closetView gEgo 270 50)))
		(closetView show:)
		(return 1)
	else
		(closetView hide:)
		(return 0)
	)
)

(instance inEgosHut of Rm
	(properties
		picture 6
		north 8
		south 5
		vanishingX 170
		vanishingY -20
	)

	(method (init)
		(super init:)
		(gAddToPics add: fishPic floorPic eachElementDo: #init doit:)
		(LoadMany rsVIEW 200 206 106 6)
		(Load rsSOUND 42)
		(Load rsSOUND 36)
		(drawerView init:)
		(closetView init:)
		(phone init:)
		(drawerProp init:)
		(closetProp init:)
		(gEgo init:)
		(switch gPrevRoomNum
			(8 ; HutSwimRm
				(gEgo setScript: walkUpLadderScript)
			)
			(else
				(if (> (gEgo y:) 170)
					(gEgo posn: 77 68 loop: 0)
				else
					(gEgo posn: (hutDoor x:) (- (hutDoor y:) 9) loop: 3)
				)
			)
		)
		(self
			setRegions: 300 ; tahiti
			setFeatures:
				hutDoor
				fishPic
				floorPic
				flowersOnTable
				bedFeature
				backCouchF
				leftCouch
				((Clone bedFeature)
					x: 36
					y: 128
					nsTop: 114
					nsBottom: 142
					nsLeft: 28
					nsRight: 44
					yourself:
				)
				((Clone leftCouch)
					x: 215
					y: 98
					nsLeft: 219
					nsTop: 82
					nsRight: 244
					nsBottom: 114
					heading: 270
					name: {rightCouch} species
				)
				lampFeature
				windowFeature
				rugFeature
				floorFeature
				((Clone floorFeature) x: 105 y: 209 yourself:)
				((Clone windowFeature)
					x: 220
					y: 40
					nsTop: 15
					nsBottom: 68
					nsLeft: 180
					nsRight: 260
					yourself:
				)
				oceanFeat
				((Clone rugFeature)
					x: 160
					y: 95
					nsTop: 80
					nsBottom: 110
					nsLeft: 136
					nsRight: 186
					yourself:
				)
		)
		(proc824_0)
		(proc316_0 gCurRoomNum 3 2 4)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 1) $4020)
			(self newRoom: 5) ; beachHuts2
		)
	)

	(method (dispose)
		(HandsOn)
		(super dispose:)
	)

	(method (cue)
		(super cue:)
		(self newRoom: 8) ; HutSwimRm
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look>')
				(if (Said '[<around][/room][/building]')
					(Print 6 0) ; "This is your hut."
				)
			)
			((Said 'rest')
				(Print 6 1) ; "Although it's a relaxing thought, you really don't have the time for slumber."
			)
			((Said 'jump,swim,dive,enter,(go<in)[/water]')
				(cond
					((== (gEgo view:) 206)
						(Print 6 2) ; "You wouldn't want to get your shirt wet."
					)
					((== (gEgo onControl: 1) 16)
						(gEgo setScript: fallInWaterScript)
					)
					(else
						(Print 6 3) ; "At least stand outside first."
					)
				)
			)
			((Said 'read/book')
				(if (gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
					(Print 6 4 #icon 300 1 0) ; "An address book."
				else
					(event claimed: 0)
				)
			)
			((Said 'turn<on,off/light')
				(proc0_39) ; "You don't need to do that."
			)
		)
	)
)

(instance fallInWaterScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid setMotion: MoveTo 158 67 self)
			)
			(1
				(gEgo heading: 0)
				((gEgo looper:) doit: gEgo 0)
				(= cycles 5)
			)
			(2
				((gEgo looper:) dispose:)
				(gEgo
					setPri: 0
					yStep: 10
					illegalBits: 0
					looper: 0
					setLoop:
					setMotion: MoveTo (gEgo x:) 107 self
				)
			)
			(3
				(HandsOn)
				(gEgo yStep: 2 setPri: -1 setLoop: -1 observeControl: -32768)
				(gCurRoom newRoom: 8) ; HutSwimRm
			)
		)
	)
)

(instance walkUpLadderScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 200
					setLoop: 2
					posn: 158 107
					setPri: 0
					moveSpeed: 1
					setMotion: MoveTo 158 67 self
				)
			)
			(1
				(HandsOn)
				(gEgo heading: 180 setPri: -1 moveSpeed: 0 setLoop: -1)
			)
		)
	)
)

(instance hutDoor of Feature
	(properties
		y 175
		x 122
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/door[<building]][/building]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 5) ; "That door leads to the beach."
					)
					((Said 'knock')
						(Print 6 6) ; "Now why would you do that?"
					)
					((GoToIfSaid self event x (- y 5) 0 6 7))
					((Said 'open')
						(HandsOff)
						(gCurRoom setScript: egoOpenDoorScript)
					)
				)
			)
		)
	)
)

(instance phone of Prop
	(properties
		y 155
		x 29
		z 7
		view 106
		loop 1
		priority 11
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/call,braxton]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 8) ; "This is your phone."
					)
					(
						(or
							(Said '(get[<!*]),call,dial,(pick<up)')
							(Said 'call<use')
							(Said 'make/call<call')
						)
						(cond
							((== (gEgo onControl: 1) 16)
								(Print 6 9) ; "At least walk inside first."
							)
							((User controls:)
								(HandsOff)
								(gEgo
									setAvoider: Avoid
									setMotion: MoveTo (+ 25 x) (+ 7 y) self
								)
							)
							(else
								(Print 6 7) ; "You can't do that here and now."
							)
						)
					)
				)
			)
		)
	)

	(method (cue)
		(gEgo setScript: phoneScript)
	)
)

(instance phoneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client
					view: 106
					loop: (if (== (gEgo view:) 200) 0 else 4)
					setCycle: End self
				)
				(phone cel: 1 forceUpd:)
			)
			(1
				(Print 6 10 #edit @local0 18) ; "Number to dial: (ESC to hang up) (x-xxx-xxx-xxxx)"
				(= seconds 3)
			)
			(2
				(cond
					((not (StrCmp @local0 {}))
						(self cue:)
					)
					((not (StrCmp @local0 {1-202-555-2729}))
						(if
							(and
								(& (tahiti flags:) $0100)
								(not (& (tahiti flags:) $0080))
							)
							(Print 6 11 #time 10) ; "After a few rings, someone on the other end answers."
							(Print 6 12) ; "The voice bellows, "General Braxton here, what can I do for you?""
							(User canInput: 1)
							(= register 0)
							(= seconds 10)
						else
							(Print 6 13 #time 10) ; "Braxton's not at home."
							(gEgo setScript: putDownPhoneScript)
						)
					)
					((not (StrCmp @local0 {555-8000}))
						(if
							(and
								(& (tahiti flags:) $0100)
								(& (tahiti flags:) $0080)
								(not (& (tahiti flags:) $0200))
							)
							(Print 6 14) ; "The voice on the other end intones, "No Sinkhy Dinghy Transport, can I help you?""
							(User canInput: 1)
							(= register 1)
							(= seconds 10)
						else
							(Print 6 15) ; "A recorded message informs you that nobody is in the office."
							(gEgo setScript: putDownPhoneScript)
						)
					)
					(else
						(Print 6 16 #time 10) ; "There is no answer."
						(gEgo setScript: putDownPhoneScript)
					)
				)
			)
			(3
				(Print 6 17) ; "Click."
				(gEgo setScript: putDownPhoneScript)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(register
				(if
					(or
						(Said 'talk[/man,clerk]')
						(Said '//boat,transport<for,about')
						(Said '/hello')
						(Said
							'/lieutenant,commander,john,westland,(westland<john)'
						)
						(Said '/boat,transport,dinghy')
						(Said 'boat,transport,dinghy/')
					)
					(Print 6 18) ; "You advise the person of your location and that you need transportation to the airport."
					(Print 6 19) ; "You're told to meet the dinghy in front of the hotel entrance."
					(tahiti setScript: (ScriptID 300 1)) ; tookTooLongScript
					(tahiti flags: (| (tahiti flags:) $0200))
					(gGame changeScore: 2)
				else
					(Print 6 20) ; "You're not making sense."
					(event claimed: 1)
				)
				(Print 6 17) ; "Click."
				(gEgo setScript: putDownPhoneScript)
			)
			(else
				(if
					(or
						(Said 'talk[/man,general,braxton]')
						(Said '//message<for,about')
						(Said '/hello')
						(Said
							'/lieutenant,commander,john,westland,(westland<john)'
						)
					)
					(Print 6 21) ; "You identify yourself to the General and tell him that you received his message."
					(if ((tahiti script:) state:)
						(Print 6 22) ; "Angrily, Braxton says, "Where on earth have you been, Johnny?""
						(Print 6 23) ; "We've got an explosive situation on our hands and you've been playing around on that island!"
					else
						(Print 6 24) ; "After the mutual "hellos" and "how-have-you-been" greetings, the General says:"
						(Print 6 25) ; "Sorry to cut your leave short, but we're in the middle of an expolsive situation."
						(gGame changeScore: 2)
					)
					(Print 6 26) ; "He continues, "Due to the sensitive nature of what we are dealing with, I can't give any details over the phone.""
					(Print 6 27) ; "I need you here in Washington as soon as possible! Report to the maximum security briefing room."
					(Print 6 28) ; "After acknowledging your orders to Washington, you say goodbye and hang up the phone."
					(tahiti flags: (| (tahiti flags:) $0080))
				else
					(Print 6 20) ; "You're not making sense."
					(event claimed: 1)
				)
				(Print 6 17) ; "Click."
				(gEgo setScript: putDownPhoneScript)
			)
		)
	)
)

(instance putDownPhoneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Beg self)
				(phone cel: 0 forceUpd:)
			)
			(1
				(gEgo
					view: (if (== (gEgo loop:) 0) 200 else 206)
					loop: 1
					setLoop: -1
					setCycle: Walk
					setScript: 0
				)
				(HandsOn)
			)
		)
	)
)

(instance drawerProp of Prop
	(properties
		y 168
		x 33
		z 7
		view 6
	)

	(method (init)
		(super init:)
		(if (& (tahiti flags:) $0020)
			(= cel (self lastCel:))
		)
		(self setPri: 12 stopUpd: ignoreActors: 1)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/dresser,drawer,dresser,lamp,light,flower]>')
				(cond
					((and (== (gEgo onControl: 1) 16) (Said '/*'))
						(Print 6 9) ; "At least walk inside first."
					)
					((TurnIfSaid self event 'look[<at,in,on]/*'))
					(
						(or
							(Said 'look[<on]/dresser,drawer,dresser')
							(Said 'look/lamp,light,flower')
						)
						(Print 6 29) ; "On the nightstand is a phone, a lamp, and some flowers."
					)
					((Said 'look[<at,in]')
						(if (not cel)
							(Print 6 30) ; "This is your nightstand, which has one drawer."
						else
							(drawerView show:)
							(cond
								((CantBeSeen self gEgo 180 50)
									(Print 6 31) ; "The drawer is open, but you can't see what's in it from here."
								)
								(
									(and
										(proc316_1 gCurRoomNum 2)
										(proc316_1 gCurRoomNum 4)
									)
									(Print 6 32) ; "You see your ID card and some change."
								)
								((proc316_1 gCurRoomNum 2)
									(Print 6 33) ; "You see your ID card."
								)
								((proc316_1 gCurRoomNum 4)
									(Print 6 34) ; "You see your change."
								)
								(else
									(Print 6 35) ; "You see an empty drawer."
								)
							)
						)
					)
					((GoToIfSaid self event self 20 'open,close,examine' 6 7))
					((Said 'open')
						(drawerView show:)
						(if cel
							(Print 6 36) ; "It's already open."
						else
							(tahiti flags: (| (tahiti flags:) $0020))
							(self setCycle: End self)
						)
					)
					((Said 'close')
						(if (not cel)
							(Print 6 37) ; "It's already closed."
						else
							(proc0_30)
							(drawerView hide:)
							(tahiti flags: (& (tahiti flags:) $ffdf))
							(self setCycle: Beg self)
						)
					)
					((Said 'examine')
						(Print 6 38) ; "It's made of wood and has one drawer."
					)
				)
			)
			((Said 'adjust,return,drop[/id,(card[<id]),change,money]>')
				(cond
					((TurnIfSaid self event 'adjust,return,drop/*'))
					((GoToIfSaid self event (+ 20 x) y 0 6 7))
					((not cel)
						(Print 6 39) ; "You must first open the drawer."
						(event claimed: 1)
						(return)
					)
					((Said '/change,money')
						(if (gEgo has: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
							(if (not (& (drawerView signal:) $0080))
								(Change show:)
							)
							(Print 6 40) ; "You return the change to the drawer."
							(gEgo put: 4 gCurRoomNum) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
						else
							(proc0_38) ; "You don't have that."
						)
					)
					((gEgo has: 2) ; ID_Card
						(event claimed: 1)
						(if (not (& (drawerView signal:) $0080))
							(Wallet show:)
						)
						(Print 6 41) ; "You return the ID card to the drawer."
						(gEgo put: 2 gCurRoomNum) ; ID_Card
					)
					(else
						(proc0_38) ; "You don't have that."
					)
				)
			)
		)
	)

	(method (cue)
		(if cel
			(drawerView show:)
		)
		(self stopUpd:)
	)
)

(instance drawerView of View
	(properties
		y 155
		x 35
		z 110
		view 6
		loop 1
	)

	(method (init)
		(super init:)
		(Change init:)
		(Wallet init:)
		(self setPri: 14 hide:)
	)

	(method (show)
		(super show:)
		(&= signal $feff)
		(if (proc316_1 gCurRoomNum 4)
			(Change show:)
		)
		(if (proc316_1 gCurRoomNum 2)
			(Wallet show:)
		)
	)

	(method (hide)
		(super hide:)
		(|= signal $0100)
		(Wallet hide:)
		(Change hide:)
	)

	(method (doit)
		(super doit:)
		(if (CantBeSeen self gEgo 180 50)
			(self hide:)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(and
					(MousedOn self event)
					(not (or (proc316_1 gCurRoomNum 4) (proc316_1 gCurRoomNum 2)))
				)
				(Print 6 42) ; "The drawer is empty."
				(event claimed: 1)
			)
		)
	)
)

(instance closetProp of Prop
	(properties
		y 161
		x 293
		view 6
		loop 7
		priority 11
		signal 16401
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/closet,(door<closet)]>')
				(cond
					((TurnIfSaid self event 'look[<at,in]/*'))
					((Said 'look[<at,in]')
						(if (localproc_0)
							(Print 6 43) ; "You see your clothes in the closet."
						else
							(Print 6 44) ; "This is where you keep your clothes."
						)
					)
					((GoToIfSaid self event self 10 0 6 7))
					((Said 'open')
						(if (localproc_0)
							(Print 6 36) ; "It's already open."
						else
							(self setCycle: End self)
						)
					)
					((Said 'close')
						(if cel
							(self setCycle: Beg self)
							(closetView hide:)
						else
							(Print 6 37) ; "It's already closed."
						)
					)
				)
			)
			((Said 'look[<at]/coat,coat,coat,clothes,pants')
				(if (not (localproc_0))
					(Print 6 45) ; "You can't see the inside of the closet too well from this distance."
				else
					(event claimed: 0)
				)
			)
		)
	)

	(method (cue)
		(localproc_0)
		(self stopUpd:)
	)
)

(instance closetView of View
	(properties
		y 155
		x 313
		z 80
		view 6
		loop 6
		cel 1
		priority 15
		signal 16400
	)

	(method (init)
		(super init:)
		(self hide:)
	)

	(method (show)
		(super show:)
		(&= signal $feff)
	)

	(method (hide)
		(super hide:)
		(|= signal $0100)
	)

	(method (doit)
		(super doit:)
		(localproc_0)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((& signal $0008))
			(
				(or
					(Said '(get[<!*]),wear,(adjust<on)/coat,clothes,uniform')
					(Said 'change/clothes')
					(Said 'dress')
				)
				(Print 6 46) ; "It's much too hot here for a suit."
			)
			((Said 'pack/bag,coat,clothes,uniform,briefcase')
				(proc0_39) ; "You don't need to do that."
			)
			((Said 'examine,look[<at,in]>')
				(cond
					((Said '/coat,coat,coat,clothes')
						(Print 6 47) ; "It's a nice dark suit with 2 front pockets."
					)
					((Said '/pocket[/coat,coat]')
						(if (proc316_1 gCurRoomNum 3)
							(Print 6 48) ; "There is a little black book in the pocket."
						else
							(Print 6 49) ; "The pocket is empty."
						)
					)
					((Said '[/closet]')
						(Print 6 50) ; "Looking in the closet, you see extra clothes."
					)
				)
			)
			((Said '(get[<!*])/book[<call,black,talk]')
				(if (proc316_1 gCurRoomNum 3)
					(proc0_30)
					(gEgo get: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
				else
					(proc0_35) ; "You already took that."
				)
			)
			((Said 'return,drop,adjust/book[<call,black,talk]')
				(if (gEgo has: 3) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
					(proc0_30)
					(gEgo put: 3 gCurRoomNum) ; Tahiti: Black_Book | Sub: Explosive | Tunisia: Fish
				else
					(proc0_38) ; "You don't have that."
				)
			)
		)
	)
)

(instance Wallet of Prop
	(properties
		y 145
		x 25
		z 120
		view 6
		loop 1
		cel 1
	)

	(method (init)
		(super init:)
		(gIceMouseDownHandler addToFront: self)
		(self setPri: 15 posn: 25 145)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/id,card]')
				(if (and (proc316_1 gCurRoomNum 2) (& (tahiti flags:) $0020))
					(Print 6 51) ; "You see your ID card in the drawer."
				else
					(event claimed: 0)
				)
			)
			((or (Said '(get[<!*])/id,card') (MousedOn self event))
				(cond
					((not (& (tahiti flags:) $0020))
						(event claimed: 0)
					)
					((proc316_1 gEgo 2)
						(if (Said '(get[<!*])/id,card')
							(Print 6 52) ; "You already have that."
						else
							(Print 6 53) ; "There's nothing there!"
						)
					)
					((not (User canControl:))
						(Print 6 54) ; "Stand up first."
					)
					((> (gEgo distanceTo: self) 40)
						(gEgo
							setAvoider: Avoid
							setMotion: MoveTo 56 165 self
						)
					)
					((proc316_1 gCurRoomNum 2)
						(self cue:)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue:)
		(proc0_30)
		(gEgo get: 2) ; ID_Card
		(self hide:)
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance Change of Prop
	(properties
		y 145
		x 42
		z 120
		view 6
		loop 1
		cel 2
	)

	(method (init)
		(super init:)
		(gIceMouseDownHandler addToFront: self)
		(self setPri: 15 posn: 42 145)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'look[<at][/change,coin,money]')
				(if (and (proc316_1 gCurRoomNum 4) (& (tahiti flags:) $0020))
					(Print 6 55) ; "You see loose change in the drawer."
				else
					(event claimed: 0)
				)
			)
			((or (Said 'get/change,coin,money') (MousedOn self event))
				(cond
					((not (& (tahiti flags:) $0020))
						(event claimed: 0)
					)
					((proc316_1 gEgo 4)
						(if (Said 'get/change,coin,money')
							(Print 6 52) ; "You already have that."
						else
							(Print 6 53) ; "There's nothing there!"
						)
					)
					((not (User canControl:))
						(Print 6 54) ; "Stand up first."
					)
					((> (gEgo distanceTo: self) 40)
						(gEgo
							setAvoider: Avoid
							setMotion: MoveTo 56 165 self
						)
					)
					((proc316_1 gCurRoomNum 4)
						(self cue:)
					)
				)
			)
		)
	)

	(method (cue)
		(super cue:)
		(self hide: stopUpd:)
		(Print 6 56 #time 10) ; "You pick up the loose change in the drawer."
		(gEgo get: 4) ; Tahiti: Change | Sub: Rum_Bottle | Tunisia: Capsule
	)

	(method (dispose)
		(gIceMouseDownHandler delete: self)
		(super dispose:)
	)
)

(instance fishPic of RPicView
	(properties
		y 120
		x 34
		view 6
		loop 2
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/painting,wall]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 57) ; "You see a picture of fish on the wall."
					)
					((Said 'move/*')
						(proc0_39) ; "You don't need to do that."
					)
				)
			)
		)
	)
)

(instance floorPic of RPicView
	(properties
		y 109
		x 105
		view 6
		loop 4
		cel 1
		priority 6
		signal 16384
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/floor,floor]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at,down,through]')
						(if (not (Random 0 5))
							(Print 6 58) ; "A dolphin!"
						else
							(Print 6 59) ; "Through the glass floor you see the beautiful Tahitian sea life."
						)
					)
				)
			)
		)
	)
)

(instance flowersOnTable of RFeature
	(properties
		y 62
		x 119
		z 10
		heading 180
		nsTop 50
		nsLeft 108
		nsBottom 75
		nsRight 131
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/table,flower]>')
				(cond
					((and (< (gEgo y:) y) (Said '/!*>')))
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 60) ; "A mahogany table with ginger flowers."
					)
					((GoToIfSaid self event x (+ 25 y) 0 6 7))
					((Said 'smell')
						(Print 6 61) ; "The ginger fragrance fills the air."
					)
				)
			)
		)
	)
)

(instance bedFeature of RFeature
	(properties
		y 140
		x 80
		heading 135
		nsTop 116
		nsLeft 44
		nsBottom 155
		nsRight 115
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bed]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 62) ; "Your bed."
					)
					((Said 'look<below')
						(proc0_36) ; "You see nothing special."
					)
					((Said 'smell')
						(gEgo setScript: egoSitScript 0 1)
					)
					((Said 'sit')
						(gEgo setScript: egoSitScript 0 8)
					)
				)
			)
		)
	)
)

(instance leftCouch of RFeature
	(properties
		y 98
		x 100
		heading 90
		nsTop 74
		nsLeft 66
		nsBottom 111
		nsRight 85
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/couch]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 63) ; "A couch."
					)
					((GoToIfSaid self event x y 0 6 7))
					((Said 'sit')
						(gEgo
							setScript: egoSitScript 0 (if (== x 215) 2 else 4)
						)
					)
					((Said 'smell')
						(Print 6 64) ; "Moldy."
					)
					((Said 'feel')
						(Print 6 65) ; "Getting lonely?"
					)
				)
			)
		)
	)
)

(instance backCouchF of RFeature
	(properties
		y 74
		x 213
		heading 180
		nsTop 67
		nsLeft 183
		nsBottom 81
		nsRight 244
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/couch]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 63) ; "A couch."
					)
				)
			)
		)
	)
)

(instance egoSitScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setAvoider: Avoid)
				(switch register
					(2
						(gEgo setMotion: MoveTo 215 98 self)
					)
					(4
						(gEgo setMotion: MoveTo 98 98 self)
					)
					(8
						(gEgo setMotion: MoveTo 129 140 self)
					)
					(1
						(gEgo setMotion: MoveTo 129 140 self)
					)
				)
			)
			(1
				(gEgo setAvoider: 0 illegalBits: 0)
				(switch register
					(2
						(gEgo setMotion: MoveTo 220 98 self)
					)
					(4
						(gEgo setMotion: MoveTo 92 98 self)
					)
					(8
						(gEgo setMotion: MoveTo 123 140 self)
					)
					(1
						(switch (Random 1 3)
							(1
								(Print 6 66) ; "Clean sheets."
							)
							(2
								(Print 6 67) ; "Borax."
							)
							(3
								(Print 6 68) ; "Lemon Fresh."
							)
						)
						(HandsOn)
						(self dispose:)
					)
				)
			)
			(2
				(if (== register 2)
					(= temp0 (if (== (gEgo view:) 200) 3 else 6))
					(gEgo heading: 270)
				else
					(= temp0 (if (== (gEgo view:) 200) 2 else 5))
					(gEgo heading: 90)
				)
				(gEgo view: 106 setLoop: temp0 cel: 0 setCycle: End self)
			)
			(3
				(User canInput: 1)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(gEgo
					view:
						(if (or (== (gEgo loop:) 2) (== (gEgo loop:) 3))
							200
						else
							206
						)
					setCycle: Walk
				)
				(switch register
					(2
						(gEgo setLoop: 1 setMotion: MoveTo 215 98 self)
					)
					(4
						(gEgo setLoop: 0 setMotion: MoveTo 98 98 self)
					)
					(8
						(gEgo setLoop: 0 setMotion: MoveTo 129 140 self)
					)
				)
			)
			(6
				(gEgo setLoop: -1 illegalBits: -32768 setScript: 0)
				(HandsOn)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'sit')
				(Print 6 69) ; "You already are sitting."
			)
			((Said 'stand')
				(self cue:)
			)
		)
	)
)

(instance rugFeature of RFeature
	(properties
		y 140
		x 240
		nsTop 120
		nsLeft 210
		nsBottom 160
		nsRight 270
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/carpet,carpet]>')
				(cond
					((TurnIfSaid self event 'look[<at,below]/*'))
					((Said 'look[<at,below]')
						(Print 6 70) ; "A cheap rug obviously made of synthetic material."
					)
				)
			)
		)
	)
)

(instance windowFeature of RFeature
	(properties
		y 50
		x 100
		nsTop 15
		nsLeft 60
		nsBottom 68
		nsRight 135
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/shutter]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 71) ; "An incredible view of azure sky which compliments the aqua blue of the ocean waves is visible through the window."
					)
				)
			)
		)
	)
)

(instance lampFeature of RFeature
	(properties
		y 150
		x 20
		z 20
		nsTop 115
		nsLeft 10
		nsBottom 140
		nsRight 30
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/lamp]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 72) ; "An ordinary lamp."
					)
				)
			)
		)
	)
)

(instance oceanFeat of RFeature
	(properties
		y 55
		x 160
		nsTop 15
		nsLeft 60
		nsBottom 68
		nsRight 260
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/bay,water]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at]')
						(Print 6 73) ; "The beautiful South Pacific stretches out in front of you."
					)
				)
			)
		)
	)
)

(instance floorFeature of Feature
	(properties
		y 109
		x 200
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said '[/floor,floor]>')
				(cond
					((TurnIfSaid self event 'look[<at]/*'))
					((Said 'look[<at,down]')
						(Print 6 74) ; "The hardwood floor is nice but it could use polishing."
					)
				)
			)
		)
	)
)

(instance egoOpenDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(theSound number: (proc0_5 36) loop: 1 play: self)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: (gCurRoom south:))
			)
		)
	)
)

(instance theSound of Sound
	(properties
		priority 2
	)
)

