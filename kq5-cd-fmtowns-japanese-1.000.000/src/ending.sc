;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use RandCycle)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	ending 0
)

(instance ending of KQ5Room
	(properties
		picture 65
	)

	(method (init &tmp temp0)
		(Load rsSCRIPT 941)
		(cond
			((== gPrevRoomNum 122) ; ending3
				(self setScript: cartoon3)
			)
			((== gPrevRoomNum 121) ; ending2
				(LoadMany rsVIEW 929 925 918 2)
				(self setScript: cartoon2)
			)
			(else
				(self style: 3)
				(gEgo
					normal: 1
					view: 2
					setPri: -1
					setLoop: -1
					cycleSpeed: 1
					moveSpeed: 1
					loop: 1
					setStep: 3 2
					init:
				)
				((gEgo head:) show:)
				(gGame setSpeed: 3)
				(self setScript: cartoon)
			)
		)
		(if (== (gGame detailLevel:) 3)
			(coals init: setCycle: RandCycle)
		else
			(coals init: addToPic:)
		)
		(super init:)
		(HandsOff)
		(gGame setCursor: 5 1)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
				(cedric init:)
			)
			(1
				(gEgo setMotion: MoveTo 87 177 self)
			)
			(2
				(gEgo
					normal: 0
					view: 916
					setLoop: 0
					ignoreActors: 1
					cycleSpeed: 1
					moveSpeed: 1
					setCycle: End self
				)
				((gEgo head:) hide:)
			)
			(3
				(gGlobalSound3 number: 138 loop: 1 play:)
				(egoMagic init: cycleSpeed: 1 setCycle: End self)
			)
			(4
				(egoMagic dispose:)
				(gEgo setCycle: Beg self)
			)
			(5
				(= seconds 2)
			)
			(6
				(Say 1083 self)
			)
			(7
				(gEgo setLoop: 2 setCycle: End self)
			)
			(8
				(cls)
				(gEgo normal: 1 view: 2 setLoop: -1)
				((gEgo head:) show:)
				(gGlobalSound3 number: 139 loop: 1 play:)
				(egoWand init: setCycle: End self)
			)
			(9
				(egoWand stopUpd:)
				(gGlobalSound number: 141 loop: 1 play:)
				(cassima init:)
				(= seconds 2)
			)
			(10
				(cassima setCycle: End self)
			)
			(11
				(= seconds 2)
			)
			(12
				(cassima
					setLoop: 1
					setCycle: Walk
					cycleSpeed: 2
					setStep: 2 1
					moveSpeed: 2
					setMotion: MoveTo 52 169 self
				)
			)
			(13
				(cassima setCycle: 0)
				(proc0_7 gEgo cassima 5)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 916
					cycleSpeed: 5
					setStep: 3 2
					setLoop: 4
				)
				(= cycles 1)
			)
			(14
				(if (and (not (== gHowFast 0)) (< (gGlobalSound prevSignal:) 10))
					(-- state)
				)
				(= cycles 1)
			)
			(15
				(gEgo setCycle: MouthSync 1084)
				(Say 1084 self)
			)
			(16
				(cls)
				(gEgo setCycle: End)
				(cassima setLoop: 2 cycleSpeed: 5 setCycle: RandCycle)
				(cassimaHead init: setPri: 15 setCycle: Fwd)
				(= cycles 1)
			)
			(17
				(if (and (not (== gHowFast 0)) (< (gGlobalSound prevSignal:) 20))
					(-- state)
				)
				(= cycles 1)
			)
			(18
				(cassimaHead setCycle: MouthSync 1085)
				(Say 1085 self)
			)
			(19
				(cassimaHead setCycle: Beg)
				(cassima setCycle: End self)
			)
			(20
				(cls)
				(= cycles 1)
			)
			(21
				(if (and (not (== gHowFast 0)) (< (gGlobalSound prevSignal:) 30))
					(-- state)
				)
				(= cycles 1)
			)
			(22
				(gEgo setCycle: MouthSync 1086)
				(Say 1086 self)
			)
			(23
				(cls)
				(gEgo setCycle: Beg)
				(cassima setLoop: 3 setCycle: RandCycle)
				(cassimaHead setCycle: Fwd)
				(cassimaHead setCycle: MouthSync 1087)
				(Say 1087 self)
			)
			(24
				(cassimaHead setCycle: Beg)
				(cassima setCycle: Beg self)
			)
			(25
				(Load rsVIEW 922)
				(Load rsSOUND 134)
				(if (not (== (gGlobalSound prevSignal:) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(26
				(cassima cycleSpeed: 2)
				(cls)
				(gGlobalSound3 number: 134 loop: 1 play:)
				(crispin
					cel: 0
					cycleSpeed: 2
					moveSpeed: 2
					setLoop: 0
					setCycle: End self
					init:
				)
			)
			(27
				(gGlobalSound number: 142 loop: -1 play:)
				(cls)
				(crispin view: 922 setLoop: 1 cel: 0)
				(gEgo setCycle: RandCycle)
				(Say 5200 self)
			)
			(28
				(cls)
				(gEgo setCycle: Beg)
				(crispinMouth init: cycleSpeed: 2)
				(crispinMouth setCycle: MouthSync 5201)
				(Say 5201 self)
			)
			(29
				(cls)
				(crispinMouth setCycle: 0)
				(gCurRoom newRoom: 121) ; ending2
			)
		)
	)
)

(instance cartoon2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cedric init:)
				(cassima init: setLoop: 1 posn: 52 169)
				(cassima cel: (- (NumCels cassima) 1))
				(crispin view: 922 setLoop: 1 init:)
				(crispin cel: (- (NumCels crispin) 1))
				(crispinMouth init:)
				(gEgo
					normal: 1
					view: 2
					setStep: 2 1
					setLoop: -1
					posn: 87 177
					init:
				)
				((gEgo head:) show:)
				(proc0_7 gEgo cassima 5)
				(= cycles 15)
			)
			(1
				(gGlobalSound number: 143 loop: -1 play:)
				(crispin setLoop: 1 setCycle: End self)
			)
			(2
				(crispinMouth setCycle: MouthSync 5206)
				(Say 5206 self)
			)
			(3
				(cls)
				(crispinMouth hide: setCycle: 0)
				(crispin setLoop: 2 setCycle: End self)
			)
			(4
				(gGlobalSound3 number: 138 loop: 1 play:)
				(cMagic
					init:
					setPri: (+ (crispin priority:) 1)
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(5
				(gGlobalSound3 number: 138 loop: 1 play:)
				(cMagic setLoop: 4 posn: 118 165 setCycle: End self)
			)
			(6
				(gGlobalSound3 number: 140 loop: 1 play:)
				(alexander init: setCycle: End self)
				(proc0_7 gEgo alexander 5)
			)
			(7
				(gGlobalSound3 number: 138 loop: 1 play:)
				(cMagic
					setStep: 3 3
					posn: 118 165
					cel: 0
					setMotion: MoveTo (- (cMagic x:) 3) (- (cMagic y:) 3)
					setCycle: End self
				)
			)
			(8
				(gGlobalSound3 number: 140 loop: 1 play:)
				(rosella init: setCycle: End self)
			)
			(9
				(rosella cel: 0 setLoop: 3 setCycle: End)
				(gGlobalSound3 number: 138 loop: 1 play:)
				(cMagic
					setStep: 6 6
					posn: 118 165
					cel: 0
					setMotion: MoveTo (- (cMagic x:) 8) (- (cMagic y:) 8)
					setCycle: End self
				)
			)
			(10
				(cMagic dispose:)
				(gGlobalSound3 number: 140 loop: 1 play:)
				(valanice init: setCycle: End self)
				(proc0_7 gEgo rosella 5)
			)
			(11
				(crispin setCycle: Beg self)
			)
			(12
				(crispin view: 922 setLoop: 7 setCycle: End self)
			)
			(13
				(valanice cel: 0 setLoop: 1 setCycle: End)
				(= seconds 2)
			)
			(14
				(gGlobalSound fade:)
				(valanice setCycle: Beg)
				(rosella setCycle: Beg)
				(= seconds 2)
			)
			(15
				(gGlobalSound number: 144 loop: -1 play:)
				(valanice setLoop: 0)
				(alexander setLoop: 0)
				(rosella setLoop: 2)
				(valanice cel: (- (NumCels valanice) 1))
				(alexander cel: (- (NumCels alexander) 1))
				(rosella cel: (- (NumCels rosella) 1))
				(cls)
				(Say 5207 self)
			)
			(16
				((gEgo head:) setCel: 0)
				(gEgo
					illegalBits: 0
					cycleSpeed: 0
					setCycle: SyncWalk
					setMotion:
						MoveTo
						(- (valanice x:) 6)
						(+ (valanice y:) 1)
						self
				)
			)
			(17
				(= seconds 2)
			)
			(18
				(valanice hide:)
				((gEgo head:) hide: setCel: -1)
				(gEgo
					view: 916
					normal: 0
					setLoop: 5
					cycleSpeed: 2
					moveSpeed: 2
					setCycle: End self
				)
			)
			(19
				(= seconds 2)
			)
			(20
				(gEgo setCycle: Beg self)
			)
			(21
				(= seconds 2)
			)
			(22
				(valanice show:)
				((gEgo head:) show:)
				(gEgo
					normal: 1
					setLoop: -1
					setCycle: SyncWalk
					cycleSpeed: 0
					moveSpeed: 0
					view: 2
					setMotion: MoveTo (- (rosella x:) 3) (+ (rosella y:) 3) self
				)
			)
			(23
				(cls)
				(Say 5208 self)
				(alexander hide:)
				(rosella hide:)
				((gEgo head:) hide:)
				(gEgo
					view: 916
					cel: 0
					normal: 0
					setLoop: 6
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(24
				(= seconds 5)
			)
			(25
				(gEgo setCycle: Beg self)
			)
			(26
				(alexander show:)
				(valanice show:)
				(rosella show:)
				((gEgo head:) show:)
				(gEgo
					view: 2
					setLoop: -1
					normal: 1
					cycleSpeed: 0
					setCycle: SyncWalk
				)
				(= seconds 2)
			)
			(27
				(gEgo
					setMotion:
						MoveTo
						(- (valanice x:) 5)
						(+ (valanice y:) 4)
						self
				)
			)
			(28
				(gEgo setMotion: MoveTo 96 136 self)
			)
			(29
				((gEgo head:) hide:)
				(gEgo view: 916 normal: 0 setLoop: 7 setCycle: End self)
			)
			(30
				(gEgo setCycle: MouthSync 5209)
				(Say 5209 self)
				(gEgo cycleSpeed: 2 setLoop: 10 setCycle: Fwd)
			)
			(31
				(gEgo setCycle: Beg self)
			)
			(32
				(gEgo
					setLoop: 7
					cel: (- (NumCels gEgo) 1)
					setCycle: Beg self
				)
			)
			(33
				((gEgo head:) show:)
				(gEgo
					view: 2
					normal: 1
					cycleSpeed: 0
					setLoop: 2
					setCycle: SyncWalk
					setLoop: -1
				)
				(= cycles 1)
			)
			(34
				(cassima
					ignoreActors: 1
					setLoop: 1
					cycleSpeed: 2
					moveSpeed: 2
					setCycle: Fwd
					setMotion: MoveTo 91 169 self
				)
			)
			(35
				(cassima setCycle: Fwd setLoop: 6 setMotion: MoveTo 97 150 self)
			)
			(36
				(cls)
				(gCurRoom newRoom: 122) ; ending3
			)
		)
	)
)

(instance cartoon3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cedric init:)
				(valanice init: posn: 106 134 cel: (- (NumCels valanice) 1))
				(rosella init: posn: 116 135 cel: (- (NumCels rosella) 1))
				(alexander init: posn: 127 135 cel: (- (NumCels alexander) 1))
				(cassima
					init:
					setLoop: 1
					cel: 5
					signal: 16384
					illegalBits: 0
					posn: 71 135
				)
				(crispin view: 922 setLoop: 7 init:)
				(crispin cel: (- (NumCels crispin) 1))
				(gEgo view: 2 posn: 94 135 ignoreActors: 1 loop: 2 init:)
				(= cycles 15)
			)
			(1
				(cls)
				(alexander
					view: 928
					setLoop: 3
					setPri: 15
					setCycle: Walk
					moveSpeed: 2
					cycleSpeed: 2
					setMotion: MoveTo 117 144 self
				)
			)
			(2
				(alexander
					setLoop: 1
					setMotion:
						MoveTo
						(+ (cassima x:) 20)
						(+ (cassima y:) 1)
						self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				(cassima hide:)
				(alexander
					view: 929
					posn: (+ (cassima x:) 18) (+ (cassima y:) 1)
					setLoop: 4
					cycleSpeed: 3
					moveSpeed: 3
					setCycle: End self
				)
			)
			(5
				(alexander setLoop: 5 setCycle: End self)
			)
			(6
				(alexander setCycle: Beg self)
			)
			(7
				(alexander setLoop: 4)
				(alexander cel: (- (NumCels alexander) 1) setCycle: Beg self)
			)
			(8
				(alexander posn: (+ (cassima x:) 20) (+ (cassima y:) 1))
				(= cycles 1)
			)
			(9
				(cassima show:)
				(alexander
					view: 928
					ignoreActors: 1
					setCycle: Fwd
					setLoop: 1
					setMotion: MoveTo (- (alexander x:) 5) (alexander y:) self
				)
			)
			(10
				(alexander setLoop: 5 setMotion: MoveTo 83 136 self)
			)
			(11
				(alexHead init:)
				(alexander hide:)
				(UnLoad 128 928)
				(valanice hide:)
				(rosella hide:)
				(cassima view: 933 loop: 7 cel: 0 show:)
				(gEgo setCel: 0)
				(gEgo
					view: 933
					setLoop: 0
					posn: 98 136
					ignoreActors: 1
					normal: 0
				)
				((gEgo head:) view: 933 setLoop: 13 hide:)
				(crispin
					setLoop: 9
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 4
				)
				(gGlobalSound stop:)
				(gGlobalSound2 number: 145 loop: 1 play:)
				(crispin setCycle: MouthSync 5212)
				(Say 5212 self)
			)
			(12
				(crispin setLoop: 7)
				(crispin cel: (- (NumCels crispin) 1) setCycle: Beg self)
			)
			(13
				(crispin setLoop: 1)
				(crispin cel: (- (NumCels crispin) 1))
				(= cycles 1)
			)
			(14
				(cls)
				(crispinMouth init: cycleSpeed: 2)
				(crispinMouth setCycle: MouthSync 5213)
				(Say 5213 self)
			)
			(15
				(cls)
				(crispinMouth setCycle: 0 hide:)
				(gGlobalSound3 number: 138 loop: 1 play:)
				(cMagic
					posn: 63 180
					setLoop: 3
					cycleSpeed: 2
					cel: 0
					setCycle: End self
					init:
				)
			)
			(16
				(cMagic dispose:)
				(gGlobalSound4 number: 140 loop: 1 play:)
				(bottle init: ignoreActors: 1 cycleSpeed: 2 setCycle: End self)
			)
			(17
				(bottle view: 922 stopUpd:)
				(gGlobalSound number: 146 loop: 1 play:)
				(crispin setLoop: 7 cycleSpeed: 2 setCycle: End self)
			)
			(18
				(crispin setLoop: 9 cycleSpeed: 4)
				(crispin setCycle: MouthSync 5214)
				(Say 5214 self)
			)
			(19
				(if
					(and
						(not (== gHowFast 0))
						(not (== (gGlobalSound prevSignal:) -1))
						(< (gGlobalSound prevSignal:) 10)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(20
				(crispin setCycle: Beg self)
			)
			(21
				(cls)
				(crispin setLoop: 8 setCycle: End)
				(Say 5215 self)
			)
			(22
				(crispin setCycle: 0)
				(= cycles 1)
			)
			(23
				(cls)
				(egoHead init: setPri: 10 signal: 16400 posn: 93 110)
				(egoHead setCycle: MouthSync 5216)
				(Say 5216 self)
			)
			(24
				(egoHead setCycle: 0 hide:)
				(crispin setCycle: Beg self)
			)
			(25
				(cls)
				(crispin setLoop: 9)
				(gGlobalSound number: 147 loop: 1 play:)
				(crispin setCycle: MouthSync 5217)
				(Say 5217 self)
			)
			(26
				(crispin setCycle: Beg self)
			)
			(27
				(gEgo setLoop: 8)
				(egoTemp init: view: 916 setLoop: 8 posn: 93 136 setCycle: End)
				(cls)
				(egoHead posn: 93 110 show:)
				(= cycles 1)
			)
			(28
				(if
					(and
						(< (gGlobalSound prevSignal:) 10)
						(not (== (gGlobalSound prevSignal:) -1))
						(not (== gHowFast 0))
					)
					(-- state)
				)
				(= cycles 1)
			)
			(29
				(egoHead setCycle: MouthSync 5218)
				(Say 5218 self)
			)
			(30
				(if
					(and
						(< (gGlobalSound prevSignal:) 20)
						(not (== gHowFast 0))
						(not (== (gGlobalSound prevSignal:) -1))
					)
					(-- state)
				)
				(= cycles 1)
			)
			(31
				(egoHead view: 933 loop: 14 hide: posn: 93 110 setCycle: 0)
				(egoTemp setCycle: Beg self)
			)
			(32
				(egoTemp dispose:)
				(gEgo setLoop: 0 show:)
				(cls)
				(crispin setLoop: 9)
				(= cycles 1)
			)
			(33
				(alexander dispose:)
				(valanice dispose:)
				(rosella dispose:)
				(crispin setCycle: RandCycle)
				(Say 5219 self)
			)
			(34
				(if
					(and
						(not (== gHowFast 0))
						(< (gGlobalSound prevSignal:) 30)
						(not (== (gGlobalSound prevSignal:) -1))
					)
					(-- state)
				)
				(= cycles 1)
			)
			(35
				(cls)
				(Say 5220 self)
			)
			(36
				(if
					(and
						(< (gGlobalSound prevSignal:) 40)
						(not (== gHowFast 0))
						(not (== (gGlobalSound prevSignal:) -1))
					)
					(-- state)
				)
				(= cycles 1)
			)
			(37
				(cls)
				(Say 5221 self)
			)
			(38
				(if
					(and
						(not (== gHowFast 0))
						(< (gGlobalSound prevSignal:) 50)
						(not (== (gGlobalSound prevSignal:) -1))
					)
					(-- state)
				)
				(= cycles 1)
			)
			(39
				(cls)
				(crispin setCycle: MouthSync 5222)
				(Say 5222 self)
			)
			(40
				(if (not (== (gGlobalSound prevSignal:) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(41
				(crispin setCycle: Beg self)
			)
			((cls)
				(gGlobalSound number: 148 loop: 1 play:)
				(crispin setLoop: 8 setCycle: End self)
			)
			(42
				(crispin setCycle: MouthSync 5223)
				(Say 5223 self)
			)
			(43
				(cls)
				(crispin setCycle: Beg)
				(cedric cel: 0 setLoop: 8 setCycle: End self)
			)
			(44
				(cedric setLoop: 5 cycleSpeed: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(45
				(cedric setLoop: 6 setCycle: End self)
			)
			(46
				(if
					(and
						(< (gGlobalSound prevSignal:) 10)
						(not (== (gGlobalSound prevSignal:) -1))
						(not (== gHowFast 0))
					)
					(-- state)
				)
				(= cycles 1)
			)
			(47
				(cedricHead init:)
				(cedricHead setCycle: MouthSync 3004)
				(Say 3004 self)
			)
			(48
				(if
					(and
						(not (== gHowFast 0))
						(not (== (gGlobalSound prevSignal:) -1))
						(< (gGlobalSound prevSignal:) 20)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(49
				(cls)
				(cedricHead setCycle: 0 hide:)
				(crispin setLoop: 9)
				(crispin setCycle: MouthSync 5225)
				(Say 5225 self)
			)
			(50
				(cls)
				(cedricHead show:)
				(crispin setCycle: 0)
				(cedricHead setCycle: MouthSync 5226)
				(Say 5226 self)
			)
			(51
				(cls)
				(cedricHead setCycle: 0 hide:)
				(crispin setCycle: MouthSync 5227)
				(Say 5227 self)
			)
			(52
				(crispin setCycle: Beg self)
			)
			(53
				(cls)
				(crispin setLoop: 9)
				(crispin setCycle: MouthSync 5228)
				(Say 5228 self)
			)
			(54
				(crispin setCycle: Beg self)
			)
			(55
				(cls)
				(cassimaHead view: 933 loop: 10 posn: 71 112 setPri: 12 init:)
				(cassimaHead setCycle: MouthSync 1088)
				(Say 1088 self)
			)
			(56
				(cls)
				(cassimaHead setCycle: 0 dispose:)
				(alexHead setLoop: 13 setCycle: MouthSync 5230)
				(Say 5230 self)
			)
			(57
				(alexHead setLoop: 12 setCycle: Beg)
				(crispin setLoop: 8 cel: 0 setCycle: End self)
			)
			(58
				(crispin setCycle: Beg)
				(gGlobalSound3 number: 140 loop: 1 play:)
				(cassima view: 933 setLoop: 7 setCycle: End self)
			)
			(59
				(cls)
				(egoHead show: setPri: 10 posn: (egoHead x:) (egoHead y:))
				(cassima dispose:)
				(egoHead setCycle: MouthSync 5231)
				(Say 5231 self)
			)
			(60
				(cls)
				(egoHead setCycle: 0 hide:)
				(crispin setLoop: 9)
				(crispin setCycle: MouthSync 5232)
				(Say 5232 self)
			)
			(61
				(crispin setCycle: Beg self)
			)
			(62
				(cls)
				(cedricHead show:)
				(cedricHead setCycle: MouthSync 5233)
				(Say 5233 self)
			)
			(63
				(cls)
				(cedricHead setCycle: 0 hide:)
				(crispin
					setLoop: 9
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 4
				)
				(crispin setCycle: MouthSync 5234)
				(Say 5234 self)
			)
			(64
				(cls)
				(crispin setCycle: MouthSync 5235)
				(Say 5235 self)
			)
			(65
				(crispin setLoop: 8 cel: 0 setCycle: End self)
			)
			(66
				(= seconds 2)
			)
			(67
				(gGlobalSound3 number: 140 loop: 1 play:)
				(alexHead dispose:)
				(gEgo cycleSpeed: 2 setLoop: 0 setCycle: End self)
			)
			(68
				(gEgo setLoop: 1)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(69
				(gEgo hide:)
				(= cycles 3)
			)
			(70
				(gCurRoom newRoom: 123) ; ending4
			)
		)
	)
)

(instance egoMagic of Prop
	(properties
		x 87
		y 167
		view 916
		loop 1
	)
)

(instance egoWand of Prop
	(properties
		x 98
		y 176
		view 916
		loop 3
	)
)

(instance cassima of Actor
	(properties
		x 6
		y 148
		view 918
	)
)

(instance crispin of Actor
	(properties
		x 68
		y 163
		view 935
	)
)

(instance crispinMouth of Prop
	(properties
		view 922
		loop 10
		signal 16384
	)

	(method (doit)
		(super doit:)
		(self posn: (+ (crispin x:) 3) (- (crispin y:) 23))
		(self setPri: (+ (crispin priority:) 1))
	)
)

(instance cMagic of Actor
	(properties
		x 63
		y 180
		view 935
		loop 3
	)
)

(instance alexander of Actor
	(properties
		x 127
		y 138
		view 929
	)
)

(instance valanice of Actor
	(properties
		x 108
		y 138
		view 925
	)
)

(instance rosella of Actor
	(properties
		x 116
		y 138
		view 925
		loop 2
	)
)

(instance bottle of Prop
	(properties
		x 81
		y 187
		view 935
		loop 6
		priority 15
		signal 16
	)
)

(instance cedric of Actor
	(properties
		x 232
		y 152
		view 720
		loop 2
		cel 2
		signal 16384
		illegalBits 0
	)
)

(instance cassimaHead of Prop
	(properties
		x 53
		y 145
		view 918
		loop 5
		cycleSpeed 2
	)
)

(instance cedricHead of Prop
	(properties
		x 229
		y 144
		view 720
		loop 7
		cycleSpeed 2
	)

	(method (init)
		(super init:)
		(self signal: 16384)
	)
)

(instance egoTemp of Prop
	(properties)
)

(instance egoHead of Prop
	(properties
		x 93
		y 110
		view 916
		loop 9
		cycleSpeed 3
	)

	(method (init)
		(super init:)
		(self signal: 16400 setPri: 10)
	)
)

(instance coals of Prop
	(properties
		x 281
		y 152
		view 933
		loop 15
		priority 12
		signal 16400
		cycleSpeed 10
	)
)

(instance alexHead of Prop
	(properties
		x 81
		y 110
		view 933
		loop 12
		cycleSpeed 3
	)
)

