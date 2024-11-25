;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm021 0
)

(local
	local0
	local1
	local2
	[local3 28] = [0 130 220 130 239 152 210 166 139 166 116 153 167 139 187 132 54 140 81 146 72 168 15 164 81 189 0 189]
	[local31 24] = [0 0 319 0 319 189 190 189 190 186 303 186 303 155 263 155 242 134 251 121 221 111 0 111]
	[local55 68] = [0 189 0 0 319 0 319 189 194 189 308 179 268 153 233 107 215 107 223 132 241 155 213 165 178 164 141 163 126 158 140 142 193 130 202 110 157 84 121 84 104 111 139 106 148 91 179 107 183 122 156 130 70 139 41 135 40 139 78 147 72 153 77 160 55 177 94 189]
)

(instance rm021 of KQ5Room
	(properties
		picture 21
		south 20
		west 22
	)

	(method (init)
		(super init:)
		(gEgo init: view: 0 setStep: 3 2)
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
		(door init: stopUpd:)
		(if (IsFlag 73)
			(door hide:)
		)
		(self setFeatures: path21 tree setRegions: 200 551) ; witchRegion, toadRegion
		(poly1 points: @local3 size: 14)
		(poly2 points: @local31 size: 12)
		(poly3 points: @local55 size: 33)
		(polyListBack add: poly1 poly2)
		(polyListFront add: poly3)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((== script falling)
				(script doit:)
			)
			((& (= temp1 (gEgo onControl: 0)) $0200)
				(gEgo setPri: 8)
				(gCurRoom obstacles: polyListBack)
				(= local0 1)
			)
			((& temp1 $0400)
				(gEgo setPri: -1)
				(gCurRoom obstacles: polyListFront)
				(= local0 0)
			)
			((and (not local0) (& temp1 $0002))
				(gEgo setPri: 10)
			)
			((and (not local0) (& temp1 $0010))
				(gEgo setPri: -1)
			)
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(gEgo setPri: -1)
				((ScriptID 200 1) register: temp0) ; poofOutScript
				(self setScript: (ScriptID 200 1) 0 (gEgo edgeHit:)) ; poofOutScript
			)
			((and (not local0) (& temp1 $0080))
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
					(Say 339)
					(= cycles 1)
				else
					(Say 341 self)
				)
			)
			(4
				(if register
					(= cycles 1)
				else
					(SetFlag 73)
					(door hide:)
					(gEgo loop: 1 cel: 0 setCycle: End self)
					(gGlobalAudio number: 8122 loop: 1 play:)
				)
			)
			(5
				(gEgo
					normal: 1
					view: 0
					cycleSpeed: 0
					loop: -1
					setCycle: KQ5SyncWalk
				)
				(if (not register)
					(heart init:)
					(Say 342)
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
				(gGlobalSound number: 36 loop: 1 play:)
			)
			(3
				(Say 340)
				(gEgo loop: 1 cel: 3 setCycle: Beg self)
				(gGlobalAudio number: 8124 loop: 1 play:)
			)
			(4
				(gGlobalSound number: 4 loop: -1 play:)
				(ClearFlag 73)
				(door show:)
				(gEgo
					normal: 1
					view: 0
					loop: 3
					setCycle: KQ5SyncWalk
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
				(gGlobalAudio number: 8078 loop: 1 play:)
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
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					setPri: -1
					loop: 3
					setCycle: KQ5SyncWalk
					yStep: 2
					cycleSpeed: 0
					illegalBits: $8000
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 5) self
				)
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
					(Say 345)
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
					(Say 346)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 121
		y 64
		view 428
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
					(if (== ((gInventory at: 9) owner:) 21) ; Heart
						(Say 347)
					else
						(Say 348)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(cond
						((!= ((gInventory at: 9) owner:) 21) ; Heart
							(Say 348)
						)
						((IsFlag 73)
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
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(1
							(cond
								((!= ((gInventory at: 9) owner:) 21) ; Heart
									(Say 348)
								)
								((IsFlag 73)
									(Say 343)
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
						(28
							(event claimed: 0)
						)
						(else
							(Say 344)
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
		x 42
		y 76
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
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(Say 342)
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

