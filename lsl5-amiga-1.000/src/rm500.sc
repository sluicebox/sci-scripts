;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Interface)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	cycleTime
)

(instance rm500 of LLRoom
	(properties
		picture 500
		north 510
	)

	(method (init)
		(switch gPrevRoomNum
			(north
				(gTheMusic fade: 80 10 10 0)
				(gEgo init: normalize: edgeHit: EDGE_NONE)
			)
			(else
				(gTheMusic number: 0 stop:)
				(gEgo
					init:
					normalize:
					posn: 24 177 0
					setLoop: -1
					setHeading: 180
					edgeHit: EDGE_NONE
				)
				(limo init:)
				(= gLarryLoc 1)
				(gCurRoom setScript: sExitLimo)
			)
		)
		(super init:)
		(door init: approachVerbs: 3) ; Do
		(doorR init: approachVerbs: 3) ; Do
		(if (or (== gPrevRoomNum 200) (IsFlag 1)) ; fCalledLimo
			(limo init: approachVerbs: 3) ; Do
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 145 143 124 157 32 157 32 147 72 147 73 145 3 145 3 165 315 165 315 145 261 145 260 147 295 147 295 156 205 156 190 143 158 143 151 0 319 0 319 189 0 189 0 0 148 0
					yourself:
				)
		)
		(lavaLamp1 init:)
		(lavaLamp2 init:)
		(plants1 init:)
		(plants2 init:)
	)

	(method (doit)
		(super doit:)
		(if (not (mod (++ cycleTime) 10))
			(Palette palANIMATE 239 254 -1)
		)
		(cond
			(script)
			((and (StepOn gEgo 2) (not (IsFlag 105)))
				(HandsOff)
				(gCurRoom setScript: sPiss)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(TPrint 500 0) ; "The exterior of "The Hard Disk Cafe" is in keeping with their computer memorabilia motif."
				(return 1)
			)
			(3 ; Do
				(cond
					((== gPrevRoomNum 200)
						(TPrint 500 1) ; "Your limo is gone, Larry. Why not walk inside?"
					)
					((IsFlag 1) ; fCalledLimo
						(TPrint 500 2) ; "The limousine you ordered has arrived. Why not get in?"
					)
					(else
						(TPrint 500 3) ; "You try in vain to find a means of transportation, but to no avail. How will you ever be able to telephone that limo company?"
					)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sPiss of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Points 1 105)
				(= seconds 3)
			)
			(1
				(Say gEgo 500 4) ; "Ahhh!"
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitLimo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(HandsOff)
				(gTheMusic2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(2
				(gEgo setLoop: 3 setCel: 0 setMotion: MoveTo 24 163 self)
			)
			(3
				(gEgo setLoop: -1 setHeading: 180)
				(= ticks 10)
			)
			(4
				(gTheMusic2 number: 192 setLoop: 1 play:)
				(= ticks 110)
			)
			(5
				(WrapMusic firstSound: 500 lastSound: 502)
				(gTheMusic
					number: 500
					play: WrapMusic
					setVol: 80
					flags: 1
					setLoop: 1
				)
				(self setScript: sLimoLeaves self)
			)
			(6
				(HandsOn)
				(limo dispose:)
				(= cycles 1)
			)
			(7
				(gEgo normalize:)
				(self dispose:)
				(if
					(Print ; "Now would be an excellent time for you to save your game, Larry."
						500
						5
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

(instance sEnterLimo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: -1 setHeading: 180 self)
			)
			(1
				(gTheMusic2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(2
				(gEgo setMotion: MoveTo 23 183 self)
			)
			(3
				(gEgo hide:)
				(= ticks 10)
			)
			(4
				(gTheMusic2 number: 192 setLoop: 1 play:)
				(= ticks 110)
			)
			(5
				(gCurRoom newRoom: 200)
			)
		)
	)
)

(instance sLimoLeaves of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gTheMusic2 number: 194 setLoop: 1 play: self)
			)
			(1
				(limo setStep: 2 2 setMotion: MoveTo 67 (limo y:) self)
			)
			(2
				(limo setStep: 4 4 setMotion: MoveTo 45 (limo y:) self)
			)
			(3
				(limo setStep: 6 6 setMotion: MoveTo 15 (limo y:) self)
			)
			(4
				(limo setStep: 9 9 setMotion: MoveTo -25 (limo y:) self)
			)
			(5
				(limo setStep: 12 12 setMotion: MoveTo -95 (limo y:) self)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance limo of Actor
	(properties
		x 75
		y 189
		description {your limousine}
		approachX 23
		approachY 163
		lookStr {Why do all these limos look alike?}
		view 500
		priority 14
		signal 18448
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(HandsOff)
				(gTheMusic fade:)
				(gCurRoom setScript: sEnterLimo)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance doorR of Feature
	(properties
		x 188
		y 98
		nsTop 56
		nsLeft 168
		nsBottom 141
		nsRight 209
		description {the front door}
		sightAngle 40
		approachX 154
		approachY 144
		lookStr {If you could figure out how to open this door, you might enter "The Hard Disk Cafe."}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(door open:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door of Door
	(properties
		x 146
		y 141
		description {the front door}
		sightAngle 40
		approachX 154
		approachY 144
		lookStr {If you could figure out how to open this door, you might enter "The Hard Disk Cafe."}
		view 500
		loop 2
		entranceTo 510
		moveToX 156
		moveToY 135
		enterType 0
		exitType 0
	)
)

(instance lavaLamp1 of Feature
	(properties
		x 76
		y 97
		nsTop 41
		nsLeft 41
		nsBottom 153
		nsRight 111
		description {the lava lamp}
		sightAngle 40
		onMeCheck 8
		lookStr {Wow! A giant lava lamp! (You've always loved those things!)}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 500 6) ; "It feels so warm to the touch."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lavaLamp2 of Feature
	(properties
		x 256
		y 93
		nsTop 33
		nsLeft 220
		nsBottom 154
		nsRight 292
		description {the lava lamp}
		sightAngle 40
		onMeCheck 8
		lookStr {Wow! A giant lava lamp! (You've always loved those things!)}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(3 ; Do
				(TPrint 500 6) ; "It feels so warm to the touch."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plants1 of Feature
	(properties
		x 76
		y 97
		nsTop 41
		nsLeft 41
		nsBottom 153
		nsRight 111
		description {the plant}
		sightAngle 40
		onMeCheck 4
		lookStr {These plants grow here in spite of the atmosphere.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance plants2 of Feature
	(properties
		x 256
		y 93
		nsTop 33
		nsLeft 220
		nsBottom 154
		nsRight 292
		description {the plant}
		sightAngle 40
		onMeCheck 4
		lookStr {These plants grow here in spite of the atmosphere.}
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

