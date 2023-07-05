;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm900 0
)

(instance rm900 of LLRoom
	(properties
		picture 900
		north 905
	)

	(method (init)
		(Load rsSOUND 194)
		(Load rsSOUND 191)
		(Load rsSOUND 192)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 127 0 127 111 119 116 77 116 77 118 126 118 70 156 55 157 41 163 9 165 9 169 166 169 310 169 309 166 231 162 55 162 55 160 72 158 131 118 230 118 231 116 135 116 130 109 130 0 319 0 319 189 0 189
					yourself:
				)
		)
		(gEgo init: normalize: 552 setStep: 2 2)
		(if (== gPrevRoomNum 920)
			(SetupExit 0)
			(SetFlag 4)
			(self style: 7)
		)
		(if (not gLarryLoc)
			(= gLarryLoc 3)
		)
		(super init:)
		(if (IsFlag 1)
			(limo init: approachVerbs: 3) ; Do
		)
		(switch gPrevRoomNum
			(920
				(HandsOn)
				(gEgo posn: 214 163 0 setHeading: 180 edgeHit: 0)
			)
			(north
				(HandsOn)
				(gEgo posn: 123 116 0 setHeading: 180 setPri: 4)
				(gTheMusic number: 0 stop:)
				(gTheMusic2 number: 0)
			)
			(else
				(= gLarryLoc 3)
				(ClearFlag 1)
				(limo init:)
				(gCurRoom setScript: sExitLimo)
			)
		)
		(tooth init: cycleSpeed: 6 setCycle: Fwd)
		(palmTrees init:)
		(gymWindow init: approachVerbs: 3 2) ; Do, Look
		(gymSign init:)
		(docSign init:)
		(docDoor init: setPri: 1)
		(theDoor init: approachVerbs: 3) ; Do
		(gymDoor init: approachVerbs: 3) ; Do
		(building init:)
		(buildings init:)
		(sidewalk init:)
		(fence init:)
		(stairs init:)
		(window1 init: approachVerbs: 3 2) ; Do, Look
		(window2 init: approachVerbs: 3 2) ; Do, Look
		(if (== gPrevRoomNum 920)
			(HandsOff)
			(Delay 3 0 gCurRoom)
		)
		(theMusic3 number: 251 loop: -1 play:)
		(SetupExit 0)
		(SetFFRoom 0)
	)

	(method (cue)
		(TPrint 900 0) ; "You vow to get in shape!"
		(HandsOn)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (< (gEgo y:) 130)
					(TPrint 900 1) ; "From up here, you can see the Atlantic Ocean."
					(TPrint 900 2) ; "But, looking through the windows, all you can see is dental equipment and a lot of people wearing smocks!"
				else
					(TPrint 900 3) ; "A closed gymnastics studio is on the ground floor, while a dentist's office occupies the second floor."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (< (gEgo x:) 88) (< (gEgo y:) 130)) 0)
			(
				(and
					(!= (gEgo priority:) 4)
					(< (gEgo y:) 162)
					(> (gEgo y:) 120)
				)
				(gEgo setPri: 4)
			)
			((and (!= (gEgo priority:) 2) (< (gEgo y:) 120))
				(gEgo setPri: 2)
			)
			((and (== (gEgo priority:) 4) (> (gEgo y:) 161))
				(gEgo setPri: -1)
			)
		)
	)
)

(instance palmTrees of Feature
	(properties
		x 37
		y 101
		nsTop 62
		nsLeft 20
		nsBottom 141
		nsRight 70
		description {the palm trees}
		sightAngle 40
		lookStr {Miami is filled with exotic palm trees just like these.}
	)
)

(instance gymWindow of Feature
	(properties
		x 162
		y 140
		nsTop 127
		nsLeft 140
		nsBottom 150
		nsRight 185
		description {the gymnastics studio}
		sightAngle 40
		approachX 165
		approachY 162
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 900 4) ; "It looks like there is no one inside the gymnastics studio, although the mini-blinds severely handicap your view."
			)
			(3 ; Do
				(TPrint 900 5) ; "You are unable to part the mini-blinds to see inside since blinds are commonly placed on the INSIDE of windows!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance docSign of Feature
	(properties
		x 182
		y 42
		nsTop 24
		nsLeft 135
		nsBottom 61
		nsRight 225
		description {the sign}
		sightAngle 40
		lookStr {The sign reads, "Doc Pulliam's Dental Hygiene Heaven."}
	)
)

(instance gymDoor of Feature
	(properties
		x 215
		y 146
		nsTop 132
		nsLeft 195
		nsBottom 161
		nsRight 235
		description {the gymnastics studio door}
		sightAngle 40
		approachX 214
		approachY 163
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 900 6) ; "The door leading to the gymnastics studio is locked."
			)
			(3 ; Do
				(TPrint 900 7) ; "You try the door and find it is locked."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance docDoor of Door
	(properties
		x 114
		y 104
		z -10
		description {the dentist's office door}
		sightAngle 40
		approachX 128
		approachY 118
		lookStr {The door leading to Doc Pulliam's Dental Hygiene Heaven is unlocked.}
		view 900
		loop 1
		priority 1
		entranceTo 905
		moveToX 128
		moveToY 115
		enterType 0
		exitType 0
	)
)

(instance building of Feature
	(properties
		x 157
		y 91
		z -20
		nsTop 60
		nsLeft 65
		nsBottom 162
		nsRight 239
		description {the building}
		sightAngle 40
		lookStr {You are outside the building where Chi Chi Lambada is employed: "Doc Pulliam's Dental Hygiene Heaven." Immediately below it is a closed gymnastics studio, "The Gym-Dandy Gymnastics Center."}
	)
)

(instance sidewalk of Feature
	(properties
		x 169
		y 170
		nsTop 162
		nsBottom 178
		nsRight 319
		description {the sidewalk}
		sightAngle 40
		lookStr {Carefully inspecting the sidewalk, you conclude Doc Pulliam doesn't spend much on filling cavities out here!}
	)
)

(instance fence of Feature
	(properties
		x 164
		y 152
		nsTop 139
		nsBottom 166
		nsRight 308
		description {the fence}
		sightAngle 40
		onMeCheck 4
		lookStr {A stone wall decorates an otherwise perfunctory building.}
	)
)

(instance gymSign of Feature
	(properties
		x 190
		y 119
		nsTop 109
		nsLeft 145
		nsBottom 129
		nsRight 230
		description {the gymnastic studio sign}
		sightAngle 40
		lookStr {The sign says, "Gym-Dandy Gymnastics Center."}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 900 8) ; "The "Gym-Dandy Gymnastics Center's" sign is made of virgin polyvinyl chloride."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance window1 of Feature
	(properties
		x 184
		y 190
		z 100
		nsTop 78
		nsLeft 145
		nsBottom 102
		nsRight 225
		description {the window}
		sightAngle 40
		approachX 167
		approachY 115
		lookStr {You don't need to peek in those windows!}
	)
)

(instance window2 of Feature
	(properties
		x 92
		y 190
		z 100
		nsTop 78
		nsLeft 89
		nsBottom 100
		nsRight 106
		description {the window}
		sightAngle 40
		approachX 95
		approachY 119
		lookStr {You don't need to peek in those windows!}
	)
)

(instance stairs of Feature
	(properties
		x 101
		y 157
		z 25
		nsTop 106
		nsLeft 70
		nsBottom 158
		nsRight 135
		description {the stairway}
		sightAngle 40
		onMeCheck 8
		lookStr {A flight of stairs leads up to Doc Pulliam's office.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(if (< (gEgo y:) 130)
					(gEgo setMotion: PolyPath 57 164)
				else
					(gEgo setMotion: PolyPath 126 113)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance tooth of Prop
	(properties
		x 115
		y 64
		nsTop 27
		nsLeft 101
		nsBottom 64
		nsRight 129
		description {the revolving tooth}
		lookStr {Take the Ventura Freeway to the Fontainebleau Freeway to the Eisenhower Turnpike to the Slaussen Cutoff. Get out of your car and cut off your slaussen. Get back in your car and continue on until you reach the Beach Front Highway. Take the Beach Front Highway to 22nd Street Southwest and stop when you come to the giant revolving tooth! You're there! Doc Pulliam's Dental Hygiene Heaven!}
		view 900
		loop 2
		signal 26640
		detailLevel 3
	)
)

(instance limo of Actor
	(properties
		x 65
		y 179
		description {the limousine}
		approachX 81
		approachY 167
		lookStr {It's your limousine, awaiting your entrance.}
		view 900
		priority 14
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gCurRoom setScript: sEnterLimo)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance buildings of Feature
	(properties
		x 159
		y 81
		nsBottom 162
		nsRight 319
		description {the building}
		sightAngle 40
		onMeCheck 2
		lookStr {There are many buildings in a city as large as Miami.}
	)
)

(instance sExitLimo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo hide: setHeading: 0 posn: 81 177 0)
				(= cycles 2)
			)
			(1
				(gTheMusic2 number: 191 setLoop: 1 play:)
				(gEgo
					show:
					setMotion: MoveTo (limo approachX:) (limo approachY:)
				)
				(= ticks 50)
			)
			(2
				(= ticks 10)
			)
			(3
				(gTheMusic2 number: 192 setLoop: 1 play:)
				(= ticks 100)
			)
			(4
				(gEgo setLoop: -1 setHeading: 180 self)
			)
			(5
				(self setScript: sLimoLeaves self)
			)
			(6
				(HandsOn)
				(gEgo normalize: 552 setStep: 2 2)
				(limo dispose:)
				(= cycles 1)
			)
			(7
				(self dispose:)
				(if
					(Print ; "Now would be an excellent time for you to save your game, Larry."
						900
						9
						#button
						{Save}
						1
						#button
						{Nah, Why Bother?}
						0
						#title
						{AL says}
						#at
						-1
						28
					)
					(gGame save:)
				)
			)
		)
	)
)

(instance sLimoLeaves of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (== (gTheMusic2 prevSignal:) 10)
			(gTheMusic2 prevSignal: 0)
			(self cue:)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= register (gTheMusic2 flags:))
				(gTheMusic2 number: 194 setLoop: 1 flags: 0 play:)
			)
			(1
				(limo
					illegalBits: 0
					ignoreActors: 1
					setStep: 3 3
					setMotion: MoveTo (- (limo x:) 20) (limo y:) self
				)
			)
			(2
				(limo
					setStep: 5 5
					setMotion: MoveTo (- (limo x:) 20) (limo y:) self
				)
			)
			(3
				(limo setStep: 8 8 setMotion: MoveTo -80 (limo y:) self)
				(gTheMusic2 fade: 0 15 12 1 flags: register)
			)
			(4
				(limo dispose:)
				(self dispose:)
			)
		)
	)
)

(instance theMusic3 of Sound
	(properties)
)

(instance theDoor of Feature
	(properties
		x 125
		y 99
		nsTop 82
		nsLeft 112
		nsBottom 117
		nsRight 139
		description {the dentist's office door}
		sightAngle 40
		approachX 128
		approachY 116
		lookStr {The door leading to Doc Pulliam's Dental Hygiene Heaven is unlocked.}
	)

	(method (doVerb)
		(docDoor doVerb: &rest)
	)
)

(instance sEnterLimo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo setMotion: MoveTo 81 177 self)
				(= ticks 10)
			)
			(2
				(gTheMusic2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(3 0)
			(4
				(gEgo hide:)
				(gTheMusic2 number: 192 setLoop: 1 play:)
				(= ticks 120)
			)
			(5
				(gCurRoom newRoom: 200)
			)
		)
	)
)

