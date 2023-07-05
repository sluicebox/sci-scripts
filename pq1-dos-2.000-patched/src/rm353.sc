;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 353)
(include sci.sh)
(use Main)
(use hotel)
(use eRS)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm353 0
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

(instance rm353 of PQRoom
	(properties
		noun 1
		picture 353
	)

	(method (init)
		(if (== gPrevRoomNum 1)
			(= gPrevRoomNum 51)
			(= global205 1)
			(SetFlag 2)
		)
		(= global224 {Last update:\nSunday, July 19, 1992})
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 72 147 275 147 275 140 102 140
					yourself:
				)
		)
		(super init:)
		(self setScript: sEnterFromRight)
		(carpet init:)
		(paneling init:)
		(theDoor init: approachVerbs: 1 4 7) ; Look, Do, ???
		(light init:)
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
				(self setScript: sExitRight)
			)
			((and (== local0 0) (& (gEgo onControl: 1) $0008))
				(if (== (Random 0 3) 1)
					(switch global205
						(2
							(gMessager say: 6 0 1) ; "Oh, John..."
						)
						(3
							(gMessager say: 6 0 2) ; "Come on! Come on, Heironymous! Jump! Jump, boy! Good boy! Come on, Daphne, you can do it. Up the ladder, girl. Throckmorton! Don't chew on that! Ariadne, come back here! What are you doing with Maxwell? Don't bite him!"
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

(instance sEnterFromLeft of Script ; UNUSED
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
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance theDoor of Feature
	(properties
		x 204
		y 96
		noun 5
		nsTop 59
		nsLeft 181
		nsBottom 133
		nsRight 227
		sightAngle 40
		approachX 203
		approachY 141
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(switch global205
					(1
						(gMessager say: 5 1 6) ; "The door says `MANAGER.'"
					)
					(2
						(gMessager say: 5 1 1) ; "It's room 201."
					)
					(3
						(gMessager say: 5 1 2) ; "It's room 301."
					)
				)
			)
			(4 ; Do
				(switch global205
					(1
						(gMessager say: 5 4 6) ; "You tap on the door. There is no answer."
					)
					(2
						(gMessager say: 5 4 1) ; "You tap on the door. There is no answer."
					)
					(3
						(gMessager say: 5 4 2) ; "You tap on the door. No one answers, but you hear a lot of squeaking."
					)
				)
			)
			(2 ; Talk
				(switch global205
					(1
						(gMessager say: 5 2 6) ; "GO AWAY!"
					)
					(2
						(gMessager say: 5 2 1) ; "Uh, we're a little busy, whoever you are..."
					)
					(3
						(gMessager say: 5 2 2) ; "Yes, what can I do for you? Throckmorton! Leave that alone!"
					)
				)
			)
			(41 ; ???
				(switch global205
					(1
						(gMessager say: 5 41 6) ; "It's too small and doesn't fit. (You've heard THIS before!)"
					)
					(2
						(gMessager say: 5 41 1) ; "It's not your room."
					)
					(3
						(gMessager say: 5 41 2) ; "It's not your room."
					)
				)
			)
		)
	)
)

(instance paneling of Feature
	(properties
		x 157
		y 131
		noun 4
		nsTop 125
		nsLeft 64
		nsBottom 137
		nsRight 250
		sightAngle 40
	)
)

(instance carpet of Feature
	(properties
		x 156
		y 140
		noun 2
		nsTop 131
		nsLeft 64
		nsBottom 150
		nsRight 249
		sightAngle 40
	)
)

(instance light of Feature
	(properties
		x 234
		y 75
		noun 3
		nsTop 70
		nsLeft 228
		nsBottom 80
		nsRight 241
		sightAngle 40
	)
)

