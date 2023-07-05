;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use Str)
(use Array)
(use Inset)
(use Polygon)
(use Feature)
(use Cursor)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	foodReplicatorInset 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
	local19
)

(instance foodReplicatorInset of Inset
	(properties
		picture 800
		y 0
		disposeNotOnMe 1
		modNum 800
		noun 1
	)

	(method (init &tmp temp0)
		(PalCycle 2) ; Pause
		(= local18 0)
		(super init: &rest)
		(if (== gCurRoomNum 390)
			(self noun: 28)
			(Load 140 393) ; WAVE
			(rogerReplicator init:)
			(bullethole init:)
			(= temp0 (proc0_8 1 9))
			((= local0 (aBug new:)) init:)
			((= local1 (aBug new:)) init:)
			((= local2 (aBug new:)) init:)
			(if (> temp0 3)
				((= local3 (aBug new:)) init:)
			)
			(if (> temp0 4)
				((= local4 (aBug new:)) init:)
			)
			(if (> temp0 5)
				((= local5 (aBug new:)) init:)
			)
			(if (> temp0 6)
				((= local6 (aBug new:)) init:)
			)
			(if (> temp0 7)
				((= local7 (aBug new:)) init:)
			)
			(if (> temp0 8)
				((= local8 (aBug new:)) init:)
			)
		else
			(self noun: 1)
			((= local0 (buttonView new:))
				setLoop: 0
				setCel: 0
				init:
				posn: 151 123
				noun: 2
			)
			((= local1 (buttonView new:))
				setLoop: 1
				setCel: 0
				init:
				posn: 140 111
				noun: 3
			)
			((= local2 (buttonView new:))
				setLoop: 2
				setCel: 0
				init:
				posn: 151 111
				noun: 4
			)
			((= local3 (buttonView new:))
				setLoop: 3
				setCel: 0
				init:
				posn: 163 111
				noun: 5
			)
			((= local4 (buttonView new:))
				setLoop: 4
				setCel: 0
				init:
				posn: 140 115
				noun: 6
			)
			((= local5 (buttonView new:))
				setLoop: 5
				setCel: 0
				init:
				posn: 151 115
				noun: 7
			)
			((= local6 (buttonView new:))
				setLoop: 6
				setCel: 0
				init:
				posn: 163 115
				noun: 8
			)
			((= local7 (buttonView new:))
				setLoop: 7
				setCel: 0
				init:
				posn: 139 119
				noun: 9
			)
			((= local8 (buttonView new:))
				setLoop: 8
				setCel: 0
				init:
				posn: 151 119
				noun: 10
			)
			((= local9 (buttonView new:))
				setLoop: 9
				setCel: 0
				init:
				posn: 163 119
				noun: 11
			)
			((= local12 (buttonView new:))
				setLoop: 10
				setCel: 0
				init:
				posn: 139 123
				noun: 26
			)
			((= local13 (buttonView new:))
				setLoop: 13
				setCel: 0
				init:
				posn: 174 115
				noun: 13
			)
			((= local14 (buttonView new:))
				setLoop: 12
				setCel: 0
				init:
				posn: 174 111
				noun: 33
			)
			((= local11 (buttonView new:))
				setLoop: 11
				setCel: 0
				init:
				posn: 163 123
				noun: 14
			)
			((= local10 (buttonView new:))
				setLoop: 14
				setCel: 0
				init:
				posn: 175 119
				noun: 12
			)
			(door init:)
			(titleScreen init:)
			(blackPanel init:)
			(= local16 (Str new:))
			(= local15 (Str with: {7469410}))
			(= local17 (IntArray new:))
		)
		(light init:)
		(leftVents init:)
		(rightVents init:)
		(access1 init:)
		(access2 init:)
		(access3 init:)
		(access4 init:)
		(screen init:)
		(pipeL init:)
		(pipeR init:)
		(gTheIconBar setupExit: 1)
		(gGame handsOn:)
	)

	(method (dispose)
		(gGame handsOff:)
		(if local19
			(gGSound1 play:)
		)
		(gGSound2 stop:)
		(gTheIconBar setupExit: 0)
		(if (!= gCurRoomNum 390)
			(local15 dispose:)
			(local16 dispose:)
			(local17 dispose:)
		)
		(super dispose: &rest)
		(PalCycle 3) ; Go
		(gGame handsOn:)
	)

	(method (onMe param1 param2 &tmp temp0 temp1)
		(if (== argc 1)
			(param1 localize: plane)
			(= temp0 (param1 x:))
			(= temp1 (param1 y:))
		else
			(= temp0 param1)
			(= temp1 param2)
		)
		(return (and (<= 84 temp0 229) (<= 0 temp1 138)))
	)

	(method (doit)
		(if (not ((gTheIconBar plane:) onMe: (gUser curEvent:)))
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
		(super doit: &rest)
	)
)

(instance playDitty of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not local19)
					(= local19 1)
					(gGSound1 stop:)
				)
				(gGSound2 number: 435 setLoop: 0 play: self setVol: 127)
			)
			(1
				(gGSound1 play:)
				(= local19 0)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(gGSound2 stop:)
		(if local19
			(= local19 0)
			(gGSound1 play:)
		)
		(super dispose: &rest)
	)
)

(instance aBug of Actor
	(properties
		noun 31
		modNum 800
		view 802
		loop 3
		yStep 1
		signal 18433
		xStep 1
	)

	(method (doit)
		(cond
			((== loop 6))
			((and (> y 90) (< y 100) (not scratch))
				(self setLoop: 5 scratch: 1)
			)
			((and (< 100 y 105) (or (not (== loop 1)) (not (== loop 2))))
				(self setLoop: (if (< x 160) 1 else 2))
			)
			((and (< 105 y 128) (or (not (== loop 3)) (not (== loop 4))))
				(self setLoop: (if (< x 160) 3 else 4) setStep: 2 2 scratch: 0)
			)
			((and (< 128 y 135) (not (== loop 5)))
				(self setLoop: 5 scratch: 999)
			)
			((and (> y 135) (self isNotHidden:))
				(self hide:)
			)
		)
		(super doit:)
	)

	(method (init)
		(self x: (proc0_8 100 220) y: (proc0_8 96 110))
		(super init:)
		(self
			moveSpeed: (proc0_8 3 6)
			cycleSpeed: 1
			setLoop: (if (< x 160) 1 else 2)
			setCycle: Fwd
			setMotion:
				MoveTo
				(if (< x 160)
					(- x (proc0_8 5 20))
				else
					(+ x (proc0_8 5 20))
				)
				150
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not case)
					(gGSound2 number: 393 loop: 0 play: setVol: 127)
					(self setMotion: 0 setCycle: 0 setCel: 0 setLoop: 6 case: 4)
					(return 1)
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

(instance door of Prop
	(properties
		noun 30
		modNum 800
		x 127
		y 64
		priority 100
		fixPriority 1
		view 803
		cel 1
		signal 16385
	)
)

(instance buttonView of View
	(properties
		modNum 800
		view 800
	)

	(method (doit)
		(if scratch
			(if (< (Abs (- gGameTime scratch)) 25)
				0
			else
				(self setCel: 0 scratch: 0)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= scratch gGameTime)
				(if (== noun 12)
					(theBeep number: 916 play:)
				else
					(theBeep number: 921 play:)
				)
				(self setCel: 1)
				(buttonCode doit: self)
				(return 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rogerReplicator of View
	(properties
		noun 28
		modNum 800
		x 113
		y 75
		view 802
	)
)

(instance titleScreen of View
	(properties
		noun 23
		modNum 800
		x 131
		y 25
		view 800
		loop 15
	)
)

(instance bg of View ; UNUSED
	(properties
		x 127
		y 65
		priority 65
		fixPriority 1
		view 803
		loop 1
		signal 16385
	)
)

(instance sparkle of Prop ; UNUSED
	(properties
		x 135
		y 70
		priority 70
		fixPriority 1
		view 803
		loop 2
		signal 16385
	)
)

(instance light of Feature
	(properties
		modNum 800
		sightAngle 40
		x 92
		y 6
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 87 5 111 10 202 10 226 5 224 4 92 4
					yourself:
				)
		)
		(super init:)
	)
)

(instance leftVents of Feature
	(properties
		noun 16
		modNum 800
		sightAngle 40
		x 98
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 97 10 102 12 102 101 97 103
					yourself:
				)
		)
		(super init:)
	)
)

(instance rightVents of Feature
	(properties
		noun 17
		modNum 800
		sightAngle 40
		x 213
		y 70
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 11 217 12 217 103 214 101
					yourself:
				)
		)
		(super init:)
	)
)

(instance access1 of Feature
	(properties
		noun 18
		modNum 800
		sightAngle 40
		x 113
		y 117
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 94 110 86 123 88 125 108 126 113 110
					yourself:
				)
		)
		(super init:)
	)
)

(instance access2 of Feature
	(properties
		noun 19
		modNum 800
		sightAngle 40
		x 129
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 117 109 115 114 129 114 130 110
					yourself:
				)
		)
		(super init:)
	)
)

(instance access3 of Feature
	(properties
		noun 20
		modNum 800
		sightAngle 40
		x 128
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 115 117 112 125 128 125 129 117
					yourself:
				)
		)
		(super init:)
	)
)

(instance access4 of Feature
	(properties
		noun 21
		modNum 800
		sightAngle 40
		x 220
		y 120
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 206 110 210 125 224 125 228 123 220 110
					yourself:
				)
		)
		(super init:)
	)
)

(instance blackPanel of Feature
	(properties
		noun 22
		modNum 800
		sightAngle 40
		x 201
		y 111
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 133 110 131 126 205 125 201 109
					yourself:
				)
		)
		(super init:)
	)
)

(instance screen of Feature
	(properties
		noun 23
		modNum 800
		sightAngle 40
		x 185
		y 38
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 129 20 123 26 124 49 128 53 185 54 190 49 190 24 185 21
					yourself:
				)
		)
		(gMouseDownHandler addToFront: self)
		(super init:)
	)

	(method (handleEvent event)
		(if
			(or
				(and
					(& (event type:) evMOUSEBUTTON)
					(not (self onMe: event))
					(gCurRoom script:)
					(== (gCurRoom script:) playDitty)
				)
				(and
					(& (event type:) evVERB)
					(self onMe: event)
					(!= (event message:) JOY_DOWNRIGHT)
					(gCurRoom script:)
					(== (gCurRoom script:) playDitty)
				)
			)
			(gCurRoom setScript: 0)
		)
		(super handleEvent: event &rest)
	)

	(method (doVerb theVerb)
		(if (and (!= gCurRoomNum 390) (== theVerb 4)) ; Do
			(gCurRoom setScript: playDitty)
		else
			(super doVerb: theVerb &rest)
		)
	)

	(method (dispose)
		(if (gMouseDownHandler contains: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose: &rest)
	)
)

(instance pipeL of Feature
	(properties
		noun 24
		modNum 800
		sightAngle 40
		x 111
		y 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 103 9 103 105 112 104 111 10
					yourself:
				)
		)
		(super init:)
	)
)

(instance pipeR of Feature
	(properties
		noun 25
		modNum 800
		sightAngle 40
		x 212
		y 71
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 203 10 203 103 212 105 212 8
					yourself:
				)
		)
		(super init:)
	)
)

(instance bullethole of Feature
	(properties
		noun 32
		modNum 800
		sightAngle 40
		x 160
		y 1000
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 160 85 156 85 157 90 160 90
					yourself:
				)
		)
		(super init:)
	)
)

(instance theExitCursor of Cursor ; UNUSED
	(properties
		view 954
		loop 4
	)
)

(instance inCursor of Cursor ; UNUSED
	(properties)
)

(instance theBeep of Sound
	(properties
		number 800
	)
)

(instance buttonCode of Code
	(properties)

	(method (doit param1)
		(switch param1
			(local0
				(if (< local18 7)
					(addANumber doit: 0)
				)
			)
			(local1
				(if (< local18 7)
					(addANumber doit: 1)
				)
			)
			(local2
				(if (< local18 7)
					(addANumber doit: 2)
				)
			)
			(local3
				(if (< local18 7)
					(addANumber doit: 3)
				)
			)
			(local4
				(if (< local18 7)
					(addANumber doit: 4)
				)
			)
			(local5
				(if (< local18 7)
					(addANumber doit: 5)
				)
			)
			(local6
				(if (< local18 7)
					(addANumber doit: 6)
				)
			)
			(local7
				(if (< local18 7)
					(addANumber doit: 7)
				)
			)
			(local8
				(if (< local18 7)
					(addANumber doit: 8)
				)
			)
			(local9
				(if (< local18 7)
					(addANumber doit: 9)
				)
			)
			(local10
				(if (local16 compare: local15)
					(if (not (IsFlag 144))
						(SetFlag 144)
						(gMessager say: 1 4 2 0 0 800) ; "Hmmm...something tells me you're thinking of the demo."
					else
						(gMessager say: 1 4 1 0 0 800) ; "Didn't your mother ever tell you to finish what you've got on your plate before taking more?"
					)
				)
			)
			(local11)
			(local12)
			(local13
				(if (> local18 0)
					((local17 at: (- local18 1)) dispose:)
					(-- local18)
					(local16 at: local18 0)
					(if (and (not (titleScreen isNotHidden:)) (== local18 0))
						(titleScreen show:)
					)
				)
			)
			(local14
				(for ((= local18 local18)) (> local18 0) ((-- local18))
					(local16 at: (- local18 1) 0)
					((local17 at: (- local18 1)) dispose:)
				)
				(titleScreen show:)
			)
		)
	)
)

(instance addANumber of Code
	(properties)

	(method (doit param1 &tmp temp0)
		(if (titleScreen isNotHidden:)
			(titleScreen hide:)
		)
		(++ local18)
		(= temp0 (Str format: {%d} param1))
		(local16 cat: temp0)
		(temp0 dispose:)
		(local17
			at:
				(- local18 1)
				((View new:)
					view: 801
					setCel: param1
					init:
					posn: (+ (* (- local18 1) 8) 131) 35
					yourself:
				)
		)
	)
)

