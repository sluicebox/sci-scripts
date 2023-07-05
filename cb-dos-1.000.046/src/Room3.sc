;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3)
(include sci.sh)
(use Main)
(use Interface)
(use DCIcon)
(use RFeature)
(use Avoid)
(use Sound)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	Room3 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0)
	(Print &rest #at 110 25 #mode 1 #dispose)
)

(instance Room3 of Rm
	(properties
		picture 3
	)

	(method (init)
		(= south 14)
		(= west 9)
		(= east 10)
		(super init:)
		(Load rsVIEW 34)
		(Load rsSOUND 73)
		(if (gEgo has: 21) ; cane
			(LoadMany rsVIEW 31 32 53)
			(LoadMany rsSOUND 30 42)
		)
		(Load rsSOUND 17)
		(if (and (== gAct 1) (<= global155 13))
			(self setRegions: 381) ; walkabout
		)
		(if gDetailLevel
			(cloud1 init: stopUpd: setScript: showers)
			(cloud2 init: stopUpd:)
		)
		(soundFX number: 17 loop: 0)
		(bat setLoop: 4 xStep: 8 illegalBits: 0 init: hide:)
		(if global164
			(bell
				illegalBits: 0
				setLoop: (if (== ((gInventory at: 20) owner:) 3) 0 else 6) ; crank
				posn: 72 138
			)
		else
			(bell illegalBits: 0 setLoop: 0)
		)
		(bell setPri: 11 baseSetter: bellBase init: stopUpd:)
		(ring setLoop: 1 setPri: 11 init: stopUpd:)
		(arm setPri: 14 init: hide:)
		(self setFeatures: Ladder)
		(if (and (>= gAct 2) (< gAct 4) (< [gCycleTimers 1] 700))
			(self setRegions: 202) ; EthelDrunk
		)
		(if
			(or
				(and (== gAct 3) (< global114 2))
				(and (== gAct 6) (not (& gMustDos $0002)))
			)
			(self setRegions: 281) ; rudywand
		)
		(switch gPrevRoomNum
			(10
				(gEgo posn: 318 175)
			)
			(14
				(gEgo posn: 305 187)
			)
			(9
				(gEgo posn: 1 176)
			)
		)
		(gEgo view: 0 illegalBits: -32768 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 3 0) ; "You see a rusted, iron bell at the top of an old, bell tower. A rope dangles a short distance beneath the bell while a ladder runs up the tower's side. Behind a weathered fence, you also notice the remnants of the old plantation's fields."
		)
		(if (and (not local3) (& (gEgo onControl: 0) $0002))
			(= local3 1)
			(gEgo setScript: climbUp)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(DisposeScript 990)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(switch (event type:)
			(evSAID
				(cond
					((Said 'look>')
						(cond
							((Said '[<around,at][/room]')
								(if global164
									(Print 3 1) ; "A rope dangles a short distance dwon from the tower while a ladder runs up the tower's side. Behind a weathered fence, you also notice the remnants of the old plantation's fields."
								else
									(Print 3 0) ; "You see a rusted, iron bell at the top of an old, bell tower. A rope dangles a short distance beneath the bell while a ladder runs up the tower's side. Behind a weathered fence, you also notice the remnants of the old plantation's fields."
								)
							)
							((Said '<up')
								(if (& (gEgo onControl: 1) $0004)
									(if global164
										(Print 3 2) ; "The rope dangles a short distance above you."
									else
										(Print 3 3) ; "The rope dangles a short distance above you. Higher up, you see the old bell."
									)
								else
									(event claimed: 0)
								)
							)
							((Said '/path')
								(Print 3 4) ; "A path travels by the old bell tower."
							)
							((Said '/field')
								(Print 3 5) ; "Behind a weather-beaten fence, you see the old, unused sugar cane fields. The fields look as if they haven't been planted in years."
							)
							((Said '/fence')
								(Print 3 6) ; "An old weather-beaten fence partitions off the remaining vestiges of the plantation's once-vast sugar cane fields. Now, all that's left are long-ago plowed furrows and old dead stalks."
							)
							((Said '/archway')
								(Print 3 7) ; "You don't see a gate here."
							)
							((or (Said '<(at,in)/tower') (Said '<in'))
								(cond
									(local0
										(if global164
											(SeeNothing) ; "You see nothing special."
										else
											(Print 3 8) ; "All you see is the old, rusted bell."
										)
									)
									((& (gEgo onControl: 1) $0004)
										(if global164
											(Print 3 2) ; "The rope dangles a short distance above you."
										else
											(Print 3 3) ; "The rope dangles a short distance above you. Higher up, you see the old bell."
										)
									)
									(else
										(Print 3 9) ; "You can't see into the bell tower from here."
									)
								)
							)
							((Said '/tower[<bell]')
								(if global164
									(Print 3 1) ; "A rope dangles a short distance dwon from the tower while a ladder runs up the tower's side. Behind a weathered fence, you also notice the remnants of the old plantation's fields."
								else
									(Print 3 10) ; "You see a rusted iron bell at the top of an old bell tower. A rope dangles a short distance beneath the bell while a ladder runs up the tower's side."
								)
							)
						)
					)
					((Said 'climb/fence')
						(Print 3 11) ; "The fence is too difficult to climb. Besides, you don't care about those old fields."
					)
					(
						(or
							(Said 'use/can<oil')
							(Said 'oil/bell')
							(Said 'attach/oil/bell')
						)
						(if (== global184 0)
							(if (gEgo has: 3) ; oilcan
								(if local0
									(= global184 1)
									(self setScript: oilBell)
								else
									(Print 3 12) ; "You're not in a position to do that."
								)
							else
								(Print 3 13) ; "You have no way of doing that."
							)
						else
							(Print 3 14) ; "The bell has been oiled."
						)
					)
				)
			)
			(evMOUSEBUTTON
				(if
					(and
						local0
						(> (event y:) (gEgo y:))
						(not (& (event modifiers:) $000f)) ; emALT | emCTRL | emSHIFT
						(User canInput:)
					)
					(gEgo setScript: climbDown)
				)
			)
			($0040 ; direction
				(if (and local0 (== (event message:) JOY_DOWN) (User canInput:))
					(gEgo setScript: climbDown)
				)
			)
		)
	)
)

(instance bellBase of Code
	(properties)

	(method (doit)
		(bell
			brTop: (+ (bell y:) 8)
			brLeft: (- (bell x:) 2)
			brBottom: (+ (bell y:) 12)
			brRight: (+ (bell x:) 2)
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
				(cloud1 setCycle: Fwd)
				(cloud2 setCycle: Fwd)
				(= cycles 7)
			)
			(2
				(cloud1 setCycle: End)
				(cloud2 setCycle: End self)
			)
			(3
				(soundFX number: 17 play: self)
			)
			(4
				(if (< (Random 1 100) 25)
					(= state 0)
				)
				(= cycles 7)
			)
			(5
				(= state 3)
				(= seconds 5)
			)
		)
	)
)

(instance climbUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local3 1)
				(HandsOff)
				(gEgo
					illegalBits: 0
					setLoop: (gEgo loop:)
					setMotion: MoveTo 26 156 self
				)
			)
			(1
				(gEgo
					view: 34
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setPri: 12
					setCycle: End self
				)
			)
			(2
				(gEgo posn: 26 145 setLoop: 1 cel: 0 setCycle: End self)
			)
			(3
				(gEgo posn: 26 120 cel: 0 setCycle: End self)
			)
			(4
				(gEgo setLoop: 2 posn: 26 110 cel: 0 setCycle: End self)
			)
			(5
				(gEgo setLoop: 3 cel: 0 posn: 39 55 setCycle: End self)
				(if (not local4)
					(++ local4)
					(bat show: setCycle: Walk setMotion: MoveTo 340 80)
				)
			)
			(6
				(arm show:)
				(gEgo loop: 8 stopUpd: 0)
				(= cycles 1)
			)
			(7
				(= local0 1)
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance climbDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(gEgo cel: 3 loop: 3 setCycle: Beg self)
				(arm hide:)
			)
			(1
				(gEgo setLoop: 2 posn: 26 110 cel: 3 setCycle: Beg self)
			)
			(2
				(gEgo setLoop: 1 posn: 26 120 cel: 3 setCycle: Beg self)
			)
			(3
				(gEgo posn: 26 145 cel: 3 setCycle: Beg self)
			)
			(4
				(gEgo setLoop: 0 posn: 26 156 cel: 3 setCycle: Beg self)
			)
			(5
				(gEgo
					view: 0
					posn: 26 158
					setPri: -1
					setCycle: Walk
					setLoop: 2
					illegalBits: -32768
					cycleSpeed: 0
					setMotion: MoveTo 32 164 self
				)
			)
			(6
				(gEgo setLoop: -1)
				(HandsOn)
				(= local1 (= local0 (= local3 0)))
				(client setScript: 0)
			)
		)
	)
)

(instance oilBell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canInput: 0)
				(arm setLoop: 6)
				(arm cel: (- (NumCels arm) 1) setCycle: Beg self)
			)
			(1
				(soundFX number: 73 loop: 1 play:)
				(arm setLoop: 7 setCycle: Fwd)
				(= cycles 16)
			)
			(2
				(soundFX stop:)
				(arm setLoop: 6 cel: 0 setCycle: End self)
			)
			(3
				(Print 3 15) ; "Oiling the rusted bell may have loosened it."
				(User canInput: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance ringBell of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(< (gEgo distanceTo: bell) 75)
				(!= (gEgo view:) 31)
				local2
			)
			(gEgo view: 31 setLoop: 0 cel: 0 cycleSpeed: 0 setCycle: End)
		)
		(if (and (== (gEgo view:) 31) (== (gEgo cel:) 3))
			(gEgo setMotion: MoveTo 73 148)
			(bell hide:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (& (gEgo onControl: 1) $0008)
					(gEgo setMotion: MoveTo 94 144 self)
					(= local2 0)
				else
					(gEgo illegalBits: 0 setMotion: MoveTo 73 144 self)
					(= local2 1)
				)
			)
			(1
				(gEgo
					view: 53
					cel: 0
					loop: (if local2 4 else 0)
					setCycle: End
				)
				(localproc_0 3 16) ; "Reaching up with the cane you hook it onto the short rope's iron ring and PULL..."
				(= seconds 3)
			)
			(2
				(cls)
				(if global184
					(gEgo
						loop: (if local2 5 else 2)
						cycleSpeed: 2
						setCycle: Fwd
					)
					(bell setCycle: Fwd)
					(ring startUpd: setCycle: Fwd)
					(soundFX number: 30 loop: 1 play:)
					(= cycles 8)
				else
					(= state 3)
					(localproc_0 3 17) ; "...Nothing happens. Oh! The bell's too rusted to move!"
					(= seconds 4)
				)
			)
			(3
				(cls)
				(bell view: 203 setLoop: 0 setCel: 0 cycleSpeed: 0 yStep: 10)
				(ring setCycle: Beg)
				(if (and global184 local2)
					(bell setMotion: MoveTo 66 108 self)
					(localproc_0 3 18) ; "Uh, oh!!"
				else
					(= global164 1)
					(bell
						setLoop: 6
						ignoreActors: 1
						setMotion: MoveTo 72 138 self
					)
					(gEgo setCycle: 0)
					(localproc_0 3 19) ; "Look out! It's falling...!"
				)
			)
			(4
				(cls)
				(if (and global184 local2)
					(soundFX number: 42 play:)
					(ShakeScreen 5 ssUPDOWN)
					(if (< (Random 1 100) 6)
						(= state 5)
					else
						(= state 8)
					)
					(= cycles 14)
				else
					(if (== global164 1)
						(soundFX number: 30 play:)
						(ShakeScreen 5 ssUPDOWN)
					)
					(gEgo loop: (if local2 4 else 0))
					(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
				)
			)
			(5
				(gEgo
					view: 0
					loop: (if global184 1 else 2)
					cycleSpeed: 0
					illegalBits: -32768
					setCycle: Walk
				)
				(ring stopUpd:)
				(if global184
					(bell ignoreActors: 0 stopUpd:)
					(Print 3 20) ; "Whew! That was close!"
				)
				(HandsOn)
				(client setScript: 0)
			)
			(6
				(= local2 0)
				(gEgo
					view: 32
					setLoop: -1
					setCycle: Walk
					setAvoider: (Avoid new:)
					illegalBits: -32768
					setMotion: MoveTo 179 167 self
				)
			)
			(7
				(soundFX number: 30 play:)
				(ShakeScreen 5 ssLEFTRIGHT)
				(gEgo setLoop: 5 setMotion: MoveTo 159 167 self)
			)
			(8
				(gEgo loop: 4)
				(= seconds 7)
			)
			(9
				(= global128 myIcon)
				(= global129 2)
				(= global130 0)
				(EgoDead 3 21) ; "Now you're a real southern belle."
			)
		)
	)
)

(instance pullRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo illegalBits: 0 setMotion: MoveTo 85 146 self)
			)
			(1
				(gEgo
					view: 58
					cel: 0
					loop: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(localproc_0 3 22) ; "You reach up and try to grab the ring attached to the end of the rope..."
			)
			(2
				(gEgo loop: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(3
				(gEgo loop: 0 cel: 5 setCycle: Beg)
				(= seconds 3)
			)
			(4
				(cls)
				(Print 3 23) ; "...but the short rope is too high for you to reach the ring."
				(gEgo
					view: 0
					loop: 1
					cycleSpeed: 0
					illegalBits: -32768
					setCycle: Walk
				)
				(HandsOn)
				(client setScript: 0)
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
				(DirLoop gEgo (GetAngle (gEgo x:) (gEgo y:) 72 150))
				(= cycles 2)
			)
			(1
				(gEgo view: 17 cel: 0 setMotion: 0 setCycle: End self)
			)
			(2
				(= global182 1)
				(Print 3 24) ; "Okay. Thinking it might be useful, you remove the crank from the bell and take it with you."
				(gEgo get: 20) ; crank
				(bell setLoop: 0 forceUpd:)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(HandsOn)
				(gEgo view: 0 setCycle: Walk)
				(client setScript: 0)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		number 17
		priority 3
	)
)

(instance bell of Act
	(properties
		y 12
		x 72
		view 203
	)

	(method (handleEvent event)
		(cond
			((Said 'look<(in,below)/bell')
				(if global164
					(Print 3 25) ; "You see nothing there."
				else
					(Print 3 26) ; "You cannot look into the bell from here."
				)
			)
			((Said 'get/control')
				(if global164
					(cond
						((!= ((gInventory at: 20) owner:) 3) ; crank
							(AlreadyTook) ; "You already took it."
						)
						((< (gEgo distanceTo: bell) 15)
							(self setScript: pickUp)
						)
						(else
							(NotClose) ; "You're not close enough."
						)
					)
				else
					(Print 3 27) ; "You don't see a crank here."
				)
			)
			((Said 'get,move/bell')
				(Print 3 28) ; "You could never carry around that big bell!"
			)
			(
				(or
					(Said '(ring,pull)<use<cane/(hemp,ring,bell)')
					(Said 'use/cane/bell<ring')
					(Said 'pull,get,get/(ring,hemp,bell)/cane<(with,use)')
					(Said 'ring/bell/cane<(with,use)')
				)
				(if (not global164)
					(if (gEgo has: 21) ; cane
						(if
							(or
								(& (gEgo onControl: 1) $0008)
								(& (gEgo onControl: 1) $0004)
							)
							(gEgo setScript: ringBell)
						else
							(NotClose) ; "You're not close enough."
						)
					else
						(DontHave) ; "You don't have it."
					)
				else
					(Print 3 29) ; "You can't ring the bell now!"
				)
			)
			(
				(or
					(Said '(ring,pull)<use<*/(hemp,ring,bell)')
					(Said 'use/*/bell<ring')
					(Said 'pull/(ring,hemp)/*<with')
				)
				(Print 3 30) ; "That would not do any good."
			)
			((Said 'ring/bell')
				(if global164
					(Print 3 29) ; "You can't ring the bell now!"
				else
					(Print 3 31) ; "You need to pull on the rope to ring the bell."
				)
			)
			((Said 'get,get,pull,ring/bell,hemp,ring')
				(cond
					(global164
						(Print 3 29) ; "You can't ring the bell now!"
					)
					(
						(or
							(& (gEgo onControl: 1) $0008)
							(& (gEgo onControl: 1) $0004)
						)
						(gEgo setScript: pullRope)
					)
					(else
						(NotClose) ; "You're not close enough."
					)
				)
			)
			((or (MousedOn self event 3) (Said 'search,look/bell'))
				(event claimed: 1)
				(cond
					(global164
						(if (== ((gInventory at: 20) owner:) 3) ; crank
							(Print 3 32) ; "What's that attached to the bell?! Hmmmm. It's some sort of old metal crank."
						else
							(Print 3 33) ; "It's just an old, rusted, iron bell."
						)
					)
					(global184
						(Print 3 15) ; "Oiling the rusted bell may have loosened it."
					)
					(else
						(Print 3 34) ; "Dusty cobwebs cover the old bell that over years has rusted in place."
					)
				)
			)
		)
	)
)

(instance ring of Prop
	(properties
		y 82
		x 77
		view 203
		signal 16384
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/hemp,ring'))
			(event claimed: 1)
			(Print 3 35) ; "A short rope hangs slightly below the old bell tower. There is a rusty, iron ring attached to the bottom of it."
		)
	)
)

(instance arm of Prop
	(properties
		y 28
		x 46
		view 34
		loop 4
		cycleSpeed 2
	)
)

(instance cloud1 of Prop
	(properties
		y 54
		x 277
		view 203
		loop 2
		cel 1
	)
)

(instance cloud2 of Prop
	(properties
		y 57
		x 211
		view 203
		loop 3
		cel 1
	)
)

(instance bat of Act
	(properties
		y 14
		x 74
		view 203
		loop 4
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/bat'))
				(event claimed: 1)
				(Print 3 36) ; "You scared away a bat!"
			)
			((Said 'capture,get/bat')
				(Print 3 37) ; "You don't want a bat."
			)
		)
	)
)

(instance Ladder of RFeature
	(properties
		nsTop 46
		nsLeft 28
		nsBottom 156
		nsRight 37
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/ladder'))
				(event claimed: 1)
				(Print 3 38) ; "A rickety ladder runs up the side of the old bell tower."
			)
			((Said 'climb[/ladder,tower]')
				(if local0
					(gEgo setScript: climbDown)
				else
					(NotClose) ; "You're not close enough."
				)
			)
		)
	)
)

(instance myIcon of DCIcon
	(properties
		view 31
		loop 2
	)
)

