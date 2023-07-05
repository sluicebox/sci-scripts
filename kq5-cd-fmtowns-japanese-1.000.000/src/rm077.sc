;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 77)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use Motion)
(use Actor)
(use System)

(public
	rm077 0
)

(local
	local0
	local1
	local2
)

(instance rm077 of KQ5Room
	(properties
		picture 77
		south 13
	)

	(method (init)
		(super init:)
		(HandsOff)
		(= local0 (gGame setCursor: 5 1))
		(self setScript: cartoon setRegions: 763) ; cartoonRegion
		(muscha init:)
		(gEgo normal: 0 view: 776 loop: 3 cel: 1 posn: 175 150 init:)
		((gEgo head:) hide:)
		(gGlobalSound number: 800 loop: -1 vol: 127 playBed:)
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

	(method (handleEvent event)
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
		(gGame setCursor: local0 1)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)

	(method (doit &tmp [temp0 2])
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(smallArm cycleSpeed: 3 setCycle: End self init:)
				(muscha loop: 0 cel: 0)
			)
			(1
				(= local2 1)
				(smallArm loop: 5 setCycle: Fwd)
				(= cycles 25)
			)
			(2
				(gCurRoom drawPic: 78)
				(smallArm dispose:)
				(ball1 init:)
				(ball2 cycleSpeed: 3 setCycle: Fwd init:)
				(muscha
					view: 778
					loop: 0
					cycleSpeed: 0
					setScript: (catMove new:)
					posn: 156 70
				)
				(theMouth cycleSpeed: 3 init:)
				(wArm cycleSpeed: 2 setScript: (catMove new:) init:)
				(eArm cycleSpeed: 2 setScript: (catMove new:) init:)
				(gEgo hide:)
				((gEgo head:) hide:)
				(= cycles 1)
			)
			(3
				(= seconds 1)
			)
			(4
				(theMouth setCycle: MouthSync 973)
				(Say 973 self)
			)
			(5
				(theMouth setScript: 0 setCycle: 0 cel: 0)
				(= cycles 1)
			)
			(6
				(cls)
				(gCurRoom drawPic: 77)
				(ball1
					view: 776
					loop: 7
					posn: 126 100
					setCycle: Fwd
					cycleSpeed: 3
				)
				(ball2 dispose:)
				(muscha
					view: 776
					loop: 0
					cel: 0
					cycleSpeed: 5
					setScript: (muschaMove new:)
					posn: 127 105
				)
				(wArm hide:)
				(eArm hide:)
				(gEgo
					normal: 0
					view: 776
					loop: 3
					setCel: 0
					posn: 152 136
					setPri: 9
					show:
				)
				(theMouth setCycle: 0 hide:)
				(Say 974 self)
			)
			(7
				(Say 975 self)
			)
			(8
				(= local2 0)
				(muscha loop: 2 cel: 0 setCycle: End self)
			)
			(9
				(= local2 1)
				(gGlobalSound number: 801 loop: -1 playBed:)
				(cls)
				(ball1 dispose:)
				(muscha hide:)
				(gEgo hide:)
				(gCurRoom drawPic: 79)
				(mordac init:)
				(mHand cycleSpeed: 2 setCycle: Fwd init:)
				(cat cycleSpeed: 1 setScript: catMove init:)
				(= cycles 1)
			)
			(10
				(= seconds 2)
			)
			(11
				(mordac setCycle: MouthSync 927)
				(Say 927 self)
			)
			(12
				(cls)
				(mordac setCycle: MouthSync 928)
				(Say 928 self)
			)
			(13
				(cls)
				(mordac setCycle: MouthSync 929)
				(Say 929 self)
			)
			(14
				(cls)
				(mordac setCycle: 0)
				(Say 930 self)
			)
			(15
				(cls)
				(gCurRoom drawPic: 80)
				(mordac hide:)
				(mHand hide:)
				(cat hide:)
				(wArm hide:)
				(eArm hide:)
				(alex init: setCycle: End self cycleSpeed: 3)
			)
			(16
				(alex setCycle: Beg self)
			)
			(17
				(alexFace init: setCycle: MouthSync 931)
				(Say 931 self)
			)
			(18
				(alexFace hide:)
				(alex setCycle: End self)
			)
			(19
				(alex setCycle: Beg self)
			)
			(20
				(alexFace show: setCycle: MouthSync 932)
				(Say 932 self)
			)
			(21
				(alexFace hide:)
				(alex setCycle: End self)
			)
			(22
				(cls)
				(alex dispose:)
				(alexFace setCycle: 0 dispose:)
				(gCurRoom drawPic: 79)
				(mordac show:)
				(mHand show:)
				(cat show:)
				(mordac setCycle: MouthSync 933)
				(Say 933 self)
			)
			(23
				(cls)
				(mordac setCycle: MouthSync 934)
				(Say 934 self)
			)
			(24
				(gGlobalSound number: 802 loop: -1 playBed:)
				(cls)
				(gCurRoom drawPic: 77)
				(mordac setCycle: 0 dispose:)
				(mHand dispose:)
				(cat dispose:)
				(muscha
					view: 776
					loop: 0
					cel: 0
					posn: 127 105
					setCycle: 0
					setScript: 0
					show:
				)
				(gEgo show:)
				(smallMouth init: setCycle: MouthSync 976)
				(Say 976 self)
			)
			(25
				(smallMouth hide:)
				(muscha loop: 8 cel: 0 cycleSpeed: 4 setCycle: End self)
			)
			(26
				(muscha loop: 9 cel: 0 setCycle: End self)
			)
			(27
				(smallMouth setCycle: MouthSync 977 show:)
				(Say 977 self)
				(gEgo get: 27) ; Amulet
				(SetScore 2)
			)
			(28
				(smallMouth setCycle: 0 dispose:)
				(cls)
				(gCurRoom drawPic: 78)
				(gEgo hide:)
				(muscha view: 778 setScript: (mouthMove new:) posn: 156 70)
				(theMouth
					view: 778
					loop: 1
					cel: 2
					posn: 156 92
					cycleSpeed: 3
					show:
				)
				(wArm show:)
				(eArm show:)
				(= cycles 1)
			)
			(29
				(= seconds 2)
			)
			(30
				(theMouth setCycle: MouthSync 978)
				(Say 978 self)
			)
			(31
				(theMouth setScript: 0 setCycle: 0 cel: 0)
				(muscha setScript: 0 setCycle: 0 cel: 0)
				(cls)
				(Say 979 self)
			)
			(32
				(gGlobalSound fade:)
				(cls)
				(gCurRoom newRoom: 13)
			)
		)
	)
)

(instance catMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: Beg)
				(= state -1)
				(= seconds (Random 5 8))
			)
		)
	)
)

(instance mouthMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: (Random 0 8))
				(= state -1)
				(= cycles 3)
			)
		)
	)
)

(instance muschaMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: 5 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(client loop: 1 cel: 0 setCycle: Fwd)
			)
		)
	)
)

(instance faceMove of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(alexFace hide:)
				(alex setCycle: Beg self)
			)
			(1
				(alexFace show: setCycle: Fwd)
				(= seconds (Random 3 5))
				(= state -1)
			)
		)
	)
)

(instance alex of Prop
	(properties
		x 173
		y 102
		view 784
	)
)

(instance alexFace of Prop
	(properties
		x 181
		y 65
		view 784
		loop 1
		cel 5
		priority 15
		signal 16
		cycleSpeed 3
	)
)

(instance smallArm of Prop
	(properties
		x 127
		y 105
		view 776
		loop 4
		priority 4
		signal 16
	)
)

(instance smallMouth of Prop
	(properties
		x 126
		y 94
		view 776
		loop 6
		priority 4
		signal 16
	)
)

(instance muscha of Prop
	(properties
		x 127
		y 105
		view 776
		priority 3
		signal 16
	)
)

(instance theMouth of Prop
	(properties
		x 156
		y 92
		view 778
		loop 1
		cel 2
		priority 5
		signal 16
	)
)

(instance wArm of Prop
	(properties
		x 130
		y 121
		view 778
		loop 3
		priority 8
		signal 16
	)
)

(instance eArm of Prop
	(properties
		x 182
		y 125
		view 778
		loop 2
		priority 8
		signal 16
	)
)

(instance mordac of Prop
	(properties
		x 166
		y 60
		view 782
		loop 3
		priority 9
		signal 16
	)
)

(instance mHand of Prop
	(properties
		x 167
		y 82
		view 782
		cel 4
		priority 7
		signal 16
	)
)

(instance cat of Prop
	(properties
		x 189
		y 80
		view 782
		loop 1
		priority 7
		signal 16
	)
)

(instance ball1 of Prop
	(properties
		x 161
		y 112
		view 778
		loop 4
		priority 15
		signal 17
	)
)

(instance ball2 of Prop
	(properties
		x 161
		y 112
		view 778
		loop 5
		cel 2
		priority 14
		signal 16
	)
)

