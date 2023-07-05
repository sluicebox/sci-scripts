;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use LoadMany)
(use StopWalk)
(use Follow)
(use RFeature)
(use Gauge)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	intro 0
)

(local
	local0
	[local1 6]
	[local7 6] = [263 224 62 24 203 123]
	[local13 6] = [167 171 169 159 178 178]
	[local19 6] = [3 3 3 3 2 1]
	local25
	[local26 3]
	[local29 3] = [51 170 288]
	[local32 3] = [155 156 158]
)

(procedure (localproc_0)
	(if gModelessDialog
		(gModelessDialog dispose:)
	)
)

(instance intro of Rm
	(properties
		picture 83
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 190 186 185 201 657 5 2 0 80 81 267 202)
		(LoadMany rsPIC 83 1 53)
		(LoadMany rsSOUND 81 82 78)
		(Load rsSCRIPT 778)
		(super init:)
		(gAddToPics add: urn eachElementDo: #init doit:)
		(Load rsSCRIPT 778)
		(gEgo posn: 330 117 init: setScript: songScript)
		(if (>= global101 1)
			(gMenace
				view: 80
				setPri: 1
				loop: (gEgo loop:)
				x: (gEgo x:)
				cel: (gEgo cel:)
				y: (+ (gEgo y:) 20)
				ignoreActors:
				init:
			)
		)
		(for ((= local0 0)) (< local0 6) ((++ local0))
			((= [local1 local0] (Clone Prop))
				view: 202
				cycleSpeed: 1
				setPri: 3
				x: [local7 local0]
				y: [local13 local0]
				setLoop: [local19 local0]
				ignoreActors: 1
				ignoreActors: 1
				sightAngle: 180
				closeRangeDist: 500
				longRangeDist: 500
				description: {ripples}
				init:
				stopUpd:
			)
			(if (>= global101 1)
				([local1 local0] setCycle: Fwd)
			)
		)
		(self setScript: beginScript)
	)

	(method (dispose)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		((ScriptID 0 23) fade:) ; backSound
		((ScriptID 0 21) fade:) ; gameSound
		(super dispose:)
	)
)

(instance songScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 0 23) number: 81 init: play: self) ; backSound
			)
			(1
				((ScriptID 0 23) number: 82 play: self) ; backSound
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance beginScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(SetCursor gTheCursor 0)
		(if
			(and
				(== (gCurRoom picture:) 83)
				(< (gEgo x:) 58)
				(>= global101 1)
			)
			(gMenace dispose:)
		)
		(if (and (== state 7) (<= (gEgo x:) 5))
			(localproc_0)
		)
		(if (>= global101 1)
			(if (== (gEgo view:) 0)
				(gMenace
					view: 80
					loop: (gEgo loop:)
					x: (gEgo x:)
					cel: (gEgo cel:)
					y: (+ (gEgo y:) 20)
				)
			else
				(gMenace
					view: 81
					loop: (gEgo loop:)
					x: (gEgo x:)
					cel: 0
					y: (+ (gEgo y:) 20)
				)
			)
		)
	)

	(method (handleEvent event &tmp temp0)
		(super handleEvent: event)
		(if (== (event type:) evKEYBOARD)
			(switch (event message:)
				(KEY_RETURN
					(if
						(or
							(and (== (gCurRoom picture:) 83) (> (gEgo x:) 0))
							(and (== (gCurRoom picture:) 1) (> (gEgo x:) 123))
							(and
								(== (gCurRoom picture:) 53)
								(< (gEgo x:) 320)
							)
						)
						(event claimed: 1)
						(gCurRoom newRoom: 86) ; titleScreen
					else
						(event claimed: 1)
					)
				)
				(KEY_F2
					(if (GetMenu 1282 113)
						(DoSound sndSET_SOUND 0)
						(SetMenu 1282 113 0 110 {Turn on})
					else
						(DoSound sndSET_SOUND 1)
						(SetMenu 1282 113 1 110 {Turn off})
					)
				)
				($0016
					(= temp0
						((Gauge new:)
							description:
								{Use the mouse or right and left arrow keys to set the sound volume.}
							text: {Sound Volume}
							minimum: 0
							normal: 12
							maximum: 15
							higher: {Louder}
							lower: {Softer}
							doit: (DoSound sndVOLUME)
						)
					)
					(DoSound sndVOLUME temp0)
					(DisposeScript 987)
				)
				(KEY_F7
					(SetCursor gTheCursor 1)
					(gGame restore:)
				)
				(else
					(event claimed: 1)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= cycles 20)
			)
			(1
				(SetCursor gTheCursor 0)
				(gEgo
					view: 0
					illegalBits: 0
					ignoreActors:
					setCycle: StopWalk 2
					signal: 4
					setMotion: MoveTo 245 117 self
				)
			)
			(2
				(gEgo loop: 2)
				(self cue:)
			)
			(3
				(Print 200 0 #at 16 20 #time 10 #dispose) ; "You are Sir Graham, the bravest and most honorable knight in the troubled realm of Daventry."
				(= cycles 30)
			)
			(4
				(gEgo setMotion: MoveTo 195 117 self)
			)
			(5
				(localproc_0)
				(Print 200 1 #at 32 125 #width 248 #dispose) ; "King Edward the Benevolent, aged ruler of Daventry, has summoned you to the castle for reasons unknown."
				(gEgo setMotion: MoveTo 88 117 self)
			)
			(6
				(gEgo setMotion: MoveTo 65 105 self)
			)
			(7
				(gEgo setMotion: MoveTo -10 105 self)
			)
			(8
				(localproc_0)
				(gCurRoom picture: 1 style: 40 drawPic: 1)
				(gate init: setPri: 3 stopUpd:)
				(gAddToPics add: guard2 urn1 urn2 eachElementDo: #init doit:)
				(guard1 init: stopUpd:)
				(gEgo posn: 318 105 setMotion: MoveTo 245 105)
				(for ((= local0 0)) (< local0 6) ((++ local0))
					([local1 local0] dispose:)
				)
				(for ((= local25 0)) (< local25 3) ((++ local25))
					((= [local26 local25] (Clone Prop))
						view: 202
						cycleSpeed: 1
						setPri: 3
						x: [local29 local25]
						y: [local32 local25]
						setLoop: 0
						ignoreActors: 1
						sightAngle: 180
						closeRangeDist: 500
						longRangeDist: 500
						description: {ripples}
						init:
						stopUpd:
						shiftClick: 0
					)
					(if (>= global101 1)
						([local26 local25] setCycle: Fwd)
					)
				)
				(= cycles 2)
			)
			(9
				(guard1 setCycle: Walk setMotion: MoveTo 160 105 self)
			)
			(10
				(guard1 setMotion: MoveTo 225 105 self)
			)
			(11
				(Print 200 2 #at 16 20 #dispose) ; "CASTLE GUARD: "Greetings, Sir Graham. The King is expecting you. Allow me to escort you to His Majesty's throne room.""
				(guard1 loop: 4 cel: 2)
				(guardFace
					posn: (- (guard1 x:) 2) (- (guard1 y:) 38)
					setPri: 7
					setCycle: Fwd
					init:
				)
				(= seconds 7)
			)
			(12
				(guardFace dispose:)
				(localproc_0)
				(Print 200 3 #at 16 20 #time 4 #dispose) ; "SIR GRAHAM: "Thank you, Sir Knight.""
				(gramHead setPri: 9 posn: 242 67 setCycle: Fwd init:)
				(guard1 setMotion: MoveTo 160 100 self)
			)
			(13
				(localproc_0)
				(gramHead hide:)
				(guard1 setMotion: MoveTo 160 95)
				(gEgo setMotion: MoveTo 160 100 self)
			)
			(14
				(guard1 stopUpd: loop: 4 cel: 3)
				(gEgo loop: 3)
				(Print 200 4 #at 16 20 #dispose) ; "CASTLE GUARD: "Raise the portcullis!""
				(= seconds 2)
			)
			(15
				((ScriptID 0 21) number: 78 play:) ; gameSound
				(guard1 stopUpd:)
				(gEgo stopUpd:)
				(gate
					illegalBits: 0
					ignoreActors:
					yStep:
						(switch global101
							(0 4)
							(else 1)
						)
					setMotion: MoveTo 160 25 self
				)
			)
			(16
				(localproc_0)
				((ScriptID 0 21) stop:) ; gameSound
				(gate stopUpd:)
				(gEgo ignoreHorizon: setMotion: Follow guard1 23)
				(guard1 setPri: 2 setMotion: MoveTo 160 70 self)
			)
			(17
				(guard1 setMotion: MoveTo 100 70)
				(gEgo setPri: 2 setMotion: MoveTo 160 70 self)
			)
			(18
				(gEgo setMotion: MoveTo 120 70 self)
			)
			(19
				(localproc_0)
				(guard1 posn: 337 154 setMotion: MoveTo 280 166 self)
				(gEgo posn: 330 144 setMotion: MoveTo 207 137 self)
				(gate dispose:)
				(for ((= local25 0)) (< local25 3) ((++ local25))
					([local26 local25] dispose:)
				)
				(gCurRoom picture: 53 style: 2 drawPic: 53)
				(king init: setPri: 5 stopUpd:)
			)
			(20
				(guard1 setLoop: 4 setCel: 1 stopUpd:)
			)
			(21
				(gEgo setMotion: MoveTo 173 123 self)
			)
			(22
				(gEgo setMotion: MoveTo 139 123 self)
			)
			(23
				(gEgo view: 5 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(24
				(localproc_0)
				(Print 200 5 #at 16 20 #width 276 #dispose) ; "SIR GRAHAM: "I am at your service, my King.""
				(gEgo stopUpd:)
				(gramHead show: posn: 136 95 setCycle: Fwd)
				(= seconds 5)
			)
			(25
				(gramHead hide:)
				(talkingHead init: setCycle: Fwd cycleSpeed: 1)
				(localproc_0)
				(Print 200 6 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "I am an old man, Sir Graham. Perhaps too old to carry the weight of this crown.""
				(= seconds 10)
			)
			(26
				(localproc_0)
				(Print 200 7 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "My bones ache, my hands tremble. I'm afraid my time on Earth grows short.""
				(= seconds 6)
			)
			(27
				(localproc_0)
				(Print 200 8 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "But enough about me.""
				(= seconds 4)
			)
			(28
				(localproc_0)
				(Print 200 9 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "Great misfortunes have befallen Daventry since the loss, years ago, of three magical treasures.""
				(= seconds 8)
			)
			(29
				(localproc_0)
				(Print 200 10 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "I have chosen you, the finest knight in all of Daventry, to search for these lost treasures.""
				(= seconds 7)
			)
			(30
				(localproc_0)
				(Print 200 11 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "Only then can this kingdom be restored to its former glory.""
				(= seconds 6)
			)
			(31
				(localproc_0)
				(Print 200 12 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "And only then may I rest with the knowledge that my people are safe.""
				(= seconds 6)
			)
			(32
				(localproc_0)
				(Print 200 13 #at 16 20 #width 230 #dispose #icon 503 2 0) ; "KING EDWARD: "The first treasure is a magic mirror that foretells the future.""
				(= seconds 8)
			)
			(33
				(localproc_0)
				(Print 200 14 #at 16 20 #width 230 #dispose #icon 522 0 2) ; "KING EDWARD: "The second is a magical shield that protects the bearer from all mortal harm.""
				(= seconds 8)
			)
			(34
				(localproc_0)
				(Print 200 15 #at 16 20 #width 230 #dispose #icon 505 0 1) ; "KING EDWARD: "The third and last is an enchanted chest that is forever filled with gold.""
				(= seconds 8)
			)
			(35
				(localproc_0)
				(Print 200 16 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "I know that what I ask is difficult ...nay, perhaps impossible. The dangers are many.""
				(= seconds 8)
			)
			(36
				(localproc_0)
				(Print 200 17 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "But you are brave and pure of heart. That is why I chose you to volunteer.""
				(= seconds 7)
			)
			(37
				(localproc_0)
				(Print 200 18 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "If you succeed, you will inherit my crown, and will rule the Realm of Daventry as her rightful King.""
				(= seconds 8)
			)
			(38
				(localproc_0)
				(Print 200 19 #at 16 20 #width 276 #dispose) ; "KING EDWARD: "Go, Sir Graham, and know that the fate of Daventry lies in your hands.""
				(= seconds 6)
			)
			(39
				(talkingHead setCel: 0 stopUpd:)
				(localproc_0)
				(Print 200 20 #at 16 20 #width 276 #dispose) ; "SIR GRAHAM: "Take heart, my King. I shall not fail you.""
				(gramHead show: setCycle: Fwd)
				(= seconds 5)
			)
			(40
				(gramHead dispose:)
				(gEgo setCycle: Beg self)
			)
			(41
				(localproc_0)
				(gEgo view: 0 setLoop: 1 setCycle: StopWalk 2)
				(= seconds 2)
			)
			(42
				(gEgo setLoop: -1 setMotion: MoveTo 173 123 self)
			)
			(43
				(gEgo setMotion: MoveTo 207 137 self)
			)
			(44
				(gEgo setMotion: MoveTo 255 136 self)
			)
			(45
				(guard1
					setLoop: -1
					startUpd:
					setCycle: Walk
					setMotion: MoveTo 340 154
				)
				(gEgo setMotion: MoveTo 330 144 self)
			)
			(46
				(localproc_0)
				(HandsOn)
				(gCurRoom newRoom: 86) ; titleScreen
			)
		)
	)
)

(instance gate of Actor
	(properties
		x 160
		y 80
		view 201
	)
)

(instance guard1 of Actor
	(properties
		x 136
		y 92
		description {guard}
		view 185
		loop 4
	)
)

(instance guard2 of RPicView
	(properties
		x 197
		y 92
		description {guard}
		view 186
		loop 4
	)
)

(instance king of Prop
	(properties
		x 80
		y 119
		view 190
		loop 2
	)
)

(instance talkingHead of Prop
	(properties
		x 66
		y 87
		view 190
		loop 1
	)

	(method (doVerb))
)

(instance gramHead of Prop
	(properties
		view 5
		loop 2
		cycleSpeed 1
	)

	(method (doVerb))
)

(instance urn of RPicView
	(properties
		x 34
		y 103
		description {urn}
		view 267
	)
)

(instance urn1 of RPicView
	(properties
		x 35
		y 103
		description {urn}
		view 267
	)
)

(instance urn2 of RPicView
	(properties
		x 292
		y 103
		description {urn}
		view 267
	)
)

(instance guardFace of Prop
	(properties
		view 185
		loop 5
		cycleSpeed 1
	)
)

