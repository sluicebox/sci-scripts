;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 7016)
(include sci.sh)
(use Main)
(use Location)
(use SaveManager)
(use newYorkRegion)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	octoAbacusCU 0
)

(local
	local0
	local1
	local2
	local3
	local4
)

(procedure (localproc_0 param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6 temp7)
	(= temp5 (/ (= temp3 param1) 8))
	(= temp4 (mod temp3 8))
	(= temp6 local0)
	(= temp7 local1)
	(if (not (lightList isEmpty:))
		(localproc_1)
	)
	(for ((= temp2 1)) (<= temp2 temp5) ((++ temp2))
		(lightList add: ((light new:) cel: 2 x: temp6 y: temp7 yourself:))
		(+= temp6 local2)
	)
	(= temp0 (+ local0 (* temp5 local2)))
	(= temp1 local1)
	(if (>= temp5 4)
		(-= temp0 local2)
		(+= temp1 (* 8 local3))
	)
	(for ((= temp2 1)) (<= temp2 temp4) ((++ temp2))
		(lightList add: ((light new:) cel: 1 x: temp0 y: temp1 yourself:))
		(if (>= temp5 4)
			(-= temp0 local2)
		else
			(+= temp1 local3)
		)
	)
	(if (not (lightList isEmpty:))
		(lightList eachElementDo: #init global117)
		(FrameOut)
	)
)

(procedure (localproc_1)
	(lightList eachElementDo: #hide)
	(lightList release: dispose:)
)

(procedure (localproc_2)
	(spikes cel: (if (== global260 global259) 4 else 5))
	(innerWheel cel: (/ global260 8))
	(outerWheel cel: (mod global260 8))
)

(procedure (localproc_3)
	(innerWheel cel: 8)
	(outerWheel cel: 8)
)

(procedure (localproc_4 param1 &tmp temp0)
	(cond
		((== gPrevRoomNum 7108) ; octoEenie9
			(cond
				((InRect 216 53 249 144 param1)
					(= temp0 0)
				)
				((InRect 258 53 290 144 param1)
					(= temp0 1)
				)
				((InRect 299 53 332 144 param1)
					(= temp0 2)
				)
				((InRect 340 53 376 144 param1)
					(= temp0 3)
				)
				(else
					(return -1)
				)
			)
		)
		((InRect 213 54 248 141 param1)
			(= temp0 0)
		)
		((InRect 255 54 290 144 param1)
			(= temp0 1)
		)
		((InRect 297 54 332 144 param1)
			(= temp0 2)
		)
		((InRect 341 54 376 144 param1)
			(= temp0 3)
		)
		(else
			(return -1)
		)
	)
	(return (localproc_5 temp0 param1))
)

(procedure (localproc_5 param1 param2)
	(cond
		((== gPrevRoomNum 7108) ; octoEenie9
			(cond
				((InRect 216 54 373 62 param2)
					(return (+ (* param1 8) 1))
				)
				((InRect 216 65 373 72 param2)
					(return (+ (* param1 8) 2))
				)
				((InRect 216 76 373 85 param2)
					(return (+ (* param1 8) 3))
				)
				((InRect 216 86 373 93 param2)
					(return (+ (* param1 8) 4))
				)
				((InRect 216 98 373 104 param2)
					(return (+ (* param1 8) 5))
				)
				((InRect 216 108 373 116 param2)
					(return (+ (* param1 8) 6))
				)
				((InRect 216 119 373 126 param2)
					(return (+ (* param1 8) 7))
				)
				((InRect 216 131 373 139 param2)
					(return (+ (* param1 8) 8))
				)
				(else
					(return -1)
				)
			)
		)
		((InRect 212 55 376 63 param2)
			(return (+ (* param1 8) 1))
		)
		((InRect 212 66 376 74 param2)
			(return (+ (* param1 8) 2))
		)
		((InRect 212 77 376 85 param2)
			(return (+ (* param1 8) 3))
		)
		((InRect 212 88 376 99 param2)
			(return (+ (* param1 8) 4))
		)
		((InRect 212 102 376 106 param2)
			(return (+ (* param1 8) 5))
		)
		((InRect 212 113 376 118 param2)
			(return (+ (* param1 8) 6))
		)
		((InRect 212 124 376 130 param2)
			(return (+ (* param1 8) 7))
		)
		((InRect 212 136 376 142 param2)
			(return (+ (* param1 8) 8))
		)
		(else
			(return -1)
		)
	)
)

(instance octoAbacusCU of CloseupLocation
	(properties
		heading 0
	)

	(method (init)
		(if (== gPrevRoomNum 7108) ; octoEenie9
			(= picture 7122)
			(= local0 218)
			(= local1 54)
			(= local2 41)
			(= local3 11)
			(super init: 7122)
		else
			(= local0 214)
			(= local1 53)
			(= local2 43)
			(= local3 12)
			(= picture 7934)
			(super init: 7934)
		)
		(self edgeW: 0 edgeE: 0)
		(abButton init:)
		(ABACUS_0 init:)
		(spikes init: global117)
		(workingScreen init: global117)
		(if (== local4 0)
			(gCurRoom setScript: sInitDisplay)
		)
	)

	(method (pitch)
		(self setScript: sShowResults self)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1 0)
			(= local4 (SaveManager readWord:))
		else
			(super serialize: param1)
			(SaveManager writeWord: local4)
		)
	)

	(method (dispose)
		(= local4 0)
		(super dispose:)
	)
)

(instance abButton of Feature
	(properties
		nsLeft 273
		nsTop 240
		nsRight 318
		nsBottom 279
	)

	(method (init)
		(= plane global116)
		(super init: &rest)
		(self setHotspot: 2)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(proc201_1 17)
				(if (== local4 1)
					(= local4 2)
					(workingScreen init: global117)
				else
					(workingScreen dispose:)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance innerWheel of View
	(properties
		view 7934
	)

	(method (init)
		(if (== local4 1)
			(= cel (/ global260 8))
		else
			(= cel 8)
		)
		(if (== gPrevRoomNum 7108) ; octoEenie9
			(self x: 309 y: 123)
		else
			(self x: 311 y: 127)
		)
		(super init: &rest)
	)
)

(instance outerWheel of View
	(properties
		view 7934
		loop 1
	)

	(method (init)
		(if (== local4 1)
			(= cel (mod global260 8))
		else
			(= cel 8)
		)
		(if (== gPrevRoomNum 7108) ; octoEenie9
			(self x: 296 y: 135)
		else
			(self x: 298 y: 139)
		)
		(super init: &rest)
	)
)

(instance workingScreen of View
	(properties
		view 7100
	)

	(method (init)
		(if (>= local4 2)
			(= plane global116)
			(if (== gPrevRoomNum 7108) ; octoEenie9
				(self loop: 0 x: 193 y: 29)
			else
				(self loop: 1 x: 186 y: 27)
			)
			(spikes cel: 5)
			(localproc_3)
			(super init: &rest)
			(gExtMouseHandler addToFront: self)
			(if (== local4 3)
				(localproc_0 global260)
			)
		)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(if (event claimed:)
			(return)
		)
		(event localize: global116)
		(if
			(and
				(not (event type:))
				(self onMe: event)
				(!= (= temp1 (localproc_4 event)) -1)
			)
			(self doVerb: 1)
			(event claimed: 1)
			(return)
		)
		(if
			(and
				(& (event type:) evMOUSEBUTTON)
				(!= (= temp1 (localproc_4 event)) -1)
			)
			(event claimed: 1)
			(= global260 temp1)
			(self doVerb: 2)
		else
			(event globalize:)
			(super handleEvent: event &rest)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor: (ScriptID 0 3)) ; ramanFingerCursor
			)
			(2
				(localproc_0 global260)
				(= local4 3)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gExtMouseHandler delete: self)
		(if (or (== local4 3) (not (lightList isEmpty:)))
			(localproc_1)
		)
		(= local4 1)
		(spikes cel: (if (== global260 global259) 4 else 5))
		(localproc_2)
		(super dispose: &rest)
	)
)

(instance lightList of List
	(properties)
)

(instance light of View
	(properties
		view 7100
	)

	(method (init)
		(if (== gPrevRoomNum 7108) ; octoEenie9
			(self loop: 0)
		else
			(self loop: 1)
		)
		(super init: &rest)
	)
)

(instance spikes of View
	(properties
		view 7100
		cel 3
	)

	(method (init)
		(if (== gPrevRoomNum 7108) ; octoEenie9
			(self loop: 0 x: 207 y: 53)
		else
			(self loop: 1 x: 205 y: 56)
		)
		(switch local4
			(0
				(= cel 3)
			)
			(1
				(= cel (if (== global260 global259) 4 else 5))
			)
			(else
				(= cel 5)
			)
		)
		(super init: global117 &rest)
		(innerWheel init: global117)
		(outerWheel init: global117)
	)
)

(instance sInitDisplay of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 2)
			)
			(1
				(localproc_2)
				(abDisplaySnd play:)
				(= local4 1)
				(= cycles 1)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sShowResults of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (>= local4 2)
					(workingScreen dispose:)
					(-= state 1)
					(= seconds 3)
				else
					(localproc_3)
					(spikes cel: 3)
					(abDisplaySnd play:)
					(UpdateScreenItem spikes)
					(= seconds 2)
				)
			)
			(2
				(gGame handsOn:)
				(gCurRoom newRoom: gPrevRoomNum)
				(self dispose:)
			)
		)
	)
)

(instance ABACUS_0 of Feature
	(properties
		noun 30
		nsLeft 178
		nsTop 15
		nsRight 419
		nsBottom 286
	)

	(method (init)
		(super init: &rest)
		(self setHotspot: 144)
	)
)

(instance abDisplaySnd of Sound
	(properties
		flags 5
		number 7926
	)
)

