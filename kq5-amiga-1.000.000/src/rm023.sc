;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 23)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm023 0
)

(local
	[local0 4]
	local4
	local5
	local6
	[local7 28] = [109 138 104 155 0 155 0 0 319 0 319 155 158 155 162 141 214 141 239 126 158 120 149 125 140 129 120 133]
)

(instance rm023 of KQ5Room
	(properties
		picture 23
	)

	(method (init)
		(super init:)
		(gGlobalSound number: 42 loop: -1 playBed:)
		(self setFeatures: dresser burner stairs interior addObstacle: poly1)
		(if (IsFlag 76)
			(trunk cel: 3)
		)
		(trunk init:)
		(if (IsFlag 75)
			(drawer cel: 3)
		)
		(drawer init:)
		(if (== ((gInventory at: 1) owner:) 23) ; Key
			(glint init:)
		)
		(gEgo
			view: 0
			illegalBits: $8000
			normal: 1
			setCycle: KQ5SyncWalk
			setLoop: -1
			setStep: 3 2
			posn: 147 210
			init:
		)
		(poly1 points: @local7 size: 14)
		(self setScript: walkInScript)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((& (gEgo onControl: 0) $4000)
				(HandsOff)
				(self setScript: leaveRoomScript)
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

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gGlobalSound fade:)
	)
)

(instance openTrunk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 188 127 self)
			)
			(1
				(if (not (trunk cel:))
					((gEgo head:) hide:)
					(gEgo
						normal: 0
						view: 464
						loop: 0
						cel: 0
						cycleSpeed: 2
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(2
				(if (not (trunk cel:))
					(gEgo loop: 2 cel: 0 setCycle: End self)
					(trunk cycleSpeed: 2 setCycle: End self)
					(gGlobalSound3 number: 124 loop: 1 play: 80)
					(SetFlag 76)
				else
					(+= state 1)
					(self cue:)
				)
			)
			(3 0)
			(4
				(if (== ((gInventory at: 15) owner:) 23) ; Spinning_Wheel
					(wheel init:)
					(PrintDC 23 0 #at 100 140) ; "An intricate spinning wheel is tucked away in the trunk."
				)
				(gEgo
					normal: 1
					view: 0
					loop: 7
					cel: 3
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(5
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getWheel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 188 127 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 464
					loop: 0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(PrintDC 23 1 #at 90 140) ; "Reaching a hand into the trunk, Graham retrieves the small spinning wheel."
				(gEgo loop: 3 cel: 0 setCycle: End self)
			)
			(3
				(wheel dispose:)
				(gEgo get: 15) ; Spinning_Wheel
				(SetScore 2)
				(trunk setCycle: Beg self)
				(gGlobalSound3 number: 124 loop: 1 play: 80)
				(ClearFlag 76)
			)
			(4
				(gEgo
					normal: 1
					view: 0
					loop: 7
					cel: 3
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(5
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance openDrawer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 145 131 self)
			)
			(1
				(if (not (drawer cel:))
					((gEgo head:) hide:)
					(gEgo
						normal: 0
						view: 464
						loop: 4
						cel: 0
						cycleSpeed: 2
						setCycle: End self
					)
					(drawer setCycle: End self)
					(gGlobalSound3 number: 793 loop: 1 play:)
					(SetFlag 75)
				else
					(+= state 1)
					(self cue:)
				)
			)
			(2 0)
			(3
				(if (== ((gInventory at: 13) owner:) 23) ; Pouch
					(pouch init:)
					(PrintDC 23 2 #at 20 140) ; "A small pouch is tucked away in the drawer."
				)
				(gEgo
					normal: 1
					view: 0
					loop: 7
					cel: 1
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getPouch of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 145 131 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 464
					loop: 4
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(PrintDC 23 3 #at 20 140) ; "Graham reaches into the drawer and removes the leather pouch."
				(gEgo loop: 5 cel: 0 setCycle: End self)
			)
			(3
				(pouch dispose:)
				(gEgo get: 13) ; Pouch
				(SetScore 2)
				(drawer setCycle: Beg self)
				(gGlobalSound3 number: 793 loop: 1 play:)
				(ClearFlag 75)
			)
			(4
				(gEgo
					normal: 1
					view: 0
					loop: 7
					cel: 1
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(5
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getKey of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 181 134 self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 464
					loop: 8
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(PrintDC 23 4 #at 80 150) ; "What's this? Why, it's a little key."
				(glint dispose:)
				(SetScore 2)
				(gEgo get: 1 setCycle: Beg self) ; Key
			)
			(3
				(gEgo
					normal: 1
					view: 0
					loop: 11
					cel: 6
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				((gEgo head:) show:)
				(= cycles 3)
			)
			(4
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance walkInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 152 143 self)
			)
			(1
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance leaveRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 142 200 self)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 22)
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
				(not (& (OnControl CONTROL (event x:) (event y:)) $0040))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 23 5) ; "A set of narrow stone steps wind precariously upward in the back of the room."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 23 6) ; "The winding steps are much too narrow for Graham to fit through."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance dresser of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0010))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 23 7) ; "Graham spies a crude drawer built into the trunk of a tree which is poking awkwardly through the house."
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((and (not local5) (== ((gInventory at: 13) owner:) 23)) ; Pouch
							(++ local5)
							(HandsOff)
							(gCurRoom setScript: openDrawer)
							(event claimed: 1)
						)
						((== ((gInventory at: 13) owner:) 23) ; Pouch
							(HandsOff)
							(gCurRoom setScript: getPouch)
							(event claimed: 1)
						)
						(else
							(PrintDC 23 8) ; "There is nothing else inside the drawer."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance interior of RFeature
	(properties
		nsTop 23
		nsLeft 51
		nsBottom 160
		nsRight 269
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
					(PrintDC 23 9) ; "The old witch's house has been crudely fashioned from an old tree trunk and salvaged stone. It has a cold, creepy feeling to it and Graham would just as soon leave."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance trunk of Prop
	(properties
		x 199
		y 120
		view 464
		loop 1
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
					(PrintDC 23 10) ; "Graham sees an intricate trunk tucked under a large crack in the wall which seems to serve as a window."
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((and (not local4) (== ((gInventory at: 15) owner:) 23)) ; Spinning_Wheel
							(++ local4)
							(HandsOff)
							(gCurRoom setScript: openTrunk)
							(event claimed: 1)
						)
						((== ((gInventory at: 15) owner:) 23) ; Spinning_Wheel
							(HandsOff)
							(gCurRoom setScript: getWheel)
							(event claimed: 1)
						)
						(else
							(PrintDC 23 11) ; "The trunk is now empty."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance wheel of Prop
	(properties
		x 229
		y 88
		view 462
		cel 1
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
					(PrintDC 23 0 #at 120 140) ; "An intricate spinning wheel is tucked away in the trunk."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getWheel)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance burner of RFeature
	(properties
		nsTop 75
		nsLeft 188
		nsBottom 90
		nsRight 199
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
					(if (== ((gInventory at: 1) owner:) 23) ; Key
						(PrintDC 23 12) ; "An interesting incense burner hangs from a protruding tree branch. Occasionally, from within it, a tiny glint winks."
					else
						(PrintDC 23 13) ; "An interesting incense burner hangs from a protruding tree branch."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (== ((gInventory at: 1) owner:) 23) ; Key
						(HandsOff)
						(gCurRoom setScript: getKey)
						(event claimed: 1)
					else
						(PrintDC 23 14) ; "The incense burner is now empty."
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance drawer of Prop
	(properties
		x 129
		y 108
		view 464
		loop 7
		cycleSpeed 2
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
					(PrintDC 23 7) ; "Graham spies a crude drawer built into the trunk of a tree which is poking awkwardly through the house."
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((== (drawer cel:) 0)
							(HandsOff)
							(gCurRoom setScript: openDrawer)
							(event claimed: 1)
						)
						((== ((gInventory at: 13) owner:) 23) ; Pouch
							(HandsOff)
							(gCurRoom setScript: getPouch)
							(event claimed: 1)
						)
						((not local5)
							(PrintDC 23 8) ; "There is nothing else inside the drawer."
							(++ local5)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance pouch of Prop
	(properties
		x 129
		y 88
		view 462
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
					(PrintDC 23 2 #at 20 140) ; "A small pouch is tucked away in the drawer."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getPouch)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 192
		y 83
		view 462
		loop 1
		signal 16384
	)

	(method (doit)
		(super doit:)
		(cond
			(local6
				(-- local6)
			)
			((not (Random 0 40))
				(self setCycle: Beg)
				(= local6 (Random 50 150))
			)
		)
	)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

