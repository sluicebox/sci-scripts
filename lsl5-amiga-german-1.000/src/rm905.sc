;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 905)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Interface)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Inventory)
(use User)
(use Actor)
(use System)

(public
	rm905 0
)

(local
	seenDoilyMsg
	talkedToGirl
	talkCounter
	usePhone
	cueCounter
	whoToTalkTo
	onPhone
	gotEvent
	returningFrom910
	windowTalkCount
	satDown
)

(procedure (NormalEgo theLoop)
	(if (not theLoop)
		(= theLoop -1)
	)
	(if (== ((Inv at: 22) state:) 1) ; Doily
		(gEgo setLoop: theLoop normalize: 908)
	else
		(gEgo setLoop: theLoop normalize: 550)
	)
)

(instance rm905 of LLRoom
	(properties
		picture 905
		east 910
		south 900
	)

	(method (init)
		(SetupExit 0)
		(SetFFRoom 0)
		(Load rsVIEW 907)
		(Load rsVIEW 908)
		(Load rsVIEW 906)
		(gEgo init: normalize:)
		(HandsOn)
		(switch gPrevRoomNum
			(900
				(self setScript: sEnterFromOutside)
			)
			(910
				(gEgo edgeHit: EDGE_NONE)
			)
			(915
				(door entranceTo: 915)
				(gEgo edgeHit: EDGE_NONE)
			)
			(else
				(= gLarryLoc 3)
				(gEgo posn: 172 160)
			)
		)
		(super init:)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 52 205 117 199 113 180 119 173 108 151 106 69 116 62 120 63 125 54 135 63 140 59 153 48 169 35 174 38 187 310 187 273 165 282 160 264 158 247 144 236 144 211 129 231 116 319 114 319 189 0 189 0 0 319 0
					yourself:
				)
		)
		(nurseWindow init: approachVerbs: 2 5 3) ; Look, Talk, Do
		(glass init: approachVerbs: 2 5 3 stopUpd:) ; Look, Talk, Do
		(if (not (IsFlag 4)) ; fSeenCC
			(girl init: stopUpd:)
		)
		(phone init: approachVerbs: 3 stopUpd:) ; Do
		(toothTable init: approachVerbs: 3 2) ; Do, Look
		(toothTable2 init: approachVerbs: 3 2) ; Do, Look
		(degrees init:)
		(rTable init: approachVerbs: 3) ; Do
		(lTable init: approachVerbs: 3) ; Do
		(lChair init: approachVerbs: 3) ; Do
		(rChair init:)
		(rChair2 init:)
		(pic2 init:)
		(palm init: approachVerbs: 3 2) ; Do, Look
		(palm2 init: approachVerbs: 3 2) ; Do, Look
		(lipPic init:)
		(magazines init: approachVerbs: 3 2 4) ; Do, Look, Inventory
		(thePhone init: approachVerbs: 3) ; Do
		(if (and (not (IsFlag 33)) (not (gEgo has: 22))) ; fUsedDoily, Doily
			(laceDoily init: stopUpd: approachVerbs: 3) ; Do
		)
		(door init:)
		(gTheMusic number: 905 setLoop: -1 play:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 0) ; "You are inside the waiting room of Doc Pulliam's Dental Hygiene Heaven. You love the carpet motif; in fact, you feel sure you seen something a lot like it before... somewhere."
			)
			(3 ; Do
				(if (OneOf (gEgo view:) 906 907)
					(TPrint 905 1) ; "There is nothing you need to do there."
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)

	(method (cue)
		(if returningFrom910
			(TPrint 905 2) ; "Your teeth feel so clean, you won't need to floss for a month!"
			(= returningFrom910 0)
			(HandsOn)
		else
			(NormalEgo 2)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((StepOn gEgo 2)
				(cond
					((== (gEgo view:) 550)
						(self setScript: sExitToOutside)
					)
					((not seenDoilyMsg)
						(= seenDoilyMsg 1)
						(TPrint 905 3) ; "You would be too embarrassed to walk outside with that silly doily wrapped around your head."
					)
				)
			)
			((StepOn gEgo 8)
				(= seenDoilyMsg 0)
			)
		)
	)

	(method (notify what)
		(= whoToTalkTo what)
	)
)

(instance magazines of Feature
	(properties
		x 54
		y 81
		nsTop 60
		nsLeft 41
		nsBottom 103
		nsRight 67
		description {the magazines}
		sightAngle 40
		approachX 62
		approachY 120
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Inventory
				(switch invItem
					(9 ; AeroDork_s_In-Flight_Magazine
						(TPrint 905 4) ; "Being totally bored with the AeroDork In-Flight Magazine, you shove it into Doc's magazine rack, where it is sure to delight and amaze his primarily Spanish-speaking customers."
						(gEgo put: 9) ; AeroDork_s_In-Flight_Magazine
						(SetFlag 52) ; fDumpedMagazine
					)
					(else
						(super doVerb: theVerb invItem &rest)
					)
				)
			)
			(2 ; Look
				(TPrint 905 5) ; "After glancing at a few of the magazines, you decide you have no interest in learning what the stock market will do in 1969!"
			)
			(3 ; Do
				(TPrint 905 6) ; "You have no desire to read magazines that are older than you."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance palm of Feature
	(properties
		x 17
		y 232
		z 100
		nsTop 75
		nsBottom 189
		nsRight 34
		description {the palm tree}
		sightAngle 40
		onMeCheck 4
		approachX 40
		approachY 184
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 7) ; "You wonder if that palm tree will ever require a "root canal?""
			)
			(3 ; Do
				(TPrint 905 8) ; "The palm tree feels rough to your touch."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance palm2 of Feature
	(properties
		x 184
		y 74
		nsTop 34
		nsLeft 163
		nsBottom 115
		nsRight 205
		sightAngle 40
		onMeCheck 4
		approachX 177
		approachY 117
	)

	(method (doVerb)
		(palm doVerb: &rest)
	)
)

(instance lipPic of Feature
	(properties
		x 14
		y 67
		nsTop 41
		nsBottom 93
		nsRight 28
		description {the painting}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 9) ; "You've always been a big fan of the "Happy Tooth School" of art."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance pic2 of Feature
	(properties
		x 277
		y 77
		nsTop 49
		nsLeft 257
		nsBottom 106
		nsRight 298
		description {the painting}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 10) ; "You've always been a big fan of the "Happy Tooth School" of art."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance degrees of Feature
	(properties
		x 314
		y 84
		nsTop 59
		nsLeft 310
		nsBottom 110
		nsRight 319
		description {Doc's diplomas}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 11) ; "Funny. You've never heard of a dentist specializing in "String and Doorknob" dentistry. And where exactly is the "School of Hard Knockers?""
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance toothTable of Feature
	(properties
		x 190
		y 97
		nsTop 82
		nsLeft 177
		nsBottom 113
		nsRight 203
		description {the table}
		sightAngle 40
		approachX 177
		approachY 117
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 12) ; "You can tell that Doc's wife decorated this place. She's suffering from terminal cuteness!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lChair of Feature
	(properties
		x 43
		y 137
		nsTop 100
		nsLeft 28
		nsBottom 134
		nsRight 59
		description {the chair}
		sightAngle 40
		approachX 62
		approachY 127
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 13) ; "This chair looks just right!"
			)
			(3 ; Do
				(gEgo setScript: sChair)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rChair of Feature
	(properties
		x 282
		y 135
		nsTop 112
		nsLeft 265
		nsBottom 159
		nsRight 300
		description {the chair}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 14) ; "This chair looks too hard."
			)
			(3 ; Do
				(TPrint 905 15) ; "You briefly consider sitting there, but decide that chair will be much too hard!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance rChair2 of Feature
	(properties
		x 246
		y 123
		nsTop 103
		nsLeft 225
		nsBottom 143
		nsRight 268
		description {the chair}
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 16) ; "This chair looks too soft."
			)
			(3 ; Do
				(TPrint 905 17) ; "You briefly consider sitting there, but decide that chair will be much too soft!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance lTable of Feature
	(properties
		x 32
		y 147
		nsTop 125
		nsLeft 15
		nsBottom 170
		nsRight 50
		description {the table}
		sightAngle 40
		approachX 59
		approachY 129
		lookStr {This table contains a telephone, placed here for the convenience of Doc's customers.}
	)

	(method (doVerb)
		(phone doVerb: &rest)
	)
)

(instance rTable of Feature
	(properties
		x 301
		y 159
		nsTop 141
		nsLeft 284
		nsBottom 177
		nsRight 319
		description {the table}
		sightAngle 40
		approachX 287
		approachY 159
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(if (gEgo has: 22) ; Doily
					(TPrint 905 18) ; "There's nothing left on this table since you took Doc's doily!"
				else
					(TPrint 905 19) ; "The only thing on this table is a long, lacy doily. It reminds you of those long runners your Grandmother had on her table."
				)
			)
			(3 ; Do
				(cond
					((gEgo has: 22) ; Doily
						(TPrint 905 20) ; "You've already taken the doily. You have no use for the table."
					)
					((OneOf (gEgo view:) 906 907)
						(gEgo setScript: sChair 0 self)
					)
					((IsObject laceDoily)
						(laceDoily doVerb: theVerb)
					)
				)
			)
			(4 ; Inventory
				(if (== invItem 22) ; Doily
					(TPrint 905 21) ; "Something inside tells you that you need the doily more than the table does."
				else
					(super doVerb: theVerb invItem)
				)
			)
		)
	)
)

(instance glass of Prop
	(properties
		x 115
		y 84
		approachX 134
		approachY 109
		view 905
		priority 6
		signal 18448
	)

	(method (doVerb)
		(nurseWindow doVerb: &rest)
	)
)

(instance girl of Prop
	(properties
		x 138
		y 75
		description {the receptionist}
		view 909
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 22) ; "You thought this might be the babe you've been searching for. Obviously, she's not. Not even you could consider this one sexy (and you know what low standards YOU have!)."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance phone of Prop
	(properties
		x 32
		y 156
		z 20
		nsTop 130
		nsLeft 24
		nsBottom 142
		nsRight 41
		description {the waiting room telephone}
		sightAngle 40
		approachX 59
		approachY 129
		view 905
		loop 2
		priority 11
		signal 18448
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 23) ; "The long table contains a telephone, placed here for the convenience of Doc's customers."
			)
			(3 ; Do
				(cond
					((OneOf (gEgo view:) 906 907)
						(if (== (gEgo loop:) 3)
							(sChair setScript: sHangUp)
						else
							(sChair cue:)
						)
					)
					((gCurRoom script:)
						(super doVerb: theVerb invItem &rest)
					)
					(else
						(HandsOff)
						(= usePhone 1)
						(gEgo view: 550)
						(gEgo setScript: sChair)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance Alberta of Talker
	(properties
		nsTop 33
		nsLeft 22
		view 1909
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust talkerBust)
		(= eyes talkerEyes)
		(= mouth talkerMouth)
		(super init:)
	)
)

(instance talkerBust of View
	(properties
		view 1909
		loop 1
	)
)

(instance talkerEyes of Prop
	(properties
		nsTop 35
		nsLeft 34
		view 1909
		loop 2
	)
)

(instance talkerMouth of Prop
	(properties
		nsTop 44
		nsLeft 33
		view 1909
	)
)

(instance sEnterFromOutside of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					posn: 163 237
					setHeading: 0
					setMotion: MoveTo 163 179 self
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance sExitToOutside of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gTheMusic fade:)
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 50) self
				)
			)
			(1
				(gCurRoom newRoom: 900)
			)
		)
	)
)

(instance sHangUp of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					setLoop: 3
					setCel: 255
					cycleSpeed: 6
					setCycle: Beg self
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 255)
				(HandsOn)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance sChair of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 2)
				((User curEvent:) type:)
				((User curEvent:) message:)
				(== (gTheIconBar curIcon:) (gTheIconBar at: 0))
				(or
					(== ((User curEvent:) message:) JOY_UP)
					(& ((User curEvent:) type:) $0040) ; direction
				)
			)
			(= gotEvent 1)
			(self init:)
		)
	)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (OneOf (gEgo view:) 906 907)
					(gEgo setLoop: 1 cycleSpeed: 6 setCycle: Beg self)
				else
					(gEgo sitting: 1)
					(= state 1)
					(if (== ((Inv at: 22) state:) 1) ; Doily
						(gEgo view: 907)
					else
						(gEgo view: 906)
					)
					(gEgo
						heading: 90
						setLoop: 1
						cycleSpeed: 6
						setCycle: End self
					)
					(palm approachVerbs: 0)
					(palm2 approachVerbs: 0)
					(magazines approachVerbs: 0)
					(nurseWindow approachVerbs: 0)
					(glass approachVerbs: 0)
					(laceDoily approachVerbs: 0)
					(rTable approachVerbs: 0)
					(phone approachVerbs: 0)
					(girl approachVerbs: 0)
					(door approachVerbs: 0)
				)
			)
			(1
				(palm approachVerbs: 3 2 4) ; Do, Look, Inventory
				(palm2 approachVerbs: 3 2 4) ; Do, Look, Inventory
				(magazines approachVerbs: 3 2 4) ; Do, Look, Inventory
				(nurseWindow approachVerbs: 3 5) ; Do, Talk
				(glass approachVerbs: 3 5) ; Do, Talk
				(laceDoily approachVerbs: 3) ; Do
				(rTable approachVerbs: 3) ; Do
				(phone approachVerbs: 3) ; Do
				(girl approachVerbs: 3) ; Do
				(door approachVerbs: 3 2 4) ; Do, Look, Inventory
				(NormalEgo 0)
				(HandsOn)
				(if (IsObject register)
					(WalkTo register 3)
				)
				(if gotEvent
					(= gotEvent 0)
					(gEgo
						setMotion:
							PolyPath
							((User curEvent:) x:)
							((User curEvent:) y:)
					)
				)
				(= register 0)
				(gEgo sitting: 0)
				(self dispose:)
			)
			(2
				(HandsOn)
				(gUser canControl: 0)
				(= register 0)
				(cond
					(usePhone
						(self setScript: sPhone)
					)
					((not satDown)
						(TPrint 905 24 #at -1 28 #dispose) ; "Ah! Good idea. This chair looks just right!"
					)
				)
				(= satDown 1)
			)
			(3
				(= state 1)
				(self setScript: sPhone)
				(= cycles 1)
			)
		)
	)
)

(instance sPhone of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(= onPhone 1)
				(if (== ((Inv at: 22) state:) 1) ; Doily
					(gEgo view: 907)
				else
					(gEgo view: 906)
				)
				(gEgo setLoop: 3 setCel: 0 cycleSpeed: 6 setCycle: End self)
			)
			(1
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				((ScriptID 20 0) init: 1 self) ; TTDialer
			)
			(2
				(= cycles 2)
			)
			(3
				(HandsOff)
				(switch whoToTalkTo
					(8544
						(TPrint 905 25) ; "Hello, North Beach Limousine Service."
						(Say gEgo 905 26) ; "This is Mr. Laffer," you say. "Would you please send my limousine over to Doc Pulliam's right away?"
						(cond
							((not (IsFlag 4)) ; fSeenCC
								(TPrint 905 27) ; "No, I'm sorry, Mr. Laffer. All of our drivers are on break right now. Could you call back again in a few minutes?"
							)
							((not (IsFlag 1)) ; fCalledLimo
								(SetFlag 1) ; fCalledLimo
								(TPrint 905 28) ; "Why, yes sir, Mr. Laffer. In fact, one of our drivers is in that vicinity right now. Just look outside. I bet you'll see her!"
							)
							(else
								(TPrint 905 29) ; "You again? Why don't you just go outside and get it?! She's waiting for you!"
							)
						)
					)
					(3627
						(if (not (SetFlag 18)) ; fCalledDoc
							(SetFlag 18) ; fCalledDoc
							(if (IsFlag 4) ; fSeenCC
								(Say Alberta 905 30 #dispose) ; "Good afternoon. You've reached Dr. Pulliam's exchange. I'm sorry, but everyone in their office has gone home for the evening. But please feel free to call back tomorrow. This has been a recording."
							else
								(TPrint 905 31) ; "Good afternoon. Dr. Pulliam's office."
								(Say gEgo 905 32) ; "Hello? This is, uh, umm, ah, Dr. `Payne.' I'm going to have to send over one of my emergency patients over for Doc Pulliam. Something's come up and I won't be able to see him this afternoon. Could you please see him right away? Thanks ever so much. Gotta go; it's tee time!"
							)
						else
							(TPrint 905 33) ; "You already did that."
						)
					)
					(-1
						(TPrint 905 34) ; "You change your mind and hang up the phone."
					)
					(else
						(TPrint 905 35) ; "Hmmm. Wrong number."
						(Say gEgo 905 36) ; ""Now where did I put that telephone number?" you ask yourself."
					)
				)
				(self setScript: sHangUp self)
			)
			(4
				(= onPhone 0)
				(= usePhone 0)
				(HandsOn)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance nurseWindow of Feature
	(properties
		x 112
		y 63
		nsTop 45
		nsLeft 71
		nsBottom 82
		nsRight 153
		description {the sliding glass window}
		sightAngle 40
		approachX 134
		approachY 109
	)

	(method (doVerb theVerb invItem)
		(cond
			((OneOf theVerb 3 5) ; Do, Talk
				(cond
					((OneOf (gEgo view:) 906 907)
						(if (== (gEgo loop:) 3)
							(TPrint 905 37) ; "First, hang up the phone."
						else
							(gEgo setScript: sChair 0 self)
						)
					)
					((IsFlag 4) ; fSeenCC
						(TPrint 905 38) ; "There is no answer from beyond the sliding glass windows. Either they're avoiding you, or they've all gone home."
					)
					((and (not (IsFlag 164)) (not talkedToGirl))
						(gCurRoom setScript: sWindow)
					)
					((== ((Inv at: 22) state:) 1) ; Doily
						(gCurRoom setScript: sWindow)
					)
					(else
						(TPrint 905 39) ; "Go away," a voice cries through the glass. "You already have an appointment. We'll see you then!"
					)
				)
			)
			((== theVerb 2) ; Look
				(TPrint 905 40) ; "Ghostly shapes seem to float on the other side of a set of frosted sliding glass windows. There must be someone working back there. On the window a small Dymo label reads, "Knock on window for service.""
			)
			((and (== theVerb 4) (== invItem 20)) ; Inventory, Doc_Pulliam_s_Card
				(TPrint 905 41) ; "Doc's office is already full of Doc's business cards."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance door of Door
	(properties
		x 234
		y 115
		description {the door}
		sightAngle 40
		approachX 194
		approachY 120
		view 905
		loop 3
		entranceTo 910
		locked 1
		openSnd 0
		closeSnd 0
		moveToX 250
		moveToY 108
		enterType 0
		exitType 0
	)

	(method (close)
		(super close:)
		(= returningFrom910 1)
		(Delay 3 2 gCurRoom)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 42) ; "This door leads to the inner offices of Doc Pulliam, including (you hope) the cubicle of Chi Chi Lambada, the woman you traveled all this way to "interview.""
			)
			(3 ; Do
				(if (OneOf (gEgo view:) 906 907)
					(gEgo setScript: sChair 0 self)
				else
					(super doVerb: theVerb invItem &rest)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sWindow of Script
	(properties)

	(method (changeState newState &tmp [temp0 2] [temp2 60])
		(switch (= state newState)
			(0
				(HandsOff)
				(if (== ((Inv at: 22) state:) 1) ; Doily
					(gEgo
						view: 907
						setLoop: 0
						cycleSpeed: 6
						setCycle: End self
					)
				else
					(gEgo
						view: 906
						setLoop: 0
						cycleSpeed: 6
						setCycle: End self
					)
				)
				(= cycles 2)
			)
			(1
				(gTheMusic2 number: 911 setLoop: 1 play:)
			)
			(2
				(NormalEgo 3)
				(TPrint 905 43 #dispose) ; "You rap your knuckles gently on the textured sliding glass window."
				(= ticks 90)
			)
			(3
				(gTheMusic2 number: 171 setLoop: -1 play:)
				(glass cycleSpeed: 12 setCycle: End self)
			)
			(4
				(gTheMusic2 stop:)
				(girl setCycle: Fwd)
				(= ticks 123)
			)
			(5
				(switch (++ windowTalkCount)
					(1
						(Say Alberta 905 44 #dispose #caller self) ; "Oh," she growls, "and just what do we think we're doing here, eh, little man?"
					)
					(else
						(Say Alberta 905 45 #dispose #caller self) ; "Yeah, what is it?"
					)
				)
				(if (or (IsFlag 18) (== (gEgo view:) 908)) ; fCalledDoc
					(= state 15)
				)
			)
			(6
				(switch windowTalkCount
					(1
						(Say gEgo 905 46) ; "Hello," you say in your most pleasant tone, "my name is Larry; Larry Laffer. I wonder if I might get an appointment with one of your dental hygienists?"
					)
					(else
						(Say gEgo 905 47) ; "Hello," you say to the receptionist. "I'd like an appointment to see one of your dental hygienists. I think I'm due for a little oral cavity work (if you know what I mean)."
					)
				)
				(= ticks 123)
			)
			(7
				(switch windowTalkCount
					(1
						(Say Alberta 905 48 #dispose #caller self) ; ""No!" she says, closing the window."
					)
					(else
						(= state 9)
						(= talkCounter 0)
						(Say Alberta 905 49 #dispose #caller self) ; "Yeah, maybe," she replies, "but first, let's do your paperwork."
					)
				)
			)
			(8
				(gTheMusic2 number: 171 setLoop: -1 play:)
				(glass setCycle: Beg self)
			)
			(9
				(gTheMusic2 stop:)
				(Say gEgo 905 50) ; ""Wait!" you cry, but it's too late."
				(= start (= register 0))
				(HandsOn)
				(NormalEgo 3)
				(self dispose:)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(TPrint 905 51) ; "And she grabs a large piece of paper, covered with tiny type."
				(= ticks 123)
			)
			(11
				(Say Alberta 905 52 #dispose #caller self) ; "Okay, sweetie, let's fill out this lil' ol' admission form together, now shall we?"
			)
			(12
				(girl setCel: 0)
				(Format @temp2 905 53 (++ talkCounter) talkCounter) ; "Question #%d"
				(switch talkCounter
					(0 0)
					(1
						(= register
							(Print ; "Do you have dental insurance?"
								905
								54
								#button
								{Yes}
								0
								#button
								{No}
								1
								#title
								@temp2
							)
						)
					)
					(2
						(= register
							(Print ; "Do you have LOTS of dental insurance?"
								905
								55
								#button
								{Yes}
								0
								#button
								{No}
								1
								#title
								@temp2
							)
						)
					)
					(3
						(= register
							(Print ; "Are your teeth overly sensitive?"
								905
								56
								#button
								{Yes}
								1
								#button
								{No}
								0
								#title
								@temp2
							)
						)
					)
					(4
						(= register
							(Print ; "Are you allergic to pain?"
								905
								57
								#button
								{Yes}
								1
								#button
								{No}
								0
								#title
								@temp2
							)
						)
					)
					(5
						(= register
							(Print ; "Do you ENJOY pain?"
								905
								58
								#button
								{Yes}
								0
								#button
								{No}
								1
								#title
								@temp2
							)
						)
					)
					(6
						(= register
							(Print ; "Do you enjoy sharing your pain with others?"
								905
								59
								#button
								{Yes}
								0
								#button
								{No}
								1
								#title
								@temp2
							)
						)
					)
					(7
						(= register
							(Print ; "Do you enjoy mechanical objects in your mouth?"
								905
								60
								#button
								{Yes}
								0
								#button
								{No}
								1
								#title
								@temp2
							)
						)
					)
					(8
						(= register
							(Print ; "Do you enjoy other people's hands in your mouth?"
								905
								61
								#button
								{Yes}
								0
								#button
								{No}
								1
								#title
								@temp2
							)
						)
					)
					(9
						(= register
							(Print ; "Do you enjoy rubber in your mouth?"
								905
								62
								#button
								{Yes}
								0
								#button
								{No}
								1
								#title
								@temp2
							)
						)
					)
					(10
						(= register
							(Print ; "Do you swallow?"
								905
								63
								#button
								{Yes}
								0
								#button
								{No}
								1
								#title
								@temp2
							)
						)
					)
					(11
						(= register
							(Print ; "Have you ever even heard of AIDS?"
								905
								64
								#button
								{Yes}
								1
								#button
								{No}
								0
								#title
								@temp2
							)
						)
					)
					(12
						(= register
							(Print ; "Do you know anyone who has ever hired a lawyer?"
								905
								65
								#button
								{Yes}
								1
								#button
								{No}
								0
								#title
								@temp2
							)
						)
					)
					(13
						(= register
							(Print ; "Do you know the definition of `malpractice?'"
								905
								66
								#button
								{Yes}
								1
								#button
								{No}
								0
								#title
								@temp2
							)
						)
					)
					(14
						(Points 13 164)
						(= state 17)
						(= talkedToGirl 1)
						(Say Alberta 905 67 #dispose) ; "Since this is not an emergency, I'll go ahead and set you up with an appointment for, uh, let's see... how about nine months from today? Ten o'clock is good for me!"
					)
				)
				(cond
					(register
						(girl setCycle: Fwd)
					)
					((< talkCounter 14)
						(-- state)
					)
				)
				(= ticks 123)
			)
			(13
				(Say Alberta 905 68 #dispose #caller self) ; "Oops! Well, gosh, I'm sorry, but I just realized we'll be unable to accept you as a client. I just remembered... we have no more openings this century!"
			)
			(14
				(glass cycleSpeed: 4 setCycle: Beg self)
				(gTheMusic2 number: 171 setLoop: -1 play:)
			)
			(15
				(gTheMusic2 stop:)
				(TPrint 905 50) ; ""Wait!" you cry, but it's too late."
				(= start (= register 0))
				(HandsOn)
				(NormalEgo 3)
				(self dispose:)
			)
			(16
				(girl setCel: 0)
				(cond
					((== (gEgo view:) 908)
						(Say gEgo 905 69) ; "Hepowafww, mmapwffoj," you mumble with your jaw tied shut, while you pretend to be unable to speak, "maywppf asqd waf ffvppf?"
						(Points 17 162)
						(SetFlag 33) ; fUsedDoily
						(Say Alberta 905 70 #dispose #caller self) ; "Oh, you poor dear! You look like you're in terrible pain! Why, just go right on in. I'll have one of our technicians attend to you right away!"
					)
					((IsFlag 18) ; fCalledDoc
						(Say gEgo 905 71) ; "Excuse me, ma'am," you say, hoping she doesn't recognize your voice. "My name is Larry; Larry Laffer."
						(Points 13 163)
						(Say Alberta 905 72 #dispose #caller self) ; "Well, Larry, that was a quick trip! Please, just walk through the door to the right! I'll have one of our technicians attend to you right away!"
					)
				)
			)
			(17
				(SetFlag 4) ; fSeenCC
				(gTheMusic fade: 0 5 1 1)
				(NormalEgo 3)
				(door setPri: 8 locked: 0 open:)
			)
			(18
				(gTheMusic2 number: 171 setLoop: 1 play:)
				(glass cycleSpeed: 12 setCycle: Beg self)
			)
			(19
				(glass stopUpd:)
				(HandsOn)
				(NormalEgo 3)
				(self dispose:)
			)
		)
	)
)

(instance laceDoily of Prop
	(properties
		x 307
		y 160
		nsTop 144
		nsLeft 20
		nsBottom 157
		nsRight 37
		description {the doily}
		sightAngle 40
		approachX 287
		approachY 159
		view 905
		loop 1
		priority 13
		signal 26640
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 19) ; "The only thing on this table is a long, lacy doily. It reminds you of those long runners your Grandmother had on her table."
			)
			(3 ; Do
				(cond
					((OneOf (gEgo view:) 906 907)
						(gEgo setScript: sChair 0 self)
					)
					((not (gEgo has: 22)) ; Doily
						(HandsOff)
						(gCurRoom setScript: sGetDoily)
					)
					(else
						(TPrint 905 73) ; "There is nothing here."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance legs of View
	(properties
		view 906
		loop 4
		priority 12
		signal 18448
	)
)

(instance thePhone of Feature
	(properties
		x 31
		y 331
		z 200
		nsTop 126
		nsLeft 25
		nsBottom 137
		nsRight 38
		description {the phone}
		sightAngle 40
		approachX 62
		approachY 127
	)

	(method (doVerb)
		(phone doVerb: &rest)
	)
)

(instance toothTable2 of Feature
	(properties
		x 19
		y 379
		z 200
		nsTop 170
		nsBottom 189
		nsRight 39
		description {the table}
		sightAngle 40
		approachX 47
		approachY 183
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(2 ; Look
				(TPrint 905 12) ; "You can tell that Doc's wife decorated this place. She's suffering from terminal cuteness!"
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance sGetDoily of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setHeading: 125 self)
			)
			(1
				(legs init: posn: 287 159)
				(gEgo
					view: 906
					setLoop: 4
					setCel: 1
					cycleSpeed: 8
					posn: 286 159
					setPri: 13
					setCycle: End self
				)
			)
			(2
				(laceDoily dispose:)
				(= cycles 2)
			)
			(3
				(rTable approachVerbs: 0)
				(Points 5 161)
				(legs dispose:)
				(NormalEgo 4)
				(gEgo setPri: -1 get: 22) ; Doily
				(= ticks 10)
			)
			(4
				(TPrint 905 74 #dispose self) ; "You take the lace doily from the waiting room table, but you really don't know why."
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

