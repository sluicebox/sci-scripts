;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use n001)
(use HandsOffScript)
(use Talker)
(use Full)
(use Interface)
(use Feature)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm380 0
)

(local
	theQuestion
	guardsUp
	[gateMsg 5] = [{By order of Khaveen, you are not allowed to leave the city without showing your visa, yellow-haired dog. } {By order of Khaveen, foreign dog, you are not allowed to leave.__Let me see your visa. } {By order of Khaveen, Infidel of Shapeir, you may not pass through these gates unless I see your visa. } {By order of Khaveen, you who come to this city unbidden may not leave as easily as you arrived.__Show me your visa. } {By order of Khaveen, you dog, you may not pass without showing your visa. }]
	gateCount
	nightTimer
	triedOnce
	rm380HowFast
	oneChance
	[str 100]
)

(instance rm380 of Rm
	(properties
		picture 300
		style 6
	)

	(method (dispose)
		(= global61 0)
		(super dispose:)
	)

	(method (init)
		(SetFlag 100) ; fRaseir
		(Load rsVIEW 0 4 465 385 382 383 380 410 450)
		(Load rsSCRIPT 78)
		(if gNight
			(= global61 3)
		else
			(= global61 2)
		)
		(= rm380HowFast gHowFast)
		(bpiDoor init: stopUpd:)
		(super init:)
		(self overlay: gCurRoomNum)
		(= gSpellChecker gNoChecker)
		(cond
			((and (== gPrevRoomNum 360) (>= gDay 29))
				(guard4 init:)
				(guard5 init:)
				(guard6 init: setScript: toTheDungeon)
				(gEgo setScript: fromBlueParrot)
			)
			((== gPrevRoomNum 360)
				(gEgo setScript: fromBlueParrot)
			)
			((== gPrevRoomNum 880) ; cityRoom
				(= gEgoGait 0) ; walking
				(NormalEgo)
				(gEgo setScript: backAgain)
			)
			((and (== gPrevRoomNum 872) (not (IsFlag 134))) ; f1stTimeRaseir
				(khaveen init: stopUpd:)
				(kMouth
					init:
					posn: (+ (khaveen x:) 2) (- (khaveen y:) 43)
					hide:
				)
				(if (> rm380HowFast 0)
					(guard3 init:)
				)
				(self setScript: comeIn)
			)
			((or (== gPrevRoomNum 703) (IsFlag 28)) ; alleyRas, fTeleporting
				(gEgo loop: 2 posn: 160 80 init: setMotion: MoveTo 160 100)
			)
		)
		(if
			(and
				(> gTimeODay 4)
				(!= gPrevRoomNum 872)
				(!= gDay 28)
				(not (gEgo has: 47)) ; Bird
			)
			(guard7 init:)
		)
		(if (== gPrevRoomNum 872)
			(guard1 posn: 80 170 loop: 0 init:)
			(guard2 posn: 230 170 loop: 1 init:)
		else
			(guard1 posn: 113 186 loop: 3 illegalBits: 0 init:)
			(guard2 posn: 203 186 loop: 3 illegalBits: 0 init:)
		)
		(InitAddToPics bpiSign lWindow lShadow rShadow rBlock lBlock)
		(InitFeatures topAlleyDoor)
	)

	(method (doit)
		(if (and (> (gEgo y:) 189) (not script) (not (gEgo script:)))
			(gEgo setScript: getTheHellOuttaDodge)
		)
		(if (< (gEgo y:) 80)
			(= gRoomExitDir 3)
			(gCurRoom newRoom: 703) ; alleyRas
		)
		(if (and (gEgo inRect: 216 103 273 123) (not (gEgo script:)))
			(gEgo setScript: toParrot)
		)
		(if
			(and
				(gEgo inRect: 119 170 220 190)
				(not guardsUp)
				(not (gEgo script:))
				(not script)
				(IsFlag 134) ; f1stTimeRaseir
			)
			(= guardsUp 1)
			(guard1 setScript: gateBlock)
		)
		(if (and (not (gEgo inRect: 110 170 230 190)) guardsUp)
			(= guardsUp 0)
			(if (> (guard1 x:) 120)
				(guard2 setScript: atEase)
			)
		)
		(if (and nightTimer (not (-- nightTimer)))
			(EgoDead 1 380 0) ; "The guards start to yell for reinforcements, and before you know it, you are surrounded and overwhelmed. They drag you to the dungeons of Raseir for a most unpleasant stay."
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'ask')
				(HighPrint 380 1 80 {Guard:}) ; "You are not permitted to ask questions in Raseir."
			)
			((Said 'attack')
				(HighPrint 380 2) ; "You will only succeed in attracting more guards."
			)
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(if (IsFlag 134) ; f1stTimeRaseir
					(HighPrint 380 3) ; "It remains a dismal sight."
				else
					(HighPrint 380 4) ; "This first view of the city does not impress you. The people of this city seem to have little civic pride. The walls are grey from smoke and dirt, and the plaster is chipping off."
				)
			)
			((Said 'look,look<up')
				(if (> gTimeODay 4)
					(LowPrint 380 5) ; "The Raseirian sky is ablaze with stars."
				else
					(LowPrint 380 6) ; "The sky is so bright that it hurts your eyes."
				)
			)
			((Said 'look,look<down')
				(HighPrint 380 7) ; "The plaza could use a good sweeping."
			)
		)
	)
)

(instance khaveen of Actor
	(properties
		x 141
		y 149
		noun '/khaveen'
		description {Khaveen}
		lookStr {It is Khaveen, Captain of the Raseirian Guard.}
		view 385
	)
)

(instance kMouth of Talker
	(properties
		view 385
		loop 5
		signal 26640
		illegalBits 0
		tLoop 5
		talkSpeed 0
		myName '//khaveen,man'
		title {Khaveen:}
		back 11
	)

	(method (messages)
		(self show:)
		(super messages: &rest)
	)

	(method (endTalk)
		(self setCycle: End)
		(super endTalk:)
	)

	(method (showText)
		(HighPrint 380 8 80 {Khaveen:} 103 35 aWin) ; "I will ask the questions around here. Learn your place!"
	)
)

(instance guard1 of Actor
	(properties
		noun '/guard'
		description {the Raseirian guard}
		lookStr {The guards of this city look like well-disciplined, tough fighters.}
		view 382
	)
)

(instance guard2 of Actor
	(properties
		noun '/guard'
		description {the Raseirian guard}
		lookStr {The guards of this city look like well-disciplined, tough fighters.}
		view 382
		loop 1
	)
)

(instance guard3 of Actor
	(properties
		x 187
		y 149
		noun '/guard'
		description {the Raseirian guard}
		lookStr {The guards of this city look like well-disciplined, tough fighters.}
		view 382
		loop 2
	)
)

(instance guard4 of Actor
	(properties
		x 222
		y 99
		noun '/guard'
		description {the Raseirian guard}
		lookStr {The guards of this city look like well-disciplined, tough fighters.}
		view 383
		loop 6
		signal 16384
		illegalBits 0
	)
)

(instance guard5 of Actor
	(properties
		x 261
		y 130
		noun '/guard'
		description {the Raseirian guard}
		lookStr {The guards of this city look like well-disciplined, tough fighters.}
		view 383
		loop 8
		signal 16384
		illegalBits 0
	)
)

(instance guard6 of Actor
	(properties
		x 162
		y 98
		noun '/guard'
		description {the Raseirian guard}
		lookStr {The guards of this city look like well-disciplined, tough fighters.}
		view 383
		loop 5
		signal 16384
		illegalBits 0
	)
)

(instance guard7 of Actor
	(properties
		x 120
		y 120
		description {the Raseirian guard}
		lookStr {The guards of this city look like well-disciplined, tough fighters.}
		view 382
		loop 6
		cel 2
	)

	(method (init)
		(self setCycle: Walk setMotion: MoveTo 125 115 self)
		(super init:)
	)

	(method (cue)
		(self view: 383 loop: 7)
		(cond
			((and (== gDay 27) (not oneChance))
				(= oneChance 1)
				(self setScript: backToInn)
			)
			((== gPrevRoomNum 360)
				(LowPrint 380 9) ; "It is forbidden for anyone to be out at night. Return to the inn."
				(= nightTimer 15)
			)
			(else
				(LowPrint 380 10) ; "You there! Halt! It is forbidden for you to be out at night. You are guilty of breaking the law of Raseir."
				(= nightTimer 15)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'make,give,show/sign[<thief]')
				(MakeSign)
				(= nightTimer 0)
				(HighPrint 380 11 103 25 4) ; "The guard looks down, then turns aside and ignores you."
				(self setLoop: 1)
			)
			((Said 'run')
				(= gEgoGait 1) ; running
				(self mover: 0)
				(gEgo setScript: runningMan)
			)
		)
	)
)

(instance bpiDoor of Prop
	(properties
		x 252
		y 117
		noun '/door[<hotel]'
		description {the door to the Blue Parrot Inn}
		lookStr {If the sign is correct, this is the stained and dirty door to the Blue Parrot Inn.}
		view 380
		priority 2
		signal 16
	)
)

(instance bpiSign of PicView
	(properties
		x 252
		y 54
		noun '/sign[<hotel]'
		description {the sign of the Blue Parrot Inn}
		lookStr {The paint on the sign is starting to chip, but it seems to indicate that this is the Blue Parrot Inn.}
		view 380
		loop 1
		priority 10
		signal 16
	)
)

(instance lWindow of PicView
	(properties
		x 74
		y 53
		noun '/window'
		description {the window.}
		lookStr {The windows are securely barred.}
		view 450
		loop 2
		cel 1
		priority 14
		signal 16
	)

	(method (init)
		(if gNight
			(= palette 2)
		else
			(= palette 1)
		)
		(super init:)
	)
)

(instance lShadow of PicView
	(properties
		x 267
		y 189
		shiftClick 0
		view 380
		loop 1
		cel 2
		priority 0
		signal 16400
	)
)

(instance rShadow of PicView
	(properties
		x 50
		y 189
		shiftClick 0
		view 380
		loop 1
		cel 2
		priority 0
		signal 16400
	)
)

(instance rBlock of PicView
	(properties
		x 308
		y 164
		view 460
		loop 3
		priority 8
		signal 16400
	)

	(method (init)
		(if gNight
			(= palette 2)
		else
			(= palette 1)
		)
	)
)

(instance lBlock of PicView
	(properties
		x 4
		y 173
		view 460
		loop 4
		priority 8
		signal 16400
	)

	(method (init)
		(if gNight
			(= palette 2)
		else
			(= palette 1)
		)
	)
)

(instance comeIn of Script
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((< state 7)
				(event claimed: 1)
				(HighPrint 380 12) ; "There's no time for that."
			)
			((Said 'no')
				(if (!= (khaveen loop:) 3)
					(HighPrint 380 13 80 {Khaveen:} 35 aWin) ; "Oh, a wise guy, eh?"
				)
			)
			((Said 'yes')
				(++ theQuestion)
				(if seconds
					(= seconds 0)
					(self cue:)
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCSound number: 380 loop: -1 priority: 0 playBed:)
				(DontMove 1)
				(= cycles 1)
			)
			(1
				(gEgo posn: 159 230 init: setMotion: MoveTo 159 172)
				(guard1 setCycle: Walk setMotion: MoveTo 135 170)
				(guard2 setCycle: Walk setMotion: MoveTo 180 170 self)
			)
			(2
				(guard1 view: 383 loop: 2 cel: 0 setCycle: End)
				(guard2 view: 383 loop: 3 cel: 0 setCycle: End self)
			)
			(3
				(guard1 stopUpd:)
				(guard2 stopUpd:)
				(khaveen setCycle: End)
				(kMouth setPri: (+ (khaveen priority:) 1))
				(= seconds 3)
			)
			(4
				(Say kMouth self 380 14) ; "Stay where you are stranger, or you'll discover how sharp a weapon can be."
			)
			(5
				(gEgo loop: 7)
				(khaveen
					view: 465
					setLoop: 4
					cel: 0
					setCycle: Walk
					ignoreActors:
					illegalBits: 0
					setMotion:
						MoveTo
						(- (gEgo x:) 2)
						(- (gEgo y:) 10)
						self
				)
			)
			(6
				(khaveen view: 385 loop: 2 cel: 0)
				(gEgo loop: 3)
				(kMouth posn: (+ (khaveen x:) 1) (- (khaveen y:) 43) setPri: 15)
				(= cycles 2)
			)
			(7
				(Say kMouth self 380 15) ; "So you are the one they call the Hero of Shapeir. Well, understand this: We don't need no stinking Heroes around here. Do I make myself clear?"
			)
			(8
				(DontTalk 0)
				(= seconds 3)
			)
			(9
				(DontTalk 1)
				(if (>= theQuestion 1)
					(self changeState: 15)
				else
					(khaveen setCycle: Full 1 self)
					(gEgo
						view: 385
						loop: 4
						cel: 0
						cycleSpeed: 1
						setCycle: End
					)
					(= theQuestion 1)
				)
			)
			(10
				(gEgo view: 4 setLoop: 3)
				(kMouth setPri: (+ (khaveen priority:) 1))
				(Say kMouth self 380 16) ; "Do I make myself clear?"
			)
			(11
				(DontTalk 0)
				(= seconds 3)
			)
			(12
				(DontTalk 1)
				(if (>= theQuestion 2)
					(self changeState: 15)
				else
					(khaveen setCycle: Full 1 self)
					(gEgo
						view: 385
						loop: 4
						cel: 0
						cycleSpeed: 1
						setCycle: End
					)
				)
			)
			(13
				(gEgo view: 4 setLoop: 3)
				(kMouth setPri: (+ (khaveen priority:) 1))
				(Say kMouth self 380 17) ; "Stubborn,aren't you? Well, perhaps some time spent in prison would teach you some manners. To avoid prison in Raseir, you must learn to obey orders."
			)
			(14
				(DontTalk 0)
				(= seconds 2)
			)
			(15
				(kMouth setPri: (+ (khaveen priority:) 1))
				(Say kMouth self 380 18) ; "See that you obey all the rules posted around town. Rule number one: Strangers must always carry their Visa. Do you have your Visa?"
			)
			(16
				(khaveen setCycle: Full 1 self)
				(gEgo view: 385 loop: 4 cel: 0 cycleSpeed: 1 setCycle: End)
			)
			(17
				(gEgo view: 4 setLoop: 3)
				(kMouth setPri: (+ (khaveen priority:) 1))
				(Say kMouth self 380 19) ; "Already breaking the rules, are you?"
			)
			(18
				(khaveen loop: 3 cel: 0 setCycle: End self)
			)
			(19
				(kMouth posn: 159 122 setPri: 15)
				(Say kMouth self 380 20) ; "Here is your Visa. Don't leave town without it."
			)
			(20
				(gEgo get: 41) ; Visa
				(guard1 setCycle: Beg)
				(guard2 setCycle: Beg self)
			)
			(21
				(guard1 stopUpd:)
				(guard2 stopUpd:)
				(khaveen
					view: 465
					illegalBits: 0
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 167 39 self
				)
				(kMouth dispose:)
				(if (> rm380HowFast 0)
					(guard3
						illegalBits: 0
						setCycle: Walk
						setMotion: MoveTo 147 41
					)
				)
			)
			(22
				(khaveen dispose:)
				(NormalEgo)
				(guard1
					view: 382
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 113 189
				)
				(guard2
					view: 382
					illegalBits: 0
					setCycle: Walk
					setMotion: MoveTo 203 189 self
				)
			)
			(23
				(guard1 setLoop: 3)
				(guard2 setLoop: 3)
				(gEgo setMotion: MoveTo 159 169 self)
				(if (> rm380HowFast 0)
					(guard3 dispose:)
				)
			)
			(24
				(SetFlag 134) ; f1stTimeRaseir
				(gCSound fade:)
				(DontMove 0)
				(DontTalk 0)
				(self dispose:)
			)
		)
	)
)

(instance gateBlock of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontMove 1 1)
				(gEgo setMotion: 0)
				(guard1
					view: 382
					illegalBits: 0
					ignoreActors: 1
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 134 188
				)
				(guard2
					view: 382
					illegalBits: 0
					ignoreActors: 1
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 184 188 self
				)
			)
			(1
				(DontTalk 1)
				(guard1
					illegalBits: -32768
					view: 383
					loop: 2
					cel: 0
					setCycle: End
				)
				(guard2
					illegalBits: -32768
					view: 383
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(2
				(if (and triedOnce (not (gEgo has: 41))) ; Visa
					(HighPrint 380 21 80 {Gate Guard:}) ; "No one without papers is allowed to pass!"
					(guard1 ignoreActors: 0)
					(guard2 ignoreActors: 0)
					(HandsOn)
					(self dispose:)
				else
					(HighPrint
						(Format @str 380 22 [gateMsg gateCount]) ; "%s"
						80
						{Gate Guard:}
					)
					(if (< gateCount 4)
						(++ gateCount)
					else
						(= gateCount 0)
					)
					(= cycles 2)
				)
			)
			(3
				(gEgo
					illegalBits: 0
					ignoreActors:
					setMotion: MoveTo 147 186 self
				)
			)
			(4
				(gEgo setHeading: 225 self)
			)
			(5
				(cond
					((== gDay 28)
						(HighPrint 380 23 80 {Gate Guard:}) ; "No one is permitted to leave the city today without Letters of Envoy, by order of Khaveen."
					)
					((gEgo has: 41) ; Visa
						(HighPrint 380 24 80 {Gate Guard:}) ; "Your papers are in order. You may pass."
						(guard2 setScript: atEase)
					)
					(else
						(HighPrint 380 25 80 {Gate Guard:}) ; "You have no Visa? Then you may not pass!"
						(= triedOnce 1)
					)
				)
				(gEgo ignoreActors: 0 illegalBits: -32768)
				(= cycles 2)
			)
			(6
				(guard1 ignoreActors: 0)
				(guard2 ignoreActors: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance atEase of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(DontMove 1)
				(guard1 view: 383 loop: 2 setCycle: Beg)
				(guard2 view: 383 loop: 3 setCycle: Beg self)
				(guard1 ignoreActors: 0)
				(guard2 ignoreActors: 0)
			)
			(1
				(DontMove 0)
				(guard1 setLoop: 1 cel: 0)
				(guard2 setLoop: 0 cel: 0)
				(= cycles 2)
			)
			(2
				(guard1
					illegalBits: 0
					view: 382
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 113 189 self
				)
				(guard2
					illegalBits: 0
					view: 382
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 203 189
				)
			)
			(3
				(guard1 setLoop: 3 cel: 0)
				(guard2 setLoop: 3 cel: 0)
				(self dispose:)
			)
		)
	)
)

(instance toParrot of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bpiDoor setCel: 1)
				(gEgo setPri: 6 setMotion: MoveTo 270 112 self)
			)
			(1
				(gCurRoom newRoom: 360)
				(self dispose:)
			)
		)
	)
)

(instance fromBlueParrot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(bpiDoor setCel: 1)
				(gEgo
					setPri: 6
					loop: 1
					illegalBits: 0
					signal: 16384
					posn: 253 112
					init:
					setCycle: Walk
					setMotion: MoveTo 210 112 self
				)
			)
			(1
				(bpiDoor setCel: 0)
				(NormalEgo)
				(= cycles 1)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance toTheDungeon of HandsOffScript
	(properties)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((Said 'cast')
				(HighPrint 380 26) ; "It is too late for that, hero, you're outnumbered."
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(guard4
					view: 382
					loop: 5
					setCycle: Walk
					setMotion: MoveTo 222 111
				)
				(guard5
					view: 382
					loop: 7
					setCycle: Walk
					setMotion: MoveTo 238 117 self
				)
			)
			(2
				(guard4 setLoop: 1)
				(guard5 setLoop: 1)
				(= cycles 4)
			)
			(3
				(HighPrint 380 27 80 {Guard:}) ; "You are under arrest for breaking the law of Raseir on this day, the 29th of the Serpent, Year of the Djinn. Come quietly, or you will be taken by force."
				(= cycles 4)
			)
			(4
				(HighPrint 380 28) ; "You briefly consider struggling with the guards, but realize that there are just too many of them."
				(guard6 view: 382 loop: 3)
				(= cycles 4)
			)
			(5
				(guard6 setCycle: Walk setMotion: MoveTo 159 40)
				(guard4 setCycle: Walk setMotion: MoveTo 159 111)
				(guard5 setCycle: Walk setMotion: MoveTo 159 117)
				(gEgo setMotion: MoveTo 159 114)
				(= seconds 2)
			)
			(6
				(gCurRoom drawPic: 2)
				(bpiDoor dispose:)
				(guard1 dispose:)
				(guard2 dispose:)
				(guard4 dispose:)
				(guard5 dispose:)
				(guard6 hide:)
				(gEgo hide:)
				(= seconds 2)
			)
			(7
				(Print 380 29) ; "You follow the guard through the dark streets, past the gates of the palace, and into the dungeon of Raseir."
				(gCurRoom newRoom: 440)
				(self dispose:)
			)
		)
	)
)

(instance runningMan of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 159 100 self)
				(HighPrint 380 30 80 {Guard:} 103 70 280) ; "Guards!! There is an intruder in the Gate Plaza. To me!!!"
			)
			(1
				(gEgo setMotion: MoveTo 159 75 self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance backAgain of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo posn: 160 220 init:)
				(guard1 view: 382)
				(guard2 view: 382)
				(= cycles 2)
			)
			(1
				(gEgo setMotion: MoveTo 160 187)
				(guard1 setLoop: 0 setCycle: Walk setMotion: MoveTo 134 184)
				(guard2
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo 184 184 self
				)
			)
			(2
				(guard1
					illegalBits: -32768
					view: 383
					loop: 2
					cel: 0
					setCycle: End
				)
				(guard2
					illegalBits: -32768
					view: 383
					loop: 3
					cel: 0
					setCycle: End self
				)
			)
			(3
				(HighPrint 380 31 80 {Guard:}) ; "Kuwait a minute. Visa please!"
				(= cycles 5)
			)
			(4
				(if (not (gEgo has: 41)) ; Visa
					(HighPrint 380 32) ; "You realize that you have left your Visa in the desert, so you improvise."
				)
				(gEgo setMotion: MoveTo 147 188)
				(= cycles 20)
			)
			(5
				(if (gEgo has: 41) ; Visa
					(HighPrint 380 33 80 {Guard:}) ; "Your papers are in order. By order of Khaveen, you must have a pleasant stay."
					(= cycles 2)
				else
					(HighPrint 380 34 80 {Guard:}) ; "What's this? We don't take Dinar's Club here."
					(HighPrint 380 35) ; "You are turned back into the desert."
					(gCurRoom newRoom: 880) ; cityRoom
					(self dispose:)
				)
			)
			(6
				(guard2 setScript: atEase)
				(= seconds 3)
			)
			(7
				(gEgo setMotion: MoveTo 160 169 self)
			)
			(8
				(if (and (not (<= 0 gTimeODay 4)) (== gDay 27))
					(gCurRoom setScript: backToInn)
				)
				(self dispose:)
			)
		)
	)
)

(instance getTheHellOuttaDodge of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 230 self)
			)
			(1
				(gCurRoom newRoom: 880) ; cityRoom
			)
		)
	)
)

(instance backToInn of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (gEgo x:) 106 self)
			)
			(1
				(HighPrint 380 36 80 {Guard:}) ; "Do you not know it is forbidden to be out after dark in Raseir? Show me your visa."
				(= cycles 2)
			)
			(2
				(if (gEgo has: 41) ; Visa
					(HighPrint 380 37) ; "You show the guard your visa."
					(= cycles 2)
				else
					(EgoDead 1 380 38 #title {Get a life - Get a visa}) ; "Caught without your visa, you are hauled off to prison for a long, long stay."
					(self dispose:)
				)
			)
			(3
				(HighPrint 380 39 80 {Guard:}) ; "You must go immediately to the Blue Parrot Inn. If you are found again outside at night, you will be taken to prison."
				(= cycles 2)
			)
			(4
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 2)
				(= cycles 10)
			)
			(5
				(Print 380 40) ; "The guard sullenly escorts you back to the Blue Parrot Inn."
				(= cycles 2)
			)
			(6
				(= gPrevRoomNum 380)
				(gCurRoom newRoom: 360)
				(self dispose:)
			)
		)
	)
)

(instance aWin of SysWindow
	(properties
		back 11
	)
)

(instance topAlleyDoor of Feature
	(properties
		x 158
		y 67
		noun '/door,sign[<alley,bearing,street]'
		nsTop 38
		nsLeft 132
		nsBottom 91
		nsRight 185
		description {an alley leading south}
		lookStr {You see a dark, foreboding passage leading South.__The street sign reads "You must carry your Visa at all times!"}
	)
)

