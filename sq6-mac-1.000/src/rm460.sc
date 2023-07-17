;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 460)
(include sci.sh)
(use Main)
(use SQRoom)
(use SQNarrator)
(use DText)
(use Str)
(use Array)
(use Talker)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm460 0
	Stellar_Santiago 1
	Commander_Kielbasa 2
	Stellar 3
)

(local
	[local0 10]
	[local10 10] = [201 185 201 217 185 201 217 185 201 217]
	[local20 10] = [109 68 68 68 81 81 81 95 95 95]
	[local30 10]
	[local40 4]
	local44
	local45
	local46
	local47
	local48
	local49 = -1
	local50
	local51
	local52
	local53
	local54
	local55
	local56 = 1
	local57
	local58
	local59
	local60
	local61
	local62
	local63
	local64
	local65
	local66
	local67
	local68 = 1
	[local69 8] = [6 14 17 19 21 21 23 0]
	local77
	local78 = 1
	local79
)

(procedure (localproc_0 &tmp temp0)
	(for ((= temp0 0)) (< temp0 10) ((++ temp0))
		(if [local30 temp0]
			([local30 temp0] dispose:)
			(= [local30 temp0] 0)
		)
	)
	(= local55 0)
	(for ((= temp0 1)) (< temp0 4) ((++ temp0))
		(if [local40 temp0]
			([local40 temp0] dispose:)
			(= [local40 temp0] 0)
		)
	)
	(= local60 0)
)

(procedure (localproc_1 param1 param2)
	(if (or (< argc 2) (and (> argc 1) param2))
		(if local55
			([local30 local55] fore: 102 draw:)
		)
		([local30 param1] fore: 145 draw:)
		(= local55 param1)
	else
		([local30 param1] fore: 102 draw:)
		(= local55 0)
	)
)

(procedure (localproc_2 param1 &tmp temp0 temp1)
	(if (< argc 7)
		(Message
			msgGET
			460
			[param1 0]
			[param1 1]
			[param1 2]
			[param1 3]
			(local44 data:)
		)
		(= temp0 [param1 4])
		(= temp1 [param1 5])
	else
		(Message
			msgGET
			460
			[param1 0]
			[param1 1]
			[param1 2]
			[param1 3]
			(local45 data:)
		)
		(local44 format: {%s %s} [param1 4] (local45 data:))
		(= temp0 [param1 5])
		(= temp1 [param1 6])
	)
	(Text 0 (local46 data:) (local44 data:) 460 110)
	((= [local30 temp0] (DText new:))
		font: 460
		text: (KString 8 (local44 data:)) ; StrDup
		fore: 102
		back: 101
		x:
			(if (== temp1 -1)
				(+ 65 (/ (- 110 (- (local46 at: 2) (local46 at: 0))) 2))
			else
				(+ 65 (* temp1 3))
			)
		y: (+ 27 (* 5 temp0))
		setSize: 110
		setPri: (+ (GetHighPlanePri) 1)
		init:
	)
)

(procedure (localproc_3 param1 param2 param3 param4 param5 param6)
	(if [local30 param5]
		([local30 param5] dispose:)
		(= [local30 param5] 0)
	)
	(Message msgGET 460 param1 param2 param3 param4 (local44 data:))
	(if (!= local49 -1)
		(local47 format: {%s %d} (local44 data:) local49)
	else
		(local47 dispose:)
		(= local47 (Str newCopies: (local44 data:)))
	)
	(Text 0 (local46 data:) (local47 data:) 460 110)
	((= [local30 param5] (DText new:))
		font: 460
		text: (KString 8 (local47 data:)) ; StrDup
		fore: 102
		back: 101
		x:
			(if (== param6 -1)
				(+ 65 (/ (- 110 (- (local46 at: 2) (local46 at: 0))) 2))
			else
				(+ 65 (* param6 3))
			)
		y: (+ 27 (* 5 param5))
		setSize: 110
		setPri: (+ (GetHighPlanePri) 1)
		init:
	)
)

(procedure (localproc_4 param1 param2 param3 param4 param5 param6)
	(Message msgGET 460 param1 param2 param3 param4 (local44 data:))
	(Text 0 (local46 data:) (local44 data:) 460 110)
	((= [local30 param5] (DText new:))
		font: 460
		text: (KString 8 (local44 data:)) ; StrDup
		fore: 102
		back: 101
		x:
			(if (== param6 -1)
				(+ 65 (/ (- 110 (- (local46 at: 2) (local46 at: 0))) 2))
			else
				(+ 65 (* param6 3))
			)
		y: (+ 27 (* 5 param5))
		setSize: 110
		setPri: (+ (GetHighPlanePri) 1)
		init:
	)
	(= local51 17)
	(cond
		(
			(and
				(== param4 1)
				(not (Message msgGET 460 param1 param2 param3 2 (local44 data:)))
			)
			(localproc_5 6 49 0 1 {@.} 1 14)
			(localproc_6 1)
			(= local59 0)
		)
		(
			(and
				(== param4 1)
				(Message msgGET 460 param1 param2 param3 2 (local44 data:))
			)
			(localproc_5 6 50 0 1 {@.} 1 8)
			(localproc_5 6 49 0 1 {2.} 2 20)
			(localproc_6 1)
			(= local59 1)
		)
		(
			(and
				(Message
					msgGET
					460
					param1
					param2
					param3
					(- param4 1)
					(local44 data:)
				)
				(not
					(Message
						msgGET
						460
						param1
						param2
						param3
						(+ param4 1)
						(local44 data:)
					)
				)
			)
			(localproc_5 6 39 0 1 {@.} 1 8)
			(localproc_5 6 49 0 1 {2.} 2 20)
			(localproc_6 2)
			(= local59 2)
		)
		(else
			(localproc_5 6 50 0 1 {@.} 1 2)
			(localproc_5 6 39 0 1 {2.} 2 14)
			(localproc_5 6 49 0 1 {3.} 3 27)
			(if local63
				(localproc_6 2)
			else
				(localproc_6 1)
			)
			(= local59 3)
		)
	)
)

(procedure (localproc_5 param1 &tmp temp0 temp1)
	(Message msgGET 460 [param1 0] [param1 1] [param1 2] [param1 3] (local45 data:))
	(local44 format: {%s %s} [param1 4] (local45 data:))
	(= temp0 [param1 5])
	(= temp1 [param1 6])
	((= [local40 temp0] (DText new:))
		font: 460
		text: (KString 8 (local44 data:)) ; StrDup
		fore: 102
		back: 101
		x: (+ 65 (* temp1 3))
		y: 72
		setSize: 110
		setPri: (+ (GetHighPlanePri) 1)
		init:
	)
)

(procedure (localproc_6 param1 param2)
	(if (or (< argc 2) (and (> argc 1) param2))
		(if local60
			([local40 local60] fore: 102 draw:)
		)
		([local40 param1] fore: 145 draw:)
		(= local60 param1)
	else
		([local40 param1] fore: 102 draw:)
		(= local60 0)
	)
)

(procedure (localproc_7 param1 param2)
	(Text 0 (local46 data:) (local44 data:) 460 110)
	((= [local30 param1] (DText new:))
		font: 460
		text: (KString 8 (local44 data:)) ; StrDup
		fore: 102
		back: 101
		x:
			(if (== param2 -1)
				(+ 65 (/ (- 110 (- (local46 at: 2) (local46 at: 0))) 2))
			else
				(+ 65 (* param2 3))
			)
		y: (+ 27 (* 5 param1))
		setSize: 110
		setPri: (+ (GetHighPlanePri) 1)
		init:
	)
)

(procedure (localproc_8 param1 &tmp temp0 temp1)
	(if (< argc 7)
		(Message
			msgGET
			390
			[param1 0]
			[param1 1]
			[param1 2]
			[param1 3]
			(local44 data:)
		)
		(= temp0 [param1 4])
		(= temp1 [param1 5])
	else
		(Message
			msgGET
			390
			[param1 0]
			[param1 1]
			[param1 2]
			[param1 3]
			(local45 data:)
		)
		(local44 format: {%s %s} [param1 4] (local45 data:))
		(= temp0 [param1 5])
		(= temp1 [param1 6])
	)
	(Text 0 (local46 data:) (local44 data:) 460 110)
	((= [local30 temp0] (DText new:))
		font: 460
		text: (KString 8 (local44 data:)) ; StrDup
		fore: 145
		back: 101
		x:
			(if (== temp1 -1)
				(+ 65 (/ (- 110 (- (local46 at: 2) (local46 at: 0))) 2))
			else
				(+ 65 (* temp1 3))
			)
		y: (+ 27 (* 5 temp0))
		setSize: 110
		setPri: (+ (GetHighPlanePri) 1)
		init:
	)
)

(instance rm460 of SQRoom
	(properties
		picture 460
	)

	(method (init &tmp temp0)
		(super init:)
		(= local64 (gGSound1 vol:))
		(= local65 (gGSound2 vol:))
		(gGSound1 setVol: 90)
		(gGSound2 setVol: 90)
		(gTheIconBar setupExit: 1)
		(if (IsFlag 110)
			(gGame handsOff:)
		else
			(gGame handsOn:)
			(gTheIconBar select: (gTheIconBar at: 2) disable: 3)
		)
		(= local44 (Str newWith: 80 {}))
		(= local45 (Str newWith: 80 {}))
		(= local47 (Str newWith: 80 {}))
		(= local46 (IntArray newWith: 4 {}))
		(KString 5 (local44 data:) 0 80 0) ; StrFill
		(KString 5 (local45 data:) 0 80 0) ; StrFill
		(KString 5 (local47 data:) 0 80 0) ; StrFill
		(compost init:)
		(intraShip init:)
		(comm init:)
		(database init:)
		(cyberSpace init:)
		(for ((= temp0 0)) (< temp0 10) ((++ temp0))
			((= [local0 temp0] (Button new:))
				init:
				setLoop: temp0
				posn: [local10 temp0] [local20 temp0]
				value: temp0
			)
		)
		(enterButton init:)
		(leftArrow init:)
		(upArrow init:)
		(rightArrow init:)
		(downArrow init:)
		(dataSlot init:)
		(cyberjack init:)
		(viewscreen init:)
		(Load 140 915 917 921) ; WAVE
		(Lock 140 915 1) ; WAVE
		(Lock 140 917 1) ; WAVE
		(Lock 140 921 1) ; WAVE
		(cond
			((IsFlag 110)
				(Load 140 385) ; WAVE
				(database setCel: 1)
				(intraShip setCel: 0)
				(comm setCel: 0)
				(cyberSpace setCel: 0)
				(localproc_2 8 33 0 1 0 -1)
				(localproc_4 8 33 16 1 2 0)
				(gCurRoom setScript: sDatacartSequence)
			)
			(
				(or
					(and (== gPrevRoomNum 390) (IsFlag 41) (not (IsFlag 118)))
					(and (== gPrevRoomNum 390) (IsFlag 424) (not (IsFlag 116)))
					(and
						(== gPrevRoomNum 390)
						(IsFlag 116)
						(IsFlag 117)
						(== gAct 1)
					)
				)
				(comm doVerb: 4)
			)
			(else
				(localproc_2 1 0 10 1 0 -1)
				(localproc_2 1 0 11 1 2 -1)
				(localproc_2 1 0 2 1 3 -1)
				(localproc_2 1 0 3 1 4 -1)
				(localproc_2 1 0 4 1 5 -1)
				(localproc_2 1 0 5 1 6 -1)
			)
		)
		(= gComPostNextRoomNum 0)
	)

	(method (doVerb)
		(= gComPostNextRoomNum 0)
		(gCurRoom newRoom: gPrevRoomNum)
	)

	(method (dispose)
		(gGSound1 setVol: local64)
		(gGSound2 setVol: local65)
		(Lock 140 915 0) ; WAVE
		(Lock 140 917 0) ; WAVE
		(Lock 140 921 0) ; WAVE
		(gTheIconBar setupExit: 0)
		(gTheIconBar enable: 3)
		(local44 dispose:)
		(local45 dispose:)
		(local47 dispose:)
		(local46 dispose:)
		(super dispose:)
	)
)

(class DoitFeature of Feature
	(properties)

	(method (init param1)
		(super init: &rest)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if
			(and
				(!= gTheCursor gWaitCursor)
				(not ((gTheIconBar plane:) onMe: (gUser curEvent:)))
			)
			(cond
				(
					(and
						(gUser canInput:)
						(not (self onMe: (gUser curEvent:)))
						(!= gTheCursor gTheExitCursor)
					)
					(gGame setCursor: gTheExitCursor 1)
				)
				(
					(and
						(gUser canInput:)
						(self onMe: (gUser curEvent:))
						(!= gTheCursor ((gTheIconBar curIcon:) getCursor:))
					)
					(gGame setCursor: ((gTheIconBar curIcon:) getCursor:))
				)
			)
		)
	)
)

(class Button of View
	(properties
		x 201
		y 109
		view 461
		value 0
	)

	(method (doit)
		(if (and scratch (> (Abs (- gGameTime scratch)) 20))
			(self setCel: 0 scratch: 0)
		)
		(super doit:)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(4 ; Do
				(sfxButton play:)
				(= scratch gGameTime)
				(self setCel: 1)
				(cond
					(local60
						(cond
							((or (== local59 1) (== local59 2))
								(if (< 0 value 3)
									(localproc_6 value)
								)
							)
							((and (== local59 3) (< 0 value 4))
								(localproc_6 value)
							)
						)
					)
					(local48
						(= local49 value)
						(localproc_3 7 0 13 1 9 -1)
						(cond
							((== local51 3)
								(switch local49
									(1
										(localproc_1 3)
									)
									(2
										(localproc_1 5)
									)
									(else
										(= temp0 local55)
										(localproc_1 local55 0)
										(= local55 temp0)
									)
								)
							)
							((< 0 local49 (+ (- local54 local53) 2))
								(localproc_1 (+ local53 (- local49 1)))
							)
							(else
								(= temp0 local55)
								(localproc_1 local55 0)
								(= local55 temp0)
							)
						)
					)
					((or (not local77) local78)
						(if (== (+= local79 value) [local69 local77])
							(= local78 1)
							(++ local77)
						else
							(= local78 0)
							(= local77 0)
							(= local79 0)
						)
					)
					(else
						(= local78 1)
						(= local77 0)
						(= local79 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(class ArrowCursor of View
	(properties
		theDirection 0
	)

	(method (doVerb theVerb &tmp temp0 temp1 temp2 temp3)
		(switch theVerb
			(4 ; Do
				(= cel (= temp1 1))
				(UpdateScreenItem self)
				(FrameOut)
				(= scratch gGameTime)
				(= temp2 0)
				(= temp3 1)
				(while (!= ((= temp0 (Event new:)) type:) evMOUSERELEASE)
					(if temp3
						(sfxUpDown play:)
						(= temp3 0)
					)
					(temp0 localize: plane)
					(cond
						((self onMe: temp0)
							(if (not temp1)
								(= cel (= temp1 1))
								(UpdateScreenItem self)
								(FrameOut)
							)
							(if
								(and
									(not (mod (Abs (- gGameTime scratch)) 30))
									(!= temp2 gGameTime)
								)
								(if local60
									(cond
										((or (== local59 1) (== local59 2))
											(if (== local60 1)
												(localproc_6 2)
											else
												(localproc_6 1)
											)
										)
										(
											(and
												(== local59 3)
												(== theDirection 2)
											)
											(if (== local60 3)
												(localproc_6 1)
											else
												(localproc_6 (+ local60 1))
											)
										)
										(
											(and
												(== local59 3)
												(== theDirection 4)
											)
											(if (== local60 1)
												(localproc_6 3)
											else
												(localproc_6 (- local60 1))
											)
										)
									)
								)
								(if local55
									(if (== local51 3)
										(if (== local55 3)
											(localproc_1 5)
											(= local49 2)
										else
											(localproc_1 3)
											(= local49 1)
										)
										(localproc_3 7 0 13 1 9 -1)
									else
										(switch theDirection
											(3
												(if (< local55 local54)
													(localproc_1 (+ local55 1))
													(= local49
														(+
															(- local55 local53)
															1
														)
													)
												else
													(localproc_1 local53)
													(= local49 1)
												)
												(localproc_3 7 0 13 1 9 -1)
											)
											(1
												(if (> local55 local53)
													(localproc_1 (- local55 1))
													(= local49
														(+
															(- local55 local53)
															1
														)
													)
												else
													(localproc_1 local54)
													(= local49
														(+
															(- local54 local53)
															1
														)
													)
												)
												(localproc_3 7 0 13 1 9 -1)
											)
										)
									)
								)
								(FrameOut)
							)
							(= temp2 gGameTime)
							(= gGameTime (+ gTickOffset (GetTime)))
						)
						(temp1
							(= cel (= temp1 0))
							(UpdateScreenItem self)
							(FrameOut)
						)
					)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(if (== temp1 1)
					(= cel 0)
					(UpdateScreenItem self)
					(FrameOut)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance compost of DoitFeature
	(properties
		nsLeft 56
		nsTop 17
		nsRight 265
		nsBottom 125
		x 160
		z 71
	)
)

(instance dataSlot of Feature
	(properties
		noun 16
		x 257
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 250 16 264 16 264 125 250 125
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(105 ; Data_Cart
				(if local67
					(gCurRoom setScript: sDatacartSequence 0 1)
				else
					(gMessager say: noun theVerb 27) ; "That must not work at this time."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cyberjack of Feature
	(properties
		noun 17
		x 214
		y 45
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 182 28 246 28 246 62 182 62
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance viewscreen of Feature
	(properties
		noun 18
		x 119
		y 51
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 61 21 177 21 177 81 61 81
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance intraShip of View
	(properties
		x 61
		y 88
		view 460
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setCel: 1)
				(comm setCel: 0)
				(database setCel: 0)
				(cyberSpace setCel: 0)
				(if local68
					(sfxChoose play:)
				else
					(= local68 1)
				)
				(localproc_0)
				(localproc_2 7 0 10 1 0 -1)
				(localproc_2 7 0 1 1 1 -1)
				(localproc_2 7 0 17 1 {@.} 3 6)
				(localproc_2 7 0 21 1 {2.} 4 6)
				(localproc_2 7 0 20 1 {3.} 5 6)
				(localproc_2 7 0 25 1 {4.} 6 6)
				(localproc_2 6 51 0 1 {5.} 7 6)
				(localproc_1 3)
				(= local53 3)
				(= local54 7)
				(= local49 1)
				(if local67
					(= local67 0)
				)
				(= local51 1)
				(= local48 1)
				(localproc_3 7 0 13 1 9 -1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance comm of View
	(properties
		x 61
		y 97
		view 460
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local51 0)
				(= local48 0)
				(= local49 -1)
				(= local55 0)
				(if local67
					(= local67 0)
				)
				(self setCel: 1)
				(intraShip setCel: 0)
				(database setCel: 0)
				(cyberSpace setCel: 0)
				(if local68
					(sfxChoose play:)
				else
					(= local68 1)
				)
				(localproc_0)
				(cond
					(
						(or
							(and
								(== gPrevRoomNum 390)
								(IsFlag 41)
								(not (IsFlag 118))
							)
							(and
								(== gPrevRoomNum 390)
								(IsFlag 424)
								(not (IsFlag 116))
							)
							(and (== gPrevRoomNum 390) (IsFlag 116) (IsFlag 117))
						)
						(gCurRoom setScript: sIncomingMessage)
					)
					((== gPrevRoomNum 390)
						(localproc_8 48 0 10 1 3 -1)
					)
					(else
						(localproc_2 5 0 15 1 0 -1)
						(localproc_2 5 0 3 1 2 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance database of View
	(properties
		x 61
		y 105
		view 460
		loop 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(self setCel: 1)
				(intraShip setCel: 0)
				(comm setCel: 0)
				(cyberSpace setCel: 0)
				(if local68
					(sfxChoose play:)
				else
					(= local68 1)
				)
				(localproc_0)
				(localproc_2 6 0 10 1 0 -1)
				(localproc_2 6 0 11 1 {@.} 2 8)
				(localproc_2 6 0 2 1 {2.} 3 8)
				(localproc_2 6 0 3 1 {3.} 4 8)
				(localproc_1 2)
				(= local53 2)
				(= local54 4)
				(if local67
					(= local67 0)
				)
				(= local51 4)
				(= local48 1)
				(= local49 1)
				(localproc_3 7 0 13 1 9 -1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cyberSpace of View
	(properties
		x 61
		y 114
		view 460
		loop 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local51 0)
				(= local48 0)
				(= local49 -1)
				(= local55 0)
				(if local68
					(sfxChoose play:)
				else
					(= local68 1)
				)
				(self setCel: 1)
				(intraShip setCel: 0)
				(comm setCel: 0)
				(database setCel: 0)
				(if local67
					(= local67 0)
				)
				(localproc_0)
				(localproc_2 4 0 0 1 2 -1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance enterButton of Button
	(properties
		x 233
		y 68
		loop 10
		value 10
	)

	(method (doit)
		(super doit:)
		(if local52
			(++ local66)
		)
		(if (and local52 (> local66 150))
			(gCurRoom newRoom: gPrevRoomNum)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(sfxEnter play:)
				(= scratch gGameTime)
				(self setCel: 1)
				(cond
					((== local51 1)
						(cond
							((< 0 local49 6)
								(switch (= local50 local49)
									(1
										(= gComPostNextRoomNum 360)
									)
									(2
										(= gComPostNextRoomNum 370)
									)
									(3
										(= gComPostNextRoomNum 430)
									)
									(4
										(= gComPostNextRoomNum 400)
									)
									(5
										(localproc_0)
										(localproc_2 7 0 10 1 0 -1)
										(localproc_2 7 0 1 1 1 -1)
										(localproc_2 7 0 18 1 {@.} 3 6)
										(localproc_2 7 0 19 1 {2.} 4 6)
										(localproc_2 7 0 22 1 {3.} 5 6)
										(localproc_2 7 0 24 1 {4.} 6 6)
										(localproc_2 6 51 0 1 {5.} 7 6)
										(localproc_1 3)
										(= local53 3)
										(= local54 7)
										(= local49 1)
										(= local51 2)
										(localproc_3 7 0 13 1 9 -1)
									)
								)
								(cond
									((== local50 5) 0)
									((== gComPostNextRoomNum gPrevRoomNum)
										(gCurRoom setScript: sInvalidEntry 0 1)
									)
									(else
										(localproc_0)
										(localproc_2 7 29 2 1 {@.} 3 6)
										(localproc_2 7 30 4 1 {2.} 5 6)
										(= local55 0)
										(= local53 3)
										(= local54 5)
										(localproc_1 3)
										(= local49 1)
										(= local51 3)
										(localproc_3 7 0 13 1 9 -1)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 2)
						(cond
							((< 0 local49 6)
								(switch (= local50 local49)
									(1
										(= gComPostNextRoomNum 390)
									)
									(2
										(= gComPostNextRoomNum 440)
									)
									(3
										(= gComPostNextRoomNum 380)
									)
									(4
										(= gComPostNextRoomNum 420)
									)
									(5
										(= local68 0)
										(intraShip doVerb: 4)
									)
								)
								(cond
									((== local50 5) 0)
									((== gComPostNextRoomNum gPrevRoomNum)
										(gCurRoom setScript: sInvalidEntry 0 1)
									)
									(else
										(localproc_0)
										(localproc_2 7 29 2 1 {@.} 3 6)
										(localproc_2 7 30 4 1 {2.} 5 6)
										(= local55 0)
										(= local53 3)
										(= local54 5)
										(localproc_1 3)
										(= local49 1)
										(= local57 local51)
										(= local51 3)
										(localproc_3 7 0 13 1 9 -1)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 3)
						(cond
							((== local49 1)
								(gGame handsOff:)
								(= local66 0)
								(= local52 1)
							)
							((== local49 2)
								(= gComPostNextRoomNum 0)
								(if (== local57 2)
									(= local51 1)
									(= local49 5)
									(enterButton doVerb: 4)
								else
									(= local68 0)
									(intraShip doVerb: 4)
								)
								(= local57 0)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 4)
						(cond
							((< 0 local49 4)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 6 0 11 1 0 -1)
										(localproc_2 8 33 0 1 {@.} 2 8)
										(localproc_2 8 34 0 1 {2.} 3 8)
										(localproc_2 6 49 0 1 {3.} 4 8)
										(localproc_1 2)
										(= local53 2)
										(= local54 4)
										(= local51 5)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(2
										(localproc_0)
										(localproc_2 6 0 2 1 0 -1)
										(localproc_2 9 35 0 1 {@.} 2 8)
										(localproc_2 9 36 0 1 {2.} 3 8)
										(localproc_2 6 49 0 1 {3.} 4 8)
										(localproc_1 2)
										(= local53 2)
										(= local54 4)
										(= local51 6)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(3
										(localproc_0)
										(localproc_2 6 0 3 1 0 -1)
										(localproc_2 10 37 0 1 {@.} 2 6)
										(localproc_2 10 38 0 1 {2.} 3 6)
										(localproc_2 6 49 0 1 {3.} 4 6)
										(localproc_1 2)
										(= local53 2)
										(= local54 4)
										(= local51 7)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 5)
						(cond
							((< 0 local49 4)
								(= local57 5)
								(= local58 local49)
								(= local62 4)
								(= local61 1)
								(switch local49
									(1
										(= local67 1)
										(localproc_0)
										(localproc_2 8 33 0 1 0 -1)
										(localproc_4 8 33 16 local56 3 -1)
									)
									(2
										(localproc_0)
										(localproc_2 8 34 0 1 0 -1)
										(localproc_2 12 45 0 1 {@.} 2 13)
										(localproc_2 12 46 0 1 {2.} 3 13)
										(localproc_2 12 47 0 1 {3.} 4 13)
										(localproc_2 12 48 0 1 {4.} 5 13)
										(localproc_2 6 49 0 1 {5.} 6 13)
										(localproc_1 2)
										(= local53 2)
										(= local54 6)
										(= local51 8)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(3
										(= local68 0)
										(database doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 6)
						(cond
							((< 0 local49 4)
								(= local57 6)
								(= local58 local49)
								(= local62 4)
								(= local61 2)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 9 35 0 1 0 -1)
										(localproc_4 9 35 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 9 36 0 1 0 -1)
										(localproc_4 9 36 16 local56 2 0)
									)
									(3
										(= local68 0)
										(database doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 7)
						(cond
							((< 0 local49 4)
								(= local57 7)
								(= local58 local49)
								(= local62 4)
								(= local61 3)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 10 37 0 1 0 -1)
										(localproc_4 10 37 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 10 38 0 1 0 -1)
										(localproc_4 10 38 16 local56 2 0)
									)
									(3
										(= local68 0)
										(database doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 8)
						(cond
							((< 0 local49 6)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 11 0 15 1 0 -1)
										(localproc_2 11 40 0 1 {@.} 2 6)
										(localproc_2 11 41 0 1 {2.} 3 6)
										(localproc_2 11 42 0 1 {3.} 4 6)
										(localproc_2 11 43 0 1 {4.} 5 6)
										(localproc_2 6 51 0 1 {5.} 6 6)
										(localproc_2 6 49 0 1 {6.} 7 6)
										(localproc_1 2)
										(= local53 2)
										(= local54 7)
										(= local51 9)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(2
										(localproc_0)
										(localproc_2 13 0 15 1 0 -1)
										(localproc_2 13 40 0 1 {@.} 2 0)
										(localproc_2 13 41 0 1 {2.} 3 0)
										(localproc_2 13 42 0 1 {3.} 4 0)
										(localproc_2 13 43 0 1 {4.} 5 0)
										(localproc_2 6 51 0 1 {5.} 6 0)
										(localproc_2 6 49 0 1 {6.} 7 0)
										(localproc_1 2)
										(= local53 2)
										(= local54 7)
										(= local51 11)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(3
										(localproc_0)
										(localproc_2 14 0 15 1 0 -1)
										(localproc_2 14 40 0 1 {@.} 2 3)
										(localproc_2 14 41 0 1 {2.} 3 3)
										(localproc_2 14 42 0 1 {3.} 4 3)
										(localproc_2 14 43 0 1 {4.} 5 3)
										(localproc_2 6 51 0 1 {5.} 6 3)
										(localproc_2 6 49 0 1 {6.} 7 3)
										(localproc_1 2)
										(= local53 2)
										(= local54 7)
										(= local51 14)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(4
										(localproc_0)
										(localproc_2 15 0 15 1 0 -1)
										(localproc_2 15 40 0 1 {@.} 2 8)
										(localproc_2 15 41 0 1 {2.} 3 8)
										(localproc_2 15 42 0 1 {3.} 4 8)
										(localproc_2 15 43 0 1 {4.} 5 8)
										(localproc_2 6 49 0 1 {5.} 6 8)
										(localproc_1 2)
										(= local53 2)
										(= local54 6)
										(= local51 16)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(5
										(= local51 4)
										(= local49 1)
										(enterButton doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 9)
						(cond
							((< 0 local49 7)
								(= local57 9)
								(= local58 local49)
								(= local62 8)
								(= local61 1)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 11 40 0 1 0 -1)
										(localproc_4 11 40 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 11 41 0 1 0 -1)
										(localproc_4 11 41 16 local56 2 0)
									)
									(3
										(localproc_0)
										(localproc_2 11 42 0 1 0 -1)
										(localproc_4 11 42 16 local56 2 0)
									)
									(4
										(localproc_0)
										(localproc_2 11 43 0 1 0 -1)
										(localproc_4 11 43 16 local56 2 0)
									)
									(5
										(localproc_0)
										(localproc_2 11 0 15 1 0 -1)
										(localproc_2 11 44 0 1 {@.} 2 4)
										(localproc_2 11 52 0 1 {2.} 3 4)
										(localproc_2 11 53 0 1 {3.} 4 4)
										(localproc_2 11 54 0 1 {4.} 5 4)
										(localproc_2 6 51 0 1 {5.} 6 4)
										(localproc_2 6 49 0 1 {6.} 7 4)
										(localproc_1 2)
										(= local53 2)
										(= local54 7)
										(= local51 10)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(6
										(= local51 5)
										(= local49 2)
										(enterButton doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 10)
						(cond
							((< 0 local49 7)
								(= local57 10)
								(= local58 local49)
								(= local62 9)
								(= local61 5)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 11 44 0 1 0 -1)
										(localproc_4 11 44 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 11 52 0 1 0 -1)
										(localproc_4 11 52 16 local56 2 0)
									)
									(3
										(localproc_0)
										(localproc_2 11 53 0 1 0 -1)
										(localproc_4 11 53 16 local56 2 0)
									)
									(4
										(localproc_0)
										(localproc_2 11 54 0 1 0 -1)
										(localproc_4 11 54 16 local56 2 0)
									)
									(5
										(= local51 8)
										(= local49 1)
										(enterButton doVerb: 4)
									)
									(6
										(= local51 5)
										(= local49 2)
										(enterButton doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 11)
						(cond
							((< 0 local49 7)
								(= local57 11)
								(= local58 local49)
								(= local62 8)
								(= local61 2)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 13 40 0 1 0 -1)
										(localproc_4 13 40 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 13 41 0 1 0 -1)
										(localproc_4 13 41 16 local56 2 0)
									)
									(3
										(localproc_0)
										(localproc_2 13 42 0 1 0 -1)
										(localproc_4 13 42 16 local56 2 0)
									)
									(4
										(localproc_0)
										(localproc_2 13 43 0 1 0 -1)
										(localproc_4 13 43 16 local56 2 0)
									)
									(5
										(localproc_0)
										(localproc_2 13 0 15 1 0 -1)
										(localproc_2 13 44 0 1 {@.} 2 4)
										(localproc_2 13 52 0 1 {2.} 3 4)
										(localproc_2 13 53 0 1 {3.} 4 4)
										(localproc_2 13 54 0 1 {4.} 5 4)
										(localproc_2 6 51 0 1 {5.} 6 4)
										(localproc_2 6 49 0 1 {6.} 7 4)
										(localproc_1 2)
										(= local53 2)
										(= local54 7)
										(= local51 12)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(6
										(= local51 5)
										(= local49 2)
										(enterButton doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 12)
						(cond
							((< 0 local49 7)
								(= local57 12)
								(= local58 local49)
								(= local62 11)
								(= local61 5)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 13 44 0 1 0 -1)
										(localproc_4 13 44 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 13 52 0 1 0 -1)
										(localproc_4 13 52 16 local56 2 0)
									)
									(3
										(localproc_0)
										(localproc_2 13 53 0 1 0 -1)
										(localproc_4 13 53 16 local56 2 0)
									)
									(4
										(localproc_0)
										(localproc_2 13 54 0 1 0 -1)
										(localproc_4 13 54 16 local56 2 0)
									)
									(5
										(localproc_0)
										(localproc_2 13 0 15 1 0 -1)
										(localproc_2 13 55 0 1 {@.} 2 4)
										(localproc_2 13 56 0 1 {2.} 3 4)
										(localproc_2 13 57 0 1 {3.} 4 4)
										(localproc_2 13 58 0 1 {4.} 5 4)
										(localproc_2 6 51 0 1 {5.} 6 4)
										(localproc_2 6 49 0 1 {6.} 7 4)
										(localproc_1 2)
										(= local53 2)
										(= local54 7)
										(= local51 13)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(6
										(= local51 5)
										(= local49 2)
										(enterButton doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 13)
						(cond
							((< 0 local49 7)
								(= local57 13)
								(= local58 local49)
								(= local62 12)
								(= local61 5)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 13 55 0 1 0 -1)
										(localproc_4 13 55 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 13 56 0 1 0 -1)
										(localproc_4 13 56 16 local56 2 0)
									)
									(3
										(localproc_0)
										(localproc_2 13 57 0 1 0 -1)
										(localproc_4 13 57 16 local56 2 0)
									)
									(4
										(localproc_0)
										(localproc_2 13 58 0 1 0 -1)
										(localproc_4 13 58 16 local56 2 0)
									)
									(5
										(= local51 8)
										(= local49 2)
										(enterButton doVerb: 4)
									)
									(6
										(= local51 5)
										(= local49 2)
										(enterButton doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 14)
						(cond
							((< 0 local49 7)
								(= local57 14)
								(= local58 local49)
								(= local62 8)
								(= local61 3)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 14 40 0 1 0 -1)
										(localproc_4 14 40 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 14 41 0 1 0 -1)
										(localproc_4 14 41 16 local56 2 0)
									)
									(3
										(localproc_0)
										(localproc_2 14 42 0 1 0 -1)
										(localproc_4 14 42 16 local56 2 0)
									)
									(4
										(localproc_0)
										(localproc_2 14 43 0 1 0 -1)
										(localproc_4 14 43 16 local56 2 0)
									)
									(5
										(localproc_0)
										(localproc_2 14 0 15 1 0 -1)
										(localproc_2 14 44 0 1 {@.} 2 8)
										(localproc_2 14 52 0 1 {2.} 3 8)
										(localproc_2 6 51 0 1 {3.} 4 8)
										(localproc_2 6 49 0 1 {4.} 5 8)
										(localproc_1 2)
										(= local53 2)
										(= local54 7)
										(= local51 15)
										(= local49 1)
										(localproc_3 7 0 13 1 9 -1)
									)
									(6
										(= local51 5)
										(= local49 2)
										(enterButton doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 15)
						(cond
							((< 0 local49 5)
								(= local57 15)
								(= local58 local49)
								(= local62 14)
								(= local61 5)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 14 44 0 1 0 -1)
										(localproc_4 14 44 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 14 52 0 1 0 -1)
										(localproc_4 14 52 16 local56 2 0)
									)
									(3
										(= local51 8)
										(= local49 3)
										(enterButton doVerb: 4)
									)
									(4
										(= local51 5)
										(= local49 2)
										(enterButton doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 16)
						(cond
							((< 0 local49 6)
								(= local57 16)
								(= local58 local49)
								(= local62 8)
								(= local61 4)
								(switch local49
									(1
										(localproc_0)
										(localproc_2 15 40 0 1 0 -1)
										(localproc_4 15 40 16 local56 2 0)
									)
									(2
										(localproc_0)
										(localproc_2 15 41 0 1 0 -1)
										(localproc_4 15 41 16 local56 2 0)
									)
									(3
										(localproc_0)
										(localproc_2 15 42 0 1 0 -1)
										(localproc_4 15 42 16 local56 2 0)
									)
									(4
										(localproc_0)
										(localproc_2 15 43 0 1 0 -1)
										(localproc_4 15 43 16 local56 2 0)
									)
									(5
										(= local51 5)
										(= local49 2)
										(enterButton doVerb: 4)
									)
								)
							)
							((!= local49 -1)
								(gCurRoom setScript: sInvalidEntry)
							)
						)
					)
					((== local51 17)
						(= local49 local60)
						(switch local59
							(0
								(if local67
									(= local67 0)
								)
								(= local63 0)
								(= local51 local62)
								(= local49 local61)
								(= local56 1)
							)
							(1
								(switch local49
									(1
										(= local63 0)
										(++ local56)
										(= local51 local57)
										(= local49 local58)
									)
									(2
										(= local63 0)
										(= local51 local62)
										(= local49 local61)
										(= local56 1)
									)
								)
							)
							(2
								(switch local49
									(1
										(= local63 1)
										(-- local56)
										(= local51 local57)
										(= local49 local58)
									)
									(2
										(= local63 0)
										(= local51 local62)
										(= local49 local61)
										(= local56 1)
									)
								)
							)
							(3
								(switch local49
									(1
										(= local63 0)
										(++ local56)
										(= local51 local57)
										(= local49 local58)
									)
									(2
										(= local63 1)
										(-- local56)
										(= local51 local57)
										(= local49 local58)
									)
									(3
										(= local63 0)
										(= local51 local62)
										(= local49 local61)
										(= local56 1)
									)
								)
							)
						)
						(enterButton doVerb: 4)
					)
					((and (== local51 0) local78 (== local77 7))
						(localproc_0)
						(local44
							format:
								{I DEDICATE THIS GAME TO MY LOVING WIFE, MICHELE, AND OUR WONDERFUL SON, SEAN.  I LOVE THEM BOTH VERY MUCH!\n\n                                LOVE,\n                                STEVE}
						)
						(localproc_7 2 -1)
						(= local78 1)
						(= local77 0)
						(= local79 0)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance leftArrow of ArrowCursor
	(properties
		x 140
		y 99
		view 460
		loop 5
		theDirection 4
	)
)

(instance upArrow of ArrowCursor
	(properties
		x 154
		y 88
		view 460
		loop 4
		theDirection 1
	)
)

(instance rightArrow of ArrowCursor
	(properties
		x 168
		y 99
		view 460
		loop 7
		theDirection 2
	)
)

(instance downArrow of ArrowCursor
	(properties
		x 154
		y 111
		view 460
		loop 6
		theDirection 3
	)
)

(instance sInvalidEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if register
					(localproc_2 7 32 14 1 8 -1)
				else
					(localproc_2 7 31 14 1 8 -1)
				)
				(localproc_3 7 0 13 1 9 -1)
				(= ticks 30)
			)
			(1
				(if [local30 8]
					([local30 8] dispose:)
					(= [local30 8] 0)
				)
				(= ticks 30)
			)
			(2
				(if register
					(localproc_2 7 32 14 1 8 -1)
				else
					(localproc_2 7 31 14 1 8 -1)
				)
				(localproc_3 7 0 13 1 9 -1)
				(= ticks 30)
			)
			(3
				(if [local30 8]
					([local30 8] dispose:)
					(= [local30 8] 0)
				)
				(= ticks 30)
			)
			(4
				(if register
					(localproc_2 7 32 14 1 8 -1)
				else
					(localproc_2 7 31 14 1 8 -1)
				)
				(localproc_3 7 0 13 1 9 -1)
				(= ticks 30)
			)
			(5
				(if [local30 8]
					([local30 8] dispose:)
					(= [local30 8] 0)
				)
				(= ticks 30)
			)
			(6
				(= local48 1)
				(if (== local51 3)
					(if (== local55 3)
						(= local49 1)
					else
						(= local49 2)
					)
				else
					(= local49 (+ (- local55 local53) 1))
				)
				(if local55
					(localproc_1 local55)
				)
				(localproc_3 7 0 13 1 9 -1)
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2) disable: 3)
				(self dispose:)
			)
		)
	)
)

(instance sDatacartSequence of Script
	(properties)

	(method (handleEvent)
		(gMouseDownHandler delete: self)
		(= ticks 0)
		(self changeState: 6)
		(super handleEvent: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gGame handsOff:)
				)
				(= cycles 3)
			)
			(1
				(= ticks 120)
			)
			(2
				(cartridge init: y: -50)
				(= ticks 45)
			)
			(3
				(sfxDatacart play:)
				(cartridge setMotion: MoveTo 267 130 self)
			)
			(4
				(sfxDatacart stop:)
				(cartridge dispose:)
				(= ticks 60)
			)
			(5
				(localproc_0)
				(localproc_2 8 33 0 1 0 -1)
				(localproc_4 8 33 23 1 2 -1)
				(if register
					(gGame handsOn:)
					(self dispose:)
				else
					(gMouseDownHandler addToFront: self)
					(= ticks 1200)
				)
			)
			(6
				(if (gMouseDownHandler contains: self)
					(gMouseDownHandler delete: self)
				)
				(gMessager sayRange: 0 0 5 1 2 self 380) ; "Oh, hi, Stellar. I hope your back's feeling better."
			)
			(7
				(gCurRoom newRoom: 380)
				(self dispose:)
			)
		)
	)
)

(instance cartridge of Actor
	(properties
		x 267
		y -50
		priority 200
		fixPriority 1
		view 462
		signal 24609
		moveSpeed 1
	)
)

(instance sfxUpDown of Sound
	(properties
		flags 1
		number 917
	)
)

(instance sfxChoose of Sound
	(properties
		flags 1
		number 915
	)
)

(instance sfxButton of Sound
	(properties
		flags 1
		number 921
	)
)

(instance sfxEnter of Sound
	(properties
		flags 1
		number 916
	)
)

(instance sfxDatacart of Sound
	(properties
		flags 1
		number 385
		loop -1
	)
)

(instance Stellar of SmallTalker
	(properties)

	(method (init)
		(= showTalk (= prepMove 0))
		(super init:)
	)
)

(instance Stellar_Santiago of Talker
	(properties
		name {Stellar Santiago}
	)

	(method (init)
		(super init: sanMouth sanBust sanEyes)
	)
)

(instance sanBust of Prop
	(properties
		x 64
		y 22
		view 463
	)
)

(instance sanMouth of Prop
	(properties
		x 120
		y 59
		view 463
		loop 1
	)
)

(instance sanEyes of Prop
	(properties
		x 120
		y 44
		view 463
		loop 2
	)
)

(instance Commander_Kielbasa of Talker
	(properties
		name {Commander Kielbasa}
	)

	(method (init)
		(super init: kielMouth kielBust kielEyes)
	)
)

(instance kielBust of Prop
	(properties
		x 59
		y 83
		view 465
	)
)

(instance kielMouth of Prop
	(properties
		x 121
		y 55
		view 465
		loop 1
	)
)

(instance kielEyes of Prop
	(properties
		x 121
		y 38
		view 465
		loop 2
	)
)

(instance sIncomingMessage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 466 463)
				(= cycles 3)
			)
			(1
				(sound1 number: 363 loop: 0 play:)
				(= ticks 120)
			)
			(2
				(incoming init: cycleSpeed: 20 setCycle: Fwd)
				(playMsg init:)
				(gMessager say: 48 0 9 0 self 390) ; "Wow, a message for ME. I must be getting popular."
			)
			(3
				(playMsg setCycle: End)
				(= ticks 60)
			)
			(4
				(playMsg dispose:)
				(incoming dispose:)
				(cond
					((and (== gPrevRoomNum 390) (IsFlag 41) (not (IsFlag 118)))
						(gCurRoom setScript: sMesgFromSantiago)
					)
					((and (== gPrevRoomNum 390) (IsFlag 424) (not (IsFlag 116)))
						(gCurRoom setScript: sMesgFromKielbasa)
					)
					((and (== gPrevRoomNum 390) (IsFlag 116) (IsFlag 117))
						(gCurRoom setScript: sMesgFromKielbasa)
					)
				)
				(self dispose:)
			)
		)
	)
)

(instance sMesgFromKielbasa of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 465)
				(= cycles 3)
			)
			(1
				(= gDeepshipLocation 1) ; Delta Burksilon
				(SetFlag 116)
				(gGame points: 3 425)
				(if (IsFlag 117)
					(ClearFlag 117)
					(gMessager say: 45 2 6 2 self 390) ; "Wilco, where are you? You either get down to Delta Burksilon V NOW, or I will have you ejected into space. Is that understood, Janitor?"
				else
					(gMessager say: 45 2 6 1 self 390) ; "Wilco, Commander Kielbasa here. I have a special assignment for you. A crewperson of special skills is required on Delta Burksilon V. In the spirit of StarCon cooperation, we have decided to offer them your assistance. Transport there immediately. Kielbasa out."
				)
			)
			(2
				(end init:)
				(sound1 number: 919 loop: 0 play:)
				(= ticks 160)
			)
			(3
				(end cel: 0 setCycle: End self)
			)
			(4
				(= local68 0)
				(intraShip doVerb: 4)
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2) disable: 3)
				(self dispose:)
			)
		)
	)
)

(instance sMesgFromSantiago of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 463)
				(= cycles 3)
			)
			(1
				(gGame points: 3 507)
				(SetFlag 118)
				(gMessager say: 46 2 7 1 self 390) ; "(LABORED) Roger... help me! I only have a moment... They faked..."
			)
			(2
				(sound1 number: 919 loop: 0 play:)
				(end init:)
				(= ticks 15)
			)
			(3
				(gMessager say: 46 2 7 2 self 390) ; "Stellar! What happened?! The picture's gone. You're alive?!"
			)
			(4
				(end init: cel: 0 setCycle: End self)
			)
			(5
				(= local68 0)
				(intraShip doVerb: 4)
				(gGame handsOn:)
				(gTheIconBar select: (gTheIconBar at: 2) disable: 3)
				(self dispose:)
			)
		)
	)
)

(instance end of Prop
	(properties
		x 79
		y 28
		view 466
	)
)

(instance incoming of Prop
	(properties
		x 64
		y 22
		view 463
		loop 3
	)
)

(instance playMsg of Prop
	(properties
		x 111
		y 55
		view 463
		loop 4
	)
)

(instance sound1 of Sound
	(properties
		flags 1
	)
)

