;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 96)
(include sci.sh)
(use Main)
(use RamaRoom)
(use Button)
(use VMDMovie)
(use Plane)
(use Motion)
(use Actor)
(use System)

(public
	arthurQuestions 0
)

(local
	local0 = 4
	local1 = 4
	local2 = 13
	[local3 2] = [0 13]
	[local5 37] = [15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15 15]
	[local42 37] = [63031 63012 63014 63021 63022 63023 63081 63082 63083 63071 63072 63073 63111 63112 63113 63121 63122 63123 63141 63142 63143 63151 63152 63153 63131 63132 63133 63051 63052 63053 63061 63063 63064 63041 63042 63043 63161]
	[local79 8] = [57 311 188 309 305 302 435 309]
	[local87 26] = [128 108 128 109 128 109 128 103 128 92 128 95 128 96 128 89 128 94 128 95 128 99 128 93 128 137]
	[local113 24] = [128 146 128 147 128 147 128 144 128 142 128 149 128 150 128 149 128 150 128 150 128 155 128 146]
	[local137 24] = [128 201 128 188 128 188 128 203 128 211 128 207 128 206 128 212 128 209 128 206 128 208 128 219]
	local161
	local162
	local163
	local164
	local165
	local166
	local167
	local168
	local169
	local170 = 4
	local171 = 13
	local172 = -1
)

(procedure (localproc_0 param1)
	(switch local170
		(0
			(cond
				((InRect 50 311 194 330 param1)
					(return 0)
				)
				((InRect 50 342 194 367 param1)
					(return 1)
				)
				((InRect 50 376 194 420 param1)
					(return 2)
				)
				(else
					(return -1)
				)
			)
		)
		(1
			(cond
				((InRect 196 308 320 334 param1)
					(return 3)
				)
				((InRect 196 350 325 377 param1)
					(return 4)
				)
				((InRect 196 399 325 422 param1)
					(return 5)
				)
				(else
					(return -1)
				)
			)
		)
		(2
			(cond
				((InRect 324 309 453 330 param1)
					(return 6)
				)
				((InRect 324 350 453 370 param1)
					(return 7)
				)
				((InRect 308 380 461 410 param1)
					(return 8)
				)
				(else
					(return -1)
				)
			)
		)
		(3
			(cond
				((InRect 436 310 581 344 param1)
					(return 9)
				)
				((InRect 444 362 571 382 param1)
					(return 10)
				)
				((InRect 460 398 546 422 param1)
					(return 11)
				)
				(else
					(return -1)
				)
			)
		)
		(else
			(return -1)
		)
	)
)

(instance arthurQuestions of RamaRoom
	(properties
		picture 95
	)

	(method (init)
		(= local164 ((ScriptID 0 2) view:)) ; ramanWaitCursor
		(= local165 ((ScriptID 0 2) loop:)) ; ramanWaitCursor
		(= local166 ((ScriptID 0 2) cel:)) ; ramanWaitCursor
		(= local167 ((ScriptID 0 3) view:)) ; ramanFingerCursor
		(= local168 ((ScriptID 0 3) loop:)) ; ramanFingerCursor
		(= local169 ((ScriptID 0 3) cel:)) ; ramanFingerCursor
		(= local161 ((ScriptID 0 1) view:)) ; ramanNormalCursor
		(= local162 ((ScriptID 0 1) loop:)) ; ramanNormalCursor
		(= local163 ((ScriptID 0 1) cel:)) ; ramanNormalCursor
		((ScriptID 0 2) view: 98 setLoop: 0 setCel: 1) ; ramanWaitCursor
		((ScriptID 0 1) view: 98 setLoop: 0 setCel: 0) ; ramanNormalCursor
		((ScriptID 0 3) view: 98 setLoop: 0 setCel: 2) ; ramanFingerCursor
		((= plane (Plane new:))
			init: 0 0 640 480
			priority: 255
			addCast: vidButnCast
		)
		(super init: &rest)
		(gCast add: vidButnCast)
		(myNormalCursor init:)
		(gTheCursor setNormalCursor: myNormalCursor)
		(boxList add: arthurBox scifiBox predictBox spaceBox)
		(boxList eachElementDo: #init vidButnCast)
		(viewList add: videoTopic quesBox1 quesBox2 quesBox3 videoQues exitButn)
		(viewList eachElementDo: #init vidButnCast)
		(= local170 4)
		(= local171 13)
		(= local172 -1)
		(= local1 0)
		(= local0 0)
	)

	(method (dispose)
		((ScriptID 0 2) view: local164 setLoop: local165 setCel: local166) ; ramanWaitCursor
		((ScriptID 0 3) view: local167 setLoop: local168 setCel: local169) ; ramanFingerCursor
		((ScriptID 0 1) view: local161 setLoop: local162 setCel: local163) ; ramanNormalCursor
		(gCast delete: vidButnCast)
		(super dispose: &rest)
	)
)

(instance viewList of List
	(properties)
)

(instance boxList of List
	(properties)
)

(instance vidButnCast of Cast
	(properties)
)

(instance arthurBox of Prop
	(properties
		x 57
		y 311
		view 95
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(self setHotspot: 2)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (and (!= local170 0) (not (gCurRoom script:)))
					(= local1 self)
					(= local170 0)
					(gCurRoom setScript: sOpenBox)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance predictBox of Prop
	(properties
		x 435
		y 309
		loop 1
		view 95
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(self setHotspot: 2)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (and (!= local170 3) (not (gCurRoom script:)))
					(= local1 self)
					(= local170 3)
					(gCurRoom setScript: sOpenBox)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance scifiBox of Prop
	(properties
		x 188
		y 309
		view 101
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(self setHotspot: 2)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (and (!= local170 1) (not (gCurRoom script:)))
					(= local1 self)
					(= local170 1)
					(gCurRoom setScript: sOpenBox)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance spaceBox of Prop
	(properties
		x 305
		y 302
		loop 1
		view 101
	)

	(method (init)
		(super init: &rest)
		(self setCel: 0)
		(self setHotspot: 2)
	)

	(method (dispose)
		(self deleteHotspot:)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (and (!= local170 2) (not (gCurRoom script:)))
					(= local1 self)
					(= local170 2)
					(gCurRoom setScript: sOpenBox)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance videoTopic of View
	(properties
		loop 2
		view 96
	)

	(method (init)
		(super init: &rest)
		(self setLoop: 2 setCel: 0)
		(if plane
			(plane addExtMH: self)
		else
			(gExtMouseHandler add: self)
			(gMouseDownHandler add: self)
		)
		(self hide:)
	)

	(method (dispose)
		(if plane
			(plane deleteExtMH: self)
		else
			(gExtMouseHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(if (or (== loop 4) (event claimed:))
			(return)
		)
		(cond
			(
				(and
					(not (event type:))
					(self onMe: event)
					(!= (= temp0 (localproc_0 event)) -1)
				)
				(self doVerb: 1)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
					(!= (= temp0 (localproc_0 event)) -1)
				)
				(event claimed: 1)
				(= local2 temp0)
				(self doVerb: 2)
			)
			(else
				(super handleEvent: event &rest)
			)
		)
	)

	(method (doVerb theVerb &tmp [temp0 2])
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(if (and (!= local2 -1) (!= loop 4))
					(self setLoop: 0 setCel: local2)
					(= local171 local2)
					(= local2 13)
					(videoQues setLoop: local171)
					(quesBox1
						x: [local87 (* local171 2)]
						y: [local87 (+ (* local171 2) 1)]
						setActive: 1
					)
					(quesBox2
						x: [local113 (* local171 2)]
						y: [local113 (+ (* local171 2) 1)]
						setActive: 1
					)
					(quesBox3
						x: [local137 (* local171 2)]
						y: [local137 (+ (* local171 2) 1)]
						setActive: 1
					)
					(UpdateScreenItem self)
					(UpdateScreenItem videoQues)
					(UpdateScreenItem quesBox1)
					(UpdateScreenItem quesBox2)
					(UpdateScreenItem quesBox3)
					(FrameOut)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance videoQues of View
	(properties
		x 136
		y 78
		loop 13
		view 97
	)

	(method (init)
		(= priority 50)
		(super init: &rest)
	)
)

(class QuesButton of Button
	(properties
		myNumber 0
	)

	(method (cue)
		(self setActive: 1)
		(gGame handsOn:)
	)

	(method (trace param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7 temp8)
		(= temp1 0)
		(= temp7 0)
		(= temp6 (= temp8 0))
		(while 1
			(if (or (not active) (== local171 13))
				(break)
			)
			(= temp5 temp1)
			(= gGameTime (+ gTickOffset (GetTime)))
			(param1 type: 0 message: 0 modifiers: 0 y: 0 x: 0 plane: 0)
			(GetEvent 3 param1)
			(param1 localize: plane)
			(if (& (param1 type:) $0002)
				(break)
			else
				(= temp2 view)
				(= temp3 loop)
				(= temp4 cel)
				(if (self onMe: param1)
					(self view: downView loop: downLoop cel: downCel)
					(= temp1 1)
					(if
						(and
							doVerbCalled
							(or
								(not temp8)
								(and
									(< temp6 60)
									(= temp6 (Abs (- temp8 gGameTime)))
									0
								)
								(and (>= temp6 60) (<= (-- temp7) 0))
							)
						)
						(= temp8 gGameTime)
						(= temp7 20)
						(self doVerb: 2)
					)
				else
					(self view: upView loop: upLoop cel: upCel)
					(= temp1 0)
				)
			)
			(if (or (!= temp2 view) (!= temp3 loop) (!= temp4 cel))
				(UpdateScreenItem self)
				(FrameOut)
			)
			(if (!= temp5 temp1)
				(= temp5 temp1)
			)
		)
		(if (and active (not temp1))
			(self view: upView loop: upLoop cel: upCel)
			(UpdateScreenItem self)
			(FrameOut)
		)
		(if (and temp1 (not doVerbCalled))
			(self doVerb: 2)
		)
		(param1 claimed: 1)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if (and active (!= local171 13))
					(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
				)
			)
			(2
				(if (and active (!= local171 13))
					(self setActive: 0)
					(= local172 (+ (* local171 3) myNumber))
					(quesMovie
						movieName: [local42 local172]
						boostRGB: [local5 local172]
						play: self
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance quesBox1 of QuesButton
	(properties
		x 128
		y 89
		view 97
	)

	(method (init)
		(self
			setLoop: 14
			setCel: 0
			upLoop: 14
			downLoop: 14
			priority: 200
			fixPriority: 1
		)
		(super init: &rest)
		(self setHotspot: 2)
	)
)

(instance quesBox2 of QuesButton
	(properties
		x 128
		y 144
		view 97
		myNumber 1
	)

	(method (init)
		(self setLoop: 14 setCel: 0 upLoop: 14 downLoop: 14)
		(super init: &rest)
		(self setHotspot: 2)
	)
)

(instance quesBox3 of QuesButton
	(properties
		x 128
		y 204
		view 97
		myNumber 2
	)

	(method (init)
		(self setLoop: 14 setCel: 0 upLoop: 14 downLoop: 14)
		(super init: &rest)
		(self setHotspot: 2)
		(|= signal $4000)
		(self priority: 256)
	)
)

(instance exitButn of Button
	(properties
		y 430
		loop 3
		view 95
		upLoop 3
		downLoop 3
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if active
					(self setActive: 0 deleteHotspot:)
					(gCurRoom setScript: sTheEnd)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance sTheEnd of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(arthurBox deleteHotspot:)
				(scifiBox deleteHotspot:)
				(spaceBox deleteHotspot:)
				(predictBox deleteHotspot:)
				(if local0
					(local0 show: setCycle: Beg self)
					(if (!= local171 13)
						(videoQues setLoop: 13)
						(= local172 13)
					)
					(videoTopic hide:)
					(= local171 13)
				else
					(= cycles 3)
				)
			)
			(1
				(videoQues setLoop: 12)
				(= local171 12)
				(quesBox1
					x: [local87 (* 12 2)]
					y: [local87 (+ (* local171 2) 1)]
					setActive: 1
				)
				(UpdateScreenItem videoQues)
				(= seconds 3)
			)
			(2
				(= local172 36)
				(quesBox1 setActive: 0)
				(quesMovie
					movieName: [local42 local172]
					boostRGB: [local5 local172]
					play: self
				)
			)
			(3
				(quesBox1 setActive: 1)
				(= seconds 1)
			)
			(4
				(videoQues setLoop: 13)
				(= cycles 90)
			)
			(5
				(gCurRoom newRoom: 89) ; videoMenu
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sOpenBox of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 1)
			)
			(1
				(if local0
					(local0 show: setCycle: Beg)
					(if (!= local171 13)
						(videoQues setLoop: 13)
						(= local172 13)
					)
					(videoTopic hide:)
					(= local171 13)
				)
				(local1 setCycle: End self)
			)
			(2
				(= local0 local1)
				(= local1 0)
				(videoTopic
					posn:
						[local79 (* local170 2)]
						[local79 (+ (* local170 2) 1)]
					setLoop: 1
					setCel: local170
					setPri: 400
					show:
				)
				(FrameOut)
				(= cycles 2)
			)
			(3
				(gGame handsOn:)
				(local0 hide:)
				(self dispose:)
			)
		)
	)
)

(instance quesMovie of VMDMovie
	(properties
		x 176
		y 80
	)

	(method (play)
		(self stretch: 1 blackLines: 1)
		(super play: &rest)
	)
)

(instance myNormalCursor of View
	(properties
		view 98
	)
)

