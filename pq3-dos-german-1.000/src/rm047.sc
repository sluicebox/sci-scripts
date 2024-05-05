;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 47)
(include sci.sh)
(use Main)
(use Interface)
(use trunk)
(use rmnScript)
(use eRS)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
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
	[local3 2]
	local5
	local6
	local7
	local8
)

(procedure (localproc_0 param1 param2)
	(if (& (param1 onControl: 1) param2)
		(return 1)
	)
)

(instance rm047 of PQRoom
	(properties
		lookStr {You're standing outside the infamous Nugget saloon.}
		picture 47
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (init)
		(proc0_17 10)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 32 315 27 202 64 115 33 103 35 159 78 140 84 142 93 122 99 110 96 76 108 64 106 44 113 47 118 0 134 0 -10 319 -10
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 178 136 49 172 5 144 126 106
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 319 80 278 88 250 73 245 62 319 36
					yourself:
				)
		)
		(trunk x: 229 y: 126 marked: 0 init: close:)
		(LoadMany rsVIEW 20 355 457 500 501 502 503 504 490)
		(LoadMany rsSOUND 470 471 913 472 907 908)
		(SetFlag 204)
		(switch gPrevRoomNum
			(48
				(if (IsFlag 51)
					(gEgo view: 5 posn: 131 47 xStep: 3 yStep: 2 init:)
					(suspectCarActor init: approachVerbs: 3 4 2 stopUpd:) ; Do, Inventory, Look
					(suspectCarActor setScript: sBurnRubber)
					(gCurRoom setScript: sGetInCar)
				else
					(gEgo view: 5 posn: 31 90 xStep: 3 yStep: 2 init:)
					(suspectCarView init: addToPic: approachVerbs: 3 4 2) ; Do, Inventory, Look
					(gLongSong setVol: 60)
					(streetSFX play:)
					(gCurRoom setScript: sFromBar)
				)
			)
			(else
				(suspectCarView init: addToPic: approachVerbs: 3 4 2) ; Do, Inventory, Look
				(pat init:)
				(gEgo view: 5 posn: 335 85 xStep: 3 yStep: 2 init:)
				(streetSFX play:)
				(gLongSong number: 470 flags: 1 loop: -1 play: 0)
				(if (== global108 2)
					(gCurRoom setScript: sBurnRubber)
				else
					(gCurRoom setScript: sExitCarScript)
				)
			)
		)
		(carDoor init:)
		(carTrunk init: approachVerbs: 3 4 2) ; Do, Inventory, Look
		(unmarkedCar init: addToPic:)
		(nuggetSign init: setCycle: Fwd)
		(bugs init: setCycle: Fwd)
		(barDoor init: approachVerbs: 3 4 2) ; Do, Inventory, Look
		(mug init:)
		(nugget init:)
		(neonSign init:)
		(garageDoor init:)
		(windows init:)
		(alley init:)
		(streetSign init:)
		(super init:)
	)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(cond
			((< (= temp0 (GetDistance (gEgo x:) (gEgo y:) 35 40)) 0)
				(= temp0 0)
			)
			((> temp0 300)
				(= temp0 300)
			)
		)
		(if
			(and
				(not (OneOf (gCurRoom script:) sToBar sFromBar))
				(== (gLongSong number:) 470)
			)
			(gLongSong setVol: (- 127 (/ temp0 3)))
		)
		(cond
			(script)
			((localproc_0 gEgo 2)
				(HandsOff)
				(Print 47 0) ; "The back entrance to the bar seems to be locked."
				(gCurRoom setScript: exitAlley)
			)
			((not (gEgo inRect: 2 0 318 188))
				(gCurRoom setScript: sEdgeHit)
			)
		)
	)

	(method (dispose)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super dispose:)
		(DisposeScript 881)
	)
)

(instance exitAlley of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 170 80 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToPat of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Face gEgo pat)
				(= seconds 3)
			)
			(1
				(HandsOff)
				(ShowClock 0)
				(if (== local1 1)
					(Print 47 1) ; "Morales ignores your attempt at conversation."
					(HandsOn)
					(self dispose:)
				else
					(= save1 1)
					(sInset init:)
					(Say sInset 47 2 108) ; "This car looks like the suspect vehicle we've been looking for."
					(pat setMotion: 0 view: 355 setLoop: 2)
					(= local1 1)
				)
				(= seconds 6)
			)
			(2
				(sInset dispose:)
				(= save1 1)
				(pInset init:)
				(Say pInset 47 3 108) ; "Hmmmm... no tags, though."
				(= seconds 4)
			)
			(3
				(pInset dispose:)
				(if (and (== (pat x:) 120) (== (pat y:) 91))
					(HandsOn)
					(self dispose:)
				else
					(pat
						view: 20
						loop: 1
						setCycle: Walk
						setMotion: MoveTo 120 91 self
					)
				)
			)
			(4
				(pat setMotion: 0 view: 355 setLoop: 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sEdgeHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((<= (gEgo x:) 2)
						(= local5 -18)
						(= local6 (gEgo y:))
						(= local7 18)
						(= local8 (gEgo y:))
					)
					((>= (gEgo x:) 318)
						(= local5 331)
						(= local6 (gEgo y:))
						(= local7 301)
						(= local8 (gEgo y:))
					)
					((>= (gEgo y:) 188)
						(= local6 239)
						(= local5 (gEgo y:))
						(= local8 185)
						(= local7 (gEgo y:))
					)
				)
				(= cycles 3)
			)
			(1
				(gEgo setMotion: MoveTo local5 local6 self)
			)
			(2
				(= seconds 4)
			)
			(3
				(gEgo setMotion: MoveTo local7 local8 self)
			)
			(4
				(Print 47 4) ; "You wander around for a moment and realize that there's nothing else of interest in this part of town."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitCarScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 4)
			)
			(1
				(ShowClock 1 32 -1)
				(pat setCycle: End self)
				(gEgo normal: 1 setMotion: PolyPath 78 113)
			)
			(2
				(HandsOn)
				(pat
					view: 20
					loop: 1
					posn: 301 50
					setCycle: Walk
					setMotion: MoveTo 120 91 self
				)
			)
			(3
				(pat view: 355 setLoop: 2)
				(= ticks 1)
			)
			(4
				(ShowClock 0)
				(self dispose:)
			)
		)
	)
)

(instance sToBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: Walk setMotion: PolyPath 62 107 self)
			)
			(1
				(roomSFX number: 907 play:)
				(gLongSong setVol: 127)
				(barDoor startUpd: setCycle: End self)
			)
			(2
				(gEgo setCycle: Walk setMotion: MoveTo 27 75)
				(pat
					view: 20
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 72 117 self
				)
			)
			(3
				(pat setMotion: MoveTo 27 90 self)
			)
			(4
				(barDoor setCycle: Beg self)
			)
			(5
				(roomSFX number: 908 play:)
				(gLongSong setVol: 100)
				(HandsOn)
				(gCurRoom newRoom: 48)
			)
		)
	)
)

(instance sFromBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 51)
					(gEgo setCycle: Walk setMotion: PolyPath 155 70)
					(HandsOn)
					(self dispose:)
				)
				(self cue:)
			)
			(1
				(roomSFX number: 907 play:)
				(gLongSong setVol: 127)
				(barDoor setCycle: End self)
			)
			(2
				(gEgo setCycle: Walk setMotion: MoveTo 62 107 self)
			)
			(3
				(barDoor setCycle: Beg self)
			)
			(4
				(gLongSong setVol: 100)
				(roomSFX number: 908 play:)
				(gEgo setMotion: PolyPath 106 107)
				(= seconds 3)
			)
			(5
				(roomSFX number: 907 play:)
				(gLongSong setVol: 127)
				(barDoor setCycle: End self)
			)
			(6
				(pat
					init:
					view: 20
					posn: 31 90
					setCycle: Walk
					setMotion: MoveTo 75 110 self
				)
			)
			(7
				(pat setMotion: MoveTo 120 91 self)
			)
			(8
				(barDoor setCycle: Beg self)
			)
			(9
				(gLongSong setVol: 100)
				(roomSFX number: 908 play:)
				(pat view: 355 setLoop: 2)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sBurnRubber of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(roomSFX number: 472 play:)
				(tire init: setCycle: End self)
			)
			(2
				(tire dispose:)
				(smoke init: setCycle: End)
				(suspectCarActor
					startUpd:
					setLoop: 0
					setCel: 0
					setMotion: MoveTo -72 204 self
				)
				(tireMarks init: stopUpd:)
			)
			(3
				(suspectCarActor dispose:)
				(smoke dispose:)
				(self dispose:)
			)
		)
	)
)

(instance sSuspectCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo normal: 0 view: local2 setCel: 0 setCycle: End self)
				(if (== local2 501)
					(roomSFX number: 938 play:)
				)
			)
			(1
				(gEgo normal: 1 view: 5)
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sGetInCar of rmnScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 5)
			)
			(1
				(gEgo
					signal: (& (gEgo signal:) $f7ff)
					setMotion: PolyPath 161 79 self
				)
			)
			(2
				(gEgo
					normal: 0
					view: 503
					setLoop: 1
					setLoop: 1
					setMotion: MoveTo 113 134 self
				)
			)
			(3
				(NormalEgo 5)
				(= cycles 3)
			)
			(4
				(Print 47 5) ; "You curse as you watch the suspect getting away."
				(pat
					init:
					view: 20
					x: 134
					y: 53
					setCycle: Walk
					setMotion: MoveTo 168 66 self
				)
			)
			(5
				(pat view: 355 setLoop: 2)
				(= ticks 1)
			)
			(6
				(= save1 1)
				(Say pat 47 6) ; "What... What's going on?"
				(= seconds 3)
			)
			(7
				(= save1 1)
				(Say gEgo 47 7) ; "Just get in the car!"
				(= seconds 3)
			)
			(8
				(gEgo
					normal: 0
					view: 503
					loop: 1
					xStep: 7
					yStep: 5
					setCycle: Walk
					setMotion: MoveTo 330 95
				)
				(pat
					view: 20
					setLoop: -1
					xStep: 5
					yStep: 3
					setCycle: Walk
					setMotion: PolyPath 301 50 self
				)
			)
			(9
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(pat view: 457 posn: 300 30 loop: 1 cel: 7 setCycle: Beg self)
			)
			(10
				(HandsOn)
				(ClearFlag 64)
				(gCurRoom newRoom: 25)
			)
		)
	)
)

(instance roomSFX of Sound
	(properties)
)

(instance roomSFX2 of Sound
	(properties)
)

(instance streetSFX of Sound
	(properties
		flags 1
		number 913
		loop -1
	)
)

(instance pat of Actor
	(properties
		x 300
		y 30
		view 457
		loop 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Talk
				(if (trunk showing:)
					(super doVerb: theVerb invItem &rest)
				else
					(gCurRoom setScript: sTalkToPat)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance suspectCarActor of Actor
	(properties
		x 94
		y 139
		description {the car}
		sightAngle 40
		approachX 117
		approachY 158
		yStep 11
		view 500
		priority 10
		signal 24592
		xStep 15
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((trunk showing:)
						(super doVerb: theVerb invItem &rest)
					)
					((== local0 1)
						(Print 47 8) ; "You can't take a paint sample without the proper field equipment."
					)
					(else
						(Print 47 9) ; "You can't search the inside of the car without a warrant."
					)
				)
			)
			(2 ; Look
				(cond
					((trunk showing:)
						(super doVerb: theVerb invItem &rest)
					)
					((!= local0 1)
						(= local0 1)
						(roomSFX2 number: 471 flags: 1 play:)
						(Print 47 10) ; "You look at the parked car and notice that the license plates are missing. The car matches the description of the suspect vehicle."
						(Print 47 11) ; "Giving the car a closer look, you see what appears to be a fresh white paint transfer."
						(Print 47 12) ; "Bingo", you mutter, "I got you now, you S.O.B..."
					)
					(else
						(Print 47 13) ; "You inspect the suspect car once more, and find no evidence other than the paint transfer."
					)
				)
			)
			(4 ; Inventory
				(if (trunk showing:)
					(super doVerb: theVerb invItem &rest)
				else
					(switch invItem
						(22 ; tracker
							(Print 47 14) ; "You plant the tracking device on the suspect vehicle."
							(HandsOff)
							(= local2 502)
							(gEgo put: 22 47) ; tracker
							(SetScore 165 10)
							(gCurRoom setScript: sSuspectCar)
						)
						(39 ; scraper
							(if (not (IsFlag 166))
								(Print 47 15) ; "You carefully scrape some of the white paint transfer off and put it in an envelope."
								(HandsOff)
								(SetScore 166 5)
								(gEgo get: 30) ; whitePaint
								(= local2 501)
								(gCurRoom setScript: sSuspectCar)
							else
								(Print 47 16) ; "You don't need any more paint."
							)
						)
						(42 ; sampleEnv
							(if (gEgo has: 30) ; whitePaint
								(Print 47 17) ; "The car won't fit in the envelope."
							else
								(Print 47 18) ; "You need to get the paint sample before you can store it in an envelope."
							)
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tire of Actor
	(properties
		x 134
		y 143
		view 500
		loop 1
		cel 4
		priority 10
		signal 16400
	)
)

(instance smoke of Actor
	(properties
		x 134
		y 142
		view 500
		loop 2
		signal 16384
		cycleSpeed 12
	)
)

(instance sInset of Prop
	(properties
		x 44
		y 107
		description {Sonny}
		view 25
		priority 15
		signal 16401
	)

	(method (init)
		(sMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(sShirt posn: (+ (self x:) 3) (+ (self y:) 61) init:)
		(sEyes posn: (self x:) (self y:) setScript: egoBlink init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(sMouth dispose:)
		(sShirt dispose:)
		(sEyes dispose:)
	)
)

(instance sMouth of Prop
	(properties
		description {Sonny}
		view 25
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance sShirt of View
	(properties
		description {Sonny}
		view 25
		cel 1
		priority 15
		signal 16401
	)
)

(instance sEyes of Prop
	(properties
		description {Sonny}
		view 25
		loop 2
		priority 15
		signal 16400
	)
)

(instance egoBlink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(sEyes cel: 1)
				(= cycles 2)
			)
			(2
				(sEyes cel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance pInset of Prop
	(properties
		x 72
		y 126
		description {Pat Morales}
		view 27
		priority 15
		signal 16401
	)

	(method (init)
		(pMouth posn: (self x:) (self y:) setCycle: RandCycle init:)
		(pShirt posn: (+ (self x:) 2) (+ (self y:) 62) init:)
		(self stopUpd:)
		(super init:)
	)

	(method (dispose)
		(super dispose:)
		(pMouth dispose:)
		(pShirt dispose:)
	)
)

(instance pMouth of Prop
	(properties
		description {Pat Morales}
		view 27
		loop 1
		priority 15
		signal 16401
		cycleSpeed 9
	)
)

(instance pShirt of View
	(properties
		description {pat}
		view 27
		cel 1
		priority 15
		signal 16401
	)
)

(instance nuggetSign of Prop
	(properties
		x 35
		y 38
		description {the sign}
		sightAngle 40
		lookStr {the neon sign.}
		view 504
		cel 2
		priority 15
		signal 16
		cycleSpeed 8
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bugs of Prop
	(properties
		x 279
		y 103
		description {the insects}
		sightAngle 40
		lookStr {The light attracts the bugs.}
		view 504
		loop 2
		cel 4
		priority 14
		signal 16400
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance barDoor of Prop
	(properties
		x 44
		y 105
		description {the bar door}
		sightAngle 40
		approachX 62
		approachY 107
		lookStr {This place looks pretty rugged.__Better be on your toes.}
		view 504
		loop 3
		signal 16384
		cycleSpeed 8
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (trunk showing:)
					(super doVerb: theVerb invItem &rest)
				else
					(HandsOff)
					(gCurRoom setScript: sToBar)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance unmarkedCar of View
	(properties
		x 319
		y 78
		description {the car}
		sightAngle 40
		lookStr {You look fondly at your car.}
		view 490
		priority 4
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance suspectCarView of View
	(properties
		x 94
		y 139
		description {the car}
		sightAngle 40
		approachX 117
		approachY 158
		view 500
		priority 10
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(cond
					((trunk showing:)
						(super doVerb: theVerb invItem &rest)
					)
					((== local0 1)
						(Print 47 8) ; "You can't take a paint sample without the proper field equipment."
					)
					(else
						(Print 47 9) ; "You can't search the inside of the car without a warrant."
					)
				)
			)
			(2 ; Look
				(cond
					((trunk showing:)
						(super doVerb: theVerb invItem &rest)
					)
					((!= local0 1)
						(= local0 1)
						(roomSFX2 number: 471 flags: 1 play:)
						(Print 47 10) ; "You look at the parked car and notice that the license plates are missing. The car matches the description of the suspect vehicle."
						(Print 47 11) ; "Giving the car a closer look, you see what appears to be a fresh white paint transfer."
						(Print 47 19) ; "Bingo", you mutter, "I got you now, you S.O.B..."
					)
					(else
						(Print 47 13) ; "You inspect the suspect car once more, and find no evidence other than the paint transfer."
					)
				)
			)
			(4 ; Inventory
				(if (trunk showing:)
					(super doVerb: theVerb invItem &rest)
				else
					(switch invItem
						(22 ; tracker
							(Print 47 14) ; "You plant the tracking device on the suspect vehicle."
							(HandsOff)
							(= local2 502)
							(gEgo put: 22 47) ; tracker
							(SetScore 165 10)
							(gCurRoom setScript: sSuspectCar)
						)
						(39 ; scraper
							(if (not (IsFlag 166))
								(Print 47 15) ; "You carefully scrape some of the white paint transfer off and put it in an envelope."
								(HandsOff)
								(SetScore 166 5)
								(gEgo get: 30) ; whitePaint
								(= local2 501)
								(gCurRoom setScript: sSuspectCar)
							else
								(Print 47 16) ; "You don't need any more paint."
							)
						)
						(42 ; sampleEnv
							(if (gEgo has: 30) ; whitePaint
								(Print 47 17) ; "The car won't fit in the envelope."
							else
								(Print 47 18) ; "You need to get the paint sample before you can store it in an envelope."
							)
						)
						(else
							(super doVerb: theVerb invItem &rest)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tireMarks of View
	(properties
		x 134
		y 138
		description {the tire marks}
		sightAngle 40
		lookStr {You can still smell the rubber left in those tire marks.}
		view 504
		loop 1
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(if (trunk showing:)
					(super doVerb: theVerb invItem &rest)
				else
					(switch invItem
						(39 ; scraper
							(Print 47 20) ; "Rubber's just rubber. If you want some there's easier ways to get it than scraping it off the street."
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance carTrunk of Feature
	(properties
		description {the car}
		sightAngle 40
		onMeCheck 8192
		approachX 311
		approachY 39
		lookStr {You look fondly at your car.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (== local0 1)
					(trunk open:)
				else
					(Print 47 21) ; "There is no apparent need for anything in the trunk right now."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance carDoor of Feature
	(properties
		description {the car}
		sightAngle 40
		onMeCheck 4096
		lookStr {You look fondly at your car.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 47 22) ; "Convinced that the serial killer will strike here next, you decide to stick around."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance garageDoor of Feature
	(properties
		description {the garage door}
		sightAngle 40
		onMeCheck 64
		lookStr {This part of town has numerous parking garages and small lots.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance windows of Feature
	(properties
		description {the window}
		sightAngle 40
		onMeCheck 16
		lookStr {The windows are tinted.__You can't see inside from here.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance alley of Feature
	(properties
		description {the alley}
		sightAngle 40
		onMeCheck 8
		lookStr {An alley runs alongside the Old Nugget.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance streetSign of Feature
	(properties
		x 135
		y 319
		description {the sign}
		sightAngle 40
		onMeCheck 32
		lookStr {Billboards are not uncommon in this part of town.__They make streets even uglier than they already are.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance nugget of Feature
	(properties
		description {the Nugget}
		sightAngle 40
		onMeCheck 512
		lookStr {This is the infamous Old Nugget saloon.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 47 23) ; "Just use the front door."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance mug of Feature
	(properties
		description {the sign}
		sightAngle 40
		onMeCheck 256
		lookStr {Based on Paul Bunyan's mug there, I'd say it's a safe bet that they serve beer here.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 47 24) ; "If you want a drink, you'd have better luck inside."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance neonSign of Feature
	(properties
		description {the sign}
		sightAngle 40
		onMeCheck 1024
		lookStr {The sign says 'Old Nugget'. It's neon glow attracts insects (including those of the human variety).}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(Print 47 23) ; "Just use the front door."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

