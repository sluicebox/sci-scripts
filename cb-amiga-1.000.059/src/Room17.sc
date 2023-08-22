;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
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
	Room17 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance Room17 of Rm
	(properties
		picture 17
	)

	(method (init)
		(super init:)
		(= local4 (IsFirstTimeInRoom))
		(self setRegions: 206 setFeatures: Window1 Window2 Window3 Window4) ; houseOReg
		(LoadMany rsSOUND 43 44)
		(= south 22)
		(= west 16)
		(= north 12)
		(= horizon 86)
		(= local0 0)
		(Door
			cel: (if (== gPrevRoomNum 38) 3 else 0)
			setPri: 6
			ignoreActors: 1
			init:
			stopUpd:
		)
		(if (== gAct 1)
			(self setRegions: 381) ; walkabout
		)
		(switch gPrevRoomNum
			(16
				(if (== global102 1)
					(gEgo posn: 1 147)
				else
					(gEgo posn: 1 186)
				)
			)
			(38
				(gEgo posn: 190 115)
				(if (not (IsFirstTimeInRoom))
					(gEgo setMotion: MoveTo 216 141)
					(= local2 1)
					(Door setCycle: Beg)
					(User canControl: 0)
					(myMusic number: 44 loop: 1 priority: 5 play:)
				)
			)
			(23
				(gEgo posn: 310 188)
			)
			(12
				(gEgo posn: 310 140)
			)
		)
		(gEgo view: 0 illegalBits: -32766 init:)
	)

	(method (doit)
		(if local4
			(Print 17 0) ; "This is the southeast corner of the mansion right outside the parlor."
			(if (== gPrevRoomNum 38)
				(gEgo setMotion: MoveTo 216 141)
				(= local2 1)
				(Door setCycle: Beg)
				(User canControl: 0)
				(myMusic number: 44 loop: 1 priority: 5 play:)
			)
			(= local4 0)
		)
		(if (and (not local3) (== gPrevRoomNum 38) (== (Door cel:) 0))
			(= local3 1)
			(Door stopUpd:)
		)
		(if (and local2 (& (gEgo onControl: 1) $0001))
			(User canControl: 1)
			(gEgo illegalBits: -32768)
			(= local2 0)
		)
		(if
			(or
				(& (gEgo onControl: 0) $0002)
				(& (gEgo onControl: 0) $0010)
			)
			(gEgo setPri: 7)
		else
			(gEgo setPri: -1)
		)
		(if (< (gEgo y:) 160)
			(= global102 1)
		else
			(= global102 0)
		)
		(if (== (gEgo edgeHit:) EDGE_RIGHT)
			(if (< (gEgo y:) 148)
				(gCurRoom newRoom: 12)
			else
				(gCurRoom newRoom: 18)
			)
		)
		(if (& (gEgo onControl: 1) $0002)
			(gCurRoom newRoom: 38)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0008)
				(or (== (gEgo loop:) 3) (== (gEgo loop:) 1))
				(== local2 0)
			)
			(= local2 1)
			(User canControl: 0)
			(gEgo illegalBits: 0 setMotion: MoveTo 69 154)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0004)
				(or (== (gEgo loop:) 2) (== (gEgo loop:) 0))
				(== local2 0)
			)
			(= local2 1)
			(User canControl: 0)
			(gEgo illegalBits: 0 setMotion: MoveTo 98 181)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0010)
				(not local1)
				(or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
			)
			(= local1 1)
			(self setScript: myDoor2)
		)
		(super doit:)
	)

	(method (dispose)
		(DisposeScript 200)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 38)
			(gConMusic stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '[<around,at][/room]')
					(Print 17 0) ; "This is the southeast corner of the mansion right outside the parlor."
				)
				((Said '/stair')
					(Print 17 1) ; "Stone steps lead up to the parlor door and to the front gallery."
				)
				((Said '/up')
					(Print 17 2) ; "You look upwards at the second-story windows of Rudy and Clarence's guest room."
				)
			)
		)
	)
)

(instance myDoor2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(User canControl: 0 canInput: 0)
				(gEgo setMotion: MoveTo 199 128 self)
			)
			(1
				(gEgo setMotion: MoveTo 189 114 self)
			)
			(2
				(gEgo setMotion: 0 illegalBits: -32768)
				(Door cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(myMusic number: 43 loop: 1 priority: 5 play:)
			)
			(3
				(gEgo setMotion: MoveTo (- (gEgo x:) 50) (gEgo y:))
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 119
		x 172
		view 117
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {door})
		)
	)
)

(instance Window1 of RFeature
	(properties
		nsTop 53
		nsLeft 43
		nsBottom 139
		nsRight 69
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
		nsTop 52
		nsLeft 119
		nsBottom 121
		nsRight 142
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
		nsTop 27
		nsLeft 216
		nsBottom 89
		nsRight 234
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance Window4 of RFeature
	(properties
		nsTop 21
		nsLeft 278
		nsBottom 89
		nsRight 302
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {window})
		)
	)
)

(instance myMusic of Sound
	(properties)
)

