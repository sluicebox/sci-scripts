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

(procedure (localproc_1 param1 &tmp temp0 [temp1 1000])
	(cond
		((u< [param1 0] 1000)
			(GetFarText [param1 0] [param1 1] @temp1)
		)
		([param1 0]
			(StrCpy @temp1 [param1 0])
		)
		(else
			(= temp1 0)
		)
	)
	(= temp0 (localproc_0 @temp1))
	(if (== global187 19)
		(Display @temp1 dsCOORD 166 (+ temp0 10) dsWIDTH 130 dsFONT 3 dsALIGN alLEFT)
	else
		(Display @temp1 dsCOORD 168 temp0 dsWIDTH 122 dsFONT 0 dsALIGN alLEFT)
	)
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
		(switch global187
			(0
				(localproc_1 900 0)
			)
			(1
				(localproc_1 900 1)
			)
			(2
				(localproc_1 900 2)
			)
			(3
				(localproc_1 900 3)
			)
			(4
				(localproc_1 900 4)
			)
			(5
				(localproc_1 900 5)
			)
			(6
				(localproc_1 900 6)
			)
			(7
				(localproc_1 900 7)
			)
			(8
				(localproc_1 900 8)
			)
			(9
				(localproc_1 900 9)
			)
			(10
				(localproc_1 900 10)
			)
			(11
				(localproc_1 900 11)
			)
			(12
				(localproc_1 900 12)
			)
			(13
				(localproc_1 900 13)
			)
			(14
				(localproc_1 900 14)
			)
			(15
				(localproc_1 900 15)
			)
			(16
				(localproc_1 900 16)
			)
			(17
				(localproc_1 900 17)
			)
			(18
				(localproc_1 900 18)
			)
			(19
				(localproc_1 900 19)
			)
			(20
				(localproc_1 900 20)
			)
			(21
				(localproc_1 900 21)
			)
			(22
				(localproc_1 900 22)
			)
			(23
				(localproc_1 900 23)
			)
			(24
				(localproc_1 900 24)
			)
			(25
				(localproc_1 900 25)
			)
			(26
				(localproc_1 900 26)
			)
			(27
				(localproc_1 900 27)
			)
			(28
				(localproc_1 900 28)
			)
			(29
				(localproc_1 900 29)
			)
			(30
				(localproc_1 900 30)
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
					31
					#at
					(proc0_19 75 83 68 83 83)
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

