;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use Interface)
(use eRS)
(use ForwardCounter)
(use DPath)
(use Motion)
(use Actor)
(use System)

(public
	rm900 0
)

(local
	[local0 4]
)

(procedure (localproc_0 param1)
	(TextSize @local0 param1 0 122)
	(return (/ (- 180 (- [local0 2] [local0 0])) 2))
)

(procedure (localproc_1 param1 &tmp temp0)
	(= temp0 (localproc_0 param1))
	(Display param1 dsCOORD 168 temp0 dsWIDTH 122 dsFONT 0 dsALIGN alLEFT)
)

(instance rm900 of SQRoom
	(properties
		picture 900
		style 10
	)

	(method (init)
		(HandsOff)
		(gLongSong prevSignal: 0)
		(super init:)
		(localproc_1
			(switch global187
				(0 {We're glad you could play SQIV.  As usual, you've been a real pantload.})
				(1 {Smoking is bad for your health.})
				(2 {It looks like shoplifting is taken seriously around here!})
				(3 {Next time, don't dilly-dally, dude!})
				(4 {Anyway, we hope you'll get yourself together and rejoin us. Isn't this a blast?})
				(5 {The formatting sequence times out, the computer brain does its thing, and you suddenly realize you've lost the game because you weren't there to see it.})
				(6 {THWUMP! Nice Reactions, Roger! Life is pounded loose from your body by the impact of the sand bike.})
				(7 {Your musculature spasms for the last time as the force field shock causes you to give up the ghost.})
				(8 {Oh, well. Just think proudly of your accomplishment... On second thought, just think - it happens to even IMPORTANT people!})
				(9 {Why'd you just STAND there?! I guess you just enjoy a laser buzz once in awhile.})
				(10 {Now, you KNEW he was coming, didn't you?!})
				(11 {Well, that's just great!  Now Vohaul's on the loose again, disguised as your SON!  You lose 3 out of 2.})
				(12 {Gee, Zero IQ, Zero-G might be for you.})
				(13 {As the green slime dissolves the flesh from your bones, you think, "Hey! This stuff consumes 47 times its weight in acid!"})
				(14 {Hint: hitting a moving target is more difficult than hitting a stationary LUMP!})
				(15 {Were you looking for trouble?  Maybe you thought you could beat them senseless with your pink bunny rabbit?})
				(16 {This is Roger.\n\nThis is Roger on Ortega.\n\n\nAny questions?})
				(17 {Zap zap, you're dead.})
				(18 {Well... maybe.  It's worth a try.})
				(19 {You hear a metallic voice announce that the formatting program is beginning, erasing all data in the super computer!})
				(20 {For a fleeting moment, you are impressed with the droid's accuracy.})
				(21 {OW! Now this is a pain that'll linger! All the Ben Gay in Florida won't relieve this stiffness.})
				(22 {That was a LOOoooong first step.})
				(23 {A droid clumsily snuck up to you and tapped you on the shoulder. "Zap," it said in its droning metallic voice, "you're it."})
				(24 {It's not over 'till the fat lady Orat spits... EEE-UCK! Well, I guess it's over. All over. All over everything!})
				(25 {These guys are in the most inconvenient places! They seem to have this area secured. Your extra crispy parts surely will provide no threat.})
				(26 {Boy, is that typical. Isn't it just like a Sequel Police cyborg to guard the main entrances and exits?})
				(27 {I'm sure the Babes appreciate your sacrifice, too bad you can't experience just how appreciative they are.})
				(28 {Just as you fade from the living organism club you think, in amazement,"So that's what my spleen looks like!"})
				(29 {You were warned not to try to break into the change machine, but did you listen?})
				(30 {The word "Laser" came to mind after each of the first six shots, but only after the seventh blast were you convinced.})
			)
		)
		(switch global186
			(0
				(self setScript: deadScript)
			)
			(1
				(self setScript: lightningScript)
			)
			(2
				(self setScript: spearScript)
			)
			(3
				(self setScript: slimeScript)
			)
			(4
				(self setScript: slugScript)
			)
			(5
				(self setScript: meltedScript)
			)
			(6
				(self setScript: explodeScript)
			)
			(7
				(self setScript: deadScript 0 4)
			)
			(8
				(self setScript: laserScript)
			)
			(9
				(self setScript: laserScript 0 4)
			)
		)
		(gLongSong2 stop:)
		(gLongSong number: 826 vol: 127 loop: 1 flags: 1 playBed:)
	)

	(method (cue)
		(super cue:)
		(gTheIconBar curIcon: (gTheIconBar at: 7))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
		(HandsOn)
		(repeat
			(switch
				(Print
					900
					0
					#at
					83
					150
					#mode
					1
					#button
					{Restore}
					1
					#button
					{Restart}
					2
					#button
					{Quit}
					3
				)
				(1
					(gGame restore:)
				)
				(2
					(gGame restart:)
				)
				(3
					(= gQuit 1)
					(break)
				)
			)
		)
	)
)

(instance deadScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(egoView
					loop: (+ (egoView loop:) register)
					x: (+ (egoView x:) -2)
					y: (+ (egoView y:) 10)
					init:
				)
				(egosHead
					loop: (+ (egosHead loop:) register)
					x: (+ (egosHead x:) -2)
					y: (+ (egosHead y:) 10)
					init:
				)
				(leftHand x: (+ (leftHand x:) -2) y: (+ (leftHand y:) 10) init:)
				(rightHand
					x: (+ (rightHand x:) -2)
					y: (+ (rightHand y:) 10)
					init:
				)
				(= cycles 1)
			)
			(1
				(egosHead setCycle: CT 1 1 self)
				(leftHand setCycle: End)
				(rightHand setCycle: End)
			)
			(2
				(egosHead setCycle: Beg self)
			)
			(3
				(egosHead setCycle: End self)
				(rightHand setCycle: Beg)
			)
			(4
				(rightHand setCycle: End self)
			)
			(5
				(gCurRoom cue:)
			)
		)
	)
)

(instance lightningScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoView x: (+ (egoView x:) -2) y: (+ (egoView y:) 10) init:)
				(egosHead x: (+ (egosHead x:) -2) y: (+ (egosHead y:) 10) init:)
				(leftHand x: (+ (leftHand x:) -2) y: (+ (leftHand y:) 10) init:)
				(rightHand
					x: (+ (rightHand x:) -2)
					y: (+ (rightHand y:) 10)
					init:
				)
				((lightningProp new:) init: x: 67 y: 100)
				((lightningProp new:) init: x: 152 y: 99 loop: 1)
				((lightningProp new:) init: x: 126 y: 90 loop: 1 cel: 2)
				((lightningProp new:) init: x: 93 y: 86 cel: 2)
				((lightningProp new:) init: x: 55 y: 87 loop: 1 cel: 4)
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 135 loop: -1 vol: 105 play:)
				(egosHead setCycle: CT 1 1 self)
				(leftHand setCycle: End)
				(rightHand setCycle: End)
			)
			(2
				(egosHead setCycle: Beg self)
			)
			(3
				(egosHead setCycle: End self)
				(rightHand setCycle: Beg)
			)
			(4
				(rightHand setCycle: End self)
			)
		)
	)
)

(instance spearScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoView x: (+ (egoView x:) -2) y: (+ (egoView y:) 10) init:)
				(egosHead x: (+ (egosHead x:) -2) y: (+ (egosHead y:) 10) init:)
				(leftHand x: (+ (leftHand x:) -2) y: (+ (leftHand y:) 10) init:)
				(rightHand
					x: (+ (rightHand x:) -2)
					y: (+ (rightHand y:) 10)
					init:
				)
				(deathProp view: 995 x: 90 y: 85 priority: 12 init:)
				(= cycles 1)
			)
			(1
				(egosHead setCycle: CT 1 1 self)
				(leftHand setCycle: End)
				(rightHand setCycle: End)
			)
			(2
				(egosHead setCycle: Beg self)
			)
			(3
				(egosHead setCycle: End self)
				(rightHand setCycle: Beg)
			)
			(4
				(rightHand cycleSpeed: 0 setCycle: End self)
			)
			(5
				(leftHand cycleSpeed: 0 setCycle: Beg self)
			)
			(6
				(gCurRoom cue:)
			)
		)
	)
)

(instance slimeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(deathProp init: view: 996 cel: 0 x: 96 y: 127)
				(= cycles 1)
			)
			(1
				(gCurRoom cue:)
			)
		)
	)
)

(instance slugScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(deathProp init: view: 996 cel: 1 x: 96 y: 127)
				(= cycles 1)
			)
			(1
				(gCurRoom cue:)
			)
		)
	)
)

(instance meltedScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoView init: x: 106 y: 116 view: 997)
				(deathProp init: view: 997 loop: 1 x: 92 y: 99 setCycle: Fwd)
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 90 loop: -1 vol: 105 play:)
				(= cycles 39)
			)
			(2
				(deathProp setCycle: End self)
			)
			(3
				(gCurRoom cue:)
			)
		)
	)
)

(instance explodeScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 100])
		(switch (= state newState)
			(0
				(egosHead init: x: 83 y: 102 cel: 2 setCycle: End)
				(leftHand
					init:
					x: 49
					y: 60
					setCycle: Walk
					setMotion: DPath 53 72 39 93 76 80 86 90 self
				)
				(rightHand
					init:
					x: 98
					y: 80
					setCycle: Walk
					setMotion: DPath 118 65 141 78 131 94 157 124 self
				)
			)
			(1 0)
			(2
				(gCurRoom cue:)
			)
		)
	)
)

(instance laserScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(egoView
					loop: (+ (egoView loop:) register)
					x: (+ (egoView x:) -2)
					y: (+ (egoView y:) 10)
					init:
				)
				(egosHead
					loop: (+ (egosHead loop:) register)
					x: (+ (egosHead x:) -2)
					y: (+ (egosHead y:) 10)
					init:
				)
				(leftHand x: (+ (leftHand x:) -2) y: (+ (leftHand y:) 10) init:)
				(rightHand
					x: (+ (rightHand x:) -2)
					y: (+ (rightHand y:) 10)
					init:
				)
				(deathProp
					view: 995
					x: 100
					y: 83
					setCel: (+ 1 (if register 1 else 0))
					setPri: 7
					init:
				)
				(smoke
					x: (+ (smoke x:) -2)
					y: (+ (smoke y:) 10)
					setCycle: Fwd
					init:
				)
				(= cycles 1)
			)
			(1
				(egosHead setCycle: CT 1 1 self)
				(leftHand setCycle: End)
				(rightHand setCycle: End)
			)
			(2
				(egosHead setCycle: Beg self)
			)
			(3
				(egosHead setCycle: End self)
				(rightHand setCycle: Beg)
			)
			(4
				(rightHand cycleSpeed: 0 setCycle: End self)
			)
			(5
				(leftHand cycleSpeed: 0 setCycle: Beg self)
			)
			(6
				(= cycles 10)
			)
			(7
				(gCurRoom cue:)
			)
		)
	)
)

(instance egoView of View
	(properties
		x 97
		y 115
		view 805
		priority 6
		signal 16400
	)
)

(instance egosHead of Prop
	(properties
		x 104
		y 80
		view 805
		loop 1
		priority 8
		signal 16400
		cycleSpeed 1
	)
)

(instance rightHand of Actor
	(properties
		x 84
		y 111
		yStep 1
		view 805
		loop 2
		priority 10
		signal 18448
		cycleSpeed 1
		illegalBits 0
		xStep 1
	)
)

(instance leftHand of Actor
	(properties
		x 146
		y 104
		yStep 1
		view 805
		loop 3
		priority 10
		signal 18448
		cycleSpeed 1
		xStep 1
	)
)

(instance deathProp of Prop
	(properties
		priority 12
		signal 16400
	)
)

(class Shocks of Prop
	(properties
		view 994
		priority 14
		signal 16400
	)

	(method (init)
		(super init:)
		(self setCycle: ForwardCounter 10 self)
	)

	(method (cue)
		(self hide: dispose:)
		(gLongSong2 stop:)
		(super cue:)
		(gCurRoom cue:)
	)
)

(instance lightningProp of Shocks
	(properties)
)

(instance smoke of Prop
	(properties
		x 102
		y 73
		view 995
		loop 1
		priority 14
		signal 16400
	)
)

