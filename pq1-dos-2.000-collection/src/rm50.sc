;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 50)
(include sci.sh)
(use Main)
(use hotel)
(use ExitCar)
(use eRS)
(use Print)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm50 0
)

(local
	local0
	local1
	local2
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

(instance rm50 of PQRoom
	(properties)

	(method (init)
		(if (not (gEgo has: 7)) ; Undercover_money
			(gEgo get: 7) ; Undercover_money
		)
		(= global224 {Last update:\nMon 5-11-92 1252})
		(switch global207
			(104
				(= picture 50)
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 180 60 228 78 228 97 121 142 98 142 49 119 49 97 80 86 157 60
							yourself:
						)
						((Polygon new:)
							type: PContainedAccess
							init: 7 89 7 185 267 185 305 160 305 6 268 5 92 64 59 32 50 36 80 68
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 254 161 254 179 217 179 217 161
							yourself:
						)
				)
			)
			(105
				(= picture 250)
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 189 318 189 0 189 0 0 79 69 11 93 2 98 2 187 317 187 317 2 276 2 93 63 11 0 319 0
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 190 56 224 73 224 97 167 121 79 138 40 111 40 99 140 56
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 255 173 239 182 219 170 238 160
							yourself:
						)
				)
			)
			(914
				(= picture 150)
				(self
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 191 63 237 79 237 97 108 131 63 111 63 91 152 63
							yourself:
						)
						((Polygon new:)
							type: PContainedAccess
							init: 8 188 268 188 309 178 309 7 264 7 98 62 58 19 29 27 74 68 8 89
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 258 159 258 181 220 181 220 159
							yourself:
						)
				)
			)
			(else
				(Prints {ERROR: I need to know which car you're driving!})
			)
		)
		(super init:)
		(switch gPrevRoomNum
			(51
				(proc160_0)
				(hotelDoors init: setCel: 255)
				(gEgo init: setLoop: 4 setCycle: Fwd posn: 71 53)
				(gLongSong2 fade: 90 15 5 0)
				(self setScript: sEnterFromInside)
			)
			(else
				(gLongSong2 number: 915 loop: -1 flags: -1 play: 90)
				(hotelDoors init: stopUpd:)
				(gEgo init:)
				(gCurRoom setScript: (ScriptID 160 1)) ; ExitCar
				(if (and (not (Random 0 3)) (not (IsFlag 28)))
					(SetFlag 28)
					(lady init:)
					(= local0 1)
					(roomTimer setReal: lady 4)
				)
				(if (== global207 104)
					(SetScore 143 10)
				)
			)
		)
		(hotelWindow init:)
		(hotelSign init:)
		(poles init:)
		(overHang init:)
		(numbers init:)
		(mat init:)
		(driveWay init:)
		(sidewalk init:)
		(HDsign init:)
		(mat2 init:)
		(theRoom init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			(
				(and
					(gEgo inRect: 22 34 150 91)
					(& (gEgo onControl: 1) $0002)
				)
				(HandsOff)
				(self setScript: sEnterHotel)
			)
		)
		(if (and local0 (User controls:))
			(HandsOff)
		)
	)

	(method (notify param1 &tmp [temp0 200])
		(if (== param1 22)
			(proc151_9)
		)
	)

	(method (newRoom newRoomNumber)
		(gLongSong2 fade:)
		(roomTimer dispose: delete:)
		(doorTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance hotelDoors of Prop
	(properties
		x 53
		y 59
		noun 7
		view 422
		signal 18432
	)

	(method (cue)
		(super cue:)
		(doorSnd stop:)
	)
)

(instance lady of Actor
	(properties
		x 32
		y 96
		view 428
		signal 18432
	)

	(method (cue)
		(super cue:)
		(switch (++ local1)
			(1
				(lady setLoop: 0 setCel: 0 setCycle: End self)
			)
			(2
				(lady setLoop: 1 setCel: 0 setCycle: End self)
			)
			(3
				(roomTimer setReal: self 2)
			)
			(4
				(lady setLoop: 2 setCel: 0 setCycle: End self)
			)
			(5
				(lady setLoop: 3 setCel: 0 setCycle: End self)
			)
			(6
				(lady setLoop: 4 setCel: 0 setCycle: End self)
			)
			(7
				(lady
					view: 429
					setLoop: 1
					setCycle: Fwd
					setMotion: MoveTo 309 0 self
				)
			)
			(8
				(self dispose:)
				(HandsOn)
				(= local0 0)
				(= local1 0)
			)
		)
	)
)

(instance driveWay of Feature
	(properties
		x 159
		y 95
		noun 9
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 16384
	)
)

(instance mat of Feature
	(properties
		x 94
		y 75
		noun 11
		nsTop 50
		nsLeft 42
		nsBottom 100
		nsRight 147
		sightAngle 40
		onMeCheck 4
	)
)

(instance numbers of Feature
	(properties
		x 286
		y 54
		noun 3
		nsTop 47
		nsLeft 269
		nsBottom 62
		nsRight 303
		sightAngle 40
		onMeCheck 2
	)
)

(instance overHang of Feature
	(properties
		x 196
		y 41
		noun 4
		nsLeft 73
		nsBottom 88
		nsRight 319
		sightAngle 40
		onMeCheck 32
	)
)

(instance poles of Feature
	(properties
		x 271
		y 114
		noun 5
		nsTop 49
		nsLeft 223
		nsBottom 179
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)
)

(instance theRoom of Feature
	(properties
		x 159
		y 3
		z -90
		noun 1
		nsBottom 189
		nsRight 319
		sightAngle 40
	)
)

(instance hotelSign of Feature
	(properties
		x 165
		y 31
		noun 2
		nsLeft 100
		nsBottom 69
		nsRight 231
		sightAngle 40
		onMeCheck 16
	)
)

(instance hotelWindow of Feature
	(properties
		x 20
		y 39
		noun 10
		nsTop 18
		nsBottom 61
		nsRight 41
		sightAngle 40
		onMeCheck 64
	)
)

(instance sidewalk of Feature
	(properties
		x 159
		y 94
		noun 6
		nsBottom 189
		nsRight 319
		sightAngle 40
		onMeCheck 8
	)
)

(instance HDsign of Feature
	(properties
		x 77
		y 132
		z 100
		noun 8
		nsTop 25
		nsLeft 62
		nsBottom 40
		nsRight 92
		sightAngle 40
		onMeCheck 16384
	)

	(method (doVerb theVerb invItem)
		(hotelDoors doVerb: theVerb invItem &rest)
	)
)

(instance mat2 of Feature
	(properties
		x 79
		y 58
		noun 11
		nsTop 48
		nsLeft 45
		nsBottom 68
		nsRight 114
		sightAngle 40
		onMeCheck 2
	)
)

(instance doorSnd of Sound
	(properties
		number 960
	)
)

(instance doorTimer of Timer
	(properties)
)

(instance sEnterFromInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= ticks 5)
			)
			(1
				(doorSnd number: 960 play:)
				(hotelDoors setCycle: Beg hotelDoors)
				(gEgo setMotion: MoveTo 97 80 self)
			)
			(2
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sEnterHotel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(doorSnd number: 960 play:)
				(hotelDoors startUpd: setCycle: End hotelDoors)
				(= ticks 30)
			)
			(1
				(if (== (hotelDoors cel:) 9)
					(gEgo
						setLoop: 7
						setCycle: Fwd
						setPri: 3
						illegalBits: 0
						ignoreActors: 1
						setMotion: MoveTo 44 34 self
					)
				else
					(-- state)
					(= ticks 10)
				)
			)
			(2
				(gCurRoom newRoom: 51)
			)
		)
	)
)

