;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 450)
(include sci.sh)
(use Main)
(use n013)
(use ExitFeature)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm450 0
)

(local
	local0
	local1
	local2
)

(instance rm450 of Room
	(properties
		noun 1
		picture 450
		style 14
		exitStyle 13
		east 200
		west 200
	)

	(method (init)
		(gWalkHandler addToFront: gCurRoom)
		(super init:)
		((= gGk1Exits gk1Exits) add:)
		(cherubL init:)
		(cherubR init:)
		(altar init:)
		(eastExit init:)
		(westExit init:)
		(southExit init:)
		(flagsL init:)
		(flagsR init:)
		(confess1 init:)
		(confess2 init:)
		(confess3 init:)
		(priestDoor init:)
		(pew1 init:)
		(pew2 init:)
		(cond
			((and (not (IsFlag 74)) (IsFlag 314))
				(crash actions: crashActions init:)
			)
			((and (IsFlag 74) (not (IsFlag 392)))
				(crash actions: crashActions init:)
			)
		)
		(gGame handsOn:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 258 145 229 120 212 98 306 98 306 96 74 96 74 98 195 98 166 123 14 123 52 111 50 109 2 124 3 125 169 125 143 134 75 134 75 136 139 136 124 146 124 152 275 152
					yourself:
				)
		)
		(switch gPrevRoomNum
			(455
				(gGkMusic1 fade: (gGkMusic1 musicVolume:) 50 10 0)
				(gGame handsOff:)
				(if (IsFlag 273)
					(gEgo
						normalize: 0
						posn: 41 111
						setScaler: Scaler 100 28 134 97
						init:
						setMotion: PolyPath 46 111
					)
					(ClearFlag 273)
				else
					(gEgo
						normalize: 0
						posn: 18 118
						setScaler: Scaler 100 28 134 97
						init:
						setMotion: PolyPath 28 117
					)
				)
				(gCurRoom south: 410)
				(gGame handsOn:)
			)
			(457
				(gGkMusic1 fade: (gGkMusic1 musicVolume:) 50 10 0)
				(gEgo
					normalize: 0
					posn: 283 97
					setScaler: Scaler 100 28 134 97
					init:
					setMotion: PolyPath 275 97
				)
				(gCurRoom south: 410)
			)
			(50 ; interrogation
				(self setScript: sBackFromInterrogate)
			)
			(410 ; neJackson
				(self setScript: sGabeEnters 0 1)
			)
			(else
				(self setScript: sGabeEnters)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(if local1
					(gEgo setMotion: 0 setScript: sGabeStands)
					(return 1)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(or
					(gEgo inRect: 63 73 94 101)
					(gEgo inRect: 301 78 319 100)
				)
				(not local0)
			)
			(= local0 1)
			(gCurRoom newRoom: 200)
		)
		(if
			(and
				(gGk1Exits size:)
				(== (gTheIconBar curIcon:) (gTheIconBar walkIconItem:))
			)
			(gGk1Exits eachElementDo: #doit)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== (gEgo edgeHit:) EDGE_BOTTOM)
			(if (< (gEgo x:) 200)
				(= newRoomNumber 420) ; nwJackson
			else
				(= newRoomNumber 410) ; neJackson
			)
		)
		(gEgo setScale: 0 normalize:)
		(if (gGk1Exits size:)
			(gGk1Exits eachElementDo: #dispose)
			(gGk1Exits dispose:)
		)
		(if (or (== newRoomNumber 200) (== newRoomNumber 410) (== newRoomNumber 420)) ; neJackson, nwJackson
			(ClearFlag 334)
			(gGkMusic1 fade:)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(gWalkHandler delete: gCurRoom)
		(DisposeScript 21)
		(DisposeScript 64935)
		(super dispose:)
	)
)

(instance gk1Exits of EventHandler
	(properties)
)

(instance sGabeStands of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setCel: 0 setLoop: 1 setSpeed: 12 setCycle: End self)
			)
			(1
				(= local1 0)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sBackFromInterrogate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 1)
				(gEgo
					view: 452
					posn: 106 134
					setCel: 12
					setLoop: 0
					setScaler: Scaler 100 28 134 97
					init:
				)
				(= cycles 1)
				(gCurRoom south: 410)
			)
			(1
				(if (IsFlag 74)
					(= cycles 1)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(2
				(gMessager say: 14 0 12 1 self) ; "(A LITTLE SCARED)Hey, are you all right?"
			)
			(3
				(gMessager say: 14 0 12 2 self) ; "(FRANTIC, LOUDLY)Someone! I need help!"
				(gEgo setCel: 0 setLoop: 1 setSpeed: 12 setCycle: End self)
			)
			(4 0)
			(5
				(gMessager say: 14 0 12 3 self) ; "(GURGLE, DYING)The eyes of the snake! Damballah! <gurgle>"
			)
			(6
				(gMessager say: 14 0 12 4 self) ; "(SCARED)What snake? Crash?"
				(gEgo setCel: 0 setLoop: 2 setCycle: End self)
			)
			(7 0)
			(8
				(gMessager say: 14 0 12 5 self) ; "Crash spasms twice more, then dies as Gabriel watches."
				(crash view: 4521 setCel: 0 setLoop: 2 setCycle: End self)
			)
			(9 0)
			(10
				(gMessager say: 14 0 12 6 self) ; "(RRCC. VERY UPSET & SYMPATHETIC. JUST WATCHED SOMEONE DIE)Oh, God! Poor bastard!"
				(= local1 0)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGabeEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= gPrevRoomNum 50) (!= gPrevRoomNum 455)) ; interrogation
					(gGkMusic1
						number: 450
						setLoop: -1
						stop:
						play:
						setVol: 0
						fade: (gGkMusic1 musicVolume:) 5 10 0
					)
				)
				(gEgo
					normalize: 3
					init:
					state: 2
					setScaler: Scaler 100 28 134 97
					setCycle: StopWalk -1
				)
				(cond
					((== gPrevRoomNum 200)
						(gEgo posn: 98 96 setMotion: MoveTo 120 96 self)
					)
					(register
						(gEgo posn: 230 170 setMotion: MoveTo 230 140 self)
					)
					(else
						(gEgo posn: 160 170 setMotion: MoveTo 160 140 self)
					)
				)
			)
			(1
				(if (and (IsFlag 392) (not (IsFlag 325)))
					(SetFlag 325)
					(if (not (== gDay 10))
						(gMessager say: 14 0 18) ; "It looks like someone found and moved Crash's body."
					)
				)
				(gGame handsOn:)
				(gCurRoom south: 420)
				(self dispose:)
			)
		)
	)
)

(instance sGabeSits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 106 134 self)
			)
			(1
				(Face gEgo 106 130 self)
			)
			(2
				(gEgo
					view: 452
					posn: 106 134
					setCel: 0
					setLoop: 4 1
					setCycle: End self
				)
			)
			(3
				(= local1 1)
				(gGame handsOn:)
				(switch register
					(0)
					(else
						(crash doVerb: register)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sTraceTattoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: sGabeStands self)
			)
			(1
				(gMessager say: 15 15 15 0 self) ; "(TO HIMSELF)I guess I'd better copy this tattoo."
			)
			(2
				(gGame handsOff:)
				(gEgo
					setSpeed: 18
					view: 454
					setCel: 0
					setLoop: 0
					setCycle: End self
				)
				(gEgo get: 26) ; tatooTrace
				(SetFlag 307)
			)
			(3
				(gGkSound1 setLoop: 1 number: 15 play:)
				(gEgo setCel: 0 setLoop: 1 setCycle: End self)
			)
			(4
				(gEgo getPoints: -999 2)
				(gGame handsOn:)
				(gEgo normalize: 6)
				(= local2 0)
				(self dispose:)
			)
		)
	)
)

(instance sGoToConfession of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if local1
					(self setScript: sGabeStands self)
				else
					(= cycles 1)
				)
			)
			(1
				(if (and (> (gEgo x:) 198) (< (gEgo y:) 117))
					(gEgo setMotion: PolyPath 198 117 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOff:)
				(switch register
					(1
						(= temp0 12)
						(= temp1 118)
					)
					(2
						(= temp0 26)
						(= temp1 85)
					)
					(3
						(= temp0 39)
						(= temp1 109)
					)
				)
				(gEgo setMotion: PolyPath temp0 temp1 self)
			)
			(3
				(gGame handsOn:)
				(if (and (== register 3) (not (IsFlag 326)) (== gDay 10))
					(gMessager say: 8 6 20) ; "Someone is in that confessional. Gabriel will have to wait."
				else
					(if (== register 3)
						(SetFlag 273)
					)
					(gCurRoom newRoom: 455)
				)
				(self dispose:)
			)
		)
	)
)

(instance sDoInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(deadCrash init: self rm450 1)
			)
			(1
				(gGame handsOff:)
				(= cycles 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGoToPriestRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if local1
					(self setScript: sGabeStands self)
				else
					(= cycles 1)
				)
			)
			(1
				(if local1
					(gEgo setMotion: MoveTo 153 130 self)
				else
					(= cycles 1)
				)
			)
			(2
				(gEgo setMotion: PolyPath 281 96 self)
			)
			(3
				(gEgo
					view: 451
					posn: 277 91
					setCel: 0
					setLoop: 4
					setScale: 0
					setCycle: End self
				)
			)
			(4
				(gGame handsOn:)
				(gCurRoom newRoom: 457)
			)
		)
	)
)

(instance sInterrogate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((and (not (IsFlag 460)) (not (IsFlag 308)))
						(SetFlag 460)
						(gMessager say: 9 10 25) ; "(RRCC)I need to talk to you--ask you some questions."
						(self dispose:)
					)
					((and (IsFlag 460) (not (IsFlag 308)))
						(gMessager say: 9 10 26) ; "(RRCC)Come on! Talk to me!"
						(self dispose:)
					)
					((and (not (IsFlag 334)) (IsFlag 308))
						(SetFlag 334)
						(gMessager say: 9 10 8 0 self) ; "(RRCC. TO CRASH. URGING, EXCITED)Will you answer some questions for me now?"
					)
					(else
						(gMessager say: 9 10 9 0 self) ; "Just a few more questions."
					)
				)
			)
			(1
				(= global178 10)
				(gCurRoom newRoom: 50) ; interrogation
			)
		)
	)
)

(instance crash of Actor
	(properties
		noun 9
		x 134
		y 146
		z 39
		priority 128
		fixPriority 1
		view 4521
		signal 16417
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(cond
				((not (IsFlag 74))
					(switch theVerb
						(42 ; braceRep_
							(if (IsFlag 308)
								(gMessager say: 9 42 11) ; "(EXCITED)Tell me more about this snake sign."
							else
								(SetFlag 308)
								(gEgo getPoints: 192 1)
								(SetFlag 323)
								(if (IsFlag 460)
									(gMessager say: 9 42 27) ; "Do you recognize this?"
								else
									(gMessager say: 9 42 10) ; "Do you recognize this?"
								)
							)
						)
						(else
							(super doVerb: theVerb)
						)
					)
				)
				((== theVerb 15) ; sketchBook
					(if (gEgo has: 26) ; tatooTrace
						(gMessager say: noun theVerb 22) ; "Gabriel already copied the tattoo."
					else
						(gMessager say: noun theVerb 23) ; "(RRCC)Gabriel should get a closer look at Crash if he wants to do any sketching."
					)
				)
				(else
					(gMessager say: 9 0 7) ; "Crash won't be looking at anything, ever again."
				)
			)
			(return 1)
		else
			(switch theVerb
				(10 ; Ask
					(if (not (IsFlag 74))
						(gCurRoom setScript: sInterrogate)
					else
						(gMessager say: noun 11 7) ; "Crash is dead. He's not going to be very communicative."
					)
					(return 1)
				)
				(11 ; Talk
					(if (not (IsFlag 74))
						(cond
							((IsFlag 333)
								(gMessager say: noun theVerb 6) ; "You look pretty sick. Shouldn't you be in a hospital?"
							)
							((IsFlag 332)
								(SetFlag 333)
								(gMessager say: noun theVerb 5) ; "Why are you praying?"
							)
							(else
								(SetFlag 332)
								(gMessager say: noun theVerb 4) ; "(APPROACHES CRASH IN CHURCH)Psst. Hey! What are you doing here?"
							)
						)
					else
						(gMessager say: noun 11 7) ; "Crash is dead. He's not going to be very communicative."
					)
					(return 1)
				)
				(9 ; Move
					(if (IsFlag 74)
						(gMessager say: 9 9 7) ; "Moving the body is the job of the coroner's office."
					else
						(gMessager say: 9 9 0) ; "Crash is still capable of moving under his own volition."
					)
					(return 1)
				)
				(7 ; Look
					(if (IsFlag 74)
						(gCurRoom setScript: sDoInset)
						(return 1)
					else
						(gMessager say: noun theVerb 3) ; "Crash is huddled in a pew. He looks seriously ill."
						(return 1)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance cherubL of Feature
	(properties
		noun 2
		sightAngle 20
		x 73
		y 145
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 58 130 54 124 59 114 61 103 57 106 53 105 47 95 50 79 59 69 58 78 64 82 62 72 71 68 81 72 78 76 74 81 71 81 75 87 77 97 93 96 99 98 98 105 90 109 80 108 81 117 76 126 79 126 81 134 82 145 57 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance cherubR of Feature
	(properties
		noun 2
		sightAngle 20
		x 312
		y 145
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 294 145 294 132 301 123 303 119 298 109 296 108 294 105 286 106 277 98 286 94 297 94 301 95 303 80 298 79 300 71 297 70 307 67 316 71 319 65 319 145
					yourself:
				)
		)
		(super init:)
	)
)

(instance flagsR of Feature
	(properties
		noun 3
		sightAngle 20
		x 312
		y 145
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 21 296 19 298 36 252 61 246 59 245 51
					yourself:
				)
		)
		(super init:)
	)
)

(instance flagsL of Feature
	(properties
		noun 3
		sightAngle 20
		y 145
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 25 131 31 145 42 162 58 162 67 94 31 94 21
					yourself:
				)
		)
		(super init:)
	)
)

(instance pew1 of Feature
	(properties
		noun 4
		sightAngle 20
		x 92
		y 145
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 146 0 108 94 93 189 94 189 97 121 146
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if local1
					(gMessager say: 4 8 0) ; "Gabriel is already seated."
				else
					(gCurRoom setScript: sGabeSits)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pew2 of Feature
	(properties
		noun 4
		sightAngle 20
		x 268
		y 145
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 291 93 319 97 319 147 278 147 221 98 221 93
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Operate
				(if local1
					(gMessager say: 4 8 0) ; "Gabriel is already seated."
				else
					(gCurRoom setScript: sGabeSits)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance crashPew of Feature ; UNUSED
	(properties
		noun 11
		sightAngle 20
		y 145
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 25 131 31 145 42 162 58 162 67 94 31 94 21
					yourself:
				)
		)
		(super init:)
	)
)

(instance altar of Feature
	(properties
		noun 5
		nsLeft 160
		nsTop 44
		nsRight 247
		nsBottom 91
		sightAngle 40
		approachX 203
		approachY 67
		x 203
		y 67
	)
)

(instance confess1 of Feature
	(properties
		noun 8
		nsLeft 6
		nsTop 64
		nsRight 18
		nsBottom 107
		sightAngle 20
		approachX 12
		approachY 118
		x 12
		y 85
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gCurRoom setScript: sGoToConfession 0 1)
			)
			(8 ; Operate
				(gCurRoom setScript: sGoToConfession 0 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance confess2 of Feature
	(properties
		noun 17
		nsLeft 21
		nsTop 65
		nsRight 32
		nsBottom 106
		sightAngle 40
		approachX 26
		approachY 85
		x 26
		y 85
	)
)

(instance confess3 of Feature
	(properties
		noun 8
		nsLeft 34
		nsTop 66
		nsRight 45
		nsBottom 102
		sightAngle 20
		approachX 39
		approachY 109
		x 39
		y 84
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gCurRoom setScript: sGoToConfession 0 3)
			)
			(8 ; Operate
				(gCurRoom setScript: sGoToConfession 0 3)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance priestDoor of Feature
	(properties
		noun 6
		nsLeft 275
		nsTop 79
		nsRight 288
		nsBottom 95
		sightAngle 40
		approachX 283
		approachY 96
		x 281
		y 87
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Open
				(gCurRoom setScript: sGoToPriestRoom)
			)
			(8 ; Operate
				(gCurRoom setScript: sGoToPriestRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance southExit of ExitFeature
	(properties
		nsTop 140
		nsLeft 80
		nsBottom 145
		nsRight 260
		cursor 964
		exitDir 3
	)
)

(instance westExit of ExitFeature
	(properties
		nsTop 73
		nsLeft 63
		nsBottom 101
		nsRight 94
		cursor 962
		exitDir 4
	)
)

(instance eastExit of ExitFeature
	(properties
		nsTop 78
		nsLeft 301
		nsBottom 100
		nsRight 319
		cursor 963
		exitDir 2
	)
)

(instance deadCrash of Inset
	(properties
		view 453
		x 82
		y 22
		priority 13
		disposeNotOnMe 1
		noun 16
	)

	(method (init)
		(super init: &rest)
		(myShirt init:)
		(if (IsFlag 322)
			(myShirt hide:)
		)
		(face init:)
		(chest init:)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (dispose)
		(myShirt dispose:)
		(face dispose:)
		(chest dispose:)
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(super dispose: &rest)
	)
)

(instance myShirt of View
	(properties
		noun 15
		x 72
		y 85
		priority 189
		fixPriority 1
		view 453
		cel 1
		signal 4129
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 15) ; sketchBook
				(if (IsFlag 322)
					(if (gEgo has: 26) ; tatooTrace
						(gMessager say: noun theVerb 16) ; "Gabriel already copied the tattoo."
					else
						(gCurRoom setScript: sTraceTattoo)
					)
				else
					(gMessager say: noun theVerb 14) ; "Gabriel doesn't even like Crash's shirt! Why would he want to draw it?"
				)
				(return 1)
			)
			((== theVerb 4) ; magGlass
				(gMessager say: noun theVerb 0) ; "(TO PLAYER. GROSSED OUT)This is about as close as I want to get!"
				(return 1)
			)
			((and (not (OneOf theVerb 8 6 12 10 11 9 7 13)) (IsFlag 322)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
				(gMessager say: noun 0 13) ; "There's no point in using that on Crash's chest."
				(return 1)
			)
			(
				(and
					(not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(not (IsFlag 322))
				)
				(gMessager say: noun 0 14) ; "There's no point in using that on Crash's shirt."
				(return 1)
			)
			(else
				(switch theVerb
					(7 ; Look
						(if (IsFlag 322)
							(gMessager say: noun 7 13) ; "On Crash's chest is a tattoo of a snake."
						else
							(gMessager say: noun 7 14) ; "Crash's shirt is closed."
						)
						(return 1)
					)
					(12 ; Pickup
						(if (IsFlag 322)
							(gMessager say: noun theVerb 13) ; "(RRCC)Gabriel can't take the tattoo with him that way."
						else
							(gMessager say: noun theVerb 14) ; "There's no point in doing that with the corpse."
						)
						(return 1)
					)
					(6 ; Open
						(if (IsFlag 322)
							(myShirt show:)
							(ClearFlag 322)
						else
							(if (not (IsFlag 323))
								(SetFlag 323)
								(gMessager say: 15 6 17) ; "(TO HIMSELF)That tattoo looks like Cazaunoux's bracelet."
							)
							(myShirt hide:)
							(SetFlag 322)
						)
						(return 1)
					)
					(9 ; Move
						(if (IsFlag 322)
							(myShirt show:)
							(ClearFlag 322)
						else
							(if (not (IsFlag 323))
								(SetFlag 323)
								(gMessager say: 15 6 17) ; "(TO HIMSELF)That tattoo looks like Cazaunoux's bracelet."
							)
							(myShirt hide:)
							(SetFlag 322)
						)
						(return 1)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance face of Feature
	(properties
		noun 7
		x 170
		y 190
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 25 37 14 27 17 14 25 13 43 14 51 25 48 39
					yourself:
				)
		)
		(super init:)
	)
)

(instance chest of Feature
	(properties
		noun 15
		x 170
		y 119
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 114 84 93 85 60 59 51 41 60 41 63 39 75 28 86 35 87 53 94 65
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 15) ; sketchBook
				(if (IsFlag 322)
					(if (gEgo has: 26) ; tatooTrace
						(gMessager say: noun theVerb 16) ; "Gabriel already copied the tattoo."
					else
						(= local2 1)
						(gCurRoom setScript: sTraceTattoo)
						(deadCrash dispose:)
					)
				else
					(gMessager say: noun theVerb 14) ; "Gabriel doesn't even like Crash's shirt! Why would he want to draw it?"
				)
				(return 1)
			)
			((== theVerb 4) ; magGlass
				(gMessager say: noun theVerb 0) ; "(TO PLAYER. GROSSED OUT)This is about as close as I want to get!"
				(return 1)
			)
			((and (not (OneOf theVerb 8 6 12 10 11 9 7 13)) (IsFlag 322)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
				(gMessager say: noun 0 13) ; "There's no point in using that on Crash's chest."
				(return 1)
			)
			(
				(and
					(not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
					(not (IsFlag 322))
				)
				(gMessager say: noun 0 14) ; "There's no point in using that on Crash's shirt."
				(return 1)
			)
			(else
				(switch theVerb
					(7 ; Look
						(if (IsFlag 322)
							(gMessager say: noun theVerb 13) ; "On Crash's chest is a tattoo of a snake."
						else
							(gMessager say: noun theVerb 14) ; "Crash's shirt is closed."
						)
						(return 1)
					)
					(6 ; Open
						(if (IsFlag 322)
							(myShirt show:)
							(ClearFlag 322)
						else
							(if (not (IsFlag 323))
								(SetFlag 323)
								(gMessager say: 15 6 17) ; "(TO HIMSELF)That tattoo looks like Cazaunoux's bracelet."
							)
							(myShirt hide:)
							(SetFlag 322)
						)
						(return 1)
					)
					(9 ; Move
						(if (IsFlag 322)
							(myShirt show:)
							(ClearFlag 322)
						else
							(if (not (IsFlag 323))
								(SetFlag 323)
								(gMessager say: 15 6 17) ; "(TO HIMSELF)That tattoo looks like Cazaunoux's bracelet."
							)
							(myShirt hide:)
							(SetFlag 322)
						)
						(return 1)
					)
					(12 ; Pickup
						(if (IsFlag 322)
							(gMessager say: noun theVerb 13) ; "(RRCC)Gabriel can't take the tattoo with him that way."
						else
							(gMessager say: noun theVerb 14) ; "There's no point in doing that with the corpse."
						)
						(return 1)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)
)

(instance crashActions of Actions
	(properties)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(if (and (not local1) (not (IsFlag 74)))
				(gCurRoom setScript: sGabeSits 0 theVerb)
				(return 1)
			else
				(return 0)
			)
		else
			(switch theVerb
				(10 ; Ask
					(if (and (not local1) (not (IsFlag 74)))
						(gCurRoom setScript: sGabeSits 0 theVerb)
						(return 1)
					else
						(return 0)
					)
				)
				(11 ; Talk
					(if (and (not local1) (not (IsFlag 74)))
						(gCurRoom setScript: sGabeSits 0 theVerb)
						(return 1)
					else
						(return 0)
					)
				)
				(7 ; Look
					(if (and (IsFlag 74) (not local1))
						(gCurRoom setScript: sGabeSits 0 theVerb)
						(return 1)
					else
						(return 0)
					)
				)
				(else
					(return 0)
				)
			)
		)
	)
)

