;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
(include sci.sh)
(use Main)
(use Interface)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm056 0
)

(local
	[local0 2]
	local2
	local3
	[local4 7] = [3 0 2 2 1 3 3]
)

(instance rm056 of Rm
	(properties
		picture 56
		north 57
		south 55
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 836 loop: -1 playBed:)
		(HandsOff)
		(= global103 0)
		(gEgo offset: 3 illegalBits: $0800 init:)
		(switch gPrevRoomNum
			(north
				(gCurRoom setScript: enterNorth)
			)
			(else
				(gEgo setStep: 3 2 posn: 156 186 0 setPri: 14)
				(gCurRoom setScript: toPlatform)
			)
		)
		(gAddToPics add: cup doit:)
		(self setFeatures: KDoor stairs cup shelves supplyRoom)
		(if (== ((gInventory at: 24) owner:) 56) ; Bag_of_Peas
			(bag init:)
		)
		(if (== global81 3)
			(fire setCycle: Fwd init:)
		)
		(cupboard init:)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $4000)
				(gGlobalSound fade:)
				(gCurRoom newRoom: 57)
			)
			((& (gEgo onControl: 0) $2000)
				(HandsOff)
				(self setScript: toStair)
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
		(gEgo illegalBits: $8000)
		(super dispose:)
	)
)

(instance toPlatform of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 157 157 self)
			)
			(1
				(gEgo
					looper: duneLooper
					setMotion: MoveTo (gEgo x:) 161 self
					setPri: -1
					setLoop: 3
					yStep: 1
				)
			)
			(2
				(gEgo setLoop: -1)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance toStair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					looper: MyLooper
					setMotion: MoveTo (gEgo x:) 161 self
					setPri: 14
					yStep: 2
				)
			)
			(1
				(gEgo setStep: 3 2 setMotion: MoveTo 155 171 self)
			)
			(2
				(gEgo setMotion: MoveTo 157 189 self)
			)
			(3
				(gGlobalSound fade:)
				(HandsOn)
				(gCurRoom newRoom: 55)
			)
		)
	)
)

(instance enterNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 156 171
					setLoop: 2
					setMotion: MoveTo 156 159 self
				)
			)
			(1
				(HandsOn)
				(gEgo looper: duneLooper setStep: 3 1)
				(client setScript: 0)
			)
		)
	)
)

(instance duneLooper of Script
	(properties)

	(method (doit)
		(if (!= local3 (- 164 (- ((gEgo mover:) y:) 164)))
			(= local3 ((gEgo mover:) y:))
			((gEgo mover:) y: (- 164 (- ((gEgo mover:) y:) 164)))
		)
		(gEgo setLoop: [local4 (/ (gEgo heading:) 60)])
	)
)

(instance openCupboard of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 69 162 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 680
					setLoop: 3
					cel: 0
					cycleSpeed: 1
					setCycle: CT 2 1 self
				)
			)
			(2
				(gEgo setCycle: End)
				(cupboard setCycle: End self)
				(gGlobalSound3 number: 796 loop: 1 vol: 127 play:)
			)
			(3
				(PrintDC 56 0) ; "Inside the cupboard, Graham's eyes fall upon a bag of dried peas."
				(bCel1 init:)
				(bCel2 init:)
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					loop: 7
					cycleSpeed: 0
					setCycle: Walk
				)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getPeas of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 70 161 self)
			)
			(1
				(PrintDC 56 1) ; "Reaching into the open cupboard, Graham retrieves the bag of dried peas."
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 680
					setLoop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(gEgo get: 24) ; Bag_of_Peas
				(SetScore 2)
				(-- local2)
				(bag dispose:)
				(bCel2 dispose:)
			)
			(2
				(cupboard setCycle: Beg self)
				(gGlobalSound3 number: 795 loop: 1 vol: 127 play:)
			)
			(3
				(bCel1 dispose:)
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					loop: 7
					cycleSpeed: 0
					setCycle: Walk
				)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance supplyRoom of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 56 2) ; "A set of wide steps leads up from the labyrinth door to a pantry off the wizard's kitchen"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance KDoor of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0400))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 56 3) ; "Graham can see into the kitchen through the open pantry door."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance shelves of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0008))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 56 4) ; "Graham scans the various items lining the open shelves but doesn't see anything of use."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 56 5) ; "Graham examines the contents of the shelves but doesn't see anything of interest."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance stairs of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(and
					(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
					(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
				)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 56 6) ; "A set of wide steps leads up from the labyrinth door to a pantry off the wizard's kitchen."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cupboard of Prop
	(properties
		y 142
		x 51
		view 680
		signal 1
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 56 7) ; "A cupboard in the corner of the pantry catches Graham's interest."
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((!= ((gInventory at: 24) owner:) 56) ; Bag_of_Peas
							(PrintDC 56 8) ; "There is nothing more of interest in the cupboard."
						)
						((not local2)
							(++ local2)
							(HandsOff)
							(gCurRoom setScript: openCupboard)
						)
						((== ((gInventory at: 24) owner:) 56) ; Bag_of_Peas
							(PrintDC 56 9) ; "The cupboard is already open."
						)
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bag of Prop
	(properties
		y 125
		x 55
		view 680
		loop 1
		priority 2
		signal 17
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
				(not local2)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 56 10) ; "A bag labeled Peas sits in the cupboard."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getPeas)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cup of RPicView
	(properties
		y 142
		x 51
		view 680
		loop 1
		cel 1
		priority 1
	)
)

(instance fire of Prop
	(properties
		y 156
		x 169
		view 680
		loop 5
		priority 1
		signal 16400
		cycleSpeed 2
	)
)

(instance bCel1 of Prop
	(properties
		y 91
		x 55
		view 680
		loop 4
		priority 1
		signal 17
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 56 11) ; "Graham's eyes fall on a bag of dried peas in the open cupboard."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bCel2 of Prop
	(properties
		y 75
		x 34
		view 680
		loop 4
		cel 1
		priority 2
		signal 17
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 56 7) ; "A cupboard in the corner of the pantry catches Graham's interest."
					(event claimed: 1)
				)
				(3 ; Do
					(if (== ((gInventory at: 24) owner:) 56) ; Bag_of_Peas
						(HandsOff)
						(gCurRoom setScript: getPeas)
					else
						(PrintDC 56 12) ; "There is nothing else of interest in cupboard."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance poly1 of Polygon ; UNUSED
	(properties
		type PBarredAccess
	)
)

