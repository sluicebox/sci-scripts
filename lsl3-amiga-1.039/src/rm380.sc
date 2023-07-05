;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 380)
(include sci.sh)
(use Main)
(use n021)
(use Interface)
(use Motion)
(use Game)
(use User)
(use Actor)
(use System)

(public
	rm380 0
)

(synonyms
	(use class do)
)

(local
	messageNum
	loopNum
	touchedBottom
	waitingToHulk
	previousX
	previousY
	previousPri
	BenchPressMax
	LegCurlsMax
	PullupsMax
	BarPullMax
	curMachine
	workOutState
)

(procedure (StartExercising onWhat)
	(Ok) ; "O.K."
	(HandsOff)
	(= curMachine onWhat)
	(= previousX (gEgo x:))
	(= previousY (gEgo y:))
	(= previousPri (gEgo priority:))
	(switch (++ messageNum)
		(1
			(Print 380 30) ; "Use the cursor keys until you work up a sweat."
		)
		(2
			(Print 380 31) ; "No pain, no gain!"
		)
		(3
			(Print 380 32) ; "You can do it!"
		)
		(4
			(Print 380 33) ; "Smile, this is supposed to be fun."
		)
		(5
			(Print 380 34) ; "Who booked this gig?"
			(= messageNum 0)
		)
	)
	(User mapKeyToDir: 0 canInput: 1)
	(gEgo viewer: 0 illegalBits: 0 ignoreActors:)
)

(procedure (NormalJock)
	(= curMachine 0)
	(= workOutState 0)
	(SetFlag 8)
	(SetFlag 10)
	(SetFlag 62)
	(NormalEgo 2 (+ 704 gEgoIsHunk))
	(gEgo posn: previousX previousY setPri: previousPri viewer: egoViewer)
	(aBigEgo cycleSpeed: 0 posn: 1234 1234 setMotion: 0 stopUpd:)
	(if
		(and
			(>= gBarPullCount BarPullMax)
			(>= gPullupsCount PullupsMax)
			(>= gBenchPressCount BenchPressMax)
			(>= gLegCurlsCount LegCurlsMax)
		)
		(HandsOff)
		(RoomScript changeState: 39)
	)
)

(procedure (UpdateCounters &tmp [string 11])
	(= touchedBottom 0)
	(Display
		(Format @string 380 35 gBarPullCount gPullupsCount gBenchPressCount gLegCurlsCount) ; "%-2d %-2d %-2d %-2d"
		dsCOORD
		122
		82
		dsFONT
		999
		dsCOLOR
		12
		dsBACKGROUND
		0
	)
)

(instance rm380 of Rm
	(properties
		picture 380
		horizon 1
		east 370
	)

	(method (init &tmp s)
		(if (not gEgoIsHunk)
			(Load rsSOUND 380)
			(Load rsVIEW 383)
			(Load rsVIEW 384)
			(Load rsVIEW 385)
			(Load rsVIEW 386)
			(Load rsVIEW 387)
		)
		(super init:)
		(gAddToPics add: atpPullupHandles doit:)
		(aBigEgo init:)
		(aActor1 init:)
		(aCenterWeight init:)
		(aRoundBar init:)
		(aExtraBar init:)
		(aDumbbell init:)
		(aBarPullBarView init:)
		(aLegCurlBar init:)
		(self setScript: RoomScript)
		(= s (+ (/ gMachineSpeed 5) 5))
		(if gDebugging
			(= s 5)
		)
		(= BarPullMax s)
		(= PullupsMax s)
		(= BenchPressMax s)
		(= LegCurlsMax s)
		(NormalEgo 1 (+ 704 gEgoIsHunk))
		(gEgo posn: 270 175 setPri: 9 viewer: egoViewer init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl:) $0040)
			(gCurRoom newRoom: 370)
		)
	)

	(method (handleEvent event)
		(super handleEvent: event)
		(if (event claimed:)
			(return)
		)
		(if (and curMachine (== (event type:) evKEYBOARD))
			(cond
				(
					(or
						(== (event message:) KEY_UP)
						(== (event message:) KEY_HOME)
						(== (event message:) $4900) ; PAGEUP
					)
					(cond
						((== workOutState 3)
							(self cue:)
						)
						((== workOutState 2)
							(++ state)
							(self cue:)
						)
					)
				)
				(
					(or
						(== (event message:) KEY_DOWN)
						(== (event message:) KEY_END)
						(== (event message:) $5100) ; PAGEDOWN
					)
					(cond
						((== workOutState 4)
							(self cue:)
						)
						((== workOutState 1)
							(++ state)
							(self cue:)
						)
					)
				)
			)
		)
		(if (!= (event type:) evSAID)
			(return)
		)
		(cond
			(
				(or
					(Said 'nightstand,(nightstand<up),(get<off,up)')
					(Said '(get<off,up),exit,stop,done')
					(Said 'exit/barstool')
				)
				(switch curMachine
					(0
						(YouAre) ; "You are."
					)
					(4
						(RoomScript changeState: 7)
					)
					(3
						(RoomScript changeState: 17)
					)
					(2
						(RoomScript changeState: 27)
					)
					(1
						(RoomScript changeState: 35)
					)
				)
			)
			((Said 'lie,(work<out),use')
				(cond
					(curMachine
						(Print 380 0) ; "You are already exercising!"
					)
					((& (gEgo onControl:) $0008)
						(if (>= gLegCurlsCount LegCurlsMax)
							(Print 380 1) ; "You've done enough leg curls!"
						else
							(self changeState: 1)
						)
					)
					((& (gEgo onControl:) $0004)
						(if (>= gBenchPressCount BenchPressMax)
							(Print 380 2) ; "You've bench pressed a ton already! Enough!"
						else
							(self changeState: 10)
						)
					)
					((& (gEgo onControl:) $0010)
						(if (>= gPullupsCount PullupsMax)
							(Print 380 3) ; "You've done enough pull ups for any man!"
						else
							(self changeState: 19)
						)
					)
					((& (gEgo onControl:) $0020)
						(if (>= gBarPullCount BarPullMax)
							(Print 380 4) ; "You've pulled that bar enough!"
						else
							(self changeState: 28)
						)
					)
					(else
						(Print 380 5) ; "There are four separate workout stations on Fat City's exercise equipment: the Leg Curl bench, the Bench Press weight-lifting bench, the Pullup station, and the Pull Bar."
						(Print 380 6) ; "You must be near the station you wish to use."
					)
				)
			)
			(
				(or
					(Said 'use/equipment<pull,bar')
					(Said 'use/bar,pull')
					(Said 'use/pull<bar')
					(Said 'pull/bar')
				)
				(cond
					(curMachine
						(Print 380 0) ; "You are already exercising!"
					)
					((>= gBarPullCount BarPullMax)
						(Print 380 7) ; "You've pulled that bar enough! How about something else?"
					)
					((& (gEgo onControl:) $0020)
						(self changeState: 28)
					)
					(else
						(Print 380 8) ; "Move until you are near the bench on the left side of the exercise machine."
					)
				)
			)
			((or (Said 'use/equipment<curl') (Said 'curl') (Said 'use/curl'))
				(cond
					(curMachine
						(Print 380 0) ; "You are already exercising!"
					)
					((>= gLegCurlsCount LegCurlsMax)
						(Print 380 9) ; "You've done enough leg curls for any hunk! Why not try another station?"
					)
					((& (gEgo onControl:) $0008)
						(self changeState: 1)
					)
					(else
						(Print 380 10) ; "Move until you are at the far side of the bench on the right side of the exercise machine."
					)
				)
			)
			(
				(or
					(Said 'use/equipment<pull,barstool')
					(Said 'pull,bell')
					(Said 'barstool<pull/')
					(Said 'get<on/barstool')
					(Said 'increase,use/pull,bell,bell')
				)
				(cond
					(curMachine
						(Print 380 0) ; "You are already exercising!"
					)
					((>= gBenchPressCount BenchPressMax)
						(Print 380 11) ; "You've lifted enough iron for any man. Why not try another station?"
					)
					((& (gEgo onControl:) $0004)
						(self changeState: 10)
					)
					(else
						(Print 380 12) ; "Move until you are on the near side of the bench at the right side of the exercise machine."
					)
				)
			)
			(
				(or
					(Said 'use/equipment<up,pullup,pull')
					(Said 'use/up<pull')
					(Said 'pullup')
					(Said '(up<pull)')
					(Said 'use/pullup')
				)
				(cond
					(curMachine
						(Print 380 0) ; "You are already exercising!"
					)
					((>= gPullupsCount PullupsMax)
						(Print 380 13) ; "You've worked out enough on this machine! Why not try another station?"
					)
					((& (gEgo onControl:) $0010)
						(self changeState: 19)
					)
					(else
						(Print 380 14) ; "Move until you are at the front center of the exercise machine."
					)
				)
			)
			((Said 'perspiration')
				(if curMachine
					(YouAre) ; "You are."
				else
					(Print 380 15) ; "Ok. Use one of the machines."
				)
			)
			((and (Said 'look>') (Said '[/equipment,pos,area]'))
				(Print 380 16) ; "There are four separate workout stations on Fat City's exercise equipment: the "Leg Curl" bench, the "Bench Press" weight-lifting dumbbell bench, the "Pullup" station, and the "Pull Bar.""
			)
		)
	)

	(method (changeState newState)
		(ShowState self newState 1 4)
		(switch (= state newState)
			(0)
			(1
				(StartExercising 4)
				(gEgo
					view: 381
					posn: 201 135
					setLoop: 8
					cel: 0
					cycleSpeed: 1
				)
				(aActor1
					setStep: 3 5
					posn: 155 45
					view: 384
					setLoop: 2
					setPri: 12
				)
				(aBigEgo view: 384 setLoop: 1 setPri: 13 posn: 155 80 stopUpd:)
				(aLegCurlBar hide:)
				(self cue:)
			)
			(2
				(= touchedBottom 1)
				(= workOutState 3)
			)
			(3
				(= workOutState 1)
				(gEgo cel: 0 setCycle: End)
				(aActor1 setMotion: MoveTo 155 15 self)
				(aCenterWeight setMotion: MoveTo 153 136)
			)
			(4
				(= workOutState 4)
				(if touchedBottom
					(if (== (++ gLegCurlsCount) LegCurlsMax)
						(Printf 380 17 gLegCurlsCount) ; "Congratulations! You've done %d leg curls."
					)
					(UpdateCounters)
				)
			)
			(5
				(= workOutState 2)
				(gEgo setCycle: Beg)
				(aActor1 setMotion: MoveTo 155 50 self)
				(aCenterWeight setMotion: MoveTo 153 166)
				(= state 1)
			)
			(6)
			(7
				(User mapKeyToDir: 1 canInput: 0 canControl: 0)
				(aCenterWeight setMotion: MoveTo 153 166 self)
				(aActor1 setMotion: MoveTo 155 50 self)
			)
			(8)
			(9
				(aLegCurlBar show:)
				(aCenterWeight stopUpd:)
				(NormalJock)
			)
			(10
				(StartExercising 3)
				(gEgo
					cycleSpeed: 1
					view: 381
					posn: 216 163
					setLoop: 1
					cel: 0
					setCycle: End self
				)
			)
			(11
				(aRoundBar hide:)
				(aBigEgo view: 382 cel: 0 setPri: 13 posn: 156 24)
				(aDumbbell hide:)
				(aActor1
					view: 380
					setLoop: 0
					setStep: 7 7
					setPri: 14
					posn: 155 34
				)
				(gEgo setPri: 13 setLoop: 2 posn: 219 159)
				(self cue:)
			)
			(12
				(= touchedBottom 1)
				(= workOutState 3)
			)
			(13
				(= workOutState 1)
				(gEgo cel: 0 setCycle: End self)
				(aActor1 setMotion: MoveTo 155 20)
				(aBigEgo setCycle: End)
			)
			(14
				(= workOutState 4)
				(if touchedBottom
					(if (== (++ gBenchPressCount) BenchPressMax)
						(Printf 380 18 (* 100 gBenchPressCount)) ; "Congratulations! You've pumped over %d pounds."
					)
					(UpdateCounters)
				)
			)
			(15
				(= workOutState 2)
				(gEgo setCycle: Beg self)
				(aActor1 setMotion: MoveTo 155 34)
				(aBigEgo setCycle: Beg)
				(= state 11)
			)
			(16)
			(17
				(User mapKeyToDir: 1 canInput: 0 canControl: 0)
				(aBigEgo posn: 1234 1234 setMotion: 0)
				(aActor1 posn: 155 34 setMotion: 0 stopUpd:)
				(aRoundBar show:)
				(aDumbbell show:)
				(gEgo posn: 216 163 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(18
				(NormalJock)
			)
			(19
				(gEgo
					illegalBits: 0
					viewer: 0
					setPri: 13
					setMotion: MoveTo 156 171 self
				)
			)
			(20
				(gEgo
					view: 381
					posn: 156 146
					setLoop: 5
					cel: 0
					setCycle: End self
				)
			)
			(21
				(StartExercising 2)
				(gEgo
					posn: 165 143
					setPri: 13
					setLoop: 6
					cel: 0
					cycleSpeed: 2
				)
				(aBigEgo view: 384 setLoop: 0 posn: 302 1)
				(self cue:)
			)
			(22
				(= touchedBottom 1)
				(= workOutState 3)
			)
			(23
				(= workOutState 1)
				(gEgo setCycle: End)
				(aBigEgo setMotion: MoveTo 302 -52 self)
			)
			(24
				(= workOutState 4)
				(if touchedBottom
					(if (== (++ gPullupsCount) PullupsMax)
						(Printf 380 19 gPullupsCount) ; "Congratulations! You've done %d pull ups."
					)
					(UpdateCounters)
				)
			)
			(25
				(= workOutState 2)
				(gEgo setCycle: Beg)
				(aBigEgo setMotion: MoveTo 302 1 self)
				(= state 21)
			)
			(26)
			(27
				(User mapKeyToDir: 1)
				(= previousX 156)
				(= previousY 175)
				(NormalJock)
			)
			(28
				(StartExercising 1)
				(gEgo
					cycleSpeed: 1
					view: 381
					posn: 131 165
					setLoop: 1
					cel: 0
					setCycle: End self
					setPri: 13
				)
			)
			(29
				(gEgo setLoop: 4 setCel: 0 posn: 126 165)
				(aBigEgo cycleSpeed: 1 view: 383 posn: 76 115 setPri: 13 cel: 0)
				(aActor1
					setStep: 3 5
					posn: 155 45
					view: 384
					setLoop: 2
					setPri: 12
				)
				(aExtraBar hide:)
				(aBarPullBarView hide:)
				(self cue:)
			)
			(30
				(= touchedBottom 1)
				(= workOutState 4)
			)
			(31
				(= workOutState 2)
				(gEgo setCycle: End)
				(aBigEgo setCycle: End)
				(aActor1 setMotion: MoveTo 155 15 self)
				(aCenterWeight setMotion: MoveTo 153 136)
			)
			(32
				(= workOutState 3)
				(if touchedBottom
					(if (== (++ gBarPullCount) BarPullMax)
						(Printf 380 20 gBarPullCount) ; "Congratulations! You've done %d bar pulls."
					)
					(UpdateCounters)
				)
			)
			(33
				(= workOutState 1)
				(gEgo setCycle: Beg)
				(aBigEgo setCycle: Beg)
				(aActor1 setMotion: MoveTo 155 50 self)
				(aCenterWeight setMotion: MoveTo 153 166)
				(= state 29)
			)
			(34)
			(35
				(User mapKeyToDir: 1 canInput: 0 canControl: 0)
				(aCenterWeight setMotion: MoveTo 153 166 self)
				(aActor1 setMotion: MoveTo 155 50 self)
				(aBarPullBarView show: stopUpd:)
				(aExtraBar show: stopUpd:)
				(aBigEgo posn: 999 999)
				(gEgo posn: 131 165 setLoop: 3 cel: 0 setCycle: End self)
			)
			(36)
			(37)
			(38
				(aCenterWeight stopUpd:)
				(NormalJock)
			)
			(39
				(= gEgoIsHunk 20)
				(= waitingToHulk 1)
				(= gNormalEgoView 720)
				(NormalEgo 2 724)
				(HandsOff)
				(= seconds 3)
			)
			(40
				(Print 380 21) ; "Boy, oh boy! This exercise stuff really works! Why, you look and feel like a new man!"
				(gMusic number: 380 loop: gBgMusicLoops play:)
				(= loopNum 0)
				(NormalEgo 2 704)
				(HandsOff)
				(= gOldGameSpeed (gGame setSpeed: 6))
				(= seconds 3)
			)
			(41
				(gEgo
					illegalBits: 64
					ignoreActors:
					view: 385
					setLoop: loopNum
					cel: 0
					setCycle: End self
				)
			)
			(42
				(cond
					((== 0 loopNum)
						(Print 380 22) ; "Hey! What's happening!?"
					)
					((== 3 loopNum)
						(Print 380 23) ; "Whoa!"
					)
				)
				(if (>= 4 (++ loopNum))
					(-= state 2)
				)
				(= cycles 11)
			)
			(43
				(Print 380 24) ; "Well, well! Look at this. It's "The Incredible Dork!""
				(gEgo view: 386 loop: 0 cel: 0 setCycle: End)
				(= cycles 18)
			)
			(44
				(gEgo loop: 1 cel: 0 setCycle: Fwd)
				(= cycles 33)
			)
			(45
				(Print 380 25) ; "There they are! The "Pulsating Pectorals!!""
				(= cycles 33)
			)
			(46
				(gEgo loop: 2 cel: 0 setCycle: End)
				(= cycles 11)
			)
			(47
				(Print 380 26) ; "You could learn to like this!"
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(48
				(gEgo loop: 3 cel: 0 setCycle: End)
				(= cycles 15)
			)
			(49
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(50
				(Print 380 27) ; "Maybe you could enter one of those contests!"
				(gEgo loop: 5 cel: 0 setCycle: End)
				(= cycles 22)
			)
			(51
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(52
				(gEgo loop: 4 cel: 0 setCycle: End)
				(= cycles 15)
			)
			(53
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(54
				(gEgo loop: 6 cel: 0 setCycle: End)
				(= cycles 22)
			)
			(55
				(gEgo setCycle: Beg)
				(= cycles 11)
			)
			(56
				(gEgo view: 387 loop: 0 cel: 0 setCycle: End self)
			)
			(57
				(Print 380 28) ; "Oops. Your new body has sprung a leak!"
				(gEgo loop: 1 setCycle: Fwd)
				(= cycles 33)
			)
			(58
				(gEgo loop: 2 cel: 0 setCycle: End self)
			)
			(59
				(NormalEgo 0 724)
				(gEgo viewer: egoViewer)
				(gGame changeScore: 100)
				(Print 380 29) ; "Oh, well. Who would want to be that "pumped up" anyway? At least you're no longer overweight; why, just take a look at yourself. That gut of yours is gone and just look at those muscles! What a hunk!!"
				(gMusic number: 399 loop: gBgMusicLoops play:)
				(gGame setSpeed: gOldGameSpeed)
			)
		)
	)
)

(instance atpPullupHandles of PV
	(properties
		y 143
		x 165
		view 380
		loop 2
		priority 9
		signal 16384
	)
)

(instance aRoundBar of View
	(properties
		y 142
		x 201
		view 381
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 10 stopUpd:)
	)
)

(instance aBarPullBarView of View
	(properties
		y 63
		x 30
		view 380
		loop 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 15 stopUpd:)
	)
)

(instance aLegCurlBar of View
	(properties
		y 164
		x 226
		view 381
		cel 2
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance aDumbbell of View
	(properties
		y 34
		x 155
		view 380
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 15 stopUpd:)
	)
)

(instance aExtraBar of View
	(properties
		y 138
		x 128
		view 381
		cel 1
		signal 16384
	)

	(method (init)
		(super init:)
		(self setPri: 9 stopUpd:)
	)
)

(instance aActor1 of Act
	(properties
		y 999
		x 155
		view 380
		signal 16384
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setPri: 15 ignoreHorizon: stopUpd:)
	)
)

(instance aCenterWeight of Act
	(properties
		y 166
		x 153
		view 381
		signal 16384
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setStep: 1 5 setLoop: 7 setPri: 11 stopUpd:)
	)
)

(instance aBigEgo of Act
	(properties
		y 999
		x 156
		view 382
		signal 16384
		illegalBits 0
	)

	(method (init)
		(super init:)
		(self setPri: 14 setStep: 6 6 ignoreHorizon: stopUpd:)
	)
)

(instance egoViewer of Code
	(properties)

	(method (doit)
		(cond
			((< (gEgo y:) 172)
				(gEgo setPri: 4)
			)
			((& (gEgo onControl:) $0002)
				(gEgo setPri: 9)
			)
			(else
				(gEgo setPri: -1)
			)
		)
	)
)

