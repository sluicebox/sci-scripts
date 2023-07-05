;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 124)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use IconBar)
(use RandCycle)
(use LoadMany)
(use RFeature)
(use Path)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	battle 0
	getWand 2
)

(local
	[local0 15] = [198 49 182 40 171 38 158 38 146 41 136 51 122 70 -32768]
	[local15 25] = [7 3 7 6 6 6 6 6 5 9 3 9 1 9 1 9 0 12 0 12 0 12 0 10 -32768]
	local40
	local41
	[local42 11] = [1 2 1 2 3 1 2 1 2 3 1]
	[local53 11] = [6 5 6 5 5 6 5 6 5 5 6]
	[local64 11] = [64 59 64 59 61 64 59 64 59 61 64]
	[local75 11] = [0 5 0 5 10 0 5 0 5 10 0]
	[local86 11] = [50 15 50 15 15 50 15 50 15 15 50]
	[local97 11] = [50 30 50 30 30 50 30 50 30 30 50]
	[local108 11] = [1 2 1 3 4 1 2 1 3 4 5]
	local119
)

(procedure (localproc_0) ; UNUSED
	(global388 dispose:)
)

(procedure (localproc_1)
	(= global103 0)
	(User canInput: 1)
	(gTheIconBar enable:)
	(gTheIconBar disable: 0 1 2 3)
	(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
	(= global102 0)
)

(instance battle of KQ5Room
	(properties
		picture 65
	)

	(method (init)
		(= gMordObj mordObj)
		(= global388 (actorCloner new:))
		(= global389 (actorCloner new:))
		(= global390 (actorCloner new:))
		(= global391 (actorCloner new:))
		(= global392 (actorCloner new:))
		((ScriptID 758) init:) ; KQInv
		(super init:)
		(LoadMany rsVIEW 715 714 548)
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
		(if (or (not (IsFlag 60)) (not (gEgo has: 28))) ; Wand
			(SetFlag 55)
		)
		(if (== (gGame detailLevel:) 3)
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
		(DisposeScript 941)
		(DisposeScript 604)
		(DisposeList (gInventory elements:))
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
				(if (and (not (== gHowFast 0)) (< (gGlobalSound prevSignal:) 30))
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gMordObj init: setCycle: End self)
			)
			(3
				(proc0_28 73 124 0 67 10 30 25 4) ; "What's going on here?!"
				(= cycles 1)
			)
			(4
				(cls)
				(gCast eachElementDo: #hide)
				(gCurRoom drawPic: 222)
				(= seconds 1)
			)
			(5
				(global388 view: 548 posn: 155 30 0 init: cycleSpeed: 4)
				(global388 setCycle: RandCycle)
				(PrintDC 124 1 #dispose) ; "I'll take care of you... you SWINE!"
				(= seconds 4)
			)
			(6
				(global388 view: 712 z: 1000)
				(cls)
				(gCast eachElementDo: #show)
				(gCurRoom drawPic: 65)
				(UnLoad 128 548)
				(= seconds 3)
			)
			(7
				(if (OneOf ((gInventory at: 35) owner:) gEgo 66) ; Mordack_s_Wand
					(self setScript: (ScriptID 604 7) self) ; summonWandScript
				else
					(= cycles 1)
				)
			)
			(8
				(if (not (IsFlag 55))
					(= register 1)
				else
					(= cycles 1)
				)
			)
			(9
				(gMordObj
					view: 715
					setLoop: 0
					cel: 0
					cycleSpeed: 1
					setCycle: End self
				)
			)
			(10
				(global388
					posn: (+ (gMordObj x:) 17) (- (gMordObj y:) 39) 0
					view: 715
					setLoop: 3
					cel: 0
					cycleSpeed: 0
					init:
					setCycle: End self
				)
				(gGlobalSound2 number: 138 loop: 1 play: 90)
			)
			(11
				(gMordObj
					view: 714
					setLoop: 3
					cel: 0
					cycleSpeed: 0
					setCycle: End
				)
				(if (IsFlag 55)
					(= global103 0)
					(gEgo cycleSpeed: 1 setCycle: End self)
				else
					((ScriptID 604 5) setLoop: 0 setCel: 0 setCycle: End self) ; cedric
					(gGlobalSound2 number: 897 loop: 1 priority: 15 play:)
				)
			)
			(12
				(if (IsFlag 55)
					(= global103 0)
					(= global330
						{That wasn't a smart move, Graham!}
					)
					(EgoDead)
				else
					((ScriptID 604 5) ; cedric
						setMotion: 0
						setLoop: 1
						setCycle: Fwd
						cycleSpeed: 1
						setScript: owlScript self
					)
				)
			)
			(13
				((ScriptID 604 5) setLoop: 2 cel: 0 setCycle: End self) ; cedric
				(gGlobalSound3 number: 892 loop: 1 priority: 15 play:)
			)
			(14
				((ScriptID 604 5) stopUpd:) ; cedric
				(gMordObj view: 715 setLoop: 0 cel: 0 setCycle: End self)
				(gGlobalSound2 number: 125 loop: 1 priority: 15 play:)
			)
			(15
				(= seconds 2)
			)
			(16
				(proc0_28 73 124 2 67 10 30 25 4) ; "What the...?"
				(= cycles 1)
			)
			(17
				(cls)
				(gMordObj setLoop: 1 cel: 0 setCycle: End self)
			)
			(18
				(proc0_28 73 124 3 67 10 30 25 5) ; "What have you done to my wand?!"
				(= cycles 1)
			)
			(19
				(UnLoad 128 714)
				(proc0_28 73 124 4 67 10 10 70 100 25 7) ; "You think you can outwit me, little man?! Hah! Let me show YOU a thing or two!"
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
		(if (and register (< ((ScriptID 604 5) x:) 296)) ; cedric
			(self cue:)
			(= register 0)
		)
	)
)

(instance owlScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 604 5) ; cedric
					posn:
						(- ((ScriptID 604 5) x:) [local15 register]) ; cedric
						(+ ((ScriptID 604 5) y:) [local15 (++ register)]) ; cedric
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
				(LoadMany rsVIEW 722 725 724)
				(gGlobalSound number: 841 loop: -1 playBed:)
				(= cycles 1)
			)
			(1
				(if (and (not (== gHowFast 0)) (< (gGlobalSound prevSignal:) 10))
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gMordObj
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
				(gMordObj
					view: 725
					setLoop: 1
					posn: (+ (gMordObj x:) 27) (- (gMordObj y:) 31)
					setStep: 6 6
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(4
				(gMordObj
					setMotion:
						MoveTo
						(- (gEgo x:) 55)
						(- (gEgo y:) 31)
						self
				)
			)
			(5
				(localproc_1)
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
					(self setScript: (ScriptID 604 0)) ; death1Script
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
				(global388
					view: 722
					setLoop: 1
					cycleSpeed: 2
					illegalBits: 0
					signal: (| (global388 signal:) $6000)
					posn: (gEgo x:) (gEgo y:) 0
					setCycle: End self
				)
				(global389
					view: 722
					setLoop: 3
					cycleSpeed: 2
					illegalBits: 0
					signal: (| (global389 signal:) $6000)
					posn: (+ (gEgo x:) 38) (gEgo y:) 0
					init:
					setCycle: Fwd
				)
			)
			(9
				(global388 setCycle: Beg self)
			)
			(10
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
				(global388 z: 1000)
				(global389 z: 1000)
			)
			(11
				(gEgo setLoop: 0 cel: 1 setCycle: 0)
				(global388 z: 0)
				(global389 z: 0)
				(PrintDC 124 5 #dispose #at 50 10) ; "Why you little...!"
				(= seconds 4)
			)
			(12
				(global388 setCycle: End self)
			)
			(13
				(global388 setCycle: Beg self)
			)
			(14
				(gEgo setLoop: 2 cel: 0 setCycle: End self)
				(global388 z: 1000)
				(global389 z: 1000)
			)
			(15
				(gEgo setLoop: 0 cel: 1 setCycle: 0)
				(global388 z: 0)
				(global389 z: 0)
				(= seconds 2)
			)
			(16
				(cls)
				(gMordObj
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
				(gMordObj cel: 2 setMotion: MoveTo 238 56 self)
			)
			(18
				(gMordObj cel: 3 setMotion: MoveTo 280 82 self)
			)
			(19
				(gMordObj cel: 4 setMotion: MoveTo 295 104 self)
			)
			(20
				(gMordObj cel: 5 setMotion: MoveTo 285 148 self)
			)
			(21
				(gMordObj cel: 6 setMotion: MoveTo 224 165 self)
			)
			(22
				(gMordObj cel: 6 setMotion: MoveTo 162 162 self)
			)
			(23
				(gMordObj cel: 6 setMotion: MoveTo 125 135 self)
			)
			(24
				(gMordObj cel: 6 setMotion: MoveTo 92 120 self)
			)
			(25
				(gMordObj cel: 7 setMotion: MoveTo 67 134 self)
			)
			(26
				(gMordObj cel: 8 setMotion: MoveTo 82 150 self)
			)
			(27
				(gMordObj cel: 9 setMotion: MoveTo 124 148 self)
			)
			(28
				(= seconds 2)
			)
			(29
				(global388 z: 1000)
				(global389 z: 1000)
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
				(global388
					setLoop: 9
					cel: 0
					posn: (- (gEgo x:) 17) (- (gEgo y:) 4) 0
					setScript: (ScriptID 604 6) ; tigerStuffScript
				)
				(global389
					setLoop: 10
					posn: (+ (gEgo x:) 21) (gEgo y:) 0
					setPri: -1
					setCycle: Fwd
				)
				(gMordObj
					view: 725
					setLoop: 0
					setPri: 13
					setStep: 3 3
					setCycle: Fwd
					setMotion:
						MoveTo
						(- (gMordObj x:) 60)
						(- (gMordObj y:) 15)
						self
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
				(LoadMany rsVIEW 728 730)
				(UnLoad 132 842)
				(gGlobalSound number: 843 loop: -1 playBed:)
				(= cycles 1)
			)
			(1
				(if (and (not (== gHowFast 0)) (< (gGlobalSound prevSignal:) 10))
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(gMordObj
					yStep: 10
					setMotion: MoveTo (gMordObj x:) (+ (gMordObj y:) 20) self
				)
			)
			(3
				(gMordObj
					view: 724
					setLoop: 1
					cel: 0
					yStep: 2
					setMotion: MoveTo (gMordObj x:) (+ (gMordObj y:) 30)
					setCycle: End self
				)
			)
			(4
				(UnLoad 128 724)
				(gMordObj
					view: 728
					setLoop: 0
					setPri: 13
					stopUpd:
					setMotion: 0
				)
				(global390
					view: 728
					setLoop: 1
					cel: 0
					ignoreActors:
					illegalBits: 0
					setPri: 14
					posn: (+ (gMordObj x:) 15) (- (gMordObj y:) 47) 0
					init:
				)
				(global391
					view: 728
					setLoop: 4
					cel: 0
					ignoreActors:
					illegalBits: 0
					setPri: 15
					posn: (+ (gMordObj x:) 14) (- (gMordObj y:) 37) 0
					init:
					cycleSpeed: 3
					setScript: armScript
				)
				(= cycles 1)
			)
			(5
				(UnLoad 128 725)
				(UnLoad 128 722)
				(localproc_1)
				(= seconds 10)
			)
			(6
				(HandsOff)
				(if (== local40 2)
					(+= gScore 4)
					(= cycles 1)
				else
					(self setScript: (ScriptID 604 1)) ; death2Script
				)
			)
			(7
				(UnLoad 132 843)
				(gGlobalSound number: 844 loop: -1 playBed:)
				(LoadMany rsVIEW 738 739)
				(= cycles 5)
			)
			(8
				(global388 setScript: 0)
				(global391 setScript: 0)
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
				(global390
					setLoop: [local42 register]
					cel: 0
					setCycle: End self
				)
			)
			(11
				(global392
					view: 728
					setLoop: [local53 register]
					illegalBits: 0
					ignoreActors:
					posn:
						(+ (global390 x:) [local64 register])
						(+ (global390 y:) [local75 register])
					setStep: 9 9
					setPri: 13
					init:
				)
				(RedrawCast)
				(global392
					setMotion:
						MoveTo
						(+ (global392 x:) [local86 register])
						(+ (global392 y:) [local97 register])
						self
				)
				(gGlobalSound4 number: 200 priority: 10 loop: 1 play:)
				(global390 setCycle: Beg)
				(gEgo setScript: bunnyScript 0 [local108 register])
			)
			(12
				(global392 setLoop: 7 cel: 0 setCycle: End self)
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
				(global390 view: 730 setLoop: 1)
				(global388
					view: 730
					setLoop: 2
					cycleSpeed: 3
					posn: (+ (global390 x:) 21) (- (global390 y:) 16) 0
					setPri: (- (global390 priority:) 1)
					setCycle: RandCycle
				)
				(global392
					view: 730
					setLoop: 3
					posn: (+ (global390 x:) 6) (- (global390 y:) 29) 0
					setPri: (+ (global390 priority:) 1)
					cel: 0
				)
				(PrintDC 124 6 #dispose #at 10 10 #width 100) ; "You think you're so smart, don't you? Well, I've got you now!"
				(= seconds 10)
			)
			(15
				(global388 setCycle: 0)
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
						(= temp2 (- (global392 priority:) 1))
					)
					(2
						(= temp0 738)
						(= temp1 3)
						(= temp2 (+ (global392 priority:) 1))
					)
					(3
						(= temp0 738)
						(= temp1 2)
						(= temp2 (- (global392 priority:) 1))
					)
					(4
						(= temp0 738)
						(= temp1 3)
						(= temp2 (+ (global392 priority:) 1))
					)
					(5
						(= temp0 739)
						(= temp1 0)
						(= temp2 (- (global392 priority:) 1))
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
				(LoadMany rsVIEW 730 732)
				(gGlobalSound number: 845 loop: -1 playBed:)
				(UnLoad 132 844)
				(= cycles 1)
			)
			(1
				(global390 view: 712 z: 1000)
				(global391 view: 712 z: 1000)
				(global392 view: 712 z: 1000)
				(global388 view: 712 z: 1000)
				(gMordObj view: 730 setLoop: 0 cel: 0 setCycle: End self)
			)
			(2
				(UnLoad 128 728)
				(UnLoad 128 730)
				(= seconds 2)
			)
			(3
				(gMordObj
					view: 732
					setLoop: 6
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(4
				(= seconds 2)
			)
			(5
				(gMordObj
					setLoop: 0
					setCycle: Walk
					setMotion:
						MoveTo
						(- (gEgo x:) 26)
						(+ (gEgo y:) 8)
						self
				)
			)
			(6
				(gMordObj setLoop: 8 cel: 0 setCycle: End self)
			)
			(7
				(gMordObj setLoop: 14 cycleSpeed: 3 setCycle: Fwd)
				(PrintDC 124 7 #dispose #at -1 70) ; "Sssssssssssay good-bye, sssssssssswine!"
				(= seconds 5)
			)
			(8
				(cls)
				(localproc_1)
				(= seconds 10)
			)
			(9
				(HandsOff)
				(if (== local40 1)
					(+= gScore 4)
					(= cycles 1)
				else
					(self setScript: (ScriptID 604 2)) ; death3Script
				)
			)
			(10
				(UnLoad 132 845)
				(gGlobalSound number: 846 loop: -1 playBed:)
				(LoadMany rsVIEW 741)
				(= cycles 5)
			)
			(11
				(gEgo
					view: 741
					setLoop: 3
					cel: 0
					moveSpeed: 2
					setCycle: End self
				)
			)
			(12
				(gEgo
					setLoop: 0
					setCycle: KQ5SyncWalk
					setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:) self
				)
			)
			(13
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
				(gMordObj setCycle: 0 setLoop: 12 cel: 1)
				(= cycles 3)
			)
			(14
				(gMordObj cel: 0)
			)
			(15
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(16
				(gEgo
					setLoop: 1
					setCycle: KQ5SyncWalk
					setMotion:
						MoveTo
						(+ (gMordObj x:) 26)
						(- (gMordObj y:) 6)
						self
				)
			)
			(17
				(gMordObj z: 1000)
				(gEgo
					setLoop: 8
					cel: 0
					cycleSpeed: 2
					posn: (gMordObj x:) (gMordObj y:)
					setCycle: End self
				)
			)
			(18
				(gMordObj z: 0)
				(gEgo
					setLoop: 0
					cycleSpeed: 0
					posn: (+ (gEgo x:) 35) (- (gEgo y:) 2)
				)
				(RedrawCast)
				(gEgo
					setCycle: KQ5SyncWalk
					setMotion: MoveTo (+ (gEgo x:) 5) (gEgo y:) self
				)
			)
			(19
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
				(gMordObj setLoop: 12 cel: 1)
				(= cycles 3)
			)
			(20
				(gMordObj cel: 0)
			)
			(21
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(22
				(gEgo
					setLoop: 1
					setCycle: KQ5SyncWalk
					setMotion:
						MoveTo
						(+ (gMordObj x:) 26)
						(- (gEgo y:) 5)
						self
				)
			)
			(23
				(gMordObj z: 1000)
				(gEgo
					setLoop: 10
					cycleSpeed: 2
					cel: 0
					posn: (gMordObj x:) (gMordObj y:)
					setCycle: End self
				)
			)
			(24
				(gMordObj z: 0)
				(gEgo
					setLoop: 0
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
					posn: (+ (gEgo x:) 31) (- (gEgo y:) 5)
				)
				(RedrawCast)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 15) (gEgo y:) self
				)
			)
			(25
				(gEgo setLoop: 6 cel: 0 setCycle: End self)
			)
			(26
				(gEgo
					setLoop: 1
					setCycle: KQ5SyncWalk
					setMotion:
						MoveTo
						(+ (gMordObj x:) 26)
						(- (gMordObj y:) 6)
						self
				)
			)
			(27
				(gMordObj z: 1000)
				(gEgo
					setLoop: 8
					cycleSpeed: 2
					cel: 0
					posn: (gMordObj x:) (gMordObj y:)
					setCycle: End self
				)
			)
			(28
				(gMordObj z: 0)
				(gEgo
					setLoop: 0
					cycleSpeed: 0
					posn: (+ (gEgo x:) 35) (- (gEgo y:) 2)
				)
				(RedrawCast)
				(gEgo
					setLoop: 1
					setCycle: KQ5SyncWalk
					setMotion:
						MoveTo
						(+ (gMordObj x:) 45)
						(- (gMordObj y:) 4)
						self
				)
			)
			(29
				(gEgo
					view: 741
					setLoop: 3
					cel: 0
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(30
				(gMordObj setLoop: 14 cycleSpeed: 1 setCycle: Fwd)
				(PrintDC 124 8 #dispose #at -1 70) ; "Ssssssssso! If thisssss issssss the way you want to play...!"
				(= seconds 4)
			)
			(31
				(gEgo cel: 0 setCycle: End self)
				(= seconds 4)
			)
			(32
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
		(if (== state 8)
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
				(LoadMany rsVIEW 734 719)
				(gMordObj
					view: 734
					setLoop: 0
					cel: 0
					setPri: (- (gEgo priority:) 1)
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(1
				(gMordObj setLoop: 1 cel: 0 setCycle: End self)
				(global389
					view: 734
					setLoop: 2
					cel: 0
					cycleSpeed: 2
					posn: (gMordObj x:) (gMordObj y:) 0
					setPri: (+ (gEgo priority:) 1)
					setScript: 0
					setCycle: End self
				)
			)
			(2 0)
			(3
				(gMordObj
					setLoop: 3
					posn: (+ (gMordObj x:) 45) (- (gMordObj y:) 4)
					setCycle: Fwd
				)
				(global389
					setLoop: 4
					posn: (gMordObj x:) (gMordObj y:)
					setCycle: Fwd
				)
				(gEgo setLoop: 12 cel: 0 setCycle: End self)
			)
			(4
				(localproc_1)
				(= local119 1)
				(= seconds 10)
			)
			(5
				(HandsOff)
				(if (== local40 3)
					(+= gScore 4)
					(= cycles 1)
				else
					(self setScript: (ScriptID 604 3)) ; death4Script
				)
			)
			(6
				(UnLoad 132 847)
				(gGlobalSound number: 849 loop: -1 playBed:)
				(LoadMany rsVIEW 743 742)
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
				(if (and (not (== gHowFast 0)) (< (gGlobalSound prevSignal:) 10))
					(-- state)
				)
				(= cycles 1)
			)
			(9
				(global390
					view: 742
					setLoop: 3
					cel: 0
					posn: (+ (gMordObj x:) 2) (- (gMordObj y:) 56) 0
					init:
					cycleSpeed: 2
					setCycle: End self
				)
				(gEgo setLoop: 1 cel: 2 setCycle: Beg)
			)
			(10
				(if (and (not (== gHowFast 0)) (< (gGlobalSound prevSignal:) 20))
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(global390 setLoop: 4 setCycle: Fwd)
				(global392
					view: 742
					setLoop: 8
					posn: (- (global390 x:) 2) (+ (global390 y:) 7) 0
					setPri: (+ (global390 priority:) 1)
					cycleSpeed: 0
					setScript: 0
					setCycle: Fwd
				)
				(global391
					view: 742
					setLoop: 5
					cel: 0
					posn: (+ (gMordObj x:) 2) (- (gMordObj y:) 49) 0
					setPri: (+ (gEgo priority:) 1)
					init:
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(12
				(global391 setLoop: 6 setCycle: Fwd)
				(= seconds 2)
				(gEgo setLoop: 0 cel: 1 z: 0)
				(global388 dispose:)
			)
			(13
				(gMordObj view: 743 setLoop: 0)
				(global389 view: 743 setLoop: 1)
				(= seconds 2)
			)
			(14
				(UnLoad 128 734)
				(gMordObj setLoop: 2)
				(global389 setLoop: 3)
				(= seconds 1)
			)
			(15
				(gMordObj setLoop: 4 setCycle: End self)
				(global389 setLoop: 5 setCycle: End self)
				(global391 setLoop: 7 cel: 0 setCycle: End self)
			)
			(16 0)
			(17 0)
			(18
				(UnLoad 132 849)
				(gGlobalSound number: 850 loop: 1 playBed: self)
				(gMordObj dispose:)
				(global389 dispose:)
				(global391 dispose:)
				(global392 dispose:)
				(global390 setLoop: 9 cel: 0 setCycle: End self)
			)
			(19)
			(20
				(= seconds 2)
			)
			(21
				(global390 dispose:)
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

(instance transformScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gEgo cycleSpeed: 3)
				(switch global387
					(0
						(= cycles 1)
					)
					(4
						(gEgo view: 721 setLoop: 1 cel: 6 setCycle: Beg self)
						(global388 view: 712 z: 1000)
						(global389 view: 712 z: 1000)
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
						(= global387 0)
						(= cycles 1)
					)
					(4
						(= global387 4)
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
						(= global387 2)
						(gEgo
							view: (if temp0 718 else 740)
							setLoop: (if temp0 0 else 2)
							cel: 0
							setCycle: End self
						)
					)
					(1
						(= global387 1)
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
						(= global387 3)
						(gEgo
							view: (if temp0 718 else 742)
							setLoop: (if temp0 5 else 1)
							cel: 0
						)
						(if temp0
							(gEgo setCycle: CT 5 1 self)
						else
							(gEgo z: 19 setCycle: End self)
							(global388
								view: 742
								setLoop: 0
								setCycle: 0
								setCel: 0
								posn: (gEgo x:) (gEgo y:) 0
								setPri: (gEgo priority:)
								setScript: 0
								init:
							)
						)
					)
				)
			)
			(2
				(if (and (== local40 3) (not local119))
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
		x 281
		y 152
		view 712
		loop 1
		priority 12
		signal 16400
		cycleSpeed 10
	)
)

(instance mordObj of Actor
	(properties
		x 70
		y 163
		view 714
		signal 24576
	)

	(method (handleEvent)
		(return 0)
	)
)

(instance getWand of Path
	(properties)

	(method (at param1)
		(return [local0 param1])
	)
)

(instance actorSix of Actor
	(properties)
)

(instance actorCloner of Actor
	(properties)

	(method (handleEvent)
		(return 0)
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(if
			(or
				global102
				(event claimed:)
				(not (MousedOn self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(HandsOn)
			(switch (event message:)
				(4 ; Inventory
					(gTheIconBar disable: 0 1 2 3)
					(if
						(OneOf
							(gInventory indexOf: (gTheIconBar curInvIcon:))
							28
							39
							41
							38
							40
						)
						(if (not (IsFlag 21))
							(event claimed: 0)
						else
							(if
								(==
									(gInventory indexOf: (gTheIconBar curInvIcon:))
									28
								)
								(+= gScore 4)
								(for
									((= temp0 (gInventory first:)))
									temp0
									((= temp0 temp2))
									
									(= temp2 (gInventory next: temp0))
									(= temp1 (NodeValue temp0))
									(cond
										((not (temp1 isMemberOf: IconI))
											(temp1 moveTo: 1)
										)
										(
											(or
												(== (temp1 message:) 2) ; Look
												(== (temp1 message:) 6)
												(== (temp1 message:) 3) ; Do
											)
											(gInventory delete: temp1)
											(temp1 dispose:)
										)
									)
								)
								(gInventory
									heading:
										{Select spell to cast}
									showScore: 0
								)
								(gEgo get: 38) ; Mongoose_Spell
								(gEgo get: 39) ; Bunny_Spell
								(gEgo get: 40) ; Rain_Spell
								(gEgo get: 41) ; Tiger_Spell
							)
							(gTheIconBar enable: 5)
							(repeat
								(if (== (event type:) evMOUSEBUTTON)
									(gGame setCursor: 999 1)
									(proc0_8 0 4 3840 0)
								else
									(proc0_8 0 4 9 0)
								)
								(if
									(>
										(= local40
											(+
												(-
													(gInventory
														indexOf:
															(gTheIconBar
																curInvIcon:
															)
													)
													38
												)
												1
											)
										)
										0
									)
									(break)
								)
							)
							(gTheIconBar disable: 5)
							(gTheIconBar disable: 0 1 2 3)
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

