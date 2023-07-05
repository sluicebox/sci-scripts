;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 731)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	enterScr 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9 = 100
)

(instance enterScr of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and local0 (not (-- local1)))
			(Palette 2 0 255 local9) ; PalIntensity
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local1 30)
				(= seconds 1)
			)
			(1
				(gEgo
					drop: 55 ; theSenseRit
					setCycle: Fwd
					signal: (| (gEgo signal:) $4000)
					setMotion: MoveTo 170 120 self
				)
			)
			(2
				(gEgo
					setLoop: 5 1
					posn: 170 79
					setCel: 0
					setPri: 119
					setCycle: End self
				)
			)
			(3
				(gEgo view: 5 setLoop: 2 1 setCel: 0 posn: 170 80)
				(= seconds 2)
			)
			(4
				(gMessager say: 4 6 1 0 self) ; "Very good. You have succeeded where many have failed."
			)
			(5
				(= seconds 1)
			)
			(6
				(gMessager say: 5 6 1 0 self) ; "Enough talk. Let's get this over with."
			)
			(7
				(= seconds 1)
			)
			(8
				(gMessager say: 6 6 2 0 self) ; "You begin to recite the final Ritual."
			)
			(9
				(= local0 1)
				(gMessager say: 4 6 3 0 self) ; "Yes! Yes! The spell is completed, and Avoozl awakens! Darkness will fill the land, and we will never flee the sunshine again!"
			)
			(10
				(= local2 ((ScriptID 730 4) new:)) ; pSpark
				(= local3 ((ScriptID 730 4) new:)) ; pSpark
				(= local4 ((ScriptID 730 4) new:)) ; pSpark
				(= local5 ((ScriptID 730 4) new:)) ; pSpark
				(= local6 ((ScriptID 730 4) new:)) ; pSpark
				(= local7 ((ScriptID 730 4) new:)) ; pSpark
				(local2
					setLoop: 0 1
					setCel: 1
					posn: 263 122
					init:
					cycleSpeed: 18
					setCycle: Fwd
				)
				(local3
					setLoop: 1 1
					setCel: 5
					posn: 100 115
					init:
					cycleSpeed: 18
					setCycle: Fwd
				)
				(local4
					setLoop: 2 1
					setCel: 0
					posn: 124 119
					init:
					cycleSpeed: 18
					setCycle: Fwd
				)
				(local5
					setLoop: 3 1
					setCel: 1
					posn: 33 42
					init:
					cycleSpeed: 18
					setCycle: Fwd
				)
				(local6
					setLoop: 4 1
					setCel: 5
					posn: 188 56
					init:
					cycleSpeed: 18
					setCycle: Fwd
				)
				(local7
					setLoop: 5 1
					setCel: 4
					posn: 296 21
					init:
					cycleSpeed: 18
					setCycle: Fwd
				)
				(gLongSong number: 104 loop: 1 play:)
				(= seconds 1)
			)
			(11
				((ScriptID 730 2) ; avis
					view: 677
					setLoop: 0 1
					setCel: 0
					signal: (| ((ScriptID 730 2) signal:) $0001) ; avis
					setCycle: CT 5 1 self
				)
			)
			(12
				((= local8 ((ScriptID 730 5) new:)) ; fireBall
					x: 91
					y: 101
					setLoop: 3 1
					moveSpeed: 0
					setCycle: Fwd
					init:
					setMotion: MoveTo 176 87 self
				)
				((ScriptID 730 2) setCycle: End) ; avis
			)
			(13
				(local8 setLoop: 5 1 cel: 0 setCycle: End self)
			)
			(14
				(local8 dispose:)
				((ScriptID 730 6) init: setCycle: End) ; midBlast
				(gEgo view: 7 posn: 170 79 setLoop: 5 1 setCel: 0)
				(= seconds 4)
			)
			(15
				(gMessager say: 4 6 4 0 self) ; "No! How dare you?!"
			)
			(16
				((ScriptID 730 3) ; katrina
					setLoop: 0 1
					setCel: 0
					setPri: (+ ((ScriptID 730 8) priority:) 17) ; rightBlast
					setCycle: End self
				)
			)
			(17
				((ScriptID 730 3) setCel: 0) ; katrina
				((= local8 ((ScriptID 730 5) new:)) ; fireBall
					x: 190
					y: 65
					setLoop: 1 1
					setCycle: Fwd
					moveSpeed: 0
					init:
					setMotion: MoveTo 76 100 self
				)
			)
			(18
				((ScriptID 730 7) init: setCycle: End) ; leftBlast
				(local8 setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(19
				(local8 dispose:)
				((ScriptID 730 2) ; avis
					view: 737
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
			)
			(20
				(gMessager say: 5 6 3 0 self) ; "Ah, you have just shattered the bonds which bound me! Now we shall see who is the true Dark Master!"
			)
			(21
				((ScriptID 730 2) ; avis
					view: 677
					setLoop: 0 1
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(22
				((= local8 ((ScriptID 730 5) new:)) ; fireBall
					x: 91
					y: 101
					setLoop: 3 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 237 70 self
				)
				((ScriptID 730 2) setCycle: End) ; avis
			)
			(23
				(local8 setLoop: 5 1 cel: 0 setCycle: End self)
				((ScriptID 730 8) init: setCycle: End) ; rightBlast
				((ScriptID 730 3) setLoop: 1 1 setCel: 0 setCycle: End) ; katrina
			)
			(24
				(local8 dispose:)
				(= ticks 30)
			)
			(25
				((ScriptID 730 3) setLoop: 0 1 setCel: 0) ; katrina
				(= seconds 2)
			)
			(26
				((ScriptID 730 3) setCycle: End self) ; katrina
			)
			(27
				((= local8 ((ScriptID 730 5) new:)) ; fireBall
					x: 190
					y: 65
					setLoop: 1 1
					moveSpeed: 0
					init:
					setMotion: MoveTo 76 100 self
				)
			)
			(28
				((ScriptID 730 3) setLoop: 0 1 setCel: 0) ; katrina
				(local8 setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(29
				(local8 dispose:)
				((ScriptID 730 2) ; avis
					view: 737
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
			)
			(30
				((ScriptID 730 2) ; avis
					view: 677
					setLoop: 0 1
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(31
				((= local8 ((ScriptID 730 5) new:)) ; fireBall
					x: 91
					y: 101
					setLoop: 3 1
					moveSpeed: 0
					setCycle: Fwd
					init:
					setMotion: MoveTo 237 70 self
				)
				((ScriptID 730 2) setCycle: End) ; avis
			)
			(32
				(local8 setLoop: 5 1 cel: 0 setCycle: End self)
			)
			(33
				(local8 dispose:)
				((ScriptID 730 3) setLoop: 1 1 setCel: 0 setCycle: End self) ; katrina
			)
			(34
				((ScriptID 730 3) setLoop: 0 1 setCel: 0) ; katrina
				(gMessager say: 4 6 5 0 self) ; "I am still a far greater Master of Magic than you. I am a far more powerful Vampire than you. Do you really think your spells can harm me? Guess again."
			)
			(35
				((ScriptID 730 3) setCel: 3 setCycle: End self) ; katrina
			)
			(36
				((= local8 ((ScriptID 730 5) new:)) ; fireBall
					x: 190
					y: 65
					setLoop: 1 1
					setCycle: Fwd
					init:
					setMotion: MoveTo 76 100 self
				)
			)
			(37
				((ScriptID 730 3) setLoop: 0 1 setCel: 0) ; katrina
				(local8 setLoop: 2 1 cel: 0 setCycle: End self)
			)
			(38
				(local8 dispose:)
				((ScriptID 730 2) ; avis
					view: 737
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
				(gLongSong number: 109 loop: -1 play:)
			)
			(39
				(gMessager say: 5 6 6 0 self) ; "But my dear Katrina, I do not need to cast spells at you to destroy you."
			)
			(40
				(gMessager say: 4 6 6 0 self) ; "No! I will not let him die!"
			)
			(41
				((ScriptID 730 2) ; avis
					view: 738
					setLoop: 0 1
					setCel: 0
					posn: 76 136
					setCycle: End
				)
				((ScriptID 730 3) ; katrina
					view: 739
					setLoop: 0 1
					setCel: 0
					posn: 235 100
					setCycle: End self
				)
			)
			(42
				((ScriptID 730 3) ; katrina
					setLoop: 1 1
					setCel: 0
					posn: 134 104
					ignoreActors: 1
					setCycle: End self
				)
			)
			(43
				((ScriptID 730 2) setLoop: 1 1 setCel: 0 setCycle: CT 1 1 self) ; avis
			)
			(44
				((ScriptID 730 3) hide: dispose:) ; katrina
				((ScriptID 730 2) setLoop: 1 1 setCel: 1 setCycle: End self) ; avis
			)
			(45
				((ScriptID 730 2) setLoop: 2 1 setCel: 0 setCycle: End self) ; avis
			)
			(46
				(gMessager say: 5 6 7 0 self) ; ""The fool! I knew that Avoozl would be attracted by that spell. Now Katrina will have all the Darkness she so desired, and much, much more."
			)
			(47
				((ScriptID 730 2) ; avis
					view: 677
					setLoop: 0 1
					setCel: 0
					posn: 73 141
					setCycle: CT 5 1 self
				)
			)
			(48
				((= local8 ((ScriptID 730 5) new:)) ; fireBall
					view: 747
					setLoop: 1 1
					x: 91
					y: 101
					moveSpeed: 0
					init:
					setCycle: Fwd
					setMotion: MoveTo 176 87 self
				)
				((ScriptID 730 2) setCycle: End) ; avis
			)
			(49
				(local8 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(50
				(local8 dispose:)
				(gMessager say: 5 6 8 0 self) ; "There's no place you can run to, and no place for you to hide. Soon there won't even be a place to stand upon. Getting worried, great Hero?"
			)
			(51
				(gEgo setCel: 0 setCycle: End self)
			)
			(52
				(gEgo view: 5 setLoop: 2 1 setCel: 0 posn: 170 80)
				(= seconds 2)
			)
			(53
				(gLongSong number: 105 loop: -1 play:)
				(switch global439
					(1
						(PalVary 0 0 600) ; PalVaryStart
					)
					(2
						(PalVary 0 0 500) ; PalVaryStart
					)
					(3
						(PalVary 0 0 400) ; PalVaryStart
					)
				)
				((ScriptID 730 9) setScript: (ScriptID 730 10)) ; crystal, sTimeItOut
				(gGlory handsOn:)
				(gTheIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

