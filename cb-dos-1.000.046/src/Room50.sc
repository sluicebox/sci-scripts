;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Path)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room50 0
)

(synonyms
	(armoire closet)
	(door panel)
)

(local
	[local0 12] = [50 0 50 1 50 2 50 3 50 4 50 5]
	local12
	local13
	[local14 5] = [105 100 121 99 -32768]
	[local19 5] = [112 99 91 109 -32768]
	[local24 5] = [156 106 133 99 -32768]
	[local29 5] = [144 100 169 109 -32768]
	local34
	local35
	local36
	local37
)

(procedure (localproc_0 &tmp temp0)
	(if (not local12)
		(= local12 1)
		(DrawPic 62 7)
		(gCast eachElementDo: #hide)
		(myMusic number: 27 loop: -1 play:)
		(if local35
			(= temp0 0)
		else
			(= temp0 4)
		)
		(if (== (gEgo loop:) 3)
			(+= temp0 2)
		)
		(Print [local0 temp0] [local0 (++ temp0)] #at 65 67 #dispose)
		(LookAround seconds: 4)
	)
)

(procedure (localproc_1)
	(if local12
		(myMusic stop:)
		(= local12 0)
		(DrawPic 39 6)
		(gAddToPics doit:)
		(gCast eachElementDo: #show)
		(eyes hide:)
	)
)

(instance rightUpPath of Path
	(properties)

	(method (at param1)
		(return [local24 param1])
	)
)

(instance leftUpPath of Path
	(properties)

	(method (at param1)
		(return [local14 param1])
	)
)

(instance rightDwnPath of Path
	(properties)

	(method (at param1)
		(return [local29 param1])
	)
)

(instance leftDwnPath of Path
	(properties)

	(method (at param1)
		(return [local19 param1])
	)
)

(instance Room50 of Rm
	(properties
		picture 39
	)

	(method (init)
		(if (or (< gPrevRoomNum 40) (and (> gPrevRoomNum 299) (< gPrevRoomNum 320))) ; scene32a
			(= west 33)
			(= north 34)
			(= south 38)
			(= local35 1)
		else
			(= west 43)
			(= north 44)
			(= south 48)
		)
		(super init:)
		(Load rsPIC 62)
		(LoadMany rsSOUND 74 27 75 106 87)
		(if (== south 38)
			(protrait cel: 3)
		else
			(protrait cel: 2)
		)
		(gAddToPics add: protrait bprotrait doit:)
		(self setFeatures: Platform)
		(if (and (== gAct 6) (== (gCurRoom west:) 43))
			(boot setPri: 3 ignoreActors: 1 init:)
			(if (and (& gMustDos $0002) (not (IsFlag 36)))
				(= [local0 6] [local0 10])
				(= [local0 7] [local0 11])
			)
		)
		(if
			(and
				(>= gAct 2)
				(not (gEgo has: 21)) ; cane
				(== gCaneLocation 0)
				(< gPrevRoomNum 49)
			)
			(= gCaneLocation (+ (Random 49 50) (gCurRoom west:)))
		)
		(if
			(and
				(>= gAct 2)
				(not (gEgo has: 21)) ; cane
				(== gCaneLocation 0)
				(< gPrevRoomNum 49)
			)
			(= gCaneLocation (+ (Random 49 50) (gCurRoom west:)))
		)
		(if
			(and
				(not (gEgo has: 21)) ; cane
				(== gCurRoomNum (- gCaneLocation (gCurRoom west:)))
			)
			(cane init:)
		)
		(if
			(and
				(>= gAct 3)
				(not (gEgo has: 8)) ; cigar_butt
				(== gCigarButtLocation 0)
				(< gPrevRoomNum 49)
				(== (= gCigarButtLocation (+ (Random 49 50) (gCurRoom west:))) gCaneLocation)
			)
			(if (> gCaneLocation 85)
				(-= gCigarButtLocation 10)
			else
				(+= gCigarButtLocation 10)
			)
		)
		(if
			(and
				(not (gEgo has: 8)) ; cigar_butt
				(== gCurRoomNum (- gCigarButtLocation (gCurRoom west:)))
			)
			(cigar ignoreActors: 1 init:)
		)
		(fpanel
			setLoop: 5
			setCel: 0
			illegalBits: 0
			ignoreActors: 1
			priority: 7
			init:
			stopUpd:
		)
		(bpanel setLoop: 3 setCel: 0 illegalBits: 0 setPri: 4 init: stopUpd:)
		(eyes setPri: 10 init:)
		(eyes hide:)
		(self setRegions: 212) ; passReg
		(switch gPrevRoomNum
			(33
				(gEgo posn: 16 110)
			)
			(43
				(gEgo posn: 16 110)
			)
			(38
				(gEgo posn: 193 115)
			)
			(48
				(gEgo posn: 193 115)
			)
		)
		(if (or (== gPrevRoomNum 34) (== gPrevRoomNum 44))
			(gEgo
				loop: 2
				illegalBits: 0
				posn: 68 102
				setPri: 3
				setScript: Entering
				init:
			)
		else
			(gEgo view: 0 setPri: 6 illegalBits: -32768 init:)
		)
	)

	(method (doit)
		(if
			(and
				(gEgo inRect: 190 111 197 114)
				(not script)
				(< gAct 7)
				(> gAct 0)
				(!= gAct 5)
				(< (Random 1 100) 35)
			)
			(self setScript: grabbed)
		)
		(if (and (== gPrevRoomNum 43) (== global144 0))
			(= global144 1)
			(mySound number: 106 loop: 1 play:)
			(Print 50 6) ; "You have found a small hidden room in the house!"
		)
		(if (and (== gPrevRoomNum 33) (== global140 0))
			(= global140 1)
			(mySound number: 106 loop: 1 play:)
			(Print 50 6) ; "You have found a small hidden room in the house!"
		)
		(if (and (== [gCycleTimers 1] 1) (not global107) (== gAct 4))
			(= global107 1)
			(Print 50 7) ; "You notice a faint aroma of perfume."
		)
		(if (< (gEgo x:) 50)
			(= vertAngle 0)
		else
			(= vertAngle 140)
		)
		(if (& (gEgo onControl: 1) $0002)
			(gCurRoom newRoom: west)
		)
		(if (not local13)
			(if (& (gEgo onControl:) $0020)
				(= local13 1)
				(= vertAngle 0)
				(gEgo illegalBits: 0)
				(HandsOff)
				(if (< (gEgo heading:) 180)
					(gEgo setLoop: 0 setMotion: leftUpPath self)
				else
					(gEgo setLoop: 1 setMotion: leftDwnPath self)
				)
			)
			(if (& (gEgo onControl:) $0040)
				(= local13 1)
				(= vertAngle 0)
				(gEgo illegalBits: 0)
				(HandsOff)
				(if (< (gEgo heading:) 180)
					(gEgo setLoop: 0 setMotion: rightDwnPath self)
				else
					(gEgo setLoop: 1 setMotion: rightUpPath self)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 983)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gEgo setPri: -1)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((and (not global107) (Said 'smell'))
					(Print 50 7) ; "You notice a faint aroma of perfume."
				)
				((Said 'look>')
					(cond
						((or (Said '/room<dining') (Said '/parlor'))
							(if (== west 33)
								(Print 50 8) ; "Just look through the holes."
							else
								(event claimed: 0)
							)
						)
						((or (Said '/room<guest') (Said '/bedroom'))
							(if (== west 43)
								(Print 50 8) ; "Just look through the holes."
							else
								(event claimed: 0)
							)
						)
						((Said '[<around,at][/room]')
							(Print 50 6) ; "You have found a small hidden room in the house!"
						)
						((Said '/painting')
							(Print 50 9) ; "What picture? You don't see any pictures!"
						)
						((Said '/mirror')
							(if (== (gCurRoom west:) 33)
								(Print 50 10) ; "You see the back of the mirror at the hidden room's entrance."
							else
								(Print 50 11) ; "What mirror?"
							)
						)
						((Said '/armoire')
							(if (== (gCurRoom west:) 43)
								(Print 50 12) ; "You see the back of the armoire at the hidden room's entrance."
							else
								(Print 50 13) ; "What armoire?"
							)
						)
						((Said '/parlor,room<dining')
							(if (== (gCurRoom west:) 33)
								(Print 50 14) ; "You can't see those rooms!"
							else
								(event claimed: 0)
							)
						)
						((or (Said '/dirt') (Said '<down'))
							(if (and (== gAct 6) (== (gCurRoom west:) 43))
								(= local36 1)
								(Print 50 15) ; "You notice a dusty bootprint on the floor."
							)
							(if
								(and
									(not (gEgo has: 21)) ; cane
									(== gCurRoomNum (- gCaneLocation gPrevRoomNum))
								)
								(= local36 1)
								(Print 50 16) ; "Someone has left an old cane behind."
							)
							(if
								(and
									(not (gEgo has: 8)) ; cigar_butt
									(== gCurRoomNum (- gCigarButtLocation gPrevRoomNum))
								)
								(= local36 1)
								(Print 50 17) ; "Someone dropped an old cigar butt on the floor."
							)
							(if (not local36)
								(event claimed: 0)
							)
							(= local36 0)
						)
						((Said '[<through,in]/eyehole,eye')
							(if (& (gEgo onControl: 1) $0010)
								(if
									(or
										(== (gEgo loop:) 2)
										(== (gEgo loop:) 3)
									)
									(eyes setScript: LookAround)
								else
									(Print 50 18) ; "Try facing either set of holes."
								)
							else
								(NotClose) ; "You're not close enough."
							)
						)
					)
				)
				((Said 'move,open/door')
					(cond
						((& (gEgo onControl: 1) $0008)
							(switch (gCurRoom south:)
								(38
									(|= global175 $0008)
								)
								(48
									(|= global175 $0080)
								)
							)
							(HandsOff)
							(self setScript: Front)
						)
						((& (gEgo onControl: 1) $0004)
							(switch (gCurRoom north:)
								(34
									(|= global175 $0002)
								)
								(44
									(|= global175 $0020)
								)
							)
							(self setScript: Back)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				)
				((Said 'close/door')
					(Print 50 19) ; "The secret panels are already closed."
				)
				((Said 'get/painting')
					(Print 50 9) ; "What picture? You don't see any pictures!"
				)
				((Said 'close,pull,press,open,move/mirror')
					(if (== (gCurRoom west:) 33)
						(Print 50 20) ; "You closed the mirror behind you. Walk to it to open it."
					else
						(Print 50 11) ; "What mirror?"
					)
				)
				((Said 'close,pull,press,open,move/armoire')
					(if (== (gCurRoom west:) 43)
						(Print 50 21) ; "You closed the armoire behind you. Walk to it to open it."
					else
						(Print 50 13) ; "What armoire?"
					)
				)
			)
		)
	)

	(method (cue)
		(HandsOn)
		(gEgo illegalBits: -32768 setLoop: -1)
		(= local13 0)
	)
)

(instance Front of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local34 0)
				(gEgo illegalBits: 0)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 209 115 self)
			)
			(2
				(mySound number: 74 loop: 1 play:)
				(gEgo loop: 2)
				(fpanel setMotion: MoveTo 187 119 self)
			)
			(3
				(= local34 0)
				(switch (gCurRoom south:)
					(48
						(switch gAct
							(0
								(if (> global199 0)
									(= local34 1)
								)
							)
							(1
								(= local34 1)
							)
							(5
								(= local34 1)
							)
							(2
								(= local34 1)
							)
						)
					)
					(38
						(switch gAct
							(0
								(= local34 1)
							)
							(1
								(= local34 1)
							)
							(4
								(= local34 1)
							)
							(3
								(if (and (< gMinute 3) (< gFifiState 2))
									(= local34 1)
								)
							)
						)
					)
				)
				(if (not local34)
					(gCurRoom newRoom: (gCurRoom south:))
				else
					(Print 50 22 #at 130 10) ; "Oh, no! There is somebody in the room!"
					(= cycles 1)
				)
			)
			(4
				(fpanel setMotion: MoveTo 194 119 self)
				(mySound number: 75 loop: 1 play:)
			)
			(5
				(HandsOn)
				(gEgo illegalBits: -32768)
				(fpanel stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance Back of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local34 0)
				(bpanel setMotion: MoveTo 89 103 self)
				(mySound number: 74 loop: 1 play:)
			)
			(1
				(= local34 0)
				(switch (gCurRoom north:)
					(34
						(if
							(or
								(== gAct 4)
								(and (== gAct 1) (== gClarenceWilburState 3))
								(and (== gMinute 3) (> [gCycleTimers 2] 1))
							)
							(= local34 1)
						)
					)
					(44
						(if
							(or
								(== gAct 5)
								(and
									(== gAct 0)
									(or
										(< [gCycleTimers 4] 20)
										(== global203 2)
										global125
									)
								)
								(and (== gAct 3) (& gMustDos $0002))
								(and
									(== gAct 6)
									(& gMustDos $0002)
									(not (IsFlag 36))
								)
							)
							(= local34 1)
						)
					)
				)
				(if local34
					(Print 50 22 #at 10 10 #mode 1) ; "Oh, no! There is somebody in the room!"
				else
					(= state 3)
				)
				(= cycles 1)
			)
			(2
				(bpanel setMotion: MoveTo 68 103 self)
				(mySound number: 75 loop: 1 play:)
			)
			(3
				(bpanel stopUpd:)
				(HandsOn)
				(gEgo setLoop: -1 illegalBits: -32768)
				(client setScript: 0)
			)
			(4
				(gEgo
					illegalBits: 0
					setLoop: 3
					setMotion: MoveTo 64 105 self
				)
			)
			(5
				(bpanel setMotion: MoveTo 98 103 self)
			)
			(6
				(gEgo
					setLoop: 3
					setPri: 3
					illegalBits: 0
					setMotion: MoveTo 68 100 self
				)
			)
			(7
				(bpanel setMotion: MoveTo 68 103 self)
				(mySound number: 75 loop: 1 play:)
			)
			(8
				(gEgo setLoop: -1 illegalBits: -32768)
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance Entering of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bpanel setMotion: MoveTo 98 103 self)
				(mySound number: 74 loop: 1 play:)
			)
			(1
				(gEgo setPri: 6 setMotion: MoveTo 68 105 self)
			)
			(2
				(bpanel setMotion: MoveTo 68 103 self)
				(mySound number: 75 loop: 1 play:)
			)
			(3
				(HandsOn)
				(gEgo illegalBits: -32768 setScript: 0)
			)
		)
	)
)

(instance LookAround of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo yStep: 1)
				(if (== (gEgo loop:) 2)
					(gEgo setMotion: MoveTo 131 104 self)
				else
					(gEgo setMotion: MoveTo 121 97 self)
				)
			)
			(1
				(gEgo yStep: 2 cel: 2)
				(if (> (gEgo y:) 100)
					(gEgo loop: 2)
					(eyes cycleSpeed: 3 setCycle: Fwd show:)
					(= seconds 3)
				else
					(gEgo loop: 3)
					(= cycles 3)
				)
			)
			(2
				(= temp0 0)
				(switch gAct
					(0
						(cond
							((== (gEgo loop:) 3)
								(if
									(and
										(!= (gCurRoom west:) 33)
										(or
											(== [gCycleTimers 4] 1)
											(== global203 2)
											global125
										)
									)
									(= temp0 330)
								)
							)
							((== (gCurRoom west:) 33)
								(= temp0 301)
							)
							(
								(and
									(== (gCurRoom west:) 43)
									(== (gEgo loop:) 2)
									(> global199 0)
								)
								(= temp0 332)
							)
						)
					)
					(1
						(cond
							((== (gEgo loop:) 3)
								(if
									(and
										(== (gCurRoom west:) 33)
										(== gClarenceWilburState 3)
									)
									(= temp0 305)
								)
							)
							((== (gCurRoom west:) 33)
								(= temp0 302)
							)
							(else
								(= temp0 332)
							)
						)
					)
					(2
						(if (and (== (gEgo loop:) 2) (== (gCurRoom west:) 43))
							(= temp0 333)
						)
					)
					(3
						(if
							(and
								(== (gEgo loop:) 3)
								(== (gCurRoom west:) 33)
								(== gMinute 3)
							)
							(= temp0 303)
						)
						(if
							(and
								(== (gEgo loop:) 3)
								(== (gCurRoom west:) 43)
								(& gMustDos $0002)
							)
							(= temp0 335)
						)
						(if
							(and
								(== (gEgo loop:) 2)
								(== (gCurRoom west:) 33)
								(< gMinute 3)
								(< gFifiState 2)
							)
							(= temp0 307)
						)
					)
					(4
						(if (== (gCurRoom west:) 33)
							(= temp0
								(switch (== (gEgo loop:) 3)
									(1 306)
									(0 304)
								)
							)
						)
					)
					(else
						(if (and (== 5 gAct) (== (gCurRoom west:) 43))
							(= temp0
								(switch (== (gEgo loop:) 3)
									(1 335)
									(0 334)
								)
							)
						)
					)
				)
				(if temp0
					(gCurRoom newRoom: temp0)
				else
					(localproc_0)
				)
			)
			(3
				(client setScript: 0)
				(cls)
				(localproc_1)
				(HandsOn)
			)
		)
	)
)

(instance pickUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(LookAt gEgo client)
				(= cycles 2)
			)
			(1
				(gEgo view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(if (== local37 1)
					(Ok) ; "Okay."
					(cane hide:)
					(gEgo get: 21) ; cane
				else
					(Print 50 23) ; "You bend over and pick up the small cigar butt."
					(cigar hide:)
					(gEgo get: 8) ; cigar_butt
				)
				(= global182 1)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo view: 0 setCycle: Walk)
				(client dispose: setScript: 0)
			)
		)
	)
)

(instance grabbed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 43 loop: 1 cel: 0 setCycle: End self)
				(mySound number: 87 loop: 1 play:)
			)
			(1
				(= seconds 5)
			)
			(2
				(= global128 43)
				(= global129 2)
				(= global130 0)
				(EgoDead 50 24) ; "That's what you get for being such a snoop, Laura!"
			)
		)
	)
)

(instance fpanel of Act
	(properties
		y 119
		x 194
		view 139
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(Print 50 25) ; "You see two secret panels, one in each wall."
			(event claimed: 1)
		)
	)
)

(instance bpanel of Act
	(properties
		y 103
		x 68
		view 139
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(Print 50 25) ; "You see two secret panels, one in each wall."
			(event claimed: 1)
		)
	)
)

(instance eyes of Prop
	(properties
		y 58
		x 132
		view 139
		loop 2
	)
)

(instance protrait of RPicView
	(properties
		y 84
		x 130
		view 139
		priority 9
	)
)

(instance bprotrait of RPicView
	(properties
		y 76
		x 121
		view 139
		loop 1
		priority 4
	)
)

(instance cigar of Prop
	(properties
		y 116
		x 56
		view 139
		loop 7
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/butt'))
				(event claimed: 1)
				(Print 50 26) ; "A cigar butt lies on the floor."
			)
			((Said 'get/butt')
				(if (< (gEgo distanceTo: cigar) 10)
					(= local37 0)
					(self setScript: pickUp)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance cane of Prop
	(properties
		y 116
		x 46
		view 139
		loop 6
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/cane'))
				(event claimed: 1)
				(Print 50 27) ; "An old cane lies on the floor."
			)
			((Said 'get/cane')
				(if (< (gEgo distanceTo: cane) 25)
					(= local37 1)
					(self setScript: pickUp)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance boot of Prop
	(properties
		y 113
		x 35
		view 139
		loop 8
	)

	(method (handleEvent)
		(cond
			((Said 'get/bootprint')
				(Print 50 28) ; "You can't get a bootprint!"
			)
			((Said 'look<use<monocle/bootprint')
				(if (gEgo has: 1) ; monocle
					(if (< (gEgo distanceTo: boot) 10)
						(Print 50 29) ; "You examine it with the monocle, but don't see anything interesting."
					else
						(NotClose) ; "You're not close enough."
					)
				else
					(DontHave) ; "You don't have it."
				)
			)
		)
	)
)

(instance Platform of RFeature
	(properties
		nsTop 95
		nsLeft 108
		nsBottom 115
		nsRight 146
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {platform})
		)
	)
)

(instance mySound of Sound
	(properties)
)

(instance myMusic of Sound
	(properties)
)

