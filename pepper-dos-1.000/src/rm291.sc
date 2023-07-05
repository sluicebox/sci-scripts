;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 291)
(include sci.sh)
(use Main)
(use smell)
(use ADRoom)
(use Print)
(use Feature)
(use Actor)
(use System)

(public
	rm291 0
)

(local
	local0
	local1 = 85
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9 = 1
	local10
	[local11 30] = [770 1284 1798 2312 2571 3085 25956 26470 26984 27498 27757 28271 -30328 -29814 -29300 -28786 -28527 -28013 -21076 -20562 -20048 -19534 -19275 -18761 0 770 0 0 0 0]
	[local41 30] = [3854 4368 4882 5396 5655 6169 29040 29554 30068 30582 30841 31355 -27244 -26730 -26216 -25702 -25443 -24929 -17992 -17478 -16964 -16450 -16191 -15677 0 3854 0 0 0 0]
	[local71 30] = [6938 7452 7966 8480 8739 9253 32124 32638 -32384 -31870 -31611 -31097 -24160 -23646 -23132 -22618 -22359 -21845 -14908 -14394 -13880 -13366 -13107 -12593 0 6938 0 0 0 0]
	[local101 6] = [21844 16704 8994 22870 19532 22359]
	[local107 6] = [14905 5653 -29300 10279 11052 1024]
	[local113 6] = [13106 15419 17989 20302 12097 768]
	[local119 6] = [15419 15933 16447 16961 8481 8226]
	[local125 6] = [31353 -8069 -7455 -6941 24415 24098]
	[local131 6] = [14134 14648 17218 20045 0 0]
	[local137 6] = [2584 -30695 -30071 -29557 11307 11821]
	[local143 6] = [15162 3132 15933 16447 11307 11821]
	[local149 6] = [13106 13877 14391 14905 15162 15676]
	[local155 6] = [20045 9809 8729 16960 23901 0]
	[local161 6] = [15676 16190 16704 17218 2629 15158]
	[local167 12] = [0 1798 2312 0 0 257 0 2312 2312 0 0 257]
)

(procedure (localproc_0 param1 param2 param3 param4 &tmp temp0)
	(= temp0 (+ (* (- local6 1) 6) (- gAct 2)))
	(if (not (proc875_1 local9 (WordAt param1 0)))
		(= local8 1)
	else
		(= local8 2)
	)
	(switch local8
		(2
			(proc875_2 local9 param2)
			(= local7 (WordAt param3 temp0))
		)
		(1
			(proc875_2 local9 param1)
			(= local7 (WordAt param3 temp0))
		)
		(else
			(Prints {*** OOPS in GetWhichTimeTalk})
		)
	)
	(param4 cue:)
)

(procedure (localproc_1)
	(= local5 (& local7 $00ff))
	(= local4 (>> local7 $0008))
	(switch local8
		(1
			(= local2 local5)
			(= global114 0)
		)
		(2
			(= local2 local4)
		)
	)
)

(procedure (localproc_2 param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
	(= temp4 (if (and argc param1) 0 else 41))
	(= temp0 (+ (param2 nsTop:) 2))
	(= temp1 (+ (param2 nsLeft:) 2))
	(= temp2 (- (param2 nsBottom:) 3))
	(= temp3 (- (param2 nsRight:) 4))
	(Graph grDRAW_LINE temp0 temp1 temp0 temp3 temp4 -1 -1)
	(Graph grDRAW_LINE temp0 temp3 temp2 temp3 temp4 -1 -1)
	(Graph grDRAW_LINE temp2 temp3 temp2 temp1 temp4 -1 -1)
	(Graph grDRAW_LINE temp2 temp1 temp0 temp1 temp4 -1 -1)
	(Graph
		grUPDATE_BOX
		(- (param2 nsTop:) 2)
		(- (param2 nsLeft:) 2)
		(param2 nsBottom:)
		(+ (param2 nsRight:) 3)
		1
	)
)

(instance rm291 of ADRoom
	(properties)

	(method (init)
		(SetFlag 2)
		(= global216 gTheCursor)
		(gGame setCursor: 999 1)
		(gTheIconBar disable:)
		(if (== gAct 0)
			(= gAct 2)
		)
		(switch global195
			(1
				(unknownFace cel: 4)
				(= local6 2)
				(= local0 18)
				(if (IsFlag 100)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(2
				(unknownFace cel: 0)
				(= local6 2)
				(= local0 9)
				(<<= local9 $0001)
				(if (IsFlag 101)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(3
				(unknownFace cel: 1)
				(= local6 1)
				(= local0 1)
				(<<= local9 $0002)
				(if (IsFlag 102)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(4
				(unknownFace cel: 7)
				(= local6 2)
				(= local0 18)
				(<<= local9 $0003)
				(if (IsFlag 103)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(5
				(unknownFace cel: 8)
				(= local6 4)
				(= local0 29)
				(<<= local9 $0004)
				(if (IsFlag 104)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(6
				(unknownFace cel: 2)
				(= local6 1)
				(= local0 19)
				(<<= local9 $0005)
				(if (IsFlag 105)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(7
				(unknownFace cel: 9)
				(= local6 1)
				(= local0 16)
				(<<= local9 $0006)
				(if (IsFlag 106)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(8
				(unknownFace cel: 10)
				(= local6 2)
				(= local0 17)
				(<<= local9 $0007)
				(if (IsFlag 107)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(9
				(unknownFace cel: 3)
				(= local6 1)
				(= local0 1)
				(<<= local9 $0008)
				(if (IsFlag 108)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(10
				(unknownFace cel: 5)
				(if (== gPrevRoomNum 210)
					(= local6 2)
				else
					(= local6 3)
				)
				(= local0 14)
				(<<= local9 $0009)
				(if (IsFlag 109)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(11
				(unknownFace cel: 6)
				(= local6 1)
				(= local0 26)
				(<<= local9 $000a)
				(if (IsFlag 110)
					(= local8 1)
				else
					(= local8 2)
				)
			)
			(12
				(unknownFace cel: 11)
				(if (IsFlag 87)
					(= local6 5)
				else
					(= local6 1)
				)
				(= local0 1)
				(<<= local9 $000b)
				(if (IsFlag 111)
					(= local8 1)
				else
					(= local8 2)
				)
			)
		)
		(cond
			((== global195 3)
				(= local3 261)
			)
			((== global195 12)
				(= local3 2012)
			)
			((== global195 9)
				(= local3 211)
			)
			(else
				(= local3 gPrevRoomNum)
			)
		)
		(super init: &rest)
		(backgroundWin init:)
		(benFace init:)
		(= local10 benFeature)
		(pughsFace init:)
		(lockjawFace init:)
		(unknownFace init:)
		(benFeature init:)
		(lockjawFeature init:)
		(pughFeature init:)
		(unknownFeature init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(gCurRoom setScript: sShowTitle)
	)

	(method (newRoom)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gTheIconBar enable:)
		(ClearFlag 2)
		(gGame setCursor: global216 1)
		(super newRoom: &rest)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(if script
		else
			(= temp0 (gFeatures firstTrue: #onMe gMouseX (- gMouseY 10)))
			(if (and (IsObject temp0) (!= temp0 local10))
				(localproc_2 0 local10)
				(localproc_2 1 temp0)
				(= local10 temp0)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1 temp2)
		(= temp1 (event type:))
		(= temp0 (event message:))
		(cond
			(
				(and
					(or
						(and (== temp1 evMOUSEBUTTON) (not (event modifiers:)))
						(and (== temp1 evKEYBOARD) (== temp0 KEY_RETURN))
					)
					(not (benFace onMe: event))
					(not (lockjawFace onMe: event))
					(not (unknownFace onMe: event))
					(not (pughsFace onMe: event))
					(not (backgroundWin onMe: event))
				)
				(= global115 0)
				(= global116 0)
				(= global196 0)
				(event claimed: 1)
				(gCurRoom newRoom: gPrevRoomNum)
			)
			(
				(or
					(and (== temp1 evMOUSEBUTTON) (not (event modifiers:)))
					(and (== temp1 evKEYBOARD) (== temp0 KEY_RETURN))
				)
				(event claimed: 1)
				(switch local10
					(benFeature
						(= local10 benFeature)
						(self setScript: sAskAboutBen)
					)
					(pughFeature
						(= local10 pughFeature)
						(self setScript: sAskAboutPughs)
					)
					(lockjawFeature
						(= local10 lockjawFeature)
						(self setScript: sAskAboutLockJaw)
					)
					(unknownFeature
						(= local10 unknownFeature)
						(self setScript: sAskAboutThemselves)
					)
				)
			)
			((or (== temp0 JOY_UP) (and (== temp1 evKEYBOARD) (== temp0 KEY_SHIFTTAB)))
				(localproc_2 0 local10)
				(if (>= (= temp2 (- (gFeatures indexOf: local10) 2)) 0)
					(= local10 (gFeatures at: temp2))
				else
					(= local10 (gFeatures at: (- (gFeatures size:) 1)))
				)
				(localproc_2 1 local10)
			)
			((or (== temp0 JOY_DOWN) (and (== temp1 evKEYBOARD) (== temp0 KEY_TAB)))
				(localproc_2 0 local10)
				(if
					(<
						(= temp2 (+ (gFeatures indexOf: local10) 2))
						(gFeatures size:)
					)
					(= local10 (gFeatures at: temp2))
				else
					(= local10 (gFeatures at: 0))
				)
				(localproc_2 1 local10)
			)
			(else
				(not (& temp1 $0040)) ; direction
			)
		)
	)
)

(instance sShowTitle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(Display {ASK ABOUT:} dsCOORD 122 51 dsFONT 10 dsCOLOR 7)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sAskAboutBen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_0 @global204 @global205 @local11 self)
			)
			(1
				(localproc_1)
				(= cycles 1)
			)
			(2
				(= global115 local0)
				(= global116 local2)
				(= global196 local3)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance sAskAboutPughs of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_0 @global208 @global209 @local71 self)
			)
			(1
				(localproc_1)
				(= cycles 1)
			)
			(2
				(= global115 local0)
				(= global116 local2)
				(= global196 local3)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance sAskAboutLockJaw of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_0 @global206 @global207 @local41 self)
				(= cycles 1)
			)
			(1
				(localproc_1)
				(= cycles 1)
			)
			(2
				(= global115 local0)
				(= global116 local2)
				(= global196 local3)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance sAskAboutThemselves of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(switch global195
					(1
						(switch local8
							(2
								(ClearFlag 112)
							)
							(1
								(ClearFlag 100)
							)
							(else
								(Prints {*** OOPS in ask about tattle})
							)
						)
						(= temp0 [local101 (- gAct 2)])
					)
					(2
						(switch local8
							(2
								(ClearFlag 113)
							)
							(1
								(ClearFlag 101)
							)
							(else
								(Prints {*** OOPS in ask about penny})
							)
						)
						(= temp0 [local107 (- gAct 2)])
					)
					(3
						(switch local8
							(2
								(ClearFlag 114)
							)
							(1
								(ClearFlag 102)
							)
							(else
								(Prints {*** OOPS in ask about glutton})
							)
						)
						(= temp0 [local113 (- gAct 2)])
					)
					(4
						(switch local8
							(2
								(ClearFlag 115)
							)
							(1
								(ClearFlag 103)
							)
							(else
								(Prints {*** OOPS in ask about quibble})
							)
						)
						(= temp0 [local119 (- gAct 2)])
					)
					(5
						(switch local8
							(2
								(ClearFlag 116)
							)
							(1
								(ClearFlag 104)
							)
							(else
								(Prints {*** OOPS in ask about vicar})
							)
						)
						(= temp0 [local125 (- gAct 2)])
					)
					(6
						(switch local8
							(2
								(ClearFlag 117)
							)
							(1
								(ClearFlag 105)
							)
							(else
								(Prints {*** OOPS in ask about nellie})
							)
						)
						(= temp0 [local131 (- gAct 2)])
					)
					(7
						(switch local8
							(2
								(ClearFlag 118)
							)
							(1
								(ClearFlag 106)
							)
							(else
								(Prints {*** OOPS in ask about postal1})
							)
						)
						(= temp0 [local137 (- gAct 2)])
					)
					(8
						(switch local8
							(2
								(ClearFlag 119)
							)
							(1
								(ClearFlag 107)
							)
							(else
								(Prints {*** OOPS in ask about postal2})
							)
						)
						(= temp0 [local143 (- gAct 2)])
					)
					(9
						(switch local8
							(2
								(ClearFlag 120)
							)
							(1
								(ClearFlag 108)
							)
							(else
								(Prints {*** OOPS in ask about reveler1})
							)
						)
						(= temp0 [local149 (- gAct 2)])
					)
					(10
						(switch local8
							(2
								(ClearFlag 121)
							)
							(1
								(ClearFlag 109)
							)
							(else
								(Prints {*** OOPS in ask about reveler2})
							)
						)
						(= temp0 [local155 (- gAct 2)])
					)
					(11
						(switch local8
							(2
								(ClearFlag 122)
							)
							(1
								(ClearFlag 110)
							)
							(else
								(Prints {*** OOPS in ask about goody})
							)
						)
						(= temp0 [local161 (- gAct 2)])
					)
					(12
						(switch local8
							(2
								(ClearFlag 123)
							)
							(1
								(ClearFlag 111)
							)
							(else
								(Prints {*** OOPS in ask about poorrich})
							)
						)
						(if (IsFlag 87)
							(= temp0 [local167 (+ (- gAct 2) 6)])
						else
							(= temp0 [local167 (- gAct 2)])
						)
					)
				)
				(= local5 (& temp0 $00ff))
				(= local4 (>> temp0 $0008))
				(switch local8
					(1
						(= local2 local5)
						(= global114 0)
					)
					(2
						(= local2 local4)
					)
				)
				(if (== local2 0)
					(Prints {***** WARNING **** case = 0})
				)
				(= cycles 1)
			)
			(2
				(= global115 local0)
				(= global116 local2)
				(= global196 local3)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance benFace of View
	(properties
		x 100
		y 164
		z 100
		view 906
		loop 2
		priority 15
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(Prints {***That's ben})
			)
			(7 ; Do
				(gCurRoom setScript: sAskAboutBen)
			)
			(85 ; Talk
				(gCurRoom setScript: sAskAboutBen)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pughsFace of View
	(properties
		x 148
		y 168
		z 100
		view 906
		loop 2
		cel 2
		priority 15
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(Prints {***That's the Pugh's})
			)
			(7 ; Do
				(gCurRoom setScript: sAskAboutPughs)
			)
			(85 ; Talk
				(gCurRoom setScript: sAskAboutPughs)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lockjawFace of View
	(properties
		x 100
		y 197
		z 100
		view 906
		loop 2
		cel 1
		priority 15
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(Prints {***That's lockjaw})
			)
			(7 ; Do
				(gCurRoom setScript: sAskAboutLockJaw)
			)
			(85 ; Talk
				(gCurRoom setScript: sAskAboutLockJaw)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance unknownFace of View
	(properties
		x 148
		y 197
		z 100
		view 906
		loop 1
		cel 3
		priority 15
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(switch global195
					(1
						(Prints {***that's tattle})
					)
					(2
						(Prints {***that's penny})
					)
					(3
						(Prints {***that's glutton})
					)
					(4
						(Prints {***that's quibble})
					)
					(5
						(Prints {***that's vicar})
					)
					(6
						(Prints {***that's nellie})
					)
					(7
						(Prints {***that's postal1})
					)
					(8
						(Prints {***that's postal2})
					)
					(9
						(Prints {***that's reveler1})
					)
					(10
						(Prints {***that's reveler2})
					)
					(11
						(Prints {***that's goody})
					)
					(12
						(Prints {***that's poorRichard})
					)
					(else
						(Prints {***there's a boo boo some where})
					)
				)
			)
			(7 ; Do
				(gCurRoom setScript: sAskAboutThemselves)
			)
			(85 ; Talk
				(gCurRoom setScript: sAskAboutThemselves)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance backgroundWin of View
	(properties
		x 134
		y 82
		view 906
		priority 15
		signal 17
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(Prints {***click on the person to talk about them})
			)
			(7 ; Do
				(Prints {***click on the person to talk about them})
			)
			(85 ; Talk
				(Prints {***click on the person to talk about them})
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance benFeature of Feature
	(properties
		x 119
		y 70
		nsTop 57
		nsLeft 94
		nsBottom 96
		nsRight 144
	)
)

(instance lockjawFeature of Feature
	(properties
		x 121
		y 104
		nsTop 92
		nsLeft 94
		nsBottom 127
		nsRight 144
	)
)

(instance pughFeature of Feature
	(properties
		x 168
		y 68
		nsTop 57
		nsLeft 144
		nsBottom 96
		nsRight 196
	)
)

(instance unknownFeature of Feature
	(properties
		x 170
		y 104
		nsTop 92
		nsLeft 144
		nsBottom 127
		nsRight 196
	)
)

