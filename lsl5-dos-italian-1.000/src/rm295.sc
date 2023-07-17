;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 295)
(include sci.sh)
(use Main)
(use eRS)
(use Talker)
(use Polygon)
(use ForwardCounter)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm295 0
)

(local
	cameraFlasherCueCounter
	kidCueCounter
	videoCueCounter
	cameraManCueCounter
	fatReporterCueCounter
)

(procedure (Flash)
	(switch (Random 0 1)
		(0
			(flash posn: (Random 73 112) (Random 110 151))
		)
		(1
			(flash posn: (Random 192 248) (Random 95 137))
		)
	)
	(flash setCycle: End)
)

(instance rm295 of LLRoom
	(properties
		picture 290
	)

	(method (init)
		(gEgo
			init:
			normalize: 291
			setCycle: 0
			setLoop: 5
			setCel: 0
			posn: 152 94
			cycleSpeed: 10
		)
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 94 144 110 145 90 163 75 161 69 167 74 174 109 189 0 189 0 0 319 0 319 189 202 189 232 169 249 165 249 157 211 141 98 140
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 210 152 221 160 218 166 193 167 176 161 179 155 191 154
					yourself:
				)
		)
		(crowd init:)
		(phoneArm init:)
		(takePicRight init:)
		(girlReporter init:)
		(fatReporter init:)
		(videoCameraMan init:)
		(takePicRight init:)
		(lightLeft init: stopUpd:)
		(lightRight init: stopUpd:)
		(cameraFlasher init:)
		(cameraMan init:)
		(kid init:)
		(gAddToPics doit:)
		(Load rsPIC 1)
		(gTheMusic number: 294 flags: 1 setLoop: -1 play: 0 fade: 127 15 12 0)
		(SetFFRoom 460)
		(HandsOff)
		(self setScript: sJetWay)
	)
)

(instance sJetWay of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (IsObject flash) (not (Random 0 5)))
			(Flash)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(gEgo cycleSpeed: 9 setCycle: End self)
			)
			(2
				(TPrint 295 0 67 -1 28 108) ; "HIP, HIP,"
				(gEgo normalize: posn: 151 121 setHeading: 180)
				(= ticks 60)
			)
			(3
				(TPrint 295 1 67 -1 185 108) ; "HURRAY!!"
				(lightLeft setCycle: End)
				(lightRight setCycle: End)
				(kid cue:)
				(flash init:)
				(= ticks 30)
			)
			(4
				(lightLeft stopUpd:)
				(lightRight stopUpd:)
				(cameraMan cue:)
				(fatReporter cue:)
				(videoCameraMan cue:)
				(cameraFlasher cue:)
				(= ticks 70)
			)
			(5
				(TPrint 295 2 67 -1 185 70 280 108 self) ; "What's this? The now all-too-expected Chartreuse Carpet Lounge is filled with people, all here to celebrate the country's newest hero--Larry; Larry Laffer!"
			)
			(6
				(= ticks 60)
			)
			(7
				(TPrint 295 3 67 -1 28 108) ; "It's him!"
				(gEgo
					normalize:
					posn: 152 123
					loop: 2
					cycleSpeed: 7
					moveSpeed: 7
					setMotion: MoveTo 152 131 self
				)
			)
			(8
				(TPrint 295 4 67 -1 185 108) ; "It's Larry!"
				(gEgo setMotion: MoveTo 152 140 self)
			)
			(9
				(= ticks 90)
			)
			(10
				(TPrint 295 5 67 -1 28 108 self) ; "It's Larry Laffer!"
			)
			(11
				(= ticks 60)
			)
			(12
				(TPrint 295 6 67 -1 28 108 self) ; "HUZZAH!!"
			)
			(13
				(= ticks 30)
			)
			(14
				(TPrint 295 6 67 -1 28 108 self) ; "HUZZAH!!"
			)
			(15
				(= ticks 30)
			)
			(16
				(TPrint 295 7 67 -1 185 108 self) ; "HIP, HIP,"
			)
			(17
				(= ticks 30)
			)
			(18
				(TPrint 295 8 67 -1 185 108 self) ; "HURRAY!!"
			)
			(19
				(girlReporter setCycle: End self)
			)
			(20
				(= ticks 90)
			)
			(21
				(TPrint 295 9 67 -1 28 108 self) ; "So tell us, Mr. Laffer," asks a reporter, "how does it feel to save the lives of hundreds of people?"
			)
			(22
				(= ticks 30)
			)
			(23
				(TPrint 295 10 67 -1 185 108 self) ; "Another reporter chimes in, "Where did you learn to fly a commercial airliner?""
			)
			(24
				(= ticks 30)
			)
			(25
				(TPrint 295 11 67 -1 28 108 self) ; ""What is the secret of your amazing rescue technique?" asks a third."
			)
			(26
				(= ticks 30)
			)
			(27
				(TPrint 295 12 67 -1 185 108 self) ; "And will you earn extra Frequent Flyer credits?"
			)
			(28
				(= ticks 30)
			)
			(29
				(TPrint 295 13 67 -1 28 108 self) ; "Before you can answer any questions, you hear a telephone ring."
			)
			(30
				(= seconds 3)
			)
			(31
				(TPrint 295 14 67 -1 185 108 self) ; "Mr. Laffer! There's a telephone call for you!"
			)
			(32
				(= ticks 30)
			)
			(33
				(TPrint 295 15 67 -1 185 108 self) ; "For me?" you wonder. "No one knows I'm here."
			)
			(34
				(gEgo setMotion: MoveTo 160 170 self)
			)
			(35
				(TPrint 295 16 67 -1 185 108 self) ; "Here, take the phone," says the reporter. "It's the President of the United States!"
			)
			(36
				(= ticks 30)
			)
			(37
				(phoneArm setCycle: End self)
			)
			(38
				(gEgo
					view: 295
					setLoop: 2
					setCel: 0
					cycleSpeed: 10
					setCycle: CT 2 1 self
				)
			)
			(39
				(phoneArm dispose:)
				(gEgo setCycle: End self)
			)
			(40
				(gEgo setLoop: 3 cycleSpeed: 6)
				(self setScript: sTalk)
			)
			(41
				(TPrint 295 17 67 -1 15 70 280 108 self) ; "Well, Larry, things DID work out for you! Who would have thought that you would get a personal invitation from the President of the United States to attend a big State Dinner--especially one in your honor!"
			)
			(42
				(= ticks 30)
			)
			(43
				(TPrint 295 18 67 -1 185) ; "(You wonder if they'll have live music.)"
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 1 6)
				(gTheMusic fade: 0 15 12 1)
				(= seconds 3)
			)
			(44
				(TPrint 295 19) ; "And so it ends..."
				(TPrint 295 20) ; "The following Tuesday, our heroine patiently awaits her turn to perform at a White House dinner, while unbeknown to her, our hero approaches the doorway."
				(gCurRoom newRoom: 460)
			)
		)
	)
)

(instance sTalk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setCycle: ForwardCounter 2)
				(Say gEgo 295 21 67 -1 185 108 self) ; "Er, hello?"
			)
			(1
				(= ticks 30)
			)
			(2
				(gEgo setCycle: 0)
				(Say Mr__President 295 22 108 139 self) ; ""Hello, who is this?" asks the voice on the phone."
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo setCycle: ForwardCounter 5)
				(Say gEgo 295 23 67 -1 185 108 self) ; ""My name is Larry; Larry Laffer," you reply."
			)
			(5
				(= ticks 30)
			)
			(6
				(gEgo setCycle: 0)
				(Say Mr__President 295 24 108 139 self) ; "Well, Mr. Lafner, this is the President of the United States!"
			)
			(7
				(= ticks 30)
			)
			(8
				(Say Mr__President 295 25 108 139 self) ; "I just wanted to telephone to express the appreciation of this great nation to you, Larry Lasner, for the heroic deed you just accomplished!"
			)
			(9
				(= ticks 30)
			)
			(10
				(Say Mr__President 295 26 108 139 self) ; "(And, of course, take this opportunity to up my approval rating another few points. You know, it never hurts to be seen worldwide on CNN under these circumstances!)"
			)
			(11
				(= ticks 30)
			)
			(12
				(Say Mr__President 295 27 108 139 self) ; "Eh, um, anyway, what I mean is," he says, getting back on track, "You probably didn't know, but the Vice-President's Mommy was on that airplane you just saved."
			)
			(13
				(= ticks 30)
			)
			(14
				(Say Mr__President 295 28 108 139 self) ; "(By the way, he's still gaining the approval of the great American people; yes, gaining every month, little by little, getting better and better...)"
			)
			(15
				(= ticks 30)
			)
			(16
				(Say Mr__President 295 29 108 139 self) ; "Ah, in any case, he's so grateful that he wants me to host a big dinner in your honor here at the White House. He would have called you himself, but it's long distance."
			)
			(17
				(= ticks 30)
			)
			(18
				(Say Mr__President 295 30 108 139 self) ; "So, Lafter, do you think you could drop by the White House, oh, say, Tuesday next week for one of those typical Big National Hero Of The Week Dinners?"
			)
			(19
				(= ticks 30)
			)
			(20
				(gEgo setCycle: ForwardCounter 6)
				(Say gEgo 295 31 67 -1 185 108 self) ; "You are astonished. "But of course, sir," you reply, "I'll be there!""
			)
			(21
				(= ticks 30)
			)
			(22
				(gEgo setCycle: 0)
				(TPrint 295 32 67 -1 185 108 self) ; ""Do I have to bring a date?" you wonder."
			)
			(23
				(= ticks 30)
			)
			(24
				(gEgo setCycle: ForwardCounter 6)
				(Say gEgo 295 33 67 -1 185 108 self) ; "But to the President you say, "I really look forward to meeting you and the First Lady!""
			)
			(25
				(= ticks 30)
			)
			(26
				(gEgo setCycle: 0)
				(Say Mr__President 295 34 108 139 self) ; "Oh, sorry, Lasser," he says, "I'll be too busy fish, er, uh, MEETing with some important ambassadors or something, to attend. But I promise to send the Vice-President instead."
			)
			(27
				(= ticks 30)
			)
			(28
				(Say Mr__President 295 35 108 139 self) ; "Nice talking to you, Licker," he concludes. "Good job!"
			)
			(29
				(= ticks 30)
			)
			(30
				(Say Mr__President 295 36 108 139 self) ; "And, good bye."
			)
			(31
				(= ticks 30)
			)
			(32
				(TPrint 295 37 67 -1 185 108 self) ; "(Click.)"
			)
			(33
				(= ticks 30)
			)
			(34
				(gEgo setCycle: ForwardCounter 5)
				(Say gEgo 295 38 67 -1 185 108 self) ; "Good bye to you, Mr. Pres... oh, I guess you've hung up."
			)
			(35
				(= ticks 30)
			)
			(36
				(gEgo setCycle: 0)
				(client cue:)
			)
		)
	)
)

(instance videoCameraMan of Prop
	(properties
		x 116
		y 144
		view 297
		loop 2
		cel 8
		priority 13
		signal 16400
		cycleSpeed 13
	)

	(method (cue)
		(switch (++ videoCueCounter)
			(1
				(self setCycle: Beg self)
			)
			(2
				((Timer new:) setReal: self 5)
			)
			(3
				(self setCycle: End self)
			)
			(4
				(= videoCueCounter 0)
				((Timer new:) setReal: self (Random 5 7))
			)
		)
	)
)

(instance cameraFlasher of Prop
	(properties
		x 184
		y 129
		view 297
		loop 1
		priority 13
		signal 16400
	)

	(method (cue)
		(switch (++ cameraFlasherCueCounter)
			(1
				(self setCycle: End self)
			)
			(2
				(self setCel: 0)
				(self cue:)
			)
			(3
				(= cameraFlasherCueCounter 0)
				((Timer new:) setReal: self (Random 3 5))
			)
		)
	)
)

(instance cameraMan of Prop
	(properties
		x 117
		y 135
		view 297
		loop 3
		priority 13
		signal 16400
		cycleSpeed 10
	)

	(method (cue)
		(switch (++ cameraManCueCounter)
			(1
				(self setCycle: End self)
			)
			(2
				((Timer new:) setReal: self 2)
			)
			(3
				(self setCycle: Beg self)
			)
			(4
				(= cameraManCueCounter 0)
				((Timer new:) setReal: self (Random 2 3))
			)
		)
	)
)

(instance takePicRight of PicView
	(properties
		x 203
		y 135
		view 297
		loop 4
		priority 13
		signal 16401
	)
)

(instance fatReporter of Prop
	(properties
		x 197
		y 137
		view 297
		loop 5
		priority 13
		signal 16400
		cycleSpeed 15
	)

	(method (cue)
		(switch (++ fatReporterCueCounter)
			(1
				(self setCycle: End self)
			)
			(2
				(self setCycle: Beg self)
			)
			(3
				(= fatReporterCueCounter 0)
				((Timer new:) setReal: self (Random 2 4))
			)
		)
	)
)

(instance kid of Prop
	(properties
		x 179
		y 133
		view 297
		loop 6
		priority 13
		signal 16400
		cycleSpeed 10
	)

	(method (cue)
		(switch (++ kidCueCounter)
			(1
				(self setCycle: End self)
			)
			(2
				(self setCel: 0)
				(self cue:)
			)
			(3
				(self setCycle: End self)
			)
			(4
				(self setCel: 0)
				(self cue:)
			)
			(5
				(= kidCueCounter 0)
				((Timer new:) setReal: self (Random 2 4))
			)
		)
	)
)

(instance girlReporter of Prop
	(properties
		x 200
		y 163
		view 297
		loop 7
		priority 14
		signal 16401
		cycleSpeed 10
	)
)

(instance phoneArm of Prop
	(properties
		x 127
		y 154
		view 295
		priority 12
		signal 16401
		cycleSpeed 10
	)
)

(instance flash of Prop
	(properties
		view 295
		loop 1
		priority 14
		signal 16400
	)
)

(instance crowd of PicView
	(properties
		x 163
		y 159
		view 2000
		signal 16385
	)
)

(instance lightLeft of Prop
	(properties
		x 91
		y 77
		view 297
		loop 8
		priority 14
		signal 16
		cycleSpeed 10
	)
)

(instance lightRight of Prop
	(properties
		x 207
		y 76
		view 297
		loop 9
		priority 14
		signal 16
		cycleSpeed 10
	)
)

(instance Mr__President of Talker
	(properties
		name {Mr. President}
		nsTop 15
		nsLeft 35
		view 1295
		loop 3
		viewInPrint 1
	)

	(method (init)
		(= bust bushBust)
		(= eyes bushEyes)
		(= mouth bushMouth)
		(super init: &rest)
	)
)

(instance bushBust of Prop
	(properties
		view 1295
		loop 1
	)
)

(instance bushEyes of Prop
	(properties
		nsTop 28
		nsLeft 30
		view 1295
		loop 2
		cycleSpeed 70
	)
)

(instance bushMouth of Prop
	(properties
		nsTop 31
		nsLeft 24
		view 1295
		cycleSpeed 5
	)
)

