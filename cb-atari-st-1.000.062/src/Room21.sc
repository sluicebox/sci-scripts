;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room21 0
)

(synonyms
	(path walk)
	(lamp ignite)
)

(local
	local0
)

(instance Room21 of Rm
	(properties
		picture 21
	)

	(method (init)
		(= south 27)
		(= east 22)
		(= north 10)
		(= horizon 86)
		(super init:)
		(self setRegions: 206 setFeatures: House BHouse) ; houseOReg
		(if gDetailLevel
			(light1 init: setScript: showers)
			(light2 init:)
			(light3 init:)
		)
		(gAddToPics add: House doit:)
		(if (== gAct 1)
			(self setRegions: 381) ; walkabout
		)
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
		(switch gPrevRoomNum
			(10
				(gEgo posn: 280 129)
			)
			(14
				(gEgo posn: 89 129)
			)
			(15
				(gEgo posn: 313 129)
			)
			(20
				(gEgo posn: 7 186)
			)
			(22
				(if (> (gEgo y:) 150)
					(gEgo posn: 310 172)
				)
			)
			(27
				(gEgo posn: 183 188)
			)
			(else
				(gEgo posn: 7 150)
			)
		)
		(gEgo illegalBits: -32768 view: 0 init:)
	)

	(method (doit)
		(if (== (gEgo edgeHit:) EDGE_LEFT)
			(if (< (gEgo y:) 166)
				(gCurRoom newRoom: 13)
			else
				(gCurRoom newRoom: 20)
			)
		)
		(if (IsFirstTimeInRoom)
			(Print 21 0) ; "You are standing at the west side of the circular gravel driveway leading to the old plantation house."
		)
		(if (& (gEgo onControl: 0) $0008)
			(gCurRoom newRoom: 14)
		)
		(if (& (gEgo onControl: 0) $0004)
			(gCurRoom newRoom: 10)
		)
		(if (& (gEgo onControl: 0) $0010)
			(gCurRoom newRoom: 13)
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((Said '[<around,at][/room]')
					(Print 21 0) ; "You are standing at the west side of the circular gravel driveway leading to the old plantation house."
				)
				((Said '/path')
					(Print 21 1) ; "A stone path leads toward the middle of the circular driveway."
				)
				((Said '/monument')
					(Print 21 2) ; "You can barely see it from here."
				)
				((Said '/lamp[<gallery]')
					(event claimed: 1)
					(DoLook {door})
				)
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
				(light2 setCycle: Fwd)
				(light3 setCycle: Fwd)
				(= cycles 7)
			)
			(2
				(light1 setCycle: End)
				(light2 setCycle: End)
				(light3 setCycle: End self)
			)
			(3
				(Thunder loop: 1 play: self)
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

(instance light1 of Prop
	(properties
		y 21
		x 252
		view 121
		loop 1
		cel 1
	)
)

(instance light2 of Prop
	(properties
		y 22
		x 293
		view 121
		loop 2
		cel 1
	)
)

(instance light3 of Prop
	(properties
		y 22
		x 269
		view 121
		loop 3
		cel 1
	)
)

(instance Thunder of Sound
	(properties
		number 17
		loop 0
	)
)

(instance House of RPicView
	(properties
		y 87
		x 108
		view 121
	)

	(method (handleEvent)
		(if
			(or
				(Said 'look/cabin<little')
				(Said 'look/playhouse')
				(Said 'look/cabin<play')
			)
			(Print 21 3) ; "You see an old playhouse in the distance to the north."
		)
	)
)

(instance BHouse of RFeature
	(properties
		nsTop 23
		nsLeft 275
		nsBottom 98
		nsRight 319
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(DoLook {house})
		)
	)
)

