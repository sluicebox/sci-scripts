;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 52)
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
	rm52 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
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

(instance rm52 of PQRoom
	(properties
		picture 52
	)

	(method (init)
		(if
			(and
				(== gPrevRoomNum 1)
				(Print
					addText: {Test 1st Poker game?}
					addButton: 0 {No} 0 12
					addButton: 1 {Yes} 0 26
					init:
				)
			)
			(SetFlag 50)
			(= global209 1)
		)
		(if
			(and
				(== gPrevRoomNum 1)
				(Print
					addText: {Test 2nd Poker game?}
					addButton: 0 {No} 0 12
					addButton: 1 {Yes} 0 26
					init:
				)
			)
			(SetFlag 50)
			(= global209 3)
			(= global213 1)
		)
		(= global224 {Last update:\nSaturday, July 18, 1992})
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 180 88 180 96 165 107 147 107 156 113 111 141 93 141 93 143 104 143 50 189 111 189 147 153 177 129 194 129 194 119 215 97 243 97 243 80 173 68 157 68 139 75 141 81
					yourself:
				)
		)
		(self setRegions: 151) ; hotel
		(super init:)
		(switch gPrevRoomNum
			(55
				(gEgo
					view: global206
					init:
					posn: 156 75
					loop: 4
					setHeading: 100
				)
				(HandsOn)
				(NormalEgo)
				(gEgo illegalBits: $8000)
			)
			(51
				(self setScript: sEnterFromLobby)
			)
			(else
				(gLongSong number: (hotel curMusic:) loop: -1 flags: -1 play:)
				(self setScript: sEnterFromLobby)
			)
		)
		(manOnStool init:)
		(blackGuy2 init:)
		(if (and (not (IsFlag 50)) (IsFlag 25))
			(= local2 1)
			((ScriptID 151 4) ; marie
				init:
				view: 441
				setLoop: 0
				setCel: 0
				posn: 74 151
				approachX: 102
				approachY: 149
				noun: 11
				setPri: 11
				maxLoop: 3
				approachVerbs: 2 ; Talk
				actions: marieActions
				status: 1
			)
			(marieBottle init: stopUpd:)
		)
		(grayGirl init:)
		(waitress init: status: 2 setScript: sWaitressLeaves)
		(bains init: setScript: sBains)
		(backDoor init: stopUpd: approachVerbs: 4 1) ; Do, Look
		(alex init: posn: 123 106)
		(hotel curVol: 127)
		(theRoom init:)
		(chairs init: approachVerbs: 4 1) ; Do, Look
		(bar init:)
		(barCover init: approachVerbs: 4 1) ; Do, Look
		(barStools init: approachVerbs: 4 1) ; Do, Look
		(tables init: approachVerbs: 4 1) ; Do, Look
		(plant init: approachVerbs: 4 1) ; Do, Look
		(panels init: approachVerbs: 4 1) ; Do, Look
		(carpet init:)
		(waitressBottle init: stopUpd:)
		(blackGuyBottle init: setPri: 7 stopUpd:)
		(room2 init:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((& (gEgo onControl: 1) $0002)
				(self setScript: sExitToLobby)
			)
		)
	)

	(method (notify param1 &tmp [temp0 200])
		(if (== param1 22)
			(Printf
				@temp0
				{marie status %d\nwaitress status %d\nalex status %d\nmarieTalkCount %d\n}
				((ScriptID 151 4) status:) ; marie
				(waitress status:)
				(alex status:)
				global219
			)
			(proc151_9)
		)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance marieActions of Actions
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1 1) ; "It's Marie. She seems to be doing a good job fitting in with the people here."
			)
			(2 ; Talk
				(gCurRoom setScript: sMarie)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sExitToLobby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setPri: 13 setLoop: 5 ignoreActors: 1)
				(if register
					(gEgo
						setMotion:
							MoveTo
							(- (gEgo x:) 40)
							(+ (gEgo y:) 50)
							self
					)
				else
					(gEgo
						setMotion:
							MoveTo
							(- (gEgo x:) 30)
							(+ (gEgo y:) 30)
							self
					)
				)
			)
			(1
				(if (hotel playMusic:)
					(gLongSong fade: 100 15 5 0)
				)
				(gEgo hide:)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 51)
			)
		)
	)
)

(instance backDoor of Prop
	(properties
		x 133
		y 169
		z 100
		approachX 149
		approachY 72
		view 486
		priority 2
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 15 4 27) ; "Hey! Where do you think you're going, buddy, get away from there!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance manOnStool of Fool
	(properties
		x 128
		y 120
		noun 18
		view 443
		loop 2
		signal 26624
		cycleSpeed 8
	)
)

(instance blackGuy2 of Fool
	(properties
		x 172
		y 153
		noun 18
		view 443
		priority 15
		signal 24592
		cycleSpeed 8
		maxLoop 1
	)
)

(instance grayGirl of Fool
	(properties
		x 205
		y 152
		noun 18
		view 444
		cel 10
		priority 15
		signal 24592
		maxLoop 1
	)
)

(instance bains of Fool
	(properties
		x 232
		y 126
		noun 18
		view 442
		signal 24576
		maxLoop 3
	)
)

(instance waitress of Fool
	(properties
		x 152
		y 112
		noun 17
		view 445
		loop 8
		cel 1
		signal 10240
	)
)

(instance sBains of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 20 40))
			)
			(1
				(if
					(and
						(> (gEgo y:) 151)
						(== (bains cel:) 0)
						(== (waitress status:) 6)
					)
					(bains status: 4)
					(Load rsVIEW 487)
				else
					(-- state)
				)
				(= cycles 2)
			)
			(2
				(bains setLoop: 4 setCycle: End self)
			)
			(3
				(bains
					view: 487
					posn: 232 120
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 150 72 self
				)
			)
			(4
				(gLongSong2 number: 913 loop: 1 play:)
				(backDoor setCycle: End self)
			)
			(5
				(backDoor stopUpd:)
				(bains setMotion: MoveTo 115 71 self)
			)
			(6
				(bains status: 6 stopUpd:)
				(backDoor setCycle: Beg self)
			)
			(7
				(backDoor stopUpd:)
				(gLongSong2 number: 914 loop: 1 play:)
				(waitress setScript: sBringInWaitress status: 5)
				(self dispose:)
			)
		)
	)
)

(instance panels of Feature
	(properties
		x 215
		y 51
		noun 12
		nsTop 29
		nsLeft 175
		nsBottom 74
		nsRight 256
		sightAngle 40
		onMeCheck 8
	)
)

(instance plant of Feature
	(properties
		x 161
		y 48
		noun 13
		nsTop 31
		nsLeft 150
		nsBottom 65
		nsRight 173
		sightAngle 40
		onMeCheck 4
		approachX 164
		approachY 68
	)
)

(instance tables of Feature
	(properties
		x 208
		y 125
		noun 16
		nsTop 91
		nsLeft 158
		nsBottom 159
		nsRight 258
		sightAngle 40
		onMeCheck 4
		approachX 191
		approachY 129
	)
)

(instance barStools of Feature
	(properties
		x 105
		y 123
		noun 4
		nsTop 95
		nsLeft 66
		nsBottom 151
		nsRight 145
		sightAngle 40
		onMeCheck 8
		approachX 116
		approachY 140
	)
)

(instance barCover of Feature
	(properties
		x 110
		y 99
		noun 2
		nsTop 66
		nsLeft 63
		nsBottom 132
		nsRight 157
		sightAngle 40
		onMeCheck 4
		approachX 116
		approachY 140
	)
)

(instance bar of Feature
	(properties
		x 113
		y 92
		noun 5
		nsTop 32
		nsLeft 64
		nsBottom 153
		nsRight 163
		sightAngle 40
	)
)

(instance chairs of Feature
	(properties
		x 207
		y 124
		noun 8
		nsTop 89
		nsLeft 156
		nsBottom 160
		nsRight 258
		sightAngle 40
		onMeCheck 8
		approachX 193
		approachY 121
	)
)

(instance carpet of Feature
	(properties
		x 159
		y 109
		noun 7
		nsTop 63
		nsLeft 64
		nsBottom 156
		nsRight 255
		sightAngle 40
		onMeCheck 16
	)
)

(instance theRoom of Feature
	(properties
		x 159
		y 1
		noun 14
		nsTop 30
		nsLeft 63
		nsBottom 156
		nsRight 255
		sightAngle 40
	)
)

(instance sBringInWaitress of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 3 9))
			)
			(1
				(if (and (< (gEgo y:) 84) (< (gEgo x:) 184))
					(-- state)
					(= cycles 5)
				else
					(gLongSong2 number: 913 loop: 1 play:)
					(backDoor setCycle: End self)
				)
			)
			(2
				(backDoor stopUpd:)
				(waitress setMotion: MoveTo 151 74 self)
			)
			(3
				(waitress setPri: -1)
				(backDoor setCycle: Beg self)
			)
			(4
				(backDoor stopUpd:)
				(gLongSong2 number: 914 loop: 1 play:)
				(waitress setMotion: MoveTo 173 85 self)
			)
			(5
				(waitress setMotion: MoveTo 181 112 self)
			)
			(6
				(waitress setMotion: MoveTo 152 112 self)
			)
			(7
				(waitress
					setLoop: 8
					setCel: 7
					status: 2
					setScript: sWaitressLeaves
				)
				(self dispose:)
			)
		)
	)
)

(instance sWaitressLeaves of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(waitress setCel: 3 status: 5)
				(= ticks 5)
			)
			(2
				(waitress setCel: 6)
				(= ticks 5)
			)
			(3
				(waitress setCel: 0)
				(= ticks 5)
			)
			(4
				(waitress
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 181 112 self
				)
			)
			(5
				(waitress setMotion: MoveTo 171 83 self)
			)
			(6
				(if (and (< (gEgo y:) 87) (< (gEgo x:) 165))
					(waitress setLoop: 8 setCel: 1)
					(-- state)
					(= cycles 5)
				else
					(waitress
						setLoop: -1
						setCycle: Walk
						setMotion: MoveTo 151 74 self
					)
				)
			)
			(7
				(gLongSong2 number: 913 loop: 1 play:)
				(backDoor ignoreActors: 1 setCycle: End self)
			)
			(8
				(backDoor stopUpd:)
				(waitress setPri: 1 setMotion: MoveTo 122 67 self)
			)
			(9
				(backDoor setCycle: Beg self)
			)
			(10
				(gLongSong2 number: 914 loop: 1 play:)
				(= seconds (Random 3 6))
			)
			(11
				(if (and (!= global213 1) (!= global209 1))
					(waitress setScript: sBringInWaitress status: 5)
				)
				(self dispose:)
			)
		)
	)
)

(instance waitressBottle of View
	(properties
		x 139
		y 88
		view 449
		loop 7
		priority 6
		signal 26640
	)
)

(instance blackGuyBottle of View
	(properties
		x 128
		y 94
		view 449
		loop 7
		cel 1
		priority 6
		signal 26645
	)
)

(instance marieBottle of View
	(properties
		x 89
		y 114
		view 449
		loop 7
		cel 2
		priority 7
		signal 26640
	)
)

(instance sExchangeMoney of Script
	(properties)

	(method (changeState newState &tmp [temp0 75])
		(switch (= state newState)
			(0
				(if register
					(++ state)
					(alex setLoop: 2 setCel: 0 setPri: 6 setCycle: CT 2 1 self)
					(gEgo view: 448 setLoop: 0 setCel: 7 setPri: 8)
				else
					(gEgo
						view: 448
						setLoop: 0
						setCel: 0
						setCycle: CT 7 1 self
						setPri: 8
					)
				)
			)
			(1
				(alex setLoop: 2 setCel: 0 setPri: 6 setCycle: CT 2 1 self)
			)
			(2
				(= seconds 2)
			)
			(3
				(if register
					(alex setCycle: Beg self)
					(gEgo setCycle: Beg self)
				else
					(alex setCycle: End self)
					(gEgo setCycle: End self)
				)
			)
			(4)
			(5
				(if register
					(alex setCel: 0 setLoop: 0 setCycle: 0)
				)
				(NormalEgo)
				(gEgo loop: 7 illegalBits: $8000)
				(= cycles 2)
			)
			(6
				(self dispose:)
			)
		)
	)
)

(instance room2 of Feature
	(properties
		x 32
		y 394
		z 200
		noun 14
		nsBottom 189
		nsRight 65
	)
)

(instance sTalkToMarie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 151 4) status: 8) ; marie
				(= seconds 2)
			)
			(1
				(gEgo setPri: 10 setLoop: 8 setCel: 1)
				(= ticks 20)
			)
			(2
				(if (!= ((ScriptID 151 4) cel:) 0) ; marie
					(-- state)
					((ScriptID 151 4) setCycle: Beg self) ; marie
				else
					(= cycles 2)
				)
			)
			(3
				((ScriptID 151 4) setLoop: 2 setCel: 0 startUpd:) ; marie
				(= ticks 10)
			)
			(4
				((ScriptID 151 4) setCycle: End self) ; marie
			)
			(5
				(switch global219
					(0
						(= global219 1)
						(gMessager say: 15 0 26 0 self) ; "Whitey! Hey, Whitey! Come on over here, you sexy thang! Don't be shy, you know I can't resist you!"
						((ScriptID 151 4) setCycle: Beg) ; marie
					)
					(1
						(= global219 2)
						(gMessager say: 11 2 16 0 self) ; "So, Marie, what's going on? Have you seen anything unusual?"
					)
					(else
						(= cycles 2)
					)
				)
			)
			(6
				(= ticks 30)
			)
			(7
				(if (!= (alex status:) 8)
					(HandsOn)
					(NormalEgo)
					(gEgo illegalBits: $8000)
					((ScriptID 151 4) status: 1) ; marie
					(self dispose:)
				else
					(alex
						setLoop: 6
						setCycle: Fwd
						setMotion: MoveTo 73 132 self
					)
				)
			)
			(8
				(alex setLoop: 0 setCel: 0 setPri: 6 setCycle: 0)
				(= seconds 2)
			)
			(9
				(gEgo setCel: 7)
				(gMessager say: 1 2 13 0 self) ; "Here's your change, sir."
			)
			(10
				(self setScript: sExchangeMoney self 1)
			)
			(11
				(if (== global219 2)
					(SetFlag 31)
					(gMessager say: 15 0 22 0 self) ; "You take your change, and give Alex a $20.00 tip."
				else
					(gMessager say: 1 2 12 0) ; "Thanks."
					(alex status: 5 setScript: sBarTender)
					((ScriptID 151 4) setCycle: Beg) ; marie
					(NormalEgo)
					(gEgo illegalBits: $8000)
					(HandsOn)
					(self dispose:)
				)
			)
			(12
				(if (== ((ScriptID 151 4) cel:) 0) ; marie
					(= cycles 2)
				else
					((ScriptID 151 4) setCycle: Beg self) ; marie
				)
			)
			(13
				(SetFlag 26)
				(gMessager say: 15 0 23 0 self) ; "Oh, I've been so rude! Alex, this is Jimmy Lee Banksten, known as Whitey to his good friends. I've known this cutie-pie for going on eight years now. But it's been... what, a whole year since the last time we got together? How I missed you, honey! Anyway, Whitey, this is my girlfriend Alex."
			)
			(14
				((ScriptID 151 4) setLoop: 4 setCel: 0 setCycle: End self) ; marie
			)
			(15
				((ScriptID 151 4) ; marie
					view: 435
					setCycle: Walk
					posn: 70 152
					setLoop: 5
					setMotion: MoveTo 45 187 self
				)
				(gEgo view: global206 setCel: 1 setLoop: 8)
			)
			(16
				(if (not (IsFlag 30))
					(SetFlag 30)
					(gMessager say: 1 2 7 0 self) ; "Marie's very special to me. We go way back."
				else
					(= cycles 2)
				)
			)
			(17
				((ScriptID 151 4) ; marie
					setLoop: 6
					setCycle: Walk
					setMotion: MoveTo 70 152 self
				)
			)
			(18
				((ScriptID 151 4) setLoop: 8 setCel: 6) ; marie
				(= ticks 10)
			)
			(19
				((ScriptID 151 4) setCel: 0) ; marie
				(gEgo view: global206 setCel: 1 setLoop: 8)
				(= ticks 10)
			)
			(20
				(gMessager say: 11 2 17 0 self) ; "All refreshed, my dear? Are you ready for adventure?"
			)
			(21
				(alex status: 5 setScript: sBarTender 0 1)
				((ScriptID 151 4) setCel: 4) ; marie
				(= ticks 10)
			)
			(22
				((ScriptID 151 4) setCel: 2) ; marie
				(= ticks 10)
			)
			(23
				((ScriptID 151 4) ; marie
					setCycle: Walk
					setLoop: 5
					setMotion: MoveTo 45 187 self
				)
			)
			(24
				(= seconds 2)
			)
			(25
				(gEgo setLoop: 8 setCel: 5)
			)
			(26
				(alex setLoop: 0 setCel: 0 setPri: 6 setCycle: 0)
				(= ticks 10)
			)
			(27
				(gEgo setCel: 7)
				(SetScore 196 2)
				(= ticks 10)
			)
			(28
				(gMessager say: 1 2 8 0 self) ; "Hey, Whitey, come on over here for a second."
			)
			(29
				(= global209 1)
				(SetFlag 27)
				(gCurRoom setScript: sExitToLobby 0 1)
				(self dispose:)
			)
		)
	)
)

(instance sMarie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(if (== global219 1)
					(gCurRoom setScript: sTalkToMarie)
				else
					(gMessager say: 11 1 1 0 self) ; "It's Marie. She seems to be doing a good job fitting in with the people here."
				)
			)
			(2
				(HandsOn)
				(NormalEgo)
				(gEgo illegalBits: $8000)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromLobby of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					init:
					view: global206
					posn: 87 205
					setLoop: 6
					setPri: 13
					setMotion: MoveTo 135 148 self
				)
			)
			(1
				(NormalEgo)
				(gEgo illegalBits: $8000)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sServeDrink of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(alex setLoop: 0 setCel: 0 setMotion: 0 setCycle: 0 setPri: 6)
				(= cycles 2)
			)
			(1
				(alex setCycle: CT 2 1 self)
			)
			(2
				(switch register
					(0
						(waitressBottle hide:)
					)
					(1
						(blackGuyBottle hide:)
					)
					(2
						(marieBottle hide:)
					)
				)
				(alex setCycle: CT 5 1 self)
			)
			(3
				(= ticks (Random 10 20))
			)
			(4
				(alex setCel: 6)
				(= ticks 10)
			)
			(5
				(alex setCycle: CT 2 -1 self)
			)
			(6
				(switch register
					(0
						(waitressBottle show:)
					)
					(1
						(blackGuyBottle show:)
					)
					(2
						(marieBottle show:)
					)
				)
				(alex setCel: 1)
				(= ticks 10)
			)
			(7
				(alex setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToBartender of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(if (and (!= (gEgo x:) 102) (!= (gEgo y:) 149))
					(-- state)
				)
				(= ticks 20)
			)
			(1
				(alex setLoop: 0 setCel: 0 setPri: 6 setCycle: 0 setMotion: 0)
				(= seconds 2)
			)
			(2
				(switch global206
					(0
						(gMessager say: 1 2 14 0 self) ; "Hello, Officer."
					)
					(1
						(gMessager say: 1 2 11 0 self) ; "Hello, sir."
					)
					(2
						(if (not (IsFlag 26))
							(gMessager say: 1 2 11 0 self) ; "Hello, sir."
						else
							(gMessager say: 1 2 9 0 self) ; "Hey, there, Whitey."
						)
					)
				)
			)
			(3
				(cond
					((!= global206 2)
						(gCast eachElementDo: #hide)
						(gCurRoom drawPic: 99 7)
						(Wait 20)
						(gLongSong fade:)
						(gMessager say: 1 2 28 0 self) ; "As you're slugging your rum-and-coke down, Sgt. Dooley comes in to meet his visiting Aunt Emily, who's staying at the hotel. He sees you quaffing the booze. The bad news is, you're off this investigation. The good news is, you have a one-month, no-salary vacation. Use your head next time, Bonds!"
					)
					((not local3)
						(alex setLoop: 4 setCel: 0 setPri: 6 setCycle: End self)
					)
					(else
						(+= state 2)
						(self setScript: sServeDrink self 2)
					)
				)
			)
			(4
				(if (!= global206 2)
					(EgoDead)
				else
					(alex setLoop: 0 setCel: 255 setCycle: CT 2 -1 self)
				)
			)
			(5
				(marieBottle init: stopUpd:)
				(= local3 1)
				(alex setCycle: Beg self)
			)
			(6
				(if (not (IsFlag 26))
					(gMessager say: 1 2 12 0 self) ; "Thanks."
				else
					(gMessager say: 1 43 4 0 self) ; "Here ya go, Angel."
				)
			)
			(7
				(self setScript: sExchangeMoney self)
			)
			(8
				(switch global219
					(0
						(= cycles 2)
					)
					(1
						(gMessager say: 1 43 5 0 self) ; "A hundred dollar bill! Well, you must be doing okay for yourself, mister. Hold on, I have to go get change for that."
					)
					(2
						(gMessager say: 1 43 5 0 self) ; "A hundred dollar bill! Well, you must be doing okay for yourself, mister. Hold on, I have to go get change for that."
					)
					(else
						(HandsOn)
						(alex status: 5 setScript: sBarTender)
						(self dispose:)
					)
				)
			)
			(9
				(alex setPri: 4 setLoop: 5)
				(if local2
					(gCurRoom setScript: sTalkToMarie)
					(alex setCycle: Fwd setMotion: MoveTo 55 143)
					(self dispose:)
				else
					(alex setCycle: Fwd setMotion: MoveTo 55 143 self)
				)
			)
			(10
				(= seconds 3)
			)
			(11
				(alex
					setCycle: Fwd
					setLoop: 6
					setPri: 4
					setMotion: MoveTo 73 132 self
				)
			)
			(12
				(self setScript: sExchangeMoney self 1)
			)
			(13
				(gMessager say: 1 2 13 0 self) ; "Here's your change, sir."
			)
			(14
				(alex status: 5 setScript: sBarTender)
				(HandsOn)
				(NormalEgo)
				(gEgo illegalBits: $8000)
				(= local5 0)
				(self dispose:)
			)
		)
	)
)

(instance sBarTender of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(if (!= (alex x:) 123)
					(-- state)
					(alex
						setLoop: 6
						setPri: 4
						setCycle: Fwd
						setMotion: MoveTo 123 106 self
					)
				else
					(self setScript: sServeDrink self 0)
				)
			)
			(1
				(if (== (waitress status:) 2)
					(sWaitressLeaves cue:)
				)
				(if (== (alex status:) 8)
					(self changeState: 7)
				else
					(= seconds 2)
				)
			)
			(2
				(alex setLoop: 5 setPri: 4 setCycle: Fwd)
				(if register
					(++ state)
					(alex setMotion: MoveTo 73 132 self)
				else
					(alex setMotion: MoveTo 112 112 self)
				)
			)
			(3
				(self setScript: sServeDrink self 1)
			)
			(4
				(cond
					((== (alex status:) 8)
						(self changeState: 7)
					)
					((== (waitress status:) 2)
						(self init:)
					)
					((or register (== ((ScriptID 151 4) status:) 1)) ; marie
						(alex
							setLoop: 5
							setPri: 4
							setCycle: Fwd
							setMotion: MoveTo 73 132 self
						)
					)
					(else
						(self changeState: 6)
					)
				)
			)
			(5
				(cond
					((not local2)
						(= cycles 2)
					)
					((not register)
						(self setScript: sServeDrink self 2)
					)
					((== (sTalkToMarie state:) 25)
						(sTalkToMarie cue:)
					)
					(else
						(-- state)
						(= cycles 2)
					)
				)
			)
			(6
				(alex
					setPri: 4
					setLoop: 5
					setCycle: Fwd
					setMotion: MoveTo 55 143 self
				)
			)
			(7
				(= seconds (Random 2 5))
			)
			(8
				(alex setLoop: 6 setPri: 4 setCycle: Fwd ignoreActors: 1)
				(cond
					((== (alex status:) 8)
						(++ state)
						(if (> (alex x:) 73)
							(alex setLoop: 5 setMotion: MoveTo 73 132 self)
						else
							(alex setMotion: MoveTo 73 132 self)
						)
					)
					((== (waitress status:) 2)
						(alex setMotion: MoveTo 123 106 self)
					)
					(else
						(= state 2)
						(alex setMotion: MoveTo 112 112 self)
					)
				)
			)
			(9
				(self init:)
			)
			(10
				(alex setLoop: 0 setCel: 0 setMotion: 0 setCycle: 0 setPri: 6)
				(if (and (!= (alex x:) 73) (!= (alex y:) 132))
					(= state 6)
					(alex setLoop: 3 setCycle: End self)
				else
					(= ticks 10)
				)
			)
			(11
				(self dispose:)
				(cond
					(local6
						(gCurRoom setScript: sPayAlex)
					)
					((or (== global209 1) (== global213 1))
						(gCurRoom setScript: sAskAboutBackRoom)
					)
					(else
						(gCurRoom setScript: sTalkToBartender)
					)
				)
			)
		)
	)
)

(instance sAskAboutBackRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(alex setCycle: 0 setLoop: 0 setCel: 0)
				(= seconds 3)
			)
			(1
				(if (== global213 1)
					(= register 1)
					(gMessager say: 1 0 33 0 self) ; "Hey, Baby. Frank sent me."
				else
					(gMessager say: 1 2 10 0 self) ; "Hey there, Whitey, what can I do for you?"
				)
			)
			(2
				(HandsOn)
				(NormalEgo)
				(gEgo illegalBits: $8000)
				(= local5 0)
				(if (not register)
					(alex status: 5 setScript: sBarTender)
					(self dispose:)
				else
					(gCurRoom setScript: sPayAlex 0 1)
				)
			)
		)
	)
)

(instance sEnterBackRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(NormalEgo)
				(gEgo illegalBits: $8000 setMotion: PolyPath 189 92 self)
			)
			(1
				(gEgo setLoop: 8 setCel: 3)
				(= ticks 10)
			)
			(2
				(gEgo setCel: 7)
				(= ticks 10)
			)
			(3
				(sPayAlex cue:)
			)
		)
	)
)

(instance sPayAlex of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not register)
					(gEgo setPri: 5)
					(self setScript: sExchangeMoney self)
				else
					(+= state 2)
					(= cycles 2)
				)
			)
			(1
				(gEgo setPri: -1)
				(= cycles 2)
			)
			(2
				(gMessager say: 1 43 2 0 self) ; "You slip Alex two hundred dollars. She deftly pockets it."
			)
			(3
				(alex
					setLoop: 6
					setCycle: Fwd
					setPri: 3
					setMotion: MoveTo 146 98 self
				)
			)
			(4
				(alex
					posn: (- (alex x:) 5) (alex y:)
					setLoop: 8
					setCycle: 0
					setCel: 6
				)
				(gEgo setScript: sEnterBackRoom)
				(= ticks 20)
			)
			(5
				(alex setCel: 3)
			)
			(6
				(gCurRoom newRoom: 55)
			)
		)
	)
)

(instance alex of Fool
	(properties
		x 123
		y 106
		noun 1
		view 449
		priority 4
		signal 26640
	)

	(method (init)
		(super init: &rest)
		(alex setScript: sBarTender status: 5)
	)

	(method (cue)
		(super cue:)
		(self doVerb: 2)
	)

	(method (doVerb theVerb invItem)
		(if (OneOf theVerb 2 43 17) ; Talk, ???, Undercover_money
			(if (and local1 (or (== theVerb 17) (== theVerb 43))) ; Undercover_money, ???
				(= local6 1)
			)
			(if (and (not local0) (> (++ local5) 2))
				(switch (Random 1 4)
					(1
						(gMessager say: 1 0 30) ; "I'll be with you in a moment."
					)
					(2
						(gMessager say: 1 0 29) ; "Just a minute, please!"
					)
					(3
						(gMessager say: 1 0 31) ; "Hold your horses, hotshot!"
					)
					(4
						(gMessager say: 1 0 32) ; "Don't rush me!"
					)
				)
			)
			(cond
				((== local0 1)
					(= local0 2)
					(gEgo setMotion: MoveTo 199 74 self)
				)
				((gEgo inRect: 129 68 166 86)
					(HandsOff)
					(= local0 1)
					(gEgo setMotion: MoveTo 173 68 self)
				)
				(
					(and
						(< (gEgo y:) (waitress y:))
						(waitress inRect: 153 82 193 122)
					)
					(HandsOff)
					(gEgo setMotion: PolyPath 211 106 self)
				)
				((!= (gEgo x:) 102)
					(!= (gEgo y:) 149)
					(HandsOff)
					(= status 8)
					(gEgo setMotion: PolyPath 102 149 self)
				)
				(else
					(gEgo loop: 7)
					(= local0 0)
					(= status 8)
					(= local5 2)
				)
			)
		else
			(super doVerb: theVerb invItem &rest)
		)
	)
)

