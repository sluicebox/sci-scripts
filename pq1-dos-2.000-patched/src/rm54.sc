;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 54)
(include sci.sh)
(use Main)
(use hotel)
(use eRS)
(use Print)
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
	rm54 0
	Chip 1
	Joe_Taber 2
	doorT 3
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

(instance rm54 of PQRoom
	(properties
		picture 54
	)

	(method (init &tmp [temp0 20])
		(= global224 {Last update\nThurs 6-25-92})
		(= global206 2)
		(= global207 104)
		(= global205 2)
		(if (== gPrevRoomNum 1)
			(= global209
				(Print
					addText: {pokerStatus}
					addButton: 0 {NOT PLAYED} 0 12
					addButton: 1 {INVITED} 0 26
					addButton: 2 {LOST} 0 40
					addButton: 3 {WON} 0 54
					init:
				)
			)
			(if
				(Print
					addText: {Test Marie?}
					addButton: 0 {No} 0 12
					addButton: 1 {Yes} 0 26
					init:
				)
				(SetFlag 27)
			)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 62 129 62 148 98 189 180 189 243 189 243 139 188 102 183 103 219 132 160 149 142 149 109 124 78 135 68 127
					yourself:
				)
		)
		(self setRegions: 151) ; hotel
		(if (IsFlag 27)
			(gLongSong number: 540 loop: -1 play: 0)
		)
		(super init:)
		(phone init:)
		(painting init:)
		(rug init:)
		(pinkCurtain init:)
		(pillows init:)
		(lamp init:)
		(curtain init:)
		(bed init:)
		(bedBoard init:)
		(theRoom init:)
		(carpet1 init:)
		(carpet2 init:)
		(bedBoard2 init:)
		(nightStandLeft init:)
		(nightStandRight init:)
		(drawer init:)
		(ClearFlag 65)
		(self setScript: sEnterRoom)
	)

	(method (notify param1 &tmp [temp0 200])
		(if (== param1 22)
			(proc151_9)
		else
			(= local2 param1)
			(sUsePhone cue:)
		)
	)

	(method (cue)
		(cond
			((== local1 25)
				(gEgo posn: (gEgo x:) (- (gEgo y:) 2))
				(HandsOn)
				(= local1 0)
			)
			((== local1 26)
				(gEgo posn: (gEgo x:) (- (gEgo y:) 2))
				(HandsOn)
				(= local1 0)
			)
			((and local7 local6)
				(roomTimer setReal: self 5)
			)
			(else
				(= local7 0)
				(gCurRoom setScript: sGetPen)
			)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((and (not local1) (IsFlag 44) (& (gEgo onControl: 1) $0200))
				(= local1 25)
				(HandsOff)
				(gMessager say: 20 0 25 0 self) ; "Don't leave now."
			)
			((and (not local1) local7 (& (gEgo onControl: 1) $0200))
				(= local1 26)
				(HandsOff)
				(gMessager say: 20 0 26 0 self) ; "Don't leave now! Your backup's on the way!"
			)
			(
				(and
					(& (gEgo onControl: 1) $0002)
					(or (> (gEgo y:) 155) (> (gEgo x:) 160))
				)
				(gEgo setPri: 12)
				(self setScript: sExitRoom)
			)
		)
		(if (and (not local0) (& (gEgo onControl: 1) $0004))
			(= local0 1)
			(gEgo setPri: 2)
		)
		(if (and local0 (& (gEgo onControl: 1) $0010))
			(= local0 0)
			(gEgo setPri: -1)
		)
	)

	(method (newRoom newRoomNumber)
		(roomTimer dispose: delete:)
		(DisposeScript 555)
		(super newRoom: newRoomNumber)
	)
)

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setMotion:
						MoveTo
						(+ (gEgo x:) 20)
						(+ (gEgo y:) 50)
						self
				)
				(gLongSong fade:)
			)
			(1
				(gCurRoom newRoom: 53)
			)
		)
	)
)

(instance nightStandLeft of Feature
	(properties
		x 87
		y 211
		z 100
		noun 13
		nsTop 99
		nsLeft 69
		nsBottom 124
		nsRight 105
		sightAngle 40
		onMeCheck 8
	)
)

(instance drawer of Feature
	(properties
		x 91
		y 213
		z 100
		noun 7
		nsTop 108
		nsLeft 81
		nsBottom 119
		nsRight 102
		onMeCheck 32
	)
)

(instance nightStandRight of Feature
	(properties
		x 168
		y 191
		z 100
		noun 12
		nsTop 84
		nsLeft 155
		nsBottom 98
		nsRight 182
		sightAngle 40
		onMeCheck 8
	)
)

(instance phone of Feature
	(properties
		x 169
		y 87
		noun 15
		nsTop 81
		nsLeft 156
		nsBottom 94
		nsRight 182
		sightAngle 40
		onMeCheck 128
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sUsePhone)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance bedBoard of Feature
	(properties
		x 124
		y 86
		noun 2
		nsTop 78
		nsLeft 100
		nsBottom 94
		nsRight 149
		sightAngle 40
		onMeCheck 16384
	)
)

(instance bed of Feature
	(properties
		x 154
		y 111
		noun 3
		nsTop 83
		nsLeft 100
		nsBottom 139
		nsRight 209
		sightAngle 40
		onMeCheck 64
	)
)

(instance carpet of Feature ; UNUSED
	(properties
		x 157
		y 119
		noun 4
		nsTop 84
		nsLeft 52
		nsBottom 155
		nsRight 262
		sightAngle 40
		onMeCheck 16
	)
)

(instance curtain of Feature
	(properties
		x 221
		y 77
		noun 9
		nsTop 27
		nsLeft 194
		nsBottom 128
		nsRight 249
		sightAngle 40
		onMeCheck 32
	)
)

(instance lamp of Feature
	(properties
		x 84
		y 97
		noun 10
		nsTop 89
		nsLeft 76
		nsBottom 105
		nsRight 93
		sightAngle 40
		onMeCheck 16
	)
)

(instance pillows of Feature
	(properties
		x 131
		y 92
		noun 16
		nsTop 88
		nsLeft 108
		nsBottom 96
		nsRight 154
		sightAngle 40
		onMeCheck 32
	)
)

(instance pinkCurtain of Feature
	(properties
		x 218
		y 58
		noun 17
		nsTop 27
		nsLeft 204
		nsBottom 90
		nsRight 233
		sightAngle 40
		onMeCheck 16
	)
)

(instance rug of Feature
	(properties
		x 116
		y 133
		noun 19
		nsTop 116
		nsLeft 87
		nsBottom 151
		nsRight 146
		sightAngle 40
		onMeCheck 2
	)
)

(instance painting of Feature
	(properties
		x 127
		y 46
		noun 14
		nsTop 23
		nsLeft 79
		nsBottom 69
		nsRight 175
		sightAngle 40
		onMeCheck 16
	)
)

(instance carpet2 of Feature
	(properties
		x 202
		y 111
		noun 4
		nsTop 89
		nsLeft 160
		nsBottom 133
		nsRight 244
		sightAngle 40
		onMeCheck 4
	)
)

(instance bedBoard2 of Feature
	(properties
		x 177
		y 123
		noun 2
		nsTop 109
		nsLeft 150
		nsBottom 138
		nsRight 204
		sightAngle 40
		onMeCheck 16384
	)
)

(instance carpet1 of Feature
	(properties
		x 150
		y 124
		noun 4
		nsTop 99
		nsLeft 53
		nsBottom 150
		nsRight 247
		sightAngle 40
		onMeCheck 16
	)
)

(instance theRoom of Feature
	(properties
		x 152
		y 1
		z 89
		noun 18
		nsTop 29
		nsLeft 59
		nsBottom 150
		nsRight 246
		sightAngle 40
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gLongSong2 number: 914 loop: 1 play:)
				(gEgo
					init:
					view: global206
					posn: 254 199
					setPri: 12
					setLoop: 7
					setMotion: MoveTo 193 143 self
				)
				(= cycles 2)
			)
			(1
				(if (IsFlag 27)
					(gLongSong fade: 127 10 10 0)
				)
			)
			(2
				(cond
					((== gPrevRoomNum 56)
						(= local8 1)
						(phone doVerb: 4)
						(self dispose:)
					)
					((not (IsFlag 27))
						(HandsOn)
						(NormalEgo)
						(self dispose:)
					)
					(else
						(= global219 0)
						(gEgo setHeading: 180 setPri: -1)
						((ScriptID 151 4) ; marie
							init:
							posn: 254 199
							setLoop: 7
							setPri: 12
							setCycle: Walk
							status: 9
							actions: marieActions
							setMotion: MoveTo 202 149 self
						)
						(SetFlag 44)
						(= cycles 2)
					)
				)
			)
			(3
				(gEgo setLoop: 8 setCel: 4)
			)
			(4
				((ScriptID 151 4) setLoop: 8 setCel: 7) ; marie
				(= ticks 10)
			)
			(5
				(gMessager say: 20 0 20 0 self) ; "Wow, Sonny, this is some fancy pad! Is the department paying for this?"
			)
			(6
				((ScriptID 151 4) ; marie
					view: 435
					setCycle: Walk
					setLoop: 1
					setMotion: MoveTo 145 155 self
				)
			)
			(7
				((ScriptID 151 4) setLoop: 7 setMotion: MoveTo 127 143 self) ; marie
			)
			(8
				((ScriptID 151 4) setLoop: 3 setMotion: MoveTo 136 133 self) ; marie
			)
			(9
				((ScriptID 151 4) setLoop: 8 setCel: 3) ; marie
				(= ticks 10)
			)
			(10
				((ScriptID 151 4) setLoop: 8 setCel: 7) ; marie
				(= ticks 10)
			)
			(11
				((ScriptID 151 4) ; marie
					view: 471
					setLoop: 2
					setCel: 0
					setPri: 4
					setCycle: End self
				)
			)
			(12
				((ScriptID 151 4) stopUpd:) ; marie
				(= ticks 30)
			)
			(13
				(gMessager say: 20 0 21 0 self) ; "Oh, don't call a cab just yet, baby. We've got the room, and the poker game doesn't start for awhile...come on, baby, what do you say?"
			)
			(14
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance marieActions of Actions
	(properties)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1) ; "Marie looks lovely tonight."
			)
			(2 ; Talk
				(gCurRoom setScript: sTalkToMarie)
				(return 1)
			)
			(4 ; Do
				(gCurRoom setScript: sJumpMarie)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sTalkToMarie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(NormalEgo)
				(gEgo setMotion: PolyPath 127 143 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(switch (++ global219)
					(1
						(gMessager say: 20 4 29 0 self) ; "Marie, um, I like you a lot, and don't think I wouldn't love to, but I can't. I'm on duty. Besides...I'd like to get to know you better first, you know?"
					)
					(2
						(gMessager say: 11 2 0 0 self) ; "Oh, Sonny, I'm worried about you. From what I've heard, these are some bad guys. You'll be careful, won't you?"
					)
					(3
						(gMessager say: 11 2 6 0 self) ; "Thanks for getting me out of jail, Sonny. I really appreciate it."
					)
					(else
						(gMessager say: 11 2 7 0 self) ; "I guess I should be getting on my way soon."
					)
				)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sJumpMarie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 127 143 self)
			)
			(1
				(gEgo setHeading: 45 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (!= global102 256)
					(gCurRoom drawPic: 99 6)
					(gCast eachElementDo: #hide)
					(+= state 2)
					(= seconds 3)
				else
					(Palette palSET_INTENSITY 0 255 0)
					(= cycles 2)
				)
			)
			(4
				(gCast eachElementDo: #hide)
				(= cycles 2)
			)
			(5
				(gCurRoom drawPic: 99 6)
				(Palette palSET_INTENSITY 0 255 100)
				(= seconds 3)
			)
			(6
				(gMessager say: 20 4 30 0 self) ; "You spend the next several hours in absolute hedonistic bliss with Marie. You miss the poker game. Sometime around 9:00 PM, you get a phone call from Lt. Morgan."
			)
			(7
				(EgoDead 28)
			)
		)
	)
)

(instance Chip of Narrator
	(properties
		x 150
		y 130
		talkWidth 150
		showTitle 1
		back 15
	)
)

(instance Joe_Taber of Narrator
	(properties
		name {Joe Taber}
		x 150
		y 130
		talkWidth 150
		showTitle 1
		back 21
	)
)

(instance sLeave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 151 4) setCycle: Beg self) ; marie
			)
			(1
				((ScriptID 151 4) view: 435 setLoop: 8 setCel: 4) ; marie
				(= ticks 20)
			)
			(2
				(gMessager say: 11 0 5 0 self) ; "Well, I guess I'd better go catch that cab. Maybe I'll see you around, huh, Sonny?"
			)
			(3
				((ScriptID 151 4) ; marie
					view: 435
					setCycle: Walk
					setLoop: -1
					setMotion: MoveTo ((ScriptID 151 4) x:) 189 self ; marie
				)
			)
			(4
				((ScriptID 151 4) hide:) ; marie
				(= ticks 20)
			)
			(5
				(SetFlag 50)
				(ClearFlag 44)
				(ClearFlag 27)
				(self dispose:)
			)
		)
	)
)

(instance backup of Actor
	(properties
		x 44
		y 141
		view 473
		priority 13
		signal 24592
	)
)

(instance doorT of Narrator
	(properties
		x 140
		y 140
		talkWidth 130
		font 4
		back 10
	)
)

(instance sGetPen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 20 0 18 0 self) ; "You hear a knock at the door."
			)
			(1
				(= seconds 2)
			)
			(2
				(gEgo setHeading: 135 self)
			)
			(3
				(= ticks 20)
			)
			(4
				(gMessager say: 6 0 3 0 self) ; "Who is it?"
			)
			(5
				(gEgo setMotion: PolyPath 197 148 self)
			)
			(6
				(gEgo setLoop: 8 setCel: 4)
				(= ticks 20)
			)
			(7
				(gMessager say: 6 0 4 0 self) ; "Come in."
			)
			(8
				(backup
					init:
					posn: 253 179
					setLoop: 1
					setPri: 13
					setCycle: Fwd
					setMotion: MoveTo 218 145 self
				)
			)
			(9
				(gEgo view: global206 setLoop: 8 setCel: 6)
				(backup setCycle: 0 setLoop: 0 setCel: 0)
				(= ticks 20)
			)
			(10
				(gMessager say: 1 2 1 0 self) ; "Hello, Detective Bonds. I'm Detective Danny Anglin."
			)
			(11
				(backup setLoop: 0 setCel: 0 setCycle: CT 2 1 self)
			)
			(12
				(gEgo view: 432 looper: 0 setCycle: 0 setLoop: 0 setCel: 3)
				(= seconds 3)
			)
			(13
				(backup setCel: 0)
				(gEgo view: global206 setLoop: 8 setCel: 6)
				(= ticks 20)
			)
			(14
				(gMessager say: 1 2 2 0 self) ; "And here's another thousand dollars. We don't want you running out of funds in the middle of a poker game."
			)
			(15
				(+= global221 1000)
				(= seconds 2)
			)
			(16
				(if (IsFlag 51)
					(gMessager say: 20 0 24 0 self) ; "Oh! Detective Bonds, this came for you this afternoon. It's from Detective Joe Taber in Chicago. He said it was a picture of Jesse Bains, also known as the Death Angel."
				else
					(= cycles 2)
				)
			)
			(17
				(backup setCel: 3 setCycle: End self)
			)
			(18
				(backup setLoop: 2 setCycle: Fwd setMotion: MoveTo 253 179 self)
			)
			(19
				(backup dispose:)
				(gEgo get: 19) ; Deluxe_Transmitter_Pen
				(NormalEgo)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sUsePhone of Script
	(properties)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(HandsOff)
				(= local6 1)
				(Load rsVIEW 555)
				(gEgo setMotion: PolyPath 188 107 self)
			)
			(1
				(gEgo setPri: 2)
				(= ticks 10)
			)
			(2
				(if (and (not local3) (IsFlag 44))
					(= local3 1)
					(gEgo setLoop: 8 setCel: 7)
				else
					(+= state 3)
				)
				(= ticks 10)
			)
			(3
				(gEgo setCel: 1)
				(= ticks 10)
			)
			(4
				(gEgo setCel: 5)
				(= ticks 10)
			)
			(5
				(gMessager say: 20 0 22 0 self) ; "Um, actually, I need to call a cab and get you out of here. Things could start to get dangerous."
			)
			(6
				(gEgo setLoop: -1 setHeading: 310 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(gEgo view: 539 setLoop: 0 setCel: 0 setCycle: CT 7 1 self)
				(= register 10)
			)
			(9
				(if (not (-- register))
					(gEgo setCycle: End self)
				else
					(if (== (gEgo cel:) 7)
						(gEgo setCel: 8)
					else
						(gEgo setCel: 7)
					)
					(-- state)
					(= ticks 10)
				)
			)
			(10
				(if local8
					(= local2 3784)
					(= cycles 2)
				else
					((ScriptID 555 0) init: 1) ; TTDialer
				)
			)
			(11
				(switch local2
					(-1
						(gMessager say: 15 0 8 0 self) ; "You start to use the phone, but decide that there are better things to do."
					)
					(9473
						(gMessager say: 15 0 9 0 self) ; "Naw. It's too late to call Taber. Your attention needs to remain focused on the operation at hand."
					)
					(3784
						(cond
							((or (== global209 2) (== global213 2))
								(= register 1)
								(gMessager say: 20 0 12 0 self) ; "Lt. James Morgan."
							)
							((and (not (IsFlag 49)) (== global209 3))
								(SetFlag 49)
								(= local7 1)
								(roomTimer setReal: gCurRoom 25)
								(gMessager say: 20 0 11 0 self) ; "Lt. James Morgan."
							)
							((or (== global209 1) (== global213 1))
								(if (not (IsFlag 48))
									(SetFlag 48)
									(SetScore 197 7)
									(gMessager say: 20 0 10 0 self) ; "Lt. James Morgan."
								else
									(gMessager say: 13 4 14 0 self 100) ; "You get a busy signal. Captain Morgan has to spend a lot of time on the phone."
								)
							)
							(else
								(gMessager say: 13 4 14 0 self 100) ; "You get a busy signal. Captain Morgan has to spend a lot of time on the phone."
							)
						)
					)
					(6887
						(= local4 1)
						(gMessager say: 20 0 14 0 self) ; "Lyvely Lytton Cab Company. May I help you?"
					)
					(0
						(= seconds 2)
					)
					(1212
						(gMessager say: 20 0 16 0 self) ; "LT&T Operator. How may I help you?"
					)
					(7588
						(EgoDead)
					)
					(else
						(Printf
							@temp0
							{ERROR(54): no message for phone number %d}
							local2
						)
						(= cycles 2)
					)
				)
			)
			(12
				(= ticks 30)
			)
			(13
				(if register
					(gCast eachElementDo: #hide)
					(gCurRoom drawPic: 99 6)
					(= ticks 30)
				else
					(+= state 3)
					(gEgo setCycle: Beg self)
				)
			)
			(14
				(gMessager say: 20 0 13 0 self) ; "After you failed to infiltrate the drug ring, you were transferred back to Traffic. You can't always get what you want. Better luck next time, Bonds."
			)
			(15
				(= ticks 30)
			)
			(16
				(EgoDead 27)
			)
			(17
				(NormalEgo)
				(gEgo setLoop: 7 setPri: 2)
				(= ticks 10)
			)
			(18
				(if (and local4 (IsFlag 44))
					((ScriptID 151 4) setScript: sLeave self) ; marie
				else
					(= cycles 2)
				)
			)
			(19
				(gEgo setLoop: -1)
				(HandsOn)
				(= local6 0)
				(self dispose:)
			)
		)
	)
)

