;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64040)
(include sci.sh)
(use Main)
(use DialogPlane)
(use TranslucentPlane)
(use ModalPlane)
(use PushButton)
(use soFlashCyberSniff)
(use Plane)
(use Str)
(use Feature)
(use System)

(public
	proc64040_0 0
	proc64040_1 1
	L7TalkWindow 2
	UnmarkTopic 3
	RemoveTopic 4
	proc64040_5 5
)

(local
	local0
	local1
	local2
	local3
)

(procedure (UnmarkTopic param1 param2)
	(if (or (< argc 2) (not param1))
		(PrintDebug {Illegal call of UnmarkTopic})
		(return)
	)
	(= param2 (- 0 (Abs param2)))
	(param1 delete: param2)
	(if (and (L7TalkWindow oPlane:) (== (L7TalkWindow oTopics:) param1))
		(L7TalkWindow rebuild:)
	)
)

(procedure (RemoveTopic param1 param2)
	(if (or (< argc 2) (not param1))
		(PrintDebug {Illegal call of RemoveTopic})
		(return)
	)
	(param1 delete: param2)
	(if (and (L7TalkWindow oPlane:) (== (L7TalkWindow oTopics:) param1))
		(L7TalkWindow rebuild:)
	)
)

(procedure (proc64040_5 param1 param2)
	(if (or (< argc 2) (not param1))
		(return (PrintDebug {Illegal call of RemoveTopic}))
	)
	(return (!= (param1 indexOf: (- 0 param2)) -1))
)

(procedure (proc64040_0 &tmp temp0 temp1 temp2)
	(= global246 (Set new:))
	(= global247 (Set new:))
	(= global248 (Set new:))
	(= global249 (Set new:))
	(= global250 (Set new:))
	(= global251 (Set new:))
	(= global252 (Set new:))
	(= global253 (Set new:))
	(= global254 (Set new:))
	(= global255 (Set new:))
	(= global256 (Set new:))
	(= global257 (Set new:))
	(= global258 (Set new:))
	(= global259 (Set new:))
	(global247 add: 102 75 105)
	(global248 add: 131 103 107 129 75 86)
	(global246 add: 244 246 245)
	(global249 add: 247 205 204 86)
	(global250 add: 176 215 217 247 86)
	(global251 add: 203 196 197 193 247 194 86)
	(global252 add: 192 238 223 247 109 242 86)
	(global253 add: 162 86)
	(global254 add: 150 174 247 218 86)
	(global255 add: 184 185 86)
	(global256 add: 211)
	(global257 add: 125)
	(global258 add: 200 237 199 198 86)
	(global259 add: 118 171 86)
	(= local1 (List new:))
	(= local2 (List new:))
	(= local0 0)
	(for ((= temp0 0)) (< temp0 255) ((++ temp0))
		(= temp1 1)
		(while (and 1 (= temp2 (MakeMessageText 0 temp0 0 temp1 12 1)))
			(local1 addToEnd: temp2)
			(local2 addToEnd: temp0)
			(++ temp1)
			(++ local0)
		)
	)
)

(procedure (proc64040_1 param1 &tmp temp0 temp1)
	(if (or (== (= temp1 (Abs param1)) 70) (== temp1 112))
		(return 1)
	)
	(if (== (local2 indexOf: temp1) -1)
		(return 0)
	else
		(return 1)
	)
)

(instance oTalkClose of PushButton ; UNUSED
	(properties
		view 60300
	)

	(method (doSelect)
		(if (and local3 (local3 oPlane:))
			(local3 dispose:)
		else
			(PrintDebug {oTalkClose selected with no current talk window})
		)
	)
)

(class L7TalkWindow of Obj
	(properties
		oPlane 0
		oTopics 0
		nCorner 1
		oClient 0
		nHeaderFont 0
		nButtonFont 0
	)

	(method (init param1 param2)
		(if (or (< argc 2) (not param1) (not param2) (not (param2 size:)))
			(PrintDebug {Illegal call of L7TalkWindow init})
			(return)
		)
		(super init: &rest)
		(= oClient param1)
		(= oTopics param2)
		(self rebuild:)
		(= local3 self)
	)

	(method (addTopic param1 &tmp temp0 temp1)
		(if (not oTopics)
			(PrintDebug {Illegal addTopic call in L7TalkWindow})
			(return)
		)
		(= temp1 0)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(if (not (proc64040_1 [param1 temp0]))
				(return)
			)
			(if (== (oTopics indexOf: [param1 temp0]) -1)
				(oTopics addToEnd: [param1 temp0])
				(= temp1 1)
			)
		)
		(if temp1
			(self rebuild:)
		)
	)

	(method (rebuild &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8 temp9 temp10 temp11 temp12 temp13 temp14 temp15 temp16 temp17 temp18 temp19 temp20 temp21 temp22)
		(if oPlane
			(oPlane dispose:)
		)
		(= oPlane (Plane new:))
		(oPlane picture: -2 init: 0 0 1 1)
		(= temp2 (oClient getName:))
		(= temp5 (+ (GetTextWidth temp2 nHeaderFont 0) 3))
		(= temp4 (+ (= temp4 (GetTextHeight temp2 nHeaderFont 0)) 6))
		(= temp3 (MakeMessageText 0 12 0 1 13))
		(= temp12 (GetTextWidth temp3 nButtonFont 0))
		(if (< temp5 temp12)
			(= temp5 temp12)
		)
		(= temp1 (oTopics size:))
		(= temp21 0)
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(if (< (= temp13 (oTopics at: temp0)) 0)
			else
				(++ temp21)
				(= temp14 (MakeMessageText 0 temp13 0 1 12))
				(= temp12 (GetTextWidth temp14 nButtonFont 0))
				(if (< temp5 temp12)
					(= temp5 temp12)
				)
				(temp14 dispose:)
			)
		)
		(+= temp5 5)
		(= temp6 3)
		(= temp7 (+ temp4 3))
		(= temp22 0)
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(cond
				((< (= temp13 (oTopics at: temp0)) 0))
				((== temp13 86)
					(= temp22 1)
				)
				(else
					(= temp19 (!= (oTopics indexOf: (- 0 temp13)) -1))
					(= temp14 (MakeMessageText 0 temp13 0 1 12))
					(= temp10 (TextButton new:))
					(if temp19
						(= temp20 85)
					else
						(= temp20 87)
					)
					(temp10
						text: temp14
						font: nButtonFont
						fore: temp20
						back: 237
						skip: 255
						nMinWidth: temp5
						x: temp6
						y: temp7
						oSelectNotify: self
						nSelectValue: temp13
						init: oPlane
					)
					(+= temp7 (+ (temp10 nHeight:) 3))
				)
			)
		)
		(if temp22
			(= temp19 (!= (oTopics indexOf: -86) -1))
			(= temp14 (MakeMessageText 0 86 0 1 12))
			(= temp10 (TextButton new:))
			(if temp19
				(= temp20 85)
			else
				(= temp20 87)
			)
			(temp10
				text: temp14
				font: nButtonFont
				fore: temp20
				back: 237
				skip: 255
				nMinWidth: temp5
				x: temp6
				y: temp7
				oSelectNotify: self
				nSelectValue: 86
				init: oPlane
			)
			(+= temp7 (+ (temp10 nHeight:) 3))
		)
		(= temp10 (TextButton new:))
		(temp10
			text: temp3
			font: nButtonFont
			fore: 87
			back: 237
			skip: 255
			nMinWidth: temp5
			x: temp6
			y: temp7
			oSelectNotify: self
			nSelectValue: 112
			init: oPlane
		)
		(= temp9 (+ (temp10 nWidth:) 6))
		(= temp8 (+ temp4 3 (* (+ temp21 1) (+ (temp10 nHeight:) 3))))
		(= temp11 (TextItem new:))
		(temp11
			text: temp2
			font: nHeaderFont
			fore: 0
			back: 82
			skip: 255
			nMinWidth: temp9
			x: 0
			y: 0
			priority: 10
			fixPriority: 1
			init: oPlane
		)
		(switch nCorner
			(0
				(= temp15 0)
				(= temp16 0)
				(= temp17 (- temp9 1))
				(= temp18 (- temp8 1))
			)
			(1
				(= temp15 0)
				(= temp17 639)
				(= temp16 (- 639 (- temp9 1)))
				(= temp18 (- temp8 1))
			)
			(2
				(= temp18 479)
				(= temp16 0)
				(= temp15 (- 479 (- temp8 1)))
				(= temp17 (- temp9 1))
			)
			(3
				(= temp18 479)
				(= temp17 639)
				(= temp15 (- 479 (- temp8 1)))
				(= temp16 (- 639 (- temp9 1)))
			)
		)
		(oPlane setRect: temp16 temp15 temp17 temp18)
		(oPlane setPri: 30)
		((OpaqueFeature new:) init: oPlane)
		((TransView new:)
			remapColor: 237
			x: 0
			y: 0
			setPri: 0
			scaleSignal: 1
			scaleX: (* temp9 32)
			scaleY: (* temp8 32)
			maxScale: 20480
			init: oPlane
		)
	)

	(method (doSelect param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
		(while (== param1 112)
			(= temp0 (MakeMessageText 0 0 53 1 14))
			(= temp1 (oClient getName:))
			(= temp2 (Str format: temp0 temp1))
			(proc64896_7 temp0)
			(proc64896_7 temp1)
			(if
				(not
					(= temp3
						(proc64033_6
							temp2
							(MakeMessageText 0 0 17 1 14)
							(MakeMessageText 0 0 18 1 14)
							20
						)
					)
				)
				(return -1)
			)
			(temp3 lower:)
			(if (oClient handleTopic: temp3)
				(return (proc64896_7 temp3))
			)
			(for ((= temp6 0)) (< temp6 local0) ((++ temp6))
				(= temp7 (Str with: (local1 at: temp6)))
				(temp7 lower:)
				(if (< (= temp5 (temp7 size:)) (temp3 size:))
					(= temp4 (temp3 left: temp5))
				else
					(= temp4 (Str with: temp3))
				)
				(if (== (temp7 weigh: temp4) 0)
					(PrintDebug {Hit on '%s'} temp7)
					(proc64896_7 temp4)
					(proc64896_7 temp7)
					(= param1 (local2 at: temp6))
					(break)
				)
				(proc64896_7 temp4)
				(proc64896_7 temp7)
			)
			(proc64896_7 temp3)
			(if (and (== param1 112) (< global327 3) (!= gCurRoomNum 432)) ; ro432
				(++ global327)
				(DisplayMsgSequence 0 0 74 14)
				(continue)
			)
			(break)
		)
		(if (== param1 112)
			(= param1 70)
		)
		(if (!= param1 70)
			(self addTopic: (- 0 param1))
		)
		(return
			(CueObj
				state: 0
				cycles: 0
				client: oClient
				theVerb: param1
				changeState: 3
			)
		)
	)

	(method (dispose)
		(if oPlane
			(oPlane dispose:)
			(= oPlane 0)
		)
		(= local3 (= oClient (= oTopics 0)))
		(super dispose: &rest)
	)
)

