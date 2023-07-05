;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 253)
(include sci.sh)
(use Main)
(use hotel)
(use eRS)
(use Print)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm253 0
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

(instance rm253 of PQRoom
	(properties
		picture 253
	)

	(method (init)
		(= global224 {Last update:\nWed 2-19-92})
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 40 147 235 147 208 139 83 139 40 139
					yourself:
				)
		)
		(super init:)
		(self setScript: sEnterFromLeft)
		(theRoom init:)
		(paneling init:)
		(light init:)
		(carpet init:)
		(theDoor init:)
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
				(if (< (gEgo x:) 174)
					(self setScript: sExitLeft)
				else
					(Prints {Hook: you can't go that way...})
				)
			)
			((and (== local0 0) (& (gEgo onControl: 1) $0008))
				(if (== (Random 0 5) 1)
					(switch global205
						(2
							(gMessager say: 5 0 1) ; "OOOOM pa pa OOOOM pa pa OOOOM pa pa OOOOM pa pa"
						)
						(3
							(gMessager say: 5 0 2) ; "FORE!"
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

(instance sEnterFromRight of Script ; UNUSED
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

(instance sExitLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 153)
			)
		)
	)
)

(instance theDoor of Feature
	(properties
		x 111
		y 96
		noun 6
		nsTop 59
		nsLeft 87
		nsBottom 133
		nsRight 136
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(switch global205
					(2
						(gMessager say: 6 1 1) ; "It's room 204."
					)
					(3
						(gMessager say: 6 1 2) ; "It's room 304."
					)
				)
			)
			(4 ; Do
				(switch global205
					(2
						(gMessager say: 6 4 1) ; "You knock on the door, but no one can hear you over the tuba."
					)
					(3
						(gMessager say: 6 4 2) ; "You tap at the door."
					)
				)
			)
			(41 ; ???
				(switch global205
					(2
						(gMessager say: 6 41 1) ; "It's not your room. Your key won't work."
					)
					(3
						(gMessager say: 6 41 2) ; "It's not your room. Your key won't work."
					)
				)
			)
			(2 ; Talk
				(switch global205
					(2
						(gMessager say: 6 2 1) ; "OOOOM pa pa OOOOM pa pa OOOOM pa pa OOOOM pa pa..."
					)
					(3
						(gMessager say: 6 2 2) ; "Oh, do go away. I'm trying to work on my swing. I have the most dreadful hook, you see..."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 78
		y 74
		noun 4
		nsTop 68
		nsLeft 72
		nsBottom 81
		nsRight 85
		sightAngle 40
	)
)

(instance carpet of Feature
	(properties
		x 160
		y 141
		noun 2
		nsTop 132
		nsLeft 66
		nsBottom 151
		nsRight 254
		sightAngle 40
	)
)

(instance paneling of Feature
	(properties
		x 156
		y 131
		noun 3
		nsTop 124
		nsLeft 61
		nsBottom 139
		nsRight 251
		sightAngle 40
	)
)

(instance theRoom of Feature
	(properties
		x 159
		y 90
		noun 1
		nsTop 23
		nsLeft 61
		nsBottom 158
		nsRight 257
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch global205
					(2
						(gMessager say: 1 1 1) ; "This is the second floor hallway of the Hotel Delphoria."
					)
					(3
						(gMessager say: 1 1 2) ; "This is the third floor hallway of the Hotel Delphoria."
					)
				)
			)
		)
	)
)

