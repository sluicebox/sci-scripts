;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use Door)
(use KQ5Room)
(use Language)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm028 0
)

(local
	[local0 14] = [0 189 0 108 107 130 72 147 123 147 145 153 145 189]
	[local14 12] = [108 128 0 104 0 0 319 0 235 132 162 127]
	[local26 12] = [319 189 174 189 174 153 254 153 237 134 319 4]
)

(instance rm028 of KQ5Room
	(properties
		picture 28
	)

	(method (init)
		(super init:)
		(HandsOn)
		(gAddToPics add: smokeOut1 smokeOut2 doit:)
		(switch gPrevRoomNum
			(27
				(gEgo view: 0 setStep: 3 2 posn: 107 135)
			)
			(85
				(gEgo posn: 228 137)
			)
			(else
				(gEgo posn: 160 150)
			)
		)
		(RDoor init: stopUpd:)
		(LDoor init: stopUpd:)
		(cupboard init: stopUpd:)
		(self setFeatures: interior addObstacle: poly1 poly2 poly3)
		(gEgo init:)
		(poly1 points: @local0 size: 7)
		(poly2 points: @local14 size: 6)
		(poly3 points: @local26 size: 6)
		(gGlobalSound number: 119 loop: -1 play: 60)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(script
				(script doit:)
			)
			((& (= temp1 (gEgo onControl: 0)) $2000)
				(HandsOff)
				(gGlobalSound fade:)
				(self setScript: enter27)
			)
			((& temp1 $0008)
				(gGlobalSound fade:)
				(gCurRoom newRoom: 86)
			)
			((& temp1 $1000)
				(HandsOff)
				(self setScript: enterBar)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance enterBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 227 132 self)
			)
			(1
				(RDoor cycleSpeed: 2 setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 253 131 self)
			)
			(3
				(gCurRoom newRoom: 85)
			)
		)
	)
)

(instance enter27 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (& (gEgo onControl: 0) $2000)
					(= cycles 1)
				else
					(gEgo setMotion: PolyPath 112 127 self)
				)
			)
			(1
				(if (not (IsFlag 79))
					(SetFlag 79)
					(PrintDC 28 0) ; "Graham unlocks the kitchen door before going outside."
				)
				(= cycles 1)
			)
			(2
				(LDoor cycleSpeed: 2 setCycle: End self)
			)
			(3
				(= seconds 3)
			)
			(4
				(gEgo
					setPri: 8
					cycleSpeed: 0
					moveSpeed: 0
					setMotion: MoveTo 90 125 self
				)
			)
			(5
				(gEgo setPri: -1)
				(gCurRoom newRoom: 27)
			)
		)
	)
)

(instance openCup of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== ((gInventory at: 19) owner:) 28) ; Leg_of_Lamb
					(gEgo setMotion: MoveTo 185 130 self)
				else
					(PrintDC 28 1 #at 10 10) ; "There is nothing else of interest inside the cupboard."
					(HandsOn)
					(client setScript: 0)
				)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 470
					loop: 4
					cel: 0
					illegalBits: 0
					posn: 187 130
					cycleSpeed: 2
					setCycle: CT 2 1 self
				)
			)
			(2
				(gGlobalSound3 number: 796 loop: 1 play:)
				(cupboard setCycle: End self)
			)
			(3
				(gEgo setCycle: CT 4 1 self)
			)
			(4
				(User canInput: 1)
				(lambInset init: stopUpd:)
				(PrintDC 28 2 #at 10 10) ; "Inside the cupboard, Graham sees a large, juicy leg of lamb."
				(gEgo
					normal: 1
					view: 0
					loop: 11
					cel: 2
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					posn: 185 130
					illegalBits: -32768
				)
				((gEgo head:) show:)
				(cupboard stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getLamb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 185 130 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 470
					loop: 4
					cel: 0
					illegalBits: 0
					posn: 187 130
					cycleSpeed: 2
					setCycle: CT 4 1 self
				)
			)
			(2
				(PrintDC 28 3 #at 10 10) ; "Reaching into the open cupboard, Graham pulls out the savory leg of lamb."
				(lambInset dispose:)
				(gEgo get: 19) ; Leg_of_Lamb
				(SetScore 2)
				(gEgo cel: 0 setCycle: CT 2 1 self)
			)
			(3
				(gGlobalSound3 number: 795 loop: 1 play:)
				(cupboard setCycle: Beg self)
				(gEgo setCycle: CT 4 1)
			)
			(4
				(gEgo
					normal: 1
					view: 0
					loop: 11
					cel: 2
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					posn: 185 130
					illegalBits: -32768
				)
				((gEgo head:) show:)
				(cupboard stopUpd:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance interior of RFeature
	(properties
		nsTop 35
		nsLeft 65
		nsBottom 155
		nsRight 253
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 28 4) ; "Graham looks around the inn's kitchen and finds it rather sparse and untidy."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance LDoor of Door
	(properties
		x 101
		y 123
		view 470
		loop 2
		priority 2
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 28 5) ; "It appears that this door leads to the outside."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: enter27)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance RDoor of Door
	(properties
		x 235
		y 114
		view 470
		loop 1
		priority 2
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 28 6) ; "The sound of several men talking and laughing floats through this door."
					(event claimed: 1)
				)
				(3 ; Do
					(gCurRoom setScript: enterBar)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cupboard of Prop
	(properties
		x 200
		y 107
		view 470
		priority 2
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 28 7) ; "At the back of the room, Graham spies a large kitchen cupboard."
					(event claimed: 1)
				)
				(3 ; Do
					(if (== (cupboard cel:) 0)
						(HandsOff)
						(gCurRoom setScript: openCup)
					else
						(gCurRoom setScript: getLamb)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance lambInset of Prop
	(properties
		x 260
		y 90
		view 470
		loop 3
		priority 15
		signal 16400
	)

	(method (doit)
		(super doit:)
		(if (gEgo mover:)
			(self dispose:)
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 28 2) ; "Inside the cupboard, Graham sees a large, juicy leg of lamb."
					(event claimed: 1)
				)
				(3 ; Do
					(gCurRoom setScript: getLamb)
					(self dispose:)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance smokeOut1 of PicView
	(properties
		x 187
		y 3
		view 292
		loop 3
	)

	(method (init)
		(= view (LangSwitch 292 113))
		(super init: &rest)
	)
)

(instance smokeOut2 of PicView
	(properties
		x 294
		y 7
		view 292
		loop 4
	)

	(method (init)
		(= view (LangSwitch 292 113))
		(super init: &rest)
	)
)

