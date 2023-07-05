;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 57)
(include sci.sh)
(use Main)
(use hotel)
(use eRS)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm57 0
)

(local
	local0
	local1
	local2
	local3
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

(instance rm57 of PQRoom
	(properties
		picture 99
	)

	(method (init)
		(= global224 {Last update:\nMon 5-4-92  849})
		(= local2 (gEgo moveSpeed:))
		(= local3 (gEgo cycleSpeed:))
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 67 117 67 159 241 159 241 121 192 113 193 91 182 112 118 101
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 103 125 165 125 165 135 175 135 175 155 103 155
					yourself:
				)
		)
		(super init:)
		(self setRegions: 151) ; hotel
		(wallPaper init:)
		(table init:)
		(theRoom init:)
		(redLamps init:)
		(paneling init:)
		(painting init:)
		(lamp init:)
		(lampPole init:)
		(coneLamps init:)
		(switch gPrevRoomNum
			(156
				(gCurRoom drawPic: 57)
				(if global251
					(= global251 0)
					(= global108 1)
				)
				(= global213 global209)
				(gEgo
					init:
					view: 494
					ignoreActors: 1
					posn: 119 142
					setLoop: 0
					setCel: 6
					setPri: 9
					setCycle: 0
					setPri: -1
				)
				(leftDoor init:)
				((ScriptID 151 3) ; elevatorDoor
					init:
					view: 533
					setLoop: 0
					setCel: 0
					posn: 219 111
					setPri: 4
					cycleSpeed: 1
					noun: 9
					modNum: 57
					actions: doorActions
					stopUpd:
				)
				(frank init: stopUpd:)
				(otto init: stopUpd:)
				(gene init: stopUpd:)
				(self setScript: sEnter_Elevator)
			)
			(else
				(self setScript: sEnterFromCardRoom)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
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
			((& (gEgo onControl: 1) $4000)
				(self setScript: sGoUpstairs)
			)
		)
	)
)

(instance chair of View
	(properties
		view 494
		signal 24576
	)
)

(instance guard of Actor
	(properties)
)

(instance leftDoor of Prop
	(properties
		x 78
		y 106
		noun 16
		modNum 57
		view 535
		priority 6
		signal 16
		cycleSpeed 1
	)
)

(instance lamp of Feature
	(properties
		x 133
		y 191
		z 100
		noun 5
		nsTop 81
		nsLeft 122
		nsBottom 102
		nsRight 144
		sightAngle 40
		onMeCheck 16384
	)
)

(instance painting of Feature
	(properties
		x 196
		y 38
		noun 8
		nsTop 30
		nsLeft 175
		nsBottom 46
		nsRight 218
		sightAngle 40
		onMeCheck 4
	)
)

(instance coneLamps of Feature
	(properties
		x 100
		y 54
		noun 6
		nsTop 48
		nsLeft 95
		nsBottom 61
		nsRight 105
		sightAngle 40
		onMeCheck 2
	)
)

(instance paneling of Feature
	(properties
		x 157
		y 96
		noun 3
		nsTop 74
		nsLeft 62
		nsBottom 119
		nsRight 252
		sightAngle 40
		onMeCheck 8
	)
)

(instance redLamps of Feature
	(properties
		x 197
		y 59
		noun 7
		nsTop 50
		nsLeft 155
		nsBottom 69
		nsRight 240
		sightAngle 40
		onMeCheck 2
	)
)

(instance table of Feature
	(properties
		x 135
		y 229
		z 100
		noun 4
		nsTop 118
		nsLeft 112
		nsBottom 140
		nsRight 158
		sightAngle 40
		onMeCheck 2
	)
)

(instance theRoom of Feature
	(properties
		x 156
		y 126
		noun 1
		nsTop 99
		nsLeft 62
		nsBottom 153
		nsRight 250
		sightAngle 40
		onMeCheck 16
	)
)

(instance wallPaper of Feature
	(properties
		x 156
		y 61
		noun 2
		nsTop 29
		nsLeft 63
		nsBottom 93
		nsRight 250
		sightAngle 40
		onMeCheck 16
	)
)

(instance frankChair of View
	(properties
		x 155
		y 154
		view 490
		loop 3
		signal 24576
	)
)

(instance doorActions of Actions
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1) ; "It appears to be a freight elevator."
			)
			(4 ; Do
				(gMessager say: 9 4) ; "It just wouldn't look right if you started playing with the elevator, Bonds."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sGoUpstairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 3 setMotion: PolyPath 194 103 self)
			)
			(1
				(gEgo setHeading: 195 self)
			)
			(2
				(= seconds 2)
			)
			(3
				((ScriptID 151 3) show: setCycle: Beg self) ; elevatorDoor
			)
			(4
				(gCurRoom newRoom: 58)
			)
		)
	)
)

(instance frank of Fool
	(properties
		x 155
		y 154
		noun 15
		view 490
		signal 24576
		status 7
	)

	(method (cue)
		(super cue:)
		(switch (++ local0)
			(1
				(self setHeading: 190 self)
			)
			(2
				(self setLoop: 8 setCel: 5 setPri: 2)
				(roomTimer setReal: self 4)
			)
			(3
				(gMessager say: 15 2 12) ; "Walk this way, Whitey."
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 32)
					(gMessager say: 15 1 10) ; "It's the Death Angel, Jesse Bains."
				else
					(gMessager say: 15 1 11) ; "It's Frank Magpie."
				)
			)
			(4 ; Do
				(gMessager say: 15 4) ; "Not a good idea, Bonds."
			)
			(2 ; Talk
				(cond
					((== global213 2)
						(gMessager say: 15 2 6) ; "Goodnight, Mr. Banksten."
					)
					((== gPrevRoomNum 156)
						(gMessager say: 15 2 12) ; "Walk this way, Whitey."
					)
					(else
						(gMessager say: 15 2 5 0 (gCurRoom script:)) ; "I would like that very much, Mr. Magpie."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance gene of View
	(properties
		x 117
		y 152
		noun 13
		view 488
		priority 14
		signal 24576
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 13 1) ; "It's Gene "The Bambino" Bamboni."
			)
			(4 ; Do
				(gMessager say: 13 4) ; "Gene has a good sense of humor, but not that good."
			)
			(2 ; Talk
				(cond
					((== gPrevRoomNum 156)
						(gMessager say: 13 2 12) ; "That was some fine poker playing, Whitey."
					)
					((== global213 2)
						(gMessager say: 13 2 6) ; "Hang loose, Whitey."
					)
					(local1
						(gMessager say: 13 2 13) ; "Hey, Whitey. It's rude not to answer our host!"
					)
					(else
						(gMessager say: 13 2 2) ; "Be cool, Whitey my friend. Frank's on his way. He's probably just shining his shoes and powdering his nose, ha ha. The guy is vain!"
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance otto of View
	(properties
		x 136
		y 122
		noun 14
		view 489
		priority 9
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 14 1) ; "It's Otto Lipschitz."
			)
			(4 ; Do
				(gMessager say: 14 4) ; "He'd probably bite your arm off and beat you with it."
			)
			(2 ; Talk
				(cond
					((== global213 2)
						(gMessager say: 14 2 6) ; "Goodnight, Mr. Banksten. Try not to let anyone else take advantage of your ignorance."
					)
					((== gPrevRoomNum 156)
						(gMessager say: 14 2 12) ; "That's some mighty smooth card playing, Whitey."
					)
					(local1
						(gMessager say: 14 2 13) ; "I would be impolite to ignore our gracious host, Whitey."
					)
					(else
						(gMessager say: 14 2 2) ; "Mr. Banksten, I assure you that Mr. Magpie will be down any moment. Please don't inflict your conversation on me. I have a low tolerance for mediocrity."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lampPole of Feature
	(properties
		x 132
		y 157
		z 100
		noun 17
		nsTop 29
		nsLeft 130
		nsBottom 86
		nsRight 134
		sightAngle 40
		onMeCheck 16384
	)
)

(instance sEnter_Elevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(frank setLoop: 2)
				(= seconds 3)
			)
			(1
				(if (== global213 2)
					(gMessager say: 12 0 6 0 self) ; "Bad run of luck, Mr. Banksten. Perhaps you should have brushed up on your poker skills before playing. Ah well, nothing's lost...but your money. Goodnight, Mr. Banksten."
				else
					(++ state)
					(if (== gPrevRoomNum 156)
						(SetScore 193 15)
					)
					(frank setCycle: End self)
				)
			)
			(2
				(EgoDead 27)
			)
			(3
				(if (== gPrevRoomNum 156)
					(frankChair init:)
				else
					(frankChair show:)
				)
				(frank view: 487 setLoop: 2 posn: 150 153)
				(= ticks 5)
			)
			(4
				(frank setCycle: Walk setMotion: MoveTo 150 156 self)
			)
			(5
				(frank setLoop: 0 setMotion: MoveTo 192 158 self)
			)
			(6
				(frank setLoop: -1 setMotion: MoveTo 201 124 self)
			)
			(7
				((ScriptID 151 3) setCycle: End self) ; elevatorDoor
			)
			(8
				((ScriptID 151 3) hide:) ; elevatorDoor
				(frank setMotion: MoveTo 210 106 frank)
				(gEgo
					view: 494
					setLoop: 0
					setCel: 255
					setCycle: Beg self
					setPri: 10
				)
			)
			(9
				(gMessager say: 14 2 12 0 self) ; "That's some mighty smooth card playing, Whitey."
			)
			(10
				(if (== gPrevRoomNum 156)
					(chair init: posn: (gEgo x:) (gEgo y:) setLoop: 3)
				else
					(chair setLoop: 3 setCel: 0 posn: 120 142 setPri: 10 show:)
				)
				(NormalEgo)
				(gEgo view: global206 posn: 126 138 setHeading: 90 self)
			)
			(11
				(gMessager say: 13 2 12 0 self) ; "That was some fine poker playing, Whitey."
			)
			(12
				(= seconds 2)
			)
			(13
				(HandsOn)
				(= gPrevRoomNum 156)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromCardRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(gCurRoom drawPic: 57)
				(leftDoor init:)
				((ScriptID 151 3) ; elevatorDoor
					init:
					view: 533
					setLoop: 0
					setCel: 0
					posn: 219 111
					setPri: 4
					cycleSpeed: 1
					noun: 9
					modNum: 57
					actions: doorActions
					stopUpd:
				)
				(frank init: stopUpd:)
				(otto init: stopUpd:)
				(gene init: stopUpd:)
				(chair view: 494 init: setLoop: 3 posn: 120 142 stopUpd:)
				(frankChair init: stopUpd:)
				(frank view: 487 posn: 210 106 setPri: 3 setLoop: 8 setCel: 5)
				(leftDoor setCycle: End self)
			)
			(2
				(leftDoor stopUpd:)
				(gEgo
					init:
					view: global206
					setPri: -1
					posn: 53 108
					setLoop: 4
					ignoreActors: 1
					illegalBits: 0
					setMotion: MoveTo 86 124 self
				)
			)
			(3
				(guard
					view: 524
					init:
					setPri: 2
					posn: 49 110
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 64 109 self
				)
				(gEgo setLoop: 8 setCel: 4)
			)
			(4
				(= seconds 2)
			)
			(5
				(guard setLoop: 8 setCel: 4)
				(leftDoor setCycle: Beg self)
			)
			(6
				(leftDoor stopUpd:)
				(gEgo setLoop: 0 setMotion: MoveTo 92 128 self)
				(guard dispose:)
			)
			(7
				(gEgo
					setLoop: 0
					ignoreActors: 1
					setMotion: MoveTo 124 141 self
				)
			)
			(8
				(chair hide:)
				(gEgo
					view: 494
					setLoop: 0
					posn: 119 142
					setCel: 0
					setCycle: End self
				)
			)
			(9
				(gEgo view: 494 setLoop: 1 setCel: 255 setPri: 11 stopUpd:)
				(= seconds 2)
			)
			(10
				(gMessager say: 12 0 1 0 self) ; "Ah, welcome, my friend. You already know Otto, so I won't bother to introduce you, ha ha!"
			)
			(11
				(HandsOn)
				(gTheIconBar disable: 0)
				(= seconds (Random 10 20))
			)
			(12
				(HandsOff)
				(= local1 1)
				((ScriptID 151 3) setCycle: End self) ; elevatorDoor
			)
			(13
				((ScriptID 151 3) hide:) ; elevatorDoor
				(frank setLoop: 5 setCycle: Walk setMotion: MoveTo 192 124 self)
			)
			(14
				((ScriptID 151 3) show: setCycle: Beg) ; elevatorDoor
				(frank setLoop: 2 setPri: -1 setMotion: MoveTo 192 155 self)
			)
			(15
				(frank setLoop: 1 setPri: 15 setMotion: MoveTo 150 155 self)
			)
			(16
				(frank
					view: 490
					setLoop: 2
					posn: (frankChair x:) (frankChair y:)
					setCel: 255
				)
				(frankChair hide:)
				(= ticks 20)
			)
			(17
				(frank setPri: -1 setCycle: Beg self)
			)
			(18
				(gMessager say: 12 0 4 0 self) ; "Ah, Mr. Banksten. Thank you for your patience, and welcome back. Perhaps after the game, you'd be interested in talking business?"
			)
			(19
				(HandsOn)
				(gTheIconBar disable: 0)
			)
			(20
				(gGame setCursor: 999 1)
				(= cycles 2)
			)
			(21
				(switch
					(Print
						addText: 18 0 15 1 0 0 57 ; "Do you wish to play poker?"
						addButton: 1 18 0 16 1 0 15 57 ; "Yes!"
						addButton: 2 18 0 17 1 0 30 57 ; "No, but win anyway."
						addButton: 3 18 0 18 1 0 45 57 ; "No, but lose anyway."
						init:
					)
					(1
						(= global209 0)
						(= global251 0)
						(gCast eachElementDo: #hide)
						(gCurRoom drawPic: 99 9)
						(= seconds 2)
					)
					(2
						(= global213 (= global209 3))
						(gCurRoom setScript: sEnter_Elevator)
					)
					(3
						(= global213 (= global209 2))
						(gCurRoom setScript: sEnter_Elevator)
					)
				)
			)
			(22
				(gCurRoom newRoom: 156)
			)
		)
	)
)

