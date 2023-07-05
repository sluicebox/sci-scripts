;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 875)
(include sci.sh)
(use Main)
(use CycleBet)
(use PolyPath)
(use Motion)
(use Actor)
(use System)

(public
	proc875_0 0
	proc875_1 1
	proc875_2 2
	proc875_3 3
	smell 4
	proc875_5 5
)

(local
	[local0 9]
)

(procedure (proc875_5)
	(if
		(and
			(IsFlag 265)
			(IsFlag 266)
			(IsFlag 267)
			(IsFlag 276)
			(IsFlag 277)
			(IsFlag 441)
			(IsFlag 219)
			(IsFlag 289)
			(IsFlag 284)
		)
		(SetFlag 56)
		((ScriptID 895 0) put: 32) ; pepper, Special_Edition
		(gTheIconBar curIcon: (gTheIconBar walkIconItem:))
		(gGame setCursor: ((gTheIconBar curIcon:) cursor:))
	)
)

(procedure (proc875_0)
	(SetFlag 100)
	(SetFlag 101)
	(SetFlag 102)
	(SetFlag 103)
	(SetFlag 104)
	(SetFlag 105)
	(SetFlag 106)
	(SetFlag 107)
	(SetFlag 108)
	(SetFlag 109)
	(SetFlag 110)
	(SetFlag 111)
	(SetFlag 112)
	(SetFlag 113)
	(SetFlag 114)
	(SetFlag 115)
	(SetFlag 116)
	(SetFlag 117)
	(SetFlag 118)
	(SetFlag 119)
	(SetFlag 120)
	(SetFlag 121)
	(SetFlag 122)
	(SetFlag 123)
	(ClearFlag 124)
	(ClearFlag 125)
	(ClearFlag 126)
	(ClearFlag 127)
	(ClearFlag 128)
	(ClearFlag 129)
	(ClearFlag 130)
	(ClearFlag 131)
	(ClearFlag 132)
	(ClearFlag 133)
	(ClearFlag 134)
	(ClearFlag 135)
	(ClearFlag 138)
	(ClearFlag 139)
	(= global204 0)
	(= global205 0)
	(= global206 0)
	(= global207 0)
	(= global208 0)
	(= global209 0)
	(DisposeScript 875)
)

(procedure (proc875_1 param1 param2)
	(return (& param2 param1))
)

(procedure (localproc_0) ; UNUSED
	(DisposeScript 875)
)

(procedure (proc875_2 param1 param2 &tmp temp0)
	(= temp0 (| (= temp0 (WordAt param2 0)) param1))
	(Memory memPOKE param2 temp0)
	(DisposeScript 875)
)

(procedure (proc875_3 param1 param2 param3 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
	(= temp0 0)
	(thinkBalloon
		setScale:
		scaleX: 75
		scaleY: 75
		x: ((ScriptID 895 1) x:) ; lockjaw
		y: (- ((ScriptID 895 1) y:) 60) ; lockjaw
	)
	(switch param1
		(1
			(thinkBalloon
				x: (- ((ScriptID 895 1) x:) 64) ; lockjaw
				y: (- ((ScriptID 895 1) y:) 110) ; lockjaw
			)
			(= temp0 907)
			(= temp1 1)
			(= temp2 7)
			(= temp3 (+ (thinkBalloon x:) 41))
			(= temp4 (+ (thinkBalloon y:) 18))
		)
		(2
			(thinkBalloon
				x: (- ((ScriptID 895 1) x:) 64) ; lockjaw
				y: (- ((ScriptID 895 1) y:) 110) ; lockjaw
			)
			(= temp0 425)
			(= temp1 1)
			(= temp2 0)
			(= temp3 (+ (thinkBalloon x:) 59))
			(= temp4 (+ (thinkBalloon y:) 32))
		)
		(3
			(thinkBalloon view: (if (== gCurRoomNum 240) 240 else 437) setScale: 0)
		)
		(4
			(thinkBalloon view: 436 setScale: 0)
		)
		(5
			(thinkBalloon view: 432 setScale: 0)
		)
		(6
			(thinkBalloon view: 435 setScale: 0)
		)
		(17
			(thinkBalloon view: 431 setScale: 0)
		)
		(18
			(thinkBalloon view: 433 setScale: 0)
		)
		(17
			(thinkBalloon view: 436 setScale: 0)
		)
	)
	(thinkBalloon init: stopUpd:)
	(thinkTail
		x: ((ScriptID 895 1) x:) ; lockjaw
		y: (- (- ((ScriptID 895 1) y:) 30) 100) ; lockjaw
		z: -100
		setScale:
		scaleX: 75
		scaleY: 75
		init:
		stopUpd:
	)
	(if temp0
		(thinkObject
			view: temp0
			setLoop: temp1
			cel: temp2
			x: temp3
			y: temp4
			init:
			stopUpd:
		)
	)
	(Animate (gCast elements:) 0)
	(if (< argc 3)
		(= param3 400)
	)
	(= temp6 (+ param3 gGameTime))
	(while
		(and
			(<= (- gGameTime temp6) 0)
			(not (OneOf ((= temp5 (Event new:)) type:) evKEYBOARD evMOUSEBUTTON))
		)
		(= gGameTime (+ gTickOffset (GetTime)))
		(temp5 dispose:)
	)
	(if (IsObject temp5)
		(temp5 dispose:)
	)
	(thinkBalloon dispose:)
	(thinkObject dispose:)
	(thinkTail dispose:)
	(Animate (gCast elements:) 0)
	(if (> argc 1)
		(param2 cue:)
	)
	(if (not (smell client:))
		(DisposeScript 875)
	)
)

(instance thinkTail of View
	(properties
		view 914
		cel 3
		priority 15
		signal 26640
	)
)

(instance thinkObject of View
	(properties
		priority 15
		signal 24592
	)
)

(instance thinkBalloon of View
	(properties
		view 915
		priority 15
		signal 26640
	)
)

(instance smell of Script
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 875)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= temp0 register)
				(for ((= temp1 0)) (<= temp1 8) ((++ temp1))
					(= [local0 temp1] (WordAt temp0 temp1))
				)
				((ScriptID 895 1) ; lockjaw
					normalize:
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath [local0 0] [local0 1] self
				)
			)
			(1
				((ScriptID 895 1) ; lockjaw
					view: 808
					setLoop: [local0 2]
					setCel: 0
					setCycle: CT 4 1 self
				)
			)
			(2
				(gLongSong2 number: 911 setLoop: 1 play: self)
				((ScriptID 895 1) setCycle: CycleBet 4 5 -1) ; lockjaw
			)
			(3
				(if [local0 8]
					(proc875_3 [local0 8] self)
				else
					(= cycles 2)
				)
			)
			(4
				((ScriptID 895 1) setCycle: Beg self) ; lockjaw
			)
			(5
				((ScriptID 895 1) ; lockjaw
					normalize:
					loop: 8
					cel: (if (== [local0 2] 3) 1 else 0)
				)
				(= ticks 15)
			)
			(6
				(if [local0 3]
					(gMessager
						say:
							[local0 3]
							[local0 4]
							[local0 5]
							[local0 6]
							self
							[local0 7]
					)
				else
					(= cycles 2)
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

