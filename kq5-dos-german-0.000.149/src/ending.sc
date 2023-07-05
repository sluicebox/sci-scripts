;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use DLetter)
(use KQ5Room)
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
				(PrintDC 120 0 #at 120 160 #dispose) ; "NOW why won't you work?!"
				(= seconds 3)
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
					setCycle: RandCycle
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
				(PrintDC 120 1 #at 120 140 #dispose) ; "Oh...Princess Cassima! Well, I did it. Mordack is dead."
				(= seconds 7)
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
				(PrintDC 120 2 #at 10 80 #dispose) ; "Dead? Are you sure? Maybe he's only trying to trick you!"
				(= seconds 6)
			)
			(19
				(cassimaHead setCycle: Beg)
				(cassima setCycle: End self)
			)
			(20
				(cls)
				(gEgo setCycle: RandCycle)
				(= cycles 1)
			)
			(21
				(if (and (not (== gHowFast 0)) (< (gGlobalSound prevSignal:) 30))
					(-- state)
				)
				(= cycles 1)
			)
			(22
				(PrintDC 120 3 #at 110 80 #dispose) ; "He's dead, all right. He turned himself into a fire and I put him out with rainwater. He'll never bother anyone else EVER again! But now I have a bigger problem; I don't know what to do about my family or my castle. I don't know how to turn them back to normal!"
				(= seconds 15)
			)
			(23
				(cls)
				(gEgo setCycle: Beg)
				(cassima setLoop: 3 setCycle: RandCycle)
				(cassimaHead setCycle: Fwd)
				(PrintDC 120 4 #at 10 80 #dispose) ; "After all you've been through, there MUST be a way!"
				(= seconds 6)
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
				(PrintDC 120 5 #at 120 160 #dispose) ; "Crispin!"
				(= seconds 3)
			)
			(28
				(cls)
				(gEgo setCycle: Beg)
				(crispinMouth init: cycleSpeed: 2)
				(crispinMouth setCycle: RandCycle)
				(PrintDC 120 6 #at 40 70 #dispose) ; "I have the solution to ALL your problems, Graham!"
				(= seconds 6)
			)
			(29
				(cls)
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
				(crispinMouth setCycle: RandCycle)
				(PrintDC 120 7 #at 40 70 #dispose) ; "Hocus, pocus, ALIOCUS!"
				(= seconds 5)
			)
			(3
				(cls)
				(crispinMouth hide:)
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
				(PrintDC 120 8 #at 120 150 #dispose) ; "Valanice! My children! My joy knows no limits!"
				(= seconds 4)
			)
			(16
				((gEgo head:) setCel: 0)
				(gEgo
					illegalBits: 0
					cycleSpeed: 0
					setCycle: KQ5SyncWalk
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
					setCycle: KQ5SyncWalk
					cycleSpeed: 0
					moveSpeed: 0
					view: 2
					setMotion: MoveTo (- (rosella x:) 3) (+ (rosella y:) 3) self
				)
			)
			(23
				(cls)
				(PrintDC 120 9 #at 40 50 #dispose) ; "Oh, Daddy! I'm so glad you're here!"
				(valanice hide:)
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
					setCycle: KQ5SyncWalk
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
				(PrintDC 120 10 #at 10 40 #dispose) ; "Oh...Princess Cassima! How could I forget you! Come over here."
				(= seconds 4)
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
					setCycle: KQ5SyncWalk
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
				(crispin setCycle: RandCycle)
				(PrintDC 120 11 #at 120 140 #dispose) ; "All right! Now that we're done with the formalities, let's get on with business, shall we?"
				(= seconds 7)
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
				(crispinMouth setCycle: RandCycle)
				(PrintDC 120 12 #at 110 160 #dispose) ; "Higgledy, piggledly, POOH!"
				(= seconds 6)
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
				(crispin setCycle: RandCycle)
				(PrintDC 120 13 #at 110 120 #dispose) ; "Be assured that your castle is right back where it belongs...and the right size too! But NOW, it's time that everyone return to their homes...with MY help, of course."
				(= seconds 12)
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
				(PrintDC 120 14 #at 110 160 #dispose) ; "Alakazam, alakazoo..."
				(= seconds 5)
			)
			(22
				(if (not (== (gGlobalSound prevSignal:) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(23
				(cls)
				(egoHead init: setPri: 10 signal: 16400 posn: 93 110)
				(egoHead setCycle: Fwd)
				(PrintDC 120 15 #at 10 50 #dispose) ; "Wait! What about Cedric?!"
				(= seconds 5)
			)
			(24
				(egoHead hide:)
				(crispin setCycle: Beg self)
			)
			(25
				(cls)
				(crispin setLoop: 9)
				(gGlobalSound number: 147 loop: 1 play:)
				(crispin setCycle: RandCycle)
				(PrintDC 120 16 #at 110 160 #dispose) ; "What? Where IS Cedric?"
				(= seconds 5)
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
				(PrintDC 120 17 #at 10 50 #dispose) ; "Over there! Mordack may have killed him! Is there ANYTHING you can do about it?"
				(= seconds 7)
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
				(egoHead view: 933 loop: 14 hide: posn: 93 110)
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
				(crispin setCycle: RandCycle)
				(PrintDC 120 18 #at 110 150 #dispose) ; "Hmmmmm, let me think. Ah, yes! I think I know."
				(= seconds 6)
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
				(PrintDC 120 19 #at 110 150 #dispose) ; "Abra...abracarbara...no. Uh, abra...codora...hmmmmm."
				(= seconds 7)
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
				(PrintDC 120 20 #at 110 160 #dispose) ; "Now, what IS that confounded word!"
				(= seconds 7)
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
				(PrintDC 120 21 #at 110 160 #dispose) ; "Oh, yes!"
				(= seconds 3)
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
				(PrintDC 120 22 #at 110 160 #dispose) ; "Abra...cadabra!"
				(= seconds 4)
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
				(cedricHead setCycle: Fwd)
				(PrintDC 120 5 #at 200 90 #dispose) ; "Crispin!"
				(= seconds 3)
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
				(cedricHead hide:)
				(crispin setLoop: 9)
				(crispin setCycle: RandCycle)
				(PrintDC 120 23 #at 110 160 #dispose) ; "Cedric, it sure is good to see YOU again!"
				(= seconds 5)
			)
			(50
				(cls)
				(cedricHead show:)
				(crispin setCycle: 0)
				(PrintDC 120 24 #at 180 80 #dispose) ; "Likewise, I'm sure."
				(= seconds 3)
			)
			(51
				(cls)
				(cedricHead hide:)
				(crispin setCycle: RandCycle)
				(PrintDC 120 25 #at 110 150 #dispose) ; "All right. Enough is enough. Let's get on with it."
				(= seconds 5)
			)
			(52
				(crispin setCycle: Beg self)
			)
			(53
				(cls)
				(crispin setLoop: 9)
				(crispin setCycle: RandCycle)
				(PrintDC 120 26 #at 110 140 #dispose) ; "Okay, Cassima. Let's send you home first. Wasn't that the Land of the Green Isles?"
				(= seconds 7)
			)
			(54
				(crispin setCycle: Beg self)
			)
			(55
				(cls)
				(cassimaHead view: 933 loop: 10 posn: 71 112 setPri: 12 init:)
				(cassimaHead setCycle: Fwd)
				(PrintDC 120 27 #at 10 10 #dispose) ; "Yes, that's right! I can't wait to see my parents again! Good-bye, Alexander. Perhaps we'll meet again."
				(= seconds 7)
			)
			(56
				(cls)
				(alexHead setLoop: 13 setCycle: Fwd)
				(cassimaHead dispose:)
				(PrintDC 120 28 #at 120 10 #dispose) ; "You can be sure of that, m'lady."
				(= seconds 4)
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
				(PrintDC 120 29 #at 10 10 #dispose) ; "Before you send us all home, Crispin, I just want to thank you for all your help. And, you too, Cedric. I wouldn't be standing here with my family without you two. I'm deeply, deeply grateful."
				(= seconds 13)
			)
			(60
				(cls)
				(egoHead hide:)
				(crispin setLoop: 9)
				(crispin setCycle: RandCycle)
				(PrintDC 120 30 #at 110 150 #dispose) ; "All in a day's work, my boy. All in a day's work. Right, Cedric?"
				(= seconds 7)
			)
			(61
				(crispin setCycle: Beg self)
			)
			(62
				(cls)
				(cedricHead show:)
				(PrintDC 120 31 #at 180 70 #dispose) ; "Right, Crispin!"
				(= seconds 3)
			)
			(63
				(cls)
				(cedricHead hide:)
				(crispin
					setLoop: 9
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 4
				)
				(crispin setCycle: RandCycle)
				(PrintDC 120 32 #at 110 160 #dispose) ; "Okay, back home you go!"
				(= seconds 4)
			)
			(64
				(cls)
				(PrintDC 120 33 #at 110 160 #dispose) ; "Alakazam, alakazoo, ALAKAZEE!"
				(= seconds 4)
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

