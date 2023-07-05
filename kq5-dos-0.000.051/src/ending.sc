;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	ending 0
)

(instance ending of Rm
	(properties
		picture 65
	)

	(method (init &tmp temp0)
		(Load rsSCRIPT 751)
		(cond
			((== gPrevRoomNum 122) ; ending3
				(self setScript: cartoon3)
			)
			((== gPrevRoomNum 121) ; ending2
				(proc0_24 128 929 925 918 2)
				(self setScript: cartoon2)
			)
			(else
				(self style: 3)
				(gEgo
					normal: 1
					view: 2
					setPri: -1
					setLoop: -1
					loop: 1
					setStep: 2 2
					offset: 2
					init:
				)
				((gEgo head:) show:)
				(gGame setSpeed: 3)
				(self setScript: cartoon)
			)
		)
		(if (== global81 3)
			(coals init: setCycle: RandCycle)
		else
			(coals init: addToPic:)
		)
		(super init:)
	)

	(method (dispose)
		(DisposeScript 751)
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
				(HandsOff)
				(gEgo setMotion: MoveTo 87 177 self)
			)
			(2
				(gEgo
					normal: 0
					view: 916
					setLoop: 0
					ignoreActors: 1
					setCycle: End self
				)
				((gEgo head:) hide:)
			)
			(3
				(gGlobalSound3 number: 138 loop: 1 play:)
				(egoMagic init: cycleSpeed: 2 setCycle: End self)
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
					setLoop: 4
					setCycle: RandCycle
				)
				(= cycles 1)
			)
			(14
				(if (< (gGlobalSound prevSignal:) 10)
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
				(if (< (gGlobalSound prevSignal:) 20)
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
				(if (< (gGlobalSound prevSignal:) 30)
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
					init:
					cel: 0
					cycleSpeed: 2
					setLoop: 0
					setCycle: End self
				)
			)
			(27
				(gGlobalSound number: 142 loop: -1 play:)
				(cls)
				(crispin setLoop: 1 cel: 0)
				(PrintDC 120 5 #at 120 160 #dispose) ; "Crispin!"
				(gEgo setCycle: RandCycle)
				(= seconds 3)
			)
			(28
				(cls)
				(gEgo setCycle: Beg)
				(crispinMouth init: cycleSpeed: 2 setCycle: RandCycle)
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
				(crispin init: setLoop: 1)
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
				(= seconds 3)
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
				(proc0_7 gEgo rosella 5)
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
				(= cycles 1)
			)
			(16
				((gEgo head:) setCel: 0)
				(gEgo
					illegalBits: 0
					cycleSpeed: 0
					setCycle: Walk
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
					setCycle: Walk
					cycleSpeed: 0
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
					setCycle: Walk
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
				(gEgo cycleSpeed: 2 setLoop: 10 setCycle: Fwd)
				(= seconds 3)
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
					setCycle: Walk
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
				(crispin init: setLoop: 7)
				(crispin cel: (- (NumCels crispin) 1))
				(cMagic init:)
				(gEgo view: 2 posn: 94 135 ignoreActors: 1 init:)
				(proc0_7 gEgo cMagic 5)
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
				(cassima show:)
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
					setCycle: RandCycle
				)
				(gGlobalSound stop:)
				(gGlobalSound2 number: 145 loop: 1 play:)
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
				(crispinMouth init: cycleSpeed: 2 setCycle: RandCycle)
				(PrintDC 120 12 #at 110 160 #dispose) ; "Higgledy, piggledly, POOH!"
				(= seconds 4)
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
				)
			)
			(16
				(gGlobalSound4 number: 140 loop: 1 play:)
				(bottle init: ignoreActors: 1 cycleSpeed: 2 setCycle: End self)
			)
			(17
				(gGlobalSound number: 146 loop: 1 play:)
				(crispin setLoop: 7 cycleSpeed: 2 setCycle: End self)
			)
			(18
				(crispin setLoop: 9 cycleSpeed: 4 setCycle: RandCycle)
				(PrintDC 120 13 #at 110 120 #dispose) ; "Be assured that your castle is right back where it belongs...and the right size too! But NOW, it's time that everyone return to their homes...with MY help, of course."
				(= cycles 1)
			)
			(19
				(if (< (gGlobalSound prevSignal:) 10)
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
				(= cycles 1)
			)
			(22
				(if (not (== (gGlobalSound prevSignal:) -1))
					(-- state)
				)
				(= cycles 1)
			)
			(23
				(cls)
				(egoHead
					init:
					setPri: 10
					signal: 16400
					posn: 93 110
					setCycle: Fwd
				)
				(PrintDC 120 15 #at 10 50 #dispose) ; "Wait! What about Cedric?!"
				(= seconds 4)
			)
			(24
				(egoHead hide:)
				(crispin setCycle: Beg self)
			)
			(25
				(cls)
				(crispin setLoop: 9 setCycle: RandCycle)
				(gGlobalSound number: 147 loop: 1 play:)
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
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(29
				(PrintDC 120 17 #at 10 50 #dispose) ; "Over there! Mordack may have killed him! Is there ANYTHING you can do about it?"
				(= cycles 1)
			)
			(30
				(if (< (gGlobalSound prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(31
				(egoHead hide: posn: 93 110)
				(egoTemp setCycle: Beg self)
			)
			(32
				(egoTemp dispose:)
				(gEgo setLoop: 0 show:)
				(cls)
				(crispin setLoop: 9 setCycle: RandCycle)
				(= cycles 1)
			)
			(33
				(PrintDC 120 18 #at 110 150 #dispose) ; "Hmmmmm, let me think. Ah, yes! I think I know."
				(= seconds 6)
			)
			(34
				(if (< (gGlobalSound prevSignal:) 30)
					(-- state)
				)
				(= cycles 1)
			)
			(35
				(cls)
				(PrintDC 120 19 #at 110 150 #dispose) ; "Abra...abracarbara...no. Uh, abra...codora...hmmmmm."
				(= cycles 1)
			)
			(36
				(if (< (gGlobalSound prevSignal:) 40)
					(-- state)
				)
				(= cycles 1)
			)
			(37
				(cls)
				(PrintDC 120 20 #at 110 160 #dispose) ; "Now, what IS that confounded word!"
				(= cycles 1)
			)
			(38
				(if (< (gGlobalSound prevSignal:) 50)
					(-- state)
				)
				(= cycles 1)
			)
			(39
				(cls)
				(PrintDC 120 21 #at 110 160 #dispose) ; "Oh, yes!"
				(= cycles 1)
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
			(42
				(cls)
				(gGlobalSound number: 148 loop: 1 play:)
				(crispin setLoop: 8 setCycle: End self)
			)
			(43
				(PrintDC 120 22 #at 110 160 #dispose) ; "Abra...cadabra!"
				(= seconds 4)
			)
			(44
				(cls)
				(crispin setCycle: Beg)
				(cedric cel: 0 setLoop: 8 setCycle: End self)
			)
			(45
				(cedric setLoop: 5 cycleSpeed: 2 setCycle: Fwd)
				(= seconds 3)
			)
			(46
				(cedric setLoop: 6 setCycle: End self)
			)
			(47
				(if (< (gGlobalSound prevSignal:) 10)
					(-- state)
				)
				(= cycles 1)
			)
			(48
				(cedricHead init: setCycle: Fwd)
				(PrintDC 120 5 #at 200 90 #dispose) ; "Crispin!"
				(= seconds 3)
			)
			(49
				(if (< (gGlobalSound prevSignal:) 20)
					(-- state)
				)
				(= cycles 1)
			)
			(50
				(cls)
				(cedricHead hide:)
				(crispin setLoop: 9 setCycle: RandCycle)
				(PrintDC 120 23 #at 110 160 #dispose) ; "Cedric, it sure is good to see YOU again!"
				(= seconds 5)
			)
			(51
				(cls)
				(cedricHead show:)
				(crispin setCycle: 0)
				(PrintDC 120 24 #at 180 80 #dispose) ; "Likewise, I'm sure."
				(= seconds 3)
			)
			(52
				(cls)
				(cedricHead hide:)
				(crispin setCycle: RandCycle)
				(PrintDC 120 25 #at 110 150 #dispose) ; "All right. Enough is enough. Let's get on with it."
				(= seconds 5)
			)
			(53
				(crispin setCycle: Beg self)
			)
			(54
				(cls)
				(crispin setLoop: 9 setCycle: RandCycle)
				(PrintDC 120 26 #at 110 140 #dispose) ; "Okay, Cassima. Let's send you home first. Wasn't that the Land of the Green Isles?"
				(= seconds 7)
			)
			(55
				(crispin setCycle: Beg self)
			)
			(56
				(cls)
				(cassimaHead init: posn: 71 112 setCycle: Fwd setPri: 12)
				(PrintDC 120 27 #at 10 10 #dispose) ; "Yes, that's right! I can't wait to see my parents again! Good-bye, Alexander. Perhaps we'll meet again."
				(= seconds 7)
			)
			(57
				(cls)
				(alexHead setLoop: 13 setCycle: Fwd)
				(cassimaHead dispose:)
				(PrintDC 120 28 #at 120 10 #dispose) ; "You can be sure of that, m'lady."
				(= seconds 4)
			)
			(58
				(alexHead setLoop: 12 setCycle: Beg)
				(crispin setLoop: 8 cel: 0 setCycle: End self)
			)
			(59
				(crispin setCycle: Beg)
				(gGlobalSound3 number: 140 loop: 1 play:)
				(cassima view: 933 setLoop: 7 setCycle: End self)
			)
			(60
				(cls)
				(egoHead show: setPri: 10 posn: (egoHead x:) (egoHead y:))
				(cassima dispose:)
				(PrintDC 120 29 #at 10 10 #dispose) ; "Before you send us all home, Crispin, I just want to thank you for all your help. And, you too, Cedric. I wouldn't be standing here with my family without you two. I'm deeply, deeply grateful."
				(= seconds 13)
			)
			(61
				(cls)
				(egoHead hide:)
				(crispin setLoop: 9 setCycle: RandCycle)
				(PrintDC 120 30 #at 110 150 #dispose) ; "All in a day's work, my boy. All in a day's work. Right, Cedric?"
				(= seconds 7)
			)
			(62
				(crispin setCycle: Beg self)
			)
			(63
				(cls)
				(cedricHead show:)
				(PrintDC 120 31 #at 180 70 #dispose) ; "Right, Crispin!"
				(= seconds 3)
			)
			(64
				(cls)
				(cedricHead hide:)
				(crispin
					setLoop: 9
					setPri: (+ (gEgo priority:) 1)
					cycleSpeed: 4
					setCycle: RandCycle
				)
				(PrintDC 120 32 #at 110 160 #dispose) ; "Okay, back home you go!"
				(= seconds 4)
			)
			(65
				(cls)
				(PrintDC 120 33 #at 110 160 #dispose) ; "Alakazam, alakazoo, ALAKAZEE!"
				(= seconds 4)
			)
			(66
				(crispin setLoop: 8 cel: 0 setCycle: End self)
			)
			(67
				(= seconds 2)
			)
			(68
				(gGlobalSound3 number: 140 loop: 1 play:)
				(alexHead dispose:)
				(gEgo cycleSpeed: 2 setLoop: 0 setCycle: End self)
			)
			(69
				(gEgo setLoop: 1)
				(gEgo cel: (- (NumCels gEgo) 1) setCycle: Beg self)
			)
			(70
				(gEgo hide:)
				(= cycles 3)
			)
			(71
				(gCurRoom newRoom: 123) ; ending4
			)
		)
	)
)

(instance egoMagic of Prop
	(properties
		y 167
		x 87
		view 916
		loop 1
	)
)

(instance egoWand of Prop
	(properties
		y 176
		x 98
		view 916
		loop 3
	)
)

(instance cassima of Act
	(properties
		y 148
		x 6
		view 918
	)
)

(instance crispin of Act
	(properties
		y 163
		x 68
		view 922
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

(instance cMagic of Act
	(properties
		y 180
		x 63
		view 922
		loop 3
	)
)

(instance alexander of Act
	(properties
		y 138
		x 127
		view 929
	)
)

(instance valanice of Act
	(properties
		y 138
		x 108
		view 925
	)
)

(instance rosella of Act
	(properties
		y 138
		x 116
		view 925
		loop 2
	)
)

(instance bottle of Prop
	(properties
		y 187
		x 81
		view 922
		loop 6
		priority 15
		signal 16
	)
)

(instance cedric of Act
	(properties
		y 152
		x 232
		view 720
		loop 2
		cel 2
		signal 16384
		illegalBits 0
	)
)

(instance cassimaHead of Prop
	(properties
		y 145
		x 53
		view 918
		loop 5
		cycleSpeed 2
	)
)

(instance cedricHead of Prop
	(properties
		y 144
		x 229
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
		y 110
		x 93
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
		y 152
		x 281
		view 933
		loop 15
		priority 12
		signal 16400
		cycleSpeed 10
	)
)

(instance alexHead of Prop
	(properties
		y 110
		x 81
		view 933
		loop 12
		cycleSpeed 3
	)
)

