;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
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
	Room10 0
)

(local
	local0
	local1
	local2
	local3
)

(instance Room10 of Rm
	(properties
		picture 10
	)

	(method (init)
		(= south 21)
		(= east 15)
		(= north 3)
		(super init:)
		(= local2 (IsFirstTimeInRoom))
		(self setRegions: 206 setFeatures: Window1 Window2 Window3) ; houseOReg
		(LoadMany rsSOUND 43 44)
		(Door
			cel: (if (== gPrevRoomNum 31) 3 else 0)
			setPri: 6
			ignoreActors: 1
			init:
			stopUpd:
		)
		(= global373 Door)
		(if gDetailLevel
			(Splash1 ignoreActors: 1 init: hide:)
			(Splash2 ignoreActors: 1 init: hide:)
		)
		(switch gPrevRoomNum
			(4
				(gEgo posn: 56 50)
			)
			(3
				(gEgo posn: 1 68)
			)
			(31
				(gEgo posn: 154 121)
				(if (not (IsFirstTimeInRoom))
					(gEgo setScript: comeDown)
				)
			)
			(15
				(gEgo posn: 317 181)
			)
			(21
				(gEgo posn: 160 185)
			)
		)
		(gEgo view: 0 illegalBits: -32766 init:)
		(if (== gAct 1)
			(self setRegions: 381) ; walkabout
		)
		(if (== gAct 5)
			(self setRegions: 277) ; rudypet
		)
		(if (and (>= gAct 2) (< gAct 4) (!= global114 0))
			(self setRegions: 202) ; EthelDrunk
		)
		(if
			(or
				(and (== gAct 3) (== global114 0))
				(and (== gAct 6) (not (& gMustDos $0002)))
			)
			(self setRegions: 281) ; rudywand
		)
		(if (and (== gAct 1) (== gClarenceWilburState 0))
			(= [gCycleTimers 0] 1800)
			(= local3 1)
			(LoadMany rsVIEW 400 420 404)
			(Clarence init:)
			(CHead setPri: 10 init:)
			(Wilbur init:)
			(WHead setPri: 10 init:)
			(self setScript: Argue)
		)
	)

	(method (doit)
		(if local2
			(= local2 0)
			(Print 10 0) ; "You are standing at the northwest corner of the house right outside the Colonel's study."
			(if (== gPrevRoomNum 31)
				(gEgo setScript: comeDown)
			)
		)
		(if (& (gEgo onControl: 0) $0004)
			(if (and (== gAct 1) (== gClarenceWilburState 14))
				(= gClarenceWilburState 2)
			)
			(gCurRoom newRoom: 4)
		)
		(if (& (gEgo onControl: 1) $0002)
			(gCurRoom newRoom: 31)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0020)
				(or (== (gEgo loop:) 0) (== (gEgo loop:) 3))
				(== local0 0)
			)
			(= local0 1)
			(self setScript: myDoor)
		)
		(if (== (gEgo edgeHit:) EDGE_LEFT)
			(if (and (== gAct 1) (== gClarenceWilburState 14))
				(= gClarenceWilburState 2)
			)
			(if (< (gEgo y:) 80)
				(gCurRoom newRoom: 3)
			else
				(gCurRoom newRoom: 14)
			)
		)
		(if
			(and
				(& (gEgo onControl: 1) $4000)
				(!= (gEgo mover:) 0)
				gDetailLevel
			)
			(switch (gEgo loop:)
				(2
					(if (== (gEgo cel:) 2)
						(Splash1
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 5)
						(Splash2
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(3
					(if (== (gEgo cel:) 2)
						(Splash1
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 5)
						(Splash2
							posn: (+ (gEgo x:) 5) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
				(else
					(if (== (gEgo cel:) 0)
						(Splash1
							posn: (- (gEgo x:) 2) (+ (gEgo y:) 1)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 4)
						(Splash2
							posn: (- (gEgo x:) 2) (+ (gEgo y:) 1)
							cel: 0
							show:
							setCycle: End
						)
					)
				)
			)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 985)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(cond
			((== newRoomNumber 31)
				(gConMusic stop:)
				(gEgo setLoop: -1)
			)
			((and (== gAct 1) (< gClarenceWilburState 3))
				(= gClarenceWilburState 3)
			)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room<!*]')
							(Print 10 0) ; "You are standing at the northwest corner of the house right outside the Colonel's study."
						)
						((Said '/fence')
							(Print 10 1) ; "There is a small fence at the back of the house."
						)
						((Said '/path')
							(Print 10 2) ; "You notice a path behind the house."
						)
						((Said '/stair')
							(Print 10 3) ; "Stone steps lead up to the Colonel's study door."
						)
						((Said '/up')
							(Print 10 4) ; "You look upwards at the second-story windows of Wilbur's guest room."
						)
					)
				)
				((Said 'climb/fence')
					(Print 10 5) ; "You don't need to do that. There's nothing there."
				)
			)
		)
	)
)

(instance Argue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if
					(and
						(== gPrevRoomNum 31)
						(or (!= (gEgo x:) 118) (!= (gEgo y:) 144))
					)
					(= state -1)
				)
				(= cycles 1)
			)
			(1
				(User canControl: 0 canInput: 0)
				(cond
					((not (& (gEgo onControl: 1) $0001))
						(= state 0)
					)
					((not global216)
						(= state 0)
					)
					((not (& gMustDos $0001))
						(|= gMustDos $0001)
						(self setScript: (ScriptID 406 0)) ; Clock
						(= state 0)
					)
					((self script:)
						(= state 0)
					)
				)
				(= cycles 3)
			)
			(2
				(Wilbur loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(Wilbur loop: 2 setCycle: Fwd)
				(WHead setCycle: Fwd)
				(Print 10 6 #at 25 145 #dispose) ; "I can't go on with this any longer! I must tell him about..."
				(= seconds 5)
			)
			(4
				(Wilbur loop: 0 cel: 3 setCycle: Beg)
				(Clarence loop: 1 setCycle: End self)
				(WHead setCycle: 0)
			)
			(5
				(cls)
				(Wilbur setCycle: 0)
				(Clarence loop: 3 setCycle: Fwd)
				(CHead setCycle: Fwd)
				(Print 10 7 #at 55 145 #dispose) ; "Quiet!"
				(= seconds 2)
			)
			(6
				(cls)
				(Print 10 8 #at 25 145 #dispose) ; "Let's go into the house to continue this discussion."
				(Clarence loop: 1 cel: 2 setCycle: Beg)
				(= seconds 1)
			)
			(7
				(CHead hide:)
				(WHead hide:)
				(Clarence
					view: 400
					setCycle: Walk
					setMotion: MoveTo 135 135 self
				)
				(Wilbur view: 420 setCycle: Walk setMotion: MoveTo 135 135)
			)
			(8
				(cls)
				(Clarence setMotion: MoveTo 150 122 self)
				(Wilbur setMotion: MoveTo 150 123 self)
			)
			(9
				(= gClarenceWilburState 1)
				(Door setCycle: End self)
				(myMusic number: 43 loop: 1 priority: 5 play:)
			)
			(10
				(Clarence illegalBits: 0 setMotion: MoveTo 190 117)
				(Wilbur illegalBits: 0 setMotion: MoveTo 177 119 self)
			)
			(11
				(Door setCycle: Beg self)
				(myMusic number: 44 loop: 1 priority: 5 play:)
			)
			(12
				(Door stopUpd:)
				(= cycles 1)
			)
			(13
				(HandsOn)
				(= seconds 20)
			)
			(14
				(== gClarenceWilburState 3)
				(client setScript: 0)
			)
		)
	)
)

(instance comeDown of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 118 144 self)
				(Door cycleSpeed: 1 setCycle: Beg)
				(myMusic number: 44 loop: 1 priority: 5 play:)
			)
			(2
				(if (not local3)
					(HandsOn)
				)
				(if (== global179 gCurRoomNum)
					(if (!= gAct 3)
						(Door stopUpd:)
					)
				else
					(Door stopUpd:)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance myDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gEgo setLoop: 0 setMotion: MoveTo 135 134 self)
			)
			(1
				(gEgo setMotion: MoveTo 146 120 self)
			)
			(2
				(gEgo setMotion: 0 illegalBits: -32768)
				(Door cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(myMusic number: 43 loop: 1 priority: 5 play:)
			)
			(3
				(gEgo
					ignoreActors: 1
					setMotion: MoveTo (+ (gEgo x:) 50) 121
				)
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 123
		x 168
		view 117
		loop 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance Splash1 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance Splash2 of Prop
	(properties
		view 1
		loop 6
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 31
		nsLeft 98
		nsBottom 96
		nsRight 120
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Window2 of RFeature
	(properties
		nsTop 56
		nsLeft 195
		nsBottom 138
		nsRight 219
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Window3 of RFeature
	(properties
		nsTop 59
		nsLeft 269
		nsBottom 138
		nsRight 295
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Wilbur of Act
	(properties
		y 142
		x 64
		view 425
	)
)

(instance Clarence of Act
	(properties
		y 142
		x 97
		view 402
		loop 1
	)
)

(instance CHead of Prop
	(properties
		y 102
		x 95
		view 404
		loop 2
	)
)

(instance WHead of Prop
	(properties
		y 103
		x 62
		view 404
		loop 4
	)
)

(instance myMusic of Sound
	(properties)
)

