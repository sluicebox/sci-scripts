;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use hotel)
(use eRS)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Grooper)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm55 0
	Bouncer 1
)

(local
	local0
	local1
	local2
	local3
	local4
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

(instance rm55 of PQRoom
	(properties
		picture 55
	)

	(method (init)
		(= global224 {Last update:\nFri 5-1-92})
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 84 94 60 101 48 101 48 141 59 141 79 141 79 132 146 132 146 143 153 143 153 127 180 127 180 122 208 122 208 134 208 144 246 144 246 140 232 140 232 134 219 134 219 117 260 117 260 127 264 127 264 75 254 75 200 92 191 92 142 107 117 96 149 84 148 81 105 94
					yourself:
				)
		)
		(self setRegions: 151) ; hotel
		(gLongSong fade: 70 10 10 0)
		(hotel curVol: 70)
		(super init:)
		(rightDoor init:)
		(leftDoor init:)
		(= global206 2)
		(switch gPrevRoomNum
			(56
				(rightDoor setCel: 255)
				(self setScript: sEnterFromCardRoom)
			)
			(else
				(barTender init: posn: 30 91 setPri: 3)
				(self setScript: sBartender)
			)
		)
		(room init:)
		(shelfBoxes init:)
		(planter init:)
		(paperTowels init:)
		(sodaCan init:)
		(metalShelf init:)
		(flatBoxes init:)
		(fireExt init:)
		(fireSign init:)
		(cleaningStuff init:)
		(bigTube init:)
		(box1 init:)
		(box2 init:)
		(box3 init:)
		(barrel1 init:)
		(barrel2 init:)
		(barrel3 init:)
		(barrel4 init:)
		(mouseAndTrap init:)
		(Load rsVIEW 1449)
		(Load rsSCRIPT 1449)
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
			((and local1 (& (gEgo onControl: 1) $4000))
				(HandsOff)
				(= local1 0)
				(barTender addToPic:)
				(gEgo setLoop: 8 setCel: 6)
				(roomTimer setReal: self 2)
			)
		)
	)

	(method (cue)
		(if (== global213 1)
			(gCurRoom newRoom: 57)
		else
			(gCurRoom newRoom: 56)
		)
	)

	(method (newRoom newRoomNumber)
		(alexTimer dispose: delete:)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)
)

(instance rightDoor of Prop
	(properties
		x 271
		y 69
		noun 23
		view 521
		priority 1
		signal 24592
	)
)

(instance leftDoor of Prop
	(properties
		x 80
		y 37
		noun 20
		view 521
		loop 1
		priority 3
		signal 24592
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (not local1)
					(gCurRoom setScript: sExitToBar)
				else
					(gMessager say: 20 4) ; "Perhaps this isn't a good time to jam. The action's just getting started and leaving would blow your cover as a cool gambling type."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sExitToBar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 100 108 self)
			)
			(1
				(gLongSong2 number: 913 loop: 1 play:)
				(leftDoor setCycle: End self)
				(gEgo setHeading: 300 self)
			)
			(2)
			(3
				(leftDoor stopUpd:)
				(gEgo
					setLoop: 7
					setPri: 3
					setCycle: Fwd
					setMotion: MoveTo 59 91 self
				)
			)
			(4
				(gEgo setCycle: 0 setLoop: 1)
				(= cycles 5)
			)
			(5
				(gEgo setCycle: Fwd setPri: 3 setMotion: MoveTo 30 91 self)
				(gLongSong2 number: 913 loop: 1 play:)
				(leftDoor setCycle: Beg self)
			)
			(6
				(gLongSong2 number: 914 loop: 1 play:)
			)
			(7
				(gCurRoom newRoom: 52)
			)
		)
	)
)

(instance barTender of Actor
	(properties
		view 440
		signal 24576
	)

	(method (doit &tmp temp0 temp1)
		(super doit:)
		(cond
			((!= view 440) 0)
			((self isStopped:)
				(if
					(and
						(!=
							(= temp0 (self loop:))
							(= temp1 (- (NumLoops self) 1))
						)
						(IsObject (self cycler:))
						(not ((self cycler:) isKindOf: Grycler))
					)
					(self loop: temp1 cel: temp0)
				)
			)
			(
				(and
					(== (self loop:) (- (NumLoops self) 1))
					(not (& signal $0800))
				)
				(self loop: (self cel:))
			)
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Talk
				(leftDoor stopUpd:)
				(gMessager say: 22 2 9 0) ; "Alex, honey, I'm a busy man..."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(super cue:)
		(gMessager say: 21 0 15) ; "These aren't patient men, Whitey. If you're gonna go in, go in."
	)
)

(instance btsg of Grooper
	(properties)

	(method (doit)
		(if
			(and
				(== (barTender loop:) (- (NumLoops barTender) 1))
				(not (& (barTender signal:) $0800))
			)
			(barTender loop: (barTender cel:))
		)
		(super doit: &rest)
	)
)

(instance room of Feature
	(properties
		x 156
		y 1
		z 88
		noun 1
		nsTop 20
		nsLeft 36
		nsBottom 156
		nsRight 276
		sightAngle 40
	)
)

(instance shelfBoxes of Feature
	(properties
		x 112
		y 60
		noun 17
		nsTop 28
		nsLeft 85
		nsBottom 92
		nsRight 139
		sightAngle 40
		onMeCheck 8
	)
)

(instance planter of Feature
	(properties
		x 174
		y 46
		noun 19
		nsTop 41
		nsLeft 166
		nsBottom 51
		nsRight 182
		sightAngle 40
		onMeCheck 4
	)
)

(instance paperTowels of Feature
	(properties
		x 103
		y 70
		noun 18
		nsTop 64
		nsLeft 91
		nsBottom 76
		nsRight 115
		sightAngle 40
		onMeCheck 2
	)
)

(instance sodaCan of Feature
	(properties
		x 194
		y 92
		noun 14
		nsTop 89
		nsLeft 190
		nsBottom 96
		nsRight 198
		sightAngle 40
		onMeCheck 16
	)
)

(instance metalShelf of Feature
	(properties
		x 115
		y 59
		noun 16
		nsTop 31
		nsLeft 83
		nsBottom 88
		nsRight 147
		sightAngle 40
		onMeCheck 4
	)
)

(instance flatBoxes of Feature
	(properties
		x 245
		y 130
		noun 4
		nsTop 116
		nsLeft 220
		nsBottom 145
		nsRight 271
		sightAngle 40
		onMeCheck 2
	)
)

(instance fireExt of Feature
	(properties
		x 209
		y 54
		noun 2
		nsTop 44
		nsLeft 201
		nsBottom 64
		nsRight 218
		sightAngle 40
		onMeCheck 8
	)
)

(instance fireSign of Feature
	(properties
		x 210
		y 38
		noun 3
		nsTop 33
		nsLeft 201
		nsBottom 44
		nsRight 219
		sightAngle 40
		onMeCheck 2
	)
)

(instance bigTube of Feature
	(properties
		x 125
		y 137
		noun 5
		nsTop 124
		nsLeft 45
		nsBottom 150
		nsRight 205
		sightAngle 40
		onMeCheck 8
	)
)

(instance box1 of Feature
	(properties
		x 103
		y 126
		noun 10
		nsTop 115
		nsLeft 84
		nsBottom 138
		nsRight 123
		sightAngle 40
		onMeCheck 16
	)
)

(instance box2 of Feature
	(properties
		x 173
		y 137
		noun 11
		nsTop 126
		nsLeft 159
		nsBottom 149
		nsRight 188
		sightAngle 40
		onMeCheck 4
	)
)

(instance box3 of Feature
	(properties
		x 182
		y 144
		noun 12
		nsTop 137
		nsLeft 165
		nsBottom 151
		nsRight 200
		sightAngle 40
		onMeCheck 2
	)
)

(instance barrel1 of Feature
	(properties
		x 73
		y 138
		noun 6
		nsTop 122
		nsLeft 61
		nsBottom 154
		nsRight 86
		sightAngle 40
		onMeCheck 2
	)
)

(instance barrel2 of Feature
	(properties
		x 104
		y 136
		noun 7
		nsTop 122
		nsLeft 92
		nsBottom 151
		nsRight 117
		sightAngle 40
		onMeCheck 4
	)
)

(instance barrel3 of Feature
	(properties
		x 115
		y 141
		noun 8
		nsTop 132
		nsLeft 104
		nsBottom 151
		nsRight 127
		sightAngle 40
		onMeCheck 2
	)
)

(instance mouseAndTrap of Feature
	(properties
		x 216
		y 140
		noun 13
		nsTop 135
		nsLeft 206
		nsBottom 146
		nsRight 226
		sightAngle 40
		onMeCheck 16
	)
)

(instance cleaningStuff of Feature
	(properties
		x 162
		y 73
		noun 15
		nsTop 47
		nsLeft 129
		nsBottom 100
		nsRight 196
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(switch (++ local0)
					(1
						(gMessager say: 15 1 1) ; "The shelves are full of cleaning fluids, powders, and sprays. You see bleach, detergent, floor wax and toilet bowl cleaner."
					)
					(2
						(gMessager say: 15 1 2) ; "On closer inspection, you see ant poison, rat poison, and Red Dye #2."
					)
					(3
						(gMessager say: 15 1 10) ; "There's kerosene, gasoline, benzine, toluene, and phosgene in handy spray bottles."
					)
					(4
						(gMessager say: 15 1 10) ; "There's kerosene, gasoline, benzine, toluene, and phosgene in handy spray bottles."
						(= local0 0)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance barrel4 of Feature
	(properties
		x 147
		y 239
		z 100
		noun 9
		nsTop 128
		nsLeft 135
		nsBottom 151
		nsRight 159
		sightAngle 40
		approachX 148
		approachY 143
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 4 1) ; Do, Look
	)
)

(instance alexTimer of Timer
	(properties)
)

(instance Bouncer of Narrator
	(properties
		x 150
		y 130
		talkWidth 150
		showTitle 1
		back 20
	)
)

(instance sEnterFromCardRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: global206
					init:
					posn: 268 72
					setLoop: 5
					setCycle: Walk
					setMotion: MoveTo 248 87
				)
				(= ticks 5)
			)
			(1
				(gLongSong2 number: 913 loop: 1 play:)
				(rightDoor setCycle: Beg self)
			)
			(2
				(gLongSong2 number: 914 loop: 1 play:)
				(HandsOn)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFromBar of Script
	(properties)

	(method (dispose)
		(gEgo cycleSpeed: local3 moveSpeed: local2)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(if (not register)
					(gLongSong2 number: 913 loop: 1 play:)
					(leftDoor setCycle: End self)
				else
					(= cycles 2)
				)
			)
			(2
				(NormalEgo)
				(= local3 (gEgo cycleSpeed:))
				(= local2 (gEgo moveSpeed:))
				(gEgo
					view: global206
					setPri: 3
					posn: 30 91
					init:
					view: global206
					ignoreActors: 1
					moveSpeed: 6
					cycleSpeed: 6
					setMotion: MoveTo 59 91 self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo setMotion: MoveTo 100 108 self)
			)
			(5
				(if (not register)
					(= cycles 2)
				else
					(gEgo setPri: -1 setMotion: PolyPath 193 116 self)
				)
			)
			(6
				(if (not register)
					(gLongSong2 number: 913 loop: 1 play:)
					(leftDoor setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(7
				(if (not register)
					(gLongSong2 number: 914 loop: 1 play:)
					(HandsOn)
					(NormalEgo)
					(self dispose:)
				else
					(gEgo setMotion: PolyPath 207 110 self)
				)
			)
			(8
				(sBartender register: 1)
				(self dispose:)
			)
		)
	)
)

(instance sBartender of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 2)
			)
			(1
				(gLongSong2 number: 913 loop: 1 play:)
				(leftDoor setCycle: End self)
			)
			(2
				(barTender
					setLoop: -1
					setCycle: Walk
					setLoop: btsg
					setMotion: MoveTo 59 91 self
				)
			)
			(3
				(gEgo
					view: global206
					setPri: 3
					posn: 30 91
					init:
					setLoop: -1
					setScript: sEnterFromBar 0 1
				)
				(barTender setMotion: MoveTo 100 108 self)
			)
			(4
				(barTender setPri: -1 setMotion: PolyPath 188 106 self)
			)
			(5
				(leftDoor setCycle: Beg self)
			)
			(6
				(gLongSong2 number: 914 loop: 1 play: self)
			)
			(7
				(cond
					((< (gEgo x:) 180)
						(if (!= (barTender heading:) 225)
							(barTender setHeading: 225)
						)
					)
					((and (< (gEgo x:) 215) (!= (barTender heading:) 180))
						(barTender setHeading: 180)
					)
				)
				(if (not register)
					(-- state)
				)
				(= ticks 20)
			)
			(8
				(leftDoor addToPic:)
				(gEgo setHeading: 315 self)
				(barTender setHeading: 135 self)
			)
			(9)
			(10
				(= ticks 10)
			)
			(11
				(if (== global213 1)
					(gMessager say: 21 0 14 0 self) ; "Just let me tell them you're coming, then you can go on through."
				else
					(gMessager say: 21 0 3 0 self) ; "Okay, big guy, I'm afraid I'm gonna have to pat you down. Not that I don't trust you or anything, but we have to be certain..."
				)
			)
			(12
				(gEgo view: 523 setCel: 0 setLoop: 0 setCycle: CT 4 1 self)
				(barTender view: 520 setLoop: 0 setCel: 0)
			)
			(13
				(= ticks 20)
			)
			(14
				(barTender setCycle: CT 6 1 self)
			)
			(15
				(= ticks 20)
			)
			(16
				(barTender setCycle: CT 3 -1 self)
			)
			(17
				(barTender setCycle: End self)
			)
			(18
				(if (!= global213 1)
					(gMessager say: 21 0 12 0 self) ; "Okay, hot shot, cool your heels while I clear the way."
				else
					(= ticks 10)
				)
			)
			(19
				(barTender
					view: 440
					setCycle: Walk
					setLoop: btsg
					setMotion: MoveTo 251 74 self
				)
				(gEgo setCycle: End self)
			)
			(20
				(NormalEgo)
				(gEgo setHeading: 45)
			)
			(21
				(if (== global213 1)
					(self changeState: 26)
				else
					(barTender setCycle: 0 setLoop: 8 setCel: 4)
					(= ticks 20)
				)
			)
			(22
				(barTender setCel: 2)
				(= ticks 20)
			)
			(23
				(barTender setCel: 5)
				(= ticks 20)
			)
			(24
				(if (!= global213 1)
					(gMessager say: 21 0 13 0 self) ; "Hang on a minute, Whitey. I'll be right with you. Why don't you, uh, take in the scenery, ha ha!"
				else
					(= cycles 2)
				)
			)
			(25
				(= seconds 2)
			)
			(26
				(barTender view: 520 setLoop: 1 setCel: 0 setCycle: End)
				(gLongSong2 number: 810 loop: -1 play:)
				(= seconds 2)
			)
			(27
				(gLongSong2 stop:)
				(= cycles 2)
			)
			(28
				(if (!= global213 1)
					(gMessager say: 21 0 11 0 self) ; "Alex taps out a strange pattern on the door."
				else
					(= cycles 2)
				)
			)
			(29
				(barTender setCycle: Beg self)
			)
			(30
				(gLongSong2 number: 913 loop: 1 play:)
				(rightDoor setCycle: End self)
			)
			(31
				(barTender setLoop: 2 setCel: 0 setCycle: End self)
			)
			(32
				(NormalEgo)
				(= local1 1)
				(if (!= global213 1)
					(gMessager say: 21 0 5 0 self) ; "Okay, they're ready for you, big guy. Just go on in."
				else
					(gMessager say: 21 0 6 0 self) ; "Okay, honey, go on in."
				)
			)
			(33
				(alexTimer setReal: barTender 12)
				(= ticks 20)
			)
			(34
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

