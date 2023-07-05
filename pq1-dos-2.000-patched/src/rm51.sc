;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 51)
(include sci.sh)
(use Main)
(use hotel)
(use eRS)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm51 0
	Ken 1
)

(local
	local0
	local1 = 5
)

(procedure (localproc_0 param1 param2 param3)
	(gMessager say: param1 param2 param3 0 0 51)
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

(instance elevatorSnd of Sound
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

(instance rm51 of PQRoom
	(properties
		picture 51
	)

	(method (init &tmp [temp0 20])
		(if (not (gEgo has: 7)) ; Undercover_money
			(gEgo get: 7) ; Undercover_money
		)
		(= global224 {Last update:\nThurs 4-30-92 1145})
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 161 107 137 190 180 245 171 160 141 160 133 180 133 180 125 173 125 173 105 108 117 0 141
					yourself:
				)
		)
		(self setRegions: 151) ; hotel
		(super init:)
		(deskClerk init: hide: stopUpd: approachVerbs: 4 1 2) ; Do, Look, Talk
		(if (!= gPrevRoomNum 52)
			(gLongSong number: (hotel curMusic:) loop: -1 flags: -1 play: 30)
		)
		(switch gPrevRoomNum
			(53
				(self setScript: (ScriptID 151 2)) ; sExitElevator
			)
			(52
				(hotel curVol: 100)
				(gEgo show:)
				(self setScript: sEnterFromBar)
			)
			(else
				(if (and (not (IsFlag 29)) (not (IsFlag 2)))
					(SetFlag 29)
					(elevatorGirl init: setPri: 6 setScript: sElevatorGirl)
				)
				(self setScript: sEnterFromOutside)
			)
		)
		(capital init:)
		(carpeting init:)
		(column init:)
		(doorFrame init:)
		(elevatorButton init:)
		(pidgeonHole init:)
		(rightPlant init:)
		(leftPlant init:)
		(regDesk init:)
	)

	(method (notify param1 &tmp [temp0 200])
		(if (== param1 22)
			(proc151_9)
		)
	)

	(method (doit &tmp temp0 temp1)
		(if (not (-- local1))
			(= local1 5)
			(= temp0 (GetDistance (gEgo x:) (gEgo y:) 155 91))
			(if (!= local0 temp0)
				(if (< (= temp1 (- 127 temp0)) 50)
					(= temp1 50)
				)
				(if (> temp1 100)
					(= temp1 100)
				)
				(if (hotel playMusic:)
					(gLongSong setVol: temp1)
				)
				(hotel curVol: temp1)
				(= local0 temp0)
			)
		)
		(super doit:)
		(cond
			(script)
			((& (gEgo onControl: 1) $0002)
				(if (< (gEgo y:) 125)
					(self setScript: sEnterBar)
				else
					(self setScript: sExitSouth)
				)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance sEnterBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (hotel playMusic:)
					(gLongSong fade: 100 15 5 0)
				)
				(gEgo setPri: 4 setMotion: MoveTo 201 90 self)
			)
			(1
				(if (hotel playMusic:)
					(gLongSong fade: 127 15 5 0)
				)
				(gCurRoom newRoom: 52)
			)
		)
	)
)

(instance capital of Feature
	(properties
		x 69
		y 42
		noun 3
		modNum 51
		nsTop 26
		nsLeft 46
		nsBottom 58
		nsRight 92
		sightAngle 40
		onMeCheck 16
	)
)

(instance carpeting of Feature
	(properties
		x 140
		y 137
		noun 5
		modNum 51
		nsTop 108
		nsLeft 41
		nsBottom 167
		nsRight 240
		sightAngle 40
		onMeCheck 8
	)
)

(instance column of Feature
	(properties
		x 66
		y 106
		noun 2
		modNum 51
		nsTop 52
		nsLeft 56
		nsBottom 161
		nsRight 76
		sightAngle 40
		onMeCheck 32
	)
)

(instance doorFrame of Feature
	(properties
		x 170
		y 82
		noun 6
		modNum 51
		nsTop 58
		nsLeft 143
		nsBottom 107
		nsRight 197
		sightAngle 40
		onMeCheck 16
	)
)

(instance elevatorButton of Feature
	(properties
		x 132
		y 76
		noun 14
		modNum 51
		nsTop 72
		nsLeft 127
		nsBottom 81
		nsRight 137
		sightAngle 40
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(localproc_0 14 1 0)
			)
			(4 ; Do
				(gCurRoom setScript: sPressButton)
			)
		)
	)
)

(instance paneling of Feature ; UNUSED
	(properties
		x 74
		y 90
		noun 4
		modNum 51
		nsTop 75
		nsLeft 58
		nsBottom 106
		nsRight 91
		sightAngle 40
	)
)

(instance pidgeonHole of Feature
	(properties
		x 252
		y 100
		noun 16
		modNum 51
		nsTop 83
		nsLeft 242
		nsBottom 118
		nsRight 263
		sightAngle 40
		onMeCheck 32
	)
)

(instance rightPlant of Feature
	(properties
		x 203
		y 87
		noun 12
		modNum 51
		nsTop 57
		nsLeft 174
		nsBottom 118
		nsRight 233
		sightAngle 40
		onMeCheck 16384
	)
)

(instance leftPlant of Feature
	(properties
		x 50
		y 102
		noun 12
		modNum 51
		nsTop 77
		nsLeft 42
		nsBottom 127
		nsRight 59
		sightAngle 40
	)
)

(instance regDesk of Feature
	(properties
		x 217
		y 232
		z 100
		noun 7
		modNum 51
		nsTop 101
		nsLeft 166
		nsBottom 163
		nsRight 269
		sightAngle 40
		onMeCheck 4
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(localproc_0 7 1 0)
			)
			(4 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: sRingBell)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Ken of Narrator
	(properties
		x 150
		y 50
		talkWidth 150
		font 4
		showTitle 1
		back 19
	)
)

(instance elevatorGirl of Actor
	(properties
		x 100
		y 124
		view 420
		priority 4
		signal 18448
		cycleSpeed 4
		moveSpeed 4
	)

	(method (cue)
		(super cue:)
		(elevatorGirl dispose:)
	)
)

(instance sEnterFromOutside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (IsFlag 2)
					(gEgo
						init:
						view: global206
						setPri: 12
						posn: 7 150
						setLoop: 6
						setMotion: MoveTo 56 142 self
					)
				else
					(gEgo
						init:
						view: global206
						setPri: 12
						posn: 230 212
						setLoop: 7
						setMotion: MoveTo 151 153 self
					)
				)
				(= cycles 2)
			)
			(1
				(if (hotel playMusic:)
					(gLongSong fade: 50 15 5 0)
				)
			)
			(2
				(= seconds 3)
			)
			(3
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance deskClerk of Actor
	(properties
		x 277
		y 156
		noun 8
		modNum 51
		approachX 214
		approachY 161
		view 434
		loop 1
		priority 4
		signal 16400
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(hotel playMusic: 0)
				(if (< (gEgo x:) 128)
					(SetFlag 2)
					(gEgo setMotion: MoveTo 7 150 self)
				else
					(ClearFlag 2)
					(gEgo
						setPri: 12
						setMotion:
							MoveTo
							(+ (gEgo x:) 50)
							(+ (gEgo y:) 50)
							self
					)
				)
				(gLongSong fade: 10 25 2 0)
			)
			(1
				(gLongSong fade:)
				(if (IsFlag 2)
					(gCurRoom newRoom: 353)
				else
					(gLongSong2 number: 915 loop: -1 flags: 0 play: 40)
					(gCurRoom newRoom: 50)
				)
			)
		)
	)
)

(instance sEnterFromBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= register 0)
				(if (and (not (IsFlag 50)) (== global209 1) (IsFlag 27))
					(= register 1)
					((ScriptID 151 4) ; marie
						init:
						setLoop: 5
						posn: 201 90
						setCycle: Walk
						setMotion: MoveTo 130 130 self
					)
				else
					(= cycles 2)
				)
			)
			(1
				(if register
					((ScriptID 151 4) setLoop: 7 setMotion: MoveTo 107 125 self) ; marie
				else
					(= cycles 2)
				)
			)
			(2
				(if register
					((ScriptID 151 4) setLoop: 8 setCel: 3) ; marie
				)
				(NormalEgo)
				(gEgo
					init:
					view: global206
					setPri: 4
					posn: 201 90
					setLoop: 5
					ignoreActors: 1
					setMotion: MoveTo 152 121 self
				)
			)
			(3
				(if (not (IsFlag 27))
					(HandsOn)
					(NormalEgo)
					(self dispose:)
				else
					(gEgo setLoop: 1 setMotion: MoveTo 133 118 self)
				)
			)
			(4
				(gEgo setLoop: 8 setCel: 3)
				(= ticks 20)
			)
			(5
				(gCurRoom setScript: (ScriptID 151 1) 0 1) ; _sEnterElevator
			)
		)
	)
)

(instance sElevatorGirl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 151 3) setCel: 255) ; elevatorDoor
				(= cycles 2)
			)
			(1
				(elevatorSnd number: 922 play:)
				(= seconds 2)
			)
			(2
				(elevatorGirl setCycle: End self)
			)
			(3
				(= ticks 20)
			)
			(4
				(elevatorGirl
					setLoop: 1
					setCel: 0
					cycleSpeed: 3
					ignoreActors: 1
					illegalBits: 0
					setPri: 4
					setCycle: End self
				)
			)
			(5
				(elevatorGirl
					setLoop: 2
					setCycle: Fwd
					ignoreActors: 1
					setMotion: MoveTo 98 107 self
				)
			)
			(6
				(elevatorGirl setCycle: 0)
				(elevatorSnd number: 921 play:)
				((ScriptID 151 3) setCycle: Beg elevatorGirl) ; elevatorDoor
				(= ticks 30)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance sPressButton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 134 121 self)
			)
			(1
				(gEgo setLoop: 8 setCel: 3)
				(= ticks 30)
			)
			(2
				(elevatorSnd play:)
				(gCurRoom setScript: (ScriptID 151 1)) ; _sEnterElevator
			)
		)
	)
)

(instance sRingBell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsVIEW 1013)
				(Load rsSOUND 961)
				(if (and (!= (gEgo x:) 210) (!= (gEgo y:) 159))
					(gEgo setMotion: PolyPath 210 159 self)
				else
					(+= state 2)
					(= cycles 2)
				)
			)
			(1
				(if (== (gEgo heading:) 45)
					(= cycles 2)
				else
					(gEgo setHeading: 45 self)
				)
			)
			(2
				(= ticks 5)
			)
			(3
				(cond
					((== global206 2)
						(gEgo
							view: 432
							setLoop: 0
							setCel: 0
							setCycle: CT 3 1 self
						)
					)
					((and (== global206 0) (not (IsFlag 16)))
						(= state 7)
						(= cycles 2)
					)
					((and (== global206 1) (not (IsFlag 18)))
						(= state 7)
						(= cycles 2)
					)
					(else
						(= state 9)
						(= cycles 2)
					)
				)
			)
			(4
				(gLongSong2 number: 961 loop: 1 flags: 0 play:)
				(= ticks 5)
			)
			(5
				(gEgo setCycle: CT 5 1 self)
			)
			(6
				(gLongSong2 play:)
				(= ticks 5)
			)
			(7
				(gEgo setCycle: End)
				(= seconds (Random 3 6))
			)
			(8
				(deskClerk
					view: 433
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 233 143 self
					show:
				)
			)
			(9
				(deskClerk view: 434 setPri: 12 setLoop: 0 setCel: 1)
				(= ticks 10)
			)
			(10
				(cond
					((== global206 0)
						(if (IsFlag 16)
							(gMessager say: 8 2 2 0 self) ; "The clerk is ignoring you."
						else
							(SetFlag 16)
							(gMessager say: 8 2 1 0 self) ; "Hello."
						)
					)
					((== global206 2)
						(if (IsFlag 25)
							(gMessager say: 8 2 9 0 self) ; "Yes, sir. Is there something else I can help you with?"
						else
							(gMessager say: 8 2 5 0 self) ; "Excuse me..."
						)
					)
					((== global206 1)
						(if (IsFlag 18)
							(gMessager say: 8 2 4 0 self) ; "The clerk is ignoring you."
						else
							(SetFlag 18)
							(gMessager say: 8 2 3 0 self) ; "Hello."
						)
					)
				)
			)
			(11
				(if (or (!= global206 2) (IsFlag 25))
					(self changeState: 22)
				else
					(SetFlag 25)
					(deskClerk setLoop: 1 setCel: 0 setCycle: End self)
				)
			)
			(12
				(= ticks 30)
			)
			(13
				(deskClerk setLoop: 2 setCel: 0 setCycle: End self)
			)
			(14
				(= ticks 30)
			)
			(15
				(deskClerk setCycle: Beg self)
			)
			(16
				(= ticks 30)
			)
			(17
				(deskClerk setLoop: 1 setCel: 255 setCycle: Beg self)
			)
			(18
				(deskClerk setLoop: 3 setCel: 0 setCycle: End self)
			)
			(19
				(gEgo view: 432 setCel: 3 get: 18) ; Hotel_Room_Key
				(= ticks 30)
			)
			(20
				(NormalEgo)
				(gEgo loop: 6)
				(deskClerk setCycle: Beg self)
			)
			(21
				(= ticks 30)
			)
			(22
				(deskClerk setLoop: 1 setCel: 0)
				(= ticks 10)
			)
			(23
				(deskClerk setCycle: CT 3 1 self)
			)
			(24
				(deskClerk
					view: 433
					setLoop: 0
					setCycle: Walk
					setPri: 4
					posn: (+ (deskClerk x:) 7) (- (deskClerk y:) 1)
					setMotion: MoveTo 277 156 self
				)
			)
			(25
				(HandsOn)
				(deskClerk hide: stopUpd:)
				(NormalEgo)
				(gEgo loop: 6)
				(self dispose:)
			)
		)
	)
)

