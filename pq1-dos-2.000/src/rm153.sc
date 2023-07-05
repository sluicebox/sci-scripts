;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 153)
(include sci.sh)
(use Main)
(use hotel)
(use eRS)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm153 0
)

(local
	local0
)

(instance roomTimer of Timer
	(properties)
)

(class Fool of Actor
	(properties
		approachDist 1
		cueCount 0
		lastTime -1
		fseconds -1
		ticksToDo -1
		maxLoop -1
		status 1
		talkCount 0
	)

	(method (init)
		(super init:)
		(= fseconds (Random 6 12))
	)

	(method (cue)
		(super cue:)
		(switch (++ cueCount)
			(1
				(cond
					((!= status 1) 0)
					((!= maxLoop -1)
						(self setLoop: (Random 0 maxLoop) setCycle: End self)
					)
					(else
						(self setCycle: End self)
					)
				)
			)
			(2
				(= fseconds 2)
				(self stopUpd:)
			)
			(3
				(if (== status 1)
					(self setCel: 0 stopUpd:)
					(= cueCount 0)
					(= fseconds (Random 4 12))
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			((!= status 1) 0)
			((!= fseconds -1)
				(if (!= lastTime (= temp0 (GetTime 1))) ; SysTime12
					(= lastTime temp0)
					(if (not (-- fseconds))
						(self cue:)
					)
				)
			)
			(
				(or
					(u< (+ ticksToDo lastTime) (GetTime))
					(and
						(u> lastTime (GetTime))
						(u> (+ ticksToDo lastTime) lastTime)
					)
				)
				(self cue:)
			)
		)
	)
)

(instance elevatorSnd of Sound ; UNUSED
	(properties
		flags -1
		number 922
	)
)

(class Script_ of Script
	(properties
		register2 -1
	)
)

(instance rm153 of PQRoom
	(properties
		picture 153
	)

	(method (init)
		(= global224 {Last update:\nThurs 4-23-92  0834})
		(if (not global205)
			(= global205 2)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 40 147 275 147 275 139 66 139 40 139
					yourself:
				)
		)
		(super init:)
		(switch gPrevRoomNum
			(53
				(self setScript: sEnterFromLeft)
			)
			(else
				(self setScript: sEnterFromRight)
			)
		)
		(if (== global205 2)
			(door202 init:)
			(door203 init:)
		else
			(door302 init:)
			(door303 init:)
		)
		(theRoom init:)
		(paneling init:)
		(light init:)
		(carpet init:)
	)

	(method (notify param1 &tmp [temp0 200])
		(if (== param1 22)
			(proc151_9)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((& (gEgo onControl: 1) $0002)
				(if (> (gEgo x:) 174)
					(self setScript: sExitRight)
				else
					(self setScript: sExitLeft)
				)
			)
			((and (== local0 0) (& (gEgo onControl: 1) $0008))
				(if (== (Random 0 5) 1)
					(switch global205
						(2
							(gMessager say: 9 0 1) ; "Gerald, I don't feel like playing this game anymore."
						)
						(3
							(gMessager say: 10 0 2) ; "As you walk by the room, you catch a snippet of what must be one of the free in-room movies..."Tonight...Dino DeLaurentis presents a Brian DePalma Production of a George Romero Film. John Carpenter's TEDDY BEAR'S PICNIC! You've never seen teddy bears like these before! If you go down to the woods today, you're in for a BIG surprise!""
						)
					)
					(= local0 2)
				else
					(= local0 1)
					(roomTimer setReal: self 8)
				)
			)
		)
	)

	(method (cue)
		(= local0 0)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance sEnterFromLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					view: global206
					posn: 54 145
					setMotion: MoveTo 75 145 self
				)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					view: global206
					posn: 256 147
					setMotion: MoveTo 229 145 self
				)
			)
			(1
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sExitRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 253)
			)
		)
	)
)

(instance sExitLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if register
					(-- state)
					(= register 0)
					(gEgo setMotion: PolyPath 65 143 self)
				else
					(gEgo
						setMotion: MoveTo (- (gEgo x:) 20) (gEgo y:) self
					)
				)
			)
			(1
				(gCurRoom newRoom: 53)
			)
		)
	)
)

(instance door202 of Feature
	(properties
		x 77
		y 95
		noun 11
		nsTop 57
		nsLeft 65
		nsBottom 134
		nsRight 89
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(switch global205
					(2
						(if (IsFlag 25)
							(gMessager say: 11 1 1) ; "It's room number 202. Hey, that's your room!"
						else
							(gMessager say: 11 1) ; "It's room number 202."
						)
					)
					(3
						(gMessager say: 11 1 2) ; MISSING MESSAGE
					)
				)
			)
			(4 ; Do
				(gMessager say: 11 4 1) ; "Try your key."
			)
			(54 ; Hotel_Room_Key
				(SetFlag 46)
				(gCurRoom setScript: sExitLeft 0 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door302 of Feature
	(properties
		x 77
		y 95
		noun 13
		nsTop 57
		nsLeft 65
		nsBottom 134
		nsRight 89
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(switch global205
					(2
						(gMessager say: 13 1 1) ; MISSING MESSAGE
					)
					(3
						(gMessager say: 13 1 2) ; "It's room 302."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door203 of Feature
	(properties
		x 218
		y 95
		noun 12
		nsTop 59
		nsLeft 194
		nsBottom 132
		nsRight 243
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(switch global205
					(2
						(gMessager say: 12 1 1) ; "It's room 203."
					)
					(3
						(gMessager say: 12 1 2) ; MISSING MESSAGE
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door303 of Feature
	(properties
		x 218
		y 95
		noun 14
		nsTop 59
		nsLeft 194
		nsBottom 132
		nsRight 243
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(switch global205
					(2
						(gMessager say: 14 1 1) ; MISSING MESSAGE
					)
					(3
						(gMessager say: 14 1 2) ; "It's room 303."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance carpet of Feature
	(properties
		x 157
		y 141
		noun 1
		nsTop 132
		nsLeft 65
		nsBottom 150
		nsRight 250
		sightAngle 40
	)
)

(instance light of Feature
	(properties
		x 186
		y 76
		noun 6
		nsTop 69
		nsLeft 179
		nsBottom 83
		nsRight 193
		sightAngle 40
	)
)

(instance paneling of Feature
	(properties
		x 142
		y 130
		noun 7
		nsTop 127
		nsLeft 88
		nsBottom 133
		nsRight 196
		sightAngle 40
	)
)

(instance theRoom of Feature
	(properties
		x 158
		y 1
		z 90
		noun 8
		nsTop 27
		nsLeft 63
		nsBottom 154
		nsRight 254
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(switch global205
					(2
						(gMessager say: 8 1 1) ; "This is the second floor of the Hotel Delphoria."
					)
					(3
						(gMessager say: 8 1 2) ; "This is the third floor hallway of the Hotel Delphoria."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

