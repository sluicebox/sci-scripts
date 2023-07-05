;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use LoadMany)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm047 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(gEgo setMotion: 0)
	(cond
		((not global110)
			(switch global111
				(1
					(gGlobalSound fade:)
					(gCurRoom newRoom: 45)
				)
				(2
					(gCurRoom newRoom: 44)
				)
				(else
					(gCurRoom newRoom: 46)
				)
			)
		)
		((and (== global110 0) (== global111 3))
			(gCurRoom newRoom: 46)
		)
		((and (== global110 4) (== global111 2))
			(gCurRoom newRoom: 48)
		)
		(else
			(if (and (== global110 4) (== global111 3))
				(harpies init:)
			else
				(harpies dispose:)
			)
			(switch local2
				(1
					(gEgo posn: 160 186)
				)
				(3
					(gEgo posn: 160 89)
				)
				(2
					(gEgo posn: 5 (gEgo y:))
				)
				(else
					(gEgo posn: 315 (gEgo y:))
				)
			)
			(islets posn: (- 200 (* global110 30)) (islets y:) forceUpd:)
			(islets2 posn: (- 350 (* global110 30)) (islets2 y:) forceUpd:)
			(sailBoat posn: (+ (gEgo x:) 10) (gEgo y:))
			(gCurRoom drawPic: 47)
			(if (gCast contains: cedric)
				(cond
					((== (sailBoat loop:) 0)
						(cedric
							posn: (+ (sailBoat x:) 20) (+ (sailBoat y:) 4)
							cel: (if (IsFlag 54) 2 else 1)
						)
					)
					((== (sailBoat loop:) 1)
						(cedric
							posn: (- (sailBoat x:) 23) (+ (sailBoat y:) 4)
							cel: (if (IsFlag 54) 3 else 0)
						)
					)
					((== (sailBoat loop:) 5)
						(cedric
							posn: (+ (sailBoat x:) 15) (- (sailBoat y:) 4)
							cel: (if (IsFlag 54) 2 else 1)
						)
					)
					((== (sailBoat loop:) 6)
						(cedric
							posn: (- (sailBoat x:) 15) (- (sailBoat y:) 4)
							cel: (if (IsFlag 54) 3 else 0)
						)
					)
					((== (sailBoat loop:) 7)
						(cedric
							posn: (- (sailBoat x:) 15) (+ (sailBoat y:) 9)
							cel: (if (IsFlag 54) 3 else 0)
						)
					)
					((== (sailBoat loop:) 8)
						(cedric
							posn: (+ (sailBoat x:) 15) (+ (sailBoat y:) 10)
							cel: (if (IsFlag 54) 3 else 0)
						)
					)
					((== (sailBoat loop:) 9)
						(cedric
							posn: (sailBoat x:) (+ (sailBoat y:) 10)
							cel: (if (IsFlag 54) 3 else 0)
						)
					)
					(else
						(cedric posn: 500 500)
					)
				)
				(RedrawCast)
			)
			(= local2 0)
			(gEgo edgeHit: 0)
			(= local1 0)
		)
	)
	(if (or (not global111) (== global111 4) (== global110 6))
		(gCurRoom setScript: killEgo)
	)
)

(instance rm047 of KQ5Room
	(properties
		picture 47
		horizon 80
	)

	(method (init)
		(self setFeatures: water)
		(if (not (IsFlag 107))
			(gGlobalSound number: 895 loop: -1 vol: 127 playBed:)
		)
		(LoadMany rsVIEW 259)
		(switch gPrevRoomNum
			(45
				(= global110 1)
				(= global111 1)
				(gEgo posn: 10 147)
			)
			(44
				(= global110 1)
				(= global111 2)
				(gEgo posn: 10 147)
			)
			(46
				(= global110 1)
				(= global111 3)
				(gEgo posn: 10 127)
			)
			(48
				(= global110 4)
				(= global111 3)
				(harpies init:)
				(gEgo posn: 160 89)
			)
			(else
				(= global110 1)
				(= global111 3)
				(gEgo posn: 10 120)
			)
		)
		(wave1 init: setScript: waves)
		(islets init: posn: (- 200 (* global110 30)) (islets y:) stopUpd:)
		(islets2 init: posn: (- 350 (* global110 30)) (islets2 y:) stopUpd:)
		(if (and (gEgo has: 18) (not (IsFlag 107))) ; Beeswax
			(gEgo posn: 80 130)
			(sailBoat
				init:
				view: 259
				setCel: -1
				posn: 80 130
				loop: 0
				cycleSpeed: 2
			)
			(if (and (not (IsFlag 54)) (not (IsFlag 55)))
				(cedric
					init:
					signal: 16400
					setPri: 15
					posn: (+ (sailBoat x:) 20) (+ (sailBoat y:) 1)
				)
			)
		)
		(super init:)
		(cond
			((IsFlag 107)
				(gCurRoom setScript: drownHim)
			)
			((gEgo has: 18) ; Beeswax
				(gCurRoom setScript: sink)
			)
			(else
				(gCurRoom setScript: sailIn)
			)
		)
	)

	(method (doit)
		(super doit:)
		(sailBoat x: (+ (gEgo x:) 10) y: (gEgo y:))
		(cond
			(script
				(script doit:)
			)
			((and (not local1) (= local2 (gEgo edgeHit:)))
				(= local1 1)
				(switch local2
					(3
						(++ global111)
					)
					(2
						(++ global110)
					)
					(4
						(-- global110)
					)
					(1
						(-- global111)
					)
				)
				(gGame setCursor: gWaitCursor 1)
				(HandsOff)
				(localproc_0)
				(Wait 0)
				(Animate (gCast elements:) 0)
				(gGame setCursor: global75 (HaveMouse))
				(HandsOn)
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
		(DisposeScript 970)
		(super dispose:)
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

(instance startBoat of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sailBoat setCycle: Fwd)
				(gEgo moveSpeed: 2)
				(= seconds 1)
			)
			(1
				(gEgo moveSpeed: 1)
				(= seconds 1)
			)
			(2
				(gEgo moveSpeed: 0)
				(= seconds 2)
			)
			(3
				(client setScript: 0)
			)
		)
	)
)

(instance stopBoat of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sailBoat setCycle: 0)
				(= cycles 1)
			)
			(1
				(client setScript: 0)
			)
		)
	)
)

(instance drownHim of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 128
					normal: 0
					posn: 0 130
					setPri: -1
					setCycle: Fwd
					moveSpeed: 1
					cycleSpeed: 1
					init:
					show:
					setMotion: MoveTo 160 130 self
				)
				((gEgo head:) hide:)
			)
			(1
				(PrintDC 47 0) ; "Oh no! The water is too cold for swimming!"
				(= cycles 1)
			)
			(2
				(gGlobalSound2 number: 893 loop: 1 vol: 127 play:)
				(gEgo view: 130 cycleSpeed: 1 setCycle: Fwd)
				(= seconds 4)
			)
			(3
				(gEgo setCycle: End self)
			)
			(4
				(gEgo hide:)
				(= cycles 5)
			)
			(5
				(= global330 {Down, down, down...to the bottom of the sea!})
				(EgoDead)
			)
		)
	)
)

(instance sailIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sailBoat
					init:
					setCel: -1
					ignoreActors:
					illegalBits: 0
					setCycle: Fwd
					cycleSpeed: 2
				)
				(gEgo
					view: 0
					setPri: 15
					setLoop: -1
					setCycle: KQ5SyncWalk
					ignoreActors:
					setStep: 3 2
					init:
					hide:
				)
				((gEgo head:) hide:)
				(if (not (IsFlag 55))
					(cedric init: ignoreActors: z: 8)
				)
				(sailBoat posn: (+ (gEgo x:) 10) (gEgo y:))
				(sail posn: (sailBoat x:) (sailBoat y:))
				(RedrawCast)
				(= cycles 1)
			)
			(1
				(HandsOn)
				(gCurRoom setScript: 0)
			)
		)
	)
)

(instance sink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 1)
			)
			(1
				(if (and (not (IsFlag 54)) (not (IsFlag 55)))
					(proc0_28 75 47 1 25 8) ; "Watch out, there's a hole in the boat!"
					(= cycles 1)
				)
			)
			(2
				(sailBoat
					cycleSpeed: (if (== gHowFast 2) 16 else 8)
					setCycle: End self
				)
				(if (and (not (IsFlag 54)) (not (IsFlag 55)))
					(cedric dispose:)
					(staticCedric
						init:
						view: 259
						posn: (cedric x:) (cedric y:) (cedric z:)
						loop: 1
						cycleSpeed: 5
						setCycle: End
					)
				)
			)
			(3
				(= cycles 1)
			)
			(4
				(= global330 {Down, down, down...to the bottom of the sea!})
				(EgoDead)
			)
		)
	)
)

(instance killEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> (gEgo heading:) 180)
					(self register: 1)
				)
				(staticBoat
					init:
					view: 648
					cel: 0
					x: (sailBoat x:)
					y: (sailBoat y:)
					setLoop: register
				)
				(sail
					init:
					view: 649
					cel: 0
					x: (sailBoat x:)
					y: (sailBoat y:)
					setLoop: register
				)
				(sailBoat dispose:)
				(if (not (IsFlag 55))
					(staticCedric
						init:
						cel: register
						x:
							(if register
								(- (staticBoat x:) 19)
							else
								(+ (staticBoat x:) 19)
							)
						y: (- (staticBoat y:) 2)
						setPri: 15
					)
					(if (IsFlag 54)
						(staticCedric cel: (+ (staticCedric cel:) 2))
					)
				)
				(cedric hide:)
				(= cycles 25)
			)
			(1
				(gGlobalSound number: 894 loop: 1 vol: 127 play:)
				(seaMonster
					init:
					loop: register
					x:
						(cond
							(register
								(if (< (- (staticBoat x:) 80) 30)
									30
								else
									(- (staticBoat x:) 80)
								)
							)
							((> (+ (staticBoat x:) 80) 290) 290)
							(else
								(+ (staticBoat x:) 80)
							)
						)
					y:
						(if (< (- (staticBoat y:) 20) 60)
							60
						else
							(- (staticBoat y:) 20)
						)
					setCycle: End self
				)
			)
			(2
				(HandsOff)
				(seaMonsterHead
					loop: (+ 4 register)
					cel: 0
					x: (seaMonster x:)
					y: (seaMonster y:)
					init:
				)
				(seaMonster
					setLoop: (+ 2 register)
					setCycle: Fwd
					setMotion:
						MoveTo
						(if register
							(- (staticBoat x:) 65)
						else
							(+ (staticBoat x:) 65)
						)
						(- (staticBoat y:) 10)
						self
				)
			)
			(3
				(seaMonsterHead dispose:)
				(seaMonster setLoop: (+ 4 register) cel: 0 setCycle: End self)
				(if (and (not (IsFlag 55)) (not (IsFlag 54)))
					(proc0_28 75 47 2 25 4 67 8 8 70 160) ; "Graham! Watch out!"
				)
			)
			(4
				(staticCedric dispose:)
				(seaMonster setLoop: (+ 6 register) cel: 0 setCycle: End)
				(staticBoat dispose:)
				(sail dispose:)
				(= cycles 1)
			)
			(5
				(= seconds 4)
			)
			(6
				(= global330 {That was a nasty sea creature!})
				(EgoDead 261)
			)
		)
	)
)

(instance sailBoat of Actor
	(properties
		x -35
		y 182
		yStep 1
		view 647
		xStep 1
	)

	(method (doit &tmp temp0)
		(super doit:)
		(gCurRoom doit:)
		(if (and (== (sailBoat view:) 647) (not (gEgo has: 18))) ; Beeswax
			(cond
				(
					(and
						(< 134 (= temp0 (gEgo heading:)) 160)
						(gEgo mover:)
						(!= (sailBoat loop:) 8)
					)
					(sailBoat loop: 8)
				)
				((and (< 200 temp0 226) (!= (sailBoat loop:) 7))
					(sailBoat loop: 7)
				)
				(
					(and
						(< 314 temp0 341)
						(gEgo mover:)
						(!= (sailBoat loop:) 6)
					)
					(sailBoat loop: 6)
				)
				((and (< 20 temp0 46) (gEgo mover:) (!= (sailBoat loop:) 5))
					(sailBoat loop: 5)
				)
				((and (< -1 temp0 20) (gEgo mover:) (!= (sailBoat loop:) 3))
					(sailBoat loop: 3)
				)
				(
					(and
						(< 340 temp0 361)
						(gEgo mover:)
						(!= (sailBoat loop:) 3)
					)
					(sailBoat loop: 3)
				)
				((and (< 45 temp0 135) (gEgo mover:) (!= (sailBoat loop:) 0))
					(sailBoat loop: 0)
				)
				(
					(and
						(< 225 temp0 315)
						(gEgo mover:)
						(!= (sailBoat loop:) 1)
					)
					(sailBoat loop: 1)
				)
				(
					(and
						(< 160 temp0 200)
						(gEgo mover:)
						(!= (sailBoat loop:) 9)
					)
					(sailBoat loop: 9)
				)
			)
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
					(if (gCast contains: cedric)
						(PrintDC 47 3) ; "Graham and Cedric sail uncertainly in the vast, blue ocean."
					else
						(PrintDC 47 4) ; "Graham sails uncertainly in the vast, blue ocean."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance water of RFeature
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
					(PrintDC 47 5) ; "Graham can see nothing but more ocean as far as the eye can see to the east."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance islets of Prop
	(properties
		y 33
		view 630
		signal 30976
		detailLevel 3
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
					(PrintDC 47 6) ; "Way in the distance, Graham can make out small, rocky islands."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance islets2 of Prop
	(properties
		y 33
		view 630
		cel 3
		signal 30976
		detailLevel 3
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
					(PrintDC 47 6) ; "Way in the distance, Graham can make out small, rocky islands."
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
		z 13
		view 647
		loop 2
		cel 1
		signal 30720
	)

	(method (doit)
		(if (not (gCurRoom script:))
			(switch (sailBoat loop:)
				(0
					(cedric
						x: (+ (sailBoat x:) 20)
						y: (+ (sailBoat y:) 4)
						cel: (if (IsFlag 54) 2 else 1)
					)
				)
				(1
					(cedric
						x: (- (sailBoat x:) 23)
						y: (+ (sailBoat y:) 4)
						cel: (if (IsFlag 54) 3 else 0)
					)
				)
				(5
					(cedric
						x: (+ (sailBoat x:) 15)
						y: (- (sailBoat y:) 4)
						cel: (if (IsFlag 54) 2 else 1)
					)
				)
				(6
					(cedric
						x: (- (sailBoat x:) 15)
						y: (- (sailBoat y:) 4)
						cel: (if (IsFlag 54) 3 else 0)
					)
				)
				(7
					(cedric
						x: (- (sailBoat x:) 15)
						y: (+ (sailBoat y:) 9)
						cel: (if (IsFlag 54) 3 else 0)
					)
				)
				(8
					(cedric
						x: (+ (sailBoat x:) 15)
						y: (+ (sailBoat y:) 10)
						cel: (if (IsFlag 54) 3 else 0)
					)
				)
				(9
					(cedric
						x: (sailBoat x:)
						y: (+ (sailBoat y:) 10)
						cel: (if (IsFlag 54) 3 else 0)
					)
				)
				(else
					(cedric x: 500 y: 500)
				)
			)
			(super doit:)
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
				(5 ; Talk
					(PrintDC 47 7) ; "Cedric isn't in the mood to talk."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rock1 of View ; UNUSED
	(properties
		x 258
		y 101
		view 630
		loop 3
		cel 2
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
					(PrintDC 47 8) ; "Many jagged rocks stand in the shallow waters."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rock2 of View ; UNUSED
	(properties
		x 54
		y 163
		view 630
		loop 3
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
					(PrintDC 47 8) ; "Many jagged rocks stand in the shallow waters."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance seaMonster of Actor
	(properties
		yStep 5
		view 621
		signal 24576
		illegalBits 0
		xStep 5
	)
)

(instance seaMonsterHead of Actor
	(properties
		yStep 5
		view 621
		priority 15
		signal 30736
		illegalBits 0
		xStep 5
	)

	(method (doit)
		(super doit:)
		(= x (seaMonster x:))
		(= y (seaMonster y:))
	)
)

(instance staticBoat of Actor
	(properties
		view 648
	)
)

(instance staticCedric of Actor
	(properties
		view 647
		loop 2
		cel 1
		signal 24576
	)
)

(instance harpies of View
	(properties
		x 160
		y 38
		view 630
		loop 1
		cel 1
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
					(if (gCast contains: cedric)
						(PrintDC 47 9) ; "Graham and Cedric spy an interesting island to the north."
					else
						(PrintDC 47 10) ; "Graham spies an interesting island to the north."
					)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance wave1 of Prop
	(properties
		x 199
		y 120
		view 631
		detailLevel 3
	)
)

(instance wave2 of Prop
	(properties
		x 250
		y 126
		view 631
		detailLevel 3
	)
)

(instance wave3 of Prop
	(properties
		x 33
		y 131
		view 631
		loop 1
		detailLevel 3
	)
)

(instance wave4 of Prop
	(properties
		x 272
		y 176
		view 631
		loop 2
		detailLevel 3
	)
)

(instance rwave1 of Prop ; UNUSED
	(properties
		x 43
		y 189
		view 631
		loop 3
		detailLevel 3
	)
)

(instance rwave2 of Prop ; UNUSED
	(properties
		x 89
		y 174
		view 631
		detailLevel 3
	)
)

(instance rwave3 of Prop ; UNUSED
	(properties
		x 245
		y 106
		view 631
		loop 4
		detailLevel 3
	)
)

(instance rwave4 of Prop ; UNUSED
	(properties
		x 116
		y 158
		view 631
		loop 1
		detailLevel 3
	)
)

(instance gull1 of Actor ; UNUSED
	(properties
		yStep 1
		view 631
		loop 5
		signal 10240
		cycleSpeed 2
		detailLevel 3
		illegalBits 2
		xStep 1
		moveSpeed 1
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
					(PrintDC 47 11) ; "Graham notices beautiful seagulls flying in the distance."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance gull2 of Actor ; UNUSED
	(properties
		yStep 1
		view 631
		loop 5
		signal 10240
		cycleSpeed 2
		detailLevel 3
		illegalBits 2
		xStep 1
		moveSpeed 1
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
					(PrintDC 47 11) ; "Graham notices beautiful seagulls flying in the distance."
					(event claimed: 1)
				)
			)
		)
	)
)

