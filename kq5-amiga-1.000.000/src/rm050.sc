;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm050 0
)

(local
	[local0 12] = [0 173 94 166 159 159 222 159 272 189 0 189]
	[local12 16] = [307 62 260 65 209 90 199 104 167 118 0 119 0 0 299 0]
	[local28 12] = [319 148 269 142 212 141 279 114 283 86 319 80]
)

(instance rm050 of KQ5Room
	(properties
		picture 50
		horizon 70
		north 90
		east 90
		west 49
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 68 656 655)
		(self setFeatures: arch path50 addObstacle: poly1 poly2 poly3)
		(switch gPrevRoomNum
			(west
				(gEgo posn: 27 138)
			)
			(else
				(gEgo posn: 297 75)
			)
		)
		(gEgo
			view: (if (IsFlag 74) 656 else 0)
			init:
			ignoreActors: 0
			setStep: 3 2
		)
		(if (IsFlag 55)
			(cedric init:)
			(gGlobalSound number: 818 loop: -1 vol: 127 playBed:)
		)
		(poly1 points: @local0 size: 6)
		(poly2 points: @local12 size: 8)
		(poly3 points: @local28 size: 6)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			(
				(and
					(gEgo edgeHit:)
					(= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				)
				(gCurRoom newRoom: temp0)
			)
			((& (gEgo onControl: 0) $0020)
				(HandsOff)
				(self setScript: fallScript)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
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
	)

	(method (dispose)
		(super dispose:)
	)
)

(instance fallScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: (if (IsFlag 74) 655 else 68)
					setLoop: 0
					signal: (| (gEgo signal:) $4000)
					cel: 0
					cycleSpeed: 3
					setCycle: End self
					illegalBits: 0
				)
			)
			(1
				(gEgo yStep: 8 setMotion: MoveTo (gEgo x:) 230)
				(gGlobalSound2 number: 83 loop: 1 vol: 127 play: self)
			)
			(2
				(= seconds 2)
				(= global103 0)
			)
			(3
				(= global330 {That last step was a doozy!})
				(EgoDead)
			)
		)
	)
)

(instance getCedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_28 75 50 0 67 -1 10 25 5) ; "Graham! (cough, cough) Help... me."
				(= cycles 1)
			)
			(1
				(gEgo
					ignoreActors:
					setMotion:
						PolyPath
						(+ (cedric x:) 11)
						(- (cedric y:) 4)
						self
				)
			)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 658
					loop: 1
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
				(cedric dispose:)
			)
			(3
				(SetScore 3)
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 656
					setLoop: -1
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
				)
				(= cycles 1)
			)
			(4
				(proc0_28 160 50 1 25 4 67 -1 10) ; "Cedric, where do you hurt?"
				(= cycles 1)
			)
			(5
				(proc0_28 75 50 2 25 3 67 -1 10) ; "Everywhere... (cough, cough)."
				(= cycles 1)
				(gGlobalSound fade:)
			)
			(6
				(ClearFlag 55)
				(SetFlag 74)
				(= global103 0)
				(HandsOn)
				(gGlobalSound number: 814 loop: -1 vol: 127 playBed:)
				(self dispose:)
			)
		)
	)
)

(instance arch of RFeature
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
					(PrintDC 50 3) ; "Graham can see the sandy path wending its way upward through a second rocky arch."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance path50 of RFeature
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
					(PrintDC 50 4) ; "From the nearby beach a sandy path continues on up to a high point of the craggy island."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cedric of Actor
	(properties
		x 112
		y 154
		view 658
		loop 3
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
					(PrintDC 50 5) ; "Poor Cedric. Having been seriously wounded by the vicious harpies, he now lies, moaning and in pain, upon the sandy path."
					(event claimed: 1)
				)
				(5 ; Talk
					(proc0_28 75 50 6 67 30 100) ; "Mooaaannn!"
					(event claimed: 1)
				)
				(4 ; Inventory
					(if (!= (gInventory indexOf: (gTheIconBar curInvIcon:)) 28)
						(PrintDC 50 7) ; "That won't help Cedric."
						(event claimed: 1)
					else
						(event claimed: 0)
					)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: getCedScript)
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

