;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use eRS)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	cloudX
	cloud2X
	clickCounter
	outOfTime
	larryStop
)

(instance rm390 of LLRoom
	(properties
		picture 390
	)

	(method (init)
		(super init:)
		(LoadMany rsFONT gNiceFont gGiantFont)
		(larry init: setCycle: End larry)
		(larryHead init: setCycle: Fwd)
		(plane init: setScript: sPlane)
		(panel1 init: setCycle: Fwd)
		(panel2 init: setCycle: Fwd)
		(panel3 init: setCycle: Fwd)
		(panel4 init: setCycle: Fwd)
		(panel5 init: setCycle: Fwd)
		(panel6 init: setCycle: Fwd)
		(panel7 init: setCycle: Fwd)
		(panel8 init: setCycle: Fwd)
		(cloud init: setScript: sCloud)
		(cloud2 init: setScript: sCloud2)
		(frontCloud init: setScript: sFrontCloud)
		(frontCloud2 init: setScript: sFrontCloud2)
		(wheel init: setCycle: Fwd)
		(wheel2 init: setCycle: Fwd)
		(windows init:)
		(console init:)
		(throttle init:)
		(bigLarry init:)
		(thePlane init:)
		(self setScript: sPlaneCartoon)
		(SetFFRoom 310)
	)

	(method (newRoom newRoomNumber)
		(gTheMusic stop:)
		(gTheMusic2 stop:)
		(super newRoom: newRoomNumber)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 390 0) ; "No matter where you look, nothing looks familiar! Whatever made you think those hours you killed playing "Red Baron" when you should have been working could possibly prepare you to handle a modern passenger jet?"
			)
			(5 ; Talk
				(TPrint 390 1 #font gGiantFont #title {You}) ; ""AAAAEEEEEEEE!" you scream."
			)
			(4 ; Inventory
				(TPrint 390 2) ; "Oh, right! Like that's gonna help you land this thing!"
			)
			(10 ; Zipper
				(TPrint 390 3) ; "You're too late. You drained your bladder shortly after entering the cockpit!"
			)
			(3 ; Do
				(switch (++ clickCounter)
					(1
						(TPrint 390 4) ; "You turn on the radio."
						(TPrint 390 5 #at -1 185) ; "(It's tuned to a nice, soft-rock, easy-listening, MOR, album station.)"
					)
					(2
						(TPrint 390 6) ; "The wing surface deicers go to work, quickly removing any trace of ice from the hot summer sun-baked flight surfaces."
					)
					(3
						(TPrint 390 7) ; "Good idea! Change to the auxiliary fuel tanks!!"
					)
					(4
						(TPrint 390 8) ; "You change back to the main fuel tanks!"
					)
					(5
						(TPrint 390 9) ; "You flip the switch that signals the stewardess to bring you a fresh cocktail!"
					)
					(else
						(if (== (sPlaneCartoon state:) 5)
							(gCurRoom setScript: sAutoPilot)
						else
							(TPrint 390 10) ; "How you wish you had acted earlier!"
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

(instance sPlane of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(plane setLoop: 1 cycleSpeed: 1 setCycle: Fwd)
				(= cycles (Random 20 30))
			)
			(1
				(plane setLoop: 2 setCel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(2
				(plane setLoop: 1 cycleSpeed: 1 setCycle: Fwd)
				(= cycles (Random 20 30))
			)
			(3
				(plane setLoop: 3 setCel: 0 cycleSpeed: 0 setCycle: End self)
			)
			(4
				(self init:)
			)
		)
	)
)

(instance panel1 of Prop
	(properties
		x 14
		y 18
		description {the panel}
		view 390
		priority 4
		signal 18448
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance panel2 of Prop
	(properties
		x 147
		y 18
		description {the panel}
		view 390
		loop 1
		cel 2
		priority 4
		signal 18448
		detailLevel 1
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance panel3 of Prop
	(properties
		x 98
		y 18
		description {the panel}
		view 390
		loop 2
		cel 1
		priority 4
		signal 18448
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance panel4 of Prop
	(properties
		x 76
		y 92
		description {the panel}
		view 390
		loop 3
		cel 4
		priority 4
		signal 18448
		detailLevel 2
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance panel5 of Prop
	(properties
		x 192
		y 95
		description {the panel}
		view 390
		loop 4
		cel 2
		priority 4
		signal 18448
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance panel6 of Prop
	(properties
		x 192
		y 18
		description {the panel}
		view 390
		loop 5
		cel 5
		priority 4
		signal 18448
		detailLevel 3
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance panel7 of Prop
	(properties
		x 283
		y 13
		description {the panel}
		view 390
		loop 6
		cel 2
		priority 4
		signal 18448
		detailLevel 4
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance panel8 of Prop
	(properties
		x 280
		y 83
		description {the panel}
		view 390
		loop 7
		cel 1
		priority 4
		signal 18448
		detailLevel 4
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance wheel of Prop
	(properties
		x 92
		y 66
		description {the yoke}
		view 390
		loop 8
		priority 6
		signal 18448
		cycleSpeed 1
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance wheel2 of Prop
	(properties
		x 223
		y 65
		description {the yoke}
		view 390
		loop 8
		priority 6
		signal 18448
		cycleSpeed 1
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance cloud of Actor
	(properties
		description {the cloud}
		view 392
		priority 2
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 390 11) ; "Your jetliner plummets through those clouds like a hot knife through a buttery-flavored, artifical, non-dairy, lard-like, food product substance."
			)
			(3 ; Do
				(TPrint 390 12) ; "As much as you'd like to grab onto the clouds, you just can't do it from inside the cockpit."
				(TPrint 390 13 #at -1 185) ; "(However, you soon may be sitting on one, strumming your harp!)"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance cloud2 of Actor
	(properties
		description {the cloud}
		view 392
		priority 2
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(cloud doVerb: theVerb invItem &rest)
	)
)

(instance frontCloud of Actor
	(properties
		description {the cloud}
		yStep 25
		view 392
		cel 3
		priority 2
		signal 22544
		xStep 25
	)

	(method (doVerb theVerb invItem)
		(cloud doVerb: theVerb invItem &rest)
	)
)

(instance frontCloud2 of Actor
	(properties
		description {the cloud}
		yStep 25
		view 392
		cel 3
		priority 2
		signal 22544
		xStep 25
	)

	(method (doVerb theVerb invItem)
		(cloud doVerb: theVerb invItem &rest)
	)
)

(instance sFrontCloud of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(frontCloud hide:)
				(= cycles (Random 2 4))
			)
			(1
				(frontCloud
					show:
					setCel: (Random 0 3)
					setStep: (+ (frontCloud xStep:) 2) (+ (frontCloud yStep:) 2)
				)
				(switch (Random 1 4)
					(1
						(frontCloud posn: 144 19 setMotion: MoveTo 0 67 self)
					)
					(2
						(frontCloud posn: 141 44 setMotion: MoveTo 0 11 self)
					)
					(3
						(frontCloud posn: 144 19 setMotion: MoveTo -24 40 self)
					)
					(4
						(frontCloud posn: 141 44 setMotion: MoveTo -24 40 self)
					)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sFrontCloud2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(frontCloud2 hide:)
				(= cycles (Random 2 4))
			)
			(1
				(frontCloud2
					show:
					setCel: (Random 0 3)
					setStep:
						(+ (frontCloud2 xStep:) 2)
						(+ (frontCloud2 yStep:) 2)
				)
				(switch (Random 1 4)
					(1
						(frontCloud2 posn: 177 20 setMotion: MoveTo 319 67 self)
					)
					(2
						(frontCloud2 posn: 177 20 setMotion: MoveTo 334 42 self)
					)
					(3
						(frontCloud2 posn: 182 43 setMotion: MoveTo 319 14 self)
					)
					(4
						(frontCloud2 posn: 182 43 setMotion: MoveTo 334 42 self)
					)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance sCloud of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cloudX (Random 138 227))
				(cloud
					setCel: (Random 0 3)
					posn: cloudX (Random 190 200)
					setStep: 10 (Random 10 15)
					setMotion: MoveTo cloudX (Random 85 95) self
				)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance sCloud2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cloud2X (Random 249 340))
				(cloud2
					setCel: (Random 0 3)
					posn: cloud2X (Random 190 200)
					setStep: 10 (Random 10 15)
					setMotion: MoveTo cloud2X (Random 85 95) self
				)
			)
			(1
				(self init:)
			)
		)
	)
)

(instance theMusic3 of Sound ; UNUSED
	(properties)
)

(instance console of Feature
	(properties
		x 162
		y 55
		nsTop 35
		nsLeft 70
		nsBottom 75
		nsRight 255
		description {the console}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance throttle of Feature
	(properties
		x 158
		y 86
		nsTop 76
		nsLeft 131
		nsBottom 96
		nsRight 186
		description {the throttle}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance windows of Feature
	(properties
		x 157
		y 34
		nsLeft 3
		nsBottom 69
		nsRight 312
		description {the window}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(gCurRoom doVerb: theVerb invItem &rest)
	)
)

(instance sPlaneCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(HandsOn)
				(User canControl: 0)
				(gTheIconBar disable: 0)
				(= seconds 4)
			)
			(2
				(HandsOff)
				(TPrint 390 14 #dispose self) ; "Oh, Larry! Here's another fine mess you've gotten yourself into!"
			)
			(3
				(RestoreIB)
				(= ticks 30)
			)
			(4
				(HandsOff)
				(TPrint 390 15 #dispose self) ; "Whatever possessed you to volunteer to land a major aircraft? This is far different from your futile attempt a few years ago when you tried to sell flight simulator software for a major computer game company!"
			)
			(5
				(RestoreIB)
				(= seconds 30)
			)
			(6
				(HandsOff)
				(TPrint 390 16 #dispose self) ; "As the ground rushes headlong toward you, you decide to make a run for it! Maybe there are some parachutes tucked away under the stewardesses' seats. Maybe the other passengers won't notice you heading for the exit with a parachute tucked under your leisure suit. Maybe you'll be able to open the door. Maybe you'll be able to fly!"
			)
			(7
				(= ticks 30)
			)
			(8
				(TPrint 390 17 #dispose self) ; "As you rise to leave, you struggle against the severe G-forces pummelling your body, inadvertently catching the cuff of your leisure suit on an inconspicuous switch labeled "Auto Pilot.""
			)
			(9
				(= ticks 60)
			)
			(10
				(= outOfTime 1)
				(self setScript: sAutoPilot)
			)
		)
	)
)

(instance sAutoPilot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if outOfTime
					(self cue:)
				else
					(HandsOff)
					(TPrint 390 18 #dispose self) ; "Grasping at anything and everything on the dashboard, you brilliantly (and totally accidentally) hit something called an "Auto Pilot.""
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(if (not outOfTime)
					(Points 100)
				)
				(plane setLoop: 1 setCel: 0 setScript: 0)
				(wheel setCycle: Beg)
				(wheel2 setCycle: Beg)
				(sCloud dispose:)
				(sCloud2 dispose:)
				(sFrontCloud dispose:)
				(sFrontCloud2 dispose:)
				(= cycles 8)
			)
			(3
				(frontCloud show: setCel: 1 posn: 56 39)
				(frontCloud2 show: setCel: 2 posn: 249 44)
				(= larryStop 1)
				(larryHead setCycle: Beg)
				(TPrint 390 19 #dispose self) ; "The airplane's computer takes over, stopping its spin, leveling out the plane, and preventing certain disaster!"
			)
			(4
				(cloud
					show:
					setCel: 0
					posn: 245 138
					xStep: 2
					moveSpeed: 10
					setMotion: MoveTo 120 138
				)
				(cloud2
					show:
					setCel: 3
					posn: 310 173
					xStep: 2
					moveSpeed: 10
					setMotion: MoveTo 180 173
				)
				(plane setLoop: 4 setCel: 0 setCycle: End self)
			)
			(5
				(= seconds 4)
			)
			(6
				(TPrint 390 20 #font gNiceFont #width 200 #mode 1 #dispose self) ; "YOU DID IT, LARRY!"
			)
			(7
				(= ticks 120)
			)
			(8
				(TPrint 390 21 #dispose self) ; "But there's a slight problem... now you've got to land this sucker!"
			)
			(9
				(gCurRoom newRoom: 310)
			)
		)
	)
)

(instance plane of Actor
	(properties
		x 249
		y 137
		description {your plane}
		view 392
		loop 1
		priority 3
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(thePlane doVerb: theVerb &rest)
	)
)

(instance larryHead of Prop
	(properties
		x 65
		y 113
		z 50
		description {yourself}
		view 391
		loop 2
		priority 7
		signal 16400
	)

	(method (doVerb theVerb invItem)
		(bigLarry doVerb: theVerb &rest)
	)
)

(instance larry of Prop
	(properties
		x 70
		y 189
		description {yourself}
		view 391
		priority 6
		signal 18448
	)

	(method (cue)
		(if larryStop
			(self setCel: 2)
		else
			(self setCel: (Random 0 3))
			(Delay (Random 2 4) 1 larry)
		)
	)

	(method (doVerb theVerb invItem)
		(bigLarry doVerb: theVerb &rest)
	)
)

(instance bigLarry of Feature
	(properties
		x 79
		y 149
		z 7
		nsTop 96
		nsBottom 189
		nsRight 158
		description {you}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 390 22) ; "You look like you're gonna die!"
			)
			(5 ; Talk
				(TPrint 390 23) ; "You begin to talk to yourself then realize, "I've gotta fly this sucker!""
			)
			(3 ; Do
				(TPrint 390 24) ; "You scratch your ear instead of saving this plane!"
			)
			(4 ; Inventory
				(TPrint 390 25) ; "That won't help! Do something!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance thePlane of Feature
	(properties
		x 238
		y 151
		z 9
		nsTop 95
		nsLeft 157
		nsBottom 189
		nsRight 319
		description {the plane}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 390 26) ; "This is your plane, plummeting to Earth, soon to crash, killing all aboard."
			)
			(5 ; Talk
				(TPrint 390 27) ; ""MAYDAY! MAYDAY!!" you scream, into no apparent microphone!"
			)
			(4 ; Inventory
				(TPrint 390 28) ; "That won't help a falling airplane!"
			)
			(3 ; Do
				(TPrint 390 29) ; "How you wish it were that simple--to just reach outside and grab your airplane, pull it back to safety. But you've learned long ago: you're no Superman!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

