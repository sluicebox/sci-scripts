;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 29)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Chase)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm029 0
)

(local
	[local0 6] = [0 93 0 0 257 0]
	[local6 6] = [319 148 319 189 212 189]
	[local12 8] = [162 179 55 210 11 189 114 157]
	[local20 8] = [290 135 187 172 132 150 237 112]
	[local28 12] = [319 129 309 129 262 106 319 84 339 84 339 129]
	[local40 20] = [290 135 187 172 132 150 237 112 276 128 283 123 300 125 306 133 291 135 0 0]
	local60
)

(instance rm029 of PQRoom
	(properties
		picture 29
		north -1
		east -1
		south -1
		west -1
	)

	(method (init)
		(super init:)
		(LoadMany rsVIEW 333 320)
		(LoadMany rsSOUND 900 901)
		(poly1 points: @local0 size: 3)
		(poly2 points: @local6 size: 3)
		(poly3 points: @local12 size: 4)
		(poly4 points: @local20 size: 4)
		(poly5 points: @local28 size: 6)
		(poly6 points: @local40 size: 9)
		(self addObstacle: poly1 poly2 poly3)
		(switch global127
			(1
				(self setRegions: 888 addObstacle: poly4 poly5) ; lady
			)
			(2
				(self setRegions: 887 addObstacle: poly4) ; speeder
			)
			(3
				(self setRegions: 886 addObstacle: poly4) ; lowrider
			)
			(5
				(self setRegions: 885 addObstacle: poly6) ; drunk
			)
			(4
				(self setRegions: 884) ; allied
			)
		)
		(= global110 yourDoor)
		(yourCar init: stopUpd:)
		(gEgo
			normal: 0
			view: 16
			loop: 2
			cel: 10
			posn: (- (yourCar x:) 15) (- (yourCar y:) 25)
			setPri: 3
			setStep: 3 2
			init:
		)
		(streetSound play:)
		(theShoulder init:)
		(theRail init:)
		(theRoom init:)
		(HandsOff)
		(self setScript: exitCar)
	)

	(method (doit &tmp temp0)
		(cond
			((& (= temp0 (gEgo onControl: 0)) $4000)
				(+= local60 1)
				(gEgo priority: 14 signal: (| (gEgo signal:) $0010))
			)
			((> (gEgo y:) 188)
				(gEgo priority: 15 signal: (| (gEgo signal:) $0010))
			)
			(
				(and
					(!= (self script:) runOver)
					(or (& temp0 $2000) (& temp0 $0040))
				)
				(-= local60 1)
				(gEgo priority: 13 signal: (| (gEgo signal:) $0010))
			)
			((and (== global127 1) (& temp0 $0200) (!= (self script:) runOver))
				(gEgo priority: 9 signal: (| (gEgo signal:) $0010))
			)
			((and (& temp0 $0001) (!= (self script:) runOver))
				(gEgo signal: (& (gEgo signal:) $ffef))
			)
			((and (& temp0 $0010) local60)
				(SetScore 114 2)
			)
		)
		(cond
			(script 0)
			((& temp0 $0002)
				(HandsOff)
				(Load rsVIEW 333 320)
				(self setScript: runOver)
				(if (== global127 4)
					(global112 setScript: 0 setMotion: 0)
				)
			)
			(
				(and
					(& temp0 $0400)
					(< (gEgo heading:) 180)
					(< local60 1)
					(< (Random 0 100) 30)
				)
				(HandsOff)
				(self setScript: runOver)
			)
			((== ((gInventory at: 24) owner:) 886) ; ticket
				((gInventory at: 24) owner: 0) ; ticket
				(HandsOff)
				(self setScript: enterCar)
			)
			((== ((gInventory at: 24) owner:) 887) ; ticket
				((gInventory at: 24) owner: 0) ; ticket
				(HandsOff)
				(self setScript: enterCar)
			)
		)
		(super doit:)
	)

	(method (dispose &tmp temp0)
		(= temp0 0)
		(cond
			((or (gEgo has: 23) (and (IsFlag 14) (not (IsFlag 16)))) 0) ; license
			(
				(or
					(not (IsFlag 12))
					(and (not (IsFlag 13)) (not (IsFlag 216)))
					(not (IsFlag 15))
				)
				(while (not temp0)
					(switch (= global127 (Random 2 4))
						(2
							(if (not (IsFlag 12))
								(= temp0 1)
							)
						)
						(3
							(if (and (not (IsFlag 13)) (not (IsFlag 216)))
								(= temp0 1)
							)
						)
						(4
							(if (not (IsFlag 15))
								(= temp0 1)
							)
						)
					)
				)
			)
			((and (not (IsFlag 14)) (not (IsFlag 215)))
				(= global127 5)
			)
			((and (!= global134 3) (== ((gInventory at: 2) owner:) 885)) ; handcuff
				(= global127 5)
			)
			(else
				(= global127 0)
			)
		)
		(DisposeScript 972)
		(super dispose:)
		(DisposeScript 881)
	)
)

(instance runOver of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 0) (< (hitAndRun distanceTo: gEgo) 110))
			(Face gEgo hitAndRun self)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(sfx number: 287 loop: 1 play:)
				(hitAndRun posn: -66 206 init:)
				(hitAndRun setMotion: Chase gEgo 80 self)
			)
			(1
				(sfx number: 293 loop: 1 play: self)
				(gEgo
					normal: 0
					view: 333
					loop: 1
					cel: 0
					setPri: 1
					setCycle: End
				)
				(hitAndRun setMotion: MoveTo 388 50 self)
			)
			(2 0)
			(3
				(EgoDead 6) ; "You have to take care of that oncoming traffic. Check that manual!"
			)
		)
	)
)

(instance exitCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 5)
			)
			(1
				(if (not (gEgo has: 23)) ; license
					(= seconds 3)
					(ShowClock 1)
				else
					(= cycles 1)
				)
			)
			(2
				(sfx number: 900 play:)
				(gEgo
					normal: 0
					view: 16
					loop: 2
					cel: 10
					posn: (- (yourCar x:) 15) (- (yourCar y:) 25)
					setPri: 3
					setCycle: Beg self
					init:
				)
			)
			(3
				(sfx number: 901 play:)
				(gEgo
					normal: 1
					view: 1
					setCycle: Walk
					posn: (- (gEgo x:) 7) (+ (gEgo y:) 2)
					setPri: -1
					setMotion: MoveTo 81 165 self
				)
			)
			(4
				(ShowClock 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 81 165 self)
			)
			(1
				(gEgo
					setMotion:
						MoveTo
						(- (yourCar x:) 17)
						(- (yourCar y:) 24)
						self
				)
			)
			(2
				(sfx number: 900 play:)
				(gEgo
					normal: 0
					view: 16
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 2)
					loop: 2
					cel: 0
					setCycle: End self
				)
			)
			(3
				(sfx number: 901 play:)
				(gEgo setPri: -1 dispose:)
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance yourDoor of Prop
	(properties
		x 113
		y 271
		z 100
		description {car door}
		view 208
		loop 3
		priority 14
		signal 16401
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Print 29 0) ; "The passenger car door."
			)
			(3 ; Do
				(cond
					((IsFlag 45)
						(= global114 500)
					)
					((== global127 5)
						(Print 29 1) ; "You need to restrain him first."
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance yourCar of Prop
	(properties
		x 80
		y 203
		description {car}
		view 208
		cel 1
		signal 16385
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 29 2) ; "Your car is parked where you left it."
			)
			(3 ; Do
				(if (or (== global113 599) (== global113 699))
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(Print 29 3) ; "This is not the time to turn your back."
				else
					(HandsOff)
					(gCurRoom setScript: enterCar)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (init)
		(if (!= global127 1)
			(topLights
				posn: (- (self x:) 4) (- (self y:) 39)
				setCycle: Fwd
				init:
			)
			(rearLights
				posn: (- (self x:) 19) (- (self y:) 23)
				setCycle: Fwd
				init:
			)
		)
		(yourDoor posn: (+ (self x:) 33) (+ (self y:) 68) 100 init: stopUpd:)
		(super init: &rest)
	)
)

(instance hitAndRun of Actor
	(properties
		yStep 25
		view 320
		cel 1
		priority 7
		signal 20496
		xStep 25
	)
)

(instance rearLights of Actor
	(properties
		x 61
		y 180
		view 208
		loop 1
		cel 2
		priority 14
		signal 18448
		cycleSpeed 7
	)
)

(instance topLights of Actor
	(properties
		x 76
		y 164
		view 208
		loop 2
		priority 14
		signal 18448
		cycleSpeed 8
	)
)

(instance theRoom of Feature
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 29 4) ; "Highway 41 runs all the way through Lytton."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance theRail of Feature
	(properties
		onMeCheck 64
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 29 5) ; "Guardrails protect out-of-control vehicles from plunging off the road."
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

(instance theShoulder of Feature
	(properties
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(Print 29 6) ; "The shoulder of the road is for emergency stops only."
			)
			(else
				(super doVerb: theVerb invItem)
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

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly6 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance sfx of Sound
	(properties)
)

(instance streetSound of Sound
	(properties
		number 294
		vol 90
		loop -1
	)
)

(instance runOverSound of Sound ; UNUSED
	(properties
		number 295
		loop -1
	)
)

