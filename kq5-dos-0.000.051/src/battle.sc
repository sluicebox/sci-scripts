;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 124)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use RFeature)
(use Path)
(use Motion)
(use Game)
(use User)
(use Menu)
(use Actor)
(use System)

(public
	battle 0
)

(local
	[local0 15] = [198 49 182 40 171 38 158 38 146 41 136 51 122 70 -32768]
	[local15 25] = [7 3 7 6 6 6 6 6 5 9 3 9 1 9 1 9 0 12 0 12 0 12 0 10 -32768]
	local40
	local41
	local42
	[local43 11] = [1 2 1 2 3 1 2 1 2 3 1]
	[local54 11] = [6 5 6 5 5 6 5 6 5 5 6]
	[local65 11] = [64 59 64 59 61 64 59 64 59 61 64]
	[local76 11] = [0 5 0 5 10 0 5 0 5 10 0]
	[local87 11] = [50 15 50 15 15 50 15 50 15 15 50]
	[local98 11] = [50 30 50 30 30 50 30 50 30 30 50]
	[local109 11] = [1 2 1 3 4 1 2 1 3 4 5]
	local120
)

(instance battle of Rm
	(properties
		picture 65
	)

	(method (init)
		(super init:)
		(proc0_24 128 715 714 548)
		(self setFeatures: room setScript: mordOneScript)
		(HandsOff)
		(gEgo
			normal: 0
			view: 715
			setLoop: 4
			cel: 0
			illegalBits: 0
			posn: 250 74
			init:
		)
		(if (IsObject (gEgo head:))
			((gEgo head:) dispose:)
		)
		(if (or (not (IsFlag 61)) (not (gEgo has: 28))) ; Wand
			(SetFlag 56)
		)
		(if (== global81 3)
			(coals init: setCycle: RandCycle)
		else
			(coals init: addToPic:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(script
				(script doit:)
			)
			((= temp0 (self edgeToRoom: (gEgo edgeHit:)))
				(gCurRoom newRoom: temp0)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(DisposeScript 983)
		(DisposeScript 751)
		(super dispose:)
	)
)

(instance mordOneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 892)
				(gGlobalSound number: 840 loop: -1 playBed:)
				(= cycles 1)
			)
			(1
				(if (< (gGlobalSound prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(mord init: setCycle: End self)
			)
			(3
				(Say 73 124 0 67 10 30 25 4) ; "What's going on here?!"
				(= cycles 1)
			)
			(4
				(cls)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 222)
				(= seconds 1)
			)
			(5
				(actorOne
					view: 548
					posn: 155 30 0
					init:
					cycleSpeed: 4
					setCycle: RandCycle
				)
				(PrintDC 124 1 #dispose) ; "I'll take care of you... you SWINE!"
				(= seconds 4)
			)
			(6
				(actorOne z: 1000)
				(cls)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 65)
				(UnLoad 128 548)
				(= seconds 3)
			)
			(7
				(if (proc0_15 ((gInventory at: 35) owner:) gEgo 66) ; Mordack_s_Wand
					(self setScript: summonWandScript self)
				else
					(= cycles 1)
				)
			)
			(8
				(if (not (IsFlag 56))
					(= register 1)
				else
					(= cycles 1)
				)
			)
			(9
				(mord
					view: 715
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(10
				(actorOne
					posn: (+ (mord x:) 17) (- (mord y:) 39) 0
					view: 715
					setLoop: 3
					cel: 0
					cycleSpeed: 0
					init:
					setCycle: End self
				)
				(gGlobalSound2 number: 138 loop: 1 vol: 90 play:)
			)
			(11
				(mord view: 714 setLoop: 3 cel: 0 cycleSpeed: 0 setCycle: End)
				(if (IsFlag 56)
					(= global103 0)
					(gEgo cycleSpeed: 1 setCycle: End self)
				else
					(cedric setLoop: 0 setCel: 0 setCycle: End self)
					(gGlobalSound2 number: 897 loop: 1 priority: 15 play:)
				)
			)
			(12
				(if (IsFlag 56)
					(= global103 0)
					(= global330 {That wasn't a smart move, Graham!})
					(EgoDead)
				else
					(cedric
						setMotion: 0
						setLoop: 1
						setCycle: Fwd
						cycleSpeed: 1
						setScript: owlScript self
					)
				)
			)
			(13
				(cedric setLoop: 2 cel: 0 setCycle: End self)
				(gGlobalSound3 number: 892 loop: 1 vol: 127 priority: 15 play:)
			)
			(14
				(+= gScore 4)
				(cedric stopUpd:)
				(mord view: 715 setLoop: 0 cel: 0 setCycle: End self)
				(gGlobalSound2 number: 125 loop: 1 priority: 15 play:)
			)
			(15
				(= seconds 2)
			)
			(16
				(Say 73 124 2 67 10 30 25 4) ; "What the...?"
				(= cycles 1)
			)
			(17
				(cls)
				(mord setLoop: 1 cel: 0 setCycle: End self)
			)
			(18
				(Say 73 124 3 67 10 30 25 5) ; "What have you done to my wand?!"
				(= cycles 1)
			)
			(19
				(UnLoad 128 714)
				(Say 73 124 4 67 10 10 70 100 25 7) ; "You think you can outwit me, little man?! Hah! Let me show YOU a thing or two!"
				(= cycles 1)
			)
			(20
				(cls)
				(gCurRoom setScript: stingScript)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and register (< (cedric x:) 296))
			(self cue:)
			(= register 0)
		)
	)
)

(instance summonWandScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(actorOne
					view: 714
					setLoop: 4
					illegalBits: 0
					setPri: 3
					cycleSpeed: 1
					setStep: 8 8
					posn: 227 66 0
					init:
				)
				(mord setLoop: 1 cel: 0 setCycle: End self)
				(gGlobalSound2 number: 838 loop: 1 play:)
			)
			(1
				(actorOne
					setPri: 15
					setCycle: Fwd
					posn: 215 59
					moveSpeed: 1
					setMotion: getWand self
				)
				(gEgo put: 35) ; Mordack_s_Wand
			)
			(2
				(actorOne
					setMotion: MoveTo (+ (mord x:) 16) (- (mord y:) 31) self
				)
			)
			(3
				(actorOne setPri: -1 z: 1000 setCycle: 0)
				(mord setLoop: 2 cel: 0 setCycle: End self)
			)
			(4
				(if (not (IsFlag 56))
					(Say 75 124 5 67 130 30 25 5) ; "Graham... I've heard from Crispin!"
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(5
				(if (not (IsFlag 56))
					(cls)
					(= seconds 2)
				else
					(= cycles 1)
				)
			)
			(6
				(if (not (IsFlag 56))
					(cedric
						init:
						setLoop: 4
						setCycle: Walk
						setPri: 15
						moveSpeed: 1
						ignoreActors: 1
						setMotion: MoveTo 246 52
					)
				)
				(= cycles 1)
			)
			(7
				(mord setLoop: 3 cel: 0 setCycle: End self)
			)
			(8
				(self dispose:)
			)
		)
	)
)

(instance owlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cedric
					posn:
						(- (cedric x:) [local15 register])
						(+ (cedric y:) [local15 (++ register)])
				)
				(= cycles 2)
			)
			(1
				(if (== [local15 (++ register)] -32768)
					(self dispose:)
				else
					(if (== register 20)
						(client setPri: -1)
					)
					(self init:)
				)
			)
		)
	)
)

(instance stingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(UnLoad 128 715)
				(UnLoad 132 840)
				(proc0_24 128 722 725 724)
				(gGlobalSound number: 841 loop: -1 playBed:)
				(= cycles 1)
			)
			(1
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(mord
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					setPri: 10
					view: 724
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(3
				(mord
					view: 725
					setLoop: 1
					posn: (+ (mord x:) 27) (- (mord y:) 31)
					setStep: 6 6
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(4
				(mord
					setMotion:
						MoveTo
						(- (gEgo x:) 55)
						(- (gEgo y:) 31)
						self
				)
			)
			(5
				(= global103 0)
				(User canInput: 1)
				(TheIconBar state: 1)
				(= global102 0)
				(= seconds 10)
			)
			(6
				(HandsOff)
				(if (== local40 4)
					(UnLoad 132 841)
					(gGlobalSound number: 842 loop: -1 playBed:)
					(+= gScore 4)
					(= cycles 1)
				else
					(self setScript: death1Script)
				)
			)
			(7
				(gEgo
					view: 722
					setLoop: 2
					cycleSpeed: 2
					cel: 0
					posn: (- (gEgo x:) 23) (+ (gEgo y:) 1)
					setCycle: End self
				)
			)
			(8
				(gEgo setLoop: 0 cel: 1)
				(actorOne
					view: 722
					setLoop: 1
					cycleSpeed: 2
					illegalBits: 0
					signal: (| (actorOne signal:) $6000)
					posn: (gEgo x:) (gEgo y:) 0
					setCycle: End self
				)
				(actorTwo
					view: 722
					setLoop: 3
					cycleSpeed: 2
					illegalBits: 0
					signal: (| (actorTwo signal:) $6000)
					posn: (+ (gEgo x:) 38) (gEgo y:) 0
					init:
					setCycle: Fwd
				)
			)
			(9
				(actorOne setCycle: Beg self)
			)
			(10
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
				(actorOne z: 1000)
				(actorTwo z: 1000)
			)
			(11
				(gEgo setLoop: 0 cel: 1 setCycle: 0)
				(actorOne z: 0)
				(actorTwo z: 0)
				(PrintDC 124 6 #dispose #at 50 10) ; "Why you little...!"
				(= seconds 4)
			)
			(12
				(actorOne setCycle: End self)
			)
			(13
				(actorOne setCycle: Beg self)
			)
			(14
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
				(actorOne z: 1000)
				(actorTwo z: 1000)
			)
			(15
				(gEgo setLoop: 0 cel: 1 setCycle: 0)
				(actorOne z: 0)
				(actorTwo z: 0)
				(= seconds 2)
			)
			(16
				(cls)
				(mord
					view: 729
					setCycle: 0
					cel: 1
					setPri: 13
					moveSpeed: 2
					setStep: 20 20
					setMotion: MoveTo 205 43 self
				)
			)
			(17
				(mord cel: 2 setMotion: MoveTo 238 56 self)
			)
			(18
				(mord cel: 3 setMotion: MoveTo 280 82 self)
			)
			(19
				(mord cel: 4 setMotion: MoveTo 295 104 self)
			)
			(20
				(mord cel: 5 setMotion: MoveTo 285 148 self)
			)
			(21
				(mord cel: 6 setMotion: MoveTo 224 165 self)
			)
			(22
				(mord cel: 6 setMotion: MoveTo 162 162 self)
			)
			(23
				(mord cel: 6 setMotion: MoveTo 125 135 self)
			)
			(24
				(mord cel: 6 setMotion: MoveTo 92 120 self)
			)
			(25
				(mord cel: 7 setMotion: MoveTo 67 134 self)
			)
			(26
				(mord cel: 8 setMotion: MoveTo 82 150 self)
			)
			(27
				(mord cel: 9 setMotion: MoveTo 124 148 self)
			)
			(28
				(= seconds 2)
			)
			(29
				(actorOne z: 1000)
				(actorTwo z: 1000)
				(gEgo setLoop: 4 cel: 0 setCycle: CT 9 1 self)
			)
			(30
				(gEgo setPri: 5 setCycle: End self)
			)
			(31
				(gEgo
					setLoop: 5
					cel: 0
					cycleSpeed: 4
					setCycle: End
					setStep: 10 10
					setMotion:
						MoveTo
						(- (gEgo x:) 35)
						(+ (gEgo y:) 90)
						self
				)
			)
			(32
				(gEgo cycleSpeed: 0 setLoop: 6 cel: 0 setCycle: End self)
			)
			(33
				(gEgo setLoop: 8 cel: 1)
				(actorOne
					setLoop: 9
					cel: 0
					posn: (- (gEgo x:) 17) (- (gEgo y:) 4) 0
					setScript: tigerStuffScript
				)
				(actorTwo
					setLoop: 10
					posn: (+ (gEgo x:) 21) (gEgo y:) 0
					setPri: -1
					setCycle: Fwd
				)
				(mord
					view: 725
					setLoop: 0
					setPri: 13
					setStep: 3 3
					setCycle: Fwd
					setMotion: MoveTo (- (mord x:) 60) (- (mord y:) 15) self
				)
			)
			(34
				(gCurRoom setScript: dragonScript)
				(= local40 0)
			)
		)
	)

	(method (doit)
		(if (== state 5)
			(if local40
				(= seconds 0)
			)
			(if local41
				(Load rsSOUND 842)
				(= local41 0)
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance dragonScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_24 128 728 730)
				(UnLoad 132 842)
				(gGlobalSound number: 843 loop: -1 playBed:)
				(= cycles 1)
			)
			(1
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(mord
					yStep: 10
					setMotion: MoveTo (mord x:) (+ (mord y:) 20) self
				)
			)
			(3
				(mord
					view: 724
					setLoop: 1
					cel: 0
					yStep: 2
					setMotion: MoveTo (mord x:) (+ (mord y:) 30)
					setCycle: End self
				)
			)
			(4
				(UnLoad 128 724)
				(mord view: 728 setLoop: 0 setPri: 13 stopUpd: setMotion: 0)
				(actorThree
					view: 728
					setLoop: 1
					cel: 0
					ignoreActors:
					illegalBits: 0
					setPri: 14
					posn: (+ (mord x:) 15) (- (mord y:) 47) 0
					init:
				)
				(actorFour
					view: 728
					setLoop: 4
					cel: 0
					ignoreActors:
					illegalBits: 0
					setPri: 15
					posn: (+ (mord x:) 14) (- (mord y:) 37) 0
					init:
					cycleSpeed: 3
					setScript: armScript
				)
				(= cycles 1)
			)
			(5
				(UnLoad 128 725)
				(UnLoad 128 722)
				(= global103 0)
				(User canInput: 1)
				(TheIconBar state: 1)
				(= global102 0)
				(= seconds 10)
			)
			(6
				(HandsOff)
				(if (== local40 2)
					(+= gScore 4)
					(= cycles 1)
				else
					(self setScript: death2Script)
				)
			)
			(7
				(UnLoad 132 843)
				(gGlobalSound number: 844 loop: -1 playBed:)
				(proc0_24 128 738 739)
				(= cycles 5)
			)
			(8
				(actorOne setScript: 0)
				(actorFour setScript: 0)
				(gEgo
					view: 738
					setLoop: 0
					cel: 0
					setStep: 10 10
					setCycle: End self
				)
			)
			(9
				(= seconds 1)
			)
			(10
				(actorThree
					setLoop: [local43 register]
					cel: 0
					setCycle: End self
				)
			)
			(11
				(actorFive
					view: 728
					setLoop: [local54 register]
					illegalBits: 0
					ignoreActors:
					posn:
						(+ (actorThree x:) [local65 register])
						(+ (actorThree y:) [local76 register])
					setStep: 9 9
					setPri: 13
					init:
				)
				(RedrawCast)
				(actorFive
					setMotion:
						MoveTo
						(+ (actorFive x:) [local87 register])
						(+ (actorFive y:) [local98 register])
						self
				)
				(gGlobalSound4 number: 200 vol: 127 priority: 10 loop: 1 play:)
				(actorThree setCycle: Beg)
				(gEgo setScript: bunnyScript 0 [local109 register])
			)
			(12
				(actorFive setLoop: 7 cel: 0 setCycle: End self)
			)
			(13
				(cond
					((== register 10)
						(= cycles 10)
					)
					((gEgo script:)
						(-- state)
						(= cycles 1)
					)
					(else
						(++ register)
						(= start 9)
						(self init:)
					)
				)
			)
			(14
				(actorThree view: 730 setLoop: 1)
				(actorOne
					view: 730
					setLoop: 2
					cycleSpeed: 3
					posn: (+ (actorThree x:) 21) (- (actorThree y:) 16) 0
					setPri: (- (actorThree priority:) 1)
					setCycle: RandCycle
				)
				(actorFive
					view: 730
					setLoop: 3
					posn: (+ (actorThree x:) 6) (- (actorThree y:) 29) 0
					setPri: (+ (actorThree priority:) 1)
					cel: 0
				)
				(PrintDC 124 7 #dispose #at 10 10 #width 100) ; "You think you're so smart, don't you? Well, I've got you now!"
				(= seconds 10)
			)
			(15
				(actorOne setCycle: 0)
				(cls)
				(= local40 0)
				(gCurRoom setScript: snakeScript)
			)
		)
	)

	(method (doit)
		(if (== state 5)
			(if local40
				(= seconds 0)
			)
			(if local41
				(Load rsSOUND 844)
				(= local41 0)
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance bunnyScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(switch register
					(1
						(= temp0 739)
						(= temp1 0)
						(= temp2 (- (actorFive priority:) 1))
					)
					(2
						(= temp0 738)
						(= temp1 3)
						(= temp2 (+ (actorFive priority:) 1))
					)
					(3
						(= temp0 738)
						(= temp1 2)
						(= temp2 (- (actorFive priority:) 1))
					)
					(4
						(= temp0 738)
						(= temp1 3)
						(= temp2 (+ (actorFive priority:) 1))
					)
					(5
						(= temp0 739)
						(= temp1 0)
						(= temp2 (- (actorFive priority:) 1))
					)
				)
				(gEgo
					view: temp0
					setLoop: temp1
					cel: 0
					setPri: temp2
					setCycle: End self
				)
			)
			(1
				(switch register
					(1
						(= temp0 739)
						(= temp1 2)
						(= temp3 (- (gEgo x:) 24))
						(= temp4 (- (gEgo y:) 10))
					)
					(2
						(= temp0 738)
						(= temp1 5)
						(= temp3 (+ (gEgo x:) 14))
						(= temp4 (- (gEgo y:) 6))
					)
					(3
						(= temp0 738)
						(= temp1 4)
						(= temp3 (- (gEgo x:) 15))
						(= temp4 (- (gEgo y:) 6))
					)
					(4
						(= temp0 738)
						(= temp1 5)
						(= temp3 (+ (gEgo x:) 14))
						(= temp4 (- (gEgo y:) 6))
					)
					(5
						(= temp0 739)
						(= temp1 2)
						(= temp3 (- (gEgo x:) 24))
						(= temp4 (- (gEgo y:) 10))
					)
				)
				(gEgo
					view: temp0
					setLoop: temp1
					cel: 0
					posn: temp3 temp4
					setCycle: End self
				)
			)
			(2
				(switch register
					(1
						(= temp3 (- (gEgo x:) 9))
						(= temp4 (- (gEgo y:) 3))
					)
					(2
						(= temp3 (+ (gEgo x:) 10))
						(= temp4 (+ (gEgo y:) 6))
					)
					(3
						(= temp3 (gEgo x:))
						(= temp4 (gEgo y:))
					)
					(4
						(= temp3 (+ (gEgo x:) 41))
						(= temp4 (+ (gEgo y:) 2))
					)
					(5
						(= temp3 (gEgo x:))
						(= temp4 (gEgo y:))
					)
				)
				(gEgo setMotion: MoveTo temp3 temp4 self)
			)
			(3
				(switch register
					(1
						(= temp0 739)
						(= temp1 4)
						(= temp3 (- (gEgo x:) 7))
						(= temp4 (+ (gEgo y:) 3))
					)
					(2
						(= temp0 738)
						(= temp1 7)
						(= temp3 (+ (gEgo x:) 16))
						(= temp4 (+ (gEgo y:) 10))
					)
					(3
						(= temp0 738)
						(= temp1 6)
						(= temp3 (- (gEgo x:) 9))
						(= temp4 (+ (gEgo y:) 10))
					)
					(4
						(= temp0 738)
						(= temp1 7)
						(= temp3 (+ (gEgo x:) 9))
						(= temp4 (+ (gEgo y:) 10))
					)
					(5
						(= temp0 739)
						(= temp1 4)
						(= temp3 (- (gEgo x:) 13))
						(= temp4 (- (gEgo y:) 9))
					)
				)
				(gEgo
					view: temp0
					setLoop: temp1
					cel: 0
					posn: temp3 temp4
					setCycle: End self
				)
			)
			(4
				(if (== register 5)
					(gEgo
						view: 739
						setLoop: 6
						posn: 145 136
						cycleSpeed: 1
						setCycle: Fwd
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance tigerStuffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(client setCycle: Beg self)
			)
			(2
				(= seconds (Random 1 5))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance armScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End self)
			)
			(1
				(= seconds (Random 1 5))
			)
			(2
				(self init:)
			)
		)
	)
)

(instance snakeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_24 128 730 732)
				(UnLoad 132 844)
				(gGlobalSound number: 845 loop: -1 playBed:)
				(= cycles 1)
			)
			(1
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(actorThree z: 1000)
				(actorFour z: 1000)
				(actorFive z: 1000)
				(actorOne z: 1000)
				(mord view: 730 setLoop: 0 cel: 0 setCycle: End self)
			)
			(3
				(UnLoad 128 728)
				(UnLoad 128 730)
				(= seconds 2)
			)
			(4
				(mord
					view: 732
					setLoop: 6
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(5
				(= seconds 2)
			)
			(6
				(mord
					setLoop: 0
					setCycle: Walk
					setMotion:
						MoveTo
						(- (gEgo x:) 26)
						(+ (gEgo y:) 8)
						self
				)
			)
			(7
				(mord setLoop: 8 cel: 0 setCycle: End self)
			)
			(8
				(mord setLoop: 14 cycleSpeed: 3 setCycle: Fwd)
				(PrintDC 124 8 #dispose #at -1 70) ; "Sssssssssssay good-bye, sssssssssswine!"
				(= seconds 5)
			)
			(9
				(cls)
				(= global103 0)
				(User canInput: 1)
				(TheIconBar state: 1)
				(= global102 0)
				(= seconds 10)
			)
			(10
				(HandsOff)
				(if (== local40 1)
					(+= gScore 4)
					(= cycles 1)
				else
					(self setScript: death3Script)
				)
			)
			(11
				(UnLoad 132 845)
				(gGlobalSound number: 846 loop: -1 playBed:)
				(proc0_24 128 741)
				(= cycles 5)
			)
			(12
				(gEgo
					view: 741
					setLoop: 3
					cel: 0
					moveSpeed: 2
					setCycle: End self
				)
			)
			(13
				(gEgo
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:) self
				)
			)
			(14
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
				(mord setCycle: 0 setLoop: 12 cel: 1)
				(= cycles 3)
			)
			(15
				(mord cel: 0)
			)
			(16
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(17
				(gEgo
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo (+ (mord x:) 26) (- (mord y:) 6) self
				)
			)
			(18
				(mord z: 1000)
				(gEgo
					setLoop: 8
					cel: 0
					cycleSpeed: 2
					posn: (mord x:) (mord y:)
					setCycle: End self
				)
			)
			(19
				(mord z: 0)
				(gEgo
					setLoop: 0
					cycleSpeed: 0
					posn: (+ (gEgo x:) 35) (- (gEgo y:) 2)
				)
				(RedrawCast)
				(gEgo
					setCycle: Walk
					setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:) self
				)
			)
			(20
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
				(mord setLoop: 12 cel: 1)
				(= cycles 3)
			)
			(21
				(mord cel: 0)
			)
			(22
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(23
				(gEgo
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo (+ (mord x:) 26) (- (gEgo y:) 5) self
				)
			)
			(24
				(mord z: 1000)
				(gEgo
					setLoop: 10
					cycleSpeed: 2
					cel: 0
					posn: (mord x:) (mord y:)
					setCycle: End self
				)
			)
			(25
				(mord z: 0)
				(gEgo
					setLoop: 0
					cycleSpeed: 0
					setCycle: Walk
					posn: (+ (gEgo x:) 31) (- (gEgo y:) 5)
				)
				(RedrawCast)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(26
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(27
				(gEgo
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo (+ (mord x:) 26) (- (mord y:) 6) self
				)
			)
			(28
				(mord z: 1000)
				(gEgo
					setLoop: 8
					cycleSpeed: 2
					cel: 0
					posn: (mord x:) (mord y:)
					setCycle: End self
				)
			)
			(29
				(mord z: 0)
				(gEgo
					setLoop: 0
					cycleSpeed: 0
					posn: (+ (gEgo x:) 35) (- (gEgo y:) 2)
				)
				(RedrawCast)
				(gEgo
					setLoop: 1
					setCycle: Walk
					setMotion: MoveTo (+ (mord x:) 45) (- (mord y:) 4) self
				)
			)
			(30
				(gEgo
					view: 741
					setLoop: 3
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(31
				(mord setLoop: 14 cycleSpeed: 1 setCycle: Fwd)
				(PrintDC 124 9 #dispose #at -1 70) ; "Ssssssssso! If thisssss issssss the way you want to play...!"
				(= seconds 4)
			)
			(32
				(gEgo cel: 0 setCycle: End self)
				(= seconds 4)
			)
			(33
				(UnLoad 132 846)
				(gGlobalSound number: 847 loop: -1 playBed:)
				(cls)
				(gEgo setLoop: 12 cycleSpeed: 0 cel: 0)
				(= local40 0)
				(gCurRoom setScript: fireScript)
			)
		)
	)

	(method (doit)
		(if (== state 9)
			(if local40
				(= seconds 0)
			)
			(if local41
				(Load rsSOUND 846)
				(= local41 0)
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance fireScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(UnLoad 128 732)
				(proc0_24 128 734 719)
				(mord
					view: 734
					setLoop: 0
					cel: 0
					setPri: (- (gEgo priority:) 1)
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(mord setLoop: 1 cel: 0 setCycle: End self)
				(actorTwo
					view: 734
					setLoop: 2
					cel: 0
					cycleSpeed: 2
					posn: (mord x:) (mord y:) 0
					setPri: (+ (gEgo priority:) 1)
					setScript: 0
					setCycle: End self
				)
			)
			(2 0)
			(3
				(mord
					setLoop: 3
					posn: (+ (mord x:) 45) (- (mord y:) 4)
					setCycle: Fwd
				)
				(actorTwo setLoop: 4 posn: (mord x:) (mord y:) setCycle: Fwd)
				(gEgo setLoop: 12 cel: 0 setCycle: End self)
			)
			(4
				(= global103 0)
				(User canInput: 1)
				(TheIconBar state: 1)
				(= global102 0)
				(= local120 1)
				(= seconds 10)
			)
			(5
				(HandsOff)
				(if (== local40 3)
					(+= gScore 4)
					(= cycles 1)
				else
					(self setScript: death4Script)
				)
			)
			(6
				(UnLoad 132 847)
				(gGlobalSound number: 849 loop: -1 playBed:)
				(proc0_24 128 743 742)
				(= cycles 5)
			)
			(7
				(gEgo
					view: 742
					setLoop: 2
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(8
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(actorThree
					view: 742
					setLoop: 3
					cel: 0
					posn: (+ (mord x:) 2) (- (mord y:) 56) 0
					init:
					cycleSpeed: 2
					setCycle: End self
				)
				(gEgo setLoop: 1 cel: 2 setCycle: Beg)
			)
			(10
				(if (< (gGlobalSound prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(actorThree setLoop: 4 setCycle: Fwd)
				(actorFive
					view: 742
					setLoop: 8
					posn: (- (actorThree x:) 2) (+ (actorThree y:) 7) 0
					setPri: (+ (actorThree priority:) 1)
					cycleSpeed: 0
					setScript: 0
					setCycle: Fwd
				)
				(actorFour
					view: 742
					setLoop: 5
					cel: 0
					posn: (+ (mord x:) 2) (- (mord y:) 49) 0
					setPri: (+ (gEgo priority:) 1)
					init:
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(12
				(actorFour setLoop: 6 setCycle: Fwd)
				(= seconds 2)
				(gEgo setLoop: 0 cel: 1 z: 0)
				(actorOne dispose:)
			)
			(13
				(mord view: 743 setLoop: 0)
				(actorTwo view: 743 setLoop: 1)
				(= seconds 2)
			)
			(14
				(UnLoad 128 734)
				(mord setLoop: 2)
				(actorTwo setLoop: 3)
				(= seconds 1)
			)
			(15
				(mord setLoop: 4 setCycle: End self)
				(actorTwo setLoop: 5 setCycle: End self)
				(actorFour setLoop: 7 cel: 0 setCycle: End self)
			)
			(16 0)
			(17 0)
			(18
				(UnLoad 132 849)
				(gGlobalSound number: 850 loop: 1 playBed: self)
				(mord dispose:)
				(actorTwo dispose:)
				(actorFour dispose:)
				(actorFive dispose:)
				(actorThree setLoop: 9 cel: 0 setCycle: End self)
			)
			(19)
			(20
				(= seconds 2)
			)
			(21
				(actorThree dispose:)
				(gEgo cycleSpeed: 0)
				(gCurRoom newRoom: 120) ; ending
			)
		)
	)

	(method (doit)
		(if (== state 4)
			(if local40
				(= seconds 0)
			)
			(if local41
				(Load rsSOUND 849)
				(= local41 0)
				(self cue:)
			)
		)
		(super doit:)
	)
)

(instance death1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 896 loop: 1 play:)
				(= cycles 10)
			)
			(1
				(mord
					setMotion:
						MoveTo
						(- (gEgo x:) 8)
						(- (gEgo y:) 13)
						self
				)
			)
			(2
				(gEgo dispose:)
				(= seconds 5)
			)
			(3
				(= global103 0)
				(= global330 {That wasn't a smart move, Graham!})
				(EgoDead)
			)
		)
	)
)

(instance death2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 896 loop: 1 play:)
				(actorThree setCycle: End self)
				(switch local42
					(4
						(actorOne dispose:)
						(actorTwo dispose:)
						(gEgo view: 722 setLoop: 11 cel: 0 setCycle: CT 1 1)
					)
				)
			)
			(1
				(actorFive
					view: 728
					setLoop: 6
					illegalBits: 0
					ignoreActors:
					posn: (+ (actorThree x:) 64) (actorThree y:)
					setStep: 6 6
					setPri: 13
					init:
				)
				(RedrawCast)
				(actorFive
					setMotion:
						MoveTo
						(+ (actorFive x:) 40)
						(+ (actorFive y:) 40)
						self
				)
				(gGlobalSound4 number: 200 vol: 127 priority: 10 loop: 1 play:)
				(actorThree setCycle: Beg)
			)
			(2
				(actorFive dispose:)
				(actorOne dispose:)
				(actorTwo dispose:)
				(switch local42
					(4
						(gEgo setCycle: End self)
					)
					(2
						(gEgo view: 719 setLoop: 2 cel: 0 setCycle: End self)
					)
					(1
						(gEgo view: 719 setLoop: 0 cel: 0 setCycle: End self)
					)
					(3
						(gEgo
							view: 719
							setLoop: 3
							z: 0
							cel: 0
							setCycle: End self
						)
					)
				)
			)
			(3
				(if (== local42 4)
					(gEgo view: 728 setLoop: 7 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(4
				(= global103 0)
				(= global330 {That wasn't a smart move, Graham!})
				(EgoDead)
			)
		)
	)
)

(instance death3Script of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlobalSound number: 896 loop: 1 play:)
				(mord setLoop: 12 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(mord setCycle: Beg)
				(switch local42
					(4
						(= temp0 5)
					)
					(2
						(= temp0 6)
					)
					(3
						(actorOne dispose:)
						(= temp0 4)
					)
				)
				(gEgo
					view: 719
					setLoop: temp0
					cycleSpeed: 2
					cel: 0
					z: 0
					setCycle: End self
				)
			)
			(2
				(= seconds 2)
			)
			(3
				(= global103 0)
				(= global330 {That wasn't a smart move, Graham!})
				(EgoDead)
			)
		)
	)
)

(instance death4Script of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGlobalSound number: 896 loop: 1 play:)
				(mord setLoop: 5)
				(actorTwo setLoop: 6)
				(= seconds 1)
			)
			(1
				(mord setLoop: 7)
				(actorTwo setLoop: 8)
				(= seconds 1)
			)
			(2
				(mord dispose:)
				(actorTwo dispose:)
				(switch local42
					(4
						(= temp0 7)
					)
					(2
						(= temp0 2)
					)
					(1
						(= temp0 0)
					)
				)
				(gEgo
					view: 719
					setLoop: temp0
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(3
				(gEgo view: 719 setLoop: 1 cel: 0 setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(= global103 0)
				(= global330 {That wasn't a smart move, Graham!})
				(EgoDead)
			)
		)
	)
)

(instance transformScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo cycleSpeed: 3)
				(switch local42
					(0
						(= cycles 1)
					)
					(4
						(gEgo view: 721 setLoop: 1 cel: 6 setCycle: Beg self)
						(actorOne z: 1000)
						(actorTwo z: 1000)
					)
					(2
						(if (== local40 1)
							(gEgo
								view: 740
								setLoop: 0
								cel: 0
								setCycle: End self
							)
							(= register 1)
						else
							(gEgo
								view: 740
								setLoop: 2
								cel: 7
								setCycle: Beg self
							)
						)
					)
					(1
						(gEgo view: 740 setLoop: 1 cel: 7 setCycle: Beg self)
					)
				)
			)
			(1
				(if (< (gEgo y:) 100)
					(= temp0 1)
				else
					(= temp0 0)
				)
				(switch local40
					(0
						(= local42 0)
						(= cycles 1)
					)
					(4
						(= local42 4)
						(if temp0
							(gEgo
								view: 721
								setLoop: 0
								cel: 0
								setPri: -1
								posn: (- (gEgo x:) 6) (- (gEgo y:) 7)
								setCycle: End self
							)
						else
							(gEgo
								view: 721
								setLoop: 1
								cel: 0
								setCycle: End self
							)
						)
					)
					(2
						(= local42 2)
						(gEgo
							view: (if temp0 718 else 740)
							setLoop: (if temp0 0 else 2)
							cel: 0
							setCycle: End self
						)
					)
					(1
						(= local42 1)
						(if register
							(= cycles 1)
						else
							(gEgo
								view: (if temp0 718 else 740)
								setLoop: (if temp0 3 else 1)
								cel: 0
								setCycle: End self
							)
						)
					)
					(3
						(= local42 3)
						(gEgo
							view: (if temp0 718 else 742)
							setLoop: (if temp0 5 else 1)
							cel: 0
						)
						(if temp0
							(gEgo setCycle: CT 5 1 self)
						else
							(gEgo z: 19 setCycle: End self)
							(actorOne
								view: 742
								setLoop: 0
								setCycle: 0
								setCel: 0
								posn: (gEgo x:) (gEgo y:) 0
								setPri: (gEgo priority:)
								init:
							)
						)
					)
				)
			)
			(2
				(if (and (== local40 3) (not local120))
					(actorSix z: 1000 init: setScript: rainKludgeScript)
				else
					(= local41 1)
				)
				(gEgo cycleSpeed: 0)
				(= register 0)
				(client setScript: 0)
			)
		)
	)
)

(instance rainKludgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					view: 742
					setLoop: 3
					ignoreActors: 1
					posn: (gEgo x:) (- (gEgo y:) 40) 0
					setPri: 9
					cel: 0
					setCycle: End self
				)
			)
			(1
				(client setLoop: 4 setCycle: Fwd)
				(= cycles 10)
			)
			(2
				(= local41 1)
			)
		)
	)
)

(instance coals of Prop
	(properties
		y 152
		x 281
		view 712
		loop 1
		priority 12
		signal 16400
		cycleSpeed 10
	)
)

(instance mord of Act
	(properties
		y 163
		x 70
		view 714
		signal 24576
	)
)

(instance cedric of Act
	(properties
		y 39
		x 346
		view 720
		illegalBits 0
	)
)

(instance getWand of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance actorOne of Act
	(properties)
)

(instance actorTwo of Act
	(properties)
)

(instance actorThree of Act
	(properties)
)

(instance actorFour of Act
	(properties)
)

(instance actorFive of Act
	(properties)
)

(instance actorSix of Act
	(properties)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				global102
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(5 ; Inventory
					(if (proc0_15 global69 28 39 41 38 40)
						(if (not (IsFlag 22))
							(event claimed: 0)
						else
							(if (== global69 28) ; Wand
								(gInventory
									eachElementDo: #moveTo 1
									mustSelect: 1
									heading: (gInventory altHeading:)
									showScore: 0
								)
								(gEgo get: 38) ; Mongoose_Spell
								(gEgo get: 39) ; Bunny_Spell
								(gEgo get: 40) ; Rain_Spell
								(gEgo get: 41) ; Tiger_Spell
								((gUIcons at: 0) state: 0)
								((gUIcons at: 1) state: 0)
								((gUIcons at: 2) state: 0)
								((gUIcons at: 3) state: 0)
								((gUIcons at: 4) state: 0)
							)
							((gUIcons at: 6) state: 21)
							(if (& global71 $0040)
								(|= global71 $0002)
								(gGame setCursor: 999 1)
								(proc0_8 0 4 3840 0)
							else
								(proc0_8 0 4 9 0)
							)
							((gUIcons at: 6) state: 0)
							(= local40 (+ (- global69 38) 1))
							(HandsOff)
							(gEgo setScript: transformScript)
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

