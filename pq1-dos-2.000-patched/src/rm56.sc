;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 56)
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
(use User)
(use Actor)
(use System)

(public
	rm56 0
)

(local
	local0
	local1
	local2
)

(procedure (localproc_0)
	(grayGuy2 setScript: (Clone sDolt) stopUpd:)
	(otto setScript: (Clone sDolt) stopUpd:)
	(frank setScript: (Clone sDolt) stopUpd:)
	(blueGuy setScript: (Clone sDolt) stopUpd:)
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

(instance rm56 of PQRoom
	(properties
		picture 56
	)

	(method (init)
		(= global224 {Last update:\nMon 5-4-92__830})
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 107 111 171 111 171 143 107 143
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 173 128 238 128 238 154 173 154
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 68 115 68 145 125 145 125 159 241 159 241 124 141 98 121 98
					yourself:
				)
		)
		(blackGuy2 init: setLoop: 0 addToPic:)
		(guard init: stopUpd:)
		(yellowGuy init: setLoop: 0 addToPic:)
		(blueGuy init: stopUpd:)
		(gene init: stopUpd:)
		(frank init: stopUpd:)
		(otto init: stopUpd:)
		(grayGuy2 init: stopUpd:)
		(self setRegions: 151) ; hotel
		(= global206 2)
		(rightDoor init: stopUpd:)
		(switch gPrevRoomNum
			(156
				(if global251
					(= global251 0)
					(= global108 1)
				)
				(egoChair init: hide:)
				(leftDoor init: setCel: 0)
				(gEgo
					init:
					view: 494
					setLoop: 0
					setPri: 7
					setCel: 255
					ignoreActors: 1
					posn: 124 127
					setCycle: 0
				)
				(localproc_0)
				(self setScript: sStandUp)
				(SetFlag 41)
				(gLongSong
					number: (hotel curMusic:)
					loop: -1
					flags: -1
					play: 50
				)
			)
			(else
				(ClearFlag 41)
				(ClearFlag 192)
				(gLongSong fade: 50 10 10 0)
				(barTender init: stopUpd:)
				(leftDoor init: setCel: 255)
				(NormalEgo)
				(gEgo
					view: global206
					init:
					ignoreActors: 1
					setLoop: 4
					setCycle: Walk
					posn: 87 97
					setPri: 4
				)
				(egoChair init: stopUpd:)
				(self setScript: sEnterFromStorageRoom)
			)
		)
		(super init:)
		(hotel curVol: 50)
		(brownThing init:)
		(theRoom init:)
		(burgRug init:)
		(tables init:)
		(smallPic init:)
		(bowlingPic init:)
	)

	(method (notify param1 &tmp [temp0 200])
		(if (== param1 22)
			(proc151_9)
		)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(if (and (not script) (not (gEgo mover:)) (not (User controls:)))
			(gMessager say: 8 0 2) ; "You're a quiet one, Mr. Banksten. What's the matter, are you speechless with awe, or just stupid?"
		else
			(roomTimer setReal: self 5)
		)
	)
)

(instance leftDoor of Prop
	(properties
		x 102
		y 90
		noun 13
		view 199
		cel 6
		priority 4
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (OneOf global209 3 2)
					(gCurRoom setScript: sExitToStorageRoom)
				else
					(gMessager say: 17 4) ; "Leaving now would not be cool. You'd be jeopardizing the operation."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rightDoor of Prop
	(properties
		x 185
		y 99
		noun 15
		view 199
		loop 2
		priority 3
		signal 26640
	)
)

(instance barTender of View
	(properties
		x 96
		y 84
		view 199
		loop 3
		cel 1
		priority 1
		signal 26640
	)
)

(instance guard of Actor
	(properties
		x 134
		y 97
		noun 12
		view 522
	)

	(method (init)
		(super init:)
		(if (== global213 1)
			(self view: 524 posn: 219 119 setLoop: 8 setCel: 5 setPri: 9)
		else
			(self posn: 134 97)
		)
	)
)

(instance grayGuy2 of Prop
	(properties
		x 194
		y 128
		noun 14
		view 492
		priority 10
		signal 24592
	)
)

(instance blackGuy2 of Prop
	(properties
		x 217
		y 148
		noun 14
		view 491
		cel 8
		priority 10
		signal 24592
	)
)

(instance yellowGuy of Prop
	(properties
		x 113
		y 150
		noun 14
		view 493
		cel 9
		priority 13
		signal 24592
	)
)

(instance blueGuy of Prop
	(properties
		x 62
		y 148
		noun 14
		view 495
		priority 11
		signal 24592
	)
)

(instance egoChair of View
	(properties
		x 124
		y 127
		view 494
		loop 3
		signal 24576
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(HandsOff)
				(gCurRoom setScript: sSitChair)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sGuard of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 6))
			)
			(1
				(if register
					(guard setCycle: Beg self)
					(= register 0)
				else
					(guard setCel: 0 setCycle: End self)
				)
			)
			(2
				(if (not (Random 0 2))
					(= register 1)
					(guard stopUpd:)
					(self init:)
				else
					(= seconds 2)
				)
			)
			(3
				(guard setCel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(guard setCel: 0 setLoop: 2 setCycle: End self)
			)
			(6
				(= ticks 10)
			)
			(7
				(guard setCel: 0 setLoop: 0 stopUpd:)
				(self init:)
			)
		)
	)
)

(instance sExitToStorageRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 100 109 self)
			)
			(1
				(gLongSong2 number: 900 loop: 1 play:)
				(leftDoor setCycle: End self)
			)
			(2
				(leftDoor setPri: 3)
				(gEgo setMotion: MoveTo 87 97 self)
			)
			(3
				(gCurRoom newRoom: 55)
			)
		)
	)
)

(instance bowlingPic of Feature
	(properties
		x 159
		y 60
		noun 2
		nsTop 46
		nsLeft 143
		nsBottom 74
		nsRight 175
		sightAngle 40
		onMeCheck 4
	)
)

(instance smallPic of Feature
	(properties
		x 116
		y 55
		noun 3
		nsTop 48
		nsLeft 111
		nsBottom 62
		nsRight 121
		sightAngle 40
		onMeCheck 4
	)
)

(instance tables of Feature
	(properties
		x 148
		y 227
		z 100
		noun 6
		nsTop 104
		nsLeft 64
		nsBottom 151
		nsRight 232
		sightAngle 40
		onMeCheck 2
	)
)

(instance burgRug of Feature
	(properties
		x 154
		y 17
		z 100
		noun 5
		nsTop 85
		nsLeft 61
		nsBottom 150
		nsRight 247
		sightAngle 40
		onMeCheck 4
	)
)

(instance theRoom of Feature
	(properties
		x 155
		y 1
		z 90
		noun 1
		nsTop 25
		nsLeft 60
		nsBottom 156
		nsRight 251
		sightAngle 40
	)
)

(instance brownThing of Feature
	(properties
		x 238
		y 77
		noun 16
		nsTop 66
		nsLeft 228
		nsBottom 89
		nsRight 248
		sightAngle 40
	)
)

(instance frank of Prop
	(properties
		x 152
		y 140
		noun 7
		view 490
		cel 3
		priority 9
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(= local1 theVerb)
		(switch theVerb
			(1 ; Look
				(if local0
					(gMessager say: 7 1 9) ; "It's Frank Magpie."
				else
					(gMessager say: 7 1 8) ; "He looks dangerous."
				)
			)
			(2 ; Talk
				(gCurRoom setScript: sTalkToFrank)
			)
			(4 ; Do
				(gMessager say: 7 4 0 0) ; "Probably not a good idea, Bonds."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance gene of Prop
	(properties
		x 122
		y 141
		noun 10
		view 488
		priority 10
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if local0
					(gMessager say: 10 1 9) ; "It's Gene "The Bambino" Bamboni."
				else
					(gMessager say: 10 1 8) ; "You wonder what he's hiding behind his rather stunned expression."
				)
			)
			(2 ; Talk
				(cond
					((IsFlag 41)
						(gMessager say: 9 2 7) ; "It's been a pleasure, Mr. Banksten."
					)
					(local0
						(gMessager say: 9 2 5) ; "Don't waste my time, Mr. Banksten."
					)
					(else
						(gMessager say: 9 2 10) ; "He doesn't answer. He just glares at you."
					)
				)
			)
			(4 ; Do
				(gMessager say: 10 4 0 0) ; "You don't even know him, Bonds."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance otto of Prop
	(properties
		x 140
		y 109
		noun 9
		view 489
		cel 10
		priority 8
		signal 26640
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(if local0
					(gMessager say: 9 1 9) ; "It's Otto Lipschitz."
				else
					(gMessager say: 9 1 8) ; "He looks pretty cranky."
				)
			)
			(2 ; Talk
				(cond
					((IsFlag 41)
						(gMessager say: 10 2 7) ; "See ya, Whitey."
					)
					(local0
						(gMessager say: 10 2 5) ; "Shut up and play, Whitey."
					)
					(else
						(gMessager say: 10 2 10) ; "He just grins at you, and doesn't answer."
					)
				)
			)
			(4 ; Do
				(gMessager say: 9 4 0 0) ; "What would you hope to accomplish, Bonds?"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sDolt of Script_
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(= seconds (Random 2 4))
			)
			(1
				(if (not (Random 0 3))
					(client setLoop: 0 setCel: 0 setCycle: End self)
				else
					(= state -1)
					(= cycles 2)
				)
			)
			(2
				(client setCel: 0 stopUpd:)
				(= seconds (Random 2 4))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance sTalkToFrank of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((not local2)
						(= local2 1)
						(Face gEgo frank)
						(-- state)
						(= ticks 20)
					)
					((IsFlag 41)
						(= local2 0)
						(gMessager say: 7 2 7 0 self) ; "Goodbye, Mr. Banksten."
					)
					(local0
						(= local2 0)
						(gMessager say: 7 2 4 0 self) ; "Do you want to play, or chat, Mr. Banksten?"
					)
					(else
						(= local2 0)
						(= local0 1)
						(gMessager say: 7 2 1 0 self) ; "Hello, Mr. Banksten. I'm glad you could join us. My name is Frank Magpie, and these are my regular poker partners. Allow me to introduce you. Jimmy Lee "Whitey" Banksten, this is Otto Lipschitz."
					)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance sSitChair of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 131 125 self
				)
			)
			(1
				(= ticks 20)
			)
			(2
				(if (not local0)
					(-- state)
					(self setScript: sTalkToFrank self)
				else
					(gEgo posn: 131 125 setLoop: 8 setCel: 4 setCycle: 0)
					(= ticks 20)
				)
			)
			(3
				(gEgo view: 494 setLoop: 0 setCel: 0 posn: 124 127)
				(egoChair hide:)
				(= ticks 20)
			)
			(4
				(gEgo cycleSpeed: 8 setCycle: End self)
			)
			(5
				(gEgo setLoop: 2 setPri: 9 setCel: 3)
				(= seconds 2)
			)
			(6
				(gLongSong fade: 0 10 10 0 self)
				(= seconds 3)
			)
			(7
				(gCurRoom setScript: sPlayPoker)
			)
			(8
				(gCurRoom setScript: sPlayPoker)
			)
		)
	)
)

(instance sStandUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 3)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(egoChair show:)
				(NormalEgo)
				(gEgo posn: 131 125)
				(= ticks 10)
			)
			(3
				(gEgo setLoop: 8 setCel: 4)
				(if (and (== gPrevRoomNum 156) (== global209 3))
					(SetScore 192 15)
				)
				(= ticks 10)
			)
			(4
				(switch global209
					(2
						(gMessager say: 8 0 3) ; "Ah, well, we can't all be card sharps, Mr. Banksten. Good evening."
					)
					(3
						(gMessager say: 8 0 6) ; "Well, well, Mr. Banksten. You are quite the poker player. My friends and I enjoy playing with a man of your skills. Perhaps you'd like to come back later and play again, in a more...private setting?"
						(ClearFlag 197)
						(ClearFlag 193)
						(= global213 1)
					)
				)
				(= cycles 2)
			)
			(5
				(gEgo setLoop: 8 setCel: 5)
				(= ticks 10)
			)
			(6
				(gEgo setCel: 1)
				(= ticks 10)
			)
			(7
				(NormalEgo)
				(gEgo
					setLoop: 7
					illegalBits: 0
					ignoreActors: 1
					setMotion: MoveTo 114 114 self
				)
			)
			(8
				(gEgo setLoop: 8 setCycle: 0 setCel: 7)
				(gLongSong2 number: 900 loop: 1 play:)
				(leftDoor setPri: 3 setCycle: End self)
			)
			(9
				(gEgo
					setLoop: 7
					setCycle: Fwd
					setPri: 4
					setMotion: MoveTo 80 95 self
				)
			)
			(10
				(gEgo hide:)
				(= cycles 3)
			)
			(11
				(if (== global209 2)
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 99)
					(= seconds 3)
				else
					(gCurRoom newRoom: 55)
				)
			)
			(12
				(gMessager say: 8 0 12 0 self) ; "Later that evening..."
			)
			(13
				(gCurRoom newRoom: 54)
			)
		)
	)
)

(instance sPlayPoker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(switch
					(Print
						addText: 18 0 13 1 0 0 56 ; "Do you wish to play poker?"
						addButton: 1 18 0 16 1 0 15 56 ; "Yes!"
						addButton: 2 18 0 15 1 0 30 56 ; "No, but win anyway."
						addButton: 3 18 0 14 1 0 45 56 ; "No, but lose anyway."
						init:
					)
					(1
						(= global251 0)
						(gCurRoom newRoom: 156)
					)
					(2
						(= global209 3)
						(SetFlag 41)
						(gCurRoom setScript: sStandUp)
					)
					(3
						(= global209 2)
						(SetFlag 41)
						(gCurRoom setScript: sStandUp)
					)
				)
			)
		)
	)
)

(instance sEnterFromStorageRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(gEgo
					view: global206
					ignoreActors: 1
					illegalBits: 0
					setLoop: 4
					setCycle: Fwd
					setMotion: MoveTo 100 109 self
				)
			)
			(2
				(gLongSong2 number: 900 loop: 1 play:)
				(leftDoor setCycle: Beg self)
				(NormalEgo)
				(gEgo setLoop: 2 setMotion: MoveTo 99 119 self)
			)
			(3
				(gLongSong2 number: 901 loop: 1 play:)
			)
			(4
				(localproc_0)
				(leftDoor stopUpd:)
				(barTender dispose:)
				(if (== global213 1)
					(= ticks 10)
				else
					(NormalEgo)
					(gEgo loop: 2)
					(roomTimer setReal: gCurRoom 5)
					(HandsOn)
					(self dispose:)
				)
			)
			(5
				(rightDoor setCycle: End)
				(gEgo
					setCycle: Walk
					setLoop: 0
					setPri: 5
					setMotion: MoveTo 187 111 self
				)
			)
			(6
				(gEgo setCycle: 0 setLoop: 8 setCel: 0)
				(= ticks 10)
			)
			(7
				(gEgo setLoop: 8 setCel: 6)
				(= ticks 10)
			)
			(8
				(gCurRoom newRoom: 57)
			)
		)
	)
)

