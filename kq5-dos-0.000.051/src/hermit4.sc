;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 113)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	hermit4 0
)

(instance hermit4 of Rm
	(properties
		picture 47
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
				(if (not (IsFlag 56))
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

(instance sailBoat of Act
	(properties
		y 182
		x -35
		yStep 1
		view 557
		xStep 1
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
					(PrintDC 113 0) ; "Boat"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance sail of Prop
	(properties
		y 133
		x 146
		view 649
		signal 30976
	)
)

(instance cedric of Act
	(properties
		view 654
		loop 2
		signal 30720
	)
)

(instance islets of Prop
	(properties
		y 33
		x 160
		view 630
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
					(PrintDC 113 1) ; "Many rocky islets dot the ocean just off-shore of the mountainous mainland."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance islets2 of Prop
	(properties
		y 33
		x 300
		view 630
		cel 3
		signal 30976
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
					(PrintDC 113 1) ; "Many rocky islets dot the ocean just off-shore of the mountainous mainland."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance mermaid of Act
	(properties
		view 624
		loop 9
	)
)

(instance wave1 of Prop
	(properties
		y 120
		x 199
		view 631
	)
)

(instance wave2 of Prop
	(properties
		y 126
		x 250
		view 631
	)
)

(instance wave3 of Prop
	(properties
		y 131
		x 33
		view 631
		loop 1
	)
)

(instance wave4 of Prop
	(properties
		y 176
		x 272
		view 631
		loop 2
	)
)

(instance rwave1 of Prop ; UNUSED
	(properties
		y 189
		x 43
		view 631
		loop 3
	)
)

(instance rwave2 of Prop ; UNUSED
	(properties
		y 174
		x 89
		view 631
	)
)

(instance rwave3 of Prop ; UNUSED
	(properties
		y 106
		x 245
		view 631
		loop 4
	)
)

(instance rwave4 of Prop ; UNUSED
	(properties
		y 158
		x 116
		view 631
		loop 1
	)
)

