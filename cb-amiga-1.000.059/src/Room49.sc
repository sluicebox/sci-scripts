;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 49)
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
	Room49 0
)

(synonyms
	(armoire closet)
	(door panel)
)

(local
	[local0 8] = [49 0 49 1 49 2 49 3]
	local8
	local9
	[local10 5] = [163 106 186 99 -32768]
	[local15 5] = [175 100 150 109 -32768]
	[local20 5] = [215 100 197 99 -32768]
	[local25 5] = [206 99 227 109 -32768]
	local30
	local31
	local32
	local33
)

(procedure (localproc_0 &tmp temp0)
	(if (not local8)
		(= local8 1)
		(DrawPic 62 7)
		(gCast eachElementDo: #hide)
		(myMusic number: 27 loop: -1 play:)
		(if local31
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
	(if local8
		(= local8 0)
		(DrawPic 40 6)
		(myMusic fade:)
		(gAddToPics doit:)
		(gCast eachElementDo: #show)
		(eyes hide:)
	)
)

(instance rightUpPath of Path
	(properties)

	(method (at param1)
		(return [local20 param1])
	)
)

(instance leftUpPath of Path
	(properties)

	(method (at param1)
		(return [local10 param1])
	)
)

(instance rightDwnPath of Path
	(properties)

	(method (at param1)
		(return [local25 param1])
	)
)

(instance leftDwnPath of Path
	(properties)

	(method (at param1)
		(return [local15 param1])
	)
)

(instance Room49 of Rm
	(properties
		picture 40
	)

	(method (init)
		(HandsOn)
		(if (or (< gPrevRoomNum 40) (and (> gPrevRoomNum 299) (< gPrevRoomNum 330))) ; scene44a
			(= local31 1)
			(= east 33)
			(= north 32)
			(= south 36)
		else
			(= east 43)
			(= north 42)
			(= south 46)
		)
		(super init:)
		(Load rsPIC 62)
		(LoadMany rsSOUND 27 74 75 106)
		(if (== south 46)
			(fprotrait cel: 1)
		)
		(gAddToPics add: fprotrait bprotrait doit:)
		(self setFeatures: Platform)
		(if
			(and
				(>= gAct 2)
				(not (gEgo has: 21)) ; cane
				(== gCaneLocation 0)
				(< gPrevRoomNum 49)
			)
			(= gCaneLocation (+ (Random 49 50) (gCurRoom east:)))
		)
		(if
			(and
				(== gCurRoomNum (- gCaneLocation (gCurRoom east:)))
				(not (gEgo has: 21)) ; cane
			)
			(cane init:)
		)
		(if
			(and
				(>= gAct 3)
				(not (gEgo has: 8)) ; cigar_butt
				(== gCigarButtLocation 0)
				(< gPrevRoomNum 49)
				(== (= gCigarButtLocation (+ (Random 49 50) (gCurRoom east:))) gCaneLocation)
			)
			(if (> gCaneLocation 85)
				(-= gCigarButtLocation 10)
			else
				(+= gCigarButtLocation 10)
			)
		)
		(if
			(and
				(== gCurRoomNum (- gCigarButtLocation (gCurRoom east:)))
				(not (gEgo has: 8)) ; cigar_butt
			)
			(cigar ignoreActors: 1 init:)
		)
		(fpanel
			setLoop: 5
			setCel: 1
			illegalBits: 0
			ignoreActors: 1
			setPri: 7
			init:
			stopUpd:
		)
		(bpanel setLoop: 3 setCel: 0 illegalBits: 0 setPri: 4 init: stopUpd:)
		(eyes setPri: 10 init:)
		(eyes hide:)
		(self setRegions: 212) ; passReg
		(switch gPrevRoomNum
			(33
				(gEgo posn: 301 110)
			)
			(43
				(gEgo posn: 301 110)
			)
			(36
				(gEgo posn: 124 115)
			)
			(46
				(gEgo posn: 124 115)
			)
		)
		(if (or (== gPrevRoomNum 32) (== gPrevRoomNum 42))
			(gEgo
				loop: 2
				illegalBits: 0
				posn: 251 101
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
				(gEgo inRect: 120 115 129 118)
				(not script)
				(> gAct 0)
				(< gAct 7)
				(!= gAct 4)
				(< (Random 1 100) 35)
			)
			(self setScript: grabbed)
		)
		(if (and (== gPrevRoomNum 43) (== global143 0))
			(= global143 1)
			(mySound number: 106 loop: 1 play:)
			(Print 49 4) ; "You have found a small hidden room in the house!"
		)
		(if (and (== gPrevRoomNum 33) (== global139 0))
			(= global139 1)
			(mySound number: 106 loop: 1 play:)
			(Print 49 4) ; "You have found a small hidden room in the house!"
		)
		(if
			(and
				(== [gCycleTimers 1] 1)
				(not global107)
				(< gPrevRoomNum 47)
				(== gAct 4)
			)
			(= global107 1)
			(Print 49 5) ; "You notice a faint aroma of perfume."
		)
		(if (< (gEgo x:) 270)
			(= vertAngle 40)
		else
			(= vertAngle 0)
		)
		(if (& (gEgo onControl: 1) $0002)
			(if (and (== gAct 0) (& gSpyFlags $0001) (== global199 0))
				(= global199 1)
			)
			(gCurRoom newRoom: east)
		)
		(if (not local9)
			(if (& (gEgo onControl:) $0040)
				(= local9 1)
				(= vertAngle 0)
				(gEgo illegalBits: 0)
				(HandsOff)
				(if (< (gEgo heading:) 180)
					(gEgo setLoop: 0 setMotion: leftUpPath self)
				else
					(gEgo setLoop: 1 setMotion: leftDwnPath self)
				)
			)
			(if (& (gEgo onControl:) $0020)
				(= local9 1)
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
		(if (and (or (IsFlag 38) (IsFlag 37)) (!= newRoomNumber 42) (!= newRoomNumber 43))
			(ClearFlag 38)
			(ClearFlag 37)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((and (not global107) (Said 'smell'))
					(Print 49 5) ; "You notice a faint aroma of perfume."
				)
				((Said 'look>')
					(cond
						((or (Said '/room<billiard') (Said '/library'))
							(if (== west 33)
								(Print 49 6) ; "Just look through the holes."
							else
								(event claimed: 0)
							)
						)
						((or (Said '/room<guest') (Said '/bedroom'))
							(if (== west 43)
								(Print 49 6) ; "Just look through the holes."
							else
								(event claimed: 0)
							)
						)
						((Said '[<around,at][/room]')
							(Print 49 4) ; "You have found a small hidden room in the house!"
						)
						((Said '/painting')
							(Print 49 7) ; "What picture? You don't see any pictures!"
						)
						((Said '/door')
							(Print 49 8) ; "You see two secret panels, one in each wall."
						)
						((or (Said '/dirt') (Said '<down'))
							(if
								(and
									(not (gEgo has: 21)) ; cane
									(== gCurRoomNum (- gCaneLocation gPrevRoomNum))
								)
								(= local32 1)
								(Print 49 9) ; "Someone has left an old cane behind."
							)
							(if
								(and
									(not (gEgo has: 8)) ; cigar_butt
									(== gCurRoomNum (- gCigarButtLocation gPrevRoomNum))
								)
								(= local32 1)
								(Print 49 10) ; "Someone dropped an old cigar butt on the floor."
							)
							(if (not local32)
								(event claimed: 0)
							)
							(= local32 0)
						)
						((Said '/clock')
							(if (== (gCurRoom east:) 33)
								(Print 49 11) ; "You see the back of the clock at the hidden room's entrance."
							else
								(Print 49 12) ; "What clock?"
							)
						)
						((Said '/armoire')
							(if (== (gCurRoom east:) 43)
								(Print 49 13) ; "You see the back of the armoire at the hidden room's entrance."
							else
								(Print 49 14) ; "What armoire?"
							)
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
									(Print 49 15) ; "Try facing either set of holes."
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
								(36
									(|= global175 $0004)
								)
								(46
									(|= global175 $0040)
								)
							)
							(HandsOff)
							(self setScript: Front)
						)
						((& (gEgo onControl: 1) $0004)
							(switch (gCurRoom north:)
								(32
									(|= global175 $0001)
								)
								(42
									(|= global175 $0010)
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
					(Print 49 16) ; "The secret panels are already closed."
				)
				((Said 'get/painting')
					(Print 49 7) ; "What picture? You don't see any pictures!"
				)
				((Said 'close,pull,press,open/clock')
					(if (== (gCurRoom east:) 33)
						(Print 49 17) ; "You closed the clock behind you. Walk to it to open it."
					else
						(Print 49 12) ; "What clock?"
					)
				)
				((Said 'close,pull,press,open/armoire')
					(if (== (gCurRoom east:) 43)
						(Print 49 18) ; "You closed the armoire behind you. Walk to it to open it."
					else
						(Print 49 14) ; "What armoire?"
					)
				)
			)
		)
	)

	(method (cue)
		(HandsOn)
		(gEgo illegalBits: -32768 setLoop: -1)
		(= local9 0)
	)
)

(instance Front of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local30 0)
				(gEgo illegalBits: 0)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 109 115 self)
			)
			(2
				(gEgo loop: 2)
				(fpanel setMotion: MoveTo 135 119 self)
				(mySound number: 74 loop: 1 play:)
			)
			(3
				(switch (gCurRoom south:)
					(46
						(if (and (& gSpyFlags $0002) (== gAct 0))
							(= local30 1)
						)
					)
					(36
						(switch gAct
							(0
								(if
									(or
										(== global199 0)
										(== global199 2)
										(== [gCycleTimers 2] 1)
									)
									(= local30 1)
								)
							)
							(1
								(= local30 1)
							)
							(2
								(= local30 1)
							)
						)
					)
				)
				(if (not local30)
					(gCurRoom newRoom: (gCurRoom south:))
				else
					(Print 49 19 #at 130 10) ; "Oh, no! There is somebody in the room!"
					(= cycles 1)
				)
			)
			(4
				(fpanel setMotion: MoveTo 126 119 self)
				(mySound number: 75 loop: 1 play:)
			)
			(5
				(fpanel stopUpd:)
				(gEgo illegalBits: -32768)
				(HandsOn)
			)
		)
	)
)

(instance Back of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local30 0)
				(HandsOff)
				(bpanel setMotion: MoveTo 272 103 self)
				(mySound number: 74 loop: 1 play:)
			)
			(1
				(= local30 0)
				(switch (gCurRoom north:)
					(42
						(if
							(or
								(== gAct 0)
								(== gAct 1)
								(IsFlag 38)
								(and
									(< gMinute 3)
									(not (& gCorpseFlags $0040)) ; Lillian
									(not (IsFlag 37))
								)
							)
							(= local30 1)
						)
					)
					(32
						(if
							(or
								(== gAct 0)
								(and (== gAct 1) (>= gClarenceWilburState 4))
							)
							(= local30 1)
						)
					)
				)
				(if local30
					(Print 49 19 #at 105 10) ; "Oh, no! There is somebody in the room!"
				else
					(= state 3)
				)
				(= cycles 1)
			)
			(2
				(bpanel setMotion: MoveTo 250 103 self)
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
					setMotion: MoveTo 251 105 self
				)
			)
			(5
				(bpanel setMotion: MoveTo 280 103 self)
			)
			(6
				(gEgo
					setLoop: 3
					setPri: 3
					illegalBits: 0
					setMotion: MoveTo 251 100 self
				)
			)
			(7
				(bpanel setMotion: MoveTo 250 103 self)
				(mySound number: 75 loop: 1 play:)
			)
			(8
				(gEgo setLoop: -1 illegalBits: -32768)
				(client setScript: 0)
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
				(bpanel setMotion: MoveTo 280 103 self)
				(mySound number: 74 loop: 1 play:)
			)
			(1
				(gEgo setPri: 6 setMotion: MoveTo 251 105 self)
			)
			(2
				(bpanel setMotion: MoveTo 250 103 self)
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
					(gEgo setMotion: MoveTo 190 104 self)
				else
					(gEgo setMotion: MoveTo 198 97 self)
				)
			)
			(1
				(gEgo yStep: 2)
				(if (== (gEgo y:) 104)
					(gEgo loop: 2)
					(eyes cycleSpeed: 3 setCycle: Fwd show:)
					(= seconds 3)
				else
					(gEgo loop: 3)
					(= cycles 1)
				)
			)
			(2
				(= temp0 0)
				(switch gAct
					(0
						(cond
							((== (gEgo loop:) 3)
								(= temp0
									(switch (== (gCurRoom east:) 33)
										(1 320)
										(0 350)
									)
								)
							)
							((== (gCurRoom east:) 33)
								(= temp0 321)
							)
							((& gSpyFlags $0002)
								(= temp0 351)
							)
						)
					)
					(1
						(cond
							((== (gEgo loop:) 3)
								(if (== (gCurRoom east:) 33)
									(if (>= gClarenceWilburState 4)
										(= temp0 320)
									)
								else
									(= temp0 352)
								)
							)
							((== (gCurRoom east:) 33)
								(= temp0 323)
							)
						)
					)
					(2
						(cond
							((== (gEgo loop:) 3)
								(if
									(and
										(!= (gCurRoom east:) 33)
										(< gMinute 3)
										(not (IsFlag 37))
									)
									(= temp0
										(switch (& gSpyFlags $0040)
											(0 353)
											(64 350)
										)
									)
								)
							)
							((== (gCurRoom east:) 33)
								(= temp0 324)
							)
						)
					)
					(3
						(if
							(and
								(== (gEgo loop:) 3)
								(== (gCurRoom east:) 43)
								(< gMinute 3)
								(not (IsFlag 37))
							)
							(= temp0 352)
						)
					)
					(4
						(if (and (== (gEgo loop:) 3) (== (gCurRoom east:) 43))
							(cond
								(
									(or
										(not (& gMustDos $0002))
										(IsFlag 38)
										(and (< gMinute 3) (not (IsFlag 37)))
									)
									(= temp0 354)
								)
								((not (& gMustDos $0004))
									(= temp0 355)
								)
							)
						)
					)
					(7
						(if
							(and
								(== (gEgo loop:) 3)
								(== (gCurRoom east:) 43)
								(not (& gCorpseFlags $0040)) ; Lillian
							)
							(= temp0 352)
						)
					)
					(else
						(if
							(and
								(== (gEgo loop:) 3)
								(== (gCurRoom east:) 43)
								(< gMinute 3)
								(not (IsFlag 37))
								(< gAct 7)
							)
							(= temp0 352)
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
				(eyes setScript: 0)
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
				(if (== local33 1)
					(Ok) ; "Okay."
					(cane hide:)
					(gEgo get: 21) ; cane
				else
					(Print 49 20) ; "You bend over and pick up the small cigar butt."
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
				(gEgo view: 43 loop: 0 cel: 0 setCycle: End self)
				(mySound number: 87 loop: 1 play:)
			)
			(1
				(= seconds 5)
			)
			(2
				(= global128 43)
				(= global129 2)
				(= global130 1)
				(EgoDead 49 21) ; "That's what you get for being such a snoop, Laura!"
			)
		)
	)
)

(instance fprotrait of PV
	(properties
		y 78
		x 189
		view 139
		priority 9
	)
)

(instance bprotrait of PV
	(properties
		y 70
		x 198
		view 139
		loop 1
		priority 4
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/door'))
			(Print 49 8) ; "You see two secret panels, one in each wall."
			(event claimed: 1)
		)
	)
)

(instance fpanel of Act
	(properties
		y 119
		x 126
		view 139
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(Print 49 8) ; "You see two secret panels, one in each wall."
			(event claimed: 1)
		)
	)
)

(instance bpanel of Act
	(properties
		y 103
		x 250
		view 139
	)
)

(instance eyes of Prop
	(properties
		y 57
		x 190
		view 139
		loop 2
	)
)

(instance cane of Prop
	(properties
		y 115
		x 276
		view 139
		loop 6
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/cane'))
				(event claimed: 1)
				(Print 49 22) ; "An old cane lies on the floor."
			)
			((Said 'get/cane')
				(if (< (gEgo distanceTo: cane) 25)
					(= local33 1)
					(self setScript: pickUp)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance cigar of Prop
	(properties
		y 115
		x 276
		view 139
		loop 7
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/butt'))
				(event claimed: 1)
				(Print 49 23) ; "A cigar butt lies on the floor."
			)
			((Said 'get/butt')
				(if (< (gEgo distanceTo: cigar) 10)
					(= local33 0)
					(self setScript: pickUp)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance Platform of RFeature
	(properties
		nsTop 95
		nsLeft 174
		nsBottom 115
		nsRight 209
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

