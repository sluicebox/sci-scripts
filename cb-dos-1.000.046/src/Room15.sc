;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15)
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
	Room15 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
)

(instance Room15 of Rm
	(properties
		picture 15
	)

	(method (init)
		(= south 22)
		(= west 10)
		(= east 16)
		(= north 10)
		(= horizon 86)
		(= local0 0)
		(super init:)
		(= local5 (IsFirstTimeInRoom))
		(self setRegions: 206 setFeatures: Window1 Window2 Window3) ; houseOReg
		(LoadMany rsSOUND 43 44)
		(if
			(and
				(>= gAct 1)
				(not (& gCorpseFlags $0001)) ; Gertie
				(not (& gCorpseFlags $0040)) ; Lillian
			)
			(++ local1)
			(self setRegions: 235) ; Dgert
		)
		(Door
			cel: (if (== gPrevRoomNum 36) 3 else 0)
			ignoreActors: 1
			setPri: 6
			init:
			stopUpd:
		)
		(if gDetailLevel
			(Splash1 ignoreActors: 1 init: hide:)
			(Splash2 ignoreActors: 1 init: hide:)
		)
		(if (and (>= gAct 2) (== global113 gCurRoomNum))
			(self setRegions: 202) ; EthelDrunk
		)
		(if
			(and
				(== global114 gCurRoomNum)
				(or
					(== gAct 3)
					(and (== gAct 6) (not (& gMustDos $0002)))
				)
			)
			(self setRegions: 281) ; rudywand
		)
		(switch gPrevRoomNum
			(21
				(gEgo posn: 93 187)
			)
			(10
				(gEgo posn: 8 155)
			)
			(36
				(gEgo posn: 132 116)
				(if (not local5)
					(= local4 1)
					(self setScript: comeDown)
				)
			)
			(22
				(gEgo posn: 160 188)
			)
			(else
				(if (== global102 1)
					(gEgo posn: 317 152)
				else
					(gEgo posn: 317 185)
				)
			)
		)
		(gEgo view: 0 illegalBits: -32766 init:)
	)

	(method (doit)
		(if local5
			(Print 15 0) ; "This is the southwest corner of the mansion right outside the billiard room."
			(if (== gPrevRoomNum 36)
				(= local4 1)
				(self setScript: comeDown)
			)
			(= local5 0)
		)
		(if (and local4 (& (gEgo onControl: 1) $0001))
			(User canControl: 1)
			(gEgo illegalBits: -32768)
			(= local4 0)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0020)
				(or (== (gEgo loop:) 3) (== (gEgo loop:) 0))
			)
			(User canControl: 0)
			(= local4 1)
			(gEgo illegalBits: 0 setMotion: MoveTo 253 153)
		)
		(if
			(and
				(& (gEgo onControl: 1) $0080)
				(or (== (gEgo loop:) 2) (== (gEgo loop:) 1))
			)
			(User canControl: 0)
			(= local4 1)
			(gEgo illegalBits: 0 setMotion: MoveTo 225 186)
		)
		(if
			(and
				(& (gEgo onControl: 0) $0010)
				(not local2)
				(or (== (gEgo loop:) 3) (== (gEgo loop:) 0))
			)
			(= local2 1)
			(self setScript: myDoor)
		)
		(if (< (gEgo y:) 162)
			(= global102 1)
		else
			(= global102 0)
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
		(if (& (gEgo onControl: 1) $0002)
			(gCurRoom newRoom: 36)
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
							posn: (- (gEgo x:) 2) (gEgo y:)
							cel: 0
							show:
							setCycle: End
						)
					)
					(if (== (gEgo cel:) 4)
						(Splash2
							posn: (- (gEgo x:) 2) (gEgo y:)
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
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 36)
			(gConMusic stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look,find/gertie,body')
					(if local1
						(event claimed: 0)
					else
						(Print 15 1) ; "She's not around here!"
					)
				)
				((Said 'look>')
					(cond
						((Said '[<around,at][/room<!*]')
							(Print 15 0) ; "This is the southwest corner of the mansion right outside the billiard room."
						)
						((Said '/stair')
							(Print 15 2) ; "Stone steps lead up to the billiard room door and to the front gallery."
						)
						((Said '/up')
							(Print 15 3) ; "You look upwards at the second-story windows of Gertie and Gloria's guest room."
						)
					)
				)
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
				(gEgo setMotion: MoveTo 119 131 self)
			)
			(1
				(gEgo setMotion: MoveTo 130 117 self)
			)
			(2
				(gEgo setMotion: 0 illegalBits: -32768)
				(Door cycleSpeed: 1 ignoreActors: 1 setCycle: End self)
				(myMusic number: 43 loop: 1 priority: 5 play:)
			)
			(3
				(gEgo setMotion: MoveTo (+ (gEgo x:) 50) (gEgo y:))
			)
		)
	)
)

(instance comeDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo 108 148 self)
				(Door cycleSpeed: 1 setCycle: Beg)
				(myMusic number: 44 loop: 1 priority: 5 play:)
			)
			(2
				(HandsOn)
				(Door cycleSpeed: 0 stopUpd:)
				(client setScript: 0)
			)
		)
	)
)

(instance Door of Prop
	(properties
		y 118
		x 148
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
		nsTop 20
		nsLeft 16
		nsBottom 87
		nsRight 39
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
		nsLeft 175
		nsBottom 129
		nsRight 199
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
		nsTop 54
		nsLeft 249
		nsBottom 135
		nsRight 275
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

