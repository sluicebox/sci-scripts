;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 113)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Motion)
(use Actor)
(use System)

(public
	hermit4 0
)

(instance hermit4 of KQ5Room
	(properties
		picture 47
		style 30
	)

	(method (init)
		(gGlobalSound number: 822 loop: -1 vol: 127 playBed:)
		(gEgo init:)
		(islets init:)
		(islets2 init:)
		(wave1 init: setScript: waves)
		(self setScript: sailInScript)
		(super init:)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
		(gGlobalSound fade:)
	)
)

(instance waves of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(wave1
					init:
					show:
					setCycle: End
					setPri: 2
					ignoreActors:
					cycleSpeed: (Random 5 10)
				)
				(wave2
					init:
					setCycle: End
					setPri: 2
					ignoreActors:
					cycleSpeed: (Random 5 10)
				)
				(wave3
					init:
					setCycle: End
					setPri: 2
					ignoreActors:
					cycleSpeed: (Random 5 10)
				)
				(wave4
					init:
					setCycle: End self
					setPri: 2
					ignoreActors:
					cycleSpeed: (Random 5 10)
				)
			)
			(1
				(= seconds (Random 3 8))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance swim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mermaid
					setCycle: Fwd
					setLoop: 9
					cycleSpeed: 2
					moveSpeed: 1
					setMotion: MoveTo 350 140 self
				)
			)
			(1
				(= state -1)
				(= seconds 2)
			)
		)
	)
)

(instance sailInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self doit:)
				(gCurRoom setRegions: 763) ; cartoonRegion
				(mermaid init: posn: 70 140 setScript: swim)
				(sailBoat
					init:
					posn: 0 140
					setPri: -1
					setCycle: Fwd
					cycleSpeed: 5
					setStep: 1 1
					moveSpeed: 1
					setMotion: MoveTo 320 140 self
				)
				(sail init:)
				(gEgo
					normal: 0
					view: 654
					setLoop: 1
					setPri: 11
					setCel: 0
					setCycle: 0
				)
				((gEgo head:) hide:)
				(if (not (IsFlag 55))
					(cedric init: z: 8)
				)
			)
			(1
				(gCurRoom newRoom: 89)
			)
		)
	)

	(method (doit)
		(if (sailBoat mover:)
			((sailBoat mover:) doit:)
		)
		(sail posn: (sailBoat x:) (sailBoat y:))
		(gEgo posn: (- (sailBoat x:) 12) (+ (sailBoat y:) 0))
		(if (gCast contains: cedric)
			(cedric posn: (+ (sailBoat x:) 20) (+ (sailBoat y:) 3))
		)
		(super doit:)
	)
)

(instance sailBoat of Actor
	(properties
		x -35
		y 182
		yStep 1
		view 557
		xStep 1
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
					(PrintDC 113 0) ; "Boat"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance sail of Prop
	(properties
		x 146
		y 133
		view 649
		signal 30976
	)
)

(instance cedric of Actor
	(properties
		view 654
		loop 2
		signal 30720
	)
)

(instance islets of Prop
	(properties
		x 160
		y 33
		view 630
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
					(Say 56)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance islets2 of Prop
	(properties
		x 300
		y 33
		view 630
		cel 3
		signal 30976
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
					(Say 56)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance mermaid of Actor
	(properties
		view 624
		loop 9
	)
)

(instance wave1 of Prop
	(properties
		x 199
		y 120
		view 631
	)
)

(instance wave2 of Prop
	(properties
		x 250
		y 126
		view 631
	)
)

(instance wave3 of Prop
	(properties
		x 33
		y 131
		view 631
		loop 1
	)
)

(instance wave4 of Prop
	(properties
		x 272
		y 176
		view 631
		loop 2
	)
)

(instance rwave1 of Prop ; UNUSED
	(properties
		x 43
		y 189
		view 631
		loop 3
	)
)

(instance rwave2 of Prop ; UNUSED
	(properties
		x 89
		y 174
		view 631
	)
)

(instance rwave3 of Prop ; UNUSED
	(properties
		x 245
		y 106
		view 631
		loop 4
	)
)

(instance rwave4 of Prop ; UNUSED
	(properties
		x 116
		y 158
		view 631
		loop 1
	)
)

