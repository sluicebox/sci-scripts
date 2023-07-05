;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 330)
(include sci.sh)
(use Main)
(use n013)
(use verseScript)
(use RTEyeCycle)
(use Feature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	fairArchery 0
)

(local
	local0
	local1 = 1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9 = 1
	local10
	local11
	[local12 6]
	[local18 6]
	[local24 3]
	[local27 3]
	[local30 3]
	[local33 3]
	[local36 3]
	[local39 3]
	local42
	local43
	local44
	local45
	local46
	[local47 3] = [105 107 109]
	[local50 3] = [159 158 158]
	[local53 3] = [51 60 76]
	[local56 3] = [276 266 248]
	[local59 3] = [126 120 108]
	[local62 3] = [5 4 3]
	[local65 3] = [36 39 42]
	[local68 3] = [60 58 70]
	[local71 3] = [3 4 5]
	[local74 3] = [0 6 9]
	local77
	local78
	local79
	local80
	local81 = 1
	local82 = 1
	local83
	local84
	local85
	[local86 4] = [1330 0 1 0]
	[local90 4] = [1330 1 1 0]
	[local94 4] = [1330 2 1 0]
	[local98 4] = [1330 3 1 0]
	[local102 4] = [1330 4 1 0]
	[local106 4] = [1330 5 1 0]
	[local110 4] = [1330 14 1 0]
	[local114 4] = [1330 6 1 0]
	[local118 4] = [1330 7 1 0]
	[local122 4] = [1330 8 1 0]
	[local126 4] = [1330 9 1 0]
	[local130 4] = [1330 10 1 0]
	[local134 4] = [1330 11 1 0]
	[local138 5] = [1330 12 1 1 0]
	[local143 9] = [327 0 3 4 15 31 12 21 21]
)

(procedure (localproc_0)
	(switch local85
		(0
			(= local44 0)
			(= local45 151)
			(= local46 129)
			(middleTarget x: local45 y: 129)
			(targetLeft x: (- local45 106) y: local46)
			(targetRight x: (+ local45 132) y: local46)
		)
		(1
			(= local44 1)
			(= local45 152)
			(= local46 122)
			(middleTarget x: local45 y: 122)
			(targetLeft x: (- local45 97) y: (+ local46 1))
			(targetRight x: (+ local45 119) y: (+ local46 1))
		)
		(2
			(= local44 2)
			(= local45 153)
			(= local46 110)
			(middleTarget x: local45 y: 110)
			(targetLeft x: (- local45 81) y: (+ local46 1))
			(targetRight x: (+ local45 100) y: (+ local46 1))
		)
	)
)

(procedure (localproc_1)
	(= local8
		(/
			(if (== global125 2)
				(switch (Random 0 2)
					(0 280)
					(1 320)
					(2 360)
				)
			else
				(switch (Random 0 3)
					(0 120)
					(1 160)
					(2 200)
					(3 240)
				)
			)
			global125
		)
	)
)

(procedure (localproc_2)
	(if (== global125 2)
		(= local79 (Random 2 4))
	else
		(= local79 (Random 0 3))
	)
	(cond
		((<= local79 1)
			(= local80 (Random 10 12))
		)
		((<= local79 3)
			(= local80 (Random 20 24))
		)
		((= local79 4)
			(= local80 (Random 65 78))
		)
	)
	(windFlags init:)
)

(procedure (localproc_3)
	(windFlags hide:)
	(middleTarget hide:)
	(targetLeft hide:)
	(targetRight hide:)
	(bowHand hide:)
	(bow hide:)
	(arrow hide:)
	(gCurRoom drawPic: 803 3)
)

(procedure (localproc_4)
	(gCurRoom drawPic: 330)
	(windFlags show:)
	(middleTarget show:)
	(targetLeft show:)
	(targetRight show:)
	(bowHand show:)
	(arrow cel: 0 posn: (+ (bowHand x:) 22) (- (bowHand y:) 106) show:)
	(= local9 1)
	(bow show:)
	(= local4 0)
)

(procedure (localproc_5)
	(switch local85
		(0
			(switch (Random 0 3)
				(0
					(= local42 (Random 272 280))
					(= local43 (Random 120 124))
				)
				(1
					(= local42 (Random 279 281))
					(= local43 (Random 124 128))
				)
				(2
					(= local42 (Random 271 280))
					(= local43 (Random 128 130))
				)
				(3
					(= local42 (Random 268 272))
					(= local43 (Random 123 129))
				)
			)
		)
		(1
			(switch (Random 0 3)
				(0
					(= local42 (Random 261 269))
					(= local43 (Random 115 119))
				)
				(1
					(= local42 (Random 267 270))
					(= local43 (Random 119 122))
				)
				(2
					(= local42 (Random 261 269))
					(= local43 (Random 122 124))
				)
				(3
					(= local42 (Random 260 263))
					(= local43 (Random 118 122))
				)
			)
		)
		(2
			(switch (Random 0 3)
				(0
					(= local42 (Random 244 251))
					(= local43 (Random 105 106))
				)
				(1
					(= local42 (Random 250 251))
					(= local43 (Random 105 109))
				)
				(2
					(= local42 (Random 244 251))
					(= local43 (Random 109 110))
				)
				(3
					(= local42 (Random 244 246))
					(= local43 (Random 106 109))
				)
			)
		)
	)
)

(procedure (localproc_6 &tmp temp0)
	(bigTarget x: 151 show:)
	(for ((= temp0 0)) (<= temp0 2) ((++ temp0))
		([local18 temp0] show:)
	)
)

(procedure (localproc_7 &tmp temp0)
	(bigTarget hide:)
	(for ((= temp0 0)) (<= temp0 2) ((++ temp0))
		([local18 temp0] hide:)
	)
)

(procedure (localproc_8 &tmp temp0)
	(bigTarget x: 63 show:)
	(for ((= temp0 0)) (<= temp0 2) ((++ temp0))
		([local30 temp0] show:)
	)
)

(procedure (localproc_9 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 2) ((++ temp0))
		([local30 temp0] hide:)
	)
)

(procedure (localproc_10 &tmp temp0)
	(bigTarget x: 256 show:)
	(for ((= temp0 0)) (<= temp0 2) ((++ temp0))
		([local33 temp0] show:)
	)
)

(procedure (localproc_11 &tmp temp0)
	(for ((= temp0 0)) (<= temp0 2) ((++ temp0))
		([local33 temp0] hide:)
	)
)

(procedure (localproc_12)
	(local5 loop: 2 cel: 0 posn: 16 166 show:)
)

(procedure (localproc_13)
	(local5 loop: 1 cel: 0 posn: 309 164 show:)
)

(instance cleanTarget of Code
	(properties)

	(method (doit &tmp [temp0 2])
		(while (>= (-- local10) 0)
			([local12 local10] dispose:)
			([local12 local10] hide:)
		)
		(= local10 0)
		(while (>= (-- local11) 0)
			([local27 local11] dispose:)
		)
		(= local11 0)
	)
)

(instance fairArchery of Rm
	(properties
		picture 330
		style -32765
	)

	(method (init)
		(= local0 (gGame egoMoveSpeed:))
		(gTheIconBar disable: 2 3 5 6 7)
		(gPMouse joyInc: 2)
		(super init:)
		(drumSound init:)
		(= local84 gUseSortedFeatures)
		(= gUseSortedFeatures 0)
		(if (> global125 1)
			(= local85 (- global125 2))
		)
		(= local78 global125)
		(bowHand setPri: 12 loop: 1 cel: 1 init:)
		(bow setPri: 12 loop: 0 cel: 0 init:)
		(arrow setPri: 14 loop: 0 cel: 0 init:)
		(localproc_0)
		(middleTarget init:)
		(targetLeft init:)
		(targetRight init:)
		(bigTarget setPri: 14 init: hide:)
		(localproc_1)
		(localproc_2)
		(targetArea init:)
	)

	(method (dispose)
		(shootSound dispose:)
		(gGame setSpeed: local0)
		(gPMouse joyInc: 5)
		(= gUseSortedFeatures local84)
		(super dispose:)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((not (-- local8))
				(localproc_2)
				(localproc_1)
			)
			((and (== global125 1) (not (IsFlag 10)))
				(gCurRoom setScript: goToGoldenArrow)
			)
			((and local81 (not (OneOf global125 local78 1)))
				(HandsOn)
				(= gCurRoomNum 0)
			)
			((and local81 (== local10 6))
				(gCurRoom setScript: beginAnnounce)
			)
			((and local82 (== local83 1) (== local10 3))
				(gCurRoom setScript: roundOne)
			)
			((and local82 (== local83 2) (== local10 3))
				(gCurRoom setScript: roundTwo)
			)
			((and (== local83 3) (== local10 1))
				(if
					(switch local85
						(0
							(>= 160 local2 158)
							(>= 127 local3 125)
						)
						(1
							(>= 158 local2 156)
							(>= 120 local3 118)
						)
						(2
							(== local2 158)
							(== local3 107)
						)
					)
					(gCurRoom setScript: puckHasWon)
				else
					(gCurRoom setScript: puckHasLost)
				)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(gDoVerbCode doit: 10)
			)
			(1 ; Walk
				(SetFlag 131)
				(gCurRoom newRoom: 320)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bowHand of View
	(properties
		x 137
		y 239
		lookStr {My arm is steady upon the bow.}
		view 201
		loop 1
		cel 1
		signal 20480
	)

	(method (doit)
		(if (OneOf gTheCursor 4 5)
			(= x (- (Max 135 (Min 189 gMouseX)) 22))
			(= y (+ (Max 88 (Min 143 gMouseY)) [local47 local85]))
			(if
				(and
					local9
					(switch local85
						(0
							(and (>= 186 gMouseX 135) (>= 143 gMouseY 114))
						)
						(1
							(and (>= 183 gMouseX 138) (>= 137 gMouseY 105))
						)
						(2
							(and (>= 179 gMouseX 139) (>= 120 gMouseY 80))
						)
					)
				)
				(gGame setCursor: 5 1)
			else
				(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(if (not local9)
					(arrow cel: 0 show:)
					(= local9 1)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bow of View
	(properties
		x 195
		y 144
		view 201
		signal 20480
	)

	(method (doit)
		(= x (+ (bowHand x:) 58))
		(= y (- (bowHand y:) 95))
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1330 17 1) ; "May my good longbow serve me well on this day."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance arrow of View
	(properties
		x 159
		y 133
		lookStr {My arrow is nocked and ready to be loosed.}
		view 332
		priority 10
		signal 16400
	)

	(method (doit)
		(= x (+ (bowHand x:) 22))
		(= y (- (bowHand y:) 106))
		(super doit:)
	)
)

(instance smallArrow of View
	(properties
		view 332
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(Say 1330 18) ; "My previous shot."
			)
			(10 ; Longbow
				(targetArea doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance adamBigArrow of Actor
	(properties
		x 166
		y 147
		view 326
		loop 1
		cel 1
		priority 15
		signal 16400
	)
)

(instance windFlags of Prop
	(properties
		x 27
		y 100
		lookStr {From the way this pennant blows, I can judge the direction and strength of the wind.}
		view 330
	)

	(method (init)
		(super init:)
		(self loop: local79 setPri: 3 setCycle: Fwd cycleSpeed: local80)
	)
)

(instance middleTarget of View
	(properties
		view 325
		signal 16384
	)

	(method (init)
		(super init:)
		(self cel: local44 stopUpd:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Look
				(cond
					((== local83 3))
					(local10
						(gCurRoom setScript: puckCloseUpTarg)
					)
					(else
						(gCurRoom setScript: showEmptyTarget)
					)
				)
			)
			(10 ; Longbow
				(targetArea doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance targetLeft of View
	(properties
		lookStr {This target is assigned to one of the competing archers.}
		view 325
		loop 3
		signal 16384
	)

	(method (init)
		(super init:)
		(self cel: local44 stopUpd:)
	)
)

(instance targetRight of View
	(properties
		lookStr {This target is assigned to one of the competing archers.}
		view 325
		loop 4
		signal 16384
	)

	(method (init)
		(super init:)
		(self cel: local44 stopUpd:)
	)
)

(instance bigTarget of View
	(properties
		y 189
		view 326
		signal 16392
	)
)

(instance splitArrow of View
	(properties
		x 165
		y 146
		view 326
		loop 2
		cel 1
		priority 15
		signal 16400
	)
)

(instance adamStanding of View ; UNUSED
	(properties
		x 223
		y 167
		view 325
		loop 2
	)
)

(instance walkPuck of Actor ; UNUSED
	(properties
		x 259
		y 164
		view 33
		loop 7
	)
)

(instance guard1 of View ; UNUSED
	(properties
		x 99
		y 181
		view 750
		loop 3
		signal 1
	)
)

(instance guard2 of View ; UNUSED
	(properties
		x 156
		y 183
		view 750
		loop 3
		cel 1
		signal 1
	)
)

(instance guard3 of View ; UNUSED
	(properties
		x 190
		y 178
		view 750
		loop 3
		cel 5
		signal 1
	)
)

(instance fireArrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (& ((gTheIconBar at: 0) signal:) $0004))
					(gTheIconBar disable: 0)
				)
				(arrow cel: 1)
				(= ticks 12)
			)
			(1
				(shootSound number: 906 play: self)
				(arrow cel: 2)
				(= ticks 12)
			)
			(2
				(arrow hide:)
				(= local2 (arrow x:))
				(= local3 (arrow y:))
				(+=
					local2
					(switch local79
						(0
							(-
								(switch local85
									(0
										(Random 3 6)
									)
									(1
										(Random 5 8)
									)
									(2
										(Random 7 10)
									)
								)
							)
						)
						(1
							(switch local85
								(0
									(Random 3 6)
								)
								(1
									(Random 5 8)
								)
								(2
									(Random 7 10)
								)
							)
						)
						(2
							(-
								(switch local85
									(0
										(Random 1 5)
									)
									(1
										(Random 3 7)
									)
									(2
										(Random 5 9)
									)
								)
							)
						)
						(3
							(switch local85
								(0
									(Random 1 5)
								)
								(1
									(Random 3 7)
								)
								(2
									(Random 5 9)
								)
							)
						)
					)
				)
				(+= local3 [local74 local85])
				(arrow cel: [local71 local85])
				(= local9 0)
				(if
					(and
						(not local81)
						(>=
							(GetDistance
								[local50 local85]
								[local59 local85]
								local2
								local3
							)
							[local62 local85]
						)
					)
					(++ local77)
				)
				(if (< local83 3)
					(if (== local10 0)
						(= [local36 local10] [local53 local85])
						(= [local39 local10] [local59 local85])
					else
						(= [local36 local10]
							(+ [local53 local85] (- (Random 2 10) 6))
						)
						(= [local39 local10]
							(+ [local59 local85] (- (Random 2 10) 6))
						)
					)
				)
				((= [local12 local10] (smallArrow new:))
					view: 332
					loop: 0
					cel: [local71 local85]
					posn: local2 local3
					ignoreActors:
					setPri: 10
					init:
					stopUpd:
				)
				(if
					(switch local85
						(0
							(or
								(> local2 169)
								(< local2 148)
								(> local3 132)
								(< local3 119)
							)
						)
						(1
							(or
								(> local2 167)
								(< local2 149)
								(> local3 126)
								(< local3 111)
							)
						)
						(2
							(or
								(> local2 166)
								(< local2 150)
								(> local3 114)
								(< local3 101)
							)
						)
					)
					(= local6 999)
					(= local7 999)
				else
					(= local6
						(+
							(/
								(*
									(- local2 [local50 local85])
									[local65 local85]
								)
								10
							)
							166
						)
					)
					(= local7
						(+
							(/
								(*
									(- local3 [local59 local85])
									[local68 local85]
								)
								10
							)
							147
						)
					)
					(if (== local3 local4)
						(-= local7 1)
					)
				)
				(= local4 local3)
				((= [local18 local10] (smallArrow new:))
					view: 326
					loop: 1
					cel: 0
					posn: local6 local7
					setPri: 15
					signal: 16400
					init:
					hide:
				)
				(++ local10)
				(gGame
					setCursor:
						gTheCursor
						1
						(+ gMouseX (Random 0 8) -4)
						(+ gMouseY (Random 0 8) -4)
				)
				(= cycles 1)
			)
			(3)
			(4
				(shootSound number: 910 play:)
				(= cycles 2)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance changeTargPos of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cleanTarget doit:)
				(windFlags hide:)
				(middleTarget dispose:)
				(targetLeft dispose:)
				(targetRight dispose:)
				(bowHand hide:)
				(bow hide:)
				(arrow hide:)
				(gCurRoom drawPic: 803)
				(= cycles 8)
			)
			(1
				(= local85 (- global125 2))
				(localproc_0)
				(gCurRoom drawPic: 330)
				(middleTarget init:)
				(targetLeft init:)
				(targetRight init:)
				(windFlags show:)
				(bowHand show:)
				(bow show:)
				(arrow
					cel: 0
					posn: (+ (bowHand x:) 22) (- (bowHand y:) 106)
					show:
				)
				(= local9 1)
				(= cycles 5)
			)
			(2
				(HandsOn)
				(gTheIconBar disable: 0 2 3 6 7)
				(= local82 1)
				(= local10 3)
				(self dispose:)
			)
		)
	)
)

(instance beginAnnounce of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local81 0)
				(HandsOff)
				(arrow hide:)
				(bow hide:)
				(bowHand hide:)
				(bigTarget x: 151 show:)
				(for ((= temp0 0)) (< temp0 local10) ((++ temp0))
					([local18 temp0] show:)
				)
				(= cycles 15)
			)
			(1
				(drumSound play:)
				(Converse 1 @local86 @local143 0 self) ; "The Tournament shall now begin!"
			)
			(2
				(bigTarget x: 151 hide:)
				(for ((= temp0 0)) (< temp0 local10) ((++ temp0))
					([local18 temp0] hide:)
				)
				(= cycles 7)
			)
			(3
				(cleanTarget doit:)
				(localproc_3)
				(= cycles 3)
			)
			(4
				(localproc_4)
				(bowHand hide:)
				(bow hide:)
				(arrow hide:)
				(= cycles 8)
			)
			(5
				(Converse 1 @local90 @local143 0 self) ; "Each Archer shall fire three arrows in this round! Clym of the Clough shall shoot first!"
			)
			(6
				((= local5 (Actor new:))
					view: 332
					loop: 1
					cel: 0
					posn: 309 164
					ignoreActors:
					setPri: 10
					init:
				)
				(= local11 0)
				(= local4 0)
				(= ticks 30)
			)
			(7
				(self setScript: turnClymBill self)
			)
			(8
				(localproc_13)
				(= ticks 30)
			)
			(9
				(self setScript: turnClymBill self)
			)
			(10
				(localproc_13)
				(= ticks 30)
			)
			(11
				(self setScript: turnClymBill self)
			)
			(12
				(localproc_10)
				(= ticks 180)
			)
			(13
				(localproc_11)
				(bigTarget x: 256 hide:)
				(= cycles 4)
			)
			(14
				(Converse 1 @local98 @local143 0 self) ; "Puck of Barnesdale shall now shoot!"
			)
			(15
				(bowHand show:)
				(bow show:)
				(arrow show:)
				(= cycles 3)
			)
			(16
				(= local83 1)
				(= local77 0)
				(HandsOn)
				(gTheIconBar disable: 0 2 3 6 7)
				(self dispose:)
			)
		)
	)
)

(instance roundOne of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local82 0)
				(HandsOff)
				(bowHand hide:)
				(bow hide:)
				(arrow hide:)
				(localproc_6)
				(= ticks 120)
			)
			(1
				(drumSound play:)
				(Converse 1 @local94 @local143 0 self) ; "Adam Bell, Champion of Nottingham, shall now shoot!"
			)
			(2
				(localproc_7)
				(= local4 0)
				(= local11 0)
				(localproc_12)
				(self setScript: adamShoot self)
			)
			(3
				(localproc_12)
				(= ticks 30)
			)
			(4
				(self setScript: adamShoot self)
			)
			(5
				(localproc_12)
				(= ticks 30)
			)
			(6
				(self setScript: adamShoot self)
			)
			(7
				(localproc_8)
				(= cycles 20)
			)
			(8
				(if (== local77 3)
					(SetFlag 160)
					(Converse 1 @local134 @local143 0 self) ; "Puck of Barnesdale, step down!"
				else
					(Converse 1 @local102 @local143 0 self) ; "Clym of the Clough shall step down! William of Cloudisly, step forth!"
				)
			)
			(9
				(localproc_9)
				(bigTarget x: 63 hide:)
				(while (>= (= temp0 (-- local11)) 0)
					([local27 temp0] dispose:)
					([local24 temp0] dispose:)
				)
				(cleanTarget doit:)
				(if (== local77 3)
					(HandsOn)
					(gCurRoom newRoom: 320)
				else
					(localproc_3)
					(= cycles 2)
				)
			)
			(10
				(localproc_4)
				(bowHand hide:)
				(bow hide:)
				(arrow hide:)
				(= cycles 3)
			)
			(11
				(Converse 1 @local106 @local143 0 self) ; "Each Archer shall fire three arrows in this round! William of Cloudisly shall shoot first!"
			)
			(12
				(= local11 0)
				(= local4 0)
				(localproc_13)
				(= ticks 30)
			)
			(13
				(self setScript: turnClymBill self)
			)
			(14
				(localproc_13)
				(= ticks 30)
			)
			(15
				(self setScript: turnClymBill self)
			)
			(16
				(localproc_13)
				(= ticks 30)
			)
			(17
				(self setScript: turnClymBill self)
			)
			(18
				(localproc_10)
				(= ticks 180)
			)
			(19
				(localproc_11)
				(bigTarget x: 256 hide:)
				(bowHand show:)
				(bow show:)
				(arrow show:)
				(= cycles 5)
			)
			(20
				(Converse 1 @local98 @local143 0 self) ; "Puck of Barnesdale shall now shoot!"
				(self cue:)
			)
			(21
				(= local83 2)
				(= local77 0)
				(HandsOn)
				(gTheIconBar disable: 0 2 3 6 7)
				(= local82 1)
				(self dispose:)
			)
		)
	)
)

(instance roundTwo of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local82 0)
				(HandsOff)
				(bowHand hide:)
				(bow hide:)
				(arrow hide:)
				(= cycles 4)
			)
			(1
				(localproc_6)
				(= ticks 120)
			)
			(2
				(drumSound play:)
				(Converse 1 @local114 @local143 0 self) ; "Adam Bell shall now shoot!"
			)
			(3
				(localproc_7)
				(= local11 0)
				(= local4 0)
				(localproc_12)
				(= ticks 30)
			)
			(4
				(self setScript: adamShoot self)
			)
			(5
				(localproc_12)
				(= ticks 30)
			)
			(6
				(self setScript: adamShoot self)
			)
			(7
				(localproc_12)
				(= ticks 30)
			)
			(8
				(self setScript: adamShoot self)
			)
			(9
				(localproc_8)
				(= cycles 20)
			)
			(10
				(localproc_9)
				(bigTarget x: 63 hide:)
				(= cycles 7)
			)
			(11
				(if (== local77 3)
					(SetFlag 160)
					(Converse 1 @local134 @local143 0 self) ; "Puck of Barnesdale, step down!"
				else
					(Converse 1 @local118 @local143 0 self) ; "William of Cloudisly shall step down. Adam Bell and Puck of Barnesdale shall shoot to win!"
				)
			)
			(12
				(for ((= temp0 0)) (<= temp0 2) ((++ temp0))
					([local27 temp0] dispose:)
					([local24 temp0] dispose:)
				)
				(cleanTarget doit:)
				(if (== local77 3)
					(HandsOn)
					(gCurRoom newRoom: 320)
				else
					(localproc_3)
					(= cycles 2)
				)
			)
			(13
				(localproc_4)
				(bowHand hide:)
				(bow hide:)
				(arrow hide:)
				(= cycles 7)
			)
			(14
				(Converse 1 @local122 @local143 0 self) ; "One arrow shall be fired and winner shall take all! Let Adam Bell place his final arrow!"
			)
			(15
				(local5 loop: 3 cel: 0 posn: 159 137 show:)
				(= ticks 30)
			)
			(16
				(local5 cel: 2 posn: 159 130)
				(shootSound number: 906 play:)
				(= ticks 24)
			)
			(17
				(local5
					posn: [local50 local85] [local59 local85]
					ignoreActors:
					cel: [local71 local85]
				)
				(= ticks 24)
			)
			(18
				(local5 hide:)
				((= [local24 0] (View new:))
					view: 332
					loop: 3
					cel: [local71 local85]
					posn: [local50 local85] [local59 local85]
					ignoreActors:
					setPri: 10
					init:
					stopUpd:
				)
				(= ticks 24)
			)
			(19
				(shootSound number: 910 play:)
				(bigTarget x: 63 show:)
				([local30 0] x: 78 y: 147 show:)
				(= cycles 20)
			)
			(20
				(Converse 1 @local126 @local143 0 self) ; "Adam Bell, Champion of Nottingham, has scored a perfect center! Let Puck of Barnesdale now fire his final arrow!"
			)
			(21
				([local30 0] x: 78 y: 147 hide:)
				(bigTarget x: 63 hide:)
				(= cycles 5)
			)
			(22
				(bowHand show:)
				(bow show:)
				(arrow
					cel: 0
					posn: (+ (bowHand x:) 22) (- (bowHand y:) 106)
					show:
				)
				(= local9 1)
				(= cycles 3)
			)
			(23
				(HandsOn)
				(gTheIconBar disable: 0 2 3 6 7)
				(= local83 3)
				(= local82 1)
				(= local77 0)
				(self dispose:)
			)
		)
	)
)

(instance puckHasLost of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local10 2)
				(HandsOff)
				(bowHand hide:)
				(bow hide:)
				(arrow hide:)
				(= cycles 5)
			)
			(1
				(bigTarget x: 159 show:)
				(adamBigArrow loop: 1 cel: 1 init:)
				([local18 0] show:)
				(= cycles 20)
			)
			(2
				(Converse 1 @local110 @local143 0 self) ; "Adam Bell is the champion!"
				(= cycles 1)
			)
			(3
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance puckHasWon of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= local10 2)
				(HandsOff)
				(bowHand hide:)
				(bow hide:)
				(arrow hide:)
				(= cycles 5)
			)
			(1
				(bigTarget x: 159 show:)
				(splitArrow loop: 2 cel: 1 init:)
				(= cycles 8)
			)
			(2
				(drumSound play:)
				(Converse 1 @local130 @local143 0 self) ; "He hath split the arrow! The winner is Puck of Barnesdale!"
			)
			(3
				([local24 0] dispose:)
				([local18 0] dispose:)
				([local12 0] dispose:)
				(splitArrow hide:)
				(bigTarget hide:)
				(HandsOn)
				(gTheIconBar enable: 8)
				(SetScore 200)
				(= cycles 15)
			)
			(4
				(gCurRoom setScript: goToGoldenArrow)
			)
		)
	)
)

(instance adamShoot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local5 posn: 45 137 cel: 1)
				(= ticks 12)
			)
			(1
				(shootSound number: 906 play:)
				(local5 cel: 2)
				(= ticks 12)
			)
			(2
				(local5
					posn: [local36 local11] [local39 local11]
					cel: [local71 local85]
					ignoreActors:
					setPri: 10
				)
				(= ticks 12)
			)
			(3
				(local5 hide:)
				(= local2 (local5 x:))
				(= local3 (local5 y:))
				((= [local24 local11] (View new:))
					view: 332
					loop: 2
					cel: [local71 local85]
					posn: local2 local3
					ignoreActors:
					setPri: 10
					init:
					stopUpd:
				)
				(= ticks 12)
			)
			(4
				(shootSound number: 910 play:)
				(= local6
					(+
						(/
							(* (- local2 [local53 local85]) [local65 local85])
							10
						)
						78
					)
				)
				(= local7
					(+
						(/
							(* (- local3 [local59 local85]) [local68 local85])
							10
						)
						147
					)
				)
				(if (== local3 local4)
					(-= local7 1)
				)
				(= local4 local3)
				((= [local30 local11] (View new:))
					view: 326
					loop: 1
					cel: 1
					posn: local6 local7
					setPri: 15
					signal: 16400
					init:
					hide:
				)
				(= ticks 12)
			)
			(5
				(++ local11)
				(self dispose:)
			)
		)
	)
)

(instance turnClymBill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(local5 posn: 291 143 cel: 1)
				(= ticks 12)
			)
			(1
				(shootSound number: 906 play:)
				(local5 cel: 2 posn: (local5 x:) (local5 y:))
				(= ticks 12)
			)
			(2
				(localproc_5)
				(local5
					posn: local42 local43
					ignoreActors:
					cel: [local71 local85]
					setPri: 10
				)
				(= ticks 12)
			)
			(3
				(local5 hide:)
				(= local2 (local5 x:))
				(= local3 (local5 y:))
				((= [local27 local11] (View new:))
					view: 332
					loop: 1
					cel: [local71 local85]
					posn: local2 local3
					ignoreActors:
					setPri: 10
					init:
					stopUpd:
				)
				(= ticks 12)
			)
			(4
				(shootSound number: 910 play:)
				(= local6
					(+
						(/
							(* (- local2 [local56 local85]) [local65 local85])
							10
						)
						271
					)
				)
				(= local7
					(+
						(/
							(* (- local3 [local59 local85]) [local68 local85])
							10
						)
						147
					)
				)
				(if (== local3 local4)
					(-= local7 1)
				)
				(= local4 local3)
				((= [local33 local11] (View new:))
					view: 326
					loop: 1
					cel: 2
					posn: local6 local7
					setPri: 15
					signal: 16400
					init:
					hide:
				)
				(= ticks 12)
			)
			(5
				(++ local11)
				(self dispose:)
			)
		)
	)
)

(instance puckCloseUpTarg of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(arrow hide:)
				(bow hide:)
				(bowHand hide:)
				(bigTarget x: 151 show:)
				(for ((= temp0 0)) (< temp0 local10) ((++ temp0))
					([local18 temp0] show:)
				)
				(= cycles 24)
			)
			(1
				(bigTarget x: 151 hide:)
				(for ((= temp0 0)) (< temp0 local10) ((++ temp0))
					([local18 temp0] hide:)
				)
				(= cycles 5)
			)
			(2
				(bow show:)
				(bowHand show:)
				(if (== local9 1)
					(arrow show:)
				)
				(HandsOn)
				(gTheIconBar disable: 0 2 3 6 7)
				(self dispose:)
			)
		)
	)
)

(instance goToGoldenArrow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 10)
				(= ticks 24)
			)
			(1
				(Converse 1 @local138 @local143 0 self) ; "Puck of Barnesdale has won the Golden Arrow!"
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance showEmptyTarget of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(arrow hide:)
				(bow hide:)
				(bowHand hide:)
				(= cycles 1)
			)
			(1
				(bigTarget x: 151 show:)
				(= cycles 3)
			)
			(2
				(if local1
					(= local1 0)
					(Say 1330 16 self) ; "The center target is mine for this match."
				else
					(self cue:)
				)
			)
			(3
				(bigTarget x: 151 hide:)
				(= cycles 3)
			)
			(4
				(bow show:)
				(bowHand show:)
				(if (== local9 1)
					(arrow show:)
				)
				(HandsOn)
				(gTheIconBar disable: 0 2 3 6 7)
				(self dispose:)
			)
		)
	)
)

(instance drumSound of Sound
	(properties
		flags 1
		number 920
	)
)

(instance shootSound of Sound
	(properties
		flags 1
	)
)

(instance targetArea of Feature
	(properties
		x 171
		y 136
		nsTop 64
		nsLeft 83
		nsBottom 155
		nsRight 245
		description {targetArea}
		sightAngle 90
	)

	(method (init)
		(= nsTop (- 84 (* local85 10)))
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Longbow
				(if
					(and
						local9
						(< local10 (+ 3 (* 3 local81)))
						(not (gCurRoom script:))
					)
					(gCurRoom setScript: fireArrow)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

