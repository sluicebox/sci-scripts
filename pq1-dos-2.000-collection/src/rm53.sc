;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
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
	rm53 0
)

(local
	local0
	local1
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

(instance rm53 of PQRoom
	(properties
		picture 53
	)

	(method (init)
		(= global224 {Last update:\nWed 4-22-92})
		(if (not global205)
			(= global205 2)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 40 147 275 147 275 140 226 140 111 140 111 117 83 117 83 139 40 139
					yourself:
				)
		)
		(self setRegions: 151) ; hotel
		(super init:)
		(theDoor init: setCel: 0 stopUpd:)
		(switch gPrevRoomNum
			(353
				(self setScript: sEnterFromLeft)
			)
			(153
				(self setScript: sEnterFromRight)
			)
			(51
				(if (IsFlag 27)
					(self setScript: (ScriptID 151 2) 0 1) ; sExitElevator
				else
					(self setScript: (ScriptID 151 2)) ; sExitElevator
				)
			)
			(else
				(theDoor setCel: 255)
				(self setScript: sExitDoor)
			)
		)
		(theRoom init:)
		(baseBoard init:)
		(carpet init:)
		(doorFrame init:)
		(lamp init:)
		(buttonFeature init: approachVerbs: 4) ; Do
	)

	(method (doit)
		(cond
			(script)
			(
				(and
					(== global205 2)
					(gEgo has: 3) ; Patrol_Car_Keys
					(& (gEgo onControl: 1) $0008)
				)
				(self setScript: sEnterHotelRoom)
			)
			((& (gEgo onControl: 1) $0002)
				(if (< (gEgo x:) 74)
					(self setScript: sExitLeft)
				else
					(self setScript: sExitRight)
				)
			)
		)
		(super doit:)
	)

	(method (cue)
		(gCurRoom setScript: sEnterHotelRoom 0 1)
	)

	(method (notify param1 &tmp [temp0 200])
		(if (== param1 22)
			(proc151_9)
		)
	)
)

(instance sExitDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong number: 913 loop: 1 play:)
				(gEgo
					view: global206
					setLoop: 2
					posn: 240 130
					ignoreActors: 1
					init:
				)
				(= cycles 2)
			)
			(1
				(NormalEgo)
				(gEgo setMotion: MoveTo 228 146 self)
			)
			(2
				(theDoor setCycle: Beg self)
			)
			(3
				(gLongSong number: 914 loop: 1 play:)
				(HandsOn)
				(theDoor stopUpd:)
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
				(gCurRoom newRoom: 153)
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
				(gCurRoom newRoom: 353)
			)
		)
	)
)

(instance sEnterFromLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: global206
					posn: 54 145
					setMotion: MoveTo 75 145 self
					init:
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
					view: global206
					posn: 256 147
					setMotion: MoveTo 229 145 self
					init:
				)
			)
			(1
				(if (IsFlag 46)
					(ClearFlag 46)
					(theDoor doVerb: 4)
				)
				(= ticks 30)
			)
			(2
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance theRoom of Feature
	(properties
		x 158
		y 1
		z 89
		nsTop 23
		nsLeft 62
		nsBottom 156
		nsRight 254
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(switch global205
					(2
						(gMessager say: 12 1 1) ; "This is the second floor hallway of the semi-swank Hotel Delphoria."
					)
					(3
						(gMessager say: 12 1 2) ; "This is the third floor hallway of the Hotel Delphoria."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance baseBoard of Feature
	(properties
		x 172
		y 130
		noun 1
		nsTop 126
		nsLeft 131
		nsBottom 135
		nsRight 213
		sightAngle 40
	)
)

(instance carpet of Feature
	(properties
		x 158
		y 141
		noun 2
		nsTop 131
		nsLeft 65
		nsBottom 151
		nsRight 251
		sightAngle 40
	)
)

(instance doorFrame of Feature
	(properties
		x 216
		y 106
		noun 3
		nsTop 79
		nsLeft 212
		nsBottom 133
		nsRight 221
		sightAngle 40
	)
)

(instance lamp of Feature
	(properties
		x 186
		y 75
		noun 9
		nsTop 70
		nsLeft 179
		nsBottom 80
		nsRight 193
		sightAngle 40
	)
)

(instance sEnterHotelRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong number: 913 loop: 1 play:)
				(if (and (!= (gEgo x:) 235) (!= (gEgo y:) 136))
					(gEgo setMotion: PolyPath 235 136 self)
				else
					(= cycles 2)
				)
			)
			(1
				(theDoor setCycle: End self)
			)
			(2
				(gEgo setMotion: MoveTo 235 134 self)
			)
			(3
				(gEgo setHeading: 360 self)
			)
			(4
				(gCurRoom newRoom: 54)
			)
		)
	)
)

(instance theDoor of Prop
	(properties
		x 219
		y 149
		z 20
		noun 4
		approachX 235
		approachY 140
		approachDist 5
		view 461
		loop 1
		priority 4
		signal 18448
	)

	(method (cue)
		(super cue:)
		(self doVerb: local0)
	)

	(method (doVerb theVerb invItem)
		(= local0 theVerb)
		(switch (++ local1)
			(1
				(gEgo setMotion: PolyPath 235 140 self)
			)
			(2
				(gEgo loop: 8 cel: 3)
				(roomTimer setReal: self 2)
			)
			(3
				(switch local0
					(1
						(switch global205
							(2
								(if (IsFlag 25)
									(gMessager say: 4 1 1) ; "It's a door. On closer inspection, your keenly honed senses reveal that this is room 202 - your room."
								else
									(gMessager say: 4 1) ; "It's the door to room 202."
								)
							)
							(3
								(gMessager say: 4 1 2) ; "It's room 302."
							)
						)
					)
					(4
						(switch global205
							(2
								(gMessager say: 4 4 1) ; "Try your key, hotshot."
							)
							(3
								(gMessager say: 4 4 2) ; "You tap lightly on the door. You hear muffled groans and snorts."
							)
						)
					)
					(54
						(gCurRoom setScript: sEnterHotelRoom)
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
				(= local1 0)
			)
		)
	)
)

(instance buttonFeature of Feature
	(properties
		x 138
		y 113
		nsTop 107
		nsLeft 135
		nsBottom 119
		nsRight 141
		sightAngle 40
		approachX 99
		approachY 137
	)

	(method (doVerb))
)

