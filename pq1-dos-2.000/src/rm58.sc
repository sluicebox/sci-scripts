;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 58)
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
	rm58 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
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

(instance rm58 of PQRoom
	(properties
		picture 58
	)

	(method (init)
		(= global224 {Last update\nTues 5-5-92 13:30})
		(= global206 2)
		(if
			(and
				(== gPrevRoomNum 1)
				(Print
					addText: {Did you call Morgan?}
					addButton: 0 {No} 0 12
					addButton: 1 {Yes} 0 26
					init:
				)
			)
			(SetFlag 49)
			(gEgo get: 19) ; Deluxe_Transmitter_Pen
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 2 187 314 187 314 110 195 87 231 66 189 51 214 40 209 38 58 77 27 116 2 116
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 207 69 210 76 191 86 150 67 178 56
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 99 148 99 169 78 169 78 179 36 179 36 172 7 172 7 148
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 127 131 190 131 216 142 215 148 211 156 139 156 127 146
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 308 127 308 182 139 182 129 171 129 158 222 158 236 145 199 131 161 124 149 114 181 100
					yourself:
				)
		)
		(super init:)
		(Load rsSOUND 922)
		(gLongSong number: 580 loop: -1 play: 1)
		(self setRegions: 151) ; hotel
		(elevator init:)
		(frank view: 487 init: setLoop: 8 setCel: 4 setPri: 2 posn: 87 59)
		(gEgo
			view: global206
			init:
			actions: egoActions
			setLoop: 8
			setCel: 4
			posn: 71 64
			setPri: 2
		)
		(tropicalPlant init:)
		(phone init:)
		(sticks init:)
		(rug init:)
		(roundTable init:)
		(theRoom init:)
		(plantPot2 init:)
		(plantPot1 init:)
		(paneling init:)
		(mirror init:)
		(glassTable init:)
		(glasses init:)
		(chairs init:)
		(bottles init:)
		(bar init:)
		(barPlant init:)
		(indianPot init:)
		(bottle1 init:)
		(bottle2 init:)
		(brownBottle init:)
		(blueCup init:)
		(tree init: approachVerbs: 4) ; Do
		(self setScript: sExitTheElevator)
	)

	(method (notify param1 &tmp [temp0 200])
		(if (== param1 22)
			(proc151_9)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(or
					(gEgo inRect: 200 79 319 135)
					(gEgo inRect: 0 105 49 131)
				)
				local4
				(frank script:)
				(not local5)
				(== (frank x:) 132)
			)
			(= local5 1)
			(sShootout cue:)
		)
	)

	(method (cue)
		(if (not (frank script:))
			(frank setScript: sShootout)
		)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance elevator of Prop
	(properties
		x 109
		y 57
		view 58
		priority 3
		signal 16400
	)
)

(instance frank of Actor
	(properties
		x 87
		y 59
		view 487
		loop 8
		cel 4
	)
)

(instance barPlant of Feature
	(properties
		x 225
		y 38
		noun 12
		nsTop 25
		nsLeft 208
		nsBottom 52
		nsRight 242
		sightAngle 40
		onMeCheck 4
	)
)

(instance bar of Feature
	(properties
		x 263
		y 79
		noun 14
		nsTop 53
		nsLeft 207
		nsBottom 106
		nsRight 319
		sightAngle 40
		onMeCheck 2
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (not local8)
					(= local8 1)
					(gMessager say: 16 4) ; "Were you planning on having a little drink to bolster your courage, Officer? How long do you want to live, anyway?"
				else
					(gCurRoom setScript: sTakeADrink)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bottles of Feature
	(properties
		x 298
		y 30
		noun 16
		nsTop 19
		nsLeft 277
		nsBottom 41
		nsRight 319
		sightAngle 40
		onMeCheck 2
	)
)

(instance chairs of Feature
	(properties
		x 51
		y 150
		noun 5
		nsTop 128
		nsLeft 8
		nsBottom 173
		nsRight 95
		sightAngle 40
		onMeCheck 4
	)
)

(instance couches of Feature ; UNUSED
	(properties
		x 205
		y 134
		noun 9
		nsTop 90
		nsLeft 119
		nsBottom 178
		nsRight 292
		sightAngle 40
		onMeCheck 16384
	)
)

(instance glasses of Feature
	(properties
		x 276
		y 40
		noun 15
		nsTop 27
		nsLeft 234
		nsBottom 54
		nsRight 319
		sightAngle 40
		onMeCheck 8
	)
)

(instance glassTable of Feature
	(properties
		x 169
		y 126
		noun 6
		nsTop 120
		nsLeft 139
		nsBottom 132
		nsRight 199
		sightAngle 40
		onMeCheck 2
	)
)

(instance indianPot of Feature
	(properties
		x 168
		y 116
		noun 7
		nsTop 106
		nsLeft 156
		nsBottom 127
		nsRight 180
		sightAngle 40
		onMeCheck 4
	)
)

(instance mirror of Feature
	(properties
		x 269
		y 41
		noun 17
		nsTop 16
		nsLeft 219
		nsBottom 67
		nsRight 319
		sightAngle 40
		onMeCheck 16
	)
)

(instance paneling of Feature
	(properties
		x 82
		y 47
		noun 2
		nsTop 30
		nsBottom 70
		nsRight 164
		sightAngle 40
		onMeCheck 16
	)
)

(instance plantPot1 of Feature
	(properties
		x 12
		y 100
		noun 13
		nsTop 91
		nsBottom 109
		nsRight 24
		sightAngle 40
		onMeCheck 2
	)
)

(instance plantPot2 of Feature
	(properties
		x 269
		y 267
		z 100
		noun 13
		nsTop 149
		nsLeft 249
		nsBottom 177
		nsRight 290
		sightAngle 40
		onMeCheck 2
	)
)

(instance theRoom of Feature
	(properties
		x 159
		y 1
		z 93
		noun 1
		nsBottom 189
		nsRight 319
		sightAngle 40
	)
)

(instance roundTable of Feature
	(properties
		x 52
		y 147
		noun 4
		nsTop 133
		nsLeft 23
		nsBottom 161
		nsRight 82
		sightAngle 40
		onMeCheck 2
	)
)

(instance rug of Feature
	(properties
		x 160
		y 134
		noun 3
		nsTop 79
		nsLeft 7
		nsBottom 189
		nsRight 313
		sightAngle 40
		onMeCheck 16
	)
)

(instance sticks of Feature
	(properties
		x 154
		y 87
		noun 8
		nsTop 66
		nsLeft 137
		nsBottom 109
		nsRight 171
		sightAngle 40
		onMeCheck 8
	)
)

(instance tropicalPlant of Feature
	(properties
		x 270
		y 129
		noun 11
		nsTop 76
		nsLeft 222
		nsBottom 182
		nsRight 319
		sightAngle 40
		onMeCheck 4
	)
)

(instance phone of View
	(properties
		x 305
		y 178
		z 100
		noun 19
		view 547
		loop 2
		priority 6
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(if (OneOf theVerb 1 4 2) ; Look, Do, Talk
			(SetScore 199 5)
			(gCurRoom setScript: sLookPhone 0 theVerb)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

(instance takeDrink of View ; UNUSED
	(properties
		x 218
		y 90
		view 532
		priority 12
	)
)

(instance brownBottle of View
	(properties
		x 235
		y 65
		view 532
		loop 2
		cel 5
		priority 6
		signal 24592
	)
)

(instance bottle1 of View
	(properties
		x 253
		y 66
		view 532
		loop 2
		cel 5
		priority 6
		signal 24592
	)
)

(instance pourDrink of View ; UNUSED
	(properties
		x 218
		y 90
		view 532
		loop 1
		cel 2
		priority 12
	)
)

(instance bottle2 of View
	(properties
		x 247
		y 64
		view 532
		loop 2
		cel 8
		priority 6
		signal 24592
	)
)

(instance call4backup of View ; UNUSED
	(properties
		x 299
		y 112
		view 547
		priority 12
	)
)

(instance blueCup of View
	(properties
		x 231
		y 65
		view 532
		loop 2
		cel 3
		priority 5
		signal 24592
	)
)

(instance sTakeADrink of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 218 90 self)
			)
			(1
				(brownBottle hide:)
				(gEgo view: 532 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(2
				(= ticks 60)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(brownBottle show:)
				(= ticks 60)
			)
			(5
				(blueCup hide:)
				(gEgo setLoop: 0 setCel: 0 setCycle: End self)
			)
			(6
				(= ticks 60)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(blueCup show:)
				(HandsOn)
				(NormalEgo)
				(gEgo loop: 6)
				(self dispose:)
			)
		)
	)
)

(instance sExitTheElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Load rsSOUND 937)
				(Load rsSOUND 921)
				(= ticks 20)
			)
			(1
				(gLongSong fade: 127 25 15 0)
				(= ticks 30)
			)
			(2
				(elevatorSnd number: 922 loop: 1 play: self)
			)
			(3
				(= seconds 3)
			)
			(4
				(elevatorSnd number: 920 loop: 1 play:)
				(elevator setCycle: End self)
			)
			(5
				(= seconds 2)
			)
			(6
				(frank
					setPri: 4
					setCycle: Walk
					setLoop: 4
					setMotion: MoveTo 117 74 self
				)
			)
			(7
				(frank setLoop: 8 setCel: 2)
				(= ticks 6)
			)
			(8
				(frank setLoop: 8 setCel: 5)
				(= ticks 6)
			)
			(9
				(frank setLoop: 8 setCel: 1)
				(= ticks 6)
			)
			(10
				(frank setLoop: 8 setCel: 7)
				(= ticks 6)
			)
			(11
				(NormalEgo)
				(gEgo setPri: 2 setMotion: MoveTo 89 78 self)
			)
			(12
				(frank setCel: 1)
				(elevatorSnd number: 921 loop: 1 play:)
				(gEgo setPri: -1 setHeading: 90)
				(= cycles 3)
			)
			(13
				(elevator setCycle: Beg self)
			)
			(14
				(gMessager say: 18 0 12 0 self) ; "You play a good game of poker, Mr. Banksten. That proves to me that you're sharp. There's something I want to tell you."
			)
			(15
				(SetFlag 33)
				(= ticks 10)
			)
			(16
				(gMessager say: 18 0 13 0 self) ; "My name isn't Frank Magpie. It's Jesse Bains. You may have heard the name before? No? Maybe this will help. Some of my men have coined an amusing little nickname for me: The Death Angel. Starting to sound familiar?"
			)
			(17
				(sfx number: 937 loop: -1 play:)
				(= ticks 30)
			)
			(18
				(gMessager say: 18 0 15 0 self) ; "Excuse me for a moment, won't you? I'll take the call in the other room. Help yourself to a refreshment at the bar. I'll be back momentarily."
			)
			(19
				(frank setLoop: 8 setCel: 7)
				(= ticks 5)
			)
			(20
				(frank setLoop: 8 setCel: 3)
				(= ticks 5)
			)
			(21
				(frank setLoop: 8 setCel: 6)
				(= ticks 5)
			)
			(22
				(frank
					setLoop: 6
					setCycle: Walk
					setPri: -1
					setMotion: MoveTo 214 42 self
				)
			)
			(23
				(= local0 1)
				(frank hide:)
				(= ticks 20)
				(if (not (HaveMouse))
					(roomTimer setReal: gCurRoom 60)
				else
					(roomTimer setReal: gCurRoom 30)
				)
			)
			(24
				(HandsOn)
				(NormalEgo)
				(sfx stop:)
				(= cycles 2)
			)
			(25
				(self dispose:)
			)
		)
	)
)

(instance tree of Feature
	(properties
		x 21
		y 59
		noun 10
		nsTop 33
		nsBottom 86
		nsRight 42
		sightAngle 40
		onMeCheck 4
		approachX 19
		approachY 116
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (not (frank script:))
					(frank setScript: sShootout 0 1)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sLookPhone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 293 114 self)
			)
			(1
				(gEgo setLoop: 8 setCel: 6)
				(= cycles 2)
			)
			(2
				(cond
					((== register 1)
						(gEgo
							view: 547
							setLoop: 1
							setCel: 0
							setCycle: End self
						)
					)
					(local2
						(+= state 2)
						(gMessager say: 19 4 2 0 self) ; "Although picking up a phone extension and eavesdropping on a conversation always works in the movies, it almost never works in real life. Are you willing to risk it with a drug dealer who probably carries more firepower than a small European country? I didn't think so."
					)
					(else
						(++ local2)
						(+= state 2)
						(gMessager say: 19 4 0 0 self) ; "That would make Bains a wee bit suspicious, wouldn't it?"
					)
				)
			)
			(3
				(= local1 1)
				(gMessager say: 19 1 0 0 self) ; "It's a telephone. The room number imprinted upon it is 401."
			)
			(4
				(++ state)
				(gEgo setCycle: Beg self)
			)
			(5
				(if (not (frank script:))
					(frank setScript: sShootout)
				)
				(= cycles 2)
			)
			(6
				(HandsOn)
				(NormalEgo)
				(gEgo loop: 6)
				(self dispose:)
			)
		)
	)
)

(instance backup1 of Actor
	(properties
		x 293
		y 245
		view 543
		loop 4
		signal 26624
	)
)

(instance backup2 of Actor
	(properties
		x 152
		y 242
		view 545
		loop 2
		signal 26624
	)

	(method (cue)
		(super cue:)
		(self setLoop: 0 setCel: 0 setCycle: End)
	)
)

(instance backup3 of Actor
	(properties
		x -15
		y 230
		view 544
		loop 1
		signal 26624
	)

	(method (cue)
		(super cue:)
		(self setLoop: 0 setCel: 0 setCycle: End)
	)
)

(instance sShootout of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 940)
				(Load rsSOUND 582)
				(cond
					(register
						(gMessager say: 10 4 0 0 self) ; "You touch the tree, and discover it is real. However, Bains is looking at you strangely. You might be a vegetable yourself in another moment or two."
					)
					(local4
						(= ticks 30)
					)
					(else
						(= ticks 30)
					)
				)
			)
			(1
				(if
					(and
						(not (gEgo inRect: 0 105 49 131))
						(not (gEgo inRect: 200 79 319 135))
					)
					(-- state)
					(= cycles 2)
				else
					(HandsOff)
					(gCurRoom setScript: 0)
					(= local5 1)
					(gEgo setMotion: 0 setCycle: 0)
					(if (gLongSong handle:)
						(gLongSong fade: 0 15 15 1)
					)
					(gLongSong2 number: 582 loop: -1 play:)
					(frank show: setLoop: 5 setMotion: MoveTo 132 68 self)
					(if (gEgo inRect: 200 79 319 135)
						(gEgo setLoop: 8 setCel: 7)
					else
						(gEgo setLoop: 8 setCel: 6)
					)
				)
			)
			(2
				(if (gEgo inRect: 200 79 319 135)
					(frank setLoop: 8 setCel: 4)
				else
					(frank setLoop: 8 setCel: 5)
				)
				(= ticks 20)
			)
			(3
				(gMessager say: 21 0 5 0 self) ; "I just got a most interesting phone call. It seems that one of our playing partners recognized you from somewhere, "Mr. Banksten.""
			)
			(4
				(if (not local6)
					(= cycles 2)
				else
					(sUsePen cue:)
				)
			)
			(5
				(if (gEgo inRect: 200 79 319 135)
					(frank view: 542 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
				else
					(frank view: 542 setLoop: 2 setCel: 0 setCycle: CT 3 1 self)
				)
				(Load rsSOUND 940)
				(Load rsSOUND 586)
				(Load rsVIEW 541)
			)
			(6
				(gMessager say: 21 0 14 0 self) ; "Kiss your ass goodbye!"
			)
			(7
				(frank setCycle: End)
				(gunShot number: 940 loop: 1 play:)
				(if (gEgo inRect: 200 79 319 135)
					(gEgo view: 541 setLoop: 0 setCel: 0 setCycle: End self)
				else
					(gEgo view: 541 setLoop: 2 setCel: 0 setCycle: End self)
				)
				(frank setCycle: End)
			)
			(8
				(gLongSong2 number: 586 loop: 1 play: self)
			)
			(9
				(= seconds 2)
			)
			(10
				(gLongSong2 fade: 0 15 10 1)
				(gLongSong fade: 0 15 10 1)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 99 6)
				(= seconds 2)
			)
			(11
				(cond
					((not (IsFlag 49))
						(EgoDead 29)
					)
					((not local1)
						(EgoDead 31)
					)
					(else
						(EgoDead 30)
					)
				)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb &tmp [temp0 20])
		(if (or (== theVerb 49) (== theVerb 2)) ; Deluxe_Transmitter_Pen, Talk
			(cond
				((and (== theVerb 2) (not (gEgo has: 19))) ; Talk, Deluxe_Transmitter_Pen
					(gMessager say: 20 0 17) ; "You start to talk to yourself then realize you already know what you were going to say."
				)
				((not (IsFlag 49))
					(gMessager say: 20 0 18) ; MISSING MESSAGE
				)
				(local3
					(gMessager say: 20 0 16) ; "You already did that."
				)
				(else
					(backup1 init: posn: 1000 1000 setScript: sUsePen)
					(backup2 init:)
					(backup3 init:)
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance sUsePen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if
					(and
						(not (gEgo inRect: 200 79 319 135))
						(not (gEgo inRect: 0 105 49 131))
					)
					(gEgo
						illegalBits: 0
						ignoreActors: 1
						setMotion: PolyPath 253 108 self
					)
				else
					(= cycles 2)
				)
			)
			(1
				(SetScore 198 12)
				(gEgo setCycle: Walk setMotion: 0 setHeading: 310 self)
			)
			(2
				(gEgo setLoop: 8 setCel: 7)
				(= ticks 10)
			)
			(3
				(gEgo view: 547 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(4
				(if local1
					(= local4 1)
					(gMessager say: 20 0 4 0 self) ; "Backup, this is Whitey. Requesting code-3 immediately. My location is the top floor penthouse Hotel Delphoria, room 401. Repeat, room 401."
				else
					(gMessager say: 20 0 3 0 self) ; "Backup, this is Whitey. I've located the Death Angel. Code-3 immediately, repeat, immediately!"
				)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(= local3 1)
				(NormalEgo)
				(gEgo loop: 7)
				(if local4
					(= cycles 2)
				else
					(HandsOn)
					(self dispose:)
				)
			)
			(7
				(gMessager say: 21 0 19 0 self) ; "Five minutes later..."
			)
			(8
				(backup1
					setLoop: 4
					setCycle: Fwd
					posn: 293 245
					setMotion: MoveTo 224 182 self
				)
				(backup2 setCycle: Fwd setMotion: MoveTo 152 186 backup2)
				(backup3 setCycle: Fwd setMotion: MoveTo 32 180 backup3)
			)
			(9
				(backup1 setCycle: 0)
				(= ticks 10)
			)
			(10
				(backup1 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(11
				(= local6 1)
				(if (not (sShootout state:))
					(sShootout cue:)
				)
			)
			(12
				(if (gLongSong handle:)
					(gLongSong fade: 0 15 15 1)
				)
				(frank setLoop: 8 setCel: 2)
				(= ticks 15)
			)
			(13
				(backup1 setLoop: 2 setCel: 0)
				(frank view: 549 setLoop: 0 setCel: 6 setScript: 0)
				(= ticks 15)
			)
			(14
				(frank setCel: 7)
				(= ticks 15)
			)
			(15
				(frank setLoop: 1 setCel: 0 setCycle: CT 2 1 self)
			)
			(16
				(backup1 setCel: 1)
				(gunShot number: 940 loop: 1 play: self)
			)
			(17
				(backup1 setCel: 2)
				(= ticks 20)
			)
			(18
				(backup1 setCel: 0)
				(= ticks 20)
			)
			(19
				(frank setCel: 3)
				(backup1 setCel: 1)
				(gunShot number: 940 loop: 1 play: self)
				(backup1 setCel: 2)
			)
			(20
				(backup1 setCel: 0)
				(= ticks 20)
			)
			(21
				(frank setCycle: End self)
			)
			(22
				(sfx number: 586 loop: 1 play: self)
			)
			(23
				(gLongSong2 number: 584 loop: -1 play:)
				(NormalEgo)
				(= seconds 2)
			)
			(24
				(gEgo setHeading: 200 self)
			)
			(25
				(= cycles 2)
			)
			(26
				(gMessager say: 21 0 7 0 self) ; "Bonds! You all right?"
			)
			(27
				(gEgo
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo 159 89 self
				)
			)
			(28
				(NormalEgo)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath (frank x:) (frank y:) self
				)
			)
			(29
				(gEgo setHeading: 360 self)
			)
			(30
				(= cycles 2)
			)
			(31
				(gMessager say: 21 0 8 0 self) ; "You got him. The Death Angel is down. You feel an overwhelming sense of relief, but you can't help feeling a little sick. You've never seen a man gunned down before. Unable to turn away, you stare at Jesse Bains's broken body..."
			)
			(32
				(= seconds 3)
			)
			(33
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 99 6)
				(= seconds 2)
			)
			(34
				(gCurRoom newRoom: 60)
			)
		)
	)
)

(instance gunShot of Sound
	(properties)
)

(instance sfx of Sound
	(properties)
)

