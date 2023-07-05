;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 680)
(include sci.sh)
(use Main)
(use KQ5Room)
(use Sync)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	cdMushkaToon 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance cdMushkaToon of KQ5Room
	(properties
		picture 77
		south 13
	)

	(method (init)
		(super init:)
		(= local4 (gGame egoMoveSpeed:))
		(gGame egoMoveSpeed: 1)
		(LoadMany rsVIEW 778 782 784 776 1027 1031)
		(Load rsPIC 78)
		(Load rsSCRIPT 929)
		(Load rsSOUND 800)
		(LoadMany rsSYNC 973 927 928 929 931 932 933 934 976 977 978)
		(= local3 0)
		(HandsOff)
		(= local0 (gGame setCursor: gNarrator 1))
		(muscha init:)
		(gEgo normal: 0 view: 776 loop: 3 cel: 1 posn: 175 150 init:)
		((gEgo head:) hide:)
		((ScriptID 763) doit:) ; cartoonCode
		(self setScript: cartoon)
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
		(gGame egoMoveSpeed: local4)
		(super dispose:)
	)
)

(instance cartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsPIC 78)
				(smallArm cycleSpeed: 3 setCycle: End self init:)
				(muscha loop: 0 cel: 0)
				(theMouth init: hide:)
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
				(theMouth cel: 4 show:)
				(wArm cycleSpeed: 2 setScript: (catMove new:) init:)
				(eArm cycleSpeed: 2 setScript: (catMove new:) init:)
				(gEgo hide:)
				((gEgo head:) hide:)
				(= cycles 1)
			)
			(3
				(theMouth setCycle: MouthSync 973)
				(Say 973 self)
			)
			(4
				(theMouth cel: 4)
				(= cycles 1)
			)
			(5
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
					setScript: (muschaMove)
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
				(theMouth hide:)
				(= cycles 1)
			)
			(6
				(= seconds 2)
			)
			(7
				(Say 974 self)
			)
			(8
				(Say 975 self)
			)
			(9
				(= local2 0)
				(muscha loop: 2 cel: 0 setCycle: End self)
				(gGlobalSound fade:)
			)
			(10
				(LoadMany rsVIEW 778 782 784 776 1027 1031)
				(Load rsPIC 79)
				(Load rsPIC 80)
				(Load rsSCRIPT 929)
				(LoadMany rsSYNC 973 927 928 929 931 932 933 934 976 977 978)
				(Load rsSOUND 801)
				(= local2 1)
				(gGlobalSound number: 801 loop: -1 playBed:)
				(ball1 dispose:)
				(muscha hide:)
				(gEgo hide:)
				(gCurRoom drawPic: 79)
				(theMouth changeMouth: 2 show:)
				(mHand cycleSpeed: 2 setCycle: Fwd init:)
				(cat cycleSpeed: 1 setScript: catMove init:)
				(= cycles 1)
			)
			(11
				(= seconds 2)
			)
			(12
				(theMouth setCycle: MouthSync 927)
				(Say 927 self)
			)
			(13
				(cls)
				(theMouth setCycle: MouthSync 928)
				(Say 928 self)
			)
			(14
				(cls)
				(theMouth setCycle: MouthSync 929)
				(Say 929 self)
			)
			(15
				(cls)
				(theMouth setCycle: 0)
				(Say 930 self)
			)
			(16
				(cls)
				(gCurRoom drawPic: 80)
				(theMouth changeMouth: 3 hide:)
				(mHand hide:)
				(cat hide:)
				(wArm hide:)
				(eArm hide:)
				(alex init: setCycle: End self cycleSpeed: 3)
			)
			(17
				(alex setCycle: Beg self)
			)
			(18
				(theMouth setCycle: MouthSync 931 show:)
				(Say 931 self)
			)
			(19
				(theMouth hide:)
				(alex setCycle: End self)
			)
			(20
				(alex setCycle: Beg self)
			)
			(21
				(theMouth setCycle: MouthSync 932 show:)
				(Say 932 self)
			)
			(22
				(theMouth hide:)
				(alex setCycle: Beg self)
			)
			(23
				(cls)
				(alex dispose:)
				(gCurRoom drawPic: 79)
				(theMouth changeMouth: 2 show:)
				(mHand show:)
				(cat show:)
				(= cycles 1)
			)
			(24
				(= seconds 2)
			)
			(25
				(theMouth setCycle: MouthSync 933)
				(Say 933 self)
			)
			(26
				(cls)
				(theMouth setCycle: MouthSync 934)
				(Say 934 self)
			)
			(27
				(LoadMany rsVIEW 778 782 784 776 1027 1031)
				(Load rsPIC 77)
				(Load rsPIC 78)
				(Load rsSCRIPT 929)
				(LoadMany rsSYNC 973 927 928 929 931 932 933 934 976 977 978)
				(Load rsSOUND 65)
				(Load rsSOUND 802)
				(gGlobalSound number: 802 loop: -1 playBed:)
				(gCurRoom drawPic: 77)
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
				(theMouth changeMouth: 1 setCycle: MouthSync 976)
				(Say 976 self)
			)
			(28
				(theMouth hide:)
				(muscha loop: 8 cel: 0 cycleSpeed: 4 setCycle: End self)
			)
			(29
				(theMouth x: (+ (theMouth x:) 1) show:)
				(theMouth setCycle: MouthSync 977)
				(Say 977 self)
			)
			(30
				(theMouth hide:)
				(gEgo get: 27) ; Amulet
				(SetScore 2)
				(muscha loop: 9 cel: 0 setCycle: End self)
			)
			(31
				(cls)
				(gCurRoom drawPic: 78)
				(gEgo hide:)
				(muscha view: 778 posn: 156 70)
				(theMouth changeMouth: 0 show:)
				(wArm show:)
				(eArm show:)
				(= cycles 1)
			)
			(32
				(= seconds 2)
			)
			(33
				(theMouth setCycle: MouthSync 978)
				(Say 978 self)
			)
			(34
				(theMouth cel: 4)
				(muscha setScript: 0 setCycle: 0 cel: 0)
				(Say 979 self)
			)
			(35
				(theMouth setCycle: 0 cel: 4)
				(gGlobalSound fade:)
				(= seconds 3)
			)
			(36
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

(instance muschaMove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cycleSpeed: 5 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(client loop: 1 cel: 0 setCycle: Fwd)
				(= cycles 1)
			)
			(2
				(self dispose:)
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
		x 128
		y 95
		view 1027
		cel 4
		priority 5
		signal 16
	)

	(method (changeMouth param1)
		(switch param1
			(0
				(theMouth
					view: 1027
					loop: 0
					cel: 4
					x: 128
					y: 95
					priority: 5
					signal: 16
				)
			)
			(1
				(theMouth
					view: 776
					loop: 6
					cel: 0
					x: 126
					y: 94
					priority: 4
					signal: 16
				)
			)
			(2
				(theMouth
					view: 1031
					loop: 3
					cel: 4
					x: 157
					y: 70
					priority: 9
					signal: 16
				)
			)
			(3
				(theMouth
					view: 784
					loop: 1
					cel: 5
					x: 181
					y: 65
					priority: 15
					signal: 16
				)
			)
		)
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

