;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 55)
(include sci.sh)
(use Main)
(use Interface)
(use RandCycle)
(use Count)
(use RFeature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm055 0
)

(local
	local0 = 50
	local1
	local2
	local3
	[local4 225] = [1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 0 1 0 1 1 0 1 1 1 1 1 1 1 1 0 0 1 0 0 0 0 1 1 1 1 1 1 1 0 0 1 0 1 1 0 1 1 1 1 1 1 1 1 0 1 0 0 1 0 0 0 1 1 1 1 1 1 1 0 0 0 1 0 0 1 1 1 1 1 1 1 1 1 1 1 0 0 0 1 0 0 1 1 1 1 1 1 1 0 1 0 1 0 0 0 1 1 1 1 1 1 1 1 0 0 0 0 0 1 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1]
	local229
	[local230 19] = [7 -3 5 -7 7 -3 7 -2 5 3 5 5 7 12 2 26 0 18 -32768]
	local249
	local250
	local251
	local252
	local253
	[local254 43] = [8 6 0 7 6 1 7 7 3 6 7 2 5 7 3 5 6 2 5 5 3 6 5 1 6 4 3 7 4 1 7 3 0 7 2 1 6 2 2 5 2 3 -32768]
	[local297 4] = [126 89 205 228]
	[local301 4] = [121 136 121 136]
	[local305 4] = [88 53 237 264]
	[local309 4] = [121 136 121 136]
	local313
	local314
	local315
	local316
	[local317 9] = [155 9 2 155 50 1 38 50 -32768]
	[local326 9] = [155 9 2 155 50 0 270 50 -32768]
	[local335 15] = [155 9 2 155 50 1 90 50 2 90 85 1 38 85 -32768]
	[local350 15] = [155 9 2 155 50 0 231 50 2 231 85 0 270 85 -32768]
	[local365 15] = [38 85 0 90 85 3 90 50 0 155 50 3 155 9 -32768]
	[local380 12] = [38 85 0 90 85 3 90 50 0 270 50 -32768]
	[local392 12] = [270 85 1 231 85 3 231 50 1 38 50 -32768]
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 100)) (>= temp0 -1) ((-= temp0 local0))
		(Palette palSET_INTENSITY 1 254 temp0)
		(Wait 1)
	)
	(Palette palSET_INTENSITY 1 254 0)
	(Wait 1)
	(Graph grFILL_BOX 37 68 146 254 3 0 0)
	(Graph grUPDATE_BOX 37 68 146 254 1)
	(gAddToPics eachElementDo: #dispose)
	(gAddToPics eachElementDo: #delete)
	(gAddToPics dispose:)
	(hole dispose:)
	(cell dispose:)
	(door dispose:)
	(doorBack dispose:)
	(dink dispose:)
	(dinkHair dispose:)
	(dinkBlink dispose:)
	(hairPin dispose:)
	(mazeBug dispose:)
	(helper dispose:)
	(arrow dispose:)
	(if (!= (gGlobalSound number:) 25)
		(gGlobalSound loop: -1 number: 25 vol: 127 playBed:)
	)
	(gEgo illegalBits: 0)
	(localproc_1)
	(cond
		((== (gCurRoom script:) dropInScript) 0)
		((== (cass script:) cassScript)
			(= local253 1)
		)
		(else
			(localproc_8)
		)
	)
)

(procedure (localproc_1)
	(= local3 (mod local3 360))
	(gEgo posn: 161 145 0 setMotion: 0 heading: 0 loop: 3)
	(if (== gPrevRoomNum 55)
		(switch local3
			(0
				(-- local2)
			)
			(90
				(++ local1)
			)
			(180
				(++ local2)
			)
			(270
				(-- local1)
			)
		)
	)
	(= local229 0)
	(localproc_15)
	(localproc_16)
	(localproc_17)
	(localproc_18)
	(localproc_19)
	(localproc_20)
	(localproc_21)
	(localproc_22)
	(localproc_23)
	(localproc_24)
	(localproc_25)
	(localproc_26)
	(cond
		((localproc_5) 0)
		((localproc_6) 0)
		((localproc_2) 0)
		((localproc_3) 0)
		((localproc_4) 0)
		((< global81 3) 0)
		((localproc_7) 0)
	)
)

(procedure (localproc_2)
	(cond
		(
			(and
				(not (and (== local1 3) (== local2 5)))
				(not (and (== local1 3) (== local2 4)))
				(not (and (== local1 3) (== local2 6)))
				(not (and (== local1 2) (== local2 5)))
				(not (and (== local1 4) (== local2 5)))
			)
			(return 0)
		)
		((and (== local1 3) (== local2 5))
			(hole
				view: 878
				setLoop: 5
				cel: 2
				setPri: 12
				x: 162
				y: 48
				init:
				show:
			)
			(return 1)
		)
		(
			(or
				(and (== local1 3) (== local2 4) (!= local3 180))
				(and (== local1 3) (== local2 6) (!= local3 0))
				(and (== local1 2) (== local2 5) (!= local3 90))
				(and (== local1 4) (== local2 5) (!= local3 270))
			)
			(return 0)
		)
		(else
			(hole view: 878 setLoop: 5 cel: 3 setPri: 12 x: 162 y: 55 init:)
			(return 1)
		)
	)
)

(procedure (localproc_3)
	(cond
		((not (IsFlag 68))
			(return 0)
		)
		((and (== local1 8) (== local2 6))
			(if (== local3 90)
				(cell
					view: 878
					setLoop: 5
					cel: 0
					setPri: 11
					x: 162
					y: 119
					init:
					show:
				)
			)
			(return 1)
		)
	)
)

(procedure (localproc_4)
	(if (and (== local1 5) (== local2 1) (== local3 0))
		(door view: 862 setLoop: 0 cel: 0 setPri: 11 x: 162 y: 128 init: show:)
		(doorBack x: 162 y: 128 init: show:)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_5)
	(cond
		((not (gEgo has: 34)) ; Tambourine
			(return 0)
		)
		(
			(or
				(and (== local1 1) (== local2 7))
				(and (== local1 3) (== local2 1))
				(and (== local1 8) (== local2 1))
				(and (== local1 8) (== local2 8))
			)
			(gGlobalSound fade:)
			(dink init: setScript: mainDinkScript)
			(dinkHair init:)
			(gEgo x: (- (gEgo x:) 30))
			(return 1)
		)
		(else
			(return 0)
		)
	)
)

(procedure (localproc_6)
	(if (and (== local1 local251) (== local2 local252))
		(hairPin init: posn: local249 local250 0 setCycle: 0)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_7)
	(if (and (> (Random 0 99) 89) (not (cass script:)))
		(mazeBugScript start: 0)
		(mazeBug init: setScript: mazeBugScript)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_8 &tmp temp0)
	(Animate (gCast elements:) 1)
	(for ((= temp0 0)) (<= temp0 100) ((+= temp0 local0))
		(Palette palSET_INTENSITY 1 254 temp0)
		(Wait 1)
	)
	(Palette palSET_INTENSITY 1 254 100)
	(Wait 1)
)

(procedure (localproc_9 param1)
	(|= local229 param1)
)

(procedure (localproc_10 param1)
	(return (& local229 param1))
)

(procedure (localproc_11 param1 param2)
	(return (+ param1 param2 (* param2 14)))
)

(procedure (localproc_12 param1 param2 param3 param4)
	(return
		(+
			local1
			(switch local3
				(0 param1)
				(90 param2)
				(180 param3)
				(270 param4)
			)
		)
	)
)

(procedure (localproc_13 param1 param2 param3 param4)
	(return
		(+
			local2
			(switch local3
				(0 param1)
				(90 param2)
				(180 param3)
				(270 param4)
			)
		)
	)
)

(procedure (localproc_14 param1 param2 param3 param4 param5 param6 &tmp temp0)
	((= temp0 (mazePiece new:))
		view: param1
		loop: param2
		cel: param3
		x: param4
		y: param5
		priority: param6
		addToPic:
	)
)

(procedure (localproc_15)
	(localproc_14 878 1 0 161 146 10)
	(localproc_14 878 0 0 162 53 10)
)

(procedure (localproc_16)
	(if
		(==
			[local4
				(localproc_11 (localproc_12 0 1 0 -1) (localproc_13 -1 0 1 0))
			]
			1
		)
		(localproc_14 878 6 0 162 131 9)
		(gEgo observeControl: 1024)
		(localproc_9 64)
	else
		(localproc_14 878 1 1 160 127 9)
		(localproc_14 878 0 1 160 58 9)
		(gEgo ignoreControl: 1024)
	)
)

(procedure (localproc_17)
	(cond
		((localproc_10 64)
			(return)
		)
		(
			(==
				[local4
					(localproc_11
						(localproc_12 0 2 0 -2)
						(localproc_13 -2 0 2 0)
					)
				]
				1
			)
			(localproc_14 878 4 1 160 115 7)
			(localproc_9 128)
		)
		(else
			(localproc_14 878 1 2 160 115 7)
			(localproc_14 878 0 2 160 60 7)
		)
	)
)

(procedure (localproc_18)
	(cond
		((or (localproc_10 64) (localproc_10 128))
			(return)
		)
		(
			(==
				[local4
					(localproc_11
						(localproc_12 0 3 0 -3)
						(localproc_13 -3 0 3 0)
					)
				]
				1
			)
			(localproc_14 878 3 1 160 109 6)
			(localproc_9 256)
		)
		(else
			(localproc_14 878 1 3 160 109 7)
			(localproc_14 878 0 3 161 63 7)
		)
	)
)

(procedure (localproc_19)
	(if
		(==
			[local4
				(localproc_11 (localproc_12 -1 0 1 0) (localproc_13 0 -1 0 1))
			]
			1
		)
		(localproc_14 877 0 0 99 147 9)
		(gEgo observeControl: 2)
		(localproc_9 1)
	else
		(localproc_14 877 0 4 101 128 9)
		(localproc_14 877 0 6 98 52 9)
	)
)

(procedure (localproc_20)
	(cond
		((and (localproc_10 64) (localproc_10 1))
			(return)
		)
		(
			(==
				[local4
					(localproc_11
						(localproc_12 -1 1 1 -1)
						(localproc_13 -1 -1 1 1)
					)
				]
				1
			)
			(if (not (localproc_10 1))
				(localproc_14 877 0 0 99 137 8)
			)
			(localproc_14 877 0 0 129 126 8)
			(localproc_9 2)
		)
		(else
			(localproc_14 877 0 4 130 115 8)
			(localproc_14 877 0 6 124 57 8)
		)
	)
)

(procedure (localproc_21)
	(cond
		(
			(or
				(and (localproc_10 64) (localproc_10 1))
				(and (localproc_10 64) (localproc_10 2))
				(and (localproc_10 128) (localproc_10 2))
			)
			(return)
		)
		(
			(==
				[local4
					(localproc_11
						(localproc_12 -1 2 1 -2)
						(localproc_13 -2 -1 2 1)
					)
				]
				1
			)
			(if (not (localproc_10 2))
				(localproc_14 877 1 0 67 114 6)
				(localproc_14 877 0 0 128 119 6)
			)
			(localproc_14 877 0 1 139 115 6)
			(localproc_9 4)
		)
		(else
			(localproc_14 877 0 5 141 109 7)
			(localproc_14 877 0 9 140 60 6)
		)
	)
)

(procedure (localproc_22)
	(cond
		(
			(or
				(and (localproc_10 64) (localproc_10 1))
				(and (localproc_10 64) (localproc_10 2))
				(and (localproc_10 64) (localproc_10 4))
				(and (localproc_10 128) (localproc_10 2))
				(and (localproc_10 128) (localproc_10 4))
			)
			(return)
		)
		(
			(==
				[local4
					(localproc_11
						(localproc_12 -1 3 1 -3)
						(localproc_13 -3 -1 3 1)
					)
				]
				1
			)
			(if (or (localproc_10 128) (localproc_10 256))
				(localproc_14 878 3 0 100 109 5)
			else
				(localproc_14 877 0 2 147 120 5)
				(localproc_14 877 0 3 138 122 5)
			)
		)
		(else
			(localproc_14 877 0 8 146 107 6)
			(localproc_14 877 0 9 148 62 6)
		)
	)
)

(procedure (localproc_23)
	(if
		(==
			[local4
				(localproc_11 (localproc_12 1 0 -1 0) (localproc_13 0 1 0 -1))
			]
			1
		)
		(localproc_14 877 1 0 223 147 9)
		(gEgo observeControl: 64)
		(localproc_9 8)
	else
		(localproc_14 877 1 4 221 128 9)
		(localproc_14 877 1 6 221 52 9)
	)
)

(procedure (localproc_24)
	(cond
		((and (localproc_10 64) (localproc_10 8))
			(return)
		)
		(
			(==
				[local4
					(localproc_11
						(localproc_12 1 1 -1 -1)
						(localproc_13 -1 1 1 -1)
					)
				]
				1
			)
			(if (not (localproc_10 8))
				(localproc_14 877 1 0 223 127 8)
			)
			(localproc_14 877 1 0 191 131 8)
			(localproc_9 16)
		)
		(else
			(localproc_14 877 1 4 192 115 8)
			(localproc_14 877 1 6 194 57 8)
		)
	)
)

(procedure (localproc_25)
	(cond
		(
			(or
				(and (localproc_10 64) (localproc_10 8))
				(and (localproc_10 64) (localproc_10 16))
				(and (localproc_10 128) (localproc_10 16))
			)
			(return)
		)
		(
			(==
				[local4
					(localproc_11
						(localproc_12 1 2 -1 -2)
						(localproc_13 -2 1 2 -1)
					)
				]
				1
			)
			(if (not (localproc_10 16))
				(localproc_14 877 1 0 192 115 6)
				(localproc_14 877 0 0 255 118 6)
			)
			(localproc_14 877 1 1 180 118 6)
			(localproc_9 32)
		)
		(else
			(localproc_14 877 1 5 179 109 7)
			(localproc_14 877 1 9 179 60 6)
		)
	)
)

(procedure (localproc_26)
	(cond
		(
			(or
				(and (localproc_10 64) (localproc_10 8))
				(and (localproc_10 64) (localproc_10 16))
				(and (localproc_10 64) (localproc_10 32))
				(and (localproc_10 128) (localproc_10 16))
				(and (localproc_10 128) (localproc_10 32))
			)
			(return)
		)
		(
			(==
				[local4
					(localproc_11
						(localproc_12 1 3 -1 -3)
						(localproc_13 -3 1 3 -1)
					)
				]
				1
			)
			(if (or (localproc_10 128) (localproc_10 256))
				(localproc_14 878 3 2 221 109 5)
			else
				(localproc_14 877 1 2 173 120 5)
				(localproc_14 877 1 3 179 122 5)
			)
		)
		(else
			(localproc_14 877 1 8 173 107 6)
			(localproc_14 877 1 9 173 62 6)
		)
	)
)

(instance rm055 of Rm
	(properties
		picture 55
	)

	(method (init)
		(super init:)
		(proc0_24 128 877 878 678 862 861 865 871 872 876)
		(gEgo
			view: 0
			setLoop: -1
			loop: 3
			posn: 161 145 0
			setPri: 11
			setMotion: 0
			setCycle: Walk
			cycleSpeed: 0
			setStep: 3 2
			init:
		)
		(switch gPrevRoomNum
			(56
				(arrow cel: 2)
				(= local1 5)
				(= local2 1)
				(= local3 0)
				(gEgo heading: 0)
			)
			(67
				(= local1 8)
				(= local2 6)
				(arrow cel: 1)
				(if (IsFlag 70)
					(cass
						init:
						setCycle: Walk
						setScript: cassScript
						posn: [local297 [local254 2]] [local301 [local254 2]] 0
						setPri: 10
						loop: 1
					)
					(= local3 270)
					(gEgo observeControl: 8 heading: 0)
				else
					(= local3 90)
					(gEgo heading: 0)
				)
				(SetFlag 68)
			)
			(else
				(= local1 3)
				(= local2 5)
				(arrow cel: 3)
				(= local3 0)
				(gEgo heading: 0)
				(HandsOff)
				(self setScript: dropInScript)
			)
		)
		(mazePiece init:)
		(localproc_0)
		(= gPrevRoomNum 55)
		(gGlobalSound loop: -1 number: 25 vol: 127 play:)
		(if (== script dropInScript)
			(dropInScript cue:)
		)
		(self setFeatures: helpFeat room)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(cond
			(script
				(script doit:)
			)
			((== temp0 8)
				(+= local3 180)
				(localproc_0)
			)
			((== temp0 1024)
				(localproc_0)
			)
			((& temp0 $0040)
				(+= local3 90)
				(localproc_0)
			)
			((& temp0 $0002)
				(+= local3 270)
				(localproc_0)
			)
		)
	)

	(method (handleEvent event &tmp [temp0 100])
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
		(gGlobalSound fade:)
		(DisposeScript 978)
		(DisposeScript 751)
		(super dispose:)
	)
)

(instance dropInScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsSOUND 78)
				0
			)
			(1
				(priBlock init:)
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 865
					setLoop: 0
					setCel: 0
					ignoreActors: 1
					illegalBits: 0
					posn: 161 76 0
					setPri: 12
					setStep: 12 12
					setCycle: 0
				)
				(= cycles 1)
			)
			(2
				(gEgo setMotion: MoveTo 161 145 self)
			)
			(3
				(gGlobalSound2 number: 78 loop: 1 vol: 50 play:)
				(gEgo setCycle: End self)
			)
			(4
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					loop: 3
					setCycle: Walk
					setPri: 11
					setStep: 3 2
					heading: 0
				)
				(priBlock dispose:)
				(HandsOn)
				(= global103 0)
				(self dispose:)
			)
		)
	)
)

(instance cassScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(HandsOff)
				(cass
					posn:
						[local297 [local254 (+ register 2)]]
						[local301 [local254 (+ register 2)]]
						0
					setPri: 10
					setMotion:
						MoveTo
						[local305 [local254 (+ register 2)]]
						[local309 [local254 (+ register 2)]]
						self
				)
			)
			(2
				(HandsOn)
				(cass z: 1000)
				(= cycles 120)
			)
			(3
				(= register 997)
				(= cycles 1)
			)
			(4
				(+= register 3)
				(cond
					((== [local254 register] -32768)
						(cass
							setPri: (- (door priority:) 1)
							posn: (- (door x:) 20) (door y:) 0
						)
						(HandsOff)
						(= cycles 1)
					)
					(
						(or
							(== register 1000)
							(!= local1 [local254 register])
							(!= local2 [local254 (+ register 1)])
						)
						(cass dispose:)
						(self dispose:)
					)
					(else
						(= seconds (= cycles 0))
						(= start 1)
						(self init:)
					)
				)
			)
			(5
				(SetFlag 69)
				(gGlobalSound3 number: 122 loop: 1 play:)
				(door cel: (door lastCel:))
				(cass setMotion: MoveTo (+ (door x:) 2) (- (door y:) 2) self)
			)
			(6
				(gGlobalSound3 number: 124 loop: 1 play:)
				(door setCycle: Beg self)
			)
			(7
				(HandsOn)
				(cass z: 1000)
				(self dispose:)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if local253
			(= local253 0)
			(if (not (IsFlag 70))
				(cass z: 1000)
			)
			(gEgo loop: 3)
			(localproc_8)
			(if (not (IsFlag 70))
				(if (<= state 2)
					(= cycles (= seconds 0))
					(= start 4)
					(self init:)
				)
			else
				(self cue:)
				(ClearFlag 70)
			)
		)
		(if (& (cass onControl: 1) $0020)
			(cass setPri: 8)
		)
	)
)

(instance mainDinkScript of Script
	(properties)

	(method (dispose)
		(if (not (dink script:))
			(gGlobalSound loop: -1 number: 25 vol: 127 playBed:)
		)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 887 loop: -1 playBed:)
				(= register 3)
			)
		)
	)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(cond
			(
				(and
					(>=
						(= temp0
							(GetAngle
								(client x:)
								(client y:)
								(gEgo x:)
								(gEgo y:)
							)
						)
						270
					)
					(<= temp0 360)
				)
				(= temp1 1)
			)
			((and (>= temp0 255) (<= temp0 269))
				(= temp1 2)
			)
			((and (>= temp0 106) (<= temp0 255))
				(= temp1 3)
			)
			((and (>= temp0 89) (<= temp0 105))
				(= temp1 4)
			)
			((and (>= temp0 0) (<= temp0 90))
				(= temp1 5)
			)
		)
		(if (!= temp1 register)
			(switch temp1
				(1
					(client setLoop: 4 cel: 0 setCycle: End)
				)
				(2
					(if (== register 1)
						(client setCycle: Beg)
					else
						(client setLoop: 0 cel: 0 setCycle: End)
					)
				)
				(3
					(if (== register 2)
						(client setLoop: 0)
						(client cel: (client lastCel:) setCycle: Beg)
					else
						(client setLoop: 1)
						(client cel: (client lastCel:) setCycle: Beg)
					)
				)
				(4
					(if (== register 5)
						(client setCycle: Beg)
					else
						(client setLoop: 1 cel: 0 setCycle: End)
					)
				)
				(5
					(client setLoop: 5 cel: 0 setCycle: End)
				)
			)
			(= register temp1)
		)
		(if (and (not (gCurRoom script:)) (gEgo inRect: 150 120 319 189))
			(HandsOff)
			(gCurRoom setScript: hugScript 0 temp1)
		)
	)
)

(instance hugScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(PrintDC 55 0 #at -1 20 #dispose) ; "Duh...DINK!"
				(gEgo setPri: (+ (dink priority:) 1))
				(dink
					setScript: 0
					setLoop: 6
					cel: 0
					cycleSpeed: 3
					setCycle: CT 3 1 self
				)
			)
			(1
				((gEgo head:) dispose:)
				(gEgo dispose:)
				(dink setCycle: End self)
			)
			(2
				(= seconds 1)
				(Load rsVIEW 545)
				(= global103 0)
			)
			(3
				(cls)
				(= seconds 3)
			)
			(4
				(= global330 {Shouldn't mess with Dink, Graham!})
				(EgoDead 545)
			)
		)
	)
)

(instance giveTamboScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(proc0_24 132 888 889 890 50)
				(SetScore 3)
				(Load rsVIEW 874)
				(gEgo
					setPri: (+ (dink priority:) 1)
					setMotion: PolyPath (- (dink x:) 20) (dink y:) self
				)
				(if (and (== (dink loop:) 4) (!= (dink cel:) 0))
					(dink setCycle: Beg self)
				else
					(= cycles 1)
				)
			)
			(1 0)
			(2
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 874
					setLoop: 5
					cel: 0
					cycleSpeed: 1
					setPri: (+ (dink priority:) 1)
					setCycle: RandCycle 30 self
				)
				(gGlobalSound2 number: 50 loop: -1 vol: 127 play:)
			)
			(3
				(gGlobalSound2 stop:)
				(dink setScript: 0 ignoreActors: 1)
				(if (== (dink loop:) 4)
					(= temp0 (- (dink x:) 3))
					(= temp1 (+ (dink y:) 2))
				else
					(= temp0 (dink x:))
					(= temp1 (dink y:))
				)
				(gEgo
					setLoop: 1
					x: temp0
					y: temp1
					cel: 0
					cycleSpeed: 1
					setPri: (+ (dink priority:) 1)
					setCycle: End self
				)
				(UnLoad 132 50)
			)
			(4
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					put: 34 ; Tambourine
					x: (- (dink x:) 20)
					y: (dink y:)
					cycleSpeed: 0
					setCycle: Walk
					moveSpeed: global289
					setScript: moveEgoScript
				)
				(gGlobalSound number: 890 loop: -1 playBed:)
				(dink
					view: 874
					setLoop: 2
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(5
				(dink setCycle: End self)
			)
			(6
				(dink setCycle: End self)
			)
			(7
				(dink setLoop: 3 cel: 0 setCycle: Fwd)
				(= seconds 5)
			)
			(8
				(gGlobalSound number: 888 loop: 1 playBed:)
				(UnLoad 132 890)
				(dink setLoop: 0 cel: 0 setCycle: End self)
			)
			(9
				(gGlobalSound number: 889 loop: 1 play:)
				(UnLoad 132 888)
				(hairPin init:)
				(self setScript: hairPinScript self)
			)
			(10
				(= local249 (hairPin x:))
				(= local250 (hairPin y:))
				(= local251 local1)
				(= local252 local2)
				(dink view: 873 setLoop: 4 cel: 0 setCycle: End self)
			)
			(11
				(dink
					setLoop: 3
					setPri: (+ (gEgo priority:) 1)
					setCycle: Walk
					setMotion: MoveTo (- (dink x:) 75) (+ (dink y:) 75) self
				)
				(gGlobalSound fade:)
			)
			(12
				(gGlobalSound loop: -1 number: 25 vol: 127 playBed:)
				(hairPin setCycle: 0 ignoreActors: 1)
				(HandsOn)
				(UnLoad 132 889)
				(self dispose:)
			)
		)
	)
)

(instance moveEgoScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 45) (gEgo y:) self
				)
			)
			(1
				(gEgo loop: 0 setLoop: -1)
				(self dispose:)
			)
		)
	)
)

(instance hairPinScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(hairPin
					posn:
						(+ (hairPin x:) [local230 register])
						(+ (hairPin y:) [local230 (++ register)])
				)
				(= cycles 1)
			)
			(1
				(if (== [local230 (++ register)] -32768)
					(= cycles 1)
				else
					(self init:)
				)
			)
			(2
				(gGlobalSound3 number: 797 loop: 1 vol: 127 play:)
				(client cue:)
				(= seconds 3)
			)
			(3
				(hairPin setCycle: 0 ignoreActors: 1)
				(client setScript: 0)
			)
		)
	)
)

(instance goHoleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 162 131 self)
			)
			(1
				((gEgo head:) dispose:)
				(gEgo
					normal: 0
					view: 861
					setLoop: 0
					cel: 0
					cycleSpeed: 3
					setCycle: End self
				)
			)
			(2
				(gEgo dispose:)
				(gCurRoom newRoom: 67)
			)
		)
	)
)

(instance goDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_24 132 122 124)
				(gEgo setMotion: MoveTo (- (door x:) 4) (+ (door y:) 6) self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 678
					setLoop: 0
					cycleSpeed: 2
					cel: 0
					setCycle: End self
				)
				(gGlobalSound3 number: 122 loop: 1 play:)
				(door setCycle: End)
			)
			(2
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					cycleSpeed: 0
					loop: 3
					setCycle: Walk
				)
				((gEgo head:) show:)
				(= cycles 2)
			)
			(3
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 16) (gEgo y:) self
				)
			)
			(4
				(gEgo
					illegalBits: 0
					setPri: (- (door priority:) 1)
					setMotion: MoveTo (+ (door x:) 2) (- (door y:) 1) self
				)
			)
			(5
				(gEgo z: 1000)
				(door setCycle: Beg self)
			)
			(6
				(gGlobalSound3 number: 124 loop: 1 play:)
				(gCurRoom newRoom: 56)
			)
		)
	)
)

(instance lockedDoorScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo (door x:) (+ (door y:) 5) self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 678
					setLoop: 2
					cycleSpeed: 2
					setCycle: End self
				)
			)
			(2
				(= cycles 10)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo setCycle: End self)
			)
			(5
				(= cycles 10)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				((gEgo head:) show:)
				(gEgo
					normal: 1
					view: 0
					setLoop: -1
					loop: 3
					cycleSpeed: 0
					setCycle: Walk
				)
				(= seconds 2)
			)
			(8
				(PrintDC 55 1) ; "Graham tries to open the wooden door, but to no avail. It's securely locked."
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance pickLockScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetScore 4)
				(gEgo setMotion: MoveTo (- (door x:) 4) (+ (door y:) 6) self)
			)
			(1
				((gEgo head:) hide:)
				(gEgo
					normal: 0
					view: 678
					setLoop: 1
					setCycle: RandCycle 15 self
				)
			)
			(2
				((gEgo head:) show:)
				(gEgo normal: 1 view: 0 setLoop: -1 setCycle: Walk)
				(= seconds 1)
			)
			(3
				(PrintDC 55 2) ; "Graham inserts the hairpin into the door's large keyhole and discovers, to his amazement, that it fits perfectly! Turning it ever so gently, he soon hears a soft click and the door is unlocked!"
				(SetFlag 69)
				(HandsOn)
				(= global103 0)
				(self dispose:)
			)
		)
	)
)

(instance getHairPinScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (- (hairPin x:) 10) (hairPin y:) self
				)
			)
			(1
				((gEgo head:) hide:)
				(gEgo normal: 0 view: 56 setLoop: 2 setCycle: End self)
			)
			(2
				(SetScore 2)
				(gEgo get: 36 setCycle: Beg self) ; Hairpin
				(hairPin dispose:)
				(= local251 0)
				(= local252 0)
			)
			(3
				((gEgo head:) show:)
				(gEgo normal: 1 view: 0 setLoop: -1 setCycle: Walk)
				(PrintDC 55 3) ; "Graham reaches down and grabs the hairpin off the labyrinth floor."
				(HandsOn)
				(= global103 0)
				(self dispose:)
			)
		)
	)
)

(instance mazeBugScript of Script
	(properties)

	(method (dispose)
		(gGlobalSound2 stop:)
		(mazeBug z: 1000)
		(= start 0)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(switch (Random 0 2)
					(0
						(mazeBug view: 871)
					)
					(1
						(mazeBug view: 872)
					)
					(2
						(mazeBug view: 876)
					)
				)
				(= cycles 5)
			)
			(1
				(= local313 0)
				(if
					(==
						[local4
							(localproc_11
								(localproc_12 -1 0 1 0)
								(localproc_13 0 -1 0 1)
							)
						]
						1
					)
					(|= local313 $0002)
				)
				(if
					(==
						[local4
							(localproc_11
								(localproc_12 1 0 -1 0)
								(localproc_13 0 1 0 -1)
							)
						]
						1
					)
					(|= local313 $0001)
				)
				(cond
					((and (& local313 $0002) (& local313 $0001))
						(= local313 (+ (Random 0 2) 2))
					)
					((and (not (& local313 $0002)) (not (& local313 $0001)))
						(= local313 (Random 0 1))
					)
					((and (not (& local313 $0002)) (& local313 $0001))
						(= local313 (* (Random 0 1) 6))
					)
					(else
						(= local313
							(+ (= temp0 (Random 1 4)) (* 1 (> temp0 2)))
						)
					)
				)
				(switch local313
					(0
						(= local314 [local317 0])
						(= local315 [local317 1])
						(= local316 [local317 2])
					)
					(1
						(= local314 [local326 0])
						(= local315 [local326 1])
						(= local316 [local326 2])
					)
					(2
						(= local314 [local335 0])
						(= local315 [local335 1])
						(= local316 [local335 2])
					)
					(3
						(= local314 [local350 0])
						(= local315 [local350 1])
						(= local316 [local350 2])
					)
					(4
						(= local314 [local365 0])
						(= local315 [local365 1])
						(= local316 [local365 2])
					)
					(5
						(= local314 [local380 0])
						(= local315 [local380 1])
						(= local316 [local380 2])
					)
					(6
						(= local314 [local392 0])
						(= local315 [local392 1])
						(= local316 [local392 2])
					)
				)
				(gGlobalSound2 number: 150 priority: 3 loop: -1 vol: 127 play:)
				(mazeBug
					posn: local314 local315 0
					setLoop: local316
					priority: 11
					show:
					setCycle: Fwd
				)
				(= register 3)
				(= cycles 1)
			)
			(2
				(switch local313
					(0
						(= local314 [local317 register])
						(= local315 [local317 (++ register)])
					)
					(1
						(= local314 [local326 register])
						(= local315 [local326 (++ register)])
					)
					(2
						(= local314 [local335 register])
						(= local315 [local335 (++ register)])
					)
					(3
						(= local314 [local350 register])
						(= local315 [local350 (++ register)])
					)
					(4
						(= local314 [local365 register])
						(= local315 [local365 (++ register)])
					)
					(5
						(= local314 [local380 register])
						(= local315 [local380 (++ register)])
					)
					(6
						(= local314 [local392 register])
						(= local315 [local392 (++ register)])
					)
				)
				(mazeBug setMotion: MoveTo local314 local315 self)
				(++ register)
			)
			(3
				(switch local313
					(0
						(= local316 [local317 register])
						(if (== [local317 register] -32768)
							(= register -1)
						)
					)
					(1
						(= local316 [local326 register])
						(if (== [local326 register] -32768)
							(= register -1)
						)
					)
					(2
						(= local316 [local335 register])
						(if (== [local335 register] -32768)
							(= register -1)
						)
					)
					(3
						(= local316 [local350 register])
						(if (== [local350 register] -32768)
							(= register -1)
						)
					)
					(4
						(= local316 [local365 register])
						(if (== [local365 register] -32768)
							(= register -1)
						)
					)
					(5
						(= local316 [local380 register])
						(if (== [local380 register] -32768)
							(= register -1)
						)
					)
					(6
						(= local316 [local392 register])
						(if (== [local392 register] -32768)
							(= register -1)
						)
					)
				)
				(if (== register -1)
					(self dispose:)
				else
					(mazeBug setLoop: local316)
					(++ register)
					(= start 2)
					(self init:)
				)
			)
		)
	)
)

(instance helpScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(helper z: 0)
				(arrow init: posn: (helper x:) (helper y:) 0)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			((== (gEgo loop:) 7)
				(= temp0 (arrow cel:))
			)
			((== (gEgo loop:) 3)
				(switch local3
					(0
						(= temp0 3)
					)
					(90
						(= temp0 1)
					)
					(180
						(= temp0 4)
					)
					(270
						(= temp0 2)
					)
				)
			)
			((== (gEgo loop:) 0)
				(switch local3
					(0
						(= temp0 1)
					)
					(90
						(= temp0 4)
					)
					(180
						(= temp0 2)
					)
					(270
						(= temp0 3)
					)
				)
			)
			((== (gEgo loop:) 2)
				(switch local3
					(0
						(= temp0 4)
					)
					(90
						(= temp0 2)
					)
					(180
						(= temp0 3)
					)
					(270
						(= temp0 1)
					)
				)
			)
			((== (gEgo loop:) 1)
				(switch local3
					(0
						(= temp0 2)
					)
					(90
						(= temp0 3)
					)
					(180
						(= temp0 1)
					)
					(270
						(= temp0 4)
					)
				)
			)
		)
		(arrow cel: temp0)
		(super doit:)
	)
)

(instance blinkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(client show:)
				(= cycles 4)
			)
			(2
				(client hide:)
				(self init:)
			)
		)
	)
)

(instance mazeBug of Act
	(properties
		z 1000
		signal 24592
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 4) ; "A grotesque creature scurries along the stone walls of the labyrinth."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 55 5) ; "Graham can't catch the creature... and wouldn't want to!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance mazePiece of View
	(properties
		signal 16400
	)
)

(instance hole of Prop
	(properties
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 6) ; "High above him, Graham sees the hole by which he entered these confusing underground tunnels."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 55 7) ; "The hole is much too high for Graham to ever reach. He'll have to find another way out."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance cell of Prop
	(properties
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 8) ; "The hole where Graham exited the dungeon."
					(event claimed: 1)
				)
				(3 ; Do
					(HandsOff)
					(gCurRoom setScript: goHoleScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance door of Prop
	(properties
		signal 16400
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 9) ; "There is a wooden door here! Perhaps it will lead into the castle."
					(event claimed: 1)
				)
				(3 ; Do
					(if (not (IsFlag 69))
						(HandsOff)
						(gCurRoom setScript: lockedDoorScript)
					else
						(HandsOff)
						(gCurRoom setScript: goDoorScript)
					)
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(1 ; Key
							(PrintDC 55 10) ; "The key won't fit this lock."
							(event claimed: 1)
						)
						(36 ; Hairpin
							(if (IsFlag 69)
								(PrintDC 55 11) ; "The door is already unlocked."
							else
								(HandsOff)
								(gCurRoom setScript: pickLockScript)
							)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 55 12) ; "That won't work with the labyrinth door."
							(event claimed: 1)
						)
					)
				)
			)
		)
	)
)

(instance doorBack of Prop
	(properties
		view 863
		priority 9
		signal 24592
	)
)

(instance cass of Act
	(properties
		view 864
		signal 24576
		illegalBits 0
		moveSpeed 2
	)
)

(instance dink of Act
	(properties
		y 138
		x 188
		view 873
		priority 11
		signal 16400
		cycleSpeed 2
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 0 cel: 0)
		(dinkBlink
			init:
			hide:
			setPri: (+ (dink priority:) 1)
			setScript: blinkScript
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 13) ; "A huge beast, sporting a funny-looking topknot bound in a crude hairpin on top of his head, skulks in one dark corner of the labyrinth."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 55 14) ; "Graham should watch his step around this ugly beast!"
					(event claimed: 1)
				)
				(5 ; Inventory
					(switch global69
						(34 ; Tambourine
							(HandsOff)
							(dink setScript: 0)
							(gCurRoom setScript: giveTamboScript)
							(event claimed: 1)
						)
						(28 ; Wand
							(event claimed: 0)
						)
						(else
							(PrintDC 55 15) ; "It makes no impression on the huge beast."
							(event claimed: 1)
						)
					)
				)
				(4 ; Talk
					(PrintDC 55 16) ; "Duh... Dink! Dink! Duh... duh... duh... Dink!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance dinkBlink of Prop
	(properties
		view 875
		signal 24592
	)

	(method (doit)
		(super doit:)
		(cond
			((!= (dink view:) 873)
				(self z: 1000)
			)
			((and (== (dink loop:) 0) (== (dink cel:) 0))
				(self posn: (dink x:) (- (dink y:) 39) 0 loop: 0 cel: 0)
			)
			((and (== (dink loop:) 0) (== (dink cel:) 6))
				(self posn: (- (dink x:) 4) (- (dink y:) 38) 0 loop: 0 cel: 1)
			)
			((and (== (dink loop:) 4) (== (dink cel:) 0))
				(self posn: (- (dink x:) 6) (- (dink y:) 36) 0 loop: 1 cel: 0)
			)
			((and (== (dink loop:) 4) (== (dink cel:) 4))
				(self posn: (- (dink x:) 10) (- (dink y:) 35) 0 loop: 1 cel: 1)
			)
			((and (== (dink loop:) 6) (== (dink cel:) 8))
				(self posn: (- (dink x:) 4) (- (dink y:) 38) 0 loop: 2 cel: 0)
			)
			(else
				(self z: 1000)
			)
		)
	)
)

(instance dinkHair of Prop
	(properties
		view 923
		priority 10
		signal 24592
	)

	(method (doit)
		(super doit:)
		(if (== (dink view:) 873)
			(self
				loop: (dink loop:)
				cel: (dink cel:)
				x: (dink x:)
				y: (dink y:)
				z: 0
			)
		else
			(self z: 1000)
		)
	)
)

(instance hairPin of Act
	(properties
		view 874
		priority 11
		signal 24592
	)

	(method (init)
		(super init: &rest)
		(self
			setLoop: 4
			ignoreActors: 1
			posn: (+ (dink x:) 7) (- (dink y:) 46) 0
			setCycle: Fwd
		)
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 17) ; "Graham sees the beast's hairpin lying on the stone floor of the labyrinth."
					(event claimed: 1)
				)
				(3 ; Do
					(Load rsVIEW 56)
					(HandsOff)
					(gCurRoom setScript: getHairPinScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance priBlock of View
	(properties
		y 41
		x 158
		view 865
		loop 1
		priority 15
		signal 24592
	)
)

(instance room of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (proc0_18 self event))
				(not (== (event type:) evVERB))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 55 18) ; "Graham looks around in terrified confusion as he finds himself in a labyrinth somewhere underneath Mordack's castle."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance helpFeat of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $4000))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(helper init: z: 1000 setScript: helpScript)
					(event claimed: 1)
				)
			)
		)
	)
)

(instance helper of Prop
	(properties
		y 168
		x 159
		view 877
		loop 2
		priority 15
		signal 26640
	)
)

(instance arrow of View
	(properties
		view 877
		loop 2
		priority 15
		signal 24592
	)
)

