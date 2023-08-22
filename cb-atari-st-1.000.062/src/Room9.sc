;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 9)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room9 0
)

(synonyms
	(gravestone crypt)
	(room room chapel)
)

(local
	local0
	local1
	local2
)

(instance Room9 of Rm
	(properties
		picture 9
	)

	(method (init)
		(= south 13)
		(= east 3)
		(= horizon 86)
		(super init:)
		(LoadMany rsSOUND 43 44)
		(Thunder number: 17 loop: 0)
		(if (== gAct 1)
			(self setRegions: 381) ; walkabout
		)
		(if gDetailLevel
			(light1 init: setScript: showers)
		)
		(Door ignoreActors: 1 stopUpd: init:)
		(gEgo view: 0 illegalBits: -32766)
		(self setFeatures: Window1 Window2)
		(if (and (>= gAct 2) (< gAct 4))
			(self setRegions: 202) ; EthelDrunk
		)
		(if
			(or
				(and (== gAct 3) (!= global114 10))
				(and (== gAct 6) (not (& gMustDos $0002)))
			)
			(self setRegions: 281) ; rudywand
		)
		(= local0 0)
		(switch gPrevRoomNum
			(14
				(gEgo posn: 285 188)
			)
			(2
				(gEgo posn: 58 114)
			)
			(13
				(gEgo posn: 68 185)
			)
			(58
				(if (== global133 1)
					(Door cel: 0)
					(gEgo posn: 109 122)
				else
					(Door cel: (- (NumCels Door) 1))
					(HandsOff)
					(gEgo loop: 2 illegalBits: -32768 posn: 237 132)
					(self setScript: exitDoor)
				)
			)
		)
		(gEgo init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 9 0) ; "At this end of the island there is a small, quaint chapel. Behind it, you see an old family cemetery."
		)
		(super doit:)
		(switch (gEgo onControl: 1)
			(64
				(if (or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
					(= local2 1)
					(User canControl: 0)
					(gEgo
						illegalBits: 0
						setLoop: 1
						setMotion: MoveTo 268 133
					)
				)
			)
			(128
				(if (or (== (gEgo loop:) 0) (== (gEgo loop:) 2))
					(= local2 1)
					(User canControl: 0)
					(gEgo
						setLoop: 0
						illegalBits: 0
						setMotion: MoveTo 294 158
					)
				)
			)
			(1
				(if (== local2 1)
					(= local2 0)
					(User canControl: 1)
					(gEgo illegalBits: -32768 setLoop: -1)
				)
			)
			(8
				(gCurRoom newRoom: 2)
			)
			(4
				(= global133 1)
				(gCurRoom newRoom: 58)
			)
			(2
				(HandsOn)
				(= global133 0)
				(self setScript: 0)
				(gCurRoom newRoom: 58)
			)
			(16
				(if
					(and
						(or (== (gEgo loop:) 3) (== (gEgo loop:) 1))
						(not local1)
					)
					(HandsOff)
					(= local1 1)
					(self setScript: chapelDoor)
				)
			)
		)
		(if (== (gEgo edgeHit:) EDGE_BOTTOM)
			(if (< (gEgo x:) 275)
				(gCurRoom newRoom: 13)
			else
				(gCurRoom newRoom: 14)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (or (== newRoomNumber 58) (== newRoomNumber 2))
			(gConMusic stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 9 0) ; "At this end of the island there is a small, quaint chapel. Behind it, you see an old family cemetery."
						)
						((Said '/cemetery')
							(Print 9 1) ; "An old cemetery hides behind the small church."
						)
						((Said '/fence')
							(Print 9 2) ; "A rusted, wrought iron fence surrounds the cemetery, while another fence sections off the old sugar cane fields."
						)
						((Said '/archway')
							(Print 9 3) ; "There is a rusted gate leading into the cemetery."
						)
						((Said '/field[<sugar,cane]')
							(Print 9 4) ; "Behind a weather-beaten fence, you see the old, unused sugar cane fields. The fields look as if they haven't been planted in years."
						)
						((Said '/path')
							(Print 9 5) ; "A path leads to the chapel. Behind it, another goes into the cemetery."
						)
						((Said '/stair')
							(Print 9 6) ; "Wide steps lead up to the door of the chapel."
						)
						((Said '/gallery')
							(Print 9 7) ; "There is a small porch on the front of the chapel."
						)
						((Said '/cross')
							(Print 9 8) ; "An old cross tops the chapel."
						)
						((Said '/grave,gravestone,epitaph')
							(Print 9 9) ; "The graves are in the cemetery."
						)
						((Said '<behind/blind')
							(Print 9 10) ; "There is only the wall of the chapel behind the shutters."
						)
					)
				)
				((Said 'get/cross')
					(Print 9 11) ; "You couldn't reach it."
				)
				((Said 'read/gravestone,epitaph')
					(Print 9 9) ; "The graves are in the cemetery."
				)
				((Said 'bang[/door]')
					(Print 9 12) ; "There's no need to knock. Just go into the chapel!"
				)
				((Said 'find/archway')
					(Print 9 3) ; "There is a rusted gate leading into the cemetery."
				)
				((Said 'climb,hop/fence')
					(Print 9 13) ; "The fences are too difficult to climb."
				)
				((Said 'open>')
					(cond
						((Said '/archway')
							(AlreadyOpen) ; "It is already open."
						)
						((Said '/door')
							(Print 9 14) ; "Just do that yourself."
						)
					)
				)
				((Said 'close>')
					(cond
						((Said '/archway')
							(Print 9 15) ; "The gate seems to be stuck in place."
						)
						((Said '/door,window')
							(AlreadyClosed) ; "It is already closed."
						)
					)
				)
			)
		)
	)
)

(instance chapelDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 240 128 self)
			)
			(2
				(gEgo loop: 1)
				(gConMusic stop:)
				(Door startUpd: ignoreActors: 1 setCycle: End self)
				(mySound number: 43 loop: 1 priority: 5 play:)
			)
			(3
				(gEgo setMotion: MoveTo 225 128)
			)
		)
	)
)

(instance exitDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mySound number: 44 loop: 1 priority: 5 play:)
				(Door setCycle: Beg self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance showers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (= state 3))
			)
			(1
				(light1 setCycle: Fwd)
				(= cycles 7)
			)
			(2
				(light1 setCycle: End self)
				(Thunder loop: 1 play:)
			)
			(3
				(if (< (Random 1 100) 20)
					(= state 0)
				)
				(= cycles 7)
			)
			(4
				(= state 2)
				(= seconds 5)
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 130
		x 222
		view 109
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(event claimed: 1)
			(if (gEgo inRect: 0 0 120 140)
				(Print 9 16) ; "You notice a door at the back of the chapel."
			else
				(Print 9 17) ; "Simple French doors front the chapel."
			)
		)
	)
)

(instance light1 of Prop
	(properties
		y 26
		x 64
		view 109
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(event claimed: 1)
			(Print 9 17) ; "Simple French doors front the chapel."
		)
	)
)

(instance Thunder of Sound
	(properties)
)

(instance mySound of Sound
	(properties)
)

(instance Window1 of RFeature
	(properties
		nsTop 63
		nsLeft 119
		nsBottom 107
		nsRight 135
	)

	(method (handleEvent event)
		(cond
			((Said 'look<(in,in,in,through)/window,room')
				(if (& (gEgo onControl: 1) $0020)
					(Print 9 18) ; "You peek through the window, but can't make out any details."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((or (MousedOn self event 3) (Said 'look/window'))
				(event claimed: 1)
				(Print 9 19) ; "Windows surround the small church."
			)
			((Said 'open/window')
				(Print 9 20) ; "The windows do not open."
			)
			((Said 'break/window')
				(Print 9 21) ; "There is no need for that. Just use the door."
			)
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 61
		nsLeft 160
		nsBottom 108
		nsRight 193
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/window'))
			(event claimed: 1)
			(Print 9 19) ; "Windows surround the small church."
		)
	)
)

