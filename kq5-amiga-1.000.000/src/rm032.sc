;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm032 0
)

(local
	local0
	local1
	[local2 8] = [0 130 47 130 47 189 0 189]
	[local10 12] = [92 131 137 128 177 179 152 189 50 189 50 130]
	[local22 18] = [0 0 319 0 319 188 225 188 187 172 168 130 180 123 139 108 0 108]
	local40
)

(instance rm032 of KQ5Room
	(properties
		picture 32
		south 33
		west 31
	)

	(method (init)
		(= global320 101)
		(= global321 92)
		(super init:)
		(if (IsFlag 34)
			(++ local0)
		else
			(self setRegions: 202) ; owl
			(wolf posn: -80 122 setCycle: Walk init:)
			(gGlobalSound2 number: 829 loop: 1 play:)
		)
		(switch gPrevRoomNum
			(south
				(gEgo view: 10 posn: 202 184 init:)
				(= local40 1)
			)
			(else
				(gEgo view: 10 posn: 10 128 init:)
			)
		)
		(self
			setFeatures: path32 halfDome area mountains
			addObstacle: poly1 poly2 poly3
		)
		(poly1 points: @local2 size: 4)
		(poly2 points: @local10 size: 6)
		(poly3 points: @local22 size: 9)
	)

	(method (doit &tmp temp0 temp1)
		(cond
			(script
				(script doit:)
			)
			((and (not (IsFlag 16)) (not local1) (>= (gEgo x:) 30))
				(PrintDC 32 0) ; "Graham's hunger grows acute. Without food, he may soon die."
				(= local1 1)
			)
			((and (not (IsFlag 16)) local1 (>= (gEgo x:) 105))
				(gCurRoom setScript: hungerDeath)
			)
			((not local0)
				(++ local0)
				(self setScript: catchCedric)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 0) $2000)
				(self setScript: sliding)
			)
			((& (= temp1 (gEgo onControl: 1)) $4000)
				(self setScript: climbUp)
			)
			((& temp1 $0038)
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
			(else
				(switch (event message:)
					(4 ; Inventory
						(if (MousedOn gEgo event)
							(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
								(29
									(if (not local40)
										(event claimed: 1)
										(gEgo setScript: useSled)
									)
								)
								(28
									(event claimed: 0)
								)
								(else
									(PrintDC 32 1) ; "It won't help Graham cross the crevasse."
									(event claimed: 1)
								)
							)
						)
					)
				)
			)
		)
	)
)

(instance falling of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 76
					setLoop: 0
					signal: 16384
					cel: 0
					cycleSpeed: 1
					setCycle: End self
					setPri:
						(cond
							((& (gEgo onControl: 1) $0008) 1)
							((& (gEgo onControl: 1) $0010) 3)
							(else 13)
						)
					illegalBits: 0
					yStep: 8
					setMotion: MoveTo (- (gEgo x:) 20) 230
				)
				(gGlobalSound4 number: 83 loop: 1 play: self)
			)
			(1)
			(2
				(= seconds 3)
			)
			(3
				(= global330 {That last step was a doozy!})
				(EgoDead)
			)
		)
	)
)

(instance sliding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 510
					setLoop: 0
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(1
				(gGlobalSound2 number: 830 loop: 1 play:)
				(gEgo
					setLoop: 1
					cel: 0
					x: (- (gEgo x:) 10)
					y: (- (gEgo y:) 10)
					setCycle: Fwd
					setPri: 5
					yStep: 8
					xStep: 8
					illegalBits: 0
					setMotion: MoveTo 202 182 self
				)
			)
			(2
				(gEgo setLoop: 2 cel: 0 y: 184 setCycle: End self)
			)
			(3
				(= local40 1)
				(HandsOn)
				(gEgo
					normal: 1
					view: 10
					setLoop: -1
					cycleSpeed: 0
					illegalBits: -32768
					setStep: 3 2
					setCycle: KQ5SyncWalk
					setPri: -1
				)
				((gEgo head:) show:)
				(client setScript: 0)
			)
		)
	)
)

(instance climbUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 512
					cel: 0
					posn: (- (gEgo x:) 15) (- (gEgo y:) 37)
					setCycle: End self
					illegalBits: 0
					cycleSpeed: 3
				)
			)
			(1
				(= local40 0)
				(HandsOn)
				(gEgo
					normal: 1
					view: 10
					setLoop: -1
					illegalBits: -32768
					posn: (- (gEgo x:) 9) (- (gEgo y:) 13)
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					setPri: -1
				)
				((gEgo head:) show:)
				(client setScript: 0)
			)
		)
	)
)

(instance catchCedric of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== state 3 (wolf cel:))
			(global322 dispose:)
			(SetFlag 34)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 15 (gEgo y:) self)
			)
			(1
				(wolf
					setLoop: 0
					setStep: 4 4
					setCycle: Walk
					cycleSpeed: 1
					setMotion: MoveTo 23 122 self
				)
			)
			(2
				(wolf setMotion: MoveTo 43 122 self)
				(PrintDC 32 2 #at 100 10 #dispose) ; "Help, Graham! Help me!"
			)
			(3
				(wolf
					setLoop: 1
					cel: 0
					setMotion: MoveTo 200 122
					setCycle: End self
				)
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 502 loop: 4 cel: 0 setCycle: End)
			)
			(4
				(gGlobalSound2 number: 830 loop: 1 play:)
				(wolf
					cycleSpeed: 0
					setStep: 7 7
					setLoop: 2
					cel: 0
					setCycle: End self
				)
			)
			(5
				(wolf
					cycleSpeed: 0
					setStep: 4 4
					setLoop: 3
					cel: 0
					setMotion: MoveTo 227 225 self
				)
			)
			(6
				(cls)
				(PrintDC 32 3 #at 10 120 #time 4) ; "Cedric!"
				(= cycles 1)
			)
			(7
				(gEgo normal: 1 view: 10 loop: 0 setCycle: KQ5SyncWalk)
				((gEgo head:) show:)
				(= global322 0)
				(cls)
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance hungerDeath of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					view: 508
					normal: 0
					setLoop: 0
					cycleSpeed: 3
					setMotion: 0
				)
				(= seconds 2)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(= seconds 2)
			)
			(4
				(= global330
					{Remember when you turned down that last meal at home...?}
				)
				(EgoDead 267)
			)
		)
	)
)

(instance useSled of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo put: 29 32) ; Sled
				(SetScore 5)
				(HandsOff)
				(gEgo setMotion: MoveTo 120 117 self)
			)
			(1
				(= global322 100)
				(gCurRoom newRoom: 33)
			)
		)
	)
)

(instance path32 of RFeature
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
					(PrintDC 32 4) ; "The snowy path abruptly ends where a gradual slope continues eastward."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance halfDome of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 32 5) ; "The shape of one particular mountaintop seems vaguely familiar to Graham."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance mountains of RFeature
	(properties
		nsBottom 200
		nsRight 320
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
					(PrintDC 32 6) ; "Graham can see a breathtaking view of distant snow-covered mountains towering above a beautiful valley with a ribbon of river slicing across it."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wolf of Actor
	(properties
		view 502
	)
)

(instance area of RFeature
	(properties
		nsTop 108
		nsBottom 137
		nsRight 195
	)

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
				(4 ; Inventory
					(switch (gInventory indexOf: (gTheIconBar curInvIcon:))
						(29
							(if (not local40)
								(event claimed: 1)
								(gEgo setScript: useSled)
							)
						)
					)
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
	(properties)
)

(instance poly3 of Polygon
	(properties)
)

