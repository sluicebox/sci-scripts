;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use Count)
(use Sort)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm021 0
)

(local
	local0
	local1
	local2
	[local3 32] = [0 135 95 134 162 129 220 130 239 152 210 166 139 165 116 153 167 139 187 132 54 140 81 146 72 168 15 164 81 189 0 189]
	[local35 24] = [0 114 221 111 251 121 242 134 263 155 303 155 298 186 190 186 190 189 319 189 319 0 0 0]
	[local59 64] = [94 189 55 177 77 160 72 153 78 147 40 139 41 135 70 139 156 130 183 122 179 107 146 95 139 106 104 111 121 84 157 84 202 110 193 130 140 142 121 157 178 164 241 155 223 132 215 107 233 107 268 153 308 179 194 189 319 189 319 0 0 0 0 189]
)

(instance rm021 of Rm
	(properties
		picture 21
		south 20
		west 22
	)

	(method (init)
		(super init:)
		(switch gPrevRoomNum
			(south
				(gEgo posn: 142 187)
				(self obstacles: polyListFront)
			)
			(west
				(gEgo setPri: 8 posn: 5 129)
				(self obstacles: polyListBack)
				(= local0 1)
			)
			(208 ; releaseGenie
				(gEgo posn: global110 global111 view: 0)
				(NormalEgo 0 0)
				(self obstacles: polyListFront)
			)
			(else
				(gEgo posn: 160 175 view: 0)
				(NormalEgo 0 0)
				(self obstacles: polyListFront)
			)
		)
		(Load rsVIEW 100)
		(door init:)
		(if (IsFlag 74)
			(door hide:)
		)
		(self setFeatures: path21 tree setRegions: 200 551) ; witchRegion, toadRegion
		(gEgo view: 0 offset: 3 setStep: 3 2 init:)
		(poly1 points: @local3 size: 16)
		(poly2 points: @local35 size: 12)
		(poly3 points: @local59 size: 32)
		(polyListBack add: poly1 poly2)
		(polyListFront add: poly3)
	)

	(method (doit &tmp temp0)
		(cond
			((== (gCurRoom script:) falling)
				(script doit:)
			)
			((& (gEgo onControl: 0) $0200)
				(gEgo setPri: 8)
				(gCurRoom obstacles: polyListBack)
				(= local0 1)
			)
			((& (gEgo onControl: 0) $0400)
				(gEgo setPri: -1)
				(gCurRoom obstacles: polyListFront)
				(= local0 0)
			)
			((and (not local0) (& (gEgo onControl: 1) $0002))
				(gEgo setPri: 10)
			)
			((and (not local0) (& (gEgo onControl: 1) $0010))
				(gEgo setPri: -1)
			)
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gEgo setPri: -1)
				((ScriptID 200 1) register: temp0) ; poofOutScript
				(self setScript: (ScriptID 200 1) 0 (gEgo edgeHit:)) ; poofOutScript
			)
			((and (== local0 0) (& (gEgo onControl: 0) $0080))
				(HandsOff)
				(self setScript: falling)
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
		(polyListFront dispose:)
		(polyListBack dispose:)
		(super dispose:)
	)
)

(instance openDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(gEgo setMotion: PolyPath 215 163 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 131 84 self)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 430
					loop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(if register
					(PrintDC 21 0) ; "Graham tugs at the door in the tree but finds it securely locked."
					(= cycles 1)
				else
					(PrintDC 21 1) ; "Graham finds that the little key fits perfectly in this lock."
					(SetFlag 74)
					(door hide:)
					(gEgo loop: 1 cel: 0 setCycle: End self)
					(gGlobalSound3 number: 122 loop: 1 vol: 100 play:)
				)
			)
			(4
				(gEgo normal: 1 view: 0 cycleSpeed: 0 loop: 7 setCycle: Walk)
				(if (not register)
					(heart init:)
					(PrintDC 21 2) ; "A little golden heart has been placed inside the crude door of the twisted old tree."
				)
				((gEgo head:) show:)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance getHeart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local0
					(gEgo setMotion: PolyPath 215 163 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 131 84 self)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 430
					loop: 2
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
				(gGlobalSound number: 36 loop: 1 vol: 127 play:)
			)
			(3
				(PrintDC 21 3) ; "Reaching a hand into the open door of the tree, Graham extracts the little golden heart."
				(gEgo loop: 1 cel: 3 setCycle: Beg self)
				(gGlobalSound3 number: 124 loop: 1 vol: 100 play:)
			)
			(4
				(gGlobalSound number: 4 loop: -1 vol: 127 play:)
				(ClearFlag 74)
				(door show:)
				(gEgo
					normal: 1
					view: 0
					loop: 3
					setCycle: Walk
					cycleSpeed: 0
					get: 9 ; Heart
				)
				(SetScore 2)
				((gEgo head:) show:)
				(heart dispose:)
				(= cycles 1)
			)
			(5
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) hide:)
				(gEgo
					view: 100
					normal: 0
					illegalBits: 0
					setLoop: 1
					cel: 0
					setCycle: CT 2 1 self
				)
			)
			(1
				(gEgo
					yStep: 10
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 30) self
				)
			)
			(2
				(gEgo cel: 3)
				(gGlobalSound3 number: 78 loop: 1 vol: 127 play:)
				(= seconds 1)
			)
			(3
				(gEgo
					setLoop: 3
					x: (- (gEgo x:) 14)
					y: (+ (gEgo y:) 7)
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(4
				(gEgo
					setLoop: 7
					x: (+ (gEgo x:) 4)
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(5
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					setPri: -1
					loop: 3
					setCycle: Walk
					yStep: 2
					cycleSpeed: 0
					illegalBits: $8000
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
				)
				((gEgo head:) show:)
			)
			(6
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance path21 of RFeature
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
					(PrintDC 21 4) ; "A slimy-looking path leads from the forest floor up to the base of a large, misshapen tree."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance tree of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0004))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 21 5) ; "Unlike the other trees of this dismal forest, a little door has been built into the trunk of one large, grotesque tree."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		y 64
		x 121
		view 428
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
					(if (== ((gInventory at: 9) owner:) 21) ; Heart
						(PrintDC 21 6) ; "A crude little door built into the trunk of a large, twisted tree catches Graham's attention."
					else
						(PrintDC 21 7) ; "There is nothing else inside the little door of the tree."
					)
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((!= ((gInventory at: 9) owner:) 21) ; Heart
							(PrintDC 21 7) ; "There is nothing else inside the little door of the tree."
						)
						((IsFlag 74)
							(openDoor register: 0)
							(gCurRoom setScript: getHeart)
						)
						(else
							(openDoor register: 1)
							(HandsOff)
							(gCurRoom setScript: openDoor)
						)
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(1 ; Key
							(cond
								((!= ((gInventory at: 9) owner:) 21) ; Heart
									(PrintDC 21 7) ; "There is nothing else inside the little door of the tree."
								)
								((IsFlag 74)
									(PrintDC 21 8) ; "The door is already open."
								)
								(else
									(++ local1)
									(HandsOff)
									(openDoor register: 0)
									(gCurRoom setScript: openDoor)
									(SetScore 3)
								)
							)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 21 9) ; "It won't help with the small door."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance heart of Prop
	(properties
		y 76
		x 42
		view 428
		loop 1
		cel 1
		priority 15
		signal 17
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
				(not (proc0_18 self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 21 2) ; "A little golden heart has been placed inside the crude door of the twisted old tree."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getHeart)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance polyListBack of List
	(properties)
)

(instance polyListFront of List
	(properties)
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

