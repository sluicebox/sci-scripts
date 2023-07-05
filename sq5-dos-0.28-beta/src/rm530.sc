;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 530)
(include sci.sh)
(use Main)
(use PriorityTalker)
(use Print)
(use Talker)
(use Feature)
(use LoadMany)
(use Jump)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm530 0
	cTalker 11
	genTalker 15
)

(local
	local0
	local1
)

(instance rm530 of Rm
	(properties
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 545)
		(theCell init: setOnMeCheck: 1 4)
		(theCliffy init:)
		(theCellExit init:)
		(theLock init:)
		(gWalkHandler addToFront: theCellExit)
		(switch gPrevRoomNum
			(510
				(gCurRoom picture: 71 setScript: sInJail1)
			)
			(else
				(gEgo get: 8) ; Spike
				(gCurRoom picture: 71 setScript: sInJail1)
			)
		)
		(super init: &rest)
		(gGame handsOn:)
	)

	(method (dispose)
		(gWalkHandler delete: theCellExit)
		(DisposeScript 991)
		(super dispose: &rest)
	)
)

(instance sInJail of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 49)
				(gGame handsOff:)
				(cliffy init: x: 80 y: 85)
				(cliffyHead init: x: 129 y: 91)
				(cArmL init: loop: 1 cel: 0 x: 83 y: 122)
				(cArmR init: loop: 1 cel: 1 x: 162 y: 122)
				(bars init: setPri: 7 stopUpd:)
				(c1 init:)
				(c2 init:)
				(c3 init:)
				(c4 init:)
				(c5 init:)
				(c6 init:)
				(c7 init:)
				(c8 init:)
				(c9 init:)
				(c10 init:)
				(c11 init:)
				(c12 init:)
				(c13 init:)
				(= cycles 1)
			)
			(1
				(cliffy x: 91 y: 85)
				(cliffyHead init: x: 140 y: 91)
				(cArmL init: loop: 1 cel: 0 x: 94 y: 122)
				(cArmR init: loop: 1 cel: 1 x: 171 y: 122)
				(= seconds 1)
			)
			(2
				(cliffy x: 101 y: 85)
				(cliffyHead init: x: 150 y: 91)
				(cArmL dispose:)
				(cArmR dispose:)
				(armbar init:)
				(armbar3 init:)
				(hand1 init:)
				(hand2 init:)
				(= seconds 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sInJail1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 49)
				(gGame handsOff:)
				(cliffy init: stopUpd:)
				(cliffyHead init:)
				(armbar init:)
				(armbar3 init:)
				(hand1 init:)
				(hand2 init:)
				(bars init: setPri: 7 stopUpd:)
				(c1 init:)
				(c2 init:)
				(c3 init:)
				(c4 init:)
				(c5 init:)
				(c6 init:)
				(c7 init:)
				(c8 init:)
				(c9 init:)
				(c10 init:)
				(c11 init: stopUpd:)
				(c12 init: stopUpd:)
				(c13 init: stopUpd:)
				(= cycles 1)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sCliffySpeaks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gMessager say: 4 0 0 0 self) ; "Boy! Am I glad to see you, captain!"
			)
			(2
				(= local0 1)
				(armbar dispose:)
				(armbar3 dispose:)
				(hand1 dispose:)
				(hand2 dispose:)
				(cArmL init:)
				(cArmR init:)
				(= cycles 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sSpikeOnCell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gSq5Music1 number: 23 loop: -1 play:)
				(if (== local1 0)
					(armbar dispose:)
					(armbar3 dispose:)
					(hand1 dispose:)
					(hand2 dispose:)
					(cArmL init:)
					(cArmR init:)
					(= cycles 1)
				else
					(= cycles 1)
				)
			)
			(1
				(spike init: setLoop: 4)
				(tail init: setCycle: Fwd)
				(= seconds 2)
			)
			(2
				(spike setCycle: Beg self)
			)
			(3
				(acid1 init: x: 116 y: 99)
				(acid2 init: x: 125 y: 122)
				(gSq5Music2 number: 222 setLoop: -1 play:)
				(spike setMotion: JumpTo 161 132 self)
			)
			(4
				(= seconds 2)
			)
			(5
				(spike setCycle: Beg self)
			)
			(6
				(fAcid1 init: x: 114 y: 99)
				(fAcid2 init: x: 125 y: 122)
				(acid1 x: 142 y: 120)
				(acid2 x: 160 y: 123)
				(c9 dispose:)
				(c8 dispose:)
				(spike setMotion: JumpTo 193 131 self)
			)
			(7
				(= seconds 2)
			)
			(8
				(spike setCycle: Beg self)
			)
			(9
				(fAcid1 init: x: 160 y: 123)
				(fAcid2 init: x: 142 y: 120)
				(acid1 x: 194 y: 120)
				(acid2 x: 177 y: 122)
				(c7 dispose:)
				(c6 dispose:)
				(spike setMotion: JumpTo 213 124 self)
			)
			(10
				(= seconds 2)
			)
			(11
				(spike setCycle: Beg self)
			)
			(12
				(spike setMotion: JumpTo 199 97 self)
				(fAcid1 init: x: 194 y: 120)
				(fAcid2 init: x: 177 y: 122)
				(acid1 x: 211 y: 114)
				(acid2 hide:)
				(c5 dispose:)
				(c4 dispose:)
			)
			(13
				(= seconds 2)
			)
			(14
				(spike setLoop: 5 setCycle: Beg self)
			)
			(15
				(spike setMotion: JumpTo 168 70 self)
				(fAcid1 init: x: 211 y: 114)
				(fAcid2 hide:)
				(acid1 x: 200 y: 92)
				(acid2 hide:)
				(c3 dispose:)
			)
			(16
				(= seconds 2)
			)
			(17
				(spike setCycle: Beg self)
			)
			(18
				(spike setMotion: JumpTo 132 73 self)
				(fAcid1 init: x: 200 y: 92)
				(fAcid2 hide:)
				(acid1 x: 173 y: 63)
				(acid2 show: x: 153 y: 56)
				(c10 dispose:)
				(c2 dispose:)
			)
			(19
				(= seconds 2)
			)
			(20
				(spike setCycle: Beg self)
			)
			(21
				(spike setMotion: JumpTo 14 78 self)
				(fAcid1 init: x: 173 y: 63)
				(fAcid2 init: show: x: 153 y: 56)
				(acid1 x: 133 y: 49)
				(acid2 show: x: 124 y: 70)
				(c1 dispose:)
				(c13 dispose:)
			)
			(22
				(= seconds 2)
			)
			(23
				(acid1 dispose:)
				(acid2 dispose:)
				(fAcid1 init: x: 133 y: 49)
				(fAcid2 init: show: x: 124 y: 70)
				(c12 dispose:)
				(c11 dispose:)
				(ClearFlag 49)
				(= seconds 1)
			)
			(24
				(gSq5Music2 stop:)
				(fAcid1 dispose:)
				(fAcid2 dispose:)
				(acid1 dispose:)
				(acid2 dispose:)
				(tail dispose:)
				(bars startUpd: setCel: 0)
				(= seconds 1)
			)
			(25
				(spike dispose:)
				(bars setMotion: MoveTo 140 220 self)
				(cliffyHead setCel: 2)
			)
			(26
				(gSq5Music2 number: 517 loop: 1 play:)
				(gMessager say: 2 0 0 0 self) ; "I guess that little beastie is good for something after all sir."
			)
			(27
				(SetScore 217 50)
				(= seconds 3)
			)
			(28
				(gSq5Music1 number: 36 setLoop: -1 play:)
				(bars dispose:)
				(gCurRoom newRoom: 510)
			)
		)
	)
)

(instance acid1 of Prop
	(properties
		x 173
		y 61
		view 545
		loop 12
		priority 10
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 12 setCycle: Fwd)
	)
)

(instance acid2 of Prop
	(properties
		x 173
		y 61
		view 545
		loop 12
		priority 10
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 12 setCycle: Fwd)
	)
)

(instance fAcid1 of Prop
	(properties
		x 173
		y 61
		view 545
		loop 13
		priority 10
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 13 cel: 0 cycleSpeed: 10 setCycle: End)
	)
)

(instance fAcid2 of Prop
	(properties
		x 173
		y 61
		view 545
		loop 13
		priority 10
		signal 16
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 13 cel: 0 cycleSpeed: 10 setCycle: End)
	)
)

(instance c1 of Prop
	(properties
		x 173
		y 61
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c2 of Prop
	(properties
		x 193
		y 70
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c3 of Prop
	(properties
		x 208
		y 111
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c4 of Prop
	(properties
		x 194
		y 118
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c5 of Prop
	(properties
		x 177
		y 120
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c6 of Prop
	(properties
		x 160
		y 121
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c7 of Prop
	(properties
		x 142
		y 118
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c8 of Prop
	(properties
		x 125
		y 120
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c9 of Prop
	(properties
		x 114
		y 97
		view 545
		loop 7
		cel 2
		priority 9
		signal 16
	)
)

(instance c10 of Prop
	(properties
		x 194
		y 90
		view 545
		loop 7
		cel 3
		priority 9
		signal 16
	)
)

(instance c11 of Prop
	(properties
		x 124
		y 68
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c12 of Prop
	(properties
		x 133
		y 47
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance c13 of Prop
	(properties
		x 153
		y 54
		view 545
		loop 7
		cel 1
		priority 9
		signal 16
	)
)

(instance cliffy of View
	(properties
		x 101
		y 85
		noun 3
		view 545
		priority 6
		signal 16400
	)
)

(instance cliffyHead of Prop
	(properties
		x 150
		y 91
		noun 3
		view 545
		loop 2
		priority 6
		signal 16384
	)
)

(instance cArmL of Prop
	(properties
		x 182
		y 122
		view 545
		loop 1
		cel 1
		priority 5
		signal 16
	)
)

(instance cArmR of Prop
	(properties
		x 104
		y 122
		view 545
		loop 1
		priority 5
		signal 16
	)
)

(instance armbar of View
	(properties
		x 108
		y 123
		view 545
		loop 1
		cel 4
		priority 5
		signal 16
	)
)

(instance armbar3 of View
	(properties
		x 175
		y 120
		view 545
		loop 1
		cel 5
		priority 5
		signal 16
	)
)

(instance hand1 of View
	(properties
		x 136
		y 125
		view 545
		loop 1
		cel 6
		priority 10
		signal 16400
	)
)

(instance hand2 of View
	(properties
		x 196
		y 120
		view 545
		loop 1
		cel 7
		priority 10
		signal 16400
	)
)

(instance spike of Actor
	(properties
		x 122
		y 108
		noun 6
		view 545
		loop 4
		priority 12
		signal 16400
	)
)

(instance tail of Actor
	(properties
		x 102
		y 131
		view 545
		loop 8
		priority 11
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(self x: (- (spike x:) 32) y: (+ (spike y:) 7))
	)

	(method (doit)
		(switch (spike loop:)
			(4
				(self setLoop: 8 x: (- (spike x:) 32) y: (+ (spike y:) 7))
			)
			(5
				(self setLoop: 9 x: (+ (spike x:) 33) y: (+ (spike y:) 7))
			)
			(11
				(self x: -20 y: 0)
			)
		)
		(super doit: &rest)
	)
)

(instance bars of Actor
	(properties
		x 140
		y 94
		view 545
		loop 7
		priority 7
		signal 16400
	)

	(method (init)
		(self setLoop: 7 cel: 0 setStep: 10 10)
		(super init: &rest)
	)
)

(instance cTalker of PriorityTalker
	(properties
		x 133
		y 42
		view 545
		loop 2
		priority 5
		signal 16400
		talkWidth 200
	)

	(method (display param1 &tmp temp0 temp1)
		(= temp0 talkWidth)
		((= temp1 (gSystemWindow new:)) color: color back: back)
		(if (and (not (HaveMouse)) (!= gTheCursor 996))
			(= saveCursor gTheCursor)
			(gGame setCursor: 996)
		else
			(= saveCursor 0)
		)
		(if showTitle
			(Print addTitle: name)
		)
		(Print
			window: temp1
			posn: x y
			font: font
			width: temp0
			addText: param1
			modeless: 1
			init:
		)
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(gSystemWindow tailX: 120 tailY: 40 xOffset: -5 isBottom: 1)
		(if (not (IsFlag 49))
			(self cel: 2 y: 41)
		)
		(super init: 0 0 cMouth &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance cMouth of Prop
	(properties
		nsTop 31
		nsLeft 3
		view 545
		loop 3
		priority 5
		signal 16400
	)

	(method (init)
		(self setPri: 5)
		(super init: &rest)
	)
)

(instance genTalker of Narrator
	(properties
		talkWidth 200
	)

	(method (init)
		(= font gUserFont)
		(= gSystemWindow gSpeakWindow)
		(switch global122
			(19
				(gSystemWindow tailX: 160 tailY: 180 xOffset: 0 isBottom: 1)
			)
		)
		(super init: &rest)
	)

	(method (dispose)
		(= gSystemWindow gSq5Win)
		(super dispose: &rest)
	)
)

(instance theCell of Feature
	(properties
		x 110
		y 170
		noun 1
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31 ; Spike
				(gCurRoom setScript: sSpikeOnCell)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theCellExit of Feature
	(properties
		x 1
		y 1
		nsBottom 200
		nsRight 320
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom newRoom: 510)
			)
			(3 ; Walk
				(gCurRoom newRoom: 510)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theCliffy of Feature
	(properties
		x 120
		y 180
		z 20
		noun 3
		nsTop 49
		nsLeft 140
		nsBottom 82
		nsRight 174
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if (== local0 0)
					(gCurRoom setScript: sCliffySpeaks)
				else
					(gMessager say: 4 0 1 0) ; "Talk is cheap Captain, I think you'd better find me a way outta here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theLock of Feature
	(properties
		x 216
		y 180
		noun 5
		nsTop 33
		nsLeft 216
		nsBottom 108
		nsRight 246
	)
)

