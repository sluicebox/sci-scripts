;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use eRS)
(use MCyc)
(use Feature)
(use Sound)
(use Motion)
(use Inventory)
(use Actor)
(use System)

(public
	rm310 0
)

(local
	birdX
	birdY
	birdFlying
	cueCounter
	[crash1Pts 25] = [1 1 58 71 1 2 80 99 1 3 98 121 1 4 118 141 1 5 131 149 1 6 145 156 -32768]
	[crash1aPts 9] = [1 7 171 150 1 8 195 133 -32768]
	[crash2Pts 17] = [0 4 199 100 0 5 188 102 0 6 174 101 0 7 165 101 -32768]
	[crash3Pts 21] = [1 1 41 35 1 2 54 53 1 3 63 68 1 4 77 90 1 5 96 111 -32768]
	[crash3aPts 9] = [1 6 112 114 1 7 115 117 -32768]
	[crash4Pts 29] = [2 0 274 148 2 1 239 153 2 2 202 157 2 3 167 156 2 4 145 150 2 5 134 146 2 6 134 146 -32768]
)

(procedure (SetUpRoom)
	(gCurRoom drawPic: 310)
	(traffic init: setCycle: Fwd)
	(switch gLarryLoc
		(0
			(sock init: posn: 260 164 setCycle: Fwd)
			(flag init: setLoop: 1 posn: 29 40 setCycle: Fwd)
			(tree1 init:)
			(tree2 init:)
			(tree3 init:)
			(tree4 init:)
			(tree5 init:)
			(water1 init:)
			(water2 init:)
			(mnt1 init:)
			(mnt2 init:)
			(cloud init:)
		)
		(1
			(sock init: posn: 185 116 setCycle: Fwd)
			(flag init: setLoop: 3 posn: 34 44 setCycle: Fwd)
		)
		(3
			(sock init: posn: 260 164 setCycle: Fwd)
			(flag init: setLoop: 3 posn: 10 44 setCycle: Fwd)
		)
		(2
			(sock init: posn: 260 164 setCycle: Fwd)
			(flag init: setLoop: 3 posn: 10 44 setCycle: Fwd)
		)
	)
	(if (!= gPrevRoomNum 390)
		(switch (Random 1 10)
			(1
				(= birdX -12)
				(= birdY 133)
				(= birdFlying 1)
				(bird init: setLoop: 4 posn: 327 47 hide:)
			)
			(2
				(= birdX 73)
				(= birdY 189)
				(= birdFlying 1)
				(bird init: setLoop: 4 posn: 319 98 hide:)
			)
			(3
				(= birdX 0)
				(= birdY 103)
				(= birdFlying 1)
				(bird init: setLoop: 4 posn: 319 138 hide:)
			)
			(4
				(= birdX 0)
				(= birdY 38)
				(= birdFlying 1)
				(bird init: setLoop: 4 posn: 319 36 hide:)
			)
			(5
				(= birdX 319)
				(= birdY 63)
				(= birdFlying 1)
				(bird init: setLoop: 5 posn: 0 123 hide:)
			)
			(6
				(= birdX 319)
				(= birdY 120)
				(= birdFlying 1)
				(bird init: setLoop: 5 posn: 0 40 hide:)
			)
			(7
				(= birdX 319)
				(= birdY 120)
				(= birdFlying 1)
				(bird init: setLoop: 5 posn: 0 40 hide:)
			)
		)
	)
)

(instance rm310 of LLRoom
	(properties
		lookStr {To you, all airports look alike (although the landscaping does vary slightly).}
		north 160
		east 160
		south 160
		west 160
	)

	(method (init)
		(super init:)
		(HandsOff)
		(sky init:)
		(aTree init:)
		(aTree2 init:)
		(aTree3 init:)
		(aPlane init:)
		(aPlane2 init:)
		(tower init:)
		(SetUpRoom)
		(switch gPrevRoomNum
			(320
				(Load rsSOUND 314)
				(Load rsSOUND 312)
				(gTheMusic2 number: 0 client: 0 stop:)
				(self setScript: sLand)
			)
			(390
				(theMusic3 init: number: 386 flags: 1 play: setLoop: -1)
				(self setScript: sCrash)
			)
			(else
				(if (== gREMState 3)
					(self setScript: sFlyGumbo)
				else
					(self setScript: sFly)
				)
			)
		)
		(gAddToPics doit:)
	)

	(method (newRoom newRoomNumber)
		(if (== gPrevRoomNum 390)
			(gTheMusic stop:)
			(gTheMusic2 stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(if birdFlying
			(switch (++ cueCounter)
				(1
					(bird
						show:
						setStep: 4 4
						setCycle: Fwd
						setMotion: MoveTo birdX birdY self
					)
				)
				(2
					(= birdFlying 0)
					(bird dispose:)
				)
			)
		)
	)
)

(instance plane of Actor
	(properties
		view 311
		priority 13
		signal 30736
	)
)

(instance bird of Actor
	(properties
		view 310
		priority 15
		signal 26640
	)
)

(instance traffic of Prop
	(properties
		x 261
		y 55
		view 310
		priority 2
		signal 18448
	)
)

(instance sock of Prop
	(properties
		view 310
		loop 2
		priority 14
		signal 18448
	)
)

(instance flag of Prop
	(properties
		view 310
		priority 4
		signal 18448
	)
)

(instance arrow of View
	(properties
		view 315
	)
)

(instance dash of View
	(properties
		view 315
		signal 22544
	)
)

(instance sLand of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic number: 312 loop: 1 play:)
				(= cycles 2)
			)
			(1
				(plane
					init:
					posn: 319 53
					setLoop: 4
					setCel: 0
					setStep: 7 7
					cycleSpeed: 10
					moveSpeed: 3
					setMotion: MoveTo 194 115 self
				)
			)
			(2
				(gTheMusic2 number: 314 loop: 1 play:)
				(plane
					setCycle: End
					setStep: 6 6
					setMotion: MoveTo 104 121 self
				)
				(= ticks 16)
			)
			(3
				(gTheMusic2 stop:)
			)
			(4
				(plane setStep: 4 4 setMotion: MoveTo -39 127 self)
				(= ticks 20)
			)
			(5
				(gTheMusic fade: 0 15 12 1)
			)
			(6
				(= seconds 4)
			)
			(7
				(= gLarryLoc ((Inv at: 8) state:)) ; Boarding_Pass
				(if (!= ((Inv at: 1) owner:) 23) ; Battery_Charger
					((Inv at: 1) owner: 0) ; Battery_Charger
				)
				(ClearFlag 8) ; fBeenToTown
				(ClearFlag 32) ; fOkToBoard
				(gCurRoom newRoom: 290)
			)
		)
	)
)

(instance tree1 of PicView
	(properties
		x 139
		y 122
		view 310
		loop 6
		cel 3
		priority 14
		signal 18448
	)
)

(instance tree2 of PicView
	(properties
		x 14
		y 146
		view 310
		loop 6
		cel 1
		priority 14
		signal 18448
	)
)

(instance tree3 of PicView
	(properties
		y 144
		view 310
		loop 6
		cel 2
		priority 14
		signal 18448
	)
)

(instance tree4 of PicView
	(properties
		x 22
		y 179
		view 310
		loop 6
		priority 14
		signal 18448
	)
)

(instance tree5 of PicView
	(properties
		x 305
		y 176
		view 310
		loop 6
		cel 2
		priority 14
		signal 18448
	)
)

(instance water1 of PicView
	(properties
		x 40
		y 45
		view 310
		loop 8
		priority 1
		signal 18448
	)
)

(instance water2 of PicView
	(properties
		x 179
		y 44
		view 310
		loop 8
		cel 1
		priority 1
		signal 18448
	)
)

(instance mnt1 of PicView
	(properties
		x 234
		y 38
		view 310
		loop 7
		priority 1
		signal 18448
	)
)

(instance mnt2 of PicView
	(properties
		x 198
		y 36
		view 310
		loop 7
		priority 1
		signal 18448
	)
)

(instance cloud of PicView
	(properties
		x 221
		y 32
		view 310
		loop 7
		cel 1
		priority 1
		signal 18448
	)
)

(instance sky of Feature
	(properties
		x 159
		y 20
		nsTop -1
		nsBottom 41
		nsRight 319
		description {the sky}
		sightAngle 40
		lookStr {Hills stretch off into the distance.}
	)
)

(instance aTree of Feature
	(properties
		x 24
		y 127
		nsTop 77
		nsBottom 177
		nsRight 49
		description {the trees}
		sightAngle 40
		lookStr {This airport is rife with trees.}
	)
)

(instance aTree2 of Feature
	(properties
		x 300
		y 142
		nsTop 108
		nsLeft 282
		nsBottom 176
		nsRight 319
		description {the tree}
		sightAngle 40
		lookStr {This airport is rife with trees.}
	)
)

(instance aTree3 of Feature
	(properties
		x 142
		y 98
		nsTop 73
		nsLeft 122
		nsBottom 124
		nsRight 162
		description {the trees}
		sightAngle 40
		lookStr {This airport is rife with trees.}
	)
)

(instance aPlane of Feature
	(properties
		x 95
		y 66
		nsTop 58
		nsLeft 71
		nsBottom 74
		nsRight 120
		description {the airplane}
		sightAngle 40
		lookStr {You hope you don't have to wait for that airplane to take off.}
	)
)

(instance aPlane2 of Feature
	(properties
		x 231
		y 65
		nsTop 59
		nsLeft 216
		nsBottom 71
		nsRight 246
		description {the airplane}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(aPlane doVerb: theVerb invItem &rest)
	)
)

(instance tower of Feature
	(properties
		x 265
		y 56
		nsTop 34
		nsLeft 248
		nsBottom 79
		nsRight 282
		description {the tower}
		sightAngle 40
		lookStr {The control tower is staffed with non-union air traffic controllers.}
	)
)

(instance sCrash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(TPrint 310 0 #dispose self) ; "There's the runway, Larry! Steady now. Bring 'er in carefully! You're "coming in" too fast!"
			)
			(2
				(= ticks 30)
			)
			(3
				(gTheMusic2 number: 396 loop: 1 play:)
				(plane
					init:
					posn: 39 50
					setLoop: 1
					setCel: 0
					setStep: 10 10
					moveSpeed: 2
					cycleSpeed: 9
					ignoreActors: 1
					illegalBits: 0
					setCycle: MCyc @crash1Pts self
				)
			)
			(4
				(gTheMusic number: 313 loop: 1 play:)
				(TPrint 310 1 #at -1 28 #title {You} #dispose) ; ""YEOW!" you scream!"
				(= cycles 2)
			)
			(5
				(gTheMusic2 number: 392 loop: 1 play:)
				(plane setCycle: MCyc @crash1aPts self)
			)
			(6
				(plane setMotion: MoveTo 319 50 self)
			)
			(7
				(plane hide:)
				(= seconds 3)
			)
			(8
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(TPrint 310 2 #dispose self) ; "Whew! That was close. You just barely "pulled out" in time!"
			)
			(9
				(= seconds 2)
			)
			(10
				(gTheMusic2 number: 396 loop: 1 play:)
				(plane
					show:
					setLoop: 0
					setCel: 0
					posn: 315 1
					setMotion: MoveTo 217 102 self
				)
			)
			(11
				(TPrint 310 3 #at -1 185 #title {You} #dispose) ; ""OH, NO!!" you scream!"
				(gTheMusic number: 313 loop: 1 play:)
				(plane setCycle: CT 2 1 self)
			)
			(12
				(gTheMusic2 number: 392 loop: 1 play:)
				(plane setCel: 3 posn: 210 101 setCycle: MCyc @crash2Pts self)
			)
			(13
				(plane setCel: 8 setMotion: MoveTo 46 3 self)
			)
			(14
				(plane hide:)
				(= seconds 3)
			)
			(15
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(TPrint 310 4 #dispose self) ; "Larry! You've got to "keep it up" longer!"
			)
			(16
				(= seconds 3)
			)
			(17
				(TPrint 310 5 #dispose self) ; "You circle around 180 degrees to try again."
			)
			(18
				(= seconds 3)
			)
			(19
				(gTheMusic2 number: 396 loop: 1 play:)
				(plane
					setLoop: 1
					setCel: 0
					posn: 21 -4
					setCycle: MCyc @crash3Pts self
					show:
				)
			)
			(20
				(gTheMusic number: 313 loop: 1 play:)
				(= ticks 2)
			)
			(21
				(gTheMusic2 number: 392 loop: 1 play:)
				(plane setCycle: MCyc @crash3aPts self show:)
			)
			(22
				(plane setCel: 8 setMotion: MoveTo 250 -5 self)
			)
			(23
				(plane hide:)
				(= ticks 20)
			)
			(24
				(TPrint 310 6) ; "Next time, try it with both hands on your "yoke!""
				(= seconds 5)
			)
			(25
				(TPrint 310 7 #at -1 28 #title {You} #dispose) ; "This is it," you think, "I've got to make it this time!"
				(= seconds 2)
			)
			(26
				(plane
					show:
					setLoop: 2
					setCel: 0
					posn: 331 136
					setCycle: MCyc @crash4Pts self
				)
			)
			(27
				(gTheMusic2 number: 314 loop: 1 play:)
				(gTheMusic stop:)
				(theMusic3 stop:)
				(plane
					setLoop: 5
					setCel: 0
					cycleSpeed: 9
					setCycle: End
					setMotion: MoveTo 86 115
				)
				(= seconds 5)
			)
			(28
				(gTheMusic number: 391 loop: 1 play:)
				(TPrint 310 8 #at -1 15 #width 280 #dispose self) ; "You did it, Larry! You saved an entire airliner filled with innocent people. Surely, you'll finally gain the respect you deserve."
			)
			(29
				(= seconds 2)
			)
			(30
				(TPrint 310 9) ; "But how stupid were those airport designers! They built a runway 100 feet long..."
				(TPrint 310 10) ; "...and TWO MILES wide!"
				(= seconds 3)
			)
			(31
				(gCurRoom newRoom: 295)
			)
		)
	)
)

(instance sTakeOff of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gTheMusic number: 311 loop: 1 play: hold: 10)
				(plane
					init:
					show:
					posn: -38 127
					setLoop: 3
					setCel: 0
					setStep: 2 2
					cycleSpeed: 6
					moveSpeed: 2
				)
				(= ticks 60)
			)
			(1
				(plane setMotion: MoveTo 33 119 self)
			)
			(2
				(plane setStep: 3 3 setMotion: MoveTo 88 118 self)
			)
			(3
				(plane setStep: 4 4 setMotion: MoveTo 130 115 self)
			)
			(4
				(plane setCycle: End self setMotion: MoveTo 190 111)
			)
			(5
				(gTheMusic release: fade: 0 15 5 1)
				(plane setStep: 6 6 setMotion: MoveTo 353 12 self)
			)
			(6
				(plane dispose:)
				(self dispose:)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance sFlyGumbo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: sTakeOff self)
			)
			(1
				(gTheIconBar disable:)
				(= gREMState 3)
				(gTheMusic2 number: 315 loop: 1 play: self)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 315 10)
				(TPrint 310 11 #at -1 28 #dispose self) ; "Your visit to the East Coast finished, your airplane heads back to Los Angeles."
				(arrow init: setLoop: 1 setPri: 15 posn: 190 122)
				(dash
					init:
					setPri: 1
					setLoop: 2
					posn: (+ (arrow x:) 2) (- (arrow y:) 2)
					addToPic:
				)
			)
			(2
				(= ticks 30)
				(= register 8)
			)
			(3
				(= start state)
				(arrow posn: (- (arrow x:) 5) (- (arrow y:) 1))
				(= ticks 30)
			)
			(4
				(dash
					init:
					setPri: 1
					setLoop: 2
					posn: (+ (arrow x:) 2) (- (arrow y:) 2)
					addToPic:
				)
				(= ticks 30)
			)
			(5
				(if (not (-- register))
					(gTheMusic number: 321 loop: -1 play:)
					(= cycles 2)
				else
					(self init:)
				)
			)
			(6
				(gTheIconBar enable:)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance sFly of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: sTakeOff self)
			)
			(1
				(if (== gLarryLoc 0)
					(gTheIconBar disable:)
					(gTheMusic2 number: 315 loop: 1 play: self)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(gCast eachElementDo: #dispose)
					(gCurRoom drawPic: 315 10)
					(arrow init: setPri: 15 posn: 52 103 setLoop: 0)
					(dash
						init:
						setPri: 1
						setLoop: 2
						posn: (- (arrow x:) 2) (- (arrow y:) 2)
						addToPic:
					)
					(= seconds 2)
					(= register 6)
				else
					(gCurRoom drawPic: 1 10)
					(gCurRoom newRoom: 320)
				)
			)
			(2
				(= start state)
				(arrow posn: (+ (arrow x:) 5) (- (arrow y:) 2))
				(= ticks 30)
			)
			(3
				(dash
					init:
					setPri: 1
					setLoop: 2
					posn: (- (arrow x:) 2) (- (arrow y:) 2)
					addToPic:
				)
				(= ticks 30)
			)
			(4
				(if (not (-- register))
					(= ticks 1)
					(= register 7)
					(arrow posn: (+ (arrow x:) 1) (- (arrow y:) 1))
				else
					(self init:)
				)
			)
			(5
				(= start state)
				(arrow posn: (+ (arrow x:) 5) (+ (arrow y:) 1))
				(= ticks 30)
			)
			(6
				(dash
					init:
					setPri: 1
					setLoop: 2
					posn: (- (arrow x:) 2) (- (arrow y:) 2)
					addToPic:
				)
				(= ticks 30)
			)
			(7
				(if (not (-- register))
					(gTheMusic number: 321 loop: -1 play:)
					(= cycles 2)
				else
					(self init:)
				)
			)
			(8
				(gTheIconBar enable:)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

